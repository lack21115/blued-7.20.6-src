package com.anythink.core.a;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.c.d;
import com.anythink.core.common.c.l;
import com.anythink.core.common.e.ae;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.v;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/a/a.class */
public final class a {
    private static a e;

    /* renamed from: a  reason: collision with root package name */
    l f6321a;
    SimpleDateFormat b = new SimpleDateFormat("yyyyMMdd");

    /* renamed from: c  reason: collision with root package name */
    SimpleDateFormat f6322c = new SimpleDateFormat("yyyyMMddHH");
    Context d;

    private a(Context context) {
        this.f6321a = l.a(com.anythink.core.common.c.c.a(context));
        this.d = context;
    }

    public static a a(Context context) {
        if (e == null) {
            e = new a(context);
        }
        return e;
    }

    public final ae.a a(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        return this.f6321a.a(str, str2, this.b.format(new Date(currentTimeMillis)), this.f6322c.format(new Date(currentTimeMillis)));
    }

    public final ae a(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        return this.f6321a.a(str, this.b.format(new Date(currentTimeMillis)), this.f6322c.format(new Date(currentTimeMillis)));
    }

    public final Map<String, ae> a(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        return this.f6321a.a(i, this.b.format(new Date(currentTimeMillis)), this.f6322c.format(new Date(currentTimeMillis)));
    }

    public final void a() {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.f6321a.a(a.this.b.format(new Date(System.currentTimeMillis())));
            }
        });
    }

    public final void a(String str, String str2, String str3) {
        synchronized (v.a().a(str2)) {
            long currentTimeMillis = System.currentTimeMillis();
            String format = this.b.format(new Date(currentTimeMillis));
            String format2 = this.f6322c.format(new Date(currentTimeMillis));
            int parseInt = Integer.parseInt(str);
            ae.a a2 = a(str2, str3);
            ae.a aVar = a2;
            if (a2 == null) {
                aVar = new ae.a();
                aVar.f6624a = str3;
            }
            if (TextUtils.equals(format, aVar.f6625c)) {
                aVar.d++;
            } else {
                aVar.d = 1;
                aVar.f6625c = format;
            }
            if (TextUtils.equals(format2, aVar.b)) {
                aVar.e++;
            } else {
                aVar.e = 1;
                aVar.b = format2;
            }
            aVar.f = currentTimeMillis;
            this.f6321a.a(parseInt, str2, aVar);
        }
    }

    public final boolean a(d dVar, String str) {
        if (dVar.ab() == -1 && dVar.ac() == -1) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ae a2 = this.f6321a.a(str, this.b.format(new Date(currentTimeMillis)), this.f6322c.format(new Date(currentTimeMillis)));
        int i = a2 != null ? a2.f6623c : 0;
        int i2 = a2 != null ? a2.d : 0;
        if (dVar.ab() == -1 || i < dVar.ab()) {
            return dVar.ac() != -1 && ((long) i2) >= dVar.ac();
        }
        return true;
    }

    public final boolean a(String str, ai aiVar) {
        if (aiVar.f() == -1 && aiVar.e() == -1) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ae.a a2 = this.f6321a.a(str, aiVar.t(), this.b.format(new Date(currentTimeMillis)), this.f6322c.format(new Date(currentTimeMillis)));
        ae.a aVar = a2;
        if (a2 == null) {
            aVar = new ae.a();
        }
        if (aiVar.f() == -1 || aVar.e < aiVar.f()) {
            return aiVar.e() != -1 && aVar.d >= aiVar.e();
        }
        return true;
    }
}
