package com.opos.cmn.biz.web.b.b.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.TextView;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/web/b/b/b/a.class */
public class a extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private Context f24725a;
    private Drawable b;

    /* renamed from: c  reason: collision with root package name */
    private Drawable f24726c;

    public a(Context context, String str, String str2) {
        super(context);
        this.f24725a = context;
        if (com.opos.cmn.an.c.a.a(str) || com.opos.cmn.an.c.a.a(str2)) {
            return;
        }
        this.b = com.opos.cmn.an.d.a.a.c(this.f24725a.getApplicationContext(), str);
        this.f24726c = com.opos.cmn.an.d.a.a.c(this.f24725a.getApplicationContext(), str2);
        com.opos.cmn.biz.web.b.b.a.a.a(this, a());
    }

    private Drawable a() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, this.f24726c);
        stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, this.f24726c);
        stateListDrawable.addState(View.ENABLED_STATE_SET, this.b);
        stateListDrawable.addState(View.FOCUSED_STATE_SET, this.f24726c);
        stateListDrawable.addState(View.EMPTY_STATE_SET, this.b);
        return stateListDrawable;
    }
}
