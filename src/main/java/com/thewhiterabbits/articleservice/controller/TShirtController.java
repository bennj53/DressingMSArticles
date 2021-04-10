package com.thewhiterabbits.articleservice.controller;

import com.thewhiterabbits.articleservice.dao.TShirtRepository;
import com.thewhiterabbits.articleservice.entity.TShirt;
import com.thewhiterabbits.articleservice.exception.AddClothingException;
import com.thewhiterabbits.articleservice.exception.ClothingNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class TShirtController {
    Logger log = LoggerFactory.getLogger(TShirtController.class);

    @Autowired
    TShirtRepository tShirtRepository;

    @GetMapping(path="/tshirt/{id}")
    public Optional<TShirt> getTShirt(@PathVariable String id){
        Optional<TShirt> tShirt = tShirtRepository.findById(id);

        if(!tShirt.isPresent()){
            throw new ClothingNotFoundException("TShirt not found");
        }

        return tShirt;
    }

    @GetMapping(path="/tshirts")
    public List<TShirt> listTShirts(){
        return tShirtRepository.findAll();
    }

    @PostMapping(value="/tshirt/add")
    public ResponseEntity<TShirt> addTShirt(@RequestBody TShirt tShirt){
        TShirt newTShirt = tShirtRepository.save(tShirt);

        if(newTShirt == null) throw new AddClothingException("Impossible to add TShirt");

        return new ResponseEntity<TShirt>(tShirt,HttpStatus.CREATED);
    }

    @DeleteMapping(path="/tshirt/delete/{id}")
    public void deleteTShirt(@PathVariable String id){
        Optional<TShirt> tShirt = tShirtRepository.findById(id);
        if(!tShirt.isPresent()){
            throw new ClothingNotFoundException("TShirt not found");
        }else{
            log.error("tshirt id to delete is  : " + tShirt.get().getId());
            tShirtRepository.deleteById(id);
        }

    }

    @PutMapping(value = "/tshirt/update/{id}")
    public ResponseEntity<TShirt> updateTShirt(@PathVariable(value="id") String id,@RequestBody TShirt tShirt){
        log.error("controller update tshirt started");
        tShirt.setId(id);
        TShirt tShirtUpdated = tShirtRepository.save(tShirt);
        if(tShirtUpdated == null) throw new AddClothingException("Impossible to update TShirt");

        return new ResponseEntity<TShirt>(tShirt, HttpStatus.ACCEPTED);
    }
}
