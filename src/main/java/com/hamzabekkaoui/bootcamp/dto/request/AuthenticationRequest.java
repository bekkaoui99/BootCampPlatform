package com.hamzabekkaoui.bootcamp.dto.request;

import lombok.Builder;

@Builder
public record AuthenticationRequest(String mail , String password) {
}
