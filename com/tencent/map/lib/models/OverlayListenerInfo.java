package com.tencent.map.lib.models;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mapsdk.internal.ma;
import com.tencent.mapsdk.internal.na;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/OverlayListenerInfo.class */
public class OverlayListenerInfo {
    private VectorOverlay.OnVectorOverlayLoadListener innerListener = new a();
    public VectorOverlay.OnVectorOverlayClickListener outterVectorOverlayClickListener;
    public VectorOverlay.OnVectorOverlayLoadListener outterVectorOverlayLoadListener;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/OverlayListenerInfo$a.class */
    public class a implements VectorOverlay.OnVectorOverlayLoadListener {

        /* renamed from: com.tencent.map.lib.models.OverlayListenerInfo$a$a  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/OverlayListenerInfo$a$a.class */
        public class RunnableC0945a implements Runnable {
            public final /* synthetic */ boolean b;

            public RunnableC0945a(boolean z) {
                this.b = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                VectorOverlay.OnVectorOverlayLoadListener onVectorOverlayLoadListener = OverlayListenerInfo.this.outterVectorOverlayLoadListener;
                if (onVectorOverlayLoadListener != null) {
                    onVectorOverlayLoadListener.onVectorOverlayLoaded(this.b);
                    na.a(ma.x, "TMS vetorOverlay loaded status: " + this.b);
                }
            }
        }

        public a() {
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay.OnVectorOverlayLoadListener
        public void onVectorOverlayLoaded(boolean z) {
            new Handler(Looper.getMainLooper()).post(new RunnableC0945a(z));
        }
    }

    public VectorOverlay.OnVectorOverlayClickListener getOutterVectorOverlayClickListener() {
        return this.outterVectorOverlayClickListener;
    }

    public void setOutterVectorOverlayClickListener(VectorOverlay.OnVectorOverlayClickListener onVectorOverlayClickListener) {
        this.outterVectorOverlayClickListener = onVectorOverlayClickListener;
    }

    public void setOutterVectorOverlayLoadListener(VectorOverlay.OnVectorOverlayLoadListener onVectorOverlayLoadListener) {
        this.outterVectorOverlayLoadListener = onVectorOverlayLoadListener;
    }
}
