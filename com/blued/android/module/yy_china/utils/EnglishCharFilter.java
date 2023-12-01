package com.blued.android.module.yy_china.utils;

import android.text.InputFilter;
import android.text.Spanned;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/utils/EnglishCharFilter.class */
public class EnglishCharFilter implements InputFilter {
    int a;
    private OnEnglishCharFilterToMaxLenListener b;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/utils/EnglishCharFilter$OnEnglishCharFilterToMaxLenListener.class */
    public interface OnEnglishCharFilterToMaxLenListener {
        void onMaxLen();
    }

    public EnglishCharFilter(int i) {
        this.a = 0;
        this.a = i;
    }

    public void a(OnEnglishCharFilterToMaxLenListener onEnglishCharFilterToMaxLenListener) {
        this.b = onEnglishCharFilterToMaxLenListener;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            i5 = i12;
            if (i11 > this.a || i5 >= spanned.length()) {
                break;
            }
            if ((spanned.charAt(i5) & 65535) <= 255) {
                i9 = i11;
                i10 = 1;
            } else {
                i9 = i11;
                i10 = 2;
            }
            i11 = i9 + i10;
            i12 = i5 + 1;
        }
        if (i11 > this.a) {
            OnEnglishCharFilterToMaxLenListener onEnglishCharFilterToMaxLenListener = this.b;
            if (onEnglishCharFilterToMaxLenListener != null) {
                onEnglishCharFilterToMaxLenListener.onMaxLen();
            }
            return spanned.subSequence(0, i5 - 1);
        }
        int i13 = 0;
        while (true) {
            i6 = i13;
            if (i11 > this.a || i6 >= charSequence.length()) {
                break;
            }
            if ((charSequence.charAt(i6) & 65535) <= 255) {
                i7 = i11;
                i8 = 1;
            } else {
                i7 = i11;
                i8 = 2;
            }
            i11 = i7 + i8;
            i13 = i6 + 1;
        }
        if (i11 > this.a) {
            OnEnglishCharFilterToMaxLenListener onEnglishCharFilterToMaxLenListener2 = this.b;
            if (onEnglishCharFilterToMaxLenListener2 != null) {
                onEnglishCharFilterToMaxLenListener2.onMaxLen();
            }
            return charSequence.subSequence(0, i6 - 1);
        }
        return null;
    }
}
