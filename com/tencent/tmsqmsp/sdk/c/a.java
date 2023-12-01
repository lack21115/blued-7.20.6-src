package com.tencent.tmsqmsp.sdk.c;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mapsdk.internal.oj;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/c/a.class */
public class a {
    private static final byte[] d = {6, 98, -78, 83, 38, 11, 101, -14, 22, 96};

    /* renamed from: a  reason: collision with root package name */
    private String f39703a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f39704c;

    /* renamed from: com.tencent.tmsqmsp.sdk.c.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/c/a$a.class */
    public interface InterfaceC1043a {
        void a();

        void run();
    }

    public a(String str, long j) {
        this.f39703a = str;
        this.b = j;
    }

    private boolean a() {
        Context context;
        context = oj.getContext();
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences(b.f39705a + a(d), 0);
        this.f39704c = true;
        try {
            long j = sharedPreferences.getLong(this.f39703a, 0L);
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = currentTimeMillis - j;
            if (j == 0 || j2 >= this.b || j2 <= 0) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putLong(this.f39703a, currentTimeMillis);
                edit.commit();
                return false;
            }
            try {
                this.f39704c = false;
                return true;
            } catch (Exception e) {
                e = e;
                z = true;
                e.printStackTrace();
                return z;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    private void b() {
        Context context;
        if (this.f39704c) {
            context = oj.getContext();
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences(b.f39705a + a(d), 0).edit();
                edit.remove(this.f39703a);
                edit.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String a(byte[] bArr) {
        return com.tencent.tmsqmsp.sdk.f.h.a(bArr);
    }

    public void a(InterfaceC1043a interfaceC1043a) {
        if (interfaceC1043a != null) {
            if (a()) {
                interfaceC1043a.a();
            } else {
                interfaceC1043a.run();
            }
            b();
        }
    }
}
