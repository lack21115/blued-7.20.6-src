package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ai;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/bw.class */
public class bw extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bv f27602a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bv bvVar) {
        this.f27602a = bvVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo8500a() {
        return "10052";
    }

    @Override // java.lang.Runnable
    public void run() {
        cl clVar;
        cl clVar2;
        Context context;
        com.xiaomi.channel.commonutils.logger.b.c("exec== mUploadJob");
        clVar = this.f27602a.f183a;
        if (clVar != null) {
            clVar2 = this.f27602a.f183a;
            context = this.f27602a.f180a;
            clVar2.a(context);
            this.f27602a.b("upload_time");
        }
    }
}
