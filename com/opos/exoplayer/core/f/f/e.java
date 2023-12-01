package com.opos.exoplayer.core.f.f;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.tencent.qcloud.core.util.IOUtils;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/f/e.class */
final class e {
    public static b a(b bVar, String[] strArr, Map<String, b> map) {
        b bVar2;
        if (bVar == null && strArr == null) {
            return null;
        }
        int i = 0;
        if (bVar == null && strArr.length == 1) {
            return map.get(strArr[0]);
        }
        if (bVar == null && strArr.length > 1) {
            b bVar3 = new b();
            int length = strArr.length;
            while (true) {
                bVar2 = bVar3;
                if (i >= length) {
                    break;
                }
                bVar3.a(map.get(strArr[i]));
                i++;
            }
        } else if (bVar != null && strArr != null && strArr.length == 1) {
            return bVar.a(map.get(strArr[0]));
        } else {
            bVar2 = bVar;
            if (bVar != null) {
                bVar2 = bVar;
                if (strArr != null) {
                    bVar2 = bVar;
                    if (strArr.length > 1) {
                        int length2 = strArr.length;
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            bVar2 = bVar;
                            if (i3 >= length2) {
                                break;
                            }
                            bVar.a(map.get(strArr[i3]));
                            i2 = i3 + 1;
                        }
                    }
                }
            }
        }
        return bVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        return str.replaceAll(IOUtils.LINE_SEPARATOR_WINDOWS, "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(SpannableStringBuilder spannableStringBuilder) {
        int i;
        int length = spannableStringBuilder.length();
        while (true) {
            i = length - 1;
            if (i < 0 || spannableStringBuilder.charAt(i) != ' ') {
                break;
            }
            length = i;
        }
        if (i < 0 || spannableStringBuilder.charAt(i) == '\n') {
            return;
        }
        spannableStringBuilder.append('\n');
    }

    public static void a(SpannableStringBuilder spannableStringBuilder, int i, int i2, b bVar) {
        RelativeSizeSpan absoluteSizeSpan;
        if (bVar.a() != -1) {
            spannableStringBuilder.setSpan(new StyleSpan(bVar.a()), i, i2, 33);
        }
        if (bVar.b()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i, i2, 33);
        }
        if (bVar.c()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
        }
        if (bVar.f()) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(bVar.e()), i, i2, 33);
        }
        if (bVar.h()) {
            spannableStringBuilder.setSpan(new BackgroundColorSpan(bVar.g()), i, i2, 33);
        }
        if (bVar.d() != null) {
            spannableStringBuilder.setSpan(new TypefaceSpan(bVar.d()), i, i2, 33);
        }
        if (bVar.j() != null) {
            spannableStringBuilder.setSpan(new AlignmentSpan.Standard(bVar.j()), i, i2, 33);
        }
        int k = bVar.k();
        if (k == 1) {
            absoluteSizeSpan = new AbsoluteSizeSpan((int) bVar.l(), true);
        } else if (k == 2) {
            absoluteSizeSpan = new RelativeSizeSpan(bVar.l());
        } else if (k != 3) {
            return;
        } else {
            absoluteSizeSpan = new RelativeSizeSpan(bVar.l() / 100.0f);
        }
        spannableStringBuilder.setSpan(absoluteSizeSpan, i, i2, 33);
    }
}
