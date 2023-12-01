package com.xiaomi.push;

import android.content.Context;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/v.class */
public final class v extends u {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Runnable f28021a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(Context context, File file, Runnable runnable) {
        super(context, file, null);
        this.f28021a = runnable;
    }

    @Override // com.xiaomi.push.u
    protected final void a(Context context) {
        Runnable runnable = this.f28021a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
