package com.codecool.micro.microbe;

import com.codecool.micro.GrowthRate;

public abstract class Bacteria extends Microbe {
    private final int minTemperature;

    public Bacteria(int[] optimalTemperature, long cellNumber, int minTemperature) {
        super(optimalTemperature, cellNumber);
        this.minTemperature = minTemperature;
    }
    
    public GrowthRate getGrowthRate(int temperature){
        int highOpt = this.getOptimalTemperature()[1];
        int lowOpt = this.getOptimalTemperature()[0];
        int coldTolerateSection = lowOpt- minTemperature;
        int[] mediumPart = {lowOpt - coldTolerateSection/2, lowOpt-1};
        int[] lowPart = {minTemperature, lowOpt-1};
        if(temperature >= lowOpt && temperature <= highOpt){
            return GrowthRate.HIGH;
        } else if(temperature >= mediumPart[0] && temperature <= mediumPart[1]) {
            return GrowthRate.MEDIUM;
        } else if(temperature >= lowPart[0] && temperature <= lowPart[1]){
            return GrowthRate.LOW;
        }else {
            return null;
        }
    }
}
