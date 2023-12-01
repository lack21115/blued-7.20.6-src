package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.bh;
import com.xiaomi.push.service.bn;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/ar.class */
public class ar extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ao f41212a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(ao aoVar, Handler handler) {
        super(handler);
        this.f41212a = aoVar;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Context context;
        Integer num;
        Context context2;
        Context context3;
        ao aoVar = this.f41212a;
        context = aoVar.f132a;
        aoVar.f136a = Integer.valueOf(bn.a(context).a());
        num = this.f41212a.f136a;
        if (num.intValue() != 0) {
            context2 = this.f41212a.f132a;
            context2.getContentResolver().unregisterContentObserver(this);
            context3 = this.f41212a.f132a;
            if (bh.b(context3)) {
                this.f41212a.m11452c();
            }
        }
    }
}
