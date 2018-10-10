package ru.geekbrains.chendyreva.homework5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class Race {
    boolean winner = false;
    private List<Stage> stages;
    private List<Car> cars = new ArrayList<>();

    List<Stage> getStages() { return stages; }

    public Race(Stage... stages) {
        this.stages = Arrays.asList(stages);
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
    }

    private static  final int CARS_COUNT = 4;
    private CountDownLatch start;
    private CyclicBarrier finish;
    private AtomicInteger results = new AtomicInteger(0);

    public static void main(String[] args) {
        Race race = new Race(new Road(60), new Tunnel(CARS_COUNT / 2), new Road(40));
        for(int i = 0; i < CARS_COUNT; i++)

            race.add(new Car(race, 20 + (int) (Math.random() * 10)));
        }
        race.start();
    }
     private void add(Car car) {cars.add(car);}

     private void start(){
    int carsSize = cars.size();
    start = new CountDownLatch(carsSize);
    finish = new CyclicBarrier(carsSize, () ->
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");)
         cars.forEach(Thread::start);
    try {
        start.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
     } catch (InterruptedException e){
        e.printStackTrace();
        }
     }
     void finish(String name) {
         int position = results.incrementAndGet();
         System.out.println(position == 1 ? name + " - WIN"
                 : name + " - занял " + position + " место");
         try {
             finish.await();
         } catch (InterruptedException | BrokenBarrierException e) {
             e.printStackTrace();
         }
     }
     public void start(String name) {
      try {
          System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
          Thread.sleep(500 + (int) (Math.random() * 800));
          System.out.println(this.name + " готов");
          start.countDown();
          start.await();
      } catch (Exception e) {
          e.printStackTrace();
     }
}
}