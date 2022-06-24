package com.storage.warehouse.common;

import java.util.Map;
import java.util.Random;

public abstract class TestsUtils {

    public static void printHashmap(Map<Object, Object> hp){
        for (Map.Entry<Object, Object> entry : hp.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }
    }



    public static int random_int(){
        Random r = new Random();
        return r.nextInt();
    }

}
