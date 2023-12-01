package org.commonmark.internal.renderer.text;

import org.commonmark.node.BulletList;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/renderer/text/BulletListHolder.class */
public class BulletListHolder extends ListHolder {

    /* renamed from: a  reason: collision with root package name */
    private final char f44043a;

    public BulletListHolder(ListHolder listHolder, BulletList bulletList) {
        super(listHolder);
        this.f44043a = bulletList.c();
    }

    public char a() {
        return this.f44043a;
    }
}
