package se.wigell.wtravels.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_CURRENCY")
public class CurrencyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    private Long price;
    private String from_currency;
    private String to_currencye;
    private float to_currency_value;
    private float converted_value;


    public CurrencyEntity() {
    }

    public CurrencyEntity(Long price, String from_currency, String to_currencye, float to_currency_value, float converted_value) {
        this.price = price;
        this.from_currency = from_currency;
        this.to_currencye = to_currencye;
        this.to_currency_value = to_currency_value;
        this.converted_value = converted_value;
    }

    public CurrencyEntity(Long price, String from_currency, String to_currencye) {
        this.price = price;
        this.from_currency = from_currency;
        this.to_currencye = to_currencye;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getFrom_currency() {
        return from_currency;
    }

    public void setFrom_currency(String from_currency) {
        this.from_currency = from_currency;
    }

    public String getTo_currencye() {
        return to_currencye;
    }

    public void setTo_currencye(String to_currencye) {
        this.to_currencye = to_currencye;
    }

    public float getTo_currency_value() {
        return to_currency_value;
    }

    public void setTo_currency_value(float to_currency_value) {
        this.to_currency_value = to_currency_value;
    }

    public float getConverted_value() {
        return converted_value;
    }

    public void setConverted_value(float converted_value) {
        this.converted_value = converted_value;
    }

    @Override
    public String toString() {
        return "CurrencyModel{" +
                "price=" + price +
                ", from_currency='" + from_currency + '\'' +
                ", to_currencye='" + to_currencye + '\'' +
                ", to_currency_value=" + to_currency_value +
                ", converted_value=" + converted_value +
                '}';
    }
}
