package com.matveyperestoronin.client_app_liga_cifrovoy_economici.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

public record ClientResponse(
        Long id,
        @JsonProperty("full_name")
        String name,
        String gender,
        String status,
        @JsonProperty("create_dttm")
        OffsetDateTime createDate,
        @JsonProperty("modify_dttm")
        OffsetDateTime modifyDate
)
{}
