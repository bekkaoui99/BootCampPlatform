package com.hamzabekkaoui.bootcamp.dto.request;

import lombok.Builder;

@Builder
public record RegisterRequest(String userName , String mail , String phoneNumber , String password , String confirmationPassword ) {
}
