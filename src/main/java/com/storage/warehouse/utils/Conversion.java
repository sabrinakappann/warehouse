package com.storage.warehouse.utils;

import java.math.BigDecimal;

public class Conversion {

    public static BigDecimal doubleToBidDecimal(Double d){
        return new BigDecimal(d);
    }

}
