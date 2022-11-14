package rest.service;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;

import rest.client.RestClient;

public class RestService {

    RestClient restClient;

    public RestService(RestClient restClient) {
        this.restClient = restClient;
    }

    /**
     * Without parallel service call, this method would take 3 + 5 = 8 sec to run.
     * However, it takes 5 sec to run with the help of CompletableFuture.
     * This method, waits for both external services to be completed and gets the result of them
     */
    public void getAllResponsesOfExternalCalls() {
        Instant start = Instant.now();
        CompletableFuture<Integer> firstService = CompletableFuture.supplyAsync(restClient::clientMethod1);
        CompletableFuture<Integer> secondService = CompletableFuture.supplyAsync(restClient::clientMethod2);

        CompletableFuture.allOf(firstService, secondService);

        int firstValue = firstService.join();
        int secondValue = secondService.join();
        long timeElapsed = Duration.between(start, Instant.now()).toMillis();
        System.out.println("First: " + firstValue + ", Second: " + secondValue);
        System.out.println("Elapsed Time:" + timeElapsed);
    }

    /**
     * This method parallel calls clientMethod1 and clientMethod2 and
     * returns the result of first responded client method
     */
    public void getFastestResponseOfExternalCalls() {
        Instant start = Instant.now();
        CompletableFuture<Integer> firstService = CompletableFuture.supplyAsync(restClient::clientMethod1);
        CompletableFuture<Integer> secondService = CompletableFuture.supplyAsync(restClient::clientMethod2);

        CompletableFuture<Object> fastestResult = CompletableFuture.anyOf(firstService, secondService);
        System.out.println("Fastest result:" + fastestResult.join());
        long timeElapsed = Duration.between(start, Instant.now()).toMillis();
        System.out.println("Elapsed Time:" + timeElapsed);
    }
}
