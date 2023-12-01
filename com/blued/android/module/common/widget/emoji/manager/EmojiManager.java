package com.blued.android.module.common.widget.emoji.manager;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoji/manager/EmojiManager.class */
public final class EmojiManager {
    private static final EmojiManager a = new EmojiManager();
    private final EmojiTree b = new EmojiTree();
    private EmojiCategory[] c;

    private EmojiManager() {
    }

    public static EmojiManager a() {
        return a;
    }

    public static void a(EmojiProvider emojiProvider) {
        a.c = emojiProvider.a();
        a.b.a();
        int i = 0;
        while (true) {
            int i2 = i;
            EmojiCategory[] emojiCategoryArr = a.c;
            if (i2 >= emojiCategoryArr.length) {
                return;
            }
            Emoji[] a2 = emojiCategoryArr[i2].a();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < a2.length) {
                    a.b.a(a2[i4]);
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Emoji a(CharSequence charSequence) {
        b();
        return this.b.a(charSequence);
    }

    public void b() {
        if (this.c != null) {
            return;
        }
        a(new IosEmojiProvider());
    }
}
