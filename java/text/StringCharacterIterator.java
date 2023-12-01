package java.text;

/* loaded from: source-2895416-dex2jar.jar:java/text/StringCharacterIterator.class */
public final class StringCharacterIterator implements CharacterIterator {
    int end;
    int offset;
    int start;
    String string;

    public StringCharacterIterator(String str) {
        this.string = str;
        this.offset = 0;
        this.start = 0;
        this.end = this.string.length();
    }

    public StringCharacterIterator(String str, int i) {
        this.string = str;
        this.start = 0;
        this.end = this.string.length();
        if (i < 0 || i > this.end) {
            throw new IllegalArgumentException();
        }
        this.offset = i;
    }

    public StringCharacterIterator(String str, int i, int i2, int i3) {
        this.string = str;
        if (i < 0 || i2 > this.string.length() || i > i2 || i3 < i || i3 > i2) {
            throw new IllegalArgumentException();
        }
        this.start = i;
        this.end = i2;
        this.offset = i3;
    }

    @Override // java.text.CharacterIterator
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.text.CharacterIterator
    public char current() {
        if (this.offset == this.end) {
            return (char) 65535;
        }
        return this.string.charAt(this.offset);
    }

    public boolean equals(Object obj) {
        if (obj instanceof StringCharacterIterator) {
            StringCharacterIterator stringCharacterIterator = (StringCharacterIterator) obj;
            return this.string.equals(stringCharacterIterator.string) && this.start == stringCharacterIterator.start && this.end == stringCharacterIterator.end && this.offset == stringCharacterIterator.offset;
        }
        return false;
    }

    @Override // java.text.CharacterIterator
    public char first() {
        if (this.start == this.end) {
            return (char) 65535;
        }
        this.offset = this.start;
        return this.string.charAt(this.offset);
    }

    @Override // java.text.CharacterIterator
    public int getBeginIndex() {
        return this.start;
    }

    @Override // java.text.CharacterIterator
    public int getEndIndex() {
        return this.end;
    }

    @Override // java.text.CharacterIterator
    public int getIndex() {
        return this.offset;
    }

    public int hashCode() {
        return this.string.hashCode() + this.start + this.end + this.offset;
    }

    @Override // java.text.CharacterIterator
    public char last() {
        if (this.start == this.end) {
            return (char) 65535;
        }
        this.offset = this.end - 1;
        return this.string.charAt(this.offset);
    }

    @Override // java.text.CharacterIterator
    public char next() {
        if (this.offset >= this.end - 1) {
            this.offset = this.end;
            return (char) 65535;
        }
        String str = this.string;
        int i = this.offset + 1;
        this.offset = i;
        return str.charAt(i);
    }

    @Override // java.text.CharacterIterator
    public char previous() {
        if (this.offset == this.start) {
            return (char) 65535;
        }
        String str = this.string;
        int i = this.offset - 1;
        this.offset = i;
        return str.charAt(i);
    }

    @Override // java.text.CharacterIterator
    public char setIndex(int i) {
        if (i < this.start || i > this.end) {
            throw new IllegalArgumentException();
        }
        this.offset = i;
        if (this.offset == this.end) {
            return (char) 65535;
        }
        return this.string.charAt(this.offset);
    }

    public void setText(String str) {
        this.string = str;
        this.offset = 0;
        this.start = 0;
        this.end = str.length();
    }
}
