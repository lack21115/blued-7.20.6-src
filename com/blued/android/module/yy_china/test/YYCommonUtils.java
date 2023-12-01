package com.blued.android.module.yy_china.test;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.blued.android.module.common.widget.emoticon.ui.Emotion;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/test/YYCommonUtils.class */
class YYCommonUtils {
    YYCommonUtils() {
    }

    private static CharSequence a(CharSequence charSequence, int i, int i2) {
        return TextUtils.isEmpty(charSequence) ? charSequence : Emotion.a(charSequence, i, i2);
    }

    public static void a(Context context, EditText editText, int i, int i2, String str, Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : map.keySet()) {
            arrayList.add(str2);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= arrayList.size()) {
                editText.setText(a((CharSequence) spannableStringBuilder, (int) editText.getTextSize(), 0));
                return;
            }
            String str3 = "@" + ((String) arrayList.get(i4)) + " ";
            if (str.contains(str3)) {
                Matcher matcher = Pattern.compile(str3).matcher(str);
                while (matcher.find()) {
                    TextView textView = new TextView(context);
                    textView.setText(str3);
                    textView.setTextSize(i);
                    textView.setTextColor(i2);
                    textView.setDrawingCacheEnabled(true);
                    textView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    textView.layout(0, 0, textView.getMeasuredWidth(), textView.getMeasuredHeight());
                    ImageSpan imageSpan = new ImageSpan(context, textView.getDrawingCache());
                    try {
                        if (a(spannableStringBuilder, matcher.start(), matcher.end())) {
                            spannableStringBuilder.setSpan(imageSpan, matcher.start(), matcher.end(), 33);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            i3 = i4 + 1;
        }
    }

    private static boolean a(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        int length;
        return i2 >= i && i <= (length = spannableStringBuilder.length()) && i2 <= length && i >= 0 && i2 >= 0;
    }
}
