package com.amap.api.maps.model;

import android.os.RemoteException;
import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.autonavi.base.ae.gmap.bean.TileProviderInner;
import java.lang.ref.WeakReference;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/model/TileOverlay.class */
public final class TileOverlay extends BaseOverlay {
    protected WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    protected TileOverlayOptions options;

    public TileOverlay(IGlOverlayLayer iGlOverlayLayer, TileOverlayOptions tileOverlayOptions, String str) {
        super(str);
        TileProviderInner tileProviderInner;
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = tileOverlayOptions;
        if (tileOverlayOptions == null || (tileProviderInner = tileOverlayOptions.getTileProviderInner()) == null) {
            return;
        }
        tileProviderInner.init(iGlOverlayLayer, str);
    }

    protected final Object callNativeFunction(String str, Object[] objArr) {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return null;
            }
            return iGlOverlayLayer.getNativeProperties(this.overlayName, str, objArr);
        } catch (Throwable th) {
            return null;
        }
    }

    public final void clearTileCache() {
        callNativeFunction("clearTileCache", null);
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof TileOverlay)) {
            return false;
        }
        try {
            if (this.options == null || !this.options.equals(((TileOverlay) obj).options)) {
                return false;
            }
            return this.overlayName.equals(((TileOverlay) obj).overlayName);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final String getId() {
        return this.overlayName;
    }

    public final float getZIndex() {
        return this.options.getZIndex();
    }

    public final int hashCode() {
        if (this.options != null) {
            return (((this.overlayName == null ? 0 : this.overlayName.hashCode()) + 31) * 31) + this.options.hashCode();
        }
        return super.hashCode();
    }

    public final boolean isVisible() {
        return this.options.isVisible();
    }

    public final void remove() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void setVisible(boolean z) {
        this.options.visible(z);
        updateOption();
    }

    public final void setZIndex(float f) {
        this.options.zIndex(f);
        updateOption();
    }

    protected final void updateOption() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.updateOption(this.overlayName, this.options);
        } catch (Throwable th) {
        }
    }
}
