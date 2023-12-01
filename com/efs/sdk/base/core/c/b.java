package com.efs.sdk.base.core.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.efs.sdk.base.core.config.b;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.f.f;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/c/b.class */
public class b extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, Long> f8128a = new HashMap<String, Long>() { // from class: com.efs.sdk.base.core.c.b.1
        {
            put("flow_5min", 300000L);
            put("flow_hour", 3600000L);
            put("flow_day", 86400000L);
        }
    };
    private static final Map<String, Long> b = new HashMap<String, Long>() { // from class: com.efs.sdk.base.core.c.b.2
        {
            put("flow_5min", 1048576L);
            put("flow_hour", 1048576L);
            put("flow_day", 2097152L);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private Map<String, AtomicInteger> f8129c;
    private volatile SharedPreferences d;
    private volatile SharedPreferences.Editor e;
    private Context f;
    private String g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/c/b$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final b f8130a = new b((byte) 0);
    }

    private b() {
        super(com.efs.sdk.base.core.util.concurrent.a.f8189a.getLooper());
        this.f8129c = new ConcurrentHashMap(5);
        this.f = ControllerCenter.getGlobalEnvStruct().mAppContext;
        this.g = ControllerCenter.getGlobalEnvStruct().getAppid();
        b();
        File c2 = com.efs.sdk.base.core.util.a.c(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (c2.exists()) {
            com.efs.sdk.base.core.util.b.b(c2);
        }
    }

    /* synthetic */ b(byte b2) {
        this();
    }

    private static long a(Map<String, String> map, String str, String str2) {
        long longValue = b.get(str).longValue();
        if (map != null && map.containsKey(str2) && !TextUtils.isEmpty(map.get(str2))) {
            try {
                return Long.parseLong(map.get(str2));
            } catch (Throwable th) {
                Log.w("efs.flow", "get max flow error", th);
            }
        }
        return longValue;
    }

    public static b a() {
        return a.f8130a;
    }

    private static List<String> a(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str + "_" + str2);
        }
        if (!TextUtils.isEmpty(str3) && !"unknown".equalsIgnoreCase(str3)) {
            arrayList.add(str + "_" + str3);
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            arrayList.add(str + "_" + str2 + "_" + str3);
        }
        return arrayList;
    }

    private void a(String str) {
        com.efs.sdk.base.core.f.f fVar;
        com.efs.sdk.base.core.f.f fVar2;
        if (!this.f8129c.containsKey(str) || this.f8129c.get(str) == null || this.f8129c.get(str).get() <= 10) {
            fVar = f.a.f8175a;
            fVar.a(com.efs.sdk.base.core.config.a.c.a().d.f8143a, str);
            if (str.equals("flow_day")) {
                fVar2 = f.a.f8175a;
                fVar2.a(com.efs.sdk.base.core.config.a.c.a().d.f8143a);
            }
            if (!this.f8129c.containsKey(str)) {
                this.f8129c.put(str, new AtomicInteger());
            }
            this.f8129c.get(str).incrementAndGet();
        }
    }

    private boolean a(String str, long j, String str2, String str3, long j2) {
        b();
        if (this.d == null) {
            Log.w("efs.flow", "sharedpreferences is null, cann't get last flow stat");
            return false;
        }
        List<String> a2 = a(str, str2, str3);
        Map<String, String> c2 = com.efs.sdk.base.core.config.a.c.a().c();
        for (String str4 : a2) {
            if (Math.abs(System.currentTimeMillis() - this.d.getLong("curr_time_".concat(String.valueOf(str)), System.currentTimeMillis())) > j) {
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = str;
                obtain.arg1 = Long.valueOf(j).intValue();
                sendMessage(obtain);
            }
            long a3 = a(c2, str, str4);
            long j3 = this.d.getLong(str4, 0L);
            if (j3 + j2 > a3) {
                Log.i("efs.flow", "flow limit, key: " + str4 + ", max: " + a3 + ", now: " + j3 + ", size: " + j2);
                a(str4);
                return false;
            }
        }
        return true;
    }

    private void b() {
        try {
            c();
        } catch (Throwable th) {
            Log.e("efs.flow", "init sharedpreferences error", th);
        }
    }

    private void c() {
        if (this.d == null) {
            synchronized (b.class) {
                try {
                    if (this.d == null) {
                        this.d = SharedPreferencesUtils.getSharedPreferences(this.f, this.g.toLowerCase() + "_flow");
                    }
                } finally {
                }
            }
        }
        if (this.e == null) {
            synchronized (b.class) {
                try {
                    if (this.e == null) {
                        this.e = this.d.edit();
                    }
                } finally {
                }
            }
        }
    }

    public final boolean a(String str, long j) {
        com.efs.sdk.base.core.config.b bVar;
        bVar = b.a.f8152a;
        String a2 = bVar.a();
        Iterator<Map.Entry<String, Long>> it = f8128a.entrySet().iterator();
        boolean z = true;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, Long> next = it.next();
            boolean a3 = a(next.getKey(), next.getValue().longValue(), str, a2, j);
            z = a3;
            if (!a3) {
                z = a3;
                break;
            }
        }
        return z;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        com.efs.sdk.base.core.config.b bVar;
        super.handleMessage(message);
        int i = message.what;
        if (i == 0) {
            b();
            if (this.d == null) {
                Log.w("efs.flow", "sharedpreferences is null, cann't get last flow stat");
            } else if (this.e == null) {
                Log.w("efs.flow", "sharedpreferences editor is null, cann't refresh flow stat");
            } else {
                String valueOf = String.valueOf(message.obj);
                long j = message.arg1;
                bVar = b.a.f8152a;
                String a2 = bVar.a();
                for (String str : f8128a.keySet()) {
                    String concat = "curr_time_".concat(String.valueOf(str));
                    if (!this.d.contains(concat)) {
                        this.e.putLong(concat, System.currentTimeMillis());
                    }
                    for (String str2 : a(str, valueOf, a2)) {
                        this.e.putLong(str2, this.d.getLong(str2, 0L) + j);
                    }
                }
                this.e.apply();
            }
        } else if (i != 1) {
            Log.w("efs.flow", "flow stat listener not support action '" + message.what + "'");
        } else {
            String valueOf2 = String.valueOf(message.obj);
            long j2 = message.arg1;
            b();
            if (this.d == null) {
                Log.w("efs.flow", "sharedpreferences is null, cann't get last refresh timestamp");
            } else if (this.e == null) {
                Log.w("efs.flow", "sharedpreferences editor is null, cann't refresh timestamp");
            } else {
                String concat2 = "curr_time_".concat(String.valueOf(valueOf2));
                if (Math.abs(System.currentTimeMillis() - this.d.getLong(concat2, System.currentTimeMillis())) >= j2) {
                    for (String str3 : this.d.getAll().keySet()) {
                        if (str3.startsWith(valueOf2)) {
                            this.e.putLong(str3, 0L);
                        }
                    }
                    this.e.putLong(concat2, System.currentTimeMillis());
                    this.e.apply();
                    this.f8129c.clear();
                }
            }
        }
    }
}
