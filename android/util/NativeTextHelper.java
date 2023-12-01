package android.util;

import android.content.Context;

/* loaded from: source-9557208-dex2jar.jar:android/util/NativeTextHelper.class */
public class NativeTextHelper {
    public static final String getInternalLocalString(Context context, String str, int i, int i2) {
        return getLocalString(context, str, context.getPackageName(), i, i2);
    }

    public static final String getLocalString(Context context, String str, int i, int i2) {
        return getLocalString(context, str, "android", i, i2);
    }

    private static final String getLocalString(Context context, String str, String str2, int i, int i2) {
        String str3;
        String[] stringArray = context.getResources().getStringArray(i);
        String[] stringArray2 = context.getResources().getStringArray(i2);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            str3 = str;
            if (i4 >= stringArray.length) {
                break;
            } else if (stringArray[i4].equalsIgnoreCase(str)) {
                str3 = context.getString(context.getResources().getIdentifier(stringArray2[i4], "string", str2));
                break;
            } else {
                i3 = i4 + 1;
            }
        }
        return str3;
    }
}
