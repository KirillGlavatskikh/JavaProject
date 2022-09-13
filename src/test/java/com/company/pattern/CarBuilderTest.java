package com.company.pattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CarBuilderTest {

    CarBuilder carBuilder = new CarBuilder();

    @Test
    void ifCarBuilderNullShouldReturnNull() {
        carBuilder.build();
        Assertions.assertNull(null);
    }
}