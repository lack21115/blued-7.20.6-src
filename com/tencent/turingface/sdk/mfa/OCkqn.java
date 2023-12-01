package com.tencent.turingface.sdk.mfa;

import java.util.ArrayList;
import java.util.Collection;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/OCkqn.class */
public final class OCkqn extends ucT3w {

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<XnM3A> f39898a;
    public long b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f39899c = 0;
    public ArrayList<XnM3A> d = null;
    public int e = 0;

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(d5HOq d5hoq) {
        d5hoq.a(this.b, 0);
        d5hoq.a(this.f39899c, 1);
        d5hoq.a((Collection) this.d, 2);
    }

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(nyvKz nyvkz) {
        this.b = nyvkz.a(this.b, 0, true);
        this.f39899c = nyvkz.a(this.f39899c, 1, true);
        if (f39898a == null) {
            ArrayList<XnM3A> arrayList = new ArrayList<>();
            f39898a = arrayList;
            arrayList.add(new XnM3A());
        }
        this.d = (ArrayList) nyvkz.a((nyvKz) f39898a, 2, true);
    }
}
