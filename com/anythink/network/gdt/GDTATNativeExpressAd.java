package com.anythink.network.gdt;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeExpressMediaListener;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/gdt/GDTATNativeExpressAd.class */
public class GDTATNativeExpressAd extends CustomNativeAd {

    /* renamed from: a  reason: collision with root package name */
    NativeExpressAD f8949a;
    NativeExpressADView b;

    /* renamed from: c  reason: collision with root package name */
    a f8950c;
    String d;

    /* JADX INFO: Access modifiers changed from: protected */
    public GDTATNativeExpressAd(Context context, String str, int i, int i2, int i3, int i4, int i5, String str2) {
        int i6;
        int i7;
        this.d = str2;
        NativeExpressAD.NativeExpressADListener nativeExpressADListener = new NativeExpressAD.NativeExpressADListener() { // from class: com.anythink.network.gdt.GDTATNativeExpressAd.1
            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public final void onADClicked(NativeExpressADView nativeExpressADView) {
                GDTATNativeExpressAd.this.notifyAdClicked();
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public final void onADClosed(NativeExpressADView nativeExpressADView) {
                GDTATNativeExpressAd.this.notifyAdDislikeClick();
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public final void onADExposure(NativeExpressADView nativeExpressADView) {
                GDTATInitManager.getInstance().a(GDTATNativeExpressAd.this.getShowId(), new WeakReference(GDTATNativeExpressAd.this.b));
                GDTATNativeExpressAd.this.notifyAdImpression();
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public final void onADLeftApplication(NativeExpressADView nativeExpressADView) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public final void onADLoaded(List<NativeExpressADView> list) {
                if (list.size() > 0) {
                    NativeExpressADView nativeExpressADView = list.get(0);
                    GDTATNativeExpressAd.this.setNetworkInfoMap(nativeExpressADView.getExtraInfo());
                    nativeExpressADView.render();
                    return;
                }
                if (GDTATNativeExpressAd.this.f8950c != null) {
                    GDTATNativeExpressAd.this.f8950c.notifyError("", "GDT Ad request success but no Ad return.");
                }
                GDTATNativeExpressAd.this.f8950c = null;
            }

            @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
            public final void onNoAD(AdError adError) {
                if (GDTATNativeExpressAd.this.f8950c != null) {
                    a aVar = GDTATNativeExpressAd.this.f8950c;
                    StringBuilder sb = new StringBuilder();
                    sb.append(adError.getErrorCode());
                    aVar.notifyError(sb.toString(), adError.getErrorMsg());
                }
                GDTATNativeExpressAd.this.f8950c = null;
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public final void onRenderFail(NativeExpressADView nativeExpressADView) {
                if (GDTATNativeExpressAd.this.f8950c != null) {
                    GDTATNativeExpressAd.this.f8950c.notifyError("", "GDT onRenderFail");
                }
                GDTATNativeExpressAd.this.f8950c = null;
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public final void onRenderSuccess(NativeExpressADView nativeExpressADView) {
                GDTATNativeExpressAd.this.b = nativeExpressADView;
                AdData boundData = GDTATNativeExpressAd.this.b.getBoundData();
                if (boundData != null) {
                    if (boundData.getAdPatternType() == 2) {
                        GDTATNativeExpressAd.this.mAdSourceType = "1";
                    } else {
                        GDTATNativeExpressAd.this.mAdSourceType = "2";
                    }
                }
                GDTATNativeExpressAd.this.setVideoDuration(boundData != null ? boundData.getVideoDuration() / 1000 : 0.0d);
                GDTATNativeExpressAd.this.b.setMediaListener(new NativeExpressMediaListener() { // from class: com.anythink.network.gdt.GDTATNativeExpressAd.1.1
                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public final void onVideoCached(NativeExpressADView nativeExpressADView2) {
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public final void onVideoComplete(NativeExpressADView nativeExpressADView2) {
                        GDTATNativeExpressAd.this.notifyAdVideoEnd();
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public final void onVideoError(NativeExpressADView nativeExpressADView2, AdError adError) {
                        GDTATNativeExpressAd gDTATNativeExpressAd = GDTATNativeExpressAd.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append(adError.getErrorCode());
                        gDTATNativeExpressAd.notifyAdVideoVideoPlayFail(sb.toString(), adError.getErrorMsg());
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public final void onVideoInit(NativeExpressADView nativeExpressADView2) {
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public final void onVideoLoading(NativeExpressADView nativeExpressADView2) {
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public final void onVideoPageClose(NativeExpressADView nativeExpressADView2) {
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public final void onVideoPageOpen(NativeExpressADView nativeExpressADView2) {
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public final void onVideoPause(NativeExpressADView nativeExpressADView2) {
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public final void onVideoReady(NativeExpressADView nativeExpressADView2, long j) {
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public final void onVideoStart(NativeExpressADView nativeExpressADView2) {
                        GDTATNativeExpressAd.this.notifyAdVideoStart();
                    }
                });
                if (GDTATNativeExpressAd.this.f8950c != null) {
                    GDTATNativeExpressAd.this.f8950c.notifyLoaded(GDTATNativeExpressAd.this);
                }
                GDTATNativeExpressAd.this.f8950c = null;
            }
        };
        if (i > 0) {
            GDTATInitManager.getInstance();
            i6 = GDTATInitManager.a(context, i);
        } else {
            i6 = -1;
        }
        if (i2 > 0) {
            GDTATInitManager.getInstance();
            i7 = GDTATInitManager.a(context, i2);
        } else {
            i7 = -2;
        }
        if (TextUtils.isEmpty(str2)) {
            this.f8949a = new NativeExpressAD(context, new ADSize(i6, i7), str, nativeExpressADListener);
        } else {
            this.f8949a = new NativeExpressAD(context, new ADSize(i6, i7), str, nativeExpressADListener, str2);
        }
        this.f8949a.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(i3 == 1).setDetailPageMuted(i3 == 1).setAutoPlayPolicy(i4).build());
        if (i5 != -1) {
            this.f8949a.setMaxVideoDuration(i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(a aVar, LoadAdParams loadAdParams) {
        this.f8950c = aVar;
        if (TextUtils.isEmpty(this.d)) {
            this.f8949a.loadAD(1, loadAdParams);
        } else {
            this.f8949a.loadAD(1);
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        NativeExpressADView nativeExpressADView = this.b;
        if (nativeExpressADView != null) {
            nativeExpressADView.setMediaListener(null);
            this.b.destroy();
        }
        this.b = null;
        this.f8950c = null;
        this.f8949a = null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        return this.b;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public boolean isNativeExpress() {
        return true;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd
    public void registerDownloadConfirmListener() {
        NativeExpressADView nativeExpressADView = this.b;
        if (nativeExpressADView != null) {
            nativeExpressADView.setDownloadConfirmListener(new DownloadConfirmListener() { // from class: com.anythink.network.gdt.GDTATNativeExpressAd.2
                @Override // com.qq.e.comm.compliance.DownloadConfirmListener
                public final void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
                    GDTDownloadFirmInfo gDTDownloadFirmInfo = new GDTDownloadFirmInfo();
                    gDTDownloadFirmInfo.appInfoUrl = str;
                    gDTDownloadFirmInfo.scenes = i;
                    gDTDownloadFirmInfo.confirmCallBack = downloadConfirmCallBack;
                    GDTATNativeExpressAd.this.notifyDownloadConfirm(activity, null, gDTDownloadFirmInfo);
                }
            });
        }
    }
}
