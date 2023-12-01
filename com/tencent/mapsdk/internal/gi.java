package com.tencent.mapsdk.internal;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/gi.class */
public class gi extends yi {
    public gi(Context context, TencentMapOptions tencentMapOptions, ViewGroup viewGroup) {
        super(context, tencentMapOptions, viewGroup);
    }

    @Override // com.tencent.mapsdk.internal.gj, com.tencent.mapsdk.internal.r1
    /* renamed from: a */
    public VectorMap b(rc rcVar) {
        return new fi(rcVar);
    }
}
