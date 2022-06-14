package com.example.tarea2restdatajpa.service;

import com.example.tarea2restdatajpa.entities.Laptop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LaptopCalcularPrecioTest {
  @Test
  void calcularPrecio() {
    Laptop laptop = new Laptop();
    laptop.setMarca("Dell");
    laptop.setModelo("XPS 13");
    laptop.setColor("Negro");
    laptop.setRam("16 GB");
    laptop.setDiscoDuro("1TB Solido");
    laptop.setPrecio(1500.20);
    laptop.setPantalla("15.6 Pulgadas");

    Laptop laptop2 = new Laptop();
    laptop2.setMarca("HP");
    laptop2.setModelo("HP Envy");
    laptop2.setColor("Blanco");
    laptop2.setRam("8 GB");
    laptop2.setDiscoDuro("500 GB");
    laptop2.setPrecio(800.20);
    laptop2.setPantalla("15.6 Pulgadas");

    LaptopCalcularPrecio laptopCalcularPrecio = new LaptopCalcularPrecio();

    // Ejecutamos las pruebas
    Double precio = laptopCalcularPrecio.calcularPrecio(laptop);
    Double precio2 = laptopCalcularPrecio.calcularPrecio(laptop2);
    System.out.println(precio);
    System.out.println(precio2);

    // Comparamos los resultados
    assertTrue(precio > 0);
    assertEquals(1600.2, precio);

    assertTrue(precio2 > 0);
    assertEquals(800.2, precio2);
  }
}
