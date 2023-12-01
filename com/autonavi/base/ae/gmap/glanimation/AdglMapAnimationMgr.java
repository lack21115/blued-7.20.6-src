package com.autonavi.base.ae.gmap.glanimation;

import com.amap.api.maps.AMap;
import com.autonavi.base.ae.gmap.GLMapState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/ae/gmap/glanimation/AdglMapAnimationMgr.class */
public class AdglMapAnimationMgr {
    private List<AbstractAdglAnimation> list = Collections.synchronizedList(new ArrayList());
    private AMap.CancelableCallback mCancelCallback;
    private MapAnimationListener mMapAnimationListener;

    /* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/ae/gmap/glanimation/AdglMapAnimationMgr$MapAnimationListener.class */
    public interface MapAnimationListener {
        void onMapAnimationFinish(AMap.CancelableCallback cancelableCallback);
    }

    public void addAnimation(AbstractAdglAnimation abstractAdglAnimation, AMap.CancelableCallback cancelableCallback) {
        AbstractAdglAnimation abstractAdglAnimation2;
        if (abstractAdglAnimation == null) {
            return;
        }
        synchronized (this.list) {
            if (!abstractAdglAnimation.isOver() && this.list.size() > 0 && (abstractAdglAnimation2 = this.list.get(this.list.size() - 1)) != null && (abstractAdglAnimation instanceof AdglMapAnimGroup) && (abstractAdglAnimation2 instanceof AdglMapAnimGroup) && ((AdglMapAnimGroup) abstractAdglAnimation).typeEqueal((AdglMapAnimGroup) abstractAdglAnimation2) && !((AdglMapAnimGroup) abstractAdglAnimation).needMove) {
                this.list.remove(abstractAdglAnimation2);
            }
            this.list.add(abstractAdglAnimation);
            this.mCancelCallback = cancelableCallback;
        }
    }

    public void clearAnimations() {
        synchronized (this) {
            this.list.clear();
        }
    }

    public void doAnimations(GLMapState gLMapState) {
        synchronized (this) {
            if (gLMapState == null) {
                return;
            }
            if (this.list.size() <= 0) {
                return;
            }
            AbstractAdglAnimation abstractAdglAnimation = this.list.get(0);
            if (abstractAdglAnimation == null) {
                return;
            }
            if (!abstractAdglAnimation.isOver()) {
                abstractAdglAnimation.doAnimation(gLMapState);
                return;
            }
            if (this.mMapAnimationListener != null) {
                this.mMapAnimationListener.onMapAnimationFinish(this.mCancelCallback);
            }
            this.list.remove(abstractAdglAnimation);
        }
    }

    public int getAnimationsCount() {
        int size;
        synchronized (this) {
            size = this.list.size();
        }
        return size;
    }

    public AMap.CancelableCallback getCancelCallback() {
        return this.mCancelCallback;
    }

    public void setMapAnimationListener(MapAnimationListener mapAnimationListener) {
        synchronized (this) {
            this.mMapAnimationListener = mapAnimationListener;
        }
    }

    public void setMapCoreListener() {
    }
}
