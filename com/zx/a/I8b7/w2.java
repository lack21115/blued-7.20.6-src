package com.zx.a.I8b7;

import com.zx.module.base.Listener;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/w2.class */
public class w2 implements Listener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Listener f28533a;
    public final /* synthetic */ a3 b;

    public w2(a3 a3Var, Listener listener) {
        this.b = a3Var;
        this.f28533a = listener;
    }

    @Override // com.zx.module.base.Listener
    public void onMessage(String str, String str2) {
        if (str.equals("zxid") || str.equals("MESSAGE_ON_ZXID_RECEIVED")) {
            this.b.f28409a.set(false);
        }
        this.f28533a.onMessage(str, str2);
    }
}
