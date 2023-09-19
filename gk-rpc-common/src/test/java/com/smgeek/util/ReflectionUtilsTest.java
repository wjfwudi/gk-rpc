package com.smgeek.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReflectionUtilsTest {

    @Test
    public void newInstance() {
        TestClass t = ReflectionUtils.newInstance(TestClass.class);
        Assert.assertNotNull(t);
    }

    @Test
    public void getPublicMethods() {
    }

    @Test
    public void invoke() {
    }
}