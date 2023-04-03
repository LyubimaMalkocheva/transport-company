package com.example.demo.vehicle;

import com.example.demo.customer.Customer;
import com.example.demo.customer.CustomerRepository;
import com.example.demo.transportcompany.TransportCompany;
import com.example.demo.transportcompany.TransportCompanyRepository;
import com.example.demo.transportorder.TransportOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

//    @Autowired
//    public VehicleService(VehicleRepository vehicleRepository) {
//        this.vehicleRepository = vehicleRepository;
//    }

    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleById(Integer id){
        Vehicle vehicle = vehicleRepository.findAll().stream().filter(t -> id.equals(t.getId()))
                .findFirst()
                .orElse(null);
        return vehicle;
    }

    public Vehicle createVehicle(Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }

    public Vehicle updateVehicle(Vehicle vehicle){
        return  vehicleRepository.save(vehicle);
    }

    public void deleteVehicleById(Integer id){
        vehicleRepository.deleteById(id);
    }

}
