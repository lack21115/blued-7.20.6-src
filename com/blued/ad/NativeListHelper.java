package com.blued.ad;

import com.anythink.nativead.api.NativeAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8756600-dex2jar.jar:com/blued/ad/NativeListHelper.class */
public class NativeListHelper {

    /* renamed from: a  reason: collision with root package name */
    private int f6641a;
    private Set<Integer> d;
    private List<NativeAd> b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private List<NativeAd> f6642c = new ArrayList();
    private Map<Integer, NativeAd> e = new HashMap();

    public NativeListHelper(int i) {
        this.f6641a = i;
    }

    public void a() {
        List<NativeAd> list = this.b;
        if (list != null) {
            list.clear();
        }
        Map<Integer, NativeAd> map = this.e;
        if (map != null) {
            map.clear();
        }
        List<NativeAd> list2 = this.f6642c;
        if (list2 != null) {
            int size = list2.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                NativeAd nativeAd = this.f6642c.get(i2);
                if (nativeAd != null) {
                    nativeAd.destory();
                }
                i = i2 + 1;
            }
            this.f6642c.clear();
        }
        Set<Integer> set = this.d;
        if (set != null) {
            set.clear();
        }
    }
}
