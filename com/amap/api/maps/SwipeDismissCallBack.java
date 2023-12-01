package com.amap.api.maps;

import android.view.View;
import com.amap.api.maps.SwipeDismissTouchListener;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/SwipeDismissCallBack.class */
public class SwipeDismissCallBack implements SwipeDismissTouchListener.DismissCallbacks {

    /* renamed from: a  reason: collision with root package name */
    SwipeDismissView f5513a;

    public SwipeDismissCallBack(SwipeDismissView swipeDismissView) {
        this.f5513a = swipeDismissView;
    }

    @Override // com.amap.api.maps.SwipeDismissTouchListener.DismissCallbacks
    public boolean canDismiss(Object obj) {
        return true;
    }

    @Override // com.amap.api.maps.SwipeDismissTouchListener.DismissCallbacks
    public void onDismiss(View view, Object obj) {
        if (this.f5513a.onDismissCallback != null) {
            this.f5513a.onDismissCallback.onDismiss();
        }
    }

    @Override // com.amap.api.maps.SwipeDismissTouchListener.DismissCallbacks
    public void onNotifySwipe() {
        if (this.f5513a.onDismissCallback != null) {
            this.f5513a.onDismissCallback.onNotifySwipe();
        }
    }
}
