package se.wigell.wtravels.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import se.wigell.wtravels.controller.RootPathController;
import se.wigell.wtravels.entity.CurrencyEntity;

import java.util.Objects;

@Service
public class CurrencyService {
    private static final Logger logger =  LogManager.getLogger(RootPathController.class);
    private static final String API_KEY ="b1d8a1990339dd7f16cd07fffe57d75d";
    // ottossonils@hotmail.com
    private static final String BASE_URL = "http://api.exchangerate.host/convert?";

    private final WebClient webClient;

    public CurrencyService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }


    // https://exchangerate.host/documentation
    // to (zloty) PLN -> SEK

    public CurrencyEntity convertCurrency(CurrencyEntity currency){
        // default
        logger.info("convertCurrency(): Convert define currency to SEK");
        String urlSearch = "from=" + currency.getFrom_currency() + "&to=" + currency.getTo_currencye() + "&amount=" + currency.getPrice();
        currency.setConverted_value(Float.parseFloat(getCurrency(urlSearch,currency.getFrom_currency())));

        return currency;
    }

    public String getCurrency(String urlSearch, String currency){
        logger.info("Get value for current currency: " + currency);
        // http://api.exchangerate.host/convert?from=EUR&to=SEK&amount=100&access_key=b1d8a1990339dd7f16cd07fffe57d75d
        String QUERY_VALUE = BASE_URL + urlSearch + "&access_key=" + API_KEY;
        logger.info("get convertion from: " + QUERY_VALUE);
        String json = "";
        try {
            json = Objects.requireNonNull(this.webClient.get().uri(QUERY_VALUE)
                            .exchange()
                            .block())
                            .bodyToMono(String.class)
                            .block();
        }catch (Exception e){
            logger.error(String.valueOf(e));
        }
        System.out.println(json);
        // Pars json repose, get result
        assert json != null;
        JsonElement jsonElement = JsonParser.parseString(json);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        return jsonObject.get("result").toString();
    }
}
