package com.opos.mobad.n.h;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.n.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/h/h.class */
public class h extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private a.InterfaceC0708a f26973a;

    public h(Context context, boolean z) {
        super(context);
        a(z);
    }

    public static h a(Context context) {
        return new h(context, true);
    }

    private void a(boolean z) {
        Context context;
        float f;
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setBackgroundColor(Color.parseColor("#000000"));
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.h.h.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (h.this.f26973a != null) {
                    h.this.f26973a.g(view, iArr);
                }
            }
        };
        relativeLayout.setOnClickListener(gVar);
        relativeLayout.setOnTouchListener(gVar);
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
        com.opos.mobad.n.c.g gVar2 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.h.h.2
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (h.this.f26973a != null) {
                    h.this.f26973a.d(view, iArr);
                }
            }
        };
        imageView.setOnTouchListener(gVar2);
        imageView.setOnClickListener(gVar2);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        ProgressBar progressBar = new ProgressBar(getContext());
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 40.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a2, a2);
        layoutParams2.addRule(13);
        progressBar.setVisibility(0);
        linearLayout.addView(progressBar, layoutParams2);
        TextView textView = new TextView(getContext());
        textView.setTextColor(Color.parseColor("#4DFFFFFF"));
        textView.setTextSize(1, 14.0f);
        textView.setText("正在加载...");
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        linearLayout.addView(textView, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(13);
        relativeLayout.addView(linearLayout, layoutParams4);
        addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -1));
    }

    public static h b(Context context) {
        return new h(context, false);
    }

    public void a(a.InterfaceC0708a interfaceC0708a) {
        this.f26973a = interfaceC0708a;
    }
}
