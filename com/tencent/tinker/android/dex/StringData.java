package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.TableOfContents;
import java.io.UTFDataFormatException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dex/StringData.class */
public class StringData extends TableOfContents.Section.Item<StringData> {
    public String value;

    public StringData(int i, String str) {
        super(i);
        this.value = str;
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int byteCountInDex() {
        try {
            return Leb128.unsignedLeb128Size(this.value.length()) + ((int) Mutf8.countBytes(this.value, false)) + 1;
        } catch (UTFDataFormatException e) {
            throw new DexException(e);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(StringData stringData) {
        return this.value.compareTo(stringData.value);
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof StringData) {
            if (compareTo((StringData) obj) == 0) {
                z = true;
            }
            return z;
        }
        return false;
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int hashCode() {
        return this.value.hashCode();
    }
}
