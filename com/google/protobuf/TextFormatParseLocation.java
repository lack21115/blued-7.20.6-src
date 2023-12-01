package com.google.protobuf;

import java.util.Arrays;

/* loaded from: source-8110460-dex2jar.jar:com/google/protobuf/TextFormatParseLocation.class */
public final class TextFormatParseLocation {
    public static final TextFormatParseLocation EMPTY = new TextFormatParseLocation(-1, -1);
    private final int column;
    private final int line;

    private TextFormatParseLocation(int i, int i2) {
        this.line = i;
        this.column = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TextFormatParseLocation create(int i, int i2) {
        if (i == -1 && i2 == -1) {
            return EMPTY;
        }
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException(String.format("line and column values must be >= 0: line %d, column: %d", Integer.valueOf(i), Integer.valueOf(i2)));
        }
        return new TextFormatParseLocation(i, i2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TextFormatParseLocation) {
            TextFormatParseLocation textFormatParseLocation = (TextFormatParseLocation) obj;
            return this.line == textFormatParseLocation.getLine() && this.column == textFormatParseLocation.getColumn();
        }
        return false;
    }

    public int getColumn() {
        return this.column;
    }

    public int getLine() {
        return this.line;
    }

    public int hashCode() {
        return Arrays.hashCode(new int[]{this.line, this.column});
    }

    public String toString() {
        return String.format("ParseLocation{line=%d, column=%d}", Integer.valueOf(this.line), Integer.valueOf(this.column));
    }
}
