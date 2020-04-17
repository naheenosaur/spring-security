package kr.naheenosaur.spring.oauth2.controller;

import kr.naheenosaur.spring.oauth2.domain.model.TokenData;
import kr.naheenosaur.spring.oauth2.domain.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private TokenService tokenService;

    @PostMapping("/token")
    public TokenData userInfo(@RequestParam(name = "company_id") String companyId,
                              @RequestParam(name = "employee_id") String employeeId,
                              @RequestParam(name = "client_id") String clientId,
                              @RequestParam(name = "client_secret") String secret) {
        return tokenService.getToken(companyId, employeeId, clientId, secret);
    }
}
