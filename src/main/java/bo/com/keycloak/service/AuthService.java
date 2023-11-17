package bo.com.keycloak.service;

import bo.com.keycloak.dto.UserDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {

    public ResponseEntity<String> login(UserDto payload){

        HttpHeaders headers = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();

        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("client_id", payload.clientId());
        formData.add("username", payload.username());
        formData.add("password", payload.password());
        formData.add("grant_type", payload.grantType());

        String url = "http://localhost:8080/realms/youtube/protocol/openid-connect/token";

        HttpEntity<MultiValueMap<String, String>> entity =
                new HttpEntity<MultiValueMap<String, String>>(formData, headers);

        return restTemplate.postForEntity(url, entity, String.class);
    }
}
