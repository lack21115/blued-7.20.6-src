package com.huawei.hms.ads.nativead;

import android.view.View;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.hms.ads.VideoOperator;
import com.huawei.hms.ads.bs;
import com.huawei.openalliance.ad.inter.data.g;
import com.huawei.openalliance.ad.inter.data.n;
import com.huawei.openalliance.ad.inter.data.v;
import com.huawei.openalliance.ad.views.NativeVideoView;
import com.huawei.openalliance.ad.views.NativeWindowImageView;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/nativead/b.class */
public class b {
    private v B;
    private g C;
    private NativeVideoView Code;
    private NativeAdConfiguration I;
    private NativeAd S;
    private NativeWindowImageView V;
    private VideoConfiguration Z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(NativeVideoView nativeVideoView, NativeWindowImageView nativeWindowImageView) {
        this.Code = nativeVideoView;
        this.V = nativeWindowImageView;
    }

    private void Code(g gVar) {
        if (gVar == null) {
            return;
        }
        this.C = gVar;
        this.B = gVar.B();
        g gVar2 = this.C;
        if (gVar2 instanceof n) {
            NativeAdConfiguration ad = ((n) gVar2).ad();
            this.I = ad;
            if (ad != null) {
                this.Z = ad.getVideoConfiguration();
            }
        }
        if (S()) {
            this.Code.setVisibility(8);
            this.V.setVisibility(0);
            return;
        }
        this.V.setVisibility(8);
        this.Code.setVisibility(0);
    }

    private boolean S() {
        return this.C.a() == 13 || this.C.a() == 113;
    }

    public View B() {
        if (this.C == null) {
            return null;
        }
        return S() ? this.V : this.Code;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Code(final VideoOperator.VideoLifecycleListener videoLifecycleListener) {
        this.Code.setVideoEventListener(new NativeVideoView.a() { // from class: com.huawei.hms.ads.nativead.b.1
            boolean Code = true;

            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void Code() {
                if (this.Code) {
                    videoLifecycleListener.onVideoStart();
                    this.Code = false;
                }
                videoLifecycleListener.onVideoPlay();
            }

            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void Code(boolean z) {
                videoLifecycleListener.onVideoMute(z);
            }

            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void Code(boolean z, int i) {
            }

            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void I() {
                this.Code = true;
                videoLifecycleListener.onVideoEnd();
            }

            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void V() {
                videoLifecycleListener.onVideoPause();
            }

            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void V(boolean z, int i) {
            }

            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void Z() {
            }
        });
    }

    public void Code(NativeAd nativeAd) {
        this.S = nativeAd;
        if (nativeAd instanceof bs) {
            Code(((bs) nativeAd).Code());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NativeVideoView I() {
        return this.Code;
    }
}
