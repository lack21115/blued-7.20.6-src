package com.qiniu.android.utils;

import com.igexin.push.core.b;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/utils/StringUtils.class */
public final class StringUtils {
    public static String getAkAndScope(String str) {
        String[] split = str.split(":");
        String str2 = split[0];
        try {
            String str3 = new JSONObject(new String(UrlSafeBase64.decode(split[2]), "utf-8")).getString("scope").split(":")[0];
            return str2 + str3;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getBucket(String str) {
        try {
            return new JSONObject(new String(UrlSafeBase64.decode(str.split(":")[2]), "utf-8")).getString("scope").split(":")[0];
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().equals("");
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || "".equals(str);
    }

    public static String join(String[] strArr, String str) {
        int length;
        if (strArr == null) {
            return null;
        }
        int length2 = strArr.length;
        int length3 = (str == null || str.equals("")) ? 0 : str.length();
        if (length2 == 0) {
            length = 0;
        } else {
            length = ((strArr[0] == null ? 16 : strArr[0].length()) + length3) * length2;
        }
        StringBuilder sb = new StringBuilder(length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length2) {
                return sb.toString();
            }
            if (i2 > 0) {
                sb.append(str);
            }
            if (strArr[i2] != null) {
                sb.append(strArr[i2]);
            }
            i = i2 + 1;
        }
    }

    public static String jsonJoin(Long[] lArr) {
        return jsonJoin(longToString(lArr));
    }

    public static String jsonJoin(String[] strArr) {
        int length = strArr.length;
        if (strArr[0] == null) {
            strArr[0] = "";
        }
        StringBuilder sb = new StringBuilder((strArr[0].length() + 3) * length);
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                sb.append(',');
            }
            sb.append('\"');
            sb.append(strArr[i]);
            sb.append('\"');
        }
        return sb.toString();
    }

    public static String[] longToString(Long[] lArr) {
        int length = lArr.length;
        String[] strArr = new String[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return strArr;
            }
            try {
                strArr[i2] = String.valueOf(lArr[i2]);
            } catch (NumberFormatException e) {
                strArr[i2] = b.l;
            }
            i = i2 + 1;
        }
    }

    public static String strip(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            char charAt = str.charAt(i2);
            if (charAt > 31 && charAt < 127) {
                sb.append(charAt);
            }
            i = i2 + 1;
        }
    }

    public static byte[] toByteArray(Object obj) {
        byte[] bArr = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            objectOutputStream.close();
            bArr = byteArray;
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception e) {
            e.printStackTrace();
            return bArr;
        }
    }

    public static Object toObject(byte[] bArr) {
        Object obj;
        Object obj2 = null;
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            Object obj3 = null;
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                obj = objectInputStream.readObject();
                obj3 = obj;
                objectInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
                obj = obj3;
            }
            obj2 = obj;
            byteArrayInputStream.close();
            return obj;
        } catch (Exception e2) {
            e2.printStackTrace();
            return obj2;
        }
    }

    public static String upperCase(String str) {
        if (str.length() <= 0 || str == null) {
            return "";
        }
        char[] charArray = str.toCharArray();
        if (charArray[0] >= 'a' && charArray[0] <= 'z') {
            charArray[0] = (char) (charArray[0] - ' ');
        }
        return new String(charArray);
    }

    public static byte[] utf8Bytes(String str) {
        try {
            return str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
