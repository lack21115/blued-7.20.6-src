package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import java.io.BufferedReader;
import java.io.FileReader;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/ab.class */
public class ab {
    public static String a() {
        BufferedReader bufferedReader;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/status"));
            while (true) {
                try {
                    readLine = bufferedReader.readLine();
                    if (!readLine.contains("TracerPid")) {
                        if (readLine == null) {
                            readLine = "";
                            break;
                        }
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                            return "";
                        } catch (Exception e2) {
                            return "";
                        }
                    }
                    return "";
                } catch (Throwable th) {
                    bufferedReader2 = bufferedReader;
                    th = th;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (Exception e3) {
                        }
                    }
                    throw th;
                }
            }
            String replace = readLine.replace("\t", " ");
            try {
                bufferedReader.close();
                return replace;
            } catch (Exception e4) {
                return replace;
            }
        } catch (Exception e5) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean a(Context context) {
        try {
            return (context.getPackageManager().getApplicationInfo(context.getPackageName(), 8192).flags & 2) == 1;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean b() {
        try {
            return Boolean.valueOf(Debug.isDebuggerConnected()).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean b(Context context) {
        try {
            return Build.VERSION.SDK_INT >= 24 ? (context.getPackageManager().getApplicationInfo(context.getPackageName(), 8192).flags & 2) == 1 : (context.getPackageManager().getApplicationInfo(context.getPackageName(), 8192).flags & 2) == 1;
        } catch (Throwable th) {
            return false;
        }
    }
}
