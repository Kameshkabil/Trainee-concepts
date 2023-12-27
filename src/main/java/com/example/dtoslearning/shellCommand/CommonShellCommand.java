package com.example.dtoslearning.shellCommand;


import com.example.dtoslearning.model.Aliens;
import com.example.dtoslearning.model.Product;
import com.example.dtoslearning.service.AlienServiceLayer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.util.List;

@ShellComponent
public class CommonShellCommand {

    //    @Autowired
//    RestTemplate restTemplate;
    private final RestTemplate restTemplate;

    public CommonShellCommand(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    AlienServiceLayer alienServiceLayer;
    @Autowired
    EntityManager entityManager;

    @ShellMethod(key = "hello", value = "I will say hello")
    public String hello(@ShellOption(defaultValue = "world") String args) {
        return "Hello," + args + "!";
    }

    @ShellMethod(key = "Goodbye", value = "I will say goodbye")
    public String goodBye() {
        return "GoodBye";
    }

    @ShellMethod(key = "getProduct", value = "I will Gather Product Data")
    public Product getAlien(@ShellOption int id) {
//        Aliens alien =  alienServiceLayer.getParticularAlienData(id);
//        return alien;
        Product userRestTemp = restTemplate.getForEntity("http://localhost:8080/template/products", Product.class, id).getBody();
        return userRestTemp;
    }


//    @ShellMethod(key = "createNewAlien",value = "I will Create New Alien Data")
//    public Aliens createProduct(@ShellOption String alienName ,String alienColor, int alienAge){
//        String apiUrl = "http://localhost:8080/aliens/createAliensData";
//        Aliens aliens = new Aliens();
//        aliens.setAlienName(alienName);
//        aliens.setAlienColor(alienColor);
//        aliens.setAlienAge(alienAge);
//
//        ResponseEntity<Aliens> responseEntity = restTemplate.exchange(
//                apiUrl,
//                HttpMethod.POST,
//                new HttpEntity<>(aliens),
//                Aliens.class
//        );
////        return restTemplate.postForObject(apiUrl, aliens, Aliens.class);
//
//        return responseEntity.getBody();

    // }
    //String alienName, String alienColor, Integer alienAge
    @ShellMethod(key = "createNewAlien", value = "I will Create New Alien Data")
    public String createNewAlien(@ShellOption String jsonData) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Aliens aliens = objectMapper.readValue(jsonData, Aliens.class);
            String apiUrl = "http://localhost:8080/aliens/createAliensData";
            return restTemplate.postForObject(apiUrl, aliens, String.class);
//        Aliens aliens = new Aliens();
//        aliens.setAlienName(alienName);
//        aliens.setAlienAge(alienAge);
//        aliens.setAlienColor(alienColor);
        } catch (JsonProcessingException e) {
            return "Error parsing Json data: " + e.getMessage();
        } catch (Exception e) {
            return "An error occurred: " + e.getMessage();
        }
        //return restTemplate.postForObject(apiUrl, requestMap, Map.class,requestMap);
    }


    @Transactional
    @ShellMethod(key = "importAlien", value = "Import aliens from a JSON File")
    public String importAliens(String filePath){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);

            List<Aliens> importedAliens = objectMapper.readValue(file, new TypeReference<List<Aliens>>() {
            });
            for (int i = 0; i < importedAliens.size(); i++) {
                Aliens aliens = importedAliens.get(i);
                if (!alienExists(aliens.getAlienName())){
                    entityManager.persist(aliens);
                }else {
                   return "This AlienAccount Already Exists...";
                    //throw new AlienAlreadyExistsExcepiton("AlienAccount Already Exist");
                }

            }
            return "Alien imported Successfully";
        } catch (IOException e) {
            return "Error importing alien";
        }


    }
    private boolean alienExists(String alienName){
        String jpql  = "SELECT COUNT(a) FROM Aliens a WHERE a.alienName = :alien_name";
        Long alienNameCount = entityManager.createQuery(jpql,Long.class)
                .setParameter("alien_name",alienName)
                .getSingleResult();

        return alienNameCount>0;
    }
}







