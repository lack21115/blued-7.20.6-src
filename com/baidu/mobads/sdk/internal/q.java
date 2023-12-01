package com.baidu.mobads.sdk.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.mobads.sdk.api.CustomNotification;
import com.baidu.mobads.sdk.api.ICommonModuleObj;
import com.huawei.hms.push.constant.RemoteMessageConst;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/q.class */
public class q implements ICommonModuleObj {

    /* renamed from: a  reason: collision with root package name */
    private static volatile q f6600a;
    private CustomNotification b = new CustomNotification();

    private q() {
    }

    public static q a() {
        if (f6600a == null) {
            synchronized (q.class) {
                try {
                    if (f6600a == null) {
                        f6600a = new q();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f6600a;
    }

    @Override // com.baidu.mobads.sdk.api.ICommonModuleObj
    public Object createModuleObj(String str, JSONObject jSONObject) {
        if (!ICommonModuleObj.KEY_NOTIFICATION.equals(str) || jSONObject == null) {
            return null;
        }
        return this.b.getCustomNotification((Context) jSONObject.opt("context"), jSONObject.optString("channelId"), jSONObject.optString(RemoteMessageConst.Notification.TICKER), (Bitmap) jSONObject.opt("icon"), jSONObject.optString("title"), jSONObject.optString("content"), jSONObject.optString("status"), jSONObject.optBoolean(RemoteMessageConst.Notification.AUTO_CANCEL), jSONObject.optInt("progress"), jSONObject.optInt("smallIcon"), jSONObject.optString("action"), (PendingIntent) jSONObject.opt(com.huawei.openalliance.ad.download.app.d.d));
    }
}
