package com.anythink.core.common.b;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import com.android.internal.content.NativeLibraryHelper;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/b/h.class */
public class h implements Thread.UncaughtExceptionHandler {
    private static volatile h d;
    private Thread.UncaughtExceptionHandler b;
    private Context c;
    private SharedPreferences e;
    private final String f = "crash_type";
    private final String g = "crash_msg";
    private final String h = e.c;
    String a = "com.anythink";

    private h(Context context) {
        this.c = context;
        this.e = context.getSharedPreferences(g.t, 0);
    }

    public static h a(Context context) {
        if (d == null) {
            synchronized (h.class) {
                try {
                    if (d == null) {
                        d = new h(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    static /* synthetic */ void a(h hVar) {
        Map<String, ?> all = hVar.e.getAll();
        Iterator<?> it = all.values().iterator();
        while (it.hasNext()) {
            Object next = it.next();
            String obj = next != null ? next.toString() : "";
            if (!TextUtils.isEmpty(obj)) {
                try {
                    JSONObject jSONObject = new JSONObject(obj);
                    com.anythink.core.common.j.c.a(jSONObject.optString("crash_type"), jSONObject.optString("crash_msg"), jSONObject.optString(e.c));
                } catch (Exception e) {
                }
            }
        }
        if (all.size() > 0) {
            hVar.e.edit().clear().commit();
        }
    }

    private void a(Throwable th) {
        try {
            String b = b(th);
            if (a(b)) {
                String b2 = b(b);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("crash_type", URLEncoder.encode(b2));
                jSONObject.put("crash_msg", URLEncoder.encode(b() + "\n" + b));
                jSONObject.put(e.c, n.a().r());
                SharedPreferences.Editor edit = this.e.edit();
                edit.putString(System.currentTimeMillis() + "_crash", jSONObject.toString());
                edit.commit();
            }
        } catch (Throwable th2) {
        }
    }

    private boolean a(String str) {
        com.anythink.core.c.a b = com.anythink.core.c.b.a(this.c).b(n.a().p());
        if (b == null) {
            return str.contains(this.a);
        } else if (b.x() == 0) {
            return false;
        } else {
            String z = b.z();
            try {
                if (TextUtils.isEmpty(z)) {
                    return true;
                }
                JSONArray jSONArray = new JSONArray(z);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= jSONArray.length()) {
                        return false;
                    }
                    if (str.contains(jSONArray.optString(i2))) {
                        return true;
                    }
                    i = i2 + 1;
                }
            } catch (Throwable th) {
                return false;
            }
        }
    }

    private String b() {
        ActivityManager.MemoryInfo memoryInfo;
        Thread key;
        try {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            HashMap hashMap = new HashMap(4);
            int i = 0;
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                if (entry.getKey().getName().startsWith(g.n)) {
                    String str = key.getName() + NativeLibraryHelper.CLEAR_ABI_OVERRIDE + key.getState();
                    if (hashMap.containsKey(str)) {
                        hashMap.put(str, Integer.valueOf(((Integer) hashMap.get(str)).intValue() + 1));
                    } else {
                        hashMap.put(str, 1);
                    }
                    i++;
                }
            }
            JSONObject jSONObject = new JSONObject(hashMap);
            jSONObject.put("anythink_thread_count", i);
            try {
                ActivityManager activityManager = (ActivityManager) this.c.getSystemService("activity");
                Debug.MemoryInfo[] processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()});
                if (processMemoryInfo.length > 0) {
                    int totalPss = processMemoryInfo[0].getTotalPss();
                    jSONObject.put("app_memory", (totalPss / 1024) + "MB");
                }
                activityManager.getMemoryInfo(new ActivityManager.MemoryInfo());
                if (Build.VERSION.SDK_INT >= 16) {
                    jSONObject.put("sys_total_memory", (memoryInfo.totalMem / 1048576) + "MB");
                    jSONObject.put("sys_avail_memory", (memoryInfo.availMem / 1048576) + "MB");
                }
            } catch (Throwable th) {
            }
            return jSONObject.toString();
        } catch (Throwable th2) {
            return th2.getMessage();
        }
    }

    private static String b(String str) {
        String str2;
        String str3;
        try {
            Matcher matcher = Pattern.compile(".*?(Exception|Error|Death)", 2).matcher(str);
            str2 = matcher.find() ? matcher.group(0) : "";
            str3 = str2;
        } catch (Exception e) {
            str2 = "";
        }
        try {
            if (!TextUtils.isEmpty(str2)) {
                return str2.replaceAll("Caused by:", "").replaceAll(" ", "");
            }
        } catch (Exception e2) {
            str3 = str2;
            return str3;
        }
        return str3;
    }

    private static String b(Throwable th) {
        PrintWriter printWriter;
        StringWriter stringWriter;
        PrintWriter printWriter2;
        StringWriter stringWriter2;
        if (th == null) {
            return "";
        }
        try {
            for (Throwable th2 = new Throwable(com.anythink.core.common.k.g.a(), th); th2 != null; th2 = th2.getCause()) {
                if (th2 instanceof UnknownHostException) {
                    return "";
                }
            }
            stringWriter = new StringWriter();
            try {
                printWriter = new PrintWriter(stringWriter);
                try {
                    th.printStackTrace(printWriter);
                    printWriter.flush();
                    printWriter.close();
                    stringWriter.close();
                    String stringWriter3 = stringWriter.toString();
                    try {
                        stringWriter.close();
                        stringWriter.close();
                        return stringWriter3;
                    } catch (Throwable th3) {
                        return stringWriter3;
                    }
                } catch (Exception e) {
                    printWriter2 = printWriter;
                    stringWriter2 = stringWriter;
                    if (stringWriter2 != null) {
                        try {
                            stringWriter2.close();
                        } catch (Throwable th4) {
                            return "";
                        }
                    }
                    if (printWriter2 != null) {
                        stringWriter2.close();
                        return "";
                    }
                    return "";
                } catch (Throwable th5) {
                    th = th5;
                    if (stringWriter != null) {
                        try {
                            stringWriter.close();
                        } catch (Throwable th6) {
                            throw th;
                        }
                    }
                    if (printWriter != null) {
                        stringWriter.close();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                printWriter2 = null;
            } catch (Throwable th7) {
                th = th7;
                printWriter = null;
            }
        } catch (Exception e3) {
            printWriter2 = null;
            stringWriter2 = null;
        } catch (Throwable th8) {
            th = th8;
            printWriter = null;
            stringWriter = null;
        }
    }

    private void c() {
        Map<String, ?> all = this.e.getAll();
        Iterator<?> it = all.values().iterator();
        while (it.hasNext()) {
            Object next = it.next();
            String obj = next != null ? next.toString() : "";
            if (!TextUtils.isEmpty(obj)) {
                try {
                    JSONObject jSONObject = new JSONObject(obj);
                    com.anythink.core.common.j.c.a(jSONObject.optString("crash_type"), jSONObject.optString("crash_msg"), jSONObject.optString(e.c));
                } catch (Exception e) {
                }
            }
        }
        if (all.size() > 0) {
            this.e.edit().clear().commit();
        }
    }

    public final void a() {
        com.anythink.core.c.a b = com.anythink.core.c.b.a(this.c).b(n.a().p());
        if (b == null || b.x() != 0) {
            try {
                com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.b.h.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.a(h.this);
                    }
                });
                if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof h)) {
                    this.b = Thread.getDefaultUncaughtExceptionHandler();
                }
                Thread.setDefaultUncaughtExceptionHandler(this);
            } catch (Exception e) {
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (th == null) {
            return;
        }
        try {
            String b = b(th);
            if (a(b)) {
                String b2 = b(b);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("crash_type", URLEncoder.encode(b2));
                jSONObject.put("crash_msg", URLEncoder.encode(b() + "\n" + b));
                jSONObject.put(e.c, n.a().r());
                SharedPreferences.Editor edit = this.e.edit();
                edit.putString(System.currentTimeMillis() + "_crash", jSONObject.toString());
                edit.commit();
            }
        } catch (Throwable th2) {
        }
        try {
            if (this.b == null || this.b == this || (this.b instanceof h)) {
                return;
            }
            this.b.uncaughtException(thread, th);
        } catch (Exception e) {
        }
    }
}
