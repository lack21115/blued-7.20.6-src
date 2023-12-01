package com.blued.android.module.common.widget.emoji.manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoji/manager/Emoji.class */
public final class Emoji implements Serializable {
    private static final long serialVersionUID = 3;
    private final String a;
    private int b;
    private List<Emoji> c;
    private Emoji d;

    public Emoji(int i, int i2) {
        this(i, i2, new Emoji[0]);
    }

    public Emoji(int i, int i2, Emoji... emojiArr) {
        this(new int[]{i}, i2, emojiArr);
    }

    public Emoji(int[] iArr, int i) {
        this(iArr, i, new Emoji[0]);
    }

    public Emoji(int[] iArr, int i, Emoji... emojiArr) {
        this.a = new String(iArr, 0, iArr.length);
        this.b = i;
        this.c = Arrays.asList(emojiArr);
        int length = emojiArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            emojiArr[i3].d = this;
            i2 = i3 + 1;
        }
    }

    public String a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public List<Emoji> c() {
        return new ArrayList(this.c);
    }

    public int d() {
        return this.a.length();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Emoji emoji = (Emoji) obj;
        return this.b == emoji.b && this.a.equals(emoji.a) && this.c.equals(emoji.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode();
    }
}
