package com.storage.warehouse.compositionItemQuantity;

import java.io.Serializable;
import java.util.Objects;

public class CompositionItemQuantityId implements Serializable {

    private Long composition;
    private Long item;

    public CompositionItemQuantityId(Long compositionId, Long itemId) {
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

    // this is important for some reason

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositionItemQuantityId that = (CompositionItemQuantityId) o;
        return Objects.equals(getComposition(), that.getComposition()) && Objects.equals(getItem(), that.getItem());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getComposition(), getItem());
    }

}
