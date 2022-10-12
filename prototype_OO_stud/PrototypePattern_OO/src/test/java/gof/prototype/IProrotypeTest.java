package gof.prototype;

import org.junit.Test;

import static org.junit.Assert.*;

public class IProrotypeTest
{
    @Test
    public void shallowCloneTest()
    {
        Car car = new Car("A6", 1.9, 130);
        Car shallowCar = car.shallowClone();
        assertEquals(car, shallowCar);
        assertSame(car, shallowCar);
    }

    @Test
    public void deepCloneTest()
    {
        Car car = new Car("A6", 1.9, 130);
        Car deepCar = car.deepClone();
        assertEquals(car, deepCar);
        assertNotSame(car, deepCar);
        assertNotSame(car.engine, deepCar.engine);
    }
}
