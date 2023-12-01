package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/common/internal/DialogRedirectImpl.class */
public class DialogRedirectImpl extends DialogRedirect {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f9045a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final Intent f9046c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogRedirectImpl(Intent intent, Activity activity, int i) {
        this.f9046c = intent;
        this.f9045a = activity;
        this.b = i;
    }

    @Override // com.huawei.hms.common.internal.DialogRedirect
    public final void redirect() {
        Intent intent = this.f9046c;
        if (intent != null) {
            this.f9045a.startActivityForResult(intent, this.b);
        }
    }
}
