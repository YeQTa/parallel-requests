import rest.client.RestClient;
import rest.service.RestService;

public class Main {
    public static void main(String[] args) {
        RestClient restClient = new RestClient();
        RestService restService = new RestService(restClient);

        restService.getAllResponsesOfExternalCalls();
        restService.getFastestResponseOfExternalCalls();
    }
}