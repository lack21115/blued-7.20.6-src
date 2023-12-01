package com.sobot.chat.utils;

import android.widget.TextView;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/StTextUtils.class */
public class StTextUtils {
    public static void ellipsizeEnd(int i, TextView textView) {
        try {
            if (textView.getLineCount() > i) {
                int lineEnd = textView.getLayout().getLineEnd(i - 1);
                textView.setText(((Object) textView.getText().subSequence(0, lineEnd - 1)) + "...");
            }
        } catch (Exception e) {
        }
    }
}
