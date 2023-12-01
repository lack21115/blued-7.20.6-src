package com.blued.community.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.manager.CommunityConstants;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.view.SelectionEditText;
import com.blued.community.view.VerticalCenterImageSpan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/utils/MarkDownLinkHelper.class */
public class MarkDownLinkHelper {

    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/utils/MarkDownLinkHelper$MDLinkForegroundColorSpan.class */
    public static class MDLinkForegroundColorSpan extends ForegroundColorSpan {

        /* renamed from: a  reason: collision with root package name */
        public String f20472a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public String f20473c;

        public MDLinkForegroundColorSpan(int i) {
            super(i);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/utils/MarkDownLinkHelper$MDLinkOnClickListener.class */
    public interface MDLinkOnClickListener {
        void a(String str);
    }

    public static Editable a(Editable editable) {
        MDLinkForegroundColorSpan[] mDLinkForegroundColorSpanArr;
        if (TextUtils.isEmpty(editable)) {
            return editable;
        }
        if (editable instanceof SpannableStringBuilder) {
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) editable;
            for (MDLinkForegroundColorSpan mDLinkForegroundColorSpan : (MDLinkForegroundColorSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), MDLinkForegroundColorSpan.class)) {
                editable.replace(spannableStringBuilder.getSpanStart(mDLinkForegroundColorSpan), spannableStringBuilder.getSpanEnd(mDLinkForegroundColorSpan), mDLinkForegroundColorSpan.f20473c);
            }
        }
        return editable;
    }

    public static CharSequence a(Context context, CharSequence charSequence) {
        return a(context, charSequence, false, 0, false, (MDLinkOnClickListener) null);
    }

    public static CharSequence a(Context context, CharSequence charSequence, boolean z, int i) {
        return a(context, charSequence, z, i, false, (MDLinkOnClickListener) null);
    }

    public static CharSequence a(final Context context, CharSequence charSequence, boolean z, final int i, boolean z2, final MDLinkOnClickListener mDLinkOnClickListener) {
        if (TextUtils.isEmpty(charSequence)) {
            return charSequence;
        }
        SpannableStringBuilder spannableStringBuilder = null;
        Matcher matcher = Pattern.compile("\\[([\\s\\S]*?)\\]\\(([\\s\\S]*?)\\)").matcher(charSequence);
        int i2 = 0;
        while (matcher.find()) {
            SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
            if (spannableStringBuilder == null) {
                spannableStringBuilder2 = new SpannableStringBuilder();
            }
            String group = matcher.group(1);
            final String group2 = matcher.group(2);
            if (TextUtils.isEmpty(group) || TextUtils.isEmpty(group2)) {
                spannableStringBuilder = spannableStringBuilder2;
            } else {
                spannableStringBuilder2.append(charSequence.subSequence(i2, matcher.start()));
                if (("Lottery1".equalsIgnoreCase(group) || "Lottery2".equalsIgnoreCase(group)) && !charSequence.toString().startsWith("[Lottery")) {
                    spannableStringBuilder2.append((CharSequence) " ");
                }
                int length = spannableStringBuilder2.length();
                int length2 = group.length() + length;
                spannableStringBuilder2.append((CharSequence) group);
                if ("Lottery1".equalsIgnoreCase(group) || "Lottery2".equalsIgnoreCase(group)) {
                    spannableStringBuilder2.append((CharSequence) " ");
                    int c2 = FeedMethods.c(74);
                    int c3 = FeedMethods.c(20);
                    int i3 = R.drawable.feed_subject_image_span_1;
                    if ("Lottery2".equalsIgnoreCase(group)) {
                        i3 = R.drawable.feed_subject_image_span_2;
                        c2 = FeedMethods.c(78);
                        c3 = FeedMethods.c(18);
                    }
                    Drawable drawable = context.getResources().getDrawable(i3);
                    drawable.setBounds(0, 0, c2, c3);
                    spannableStringBuilder2.setSpan(new VerticalCenterImageSpan(drawable, 2), length, length2, 33);
                } else if (z) {
                    MDLinkForegroundColorSpan mDLinkForegroundColorSpan = new MDLinkForegroundColorSpan(BluedSkinUtils.a(context, i));
                    mDLinkForegroundColorSpan.f20472a = group;
                    mDLinkForegroundColorSpan.b = group2;
                    mDLinkForegroundColorSpan.f20473c = matcher.group();
                    spannableStringBuilder2.setSpan(mDLinkForegroundColorSpan, length, length2, 33);
                }
                if (z2) {
                    spannableStringBuilder2.setSpan(new ClickableSpan() { // from class: com.blued.community.utils.MarkDownLinkHelper.1
                        @Override // android.text.style.ClickableSpan
                        public void onClick(View view) {
                            Selection.removeSelection((Spannable) ((TextView) view).getText());
                            MDLinkOnClickListener mDLinkOnClickListener2 = MDLinkOnClickListener.this;
                            if (mDLinkOnClickListener2 != null) {
                                mDLinkOnClickListener2.a(group2);
                            } else {
                                CommunityServiceManager.b().a(context, group2, CommunityConstants.WebShowType.DEFAULT);
                            }
                        }

                        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                        public void updateDrawState(TextPaint textPaint) {
                            super.updateDrawState(textPaint);
                            textPaint.setColor(BluedSkinUtils.a(context, i));
                            textPaint.setUnderlineText(false);
                            textPaint.setFakeBoldText(false);
                        }
                    }, length, length2, 33);
                }
                i2 = matcher.end();
                spannableStringBuilder = spannableStringBuilder2;
            }
        }
        if (spannableStringBuilder != null && i2 < charSequence.length()) {
            spannableStringBuilder.append(charSequence.subSequence(i2, charSequence.length()));
        }
        return spannableStringBuilder != null ? spannableStringBuilder : charSequence;
    }

