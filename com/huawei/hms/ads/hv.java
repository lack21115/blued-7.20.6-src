package com.huawei.hms.ads;

import android.content.Context;
import android.view.View;
import com.anythink.expressad.foundation.d.c;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/hv.class */
public class hv implements ih {
    private static final String Code = "OmPresent";
    private is I;
    private id V;
    private boolean Z;
    private boolean B = true;
    private boolean C = false;
    private boolean S = false;
    private boolean F = false;
    private boolean D = false;

    @Override // com.huawei.hms.ads.is
    public void B() {
        is isVar = this.I;
        if (isVar == null) {
            return;
        }
        isVar.B();
    }

    @Override // com.huawei.hms.ads.is
    public void C() {
        is isVar = this.I;
        if (isVar == null) {
            return;
        }
        isVar.C();
    }

    public id Code() {
        return this.V;
    }

    @Override // com.huawei.hms.ads.jc
    public void Code(float f) {
        if (ge.Code()) {
            ge.Code(Code, "onProgress, isAllowRepeat= %s, isVideoComplete= %s", Boolean.valueOf(this.B), Boolean.valueOf(this.C));
        }
        if (this.B || !this.C) {
            id idVar = this.V;
            if (idVar instanceof ig) {
                ((ig) idVar).Code(f);
            }
        }
    }

    @Override // com.huawei.hms.ads.jc
    public void Code(float f, boolean z) {
        ge.V(Code, "start");
        if (!this.B && this.C) {
            ge.I(Code, "start: Video completed");
            return;
        }
        id idVar = this.V;
        if (idVar instanceof ig) {
            ((ig) idVar).Code(f, z);
        }
    }

    @Override // com.huawei.hms.ads.ih
    public void Code(Context context, AdContentData adContentData, hr hrVar, boolean z) {
        if ((adContentData != null ? adContentData.ae() : null) == null) {
            ge.V(Code, "om is null, no initialization is required");
        } else if (this.F) {
        } else {
            ge.V(Code, "init omPresent");
            this.I = hx.Code(context, adContentData, hrVar, z);
            id Code2 = ic.Code(adContentData);
            this.V = Code2;
            Code2.Code(this.I);
            this.Z = z;
            this.F = true;
            this.D = false;
            this.S = false;
        }
    }

    @Override // com.huawei.hms.ads.is
    public void Code(View view) {
        if (this.Z) {
            return;
        }
        is isVar = this.I;
        if (isVar == null) {
            ge.V(Code, "AdSessionAgent is null");
        } else {
            isVar.Code(view);
        }
    }

    @Override // com.huawei.hms.ads.is
    public void Code(View view, ir irVar, String str) {
        is isVar = this.I;
        if (isVar == null) {
            return;
        }
        isVar.Code(view, irVar, str);
    }

    @Override // com.huawei.hms.ads.is
    public void Code(iq iqVar, String str) {
        is isVar = this.I;
        if (isVar == null) {
            return;
        }
        isVar.Code(iqVar, str);
    }

    @Override // com.huawei.hms.ads.ix
    public void Code(jb jbVar) {
        ge.V(Code, "load vastPropertiesWrapper");
        if (this.B || !this.S) {
            id idVar = this.V;
            if (idVar instanceof hy) {
                ((hy) idVar).Code(jbVar);
            }
        }
    }

    @Override // com.huawei.hms.ads.jc
    public void Code(jd jdVar) {
        id idVar = this.V;
        if (idVar instanceof ig) {
            ((ig) idVar).Code(jdVar);
        }
    }

    @Override // com.huawei.hms.ads.jc
    public void Code(je jeVar) {
        id idVar = this.V;
        if (idVar instanceof ig) {
            ((ig) idVar).Code(jeVar);
        }
    }

    @Override // com.huawei.hms.ads.jc
    public void Code(jg jgVar) {
        if (!this.B && this.C) {
            ge.I(Code, "loaded: Video completed");
        } else if (this.D) {
            if (ge.Code()) {
                ge.Code(Code, "Already loaded");
            }
        } else {
            id idVar = this.V;
            if (idVar instanceof ig) {
                ((ig) idVar).Code(jgVar);
            }
            this.D = true;
        }
    }

