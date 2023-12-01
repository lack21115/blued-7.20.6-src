package com.heytap.msp.mobad.api.params;

import android.view.View;
import com.heytap.msp.mobad.api.ad.IBidding;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/params/INativeTempletAdView.class */
public interface INativeTempletAdView extends IBidding {
    public static final String TAG = "INativeTempletAdView";

    void destroy();

    View getAdView();

    void render();
}
