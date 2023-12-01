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
    final /* synthetic */ ao f27521a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(ao aoVar, Handler handler) {
        super(handler);
        this.f27521a = aoVar;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Context context;
        Integer num;
        Context context2;
        Context context3;
        ao aoVar = this.f27521a;
        context = aoVar.f85a;
        aoVar.f89a = Integer.valueOf(bn.a(context).a());
        num = this.f27521a.f89a;
        if (num.intValue() != 0) {
            context2 = this.f27521a.f85a;
            context2.getContentResolver().unregisterContentObserver(this);
            context3 = this.f27521a.f85a;
            if (bh.b(context3)) {
                this.f27521a.m8402c();
            }
        }
    }
}
