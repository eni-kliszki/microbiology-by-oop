package com.codecool.micro.microbe;

import java.util.HashSet;
import java.util.Set;

public class Labor {
    private final Set<Microbe> microbes = new HashSet<>();
    private int time;
    private int temperature;

    public Labor(int time, int temperature) {
        this.time = time;
        this.temperature = temperature;
        microbes.add(new LeuconostocMesenteroides(new int[]{29,30}, 1, 10, 25000));
        microbes.add(new ListeriaMonocytogenes(new int[]{30,37}, 1, 2));
        microbes.add(new TobaccoMosaicVirus(new int[]{24,28}, 1, 100000));
    }

    public void simulate(){
        for (Microbe microbe: microbes) {
            microbe.getGrowthRate(temperature);
            microbe.growth(time, temperature);
        }
    }

    public Set<Microbe> getMicrobes() {
        return microbes;
    }
}
