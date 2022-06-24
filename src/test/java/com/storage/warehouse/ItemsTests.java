package com.storage.warehouse;

import com.storage.warehouse.models.Component;
import com.storage.warehouse.models.Item;
import org.junit.jupiter.api.Test;

import static com.storage.warehouse.common.TestsUtils.random_int;

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

        Double v1 = new Double(233.12121);
        Double v2 = new Double(0);
        Double v3 = new Double(4);

        Item fonte12V = new Component(v1, id1, "font", "12V" );
        Item suporteAcrilico = new Component(v2, id2, "suporte acrílico", "é feito de acrílico para suportar coisas" );
        Item cooler = new Component(v3, id3, "cooler", "se resfriar é bom" );
    }

}