    @Override // com.huawei.hms.ads.ih
    public void Code(boolean z) {
        this.B = z;
    }

    @Override // com.huawei.hms.ads.ix
    public void D() {
        ge.V(Code, "impressionOccurred");
        if (this.S) {
            return;
        }
        id idVar = this.V;
        if (idVar instanceof hy) {
            ((hy) idVar).D();
            this.S = true;
        }
        id idVar2 = this.V;
        if (idVar2 instanceof ig) {
            ((ig) idVar2).B();
            this.S = true;
        }
    }

    @Override // com.huawei.hms.ads.is
    public String F() {
        is isVar = this.I;
        if (isVar == null) {
            return null;
        }
        return isVar.F();
    }

    @Override // com.huawei.hms.ads.ih
    public void I() {
        ge.V(Code, "release");
        if (this.F) {
            this.B = true;
            this.C = false;
            this.S = false;
            id idVar = this.V;
            if (idVar != null) {
                idVar.V();
            }
            is isVar = this.I;
            if (isVar != null) {
                isVar.B();
            }
            this.F = false;
        }
    }

    @Override // com.huawei.hms.ads.is
    public void I(View view) {
        is isVar = this.I;
        if (isVar == null) {
            return;
        }
        isVar.I(view);
    }

    @Override // com.huawei.hms.ads.ix
    public void L() {
        ge.V(Code, "load");
        if (this.B || !this.S) {
            id idVar = this.V;
            if (idVar instanceof hy) {
                ((hy) idVar).L();
            }
        }
    }

    @Override // com.huawei.hms.ads.is
    public io S() {
        is isVar = this.I;
        if (isVar == null) {
            return null;
        }
        return isVar.S();
    }

    @Override // com.huawei.hms.ads.ih
    public is V() {
        return this.I;
    }

    @Override // com.huawei.hms.ads.jc
    public void V(float f) {
        if (!this.B && this.C) {
            ge.I(Code, "volumeChange: Video completed");
            return;
        }
        id idVar = this.V;
        if (idVar instanceof ig) {
            ((ig) idVar).V(f);
        }
    }

    @Override // com.huawei.hms.ads.is
    public void V(View view) {
        is isVar = this.I;
        if (isVar == null) {
            return;
        }
        isVar.V(view);
    }

    @Override // com.huawei.hms.ads.jc
    public void V(boolean z) {
        id idVar = this.V;
        if (idVar instanceof ig) {
            ((ig) idVar).V(z);
        }
    }

    @Override // com.huawei.hms.ads.is
    public void Z() {
        is isVar = this.I;
        if (isVar == null) {
            ge.V(Code, "AdSessionAgent is null");
        } else {
            isVar.Z();
        }
    }

    @Override // com.huawei.hms.ads.jc
    public void a() {
        ge.V(Code, "complete");
        if (this.B || !this.C) {
            id idVar = this.V;
            if (idVar instanceof ig) {
                ((ig) idVar).a();
                this.C = true;
            }
        }
    }

    @Override // com.huawei.hms.ads.jc
    public void b() {
        if (this.B || !this.C) {
            id idVar = this.V;
            if (idVar instanceof ig) {
                ((ig) idVar).b();
            }
        }
    }

    @Override // com.huawei.hms.ads.jc
    public void c() {
        if (this.B || !this.C) {
            id idVar = this.V;
            if (idVar instanceof ig) {
                ((ig) idVar).c();
            }
        }
    }

    @Override // com.huawei.hms.ads.jc
    public void d() {
        ge.V(Code, "skipped");
        id idVar = this.V;
        if (idVar instanceof ig) {
            ((ig) idVar).d();
        }
    }

    @Override // com.huawei.hms.ads.jc
    public void e() {
        ge.V(Code, c.cb);
        if (!this.B && this.C) {
            ge.I(Code, "pause: Video completed");
            return;
        }
        id idVar = this.V;
        if (idVar instanceof ig) {
            ((ig) idVar).e();
        }
    }

    @Override // com.huawei.hms.ads.jc
    public void f() {
        ge.V(Code, "resume");
        if (!this.B && this.C) {
            ge.I(Code, "resume: Video completed");
            return;
        }
        id idVar = this.V;
        if (idVar instanceof ig) {
            ((ig) idVar).f();
        }
    }
}
