package com.blued.android.framework.utils;

import android.content.Intent;
import android.util.Log;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/Logger.class */
public class Logger {
    private static boolean a = true;
    private static boolean b = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.framework.utils.Logger$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/Logger$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0041 -> B:27:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0045 -> B:25:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0049 -> B:23:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004d -> B:29:0x0035). Please submit an issue!!! */
        static {
            int[] iArr = new int[TYPE.values().length];
            a = iArr;
            try {
                iArr[TYPE.Verbose.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[TYPE.Info.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[TYPE.Debug.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[TYPE.Warn.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[TYPE.Error.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/Logger$TYPE.class */
    public enum TYPE {
        Verbose,
        Info,
        Debug,
        Warn,
        Error
    }

    private static String a() {
        Thread currentThread = Thread.currentThread();
        StackTraceElement stackTraceElement = currentThread.getStackTrace()[6];
        return "at " + stackTraceElement.toString() + " Thread[" + currentThread.getThreadGroup() + ":" + currentThread.getName() + ":" + currentThread.getId();
    }

    private static String a(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        if (b) {
            sb.append(a());
            sb.append("\n");
        }
        int length = objArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            Object obj = objArr[i2];
            if (obj == null) {
                sb.append("null");
            } else if (obj instanceof Intent) {
                sb.append(((Intent) obj).getExtras());
                sb.append("\n");
            } else if (obj instanceof Throwable) {
                sb.append(Log.getStackTraceString((Throwable) obj));
                sb.append("\n");
            } else {
                sb.append(obj.toString());
            }
            i = i2 + 1;
        }
    }

    private static void a(TYPE type, String str, String str2) {
        int i = AnonymousClass1.a[type.ordinal()];
        if (i == 1) {
            Log.v(str, str2);
        } else if (i == 2) {
            Log.i(str, str2);
        } else if (i == 3) {
            Log.d(str, str2);
        } else if (i == 4) {
            Log.w(str, str2);
        } else if (i != 5) {
        } else {
            Log.e(str, str2);
        }
    }

    private static void a(TYPE type, String str, Object... objArr) {
        String a2 = a(objArr);
        int length = a2.length();
        if (length <= 4000) {
            a(type, str, a2);
            return;
        }
        int i = length / 2000;
        int i2 = length % 2000 == 0 ? 0 : 1;
        int i3 = 0;
        int i4 = 1;
        while (i3 < length) {
            int i5 = i3 + 2000;
            if (i5 >= length) {
                i5 = length;
            }
            a(type, str, String.format("[%d/%d] %s", Integer.valueOf(i4), Integer.valueOf(i + i2), a2.substring(i3, i5)));
            i4++;
            i3 = i5;
        }
    }

    public static void a(String str, Object... objArr) {
        if (a) {
            a(TYPE.Verbose, str, objArr);
        }
    }

    public static void b(String str, Object... objArr) {
        if (a) {
            a(TYPE.Info, str, objArr);
        }
    }

    public static void c(String str, Object... objArr) {
        if (a) {
            a(TYPE.Debug, str, objArr);
        }
    }

    public static void d(String str, Object... objArr) {
        if (a) {
            a(TYPE.Warn, str, objArr);
        }
    }

    public static void e(String str, Object... objArr) {
        if (a) {
            a(TYPE.Error, str, objArr);
        }
    }
}
