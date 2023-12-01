package com.blued.android.framework.ui.markdown.atuser;

import com.blued.android.chat.utils.AtRegExpUtils;
import java.util.regex.Pattern;
import org.commonmark.parser.delimiter.DelimiterProcessor;
import org.commonmark.parser.delimiter.DelimiterRun;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/markdown/atuser/AtUserProcessor.class */
public class AtUserProcessor implements DelimiterProcessor {
    public static final Pattern a = Pattern.compile(AtRegExpUtils.AT_USERNAME_PATTERN2);

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public char getClosingCharacter() {
        return ')';
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public int getDelimiterUse(DelimiterRun delimiterRun, DelimiterRun delimiterRun2) {
        return (delimiterRun.c() < 1 || delimiterRun2.c() < 1) ? 0 : 1;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public int getMinLength() {
        return 1;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public char getOpeningCharacter() {
        return '@';
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void process(org.commonmark.node.Text r6, org.commonmark.node.Text r7, int r8) {
        /*
            r5 = this;
            r0 = r6
            org.commonmark.node.Node r0 = r0.h()
            r11 = r0
            r0 = r11
            boolean r0 = r0 instanceof org.commonmark.node.Text
            if (r0 == 0) goto La9
            r0 = r11
            org.commonmark.node.Node r0 = r0.h()
            r1 = r7
            if (r0 != r1) goto La9
            r0 = r11
            org.commonmark.node.Text r0 = (org.commonmark.node.Text) r0
            java.lang.String r0 = r0.a()
            r9 = r0
            r0 = r9
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto La9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r10 = r0
            r0 = r10
            r1 = 64
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            r1 = r9
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            r1 = 41
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            java.lang.String r0 = r0.toString()
            r9 = r0
            java.util.regex.Pattern r0 = com.blued.android.framework.ui.markdown.atuser.AtUserProcessor.a
            r1 = r9
            java.util.regex.Matcher r0 = r0.matcher(r1)
            r9 = r0
            r0 = r9
            boolean r0 = r0.matches()
            if (r0 == 0) goto La9
            r0 = r9
            r1 = 1
            java.lang.String r0 = r0.group(r1)
            r12 = r0
            r0 = r9
            r1 = 2
            java.lang.String r0 = r0.group(r1)
            r10 = r0
            r0 = r10
            r9 = r0
            r0 = r10
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L86
            r0 = r10
            java.lang.String r0 = com.blued.android.framework.utils.HashidEncryptTool.a(r0)
            r9 = r0
        L86:
            r0 = r9
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto La9
            com.blued.android.framework.ui.markdown.atuser.AtUserNode r0 = new com.blued.android.framework.ui.markdown.atuser.AtUserNode
            r1 = r0
            r2 = r12
            r3 = r9
            r1.<init>(r2, r3)
            r9 = r0
            r0 = r6
            r1 = r9
            r0.d(r1)
            r0 = r11
            r0.l()
            goto Lac
        La9:
            r0 = 0
            r9 = r0
        Lac:
            r0 = r9
            if (r0 != 0) goto Lcb
            r0 = r6
            org.commonmark.node.Text r1 = new org.commonmark.node.Text
            r2 = r1
            java.lang.String r3 = "@"
            r2.<init>(r3)
            r0.d(r1)
            r0 = r7
            org.commonmark.node.Text r1 = new org.commonmark.node.Text
            r2 = r1
            java.lang.String r3 = ")"
            r2.<init>(r3)
            r0.d(r1)
        Lcb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.framework.ui.markdown.atuser.AtUserProcessor.process(org.commonmark.node.Text, org.commonmark.node.Text, int):void");
    }
}
