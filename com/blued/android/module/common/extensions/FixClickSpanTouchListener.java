package com.blued.android.module.common.extensions;

import android.text.Layout;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/extensions/FixClickSpanTouchListener.class */
public final class FixClickSpanTouchListener implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private long f10792a = -1;

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        Intrinsics.e(v, "v");
        Intrinsics.e(event, "event");
        int action = event.getAction();
        if (v instanceof TextView) {
            TextView textView = (TextView) v;
            CharSequence text = textView.getText();
            if (action == 0) {
                this.f10792a = System.currentTimeMillis();
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.f10792a;
            if (j != -1 && currentTimeMillis - j >= ViewConfiguration.getLongPressTimeout()) {
                this.f10792a = -1L;
                return v.performLongClick();
            } else if (action == 1) {
                if (!(text instanceof Spanned)) {
                    v.performClick();
                    return true;
                }
                int x = (int) event.getX();
                int y = (int) event.getY();
                int totalPaddingLeft = textView.getTotalPaddingLeft();
                int totalPaddingTop = textView.getTotalPaddingTop();
                int scrollX = textView.getScrollX();
                int scrollY = textView.getScrollY();
                Layout layout = textView.getLayout();
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((y - totalPaddingTop) + scrollY), (x - totalPaddingLeft) + scrollX);
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) ((Spanned) text).getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                if (clickableSpanArr != null) {
                    if (!(clickableSpanArr.length == 0)) {
                        clickableSpanArr[0].onClick(v);
                        return true;
                    }
                }
                v.performClick();
                return true;
            } else {
                return true;
            }
        }
        return false;
    }
}
