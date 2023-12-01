package com.autonavi.base.ae.gmap.glyph;

import java.text.BreakIterator;
import java.util.ArrayList;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/ae/gmap/glyph/GlyphBreakIterator.class */
public class GlyphBreakIterator {
    public static final int BREAK_BY_CHARACTER_SEQUENCES = 2;
    public static final int BREAK_BY_WORDS = 1;
    public ArrayList<Integer> breakResult = new ArrayList<>();
    public int mBreakMode;

    public GlyphBreakIterator(int i) {
        this.mBreakMode = i;
    }

    public int[] setText(String str) {
        BreakIterator breakIterator = null;
        if (str.isEmpty()) {
            return null;
        }
        if (!this.breakResult.isEmpty()) {
            this.breakResult.clear();
        }
        int i = this.mBreakMode;
        if (i == 1) {
            breakIterator = BreakIterator.getWordInstance();
        } else if (i == 2) {
            breakIterator = BreakIterator.getCharacterInstance();
        }
        breakIterator.setText(str);
        int first = breakIterator.first();
        while (true) {
            int i2 = first;
            int next = breakIterator.next();
            if (next == -1) {
                break;
            }
            this.breakResult.add(Integer.valueOf(i2));
            first = next;
        }
        this.breakResult.add(Integer.valueOf(str.length()));
        int size = this.breakResult.size();
        Integer[] numArr = new Integer[size];
        this.breakResult.toArray(numArr);
        int[] iArr = new int[size];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size) {
                return iArr;
            }
            iArr[i4] = numArr[i4].intValue();
            i3 = i4 + 1;
        }
    }
}
