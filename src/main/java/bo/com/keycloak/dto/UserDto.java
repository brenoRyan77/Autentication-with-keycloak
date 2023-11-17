package bo.com.keycloak.dto;

public record UserDto(String username, String password,
                      String clientId, String grantType) {
}
