package com.opos.cmn.e.a.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.TextView;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/e/a/a/a.class */
public class a extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private Context f11063a;
    private Drawable b;

    /* renamed from: c  reason: collision with root package name */
    private Drawable f11064c;

    public a(Context context, int i) {
        super(context);
        this.b = com.opos.cmn.e.a.d.a.a(context, i);
        this.f11064c = com.opos.cmn.e.a.d.a.a(context, i);
        com.opos.cmn.e.a.d.a.a(this, a());
    }

    public a(Context context, Drawable drawable, Drawable drawable2, int i, int i2) {
        super(context);
        this.b = drawable;
        this.f11064c = drawable2;
        com.opos.cmn.e.a.d.a.a(this, a());
        setTextColor(a(i, i2));
    }

    public a(Context context, String str, String str2) {
        super(context);
        this.f11063a = context;
        if (com.opos.cmn.an.c.a.a(str) || com.opos.cmn.an.c.a.a(str2)) {
            return;
        }
        this.b = com.opos.cmn.an.d.a.a.c(this.f11063a, str);
        this.f11064c = com.opos.cmn.an.d.a.a.c(this.f11063a, str2);
        com.opos.cmn.e.a.d.a.a(this, a());
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [int[], int[][]] */
    public static ColorStateList a(int i, int i2) {
        return new ColorStateList(new int[]{View.PRESSED_ENABLED_STATE_SET, View.ENABLED_FOCUSED_STATE_SET, View.ENABLED_STATE_SET, View.FOCUSED_STATE_SET, View.EMPTY_STATE_SET}, new int[]{i2, i2, i, i2, i});
    }

    private StateListDrawable a() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, this.f11064c);
        stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, this.f11064c);
        stateListDrawable.addState(View.ENABLED_STATE_SET, this.b);
        stateListDrawable.addState(View.FOCUSED_STATE_SET, this.f11064c);
        stateListDrawable.addState(View.EMPTY_STATE_SET, this.b);
        return stateListDrawable;
    }
}
