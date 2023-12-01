package com.tencent.turingcam;

import java.util.ArrayList;
import java.util.Collection;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/B9LVG.class */
public final class B9LVG extends SkEpO {

    /* renamed from: a  reason: collision with root package name */
    static ArrayList<Bi3eT> f39807a;
    static byte[] b;

    /* renamed from: c  reason: collision with root package name */
    public String f39808c = "";
    public ArrayList<Bi3eT> d = null;
    public byte[] e = null;
    public SWw7W f = null;

    static {
        ArrayList<Bi3eT> arrayList = new ArrayList<>();
        f39807a = arrayList;
        arrayList.add(new Bi3eT());
        b = r0;
        byte[] bArr = {0};
    }

    @Override // com.tencent.turingcam.SkEpO
    public void a(ShGzN shGzN) {
        shGzN.a(this.f39808c, 0);
        shGzN.a((Collection) this.d, 1);
        byte[] bArr = this.e;
        if (bArr != null) {
            shGzN.a(bArr, 2);
        }
        SWw7W sWw7W = this.f;
        if (sWw7W != null) {
            shGzN.a((SkEpO) sWw7W, 3);
        }
    }
}
