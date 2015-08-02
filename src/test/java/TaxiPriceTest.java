import org.github.jane829.TaxiPrice;
import org.github.jane829.TotalPriceCalculater;
import org.github.jane829.distanceLevel.impl.DistanceMoreThanEightKilometersLevel;
import org.github.jane829.distanceLevel.impl.DistanceMoreThanTwoAndLessThanEightKilometersLevel;
import org.github.jane829.distanceLevel.impl.DistanceNotMoreThanTwoKilometersLevel;
import org.github.jane829.distanceLevel.impl.DistanceNotMoreThanZeroLevel;
import org.github.jane829.payrule.PayRule;
import org.github.jane829.payrule.impl.RoundRules;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TaxiPriceTest
{

    private TaxiPrice taxiPrice;

    private PayRule payRule;

    @Before
    public void setUp() throws Exception
    {
        payRule = new RoundRules();
        taxiPrice = new TaxiPrice(new RoundRules(), new TotalPriceCalculater(Arrays.asList(new DistanceNotMoreThanZeroLevel(),new DistanceNotMoreThanTwoKilometersLevel(),
                new DistanceMoreThanTwoAndLessThanEightKilometersLevel(), new DistanceMoreThanEightKilometersLevel())));
    }

    @Test
    public void shoud_pay_six_if_calculated_total_price_less_than_six_point_five()
    {
        // given
        float calculatedPrice = 6.4f;

        // when
        float totalPrice = payRule.shouldPay(calculatedPrice);

        // then
        assertThat(totalPrice, is(6.0f));
    }


    @Test
    public void shoud_pay_seven_if_calculated_total_price_is_six_point_five()
    {

        // given
        float calculatedPrice = 6.5f;

        // when
        float totalPrice = payRule.shouldPay(calculatedPrice);

        // then
        assertThat(totalPrice, is(7.0f));
    }

    @Test
    public void shoud_pay_six_if_calculated_price_is_six_point_nine_five()
    {
        // given
        float calculatedPrice = 6.95f;

        // when
        float totalPrice = payRule.shouldPay(calculatedPrice);

        // then
        assertThat(totalPrice, is(7.0f));
    }

    @Test
    public void shoud_pay_six_if_the_distance_is_two_km()
    {
        //given
        float distance = 2;

        //when
        float calculatedPrice = taxiPrice.calculateTotalPrice(distance);

        //then
        assertThat(calculatedPrice, is(6.0f));
    }

    @Test
    public void should_pay_six_if_the_distance_is_in_two_km()
    {
        // given
        float distance = 1.5f;

        // when
        float calculatedPrice = taxiPrice.calculateTotalPrice(distance);

        // then
        assertThat(calculatedPrice, is(6.0f));

    }

    @Test
    public void shoud_pay_zero_if_the_distance_is_zero()
    {
        // given
        float distance = 0;

        // when
        float calculatedPrice = taxiPrice.calculateTotalPrice(distance);

        // then
        assertThat(calculatedPrice, is(0f));

    }

    @Test
    public void shoud_pay_if_the_distance_is_eight_km()
    {
        // given
        float distance = 8f;

        // when
        float calculatedPrice = taxiPrice.calculateTotalPrice(distance);

        // then
        assertThat(calculatedPrice, is(15f));
    }

    @Test
    public void shoud_pay_if_the_disance_is_two_point_five()
    {
        // given
        float distance = 2.5f;

        // when
        float calculatedPrice = taxiPrice.calculateTotalPrice(distance);

        // then
        assertThat(calculatedPrice, is(7f));

    }

    @Test
    public void shoud_pay_if_the_distance_is_nine()
    {
        // given
        float distance = 9f;

        // when
        float calculcatedPrice = taxiPrice.calculateTotalPrice(distance);

        // then
        assertThat(calculcatedPrice, is(17f));

    }
}

