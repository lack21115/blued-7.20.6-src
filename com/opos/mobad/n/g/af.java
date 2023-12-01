package com.opos.mobad.n.g;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.n.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/g/af.class */
public class af extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private ae f26777a;
    private LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f26778c;
    private int d;
    private a.InterfaceC0708a e;
    private a f;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/g/af$a.class */
    public interface a {
        void a(int i);
    }

    public af(Context context, boolean z) {
        super(context);
        this.d = 0;
        a(z);
    }

    public static af a(Context context, boolean z) {
        return new af(context, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        int i = this.d;
        int i2 = 1;
        if (i != 0) {
            i2 = i == 1 ? 0 : -1;
        }
        if (i2 == -1) {
            return;
        }
        a aVar = this.f;
        if (aVar != null) {
            aVar.a(i2);
        }
        a(i2);
    }

    private void a(int i) {
        Resources resources;
        int i2;
        TextView textView = this.f26778c;
        if (textView == null || this.d == i) {
            return;
        }
        this.d = i;
        if (i == 0) {
            resources = getContext().getResources();
            i2 = R.drawable.opos_mobad_drawable_block_sound_off;
        } else if (i == 2) {
            textView.setVisibility(8);
            return;
        } else {
            resources = getContext().getResources();
            i2 = R.drawable.opos_mobad_drawable_block_sound_on;
        }
        textView.setBackground(resources.getDrawable(i2));
    }

    private void a(boolean z) {
        this.f26777a = ae.a(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        layoutParams.addRule(9);
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        layoutParams.leftMargin = a2;
        layoutParams.addRule(15);
        addView(this.f26777a, layoutParams);
        this.b = new LinearLayout(getContext());
        ImageView imageView = new ImageView(getContext());
        this.b.setId(View.generateViewId());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(R.drawable.opos_mobad_drawable_block_close);
        this.b.addView(imageView, new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 16.0f), com.opos.cmn.an.h.f.a.a(getContext(), 16.0f)));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.rightMargin = a2;
        layoutParams2.addRule(11);
        layoutParams2.addRule(15);
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.af.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (af.this.e != null) {
                    af.this.e.d(view, iArr);
                }
            }
        };
        this.b.setOnTouchListener(gVar);
        this.b.setOnClickListener(gVar);
        addView(this.b, layoutParams2);
        if (z) {
            this.f26778c = new TextView(getContext());
            com.opos.mobad.n.c.g gVar2 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.af.2
                @Override // com.opos.mobad.n.c.g
                public void a(View view, int[] iArr) {
                    if (af.this.e != null) {
                        af.this.a();
                        a.InterfaceC0708a interfaceC0708a = af.this.e;
                        boolean z2 = true;
                        if (af.this.d != 1) {
                            z2 = false;
                        }
                        interfaceC0708a.a(view, iArr, z2);
                    }
                }
            };
            this.f26778c.setOnClickListener(gVar2);
            this.f26778c.setOnTouchListener(gVar2);
            this.f26778c.setBackground(getContext().getResources().getDrawable(R.drawable.opos_mobad_drawable_block_sound_off));
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 16.0f), com.opos.cmn.an.h.f.a.a(getContext(), 16.0f));
            layoutParams3.addRule(0, this.b.getId());
            layoutParams3.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 10.0f);
            addView(this.f26778c, layoutParams3);
        }
    }

    public void a(a.InterfaceC0708a interfaceC0708a) {
        this.e = interfaceC0708a;
        this.f26777a.a(interfaceC0708a);
    }

    public void a(a aVar) {
        this.f = aVar;
    }

    public void a(boolean z, String str, boolean z2, com.opos.mobad.n.d.g gVar, String str2, int i) {
        this.f26777a.a(z, str, z2, gVar, str2);
        a(i);
    }
}
