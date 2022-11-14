# parallel-requests
In this repository, Java's CompletableFuture feature is used to demonstrate parallel service calls.

## Use Case
Imagine that there are 2 external rest services that needs to be called from the app. One of them takes 3 seconds and the other takes 5 seconds.
Instead of waiting for 8 seconds to collect the data from both external services, we are able to call these services in parallel with the help of CompletableFuture
so that it takes 5 seconds instead of 8.

Besides, we are also able to call both external services and take the result of the fastest responded service.
