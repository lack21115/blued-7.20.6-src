package org.commonmark.internal.renderer.text;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/renderer/text/ListHolder.class */
public abstract class ListHolder {
    private final ListHolder a;
    private final String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ListHolder(ListHolder listHolder) {
        this.a = listHolder;
        if (listHolder == null) {
            this.b = "";
            return;
        }
        this.b = listHolder.b + "   ";
    }

    public ListHolder b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }
}
