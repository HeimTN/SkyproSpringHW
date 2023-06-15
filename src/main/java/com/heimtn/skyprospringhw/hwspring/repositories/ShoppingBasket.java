package com.heimtn.skyprospringhw.hwspring.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Repository
@SessionScope
public class ShoppingBasket {
    private List<Integer> shoppingBasket = new ArrayList<>();

    public List<Integer> getShoppingBasket() {
        return shoppingBasket;
    }

    public void addShoppingBasket(Integer number){
        shoppingBasket.add(number);
    }

}
