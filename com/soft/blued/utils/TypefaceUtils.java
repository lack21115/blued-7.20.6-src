package com.soft.blued.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.expressad.video.dynview.a.a;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.ClickUtils;
import com.blued.android.module.common.utils.LinkMovementClickMethod;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.log.bytedance.MessageEventUtils;
import com.soft.blued.ui.web.WebViewShowInfoFragment;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/TypefaceUtils.class */
public class TypefaceUtils {

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/TypefaceUtils$ClickAtLinkListener.class */
    public interface ClickAtLinkListener {
        void a(String str, String str2);
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/TypefaceUtils$ClickLinkListener.class */
    public interface ClickLinkListener {
        void a(String str);
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/TypefaceUtils$SpannIndex.class */
    public static class SpannIndex {

        /* renamed from: a  reason: collision with root package name */
        public int f21106a;
        public int b;

        public SpannIndex(int i, int i2) {
            this.f21106a = i;
            this.b = i2;
        }
    }

    public static SpannableStringBuilder a(final Context context, String str, final boolean z, final ClickLinkListener clickLinkListener) {
        if (TextUtils.isEmpty(str)) {
            return new SpannableStringBuilder(str);
        }
        Spanned fromHtml = Html.fromHtml(str);
        if (fromHtml instanceof SpannableStringBuilder) {
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) fromHtml;
            Object[] spans = spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), URLSpan.class);
            if (spans != null && spans.length != 0) {
                for (Object obj : spans) {
                    int spanStart = spannableStringBuilder.getSpanStart(obj);
                    int spanEnd = spannableStringBuilder.getSpanEnd(obj);
                    if (obj instanceof URLSpan) {
                        final URLSpan uRLSpan = (URLSpan) obj;
                        final String url = uRLSpan.getURL();
                        spannableStringBuilder.removeSpan(obj);
                        spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.soft.blued.utils.TypefaceUtils.1
                            @Override // android.text.style.ClickableSpan
                            public void onClick(View view) {
                                if (z) {
                                    MessageEventUtils.b(url);
                                }
                                ClickLinkListener clickLinkListener2 = clickLinkListener;
                                if (clickLinkListener2 != null) {
                                    clickLinkListener2.a(uRLSpan.getURL());
                                }
                                WebViewShowInfoFragment.show(context, uRLSpan.getURL(), -1);
                            }

                            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                            public void updateDrawState(TextPaint textPaint) {
                                super.updateDrawState(textPaint);
                                textPaint.setUnderlineText(false);
                            }
                        }, spanStart, spanEnd, 17);
                    }
                }
            }
            return spannableStringBuilder;
        }
        return new SpannableStringBuilder(str);
    }

    public static View a(Context context, String str, double d) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_photo_watermark, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(2131372046);
        textView.setText(str);
        if (d > 1.0d) {
            textView.setTextSize(DensityUtils.c(context, (float) (textView.getTextSize() * d)));
            ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_logo);
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.width = (int) (layoutParams.width * d);
            layoutParams.height = (int) (layoutParams.height * d);
            imageView.setLayoutParams(layoutParams);
        }
        return inflate;
    }

    public static void a(Context context, int i, TextView textView, int i2) {
        if (textView != null) {
            textView.setText(context.getResources().getString(2131891593));
            if (i > 0) {
                Drawable drawable = context.getResources().getDrawable(i);
                if (i2 == 0) {
                    drawable.setBounds(0, 0, AppMethods.a(11), AppMethods.a(11));
                } else {
                    drawable.setBounds(0, 0, AppMethods.a(i2), AppMethods.a(i2));
                }
                textView.setCompoundDrawables(drawable, null, null, null);
                textView.setCompoundDrawablePadding(DensityUtils.a(context, 3.0f));
            }
        }
    }

    public static void a(Context context, TextView textView, int i, int i2) {
        a(context, textView, i, i2, 0);
    }

    public static void a(Context context, TextView textView, int i, int i2, int i3) {
        if (i != 1) {
            textView.setCompoundDrawables(null, null, null, null);
            return;
        }
        int i4 = -1;
        if (i2 == 1) {
            i4 = 2131233898;
        }
        a(context, i4, textView, i3);
    }

    @Deprecated
    public static void a(Context context, TextView textView, View.OnClickListener onClickListener, SpannIndex spannIndex, SpannIndex spannIndex2) {
        a(context, textView, onClickListener, spannIndex, spannIndex2, false);
    }

    @Deprecated
    public static void a(Context context, TextView textView, View.OnClickListener onClickListener, SpannIndex spannIndex, SpannIndex spannIndex2, boolean z) {
        a(context, textView, onClickListener, spannIndex, spannIndex2, z, 0);
    }

    @Deprecated
    public static void a(Context context, TextView textView, final View.OnClickListener onClickListener, SpannIndex spannIndex, SpannIndex spannIndex2, boolean z, int i) {
        if (textView == null || spannIndex == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(textView.getText());
        ClickUtils.RevoClickSpan revoWhiteClickSpan = z ? new ClickUtils.RevoWhiteClickSpan(context, i, new View.OnClickListener() { // from class: com.soft.blued.utils.TypefaceUtils.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                View.OnClickListener onClickListener2 = onClickListener;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(view);
                }
            }
        }) : new ClickUtils.RevoClickSpan(context, i, new View.OnClickListener() { // from class: com.soft.blued.utils.TypefaceUtils.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                View.OnClickListener onClickListener2 = onClickListener;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(view);
                }
            }
        });
        if (!a.V.equals(BlueAppLocal.c().getLanguage()) || spannIndex == null) {
            if (spannIndex2 != null && spannIndex2.f21106a < spannableStringBuilder.length() && spannIndex2.b <= spannableStringBuilder.length()) {
                spannableStringBuilder.setSpan(revoWhiteClickSpan, spannIndex2.f21106a, spannIndex2.b, 17);
            }
        } else if (spannIndex.f21106a < spannableStringBuilder.length() && spannIndex.b <= spannableStringBuilder.length()) {
            spannableStringBuilder.setSpan(revoWhiteClickSpan, spannIndex.f21106a, spannIndex.b, 17);
        }
        textView.setText(spannableStringBuilder);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static void a(Context context, TextView textView, String str, int i) {
        int indexOf;
        if (StringUtils.d(str) || textView == null) {
            return;
        }
        String lowerCase = textView.getText().toString().toLowerCase();
        String lowerCase2 = str.toLowerCase();
        if (!lowerCase.contains(lowerCase2)) {
            textView.setText(lowerCase);
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(lowerCase);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= lowerCase.length() - 1 || (indexOf = lowerCase.indexOf(lowerCase2, i3)) < 0) {
                break;
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i), indexOf, lowerCase2.length() + indexOf, 33);
            i2 = Math.max(i3 + 1, indexOf);
        }
        textView.setText(spannableStringBuilder);
    }

    public static void a(TextView textView, CharSequence charSequence, int i, ClickAtLinkListener clickAtLinkListener, boolean z, boolean z2, boolean z3, String str, int i2, boolean... zArr) {
        if (textView == null) {
            return;
        }
        if (TextUtils.isEmpty(((Object) charSequence) + "")) {
            textView.setText("");
            return;
        }
        CharSequence a2 = StringUtils.a(StringUtils.a(charSequence, (int) textView.getTextSize(), i), true, true, false, clickAtLinkListener, z2, "", str);
        CharSequence charSequence2 = a2;
        if (z) {
            charSequence2 = StringUtils.a(a2, z2, zArr);
        }
        textView.setText(charSequence2);
        if (z3) {
            textView.setMovementMethod(LinkMovementClickMethod.a());
        }
    }

    public static void a(TextView textView, CharSequence charSequence, int i, String str) {
        a(textView, charSequence, i, null, true, true, true, str, -1, new boolean[0]);
    }

    public static void a(TextView textView, CharSequence charSequence, boolean z, String str, int i, boolean... zArr) {
        a(textView, charSequence, 0, null, true, z, true, str, i, zArr);
    }

    public static void b(Context context, TextView textView, int i, int i2) {
        b(context, textView, i, i2, 0);
    }

    public static void b(Context context, TextView textView, int i, int i2, int i3) {
        if (i != 1) {
            textView.setCompoundDrawables(null, null, null, null);
            return;
        }
        int i4 = -1;
        if (i2 == 1) {
            i4 = 2131233178;
        }
        a(context, i4, textView, i3);
    }
}
