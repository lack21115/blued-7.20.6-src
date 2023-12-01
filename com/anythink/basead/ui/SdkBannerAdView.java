package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.basead.a.b.c;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.aa;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.k;
import com.anythink.core.common.e.s;
import com.anythink.core.common.k.h;
import com.anythink.core.common.k.l;
import com.anythink.core.common.k.u;
import com.anythink.core.common.res.b;
import com.anythink.core.common.res.e;
import com.anythink.core.common.res.image.RecycleImageView;
import com.anythink.core.common.ui.component.RoundImageView;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/SdkBannerAdView.class */
public class SdkBannerAdView extends BaseBannerAdView {
    private static final int x = 1;
    private static final int y = 2;
    private final View.OnClickListener A;
    boolean u;
    String v;
    private int w;
    private final View.OnClickListener z;

    /* renamed from: com.anythink.basead.ui.SdkBannerAdView$10  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/SdkBannerAdView$10.class */
    final class AnonymousClass10 implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ImageView f6173a;

        AnonymousClass10(ImageView imageView) {
            this.f6173a = imageView;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, Bitmap bitmap) {
            if (TextUtils.equals(SdkBannerAdView.this.d.v(), str)) {
                this.f6173a.setImageBitmap(bitmap);
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.SdkBannerAdView$11  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/SdkBannerAdView$11.class */
    final class AnonymousClass11 implements View.OnClickListener {
        AnonymousClass11() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.SdkBannerAdView$12  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/SdkBannerAdView$12.class */
    final class AnonymousClass12 implements View.OnClickListener {
        AnonymousClass12() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            l.b(n.a().g(), SdkBannerAdView.this.d.H());
        }
    }

    /* renamed from: com.anythink.basead.ui.SdkBannerAdView$13  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/SdkBannerAdView$13.class */
    final class AnonymousClass13 implements View.OnClickListener {
        AnonymousClass13() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            l.b(n.a().g(), SdkBannerAdView.this.d.I());
        }
    }

    /* renamed from: com.anythink.basead.ui.SdkBannerAdView$14  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/SdkBannerAdView$14.class */
    final class AnonymousClass14 implements View.OnClickListener {
        AnonymousClass14() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.SdkBannerAdView$15  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/SdkBannerAdView$15.class */
    final class AnonymousClass15 implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RoundImageView f6178a;

        AnonymousClass15(RoundImageView roundImageView) {
            this.f6178a = roundImageView;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, Bitmap bitmap) {
            if (TextUtils.equals(SdkBannerAdView.this.d.t(), str)) {
                this.f6178a.setImageBitmap(bitmap);
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.SdkBannerAdView$2  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/SdkBannerAdView$2.class */
    final class AnonymousClass2 implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ImageView f6179a;

        AnonymousClass2(ImageView imageView) {
            this.f6179a = imageView;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, Bitmap bitmap) {
            if (TextUtils.equals(SdkBannerAdView.this.d.v(), str)) {
                this.f6179a.setImageBitmap(bitmap);
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.SdkBannerAdView$3  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/SdkBannerAdView$3.class */
    final class AnonymousClass3 implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RoundImageView f6180a;

        AnonymousClass3(RoundImageView roundImageView) {
            this.f6180a = roundImageView;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, Bitmap bitmap) {
            if (TextUtils.equals(SdkBannerAdView.this.d.u(), str)) {
                this.f6180a.setImageBitmap(bitmap);
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.SdkBannerAdView$4  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/SdkBannerAdView$4.class */
    final class AnonymousClass4 implements View.OnClickListener {
        AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.SdkBannerAdView$5  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/SdkBannerAdView$5.class */
    final class AnonymousClass5 implements View.OnClickListener {
        AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            l.b(n.a().g(), SdkBannerAdView.this.d.H());
        }
    }

    /* renamed from: com.anythink.basead.ui.SdkBannerAdView$6  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/SdkBannerAdView$6.class */
    final class AnonymousClass6 implements View.OnClickListener {
        AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            l.b(n.a().g(), SdkBannerAdView.this.d.I());
        }
    }

    /* renamed from: com.anythink.basead.ui.SdkBannerAdView$7  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/SdkBannerAdView$7.class */
    final class AnonymousClass7 implements View.OnClickListener {
        AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.SdkBannerAdView$9  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/SdkBannerAdView$9.class */
    final class AnonymousClass9 implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f6186a;
        final /* synthetic */ RecycleImageView b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ RecycleImageView f6187c;

        AnonymousClass9(String str, RecycleImageView recycleImageView, RecycleImageView recycleImageView2) {
            this.f6186a = str;
            this.b = recycleImageView;
            this.f6187c = recycleImageView2;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, final Bitmap bitmap) {
            if (TextUtils.equals(this.f6186a, str)) {
                this.b.setImageBitmap(bitmap);
                SdkBannerAdView.this.post(new Runnable() { // from class: com.anythink.basead.ui.SdkBannerAdView.9.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        int[] a2 = u.a(SdkBannerAdView.this.getWidth(), SdkBannerAdView.this.getHeight(), bitmap.getWidth() / bitmap.getHeight());
                        ViewGroup.LayoutParams layoutParams = AnonymousClass9.this.b.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = a2[0];
                            layoutParams.height = a2[1];
                            AnonymousClass9.this.b.setLayoutParams(layoutParams);
                        }
                    }
                });
                this.f6187c.setImageBitmap(com.anythink.core.common.k.b.a(SdkBannerAdView.this.getContext(), bitmap));
            }
        }
    }

    public SdkBannerAdView(Context context) {
        super(context);
        this.w = 2;
        this.z = new View.OnClickListener() { // from class: com.anythink.basead.ui.SdkBannerAdView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                if (2 != SdkBannerAdView.this.w) {
                    SdkBannerAdView.super.b(1);
                } else if (SdkBannerAdView.this.f6049c.m == null || SdkBannerAdView.this.f6049c.m.x() != 0) {
                } else {
                    SdkBannerAdView.super.b(1);
                }
            }
        };
        this.A = new View.OnClickListener() { // from class: com.anythink.basead.ui.SdkBannerAdView.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                SdkBannerAdView.super.b(1);
            }
        };
    }

    public SdkBannerAdView(Context context, j jVar, i iVar, com.anythink.basead.e.a aVar) {
        super(context, jVar, iVar, aVar);
        this.w = 2;
        this.z = new View.OnClickListener() { // from class: com.anythink.basead.ui.SdkBannerAdView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                if (2 != SdkBannerAdView.this.w) {
                    SdkBannerAdView.super.b(1);
                } else if (SdkBannerAdView.this.f6049c.m == null || SdkBannerAdView.this.f6049c.m.x() != 0) {
                } else {
                    SdkBannerAdView.super.b(1);
                }
            }
        };
        this.A = new View.OnClickListener() { // from class: com.anythink.basead.ui.SdkBannerAdView.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                SdkBannerAdView.super.b(1);
            }
        };
        b();
        c();
    }

    private int a(String str) {
        int i = 1;
        if (!(this.d instanceof aa) ? !(this.d instanceof s) || TextUtils.isEmpty(str) || !c.c(str) : ((aa) this.d).Y() != 1) {
            i = 2;
        }
        this.w = i;
        return i;
    }

    private void b(String str) {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(h.a(getContext(), "myoffer_banner_root", "id"));
        this.t = (CloseImageView) findViewById(h.a(getContext(), "myoffer_banner_close", "id"));
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(h.a(getContext(), "myoffer_banner_container", "id"));
        TextView textView = (TextView) findViewById(h.a(getContext(), "myoffer_banner_publisher_name", "id"));
        TextView textView2 = (TextView) findViewById(h.a(getContext(), "myoffer_banner_privacy_agreement", "id"));
        TextView textView3 = (TextView) findViewById(h.a(getContext(), "myoffer_banner_permission_manage", "id"));
        TextView textView4 = (TextView) findViewById(h.a(getContext(), "myoffer_banner_version_name", "id"));
        if (this.f6049c.m.s() == 0) {
            this.t.setVisibility(0);
            if (TextUtils.equals(k.d, this.v)) {
                ViewGroup.LayoutParams layoutParams = this.t.getLayoutParams();
                layoutParams.width = h.a(getContext(), 23.0f);
                layoutParams.height = h.a(getContext(), 23.0f);
                this.t.setLayoutParams(layoutParams);
            }
            a(this.t, this.f6049c.m.h());
        } else {
            this.t.setVisibility(8);
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        relativeLayout.setLayoutParams(layoutParams2);
        RecycleImageView recycleImageView = new RecycleImageView(getContext());
        recycleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(recycleImageView, 0, new RelativeLayout.LayoutParams(-1, -1));
        RecycleImageView recycleImageView2 = new RecycleImageView(getContext());
        recycleImageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        com.anythink.core.common.res.b.a(getContext()).a(new e(1, str), new AnonymousClass9(str, recycleImageView2, recycleImageView));
        this.r.add(recycleImageView2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams3.addRule(13);
        addView(recycleImageView2, 1, layoutParams3);
        if (!TextUtils.isEmpty(this.d.v())) {
            ImageView imageView = (ImageView) findViewById(h.a(getContext(), "myoffer_banner_self_ad_logo", "id"));
            com.anythink.core.common.res.b.a(getContext()).a(new e(1, this.d.v()), new AnonymousClass10(imageView));
            this.r.add(imageView);
        }
        if (this.d.K()) {
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(0);
            }
            if (textView != null) {
                textView.setVisibility(0);
                textView.setText(this.d.F());
                textView.setOnClickListener(new AnonymousClass11());
            }
            if (textView2 != null) {
                textView2.setVisibility(0);
                textView2.setOnClickListener(new AnonymousClass12());
            }
            if (textView3 != null) {
                textView3.setVisibility(0);
                textView3.setOnClickListener(new AnonymousClass13());
            }
            if (textView4 != null) {
                textView4.setVisibility(0);
                textView4.setText(getContext().getResources().getString(h.a(getContext(), "myoffer_panel_version", "string"), this.d.G()));
                textView4.setOnClickListener(new AnonymousClass14());
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x0c43, code lost:
        if (r0.equals(com.anythink.core.common.e.k.f6665a) != false) goto L146;
     */
    /* JADX WARN: Removed duplicated region for block: B:122:0x05ff  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x064c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void o() {
        /*
            Method dump skipped, instructions count: 3197
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.ui.SdkBannerAdView.o():void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void p() {
        /*
            Method dump skipped, instructions count: 2039
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.ui.SdkBannerAdView.p():void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x0c43, code lost:
        if (r0.equals(com.anythink.core.common.e.k.f6665a) != false) goto L146;
     */
    /* JADX WARN: Removed duplicated region for block: B:122:0x05ff  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x064c  */
    @Override // com.anythink.basead.ui.BaseAdView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void a() {
        /*
            Method dump skipped, instructions count: 3197
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.ui.SdkBannerAdView.a():void");
    }

    @Override // com.anythink.basead.ui.BaseBannerAdView
    protected final void c() {
        int size = this.r.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                setOnClickListener(this.z);
                super.c();
                return;
            }
            View view = this.r.get(i2);
            if (view != null) {
                view.setOnClickListener(this.A);
            }
            i = i2 + 1;
        }
    }
}
