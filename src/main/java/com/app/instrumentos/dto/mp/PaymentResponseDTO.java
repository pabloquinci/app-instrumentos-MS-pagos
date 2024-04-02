package com.app.instrumentos.dto.mp;

import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponseDTO {
	 	private Long id;
	    private String status;
	    private String detail;
}
