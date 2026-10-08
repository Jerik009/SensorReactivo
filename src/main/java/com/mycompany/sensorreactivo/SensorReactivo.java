package com.mycompany.sensorreactivo;

import reactor.core.publisher.Flux;
import java.time.Duration;
import java.time.Duration;

public class SensorReactivo {
    public static void main(String[] args) throws InterruptedException {
        Flux.interval(Duration.ofMillis(200))
            .map(i -> 20 + Math.random() * 15)
            .filter(t -> t > 30)    
            .map(t -> String.format("ALERT: %.1f °C", t))
            .take(5)
            .subscribe(
                System.out::println,                         
                e -> System.err.println("Error: " + e),
                () -> System.out.println("Stream completed")
            );

        Thread.sleep(10000); 
    }
}