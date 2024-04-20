package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeEach
    void setupDemoUtils(){
        demoUtils = new DemoUtils();
    }


    @Test
    @DisplayName("Check whether value is equal or not")
    void testEqualsAndNotEquals(){
        int expected = 6;
        int actual = demoUtils.add(1,5);
        assertEquals(expected,actual,"Unexpected result");
    }

    @Test
    @DisplayName("Check whether value is null or not")
    void testNullAndNotNull(){
        String str1 = null;
        String str2 = "luv2code";
        assertNull(demoUtils.checkNull(str1),"Object should be null");
        assertNotNull(demoUtils.checkNull(str2),"Object shouldn't be null");
    }

}
