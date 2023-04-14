package ua.kiev.prog.retrievers;

import org.apache.catalina.connector.Request;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ua.kiev.prog.json.Rate;

import java.net.URI;

@Component
public class RateRetriever {

    private static final String URL = "https://api.apilayer.com/fixer/latest?symbols=uah&base=eur";
    private String key = "mZHFHzYRo0Gg7Grv1siHGFBiP3UBjDTB";
    @Scheduled(fixedRate = 60000)
    @Cacheable(value = "rates") // Redis
    public Rate getRate() {

        HttpHeaders headers = new HttpHeaders();
        headers.set("apikey", key);
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Rate> response = restTemplate.exchange(
                URL,
                HttpMethod.GET,
                entity,
                Rate.class
        );
        return response.getBody();
    }
}
