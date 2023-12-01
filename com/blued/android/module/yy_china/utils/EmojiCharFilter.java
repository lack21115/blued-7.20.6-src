package com.blued.android.module.yy_china.utils;

import android.text.InputFilter;
import android.text.Spanned;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/utils/EmojiCharFilter.class */
public class EmojiCharFilter implements InputFilter {
    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        while (i < i2) {
            if (!Character.isLetterOrDigit(charSequence.charAt(i)) && !Character.toString(charSequence.charAt(i)).equals(BridgeUtil.UNDERLINE_STR) && !Character.toString(charSequence.charAt(i)).equals("-")) {
                return "";
            }
            i++;
        }
        return null;
    }
}
