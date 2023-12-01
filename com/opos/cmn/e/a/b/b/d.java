package com.opos.cmn.e.a.b.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.cmn.i.g;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/e/a/b/b/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private RelativeLayout f24764a;
    private RelativeLayout b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f24765c;
    private ImageView d;
    private LinearLayout e;
    private Dialog f;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/e/a/b/b/d$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Context f24768a;
        private CharSequence b;

        /* renamed from: c  reason: collision with root package name */
        private CharSequence f24769c;
        private b d;
        private CharSequence e;
        private b f;

        public a(Context context) {
            this.f24768a = context;
        }

        public a a(CharSequence charSequence) {
            this.b = charSequence;
            return this;
        }

        public a a(CharSequence charSequence, b bVar) {
            this.f24769c = charSequence;
            this.d = bVar;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(CharSequence charSequence, b bVar) {
            this.e = charSequence;
            this.f = bVar;
            return this;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/e/a/b/b/d$b.class */
    public interface b {
        void a(d dVar, View view, int[] iArr);
    }

    private d(a aVar) {
        b(aVar);
        a(aVar);
    }

    private void b(a aVar) {
        RelativeLayout relativeLayout = new RelativeLayout(aVar.f24768a);
        this.f24764a = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        c(aVar);
        this.b = new RelativeLayout(aVar.f24768a);
        d(aVar);
        if (Build.VERSION.SDK_INT >= 29) {
            this.b.setForceDarkAllowed(false);
        }
        TextView textView = new TextView(aVar.f24768a);
        this.f24765c = textView;
        textView.setId(1);
        this.f24765c.setGravity(17);
        this.f24765c.setMaxLines(2);
        this.f24765c.setEllipsize(TextUtils.TruncateAt.END);
        this.f24765c.setTextColor(Color.parseColor("#2f2f2f"));
        this.f24765c.setTextSize(1, 16.0f);
        this.f24765c.setText(aVar.b);
        e(aVar);
        ImageView imageView = new ImageView(aVar.f24768a);
        this.d = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.d.setImageDrawable(new ColorDrawable(Color.parseColor("#cdd2d4")));
        f(aVar);
        g(aVar);
    }

    private void c(a aVar) {
        ImageView imageView = new ImageView(aVar.f24768a);
        imageView.setImageDrawable(new ColorDrawable(-16777216));
        imageView.setAlpha(0.6f);
        this.f24764a.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void d(a aVar) {
        com.opos.cmn.e.a.a.c cVar = new com.opos.cmn.e.a.a.c(aVar.f24768a, 14.0f);
        cVar.setImageDrawable(new ColorDrawable(-1));
        this.b.addView(cVar, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void e(a aVar) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(aVar.f24768a, 260.0f), com.opos.cmn.an.h.f.a.a(aVar.f24768a, 91.0f));
        layoutParams.addRule(10);
        this.b.addView(this.f24765c, layoutParams);
    }

    private void f(a aVar) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(aVar.f24768a, 260.0f), com.opos.cmn.an.h.f.a.a(aVar.f24768a, 1.0f));
        layoutParams.addRule(3, 1);
        this.b.addView(this.d, layoutParams);
    }

    private void g(a aVar) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(aVar.f24768a, 260.0f), com.opos.cmn.an.h.f.a.a(aVar.f24768a, 130.0f));
        layoutParams.addRule(13);
        this.f24764a.addView(this.b, layoutParams);
    }

    private void h(a aVar) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(aVar.f24768a, 260.0f), com.opos.cmn.an.h.f.a.a(aVar.f24768a, 38.0f));
        layoutParams.addRule(12);
        this.b.addView(this.e, layoutParams);
    }

    public void a(Activity activity) {
        if (this.f == null) {
            int i = 16973840;
            if (com.opos.cmn.an.h.f.a.a(activity)) {
                i = 16973841;
            }
            Dialog dialog = new Dialog(activity, i);
            this.f = dialog;
            dialog.setCancelable(false);
            this.f.setCanceledOnTouchOutside(false);
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = this.f.getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                this.f.getWindow().setAttributes(attributes);
            }
            g.a(activity.getApplicationContext(), this.f.getWindow());
            this.f.setContentView(this.f24764a);
        }
        if (this.f.isShowing()) {
            return;
        }
        this.f.show();
    }

    protected void a(a aVar) {
        LinearLayout linearLayout = new LinearLayout(aVar.f24768a);
        this.e = linearLayout;
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(1, -1);
        layoutParams.weight = 1.0f;
        TextView textView = new TextView(aVar.f24768a);
        textView.setGravity(17);
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextColor(Color.parseColor("#767575"));
        textView.setTextSize(1, 13.0f);
        textView.setText(aVar.f24769c);
        final b bVar = aVar.d;
        com.opos.cmn.e.a.a aVar2 = new com.opos.cmn.e.a.a() { // from class: com.opos.cmn.e.a.b.b.d.1
            @Override // com.opos.cmn.e.a.a
            public void a(View view, int[] iArr) {
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a(d.this, view, iArr);
                }
            }
        };
        textView.setOnTouchListener(aVar2);
        textView.setOnClickListener(aVar2);
        this.e.addView(textView, layoutParams);
        TextView textView2 = new TextView(aVar.f24768a);
        textView2.setBackgroundColor(Color.parseColor("#cdd2d4"));
        this.e.addView(textView2, new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(aVar.f24768a, 1.0f), -1));
        TextView textView3 = new TextView(aVar.f24768a);
        textView3.setGravity(17);
        textView3.setSingleLine();
        textView3.setEllipsize(TextUtils.TruncateAt.END);
        textView3.setTextColor(Color.parseColor("#d95955"));
        textView3.setTextSize(1, 13.0f);
        textView3.setText(aVar.e);
        final b bVar2 = aVar.f;
        com.opos.cmn.e.a.a aVar3 = new com.opos.cmn.e.a.a() { // from class: com.opos.cmn.e.a.b.b.d.2
            @Override // com.opos.cmn.e.a.a
            public void a(View view, int[] iArr) {
                b bVar3 = bVar2;
                if (bVar3 != null) {
                    bVar3.a(d.this, view, iArr);
                }
            }
        };
        textView3.setOnTouchListener(aVar3);
        textView3.setOnClickListener(aVar3);
        this.e.addView(textView3, layoutParams);
        if (bVar2 == null) {
            textView3.setVisibility(8);
            textView2.setVisibility(8);
        }
        if (bVar == null) {
            textView.setVisibility(8);
            textView2.setVisibility(8);
        }
        h(aVar);
    }

    public void a(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.f24765c.setText(charSequence);
    }

    public boolean a() {
        Dialog dialog = this.f;
        return dialog != null && dialog.isShowing();
    }

    public void b() {
        Dialog dialog = this.f;
        if (dialog != null) {
            dialog.cancel();
        }
    }
}
