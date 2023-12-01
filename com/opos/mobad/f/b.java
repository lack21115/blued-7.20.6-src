package com.opos.mobad.f;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.opos.mobad.ad.c;
import java.util.HashMap;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f26126a = b.class.getSimpleName();
    private Handler d;
    private HashMap<Integer, com.opos.mobad.ad.c> b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private HashMap<Integer, Boolean> f26127c = new HashMap<>();
    private boolean e = false;

    private void a(Context context) {
        if (this.d != null) {
            return;
        }
        synchronized (this) {
            if (this.d == null) {
                this.d = new Handler(context.getMainLooper());
            }
        }
    }

    private boolean a(int i, String str) {
        if (i == 3 && !TextUtils.isEmpty(str)) {
            return "1200431650".equals(str);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, com.opos.mobad.service.a.e eVar, boolean z) {
        com.opos.cmn.an.f.a.b("DispatchController", "initCreatorIfNeed done");
        com.opos.cmn.an.f.a.a(f26126a, "init creator size:" + this.b.size() + ".CreateMap:" + this.b.toString());
        String str = context.getApplicationInfo().name;
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = context.getPackageName();
        }
        boolean z2 = true;
        for (Integer num : this.b.keySet()) {
            String b = eVar.b(num.intValue());
            String c2 = eVar.c(num.intValue());
            com.opos.mobad.ad.c cVar = this.b.get(num);
            com.opos.cmn.an.f.a.a(f26126a, "init creator channelAppId:" + b);
            if ((!TextUtils.isEmpty(b) || num.intValue() == 7) && com.opos.mobad.service.f.b().a(num.intValue()) && !a(num.intValue(), b)) {
                this.f26127c.put(num, true);
                cVar.a(context, b, str2, c2, z);
            } else {
                z2 = false;
            }
        }
        this.e = z2;
    }

    public int a(int i) {
        if (this.f26127c.containsKey(Integer.valueOf(i))) {
            if (com.opos.mobad.service.f.b().a(i)) {
                return this.f26127c.get(Integer.valueOf(i)).booleanValue() ? 0 : 1;
            }
            return 3;
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c.a a(Context context, Integer num, com.opos.mobad.ad.c cVar) {
        c.a a2;
        synchronized (this) {
            if (this.b.containsKey(num)) {
                a2 = new c.a(true, "");
            } else {
                a2 = cVar.a(context);
                if (a2 == null) {
                    String str = f26126a;
                    com.opos.cmn.an.f.a.c(str, "creator check null:" + num);
                    a2 = new c.a(false, "unknown error");
                } else if (a2.f25670a) {
                    this.b.put(num, cVar);
                    this.f26127c.put(num, false);
                } else {
                    String str2 = f26126a;
                    com.opos.cmn.an.f.a.d(str2, "error:" + a2.b);
                }
            }
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final Context context, final com.opos.mobad.service.a.e eVar, final boolean z) {
        com.opos.cmn.an.f.a.b("DispatchController", "initCreatorIfNeed");
        if (context.getMainLooper().getThread() == Thread.currentThread()) {
            b(context, eVar, z);
            return;
        }
        a(context);
        this.d.post(new Runnable() { // from class: com.opos.mobad.f.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.b(context, eVar, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.b.containsKey(1);
    }

    public com.opos.mobad.ad.c b(int i) {
        return this.b.get(Integer.valueOf(i));
    }

    public void b() {
        synchronized (this) {
            for (Integer num : this.b.keySet()) {
                this.b.get(num).b();
            }
        }
    }
}
