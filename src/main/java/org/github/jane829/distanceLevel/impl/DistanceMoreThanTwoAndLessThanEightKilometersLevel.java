package org.github.jane829.distanceLevel.impl;

import org.github.jane829.distanceLevel.DistanceLevel;
import org.springframework.stereotype.Component;

@Component
public class DistanceMoreThanTwoAndLessThanEightKilometersLevel extends DistanceLevel
{
    @Override
    public boolean check_distance_level(float distance)
    {
        return distance <= 8 && distance > 2;
    }

    @Override
    public float calculate_total_price(float distance)
    {
        return (float) ((distance - 2) * 1.5 + 6);
    }
}
