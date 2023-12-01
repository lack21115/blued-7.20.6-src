package java.lang;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: source-2895416-dex2jar.jar:java/lang/StringBuilder.class */
public final class StringBuilder extends AbstractStringBuilder implements Appendable, CharSequence, Serializable {
    private static final long serialVersionUID = 4383685877147921099L;

    public StringBuilder() {
    }

    public StringBuilder(int i) {
        super(i);
    }

    public StringBuilder(CharSequence charSequence) {
        super(charSequence.toString());
    }

    public StringBuilder(String str) {
        super(str);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        set((char[]) objectInputStream.readObject(), objectInputStream.readInt());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(length());
        objectOutputStream.writeObject(getValue());
    }

    @Override // java.lang.Appendable
    public StringBuilder append(char c) {
        append0(c);
        return this;
    }

    public StringBuilder append(double d) {
        RealToString.getInstance().appendDouble(this, d);
        return this;
    }

    public StringBuilder append(float f) {
        RealToString.getInstance().appendFloat(this, f);
        return this;
    }

    public StringBuilder append(int i) {
        IntegralToString.appendInt(this, i);
        return this;
    }

    public StringBuilder append(long j) {
        IntegralToString.appendLong(this, j);
        return this;
    }

    @Override // java.lang.Appendable
    public StringBuilder append(CharSequence charSequence) {
        if (charSequence == null) {
            appendNull();
            return this;
        }
        append0(charSequence, 0, charSequence.length());
        return this;
    }

    @Override // java.lang.Appendable
    public StringBuilder append(CharSequence charSequence, int i, int i2) {
        append0(charSequence, i, i2);
        return this;
    }

    public StringBuilder append(Object obj) {
        if (obj == null) {
            appendNull();
            return this;
        }
        append0(obj.toString());
        return this;
    }

    public StringBuilder append(String str) {
        append0(str);
        return this;
    }

    public StringBuilder append(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            appendNull();
            return this;
        }
        append0(stringBuffer.getValue(), 0, stringBuffer.length());
        return this;
    }

    public StringBuilder append(boolean z) {
        append0(z ? "true" : "false");
        return this;
    }

    public StringBuilder append(char[] cArr) {
        append0(cArr);
        return this;
    }

    public StringBuilder append(char[] cArr, int i, int i2) {
        append0(cArr, i, i2);
        return this;
    }

    public StringBuilder appendCodePoint(int i) {
        append0(Character.toChars(i));
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public /* bridge */ /* synthetic */ int capacity() {
        return super.capacity();
    }

    @Override // java.lang.AbstractStringBuilder, java.lang.CharSequence
    public /* bridge */ /* synthetic */ char charAt(int i) {
        return super.charAt(i);
    }

    @Override // java.lang.AbstractStringBuilder
    public /* bridge */ /* synthetic */ int codePointAt(int i) {
        return super.codePointAt(i);
    }

    @Override // java.lang.AbstractStringBuilder
    public /* bridge */ /* synthetic */ int codePointBefore(int i) {
        return super.codePointBefore(i);
    }

    @Override // java.lang.AbstractStringBuilder
    public /* bridge */ /* synthetic */ int codePointCount(int i, int i2) {
        return super.codePointCount(i, i2);
    }

    public StringBuilder delete(int i, int i2) {
        delete0(i, i2);
        return this;
    }

    public StringBuilder deleteCharAt(int i) {
        deleteCharAt0(i);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public /* bridge */ /* synthetic */ void ensureCapacity(int i) {
        super.ensureCapacity(i);
    }

    @Override // java.lang.AbstractStringBuilder
    public /* bridge */ /* synthetic */ void getChars(int i, int i2, char[] cArr, int i3) {
        super.getChars(i, i2, cArr, i3);
    }

    @Override // java.lang.AbstractStringBuilder
    public /* bridge */ /* synthetic */ int indexOf(String str) {
        return super.indexOf(str);
    }

    @Override // java.lang.AbstractStringBuilder
    public /* bridge */ /* synthetic */ int indexOf(String str, int i) {
        return super.indexOf(str, i);
    }

    public StringBuilder insert(int i, char c) {
        insert0(i, c);
        return this;
    }

    public StringBuilder insert(int i, double d) {
        insert0(i, Double.toString(d));
        return this;
    }

    public StringBuilder insert(int i, float f) {
        insert0(i, Float.toString(f));
        return this;
    }

    public StringBuilder insert(int i, int i2) {
        insert0(i, Integer.toString(i2));
        return this;
    }

    public StringBuilder insert(int i, long j) {
        insert0(i, Long.toString(j));
        return this;
    }

    public StringBuilder insert(int i, CharSequence charSequence) {
        insert0(i, charSequence == null ? "null" : charSequence.toString());
        return this;
    }

    public StringBuilder insert(int i, CharSequence charSequence, int i2, int i3) {
        insert0(i, charSequence, i2, i3);
        return this;
    }

    public StringBuilder insert(int i, Object obj) {
        insert0(i, obj == null ? "null" : obj.toString());
        return this;
    }

    public StringBuilder insert(int i, String str) {
        insert0(i, str);
        return this;
    }

    public StringBuilder insert(int i, boolean z) {
        insert0(i, z ? "true" : "false");
        return this;
    }

    public StringBuilder insert(int i, char[] cArr) {
        insert0(i, cArr);
        return this;
    }

    public StringBuilder insert(int i, char[] cArr, int i2, int i3) {
        insert0(i, cArr, i2, i3);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public /* bridge */ /* synthetic */ int lastIndexOf(String str) {
        return super.lastIndexOf(str);
    }

    @Override // java.lang.AbstractStringBuilder
    public /* bridge */ /* synthetic */ int lastIndexOf(String str, int i) {
        return super.lastIndexOf(str, i);
    }

    @Override // java.lang.AbstractStringBuilder, java.lang.CharSequence
    public /* bridge */ /* synthetic */ int length() {
        return super.length();
    }

    @Override // java.lang.AbstractStringBuilder
    public /* bridge */ /* synthetic */ int offsetByCodePoints(int i, int i2) {
        return super.offsetByCodePoints(i, i2);
    }

    public StringBuilder replace(int i, int i2, String str) {
        replace0(i, i2, str);
        return this;
    }

    public StringBuilder reverse() {
        reverse0();
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public /* bridge */ /* synthetic */ void setCharAt(int i, char c) {
        super.setCharAt(i, c);
    }

    @Override // java.lang.AbstractStringBuilder
    public /* bridge */ /* synthetic */ void setLength(int i) {
        super.setLength(i);
    }

    @Override // java.lang.AbstractStringBuilder, java.lang.CharSequence
    public /* bridge */ /* synthetic */ CharSequence subSequence(int i, int i2) {
        return super.subSequence(i, i2);
    }

    @Override // java.lang.AbstractStringBuilder
    public /* bridge */ /* synthetic */ String substring(int i) {
        return super.substring(i);
    }

    @Override // java.lang.AbstractStringBuilder
    public /* bridge */ /* synthetic */ String substring(int i, int i2) {
        return super.substring(i, i2);
    }

    @Override // java.lang.AbstractStringBuilder, java.lang.CharSequence
    public String toString() {
        return super.toString();
    }

    @Override // java.lang.AbstractStringBuilder
    public /* bridge */ /* synthetic */ void trimToSize() {
        super.trimToSize();
    }
}
