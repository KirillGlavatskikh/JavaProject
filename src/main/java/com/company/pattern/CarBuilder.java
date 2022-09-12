package com.company.pattern;

public class CarBuilder {

    private Car car;

    public CarBuilder() {
        car = new Car();
    }

    public CarBuilder name(String name) {
        car.setName(name);
        return this;
    }

    public CarBuilder color(String color) {
        car.setColor(color);
        return this;
    }

    public CarBuilder enginePower(Long enginePower) {
        car.setEnginePower(enginePower);
        return this;
    }

    public CarBuilder transmission(String transmission) {
        car.setTransmission(transmission);
        return this;
    }

    public Car build() {
        return car;
    }
}
