package com.opos.mobad.n.h;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/h/i.class */
public class i extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private a f13288a;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/h/i$a.class */
    public interface a {
        void a(View view, int[] iArr);
    }

    public i(Context context) {
        super(context);
        a();
    }

    public static i a(Context context) {
        return new i(context);
    }

    private void a() {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        RelativeLayout relativeLayout2 = new RelativeLayout(getContext());
        RelativeLayout relativeLayout3 = new RelativeLayout(getContext());
        relativeLayout2.setBackgroundResource(R.drawable.opos_mobad_drawable_reward_dialog_bg);
        relativeLayout.setBackgroundColor(Color.parseColor("#B3000000"));
        TextView textView = new TextView(getContext());
        textView.setId(View.generateViewId());
        textView.setTextColor(Color.parseColor("#D9000000"));
        textView.setTextSize(1, 16.0f);
        textView.setText("播放失败");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        TextPaint paint = textView.getPaint();
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        relativeLayout3.addView(textView, layoutParams);
        TextView textView2 = new TextView(getContext());
        textView2.setTextColor(Color.parseColor("#2D40E9"));
        textView2.setGravity(1);
        textView2.setTextSize(1, 14.0f);
        textView2.setText("确认");
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(getContext(), 20.0f));
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 31.0f);
        layoutParams2.addRule(14);
        layoutParams2.addRule(3, textView.getId());
        TextPaint paint2 = textView2.getPaint();
        paint2.setStrokeWidth(1.0f);
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        relativeLayout3.addView(textView2, layoutParams2);
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.h.i.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (i.this.f13288a != null) {
                    i.this.f13288a.a(view, iArr);
                }
            }
        };
        textView2.setOnClickListener(gVar);
        textView2.setOnTouchListener(gVar);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 328.0f), -2);
        layoutParams3.addRule(15);
        relativeLayout2.addView(relativeLayout3, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 328.0f), com.opos.cmn.an.h.f.a.a(getContext(), 120.0f));
        layoutParams4.addRule(13);
        relativeLayout.addView(relativeLayout2, layoutParams4);
        addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -1));
    }

    public void a(a aVar) {
        this.f13288a = aVar;
    }
}
