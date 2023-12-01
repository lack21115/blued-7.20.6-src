package com.google.android.util;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import com.google.android.util.AbstractMessageParser;
import java.util.ArrayList;

/* loaded from: source-4181928-dex2jar.jar:com/google/android/util/SmileyParser.class */
public class SmileyParser extends AbstractMessageParser {
    private SmileyResources mRes;

    public SmileyParser(String str, SmileyResources smileyResources) {
        super(str, true, false, false, false, false, false);
        this.mRes = smileyResources;
    }

    @Override // com.google.android.util.AbstractMessageParser
    protected AbstractMessageParser.Resources getResources() {
        return this.mRes;
    }

    public CharSequence getSpannableString(Context context) {
        SpannableStringBuilder spannableStringBuilder;
        int smileyRes;
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        if (getPartCount() != 0) {
            ArrayList<AbstractMessageParser.Token> tokens = getPart(0).getTokens();
            int size = tokens.size();
            int i = 0;
            while (true) {
                int i2 = i;
                spannableStringBuilder = spannableStringBuilder2;
                if (i2 >= size) {
                    break;
                }
                AbstractMessageParser.Token token = tokens.get(i2);
                int length = spannableStringBuilder2.length();
                spannableStringBuilder2.append((CharSequence) token.getRawText());
                if (token.getType() == AbstractMessageParser.Token.Type.SMILEY && (smileyRes = this.mRes.getSmileyRes(token.getRawText())) != -1) {
                    spannableStringBuilder2.setSpan(new ImageSpan(context, smileyRes), length, spannableStringBuilder2.length(), 33);
                }
                i = i2 + 1;
            }
        } else {
            spannableStringBuilder = "";
        }
        return spannableStringBuilder;
    }
}
