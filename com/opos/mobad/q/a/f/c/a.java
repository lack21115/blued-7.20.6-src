package com.opos.mobad.q.a.f.c;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.opos.mobad.cmn.a.b.g;
import com.opos.mobad.model.data.AdItemData;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/f/c/a.class */
public abstract class a extends com.opos.mobad.cmn.a.c {
    protected com.opos.mobad.q.a.c.a h;
    protected RelativeLayout i;
    private final String j;

    public a(Context context, com.opos.mobad.q.a.c.a aVar) {
        super(context);
        this.j = "BaseTipBarView";
        this.h = aVar;
        b();
        g();
    }

    private void b() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f25896a);
        this.i = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f25896a, 85.0f)));
        this.i.setVisibility(8);
    }

    public RelativeLayout a() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, final AdItemData adItemData, final com.opos.mobad.cmn.a.b.a aVar) {
        if (view != null) {
            view.setOnTouchListener(new com.opos.cmn.e.a.a.b(this.d));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.q.a.f.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    if (g.a(adItemData, aVar)) {
                        a.this.h.a(view2, a.this.d, aVar);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, String str) {
        if (textView != null) {
            String str2 = str;
            if (com.opos.cmn.an.c.a.a(str)) {
                str2 = "";
            }
            textView.setText(str2);
        }
    }

    @Override // com.opos.mobad.cmn.a.c
    public void j() {
        this.i.removeAllViews();
    }
}
