package com.opos.mobad.o.d;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.opos.cmn.e.a.b.d.a;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/d/e.class */
public class e {

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/d/e$a.class */
    public static final class a extends RelativeLayout {

        /* renamed from: a  reason: collision with root package name */
        private LinearLayout f13415a;
        private TextView b;

        /* renamed from: c  reason: collision with root package name */
        private Context f13416c;
        private b d;
        private d e;

        public a(Context context) {
            super(context);
            this.f13416c = com.opos.mobad.service.b.a(context.getApplicationContext());
            b();
        }

        private void a(int i, b bVar) {
            d dVar = this.e;
            if (dVar != null) {
                if (i == dVar.a()) {
                    com.opos.cmn.an.f.a.b("CustomPrivacyTextView", "Same type use last view");
                    return;
                }
                com.opos.cmn.an.f.a.b("CustomPrivacyTextView", "differ type use new one");
                removeView(this.e.b());
                this.e.c();
            }
            d a2 = c.a(getContext(), i, bVar);
            this.e = a2;
            View b = a2.b();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, this.f13415a.getId());
            addView(b, layoutParams);
        }

        private void b() {
            setBackgroundColor(-1);
            LinearLayout linearLayout = new LinearLayout(this.f13416c);
            this.f13415a = linearLayout;
            linearLayout.setId(View.generateViewId());
            this.f13415a.setOrientation(0);
            TextView textView = new TextView(this.f13416c);
            this.b = new TextView(this.f13416c);
            textView.setBackground(com.opos.cmn.an.d.a.a.c(this.f13416c, "opos_module_biz_ui_cmn_privacy_web_close_bn.png"));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.o.d.e.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (a.this.d != null) {
                        a.this.d.a();
                    }
                }
            });
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f13416c, 16.58f), com.opos.cmn.an.h.f.a.a(this.f13416c, 12.73f));
            layoutParams.gravity = 16;
            layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f13416c, 23.71f);
            layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f13416c, 18.71f);
            this.f13415a.addView(textView, layoutParams);
            this.b.setGravity(8388627);
            this.b.setTextSize(1, 16.0f);
            this.b.setTextColor(-16777216);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            this.f13415a.addView(this.b, layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f13416c, 50.0f));
            layoutParams3.addRule(10);
            addView(this.f13415a, layoutParams3);
        }

        public void a() {
            removeAllViews();
            d dVar = this.e;
            if (dVar != null) {
                dVar.c();
            }
        }

        public void a(b bVar) {
            this.d = bVar;
        }

        public void a(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.opos.cmn.an.f.a.b("CustomPrivacyTextView", "show url = " + str);
            a(0, this.d);
            this.e.a(str);
            this.b.setText(str2);
        }

        public void a(Map<String, String> map, String str) {
            if (map == null) {
                return;
            }
            com.opos.cmn.an.f.a.b("CustomPrivacyTextView", "show Map");
            a(1, this.d);
            this.e.a(map);
            this.b.setText(str);
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/d/e$b.class */
    public interface b {
        void a();
    }

    public static Dialog a(Activity activity, String str, String str2, b bVar) {
        return a(activity, str, str2, (Map<String, String>) null, bVar);
    }

    public static Dialog a(Activity activity, String str, String str2, Map<String, String> map, final b bVar) {
        final com.opos.cmn.e.a.b.f.a aVar = new com.opos.cmn.e.a.b.f.a(activity, R.style.Theme_NoTitleBar, new a.C0464a().a(R.style.Theme_NoTitleBar).a(false).b(false).a());
        final a aVar2 = new a(activity);
        aVar2.a(new b() { // from class: com.opos.mobad.o.d.e.1
            @Override // com.opos.mobad.o.d.e.b
            public void a() {
                b bVar2 = b.this;
                if (bVar2 != null) {
                    bVar2.a();
                }
                aVar2.a();
                aVar.dismiss();
            }
        });
        if (TextUtils.isEmpty(str2)) {
            aVar2.a(map, str);
        } else {
            aVar2.a(str2, str);
        }
        aVar.setContentView(aVar2);
        aVar.getWindow().setBackgroundDrawable(new ColorDrawable(-1));
        aVar.getWindow().setLayout(-1, -1);
        aVar.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.opos.mobad.o.d.e.2
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i == 4 && keyEvent.getAction() == 0) {
                    b bVar2 = b.this;
                    if (bVar2 != null) {
                        bVar2.a();
                    }
                    dialogInterface.dismiss();
                    return true;
                }
                return false;
            }
        });
        aVar.show();
        return aVar;
    }

    public static a a(Context context, String str, String str2, Map<String, String> map, final b bVar) {
        final a aVar = new a(context);
        aVar.a(new b() { // from class: com.opos.mobad.o.d.e.3
            @Override // com.opos.mobad.o.d.e.b
            public void a() {
                b bVar2 = b.this;
                if (bVar2 != null) {
                    bVar2.a();
                }
                aVar.a();
            }
        });
        if (TextUtils.isEmpty(str2)) {
            aVar.a(map, str);
        } else {
            aVar.a(str2, str);
        }
        aVar.setBackgroundColor(-1);
        return aVar;
    }
}
