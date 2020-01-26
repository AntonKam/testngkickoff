package com.lits.kaminskyi.HW_1;

import com.lits.calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class operationRevert {

    @Test(dataProvider = "RevertData")
    public void testingRevert(BigDecimal a, BigDecimal b, BigDecimal result){
        Calculator calculator = new Calculator();
        calculator.setValue(a);
        calculator.multiply(b);
        calculator.subtract(b);
        calculator.revert();
        Assert.assertEquals(calculator.getCurrentAmount(), result);
    }

    @DataProvider
    public Object[][] RevertData(){
        return new Object[][]{
                {BigDecimal.valueOf(5), BigDecimal.valueOf(5), BigDecimal.valueOf(25)}
        };
    }
}
