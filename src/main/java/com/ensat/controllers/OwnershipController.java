package com.ensat.controllers;


import com.ensat.entities.OwnershipEntity;
import com.ensat.services.OwnerService;
import com.ensat.services.OwnershipService;

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
public class OwnershipController {

    private OwnershipService ownershipService;
    private OwnerService ownerService;
    
    
    @Autowired
    public void setOwnershipService(OwnershipService ownershipService,OwnerService ownerService) {
        this.ownershipService = ownershipService;
        this.ownerService = ownerService;
        
    }
    
	/**
     * List all products.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/propiedades", method = RequestMethod.GET)
    public String list(Model model) {

        model.addAttribute("propiedades", ownershipService.listAllOwner());
        System.out.println("Returning propiedades:");
        return "ownership/propiedades";
    }

    /**
     * View a specific product by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("propiedad/{id}")
    public String showOwner(@PathVariable Integer id, Model model) {
        model.addAttribute("propiedad", ownershipService.getOwnerById(id));
        return "ownership/propiedadshow";
    }

    // Afficher le formulaire de modification du Product
    @RequestMapping("propiedad/editar/{id}")
    public String editOwner(@PathVariable Integer id, Model model) {
        model.addAttribute("propietarios", ownerService.listAllOwner());
        model.addAttribute("propiedad", ownershipService.getOwnerById(id));
        return "ownership/propiedadform";
    }

    /**
     * New product.
     *
     * @param model
     * @return
     */
    @RequestMapping("propiedad/nuevo")
    public String newOwner(Model model) {
        model.addAttribute("propietarios", ownerService.listAllOwner());
        model.addAttribute("propiedad", new OwnershipEntity());
        return "ownership/propiedadnuevo";
    }

    /**
     * Save product to database.
     *
     * @param product
     * @return
     */
    @RequestMapping(value = "propiedad", method = RequestMethod.POST)
    public String saveOwner(OwnershipEntity ownershipEntity) {
    	ownershipService.saveOwner(ownershipEntity);
        return "redirect:/propiedad/" + ownershipEntity.getId();
    }

    /**
     * Delete product by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("propiedad/eliminar/{id}")
    public String deleteOwner(@PathVariable Integer id) {
    	ownershipService.deleteOwner(id);
        return "redirect:/propiedades/";
    }

}
