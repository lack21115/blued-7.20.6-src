package com.huawei.hms.push;

import android.app.Notification;
import android.text.TextUtils;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/push/h.class */
public class h {
    public static i a(m mVar) {
        i iVar = i.STYLE_DEFAULT;
        i iVar2 = iVar;
        if (mVar.w() >= 0) {
            iVar2 = iVar;
            if (mVar.w() < i.values().length) {
                iVar2 = i.values()[mVar.w()];
            }
        }
        return iVar2;
    }

    public static void a(Notification.Builder builder, String str, m mVar) {
        Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
        if (!TextUtils.isEmpty(mVar.h())) {
            bigTextStyle.setBigContentTitle(mVar.h());
        }
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            bigTextStyle.bigText(str);
        }
        builder.setStyle(bigTextStyle);
    }
}
