package org.by1337.bairx.util;

import junit.framework.TestCase;
import org.junit.Assert;

public class PlaceholderTest extends TestCase {
    public void testReplace() {
        PlaceholderableTest test = new PlaceholderableTest();
        Assert.assertEquals("message 456456456456456456456456456456456456456456123test, a321123456 bla bla bla 123", test.replace("message {qwerty}{qwerty}{test}test, {placeholder_123_123}{test1}{test}{test2} bla bla bla {test}"));
        Assert.assertEquals("123123123123123123123123", test.replace("{test}{test}{test}{test}{test}{test}{test}{test}"));
    }

    private static class PlaceholderableTest extends Placeholder {
        public PlaceholderableTest() {
            registerPlaceholder("{test}", () -> "123");
            registerPlaceholder("{test1}", () -> "321");
            registerPlaceholder("{test2}", () -> "456");
            registerPlaceholder("{qwerty}", () -> "456456456456456456456");
            registerPlaceholder("{placeholder_123_123}", () -> "a");
        }
    }
}