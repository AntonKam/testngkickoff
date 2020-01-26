package com.lits.kaminskyi.calculator;

import com.lits.calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class CalculatorParametrizedTest {

    private Calculator calculator = new Calculator();

    @Test(dataProvider = "dataAdd")
    public void testAddTwoValues(BigDecimal a, BigDecimal b, BigDecimal result) {
        calculator.setValue(a);
        calculator.add(b);

        Assert.assertEquals(calculator.getCurrentAmount(), result);

//        int compareResult = result.compareTo()
//                Assert.assertEquals();
    }
    @DataProvider /*(parallel = true) - коли ми хочемо запустити потоки паралельно*/
    public Object[][] dataAdd() {
        return new Object[][]{
                {BigDecimal.valueOf(1.5), BigDecimal.valueOf(1.5), BigDecimal.valueOf(3.0)},
                {BigDecimal.valueOf(-1.5), BigDecimal.valueOf(1.5), BigDecimal.valueOf(0.0)},
                {BigDecimal.valueOf(2.5), BigDecimal.ZERO, BigDecimal.valueOf(2.5)},
                {BigDecimal.valueOf(1.5), BigDecimal.valueOf(1.5), BigDecimal.valueOf(3.0)},
                {BigDecimal.valueOf(1000), BigDecimal.valueOf(1.5), BigDecimal.valueOf(1001.5)},
                {BigDecimal.valueOf(1.5), BigDecimal.valueOf(1.5), BigDecimal.valueOf(3.0)}
        };
    }


        @Test(dataProvider = "dataSubtract")
        public void testSubtractTwoValues (BigDecimal c, BigDecimal d, BigDecimal result2) {
            calculator.setValue(c);
            calculator.subtract(d);

            Assert.assertEquals(calculator.getCurrentAmount(), result2);
        }
        @DataProvider
        public Object[][] dataSubtract() {

            return new Object[][]{
                    {BigDecimal.valueOf(3.5), BigDecimal.valueOf(3.5), BigDecimal.valueOf(0.0)},
                    {BigDecimal.valueOf(-1.5), BigDecimal.valueOf(1.5), BigDecimal.valueOf(-3.0)},
                    {BigDecimal.valueOf(2.5), BigDecimal.ZERO, BigDecimal.valueOf(2.5)},
                    {BigDecimal.valueOf(3.5), BigDecimal.valueOf(1.5), BigDecimal.valueOf(2.0)},
                    {BigDecimal.valueOf(1000), BigDecimal.valueOf(1.5), BigDecimal.valueOf(998.5)},
                    {BigDecimal.valueOf(4.5), BigDecimal.valueOf(1.5), BigDecimal.valueOf(3.0)}
            };

        }
    }

