package com.alipay.sdk.widget;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/widget/i.class */
public class i implements DownloadListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f4687a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f4687a = hVar;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(268435456);
            this.f4687a.f4685a.startActivity(intent);
        } catch (Throwable th) {
        }
    }
}
