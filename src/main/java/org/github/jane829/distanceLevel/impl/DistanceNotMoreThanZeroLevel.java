package org.github.jane829.distanceLevel.impl;

import org.github.jane829.distanceLevel.DistanceLevel;
import org.springframework.stereotype.Component;

@Component
public class DistanceNotMoreThanZeroLevel extends DistanceLevel
{
    @Override
    public boolean check_distance_level(float distance)
    {
        return distance <= 0;
    }

    @Override
    public float calculate_total_price(float distance)
    {
        return 0;
    }
}
