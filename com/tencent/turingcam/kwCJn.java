package com.tencent.turingcam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/kwCJn.class */
public final class kwCJn extends SkEpO {

    /* renamed from: a  reason: collision with root package name */
    static ArrayList<Bi3eT> f26137a;
    static byte[] b;

    /* renamed from: c  reason: collision with root package name */
    static Map<String, String> f26138c;
    public String d = "";
    public ArrayList<Bi3eT> e = null;
    public byte[] f = null;
    public Map<String, String> g = null;
    public SWw7W h = null;
    public String i = "";

    static {
        ArrayList<Bi3eT> arrayList = new ArrayList<>();
        f26137a = arrayList;
        arrayList.add(new Bi3eT());
        b = r0;
        byte[] bArr = {0};
        HashMap hashMap = new HashMap();
        f26138c = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.turingcam.SkEpO
    public void a(ShGzN shGzN) {
        shGzN.a(this.d, 0);
        shGzN.a((Collection) this.e, 1);
        shGzN.a(this.f, 2);
        Map<String, String> map = this.g;
        if (map != null) {
            shGzN.a((Map) map, 3);
        }
        SWw7W sWw7W = this.h;
        if (sWw7W != null) {
            shGzN.a((SkEpO) sWw7W, 4);
        }
        String str = this.i;
        if (str != null) {
            shGzN.a(str, 5);
        }
        shGzN.a(0, 6);
    }
}
