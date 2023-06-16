package com.heimtn.skyprospringhw.hwspring.controllers;

import com.heimtn.skyprospringhw.hwspring.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@RestController
@RequestMapping("/store/order")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/add")
    public void addItem(@RequestParam String numbers){
        List<Integer> temp = Arrays.stream(numbers.split(",")).map(Integer::valueOf).toList();
        storeService.addItemToShBasket(temp);
    }

    @GetMapping("/get")
    public List<Integer> getItem(){
        return storeService.getItemsFromShBasket();
    }
}
