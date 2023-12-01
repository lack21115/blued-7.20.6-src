package com.huawei.hms.push.task;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.PushNaming;
import java.util.concurrent.Callable;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/push/task/IntentCallable.class */
public class IntentCallable implements Callable<Void> {

    /* renamed from: a  reason: collision with root package name */
    private Context f22859a;
    private Intent b;

    /* renamed from: c  reason: collision with root package name */
    private String f22860c;

    public IntentCallable(Context context, Intent intent, String str) {
        this.f22859a = context;
        this.b = intent;
        this.f22860c = str;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.f22859a.sendBroadcast(this.b);
        PushBiUtil.reportExit(this.f22859a, PushNaming.SET_NOTIFY_FLAG, this.f22860c, ErrorEnum.SUCCESS);
        return null;
    }
}
