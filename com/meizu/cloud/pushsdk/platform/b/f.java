package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/platform/b/f.class */
public class f extends c<PushSwitchStatus> {
    private String h;
    private int i;
    private boolean j;
    private final Map<String, Boolean> k;

    public f(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, null, null, null, aVar, scheduledExecutorService);
    }

    public f(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, aVar, scheduledExecutorService);
        this.g = z;
    }

    public f(Context context, String str, String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
        this.i = 0;
        this.k = new HashMap();
    }

    public f(Context context, String str, String str2, String str3, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, str, str2, aVar, scheduledExecutorService);
        this.h = str3;
    }

    private com.meizu.cloud.pushsdk.c.a.c<String> b(PushSwitchStatus pushSwitchStatus) {
        boolean z;
        boolean r;
        boolean p;
        int i = this.i;
        if (i != 0) {
            if (i == 1) {
                pushSwitchStatus.setMessage("SWITCH_THROUGH_MESSAGE");
                if (r() != this.j || t()) {
                    f(true);
                    d(this.j);
                    return this.e.a(this.b, this.f24188c, this.h, this.i, this.j);
                }
                p = p();
            } else if (i == 2) {
                pushSwitchStatus.setMessage("CHECK_PUSH");
                if (!q() || !s() || t()) {
                    f(true);
                    return this.e.c(this.b, this.f24188c, this.h);
                }
                z = p();
                pushSwitchStatus.setSwitchNotificationMessage(z);
                r = r();
            } else if (i != 3) {
                return null;
            } else {
                pushSwitchStatus.setMessage("SWITCH_ALL");
                if (p() != this.j || r() != this.j || t()) {
                    f(true);
                    e(this.j);
                    return this.e.a(this.b, this.f24188c, this.h, this.j);
                }
                p = this.j;
            }
            pushSwitchStatus.setSwitchNotificationMessage(p);
            r = this.j;
        } else {
            pushSwitchStatus.setMessage("SWITCH_NOTIFICATION");
            if (p() != this.j || t()) {
                f(true);
                c(this.j);
                return this.e.a(this.b, this.f24188c, this.h, this.i, this.j);
            }
            z = this.j;
            pushSwitchStatus.setSwitchNotificationMessage(z);
            r = r();
        }
        pushSwitchStatus.setSwitchThroughMessage(r);
        return null;
    }

    private void c(boolean z) {
        com.meizu.cloud.pushsdk.util.b.a(this.f24187a, !TextUtils.isEmpty(this.d) ? this.d : this.f24187a.getPackageName(), z);
    }

    private void d(boolean z) {
        com.meizu.cloud.pushsdk.util.b.b(this.f24187a, !TextUtils.isEmpty(this.d) ? this.d : this.f24187a.getPackageName(), z);
    }

    private void e(boolean z) {
        com.meizu.cloud.pushsdk.util.b.a(this.f24187a, !TextUtils.isEmpty(this.d) ? this.d : this.f24187a.getPackageName(), z);
        com.meizu.cloud.pushsdk.util.b.b(this.f24187a, !TextUtils.isEmpty(this.d) ? this.d : this.f24187a.getPackageName(), z);
    }

    private void f(boolean z) {
        Map<String, Boolean> map = this.k;
        map.put(this.d + BridgeUtil.UNDERLINE_STR + this.i, Boolean.valueOf(z));
    }

    private void o() {
        Context context;
        int i;
        int i2 = this.i;
        if (i2 != 0) {
            i = 1;
            if (i2 != 1) {
                if (i2 != 3) {
                    return;
                }
                PlatformMessageSender.a(this.f24187a, 0, this.j, this.d);
                context = this.f24187a;
                PlatformMessageSender.a(context, i, this.j, this.d);
            }
        }
        context = this.f24187a;
        i = this.i;
        PlatformMessageSender.a(context, i, this.j, this.d);
    }

    private boolean p() {
        return com.meizu.cloud.pushsdk.util.b.e(this.f24187a, !TextUtils.isEmpty(this.d) ? this.d : this.f24187a.getPackageName());
    }

    private boolean q() {
        return com.meizu.cloud.pushsdk.util.b.f(this.f24187a, !TextUtils.isEmpty(this.d) ? this.d : this.f24187a.getPackageName());
    }

    private boolean r() {
        return com.meizu.cloud.pushsdk.util.b.h(this.f24187a, !TextUtils.isEmpty(this.d) ? this.d : this.f24187a.getPackageName());
    }

    private boolean s() {
        return com.meizu.cloud.pushsdk.util.b.i(this.f24187a, !TextUtils.isEmpty(this.d) ? this.d : this.f24187a.getPackageName());
    }

    private boolean t() {
        Map<String, Boolean> map = this.k;
        Boolean bool = map.get(this.d + BridgeUtil.UNDERLINE_STR + this.i);
        boolean z = bool == null || bool.booleanValue();
        DebugLogger.e("Strategy", "isSyncPushStatus " + this.d + " switch type->" + this.i + " flag->" + z);
        return z;
    }

    public void a(int i) {
        this.i = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(PushSwitchStatus pushSwitchStatus) {
        PlatformMessageSender.a(this.f24187a, !TextUtils.isEmpty(this.d) ? this.d : this.f24187a.getPackageName(), pushSwitchStatus);
    }

    public void a(String str) {
        this.h = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected boolean a() {
        return (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.f24188c) || TextUtils.isEmpty(this.h)) ? false : true;
    }

    public void b(boolean z) {
        this.j = z;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected Intent c() {
        Intent intent = new Intent();
        intent.putExtra("app_id", this.b);
        intent.putExtra("app_key", this.f24188c);
        intent.putExtra("strategy_package_name", this.f24187a.getPackageName());
        intent.putExtra(PushConstants.REGISTER_STATUS_PUSH_ID, this.h);
        intent.putExtra("strategy_type", g());
        intent.putExtra("strategy_child_type", this.i);
        intent.putExtra("strategy_params", this.j ? "1" : "0");
        return intent;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected int g() {
        return 16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: h */
    public PushSwitchStatus b() {
        String str;
        PushSwitchStatus pushSwitchStatus = new PushSwitchStatus();
        pushSwitchStatus.setCode("20001");
        if (TextUtils.isEmpty(this.b)) {
            str = "appId not empty";
        } else if (TextUtils.isEmpty(this.f24188c)) {
            str = "appKey not empty";
        } else if (!TextUtils.isEmpty(this.h)) {
            return pushSwitchStatus;
        } else {
            str = "pushId not empty";
        }
        pushSwitchStatus.setMessage(str);
        return pushSwitchStatus;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: i */
    public PushSwitchStatus e() {
        PushSwitchStatus pushSwitchStatus = new PushSwitchStatus();
        pushSwitchStatus.setPushId(this.h);
        pushSwitchStatus.setCode(BasicPushStatus.SUCCESS_CODE);
        com.meizu.cloud.pushsdk.c.a.c<String> b = b(pushSwitchStatus);
        if (b != null) {
            if (b.b()) {
                PushSwitchStatus pushSwitchStatus2 = new PushSwitchStatus(b.a());
                DebugLogger.e("Strategy", "network pushSwitchStatus " + pushSwitchStatus2);
                if (BasicPushStatus.SUCCESS_CODE.equals(pushSwitchStatus.getCode())) {
                    f(false);
                    DebugLogger.e("Strategy", "update local switch preference");
                    pushSwitchStatus.setSwitchNotificationMessage(pushSwitchStatus2.isSwitchNotificationMessage());
                    pushSwitchStatus.setSwitchThroughMessage(pushSwitchStatus2.isSwitchThroughMessage());
                    c(pushSwitchStatus2.isSwitchNotificationMessage());
                    d(pushSwitchStatus2.isSwitchThroughMessage());
                }
            } else {
                com.meizu.cloud.pushsdk.c.b.a c2 = b.c();
                if (c2.a() != null) {
                    DebugLogger.e("Strategy", "status code=" + c2.b() + " data=" + c2.a());
                }
                pushSwitchStatus.setCode(String.valueOf(c2.b()));
                pushSwitchStatus.setMessage(c2.c());
                DebugLogger.e("Strategy", "pushSwitchStatus " + pushSwitchStatus);
            }
        }
        DebugLogger.e("Strategy", "enableRpc " + this.g + " isSupportRemoteInvoke " + this.f);
        if (this.g && !this.f) {
            o();
        }
        return pushSwitchStatus;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: j */
    public PushSwitchStatus f() {
        int i = this.i;
        if (i == 0) {
            c(this.j);
            return null;
        } else if (i == 1) {
            d(this.j);
            return null;
        } else if (i == 2 || i == 3) {
            e(this.j);
            return null;
        } else {
            return null;
        }
    }
}
