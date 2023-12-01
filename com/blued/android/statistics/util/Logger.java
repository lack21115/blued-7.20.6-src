package com.blued.android.statistics.util;

import android.util.Log;
import com.igexin.push.core.b;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/util/Logger.class */
public class Logger {

    /* renamed from: a  reason: collision with root package name */
    private String f18727a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.statistics.util.Logger$1  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/util/Logger$1.class */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f18728a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0041 -> B:27:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0045 -> B:25:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0049 -> B:23:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004d -> B:29:0x0035). Please submit an issue!!! */
        static {
            int[] iArr = new int[TYPE.values().length];
            f18728a = iArr;
            try {
                iArr[TYPE.Verbose.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18728a[TYPE.Info.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18728a[TYPE.Debug.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f18728a[TYPE.Warn.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f18728a[TYPE.Error.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/util/Logger$TYPE.class */
    public enum TYPE {
        Verbose,
        Info,
        Debug,
        Warn,
        Error
    }

    public Logger(String str) {
        this.f18727a = str;
    }

    private void a(TYPE type, String str) {
        int i = AnonymousClass1.f18728a[type.ordinal()];
        if (i == 1) {
            Log.v(this.f18727a, str);
        } else if (i == 2) {
            Log.i(this.f18727a, str);
        } else if (i == 3) {
            Log.d(this.f18727a, str);
        } else if (i == 4) {
            Log.w(this.f18727a, str);
        } else if (i != 5) {
        } else {
            Log.e(this.f18727a, str);
        }
    }

    private void a(TYPE type, Object... objArr) {
        String f = f(objArr);
        int length = f.length();
        if (length <= 4000) {
            a(type, f);
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
            a(type, String.format("[%d/%d] %s", Integer.valueOf(i4), Integer.valueOf(i + i2), f.substring(i3, i5)));
            i4++;
            i3 = i5;
        }
    }

    private static String f(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        int length = objArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            Object obj = objArr[i2];
            if (obj == null) {
                sb.append(b.l);
            } else if (obj instanceof Throwable) {
                sb.append(Log.getStackTraceString((Throwable) obj));
                sb.append("\n");
            } else {
                sb.append(obj.toString());
            }
            i = i2 + 1;
        }
    }

    public void a(Object... objArr) {
        a(TYPE.Verbose, objArr);
    }

    public void b(Object... objArr) {
        a(TYPE.Info, objArr);
    }

    public void c(Object... objArr) {
        a(TYPE.Debug, objArr);
    }

    public void d(Object... objArr) {
        a(TYPE.Warn, objArr);
    }

    public void e(Object... objArr) {
        a(TYPE.Error, objArr);
    }
}
