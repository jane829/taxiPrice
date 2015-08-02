package org.github.jane829.distanceLevel.impl;

import org.github.jane829.distanceLevel.DistanceLevel;

public class DistanceNotMoreThanTwoKilometersLevel extends DistanceLevel
{
    private static final float PRICE_FOR_LESS_THAN_TWO_KILOMETER = 6f;

    @Override
    public boolean check_distance_level(float distance)
    {
        return distance <= 2 && distance > 0;
    }

    @Override
    public float calculate_total_price(float distance)
    {
        return PRICE_FOR_LESS_THAN_TWO_KILOMETER;
    }
}

