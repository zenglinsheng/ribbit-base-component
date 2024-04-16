package com.bfxy.rabbit.task.annotation;

import com.bfxy.rabbit.task.autoconfigure.JobParserAutoConfigurartion;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(JobParserAutoConfigurartion.class)
public @interface EnableElasticJob {

}
