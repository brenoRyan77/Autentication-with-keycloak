package bo.com.keycloak.auth;

import bo.com.keycloak.dto.UserDto;
import bo.com.keycloak.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/login")
@RestController
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping()
    public ResponseEntity<String> login(@RequestBody UserDto payload){
        return service.login(payload);
    }
}
