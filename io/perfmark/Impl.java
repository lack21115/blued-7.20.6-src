package io.perfmark;

import javax.annotation.Nullable;

/* loaded from: source-3503164-dex2jar.jar:io/perfmark/Impl.class */
public class Impl {
    private static final long NO_LINK_ID = Long.MIN_VALUE;
    static final long NO_TAG_ID = Long.MIN_VALUE;
    static final String NO_TAG_NAME = "";
    static final Tag NO_TAG = new Tag("", Long.MIN_VALUE);
    static final Link NO_LINK = new Link(Long.MIN_VALUE);

    /* JADX INFO: Access modifiers changed from: protected */
    public Impl(Tag tag) {
        if (tag != NO_TAG) {
            throw new AssertionError("nope");
        }
    }

    protected static Link packLink(long j) {
        return new Link(j);
    }

    protected static Tag packTag(@Nullable String str, long j) {
        return new Tag(str, j);
    }

    protected static long unpackLinkId(Link link) {
        return link.linkId;
    }

    protected static long unpackTagId(Tag tag) {
        return tag.tagId;
    }

    @Nullable
    protected static String unpackTagName(Tag tag) {
        return tag.tagName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void attachTag(Tag tag) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Tag createTag(@Nullable String str, long j) {
        return NO_TAG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void event(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void event(String str, Tag tag) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void linkIn(Link link) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Link linkOut() {
        return NO_LINK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setEnabled(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startTask(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startTask(String str, Tag tag) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stopTask(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stopTask(String str, Tag tag) {
    }
}
