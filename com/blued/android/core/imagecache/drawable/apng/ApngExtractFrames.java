package com.blued.android.core.imagecache.drawable.apng;

import ar.com.hjg.pngj.ChunkReader;
import ar.com.hjg.pngj.ChunkSeqReaderPng;
import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngHelperInternal;
import ar.com.hjg.pngj.PngReader;
import ar.com.hjg.pngj.PngjException;
import ar.com.hjg.pngj.chunks.ChunkHelper;
import ar.com.hjg.pngj.chunks.ChunkRaw;
import ar.com.hjg.pngj.chunks.PngChunk;
import ar.com.hjg.pngj.chunks.PngChunkFCTL;
import ar.com.hjg.pngj.chunks.PngChunkIEND;
import ar.com.hjg.pngj.chunks.PngChunkIHDR;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/drawable/apng/ApngExtractFrames.class */
public class ApngExtractFrames {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/drawable/apng/ApngExtractFrames$PngReaderBuffered.class */
    public static class PngReaderBuffered extends PngReader {
        FileOutputStream g;
        File h;
        ImageInfo i;
        int j;
        private File k;

        public PngReaderBuffered(File file) {
            super(file);
            this.g = null;
            this.j = -1;
            this.k = file;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g() throws Exception {
            if (this.g != null) {
                h();
            }
            this.h = i();
            FileOutputStream fileOutputStream = new FileOutputStream(this.h);
            this.g = fileOutputStream;
            fileOutputStream.write(PngHelperInternal.a());
            new PngChunkIHDR(this.i).e().a(this.g);
            for (PngChunk pngChunk : a(false).a()) {
                String str = pngChunk.f3667a;
                if (!str.equals("IHDR") && !str.equals("fcTL") && !str.equals("acTL")) {
                    if (str.equals("IDAT")) {
                        return;
                    }
                    pngChunk.b().a(this.g);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h() throws IOException {
            new PngChunkIEND(null).e().a(this.g);
            this.g.close();
            this.g = null;
        }

        private File i() {
            return new File(this.k.getParent(), ApngExtractFrames.a(this.k, this.j));
        }

        @Override // ar.com.hjg.pngj.PngReader
        public ChunkSeqReaderPng f() {
            return new ChunkSeqReaderPng(false) { // from class: com.blued.android.core.imagecache.drawable.apng.ApngExtractFrames.PngReaderBuffered.1
                @Override // ar.com.hjg.pngj.ChunkSeqReaderPng, ar.com.hjg.pngj.ChunkSeqReader
                public void a(ChunkReader chunkReader) {
                    super.a(chunkReader);
                    try {
                        String str = chunkReader.a().f3660c;
                        PngChunk pngChunk = this.f.a().get(this.f.a().size() - 1);
                        if (str.equals("fcTL")) {
                            PngReaderBuffered.this.j++;
                            PngReaderBuffered.this.i = ((PngChunkFCTL) pngChunk).e();
                            PngReaderBuffered.this.g();
                        }
                        if (str.equals("fdAT") || str.equals("IDAT")) {
                            if (!str.equals("IDAT")) {
                                ChunkRaw chunkRaw = new ChunkRaw(chunkReader.a().f3659a - 4, ChunkHelper.f3655c, true);
                                System.arraycopy((Object) chunkReader.a().d, 4, (Object) chunkRaw.d, 0, chunkRaw.d.length);
                                chunkRaw.a(PngReaderBuffered.this.g);
                            } else if (PngReaderBuffered.this.g != null) {
                                chunkReader.a().a(PngReaderBuffered.this.g);
                            }
                            chunkReader.a().d = null;
                        }
                        if (!str.equals("IEND") || PngReaderBuffered.this.g == null) {
                            return;
                        }
                        PngReaderBuffered.this.h();
                    } catch (Exception e) {
                        throw new PngjException(e);
                    }
                }

                @Override // ar.com.hjg.pngj.ChunkSeqReaderPng, ar.com.hjg.pngj.ChunkSeqReader
                public boolean a(String str) {
                    return false;
                }

                @Override // ar.com.hjg.pngj.ChunkSeqReaderPng, ar.com.hjg.pngj.ChunkSeqReader
                public boolean b(int i, String str) {
                    return false;
                }
            };
        }
    }

    public static int a(File file) {
        PngReaderBuffered pngReaderBuffered = new PngReaderBuffered(file);
        pngReaderBuffered.c();
        return pngReaderBuffered.j + 1;
    }

    public static String a(File file, int i) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf > 0) {
            return String.format(Locale.ENGLISH, "%s_%03d.%s", name.substring(0, lastIndexOf), Integer.valueOf(i), name.substring(lastIndexOf + 1));
        }
        return String.format(Locale.ENGLISH, "%s_%03d", name, Integer.valueOf(i));
    }
}
