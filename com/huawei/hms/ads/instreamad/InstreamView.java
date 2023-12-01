package com.huawei.hms.ads.instreamad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.hms.ads.MediaMuteListener;
import com.huawei.hms.ads.gs;
import com.huawei.hms.ads.ll;
import com.huawei.hms.ads.lm;
import com.huawei.hms.ads.w;
import com.huawei.openalliance.ad.inter.data.h;
import com.huawei.openalliance.ad.views.PPSPlacementView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/instreamad/InstreamView.class */
public class InstreamView extends PPSPlacementView implements IInstreamView {
    private View B;
    private OnInstreamAdClickListener C;
    private InstreamMediaStateListener D;
    private InstreamMediaChangeListener F;
    private MediaMuteListener L;
    private gs S;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/instreamad/InstreamView$OnInstreamAdClickListener.class */
    public interface OnInstreamAdClickListener {
        void onClick();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/instreamad/InstreamView$a.class */
    public class a implements gs {
        private a() {
        }

        @Override // com.huawei.hms.ads.gs
        public void Code() {
            if (InstreamView.this.L != null) {
                InstreamView.this.L.onMute();
            }
        }

        @Override // com.huawei.hms.ads.gs
        public void V() {
            if (InstreamView.this.L != null) {
                InstreamView.this.L.onUnmute();
            }
        }
    }

    public InstreamView(Context context) {
        super(context);
        this.F = null;
        this.D = null;
        this.L = null;
        Code(context);
    }

    public InstreamView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.F = null;
        this.D = null;
        this.L = null;
        Code(context);
    }

