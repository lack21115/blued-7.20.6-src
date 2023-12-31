package com.anythink.expressad.advanced.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.anythink.expressad.advanced.d.c;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/advanced/view/ATOutNativeAdvancedViewGroup.class */
public class ATOutNativeAdvancedViewGroup extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private c f4214a;

    public ATOutNativeAdvancedViewGroup(Context context) {
        super(context);
    }

    public ATOutNativeAdvancedViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ATOutNativeAdvancedViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void a(final int i) {
        postDelayed(new Runnable() { // from class: com.anythink.expressad.advanced.view.ATOutNativeAdvancedViewGroup.1
            @Override // java.lang.Runnable
            public final void run() {
                if (ATOutNativeAdvancedViewGroup.this.f4214a != null) {
                    ATOutNativeAdvancedViewGroup.this.f4214a.d(i);
                }
            }
        }, 200L);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f4214a != null) {
            a(1);
            if (getVisibility() == 0) {
                a(2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.f4214a;
        if (cVar != null) {
            cVar.e(1);
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            a(2);
            if (getParent() != null) {
                a(1);
                return;
            }
            return;
        }
        c cVar = this.f4214a;
        if (cVar != null) {
            cVar.e(2);
        }
    }

    public void setProvider(c cVar) {
        this.f4214a = cVar;
    }
}
