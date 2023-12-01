package com.opos.mobad.o.a.b;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/a/b/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private Context f13351a;
    private c b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f13352c;

    public e(Context context, c cVar) {
        this.f13351a = context;
        this.b = cVar;
        c();
    }

    private void a(View view, final int i) {
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.o.a.b.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    if (e.this.b != null) {
                        e.this.b.a(i);
                    }
                }
            });
        }
    }

    private void c() {
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1A000000"));
        colorDrawable.setBounds(0, 0, com.opos.cmn.an.h.f.a.c(this.f13351a, 288.0f), com.opos.cmn.an.h.f.a.c(this.f13351a, 1.0f));
        TextView textView = new TextView(this.f13351a);
        this.f13352c = textView;
        textView.setTextColor(com.opos.cmn.e.a.a.a.a(Color.parseColor("#8C000000"), Color.parseColor("#FF5A60")));
        this.f13352c.setText("内容展示异常（黑屏/卡顿）");
        this.f13352c.setTextSize(1, 13.0f);
        this.f13352c.setCompoundDrawables(null, colorDrawable, null, null);
        this.f13352c.setCompoundDrawablePadding(com.opos.cmn.an.h.f.a.a(this.f13351a, 14.0f));
        new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f13351a, 288.0f), -2).topMargin = com.opos.cmn.an.h.f.a.a(this.f13351a, 20.0f);
    }

    public View a() {
        return this.f13352c;
    }

    public void a(com.opos.mobad.o.a.a.a aVar) {
        com.opos.mobad.o.a.a.b bVar;
        if (aVar == null || (bVar = aVar.b.get(0)) == null) {
            return;
        }
        this.f13352c.setText(bVar.b());
        a(this.f13352c, bVar.a());
    }

    public void b() {
        if (this.b != null) {
            this.b = null;
        }
    }
}
