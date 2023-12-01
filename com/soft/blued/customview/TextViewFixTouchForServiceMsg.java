package com.soft.blued.customview;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.widget.emoji.view.EmojiTextView;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/TextViewFixTouchForServiceMsg.class */
public class TextViewFixTouchForServiceMsg extends EmojiTextView {

    /* renamed from: a  reason: collision with root package name */
    private int f28528a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private CharSequence f28529c;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/TextViewFixTouchForServiceMsg$ButtonSpan.class */
    public class ButtonSpan extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        View.OnClickListener f28530a;
        private Context b;

        /* renamed from: c  reason: collision with root package name */
        private int f28531c;

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            View.OnClickListener onClickListener = this.f28530a;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(BluedSkinUtils.a(this.b, this.f28531c));
            textPaint.setUnderlineText(false);
        }
    }

    public TextViewFixTouchForServiceMsg(Context context) {
        super(context);
        this.f28528a = -1;
        this.b = -1;
    }

    public TextViewFixTouchForServiceMsg(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f28528a = -1;
        this.b = -1;
    }

    private Layout a(CharSequence charSequence) {
        return Build.VERSION.SDK_INT >= 23 ? StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), getPaint(), (getMaxWidth() - getPaddingLeft()) - getPaddingRight()).setLineSpacing(getLineSpacingExtra(), getLineSpacingMultiplier()).setAlignment(Layout.Alignment.ALIGN_NORMAL).setBreakStrategy(1).setHyphenationFrequency(2).build() : new StaticLayout(charSequence, 0, charSequence.length(), getPaint(), (getMaxWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 1.0f, true);
    }

    @Override // skin.support.widget.SkinCompatTextView, skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        super.applySkin();
    }

    @Override // android.view.View
    public boolean hasFocusable() {
        return false;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        try {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int totalPaddingLeft = getTotalPaddingLeft();
            int totalPaddingTop = getTotalPaddingTop();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            Layout layout = getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((y - totalPaddingTop) + scrollY), (x - totalPaddingLeft) + scrollX);
            CharSequence text = getText();
            if (!TextUtils.isEmpty(text) && (text instanceof Spannable)) {
                Spannable spannable = (Spannable) text;
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                if (clickableSpanArr.length == 0) {
                    if (this.f28528a >= 0 && this.b >= this.f28528a) {
                        if (spannable.length() >= this.b) {
                            spannable.setSpan(new BackgroundColorSpan(0), this.f28528a, this.b, 33);
                        }
                        this.f28528a = -1;
                        this.b = -1;
                    }
                    Selection.removeSelection(spannable);
                    return false;
                } else if (action == 0) {
                    this.f28528a = spannable.getSpanStart(clickableSpanArr[0]);
                    int spanEnd = spannable.getSpanEnd(clickableSpanArr[0]);
                    this.b = spanEnd;
                    if (this.f28528a < 0 || spanEnd < this.f28528a || spanEnd > spannable.length()) {
                        return true;
                    }
                    spannable.setSpan(new BackgroundColorSpan(Color.parseColor("#0A000000")), this.f28528a, this.b, 33);
                    return true;
                } else if ((action == 1 || action == 3) && this.f28528a >= 0 && this.b >= this.f28528a && this.b <= spannable.length()) {
                    spannable.setSpan(new BackgroundColorSpan(0), this.f28528a, this.b, 33);
                    this.f28528a = -1;
                    this.b = -1;
                    return true;
                } else {
                    return true;
                }
            }
            return onTouchEvent;
        } catch (Exception e) {
            return onTouchEvent;
        }
    }

    public void setExpandText(CharSequence charSequence) {
        int length;
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.f28529c = charSequence;
        setText(charSequence);
        measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        int maxLines = getMaxLines();
        CharSequence charSequence2 = this.f28529c;
        SpannableStringBuilder spannableStringBuilder = charSequence2;
        if (maxLines != -1) {
            Layout a2 = a(charSequence2);
            spannableStringBuilder = charSequence2;
            if (a2.getLineCount() > maxLines) {
                CharSequence subSequence = this.f28529c.subSequence(0, a2.getLineEnd(maxLines - 1));
                Layout a3 = a(new SpannableStringBuilder().append(subSequence).append((CharSequence) "..."));
                while (a3.getLineCount() > maxLines && (length = subSequence.length() - 1) > 0 && !TextUtils.isEmpty(subSequence)) {
                    subSequence = subSequence.subSequence(0, length);
                    a3 = a(new SpannableStringBuilder().append(subSequence).append((CharSequence) "..."));
                }
                spannableStringBuilder = new SpannableStringBuilder().append(subSequence).append((CharSequence) "...");
            }
        }
        setText(spannableStringBuilder);
    }
}
