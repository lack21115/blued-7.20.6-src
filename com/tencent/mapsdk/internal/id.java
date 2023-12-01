package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.map.lib.models.GroundOverlayInfo;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/id.class */
public class id extends GroundOverlayInfo implements vc {

    /* renamed from: a  reason: collision with root package name */
    private GroundOverlayOptions f23863a;

    public id(Context context, GroundOverlayOptions groundOverlayOptions) {
        if (groundOverlayOptions == null) {
            return;
        }
        this.f23863a = groundOverlayOptions;
        BitmapDescriptor bitmap = groundOverlayOptions.getBitmap();
        if (bitmap != null) {
            Bitmap bitmap2 = bitmap.getBitmap(context);
            if (bitmap2 != null) {
                this.mBitmapWidth = bitmap2.getWidth();
                this.mBitmapHeight = bitmap2.getHeight();
            }
            this.mBitmap = bitmap2;
        }
        this.mAlpha = groundOverlayOptions.getAlpha();
        this.mVisibility = groundOverlayOptions.isVisible();
        this.mLevel = groundOverlayOptions.getLevel();
        this.mZIndex = groundOverlayOptions.getZIndex();
        if (groundOverlayOptions.getPosition() != null) {
            a();
        }
        if (groundOverlayOptions.getLatLngBounds() != null) {
            this.mLatLngBounds = (LatLngBounds) d7.a(groundOverlayOptions.getLatLngBounds());
        }
    }

    public void a() {
        if (this.f23863a.getPosition() == null) {
            return;
        }
        float max = Math.max(0.0f, Math.min(1.0f, this.f23863a.getAnchorU()));
        float max2 = Math.max(0.0f, Math.min(1.0f, this.f23863a.getAnchorV()));
        double pow = Math.pow(2.0d, 20.0f - Math.max(3.0f, Math.min(22.0f, this.f23863a.getZoom())));
        a6 a6Var = new a6(2.68435456E8d);
        p5 c2 = a6Var.c(this.f23863a.getPosition());
        this.mLatLngBounds = LatLngBounds.builder().include(a6Var.b(new p5(c2.b - ((this.mBitmapWidth * max) * pow), c2.f23992c - ((this.mBitmapHeight * max2) * pow)))).include(a6Var.b(new p5(c2.b + (this.mBitmapWidth * (1.0d - max) * pow), c2.f23992c + (this.mBitmapHeight * (1.0d - max2) * pow)))).build();
    }

    public GroundOverlayOptions b() {
        return this.f23863a;
    }
}
