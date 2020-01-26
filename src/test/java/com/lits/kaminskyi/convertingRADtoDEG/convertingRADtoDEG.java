package com.lits.kaminskyi.convertingRADtoDEG;


import com.lits.calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.math.BigDecimal;

public class convertingRADtoDEG {

    private Calculator calculator = new Calculator();

    @Test(dataProvider = "RADtoDEG")
    public void testingRADToDEG (BigDecimal bd, BigDecimal result) {
        calculator.setValue(bd);
        calculator.convertToDEG();
        int compareResult = calculator.getCurrentAmount().compareTo(result);
        Assert.assertEquals(compareResult, 0);
    }

    @DataProvider
    public Object[][] RADtoDEG() {
        return new Object[][]
                {
                {BigDecimal.valueOf(4.5), BigDecimal.valueOf(257.83)},
                {BigDecimal.ZERO, BigDecimal.ZERO}
                };
    }
}