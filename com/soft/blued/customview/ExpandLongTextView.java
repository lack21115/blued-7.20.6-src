package com.soft.blued.customview;

import android.content.Context;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/ExpandLongTextView.class */
public class ExpandLongTextView extends AppCompatTextView {

    /* renamed from: a  reason: collision with root package name */
    private Context f28411a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private int f28412c;
    private boolean d;
    private SpannableString e;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/ExpandLongTextView$ButtonSpan.class */
    public class ButtonSpan extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        View.OnClickListener f28413a;

        /* renamed from: c  reason: collision with root package name */
        private Context f28414c;
        private int d;

        public ButtonSpan(Context context, View.OnClickListener onClickListener, int i) {
            this.f28413a = onClickListener;
            this.f28414c = context;
            this.d = i;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            View.OnClickListener onClickListener = this.f28413a;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(this.f28414c.getResources().getColor(this.d));
            textPaint.setUnderlineText(false);
        }
    }

    public ExpandLongTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f28412c = 6;
        this.d = false;
        this.e = null;
        a(context);
    }

    public ExpandLongTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f28412c = 6;
        this.d = false;
        this.e = null;
        a(context);
    }

    private Layout a(String str) {
        return Build.VERSION.SDK_INT >= 23 ? StaticLayout.Builder.obtain(str, 0, str.length(), getPaint(), (getMaxWidth() - getPaddingLeft()) - getPaddingRight()).setLineSpacing(getLineSpacingExtra(), getLineSpacingMultiplier()).setAlignment(Layout.Alignment.ALIGN_NORMAL).setBreakStrategy(1).setHyphenationFrequency(2).build() : new StaticLayout(str, 0, str.length(), getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 1.0f, true);
    }

    private void a(Context context) {
        this.f28411a = context;
        String string = context.getResources().getString(2131891413);
        this.e = new SpannableString(string);
        this.e.setSpan(new ButtonSpan(getContext(), null, 2131100442), 0, string.length(), 17);
    }

    public boolean getIfShowedMore() {
        return this.d;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0135  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setExpandText(java.lang.CharSequence r7) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.customview.ExpandLongTextView.setExpandText(java.lang.CharSequence):void");
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        this.f28412c = i;
        super.setMaxLines(i);
    }
}
