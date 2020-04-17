package kr.naheenosaur.spring.oauth2.domain.service;

import kr.naheenosaur.spring.oauth2.domain.model.TokenData;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class TokenService {
    @Value("${oauth.token.uri}")
    private String MY_TOKEN_API_URI;

    public TokenData getToken(String companyId, String employeeId, String client, String secret) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity entity = new HttpEntity(new HttpHeaders() {{
            String auth = client + ":" + secret;
            byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.US_ASCII));
            set("Authorization", "Basic " + new String(encodedAuth));
        }});
        try {
            URI userCheckUrl = UriComponentsBuilder
                    .fromUriString(MY_TOKEN_API_URI)
                    .queryParam("grant_type", "client_credentials")
                    .queryParam("company_id", companyId)
                    .queryParam("employee_id", employeeId)
                    .build().encode().toUri();
            TokenData tokenData = restTemplate.exchange(userCheckUrl, HttpMethod.POST, entity, TokenData.class).getBody();
            return tokenData;
        } catch (Exception e) {
            log.error(e.toString());
            e.printStackTrace();
        }
        return null;
    }
}
