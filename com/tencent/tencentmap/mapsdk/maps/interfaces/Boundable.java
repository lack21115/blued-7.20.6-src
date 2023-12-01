package com.tencent.tencentmap.mapsdk.maps.interfaces;

import android.graphics.Rect;
import com.tencent.tencentmap.mapsdk.maps.Projection;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/interfaces/Boundable.class */
public interface Boundable<T extends Projection> {
    Rect getBound(T t);

    List<Boundable<T>> getGroupBounds();

    Rect getScreenBound(T t);
}
