package org.commonmark.internal.renderer.text;

import org.commonmark.node.OrderedList;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/renderer/text/OrderedListHolder.class */
public class OrderedListHolder extends ListHolder {
    private final char a;
    private int b;

    public OrderedListHolder(ListHolder listHolder, OrderedList orderedList) {
        super(listHolder);
        this.a = orderedList.f();
        this.b = orderedList.c();
    }

    public char a() {
        return this.a;
    }

    public int d() {
        return this.b;
    }

    public void e() {
        this.b++;
    }
}
