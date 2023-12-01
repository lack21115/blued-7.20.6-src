package org.commonmark.internal;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/BlockContent.class */
class BlockContent {
    private int b = 0;

    /* renamed from: a  reason: collision with root package name */
    private final StringBuilder f44001a = new StringBuilder();

    public String a() {
        return this.f44001a.toString();
    }

    public void a(CharSequence charSequence) {
        if (this.b != 0) {
            this.f44001a.append('\n');
        }
        this.f44001a.append(charSequence);
        this.b++;
    }
}
