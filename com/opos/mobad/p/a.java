package com.opos.mobad.p;

import android.app.ActivityManager;
import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/p/a.class */
public class a {
    private static int a() {
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        int i = 0;
        int i2 = 0;
        if (allStackTraces != null) {
            if (allStackTraces.size() > 0) {
                Iterator<Thread> it = allStackTraces.keySet().iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    Thread next = it.next();
                    if (next.getName().startsWith("single_thread") || next.getName().startsWith("comp_thread") || next.getName().startsWith("io_thread") || next.getName().startsWith("scheduled_thread")) {
                        i2++;
                    }
                }
            } else {
                return 0;
            }
        }
        return i;
    }

    public static String a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            long maxMemory = Runtime.getRuntime().maxMemory();
            long j = Runtime.getRuntime().totalMemory();
            jSONObject.put("dmm", maxMemory);
            jSONObject.put("dtm", j);
        } catch (Throwable th) {
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            long j2 = memoryInfo.totalMem;
            long j3 = memoryInfo.availMem;
            jSONObject.put("mm", j2);
            jSONObject.put("am", j3);
        } catch (Throwable th2) {
        }
        try {
            jSONObject.put("limits", a("/proc/self/limits"));
        } catch (Throwable th3) {
        }
        try {
            jSONObject.put("status", a("/proc/self/status"));
        } catch (Throwable th4) {
        }
        try {
            jSONObject.put("oposThreads", a());
        } catch (Throwable th5) {
        }
        try {
            jSONObject.put("pfd", b("/proc/self/fd"));
        } catch (Throwable th6) {
        }
        return jSONObject.toString();
    }

    private static String a(String str) {
        return a(str, 50);
    }

    /* JADX WARN: Finally extract failed */
    private static String a(String str, int i) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        StringBuilder sb = new StringBuilder();
        try {
            bufferedReader = new BufferedReader(new FileReader(str));
            int i2 = 0;
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String trim = readLine.trim();
                    if (trim.length() > 0) {
                        int i3 = i2 + 1;
                        if (i != 0) {
                            i2 = i3;
                            if (i3 <= i) {
                            }
                        }
                        sb.append("  ");
                        sb.append(trim);
                        sb.append("\n");
                        i2 = i3;
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        com.opos.cmn.an.f.a.b("sysContext", "get info fail", th);
                        if (bufferedReader != null) {
                            bufferedReader2 = bufferedReader;
                            bufferedReader2.close();
                        }
                        return sb.toString();
                    } catch (Throwable th2) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e) {
                            }
                        }
                        throw th2;
                    }
                }
            }
            bufferedReader2 = bufferedReader;
            if (i > 0) {
                bufferedReader2 = bufferedReader;
                if (i2 > i) {
                    sb.append("  ......\n");
                    sb.append("  (number of records: ");
                    sb.append(i2);
                    sb.append(")\n");
                    bufferedReader2 = bufferedReader;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
        try {
            bufferedReader2.close();
        } catch (Exception e2) {
        }
        return sb.toString();
    }

    private static int b(String str) {
        try {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                return file.list().length;
            }
            return 0;
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.b("sysContext", "get proc dir fail", th);
            return 0;
        }
    }
}
