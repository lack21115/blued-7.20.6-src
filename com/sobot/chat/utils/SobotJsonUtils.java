package com.sobot.chat.utils;

import com.igexin.push.core.b;
import java.util.Collection;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/SobotJsonUtils.class */
public class SobotJsonUtils {
    static String array2Json(Object[] objArr) {
        if (objArr.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(objArr.length << 4);
        sb.append('[');
        int length = objArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                sb.setCharAt(sb.length() - 1, ']');
                return sb.toString();
            }
            sb.append(toJson(objArr[i2]));
            sb.append(',');
            i = i2 + 1;
        }
    }

    static String boolean2Json(Boolean bool) {
        return bool.toString();
    }

    static String booleanArray2Json(boolean[] zArr) {
        if (zArr.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(zArr.length << 4);
        sb.append('[');
        int length = zArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                sb.setCharAt(sb.length() - 1, ']');
                return sb.toString();
            }
            sb.append(Boolean.toString(zArr[i2]));
            sb.append(',');
            i = i2 + 1;
        }
    }

    static String byteArray2Json(byte[] bArr) {
        if (bArr.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(bArr.length << 4);
        sb.append('[');
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                sb.setCharAt(sb.length() - 1, ']');
                return sb.toString();
            }
            sb.append(Byte.toString(bArr[i2]));
            sb.append(',');
            i = i2 + 1;
        }
    }

    static String collection2Json(Collection<Object> collection) {
        return toJson(collection.toArray());
    }

    static String doubleArray2Json(double[] dArr) {
        if (dArr.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(dArr.length << 4);
        sb.append('[');
        int length = dArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                sb.setCharAt(sb.length() - 1, ']');
                return sb.toString();
            }
            sb.append(Double.toString(dArr[i2]));
            sb.append(',');
            i = i2 + 1;
        }
    }

    static String floatArray2Json(float[] fArr) {
        if (fArr.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(fArr.length << 4);
        sb.append('[');
        int length = fArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                sb.setCharAt(sb.length() - 1, ']');
                return sb.toString();
            }
            sb.append(Float.toString(fArr[i2]));
            sb.append(',');
            i = i2 + 1;
        }
    }

    static String intArray2Json(int[] iArr) {
        if (iArr.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(iArr.length << 4);
        sb.append('[');
        int length = iArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                sb.setCharAt(sb.length() - 1, ']');
                return sb.toString();
            }
            sb.append(Integer.toString(iArr[i2]));
            sb.append(',');
            i = i2 + 1;
        }
    }

    static String longArray2Json(long[] jArr) {
        if (jArr.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(jArr.length << 4);
        sb.append('[');
        int length = jArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                sb.setCharAt(sb.length() - 1, ']');
                return sb.toString();
            }
            sb.append(Long.toString(jArr[i2]));
            sb.append(',');
            i = i2 + 1;
        }
    }

    static String map2Json(Map<String, Object> map) {
        if (map.isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(map.size() << 4);
        sb.append('{');
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            sb.append('\"');
            sb.append(str);
            sb.append('\"');
            sb.append(':');
            sb.append(toJson(obj));
            sb.append(',');
        }
        sb.setCharAt(sb.length() - 1, '}');
        return sb.toString();
    }

    static String number2Json(Number number) {
        return number.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x018f, code lost:
        if (r8 != false) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String object2Json(java.lang.Object r5) {
        /*
            Method dump skipped, instructions count: 405
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.utils.SobotJsonUtils.object2Json(java.lang.Object):java.lang.String");
    }

    static String shortArray2Json(short[] sArr) {
        if (sArr.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(sArr.length << 4);
        sb.append('[');
        int length = sArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                sb.setCharAt(sb.length() - 1, ']');
                return sb.toString();
            }
            sb.append(Short.toString(sArr[i2]));
            sb.append(',');
            i = i2 + 1;
        }
    }

    static String string2Json(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 20);
        sb.append('\"');
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                sb.append('\"');
                return sb.toString();
            }
            char charAt = str.charAt(i2);
            if (charAt == '\f') {
                sb.append("\\f");
            } else if (charAt == '\r') {
                sb.append("\\r");
            } else if (charAt == '\"') {
                sb.append("\\\"");
            } else if (charAt == '/') {
                sb.append("\\/");
            } else if (charAt != '\\') {
                switch (charAt) {
                    case '\b':
                        sb.append("\\b");
                        continue;
                    case '\t':
                        sb.append("\\t");
                        continue;
                    case '\n':
                        sb.append("\\n");
                        continue;
                    default:
                        sb.append(charAt);
                        continue;
                }
            } else {
                sb.append("\\\\");
            }
            i = i2 + 1;
        }
    }

    public static String toJson(Object obj) {
        if (obj == null) {
            return b.l;
        }
        if (obj instanceof String) {
            return string2Json((String) obj);
        }
        if (obj instanceof Boolean) {
            return boolean2Json((Boolean) obj);
        }
        if (obj instanceof Number) {
            return number2Json((Number) obj);
        }
        if (obj instanceof Map) {
            return map2Json((Map) obj);
        }
        if (obj instanceof Collection) {
            return collection2Json((Collection) obj);
        }
        if (obj instanceof Object[]) {
            return array2Json((Object[]) obj);
        }
        if (obj instanceof int[]) {
            return intArray2Json((int[]) obj);
        }
        if (obj instanceof boolean[]) {
            return booleanArray2Json((boolean[]) obj);
        }
        if (obj instanceof long[]) {
            return longArray2Json((long[]) obj);
        }
        if (obj instanceof float[]) {
            return floatArray2Json((float[]) obj);
        }
        if (obj instanceof double[]) {
            return doubleArray2Json((double[]) obj);
        }
        if (obj instanceof short[]) {
            return shortArray2Json((short[]) obj);
        }
        if (obj instanceof byte[]) {
            return byteArray2Json((byte[]) obj);
        }
        if (obj instanceof Object) {
            return object2Json(obj);
        }
        throw new RuntimeException("不支持的类型: " + obj.getClass().getName());
    }
}
