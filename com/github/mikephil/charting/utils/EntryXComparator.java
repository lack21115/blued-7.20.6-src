package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.data.Entry;
import java.util.Comparator;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/utils/EntryXComparator.class */
public class EntryXComparator implements Comparator<Entry> {
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(Entry entry, Entry entry2) {
        int i = ((entry.i() - entry2.i()) > 0.0f ? 1 : ((entry.i() - entry2.i()) == 0.0f ? 0 : -1));
        if (i == 0) {
            return 0;
        }
        return i > 0 ? 1 : -1;
    }
}
