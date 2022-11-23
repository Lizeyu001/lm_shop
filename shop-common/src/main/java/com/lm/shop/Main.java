package com.lm.shop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> idList = new ArrayList<>();

        Set<Integer> idSet = idList.stream().collect(Collectors.toSet());

        Set<Integer> asd = new HashSet<>();
        asd.add(1);

        List<Integer> collect = idSet.stream()
                .filter(imgId -> !asd.contains(imgId))
                .collect(Collectors.toList());

        List<Integer> removeMaritalImgList = asd.stream()
                .filter(imgId -> !idSet.contains(imgId))
                .collect(Collectors.toList());
//        System.out.println(collect);
//        System.out.println(removeMaritalImgList);

//        idList.stream().forEach(System.out::println);

        for (Integer integer : idList) {
            System.out.println(integer);
        }
    }
}