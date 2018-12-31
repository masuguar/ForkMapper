package tk.mybatis.mapper.annotation;


import tk.mybatis.mapper.inherit.InheritTableFormatter;
import tk.mybatis.mapper.inherit.InheritQueryDialect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface InheritTable {

    Class< ? extends InheritTableFormatter> formatter() ;

    InheritQueryDialect dialect() default InheritQueryDialect.POSTGRESSQL;

    String spliter() default "_";
}
