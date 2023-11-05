package Task_4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class RandomDataController {

    @GetMapping("/uuid")
    public String getRandomUUID() {
        UUID randomUUID = UUID.randomUUID();
        return "{\"uuid\":\"" + randomUUID.toString() + "\"}";
    }

    @GetMapping("/exchange")
    public String getRandomExchangeRate() {
        double randomRate = ThreadLocalRandom.current().nextDouble(0.5, 2.0);
        return "{\"exchangeRate\":" + randomRate + "}";
    }

    @GetMapping("/exchange/{currency}")
    public String getExchangeRateForCurrency(@PathVariable String currency) {
        double randomRate = ThreadLocalRandom.current().nextDouble(0.5, 2.0);
        return "{\"currency\":\"" + currency + "\", \"exchangeRate\":" + randomRate + "}";
    }
}
