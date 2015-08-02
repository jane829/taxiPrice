package org.github.jane829.distanceLevel.impl;

import org.github.jane829.distanceLevel.DistanceLevel;

public class DistanceMoreThanEightKilometersLevel extends DistanceLevel
{
    @Override
    public boolean check_distance_level(float distance)
    {
        return distance > 8;
    }

    @Override
    public float calculate_total_price(float distance)
    {
        return (float) ((distance - 8) * (1.5 * 1.5) + 6 * 1.5 + 6);
    }
}
