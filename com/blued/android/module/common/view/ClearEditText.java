package com.blued.android.module.common.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import skin.support.widget.SkinCompatEditText;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/ClearEditText.class */
public class ClearEditText extends SkinCompatEditText {
    private final String a;
    private Drawable b;
    private Rect c;

    public ClearEditText(Context context) {
        super(context);
        this.a = ClearEditText.class.getSimpleName();
        c();
    }

    public ClearEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = ClearEditText.class.getSimpleName();
        c();
    }

    public ClearEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = ClearEditText.class.getSimpleName();
        c();
    }

    private void c() {
        a();
        addTextChangedListener(new TextWatcher() { // from class: com.blued.android.module.common.view.ClearEditText.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ClearEditText.this.a();
            }
        });
    }

    public void a() {
        if (getText().toString().length() == 0) {
            setCompoundDrawables(null, null, null, null);
        } else {
            setCompoundDrawables(null, null, this.b, null);
        }
    }

    public void b() {
        setCompoundDrawables(null, null, null, null);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b = null;
        this.c = null;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.b != null) {
                boolean z = true;
                if (motionEvent.getAction() == 1) {
                    if (motionEvent.getX() <= getWidth() - getTotalPaddingRight() || motionEvent.getX() >= getWidth() - getPaddingRight()) {
                        z = false;
                    }
                    if (z) {
                        setText("");
                        motionEvent.setAction(3);
                    }
                }
            }
        } catch (Exception e) {
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable3 != null) {
            this.b = drawable3;
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            a();
        } else {
            b();
        }
    }
}
