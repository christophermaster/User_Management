package com.ensat.controllers;

import com.ensat.entities.VehicleEntity;
import com.ensat.services.OwnerService;
import com.ensat.services.VehicleService;

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
public class VehicleController {

    private VehicleService vehicleService;
    private OwnerService ownerService;

    @Autowired
    public void setVehicleService(VehicleService vehicleService,OwnerService ownerService) {
        this.vehicleService = vehicleService;
        this.ownerService = ownerService;
    }

    /**
     * List all products.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/vehiculos", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("vehiculos", vehicleService.listAllVehicle());
        System.out.println("Returning vehiculos:");
        return "vehicle/vehiculos";
    }

    /**
     * View a specific product by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("vehiculo/{id}")
    public String showVehicle(@PathVariable Integer id, Model model) {
        model.addAttribute("vehiculo", vehicleService.getVehicleById(id));
        return "vehicle/vehiculoshow";
    }

    // Afficher le formulaire de modification du Product
    @RequestMapping("vehiculo/editar/{id}")
    public String editVehicle(@PathVariable Integer id, Model model) {
    	model.addAttribute("propietarios", ownerService.listAllOwner());
        model.addAttribute("vehiculo", vehicleService.getVehicleById(id));
        return "vehicle/vehiculoform";
    }

    /**
     * New product.
     *
     * @param model
     * @return
     */
    @RequestMapping("vehiculo/nuevo")
    public String newVehicle(Model model) {
    	model.addAttribute("propietarios", ownerService.listAllOwner());
        model.addAttribute("vehiculo", new VehicleEntity());
        return "vehicle/vehiculonuevo";
    }

    /**
     * Save product to database.
     *
     * @param product
     * @return
     */
    @RequestMapping(value = "vehiculo", method = RequestMethod.POST)
    public String saveVehicle(VehicleEntity vehicleEntity) {
    	vehicleService.saveVehicle(vehicleEntity);
        return "redirect:/vehiculo/" + vehicleEntity.getId();
    }

    /**
     * Delete product by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("vehiculo/eliminar/{id}")
    public String deleteVehicle(@PathVariable Integer id) {
    	vehicleService.deleteVehicle(id);;
        return "redirect:/vehiculos/";
    }

}
