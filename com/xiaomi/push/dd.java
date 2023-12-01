package com.xiaomi.push;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.push.al;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dd.class */
public class dd {

    /* renamed from: a  reason: collision with root package name */
    private static volatile dd f41328a;

    /* renamed from: a  reason: collision with other field name */
    private Context f284a;

    /* renamed from: a  reason: collision with other field name */
    private final ConcurrentLinkedQueue<b> f285a;

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dd$a.class */
    class a extends b {
        a() {
            super();
        }

        @Override // com.xiaomi.push.dd.b, com.xiaomi.push.al.b
        public void b() {
            dd.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dd$b.class */
    public class b extends al.b {

        /* renamed from: a  reason: collision with root package name */
        long f41330a = System.currentTimeMillis();

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        public boolean a() {
            return true;
        }

        @Override // com.xiaomi.push.al.b
        public void b() {
        }

        /* renamed from: b  reason: collision with other method in class */
        final boolean m11617b() {
            return System.currentTimeMillis() - this.f41330a > com.baidu.mobads.sdk.internal.bj.e;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dd$c.class */
    class c extends b {

        /* renamed from: a  reason: collision with root package name */
        int f41331a;

        /* renamed from: a  reason: collision with other field name */
        File f287a;

        /* renamed from: a  reason: collision with other field name */
        String f288a;

        /* renamed from: a  reason: collision with other field name */
        boolean f289a;
        String b;

        /* renamed from: b  reason: collision with other field name */
        boolean f290b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(String str, String str2, File file, boolean z) {
            super();
            this.f288a = str;
            this.b = str2;
            this.f287a = file;
            this.f290b = z;
        }

        private boolean c() {
            int i;
            SharedPreferences sharedPreferences = dd.this.f284a.getSharedPreferences("log.timestamp", 0);
            String string = sharedPreferences.getString("log.requst", "");
            long currentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject(string);
                long j = jSONObject.getLong("time");
                currentTimeMillis = j;
                i = jSONObject.getInt("times");
                currentTimeMillis = j;
            } catch (JSONException e) {
                i = 0;
            }
            if (System.currentTimeMillis() - currentTimeMillis >= 86400000) {
                currentTimeMillis = System.currentTimeMillis();
                i = 0;
            } else if (i > 10) {
                return false;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("time", currentTimeMillis);
                jSONObject2.put("times", i + 1);
                sharedPreferences.edit().putString("log.requst", jSONObject2.toString()).commit();
                return true;
            } catch (JSONException e2) {
                com.xiaomi.channel.commonutils.logger.b.c("JSONException on put " + e2.getMessage());
                return true;
            }
        }

        @Override // com.xiaomi.push.dd.b
        public boolean a() {
            if (bh.e(dd.this.f284a)) {
                return true;
            }
            return this.f290b && bh.b(dd.this.f284a);
        }

        @Override // com.xiaomi.push.dd.b, com.xiaomi.push.al.b
        public void b() {
            try {
                if (c()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uid", com.xiaomi.push.service.bv.m12168a());
                    hashMap.put("token", this.b);
                    hashMap.put("net", bh.m11535a(dd.this.f284a));
                    bh.a(this.f288a, hashMap, this.f287a, ContentResolver.SCHEME_FILE);
                }
                this.f289a = true;
            } catch (IOException e) {
            }
        }

        @Override // com.xiaomi.push.al.b
        /* renamed from: c  reason: collision with other method in class */
        public void mo11618c() {
            if (!this.f289a) {
                int i = this.f41331a + 1;
                this.f41331a = i;
                if (i < 3) {
                    dd.this.f285a.add(this);
                }
            }
            if (this.f289a || this.f41331a >= 3) {
                this.f287a.delete();
            }
            dd.this.a((1 << this.f41331a) * 1000);
        }
    }

    private dd(Context context) {
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        this.f285a = concurrentLinkedQueue;
        this.f284a = context;
        concurrentLinkedQueue.add(new a());
        b(0L);
    }

    public static dd a(Context context) {
        if (f41328a == null) {
            synchronized (dd.class) {
                try {
                    if (f41328a == null) {
                        f41328a = new dd(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        f41328a.f284a = context;
        return f41328a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        b peek = this.f285a.peek();
        if (peek == null || !peek.a()) {
            return;
        }
        b(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (z.b() || z.m12223a()) {
            return;
        }
        try {
            File file = new File(this.f284a.getExternalFilesDir(null) + "/.logcache");
            if (!file.exists() || !file.isDirectory()) {
                return;
            }
            File[] listFiles = file.listFiles();
            int length = listFiles.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                listFiles[i2].delete();
                i = i2 + 1;
            }
        } catch (NullPointerException e) {
        }
    }

    private void b(long j) {
        if (this.f285a.isEmpty()) {
            return;
        }
        gx.a(new df(this), j);
    }

    private void c() {
        while (!this.f285a.isEmpty()) {
            b peek = this.f285a.peek();
            if (peek != null) {
                if (!peek.m11617b() && this.f285a.size() <= 6) {
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.c("remove Expired task");
                this.f285a.remove(peek);
            }
        }
    }

    public void a() {
        c();
        a(0L);
    }

    public void a(String str, String str2, Date date, Date date2, int i, boolean z) {
        this.f285a.add(new de(this, i, date, date2, str, str2, z));
        b(0L);
    }
}
