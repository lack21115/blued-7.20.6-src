package com.huawei.hms.ads;

import android.view.View;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/lj.class */
public interface lj extends hi, hr, ls {
    void B();

    boolean C();

    void Code(int i);

    void Code(int i, int i2);

    void Code(View view, Integer num);

    void Code(ih ihVar);

    void D();

    void F();

    void I(int i);

    void V();

    void Z();

    gz getAdMediator();

    void setAdContent(AdContentData adContentData);

    void setAdMediator(gz gzVar);

    void setAudioFocusType(int i);

    void setDisplayDuration(int i);
}
