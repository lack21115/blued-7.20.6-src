package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import java.util.HashMap;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/dl.class */
public class dl {

    /* renamed from: a  reason: collision with root package name */
    private Boolean f9423a;

    public dl(Context context, Activity activity, Boolean bool) {
        this.f9423a = bool;
        a().booleanValue();
    }

    public Boolean a() {
        return this.f9423a;
    }

    protected HashMap<String, String> b() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("xyz", "hihihi");
        return hashMap;
    }

    public String c() {
        return null;
    }
}
