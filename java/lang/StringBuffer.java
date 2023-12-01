package java.lang;

import com.igexin.push.core.b;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;

/* loaded from: source-2895416-dex2jar.jar:java/lang/StringBuffer.class */
public final class StringBuffer extends AbstractStringBuilder implements Appendable, Serializable, CharSequence {
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("count", Integer.TYPE), new ObjectStreamField("shared", Boolean.TYPE), new ObjectStreamField("value", char[].class)};
    private static final long serialVersionUID = 3388685877147921107L;

    public StringBuffer() {
    }

    public StringBuffer(int i) {
        super(i);
    }

    public StringBuffer(CharSequence charSequence) {
        super(charSequence.toString());
    }

    public StringBuffer(String str) {
        super(str);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField readFields = objectInputStream.readFields();
        set((char[]) readFields.get("value", (Object) null), readFields.get("count", 0));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this) {
            ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
            putFields.put("count", length());
            putFields.put("shared", false);
            putFields.put("value", getValue());
            objectOutputStream.writeFields();
        }
    }

    @Override // java.lang.Appendable
    public StringBuffer append(char c2) {
        synchronized (this) {
            append0(c2);
        }
        return this;
    }

    public StringBuffer append(double d) {
        RealToString.getInstance().appendDouble(this, d);
        return this;
    }

    public StringBuffer append(float f) {
        RealToString.getInstance().appendFloat(this, f);
        return this;
    }

    public StringBuffer append(int i) {
        IntegralToString.appendInt(this, i);
        return this;
    }

    public StringBuffer append(long j) {
        IntegralToString.appendLong(this, j);
        return this;
    }

    @Override // java.lang.Appendable
    public StringBuffer append(CharSequence charSequence) {
        synchronized (this) {
            if (charSequence == null) {
                appendNull();
            } else {
                append0(charSequence, 0, charSequence.length());
            }
        }
        return this;
    }

    @Override // java.lang.Appendable
    public StringBuffer append(CharSequence charSequence, int i, int i2) {
        synchronized (this) {
            append0(charSequence, i, i2);
        }
        return this;
    }

    public StringBuffer append(Object obj) {
        synchronized (this) {
            if (obj == null) {
                appendNull();
            } else {
                append0(obj.toString());
            }
        }
        return this;
    }

    public StringBuffer append(String str) {
        synchronized (this) {
            append0(str);
        }
        return this;
    }

    public StringBuffer append(StringBuffer stringBuffer) {
        synchronized (this) {
            if (stringBuffer == null) {
                appendNull();
            } else {
                synchronized (stringBuffer) {
                    append0(stringBuffer.getValue(), 0, stringBuffer.length());
                }
            }
        }
        return this;
    }

    public StringBuffer append(boolean z) {
        return append(z ? "true" : "false");
    }

    public StringBuffer append(char[] cArr) {
        synchronized (this) {
            append0(cArr);
        }
        return this;
    }

    public StringBuffer append(char[] cArr, int i, int i2) {
        synchronized (this) {
            append0(cArr, i, i2);
        }
        return this;
    }

    public StringBuffer appendCodePoint(int i) {
        return append(Character.toChars(i));
    }

    @Override // java.lang.AbstractStringBuilder
    public /* bridge */ /* synthetic */ int capacity() {
        return super.capacity();
    }

    @Override // java.lang.AbstractStringBuilder, java.lang.CharSequence
    public char charAt(int i) {
        char charAt;
        synchronized (this) {
            charAt = super.charAt(i);
        }
        return charAt;
    }

    @Override // java.lang.AbstractStringBuilder
    public int codePointAt(int i) {
        int codePointAt;
        synchronized (this) {
            codePointAt = super.codePointAt(i);
        }
        return codePointAt;
    }

    @Override // java.lang.AbstractStringBuilder
    public int codePointBefore(int i) {
        int codePointBefore;
        synchronized (this) {
            codePointBefore = super.codePointBefore(i);
        }
        return codePointBefore;
    }

    @Override // java.lang.AbstractStringBuilder
    public int codePointCount(int i, int i2) {
        int codePointCount;
        synchronized (this) {
            codePointCount = super.codePointCount(i, i2);
        }
        return codePointCount;
    }

    public StringBuffer delete(int i, int i2) {
        synchronized (this) {
            delete0(i, i2);
        }
        return this;
    }

    public StringBuffer deleteCharAt(int i) {
        synchronized (this) {
            deleteCharAt0(i);
        }
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public void ensureCapacity(int i) {
        synchronized (this) {
            super.ensureCapacity(i);
        }
    }

    @Override // java.lang.AbstractStringBuilder
    public void getChars(int i, int i2, char[] cArr, int i3) {
        synchronized (this) {
            super.getChars(i, i2, cArr, i3);
        }
    }

    @Override // java.lang.AbstractStringBuilder
    public /* bridge */ /* synthetic */ int indexOf(String str) {
        return super.indexOf(str);
    }

    @Override // java.lang.AbstractStringBuilder
    public int indexOf(String str, int i) {
        int indexOf;
        synchronized (this) {
            indexOf = super.indexOf(str, i);
        }
        return indexOf;
    }

    public StringBuffer insert(int i, char c2) {
        synchronized (this) {
            insert0(i, c2);
        }
        return this;
    }

    public StringBuffer insert(int i, double d) {
        return insert(i, Double.toString(d));
    }

    public StringBuffer insert(int i, float f) {
        return insert(i, Float.toString(f));
    }

    public StringBuffer insert(int i, int i2) {
        return insert(i, Integer.toString(i2));
    }

    public StringBuffer insert(int i, long j) {
        return insert(i, Long.toString(j));
    }

    public StringBuffer insert(int i, CharSequence charSequence) {
        synchronized (this) {
            insert0(i, charSequence == null ? b.l : charSequence.toString());
        }
        return this;
    }

    public StringBuffer insert(int i, CharSequence charSequence, int i2, int i3) {
        synchronized (this) {
            insert0(i, charSequence, i2, i3);
        }
        return this;
    }

    public StringBuffer insert(int i, Object obj) {
        return insert(i, obj == null ? b.l : obj.toString());
    }

    public StringBuffer insert(int i, String str) {
        synchronized (this) {
            insert0(i, str);
        }
        return this;
    }

    public StringBuffer insert(int i, boolean z) {
        return insert(i, z ? "true" : "false");
    }

    public StringBuffer insert(int i, char[] cArr) {
        synchronized (this) {
            insert0(i, cArr);
        }
        return this;
    }

    public StringBuffer insert(int i, char[] cArr, int i2, int i3) {
        synchronized (this) {
            insert0(i, cArr, i2, i3);
        }
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public /* bridge */ /* synthetic */ int lastIndexOf(String str) {
        return super.lastIndexOf(str);
    }

    @Override // java.lang.AbstractStringBuilder
    public int lastIndexOf(String str, int i) {
        int lastIndexOf;
        synchronized (this) {
            lastIndexOf = super.lastIndexOf(str, i);
        }
        return lastIndexOf;
    }

    @Override // java.lang.AbstractStringBuilder, java.lang.CharSequence
    public /* bridge */ /* synthetic */ int length() {
        return super.length();
    }

    @Override // java.lang.AbstractStringBuilder
    public int offsetByCodePoints(int i, int i2) {
        int offsetByCodePoints;
        synchronized (this) {
            offsetByCodePoints = super.offsetByCodePoints(i, i2);
        }
        return offsetByCodePoints;
    }

    public StringBuffer replace(int i, int i2, String str) {
        synchronized (this) {
            replace0(i, i2, str);
        }
        return this;
    }

    public StringBuffer reverse() {
        synchronized (this) {
            reverse0();
        }
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public void setCharAt(int i, char c2) {
        synchronized (this) {
            super.setCharAt(i, c2);
        }
    }

    @Override // java.lang.AbstractStringBuilder
    public void setLength(int i) {
        synchronized (this) {
            super.setLength(i);
        }
    }

    @Override // java.lang.AbstractStringBuilder, java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        String substring;
        synchronized (this) {
            substring = super.substring(i, i2);
        }
        return substring;
    }

    @Override // java.lang.AbstractStringBuilder
    public String substring(int i) {
        String substring;
        synchronized (this) {
            substring = super.substring(i);
        }
        return substring;
    }

    @Override // java.lang.AbstractStringBuilder
    public String substring(int i, int i2) {
        String substring;
        synchronized (this) {
            substring = super.substring(i, i2);
        }
        return substring;
    }

    @Override // java.lang.AbstractStringBuilder, java.lang.CharSequence
    public String toString() {
        String abstractStringBuilder;
        synchronized (this) {
            abstractStringBuilder = super.toString();
        }
        return abstractStringBuilder;
    }

    @Override // java.lang.AbstractStringBuilder
    public void trimToSize() {
        synchronized (this) {
            super.trimToSize();
        }
    }
}
