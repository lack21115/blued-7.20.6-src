package com.tencent.mapsdk.internal;

import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/gd.class */
public final class gd extends tc<id> implements GroundOverlay {
    public gd(hd hdVar, id idVar) {
        super(hdVar, idVar);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay
    public void setAlpha(float f) {
        if (((id) this.j).b() != null) {
            ((id) this.j).b().alpha(f);
        }
        ((id) this.j).setAlpha(f);
        a((gd) this.j);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay
    public void setAnchor(float f, float f2) {
        if (((id) this.j).b() != null) {
            ((id) this.j).b().anchor(f, f2);
        }
        ((id) this.j).a();
        a((gd) this.j);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay
    public void setBitmap(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            return;
        }
        if (((id) this.j).b() != null) {
            ((id) this.j).b().bitmap(bitmapDescriptor);
        }
        uc<T> ucVar = this.i;
        if (ucVar != 0) {
            ((id) this.j).setBitmap(bitmapDescriptor.getBitmap(ucVar.e()));
        }
        a((gd) this.j);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay
    public void setLatLongBounds(LatLngBounds latLngBounds) {
        if (((id) this.j).b() != null) {
            ((id) this.j).b().latLngBounds(latLngBounds);
        }
        ((id) this.j).setLatLngBounds(latLngBounds);
        a((gd) this.j);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay
    public void setLevel(int i) {
        if (((id) this.j).b() != null) {
            ((id) this.j).b().level(i);
        }
        ((id) this.j).setLevel(i);
        a((gd) this.j);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay
    public void setPosition(LatLng latLng) {
        if (((id) this.j).b() != null) {
            ((id) this.j).b().position(latLng);
        }
        ((id) this.j).a();
        a((gd) this.j);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay
    public void setVisibility(boolean z) {
        if (((id) this.j).b() != null) {
            ((id) this.j).b().visible(z);
        }
        ((id) this.j).setVisibility(z);
        a((gd) this.j);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay
    public void setZindex(int i) {
        if (((id) this.j).b() != null) {
            ((id) this.j).b().zIndex(i);
        }
        ((id) this.j).setZIndex(i);
        a((gd) this.j);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay
    public void setZoom(float f) {
        if (((id) this.j).b() != null) {
            ((id) this.j).b().zoom(f);
        }
        ((id) this.j).a();
        a((gd) this.j);
    }
}
