package com.blued.android.module.common.widget.emoji.manager;

import android.content.Context;
import android.text.Spannable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoji/manager/EmojiHandler.class */
public final class EmojiHandler {
    private static EmojiHandler a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoji/manager/EmojiHandler$Range.class */
    public static final class Range {
        final int a;
        final int b;

        Range(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoji/manager/EmojiHandler$SpanRangeList.class */
    public static final class SpanRangeList {
        private final List<Range> a = new ArrayList();

        SpanRangeList(Spannable spannable) {
            EmojiSpan[] emojiSpanArr;
            for (EmojiSpan emojiSpan : (EmojiSpan[]) spannable.getSpans(0, spannable.length(), EmojiSpan.class)) {
                this.a.add(new Range(spannable.getSpanStart(emojiSpan), spannable.getSpanEnd(emojiSpan)));
            }
        }

        int a(int i) {
            for (Range range : this.a) {
                if (range.a == i) {
                    return range.b;
                }
            }
            return -1;
        }

        int b(int i) {
            for (Range range : this.a) {
                if (range.a > i) {
                    return range.a;
                }
            }
            return -1;
        }
    }

    private EmojiHandler() {
    }

    public static EmojiHandler a() {
        if (a == null) {
            a = new EmojiHandler();
        }
        return a;
    }

    public void a(Context context, Spannable spannable, int i, int i2, int i3, int i4, int i5, boolean z) {
        int i6;
        if (z) {
            return;
        }
        SpanRangeList spanRangeList = new SpanRangeList(spannable);
        EmojiManager a2 = EmojiManager.a();
        int i7 = i;
        while (true) {
            int i8 = i7;
            if (i8 >= i + i2) {
                return;
            }
            int a3 = spanRangeList.a(i8);
            if (a3 == -1) {
                int b = spanRangeList.b(i8);
                int i9 = b;
                if (b == -1) {
                    i9 = spannable.length();
                }
                Emoji a4 = a2.a(spannable.subSequence(i8, i9));
                if (a4 != null) {
                    spannable.setSpan(new EmojiconSpan(context, a4.b(), i3, i4, i5), i8, a4.d() + i8, 33);
                    i6 = a4.d();
                } else {
                    i7 = i8 + 1;
                }
            } else {
                i6 = a3 - i8;
            }
            i7 = i8 + i6;
        }
    }

    public void a(Context context, Spannable spannable, int i, int i2, int i3, boolean z) {
        a(context, spannable, 0, spannable.length(), i, i2, i3, z);
    }
}
