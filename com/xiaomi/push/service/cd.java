package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import com.xiaomi.push.ai;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/cd.class */
public final class cd extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f41662a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Notification f1042a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Context f1043a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f1044a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(int i, String str, Context context, String str2, Notification notification) {
        this.f41662a = i;
        this.f1044a = str;
        this.f1043a = context;
        this.b = str2;
        this.f1042a = notification;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public final String mo11550a() {
        String b;
        b = cc.b(this.f41662a, this.f1044a);
        return b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        cc.c(this.f1043a, this.b, this.f41662a, this.f1044a, this.f1042a);
    }
}
