package com.anythink.network.gdt;

import com.anythink.core.api.ATInitConfig;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/gdt/GDTATInitConfig.class */
public class GDTATInitConfig extends ATInitConfig {
    public GDTATInitConfig(String str) {
        this.paramMap.put("app_id", str);
        this.initMediation = GDTATInitManager.getInstance();
    }
}
