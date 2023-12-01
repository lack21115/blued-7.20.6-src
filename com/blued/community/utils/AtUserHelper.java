package com.blued.community.utils;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pair;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.community.R;
import com.blued.community.view.SelectionEditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/utils/AtUserHelper.class */
public class AtUserHelper {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f20449a = Pattern.compile("[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+");
    private static final Pattern b = Pattern.compile("@([^\\s`~\\!@#\\$%\\^&\\*\\(\\)\\+=\\|'\\:;'\\,\\[\\]\\.\\<\\>/\\?！@#￥%……（）——\\{\\}【】‘；：”“’。，、？]+)");

    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/utils/AtUserHelper$AtUserForegroundColorSpan.class */
    public static class AtUserForegroundColorSpan extends ForegroundColorSpan {

        /* renamed from: a  reason: collision with root package name */
        public String f20455a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public String f20456c;

        public AtUserForegroundColorSpan(int i) {
            super(i);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/utils/AtUserHelper$AtUserLinkOnClickListener.class */
    public interface AtUserLinkOnClickListener {
        void onClick(String str, String str2);
    }

    public static Editable a(Editable editable) {
        AtUserForegroundColorSpan[] atUserForegroundColorSpanArr;
        if (TextUtils.isEmpty(editable)) {
            return editable;
        }
        if (editable instanceof SpannableStringBuilder) {
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) editable;
            for (AtUserForegroundColorSpan atUserForegroundColorSpan : (AtUserForegroundColorSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), AtUserForegroundColorSpan.class)) {
                editable.replace(spannableStringBuilder.getSpanStart(atUserForegroundColorSpan), spannableStringBuilder.getSpanEnd(atUserForegroundColorSpan), atUserForegroundColorSpan.f20456c);
            }
        }
        return editable;
    }

    public static CharSequence a(CharSequence charSequence, int i) {
        return a(charSequence, i, (AtUserLinkOnClickListener) null);
    }

