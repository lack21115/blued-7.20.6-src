package com.tencent.qmsp.sdk.c;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/c/a.class */
public class a {
    private static final byte[] d = {6, 98, -78, 83, 38, 11, 101, -14, 22, 96};

    /* renamed from: a  reason: collision with root package name */
    private String f38545a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f38546c;

    /* renamed from: com.tencent.qmsp.sdk.c.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/c/a$a.class */
    public interface InterfaceC0986a {
        void a();

        void run();
    }

    public a(String str, long j) {
        this.f38545a = str;
        this.b = j;
    }

    private boolean a() {
        Context context;
        context = com.tencent.qmsp.sdk.app.a.getContext();
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences(b.f38547a + a(d), 0);
        this.f38546c = true;
        try {
            long j = sharedPreferences.getLong(this.f38545a, 0L);
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = currentTimeMillis - j;
            if (j == 0 || j2 >= this.b || j2 <= 0) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putLong(this.f38545a, currentTimeMillis);
                edit.commit();
                return false;
            }
            try {
                this.f38546c = false;
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
        if (this.f38546c) {
            context = com.tencent.qmsp.sdk.app.a.getContext();
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences(b.f38547a + a(d), 0).edit();
                edit.remove(this.f38545a);
                edit.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String a(byte[] bArr) {
        return com.tencent.qmsp.sdk.f.h.a(bArr);
    }

    public void a(InterfaceC0986a interfaceC0986a) {
        if (interfaceC0986a != null) {
            if (a()) {
                interfaceC0986a.a();
            } else {
                interfaceC0986a.run();
            }
            b();
        }
    }
}
