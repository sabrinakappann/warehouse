package com.storage.warehouse;

import com.storage.warehouse.models.Component;
import com.storage.warehouse.models.Item;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.storage.warehouse.TestsUtils.random_int;

public class ItemsTests {

    Item aquario_cooler;
    Item fonte_12V;
    Item suporte_acrilico;
    Item cooler;

    @Test
    public void creation_of_component_from_interface(){

        int id1 = random_int();
        int id2 = random_int();
        int id3 = random_int();
        int id4 = random_int();

        Item fonte12V = new Component(new BigDecimal("25.5"), id1, "font", "12V" );
        Item suporteAcrilico = new Component(new BigDecimal("16"), id2, "suporte acrílico", "é feito de acrílico para suportar coisas" );
        Item cooler = new Component(new BigDecimal("67.99"), id3, "cooler", "se resfriar é bom" );
    }

}
