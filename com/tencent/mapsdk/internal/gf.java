package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import com.tencent.map.lib.models.AccessibleTouchItem;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/gf.class */
public class gf extends AccessibleTouchItem {
    private o0 b;

    /* renamed from: c  reason: collision with root package name */
    private yi f37490c;

    public gf(yi yiVar, o0 o0Var) {
        this.f37490c = yiVar;
        this.b = o0Var;
    }

    private Rect a(Rect rect) {
        if (rect == null) {
            return null;
        }
        int i = rect.left;
        int i2 = rect.right;
        int i3 = rect.top;
        int i4 = rect.bottom;
        int i5 = (i2 + i) / 2;
        int i6 = (i3 + i4) / 2;
        int i7 = i;
        int i8 = i2;
        if (i2 - i < c7.w() * 40.0f) {
            float f = i5;
            i7 = (int) (f - (c7.w() * 20.0f));
            i8 = (int) (f + (c7.w() * 20.0f));
        }
        int i9 = i3;
        int i10 = i4;
        if (i4 - i3 < c7.w() * 40.0f) {
            float f2 = i6;
            i9 = (int) (f2 - (c7.w() * 20.0f));
            i10 = (int) (f2 + (c7.w() * 20.0f));
        }
        return new Rect(i7, i9, i8, i10);
    }

    @Override // com.tencent.map.lib.models.AccessibleTouchItem
    public Rect getBounds() {
        o0 o0Var = this.b;
        if (o0Var == null) {
            return null;
        }
        return a(o0Var.g());
    }

    @Override // com.tencent.map.lib.models.AccessibleTouchItem
    public String getContentDescription() {
        o0 o0Var = this.b;
        if (o0Var == null) {
            return null;
        }
        return o0Var.getContentDescription();
    }

    @Override // com.tencent.map.lib.models.AccessibleTouchItem
    public void onClick() {
        yi yiVar = this.f37490c;
        if (yiVar != null) {
            TencentMap.OnMarkerClickListener onMarkerClickListener = yiVar.a0;
            o0 o0Var = this.b;
            if (o0Var == null || onMarkerClickListener == null) {
                return;
            }
            onMarkerClickListener.onMarkerClick(o0Var);
        }
    }
}
