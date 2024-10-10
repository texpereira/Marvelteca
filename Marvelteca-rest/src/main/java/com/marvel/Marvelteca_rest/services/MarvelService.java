package com.marvel.Marvelteca_rest.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class MarvelService {
    @Value("${marvel.api.url}")
    private String apiUrl;

    @Value("${marvel.api.key}")
    private String apiKey;

    @Value("${marvel.api.privateKey}")
    private String privateKey;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public String getDatacharacterId(String personaje) {

        return getDataFromApi(personaje);
    }

    public String getDataFromApi(String personaje) {
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000L);
        String hash = generateHash(timestamp, privateKey, apiKey);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(apiUrl.concat(personaje))
                .queryParam("apikey", apiKey)
                .queryParam("ts", timestamp)
                .queryParam("hash", hash);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    uriBuilder.toUriString(),
                    HttpMethod.GET,
                    entity,
                    String.class);
        return response.getBody();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "";
        }
    }

    private String generateHash(String ts, String privateKey, String publicKey) {
        try {
            String valueToHash = ts + privateKey + publicKey;
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(valueToHash.getBytes());
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
