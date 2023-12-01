package com.bytedance.applog.picker;

import android.app.Application;
import com.bytedance.applog.IPicker;
import com.bytedance.applog.InitConfig;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/applog/picker/Picker.class */
public class Picker implements IPicker {

    /* renamed from: a  reason: collision with root package name */
    public String f21180a;

    public Picker(Application application, InitConfig initConfig) {
    }

    @Override // com.bytedance.applog.IPicker
    public String getMarqueeCookie() {
        return this.f21180a;
    }

    @Override // com.bytedance.applog.IPicker
    public void setMarqueeCookie(String str) {
        this.f21180a = str;
    }
}
