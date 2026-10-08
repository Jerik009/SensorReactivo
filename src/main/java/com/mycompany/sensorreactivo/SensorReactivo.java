package com.mycompany.sensorreactivo;

import reactor.core.publisher.Flux;
import java.time.Duration;
import java.time.Duration;

public class SensorReactivo {
    public static void main(String[] args) throws InterruptedException {
        Flux.interval(Duration.ofMillis(200))                // 1 Publisher
            .map(i -> 20 + Math.random() * 15)               // 2 simulated temperature
            .filter(t -> t > 30)                             // 3 only high readings
            .map(t -> String.format("ALERT: %.1f °C", t))
            .take(5)                                         // 4 complete after 5 alerts
            .subscribe(                                      // 5 Subscriber
                System.out::println,                         // onNext
                e -> System.err.println("Error: " + e),      // onError
                () -> System.out.println("Stream completed") // onComplete
            );

        Thread.sleep(10000); // keeps main alive: the stream runs on another thread
    }
}