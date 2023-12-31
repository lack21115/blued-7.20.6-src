package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.igexin.sdk.PushConsts;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/platform/b/d.class */
public class d extends c<SubAliasStatus> {
    private String h;
    private int i;
    private String j;
    private final Map<String, Boolean> k;

    public d(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, null, null, null, aVar, scheduledExecutorService);
    }

    public d(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, aVar, scheduledExecutorService);
        this.g = z;
    }

    public d(Context context, String str, String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
        this.k = new HashMap();
    }

    public d(Context context, String str, String str2, String str3, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, str, str2, aVar, scheduledExecutorService);
        this.h = str3;
    }

    private void b(boolean z) {
        Map<String, Boolean> map = this.k;
        map.put(this.d + "_" + this.i, Boolean.valueOf(z));
    }

    private void f(String str) {
        com.meizu.cloud.pushsdk.util.b.h(this.f10572a, !TextUtils.isEmpty(this.d) ? this.d : this.f10572a.getPackageName(), str);
    }

    private String o() {
        return com.meizu.cloud.pushsdk.util.b.g(this.f10572a, !TextUtils.isEmpty(this.d) ? this.d : this.f10572a.getPackageName());
    }

    private boolean p() {
        Map<String, Boolean> map = this.k;
        Boolean bool = map.get(this.d + "_" + this.i);
        return bool == null || bool.booleanValue();
    }

    private boolean q() {
        return !this.f && PushConstants.PUSH_PACKAGE_NAME.equals(this.d);
    }

    public void a(int i) {
        this.i = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(SubAliasStatus subAliasStatus) {
        PlatformMessageSender.a(this.f10572a, !TextUtils.isEmpty(this.d) ? this.d : this.f10572a.getPackageName(), subAliasStatus);
    }

    public void a(String str) {
        this.j = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected boolean a() {
        return (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.f10573c) || TextUtils.isEmpty(this.h)) ? false : true;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected Intent c() {
        if (this.i != 2) {
            Intent intent = new Intent();
            intent.putExtra("app_id", this.b);
            intent.putExtra("app_key", this.f10573c);
            intent.putExtra("strategy_package_name", this.f10572a.getPackageName());
            intent.putExtra(PushConstants.REGISTER_STATUS_PUSH_ID, this.h);
            intent.putExtra("strategy_type", g());
            intent.putExtra("strategy_child_type", this.i);
            intent.putExtra("strategy_params", this.j);
            return intent;
        }
        return null;
    }

    public void e(String str) {
        this.h = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected int g() {
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: h */
    public SubAliasStatus b() {
        String str;
        SubAliasStatus subAliasStatus = new SubAliasStatus();
        subAliasStatus.setCode(PushConsts.SEND_MESSAGE_ERROR_GENERAL);
        if (TextUtils.isEmpty(this.b)) {
            str = "appId not empty";
        } else if (TextUtils.isEmpty(this.f10573c)) {
            str = "appKey not empty";
        } else if (!TextUtils.isEmpty(this.h)) {
            return subAliasStatus;
        } else {
            str = "pushId not empty";
        }
        subAliasStatus.setMessage(str);
        return subAliasStatus;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ec  */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.meizu.cloud.pushsdk.platform.message.SubAliasStatus e() {
        /*
            Method dump skipped, instructions count: 429
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.platform.b.d.e():com.meizu.cloud.pushsdk.platform.message.SubAliasStatus");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: j */
    public SubAliasStatus f() {
        if (this.i == 2) {
            SubAliasStatus subAliasStatus = new SubAliasStatus();
            subAliasStatus.setCode(BasicPushStatus.SUCCESS_CODE);
            subAliasStatus.setPushId(this.h);
            subAliasStatus.setAlias(o());
            subAliasStatus.setMessage("check alias success");
            return subAliasStatus;
        }
        return null;
    }
}
