package com.soft.blued.ui.welcome.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/model/SplashExtraEntity.class */
public class SplashExtraEntity extends BluedEntityBaseExtra {
    public String ID;
    public String IMGURL;
    public int IS3RD;
    public float RECALL;
    public int TIMEOUT;
    public SplashConfig splash_config;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/model/SplashExtraEntity$SplashConfig.class */
    public static class SplashConfig {
        public float interval;
        public int security;
        public int timeout;
    }
}
