package kr.naheenosaur.spring.oauth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CustomJwtAccessTokenConverter extends JwtAccessTokenConverter {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, Object> additionalData = new HashMap<>();
        additionalData.put("employee_info", authentication.getOAuth2Request().getRequestParameters());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalData);

        String encoded = super.encode(accessToken, authentication);
        ((DefaultOAuth2AccessToken) accessToken).setValue(encoded);
        return accessToken;
    }
}
