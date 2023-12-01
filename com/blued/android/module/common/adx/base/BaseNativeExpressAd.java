package com.blued.android.module.common.adx.base;

import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/base/BaseNativeExpressAd.class */
public abstract class BaseNativeExpressAd implements IBaseAd {
    public NativeExpressADView a() {
        return null;
    }

    public void a(Map<String, ? extends Object> map) {
        Intrinsics.e(map, "map");
    }

    public NativeUnifiedADData b() {
        return null;
    }

    public void b(Map<String, ? extends Object> map) {
        Intrinsics.e(map, "map");
    }
}
