package com.hihonor.push.sdk;

import android.content.Context;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/HonorPushClient.class */
public class HonorPushClient {

    /* renamed from: a  reason: collision with root package name */
    public static final HonorPushClient f22276a = new HonorPushClient();

    public static HonorPushClient getInstance() {
        return f22276a;
    }

    public void deletePushToken(HonorPushCallback<Void> honorPushCallback) {
        d.e.a(honorPushCallback);
    }

    public void getNotificationCenterStatus(HonorPushCallback<Boolean> honorPushCallback) {
        d.e.j(honorPushCallback);
    }

    public void getPushToken(HonorPushCallback<String> honorPushCallback) {
        d.e.a(honorPushCallback, false);
    }

    public void getUnReadMessageBox(HonorPushCallback<List<HonorPushDataMsg>> honorPushCallback) {
        d.e.d(honorPushCallback);
    }

    public void init(Context context, boolean z) {
        d dVar = d.e;
        f fVar = new f();
        fVar.f22290a = context.getApplicationContext();
        fVar.b = z;
        dVar.a(fVar);
    }

    public void turnOffNotificationCenter(HonorPushCallback<Void> honorPushCallback) {
        d.e.b(honorPushCallback);
    }

    public void turnOnNotificationCenter(HonorPushCallback<Void> honorPushCallback) {
        d.e.c(honorPushCallback);
    }
}
