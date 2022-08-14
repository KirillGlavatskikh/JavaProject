package com.company.homeworkStream;

import java.util.Objects;

public class Television {

    private String modelName;
    private Long yearRelease;
    private Long price;
    private Long diagonal;
    private String madeIn;

    public Television(String modelName, Long yearRelease, Long price, Long diagonal, String madeIn) {
        this.modelName = modelName;
        this.yearRelease = yearRelease;
        this.price = price;
        this.diagonal = diagonal;
        this.madeIn = madeIn;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Long getYearRelease() {
        return yearRelease;
    }

    public void setYearRelease(Long yearRelease) {
        this.yearRelease = yearRelease;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(Long diagonal) {
        this.diagonal = diagonal;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Television that = (Television) o;
        return Objects.equals(modelName, that.modelName) && Objects.equals(yearRelease, that.yearRelease) && Objects.equals(price, that.price) && Objects.equals(diagonal, that.diagonal) && Objects.equals(madeIn, that.madeIn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelName, yearRelease, price, diagonal, madeIn);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Television{");
        sb.append("modelName='").append(modelName).append('\'');
        sb.append(", yearRelease=").append(yearRelease);
        sb.append(", price=").append(price);
        sb.append(", diagonal=").append(diagonal);
        sb.append(", madeIn='").append(madeIn).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
