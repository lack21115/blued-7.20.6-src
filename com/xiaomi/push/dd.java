package com.xiaomi.push;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
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
    private static volatile dd f27637a;

    /* renamed from: a  reason: collision with other field name */
    private Context f237a;

    /* renamed from: a  reason: collision with other field name */
    private final ConcurrentLinkedQueue<b> f238a;

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
        long f27639a = System.currentTimeMillis();

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
        final boolean m8567b() {
            return System.currentTimeMillis() - this.f27639a > com.baidu.mobads.sdk.internal.bj.e;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dd$c.class */
    class c extends b {

        /* renamed from: a  reason: collision with root package name */
        int f27640a;

        /* renamed from: a  reason: collision with other field name */
        File f240a;

        /* renamed from: a  reason: collision with other field name */
        String f241a;

        /* renamed from: a  reason: collision with other field name */
        boolean f242a;
        String b;

        /* renamed from: b  reason: collision with other field name */
        boolean f243b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(String str, String str2, File file, boolean z) {
            super();
            this.f241a = str;
            this.b = str2;
            this.f240a = file;
            this.f243b = z;
        }

        private boolean c() {
            int i;
            SharedPreferences sharedPreferences = dd.this.f237a.getSharedPreferences("log.timestamp", 0);
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
            if (bh.e(dd.this.f237a)) {
                return true;
            }
            return this.f243b && bh.b(dd.this.f237a);
        }

        @Override // com.xiaomi.push.dd.b, com.xiaomi.push.al.b
        public void b() {
            try {
                if (c()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uid", com.xiaomi.push.service.bv.m9118a());
                    hashMap.put("token", this.b);
                    hashMap.put(TKDownloadReason.KSAD_TK_NET, bh.m8485a(dd.this.f237a));
                    bh.a(this.f241a, hashMap, this.f240a, ContentResolver.SCHEME_FILE);
                }
                this.f242a = true;
            } catch (IOException e) {
            }
        }

        @Override // com.xiaomi.push.al.b
        /* renamed from: c  reason: collision with other method in class */
        public void mo8568c() {
            if (!this.f242a) {
                int i = this.f27640a + 1;
                this.f27640a = i;
                if (i < 3) {
                    dd.this.f238a.add(this);
                }
            }
            if (this.f242a || this.f27640a >= 3) {
                this.f240a.delete();
            }
            dd.this.a((1 << this.f27640a) * 1000);
        }
    }

    private dd(Context context) {
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        this.f238a = concurrentLinkedQueue;
        this.f237a = context;
        concurrentLinkedQueue.add(new a());
        b(0L);
    }

    public static dd a(Context context) {
        if (f27637a == null) {
            synchronized (dd.class) {
                try {
                    if (f27637a == null) {
                        f27637a = new dd(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        f27637a.f237a = context;
        return f27637a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        b peek = this.f238a.peek();
        if (peek == null || !peek.a()) {
            return;
        }
        b(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (z.b() || z.m9173a()) {
            return;
        }
        try {
            File file = new File(this.f237a.getExternalFilesDir(null) + "/.logcache");
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
        if (this.f238a.isEmpty()) {
            return;
        }
        gx.a(new df(this), j);
    }

    private void c() {
        while (!this.f238a.isEmpty()) {
            b peek = this.f238a.peek();
            if (peek != null) {
                if (!peek.m8567b() && this.f238a.size() <= 6) {
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.c("remove Expired task");
                this.f238a.remove(peek);
            }
        }
    }

    public void a() {
        c();
        a(0L);
    }

    public void a(String str, String str2, Date date, Date date2, int i, boolean z) {
        this.f238a.add(new de(this, i, date, date2, str, str2, z));
        b(0L);
    }
}
