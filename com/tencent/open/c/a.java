package com.tencent.open.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/c/a.class */
public class a extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final String f24570a = a.class.getName();
    private Rect b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f24571c;
    private InterfaceC0804a d;

    /* renamed from: com.tencent.open.c.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/c/a$a.class */
    public interface InterfaceC0804a {
        void onKeyboardHidden();

        void onKeyboardShown(int i);
    }

    public a(Context context) {
        super(context);
        this.b = null;
        this.f24571c = false;
        this.d = null;
        if (0 == 0) {
            this.b = new Rect();
        }
    }

    public void a(InterfaceC0804a interfaceC0804a) {
        this.d = interfaceC0804a;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.b);
        int i3 = this.b.top;
        int height = activity.getWindowManager().getDefaultDisplay().getHeight();
        InterfaceC0804a interfaceC0804a = this.d;
        if (interfaceC0804a != null && size != 0) {
            if ((height - i3) - size > 100) {
                interfaceC0804a.onKeyboardShown((Math.abs(this.b.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                interfaceC0804a.onKeyboardHidden();
            }
        }
        super.onMeasure(i, i2);
    }
}
