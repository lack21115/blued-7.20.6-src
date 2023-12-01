package io.perfmark;

import javax.annotation.Nullable;

/* loaded from: source-3503164-dex2jar.jar:io/perfmark/Tag.class */
public final class Tag {
    final long tagId;
    @Nullable
    final String tagName;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Tag(@Nullable String str, long j) {
        this.tagName = str;
        this.tagId = j;
    }
}
