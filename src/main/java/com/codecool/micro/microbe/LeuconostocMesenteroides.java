package com.codecool.micro.microbe;

import com.codecool.micro.GrowthRate;

public class LeuconostocMesenteroides extends Bacteria{
    private final int cellNumberByInhibition;

    public LeuconostocMesenteroides(int[] optimalTemperature, long cellNumber, int minTemperature, int cellNumberByInhibition) {
        super(optimalTemperature, cellNumber, minTemperature);
        this.cellNumberByInhibition = cellNumberByInhibition;
    }

    @Override
    public void growth(int time, int temperature) {
        long cellNumber = this.getCellNumber();
        int estimateNumberNearByInhibition = (int)(Math.log(cellNumberByInhibition) / Math.log(2))+1;
        GrowthRate growthRate = this.getGrowthRate(temperature);
        int leftTime = time- (estimateNumberNearByInhibition * growthRate.getTimeByDuplicate());
        if (growthRate != null) {
            cellNumber = (long) Math.pow(2, estimateNumberNearByInhibition) * cellNumber;
            growthRate = growthRate.increaseGrowthRate(growthRate);
            if(growthRate!= null){
                cellNumber = (long) Math.pow(2, leftTime / growthRate.getTimeByDuplicate()) * cellNumber;
                this.setCellNumber(cellNumber);
            }
        }
    }
}
