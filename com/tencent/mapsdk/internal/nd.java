package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlay;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/nd.class */
public class nd extends tc<od> implements wc, IntersectionOverlay {
    public nd(md mdVar, od odVar) {
        super(mdVar, odVar);
    }

    @Override // com.tencent.mapsdk.internal.wc
    public int d() {
        return ((md) this.i).a(this.h);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlay
    public void setBounds(Rect rect) {
        ((od) this.j).setBounds(rect);
        a((nd) this.j);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlay
    public void setDarkMode(boolean z) {
        ((od) this.j).enableDarkMode(z);
        a((nd) this.j);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlay
    public void setData(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        ((od) this.j).setData(bArr);
        a((nd) this.j);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlay
    public void setDistance(int i) {
        ((od) this.j).setDistance(i);
        a((nd) this.j);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlay
    public void setRoundedCorner(boolean z) {
        ((od) this.j).enableRoundedCorner(z);
        a((nd) this.j);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlay
    public void setVisibility(boolean z) {
        ((od) this.j).setVisibility(z);
        a((nd) this.j);
    }
}
