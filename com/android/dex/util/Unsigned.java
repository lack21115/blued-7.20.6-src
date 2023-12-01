package com.android.dex.util;

import android.widget.ExpandableListView;

/* loaded from: source-2895416-dex2jar.jar:com/android/dex/util/Unsigned.class */
public final class Unsigned {
    private Unsigned() {
    }

    public static int compare(int i, int i2) {
        if (i == i2) {
            return 0;
        }
        return (((long) i) & ExpandableListView.PACKED_POSITION_VALUE_NULL) < (((long) i2) & ExpandableListView.PACKED_POSITION_VALUE_NULL) ? -1 : 1;
    }

    public static int compare(short s, short s2) {
        if (s == s2) {
            return 0;
        }
        return (s & 65535) < (s2 & 65535) ? -1 : 1;
    }
}
