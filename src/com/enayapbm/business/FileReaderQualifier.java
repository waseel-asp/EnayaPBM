package com.enayapbm.business;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

import com.enayapbm.business.PbmDataOperations.FileType;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.TYPE,
		ElementType.PARAMETER })
public @interface FileReaderQualifier{
	FileType value();
}
