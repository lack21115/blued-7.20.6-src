package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import java.lang.ref.WeakReference;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/model/GroundOverlay.class */
public final class GroundOverlay extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private float high;
    private GroundOverlayOptions options;
    private LatLng point;
    private float width;

    public GroundOverlay(IGlOverlayLayer iGlOverlayLayer, GroundOverlayOptions groundOverlayOptions, String str) {
        super(str);
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = groundOverlayOptions;
    }

    private void a() {
        IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
        if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
            return;
        }
        iGlOverlayLayer.updateOption(this.overlayName, this.options);
    }

    public final void destroy() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (Throwable th) {
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof GroundOverlay)) {
            return false;
        }
        try {
            if (super.equals(obj)) {
                return true;
            }
            return ((GroundOverlay) obj).getId() == getId();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final float getBearing() {
        float f = 0.0f;
        try {
            if (this.options != null) {
                f = this.options.getBearing();
            }
            return f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final LatLngBounds getBounds() {
        LatLngBounds latLngBounds = null;
        try {
            if (this.options != null) {
                latLngBounds = this.options.getBounds();
            }
            return latLngBounds;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final float getHeight() {
        float f = 0.0f;
        try {
            if (this.options != null) {
                f = this.options.getHeight();
            }
            return f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final String getId() {
        try {
            return this.overlayName;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final LatLng getPosition() {
        LatLng latLng = null;
        try {
            if (this.options != null) {
                latLng = this.options.getLocation();
            }
            return latLng;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final float getTransparency() {
        float f = 0.0f;
        try {
            if (this.options != null) {
                f = this.options.getTransparency();
            }
            return f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final float getWidth() {
        float f = 0.0f;
        try {
            if (this.options != null) {
                f = this.options.getWidth();
            }
            return f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final float getZIndex() {
        float f = 0.0f;
        try {
            if (this.options != null) {
                f = this.options.getZIndex();
            }
            return f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final boolean isVisible() {
        boolean z = false;
        try {
            if (this.options != null) {
                z = this.options.isVisible();
            }
            return z;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final void remove() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
            if (this.options == null || this.options.getImage() == null) {
                return;
            }
            this.options.getImage().recycle();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setBearing(float f) {
        try {
            if (this.options != null) {
                this.options.bearing(f);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setDimensions(float f) {
        try {
            if (this.options != null) {
                LatLng location = this.point != null ? this.point : this.options.getLocation();
                if (location == null) {
                    this.width = f;
                    return;
                }
                this.options.position(location, f);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setDimensions(float f, float f2) {
        try {
            if (this.options != null) {
                if ((this.point != null ? this.point : this.options.getLocation()) == null) {
                    this.width = f;
                    this.high = f2;
                    return;
                }
                this.options.position(this.options.getLocation(), f, f2);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setImage(BitmapDescriptor bitmapDescriptor) {
        try {
            if (this.options != null) {
                this.options.image(bitmapDescriptor);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setPosition(LatLng latLng) {
        try {
            if (this.options == null || latLng == null) {
                return;
            }
            float width = this.width > 0.0f ? this.width : this.options.getWidth();
            float height = this.high > 0.0f ? this.high : this.options.getHeight();
            if (width == 0.0f) {
                this.point = latLng;
                return;
            }
            int i = (height > 0.0f ? 1 : (height == 0.0f ? 0 : -1));
            if (i == 0) {
                this.options.position(latLng, width);
                a();
            } else if (i > 0) {
                this.options.position(latLng, width, height);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setPositionFromBounds(LatLngBounds latLngBounds) {
        try {
            if (this.options == null || latLngBounds == null) {
                return;
            }
            this.options.positionFromBounds(latLngBounds);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setTransparency(float f) {
        try {
            if (this.options != null) {
                this.options.transparency(f);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setVisible(boolean z) {
        try {
            if (this.options != null) {
                this.options.visible(z);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZIndex(float f) {
        try {
            if (this.options != null) {
                this.options.zIndex(f);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
