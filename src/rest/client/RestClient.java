package rest.client;

public class RestClient {

    /**
     * A prototype client service that runs with 3 sec delay
     *
     * @return
     */
    public int clientMethod1() {
        try {
            Thread.sleep(3000);
            return 1;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * A prototype client service that runs with 5 sec delay
     *
     * @return 2
     */
    public int clientMethod2() {
        try {
            Thread.sleep(5000);
            return 2;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
