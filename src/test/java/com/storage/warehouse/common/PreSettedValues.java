package com.storage.warehouse.common;

import java.math.BigDecimal;

public abstract class PreSettedValues {

    public BigDecimal getBigDecimalValueFromString(String value, int round){
        BigDecimal value2 = new BigDecimal(value); // str -> BigDecimal
        return value2.setScale(round, BigDecimal.ROUND_HALF_UP);
    }


}
