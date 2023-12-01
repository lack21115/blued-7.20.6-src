package com.opos.mobad.n.h;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.n.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/h/k.class */
public class k extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f13294a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f13295c;
    private int d;
    private a.InterfaceC0538a e;
    private a f;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/h/k$a.class */
    public interface a {
        void a(int i);
    }

    public k(Context context) {
        super(context);
        this.d = 0;
        c();
    }

    public static k a(Context context) {
        return new k(context);
    }

    private void b(int i) {
        Resources resources;
        int i2;
        TextView textView = this.f13294a;
        if (textView == null || this.d == i) {
            return;
        }
        this.d = i;
        if (i == 0) {
            resources = getContext().getResources();
            i2 = R.drawable.opos_mobad_drawable_block_sound_off;
        } else if (i == 2) {
            textView.setVisibility(8);
            this.b.setVisibility(8);
            return;
        } else {
            resources = getContext().getResources();
            i2 = R.drawable.opos_mobad_drawable_block_sound_on;
        }
        textView.setBackground(resources.getDrawable(i2));
    }

    private void c() {
        setBackgroundResource(R.drawable.opos_mobad_drawable_reward_title_bg);
        setGravity(16);
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        int a3 = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
        setPadding(a3, a2, a3, a2);
        this.f13294a = new TextView(getContext());
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.h.k.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (k.this.e != null) {
                    a.InterfaceC0538a interfaceC0538a = k.this.e;
                    boolean z = true;
                    if (k.this.d != 1) {
                        z = false;
                    }
                    interfaceC0538a.a(view, iArr, z);
                }
            }
        };
        this.f13294a.setOnClickListener(gVar);
        this.f13294a.setOnTouchListener(gVar);
        this.f13294a.setBackground(getContext().getResources().getDrawable(R.drawable.opos_mobad_drawable_block_sound_off));
        addView(this.f13294a, new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 20.0f), com.opos.cmn.an.h.f.a.a(getContext(), 20.0f)));
        View view = new View(getContext());
        this.b = view;
        view.setBackgroundColor(Color.parseColor("#4DFFFFFF"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 1.0f), com.opos.cmn.an.h.f.a.a(getContext(), 12.0f));
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        this.b.setVisibility(8);
        addView(this.b, layoutParams);
        ImageView imageView = new ImageView(getContext());
        this.f13295c = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f13295c.setImageResource(R.drawable.opos_mobad_drawable_block_close);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 20.0f), com.opos.cmn.an.h.f.a.a(getContext(), 20.0f));
        layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        this.f13295c.setVisibility(8);
        addView(this.f13295c, layoutParams2);
        com.opos.mobad.n.c.g gVar2 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.h.k.2
            @Override // com.opos.mobad.n.c.g
            public void a(View view2, int[] iArr) {
                if (k.this.e != null) {
                    k.this.e.d(view2, iArr);
                }
            }
        };
        this.f13295c.setOnTouchListener(gVar2);
        this.f13295c.setOnClickListener(gVar2);
    }

    public void a() {
        this.b.setVisibility(0);
        this.f13295c.setVisibility(0);
    }

    public void a(int i) {
        if (this.d == i) {
            return;
        }
        a aVar = this.f;
        if (aVar != null) {
            aVar.a(i);
        }
        b(i);
    }

    public void a(a.InterfaceC0538a interfaceC0538a) {
        this.e = interfaceC0538a;
    }

    public void a(a aVar) {
        this.f = aVar;
    }

    public void b() {
        this.f13294a.setVisibility(8);
        this.b.setVisibility(8);
        this.f13295c.setVisibility(0);
        ((LinearLayout.LayoutParams) this.f13295c.getLayoutParams()).leftMargin = 0;
    }
}
