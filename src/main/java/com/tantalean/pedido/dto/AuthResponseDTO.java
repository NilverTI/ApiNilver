package com.tantalean.pedido.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponseDTO {
    private Long id;
    private String email;
    private String token;
    private String tokenType = "Bearer";
}
