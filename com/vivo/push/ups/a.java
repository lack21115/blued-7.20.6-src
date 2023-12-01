package com.vivo.push.ups;

import android.content.Context;
import com.vivo.push.IPushActionListener;
import com.vivo.push.PushClient;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/ups/a.class */
final class a implements IPushActionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UPSRegisterCallback f41123a;
    final /* synthetic */ Context b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ VUpsManager f41124c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(VUpsManager vUpsManager, UPSRegisterCallback uPSRegisterCallback, Context context) {
        this.f41124c = vUpsManager;
        this.f41123a = uPSRegisterCallback;
        this.b = context;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        this.f41123a.onResult(new TokenResult(i, PushClient.getInstance(this.b).getRegId()));
    }
}
