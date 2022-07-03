package com.storage.warehouse.compositionItemsQuantities;

import java.io.Serializable;

public class CompositionItemsId implements Serializable {

    private Long composition; // name must be this one, but reffers to compositionId
    private Long item; // name must be this one, but reffers to itemId
    private static final Long serialVersionUID = 1L;

    public CompositionItemsId() {
    }

    public CompositionItemsId(Long compositionId, Long itemId) {
        this.composition = compositionId;
        this.item = itemId;
    }

    public Long getComposition() {
        return composition;
    }

    public void setComposition(Long composition) {
        this.composition = composition;
    }

    public Long getItem() {
        return item;
    }

    public void setItem(Long item) {
        this.item = item;
    }

/*    // this is important for some reason

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositionItemsId that = (CompositionItemsId) o;
        return Objects.equals(getComposition(), that.getComposition()) && Objects.equals(getItem(), that.getItem());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getComposition(), getItem());
    }*/

}
