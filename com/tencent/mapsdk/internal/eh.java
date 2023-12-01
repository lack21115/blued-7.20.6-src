package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.core.components.protocol.jce.trafficevent.Detail;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/eh.class */
public class eh {

    /* renamed from: a  reason: collision with root package name */
    public long f23727a = System.currentTimeMillis();
    public LatLngBounds b;

    /* renamed from: c  reason: collision with root package name */
    public List<Detail> f23728c;

    public eh(LatLngBounds latLngBounds, List<Detail> list) {
        this.b = latLngBounds;
        this.f23728c = list;
    }
}
