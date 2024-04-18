package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DemoUtilsTest {

    @Test
    void testEqualsAndNotEquals(){
        DemoUtils demoUtils=new DemoUtils();
        int expected = 6;
        int actual = demoUtils.add(1,5);
        assertEquals(expected,actual,"Unexpected result");
    }

    @Test
    void testNullAndNotNull(){
        DemoUtils demoUtils=new DemoUtils();
        String str1 = null;
        String str2 = "luv2code";
        assertNull(demoUtils.checkNull(str1),"Object should be null");
        assertNotNull(demoUtils.checkNull(str2),"Object shouldn't be null");
    }

}
