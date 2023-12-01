package com.blued.android.framework.utils;

import android.text.Selection;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.blued.android.chat.utils.AtRegExpUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/RegExpUtils.class */
public class RegExpUtils {

    /* renamed from: com.blued.android.framework.utils.RegExpUtils$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/RegExpUtils$1.class */
    class AnonymousClass1 extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TopicClickSpanListener f10109a;
        final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f10110c;

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Selection.removeSelection((Spannable) ((TextView) view).getText());
            this.f10109a.a(this.b);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(this.f10110c);
            textPaint.setUnderlineText(false);
            textPaint.clearShadowLayer();
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/RegExpUtils$AtUserClickSpanListener.class */
    public interface AtUserClickSpanListener {
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/RegExpUtils$TopicClickSpanListener.class */
    public interface TopicClickSpanListener {
        void a(String str);
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = null;
        Matcher matcher = Pattern.compile(AtRegExpUtils.AT_USERNAME_PATTERN2).matcher(str);
        int i = 0;
        while (matcher.find()) {
            StringBuilder sb2 = sb;
            if (sb == null) {
                sb2 = new StringBuilder();
            }
            sb2.append(str.subSequence(i, matcher.start()));
            sb2.append("@" + matcher.group(1));
            i = matcher.end();
            sb = sb2;
        }
        if (sb != null && i < str.length() - 1) {
            sb.append(str.subSequence(i, str.length()));
        }
        if (sb != null) {
            str = sb.toString();
        }
        return str;
    }
}
