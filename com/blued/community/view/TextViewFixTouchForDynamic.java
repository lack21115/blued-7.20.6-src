package com.blued.community.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.widget.emoji.view.EmojiTextView;
import com.blued.community.R;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/view/TextViewFixTouchForDynamic.class */
public class TextViewFixTouchForDynamic extends EmojiTextView {
    private SpannableString ELLIPSIS;
    private boolean ifShowedMore;
    private int mEnd;
    private String mMoreText;
    private int mStart;
    private CharSequence originText;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/view/TextViewFixTouchForDynamic$ButtonSpan.class */
    public class ButtonSpan extends ClickableSpan {
        private int colorId;
        private Context context;
        View.OnClickListener onClickListener;

        public ButtonSpan(TextViewFixTouchForDynamic textViewFixTouchForDynamic, Context context, View.OnClickListener onClickListener) {
            this(context, onClickListener, -65536);
        }

        public ButtonSpan(Context context, View.OnClickListener onClickListener, int i) {
            this.onClickListener = onClickListener;
            this.context = context;
            this.colorId = i;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            View.OnClickListener onClickListener = this.onClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(BluedSkinUtils.a(this.context, this.colorId));
            textPaint.setUnderlineText(false);
        }
    }

    public TextViewFixTouchForDynamic(Context context) {
        super(context);
        this.mStart = -1;
        this.mEnd = -1;
        this.ELLIPSIS = null;
        this.mMoreText = "";
        init();
    }

    public TextViewFixTouchForDynamic(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStart = -1;
        this.mEnd = -1;
        this.ELLIPSIS = null;
        this.mMoreText = "";
        init();
    }

    private Layout createWorkingLayout(CharSequence charSequence) {
        try {
            return Build.VERSION.SDK_INT >= 23 ? StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), getPaint(), (getMaxWidth() - getPaddingLeft()) - getPaddingRight()).setLineSpacing(getLineSpacingExtra(), getLineSpacingMultiplier()).setAlignment(Layout.Alignment.ALIGN_NORMAL).setBreakStrategy(1).setHyphenationFrequency(2).build() : new StaticLayout(charSequence, 0, charSequence.length(), getPaint(), (getMaxWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 1.0f, true);
        } catch (Exception e) {
            return null;
        }
    }

    public void applySkin() {
        super.applySkin();
    }

    public boolean getIfShowedMore() {
        return this.ifShowedMore;
    }

    public boolean hasFocusable() {
        return false;
    }

    public void init() {
        setMoreText(getContext().getResources().getString(R.string.full_text));
        setMoeTextColor(BluedSkinUtils.a(getContext(), R.color.syc_a));
    }

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
                    if (this.mStart >= 0 && this.mEnd >= this.mStart) {
                        if (spannable.length() >= this.mEnd) {
                            spannable.setSpan(new BackgroundColorSpan(0), this.mStart, this.mEnd, 33);
                        }
                        this.mStart = -1;
                        this.mEnd = -1;
                    }
                    Selection.removeSelection(spannable);
                    return false;
                } else if (action == 0) {
                    this.mStart = spannable.getSpanStart(clickableSpanArr[0]);
                    int spanEnd = spannable.getSpanEnd(clickableSpanArr[0]);
                    this.mEnd = spanEnd;
                    if (this.mStart < 0 || spanEnd < this.mStart || spanEnd > spannable.length()) {
                        return true;
                    }
                    spannable.setSpan(new BackgroundColorSpan(Color.parseColor("#0A000000")), this.mStart, this.mEnd, 33);
                    return true;
                } else if ((action == 1 || action == 3) && this.mStart >= 0 && this.mEnd >= this.mStart && this.mEnd <= spannable.length()) {
                    spannable.setSpan(new BackgroundColorSpan(0), this.mStart, this.mEnd, 33);
                    this.mStart = -1;
                    this.mEnd = -1;
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

    /* JADX WARN: Removed duplicated region for block: B:37:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0146  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setExpandText(java.lang.CharSequence r7) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.community.view.TextViewFixTouchForDynamic.setExpandText(java.lang.CharSequence):void");
    }

    public void setMoeTextColor(int i) {
        setMoeTextColor(i, true);
    }

    public void setMoeTextColor(int i, boolean z) {
        this.ELLIPSIS = new SpannableString(this.mMoreText);
        this.ELLIPSIS.setSpan(new ForegroundColorSpan(i), 0, this.mMoreText.length(), 17);
        if (z) {
            this.ELLIPSIS.setSpan(new StyleSpan(1), 0, this.mMoreText.length(), 17);
        }
    }

    public void setMoreText(String str) {
        this.mMoreText = str;
    }
}
