package com.example.clientsystem.domain.client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestClient(

        String id,

        @NotBlank
        String name,
        @NotNull
        String email
        
) {

}