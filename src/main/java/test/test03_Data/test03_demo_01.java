package test.test03_Data;

import jxl.read.biff.BiffException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelUtil;

import java.io.IOException;
import java.util.HashMap;

/**
 * @program: TestNG_DEMO
 * @description: 实现数据驱动，读取Excel
 * @author: poooooi
 * @create: 2021-03-21 22:49
 **/

public class test03_demo_01 {
    @DataProvider(name = "num")
    public Object[][] Numbers() throws BiffException, IOException {
        ExcelUtil e = new ExcelUtil("testdata", "calculator");
        return e.getExcelData();
    }

    @Test(dataProvider = "num")
    public void testAdd(HashMap<String, String> data) {
        System.out.println(data.toString());
        float num1 = Float.parseFloat(data.get("num1"));
        float num2 = Float.parseFloat(data.get("num2"));
        float expectedResult = Float.parseFloat(data.get("result"));

        System.out.println("num1:" + num1);
        System.out.println("num2:" + num2);
        System.out.println("expectedResult:" + expectedResult);
    }

}
