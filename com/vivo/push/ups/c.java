package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/ups/c.class */
final class c implements IPushActionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UPSTurnCallback f27435a;
    final /* synthetic */ VUpsManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(VUpsManager vUpsManager, UPSTurnCallback uPSTurnCallback) {
        this.b = vUpsManager;
        this.f27435a = uPSTurnCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        this.f27435a.onResult(new CodeResult(i));
    }
}
