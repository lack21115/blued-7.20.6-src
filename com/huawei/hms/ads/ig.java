package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.ik;
import com.iab.omid.library.huawei.adsession.AdEvents;
import com.iab.omid.library.huawei.adsession.AdSession;
import com.iab.omid.library.huawei.adsession.media.InteractionType;
import com.iab.omid.library.huawei.adsession.media.MediaEvents;
import com.iab.omid.library.huawei.adsession.media.PlayerState;
import com.iab.omid.library.huawei.adsession.media.VastProperties;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ig.class */
public class ig extends Cif implements id {
    public static final int Code = 200;
    private static boolean I = false;
    private static final String V = "VideoEventAgent";
    private ik C;
    private final List<MediaEvents> Z = new ArrayList();
    private final List<AdEvents> B = new ArrayList();
    private boolean S = false;
    private int F = 0;
    private float D = 0.0f;
    private boolean L = false;

    static {
        I = ii.Code("com.iab.omid.library.huawei.adsession.media.MediaEvents") && ii.Code(ii.e);
    }

    public static boolean C() {
        return I;
    }

    private String D() {
        return V + hashCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        if (ge.Code()) {
            ge.Code(D(), "volumeChangeInner %s", Boolean.valueOf(this.S));
        }
        V(this.S ? 0.0f : 1.0f);
    }

    @Override // com.huawei.hms.ads.Cif
    public void B() {
        if (this.B.isEmpty()) {
            ge.I(D(), "impressionOccurred, mAdEventList isEmpty");
            return;
        }
        try {
            for (AdEvents adEvents : this.B) {
                adEvents.impressionOccurred();
            }
        } catch (IllegalStateException e) {
            ge.V(D(), "impressionOccurred, fail");
        }
    }

