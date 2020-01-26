package com.lits.kaminskyi.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.lits.kaminskyi.lits.LitsHttpClient;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class TestGetGoogle {

    private LitsHttpClient client = new LitsHttpClient();

    @Test
    public void testGetGoogle() throws IOException {

        Response getGoogleResponse = client.GET ("https://google.com");

        String responseContentType = getGoogleResponse.header("Content-Type");
        Assert.assertEquals(getGoogleResponse.code(), 200);
        Assert.assertEquals(responseContentType, "text/html; charset=ISO-8859-1");
    }

    @Test
    public void testGetCurrencyExchangeRate() throws IOException {


                String url = "https://bank.gov.ua/NBU_Exchange/exchange?date=20.01.2020&json";

                Response getNbuResponse = client.GET(url);

        CurrencyRate[] currencyRates = LitsHttpClient
                .convert(
                        getNbuResponse,
                        CurrencyRate[].class);

        for (CurrencyRate currencyRate : currencyRates) {
            System.out.println(currencyRate);
        }

        // HOMEWORK WRITE ASSERTS
        // Check Currency rate by currency code
        // USD amount is 24.2527
    }

    @Test
    public void testLogin() throws IOException {

        // 1 DOWNLOAD POSTMAN
        // 2 REGISTER USER (via POSTMAN)
        // 3 ACTIVATE USER (via EMAIL)

        // 4 LOGIN USER (via JAVA CODE)

//        String url

        Request postLogin = new Request.Builder()
                .url("https://europe-west2-search-app-263e2.cloudfunctions.net/webapp/api/auth/login")
                .post(RequestBody.create(MediaType.parse("application/json"), "{\n" +
                        "\t\"email\":\"drolgmaks+16@gmail.com\",\n" +
                        "\t\"password\":\"Qwerty123456\"\n" +
                        "}")).build();

//        Response execute = client.newCall(postLogin).execute();

        // 5 CONVERT RESPONSE TO JAVA MODEL
    }


    public static class CurrencyRate {
        @JsonProperty("StartDate")
        private String StartDate;
        @JsonProperty("TimeSign")
        private String TimeSign;
        @JsonProperty("CurrencyCode")
        private String CurrencyCode;
        @JsonProperty("CurrencyCodeL")
        private String CurrencyCodeL;
        @JsonProperty("Units")
        private int Units;
        @JsonProperty("Amount")
        private BigDecimal Amount;

        public String getStartDate() {
            return StartDate;
        }

        public void setStartDate(String startDate) {
            StartDate = startDate;
        }

        public String getTimeSign() {
            return TimeSign;
        }

        public void setTimeSign(String timeSign) {
            TimeSign = timeSign;
        }

        public String getCurrencyCode() {
            return CurrencyCode;
        }

        public void setCurrencyCode(String currencyCode) {
            CurrencyCode = currencyCode;
        }

        public String getCurrencyCodeL() {
            return CurrencyCodeL;
        }

        public void setCurrencyCodeL(String currencyCodeL) {
            CurrencyCodeL = currencyCodeL;
        }

        public int getUnits() {
            return Units;
        }

        public void setUnits(int units) {
            Units = units;
        }

        public BigDecimal getAmount() {
            return Amount;
        }

        public void setAmount(BigDecimal amount) {
            Amount = amount;
        }

        @Override
        public String toString() {
            return "CurrencyRate{" +
                    "StartDate='" + StartDate + '\'' +
                    ", TimeSign='" + TimeSign + '\'' +
                    ", CurrencyCode='" + CurrencyCode + '\'' +
                    ", CurrencyCodeL='" + CurrencyCodeL + '\'' +
                    ", Units='" + Units + '\'' +
                    ", Amount='" + Amount + '\'' +
                    '}';
        }
    }
}
