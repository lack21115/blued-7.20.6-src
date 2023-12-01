package org.commonmark.internal.renderer.text;

import org.commonmark.node.BulletList;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/renderer/text/BulletListHolder.class */
public class BulletListHolder extends ListHolder {
    private final char a;

    public BulletListHolder(ListHolder listHolder, BulletList bulletList) {
        super(listHolder);
        this.a = bulletList.c();
    }

    public char a() {
        return this.a;
    }
}
