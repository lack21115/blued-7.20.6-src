package org.commonmark.internal;

import org.commonmark.node.Text;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/Bracket.class */
public class Bracket {

    /* renamed from: a  reason: collision with root package name */
    public final Text f44007a;
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f44008c;
    public final Bracket d;
    public final Delimiter e;
    public boolean f = true;
    public boolean g = false;

    private Bracket(Text text, int i, Bracket bracket, Delimiter delimiter, boolean z) {
        this.f44007a = text;
        this.b = i;
        this.f44008c = z;
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
