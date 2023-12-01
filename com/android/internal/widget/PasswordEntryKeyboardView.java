package com.android.internal.widget;

import android.content.Context;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/PasswordEntryKeyboardView.class */
public class PasswordEntryKeyboardView extends KeyboardView {
    static final int KEYCODE_F1 = -103;
    static final int KEYCODE_NEXT_LANGUAGE = -104;
    static final int KEYCODE_OPTIONS = -100;
    static final int KEYCODE_SHIFT_LONGPRESS = -101;
    static final int KEYCODE_VOICE = -102;

    public PasswordEntryKeyboardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PasswordEntryKeyboardView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public PasswordEntryKeyboardView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // android.inputmethodservice.KeyboardView
    public boolean setShifted(boolean z) {
        boolean shifted = super.setShifted(z);
        int[] shiftKeyIndices = getKeyboard().getShiftKeyIndices();
        int length = shiftKeyIndices.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return shifted;
            }
            invalidateKey(shiftKeyIndices[i2]);
            i = i2 + 1;
        }
    }
}
