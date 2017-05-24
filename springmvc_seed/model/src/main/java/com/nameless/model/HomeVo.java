package com.nameless.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class HomeVo implements Serializable{

	/**
	 * 	hibernate validator
		表 1. Bean Validation 规范内嵌的约束注解定义  
		约束注解名称  约束注解说明  
		@Null           验证对象是否为空  
		@NotNull    验证对象是否为非空  
		@AssertTrue     验证 Boolean 对象是否为 true  
		@AssertFalse    验证 Boolean 对象是否为 false  
		@Min            验证 Number 和 String 对象是否大等于指定的值  
		@Max            验证 Number 和 String 对象是否小等于指定的值  
		@DecimalMin     验证 Number 和 String 对象是否大等于指定的值，小数存在精度  
		@DecimalMax     验证 Number 和 String 对象是否小等于指定的值，小数存在精度  
		@Size           验证对象（Array,Collection,Map,String）长度是否在给定的范围之内  
		@Digits     验证 Number 和 String 的构成是否合法  
		@Past           验证 Date 和 Calendar 对象是否在当前时间之前  
		@Future     验证 Date 和 Calendar 对象是否在当前时间之后  
		@Pattern    验证 String 对象是否符合正则表达式的规则 
	 */
	private static final long serialVersionUID = 5503307241364472713L;

	/**
	 * 输入参数 {"version":null,"host":"192.168.168.1"} , version 和 host 属性必须存在，不存在@requestbody报错。
	 */
	@NotNull(message="version is required !")
	private String version;
	
	@NotNull(message="host is required !")
	private String host;
	
}
