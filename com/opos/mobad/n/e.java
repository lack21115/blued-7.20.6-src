package com.opos.mobad.n;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/e.class */
public class e {
    public static Bitmap a(String str) {
        if (com.opos.cmn.an.c.a.a(str)) {
            return null;
        }
        try {
            return BitmapFactory.decodeFile(str);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.a("TemplateUtils", "", th);
            return null;
        }
    }

    public static Bitmap a(String str, int i, int i2) {
        if (com.opos.cmn.an.c.a.a(str)) {
            return null;
        }
        try {
            Bitmap b = com.opos.cmn.an.d.c.a.b(str, i, i2);
            return com.opos.cmn.an.d.c.a.a(b, i, (b.getHeight() * i) / b.getWidth(), 1);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.a("TemplateUtils", "", th);
            return null;
        }
    }

    public static BitmapDrawable a(Context context, Bitmap bitmap) {
        if (bitmap != null) {
            return (Build.VERSION.SDK_INT < 15 || context == null) ? new BitmapDrawable(bitmap) : new BitmapDrawable(context.getResources(), bitmap);
        }
        return null;
    }

    public static Drawable a(Context context, String str) {
        Bitmap a2 = a(str);
        if (a2 != null) {
            return a(context, a2);
        }
        return null;
    }

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
            Drawable drawable = null;
            if (dVar != null) {
                drawable = null;
                if (dVar.j != null) {
                    drawable = null;
                    if (!com.opos.cmn.an.c.a.a(dVar.j.f26633a)) {
                        drawable = a(context, dVar.j.f26633a);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("getLogoDrawable=");
            sb.append(drawable != null ? drawable : com.igexin.push.core.b.l);
            com.opos.cmn.an.f.a.b("TemplateUtils", sb.toString());
            if (drawable != null) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(637534208);
                gradientDrawable.setCornerRadius(9.0f);
                a(textView, new LayerDrawable(new Drawable[]{gradientDrawable, drawable}));
                layoutParams2.width = com.opos.cmn.an.h.f.a.a(context, 26.0f);
                layoutParams2.height = com.opos.cmn.an.h.f.a.a(context, 12.0f);
            } else {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setColor(Color.parseColor("#3D151515"));
                gradientDrawable2.setCornerRadius(5.0f);
                a(textView, gradientDrawable2);
                if (!TextUtils.isEmpty(dVar.k)) {
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

    public static final TextView a(Context context) {
        TextView textView = new TextView(context);
        textView.setTextSize(0, com.opos.cmn.an.h.f.a.a(context, 9.0f));
        textView.setTextColor(-1);
        textView.setPadding(com.opos.cmn.an.h.f.a.a(context, 6.0f), com.opos.cmn.an.h.f.a.a(context, 3.0f), com.opos.cmn.an.h.f.a.a(context, 6.0f), com.opos.cmn.an.h.f.a.a(context, 3.0f));
        textView.setBackground(context.getResources().getDrawable(R.drawable.opos_mobad_drawable_txt_tips_bg));
        return textView;
    }

    public static void a(View view, Drawable drawable) {
        if (view == null || drawable == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static Bitmap b(String str, int i, int i2) {
        if (com.opos.cmn.an.c.a.a(str)) {
            return null;
        }
        try {
            return com.opos.cmn.an.d.c.a.a(str, i, i2);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.a("TemplateUtils", "", th);
            return null;
        }
    }
}
