package org.github.jane829.core;


import org.github.jane829.ApplicationRunner;
import org.github.jane829.controller.DependencyConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.github.jane829")
public class SpringApplicationRunner
{
    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(DependencyConfiguration.class);
        ApplicationRunner applicationRunner = (ApplicationRunner) annotationConfigApplicationContext.getBean("applicationRunner");

        for (int i = 1; i < 101; i++) {
            float totalPrice = applicationRunner.calculateTotalPrice((float) i);
            System.out.println("distance="+i+", pay="+totalPrice);
        }
    }
}
