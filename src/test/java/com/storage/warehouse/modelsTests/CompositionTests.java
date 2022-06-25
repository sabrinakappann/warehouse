package com.storage.warehouse.modelsTests;

import com.storage.warehouse.common.modelsCommon.CompositionTestsAuxiliary;
import com.storage.warehouse.models.Composition;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CompositionTests {
    // very simple tests to automatizate them and  ensure the comportament is ok

    CompositionTestsAuxiliary aux = new CompositionTestsAuxiliary();

    Composition compositionWithOneComponent = aux.createCompositionFromOneComponent();
    Composition compositionWithMoreThenOneComponent = aux.createTestCompositionFromListOfTestComponents();
    Composition compositionFRomListOfCompositions= aux.createCompositionFromListOfCompositionItem();

    @Test
    public void testIfAllComponentsAreInCompositionCreatedWithAFewItems(){
        assert compositionWithMoreThenOneComponent.getItems().contains(aux.component1);
        assert compositionWithMoreThenOneComponent.getItems().contains(aux.component2);
        assert compositionWithMoreThenOneComponent.getItems().contains(aux.component3);
        assert compositionWithMoreThenOneComponent.getItems().contains(aux.component4);
    }

    @Test
    public void testIfAllCompositionsAreInCompositionCreatedWithAFFewItems(){
        assert compositionFRomListOfCompositions.getItems().contains(aux.composition1);
        assert compositionFRomListOfCompositions.getItems().contains(aux.composition2);
    }



}
