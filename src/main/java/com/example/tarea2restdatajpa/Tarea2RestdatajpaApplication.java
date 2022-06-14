package com.example.tarea2restdatajpa;

import com.example.tarea2restdatajpa.entities.Laptop;
import com.example.tarea2restdatajpa.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Tarea2RestdatajpaApplication {

  public static void main(String[] args) {

    ApplicationContext context = SpringApplication.run(Tarea2RestdatajpaApplication.class, args);

    LaptopRepository laptopRepository = context.getBean(LaptopRepository.class);

    // Creamos laptops
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

    // Guardamos los laptops
    laptopRepository.save(laptop);
    laptopRepository.save(laptop2);

  }

}
