package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * DisplayNameGenerator has types
 * Simple : Just takes method name without parenthesis
 * ReplaceUnderscores : Replaces underscores in method name, then takes method name without parenthesis
 * IndicativeSentences: Takes className, and methodName with parenthesis
 *
 */
@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)

class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeEach
    void setupDemoUtils(){
        demoUtils = new DemoUtils();
    }


    @Test
    void testEqualsAndNotEquals(){
        int expected = 6;
        int actual = demoUtils.add(1,5);
        assertEquals(expected,actual,"Unexpected result");
    }

    @Test
    void testNullAndNotNull(){
        String str1 = null;
        String str2 = "luv2code";
        assertNull(demoUtils.checkNull(str1),"Object should be null");
        assertNotNull(demoUtils.checkNull(str2),"Object shouldn't be null");
    }

}
