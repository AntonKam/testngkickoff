package com.lits.kaminskyi.HW_1;


import com.lits.calculator.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class operationHistory {

    @Test(description = "Operations history: add, subtract", dataProvider = "OperationData")
    public void testOperationsHistoryAddSubtract(BigDecimal a, BigDecimal b) {
        Calculator calculator = new Calculator();
        calculator.setValue(a);
        BigDecimal c = calculator.add(b);
        calculator.subtract(b);
        List<Operation> expectedResult = Arrays.asList(new AddOperation(a, b), new SubtractOperation(c, b));
        Assert.assertEquals(calculator.getOperationsHistory().toString(), expectedResult.toString());
    }

    @Test(dataProvider = "OperationData", description = "Operations history: multiply, divide")
    public void testOperationHistoryMultiplySubtract(BigDecimal a, BigDecimal b) {
        Calculator calculator = new Calculator();
        calculator.setValue(a);
        BigDecimal c = calculator.multiply(b);
        calculator.divide(b);
        List<Operation> expectedResult = Arrays.asList(new MultiplyOperation(a, b), new DivideOperation(c, b));
        Assert.assertEquals(calculator.getOperationsHistory().toString(), expectedResult.toString());
    }

    @Test(dataProvider = "OperationData", description = "Operations history: DEG to RAD, RAD to DEG")
    public void testOperationHistoryConversion(BigDecimal a, BigDecimal b) {
        Calculator calculator = new Calculator();
        calculator.setValue(a);
        calculator.convertToDEG();
        calculator.setValue(b);
        calculator.convertToRAD();

        Assert.assertTrue(calculator.getOperationsHistory().get(0) instanceof RadToDegOperation);
        Assert.assertTrue(calculator.getOperationsHistory().get(1) instanceof DedToRadOperation);
    }

    @DataProvider
    public Object[][] OperationData(Method testMethod) {
        return new Object[][]{
                {BigDecimal.valueOf(5), BigDecimal.valueOf(2)}
        };
    }
}
