package com.blued.login.face;

import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.CommonPreferences;
import com.google.gson.Gson;

/* loaded from: source-7206380-dex2jar.jar:com/blued/login/face/AVConfig.class */
public class AVConfig {
    private static AVConfig b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f20536a = false;

    /* renamed from: c  reason: collision with root package name */
    private AVConfigModel f20537c;

    private AVConfig() {
        Gson f = AppInfo.f();
        String t = CommonPreferences.t();
        if (StringUtils.b(t)) {
            this.f20537c = new AVConfigModel();
            return;
        }
        try {
            this.f20537c = (AVConfigModel) f.fromJson(t, (Class<Object>) AVConfigModel.class);
        } catch (Exception e) {
            this.f20537c = new AVConfigModel();
        }
    }

    public static AVConfig a() {
        AVConfig aVConfig;
        synchronized (AVConfig.class) {
            try {
                if (b == null) {
                    b = new AVConfig();
                }
                aVConfig = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVConfig;
    }

    public void a(AVConfigModel aVConfigModel, boolean z) {
        this.f20536a = z;
        try {
            String json = AppInfo.f().toJson(aVConfigModel);
            this.f20537c = aVConfigModel;
            CommonPreferences.y(json);
        } catch (Exception e) {
            CommonPreferences.y("");
        }
    }

    public void a(boolean z) {
        this.f20536a = z;
    }

    public AVConfigModel b() {
        AVConfigModel aVConfigModel = this.f20537c;
        AVConfigModel aVConfigModel2 = aVConfigModel;
        if (aVConfigModel == null) {
            aVConfigModel2 = new AVConfigModel();
        }
        return aVConfigModel2;
    }
}
