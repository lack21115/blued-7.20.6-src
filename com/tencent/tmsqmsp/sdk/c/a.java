package com.tencent.tmsqmsp.sdk.c;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mapsdk.internal.oj;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/c/a.class */
public class a {
    private static final byte[] d = {6, 98, -78, 83, 38, 11, 101, -14, 22, 96};

    /* renamed from: a  reason: collision with root package name */
    private String f26012a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f26013c;

    /* renamed from: com.tencent.tmsqmsp.sdk.c.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/c/a$a.class */
    public interface InterfaceC0873a {
        void a();

        void run();
    }

    public a(String str, long j) {
        this.f26012a = str;
        this.b = j;
    }

    private boolean a() {
        Context context;
        context = oj.getContext();
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences(b.f26014a + a(d), 0);
        this.f26013c = true;
        try {
            long j = sharedPreferences.getLong(this.f26012a, 0L);
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = currentTimeMillis - j;
            if (j == 0 || j2 >= this.b || j2 <= 0) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putLong(this.f26012a, currentTimeMillis);
                edit.commit();
                return false;
            }
            try {
                this.f26013c = false;
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
        if (this.f26013c) {
            context = oj.getContext();
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences(b.f26014a + a(d), 0).edit();
                edit.remove(this.f26012a);
                edit.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String a(byte[] bArr) {
        return com.tencent.tmsqmsp.sdk.f.h.a(bArr);
    }

    public void a(InterfaceC0873a interfaceC0873a) {
        if (interfaceC0873a != null) {
            if (a()) {
                interfaceC0873a.a();
            } else {
                interfaceC0873a.run();
            }
            b();
        }
    }
}
