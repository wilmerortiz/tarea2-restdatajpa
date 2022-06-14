package com.example.tarea2restdatajpa.entities;

import javax.persistence.*;

@Entity
@Table(name = "laptops")
public class Laptop {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String marca;
  private String modelo;
  private String color;
  private String ram;
  private String discoDuro;
  private Double precio;
  private String pantalla;

  public Laptop() {
  }

  public Laptop(String marca, String modelo, String color, String ram, String discoDuro, Double precio, String pantalla) {
    this.marca = marca;
    this.modelo = modelo;
    this.color = color;
    this.ram = ram;
    this.discoDuro = discoDuro;
    this.precio = precio;
    this.pantalla = pantalla;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getRam() {
    return ram;
  }

  public void setRam(String ram) {
    this.ram = ram;
  }

  public String getDiscoDuro() {
    return discoDuro;
  }

  public void setDiscoDuro(String discoDuro) {
    this.discoDuro = discoDuro;
  }

  public Double getPrecio() {
    return precio;
  }

  public void setPrecio(Double precio) {
    this.precio = precio;
  }

  public String getPantalla() {
    return pantalla;
  }

  public void setPantalla(String pantalla) {
    this.pantalla = pantalla;
  }

  @Override
  public String toString() {
    return "Laptop{" +
        "id=" + id +
        ", marca='" + marca + '\'' +
        ", modelo='" + modelo + '\'' +
        ", color='" + color + '\'' +
        ", ram='" + ram + '\'' +
        ", discoDuro='" + discoDuro + '\'' +
        ", precio='" + precio + '\'' +
        ", pantalla='" + pantalla + '\'' +
        '}';
  }
}
