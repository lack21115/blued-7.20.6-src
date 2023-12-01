package com.blued.community.utils;

import android.graphics.Color;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pair;
import com.blued.android.chat.data.MsgType;
import com.blued.android.chat.utils.AtRegExpUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.CommonPreferences;
import com.blued.android.module.common.utils.LinkMovementClickMethod;
import com.blued.android.module.common.widget.emoticon.ui.Emotion;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.ui.send.manager.FeedSendManager;
import com.igexin.push.core.b;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/utils/StringUtils.class */
public class StringUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f20475a = Pattern.compile("[^一-龥]");
    private static final Pattern b = Pattern.compile("((http[s]{0,1}|blued)://|www\\.)[A-Za-z0-9\\.\\?\\-_~!@#$%^&/:=]+[A-Za-z0-9/#]");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f20476c = Pattern.compile(AtRegExpUtils.AT_USERNAME_PATTERN2);
    private static final Pattern d = Pattern.compile("@([^\\s`~\\!@#\\$%\\^&\\*\\(\\)\\+=\\|'\\:;'\\,\\[\\]\\.\\<\\>/\\?！@#￥%……（）——\\{\\}【】‘；：”“’。，、？]+)");
    private static final Pattern e = Pattern.compile("[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+");

    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/utils/StringUtils$ClickAtLinkListener.class */
    public interface ClickAtLinkListener {
        void a(String str, String str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/utils/StringUtils$JayceSpan.class */
    public static class JayceSpan extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        public boolean f20481a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f20482c;
        private WebLinkListener d;

        JayceSpan(String str, boolean z) {
            this.b = str;
            this.f20482c = z;
        }

        public void a(WebLinkListener webLinkListener) {
            this.d = webLinkListener;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Selection.removeSelection((Spannable) ((TextView) view).getText());
            CommunityServiceManager.b().a(AppInfo.d(), this.b);
            WebLinkListener webLinkListener = this.d;
            if (webLinkListener != null) {
                webLinkListener.b(this.b);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (this.f20482c) {
                textPaint.setColor(BluedSkinUtils.a(AppInfo.d(), R.color.syc_m));
            }
            textPaint.setUnderlineText(false);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/utils/StringUtils$WebLinkListener.class */
    public interface WebLinkListener {
        void a(String str);

        void b(String str);
    }

    public static int a(String str, int i) {
        if (d(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return i;
        }
    }

    public static CharSequence a(CharSequence charSequence, int i, int i2) {
        return TextUtils.isEmpty(charSequence) ? charSequence : Emotion.a(charSequence, i, i2);
    }

    public static CharSequence a(CharSequence charSequence, boolean z, WebLinkListener webLinkListener) {
        SpannableStringBuilder spannableStringBuilder;
        if (TextUtils.isEmpty(charSequence)) {
            return charSequence;
        }
        Matcher matcher = b.matcher(charSequence);
        SpannableStringBuilder spannableStringBuilder2 = null;
        while (true) {
            spannableStringBuilder = spannableStringBuilder2;
            if (!matcher.find()) {
                break;
            }
            SpannableStringBuilder spannableStringBuilder3 = spannableStringBuilder;
            if (spannableStringBuilder == null) {
                spannableStringBuilder3 = new SpannableStringBuilder(charSequence);
            }
            JayceSpan jayceSpan = new JayceSpan(matcher.group(), z);
            if (webLinkListener != null) {
                webLinkListener.a(matcher.group());
                jayceSpan.a(webLinkListener);
            }
            spannableStringBuilder3.setSpan(jayceSpan, matcher.start(), matcher.end(), 33);
            spannableStringBuilder2 = spannableStringBuilder3;
        }
        return spannableStringBuilder != null ? spannableStringBuilder : charSequence;
    }

    public static CharSequence a(CharSequence charSequence, boolean z, boolean z2, boolean z3, final ClickAtLinkListener clickAtLinkListener, final boolean z4, final String str, final String str2) {
        ArrayList arrayList;
        boolean z5;
        if (TextUtils.isEmpty(charSequence)) {
            return charSequence;
        }
        Matcher matcher = f20476c.matcher(charSequence);
        SpannableStringBuilder spannableStringBuilder = null;
        int i = 0;
        while (matcher.find()) {
            SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
            if (spannableStringBuilder == null) {
                spannableStringBuilder2 = new SpannableStringBuilder();
            }
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            String str3 = group2;
            if (!TextUtils.isEmpty(group2)) {
                str3 = group2;
                if (!group2.equals(MsgType.UID_GROUP_AT_ALL)) {
                    str3 = EncryptTool.a(group2);
                }
            }
            if (z3) {
                FeedSendManager.a().c().put(group, str3);
            }
            boolean z6 = !TextUtils.isEmpty(str3) && str3.equals(UserInfoUtils.c());
            boolean z7 = !TextUtils.isEmpty(str3) && str3.equals(MsgType.UID_GROUP_AT_ALL);
            String str4 = group;
            if (z2) {
                str4 = "@" + group;
            }
            spannableStringBuilder2.append(charSequence.subSequence(i, matcher.start()));
            int length = spannableStringBuilder2.length();
            int length2 = str4.length() + length;
            spannableStringBuilder2.append((CharSequence) str4);
            if (z) {
                if (z6) {
                    spannableStringBuilder2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(AppInfo.d(), R.color.syc_m)), length, length2, 33);
                }
                final boolean z8 = z7;
                final String str5 = str4;
                final String str6 = str3;
                spannableStringBuilder2.setSpan(new ClickableSpan() { // from class: com.blued.community.utils.StringUtils.1
                    @Override // android.text.style.ClickableSpan
                    public void onClick(View view) {
                        if (z8) {
                            return;
                        }
                        Selection.removeSelection((Spannable) ((TextView) view).getText());
                        ClickAtLinkListener clickAtLinkListener2 = clickAtLinkListener;
                        if (clickAtLinkListener2 != null) {
                            clickAtLinkListener2.a(str5, str6);
                        } else {
                            CommunityServiceManager.b().a(AppInfo.d(), str6, str2);
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
            }
            i = matcher.end();
            spannableStringBuilder = spannableStringBuilder2;
        }
        if (spannableStringBuilder != null && i < charSequence.length() - 1) {
            spannableStringBuilder.append(charSequence.subSequence(i, charSequence.length()));
        }
        SpannableStringBuilder spannableStringBuilder3 = spannableStringBuilder;
        if (spannableStringBuilder == null) {
            Matcher matcher2 = e.matcher(charSequence);
            ArrayList arrayList2 = null;
            while (true) {
                arrayList = arrayList2;
                if (!matcher2.find()) {
                    break;
                }
                ArrayList arrayList3 = arrayList;
                if (arrayList == null) {
                    arrayList3 = new ArrayList();
                }
                arrayList3.add(new Pair(Integer.valueOf(matcher2.start()), Integer.valueOf(matcher2.end())));
                arrayList2 = arrayList3;
            }
            Matcher matcher3 = d.matcher(charSequence);
            while (true) {
                spannableStringBuilder3 = spannableStringBuilder;
                if (!matcher3.find()) {
                    break;
                }
                if (arrayList != null && arrayList.size() > 0) {
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z5 = false;
                            break;
                        }
                        Pair pair = (Pair) it.next();
                        if (matcher3.start() >= ((Integer) pair.first).intValue() && matcher3.end() <= ((Integer) pair.second).intValue()) {
                            it.remove();
                            z5 = true;
                            break;
                        } else if (matcher3.start() > ((Integer) pair.second).intValue()) {
                            it.remove();
                        }
                    }
                    if (z5) {
                    }
                }
                final String group3 = matcher3.group(1);
                SpannableStringBuilder spannableStringBuilder4 = spannableStringBuilder;
                if (spannableStringBuilder == null) {
                    spannableStringBuilder4 = new SpannableStringBuilder(charSequence);
                }
                spannableStringBuilder = spannableStringBuilder4;
                if (z) {
                    if (!TextUtils.isEmpty(group3) && group3.equals(UserInfo.getInstance().getLoginUserInfo().name)) {
                        spannableStringBuilder4.setSpan(new ForegroundColorSpan(ContextCompat.getColor(AppInfo.d(), R.color.syc_m)), matcher3.start(), matcher3.end(), 33);
                    }
                    spannableStringBuilder4.setSpan(new ClickableSpan() { // from class: com.blued.community.utils.StringUtils.2
                        @Override // android.text.style.ClickableSpan
                        public void onClick(View view) {
                            if (String.this.equals(view.getContext().getString(R.string.feed_post_see_all))) {
                                return;
                            }
                            Selection.removeSelection((Spannable) ((TextView) view).getText());
                            ClickAtLinkListener clickAtLinkListener2 = clickAtLinkListener;
                            if (clickAtLinkListener2 != null) {
                                clickAtLinkListener2.a(String.this, null);
                            } else {
                                CommunityServiceManager.b().a(AppInfo.d(), String.this, str2);
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
                    }, matcher3.start(), matcher3.end(), 33);
                    spannableStringBuilder = spannableStringBuilder4;
                }
            }
        }
        return spannableStringBuilder3 != null ? spannableStringBuilder3 : charSequence;
    }

    public static CharSequence a(CharSequence charSequence, boolean z, boolean z2, boolean z3, String str) {
        return a(charSequence, z, z2, false, null, z3, "", str);
    }

    public static CharSequence a(CharSequence charSequence, boolean z, boolean... zArr) {
        SpannableStringBuilder spannableStringBuilder;
        if (TextUtils.isEmpty(charSequence)) {
            return charSequence;
        }
        Matcher matcher = b.matcher(charSequence);
        SpannableStringBuilder spannableStringBuilder2 = null;
        while (true) {
            spannableStringBuilder = spannableStringBuilder2;
            if (!matcher.find()) {
                break;
            }
            SpannableStringBuilder spannableStringBuilder3 = spannableStringBuilder;
            if (spannableStringBuilder == null) {
                spannableStringBuilder3 = new SpannableStringBuilder(charSequence);
            }
            JayceSpan jayceSpan = new JayceSpan(matcher.group(), z);
            boolean z2 = false;
            if (zArr != null) {
                z2 = false;
                if (zArr.length > 0) {
                    z2 = false;
                    if (zArr[0]) {
                        z2 = true;
                    }
                }
            }
            jayceSpan.f20481a = z2;
            spannableStringBuilder3.setSpan(jayceSpan, matcher.start(), matcher.end(), 33);
            spannableStringBuilder2 = spannableStringBuilder3;
        }
        return spannableStringBuilder != null ? spannableStringBuilder : charSequence;
    }

    public static String a(String str) {
        double d2;
        if (TextUtils.isEmpty(str)) {
            return "0";
        }
        DecimalFormat decimalFormat = str.indexOf(".") > 0 ? (str.length() - str.indexOf(".")) - 1 == 0 ? new DecimalFormat("###,##0") : (str.length() - str.indexOf(".")) - 1 == 1 ? new DecimalFormat("###,##0.0") : new DecimalFormat("###,##0.00") : new DecimalFormat("###,##0");
        try {
            d2 = Double.parseDouble(str);
        } catch (Exception e2) {
            d2 = 0.0d;
        }
        String format = decimalFormat.format(d2);
        String str2 = format;
        if (format.indexOf(".") > 0) {
            str2 = format.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str2;
    }

    public static String a(String str, String str2) {
        if (d(str) && d(str2)) {
            return null;
        }
        return str + "(" + str2 + ")";
    }

    public static String a(String str, Locale locale, boolean z) {
        String str2;
        str2 = "";
        String str3 = str2;
        if (!d(str)) {
            int c2 = CommonPreferences.c();
            if (c2 != 1) {
                if (c2 != 2) {
                    return "";
                }
                int i = 0;
                double a2 = a(str, 0) / 30.48d;
                int i2 = (int) a2;
                int round = (int) Math.round((a2 - i2) * 12.0d);
                if (round == 12) {
                    i2++;
                } else {
                    i = round;
                }
                return i2 + "'" + i + "\"";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(z ? " cm" : "");
            str3 = sb.toString();
        }
        return str3;
    }

    public static void a(TextView textView, CharSequence charSequence, int i, ClickAtLinkListener clickAtLinkListener, boolean z, boolean z2, boolean z3, String str, int i2, boolean... zArr) {
        if (textView == null) {
            return;
        }
        if (TextUtils.isEmpty(((Object) charSequence) + "")) {
            textView.setText("");
            return;
        }
        CharSequence a2 = a(a(charSequence, (int) textView.getTextSize(), i), true, true, false, clickAtLinkListener, z2, "", str);
        CharSequence charSequence2 = a2;
        if (z) {
            charSequence2 = a(a2, z2, zArr);
        }
        textView.setText(charSequence2);
        if (z3) {
            textView.setMovementMethod(LinkMovementClickMethod.a());
        }
    }

    public static void a(TextView textView, CharSequence charSequence, int i, String str) {
        a(textView, charSequence, i, null, true, true, true, str, -1, new boolean[0]);
    }

    public static void a(TextView textView, CharSequence charSequence, boolean z, String str) {
        a(textView, charSequence, 0, null, true, z, true, str, -1, new boolean[0]);
    }

    public static int b(String str) {
        if (!d(str) && Pattern.compile("[0-9]*").matcher(str).matches()) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e2) {
                return 0;
            }
        }
        return 0;
    }

    public static String b(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return String.format("@%s", str);
        }
        String b2 = EncryptTool.b(str2);
        if (!str2.equals(MsgType.UID_GROUP_AT_ALL)) {
            str2 = b2;
        }
        return String.format("@(name:%s,id:%s)", str, str2);
    }

    public static String b(String str, Locale locale, boolean z) {
        String str2;
        str2 = "";
        String str3 = str2;
        if (!d(str)) {
            int c2 = CommonPreferences.c();
            if (c2 != 1) {
                if (c2 != 2) {
                    return "";
                }
                int round = (int) Math.round(a(str, 0) * 2.2d);
                return round + " lbs";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(z ? " kg" : "");
            str3 = sb.toString();
        }
        return str3;
    }

    public static String c(String str, String str2) {
        return String.format("(name:%s,id:%s)", str, EncryptTool.b(str2));
    }

    public static boolean c(String str) {
        return !TextUtils.isEmpty(str.trim()) && Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static boolean d(String str) {
        return str == null || "".equals(str.trim()) || b.l.equals(str) || " ".equals(str);
    }
}
