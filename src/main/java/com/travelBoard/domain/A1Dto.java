package com.travelBoard.domain;

import java.util.Objects;

public class A1Dto {
    private Integer keyy;
    private Integer value;

    public A1Dto() {}
    public A1Dto(Integer keyy, Integer value) {
        this.keyy = keyy;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A1Dto a1Dto = (A1Dto) o;
        return Objects.equals(keyy, a1Dto.keyy) && Objects.equals(value, a1Dto.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyy, value);
    }

    public Integer getkeyy() {
        return keyy;
    }

    public void setkeyy(Integer keyy) {
        this.keyy = keyy;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
