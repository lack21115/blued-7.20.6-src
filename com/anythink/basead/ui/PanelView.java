package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.basead.ui.BaseShakeView;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.k;
import com.anythink.core.common.k.h;
import com.anythink.core.common.k.l;
import com.anythink.core.common.k.u;
import com.anythink.core.common.res.b;
import com.anythink.core.common.res.e;
import com.anythink.core.common.ui.component.RoundImageView;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/PanelView.class */
public class PanelView extends RelativeLayout {
    public static final int TYPE_FULL_SCREEN_BANNER = 0;
    public static final int TYPE_FULL_SCREEN_EMPTY_INFO = 8;
    public static final int TYPE_FULL_SCREEN_ENDCARD_HORIZONTAL_LANDSCAPE = 6;
    public static final int TYPE_FULL_SCREEN_ENDCARD_HORIZONTAL_PORTRAIT = 1;
    public static final int TYPE_FULL_SCREEN_ENDCARD_VERTICAL_LANDSCAPE = 2;
    public static final int TYPE_FULL_SCREEN_ENDCARD_VERTICAL_PORTRAIT = 5;
    public static final int TYPE_HALF_SCREEN_EMPTY_INFO = 7;
    public static final int TYPE_HALF_SCREEN_HORIZONTAL = 4;
    public static final int TYPE_HALF_SCREEN_VERTICAL = 3;

    /* renamed from: a  reason: collision with root package name */
    private View f6143a;
    private ImageView b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f6144c;
    private TextView d;
    private TextView e;
    private Button f;
    private BaseShakeView g;
    private a h;
    private int i;
    private k j;
    private j k;
    private i l;
    private int m;
    private ViewGroup n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private boolean s;
    private boolean t;
    private boolean u;
    private List<View> v;
    private final View.OnClickListener w;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.basead.ui.PanelView$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/PanelView$1.class */
    public final class AnonymousClass1 implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f6145a;

