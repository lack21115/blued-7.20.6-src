package com.blued.android.module.yy_china.test;

import android.graphics.Color;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import androidx.core.util.Pair;
import com.blued.android.chat.utils.AtRegExpUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.listener.ClickAtLinkListener;
import com.blued.android.module.yy_china.test.YYTypefaceUtils;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/test/YYStringUtils.class */
public class YYStringUtils {
    private static final Pattern a = Pattern.compile("[^一-龥]");
    private static final Pattern b = Pattern.compile("((http[s]{0,1}|blued)://|www\\.)[A-Za-z0-9\\.\\?\\-_~!@#$%^&/:=]+[A-Za-z0-9/#]");
    private static final Pattern c = Pattern.compile(AtRegExpUtils.AT_USERNAME_PATTERN2);
    private static final Pattern d = Pattern.compile("@([^\\s`~\\!@#\\$%\\^&\\*\\(\\)\\+=\\|'\\:;'\\,\\[\\]\\.\\<\\>/\\?！@#￥%……（）——\\{\\}【】‘；：”“’。，、？]+)");
    private static final Pattern e = Pattern.compile("[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+");

    public static CharSequence a(CharSequence charSequence, String str, final ClickAtLinkListener clickAtLinkListener) {
        return a(charSequence, true, true, false, new YYTypefaceUtils.ClickAtLinkListener() { // from class: com.blued.android.module.yy_china.test.YYStringUtils.1
            @Override // com.blued.android.module.yy_china.test.YYTypefaceUtils.ClickAtLinkListener
            public void a(String str2, String str3) {
                ClickAtLinkListener.this.a(str2, str3);
            }
        }, true, str, "", clickAtLinkListener);
    }

    public static CharSequence a(CharSequence charSequence, boolean z, boolean z2, boolean z3, final YYTypefaceUtils.ClickAtLinkListener clickAtLinkListener, final boolean z4, final String str, String str2, ClickAtLinkListener clickAtLinkListener2) {
        SpannableStringBuilder spannableStringBuilder;
        if (TextUtils.isEmpty(charSequence)) {
            return charSequence;
        }
        Matcher matcher = c.matcher(charSequence);
        int i = 0;
        SpannableStringBuilder spannableStringBuilder2 = null;
        while (true) {
            spannableStringBuilder = spannableStringBuilder2;
            if (!matcher.find()) {
                break;
            }
            SpannableStringBuilder spannableStringBuilder3 = spannableStringBuilder;
            if (spannableStringBuilder == null) {
                spannableStringBuilder3 = new SpannableStringBuilder();
            }
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            String str3 = group2;
            if (!TextUtils.isEmpty(group2)) {
                str3 = EncryptTool.a(group2);
            }
            String str4 = group;
            if (clickAtLinkListener2 != null) {
                str4 = clickAtLinkListener2.b(group, str3);
            }
            String str5 = str4;
            if (z2) {
                str5 = "@" + str4;
            }
            spannableStringBuilder3.append(charSequence.subSequence(i, matcher.start()));
            int length = spannableStringBuilder3.length();
            int length2 = str5.length() + length;
            spannableStringBuilder3.append((CharSequence) str5);
            if (z) {
                final String str6 = str5;
                final String str7 = str3;
                spannableStringBuilder3.setSpan(new ClickableSpan() { // from class: com.blued.android.module.yy_china.test.YYStringUtils.2
                    @Override // android.text.style.ClickableSpan
                    public void onClick(View view) {
                        Selection.removeSelection((Spannable) ((TextView) view).getText());
                        YYTypefaceUtils.ClickAtLinkListener clickAtLinkListener3 = YYTypefaceUtils.ClickAtLinkListener.this;
                        if (clickAtLinkListener3 != null) {
                            clickAtLinkListener3.a(str6, str7);
                        } else {
                            ToastUtils.a("单模块，无法跳转");
                        }
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        if (z4) {
                            if (TextUtils.isEmpty(str)) {
                                textPaint.setColor(AppInfo.d().getResources().getColor(R.color.syc_m));
                            } else {
                                try {
                                    textPaint.setColor(Color.parseColor(str));
                                } catch (Exception e2) {
                                    textPaint.setColor(AppInfo.d().getResources().getColor(R.color.biao_live_msg_name_3));
                                }
                            }
                        }
                        textPaint.setUnderlineText(false);
                        textPaint.clearShadowLayer();
                    }
                }, length, length2, 33);
                spannableStringBuilder3.setSpan(new StyleSpan(1), length, length2, 33);
            }
            i = matcher.end();
            spannableStringBuilder2 = spannableStringBuilder3;
        }
        if (spannableStringBuilder != null && i < charSequence.length() - 1) {
            spannableStringBuilder.append(charSequence.subSequence(i, charSequence.length()));
        }
        if (spannableStringBuilder == null) {
            Matcher matcher2 = e.matcher(charSequence);
            ArrayList arrayList = null;
            while (true) {
                ArrayList arrayList2 = arrayList;
                if (!matcher2.find()) {
                    break;
                }
                ArrayList arrayList3 = arrayList2;
                if (arrayList2 == null) {
                    arrayList3 = new ArrayList();
                }
                arrayList3.add(new Pair(Integer.valueOf(matcher2.start()), Integer.valueOf(matcher2.end())));
                arrayList = arrayList3;
            }
        }
        return spannableStringBuilder != null ? spannableStringBuilder : charSequence;
    }
}
