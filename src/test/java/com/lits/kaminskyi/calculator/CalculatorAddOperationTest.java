package com.lits.kaminskyi.calculator;

import com.lits.calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class CalculatorAddOperationTest
{
    private Calculator calculator = new Calculator();

    @Test (expectedExceptions = {AssertionError.class})
    public void testExpected()
    {
        calculator.reset();
        calculator.setValue(BigDecimal.valueOf(20.0));

        Assert.assertEquals(calculator.getCurrentAmount(), BigDecimal.ZERO);
    }

    @Test  (description = "Verify that add operation is being performed correctly")

    public void testAdd () {
        BigDecimal a = BigDecimal.valueOf(0.1);
        BigDecimal b = BigDecimal.valueOf(0.2);

        calculator.setValue(a);

        Assert.assertEquals(calculator.getCurrentAmount(), a);

        calculator.add(b);

        Assert.assertEquals(calculator.getCurrentAmount(), BigDecimal.valueOf(0.3));

    }
        @Test
        public void testSubtract () {
        BigDecimal e = BigDecimal.valueOf(0.4);
        BigDecimal f = BigDecimal.valueOf(0.2);

        calculator.setValue(e);

        Assert.assertEquals(calculator.getCurrentAmount(), e);

        calculator.subtract(f);

        Assert.assertEquals(calculator.getCurrentAmount(), BigDecimal.valueOf(0.2));
      }


    @Test
    public void testMultiply() {
        BigDecimal c = BigDecimal.valueOf(10);
        BigDecimal d = BigDecimal.valueOf(2);

        calculator.setValue(c);

        Assert.assertEquals(calculator.getCurrentAmount(), c);

        calculator.multiply(d);

        Assert.assertEquals(calculator.getCurrentAmount(), BigDecimal.valueOf(20));
    }


    @Test
    public void testDivide() {


        BigDecimal g = BigDecimal.valueOf(10);
        BigDecimal l = BigDecimal.valueOf(5);

        calculator.setValue(g);

        Assert.assertEquals(calculator.getCurrentAmount(), g);

        calculator.divide(l);

        Assert.assertEquals(calculator.getCurrentAmount(), BigDecimal.valueOf(2));

    }
}