        AnonymousClass1(String str) {
            this.f6145a = str;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, Bitmap bitmap) {
            if (TextUtils.equals(str, this.f6145a)) {
                PanelView.this.b.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.basead.ui.PanelView$2  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/PanelView$2.class */
    public final class AnonymousClass2 implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f6146a;
        final /* synthetic */ ViewGroup.LayoutParams b;

        AnonymousClass2(String str, ViewGroup.LayoutParams layoutParams) {
            this.f6146a = str;
            this.b = layoutParams;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
            PanelView.this.f6144c.setVisibility(8);
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, Bitmap bitmap) {
            if (TextUtils.equals(str, this.f6146a)) {
                PanelView.this.f6144c.setImageBitmap(bitmap);
                float width = (bitmap.getWidth() * 1.0f) / bitmap.getHeight();
                int i = this.b.height;
                this.b.width = (int) (i * width);
                this.b.height = i;
                PanelView.this.f6144c.setLayoutParams(this.b);
                PanelView.this.f6144c.setScaleType(ImageView.ScaleType.FIT_XY);
                PanelView.this.f6144c.setImageBitmap(bitmap);
                PanelView.this.f6144c.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.basead.ui.PanelView$7  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/PanelView$7.class */
    public final class AnonymousClass7 implements View.OnClickListener {
        AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            PanelView.this.w.onClick(PanelView.this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.basead.ui.PanelView$8  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/PanelView$8.class */
    public final class AnonymousClass8 implements BaseShakeView.a {
        AnonymousClass8() {
        }

        @Override // com.anythink.basead.ui.BaseShakeView.a
        public final boolean a() {
            return PanelView.this.h.b();
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/PanelView$a.class */
    public interface a {
        void a();

        boolean b();
    }

    public PanelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = 0;
        this.s = false;
        this.t = false;
        this.u = false;
        this.w = new View.OnClickListener() { // from class: com.anythink.basead.ui.PanelView.9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                if (PanelView.this.j != null) {
                    if (PanelView.this.j.x() != 1) {
                        if (PanelView.this.h != null) {
                            PanelView.this.h.a();
                        }
                    } else if (view != PanelView.this.f || PanelView.this.h == null) {
                    } else {
                        PanelView.this.h.a();
                    }
                }
            }
        };
    }

    private void a(i iVar) {
        if (this.b != null) {
            String t = iVar.t();
            if (!TextUtils.isEmpty(t)) {
                ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
                com.anythink.core.common.res.b.a(getContext()).a(new e(1, t), layoutParams.width, layoutParams.height, new AnonymousClass1(t));
            }
            if (TextUtils.isEmpty(iVar.t())) {
                this.b.setVisibility(8);
            }
        }
        if (this.f6144c != null) {
            String v = iVar.v();
            if (TextUtils.isEmpty(v)) {
                this.f6144c.setVisibility(8);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.f6144c.getLayoutParams();
                com.anythink.core.common.res.b.a(getContext()).a(new e(1, v), layoutParams2.width, layoutParams2.height, new AnonymousClass2(v, layoutParams2));
            }
        }
        if (this.e != null) {
            if (TextUtils.isEmpty(iVar.s())) {
                this.e.setVisibility(8);
            } else {
                this.e.setText(iVar.s());
            }
        }
        if (this.d != null) {
            if (TextUtils.isEmpty(iVar.r())) {
                this.d.setVisibility(8);
            } else {
                this.d.setText(iVar.r());
            }
        }
        if (TextUtils.isEmpty(iVar.w())) {
            this.f.setText(com.anythink.basead.a.e.a(getContext(), this.l));
        } else {
            this.f.setText(iVar.w());
        }
        b(iVar);
    }

    private boolean a() {
        return this.s && !this.t;
    }

    private void b() {
        d();
        i iVar = this.l;
        if (this.b != null) {
            String t = iVar.t();
            if (!TextUtils.isEmpty(t)) {
                ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
                com.anythink.core.common.res.b.a(getContext()).a(new e(1, t), layoutParams.width, layoutParams.height, new AnonymousClass1(t));
            }
            if (TextUtils.isEmpty(iVar.t())) {
                this.b.setVisibility(8);
            }
        }
        if (this.f6144c != null) {
            String v = iVar.v();
            if (TextUtils.isEmpty(v)) {
                this.f6144c.setVisibility(8);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.f6144c.getLayoutParams();
                com.anythink.core.common.res.b.a(getContext()).a(new e(1, v), layoutParams2.width, layoutParams2.height, new AnonymousClass2(v, layoutParams2));
            }
        }
        if (this.e != null) {
            if (TextUtils.isEmpty(iVar.s())) {
                this.e.setVisibility(8);
            } else {
                this.e.setText(iVar.s());
            }
        }
        if (this.d != null) {
            if (TextUtils.isEmpty(iVar.r())) {
                this.d.setVisibility(8);
            } else {
                this.d.setText(iVar.r());
            }
        }
        if (TextUtils.isEmpty(iVar.w())) {
            this.f.setText(com.anythink.basead.a.e.a(getContext(), this.l));
        } else {
            this.f.setText(iVar.w());
        }
        b(iVar);
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setOnClickListener(this.w);
            this.v.add(this.b);
        }
        TextView textView = this.d;
        if (textView != null) {
            textView.setOnClickListener(this.w);
            this.v.add(this.d);
        }
        TextView textView2 = this.e;
        if (textView2 != null) {
            textView2.setOnClickListener(this.w);
            this.v.add(this.e);
        }
        this.f.setOnClickListener(this.w);
        this.v.add(this.f);
        ImageView imageView2 = this.f6144c;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this.w);
            this.v.add(this.f6144c);
        }
        BaseShakeView baseShakeView = this.g;
        if (baseShakeView != null && this.u) {
            baseShakeView.setOnClickListener(new AnonymousClass7());
            this.g.setOnShakeListener(new AnonymousClass8(), this.j);
        }
        View findViewById = this.f6143a.findViewById(h.a(getContext(), "myoffer_panel_view_blank", "id"));
        if (findViewById != null) {
            findViewById.setOnClickListener(this.w);
            this.v.add(findViewById);
        } else {
            this.f6143a.setOnClickListener(this.w);
            this.v.add(this.f6143a);
        }
        ImageView imageView3 = this.b;
        if (imageView3 instanceof RoundImageView) {
            ((RoundImageView) imageView3).setNeedRadiu(true);
            int i = this.m;
            if (i == 2 || i == 6) {
                ((RoundImageView) this.b).setRadiusInDip(8);
            } else {
                ((RoundImageView) this.b).setRadiusInDip(12);
            }
            this.b.invalidate();
        }
    }

    private void b(final i iVar) {
        if (!a()) {
            ViewGroup viewGroup = this.n;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            TextView textView = this.o;
            if (textView != null) {
                textView.setVisibility(8);
            }
            TextView textView2 = this.p;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            TextView textView3 = this.r;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            TextView textView4 = this.q;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            try {
                View findViewById = findViewById(h.a(getContext(), "myoffer_four_element_container_bg", "id"));
                if (findViewById != null) {
                    findViewById.setBackgroundDrawable(null);
                    return;
                }
                return;
            } catch (Throwable th) {
                return;
            }
        }
        this.o.setText(getContext().getResources().getString(h.a(getContext(), "myoffer_panel_version", "string"), iVar.G()));
        this.p.setText(iVar.F());
        this.r.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.PanelView.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                l.b(n.a().g(), iVar.H());
            }
        });
        this.q.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.PanelView.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                l.b(n.a().g(), iVar.I());
            }
        });
        this.o.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.PanelView.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        this.p.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.PanelView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        ViewGroup viewGroup2 = this.n;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(0);
        }
        TextView textView5 = this.o;
        if (textView5 != null) {
            textView5.setVisibility(0);
        }
        TextView textView6 = this.p;
        if (textView6 != null) {
            textView6.setVisibility(0);
        }
        TextView textView7 = this.r;
        if (textView7 != null) {
            textView7.setVisibility(0);
        }
        TextView textView8 = this.q;
        if (textView8 != null) {
            textView8.setVisibility(0);
        }
    }

    private void c() {
        ImageView imageView = this.b;
        if (imageView instanceof RoundImageView) {
            ((RoundImageView) imageView).setNeedRadiu(true);
            int i = this.m;
            if (i == 2 || i == 6) {
                ((RoundImageView) this.b).setRadiusInDip(8);
            } else {
                ((RoundImageView) this.b).setRadiusInDip(12);
            }
            this.b.invalidate();
        }
    }

    private void d() {
        this.v.clear();
        this.b = (ImageView) this.f6143a.findViewById(h.a(getContext(), "myoffer_iv_banner_icon", "id"));
        this.d = (TextView) this.f6143a.findViewById(h.a(getContext(), "myoffer_tv_banner_title", "id"));
        this.e = (TextView) this.f6143a.findViewById(h.a(getContext(), "myoffer_tv_banner_desc", "id"));
        this.f = (Button) this.f6143a.findViewById(h.a(getContext(), "myoffer_btn_banner_cta", "id"));
        this.f6144c = (ImageView) this.f6143a.findViewById(h.a(getContext(), "myoffer_ad_logo", "id"));
        this.n = (ViewGroup) this.f6143a.findViewById(h.a(getContext(), "myoffer_four_element_container", "id"));
        this.o = (TextView) this.f6143a.findViewById(h.a(getContext(), "myoffer_version_name", "id"));
        this.p = (TextView) this.f6143a.findViewById(h.a(getContext(), "myoffer_publisher_name", "id"));
        this.q = (TextView) this.f6143a.findViewById(h.a(getContext(), "myoffer_permission_manage", "id"));
        this.r = (TextView) this.f6143a.findViewById(h.a(getContext(), "myoffer_privacy_agreement", "id"));
        try {
            this.g = (BaseShakeView) this.f6143a.findViewById(h.a(getContext(), "myoffer_shake_hint_text", "id"));
        } catch (Throwable th) {
        }
        e();
    }

    private void e() {
        BaseShakeView baseShakeView;
        if (!this.u || (baseShakeView = this.g) == null || this.m == 8) {
            return;
        }
        baseShakeView.setVisibility(0);
    }

    private void f() {
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setOnClickListener(this.w);
            this.v.add(this.b);
        }
        TextView textView = this.d;
        if (textView != null) {
            textView.setOnClickListener(this.w);
            this.v.add(this.d);
        }
        TextView textView2 = this.e;
        if (textView2 != null) {
            textView2.setOnClickListener(this.w);
            this.v.add(this.e);
        }
        this.f.setOnClickListener(this.w);
        this.v.add(this.f);
        ImageView imageView2 = this.f6144c;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this.w);
            this.v.add(this.f6144c);
        }
        BaseShakeView baseShakeView = this.g;
        if (baseShakeView != null && this.u) {
            baseShakeView.setOnClickListener(new AnonymousClass7());
            this.g.setOnShakeListener(new AnonymousClass8(), this.j);
        }
        View findViewById = this.f6143a.findViewById(h.a(getContext(), "myoffer_panel_view_blank", "id"));
        if (findViewById != null) {
            findViewById.setOnClickListener(this.w);
            this.v.add(findViewById);
            return;
        }
        this.f6143a.setOnClickListener(this.w);
        this.v.add(this.f6143a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.m != 0) {
            super.dispatchDraw(canvas);
            return;
        }
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        super.dispatchDraw(canvas);
        u.a(canvas, getWidth(), getHeight(), h.a(getContext(), 7.0f));
        canvas.restoreToCount(saveLayer);
    }

    public View getCTAButton() {
        return this.f;
    }

    public List<View> getClickViews() {
        return this.v;
    }

    public View getShakeView() {
        return this.g;
    }

    public void init(i iVar, j jVar, int i, boolean z, a aVar) {
        this.h = aVar;
        this.i = i;
        this.l = iVar;
        this.k = jVar;
        this.j = jVar.m;
        this.u = z;
        this.s = iVar.K();
        boolean z2 = true;
        if (this.j.o() != 1) {
            z2 = false;
        }
        this.t = z2;
        this.v = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setLayoutType(int i) {
        this.m = i;
        switch (i) {
            case 1:
                if (!TextUtils.isEmpty(this.l.t())) {
                    this.f6143a = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_panel_view_endcard_horizontal_portrait", "layout"), (ViewGroup) this, true);
                    break;
                } else {
                    this.f6143a = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_panel_view_endcard_portrait_without_icon", "layout"), (ViewGroup) this, true);
                    break;
                }
            case 2:
            case 6:
                if (!TextUtils.isEmpty(this.l.t())) {
                    this.f6143a = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_panel_view_endcard_landscape", "layout"), (ViewGroup) this, true);
                    break;
                } else {
                    this.f6143a = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_panel_view_endcard_landscape_without_icon", "layout"), (ViewGroup) this, true);
                    break;
                }
            case 3:
                if (this.i != 1) {
                    if (!TextUtils.isEmpty(this.l.t())) {
                        this.f6143a = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_panel_view_vertical", "layout"), (ViewGroup) this, true);
                        break;
                    } else {
                        this.f6143a = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_panel_view_vertical_without_icon", "layout"), (ViewGroup) this, true);
                        break;
                    }
                } else if (!TextUtils.isEmpty(this.l.t())) {
                    this.f6143a = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_panel_view_horizontal", "layout"), (ViewGroup) this, true);
                    break;
                } else {
                    this.f6143a = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_panel_view_horizontal_without_icon", "layout"), (ViewGroup) this, true);
                    break;
                }
            case 4:
                if (!TextUtils.isEmpty(this.l.t())) {
                    this.f6143a = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_panel_view_horizontal", "layout"), (ViewGroup) this, true);
                    break;
                } else {
                    this.f6143a = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_panel_view_horizontal_without_icon", "layout"), (ViewGroup) this, true);
                    break;
                }
            case 5:
                if (!TextUtils.isEmpty(this.l.t())) {
                    this.f6143a = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_panel_view_endcard_vertical_portrait", "layout"), (ViewGroup) this, true);
                    break;
                } else {
                    this.f6143a = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_panel_view_endcard_portrait_without_icon", "layout"), (ViewGroup) this, true);
                    break;
                }
            case 7:
                this.f6143a = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_panel_view_empty_info", "layout"), (ViewGroup) this, true);
                break;
            case 8:
                this.f6143a = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_panel_view_full_screen_empty_info", "layout"), (ViewGroup) this, true);
                break;
            default:
                if (!TextUtils.isEmpty(this.l.t())) {
                    this.f6143a = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_panel_view_bottom_banner", "layout"), (ViewGroup) this, true);
                    break;
                } else {
                    this.f6143a = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_panel_view_bottom_banner_without_icon", "layout"), (ViewGroup) this, true);
                    break;
                }
        }
        d();
        i iVar = this.l;
        if (this.b != null) {
            String t = iVar.t();
            if (!TextUtils.isEmpty(t)) {
                ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
                com.anythink.core.common.res.b.a(getContext()).a(new e(1, t), layoutParams.width, layoutParams.height, new AnonymousClass1(t));
            }
            if (TextUtils.isEmpty(iVar.t())) {
                this.b.setVisibility(8);
            }
        }
        if (this.f6144c != null) {
            String v = iVar.v();
            if (TextUtils.isEmpty(v)) {
                this.f6144c.setVisibility(8);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.f6144c.getLayoutParams();
                com.anythink.core.common.res.b.a(getContext()).a(new e(1, v), layoutParams2.width, layoutParams2.height, new AnonymousClass2(v, layoutParams2));
            }
        }
        if (this.e != null) {
            if (TextUtils.isEmpty(iVar.s())) {
                this.e.setVisibility(8);
            } else {
                this.e.setText(iVar.s());
            }
        }
        if (this.d != null) {
            if (TextUtils.isEmpty(iVar.r())) {
                this.d.setVisibility(8);
            } else {
                this.d.setText(iVar.r());
            }
        }
        if (TextUtils.isEmpty(iVar.w())) {
            this.f.setText(com.anythink.basead.a.e.a(getContext(), this.l));
        } else {
            this.f.setText(iVar.w());
        }
        b(iVar);
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setOnClickListener(this.w);
            this.v.add(this.b);
        }
        TextView textView = this.d;
        if (textView != null) {
            textView.setOnClickListener(this.w);
            this.v.add(this.d);
        }
        TextView textView2 = this.e;
        if (textView2 != null) {
            textView2.setOnClickListener(this.w);
            this.v.add(this.e);
        }
        this.f.setOnClickListener(this.w);
        this.v.add(this.f);
        ImageView imageView2 = this.f6144c;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this.w);
            this.v.add(this.f6144c);
        }
        BaseShakeView baseShakeView = this.g;
        if (baseShakeView != null && this.u) {
            baseShakeView.setOnClickListener(new AnonymousClass7());
            this.g.setOnShakeListener(new AnonymousClass8(), this.j);
        }
        View findViewById = this.f6143a.findViewById(h.a(getContext(), "myoffer_panel_view_blank", "id"));
        if (findViewById != null) {
            findViewById.setOnClickListener(this.w);
            this.v.add(findViewById);
        } else {
            this.f6143a.setOnClickListener(this.w);
            this.v.add(this.f6143a);
        }
        ImageView imageView3 = this.b;
        if (imageView3 instanceof RoundImageView) {
            ((RoundImageView) imageView3).setNeedRadiu(true);
            int i2 = this.m;
            if (i2 == 2 || i2 == 6) {
                ((RoundImageView) this.b).setRadiusInDip(8);
            } else {
                ((RoundImageView) this.b).setRadiusInDip(12);
            }
            this.b.invalidate();
        }
    }
}
