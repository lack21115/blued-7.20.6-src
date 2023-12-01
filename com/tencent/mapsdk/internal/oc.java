package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/oc.class */
public class oc extends TextView {
    private boolean g;

    public oc(Context context, TencentMapContext tencentMapContext) {
        super(context);
        a(tencentMapContext);
    }

    public void a(TencentMapContext tencentMapContext) {
        if (this.g || tencentMapContext == null) {
            return;
        }
        this.g = true;
        Typeface typeface = tencentMapContext.getTypeface();
        if (typeface != null) {
            setTypeface(typeface);
        }
    }
}
