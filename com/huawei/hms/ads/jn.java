package com.huawei.hms.ads;

import android.content.Context;
import android.os.CountDownTimer;
import com.huawei.hms.ads.lj;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/jn.class */
public abstract class jn<V extends lj> extends hg<V> implements kd<V> {
    private CountDownTimer B;
    protected Context V;
    private boolean Z = false;
    private boolean C = false;

    public jn(Context context, V v) {
        this.V = context.getApplicationContext();
        Code((jn<V>) v);
    }

    private void I(String str) {
        if (this.Z) {
            ge.V("PPSBaseViewPresenter", str);
            return;
        }
        this.Z = true;
        B();
        Code();
    }

    @Override // com.huawei.hms.ads.kd
    public void B() {
        if (this.C) {
            ge.V("PPSBaseViewPresenter", "already reset");
        }
        this.C = true;
        if (I() != 0) {
            ((lj) I()).destroyView();
        }
    }

    public void Code() {
        ge.V("PPSBaseViewPresenter", "cancelDisplayDurationCountTask");
        CountDownTimer countDownTimer = this.B;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.B = null;
        }
    }

    @Override // com.huawei.hms.ads.kd
    public void Code(int i) {
        ge.V("PPSBaseViewPresenter", "startDisplayDurationCountTask duration: %d", Integer.valueOf(i));
        CountDownTimer countDownTimer = this.B;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(i, 500L) { // from class: com.huawei.hms.ads.jn.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                ((lj) jn.this.I()).I(1);
                jn.this.V();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                int max = Math.max(1, (int) Math.ceil((((float) j) * 1.0f) / 1000.0f));
                ge.Code("PPSBaseViewPresenter", "count down time: %d seconds: %d", Long.valueOf(j), Integer.valueOf(max));
                ((lj) jn.this.I()).I(max);
            }
        };
        this.B = countDownTimer2;
        countDownTimer2.start();
    }

    @Override // com.huawei.hms.ads.kd
    public void Code(int i, int i2, AdContentData adContentData, Long l, com.huawei.openalliance.ad.inter.data.m mVar, int i3) {
        ge.V("PPSBaseViewPresenter", "onTouch");
        gz adMediator = ((lj) I()).getAdMediator();
        if (adMediator == null || !adMediator.Code(i, i2, adContentData, l, mVar, i3)) {
            return;
        }
        if (this.Z) {
            ge.V("PPSBaseViewPresenter", "onDoActionSucc hasShowFinish");
            return;
        }
        this.Z = true;
        B();
        Code();
    }

    @Override // com.huawei.hms.ads.kd
    public void Code(int i, int i2, Long l) {
        ge.V("PPSBaseViewPresenter", "skip ad - hasShowFinish: %s", Boolean.valueOf(this.Z));
        if (this.Z) {
            return;
        }
        this.Z = true;
        B();
        Code();
    }

    @Override // com.huawei.hms.ads.kd
    public void Code(AdContentData adContentData) {
        this.Code = adContentData;
        Code(com.huawei.openalliance.ad.utils.au.Code(Long.valueOf(com.huawei.openalliance.ad.utils.v.Code())));
        if (adContentData == null) {
            ge.I("PPSBaseViewPresenter", "loadAdMaterial contentRecord is null");
            ((lj) I()).Code(-7);
            return;
        }
        ge.V("PPSBaseViewPresenter", "loadAdMaterial");
        V(adContentData.d());
        com.huawei.openalliance.ad.utils.d.Code(this.V, adContentData);
    }

    @Override // com.huawei.hms.ads.kd
    public void Code(AdContentData adContentData, long j, int i) {
        gz adMediator = ((lj) I()).getAdMediator();
        if (adMediator != null) {
            adMediator.Code(adContentData, j, i);
        }
    }

    @Override // com.huawei.hms.ads.kd
    public void Code(Long l) {
        I("onWhyThisAd hasShowFinish");
    }

    @Override // com.huawei.hms.ads.kd
    public void V() {
        ge.V("PPSBaseViewPresenter", "onDisplayTimeUp hasShowFinish: %s", Boolean.valueOf(this.Z));
        if (this.Z) {
            return;
        }
        this.Z = true;
        B();
        gz adMediator = ((lj) I()).getAdMediator();
        if (adMediator != null) {
            adMediator.i();
        }
    }

    public void V(AdContentData adContentData) {
        gz adMediator = ((lj) I()).getAdMediator();
        if (adMediator != null) {
            adMediator.Z(adContentData);
        }
    }

    @Override // com.huawei.hms.ads.kd
    public void V(Long l) {
        I("feedback hasShowFinish");
    }

    protected abstract void V(String str);
}
