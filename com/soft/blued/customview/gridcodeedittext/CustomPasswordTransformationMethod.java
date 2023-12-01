package com.soft.blued.customview.gridcodeedittext;

import android.text.method.PasswordTransformationMethod;
import android.view.View;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/gridcodeedittext/CustomPasswordTransformationMethod.class */
public class CustomPasswordTransformationMethod extends PasswordTransformationMethod {

    /* renamed from: a  reason: collision with root package name */
    String f14901a;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/gridcodeedittext/CustomPasswordTransformationMethod$PasswordCharSequence.class */
    class PasswordCharSequence implements CharSequence {
        private CharSequence b;

        public PasswordCharSequence(CharSequence charSequence) {
            this.b = charSequence;
        }

        @Override // java.lang.CharSequence
        public char charAt(int i) {
            return CustomPasswordTransformationMethod.this.f14901a.charAt(0);
        }

        @Override // java.lang.CharSequence
        public int length() {
            return this.b.length();
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int i, int i2) {
            return this.b.subSequence(i, i2);
        }
    }

    public CustomPasswordTransformationMethod(String str) {
        this.f14901a = str;
    }

    @Override // android.text.method.PasswordTransformationMethod, android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        return new PasswordCharSequence(charSequence);
    }
}
