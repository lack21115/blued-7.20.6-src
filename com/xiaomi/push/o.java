package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/o.class */
public class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f41561a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f900a;
    final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f41562c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, String str, String str2, String str3) {
        this.f41561a = nVar;
        this.f900a = str;
        this.b = str2;
        this.f41562c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = this.f41561a.f897a;
        SharedPreferences.Editor edit = context.getSharedPreferences(this.f900a, 4).edit();
        edit.putString(this.b, this.f41562c);
        edit.commit();
    }
}