    public static void a(final SelectionEditText selectionEditText) {
        if (selectionEditText == null) {
            return;
        }
        selectionEditText.setOnSelectionChangeListener(new SelectionEditText.OnSelectionChangeListener() { // from class: com.blued.community.utils.MarkDownLinkHelper.2
            @Override // com.blued.community.view.SelectionEditText.OnSelectionChangeListener
            public void onSelectionChange(int i, int i2) {
                int i3;
                boolean z;
                Editable text = SelectionEditText.this.getText();
                if (text instanceof SpannableStringBuilder) {
                    SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) text;
                    MDLinkForegroundColorSpan[] mDLinkForegroundColorSpanArr = (MDLinkForegroundColorSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), MDLinkForegroundColorSpan.class);
                    int length = mDLinkForegroundColorSpanArr.length;
                    int i4 = i2;
                    int i5 = 0;
                    while (i5 < length) {
                        MDLinkForegroundColorSpan mDLinkForegroundColorSpan = mDLinkForegroundColorSpanArr[i5];
                        int spanStart = spannableStringBuilder.getSpanStart(mDLinkForegroundColorSpan);
                        int spanEnd = spannableStringBuilder.getSpanEnd(mDLinkForegroundColorSpan);
                        if (i <= spanStart || i >= spanEnd) {
                            i3 = i;
                            z = false;
                        } else {
                            i3 = spanStart;
                            z = true;
                        }
                        if (i4 < spanEnd && i4 > spanStart) {
                            i4 = spanEnd;
                            z = true;
                        }
                        if (z) {
                            SelectionEditText.this.setSelection(i3, i4);
                        }
                        i5++;
                        i = i3;
                    }
                }
            }
        });
    }

    public static boolean a(Spannable spannable) {
        if (TextUtils.isEmpty(spannable)) {
            return false;
        }
        MDLinkForegroundColorSpan[] mDLinkForegroundColorSpanArr = (MDLinkForegroundColorSpan[]) spannable.getSpans(0, spannable.length(), MDLinkForegroundColorSpan.class);
        boolean z = false;
        if (mDLinkForegroundColorSpanArr != null) {
            z = false;
            if (mDLinkForegroundColorSpanArr.length > 0) {
                z = true;
            }
        }
        return z;
    }

    public static boolean a(EditText editText, CharSequence charSequence, CharSequence charSequence2, Editable editable, int i, int i2) {
        boolean z;
        if (editText == null || TextUtils.isEmpty(charSequence2) || TextUtils.isEmpty(charSequence) || !(charSequence2 instanceof SpannableStringBuilder) || !(charSequence instanceof SpannableStringBuilder) || charSequence2.length() >= charSequence.length()) {
            return false;
        }
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) charSequence;
        MDLinkForegroundColorSpan[] mDLinkForegroundColorSpanArr = (MDLinkForegroundColorSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), MDLinkForegroundColorSpan.class);
        int length = mDLinkForegroundColorSpanArr.length;
        int i3 = 0;
        boolean z2 = false;
        while (true) {
            boolean z3 = z2;
            if (i3 >= length) {
                return z3;
            }
            MDLinkForegroundColorSpan mDLinkForegroundColorSpan = mDLinkForegroundColorSpanArr[i3];
            int spanStart = spannableStringBuilder.getSpanStart(mDLinkForegroundColorSpan);
            int spanEnd = spannableStringBuilder.getSpanEnd(mDLinkForegroundColorSpan);
            if (i == i2 && i2 == spanEnd) {
                editText.setText(charSequence);
                editText.setSelection(spanStart, spanEnd);
                z = z3;
            } else if (i <= spanStart && i2 >= spanEnd) {
                return false;
            } else {
                if (i > spanStart || i2 <= spanStart) {
                    z = z3;
                    if (i < spanEnd) {
                        z = z3;
                        if (i2 >= spanEnd) {
                            editable.delete(spanStart, i);
                        }
                    }
                } else {
                    editable.delete(i, spanEnd - i2);
                }
                z = true;
            }
            if (z) {
                spannableStringBuilder.removeSpan(mDLinkForegroundColorSpan);
            }
            i3++;
            z2 = z;
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Matcher matcher = Pattern.compile("\\[([\\s\\S]*?)\\]\\(([\\s\\S]*?)\\)").matcher(str);
        while (matcher.find()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            if (!TextUtils.isEmpty(group) && !TextUtils.isEmpty(group2) && ("Lottery1".equalsIgnoreCase(group) || "Lottery2".equalsIgnoreCase(group))) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Matcher matcher = Pattern.compile("\\[([\\s\\S]*?)\\]\\(([\\s\\S]*?)\\)").matcher(str);
        while (matcher.find()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            if (!TextUtils.isEmpty(group) && !TextUtils.isEmpty(group2)) {
                return true;
            }
        }
        return false;
    }
}
