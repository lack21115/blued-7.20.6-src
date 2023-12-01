package com.anythink.expressad.video.dynview.ordercamp.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.g.d.b;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.video.dynview.widget.ATRotationView;
import com.anythink.expressad.video.dynview.widget.AnyThinkImageView;
import com.anythink.expressad.video.dynview.widget.AnyThinkLevelLayoutView;
import com.anythink.expressad.video.dynview.widget.AnyThinkTextView;
import com.anythink.expressad.videocommon.view.RoundImageView;
import java.util.List;
import java.util.Locale;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/dynview/ordercamp/a/a.class */
public final class a extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5562a = "OrderCampAdapter";
    private static final String e = "anythink_lv_item_rl";
    private static final String f = "anythink_lv_iv";
    private static final String g = "anythink_lv_icon_iv";
    private static final String h = "anythink_lv_title_tv";
    private static final String i = "anythink_lv_tv_install";
    private static final String j = "anythink_lv_sv_starlevel";
    private static final String k = "anythink_lv_sv_heat_level";
    private static final String l = "anythink_lv_ration";
    private static final String m = "anythink_lv_desc_tv";
    private static final String n = "anythink_iv_flag";
    private static final String o = "anythink_order_viewed_tv";
    private static final String p = "anythink_order_layout_item";
    private static final String q = "anythink_lv_iv_burl";
    private static final String r = "501";
    private static final String s = "\\.xml";
    private static final String t = "\\/xml";
    private static final String u = "_item.xml";
    private boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private C0091a f5563c;
    private List<c> d;

    /* renamed from: com.anythink.expressad.video.dynview.ordercamp.a.a$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/dynview/ordercamp/a/a$2.class */
    final class AnonymousClass2 implements com.anythink.expressad.foundation.g.d.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f5566a;

        AnonymousClass2(Context context) {
            this.f5566a = context;
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(Bitmap bitmap, String str) {
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            try {
                float width = (bitmap.getWidth() * 1.0f) / bitmap.getHeight();
                int b = t.b(this.f5566a, 12.0f);
                int i = (int) (b * width);
                a.this.f5563c.j.getLayoutParams().height = b;
                a.this.f5563c.j.getLayoutParams().width = i;
                a.this.f5563c.j.setImageBitmap(bitmap);
                a.this.f5563c.j.setBackgroundColor(1426063360);
            } catch (Throwable th) {
            }
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(String str, String str2) {
        }
    }

    /* renamed from: com.anythink.expressad.video.dynview.ordercamp.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/dynview/ordercamp/a/a$a.class */
    static final class C0091a {

        /* renamed from: a  reason: collision with root package name */
        RelativeLayout f5567a;
        ATRotationView b;

        /* renamed from: c  reason: collision with root package name */
        AnyThinkImageView f5568c;
        RoundImageView d;
        TextView e;
        TextView f;
        TextView g;
        TextView h;
        AnyThinkLevelLayoutView i;
        ImageView j;

        C0091a() {
        }
    }

    public a(List<c> list) {
        this.d = list;
    }

    private static int a(String str) {
        return i.a(n.a().g().getApplicationContext(), str, "layout");
    }

    private View a() {
        View inflate = LayoutInflater.from(n.a().g()).inflate(i.a(n.a().g().getApplicationContext(), p, "layout"), (ViewGroup) null);
        C0091a c0091a = new C0091a();
        this.f5563c = c0091a;
        c0091a.f5568c = (AnyThinkImageView) inflate.findViewById(b(f));
        this.f5563c.d = (RoundImageView) inflate.findViewById(b(g));
        this.f5563c.i = (AnyThinkLevelLayoutView) inflate.findViewById(b(j));
        this.f5563c.b = (ATRotationView) inflate.findViewById(b(l));
        inflate.setTag(this.f5563c);
        return inflate;
    }

    private void a(int i2) {
        List<c> list = this.d;
        if (list == null || this.f5563c == null || list.size() == 0) {
            return;
        }
        if (this.f5563c.f5568c != null) {
            a(this.f5563c.f5568c, this.d.get(i2).be(), false);
        }
        if (this.f5563c.d != null) {
            this.f5563c.d.setBorderRadius(25);
            a(this.f5563c.d, this.d.get(i2).bd(), true);
        }
        double aX = this.d.get(i2).aX();
        double d = aX;
        if (aX <= 0.0d) {
            d = 5.0d;
        }
        if (this.f5563c.i != null) {
            this.f5563c.i.setRatingAndUser(d, this.d.get(i2).aY());
            this.f5563c.i.setOrientation(0);
        }
        if (this.f5563c.b != null) {
            this.f5563c.b.setWidthRatio(1.0f);
            this.f5563c.b.setHeightRatio(1.0f);
            this.f5563c.b.setAutoscroll(false);
        }
        if (this.f5563c.f5568c != null) {
            this.f5563c.f5568c.setCustomBorder(30, 30, 30, 30, 10, -1728053248);
        }
    }

    private void a(View view) {
        this.f5563c.f5567a = (RelativeLayout) view.findViewById(d(e));
        this.f5563c.e = (TextView) view.findViewById(d(h));
        this.f5563c.g = (TextView) view.findViewById(d(i));
        this.f5563c.f = (TextView) view.findViewById(d(m));
        this.f5563c.j = (ImageView) view.findViewById(d(n));
        this.f5563c.h = (TextView) view.findViewById(d(o));
    }

    private void a(final ImageView imageView, String str, final boolean z) {
        if (imageView == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            b.a(imageView.getContext()).a(str, new com.anythink.expressad.foundation.g.d.c() { // from class: com.anythink.expressad.video.dynview.ordercamp.a.a.1
                @Override // com.anythink.expressad.foundation.g.d.c
                public final void a(Bitmap bitmap, String str2) {
                    try {
                        if (bitmap.isRecycled()) {
                            return;
                        }
                        imageView.setImageBitmap(bitmap);
                    } catch (Throwable th) {
                        o.d(a.f5562a, th.getMessage());
                    }
                }

                @Override // com.anythink.expressad.foundation.g.d.c
                public final void a(String str2, String str3) {
                    if (z) {
                        imageView.setVisibility(8);
                    }
                }
            });
        } else if (z) {
            imageView.setVisibility(8);
        }
    }

    private static int b(String str) {
        return i.a(n.a().g().getApplicationContext(), str, "id");
    }

    private View b() {
        View inflate = LayoutInflater.from(n.a().g()).inflate(i.a(n.a().g().getApplicationContext(), p, "layout"), (ViewGroup) null);
        C0091a c0091a = new C0091a();
        this.f5563c = c0091a;
        c0091a.f5568c = (AnyThinkImageView) inflate.findViewById(b(f));
        this.f5563c.d = (RoundImageView) inflate.findViewById(b(g));
        this.f5563c.i = (AnyThinkLevelLayoutView) inflate.findViewById(b(j));
        this.f5563c.b = (ATRotationView) inflate.findViewById(b(l));
        inflate.setTag(this.f5563c);
        return inflate;
    }

    private void b(int i2) {
        if (this.f5563c != null) {
            c cVar = this.d.get(i2);
            if (this.f5563c.e != null) {
                this.f5563c.e.setText(cVar.bb());
            }
            if (this.f5563c.f != null) {
                this.f5563c.f.setText(cVar.bc());
            }
            if (this.f5563c.g != null) {
                String str = cVar.cU;
                if (this.f5563c.g instanceof AnyThinkTextView) {
                    new com.anythink.expressad.video.dynview.h.b();
                    ((AnyThinkTextView) this.f5563c.g).setObjectAnimator(com.anythink.expressad.video.dynview.h.b.c(this.f5563c.g));
                }
                this.f5563c.g.setText(str);
            }
            if (this.f5563c.j != null) {
                try {
                    Locale.getDefault().getLanguage();
                    Context g2 = n.a().g();
                    b.a(g2).a(cVar.aE(), new AnonymousClass2(g2));
                } catch (Exception e2) {
                    o.d(f5562a, e2.getMessage());
                }
            }
            if (this.f5563c.h != null) {
                try {
                    this.f5563c.h.setText(n.a().g().getResources().getString(n.a().g().getResources().getIdentifier("anythink_reward_viewed_text_str", "string", n.a().g().getPackageName())));
                    this.f5563c.h.setVisibility(0);
                } catch (Exception e3) {
                    o.d(f5562a, e3.getMessage());
                }
            }
        }
    }

    private static int c(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return str.hashCode();
    }

    private int d(String str) {
        return this.b ? c(str) : b(str);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List<c> list = this.d;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return this.d.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i2) {
        List<c> list = this.d;
        if (list != null) {
            return list.get(i2);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i2) {
        return i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v17, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v20, types: [java.lang.String] */
    @Override // android.widget.Adapter
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        try {
            if (view == null) {
                View inflate = LayoutInflater.from(n.a().g()).inflate(i.a(n.a().g().getApplicationContext(), p, "layout"), (ViewGroup) null);
                C0091a c0091a = new C0091a();
                this.f5563c = c0091a;
                c0091a.f5568c = (AnyThinkImageView) inflate.findViewById(b(f));
                this.f5563c.d = (RoundImageView) inflate.findViewById(b(g));
                this.f5563c.i = (AnyThinkLevelLayoutView) inflate.findViewById(b(j));
                this.f5563c.b = (ATRotationView) inflate.findViewById(b(l));
                inflate.setTag(this.f5563c);
                view = inflate;
            } else {
                this.f5563c = (C0091a) view.getTag();
            }
            View view3 = view;
            this.f5563c.f5567a = (RelativeLayout) view.findViewById(d(e));
            View view4 = view;
            this.f5563c.e = (TextView) view.findViewById(d(h));
            View view5 = view;
            this.f5563c.g = (TextView) view.findViewById(d(i));
            View view6 = view;
            this.f5563c.f = (TextView) view.findViewById(d(m));
            View view7 = view;
            this.f5563c.j = (ImageView) view.findViewById(d(n));
            View view8 = view;
            this.f5563c.h = (TextView) view.findViewById(d(o));
            View view9 = view;
            if (this.d != null) {
                View view10 = view;
                if (this.f5563c != null && this.d.size() != 0) {
                    View view11 = view;
                    if (this.f5563c.f5568c != null) {
                        View view12 = view;
                        a(this.f5563c.f5568c, this.d.get(i2).be(), false);
                    }
                    View view13 = view;
                    if (this.f5563c.d != null) {
                        View view14 = view;
                        this.f5563c.d.setBorderRadius(25);
                        View view15 = view;
                        a(this.f5563c.d, this.d.get(i2).bd(), true);
                    }
                    View view16 = view;
                    double aX = this.d.get(i2).aX();
                    double d = aX;
                    if (aX <= 0.0d) {
                        d = 5.0d;
                    }
                    if (this.f5563c.i != null) {
                        View view17 = view;
                        this.f5563c.i.setRatingAndUser(d, this.d.get(i2).aY());
                        View view18 = view;
                        this.f5563c.i.setOrientation(0);
                    }
                    View view19 = view;
                    if (this.f5563c.b != null) {
                        View view20 = view;
                        this.f5563c.b.setWidthRatio(1.0f);
                        View view21 = view;
                        this.f5563c.b.setHeightRatio(1.0f);
                        View view22 = view;
                        this.f5563c.b.setAutoscroll(false);
                    }
                    View view23 = view;
                    if (this.f5563c.f5568c != null) {
                        View view24 = view;
                        this.f5563c.f5568c.setCustomBorder(30, 30, 30, 30, 10, -1728053248);
                    }
                }
            }
            View view25 = view;
            view2 = view;
            if (this.f5563c != null) {
                View view26 = view;
                c cVar = this.d.get(i2);
                View view27 = view;
                if (this.f5563c.e != null) {
                    View view28 = view;
                    String bb = cVar.bb();
                    View view29 = view;
                    this.f5563c.e.setText(bb);
                }
                View view30 = view;
                if (this.f5563c.f != null) {
                    View view31 = view;
                    String bc = cVar.bc();
                    View view32 = view;
                    this.f5563c.f.setText(bc);
                }
                View view33 = view;
                if (this.f5563c.g != null) {
                    View view34 = view;
                    String str = cVar.cU;
                    View view35 = view;
                    if (this.f5563c.g instanceof AnyThinkTextView) {
                        View view36 = view;
                        new com.anythink.expressad.video.dynview.h.b();
                        View view37 = view;
                        View view38 = view;
                        ((AnyThinkTextView) this.f5563c.g).setObjectAnimator(com.anythink.expressad.video.dynview.h.b.c(this.f5563c.g));
                    }
                    View view39 = view;
                    this.f5563c.g.setText(str);
                }
                viewGroup = view;
                if (this.f5563c.j != null) {
                    try {
                        Locale.getDefault().getLanguage();
                        viewGroup = n.a().g();
                        b.a((Context) viewGroup).a(cVar.aE(), new AnonymousClass2(viewGroup));
                    } catch (Exception e2) {
                        o.d(f5562a, e2.getMessage());
                    }
                }
                viewGroup = view;
                view2 = view;
                if (this.f5563c.h != null) {
                    try {
                        viewGroup = n.a().g().getPackageName();
                        this.f5563c.h.setText(n.a().g().getResources().getString(n.a().g().getResources().getIdentifier("anythink_reward_viewed_text_str", "string", viewGroup)));
                        this.f5563c.h.setVisibility(0);
                        return view;
                    } catch (Exception e3) {
                        viewGroup = view;
                        o.d(f5562a, e3.getMessage());
                        return view;
                    }
                }
            }
        } catch (Exception e4) {
            o.d(f5562a, e4.getMessage());
            view2 = viewGroup;
        }
        return view2;
    }
}
