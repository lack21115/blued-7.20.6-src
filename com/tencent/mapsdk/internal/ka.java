package com.tencent.mapsdk.internal;

import android.content.Context;
import android.util.Log;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ka.class */
public class ka {

    /* renamed from: a  reason: collision with root package name */
    private static final String f37585a = "LibraryLoader";
    public static final String[] b = {mi.f37649a, "txnavengine"};

    public static void a(Context context) {
        String[] strArr = b;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            a(context, strArr[i2]);
            i = i2 + 1;
        }
    }

    public static void a(Context context, String str) {
        try {
            System.loadLibrary(str);
            if (Log.isLoggable(f37585a, 4)) {
                Log.i(f37585a, "loadLibary:" + str + "  successful");
            }
        } catch (UnsatisfiedLinkError e) {
            boolean b2 = la.b(context, str);
            if (Log.isLoggable(f37585a, 4)) {
                Log.i(f37585a, "loadLibary:" + str + " result:" + b2);
            }
        }
    }
}
