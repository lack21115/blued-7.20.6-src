package com.huawei.openalliance.ad.views;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.huawei.hms.ads.fe;
import com.huawei.hms.ads.fi;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.lr;
import com.huawei.openalliance.ad.utils.s;
import java.lang.ref.WeakReference;
import java.util.Set;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/d.class */
public class d {
    private fi B;
    private SurfaceTexture C;
    private final Set<WeakReference<lr>> D;
    private Surface F;
    private fe I;
    private SurfaceTexture.OnFrameAvailableListener L;
    private int S;
    private final s V;
    private com.huawei.openalliance.ad.media.b Z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SurfaceTexture B() {
        SurfaceTexture surfaceTexture;
        synchronized (this) {
            surfaceTexture = this.C;
        }
        return surfaceTexture;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public fi C() {
        fi fiVar;
        synchronized (this) {
            fiVar = this.B;
        }
        return fiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Code() {
        synchronized (this) {
            try {
            } catch (Throwable th) {
                ge.Code(5, "MultiSurfacesVideoMixer", "init texture", th);
            }
            if (this.B != null) {
                return;
            }
            fi fiVar = new fi();
            this.B = fiVar;
            this.S = fiVar.V();
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.S);
            this.C = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(this.L);
            Surface surface = new Surface(this.C);
            this.F = surface;
            this.Z.Code(surface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Code(Runnable runnable) {
        this.V.Code(runnable);
    }

    public void D() {
        fi fiVar = this.B;
        if (fiVar != null) {
            fiVar.Code();
            this.B = null;
        }
        fe feVar = this.I;
        if (feVar != null) {
            feVar.V();
            this.I.Code();
            this.I = null;
        }
        SurfaceTexture surfaceTexture = this.C;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Surface I() {
        Surface surface;
        synchronized (this) {
            surface = this.F;
        }
        return surface;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public fe S() {
        fe feVar;
        synchronized (this) {
            feVar = this.I;
        }
        return feVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V() {
        synchronized (this) {
            if (this.I != null) {
                return;
            }
            this.I = new fe();
        }
    }

    public void V(lr lrVar) {
        WeakReference<lr> weakReference = null;
        for (WeakReference<lr> weakReference2 : this.D) {
            if (weakReference2.get() == lrVar) {
                weakReference = weakReference2;
            }
        }
        if (weakReference != null) {
            this.D.remove(weakReference);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int Z() {
        int i;
        synchronized (this) {
            i = this.S;
        }
        return i;
    }

    protected void finalize() {
        super.finalize();
        this.V.V();
    }
}