    public static CharSequence a(CharSequence charSequence, final int i, final AtUserLinkOnClickListener atUserLinkOnClickListener) {
        if (TextUtils.isEmpty(charSequence)) {
            return charSequence;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        Matcher matcher = Pattern.compile("@\\(name:([\\s\\S]*?),id:([A-Za-z0-9]+)\\)").matcher(charSequence);
        boolean z = false;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (!matcher.find()) {
                break;
            }
            final String group = matcher.group(1);
            final String group2 = matcher.group(2);
            int i4 = i3;
            if (!TextUtils.isEmpty(group)) {
                if (TextUtils.isEmpty(group2)) {
                    i4 = i3;
                } else {
                    String str = "@" + group + "";
                    int start = matcher.start() - i3;
                    int length = str.length() + start;
                    spannableStringBuilder.replace(matcher.start() - i3, matcher.end() - i3, (CharSequence) str);
                    int end = i3 + ((matcher.end() - matcher.start()) - str.length());
                    if (i != 0) {
                        AtUserForegroundColorSpan atUserForegroundColorSpan = new AtUserForegroundColorSpan(i);
                        atUserForegroundColorSpan.f20455a = group;
                        atUserForegroundColorSpan.b = group2;
                        atUserForegroundColorSpan.f20456c = matcher.group();
                        spannableStringBuilder.setSpan(atUserForegroundColorSpan, start, length, 33);
                    }
                    i4 = end;
                    if (atUserLinkOnClickListener != null) {
                        spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.blued.community.utils.AtUserHelper.1
                            @Override // android.text.style.ClickableSpan
                            public void onClick(View view) {
                                Selection.removeSelection((Spannable) ((TextView) view).getText());
                                String str2 = String.this;
                                String str3 = str2;
                                if (!TextUtils.isEmpty(str2)) {
                                    str3 = EncryptTool.a(String.this);
                                }
                                atUserLinkOnClickListener.onClick(str3, group);
                            }

                            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                            public void updateDrawState(TextPaint textPaint) {
                                super.updateDrawState(textPaint);
                                textPaint.setColor(i);
                                textPaint.setUnderlineText(false);
                                textPaint.setFakeBoldText(false);
                            }
                        }, start, length, 33);
                        i4 = end;
                    }
                }
            }
            z = true;
            i2 = i4;
        }
        return z ? spannableStringBuilder : b(charSequence, i, atUserLinkOnClickListener);
    }

    public static void a(EditText editText, String str, String str2, TextWatcher textWatcher, int i) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        editText.removeTextChangedListener(textWatcher);
        int length = editText.length();
        int selectionEnd = editText.getSelectionEnd();
        editText.getText().replace(selectionEnd - 1, selectionEnd, "@(name:" + str + ",id:" + str2 + ")");
        editText.setText(a(editText.getText(), i));
        editText.setSelection((editText.length() - length) + selectionEnd);
        editText.addTextChangedListener(textWatcher);
    }

    public static void a(final SelectionEditText selectionEditText) {
        if (selectionEditText == null) {
            return;
        }
        selectionEditText.addOnSelectionChangeListener(new SelectionEditText.OnSelectionChangeListener() { // from class: com.blued.community.utils.AtUserHelper.3
            @Override // com.blued.community.view.SelectionEditText.OnSelectionChangeListener
            public void onSelectionChange(int i, int i2) {
                int i3;
                boolean z;
                Editable text = SelectionEditText.this.getText();
                if (text instanceof SpannableStringBuilder) {
                    SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) text;
                    AtUserForegroundColorSpan[] atUserForegroundColorSpanArr = (AtUserForegroundColorSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), AtUserForegroundColorSpan.class);
                    int length = atUserForegroundColorSpanArr.length;
                    int i4 = i2;
                    int i5 = 0;
                    while (i5 < length) {
                        AtUserForegroundColorSpan atUserForegroundColorSpan = atUserForegroundColorSpanArr[i5];
                        int spanStart = spannableStringBuilder.getSpanStart(atUserForegroundColorSpan);
                        int spanEnd = spannableStringBuilder.getSpanEnd(atUserForegroundColorSpan);
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

    public static boolean a(EditText editText, CharSequence charSequence, CharSequence charSequence2, Editable editable, int i, int i2) {
        boolean z;
        if (editText == null || TextUtils.isEmpty(charSequence2) || TextUtils.isEmpty(charSequence) || !(charSequence2 instanceof SpannableStringBuilder) || !(charSequence instanceof SpannableStringBuilder) || charSequence2.length() >= charSequence.length()) {
            return false;
        }
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) charSequence;
        AtUserForegroundColorSpan[] atUserForegroundColorSpanArr = (AtUserForegroundColorSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), AtUserForegroundColorSpan.class);
        int length = atUserForegroundColorSpanArr.length;
        int i3 = 0;
        boolean z2 = false;
        while (true) {
            boolean z3 = z2;
            if (i3 >= length) {
                return z3;
            }
            AtUserForegroundColorSpan atUserForegroundColorSpan = atUserForegroundColorSpanArr[i3];
            int spanStart = spannableStringBuilder.getSpanStart(atUserForegroundColorSpan);
            int spanEnd = spannableStringBuilder.getSpanEnd(atUserForegroundColorSpan);
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
                spannableStringBuilder.removeSpan(atUserForegroundColorSpan);
            }
            i3++;
            z2 = z;
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Matcher matcher = Pattern.compile("@\\(name:([\\s\\S]*?),id:([A-Za-z0-9]+)\\)").matcher(str);
        while (matcher.find()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            if (!TextUtils.isEmpty(group) && !TextUtils.isEmpty(group2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(String str, String str2, int i) {
        int i2;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return (TextUtils.isEmpty(str) || str2.length() > str.length()) && str2.length() >= 1 && (i2 = i - 1) >= 0 && str2.subSequence(i2, i).equals("@");
    }

    public static CharSequence b(CharSequence charSequence, final int i, final AtUserLinkOnClickListener atUserLinkOnClickListener) {
        ArrayList arrayList;
        boolean z;
        if (TextUtils.isEmpty(charSequence)) {
            return charSequence;
        }
        Matcher matcher = f20449a.matcher(charSequence);
        ArrayList arrayList2 = null;
        while (true) {
            arrayList = arrayList2;
            if (!matcher.find()) {
                break;
            }
            ArrayList arrayList3 = arrayList;
            if (arrayList == null) {
                arrayList3 = new ArrayList();
            }
            arrayList3.add(new Pair(Integer.valueOf(matcher.start()), Integer.valueOf(matcher.end())));
            arrayList2 = arrayList3;
        }
        Matcher matcher2 = b.matcher(charSequence);
        SpannableStringBuilder spannableStringBuilder = null;
        while (matcher2.find()) {
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (true) {
                    z = false;
                    if (!it.hasNext()) {
                        break;
                    }
                    Pair pair = (Pair) it.next();
                    if (matcher2.start() >= ((Integer) pair.first).intValue() && matcher2.end() <= ((Integer) pair.second).intValue()) {
                        it.remove();
                        z = true;
                        break;
                    } else if (matcher2.start() > ((Integer) pair.second).intValue()) {
                        it.remove();
                    }
                }
                if (z) {
                }
            }
            final String group = matcher2.group(1);
            SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
            if (spannableStringBuilder == null) {
                spannableStringBuilder2 = new SpannableStringBuilder(charSequence);
            }
            spannableStringBuilder = spannableStringBuilder2;
            if (atUserLinkOnClickListener != null) {
                if (!TextUtils.isEmpty(group) && group.equals(UserInfo.getInstance().getLoginUserInfo().name)) {
                    spannableStringBuilder2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(AppInfo.d(), R.color.syc_m)), matcher2.start(), matcher2.end(), 33);
                }
                spannableStringBuilder2.setSpan(new ClickableSpan() { // from class: com.blued.community.utils.AtUserHelper.2
                    @Override // android.text.style.ClickableSpan
                    public void onClick(View view) {
                        AtUserLinkOnClickListener.this.onClick(null, group);
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        int i2 = i;
                        if (i2 != 0) {
                            textPaint.setColor(i2);
                        }
                        textPaint.setUnderlineText(false);
                        textPaint.setFakeBoldText(false);
                        textPaint.clearShadowLayer();
                    }
                }, matcher2.start(), matcher2.end(), 33);
                spannableStringBuilder = spannableStringBuilder2;
            }
        }
        return spannableStringBuilder != null ? spannableStringBuilder : charSequence;
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str) && str.indexOf(64) >= 0;
    }
}
