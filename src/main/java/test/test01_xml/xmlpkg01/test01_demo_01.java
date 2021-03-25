package test.test01_xml.xmlpkg01; /**
 * @program: TestNG_DEMO
 * @description: 通过testng.xml文件实现testNG
 * @author: poooooi
 * @create: 2021-03-15 15:27
 **/

import org.testng.annotations.Test;

public class test01_demo_01 {
    @Test
    public void test01_demo01_HelloWorld(){
        System.out.println("test01_Demo01 - HelloWorld");
    }

    @Test
    public void test01_demo01_HelloTestNG(){
        System.out.println("test01_Demo01 - HelloTestNG");
    }
}

