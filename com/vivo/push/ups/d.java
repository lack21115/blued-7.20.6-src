package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/ups/d.class */
final class d implements IPushActionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UPSTurnCallback f27436a;
    final /* synthetic */ VUpsManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(VUpsManager vUpsManager, UPSTurnCallback uPSTurnCallback) {
        this.b = vUpsManager;
        this.f27436a = uPSTurnCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        this.f27436a.onResult(new CodeResult(i));
    }
}
