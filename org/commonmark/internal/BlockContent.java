package org.commonmark.internal;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/BlockContent.class */
class BlockContent {
    private int b = 0;
    private final StringBuilder a = new StringBuilder();

    public String a() {
        return this.a.toString();
    }

    public void a(CharSequence charSequence) {
        if (this.b != 0) {
            this.a.append('\n');
        }
        this.a.append(charSequence);
        this.b++;
    }
}
