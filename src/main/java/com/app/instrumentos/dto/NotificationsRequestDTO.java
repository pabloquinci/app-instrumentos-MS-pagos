package com.app.instrumentos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NotificationsRequestDTO {
	
	private String action;
	private String api_version;
	private DataDTO data;
	private String date_created;
	private String id;
	private Boolean live_mode;
	private String type;
	private Integer user_id;
}
