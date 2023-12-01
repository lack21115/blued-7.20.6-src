package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CpuChannelListManager;
import com.baidu.mobads.sdk.api.CpuChannelResponse;
import com.baidu.mobads.sdk.api.IOAdEvent;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/n.class */
class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IOAdEvent f9436a;
    final /* synthetic */ m b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, IOAdEvent iOAdEvent) {
        this.b = mVar;
        this.f9436a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener2;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener3;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener4;
        IOAdEvent iOAdEvent = this.f9436a;
        if (iOAdEvent == null || TextUtils.isEmpty(iOAdEvent.getType())) {
            return;
        }
        String type = this.f9436a.getType();
        if (w.an.equals(type)) {
            List<CpuChannelResponse> a2 = k.a((JSONArray) this.f9436a.getData().get("cpuChannelList"));
            cpuChannelListListener3 = this.b.f9435a.q;
            if (cpuChannelListListener3 != null) {
                cpuChannelListListener4 = this.b.f9435a.q;
                cpuChannelListListener4.onChannelListLoaded(a2);
            }
        } else if (w.ao.equals(type)) {
            Map<String, Object> data = this.f9436a.getData();
            int i = 0;
            if (data != null) {
                String str2 = (String) data.get("error_message");
                Object obj = data.get("error_code");
                Integer num = obj;
                if (obj == null) {
                    num = 0;
                }
                i = ((Integer) num).intValue();
                str = str2;
            } else {
                str = "";
            }
            cpuChannelListListener = this.b.f9435a.q;
            if (cpuChannelListListener != null) {
                cpuChannelListListener2 = this.b.f9435a.q;
                cpuChannelListListener2.onChannelListError(str, i);
            }
        }
    }
}
