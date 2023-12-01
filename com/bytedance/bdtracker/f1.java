package com.bytedance.bdtracker;

import android.text.TextUtils;
import com.bytedance.applog.AppLog;
import com.bytedance.applog.IDataObserver;
import com.bytedance.applog.onekit.DeviceComponentRegistrar;
import com.volcengine.onekit.component.ComponentContainer;
import com.volcengine.onekit.service.Device;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/f1.class */
public class f1 implements IDataObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentContainer f7611a;

    public f1(DeviceComponentRegistrar.a aVar, ComponentContainer componentContainer) {
        this.f7611a = componentContainer;
    }

    @Override // com.bytedance.applog.IDataObserver
    public void onAbVidsChange(String str, String str2) {
    }

    @Override // com.bytedance.applog.IDataObserver
    public void onIdLoaded(String str, String str2, String str3) {
        if (TextUtils.isEmpty(AppLog.getDid())) {
            return;
        }
        this.f7611a.set(new g1(), new Class[]{Device.class});
        AppLog.removeDataObserver(this);
    }

    @Override // com.bytedance.applog.IDataObserver
    public void onRemoteAbConfigGet(boolean z, JSONObject jSONObject) {
    }

    @Override // com.bytedance.applog.IDataObserver
    public void onRemoteConfigGet(boolean z, JSONObject jSONObject) {
    }

    @Override // com.bytedance.applog.IDataObserver
    public void onRemoteIdGet(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(AppLog.getDid())) {
            return;
        }
        this.f7611a.set(new g1(), new Class[]{Device.class});
        AppLog.removeDataObserver(this);
    }
}
