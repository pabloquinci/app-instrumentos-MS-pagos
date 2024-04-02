package com.app.instrumentos.dto.mp;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardPaymentDTO {
	 	@NotNull
	    private String token;

	    private String issuerId;

	    @NotNull
	    private String paymentMethodId;

	    @NotNull
	    private BigDecimal transactionAmount;

	    @NotNull
	    private Integer installments;

	    @NotNull
	    @JsonProperty("description")
	    private String productDescription;

	    @NotNull
	    private PayerDTO payer;
}
