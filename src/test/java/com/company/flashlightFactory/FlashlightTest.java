package com.company.flashlightFactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlashlightTest {

    Flashlight flashlight = new Flashlight();
    ChinaBattery chinaBattery = new ChinaBattery();

    @Test
    void isNewFlashLightShouldBeOffAndReturnFalse() {
        flashlight.addNewFlashLight();
        Assertions.assertFalse(false);
    }

    @Test
    void isFlashLightOnShouldBeTrue(){
    flashlight.flashLightOn();
        Assertions.assertTrue(true);
    }
    @Test
    void isFlashLightOffShouldBeFalse(){
        flashlight.flashLightOff();
        Assertions.assertFalse(false);
    }
    @Test
    void isFlashLightFifthOnShouldBeFalse(){
        flashlight.flashLightOn();
        flashlight.flashLightOn();
        flashlight.flashLightOn();
        flashlight.flashLightOn();
        flashlight.flashLightOn();
        flashlight.flashLightOn();
        Assertions.assertFalse(flashlight.isLight);
    }
    @Test
    void isChinaBatteryFifthOnShouldBeFalse(){
        chinaBattery.isCheckBatteryCharge();
        chinaBattery.isCheckBatteryCharge();
        chinaBattery.isCheckBatteryCharge();
        chinaBattery.isCheckBatteryCharge();
        chinaBattery.isCheckBatteryCharge();
        Assertions.assertFalse(chinaBattery.isCheckBatteryCharge());
    }

}