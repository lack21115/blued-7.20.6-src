package com.soft.blued.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import com.blued.android.core.AppInfo;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/ResizeLayout.class */
public class ResizeLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    int f14798a;
    int b;

    /* renamed from: c  reason: collision with root package name */
    int f14799c;
    LinearLayout d;
    LinearLayout e;
    private GridView f;

    public ResizeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14798a = 0;
        this.b = 0;
        this.f14799c = 0;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, final int i2, int i3, final int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        AppInfo.n().post(new Runnable() { // from class: com.soft.blued.customview.ResizeLayout.1
            @Override // java.lang.Runnable
            public void run() {
                ResizeLayout resizeLayout = ResizeLayout.this;
                resizeLayout.e = (LinearLayout) resizeLayout.findViewById(R.id.bottom_edit_view);
                ResizeLayout resizeLayout2 = ResizeLayout.this;
                resizeLayout2.d = (LinearLayout) resizeLayout2.findViewById(R.id.bottom_view);
                EditText editText = (EditText) ResizeLayout.this.findViewById(R.id.edit_view);
                if (i4 - i2 <= 50) {
                    if (ResizeLayout.this.f.getVisibility() != 0) {
                        ResizeLayout.this.e.setVisibility(8);
                        ResizeLayout.this.d.setVisibility(0);
                        return;
                    }
                    return;
                }
                ResizeLayout.this.e.setVisibility(0);
                ResizeLayout.this.d.setVisibility(8);
                editText.requestFocus();
                if (ResizeLayout.this.f.getVisibility() == 0) {
                    ResizeLayout.this.f.setVisibility(8);
                }
            }
        });
    }
}
