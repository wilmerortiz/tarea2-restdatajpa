package com.example.tarea2restdatajpa.service;

import com.example.tarea2restdatajpa.entities.Laptop;

public class LaptopCalcularPrecio {
  public static Double calcularPrecio(Laptop laptop) {
    Double precio = laptop.getPrecio();
    if (laptop.getRam().equals("16 GB")) {
      precio = precio + 100.0;
    }

    return precio;
  }
}
