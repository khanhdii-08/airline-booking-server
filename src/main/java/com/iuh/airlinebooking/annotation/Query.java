package com.iuh.airlinebooking.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Query {

	String propName() default "";

	/** 
	 * copare type
	 * @return
	 */
	Type type() default Type.EQUAL;

	/**
	 * The attribute name of the connection query, such as dept in the User class
	 */
	String joinName() default "";

	/**
	 * Default left connection
	 */
	Join join() default Join.LEFT;

	/**
	 * Multi-field fuzzy search, only supports String type fields, multiple
	 * separated by commas, such as @Query(blurry = "email,username")
	 */
	String blurry() default "";

	enum Type {
		EQUAL, NOT_EQUAL, 
		GREATER_THAN, LESS_THAN,
		LESS_THAN_NQ,
		INNER_LIKE, LEFT_LIKE, RIGHT_LIKE, 
		/**
		 * Like with remove accent
		 */
		LIKE_W_NACCENT,
		IN, NOT_IN, 
		BETWEEN,
		NOT_NULL, IS_NULL
	}

	/**
	 * Suitable for simple connection query, please customize the annotation for
	 * complex ones, or use sql query
	 * 
	 * @author Zheng Jie
	 */
	enum Join {
		LEFT, RIGHT, INNER
	}
}
