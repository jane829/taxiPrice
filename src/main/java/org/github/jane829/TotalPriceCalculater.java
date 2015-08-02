package org.github.jane829;

import org.github.jane829.distanceLevel.DistanceLevel;

import java.util.List;

public class TotalPriceCalculater
{
    private List<DistanceLevel> distanceLevels;

    public TotalPriceCalculater(List<DistanceLevel> distanceLevels)
    {
        this.distanceLevels = distanceLevels;
    }

    public float calculateTotalPrice(float distance)
    {

        for (DistanceLevel distanceLevel : distanceLevels) {

            if (distanceLevel.check_distance_level(distance)) {
                return distanceLevel.calculate_total_price(distance);
            }
        }

        return 0;
    }

}