package org.commonmark.internal;

import org.commonmark.node.Text;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/Bracket.class */
public class Bracket {
    public final Text a;
    public final int b;
    public final boolean c;
    public final Bracket d;
    public final Delimiter e;
    public boolean f = true;
    public boolean g = false;

    private Bracket(Text text, int i, Bracket bracket, Delimiter delimiter, boolean z) {
        this.a = text;
        this.b = i;
        this.c = z;
        this.d = bracket;
        this.e = delimiter;
    }

    public static Bracket a(Text text, int i, Bracket bracket, Delimiter delimiter) {
        return new Bracket(text, i, bracket, delimiter, false);
    }

    public static Bracket b(Text text, int i, Bracket bracket, Delimiter delimiter) {
        return new Bracket(text, i, bracket, delimiter, true);
    }
}
