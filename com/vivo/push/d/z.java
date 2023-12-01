package com.vivo.push.d;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.rtmp.TXLiveConstants;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.NotifyAdapterUtil;
import java.security.PublicKey;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/d/z.class */
public abstract class z extends com.vivo.push.l {
    protected PushMessageCallback b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(com.vivo.push.o oVar) {
        super(oVar);
    }

    public final void a(PushMessageCallback pushMessageCallback) {
        this.b = pushMessageCallback;
    }

    public final boolean a(PublicKey publicKey, String str, String str2) {
        String str3;
        if (!com.vivo.push.e.a().d()) {
            com.vivo.push.util.p.d("OnVerifyCallBackCommand", "vertify is not support , vertify is ignore");
            return true;
        }
        if (publicKey == null) {
            str3 = "vertify key is null";
        } else if (TextUtils.isEmpty(str)) {
            str3 = "contentTag is null";
        } else if (TextUtils.isEmpty(str2)) {
            str3 = "vertify id is null";
        } else {
            try {
                com.vivo.push.util.p.d("OnVerifyCallBackCommand", str.hashCode() + " = " + str2);
                if (com.vivo.push.util.u.a(str.getBytes("UTF-8"), publicKey, Base64.decode(str2, 2))) {
                    com.vivo.push.util.p.d("OnVerifyCallBackCommand", "vertify id is success");
                    return true;
                }
                com.vivo.push.util.p.d("OnVerifyCallBackCommand", "vertify fail srcDigest is ".concat(String.valueOf(str)));
                com.vivo.push.util.p.c(this.f27414a, "vertify fail srcDigest is ".concat(String.valueOf(str)));
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                str3 = "vertify exception";
            }
        }
        com.vivo.push.util.p.d("OnVerifyCallBackCommand", str3);
        return false;
    }

    public final int b() {
        if (Build.VERSION.SDK_INT >= 24) {
            NotificationManager notificationManager = (NotificationManager) this.f27414a.getSystemService("notification");
            if (notificationManager == null || notificationManager.areNotificationsEnabled()) {
                if (Build.VERSION.SDK_INT < 26 || notificationManager == null) {
                    return 0;
                }
                try {
                    NotificationChannel notificationChannel = notificationManager.getNotificationChannel(NotifyAdapterUtil.PRIMARY_CHANNEL);
                    if (notificationChannel != null) {
                        return notificationChannel.getImportance() == 0 ? 2121 : 0;
                    }
                    return 0;
                } catch (Exception e) {
                    com.vivo.push.util.p.b("OnVerifyCallBackCommand", "判断通知通道出现系统错误");
                    return 0;
                }
            }
            return TXLiveConstants.PLAY_WARNING_RECV_DATA_LAG;
        }
        return 0;
    }
}
