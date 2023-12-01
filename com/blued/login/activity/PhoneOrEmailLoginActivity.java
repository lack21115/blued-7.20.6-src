package com.blued.login.activity;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.blued.android.core.ui.TerminalActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/activity/PhoneOrEmailLoginActivity.class */
public final class PhoneOrEmailLoginActivity extends TerminalActivity {
    public static final Companion d = new Companion(null);

    @Metadata
    /* loaded from: source-7206380-dex2jar.jar:com/blued/login/activity/PhoneOrEmailLoginActivity$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, Class<? extends Fragment> cls, Bundle bundle) {
            new TerminalActivity.WrapIntent(context, cls, bundle, PhoneOrEmailLoginActivity.class).b();
        }
    }
}
