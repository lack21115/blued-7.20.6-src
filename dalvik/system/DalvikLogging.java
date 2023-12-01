package dalvik.system;

import com.igexin.push.core.b;

/* loaded from: source-2895416-dex2jar.jar:dalvik/system/DalvikLogging.class */
public final class DalvikLogging {
    private DalvikLogging() {
    }

    public static String loggerNameToTag(String str) {
        String str2;
        if (str == null) {
            str2 = b.l;
        } else {
            int length = str.length();
            str2 = str;
            if (length > 23) {
                int lastIndexOf = str.lastIndexOf(".");
                return length - (lastIndexOf + 1) <= 23 ? str.substring(lastIndexOf + 1) : str.substring(str.length() - 23);
            }
        }
        return str2;
    }
}
