package com.hamzabekkaoui.bootcamp.dto.response;
import lombok.Builder;

@Builder
public record AuthenticationResponse(String userName  , String jwt ) {
}
