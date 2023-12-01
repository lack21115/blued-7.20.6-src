package org.commonmark.internal;

import org.commonmark.node.Text;
import org.commonmark.parser.delimiter.DelimiterRun;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/Delimiter.class */
public class Delimiter implements DelimiterRun {
    public final Text a;
    public final char b;
    public final boolean c;
    public final boolean d;
    public Delimiter e;
    public Delimiter f;
    public int g = 1;
    public int h = 1;

    public Delimiter(Text text, char c, boolean z, boolean z2, Delimiter delimiter) {
        this.a = text;
        this.b = c;
        this.c = z;
        this.d = z2;
        this.e = delimiter;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterRun
    public boolean a() {
        return this.c;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterRun
    public boolean b() {
        return this.d;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterRun
    public int c() {
        return this.g;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterRun
    public int d() {
        return this.h;
    }
}