    @Override // com.huawei.hms.ads.Cif
    void Code() {
        if (this.Z.isEmpty()) {
            ge.I(D(), "firstQuartile, mVideoEventsList isEmpty");
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    ge.V(D(), com.huawei.openalliance.ad.constant.cf.V);
                    mediaEvents.firstQuartile();
                }
            }
        } catch (IllegalStateException e) {
            ge.V(D(), "firstQuartile, fail");
        }
    }

    @Override // com.huawei.hms.ads.jc
    public void Code(float f) {
        int Code2 = ij.Code(this.D, f);
        if (ge.Code()) {
            ge.Code(D(), "onProgress %s", Integer.valueOf(Code2));
        }
        if (Code2 == 25) {
            this.D = Code2;
            Code();
        } else if (Code2 == 50) {
            this.D = Code2;
            I();
        } else if (Code2 != 75) {
        } else {
            this.D = Code2;
            Z();
        }
    }

    @Override // com.huawei.hms.ads.Cif
    void Code(float f, float f2) {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    if (ge.Code()) {
                        ge.Code(D(), "start，duration %s", Float.valueOf(f));
                    }
                    mediaEvents.start(f, f2);
                }
            }
        } catch (IllegalStateException e) {
            ge.V(D(), "start, fail");
        }
    }

    @Override // com.huawei.hms.ads.jc
    public void Code(float f, boolean z) {
        this.F = 1;
        this.S = z;
        Code(f, z ? 0.0f : 1.0f);
    }

    @Override // com.huawei.hms.ads.id
    public void Code(is isVar) {
        String D;
        String str;
        if (I) {
            if ((isVar instanceof hw) && C()) {
                hw hwVar = (hw) isVar;
                Context I2 = hwVar.I();
                if (I2 != null) {
                    ge.V(D(), "Set VolumeChange observer");
                    ik ikVar = new ik(I2);
                    this.C = ikVar;
                    ikVar.Code(new ik.b() { // from class: com.huawei.hms.ads.ig.1
                        @Override // com.huawei.hms.ads.ik.b
                        public void Code() {
                            ig.this.F();
                        }
                    });
                }
                List<AdSession> V2 = hwVar.V();
                if (!V2.isEmpty()) {
                    for (AdSession adSession : V2) {
                        if (adSession != null) {
                            if (ge.Code()) {
                                ge.Code(D(), "setAdSessionAgent, add mVideoEventsList ");
                            }
                            this.Z.add(MediaEvents.createMediaEvents(adSession));
                            this.B.add(AdEvents.createAdEvents(adSession));
                        }
                    }
                    return;
                }
                D = D();
                str = "adSessionList is empty";
            } else {
                D = D();
                str = "adsessionAgent is null";
            }
            ge.V(D, str);
        }
    }

    @Override // com.huawei.hms.ads.Cif, com.huawei.hms.ads.jc
    public void Code(jd jdVar) {
        InteractionType Code2;
        if (!jd.Code() || (Code2 = jd.Code(jdVar)) == null) {
            return;
        }
        Code(Code2);
    }

    @Override // com.huawei.hms.ads.jc
    public void Code(je jeVar) {
        PlayerState Code2;
        if (!je.Code() || (Code2 = je.Code(jeVar)) == null) {
            return;
        }
        if (ge.Code()) {
            ge.Code(D(), "playerStateChange %s", jeVar.toString());
        }
        Code(Code2);
    }

    @Override // com.huawei.hms.ads.Cif, com.huawei.hms.ads.jc
    public void Code(jg jgVar) {
        VastProperties V2;
        if (jgVar == null || !jg.Code() || (V2 = jgVar.V()) == null) {
            return;
        }
        Code(V2);
    }

    @Override // com.huawei.hms.ads.Cif
    void Code(InteractionType interactionType) {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    if (ge.Code()) {
                        ge.Code(D(), "adUserInteraction ");
                    }
                    mediaEvents.adUserInteraction(interactionType);
                }
            }
        } catch (IllegalStateException e) {
            ge.V(D(), "adUserInteraction, fail");
        }
    }

    @Override // com.huawei.hms.ads.Cif
    void Code(PlayerState playerState) {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    mediaEvents.playerStateChange(PlayerState.COLLAPSED);
                }
            }
        } catch (IllegalStateException e) {
            ge.V(D(), "playerStateChange, fail");
        }
    }

    @Override // com.huawei.hms.ads.Cif
    void Code(VastProperties vastProperties) {
        if (this.B.isEmpty()) {
            return;
        }
        try {
            for (AdEvents adEvents : this.B) {
                if (adEvents != null) {
                    if (ge.Code()) {
                        ge.Code(D(), "loaded ");
                    }
                    adEvents.loaded(vastProperties);
                }
            }
        } catch (IllegalStateException e) {
            ge.V(D(), "loaded, fail");
        }
    }

    @Override // com.huawei.hms.ads.Cif
    void I() {
        if (this.Z.isEmpty()) {
            ge.I(D(), "midpoint, mVideoEventsList isEmpty");
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    ge.V(D(), "midpoint ");
                    mediaEvents.midpoint();
                }
            }
        } catch (IllegalStateException e) {
            ge.V(D(), "midpoint, fail");
        }
    }

    public ik S() {
        return this.C;
    }

    @Override // com.huawei.hms.ads.id
    public void V() {
        if (ge.Code()) {
            ge.Code(D(), "release ");
        }
        this.F = 0;
        ik ikVar = this.C;
        if (ikVar != null) {
            ikVar.V();
        }
        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.ig.2
            @Override // java.lang.Runnable
            public void run() {
                ig.this.Z.clear();
                ig.this.B.clear();
            }
        }, 200L);
    }

    @Override // com.huawei.hms.ads.Cif, com.huawei.hms.ads.jc
    public void V(float f) {
        ge.V(D(), "volumeChange %s", Float.valueOf(f));
        this.S = Math.abs(f - 0.0f) < 1.0E-8f;
        if (this.Z.isEmpty() || this.F != 1) {
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null && this.C != null) {
                    if (f == -1.0f) {
                        mediaEvents.volumeChange(this.C.Code(this.S));
                    } else {
                        mediaEvents.volumeChange(f);
                    }
                }
            }
        } catch (IllegalStateException e) {
            ge.V(D(), "volumeChange, fail");
        }
    }

    @Override // com.huawei.hms.ads.jc
    public void V(boolean z) {
        this.L = z;
    }

    @Override // com.huawei.hms.ads.Cif
    void Z() {
        if (this.Z.isEmpty()) {
            ge.I(D(), "thirdQuartile, mVideoEventsList isEmpty");
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    ge.V(D(), "thirdQuartile ");
                    mediaEvents.thirdQuartile();
                }
            }
        } catch (IllegalStateException e) {
            ge.V(D(), "thirdQuartile, fail");
        }
    }

    @Override // com.huawei.hms.ads.Cif, com.huawei.hms.ads.jc
    public void a() {
        this.D = 0.0f;
        this.F = 0;
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    if (ge.Code()) {
                        ge.Code(D(), "complete ");
                    }
                    mediaEvents.complete();
                }
            }
        } catch (IllegalStateException e) {
            ge.V(D(), "complete, fail");
        }
    }

    @Override // com.huawei.hms.ads.Cif, com.huawei.hms.ads.jc
    public void b() {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    if (ge.Code()) {
                        ge.Code(D(), "bufferStart ");
                    }
                    mediaEvents.bufferStart();
                }
            }
        } catch (IllegalStateException e) {
            ge.V(D(), "bufferStart, fail");
        }
    }

    @Override // com.huawei.hms.ads.Cif, com.huawei.hms.ads.jc
    public void c() {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    if (ge.Code()) {
                        ge.Code(D(), "bufferFinish ");
                    }
                    mediaEvents.bufferFinish();
                }
            }
        } catch (IllegalStateException e) {
            ge.V(D(), "bufferFinish, fail");
        }
    }

    @Override // com.huawei.hms.ads.Cif, com.huawei.hms.ads.jc
    public void d() {
        if (!this.L) {
            this.F = 0;
        }
        if (this.Z.isEmpty()) {
            ge.I(D(), "skipped, mVideoEventsList isEmpty");
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    if (ge.Code()) {
                        ge.Code(D(), "skipped ");
                    }
                    mediaEvents.skipped();
                }
            }
        } catch (IllegalStateException e) {
            ge.V(D(), "skipped, fail");
        }
    }

    @Override // com.huawei.hms.ads.Cif, com.huawei.hms.ads.jc
    public void e() {
        if (this.Z.isEmpty() || 1 != this.F) {
            return;
        }
        try {
            this.F = 2;
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    if (ge.Code()) {
                        ge.Code(D(), "pause ");
                    }
                    mediaEvents.pause();
                }
            }
        } catch (IllegalStateException e) {
            ge.V(D(), "pause, fail");
        }
    }

    @Override // com.huawei.hms.ads.Cif, com.huawei.hms.ads.jc
    public void f() {
        this.F = 1;
        if (this.Z.isEmpty()) {
            ge.I(D(), "resume, mVideoEventsList isEmpty");
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    if (ge.Code()) {
                        ge.Code(D(), "resume ");
                    }
                    mediaEvents.resume();
                }
            }
        } catch (IllegalStateException e) {
            ge.V(D(), "resume, fail");
        }
    }
}
