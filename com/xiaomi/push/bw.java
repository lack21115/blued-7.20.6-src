package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ai;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/bw.class */
public class bw extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bv f41293a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bv bvVar) {
        this.f41293a = bvVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo11550a() {
        return "10052";
    }

    @Override // java.lang.Runnable
    public void run() {
        cl clVar;
        cl clVar2;
        Context context;
        com.xiaomi.channel.commonutils.logger.b.c("exec== mUploadJob");
        clVar = this.f41293a.f230a;
        if (clVar != null) {
            clVar2 = this.f41293a.f230a;
            context = this.f41293a.f227a;
            clVar2.a(context);
            this.f41293a.b("upload_time");
        }
    }
}
