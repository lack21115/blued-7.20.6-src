package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/oned/rss/expanded/decoders/DecodedObject.class */
abstract class DecodedObject {
    private final int newPosition;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecodedObject(int i) {
        this.newPosition = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getNewPosition() {
        return this.newPosition;
    }
}
