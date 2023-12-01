package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ViewCertificateLevelBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/CertificateLevelView.class */
public final class CertificateLevelView extends RelativeLayout {
    private ViewCertificateLevelBinding a;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/CertificateLevelView$Builder.class */
    public static final class Builder {
        private boolean g;
        private IRequestHost h;
        private int a = R.color.syc_dark_b;
        private int b = R.color.syc_dark_b;
        private String c = "";
        private String d = "";
        private int e = R.drawable.yy_bg_user_card_fans;
        private int f = R.drawable.yy_icon_user_card_fans;
        private String i = "";

        public final int a() {
            return this.a;
        }

        public final void a(int i) {
            this.a = i;
        }

        public final void a(IRequestHost iRequestHost) {
            this.h = iRequestHost;
        }

        public final void a(String str) {
            this.c = str;
        }

        public final void a(boolean z) {
            this.g = z;
        }

        public final int b() {
            return this.b;
        }

        public final void b(int i) {
            this.b = i;
        }

        public final void b(String str) {
            this.d = str;
        }

        public final String c() {
            return this.c;
        }

        public final void c(int i) {
            this.e = i;
        }

        public final void c(String str) {
            Intrinsics.e(str, "<set-?>");
            this.i = str;
        }

        public final String d() {
            return this.d;
        }

        public final void d(int i) {
            this.f = i;
        }

        public final int e() {
            return this.e;
        }

        public final int f() {
            return this.f;
        }

        public final boolean g() {
            return this.g;
        }

        public final IRequestHost h() {
            return this.h;
        }

        public final String i() {
            return this.i;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CertificateLevelView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CertificateLevelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CertificateLevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        ViewCertificateLevelBinding a = ViewCertificateLevelBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics.c(a, "inflate(LayoutInflater.from(context), this, true)");
        this.a = a;
    }

    public final void a(Builder builder) {
        if (builder == null) {
            return;
        }
        this.a.b.setBackgroundResource(builder.e());
        this.a.c.setText(builder.d());
        this.a.c.setTextColor(getResources().getColor(builder.a()));
        this.a.d.setText(builder.c());
        this.a.d.setTextColor(getResources().getColor(builder.b()));
        if (builder.g()) {
            ImageLoader.a(builder.h(), builder.i()).a(this.a.a);
        } else {
            this.a.a.setImageResource(builder.f());
        }
    }
}
