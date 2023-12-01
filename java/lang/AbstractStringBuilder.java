package java.lang;

import com.igexin.push.core.b;
import java.io.InvalidObjectException;
import java.util.Arrays;
import libcore.util.EmptyArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/lang/AbstractStringBuilder.class */
public abstract class AbstractStringBuilder {
    static final int INITIAL_CAPACITY = 16;
    private int count;
    private boolean shared;
    private char[] value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractStringBuilder() {
        this.value = new char[16];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractStringBuilder(int i) {
        if (i < 0) {
            throw new NegativeArraySizeException(Integer.toString(i));
        }
        this.value = new char[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractStringBuilder(String str) {
        this.count = str.length();
        this.shared = false;
        this.value = new char[this.count + 16];
        str._getChars(0, this.count, this.value, 0);
    }

    private void enlargeBuffer(int i) {
        int length = (this.value.length >> 1) + this.value.length + 2;
        if (i <= length) {
            i = length;
        }
        char[] cArr = new char[i];
        System.arraycopy(this.value, 0, cArr, 0, this.count);
        this.value = cArr;
        this.shared = false;
    }

    private StringIndexOutOfBoundsException indexAndLength(int i) {
        throw new StringIndexOutOfBoundsException(this.count, i);
    }

    private void move(int i, int i2) {
        int max;
        if (this.value.length - this.count < i) {
            max = Math.max(this.count + i, (this.value.length * 2) + 2);
        } else if (!this.shared) {
            System.arraycopy(this.value, i2, this.value, i2 + i, this.count - i2);
            return;
        } else {
            max = this.value.length;
        }
        char[] cArr = new char[max];
        System.arraycopy(this.value, 0, cArr, 0, i2);
        System.arraycopy(this.value, i2, cArr, i2 + i, this.count - i2);
        this.value = cArr;
        this.shared = false;
    }

    private StringIndexOutOfBoundsException startEndAndLength(int i, int i2) {
        throw new StringIndexOutOfBoundsException(this.count, i, i2 - i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void append0(char c2) {
        if (this.count == this.value.length) {
            enlargeBuffer(this.count + 1);
        }
        char[] cArr = this.value;
        int i = this.count;
        this.count = i + 1;
        cArr[i] = c2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void append0(CharSequence charSequence, int i, int i2) {
        CharSequence charSequence2 = charSequence;
        if (charSequence == null) {
            charSequence2 = b.l;
        }
        if ((i | i2) < 0 || i > i2 || i2 > charSequence2.length()) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        int i4 = this.count + i3;
        if (i4 > this.value.length) {
            enlargeBuffer(i4);
        } else if (this.shared) {
            this.value = (char[]) this.value.clone();
            this.shared = false;
        }
        if (!(charSequence2 instanceof String)) {
            if (!(charSequence2 instanceof AbstractStringBuilder)) {
                int i5 = this.count;
                while (true) {
                    int i6 = i5;
                    if (i >= i2) {
                        break;
                    }
                    this.value[i6] = charSequence2.charAt(i);
                    i++;
                    i5 = i6 + 1;
                }
            } else {
                System.arraycopy(((AbstractStringBuilder) charSequence2).value, i, this.value, this.count, i3);
            }
        } else {
            ((String) charSequence2)._getChars(i, i2, this.value, this.count);
        }
        this.count = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void append0(String str) {
        if (str == null) {
            appendNull();
            return;
        }
        int length = str.length();
        int i = this.count + length;
        if (i > this.value.length) {
            enlargeBuffer(i);
        }
        str._getChars(0, length, this.value, this.count);
        this.count = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void append0(char[] cArr) {
        int length = this.count + cArr.length;
        if (length > this.value.length) {
            enlargeBuffer(length);
        }
        System.arraycopy(cArr, 0, this.value, this.count, cArr.length);
        this.count = length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void append0(char[] cArr, int i, int i2) {
        Arrays.checkOffsetAndCount(cArr.length, i, i2);
        int i3 = this.count + i2;
        if (i3 > this.value.length) {
            enlargeBuffer(i3);
        }
        System.arraycopy(cArr, i, this.value, this.count, i2);
        this.count = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void appendNull() {
        int i = this.count + 4;
        if (i > this.value.length) {
            enlargeBuffer(i);
        }
        char[] cArr = this.value;
        int i2 = this.count;
        this.count = i2 + 1;
        cArr[i2] = 'n';
        char[] cArr2 = this.value;
        int i3 = this.count;
        this.count = i3 + 1;
        cArr2[i3] = 'u';
        char[] cArr3 = this.value;
        int i4 = this.count;
        this.count = i4 + 1;
        cArr3[i4] = 'l';
        char[] cArr4 = this.value;
        int i5 = this.count;
        this.count = i5 + 1;
        cArr4[i5] = 'l';
    }

    public int capacity() {
        return this.value.length;
    }

    public char charAt(int i) {
        if (i < 0 || i >= this.count) {
            throw indexAndLength(i);
        }
        return this.value[i];
    }

    public int codePointAt(int i) {
        if (i < 0 || i >= this.count) {
            throw indexAndLength(i);
        }
        return Character.codePointAt(this.value, i, this.count);
    }

    public int codePointBefore(int i) {
        if (i < 1 || i > this.count) {
            throw indexAndLength(i);
        }
        return Character.codePointBefore(this.value, i);
    }

    public int codePointCount(int i, int i2) {
        if (i < 0 || i2 > this.count || i > i2) {
            throw startEndAndLength(i, i2);
        }
        return Character.codePointCount(this.value, i, i2 - i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void delete0(int i, int i2) {
        int i3 = i2;
        if (i2 > this.count) {
            i3 = this.count;
        }
        if (i < 0 || i > this.count || i > i3) {
            throw startEndAndLength(i, i3);
        }
        if (i3 == i) {
            return;
        }
        int i4 = this.count - i3;
        if (i4 >= 0) {
            if (this.shared) {
                char[] cArr = new char[this.value.length];
                System.arraycopy(this.value, 0, cArr, 0, i);
                System.arraycopy(this.value, i3, cArr, i, i4);
                this.value = cArr;
                this.shared = false;
            } else {
                System.arraycopy(this.value, i3, this.value, i, i4);
            }
        }
        this.count -= i3 - i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void deleteCharAt0(int i) {
        if (i < 0 || i >= this.count) {
            throw indexAndLength(i);
        }
        delete0(i, i + 1);
    }

    public void ensureCapacity(int i) {
        if (i > this.value.length) {
            enlargeBuffer(Math.max((this.value.length * 2) + 2, i));
        }
    }

    public void getChars(int i, int i2, char[] cArr, int i3) {
        if (i > this.count || i2 > this.count || i > i2) {
            throw startEndAndLength(i, i2);
        }
        System.arraycopy(this.value, i, cArr, i3, i2 - i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final char[] getValue() {
        return this.value;
    }

    public int indexOf(String str) {
        return indexOf(str, 0);
    }

    public int indexOf(String str, int i) {
        boolean z;
        int i2;
        int i3;
        int i4;
        int i5 = i;
        if (i < 0) {
            i5 = 0;
        }
        int length = str.length();
        if (length <= 0) {
            if (i5 >= this.count && i5 != 0) {
                i5 = this.count;
            }
            return i5;
        }
        if (length + i5 <= this.count) {
            char charAt = str.charAt(0);
            while (true) {
                int i6 = i5;
                while (true) {
                    z = false;
                    if (i6 >= this.count) {
                        break;
                    } else if (this.value[i6] == charAt) {
                        z = true;
                        break;
                    } else {
                        i6++;
                    }
                }
                if (z && length + i6 <= this.count) {
                    int i7 = i6;
                    int i8 = 0;
                    do {
                        i2 = i8 + 1;
                        if (i2 >= length) {
                            break;
                        }
                        i4 = i7 + 1;
                        i7 = i4;
                        i8 = i2;
                    } while (this.value[i4] == str.charAt(i2));
                    i3 = i6;
                    if (i2 == length) {
                        break;
                    }
                    i5 = i6 + 1;
                } else {
                    return -1;
                }
            }
        } else {
            i3 = -1;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void insert0(int i, char c2) {
        if (i < 0 || i > this.count) {
            throw new ArrayIndexOutOfBoundsException(this.count, i);
        }
        move(1, i);
        this.value[i] = c2;
        this.count++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void insert0(int i, CharSequence charSequence, int i2, int i3) {
        CharSequence charSequence2 = charSequence;
        if (charSequence == null) {
            charSequence2 = b.l;
        }
        if ((i | i2 | i3) < 0 || i > this.count || i2 > i3 || i3 > charSequence2.length()) {
            throw new IndexOutOfBoundsException();
        }
        insert0(i, charSequence2.subSequence(i2, i3).toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void insert0(int i, String str) {
        if (i < 0 || i > this.count) {
            throw indexAndLength(i);
        }
        String str2 = str;
        if (str == null) {
            str2 = b.l;
        }
        int length = str2.length();
        if (length != 0) {
            move(length, i);
            str2._getChars(0, length, this.value, i);
            this.count += length;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void insert0(int i, char[] cArr) {
        if (i < 0 || i > this.count) {
            throw indexAndLength(i);
        }
        if (cArr.length != 0) {
            move(cArr.length, i);
            System.arraycopy(cArr, 0, this.value, i, cArr.length);
            this.count += cArr.length;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void insert0(int i, char[] cArr, int i2, int i3) {
        if (i < 0 || i > this.count || i2 < 0 || i3 < 0 || i3 > cArr.length - i2) {
            throw new StringIndexOutOfBoundsException("this.length=" + this.count + "; index=" + i + "; chars.length=" + cArr.length + "; start=" + i2 + "; length=" + i3);
        }
        if (i3 != 0) {
            move(i3, i);
            System.arraycopy(cArr, i2, this.value, i, i3);
            this.count += i3;
        }
    }

    public int lastIndexOf(String str) {
        return lastIndexOf(str, this.count);
    }

    public int lastIndexOf(String str, int i) {
        boolean z;
        int i2;
        int i3;
        int i4;
        int length = str.length();
        if (length > this.count || i < 0) {
            return -1;
        }
        if (length <= 0) {
            if (i >= this.count) {
                i = this.count;
            }
            return i;
        }
        int i5 = i;
        if (i > this.count - length) {
            i5 = this.count - length;
        }
        char charAt = str.charAt(0);
        while (true) {
            int i6 = i5;
            while (true) {
                z = false;
                if (i6 < 0) {
                    break;
                } else if (this.value[i6] == charAt) {
                    z = true;
                    break;
                } else {
                    i6--;
                }
            }
            if (!z) {
                i2 = -1;
                break;
            }
            int i7 = i6;
            int i8 = 0;
            do {
                i3 = i8 + 1;
                if (i3 >= length) {
                    break;
                }
                i4 = i7 + 1;
                i7 = i4;
                i8 = i3;
            } while (this.value[i4] == str.charAt(i3));
            i2 = i6;
            if (i3 == length) {
                break;
            }
            i5 = i6 - 1;
        }
        return i2;
    }

    public int length() {
        return this.count;
    }

    public int offsetByCodePoints(int i, int i2) {
        return Character.offsetByCodePoints(this.value, 0, this.count, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void replace0(int i, int i2, String str) {
        int i3 = i2;
        if (i >= 0) {
            int i4 = i2;
            if (i2 > this.count) {
                i4 = this.count;
            }
            if (i4 > i) {
                int length = str.length();
                int i5 = (i4 - i) - length;
                if (i5 > 0) {
                    if (this.shared) {
                        char[] cArr = new char[this.value.length];
                        System.arraycopy(this.value, 0, cArr, 0, i);
                        System.arraycopy(this.value, i4, cArr, i + length, this.count - i4);
                        this.value = cArr;
                        this.shared = false;
                    } else {
                        System.arraycopy(this.value, i4, this.value, i + length, this.count - i4);
                    }
                } else if (i5 < 0) {
                    move(-i5, i4);
                } else if (this.shared) {
                    this.value = (char[]) this.value.clone();
                    this.shared = false;
                }
                str._getChars(0, length, this.value, i);
                this.count -= i5;
                return;
            }
            i3 = i4;
            if (i == i4) {
                if (str == null) {
                    throw new NullPointerException("string == null");
                }
                insert0(i, str);
                return;
            }
        }
        throw startEndAndLength(i, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void reverse0() {
        if (this.count < 2) {
            return;
        }
        if (this.shared) {
            char[] cArr = new char[this.value.length];
            int i = 0;
            int i2 = this.count;
            while (i < this.count) {
                char c2 = this.value[i];
                int i3 = i2;
                int i4 = i;
                if (i + 1 < this.count) {
                    i3 = i2;
                    i4 = i;
                    if (c2 >= 55296) {
                        i3 = i2;
                        i4 = i;
                        if (c2 <= 56319) {
                            char c3 = this.value[i + 1];
                            i3 = i2;
                            i4 = i;
                            if (c3 >= 56320) {
                                i3 = i2;
                                i4 = i;
                                if (c3 <= 57343) {
                                    i3 = i2 - 1;
                                    cArr[i3] = c3;
                                    i4 = i + 1;
                                }
                            }
                        }
                    }
                }
                i2 = i3 - 1;
                cArr[i2] = c2;
                i = i4 + 1;
            }
            this.value = cArr;
            this.shared = false;
            return;
        }
        int i5 = this.count - 1;
        char c4 = this.value[0];
        char c5 = this.value[i5];
        boolean z = true;
        boolean z2 = true;
        int i6 = 0;
        int i7 = this.count / 2;
        while (i6 < i7) {
            char c6 = this.value[i6 + 1];
            char c7 = this.value[i5 - 1];
            boolean z3 = z && c6 >= 56320 && c6 <= 57343 && c4 >= 55296 && c4 <= 56319;
            if (z3 && this.count < 3) {
                return;
            }
            if (z3 == (z2 && c7 >= 55296 && c7 <= 56319 && c5 >= 56320 && c5 <= 57343)) {
                if (z3) {
                    this.value[i5] = c6;
                    this.value[i5 - 1] = c4;
                    this.value[i6] = c7;
                    this.value[i6 + 1] = c5;
                    c4 = this.value[i6 + 2];
                    c5 = this.value[i5 - 2];
                    i6++;
                    i5--;
                    z = true;
                    z2 = true;
                } else {
                    this.value[i5] = c4;
                    this.value[i6] = c5;
                    c4 = c6;
                    c5 = c7;
                    z2 = true;
                    z = true;
                }
            } else if (z3) {
                this.value[i5] = c6;
                this.value[i6] = c5;
                c5 = c7;
                z = false;
                z2 = true;
            } else {
                this.value[i5] = c4;
                this.value[i6] = c7;
                c4 = c6;
                z2 = false;
                z = true;
            }
            i6++;
            i5--;
        }
        if ((this.count & 1) == 1) {
            if (z && z2) {
                return;
            }
            char[] cArr2 = this.value;
            if (!z) {
                c5 = c4;
            }
            cArr2[i5] = c5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void set(char[] cArr, int i) throws InvalidObjectException {
        char[] cArr2 = cArr;
        if (cArr == null) {
            cArr2 = EmptyArray.CHAR;
        }
        if (cArr2.length < i) {
            throw new InvalidObjectException("count out of range");
        }
        this.shared = false;
        this.value = cArr2;
        this.count = i;
    }

    public void setCharAt(int i, char c2) {
        if (i < 0 || i >= this.count) {
            throw indexAndLength(i);
        }
        if (this.shared) {
            this.value = (char[]) this.value.clone();
            this.shared = false;
        }
        this.value[i] = c2;
    }

    public void setLength(int i) {
        if (i < 0) {
            throw new StringIndexOutOfBoundsException("length < 0: " + i);
        }
        if (i > this.value.length) {
            enlargeBuffer(i);
        } else if (this.shared) {
            char[] cArr = new char[this.value.length];
            System.arraycopy(this.value, 0, cArr, 0, this.count);
            this.value = cArr;
            this.shared = false;
        } else if (this.count < i) {
            Arrays.fill(this.value, this.count, i, (char) 0);
        }
        this.count = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final char[] shareValue() {
        this.shared = true;
        return this.value;
    }

    public CharSequence subSequence(int i, int i2) {
        return substring(i, i2);
    }

    public String substring(int i) {
        if (i < 0 || i > this.count) {
            throw indexAndLength(i);
        }
        return i == this.count ? "" : new String(this.value, i, this.count - i);
    }

    public String substring(int i, int i2) {
        if (i < 0 || i > i2 || i2 > this.count) {
            throw startEndAndLength(i, i2);
        }
        return i == i2 ? "" : new String(this.value, i, i2 - i);
    }

    public String toString() {
        if (this.count == 0) {
            return "";
        }
        int length = this.value.length - this.count;
        if (length >= 256 || (length >= 16 && length >= (this.count >> 1))) {
            return new String(this.value, 0, this.count);
        }
        this.shared = true;
        return new String(0, this.count, this.value);
    }

    public void trimToSize() {
        if (this.count < this.value.length) {
            char[] cArr = new char[this.count];
            System.arraycopy(this.value, 0, cArr, 0, this.count);
            this.value = cArr;
            this.shared = false;
        }
    }
}
