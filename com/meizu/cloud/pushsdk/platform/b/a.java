package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/platform/b/a.class */
public class a extends c {
    private int[] h;
    private int i;
    private String j;

    public a(Context context, String str, String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
        this.f = MinSdkChecker.isSupportSetDrawableSmallIcon();
    }

    public a(Context context, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, null, null, null, scheduledExecutorService);
        this.g = z;
    }

    public void a(int i) {
        this.i = i;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected void a(BasicPushStatus basicPushStatus) {
    }

    public void a(String str) {
        this.j = str;
    }

    public void a(int... iArr) {
        this.h = iArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
        if (r0 != 1) goto L9;
     */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean a() {
        /*
            r3 = this;
            r0 = r3
            int r0 = r0.i
            r4 = r0
            r0 = 1
            r6 = r0
            r0 = r6
            r5 = r0
            r0 = r4
            if (r0 == 0) goto L3b
            r0 = r3
            int[] r0 = r0.h
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L25
            r0 = r7
            int r0 = r0.length
            if (r0 <= 0) goto L25
            r0 = r6
            r5 = r0
            r0 = r4
            r1 = 1
            if (r0 == r1) goto L3b
        L25:
            r0 = r3
            int r0 = r0.i
            r1 = 2
            if (r0 != r1) goto L39
            r0 = r3
            java.lang.String r0 = r0.j
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L39
            r0 = 1
            return r0
        L39:
            r0 = 0
            r5 = r0
        L3b:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.platform.b.a.a():boolean");
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected BasicPushStatus b() {
        return null;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected Intent c() {
        Intent intent = new Intent();
        intent.putExtra("strategy_package_name", this.f24187a.getPackageName());
        intent.putExtra("strategy_type", g());
        intent.putExtra("strategy_child_type", this.i);
        int i = this.i;
        if (i == 2) {
            intent.putExtra("strategy_params", this.j);
            return intent;
        }
        if (i == 1) {
            intent = null;
        }
        return intent;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected Intent[] d() {
        Intent[] intentArr;
        int[] iArr = this.h;
        if (iArr != null) {
            Intent[] intentArr2 = new Intent[iArr.length];
            int i = 0;
            while (true) {
                int i2 = i;
                intentArr = intentArr2;
                if (i2 >= this.h.length) {
                    break;
                }
                DebugLogger.i("Strategy", "send notifyId " + this.h[i2] + " to PushManagerService");
                Intent intent = new Intent();
                intent.putExtra("strategy_package_name", this.f24187a.getPackageName());
                intent.putExtra("strategy_type", g());
                intent.putExtra("strategy_child_type", this.i);
                intent.putExtra("strategy_params", "" + this.h[i2]);
                intentArr2[i2] = intent;
                i = i2 + 1;
            }
        } else {
            intentArr = null;
        }
        return intentArr;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected BasicPushStatus e() {
        int i = this.i;
        if (i == 0) {
            if (!MinSdkChecker.isSupportSetDrawableSmallIcon()) {
                DebugLogger.e("Strategy", "android 6.0 blow so cancel all by context");
                com.meizu.cloud.pushsdk.notification.c.b.a(this.f24187a);
            }
            com.meizu.cloud.pushsdk.notification.c.b.a(this.f24187a, this.d);
            return null;
        } else if (i != 1) {
            if (i != 2) {
                return null;
            }
            com.meizu.cloud.pushsdk.notification.c.b.a(this.f24187a, this.d, this.j);
            return null;
        } else {
            int[] iArr = this.h;
            if (iArr == null) {
                return null;
            }
            int length = iArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return null;
                }
                int i4 = iArr[i3];
                DebugLogger.e("Strategy", "clear notifyId " + i4);
                com.meizu.cloud.pushsdk.notification.c.b.a(this.f24187a, this.d, i4);
                i2 = i3 + 1;
            }
        }
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected BasicPushStatus f() {
        return null;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected int g() {
        return 64;
    }
}
