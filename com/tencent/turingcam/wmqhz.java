package com.tencent.turingcam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/wmqhz.class */
public final class wmqhz extends SkEpO {

    /* renamed from: a  reason: collision with root package name */
    static ArrayList<Bi3eT> f26149a;
    static Map<String, String> b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<Bi3eT> f26150c = null;
    public Map<String, String> d = null;

    static {
        ArrayList<Bi3eT> arrayList = new ArrayList<>();
        f26149a = arrayList;
        arrayList.add(new Bi3eT());
        HashMap hashMap = new HashMap();
        b = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.turingcam.SkEpO
    public void a(ShGzN shGzN) {
        shGzN.a("", 0);
        shGzN.a((Collection) this.f26150c, 1);
        Map<String, String> map = this.d;
        if (map != null) {
            shGzN.a((Map) map, 2);
        }
    }
}
