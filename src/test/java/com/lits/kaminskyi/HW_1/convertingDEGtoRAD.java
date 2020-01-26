package com.lits.kaminskyi.HW_1;


import com.lits.calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.math.BigDecimal;

public class convertingDEGtoRAD {

    private Calculator calculator = new Calculator();

    @Test(dataProvider = "DEGtoRAD")
    public void testingDEGtoRAD (BigDecimal bd, BigDecimal result) {
        calculator.setValue(bd);
        calculator.convertToRAD();
        int compareResult = calculator.getCurrentAmount().compareTo(result);
        Assert.assertEquals(compareResult, 0);
    }

    @DataProvider
    public Object[][] DEGtoRAD() {
        return new Object[][]
                {
                        {BigDecimal.valueOf(0), BigDecimal.valueOf(0)},
                        {BigDecimal.valueOf(30), BigDecimal.valueOf(0.5235987755982988)}
                };
    }
}