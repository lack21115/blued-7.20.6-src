package com.blued.android.framework.view;

import android.content.Context;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.blued.android.framework.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/ExpandLongTextView.class */
public class ExpandLongTextView extends TextView {
    private Context a;
    private String b;
    private int c;
    private boolean d;
    private SpannableString e;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/ExpandLongTextView$ButtonSpan.class */
    public class ButtonSpan extends ClickableSpan {
        View.OnClickListener a;
        private Context c;
        private int d;

        public ButtonSpan(Context context, View.OnClickListener onClickListener, int i) {
            this.a = onClickListener;
            this.c = context;
            this.d = i;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            View.OnClickListener onClickListener = this.a;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(this.c.getResources().getColor(this.d));
            textPaint.setUnderlineText(false);
        }
    }

    public ExpandLongTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 6;
        this.d = false;
        this.e = null;
        a(context);
    }

    public ExpandLongTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = 6;
        this.d = false;
        this.e = null;
        a(context);
    }

    private Layout a(String str) {
        return Build.VERSION.SDK_INT >= 23 ? StaticLayout.Builder.obtain(str, 0, str.length(), getPaint(), (getMaxWidth() - getPaddingLeft()) - getPaddingRight()).setLineSpacing(getLineSpacingExtra(), getLineSpacingMultiplier()).setAlignment(Layout.Alignment.ALIGN_NORMAL).setBreakStrategy(1).setHyphenationFrequency(2).build() : new StaticLayout(str, 0, str.length(), getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 1.0f, true);
    }

    private void a(Context context) {
        this.a = context;
        String string = context.getResources().getString(R.string.read_more);
        this.e = new SpannableString(string);
        this.e.setSpan(new ButtonSpan(getContext(), null, R.color.expand_text_color), 0, string.length(), 17);
    }

    public boolean getIfShowedMore() {
        return this.d;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x013f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setExpandText(java.lang.CharSequence r7) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.framework.view.ExpandLongTextView.setExpandText(java.lang.CharSequence):void");
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        this.c = i;
        super.setMaxLines(i);
    }
}
