package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import java.util.HashMap;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/dj.class */
public class dj {

    /* renamed from: a  reason: collision with root package name */
    private Boolean f6581a;

    public dj(Context context, Activity activity, Boolean bool) {
        this.f6581a = bool;
        a().booleanValue();
    }

    public Boolean a() {
        return this.f6581a;
    }

    protected HashMap<String, String> b() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("xyz", "hihihi");
        return hashMap;
    }

    public String c() {
        return "http://211.151.146.65:8080/wlantest/shanghai_sun/mock_ad_server_intersitial_video.json";
    }
}
