package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.igexin.sdk.PushConsts;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/platform/b/b.class */
public class b extends c<RegisterStatus> {
    private Handler h;
    private ScheduledExecutorService i;
    private int j;

    public b(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, null, null, aVar, scheduledExecutorService);
        this.i = (ScheduledExecutorService) com.meizu.cloud.pushsdk.d.b.a.b.a();
        this.h = new Handler(context.getMainLooper()) { // from class: com.meizu.cloud.pushsdk.platform.b.b.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 0) {
                    b.this.m();
                }
            }
        };
    }

    public b(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, aVar, scheduledExecutorService);
        this.g = z;
    }

    public b(Context context, String str, String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
        this.j = 0;
    }

    private boolean a(String str, String str2, int i) {
        boolean z = true;
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2) || !str2.startsWith(str) || System.currentTimeMillis() / 1000 > i) {
                return true;
            }
            z = false;
        }
        return z;
    }

    protected void a(long j) {
        this.i.schedule(new Runnable() { // from class: com.meizu.cloud.pushsdk.platform.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                com.meizu.cloud.pushsdk.b.c.a(b.this.f24187a);
                b.this.h.sendEmptyMessage(0);
            }
        }, j, TimeUnit.SECONDS);
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(RegisterStatus registerStatus) {
        PlatformMessageSender.a(this.f24187a, !TextUtils.isEmpty(this.d) ? this.d : this.f24187a.getPackageName(), registerStatus);
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public boolean a() {
        DebugLogger.e("Strategy", "isBrandMeizu " + MzSystemUtils.isBrandMeizu(this.f24187a));
        return (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.f24188c)) ? false : true;
    }

    protected boolean a(String str, int i) {
        String a2 = com.meizu.cloud.pushsdk.b.c.a(this.f24187a);
        boolean a3 = a(a2, str, i);
        boolean z = a3;
        if (a3) {
            z = a(a2, com.meizu.cloud.pushsdk.platform.a.a(str), i);
        }
        return z;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public Intent c() {
        Intent intent = new Intent();
        intent.putExtra("app_id", this.b);
        intent.putExtra("app_key", this.f24188c);
        intent.putExtra("strategy_package_name", this.f24187a.getPackageName());
        intent.putExtra("strategy_type", g());
        return intent;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected int g() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: h */
    public RegisterStatus b() {
        String str;
        RegisterStatus registerStatus = new RegisterStatus();
        registerStatus.setCode("20001");
        if (TextUtils.isEmpty(this.b)) {
            str = "appId not empty";
        } else if (!TextUtils.isEmpty(this.f24188c)) {
            return registerStatus;
        } else {
            str = "appKey not empty";
        }
        registerStatus.setMessage(str);
        return registerStatus;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: i */
    public RegisterStatus f() {
        return null;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: j */
    public RegisterStatus e() {
        RegisterStatus registerStatus = new RegisterStatus();
        String a2 = com.meizu.cloud.pushsdk.util.b.a(this.f24187a, this.d);
        int b = com.meizu.cloud.pushsdk.util.b.b(this.f24187a, this.d);
        if (!a(a2, b)) {
            registerStatus.setCode(BasicPushStatus.SUCCESS_CODE);
            registerStatus.setMessage("already register PushId,don't register frequently");
            registerStatus.setPushId(a2);
            registerStatus.setExpireTime((int) (b - (System.currentTimeMillis() / 1000)));
            return registerStatus;
        }
        com.meizu.cloud.pushsdk.util.b.g(this.f24187a, "", this.d);
        String a3 = com.meizu.cloud.pushsdk.b.c.a(this.f24187a);
        if (TextUtils.isEmpty(a3) && this.j < 3) {
            DebugLogger.i("Strategy", "after " + (this.j * 10) + " seconds start register");
            a((long) (this.j * 10));
            this.j = this.j + 1;
            registerStatus.setCode(PushConsts.SEND_MESSAGE_ERROR);
            registerStatus.setMessage("deviceId is empty");
            return registerStatus;
        }
        this.j = 0;
        com.meizu.cloud.pushsdk.c.a.c a4 = this.e.a(this.b, this.f24188c, a3);
        if (a4.b()) {
            RegisterStatus registerStatus2 = new RegisterStatus((String) a4.a());
            DebugLogger.e("Strategy", "registerStatus " + registerStatus2);
            registerStatus = registerStatus2;
            if (!TextUtils.isEmpty(registerStatus2.getPushId())) {
                com.meizu.cloud.pushsdk.util.b.g(this.f24187a, registerStatus2.getPushId(), this.d);
                com.meizu.cloud.pushsdk.util.b.a(this.f24187a, (int) ((System.currentTimeMillis() / 1000) + registerStatus2.getExpireTime()), this.d);
                return registerStatus2;
            }
        } else {
            com.meizu.cloud.pushsdk.c.b.a c2 = a4.c();
            if (c2.a() != null) {
                DebugLogger.e("Strategy", "status code=" + c2.b() + " data=" + c2.a());
            }
            registerStatus.setCode(String.valueOf(c2.b()));
            registerStatus.setMessage(c2.c());
            DebugLogger.e("Strategy", "registerStatus " + registerStatus);
        }
        return registerStatus;
    }
}
