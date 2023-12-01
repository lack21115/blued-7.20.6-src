package c.t.m.g;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/b6.class */
public class b6 {
    public static String a(String str) {
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    public static boolean a(Object obj) {
        return obj == null;
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null && obj2 == null;
    }

    public static boolean a(Object obj, Object obj2, Object... objArr) {
        if (!a(objArr, obj2)) {
            return false;
        }
        int length = objArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (objArr[i2] != null) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static boolean b(Object obj) {
        return obj != null;
    }

    public static boolean b(Object obj, Object obj2) {
        return obj == null || obj2 == null;
    }
}
