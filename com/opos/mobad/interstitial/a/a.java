package com.opos.mobad.interstitial.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/interstitial/a/a.class */
public class a {
    public static final View a(com.opos.mobad.n.d.d dVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup == null) {
            return null;
        }
        Context context = viewGroup.getContext();
        TextView textView = new TextView(context);
        textView.setPadding(com.opos.cmn.an.h.f.a.a(context, 4.0f), com.opos.cmn.an.h.f.a.a(context, 2.0f), com.opos.cmn.an.h.f.a.a(context, 4.0f), com.opos.cmn.an.h.f.a.a(context, 2.0f));
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        textView.setTextSize(1, 8.0f);
        textView.setGravity(17);
        textView.setMaxEms(6);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine();
        textView.setVisibility(8);
        ViewGroup.LayoutParams layoutParams2 = layoutParams;
        if (layoutParams == null) {
            layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
        }
        if (dVar != null && dVar.i) {
            String str = dVar.q;
            Drawable drawable = null;
            if (!com.opos.cmn.an.c.a.a(str)) {
                boolean z = true;
                int hashCode = str.hashCode();
                if (hashCode != -1394031459) {
                    if (hashCode == 3138 && str.equals(com.anythink.expressad.foundation.g.a.L)) {
                        z = false;
                    }
                } else if (str.equals("bd_api")) {
                    z = true;
                }
                if (!z || z) {
                    drawable = com.opos.cmn.an.d.a.a.c(context, "opos_module_biz_ui_cmn_bd_logo_img.png");
                } else {
                    drawable = null;
                    if (dVar.j != null) {
                        drawable = null;
                        if (!com.opos.cmn.an.c.a.a(dVar.j.f12945a)) {
                            drawable = com.opos.mobad.cmn.a.b.g.b(context, dVar.j.f12945a);
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("getLogoDrawable=");
            sb.append(drawable != null ? drawable : com.igexin.push.core.b.l);
            com.opos.cmn.an.f.a.b("AdViewUtils", sb.toString());
            if (drawable != null) {
                com.opos.mobad.cmn.a.b.g.a(textView, drawable);
                layoutParams2.width = com.opos.cmn.an.h.f.a.a(context, 26.0f);
                layoutParams2.height = com.opos.cmn.an.h.f.a.a(context, 12.0f);
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(Color.parseColor("#3D151515"));
                gradientDrawable.setCornerRadius(5.0f);
                com.opos.mobad.cmn.a.b.g.a(textView, gradientDrawable);
                if (!com.opos.cmn.an.c.a.a(dVar.k)) {
                    textView.setText(dVar.k);
                }
                layoutParams2.width = -2;
                layoutParams2.height = -2;
            }
            textView.setVisibility(0);
        }
        viewGroup.addView(textView, layoutParams2);
        return textView;
    }
}
