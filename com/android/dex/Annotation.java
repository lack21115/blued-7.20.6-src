package com.android.dex;

import com.android.dex.Dex;

/* loaded from: source-2895416-dex2jar.jar:com/android/dex/Annotation.class */
public final class Annotation implements Comparable<Annotation> {
    private final Dex dex;
    private final EncodedValue encodedAnnotation;
    private final byte visibility;

    public Annotation(Dex dex, byte b, EncodedValue encodedValue) {
        this.dex = dex;
        this.visibility = b;
        this.encodedAnnotation = encodedValue;
    }

    @Override // java.lang.Comparable
    public int compareTo(Annotation annotation) {
        return this.encodedAnnotation.compareTo(annotation.encodedAnnotation);
    }

    public EncodedValueReader getReader() {
        return new EncodedValueReader(this.encodedAnnotation, 29);
    }

    public int getTypeIndex() {
        EncodedValueReader reader = getReader();
        reader.readAnnotation();
        return reader.getAnnotationType();
    }

    public byte getVisibility() {
        return this.visibility;
    }

    public String toString() {
        return this.dex == null ? ((int) this.visibility) + " " + getTypeIndex() : ((int) this.visibility) + " " + this.dex.typeNames().get(getTypeIndex());
    }

    public void writeTo(Dex.Section section) {
        section.writeByte(this.visibility);
        this.encodedAnnotation.writeTo(section);
    }
}
