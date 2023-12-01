package com.opos.mobad.n.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.c.a;
import com.opos.mobad.n.a;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/h/f.class */
public class f extends RelativeLayout implements com.opos.mobad.n.a {

    /* renamed from: a  reason: collision with root package name */
    private com.opos.mobad.n.c.f f26964a;
    private TextView b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f26965c;
    private j d;
    private e e;
    private LinearLayout f;
    private com.opos.mobad.c.a g;
    private boolean h;
    private int i;
    private boolean j;
    private a.InterfaceC0708a k;

    public f(Context context, boolean z, com.opos.mobad.c.a aVar, int i) {
        super(context);
        this.h = false;
        this.j = false;
        a(com.opos.mobad.c.b.a.a(getContext()) ? true : z);
        this.g = aVar;
        this.i = i;
    }

    public static f a(Context context, com.opos.mobad.c.a aVar, int i) {
        return new f(context, true, aVar, i);
    }

    private void a(LinearLayout linearLayout) {
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.f = linearLayout2;
        linearLayout2.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        layoutParams.gravity = 1;
        linearLayout.addView(this.f, layoutParams);
    }

    private void a(RelativeLayout relativeLayout, boolean z) {
        Context context;
        float f;
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(R.drawable.opos_mobad_drawable_block_close);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 20.0f), com.opos.cmn.an.h.f.a.a(getContext(), 20.0f));
        layoutParams.addRule(11);
        if (z) {
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 53.0f);
            context = getContext();
            f = 28.0f;
        } else {
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 20.0f);
            context = getContext();
            f = 54.0f;
        }
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(context, f);
        relativeLayout.addView(imageView, layoutParams);
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.h.f.2
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (f.this.k != null) {
                    f.this.k.d(view, iArr);
                }
            }
        };
        imageView.setOnTouchListener(gVar);
        imageView.setOnClickListener(gVar);
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        j jVar;
        com.opos.mobad.n.d.a aVar = dVar.v;
        if (aVar == null || TextUtils.isEmpty(aVar.f26626a) || TextUtils.isEmpty(aVar.b) || (jVar = this.d) == null) {
            return;
        }
        jVar.setVisibility(0);
        this.d.a(aVar.f26626a, aVar.b);
    }

    private void a(com.opos.mobad.n.d.g gVar, com.opos.mobad.c.a aVar) {
        this.f26964a.setScaleType(ImageView.ScaleType.FIT_XY);
        if (gVar == null) {
            com.opos.cmn.an.f.a.b("RewardEndPage", "iconUrl is null");
        } else if (this.j) {
        } else {
            this.j = true;
            int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 60.0f);
            aVar.a(gVar.f26633a, gVar.b, a2, a2, new a.InterfaceC0676a() { // from class: com.opos.mobad.n.h.f.3
                @Override // com.opos.mobad.c.a.InterfaceC0676a
                public void a(int i, final Bitmap bitmap) {
                    if (f.this.h) {
                        return;
                    }
                    if (i != 0 && i != 1) {
                        if (f.this.k != null) {
                            f.this.k.c(i);
                            return;
                        }
                        return;
                    }
                    if (i == 1 && f.this.k != null) {
                        f.this.k.c(i);
                    }
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.h.f.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap2;
                            if (f.this.h || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                return;
                            }
                            f.this.f26964a.setImageBitmap(bitmap);
                        }
                    });
                }
            });
        }
    }

    private void a(com.opos.mobad.n.d.g gVar, String str, String str2, String str3, com.opos.mobad.c.a aVar) {
        if (!TextUtils.isEmpty(str)) {
            this.e.a(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.b.setVisibility(0);
            this.b.setText(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            this.f26965c.setVisibility(0);
            this.f26965c.setText(str3);
        }
        if (gVar == null || TextUtils.isEmpty(gVar.f26633a)) {
            this.f26964a.setVisibility(0);
            this.f26964a.setVisibility(8);
            return;
        }
        this.f26964a.setVisibility(0);
        a(gVar, aVar);
    }

    private void a(String str, int i) {
        if (TextUtils.isEmpty(str) || i >= 3) {
            return;
        }
        if (this.f.getVisibility() != 0) {
            this.f.setVisibility(0);
        }
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 14.0f);
        int a3 = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        TextView textView = new TextView(getContext());
        textView.setTextColor(Color.parseColor("#8CFFFFFF"));
        textView.setTextSize(1, 10.0f);
        textView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(6)});
        textView.setText(str);
        textView.setPadding(a3, 0, a3, 0);
        textView.setBackgroundResource(R.drawable.opos_mobad_drawable_reward_label_bg);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, a2);
        if (i > 0) {
            layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        }
        this.f.addView(textView, layoutParams);
    }

    private void a(List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            a(list.get(i2), i2);
            i = i2 + 1;
        }
    }

    private void a(boolean z) {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        relativeLayout.setBackgroundColor(Color.parseColor("#B3000000"));
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.h.f.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (f.this.k != null) {
                    f.this.k.j(view, iArr);
                }
            }
        };
        relativeLayout.setOnClickListener(gVar);
        relativeLayout.setOnTouchListener(gVar);
        b(linearLayout);
        c(linearLayout);
        a(linearLayout);
        d(linearLayout);
        a(relativeLayout, z);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 360.0f), -2);
        layoutParams.addRule(13);
        relativeLayout.addView(linearLayout, layoutParams);
        addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void b(LinearLayout linearLayout) {
        com.opos.mobad.n.c.f fVar = new com.opos.mobad.n.c.f(getContext(), com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        this.f26964a = fVar;
        fVar.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f26964a.setVisibility(8);
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 60.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a2, a2);
        layoutParams.gravity = 1;
        linearLayout.addView(this.f26964a, layoutParams);
    }

    private void c(LinearLayout linearLayout) {
        TextView textView = new TextView(getContext());
        this.b = textView;
        textView.setTextColor(Color.parseColor("#D9FFFFFF"));
        this.b.setTextSize(1, 14.0f);
        this.b.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.b.setSingleLine(true);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        this.b.setVisibility(8);
        layoutParams.gravity = 1;
        linearLayout.addView(this.b, layoutParams);
        TextView textView2 = new TextView(getContext());
        this.f26965c = textView2;
        textView2.setTextColor(Color.parseColor("#8CFFFFFF"));
        this.f26965c.setTextSize(1, 10.0f);
        this.f26965c.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.f26965c.setSingleLine(true);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        this.f26965c.setVisibility(8);
        layoutParams2.gravity = 1;
        linearLayout.addView(this.f26965c, layoutParams2);
        this.d = j.a(getContext());
        new RelativeLayout.LayoutParams(-1, -2).addRule(5);
        this.d.setGravity(3);
        this.d.setVisibility(8);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        layoutParams3.gravity = 1;
        linearLayout.addView(this.d, layoutParams3);
    }

    private void d(LinearLayout linearLayout) {
        this.e = e.a(getContext(), "");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 220.0f), com.opos.cmn.an.h.f.a.a(getContext(), 44.0f));
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 24.0f);
        layoutParams.gravity = 1;
        linearLayout.addView(this.e, layoutParams);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0708a interfaceC0708a) {
        this.k = interfaceC0708a;
        this.e.a(interfaceC0708a);
        this.d.a(interfaceC0708a);
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        a.InterfaceC0708a interfaceC0708a;
        if (hVar == null) {
            com.opos.cmn.an.f.a.b("RewardEndPage", "data is null");
            interfaceC0708a = this.k;
            if (interfaceC0708a == null) {
                return;
            }
        } else {
            com.opos.mobad.n.d.f e = hVar.e();
            if (e != null) {
                a(e.f26631a, e.d, e.b, e.f26632c, this.g);
                a(e);
                a(e.n);
                return;
            }
            com.opos.cmn.an.f.a.d("", "render with data null");
            interfaceC0708a = this.k;
            if (interfaceC0708a == null) {
                return;
            }
        }
        interfaceC0708a.b(1);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        this.h = true;
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.i;
    }

    @Override // com.opos.mobad.n.a
    /* renamed from: f */
    public RelativeLayout c() {
        return this;
    }
}
