package test.test01_xml; /**
 * @program: TestNG_DEMO
 * @description: 通过testng.xml文件实现testNG
 * @author: poooooi
 * @create: 2021-03-15 15:27
 **/

import org.testng.annotations.Test;

public class test01_demo {

    @Test
    public void test01_demo_HelloWorld(){
        System.out.println("testDemo01 - HelloWorld");
    }

    @Test
    public void test01_demo_HelloTestNG(){
        System.out.println("testDemo01 - HelloTestNG");
    }
}

