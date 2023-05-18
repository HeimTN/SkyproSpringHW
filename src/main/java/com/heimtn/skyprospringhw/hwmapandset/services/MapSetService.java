package com.heimtn.skyprospringhw.hwmapandset.services;

import java.util.List;
import java.util.Map;

public interface MapSetService {
    List<Integer> getOddNums();

    List<Integer> getEvenNums();

    List<String> getUniqueString();

    Map<String,Integer> getDuplicationStr();
}
