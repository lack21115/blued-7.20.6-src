package com.blued.android.module.common.utils;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/EditTextHeightAnimHelper.class */
public class EditTextHeightAnimHelper {
    public static void a(final EditText editText, final float f, final float f2) {
        if (editText == null || f < 1.0f || f2 <= f) {
            return;
        }
        editText.addTextChangedListener(new TextWatcher() { // from class: com.blued.android.module.common.utils.EditTextHeightAnimHelper.1
            float a;
            float b;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                float f3 = this.a;
                float f4 = this.b;
                if (f3 != f4) {
                    float lineHeight = EditText.this.getLineHeight();
                    EditTextHeightAnimHelper.b(EditText.this, (int) ((f4 * lineHeight) + EditText.this.getPaddingTop() + EditText.this.getPaddingBottom()));
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.a = EditText.this.getLineCount();
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.b = Math.min(Math.max(EditText.this.getLineCount(), f), f2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final EditText editText, int i) {
        int height = editText.getHeight();
        editText.clearAnimation();
        ValueAnimator ofInt = ObjectAnimator.ofInt(height, i);
        ofInt.setDuration(160L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.common.utils.EditTextHeightAnimHelper.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                EditText.this.getLayoutParams().height = Math.max(intValue, EditText.this.getMinHeight());
                EditText.this.requestLayout();
            }
        });
        ofInt.start();
    }
}
