package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobads.sdk.internal.bw;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/by.class */
public class by extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bw f6526a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public by(bw bwVar, Looper looper) {
        super(looper);
        this.f6526a = bwVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        bq bqVar;
        boolean z;
        Context context;
        bq bqVar2;
        boolean z2;
        boolean p;
        String string = message.getData().getString(bw.n);
        bu buVar = (bu) message.getData().getParcelable(bw.m);
        if (!bw.k.equals(string)) {
            bqVar = this.f6526a.z;
            bqVar.a(bw.f6522a, "mOnApkDownloadCompleted: download failed, code: " + string);
            this.f6526a.a(false);
            z = this.f6526a.A;
            if (z) {
                this.f6526a.A = false;
                this.f6526a.a(false, "Refused to download remote for version...");
                return;
            }
            return;
        }
        String e = buVar.e();
        context = this.f6526a.y;
        bp bpVar = new bp(e, context, buVar);
        try {
            try {
                if (this.f6526a.u == bw.t) {
                    bpVar.a();
                    bpVar.a(bw.f());
                    if (bw.p != null) {
                        bw.p.b = buVar.b();
                    }
                    this.f6526a.l();
                    z2 = this.f6526a.A;
                    if (z2) {
                        this.f6526a.A = false;
                        bw bwVar = this.f6526a;
                        p = this.f6526a.p();
                        bwVar.a(p, "load remote file just downloaded");
                    }
                } else {
                    this.f6526a.a(bpVar);
                    bpVar.a(bw.f());
                    this.f6526a.a(true);
                }
            } catch (bw.a e2) {
                this.f6526a.a(false);
                bqVar2 = this.f6526a.z;
                bqVar2.a(bw.f6522a, "download apk file failed: " + e2.toString());
            }
        } finally {
            bpVar.delete();
        }
    }
}
