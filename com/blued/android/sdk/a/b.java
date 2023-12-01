package com.blued.android.sdk.a;

import android.content.Intent;
import com.blued.android.sdk.BluedAuth;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/sdk/a/b.class */
public class b extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final String f18652c = "com.blued.android.sdk.action.auth";
    public static final String d = "com.blued.android.sdk.action.auth_result";
    public static final String e = "extra_auth_token_string";
    public static final String f = "extra_auth_expire_int";
    private final BluedAuth.AuthCallback g;

    public b(BluedAuth.AuthCallback authCallback) {
        this.g = authCallback;
    }

    public void a(Intent intent) {
        String action = intent.getAction();
        if (this.g != null && d.equals(action)) {
            int intExtra = intent.getIntExtra(a.f18649a, 2);
            if (intExtra == 0) {
                this.g.onSuccess(intent.getStringExtra(e), intent.getIntExtra(f, 0));
            } else if (intExtra == 2) {
                this.g.onCancel();
            } else {
                this.g.onFailed(intent.getIntExtra(a.b, 0));
            }
        }
    }
}
