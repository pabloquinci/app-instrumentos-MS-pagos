package com.app.instrumentos.dto.mp;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PayerIdentificationDTO {
	@NotNull
    private String type;

    @NotNull
    private String number;
}
