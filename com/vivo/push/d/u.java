package com.vivo.push.d;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.IntentConstant;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/d/u.class */
public final class u extends z {
    /* JADX INFO: Access modifiers changed from: package-private */
    public u(com.vivo.push.o oVar) {
        super(oVar);
    }

    private void a(UPSNotificationMessage uPSNotificationMessage) {
        com.vivo.push.m.c(new w(this, uPSNotificationMessage));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Intent b(Intent intent, Map<String, String> map) {
        if (map != null) {
            if (map.entrySet() == null) {
                return intent;
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null && entry.getKey() != null) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }
        }
        return intent;
    }

    @Override // com.vivo.push.l
    public final void a(com.vivo.push.o oVar) {
        String str;
        Intent parseUri;
        String str2;
        com.vivo.push.b.p pVar = (com.vivo.push.b.p) oVar;
        InsideNotificationItem f = pVar.f();
        if (f == null) {
            com.vivo.push.util.p.d("OnNotificationClickTask", "current notification item is null");
            return;
        }
        UPSNotificationMessage a2 = com.vivo.push.util.q.a(f);
        boolean equals = this.f41105a.getPackageName().equals(pVar.d());
        if (equals) {
            NotifyAdapterUtil.cancelNotify(this.f41105a);
        }
        if (!equals) {
            com.vivo.push.util.p.a("OnNotificationClickTask", "notify is " + a2 + " ; isMatch is " + equals);
            return;
        }
        com.vivo.push.b.x xVar = new com.vivo.push.b.x(1030L);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("type", "2");
        hashMap.put(IntentConstant.MESSAGE_ID, String.valueOf(pVar.e()));
        hashMap.put("platform", this.f41105a.getPackageName());
        String b = com.vivo.push.util.z.b(this.f41105a, this.f41105a.getPackageName());
        if (!TextUtils.isEmpty(b)) {
            hashMap.put("remoteAppId", b);
        }
        xVar.a(hashMap);
        com.vivo.push.e.a().a(xVar);
        com.vivo.push.util.p.d("OnNotificationClickTask", "notification is clicked by skip type[" + a2.getSkipType() + "]");
        int skipType = a2.getSkipType();
        if (skipType == 1) {
            new Thread(new v(this, this.f41105a, a2.getParams())).start();
            a(a2);
        } else if (skipType == 2) {
            String skipContent = a2.getSkipContent();
            boolean z = true;
            if (!skipContent.startsWith("http://")) {
                z = skipContent.startsWith("https://");
            }
            if (z) {
                Uri parse = Uri.parse(skipContent);
                Intent intent = new Intent("android.intent.action.VIEW", parse);
                intent.setFlags(268435456);
                b(intent, a2.getParams());
                try {
                    this.f41105a.startActivity(intent);
                } catch (Exception e) {
                    str = "startActivity error : ".concat(String.valueOf(parse));
                }
                a(a2);
            }
            str = "url not legal";
            com.vivo.push.util.p.a("OnNotificationClickTask", str);
            a(a2);
        } else if (skipType == 3) {
            a(a2);
        } else if (skipType != 4) {
            com.vivo.push.util.p.a("OnNotificationClickTask", "illegitmacy skip type error : " + a2.getSkipType());
        } else {
            String skipContent2 = a2.getSkipContent();
            try {
                parseUri = Intent.parseUri(skipContent2, 1);
                str2 = parseUri.getPackage();
            } catch (Exception e2) {
                com.vivo.push.util.p.a("OnNotificationClickTask", "open activity error : ".concat(String.valueOf(skipContent2)), e2);
            }
            if (!TextUtils.isEmpty(str2) && !this.f41105a.getPackageName().equals(str2)) {
                com.vivo.push.util.p.a("OnNotificationClickTask", "open activity error : local pkgName is " + this.f41105a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                return;
            }
            String packageName = parseUri.getComponent() == null ? null : parseUri.getComponent().getPackageName();
            if (!TextUtils.isEmpty(packageName) && !this.f41105a.getPackageName().equals(packageName)) {
                com.vivo.push.util.p.a("OnNotificationClickTask", "open activity component error : local pkgName is " + this.f41105a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                return;
            }
            parseUri.setSelector(null);
            parseUri.setPackage(this.f41105a.getPackageName());
            parseUri.addFlags(335544320);
            b(parseUri, a2.getParams());
            ActivityInfo resolveActivityInfo = parseUri.resolveActivityInfo(this.f41105a.getPackageManager(), 65536);
            if (resolveActivityInfo == null || resolveActivityInfo.exported) {
                this.f41105a.startActivity(parseUri);
                a(a2);
                return;
            }
            com.vivo.push.util.p.a("OnNotificationClickTask", "activity is not exported : " + resolveActivityInfo.toString());
        }
    }
}
