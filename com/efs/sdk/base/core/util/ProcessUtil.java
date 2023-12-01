package com.efs.sdk.base.core.util;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/util/ProcessUtil.class */
public class ProcessUtil {

    /* renamed from: a  reason: collision with root package name */
    private static String f21784a;
    private static List<Integer> b;

    /* renamed from: c  reason: collision with root package name */
    private static long f21785c = -1;

    public static String getCurrentProcessName() {
        String str = f21784a;
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = getProcessName(Process.myPid());
            f21784a = str2;
        }
        return str2;
    }

    public static String getProcessName(int i) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + i + "/cmdline")));
        } catch (Throwable th) {
            th = th;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                int read = bufferedReader.read();
                if (read <= 0) {
                    sb.trimToSize();
                    String sb2 = sb.toString();
                    try {
                        bufferedReader.close();
                        return sb2;
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                        return sb2;
                    }
                }
                sb.append((char) read);
            }
        } catch (Throwable th3) {
            bufferedReader2 = bufferedReader;
            th = th3;
            try {
                Log.e("efs.base", "get process name error", th);
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                        return "";
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                        return "";
                    }
                }
                return "";
            } catch (Throwable th5) {
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Throwable th6) {
                        th6.printStackTrace();
                    }
                }
                throw th5;
            }
        }
    }

    public static boolean isProcessExist(Context context, String str) {
        try {
            int parseInt = Integer.parseInt(str);
            boolean z = false;
            if (b != null) {
                if (b.isEmpty()) {
                    z = false;
                } else {
                    z = false;
                    if (f21785c > 0) {
                        z = System.currentTimeMillis() - f21785c <= 600000;
                    }
                }
            }
            if (!z) {
                if (b != null) {
                    b.clear();
                } else {
                    b = new ArrayList();
                }
                if (!TextUtils.isEmpty(getProcessName(Process.myPid()))) {
                    b.add(Integer.valueOf(Process.myPid()));
                }
                if (!TextUtils.isEmpty(getProcessName(parseInt))) {
                    b.add(Integer.valueOf(parseInt));
                }
                f21785c = System.currentTimeMillis();
            }
            return b.contains(Integer.valueOf(parseInt));
        } catch (Throwable th) {
            Log.e("efs.base", "Process exist judge error", th);
            return true;
        }
    }

    public static int myPid() {
        return Process.myPid();
    }
}
