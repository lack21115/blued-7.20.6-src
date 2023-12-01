package com.blued.community.view;

import android.content.Context;
import android.graphics.Canvas;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/view/EllipSizeText.class */
public class EllipSizeText extends AppCompatTextView {
    private boolean isEllipSized;

    public EllipSizeText(Context context) {
        super(context);
        this.isEllipSized = false;
    }

    public EllipSizeText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isEllipSized = false;
    }

    public boolean isAppendEllipSize() {
        return this.isEllipSized;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            CharSequence text = getText();
            int lineCount = getLayout().getLineCount();
            int maxLines = getMaxLines();
            if (maxLines <= lineCount) {
                lineCount = maxLines;
            }
            int i = lineCount;
            if (lineCount <= 0) {
                i = 1;
            }
            int lineVisibleEnd = getLayout().getLineVisibleEnd(i - 1);
            if (text != null && text.length() > lineVisibleEnd) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append(text.subSequence(0, lineVisibleEnd - 4)).append((CharSequence) "...");
                setText(spannableStringBuilder);
                this.isEllipSized = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onDraw(canvas);
    }
}
