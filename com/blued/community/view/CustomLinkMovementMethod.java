package com.blued.community.view;

import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/view/CustomLinkMovementMethod.class */
public class CustomLinkMovementMethod extends LinkMovementMethod {
    private static CustomLinkMovementMethod sInstance;

    public static CustomLinkMovementMethod getInstance() {
        if (sInstance == null) {
            sInstance = new CustomLinkMovementMethod();
        }
        return sInstance;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(textView, spannable, motionEvent);
        if (!onTouchEvent && motionEvent.getAction() == 1) {
            ViewParent parent = textView.getParent();
            if (parent instanceof ViewGroup) {
                return ((ViewGroup) parent).performClick();
            }
        }
        return onTouchEvent;
    }
}
