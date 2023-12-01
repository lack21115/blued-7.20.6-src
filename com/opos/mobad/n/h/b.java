package com.opos.mobad.n.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.c.a;
import com.opos.mobad.n.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/h/b.class */
public class b extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private c f13262a;
    private com.opos.mobad.n.c.f b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f13263c;
    private LinearLayout d;
    private TextView e;
    private TextView f;
    private j g;
    private boolean h;
    private boolean i;
    private a.InterfaceC0538a j;

    public b(Context context) {
        super(context);
        this.h = false;
        this.i = false;
        b(context);
    }

    public static b a(Context context) {
        return new b(context);
    }

    private void a(com.opos.mobad.n.d.g gVar, com.opos.mobad.c.a aVar) {
        this.b.setScaleType(ImageView.ScaleType.FIT_XY);
        if (gVar == null) {
            com.opos.cmn.an.f.a.b("RewardBottomAreaView", "iconUrl is null");
        } else if (this.i) {
        } else {
            this.i = true;
            int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 44.0f);
            aVar.a(gVar.f12945a, gVar.b, a2, a2, new a.InterfaceC0506a() { // from class: com.opos.mobad.n.h.b.2
                @Override // com.opos.mobad.c.a.InterfaceC0506a
                public void a(int i, final Bitmap bitmap) {
                    if (b.this.h) {
                        return;
                    }
                    if (i != 0 && i != 1) {
                        if (b.this.j != null) {
                            b.this.j.c(i);
                            return;
                        }
                        return;
                    }
                    if (i == 1 && b.this.j != null) {
                        b.this.j.c(i);
                    }
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.h.b.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap2;
                            if (b.this.h || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                return;
                            }
                            b.this.b.setImageBitmap(bitmap);
                        }
                    });
                }
            });
        }
    }

    private void b() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.d = linearLayout;
        linearLayout.setOrientation(1);
        TextView textView = new TextView(getContext());
        this.e = textView;
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        this.e.setTextSize(1, 14.0f);
        this.e.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.e.setSingleLine(true);
        TextPaint paint = this.e.getPaint();
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        TextView textView2 = new TextView(getContext());
        this.f = textView2;
        textView2.setTextColor(Color.parseColor("#8CFFFFFF"));
        this.f.setTextSize(1, 10.0f);
        this.f.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.f.setSingleLine(true);
        this.f.setVisibility(8);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        this.g = j.a(getContext());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(5);
        this.g.setGravity(3);
        this.g.setVisibility(8);
        relativeLayout.addView(this.f, layoutParams3);
        relativeLayout.addView(this.g, layoutParams4);
        this.d.addView(this.e, layoutParams);
        this.d.addView(relativeLayout, layoutParams2);
    }

    private void b(Context context) {
        setBackgroundResource(R.drawable.opos_mobad_drawable_reward_bottom_bg);
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        setPadding(a2, a2, a2, a2);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.f13263c = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        int a3 = com.opos.cmn.an.h.f.a.a(getContext(), 0.33f);
        this.f13263c.setPadding(a3, a3, a3, a3);
        this.f13263c.setBackgroundResource(R.drawable.opos_mobad_drawable_block_icon_stroke);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 44.0f), com.opos.cmn.an.h.f.a.a(getContext(), 44.0f));
        layoutParams.addRule(15);
        this.f13263c.setVisibility(0);
        com.opos.mobad.n.c.f fVar = new com.opos.mobad.n.c.f(getContext(), com.opos.cmn.an.h.f.a.a(getContext(), 12.0f));
        this.b = fVar;
        fVar.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        c a4 = c.a(context, "");
        this.f13262a = a4;
        a4.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(15);
        layoutParams3.addRule(11);
        b();
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(15);
        layoutParams4.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        layoutParams4.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        layoutParams4.addRule(1, this.f13263c.getId());
        layoutParams4.addRule(0, this.f13262a.getId());
        this.f13263c.addView(this.b, layoutParams2);
        addView(this.f13263c, layoutParams);
        addView(this.f13262a, layoutParams3);
        addView(this.d, layoutParams4);
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.h.b.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (b.this.h || b.this.j == null) {
                    return;
                }
                b.this.j.g(view, iArr);
            }
        };
        setOnClickListener(gVar);
        setOnTouchListener(gVar);
    }

    public void a() {
        this.h = true;
    }

    public void a(a.InterfaceC0538a interfaceC0538a) {
        com.opos.cmn.an.f.a.b("RewardBottomAreaView", "setListener " + interfaceC0538a);
        this.j = interfaceC0538a;
        this.f13262a.a(interfaceC0538a);
        this.g.a(interfaceC0538a);
    }

    public void a(com.opos.mobad.n.d.d dVar) {
        com.opos.mobad.n.d.a aVar = dVar.v;
        if (aVar == null || TextUtils.isEmpty(aVar.f12938a) || TextUtils.isEmpty(aVar.b)) {
            this.f.setVisibility(0);
            return;
        }
        j jVar = this.g;
        if (jVar != null) {
            jVar.setVisibility(0);
            this.g.a(aVar.f12938a, aVar.b);
        }
    }

    public void a(com.opos.mobad.n.d.g gVar, String str, String str2, String str3, com.opos.mobad.c.a aVar) {
        if (!TextUtils.isEmpty(str)) {
            this.f13262a.setText(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.e.setText(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            this.f.setText(str3);
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.f12945a)) {
            this.f13263c.setVisibility(0);
            a(gVar, aVar);
            return;
        }
        this.f13263c.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.width = -1;
        this.d.setLayoutParams(layoutParams);
    }
}
