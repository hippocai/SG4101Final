package com.ft9.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author CaiYicheng
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Menu {
	String name();
	String fatherName();
}
