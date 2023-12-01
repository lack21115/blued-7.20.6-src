package com.jungly.gridpasswordview;

import android.text.method.PasswordTransformationMethod;
import android.view.View;

/* loaded from: source-7994992-dex2jar.jar:com/jungly/gridpasswordview/CustomPasswordTransformationMethod.class */
public class CustomPasswordTransformationMethod extends PasswordTransformationMethod {

    /* renamed from: a  reason: collision with root package name */
    String f10069a;

    /* loaded from: source-7994992-dex2jar.jar:com/jungly/gridpasswordview/CustomPasswordTransformationMethod$PasswordCharSequence.class */
    class PasswordCharSequence implements CharSequence {
        private CharSequence b;

        public PasswordCharSequence(CharSequence charSequence) {
            this.b = charSequence;
        }

        @Override // java.lang.CharSequence
        public char charAt(int i) {
            return CustomPasswordTransformationMethod.this.f10069a.charAt(0);
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
        this.f10069a = str;
    }

    @Override // android.text.method.PasswordTransformationMethod, android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        return new PasswordCharSequence(charSequence);
    }
}
