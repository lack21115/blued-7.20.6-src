package com.blued.android.module.yy_china.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.TextView;
import com.blued.android.module.common.view.CenterAlignImageSpan;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.utils.YYTextSpanComputer;
import java.util.regex.Pattern;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/utils/YYCommonStringUtils.class */
public class YYCommonStringUtils {
    static final Pattern a = Pattern.compile("\\S*[?]\\S*");

    public static SpannableStringBuilder a(Context context, TextView textView, YYImModel yYImModel, String str, int i, String str2, String str3) {
        return a(context, textView, yYImModel, str, i, str2, str3, true);
    }

    public static SpannableStringBuilder a(Context context, TextView textView, YYImModel yYImModel, String str, int i, String str2, String str3, Bitmap bitmap) {
        YYTextSpanComputer.Builder builder = new YYTextSpanComputer.Builder();
        if (!TextUtils.isEmpty(str)) {
            builder.a(context, str, i, i);
            builder.a(" ");
        }
        if (yYImModel != null && yYImModel.source_profile != null && yYImModel.source_profile.wealth_level > 0) {
            builder.a(context.getResources().getDrawable(YYRoomInfoManager.e().a(yYImModel.source_profile.wealth_level)));
            builder.a(" ");
        }
        textView.setIncludeFontPadding(false);
        textView.setLineSpacing(context.getResources().getDimensionPixelOffset(R.dimen.dp_2), 1.0f);
        CenterAlignImageSpan centerAlignImageSpan = null;
        if (bitmap != null) {
            centerAlignImageSpan = new CenterAlignImageSpan(context, bitmap);
        }
        if (!TextUtils.isEmpty(str2)) {
            builder.a(str2 + ": ");
        }
        if (!TextUtils.isEmpty(str3)) {
            builder.a(str3);
        }
        if (centerAlignImageSpan != null) {
            builder.a(SpannableString.valueOf("1"), centerAlignImageSpan);
        }
        return builder.c().a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0173, code lost:
        if (r15 != false) goto L70;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.text.SpannableStringBuilder a(android.content.Context r7, android.widget.TextView r8, com.blued.android.module.yy_china.model.YYImModel r9, java.lang.String r10, int r11, java.lang.String r12, java.lang.String r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 524
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.utils.YYCommonStringUtils.a(android.content.Context, android.widget.TextView, com.blued.android.module.yy_china.model.YYImModel, java.lang.String, int, java.lang.String, java.lang.String, boolean):android.text.SpannableStringBuilder");
    }

    public static String a(String str, Paint paint, int i) {
        float measureText = paint.measureText(str);
        String str2 = str;
        if (measureText > i) {
            str2 = str.substring(0, (int) ((str.length() * i) / measureText)) + "...";
        }
        return str2;
    }
}
