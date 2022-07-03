package com.storage.warehouse.compositionItemsQuantities;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CompositionItemsId implements Serializable {

    private static final Long serialVersionUID = 1L;
    Long compositionId;
    Long itemId;


    public CompositionItemsId() {
    }

    public CompositionItemsId(Long compositionId, Long itemId) {
        this.compositionId = compositionId;
        this.itemId = itemId;
    }

    public Long getCompositionId() {
        return compositionId;
    }

    public void setCompositionId(Long compositionId) {
        this.compositionId = compositionId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    // equals and hashCode are important for some reason

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositionItemsId that = (CompositionItemsId) o;
        return getCompositionId().equals(that.getCompositionId()) && getItemId().equals(that.getItemId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCompositionId(), getItemId());
    }
}
