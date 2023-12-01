package com.blued.android.module.svgaplayer;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/SVGADynamicEntity$setClickArea$2.class */
public final class SVGADynamicEntity$setClickArea$2 implements IClickAreaListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SVGADynamicEntity f15949a;

    @Override // com.blued.android.module.svgaplayer.IClickAreaListener
    public void a(String key, int i, int i2, int i3, int i4) {
        Intrinsics.e(key, "key");
        HashMap<String, int[]> h = this.f15949a.h();
        if (h.get(key) == null) {
            h.put(key, new int[]{i, i2, i3, i4});
            return;
        }
        int[] iArr = h.get(key);
        if (iArr != null) {
            iArr[0] = i;
            iArr[1] = i2;
            iArr[2] = i3;
            iArr[3] = i4;
        }
    }
}
