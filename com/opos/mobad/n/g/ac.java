package com.opos.mobad.n.g;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.n.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/g/ac.class */
public class ac extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f13080a;
    private ad b;

    public ac(Context context) {
        super(context);
        b(context);
    }

    public static ac a(Context context) {
        return new ac(context);
    }

    private void b(Context context) {
        TextView textView = new TextView(getContext());
        this.f13080a = textView;
        textView.setTextColor(getResources().getColor(R.color.opos_mobad_small_top_title_color));
        this.f13080a.setTextSize(1, 17.0f);
        this.f13080a.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.f13080a.setMaxLines(2);
        addView(this.f13080a, new RelativeLayout.LayoutParams(-1, -2));
        this.b = ad.a(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.b, layoutParams);
    }

    public void a(a.InterfaceC0538a interfaceC0538a) {
        com.opos.cmn.an.f.a.b("BlockSmallLeftAreaView", "setListener " + interfaceC0538a);
        this.b.a(interfaceC0538a);
    }

    public void a(com.opos.mobad.n.d.d dVar) {
        if (dVar == null) {
            return;
        }
        String str = dVar.e;
        if (!TextUtils.isEmpty(str)) {
            this.f13080a.setText(str);
        }
        this.b.a(dVar.r, dVar.s, dVar.i, dVar.j, dVar.k, dVar.B, dVar.f);
    }
}
