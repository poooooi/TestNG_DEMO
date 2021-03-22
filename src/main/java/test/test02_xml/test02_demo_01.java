package test.test02_xml; /**
 * @program: TestNG_DEMO
 * @description: 通过testng.xml文件实现testNG
 * @author: poooooi
 * @create: 2021-03-15 15:27
 **/

import org.testng.annotations.Test;

public class test02_demo_01 {

    @Test
    public void testDemo02_01_HelloWorld(){
        System.out.println("testDemo02 - HelloWorld");
    }

    @Test
    public void testDemo02_01_HelloTestNG(){
        System.out.println("testDemo02 - HelloTestNG");
    }
}

