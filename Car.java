package ru.geekbrains.chendyreva.homework5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Car implements Runnable {
    private static int CARS_COUNT = 0;

    private Race race;
    private int speed;

    int getSpeed() {return speed; }

    public Car(Race race, int speed, CountDownLatch startLatch, Semaphore tunnelSemaphore, CyclicBarrier finishBarrier) {
        CARS_COUNT++;
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        setName("Участник #" + CARS_COUNT);
    }
    @Override
public void run() {
    race.start(getName());
    race.getStages().forEach(stage -> stage.go(this));
    race.finish(getName());
    }
}



