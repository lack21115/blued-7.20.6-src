package com.tencent.cos.xml.model.tag.eventstreaming;

import java.util.Collection;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/ValidationUtils.class */
public class ValidationUtils {
    public static void assertAllAreNull(String str, Object... objArr) throws IllegalArgumentException {
        int length = objArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            if (objArr[i2] != null) {
                throw new IllegalArgumentException(str);
            }
            i = i2 + 1;
        }
    }

    public static int assertIsPositive(int i, String str) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(String.format("%s must be positive", str));
    }

    public static <T extends Collection<?>> T assertNotEmpty(T t, String str) throws IllegalArgumentException {
        assertNotNull(t, str);
        if (t.isEmpty()) {
            throw new IllegalArgumentException(String.format("%s cannot be empty", str));
        }
        return t;
    }

    public static <T> T[] assertNotEmpty(T[] tArr, String str) throws IllegalArgumentException {
        assertNotNull(tArr, str);
        if (tArr.length != 0) {
            return tArr;
        }
        throw new IllegalArgumentException(String.format("%s cannot be empty", str));
    }

    public static <T> T assertNotNull(T t, String str) throws IllegalArgumentException {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(String.format("%s cannot be null", str));
    }

    public static String assertStringNotEmpty(String str, String str2) throws IllegalArgumentException {
        assertNotNull(str, str2);
        if (str.isEmpty()) {
            throw new IllegalArgumentException(String.format("%s cannot be empty", str2));
        }
        return str;
    }
}
