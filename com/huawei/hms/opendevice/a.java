package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import java.util.concurrent.Callable;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/opendevice/a.class */
public class a implements Callable<AAIDResult> {

    /* renamed from: a  reason: collision with root package name */
    private Context f9202a;

    public a(Context context) {
        this.f9202a = context;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public AAIDResult call() throws Exception {
        Context context = this.f9202a;
        if (context != null) {
            String c2 = b.c(context);
            AAIDResult aAIDResult = new AAIDResult();
            aAIDResult.setId(c2);
            return aAIDResult;
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }
}
