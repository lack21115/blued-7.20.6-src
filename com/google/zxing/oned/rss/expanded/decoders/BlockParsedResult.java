package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/oned/rss/expanded/decoders/BlockParsedResult.class */
final class BlockParsedResult {
    private final DecodedInformation decodedInformation;
    private final boolean finished;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BlockParsedResult(DecodedInformation decodedInformation, boolean z) {
        this.finished = z;
        this.decodedInformation = decodedInformation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BlockParsedResult(boolean z) {
        this(null, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecodedInformation getDecodedInformation() {
        return this.decodedInformation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isFinished() {
        return this.finished;
    }
}
