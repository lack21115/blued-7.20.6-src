package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/PngChunkTextVar.class */
public abstract class PngChunkTextVar extends PngChunkMultiple {
    protected String h;
    protected String i;

    /* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/PngChunkTextVar$PngTxtInfo.class */
    public static class PngTxtInfo {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PngChunkTextVar(String str, ImageInfo imageInfo) {
        super(str, imageInfo);
    }

    public String e() {
        return this.h;
    }
}
