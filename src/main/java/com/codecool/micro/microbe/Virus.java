package com.codecool.micro.microbe;

import com.codecool.micro.GrowthRate;

public abstract class Virus extends Microbe{
    private int deadlyGermCount;

    public Virus(int[] optimalTemperature, long cellNumber, int deadlyGermCount) {
        super(optimalTemperature, cellNumber);
        this.deadlyGermCount = deadlyGermCount;
    }

    public GrowthRate getGrowthRate(int temperature){
        if(temperature >= this.getOptimalTemperature()[0] && temperature <= this.getOptimalTemperature()[1]){
            return GrowthRate.HIGH;
        } else {
            return null;
        }
    }

    @Override
    public void growth(int time, int temperature) {
        long cellNumber = this.getCellNumber();
        int estimateNumberNearByInhibition = (int)(Math.log(deadlyGermCount) / Math.log(2))+1;
        GrowthRate growthRate = this.getGrowthRate(temperature);
        int leftTime = time- (estimateNumberNearByInhibition * growthRate.getTimeByDuplicate());
        if (growthRate != null) {
            cellNumber = (long) Math.pow(2, estimateNumberNearByInhibition) * cellNumber;
            this.setCellNumber(cellNumber);
        }
    }
}
