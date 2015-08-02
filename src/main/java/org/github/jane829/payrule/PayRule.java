package org.github.jane829.payrule;

public abstract class PayRule
{
    public abstract float shouldPay(float calculatedPrice);
}