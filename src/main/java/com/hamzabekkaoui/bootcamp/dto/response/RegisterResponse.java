package com.hamzabekkaoui.bootcamp.dto.response;

import lombok.Builder;

@Builder
public record RegisterResponse(String userName , String mail , String phoneNumber) {
}