    public InstreamView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.F = null;
        this.D = null;
        this.L = null;
        Code(context);
    }

    private void Code(final Context context) {
        setGravity(17);
        Code(new lm() { // from class: com.huawei.hms.ads.instreamad.InstreamView.1
            @Override // com.huawei.hms.ads.lm
            public void Code(int i) {
                if (InstreamView.this.D != null) {
                    InstreamView.this.D.onMediaStart(i);
                }
            }

            @Override // com.huawei.hms.ads.lm
            public void Code(int i, int i2) {
                if (InstreamView.this.D != null) {
                    InstreamView.this.D.onMediaProgress(i, i2);
                }
            }

            @Override // com.huawei.hms.ads.lm
            public void Code(int i, int i2, int i3) {
                if (InstreamView.this.D != null) {
                    InstreamView.this.D.onMediaError(i, i2, i3);
                }
            }

            @Override // com.huawei.hms.ads.lm
            public void I(int i) {
                if (InstreamView.this.D != null) {
                    InstreamView.this.D.onMediaStop(i);
                }
            }

            @Override // com.huawei.hms.ads.lm
            public void V(int i) {
                if (InstreamView.this.D != null) {
                    InstreamView.this.D.onMediaPause(i);
                }
            }

            @Override // com.huawei.hms.ads.lm
            public void Z(int i) {
                if (InstreamView.this.D != null) {
                    InstreamView.this.D.onMediaCompletion(i);
                }
            }
        });
        Code(new ll() { // from class: com.huawei.hms.ads.instreamad.InstreamView.2
            @Override // com.huawei.hms.ads.ll
            public void Code(h hVar) {
                if (InstreamView.this.F != null) {
                    InstreamView.this.F.onSegmentMediaChange(new w(context, hVar));
                }
            }
        });
        setOnPlacementAdClickListener(new PPSPlacementView.a() { // from class: com.huawei.hms.ads.instreamad.InstreamView.3
            @Override // com.huawei.openalliance.ad.views.PPSPlacementView.a
            public void Code() {
                if (InstreamView.this.C != null) {
                    InstreamView.this.C.onClick();
                }
            }
        });
        a aVar = new a();
        this.S = aVar;
        Code(aVar);
    }

    @Override // com.huawei.hms.ads.instreamad.IInstreamView
    public void destroy() {
        super.destroyView();
    }

    @Override // com.huawei.hms.ads.instreamad.IInstreamView
    public View getCallToActionView() {
        return this.B;
    }

    @Override // com.huawei.openalliance.ad.views.PPSPlacementView
    public void hideAdvertiserInfoDialog() {
        super.hideAdvertiserInfoDialog();
    }

    @Override // com.huawei.openalliance.ad.views.PPSPlacementView, com.huawei.hms.ads.instreamad.IInstreamView
    public boolean isPlaying() {
        return super.isPlaying();
    }

    @Override // com.huawei.hms.ads.instreamad.IInstreamView
    public void mute() {
        super.C();
    }

    @Override // com.huawei.openalliance.ad.views.PPSPlacementView, com.huawei.hms.ads.instreamad.IInstreamView
    public void onClose() {
        super.Code((Integer) 3);
        super.onClose();
    }

    @Override // com.huawei.openalliance.ad.views.PPSPlacementView, com.huawei.hms.ads.instreamad.IInstreamView
    public void pause() {
        super.pauseView();
    }

    @Override // com.huawei.hms.ads.instreamad.IInstreamView
    public void play() {
        super.resumeView();
    }

    @Override // com.huawei.hms.ads.instreamad.IInstreamView
    public void registerOverlays(List<View> list) {
        setOverlays(list);
    }

    @Override // com.huawei.hms.ads.instreamad.IInstreamView
    public void removeInstreamMediaChangeListener() {
        this.F = null;
    }

    @Override // com.huawei.hms.ads.instreamad.IInstreamView
    public void removeInstreamMediaStateListener() {
        this.D = null;
    }

    @Override // com.huawei.hms.ads.instreamad.IInstreamView
    public void removeMediaMuteListener() {
        V(this.S);
        this.S = null;
        this.L = null;
    }

    @Override // com.huawei.hms.ads.instreamad.IInstreamView
    public void setCallToActionView(View view) {
        this.B = view;
        ArrayList arrayList = new ArrayList();
        arrayList.add(view);
        V(arrayList);
    }

    @Override // com.huawei.hms.ads.instreamad.IInstreamView
    public void setInstreamAds(List<InstreamAd> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (InstreamAd instreamAd : list) {
            if (instreamAd instanceof w) {
                arrayList.add(((w) instreamAd).Code());
            }
        }
        Code(arrayList);
    }

    @Override // com.huawei.hms.ads.instreamad.IInstreamView
    public void setInstreamMediaChangeListener(InstreamMediaChangeListener instreamMediaChangeListener) {
        this.F = instreamMediaChangeListener;
    }

    @Override // com.huawei.hms.ads.instreamad.IInstreamView
    public void setInstreamMediaStateListener(InstreamMediaStateListener instreamMediaStateListener) {
        this.D = instreamMediaStateListener;
    }

    @Override // com.huawei.hms.ads.instreamad.IInstreamView
    public void setMediaMuteListener(MediaMuteListener mediaMuteListener) {
        this.L = mediaMuteListener;
        a aVar = this.S;
        if (aVar == null) {
            aVar = new a();
            this.S = aVar;
        }
        Code(aVar);
    }

    @Override // com.huawei.hms.ads.instreamad.IInstreamView
    public void setOnInstreamAdClickListener(OnInstreamAdClickListener onInstreamAdClickListener) {
        this.C = onInstreamAdClickListener;
    }

    @Override // com.huawei.openalliance.ad.views.PPSPlacementView
    public void showAdvertiserInfoDialog(View view, boolean z) {
        super.showAdvertiserInfoDialog(view, z);
    }

    @Override // com.huawei.openalliance.ad.views.PPSPlacementView, com.huawei.hms.ads.instreamad.IInstreamView
    public void stop() {
        super.stop();
    }

    @Override // com.huawei.hms.ads.instreamad.IInstreamView
    public void unmute() {
        super.S();
    }
}
