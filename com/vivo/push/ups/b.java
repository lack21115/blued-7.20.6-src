package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/ups/b.class */
final class b implements IPushActionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UPSRegisterCallback f41125a;
    final /* synthetic */ VUpsManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(VUpsManager vUpsManager, UPSRegisterCallback uPSRegisterCallback) {
        this.b = vUpsManager;
        this.f41125a = uPSRegisterCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        this.f41125a.onResult(new TokenResult(i, ""));
    }
}
