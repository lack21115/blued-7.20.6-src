package com.blued.android.module.common.utils;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.blued.android.module.common.utils.ClickUtils;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/HyperlinkUtils.class */
public class HyperlinkUtils {
    public static SpannableStringBuilder a(Context context, CharSequence charSequence, String str, int i, final View.OnClickListener onClickListener) {
        if (TextUtils.isEmpty(charSequence) || TextUtils.isEmpty(str)) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        ClickUtils.RevoClickSpan revoClickSpan = new ClickUtils.RevoClickSpan(context, i, new View.OnClickListener() { // from class: com.blued.android.module.common.utils.HyperlinkUtils.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                View.OnClickListener onClickListener2 = View.OnClickListener.this;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(view);
                }
            }
        });
        int indexOf = charSequence.toString().indexOf(str);
        int length = str.length() + indexOf;
        if (indexOf < spannableStringBuilder.length() && length <= spannableStringBuilder.length()) {
            spannableStringBuilder.setSpan(revoClickSpan, indexOf, length, 17);
        }
        return spannableStringBuilder;
    }

    public static void a(Context context, TextView textView, String str, int i, View.OnClickListener onClickListener) {
        if (textView == null) {
            return;
        }
        textView.setText(a(context, textView.getText(), str, i, onClickListener));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
