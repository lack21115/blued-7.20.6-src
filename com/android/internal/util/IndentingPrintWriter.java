package com.android.internal.util;

import java.io.PrintWriter;
import java.io.Writer;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/IndentingPrintWriter.class */
public class IndentingPrintWriter extends PrintWriter {
    private char[] mCurrentIndent;
    private int mCurrentLength;
    private boolean mEmptyLine;
    private StringBuilder mIndentBuilder;
    private final String mSingleIndent;
    private final int mWrapLength;

    public IndentingPrintWriter(Writer writer, String str) {
        this(writer, str, -1);
    }

    public IndentingPrintWriter(Writer writer, String str, int i) {
        super(writer);
        this.mIndentBuilder = new StringBuilder();
        this.mEmptyLine = true;
        this.mSingleIndent = str;
        this.mWrapLength = i;
    }

    private void maybeWriteIndent() {
        if (this.mEmptyLine) {
            this.mEmptyLine = false;
            if (this.mIndentBuilder.length() != 0) {
                if (this.mCurrentIndent == null) {
                    this.mCurrentIndent = this.mIndentBuilder.toString().toCharArray();
                }
                super.write(this.mCurrentIndent, 0, this.mCurrentIndent.length);
            }
        }
    }

    public void decreaseIndent() {
        this.mIndentBuilder.delete(0, this.mSingleIndent.length());
        this.mCurrentIndent = null;
    }

    public void increaseIndent() {
        this.mIndentBuilder.append(this.mSingleIndent);
        this.mCurrentIndent = null;
    }

    public void printHexPair(String str, int i) {
        print(str + "=0x" + Integer.toHexString(i) + " ");
    }

    public void printPair(String str, Object obj) {
        print(str + "=" + String.valueOf(obj) + " ");
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        int i3;
        int length = this.mIndentBuilder.length();
        int i4 = i;
        int i5 = i;
        while (true) {
            i3 = i5;
            if (i3 >= i + i2) {
                break;
            }
            int i6 = i3 + 1;
            char c2 = cArr[i3];
            this.mCurrentLength++;
            int i7 = i4;
            if (c2 == '\n') {
                maybeWriteIndent();
                super.write(cArr, i4, i6 - i4);
                i7 = i6;
                this.mEmptyLine = true;
                this.mCurrentLength = 0;
            }
            i4 = i7;
            if (this.mWrapLength > 0) {
                i4 = i7;
                if (this.mCurrentLength >= this.mWrapLength - length) {
                    if (this.mEmptyLine) {
                        maybeWriteIndent();
                        super.write(cArr, i7, i6 - i7);
                        super.write(10);
                        this.mEmptyLine = true;
                        i4 = i6;
                        this.mCurrentLength = 0;
                    } else {
                        super.write(10);
                        this.mEmptyLine = true;
                        this.mCurrentLength = i6 - i7;
                        i4 = i7;
                    }
                }
            }
            i5 = i6;
        }
        if (i4 != i3) {
            maybeWriteIndent();
            super.write(cArr, i4, i3 - i4);
        }
    }
}
