package com.example.tarea2restdatajpa.controller;

import com.example.tarea2restdatajpa.entities.Laptop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {
  private TestRestTemplate testRestTemplate;

  @Autowired
  private RestTemplateBuilder restTemplateBuilder;

  @LocalServerPort
  private int port;

  @BeforeEach
  void setUp() {
    restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
    testRestTemplate = new TestRestTemplate(restTemplateBuilder);
  }

  @Test
  void findAll() {
    ResponseEntity<Laptop[]> response =
        testRestTemplate.getForEntity("/api/laptops", Laptop[].class);

    assertEquals(HttpStatus.OK ,response.getStatusCode());
    assertEquals(200, response.getStatusCodeValue());

    List<Laptop> laptops = Arrays.asList(response.getBody());
    assertEquals(1, laptops.size());

  }

  @Test
  void findOneById() {
    ResponseEntity<Laptop> response =
        testRestTemplate.getForEntity("/api/laptops/1", Laptop.class);

    assertEquals(HttpStatus.OK ,response.getStatusCode());
    assertEquals(200 ,response.getStatusCodeValue());
  }

  @Test
  void create() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

    String json = """
         {
             "marca" : "ASUS",
             "modelo" : "ASUS TUF GAMING",
             "color" : "NEGRO",
             "ram" : "15 GB",
             "discoDuro" : "500 GB",
             "precio" : 500.99,
             "pantalla" : "17.3 PULGADAS"
         }
        """;
    HttpEntity<String> request = new HttpEntity<>(json, headers);
    ResponseEntity<Laptop> response =  testRestTemplate.exchange("/api/laptops", HttpMethod.POST, request, Laptop.class);
    Laptop result = response.getBody();

    assertEquals(1L, result.getId());
    assertEquals("ASUS", result.getMarca());
    assertEquals("ASUS TUF GAMING", result.getModelo());

  }
}