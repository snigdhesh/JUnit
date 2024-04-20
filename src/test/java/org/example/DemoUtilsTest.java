package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeAll
    static void executeBeforeAll(){
        System.out.println("Excecuted @BeforeAll");
    }

    @AfterAll
    static void executeAfterAll(){
        System.out.println("Excecuted @AfterAll");
    }


    @BeforeEach
    void setupDemoUtils(){
        demoUtils = new DemoUtils();
        System.out.println("Excecuted @BeforeEach");
    }

    @AfterEach
    void cleanResources(){
        System.out.println("Excecuted @AfterEach");
    }


    @Test
    void testEqualsAndNotEquals(){
        System.out.println("Running test testEqualsAndNotEquals");
        int expected = 6;
        int actual = demoUtils.add(1,5);
        assertEquals(expected,actual,"Unexpected result");
    }

    @Test
    void testNullAndNotNull(){
        System.out.println("Running test testNullAndNotNull");
        String str1 = null;
        String str2 = "luv2code";
        assertNull(demoUtils.checkNull(str1),"Object should be null");
        assertNotNull(demoUtils.checkNull(str2),"Object shouldn't be null");
    }

}
