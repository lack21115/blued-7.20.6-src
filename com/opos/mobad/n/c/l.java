package com.opos.mobad.n.c;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.widget.TextView;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/c/l.class */
public class l extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private float f26621a;
    private CharSequence b;

    public l(Context context) {
        super(context);
        this.f26621a = 0.2f;
        this.b = "";
    }

    private void a() {
        if (this.b == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < this.b.length()) {
            sb.append(("" + this.b.charAt(i)).toLowerCase());
            int i2 = i + 1;
            i = i2;
            if (i2 < this.b.length()) {
                sb.append(" ");
                i = i2;
            }
        }
        SpannableString spannableString = new SpannableString(sb.toString());
        if (sb.toString().length() > 1) {
            for (int i3 = 1; i3 < sb.toString().length(); i3 += 2) {
                spannableString.setSpan(new ScaleXSpan((this.f26621a + 1.0f) / 10.0f), i3, i3 + 1, 33);
            }
        }
        super.setText(spannableString, TextView.BufferType.SPANNABLE);
    }

    @Override // android.widget.TextView
    public float getLetterSpacing() {
        return this.f26621a;
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        return this.b;
    }

    @Override // android.widget.TextView
    public void setLetterSpacing(float f) {
        this.f26621a = f;
        a();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.b = charSequence;
        a();
    }
}
