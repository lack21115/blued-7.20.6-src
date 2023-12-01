package com.blued.android.module.common.utils;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import com.blued.android.module.common.R;
import com.blued.android.module.common.observer.CommonTitleDoubleClickObserver;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/ClickUtils.class */
public class ClickUtils implements View.OnTouchListener {
    private int a = 0;
    private int b = 0;
    private int c = 0;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/ClickUtils$RevoClickSpan.class */
    public static class RevoClickSpan extends ClickableSpan {
        int a;
        View.OnClickListener b;

        public RevoClickSpan(Context context, int i, View.OnClickListener onClickListener) {
            this.a = i == 0 ? context.getResources().getColor(R.color.nafio_a) : i;
            this.b = onClickListener;
        }

        public RevoClickSpan(Context context, View.OnClickListener onClickListener) {
            this.a = context.getResources().getColor(R.color.nafio_a);
            this.b = onClickListener;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            View.OnClickListener onClickListener = this.b;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(this.a);
            textPaint.setUnderlineText(false);
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/ClickUtils$RevoWhiteClickSpan.class */
    public static class RevoWhiteClickSpan extends RevoClickSpan {
        int c;

        public RevoWhiteClickSpan(Context context, int i, View.OnClickListener onClickListener) {
            super(context, onClickListener);
            this.c = i == 0 ? context.getResources().getColor(R.color.nafio_b) : i;
        }

        @Override // com.blued.android.module.common.utils.ClickUtils.RevoClickSpan, android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(this.c);
            textPaint.setUnderlineText(true);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                return true;
            }
            view.performClick();
            return true;
        }
        int i = this.a + 1;
        this.a = i;
        if (i == 1) {
            this.b = (int) System.currentTimeMillis();
            return true;
        } else if (i == 2) {
            int currentTimeMillis = (int) System.currentTimeMillis();
            this.c = currentTimeMillis;
            if (currentTimeMillis - this.b < 1000) {
                CommonTitleDoubleClickObserver.a().b();
            }
            this.a = 0;
            this.b = 0;
            this.c = 0;
            return true;
        } else {
            return true;
        }
    }
}
