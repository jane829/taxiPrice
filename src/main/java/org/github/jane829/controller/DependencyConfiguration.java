package org.github.jane829.controller;

import org.github.jane829.ApplicationRunner;
import org.github.jane829.TotalPriceCalculater;
import org.github.jane829.payrule.PayRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@ComponentScan(basePackages = "org.github.jane829")
@RequestMapping
public class DependencyConfiguration
{
    @Bean
    public ApplicationRunner applicationRunner(PayRule payrule, TotalPriceCalculater toalCalculator)
    {

        return new ApplicationRunner(payrule, toalCalculator);
    }

}
