package com.ensat.controllers;

import com.ensat.entities.AccessHistoryEntity;
import com.ensat.entities.ComunityEntity;
import com.ensat.services.AccessHistoryService;
import com.ensat.services.ComunityService;
import com.ensat.services.OwnerService;

import antlr.Utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Product controller.
 */
@Controller
public class AccessHistoryController {

    private AccessHistoryService accessHistoryService;
    private OwnerService ownerService;

    @Autowired
	public void setAccessHistoryService(AccessHistoryService accessHistoryService,
			OwnerService ownerService) {
		this.accessHistoryService = accessHistoryService;
		this.ownerService = ownerService;
	}
   

    /**
     * List all products.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/historicos", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("historicos", accessHistoryService.listAllAccessHistory());
        System.out.println("Returning todos:");
        return "history/historicos";
    }



	/**
     * View a specific product by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("historial/{id}")
    public String showAccessHistory(@PathVariable Integer id, Model model) {
    	AccessHistoryEntity accessHistoryEntity;
    	accessHistoryEntity = accessHistoryService.getAccessHistoryById(id);
    	byte[] data = accessHistoryEntity.getPhotho();
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(data);
	        BufferedImage bImage2;
			bImage2 = ImageIO.read(bis);
			ImageIO.write(bImage2, "jpg", new File("src/main/resources/static/images/output.jpg"));
		
			accessHistoryEntity.setRuta("src/main/resources/static/images/output.jpg");
			System.out.println(accessHistoryEntity.getRuta());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
        model.addAttribute("historial",accessHistoryEntity);
        
        return "history/historialshow";
    }

    // Afficher le formulaire de modification du Product
    @RequestMapping("historial/editar/{id}")
    public String editAccessHistory(@PathVariable Integer id, Model model) {
     	model.addAttribute("propietarios", ownerService.listAllOwner());
        model.addAttribute("historial", accessHistoryService.getAccessHistoryById(id));
        return "history/historialform";
    }

    /**
     * New product.
     *
     * @param model
     * @return
     */
    @RequestMapping("historial/nuevo")
    public String newAccessHistory(Model model) {
    	
    	System.out.println("AQUIIIIIIII 1" );
     	model.addAttribute("propietarios", ownerService.listAllOwner());
        model.addAttribute("historial", new AccessHistoryEntity());
        return "history/historialnuevo";
    }

    /**
     * Save product to database.
     *
     * @param product
     * @return
     */
    @RequestMapping(value = "historial", method = RequestMethod.POST)
    public String saveAccessHistory(AccessHistoryEntity accessHistoryEntity) {

    	Optional<byte[]> binary = toBinary("/home/octavio/Imágenes/linear/linear3.jpg");
    	// la imagen se procesó sin problemas y hay datos
    	if(binary.isPresent()) {
    	    byte[] image = binary.get();
    		accessHistoryEntity.setPhotho(image);
    	}
    
    	accessHistoryService.saveAccessHistory(accessHistoryEntity);
        return "redirect:/historial/" + accessHistoryEntity.getId();
    }

    /**
     * Delete product by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("historial/eliminar/{id}")
    public String deleteAccessHistory(@PathVariable Integer id) {
    	accessHistoryService.deleteAccessHistory(id);
        return "redirect:/historicos/";
    }
    
    
    public static Optional<byte[]> toBinary(String path) {
        int len = path.split("\\.").length;
        String ext = path.split("\\.")[len - 1];
        try {
            BufferedImage img = ImageIO.read(new File(path));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(img, ext, baos);
            return Optional.of(baos.toByteArray());
        } catch(IOException e) {
            return Optional.empty();
        }
    }

    
    
    

}
