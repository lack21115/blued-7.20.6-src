package com.soft.blued.utils;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pair;
import com.anythink.expressad.video.dynview.a.a;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.widget.emoticon.ui.Emotion;
import com.blued.android.module.yy_china.listener.ClickAtLinkListener;
import com.blued.community.ui.send.manager.FeedSendManager;
import com.igexin.push.core.b;
import com.soft.blued.R;
import com.soft.blued.log.bytedance.MessageEventUtils;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.TypefaceUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.Character;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/StringUtils.class */
public class StringUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f21089a = Pattern.compile("[^一-龥]");
    private static final Pattern b = Pattern.compile("((http[s]{0,1}|blued)://|www\\.)[A-Za-z0-9\\.\\?\\-_~!@#$%^&/:=]+[A-Za-z0-9/#]");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f21090c = Pattern.compile("@\\(name:([^\\n\\r`~\\!@#\\$%\\^&\\*\\(\\)\\+=\\|'\\:;'\\,\\[\\]\\.\\<\\>/\\?！@#￥%……（）——\\{\\}【】‘；：”“’。，、？]+),id:([A-Za-z0-9]+)\\)");
    private static final Pattern d = Pattern.compile("@([^\\s`~\\!@#\\$%\\^&\\*\\(\\)\\+=\\|'\\:;'\\,\\[\\]\\.\\<\\>/\\?！@#￥%……（）——\\{\\}【】‘；：”“’。，、？]+)");
    private static final Pattern e = Pattern.compile("[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+");
    private static final Pattern f = Pattern.compile("@\\(name:(.+?),id:([A-Za-z0-9]+?)\\)");

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/StringUtils$JayceSpan.class */
    static class JayceSpan extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        public boolean f21100a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f21101c;

        JayceSpan(String str, boolean z) {
            this.b = str;
            this.f21101c = z;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.f21100a) {
                MessageEventUtils.b(this.b);
            }
            Selection.removeSelection((Spannable) ((TextView) view).getText());
            WebViewShowInfoFragment.show(AppInfo.d(), this.b, 7);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (this.f21101c) {
                textPaint.setColor(BluedSkinUtils.a(AppInfo.d(), 2131102270));
            }
            textPaint.setUnderlineText(true);
        }
    }

    public static double a(String str, double d2) {
        if (d(str)) {
            return d2;
        }
        try {
            return Double.valueOf(str).doubleValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return d2;
        }
    }

    public static int a(Editable editable) {
        int i;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < editable.length(); i4++) {
            if (editable.charAt(i4) < 128) {
                i = i3;
                i2 = 1;
            } else {
                i = i3;
                i2 = 2;
            }
            i3 = i + i2;
        }
        return i3;
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

    public static long a(String str, long j) {
        if (d(str)) {
            return j;
        }
        try {
            return Long.parseLong(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return j;
        }
    }

    public static InputFilter a() {
        return new InputFilter() { // from class: com.soft.blued.utils.StringUtils.9
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                if (TextUtils.isEmpty(charSequence)) {
                    return "";
                }
                while (i < i2) {
                    if (StringUtils.a(charSequence) && !charSequence.toString().contains("。") && !charSequence.toString().contains("，") && !charSequence.toString().contains("·")) {
                        return "";
                    }
                    i++;
                }
                return null;
            }
        };
    }

    public static SpannableStringBuilder a(SpannableStringBuilder spannableStringBuilder, String str, final View.OnClickListener... onClickListenerArr) {
        if (!TextUtils.isEmpty(spannableStringBuilder.toString()) && !TextUtils.isEmpty(str)) {
            Matcher matcher = Pattern.compile(str).matcher(spannableStringBuilder);
            while (matcher.find()) {
                spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.soft.blued.utils.StringUtils.6
                    @Override // android.text.style.ClickableSpan
                    public void onClick(View view) {
                        View.OnClickListener[] onClickListenerArr2 = onClickListenerArr;
                        if (onClickListenerArr2 == null || onClickListenerArr2.length <= 0) {
                            return;
                        }
                        onClickListenerArr2[0].onClick(view);
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        textPaint.setColor(AppInfo.d().getResources().getColor(2131101766));
                        textPaint.setFakeBoldText(true);
                        textPaint.setUnderlineText(false);
                        textPaint.clearShadowLayer();
                    }
                }, matcher.start(), matcher.end(), 33);
            }
            return spannableStringBuilder;
        }
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder a(SpannableStringBuilder spannableStringBuilder, List<String> list, final int i) {
        if (TextUtils.isEmpty(spannableStringBuilder.toString())) {
            return spannableStringBuilder;
        }
        if (list != null) {
            if (list.size() == 0) {
                return spannableStringBuilder;
            }
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    Matcher matcher = Pattern.compile(str).matcher(spannableStringBuilder);
                    while (matcher.find()) {
                        spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.soft.blued.utils.StringUtils.7
                            @Override // android.text.style.ClickableSpan
                            public void onClick(View view) {
                            }

                            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                            public void updateDrawState(TextPaint textPaint) {
                                textPaint.setColor(BluedSkinUtils.a(AppInfo.d(), i));
                                textPaint.setFakeBoldText(true);
                                textPaint.setUnderlineText(false);
                                textPaint.clearShadowLayer();
                            }
                        }, matcher.start(), matcher.end(), 33);
                    }
                }
            }
        }
        return spannableStringBuilder;
    }

    public static CharSequence a(CharSequence charSequence, int i) {
        return a(charSequence, i, 0);
    }

    public static CharSequence a(CharSequence charSequence, int i, int i2) {
        CharSequence a2;
        return (TextUtils.isEmpty(charSequence) || (a2 = Emotion.a(charSequence, i, i2)) == null) ? "" : a2;
    }

    public static CharSequence a(CharSequence charSequence, boolean z, boolean z2, boolean z3, final TypefaceUtils.ClickAtLinkListener clickAtLinkListener, final boolean z4, final String str, final String str2) {
        ArrayList arrayList;
        boolean z5;
        if (TextUtils.isEmpty(charSequence)) {
            return "";
        }
        Matcher matcher = f21090c.matcher(charSequence);
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
                if (!group2.equals("000000")) {
                    str3 = EncryptTool.a(group2);
                }
            }
            if (z3) {
                FeedSendManager.a().c().put(group, str3);
            }
            boolean z6 = !TextUtils.isEmpty(str3) && str3.equals(UserInfo.getInstance().getLoginUserInfo().uid);
            boolean z7 = !TextUtils.isEmpty(str3) && str3.equals("000000");
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
                    spannableStringBuilder2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(AppInfo.d(), 2131102270)), length, length2, 33);
                }
                final boolean z8 = z7;
                final String str5 = str4;
                final String str6 = str3;
                spannableStringBuilder2.setSpan(new ClickableSpan() { // from class: com.soft.blued.utils.StringUtils.1
                    @Override // android.text.style.ClickableSpan
                    public void onClick(View view) {
                        if (z8) {
                            return;
                        }
                        Selection.removeSelection((Spannable) ((TextView) view).getText());
                        TypefaceUtils.ClickAtLinkListener clickAtLinkListener2 = clickAtLinkListener;
                        if (clickAtLinkListener2 != null) {
                            clickAtLinkListener2.a(str5, str6);
                        } else {
                            UserInfoFragmentNew.a(AppInfo.d(), str6, str2);
                        }
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        if (z4) {
                            if (TextUtils.isEmpty(str)) {
                                textPaint.setColor(AppInfo.d().getResources().getColor(2131102270));
                            } else {
                                try {
                                    textPaint.setColor(Color.parseColor(str));
                                } catch (Exception e2) {
                                    textPaint.setColor(AppInfo.d().getResources().getColor(2131099778));
                                }
                            }
                        }
                        textPaint.setUnderlineText(false);
                        textPaint.clearShadowLayer();
                    }
                }, length, length2, 33);
                spannableStringBuilder2.setSpan(new StyleSpan(1), length, length2, 33);
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
                        spannableStringBuilder4.setSpan(new ForegroundColorSpan(ContextCompat.getColor(AppInfo.d(), 2131102270)), matcher3.start(), matcher3.end(), 33);
                    }
                    spannableStringBuilder4.setSpan(new ClickableSpan() { // from class: com.soft.blued.utils.StringUtils.2
                        @Override // android.text.style.ClickableSpan
                        public void onClick(View view) {
                            if (group3.equals(view.getContext().getString(R.string.group_at_all))) {
                                return;
                            }
                            Selection.removeSelection((Spannable) ((TextView) view).getText());
                            TypefaceUtils.ClickAtLinkListener clickAtLinkListener2 = clickAtLinkListener;
                            if (clickAtLinkListener2 != null) {
                                clickAtLinkListener2.a(group3, null);
                            } else {
                                UserInfoFragmentNew.d(AppInfo.d(), group3, str2);
                            }
                        }

                        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                        public void updateDrawState(TextPaint textPaint) {
                            if (z4) {
                                if (TextUtils.isEmpty(str)) {
                                    textPaint.setColor(AppInfo.d().getResources().getColor(2131102270));
                                } else {
                                    try {
                                        textPaint.setColor(Color.parseColor(str));
                                    } catch (Exception e2) {
                                        textPaint.setColor(AppInfo.d().getResources().getColor(2131099778));
                                    }
                                }
                            }
                            textPaint.setUnderlineText(false);
                            textPaint.clearShadowLayer();
                        }
                    }, matcher3.start(), matcher3.end(), 33);
                    spannableStringBuilder4.setSpan(new StyleSpan(1), matcher3.start(), matcher3.end(), 33);
                    spannableStringBuilder = spannableStringBuilder4;
                }
            }
        }
        return spannableStringBuilder3 != null ? spannableStringBuilder3 : charSequence;
    }

    public static CharSequence a(CharSequence charSequence, boolean z, boolean z2, boolean z3, final TypefaceUtils.ClickAtLinkListener clickAtLinkListener, final boolean z4, final String str, final String str2, ClickAtLinkListener clickAtLinkListener2) {
        SpannableStringBuilder spannableStringBuilder;
        if (TextUtils.isEmpty(charSequence)) {
            return charSequence;
        }
        Matcher matcher = f.matcher(charSequence);
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
            if (z3) {
                FeedSendManager.a().c().put(str4, str3);
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
                spannableStringBuilder3.setSpan(new ClickableSpan() { // from class: com.soft.blued.utils.StringUtils.3
                    @Override // android.text.style.ClickableSpan
                    public void onClick(View view) {
                        Selection.removeSelection((Spannable) ((TextView) view).getText());
                        TypefaceUtils.ClickAtLinkListener clickAtLinkListener3 = TypefaceUtils.ClickAtLinkListener.this;
                        if (clickAtLinkListener3 != null) {
                            clickAtLinkListener3.a(str6, str7);
                        } else {
                            UserInfoFragmentNew.a(AppInfo.d(), str7, str2);
                        }
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        if (z4) {
                            if (TextUtils.isEmpty(str)) {
                                textPaint.setColor(AppInfo.d().getResources().getColor(2131102270));
                            } else {
                                try {
                                    textPaint.setColor(Color.parseColor(str));
                                } catch (Exception e2) {
                                    textPaint.setColor(AppInfo.d().getResources().getColor(2131099778));
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

    public static CharSequence a(CharSequence charSequence, boolean z, boolean z2, boolean z3, String str) {
        return a(charSequence, z, z2, false, null, z3, "", str);
    }

    public static CharSequence a(CharSequence charSequence, boolean z, boolean... zArr) {
        SpannableStringBuilder spannableStringBuilder;
        if (TextUtils.isEmpty(charSequence)) {
            return "";
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
            jayceSpan.f21100a = z2;
            spannableStringBuilder3.setSpan(jayceSpan, matcher.start(), matcher.end(), 33);
            spannableStringBuilder2 = spannableStringBuilder3;
        }
        return spannableStringBuilder != null ? spannableStringBuilder : charSequence;
    }

    public static CharSequence a(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            SpannableStringBuilder spannableStringBuilder2 = null;
            Matcher matcher = Pattern.compile(str2).matcher(str);
            while (true) {
                spannableStringBuilder = spannableStringBuilder2;
                if (!matcher.find()) {
                    break;
                }
                spannableStringBuilder2 = spannableStringBuilder;
                if (spannableStringBuilder == null) {
                    spannableStringBuilder2 = new SpannableStringBuilder(str);
                }
                spannableStringBuilder2.setSpan(new ClickableSpan() { // from class: com.soft.blued.utils.StringUtils.4
                    @Override // android.text.style.ClickableSpan
                    public void onClick(View view) {
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        textPaint.setColor(AppInfo.d().getResources().getColor(2131101190));
                        textPaint.setFakeBoldText(true);
                        textPaint.setUnderlineText(true);
                        textPaint.clearShadowLayer();
                    }
                }, matcher.start(), matcher.end(), 33);
            }
            return spannableStringBuilder == null ? str : spannableStringBuilder;
        }
        return str;
    }

    public static CharSequence a(String str, List<String> list) {
        if (!TextUtils.isEmpty(str) && list != null && list.size() != 0) {
            SpannableStringBuilder spannableStringBuilder = null;
            for (String str2 : list) {
                if (!TextUtils.isEmpty(str2)) {
                    Matcher matcher = Pattern.compile(str2).matcher(str);
                    while (true) {
                        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
                        spannableStringBuilder = spannableStringBuilder2;
                        if (matcher.find()) {
                            spannableStringBuilder = spannableStringBuilder2;
                            if (spannableStringBuilder2 == null) {
                                spannableStringBuilder = new SpannableStringBuilder(str);
                            }
                            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.soft.blued.utils.StringUtils.5
                                @Override // android.text.style.ClickableSpan
                                public void onClick(View view) {
                                }

                                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                                public void updateDrawState(TextPaint textPaint) {
                                    textPaint.setColor(AppInfo.d().getResources().getColor(2131102215));
                                    textPaint.setUnderlineText(false);
                                    textPaint.clearShadowLayer();
                                }
                            }, matcher.start(), matcher.end(), 33);
                        }
                    }
                }
            }
            return spannableStringBuilder == null ? str : spannableStringBuilder;
        }
        return str;
    }

    public static CharSequence a(String str, List<String> list, final int i, final View.OnClickListener... onClickListenerArr) {
        if (!TextUtils.isEmpty(str) && list != null && list.size() != 0) {
            SpannableStringBuilder spannableStringBuilder = null;
            for (String str2 : list) {
                if (!TextUtils.isEmpty(str2)) {
                    Matcher matcher = Pattern.compile(str2).matcher(str);
                    while (true) {
                        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
                        spannableStringBuilder = spannableStringBuilder2;
                        if (matcher.find()) {
                            spannableStringBuilder = spannableStringBuilder2;
                            if (spannableStringBuilder2 == null) {
                                spannableStringBuilder = new SpannableStringBuilder(str);
                            }
                            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.soft.blued.utils.StringUtils.8
                                @Override // android.text.style.ClickableSpan
                                public void onClick(View view) {
                                    View.OnClickListener[] onClickListenerArr2 = onClickListenerArr;
                                    if (onClickListenerArr2.length > 0) {
                                        onClickListenerArr2[0].onClick(view);
                                    }
                                }

                                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                                public void updateDrawState(TextPaint textPaint) {
                                    textPaint.setColor(AppInfo.d().getResources().getColor(i));
                                    textPaint.setUnderlineText(false);
                                    textPaint.clearShadowLayer();
                                }
                            }, matcher.start(), matcher.end(), 33);
                        }
                    }
                }
            }
            return spannableStringBuilder == null ? str : spannableStringBuilder;
        }
        return str;
    }

    public static String a(int i) {
        return i != 2 ? i != 3 ? i != 4 ? i != 5 ? i != 7 ? i != 8 ? "" : AppInfo.d().getResources().getString(R.string.official_merchant) : AppInfo.d().getResources().getString(R.string.host_tag) : AppInfo.d().getResources().getString(R.string.official_redribbon) : AppInfo.d().getResources().getString(R.string.official_person) : AppInfo.d().getResources().getString(R.string.official_mate) : AppInfo.d().getResources().getString(R.string.official_partner);
    }

    public static String a(int i, String str) {
        return String.valueOf(i);
    }

    public static String a(long j) {
        if (j < 10000) {
            return a(String.valueOf(j));
        }
        String format = String.format("%.1f", Double.valueOf(j / 10000.0d));
        String str = format;
        if (format.indexOf(".") > 0) {
            str = format.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str + "万";
    }

    public static String a(Context context, Locale locale, int i) {
        int i2 = i - 1;
        String[] stringArray = context.getResources().getStringArray(R.array.relation_status_array);
        String str = (i2 >= stringArray.length || i2 < 0) ? "" : stringArray[i2];
        String str2 = str;
        if (a.V.equals(locale.getLanguage())) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                str2 = str;
                if (i4 >= UserRelationshipUtils.l.length) {
                    break;
                } else if (i2 == UserRelationshipUtils.l[i4]) {
                    str2 = "";
                    break;
                } else {
                    i3 = i4 + 1;
                }
            }
        }
        return i2 <= 0 ? "" : str2;
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

    public static String a(String str, Locale locale) {
        String str2;
        if (!d(str)) {
            int aF = BluedPreferences.aF();
            str2 = str;
            if (aF != 1) {
                if (aF == 2) {
                    int round = (int) Math.round(a(str, 0) * 2.2d);
                    return round + "";
                }
            }
            return str2;
        }
        str2 = "";
        return str2;
    }

    public static String a(String str, Locale locale, boolean z) {
        String str2;
        str2 = "";
        String str3 = str2;
        if (!d(str)) {
            int aF = BluedPreferences.aF();
            if (aF != 1) {
                if (aF != 2) {
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

    public static String a(List<String> list) {
        StringBuilder sb = new StringBuilder();
        if (list != null && list.size() > 0) {
            int size = list.size() - 1;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                sb.append(list.get(i2));
                sb.append(",");
                i = i2 + 1;
            }
            sb.append(list.get(size));
        }
        return sb.toString();
    }

    public static String a(String[] strArr, String[] strArr2, String str) {
        if (d(str)) {
            return "";
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr2.length) {
                return "";
            }
            if (str.equals(strArr2[i2])) {
                return strArr[i2];
            }
            i = i2 + 1;
        }
    }

    public static boolean a(char c2) {
        Character.UnicodeBlock of = Character.UnicodeBlock.of(c2);
        return of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == Character.UnicodeBlock.GENERAL_PUNCTUATION || of == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
    }

    public static boolean a(CharSequence charSequence) {
        return f21089a.matcher(charSequence).find();
    }

    public static String[] a(Context context) {
        String[] strArr = new String[373];
        String string = context.getResources().getString(R.string.unlimited);
        int i = 70;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 373) {
                return strArr;
            }
            if (i3 == 0 || i3 == 372) {
                strArr[i3] = string;
            } else {
                strArr[i3] = String.valueOf(i);
                i++;
            }
            i2 = i3 + 1;
        }
    }

    public static String[] a(Context context, Locale locale) {
        String[] stringArray = context.getResources().getStringArray(R.array.relation_status_array);
        ArrayList arrayList = new ArrayList();
        String[] strArr = stringArray;
        if (a.V.equals(locale.getLanguage())) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= stringArray.length) {
                    break;
                }
                boolean z = false;
                for (int i3 = 0; i3 < UserRelationshipUtils.l.length; i3++) {
                    z = z || UserRelationshipUtils.l[i3] == i2;
                }
                if (!z) {
                    arrayList.add(stringArray[i2]);
                }
                i = i2 + 1;
            }
            strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return strArr;
    }

    public static String b(int i) {
        return AppInfo.d().getResources().getStringArray(R.array.race_array_key_more)[i + 1];
    }

    public static String b(String str) {
        double d2;
        if (TextUtils.isEmpty(str)) {
            return " - ";
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

    public static String b(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return String.format("@%s", str);
        }
        String b2 = EncryptTool.b(str2);
        if (!str2.equals("000000")) {
            str2 = b2;
        }
        return String.format("@(name:%s,id:%s)", str, str2);
    }

    public static String b(String str, Locale locale, boolean z) {
        String str2;
        str2 = "";
        String str3 = str2;
        if (!d(str)) {
            int aF = BluedPreferences.aF();
            if (aF != 1) {
                if (aF != 2) {
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

    public static int c(String str) {
        if (!d(str) && Pattern.compile("[0-9]*").matcher(str).matches()) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e2) {
                return 0;
            }
        }
        return 0;
    }

    public static boolean d(String str) {
        return str == null || "".equals(str.trim()) || b.l.equals(str) || " ".equals(str);
    }

    public static String e(String str) {
        if (d(str)) {
            return AppInfo.d().getResources().getString(2131891554) + "";
        }
        String[] stringArray = AppInfo.d().getResources().getStringArray(R.array.roletype);
        String[] stringArray2 = AppInfo.d().getResources().getStringArray(R.array.role_key);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= stringArray2.length) {
                return Constants.WAVE_SEPARATOR;
            }
            if (stringArray2[i2].equals(str)) {
                return stringArray[i2];
            }
            i = i2 + 1;
        }
    }

    public static String f(String str) {
        if (d(str)) {
            return "-1";
        }
        String[] stringArray = AppInfo.d().getResources().getStringArray(R.array.roletype);
        String[] stringArray2 = AppInfo.d().getResources().getStringArray(R.array.role_key);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= stringArray.length) {
                return "-1";
            }
            if (stringArray[i2].equals(str)) {
                return stringArray2[i2];
            }
            i = i2 + 1;
        }
    }

    public static boolean g(String str) {
        return TextUtils.isEmpty(str) || "0".equals(str);
    }

    public static boolean h(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return b.matcher(str).find();
    }

    public static int i(String str) {
        int i;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < str.length(); i4++) {
            if (str.charAt(i4) < 128) {
                i = i3;
                i2 = 1;
            } else {
                i = i3;
                i2 = 2;
            }
            i3 = i + i2;
        }
        return i3;
    }

    public static String j(String str) {
        return str != null ? Pattern.compile("\t|\r|\n|\\s*").matcher(str).replaceAll("") : "";
    }
}
