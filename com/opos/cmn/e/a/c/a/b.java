package com.opos.cmn.e.a.c.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.cmn.e.a.c.d.c;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/e/a/c/a/b.class */
public class b extends a {
    private ImageView f;
    private TextView g;
    private com.opos.cmn.e.a.a.a h;

    public b(Context context, c cVar) {
        super(context, cVar);
    }

    private void b(String str) {
        Drawable f = com.opos.cmn.an.h.d.a.f(this.f11090a, str);
        if (f != null) {
            this.f.setImageDrawable(f);
        }
    }

    private void c() {
        ImageView imageView = new ImageView(this.f11090a);
        this.f = imageView;
        imageView.setId(1);
        this.f.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f11090a, 43.0f), com.opos.cmn.an.h.f.a.a(this.f11090a, 43.0f));
        layoutParams.addRule(15);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f11090a, 12.0f);
        this.f11091c.addView(this.f, layoutParams);
    }

    private void c(String str) {
        String d = d(str);
        this.g.setText("您下载的【" + d + "】已经安装完成，是否立即打开？");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0092, code lost:
        if ((-1) == r0) goto L74;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String d(java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 511
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.e.a.c.a.b.d(java.lang.String):java.lang.String");
    }

    private void d() {
        TextView textView = new TextView(this.f11090a);
        this.g = textView;
        textView.setTextColor(Color.parseColor("#2f2f2f"));
        this.g.setTextSize(1, 12.0f);
        this.g.setMaxLines(2);
        this.g.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, 1);
        layoutParams.addRule(0, 2);
        layoutParams.addRule(15);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f11090a, 19.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f11090a, 19.0f);
        this.f11091c.addView(this.g, layoutParams);
    }

    private void e() {
        com.opos.cmn.e.a.a.a aVar = new com.opos.cmn.e.a.a.a(this.f11090a, "opos_module_biz_ui_cmn_reminder_toast_click_bn_normal_img.png", "opos_module_biz_ui_cmn_reminder_toast_click_bn_pressed_img.png");
        this.h = aVar;
        aVar.setText("立即打开");
        this.h.setId(2);
        this.h.setTextColor(-1);
        this.h.setTextSize(1, 10.0f);
        this.h.setGravity(17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f11090a, 66.0f), com.opos.cmn.an.h.f.a.a(this.f11090a, 22.0f));
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f11090a, 12.0f);
        this.f11091c.addView(this.h, layoutParams);
    }

    @Override // com.opos.cmn.e.a.c.a.a
    public void a(String str, boolean z, Object... objArr) {
        com.opos.cmn.e.a.a.a aVar;
        try {
            if (com.opos.cmn.an.c.a.a(str)) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("setCustomViewData pkgName=");
            sb.append(str);
            sb.append(",gbClick=");
            sb.append(z);
            sb.append(",objects=");
            if (objArr == null) {
                objArr = com.igexin.push.core.b.l;
            }
            sb.append(objArr);
            com.opos.cmn.an.f.a.b("ReminderToast", sb.toString());
            b(str);
            c(str);
            a(str);
            if (z) {
                a(this.f11091c, str);
                aVar = this.h;
            } else {
                a(this.f11091c);
                aVar = this.h;
            }
            a(aVar, str);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ReminderToast", "", (Throwable) e);
        }
    }

    @Override // com.opos.cmn.e.a.c.a.a
    public void b() {
        c();
        e();
        d();
    }
}
