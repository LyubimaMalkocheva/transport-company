package com.example.demo.vehicle;

import com.example.demo.customer.Customer;
import com.example.demo.customer.CustomerRepository;
import com.example.demo.customer.CustomerService;
import com.example.demo.transportcompany.TransportCompany;
import com.example.demo.transportcompany.TransportCompanyService;
import com.example.demo.transportorder.TransportOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/vehicle")
public class VhicleController {
    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleRepository vehicleRepository;

//    @Autowired
//    public VhicleController(VehicleService vehicleService) {
//        this.vehicleService = vehicleService;
//    }

    @GetMapping("/getAllVehicles")
    public List<Vehicle> getVehicles(){
        return vehicleService.getVehicles();
    }

    @GetMapping("/findVehicleById/{id}")
    public Vehicle getVehicleById(@PathVariable Integer id) {
        return vehicleService.getVehicleById(id);
    }

    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle){
        return vehicleService.createVehicle(vehicle);
    }

    @PutMapping("/update/{id}")
    public Vehicle updateVehicle(@PathVariable Integer id, @RequestBody Vehicle vehicle){
        vehicle.setId(id);
        return vehicleService.updateVehicle(vehicle);
    }

    @DeleteMapping("/deleteVehicleById/{id}")
    public void deleteVehicleById(@PathVariable Integer id){
        boolean exists = vehicleRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("vehicle with id " + id + " does not exists");
        }
        vehicleService.deleteVehicleById(id);
        System.out.println("Vehicle with id - " + id +" is deleted!");
    }

}