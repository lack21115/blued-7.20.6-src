package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.amap.api.col.3sl.ht;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/restruct/a.class */
public abstract class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public String f6398a;
    private File b;
    private Handler e;
    private String f;
    private boolean g;

    /* renamed from: c  reason: collision with root package name */
    private boolean f6399c = false;
    private Map<String, C0119a> d = new ConcurrentHashMap();
    private Runnable h = new Runnable() { // from class: com.autonavi.aps.amapapi.restruct.a.2
        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.f6399c) {
                if (a.this.g) {
                    a.this.e();
                    a.e(a.this);
                }
                if (a.this.e != null) {
                    a.this.e.postDelayed(a.this.h, 60000L);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.autonavi.aps.amapapi.restruct.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/restruct/a$a.class */
    public static final class C0119a {

        /* renamed from: a  reason: collision with root package name */
        int f6402a;
        long b;

        /* renamed from: c  reason: collision with root package name */
        long f6403c;

        public C0119a(int i, long j, long j2) {
            this.f6402a = i;
            this.b = j;
            this.f6403c = j2;
        }
    }

    public a(Context context, String str, Handler handler) {
        this.f = null;
        if (context == null) {
            return;
        }
        this.e = handler;
        this.f6398a = TextUtils.isEmpty(str) ? "unknow" : str;
        this.f = com.autonavi.aps.amapapi.utils.i.l(context);
        try {
            this.b = new File(context.getFilesDir().getPath(), this.f6398a);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        d();
    }

    public static int a(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i == 0 ? 0 : 1;
    }

    private void b(T t, long j) {
        if (t == null || d((a<T>) t) < 0) {
            return;
        }
        String b = b((a<T>) t);
        C0119a c0119a = this.d.get(b);
        if (c0119a == null) {
            a((a<T>) t, j);
            this.d.put(b, new C0119a(c((a<T>) t), d((a<T>) t), j));
            this.g = true;
            return;
        }
        c0119a.f6403c = j;
        if (c0119a.f6402a == c((a<T>) t)) {
            a((a<T>) t, c0119a.b);
            return;
        }
        a((a<T>) t, j);
        c0119a.f6402a = c((a<T>) t);
        c0119a.b = d((a<T>) t);
        this.g = true;
    }

    private void d() {
        try {
            StringBuilder sb = new StringBuilder("restore from：\n");
            for (String str : com.autonavi.aps.amapapi.utils.i.a(this.b)) {
                String str2 = new String(com.autonavi.aps.amapapi.security.a.b(ht.b(str), this.f), "UTF-8");
                sb.append(str2);
                sb.append("\n");
                String[] split = str2.split(",");
                this.d.put(split[0], new C0119a(Integer.parseInt(split[1]), Long.parseLong(split[2]), split.length >= 4 ? Long.parseLong(split[3]) : com.autonavi.aps.amapapi.utils.i.b()));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (c() > 0) {
            this.d.size();
            if (b() > 0) {
                long b = com.autonavi.aps.amapapi.utils.i.b();
                Iterator<Map.Entry<String, C0119a>> it = this.d.entrySet().iterator();
                while (it.hasNext()) {
                    if (b - this.d.get(it.next().getKey()).f6403c > b()) {
                        it.remove();
                    }
                }
            }
            if (this.d.size() > c()) {
                ArrayList arrayList = new ArrayList(this.d.keySet());
                Collections.sort(arrayList, new Comparator<String>() { // from class: com.autonavi.aps.amapapi.restruct.a.1
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // java.util.Comparator
                    /* renamed from: a */
                    public int compare(String str, String str2) {
                        return a.a(((C0119a) a.this.d.get(str2)).f6403c, ((C0119a) a.this.d.get(str)).f6403c);
                    }
                });
                int c2 = (int) c();
                while (true) {
                    int i = c2;
                    if (i >= arrayList.size()) {
                        break;
                    }
                    this.d.remove(arrayList.get(i));
                    c2 = i + 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, C0119a> entry : this.d.entrySet()) {
            String str = entry.getKey() + "," + entry.getValue().f6402a + "," + entry.getValue().b + "," + entry.getValue().f6403c;
            try {
                sb.append(ht.b(com.autonavi.aps.amapapi.security.a.a(str.getBytes("UTF-8"), this.f)) + "\n");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(sb2)) {
            return;
        }
        com.autonavi.aps.amapapi.utils.i.a(this.b, sb2);
    }

    static /* synthetic */ boolean e(a aVar) {
        aVar.g = false;
        return false;
    }

    public final void a() {
        Handler handler;
        if (!this.f6399c && (handler = this.e) != null) {
            handler.removeCallbacks(this.h);
            this.e.postDelayed(this.h, 60000L);
        }
        this.f6399c = true;
    }

    public final void a(T t) {
        b(t, com.autonavi.aps.amapapi.utils.i.b());
    }

    abstract void a(T t, long j);

    public final void a(List<T> list) {
        long b = com.autonavi.aps.amapapi.utils.i.b();
        for (T t : list) {
            b(t, b);
        }
        if (this.d.size() >= list.size()) {
            this.g = true;
        }
        if (this.d.size() > 16384 || c() <= 0) {
            this.d.clear();
            for (T t2 : list) {
                this.d.put(b((a<T>) t2), new C0119a(c((a<T>) t2), d((a<T>) t2), b));
            }
        }
    }

    public final void a(boolean z) {
        Handler handler = this.e;
        if (handler != null) {
            handler.removeCallbacks(this.h);
        }
        if (!z) {
            this.h.run();
        }
        this.f6399c = false;
    }

    abstract long b();

    public abstract String b(T t);

    abstract int c(T t);

    abstract long c();

    abstract long d(T t);

    public final long e(T t) {
        return (com.autonavi.aps.amapapi.utils.i.b() - d((a<T>) t)) / 1000;
    }
}
