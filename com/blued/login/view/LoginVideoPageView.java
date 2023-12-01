package com.blued.login.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.module.player.media.view.AbsPlayerView;
import com.blued.login.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/view/LoginVideoPageView.class */
public final class LoginVideoPageView extends AbsPlayerView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoginVideoPageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginVideoPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        c();
    }

    private final void c() {
        this.b = LayoutInflater.from(this.a);
        this.c = this.b.inflate(R.layout.login_video_root, (ViewGroup) this);
        this.i = (FrameLayout) this.c.findViewById(R.id.video_root);
    }

    private final String getPlayUrl() {
        return this.j != null ? this.j.b : "";
    }
}
