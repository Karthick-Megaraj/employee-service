package com.employee.service.details.entity;

import javax.persistence.Table;
import javax.xml.ws.soap.Addressing;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name = "address")
public class Address {
	
	private String area;
	
	private String district;
	
	private String state;
	
	private Long postalCode;

}
