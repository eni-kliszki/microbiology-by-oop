package com.codecool.micro;

import com.sun.source.tree.ReturnTree;

public enum GrowthRate {
    LOW(60),
    MEDIUM(40),
    HIGH(20);

    private final int time;

    GrowthRate(int time) {
        this.time = time;
    }

    public int getTimeByDuplicate() {
        return time;
    }

    public GrowthRate increaseGrowthRate(GrowthRate growthRate){
        if(growthRate.equals(HIGH)){
            return MEDIUM;
        }else if(growthRate.equals(MEDIUM)){
            return LOW;
        }
        return null;
    }
}
