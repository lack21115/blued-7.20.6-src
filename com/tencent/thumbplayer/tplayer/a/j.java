package com.tencent.thumbplayer.tplayer.a;

import android.content.Context;
import com.tencent.thumbplayer.api.TPCommonEnum;
import com.tencent.thumbplayer.api.capability.TPCapability;
import com.tencent.thumbplayer.config.TPPlayerConfig;
import com.tencent.thumbplayer.core.common.TPSystemInfo;
import com.tencent.thumbplayer.utils.i;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/a/j.class */
public class j implements i.b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f39394a = String.format("android %s", TPSystemInfo.getOsVersion());

    /* renamed from: c  reason: collision with root package name */
    private static final Map<Integer, Integer> f39395c;
    private static final Map<Integer, Integer> d;
    private Context b;

    static {
        HashMap hashMap = new HashMap();
        f39395c = hashMap;
        hashMap.put(0, -1);
        f39395c.put(1, 0);
        f39395c.put(2, 3);
        f39395c.put(3, 3);
        HashMap hashMap2 = new HashMap();
        d = hashMap2;
        hashMap2.put(-1, -1);
        d.put(0, 32);
        d.put(2, 4);
    }

    public j(Context context) {
        this.b = context;
        com.tencent.thumbplayer.utils.i.a().a(this);
    }

    private int a() {
        int i = 0;
        for (int i2 : TPCapability.getDRMCapabilities()) {
            i |= a(i2);
        }
        return i;
    }

    public static int a(@TPCommonEnum.TP_DRM_TYPE int i) {
        Integer num = d.get(Integer.valueOf(i));
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public static int b(int i) {
        Integer num = f39395c.get(Integer.valueOf(i));
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.tencent.thumbplayer.utils.i.b
    public void a(int i, int i2, int i3, int i4) {
        com.tencent.thumbplayer.utils.h.b(this.b);
    }

    public void a(com.tencent.thumbplayer.tplayer.a.b.a aVar) {
        aVar.b(TPPlayerConfig.getGuid());
        aVar.b(0);
        aVar.c(0);
        aVar.d(com.tencent.thumbplayer.utils.h.a(this.b));
        aVar.c(TPSystemInfo.getDeviceName());
        aVar.d(f39394a);
        aVar.e(this.b.getPackageName());
        aVar.g(TPPlayerConfig.getAppVersionName(this.b));
        aVar.h("1.0.0");
        aVar.f(TPPlayerConfig.VERSION);
        aVar.m(TPPlayerConfig.getPlatform());
        aVar.a(0);
        aVar.n(a());
    }

    public void b(com.tencent.thumbplayer.tplayer.a.b.a aVar) {
        aVar.d(com.tencent.thumbplayer.utils.h.a(this.b));
    }
}
