package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ai;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/by.class */
public class by extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bv f41295a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bv bvVar) {
        this.f41295a = bvVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo11550a() {
        return "10053";
    }

    @Override // java.lang.Runnable
    public void run() {
        cl clVar;
        cl clVar2;
        Context context;
        clVar = this.f41295a.f230a;
        if (clVar != null) {
            clVar2 = this.f41295a.f230a;
            context = this.f41295a.f227a;
            clVar2.b(context);
            this.f41295a.b("delete_time");
        }
    }
}
