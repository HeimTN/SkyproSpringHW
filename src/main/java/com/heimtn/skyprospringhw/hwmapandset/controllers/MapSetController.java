package com.heimtn.skyprospringhw.hwmapandset.controllers;

import com.heimtn.skyprospringhw.hwmapandset.services.MapSetService;
import com.heimtn.skyprospringhw.hwmapandset.services.MapSetServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/map-set")
public class MapSetController {
    private final MapSetService mapSetService = new MapSetServiceImpl();

    @GetMapping("/odd-nums")
    public List<Integer> getOddNums(){
        return mapSetService.getOddNums();
    }

    @GetMapping("/even-nums")
    public List<Integer> getEvenNums(){
        return mapSetService.getEvenNums();
    }

    @GetMapping("/unique-string")
    public List<String> getUniqueString(){
        return mapSetService.getUniqueString();
    }

    @GetMapping("/duplication-str")
    public Map<String, Integer> getDuplicationStr(){
        return mapSetService.getDuplicationStr();
    }

}
