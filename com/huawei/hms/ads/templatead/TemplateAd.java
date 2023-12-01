package com.huawei.hms.ads.templatead;

import android.view.View;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/templatead/TemplateAd.class */
public interface TemplateAd {
    void destroy();

    String getContentId();

    Map<String, String> getExt();

    View getTemplateAdView();

    String getUniqueId();

    boolean isExpire();

    void render();
}
