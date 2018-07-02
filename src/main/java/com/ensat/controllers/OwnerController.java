package com.ensat.controllers;


import com.ensat.entities.OwnerEntity;
import com.ensat.services.ComunityService;
import com.ensat.services.ComunityServiceImpl;
import com.ensat.services.OwnerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Product controller.
 */
@Controller
public class OwnerController {

    private OwnerService ownerService;
    private ComunityService comunityService;
    
    @Autowired
    public void setOwnerService(OwnerService ownerService) {
        this.ownerService = ownerService;
        
    }
    
    @Autowired
	public void setComunityService(ComunityService comunityService) {
		this.comunityService = comunityService;
	}


	/**
     * List all products.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/propietarios", method = RequestMethod.GET)
    public String list(Model model) {
    	
        model.addAttribute("propietarios", ownerService.listAllOwner());
        System.out.println("Returning rpoducts:");
        return "owner/propietarios";
    }

    /**
     * View a specific product by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("propietario/{id}")
    public String showOwner(@PathVariable Integer id, Model model) {
        model.addAttribute("propietario", ownerService.getOwnerById(id));
        return "owner/propietarioshow";
    }

    // Afficher le formulaire de modification du Product
    @RequestMapping("propietario/editar/{id}")
    public String editOwner(@PathVariable Integer id, Model model) {
    	model.addAttribute("comunidades", comunityService.listAllComunyty());
        model.addAttribute("propietario", ownerService.getOwnerById(id));
        return "owner/propietarioform";
    }

    /**
     * New product.
     *
     * @param model
     * @return
     */
    @RequestMapping("propietario/nuevo")
    public String newOwner(Model model) {
    	model.addAttribute("comunidades", comunityService.listAllComunyty());
        model.addAttribute("propietario", new OwnerEntity());
        return "owner/propietarionuevo";
    }

    /**
     * Save product to database.
     *
     * @param product
     * @return
     */
    @RequestMapping(value = "propietario", method = RequestMethod.POST)
    public String saveOwner(OwnerEntity ownerEntity) {
    	ownerService.saveOwner(ownerEntity);
        return "redirect:/propietario/" + ownerEntity.getId();
    }

    /**
     * Delete product by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("propietario/eliminar/{id}")
    public String deleteOwner(@PathVariable Integer id) {
    	ownerService.deleteOwner(id);
        return "redirect:/propietarios/";
    }

}
