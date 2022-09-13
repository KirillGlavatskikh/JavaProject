package com.company.flashlightFactory;

public class ChinaBattery {

    private int batteryCharge = 5;

    public boolean isCheckBatteryCharge(){
        boolean isCharge = true;
        if(batteryCharge > 0){
            batteryCharge--;
        }else{
            isCharge = false;
        }
        return isCharge;
    }
}