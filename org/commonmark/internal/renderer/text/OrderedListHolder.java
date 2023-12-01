package org.commonmark.internal.renderer.text;

import org.commonmark.node.OrderedList;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/renderer/text/OrderedListHolder.class */
public class OrderedListHolder extends ListHolder {

    /* renamed from: a  reason: collision with root package name */
    private final char f44045a;
    private int b;

    public OrderedListHolder(ListHolder listHolder, OrderedList orderedList) {
        super(listHolder);
        this.f44045a = orderedList.f();
        this.b = orderedList.c();
    }

    public char a() {
        return this.f44045a;
    }

    public int d() {
        return this.b;
    }

    public void e() {
        this.b++;
    }
}
