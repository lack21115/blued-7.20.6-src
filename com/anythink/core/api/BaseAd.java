package com.anythink.core.api;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.core.common.b.l;
import com.anythink.core.common.e.e;
import java.util.List;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/api/BaseAd.class */
public abstract class BaseAd implements IATThirdPartyMaterial {
    public abstract void destroy();

    public abstract ViewGroup getCustomAdContainer();

    public abstract e getDetail();

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public abstract Map<String, Object> getNetworkInfoMap();

    public abstract void registerListener(View view, List<View> list, FrameLayout.LayoutParams layoutParams);

    public abstract void setNativeEventListener(l lVar);

    public abstract void setNetworkInfoMap(Map<String, Object> map);

    public abstract void setTrackingInfo(e eVar);

    public abstract void setVideoMute(boolean z);
}
