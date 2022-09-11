package com.company.flashlightFactory;

import java.util.Scanner;

public class Flashlight {

    ChinaBattery chinaBattery = new ChinaBattery();
    public boolean isLight;

    public void flashLightOn(){
        isLight = chinaBattery.isCheckBatteryCharge();
    }
    public boolean flashLightOff(){
        return false;
    }
    public boolean addNewFlashLight(){
        Flashlight flashlight = new Flashlight();
        return  flashLightOff();
    }
}