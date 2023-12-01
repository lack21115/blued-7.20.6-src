package com.tencent.qimei.p;

import com.tencent.qimei.j.b;
import com.tencent.qimei.sdk.debug.IDebugger;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/p/a.class */
public class a implements IDebugger {

    /* renamed from: a  reason: collision with root package name */
    public final String f38402a;

    public a(String str) {
        this.f38402a = str;
    }

    @Override // com.tencent.qimei.sdk.debug.IDebugger
    public void requestQm() {
    }

    @Override // com.tencent.qimei.sdk.debug.IDebugger
    public void requestStrategy() {
    }

    @Override // com.tencent.qimei.sdk.debug.IDebugger
    public void setDebug(boolean z) {
        b.f38341a = z;
    }
}
