package com.soft.blued.tinker.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Environment;
import android.os.StatFs;
import com.kuaishou.weapon.p0.an;
import com.tencent.tinker.lib.util.TinkerLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/tinker/util/Utils.class */
public class Utils {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f16097a = false;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/tinker/util/Utils$ScreenState.class */
    public static class ScreenState {

        /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/tinker/util/Utils$ScreenState$IOnScreenOff.class */
        public interface IOnScreenOff {
            void a();
        }

        public ScreenState(Context context, final IOnScreenOff iOnScreenOff) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
            context.registerReceiver(new BroadcastReceiver() { // from class: com.soft.blued.tinker.util.Utils.ScreenState.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context2, Intent intent) {
                    IOnScreenOff iOnScreenOff2;
                    String action = intent == null ? "" : intent.getAction();
                    TinkerLog.i("Tinker.Utils", "ScreenReceiver action [%s] ", action);
                    if (Intent.ACTION_SCREEN_OFF.equals(action) && (iOnScreenOff2 = iOnScreenOff) != null) {
                        iOnScreenOff2.a();
                    }
                    context2.unregisterReceiver(this);
                }
            }, intentFilter);
        }
    }

    public static int a(long j, int i) {
        if (a()) {
            return -20;
        }
        if (i < 45) {
            return -22;
        }
        return !a(j) ? -21 : 0;
    }

    private static String a(String str) {
        char[] charArray;
        int i;
        boolean z;
        if (str == null || (charArray = str.toCharArray()) == null) {
            return null;
        }
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= charArray.length) {
                z = false;
                break;
            } else if (charArray[i] > 127) {
                charArray[i] = 0;
                z = true;
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (z) {
            str = new String(charArray, 0, i);
        }
        return str;
    }

    public static void a(boolean z) {
        f16097a = z;
    }

    public static boolean a() {
        return false;
    }

    @Deprecated
    public static boolean a(long j) {
        long j2;
        long j3;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            j2 = statFs.getAvailableBlocks() * statFs.getBlockSize();
            try {
                j3 = statFs.getBlockCount() * statFs.getBlockSize();
            } catch (Exception e) {
                j3 = 0;
                return j3 == 0 ? false : false;
            }
        } catch (Exception e2) {
            j2 = 0;
        }
        if (j3 == 0 && j2 > j) {
            return true;
        }
    }

    public static boolean a(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            String className = stackTrace[i2].getClassName();
            if (className != null && className.contains(an.b)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static String b(Throwable th) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        while (th.getCause() != null) {
            try {
                th = th.getCause();
            } catch (Throwable th2) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                throw th2;
            }
        }
        th.printStackTrace(printStream);
        String a2 = a(byteArrayOutputStream.toString());
        try {
            byteArrayOutputStream.close();
            return a2;
        } catch (IOException e2) {
            e2.printStackTrace();
            return a2;
        }
    }

    public static boolean b() {
        return f16097a;
    }
}
