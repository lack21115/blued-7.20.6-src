package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.util.CompareUtils;
import com.tencent.tinker.android.dex.util.HashCodeHelper;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dex/Annotation.class */
public final class Annotation extends TableOfContents.Section.Item<Annotation> {
    public EncodedValue encodedAnnotation;
    public byte visibility;

    public Annotation(int i, byte b, EncodedValue encodedValue) {
        super(i);
        this.visibility = b;
        this.encodedAnnotation = encodedValue;
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int byteCountInDex() {
        return this.encodedAnnotation.byteCountInDex() + 1;
    }

    @Override // java.lang.Comparable
    public int compareTo(Annotation annotation) {
        int compareTo = this.encodedAnnotation.compareTo(annotation.encodedAnnotation);
        return compareTo != 0 ? compareTo : CompareUtils.uCompare(this.visibility, annotation.visibility);
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof Annotation) {
            if (compareTo((Annotation) obj) == 0) {
                z = true;
            }
            return z;
        }
        return false;
    }

    public EncodedValueReader getReader() {
        return new EncodedValueReader(this.encodedAnnotation, 29);
    }

    public int getTypeIndex() {
        EncodedValueReader reader = getReader();
        reader.readAnnotation();
        return reader.getAnnotationType();
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int hashCode() {
        return HashCodeHelper.hash(Byte.valueOf(this.visibility), this.encodedAnnotation);
    }
}
