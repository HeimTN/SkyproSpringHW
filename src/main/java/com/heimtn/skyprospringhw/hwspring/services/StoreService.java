package com.heimtn.skyprospringhw.hwspring.services;

import java.util.List;

public interface StoreService {

    List<Integer> getItemsFromShBasket();

    void addItemToShBasket(List<Integer> numbers);
}
