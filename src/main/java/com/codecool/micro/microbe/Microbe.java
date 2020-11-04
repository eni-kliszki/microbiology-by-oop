package com.codecool.micro.microbe;

import com.codecool.micro.GrowthRate;

public abstract class Microbe {
    private final int[] optimalTemperature;
    private long cellNumber;
    private GrowthRate growthRate;

    public Microbe(int[] optimalTemperature, long cellNumber) {
        this.optimalTemperature = optimalTemperature;
        this.cellNumber = cellNumber;
    }

    public void growth(int time, int temperature) {
        growthRate = getGrowthRate(temperature);
        if (growthRate != null) {
            int iterations = (int) Math.floor(time / growthRate.getTimeByDuplicate());
            cellNumber = (long) Math.pow(2, iterations) * cellNumber;
        }
    }

    public int[] getOptimalTemperature() {
        return optimalTemperature;
    }

    public long getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(long cellNumber) {
        this.cellNumber = cellNumber;
    }

    public abstract GrowthRate getGrowthRate(int temperature);

}