package com.nameless.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class CatVo implements Serializable{

	/**
	 * spring validator 
	 */
	private static final long serialVersionUID = 7949803427462730538L;

	private String color ;
}
