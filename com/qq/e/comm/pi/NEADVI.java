package com.qq.e.comm.pi;

import com.qq.e.ads.nativ.ADSize;
import com.qq.e.comm.adevent.ADListener;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/comm/pi/NEADVI.class */
public interface NEADVI extends LADI {
    void destroy();

    void preloadVideo();

    void render();

    void reportAdNegative();

    void setAdListener(ADListener aDListener);

    void setAdSize(ADSize aDSize);
}
