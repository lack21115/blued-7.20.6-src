package com.huawei.hms.ads.templatead;

import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/templatead/TemplateAdListener.class */
public interface TemplateAdListener {
    void onAdLoaded(Map<String, List<TemplateAd>> map);

    void onError(int i);
}
