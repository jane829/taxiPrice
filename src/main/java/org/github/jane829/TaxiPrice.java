package org.github.jane829;

import org.github.jane829.payrule.PayRule;

public class TaxiPrice
{
    private static PayRule payRule;
    private final TotalPriceCalculater totalPriceCalculater;

    public TaxiPrice(PayRule payRule, TotalPriceCalculater totalPriceCalculater)
    {
        this.payRule = payRule;
        this.totalPriceCalculater = totalPriceCalculater;
    }

    public float calculateTotalPrice(float distance)
    {
        return payRule.shouldPay(totalPriceCalculater.calculateTotalPrice(distance));
    }


}
