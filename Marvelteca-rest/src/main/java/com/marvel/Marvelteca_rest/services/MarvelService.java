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
    
        // método para obtener datos de la API utilizando valores de las propiedades
        public String getDataFromApi() {

            // Generar el timestamp actual en segundos
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000L);

        // Generar el hash
        String hash = generateHash(timestamp, privateKey, apiKey);
            // Configurar los encabezados
            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", "*/*");
    
            // Construir la URL con los parámetros
            UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("apikey", apiKey)
                .queryParam("ts", timestamp)
                .queryParam("hash", hash);
    
            // Crear la entidad de la solicitud con los encabezados
            HttpEntity<String> entity = new HttpEntity<>(headers);
            RestTemplate restTemplate = new RestTemplate();
    
            // Realizar la solicitud GET
            ResponseEntity<String> response = restTemplate.exchange(
                uriBuilder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class
            );
    
            // Devolver la respuesta del cuerpo
            return response.getBody();
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
