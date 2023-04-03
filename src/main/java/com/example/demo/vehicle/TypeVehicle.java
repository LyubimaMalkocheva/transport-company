package com.example.demo.vehicle;

public enum TypeVehicle {
    BUS("BUS"), TAXI("TAXI"), TRUCK("TRUCK"), DUMPTRUCK("DUMPTRUCK"), TRAIN("TRAIN"), TANKERTRUCK("TANKERTRUCK");

    private String vehicletype;

    TypeVehicle(String vtype) {
        vehicletype = vtype;
    }
     String getVehicletype(){return  vehicletype;}
}
