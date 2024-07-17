package com.winterbe.java8.samples.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Benjamin Winterberg
 */
public class CustomStreamScene {

    public static void main(String[] args) {
        // Veri kümesini IntStream ile oluşturma
        List<Integer> data = IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());

        // Thread havuzu oluşturma
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // Veriyi parçalara bölme ve her parçayı bir Callable olarak tanımlama
        List<Callable<List<Integer>>> tasks = data.stream()
                .collect(Collectors.groupingBy(i -> (i - 1) / 10))
                .values().stream()
                .map(sublist -> (Callable<List<Integer>>) () -> {
                    // Her parça üzerinde işlem (örneğin, her elemanın karesini alma)
                    return sublist.stream().map(x -> x * x).collect(Collectors.toList());
                })
                .collect(Collectors.toList());

        // Görevleri asenkron olarak yürütme ve sonuçları CompletableFuture ile toplama
        List<CompletableFuture<List<Integer>>> futures = tasks.stream()
                .map(task -> CompletableFuture.supplyAsync(() -> {
                    try {
                        return task.call();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }, executorService))
                .collect(Collectors.toList());

        // Sonuçları toplama ve ekrana yazdırma
        futures.forEach(future -> future.thenAcceptAsync(processedData -> {
            processedData.forEach(System.out::println);
        }, executorService));

        // ExecutorService'i kapatma
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
