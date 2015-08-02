package org.github.jane829;

import org.github.jane829.payrule.PayRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner
{
    private static PayRule payRule;
    private final TotalPriceCalculater totalPriceCalculater;

    @Autowired
    public ApplicationRunner(PayRule payRule, TotalPriceCalculater totalPriceCalculater)
    {
        this.payRule = payRule;
        this.totalPriceCalculater = totalPriceCalculater;
    }

    public float calculateTotalPrice(float distance)
    {
        return payRule.shouldPay(totalPriceCalculater.calculateTotalPrice(distance));
    }


}
