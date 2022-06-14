package com.example.tarea2restdatajpa.controller;

import com.example.tarea2restdatajpa.entities.Laptop;
import com.example.tarea2restdatajpa.repository.LaptopRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {
  private final LaptopRepository laptopRepository;

  public LaptopController(LaptopRepository laptopRepository) {
    this.laptopRepository = laptopRepository;
  }

  // Buscar toda la lista de laptops
  @GetMapping("/api/laptops")
  @ApiOperation("Buscar toda la lista de laptops")
  public List<Laptop> findAll() {
    return laptopRepository.findAll();
  }

  // Buscar laptop por id
  @GetMapping("/api/laptops/{id}")
  @ApiOperation("Buscar una laptop por id Long")
  public ResponseEntity<Laptop> findOneById(@PathVariable Long id) {
    return laptopRepository.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  // Crear laptop
  @PostMapping("/api/laptops")
  @ApiOperation("Crear una laptop")
  public Laptop create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers) {
    System.out.println("headers: " + headers.get("User-Agent"));
    return laptopRepository.save(laptop);
  }

  // Actualizar laptop
  @PutMapping("/api/laptops")
  @ApiOperation("Actualizar una laptop")
  public ResponseEntity<Laptop> update(@RequestBody Laptop laptop) {
    if(laptop.getId() == null){
      return ResponseEntity.notFound().build();
    }

    Optional<Laptop> laptopOptional = laptopRepository.findById(laptop.getId());
    if(laptopOptional.isPresent()){
      return ResponseEntity.ok(laptopRepository.save(laptop));
    }

    return ResponseEntity.notFound().build();
  }

  // Eliminar laptop
  @DeleteMapping("/api/laptops/{id}")
  @ApiOperation("Eliminar una laptop con id Long")
  public ResponseEntity<Laptop> delete(@PathVariable Long id) {
    Optional<Laptop> laptopOptional = laptopRepository.findById(id);
    if(laptopOptional.isPresent()){
      laptopRepository.deleteById(id);
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.notFound().build();
  }

  // Eliminar todas las laptops

  @DeleteMapping("/api/laptops")
  @ApiOperation("Eliminamos todas las laptops")
  public ResponseEntity<Laptop> deleteAll() {
    if(laptopRepository.count() > 0){
      laptopRepository.deleteAll();
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.notFound().build();
  }
}
