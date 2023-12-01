package com.opos.mobad.l;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/l/n.class */
public class n implements com.opos.mobad.ad.e.d {

    /* renamed from: a  reason: collision with root package name */
    private Context f26320a;
    private ViewGroup b;

    /* renamed from: c  reason: collision with root package name */
    private String f26321c;
    private String d;

    public n(Context context, String str, String str2) {
        this.f26320a = context.getApplicationContext();
        this.f26321c = str;
        this.d = str2;
        b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a4, code lost:
        if ((-1) == r0) goto L82;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r5, java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 531
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.l.n.a(android.content.Context, java.lang.String):java.lang.String");
    }

    private void a(RelativeLayout relativeLayout) {
        ImageView imageView = new ImageView(this.f26320a);
        imageView.setId(2);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        Context context = this.f26320a;
        Drawable f = com.opos.cmn.an.h.d.a.f(context, context.getPackageName());
        if (f != null) {
            imageView.setImageDrawable(f);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f26320a, 40.0f), com.opos.cmn.an.h.f.a.a(this.f26320a, 40.0f));
        layoutParams.addRule(15);
        relativeLayout.addView(imageView, layoutParams);
    }

    private void a(RelativeLayout relativeLayout, String str) {
        TextView textView = new TextView(this.f26320a);
        textView.setText(str);
        textView.setId(3);
        textView.setGravity(17);
        textView.setTextColor(Color.parseColor("#010036"));
        textView.setTextSize(1, 22.0f);
        textView.setMaxEms(7);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        relativeLayout.addView(textView, layoutParams);
    }

    private void a(RelativeLayout relativeLayout, String str, String str2) {
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f26320a);
        a(relativeLayout2, str);
        b(relativeLayout2, str2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, 2);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f26320a, 10.0f);
        relativeLayout.addView(relativeLayout2, layoutParams);
    }

    private void b() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f26320a);
        this.b = relativeLayout;
        relativeLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f26320a);
        a(relativeLayout2);
        a(relativeLayout2, this.f26321c, this.d);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.f26320a, 55.0f));
        layoutParams.addRule(13);
        this.b.addView(relativeLayout2, layoutParams);
    }

    private void b(RelativeLayout relativeLayout, String str) {
        TextView textView = new TextView(this.f26320a);
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextColor(Color.parseColor("#aaaaaa"));
        textView.setTextSize(1, 13.0f);
        textView.setMaxEms(11);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, 3);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        relativeLayout.addView(textView, layoutParams);
    }

    @Override // com.opos.mobad.ad.e.d
    public View a() {
        return this.b;
    }
}
