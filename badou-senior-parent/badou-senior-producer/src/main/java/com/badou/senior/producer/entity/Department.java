package com.badou.senior.producer.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department implements Serializable {

	private static final long serialVersionUID = -5608719557656666534L;
	
	private Integer deptId;
	private String deptName;
	private String description;
}
