package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.RemoteException;
import android.view.MotionEvent;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.interfaces.IInfoWindowManager;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction;

/* renamed from: com.amap.api.col.3sl.cm  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/cm.class */
public final class cm implements IInfoWindowManager, IInfoWindowAction {
    au a;
    private final Context b;
    private final IGlOverlayLayer c;
    private final String d = "PopupOverlay";

    public cm(IGlOverlayLayer iGlOverlayLayer, Context context) {
        this.b = context;
        this.c = iGlOverlayLayer;
    }

    public final void hideInfoWindow() {
        synchronized (this) {
            if (this.c != null) {
                this.c.getNativeProperties("PopupOverlay", "hideInfoWindow", null);
            }
        }
    }

    public final boolean isInfoWindowShown() {
        return false;
    }

    public final boolean onInfoWindowTap(MotionEvent motionEvent) {
        IGlOverlayLayer iGlOverlayLayer = this.c;
        if (iGlOverlayLayer == null || motionEvent == null) {
            return false;
        }
        Object nativeProperties = iGlOverlayLayer.getNativeProperties("PopupOverlay", "onInfoWindowTap", new Object[]{Double.valueOf(motionEvent.getX()), Double.valueOf(motionEvent.getY())});
        if (nativeProperties instanceof Boolean) {
            return ((Boolean) nativeProperties).booleanValue();
        }
        return false;
    }

    public final void redrawInfoWindow() {
        IGlOverlayLayer iGlOverlayLayer = this.c;
        if (iGlOverlayLayer != null) {
            iGlOverlayLayer.getNativeProperties("PopupOverlay", "redrawInfoWindow", null);
        }
    }

    public final void setInfoWindowAdapterManager(au auVar) {
        synchronized (this) {
            this.a = auVar;
        }
    }

    public final void setInfoWindowAnimation(Animation animation, Animation.AnimationListener animationListener) {
    }

    public final void setInfoWindowAppearAnimation(Animation animation) {
    }

    public final void setInfoWindowBackColor(int i) {
    }

    public final void setInfoWindowBackEnable(boolean z) {
    }

    public final void setInfoWindowBackScale(float f, float f2) {
    }

    public final void setInfoWindowDisappearAnimation(Animation animation) {
    }

    public final void setInfoWindowMovingAnimation(Animation animation) {
    }

    public final void showInfoWindow(BasePointOverlay basePointOverlay) throws RemoteException {
        synchronized (this) {
            if (this.c != null && basePointOverlay != null) {
                this.c.getNativeProperties(basePointOverlay.getId(), "showInfoWindow", new Object[]{basePointOverlay.getId()});
            }
        }
    }

    public final void showInfoWindow(BaseOverlayImp baseOverlayImp) throws RemoteException {
        synchronized (this) {
        }
    }

    public final void startAnimation() {
    }
}
