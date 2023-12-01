package com.huawei.hms.ads;

import android.content.Context;
import android.view.View;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/lh.class */
public interface lh extends hi, hr {
    Integer Code(AdContentData adContentData);

    void Code(int i);

    void Code(int i, int i2, String str, boolean z, Integer num);

    void Code(int i, boolean z);

    void Code(View view);

    void Code(lj ljVar, Integer num);

    void Code(lu luVar);

    void Code(AdContentData adContentData, int i);

    void I(int i);

    lj V(int i);

    void V();

    AdSlotParam getAdSlotParam();

    int getAdType();

    int getAudioFocusType();

    Context getContext();
}
