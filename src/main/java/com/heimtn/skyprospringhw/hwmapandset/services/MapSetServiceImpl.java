package com.heimtn.skyprospringhw.hwmapandset.services;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MapSetServiceImpl implements MapSetService{
    private final List<Integer> nums = new ArrayList<>(List.of(8, 1, 7, 3, 4, 4, 5, 5, 2, 7));
    private final String text = "Олень северное животное В летнее время оленям в тайге жарко а в горах даже в июле холодно " +
            "Олень как бы создан для северных просторов жёсткого ветра,длинных морозных ночей " +
            "Олень легко бежит вперёд по тайге,подминает под себя кусты,переплывает быстрые реки " +
            "Олень не тонет потому что каждая его шерстинка-это длинная трубочка которую внутри наполняет воздух " +
            "Нос у олень покрыт серебристой шёрсткой Если бы шерсти на носу не было,олень бы его отморозил";
    private final List<String> textStr = Arrays.stream(text.split("[^a-яё]")).toList();
    private final List<String> strings = new ArrayList<>(List.of("один", "два","два", "три", "три", "три"));

    /* Задание 1 */
    @Override
    public List<Integer> getOddNums(){
        List<Integer> oddNums = new ArrayList<>();
        for (Integer num : nums) {
            if (num % 2 != 0) oddNums.add(num);
        }
        return oddNums;
    }

    /* Задание 2 */
    @Override
    public List<Integer> getEvenNums(){
        Set<Integer> evenNums = new HashSet<>();
        for(Integer num : nums){
            if (num % 2 == 0) evenNums.add(num);
        }
        return evenNums.stream().toList();
    }

    /* Задание 3 */
    @Override
    public List<String> getUniqueString(){
        Set<String> uniqueString = new HashSet<>();
        for(String temp : textStr){
            if (temp.length() > 3) uniqueString.add(temp.toLowerCase());
        }
        return uniqueString.stream().toList();
    }

    /* Задание 4 */
    @Override
    public Map<String,Integer> getDuplicationStr(){
        Map<String, Integer> duplicationStr = new HashMap<>();
        for(String temp : strings){
            if(duplicationStr.containsKey(temp)){
                duplicationStr.put(temp, duplicationStr.get(temp) + 1);
            }
            else {
                duplicationStr.put(temp, 1);
            }
        }
        return duplicationStr;
    }

}
