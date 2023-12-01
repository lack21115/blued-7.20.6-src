package com.huawei.hms.adapter;

import android.content.Context;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/adapter/InnerBinderAdapter.class */
public class InnerBinderAdapter extends BinderAdapter {
    private static final Object j = new Object();
    private static BinderAdapter k;

    private InnerBinderAdapter(Context context, String str, String str2) {
        super(context, str, str2);
    }

    public static BinderAdapter getInstance(Context context, String str, String str2) {
        BinderAdapter binderAdapter;
        HMSLog.i("InnerBinderAdapter", "InnerBinderAdapter getInstance.");
        synchronized (j) {
            if (k == null) {
                k = new InnerBinderAdapter(context, str, str2);
            }
            binderAdapter = k;
        }
        return binderAdapter;
    }

    @Override // com.huawei.hms.adapter.BinderAdapter
    protected int a() {
        return 2001;
    }

    @Override // com.huawei.hms.adapter.BinderAdapter
    protected int b() {
        return 2002;
    }
}
