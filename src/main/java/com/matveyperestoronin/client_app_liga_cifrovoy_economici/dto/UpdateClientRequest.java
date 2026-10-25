package com.matveyperestoronin.client_app_liga_cifrovoy_economici.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UpdateClientRequest(

        @Size(min = 1, max = 255)
        @JsonProperty("full_name")
        String name,
        @Size(max = 1)
        @Pattern(regexp = "^(?i)[MF]$", message = "Пол указывается 'M' или 'F'")
        String gender,

        @Size(max = 20)
        @Pattern(regexp = "^(?i)(ACTIVE|INACTIVE)$", message = "Статус только ACTIVE и INACTIVE")
        String status

) {
}
