package com.blued.android.module.common.utils;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/LinkMovementClickMethod.class */
public class LinkMovementClickMethod extends LinkMovementMethod {

    /* renamed from: c  reason: collision with root package name */
    private static LinkMovementClickMethod f10887c;

    /* renamed from: a  reason: collision with root package name */
    private long f10888a;
    private boolean b;

    public static LinkMovementClickMethod a() {
        if (f10887c == null) {
            f10887c = new LinkMovementClickMethod();
        }
        return f10887c;
    }

    public boolean b() {
        return this.b;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        try {
            int action = motionEvent.getAction();
            if (action == 1 || action == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                int totalPaddingLeft = textView.getTotalPaddingLeft();
                int totalPaddingTop = textView.getTotalPaddingTop();
                int scrollX = textView.getScrollX();
                int scrollY = textView.getScrollY();
                Layout layout = textView.getLayout();
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((y - totalPaddingTop) + scrollY), (x - totalPaddingLeft) + scrollX);
                Object[] objArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                if (objArr.length != 0) {
                    if (action == 1) {
                        if (System.currentTimeMillis() - this.f10888a < 500) {
                            objArr[0].onClick(textView);
                        }
                    } else if (action == 0) {
                        Selection.setSelection(spannable, spannable.getSpanStart(objArr[0]), spannable.getSpanEnd(objArr[0]));
                        this.f10888a = System.currentTimeMillis();
                    }
                    this.b = true;
                    return true;
                }
                Selection.removeSelection(spannable);
                this.b = false;
            }
        } catch (Exception e) {
        }
        return super.onTouchEvent(textView, spannable, motionEvent);
    }
}
