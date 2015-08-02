package org.github.jane829.payrule.impl;

import org.github.jane829.payrule.PayRule;

public class RoundRules extends PayRule
{
    @Override
    public float shouldPay(float calculatedPrice)
    {
        return Math.round(calculatedPrice);
    }
}
