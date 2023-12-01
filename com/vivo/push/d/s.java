package com.vivo.push.d;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.IntentConstant;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/d/s.class */
public final class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ InsideNotificationItem f41084a;
    final /* synthetic */ com.vivo.push.b.q b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ r f41085c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, InsideNotificationItem insideNotificationItem, com.vivo.push.b.q qVar) {
        this.f41085c = rVar;
        this.f41084a = insideNotificationItem;
        this.b = qVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        boolean z;
        Context context7;
        Context context8;
        Context context9;
        Context context10;
        Context context11;
        Context context12;
        Context context13;
        Context context14;
        PushMessageCallback pushMessageCallback = this.f41085c.b;
        context = this.f41085c.f41105a;
        if (pushMessageCallback.onNotificationMessageArrived(context, com.vivo.push.util.q.a(this.f41084a))) {
            StringBuilder sb = new StringBuilder("pkg name : ");
            context11 = this.f41085c.f41105a;
            sb.append(context11.getPackageName());
            sb.append(" 应用主动拦截通知");
            com.vivo.push.util.p.b("OnNotificationArrivedTask", sb.toString());
            context12 = this.f41085c.f41105a;
            com.vivo.push.util.p.b(context12, "应用主动拦截通知，导致通知无法展示，如需打开请在onNotificationMessageArrived中返回false");
            HashMap hashMap = new HashMap();
            hashMap.put(IntentConstant.MESSAGE_ID, String.valueOf(this.b.f()));
            context13 = this.f41085c.f41105a;
            context14 = this.f41085c.f41105a;
            String b = com.vivo.push.util.z.b(context13, context14.getPackageName());
            if (!TextUtils.isEmpty(b)) {
                hashMap.put("remoteAppId", b);
            }
            com.vivo.push.util.e.a(2120L, hashMap);
            return;
        }
        int b2 = this.f41085c.b();
        if (b2 > 0) {
            StringBuilder sb2 = new StringBuilder("pkg name : ");
            context7 = this.f41085c.f41105a;
            sb2.append(context7.getPackageName());
            sb2.append(" notify channel switch is ");
            sb2.append(b2);
            com.vivo.push.util.p.b("OnNotificationArrivedTask", sb2.toString());
            context8 = this.f41085c.f41105a;
            com.vivo.push.util.p.b(context8, "允许通知开关或者推送通知渠道开关关闭，导致通知无法展示，请到设置页打开应用通知开关 ".concat(String.valueOf(b2)));
            HashMap hashMap2 = new HashMap();
            hashMap2.put(IntentConstant.MESSAGE_ID, String.valueOf(this.b.f()));
            context9 = this.f41085c.f41105a;
            context10 = this.f41085c.f41105a;
            String b3 = com.vivo.push.util.z.b(context9, context10.getPackageName());
            if (!TextUtils.isEmpty(b3)) {
                hashMap2.put("remoteAppId", b3);
            }
            com.vivo.push.util.e.a(b2, hashMap2);
            return;
        }
        context2 = this.f41085c.f41105a;
        InsideNotificationItem insideNotificationItem = this.f41084a;
        long f = this.b.f();
        PushMessageCallback pushMessageCallback2 = this.f41085c.b;
        context3 = this.f41085c.f41105a;
        com.vivo.push.util.k kVar = new com.vivo.push.util.k(context2, insideNotificationItem, f, pushMessageCallback2.isAllowNet(context3), new t(this));
        boolean isShowBigPicOnMobileNet = this.f41084a.isShowBigPicOnMobileNet();
        String purePicUrl = this.f41084a.getPurePicUrl();
        String str = purePicUrl;
        if (TextUtils.isEmpty(purePicUrl)) {
            str = this.f41084a.getCoverUrl();
        }
        String str2 = str;
        if (!TextUtils.isEmpty(str)) {
            com.vivo.push.util.p.c("OnNotificationArrivedTask", "showCode=".concat(String.valueOf(isShowBigPicOnMobileNet)));
            if (isShowBigPicOnMobileNet) {
                context4 = this.f41085c.f41105a;
                com.vivo.push.util.p.a(context4, "mobile net show");
                str2 = str;
            } else {
                context5 = this.f41085c.f41105a;
                com.vivo.push.util.p.a(context5, "mobile net unshow");
                context6 = this.f41085c.f41105a;
                NetworkInfo a2 = com.vivo.push.util.r.a(context6);
                if (a2 != null && a2.getState() == NetworkInfo.State.CONNECTED) {
                    int type = a2.getType();
                    z = type == 1 ? true : type == 0 ? true : true;
                } else {
                    z = false;
                }
                str2 = str;
                if (z) {
                    str2 = null;
                    this.f41084a.clearCoverUrl();
                    this.f41084a.clearPurePicUrl();
                }
            }
        }
        kVar.execute(this.f41084a.getIconUrl(), str2);
    }
}
