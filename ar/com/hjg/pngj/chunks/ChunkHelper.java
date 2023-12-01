package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.PngHelperInternal;
import ar.com.hjg.pngj.PngjException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/ChunkHelper.class */
public class ChunkHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f3654a = a("IHDR");
    public static final byte[] b = a("PLTE");

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f3655c = a("IDAT");
    public static final byte[] d = a("IEND");
    private static byte[] e = new byte[4096];

    /* renamed from: ar.com.hjg.pngj.chunks.ChunkHelper$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/ChunkHelper$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3656a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[ChunkLoadBehaviour.values().length];
            f3656a = iArr;
            try {
                iArr[ChunkLoadBehaviour.LOAD_CHUNK_ALWAYS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3656a[ChunkLoadBehaviour.LOAD_CHUNK_IF_SAFE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3656a[ChunkLoadBehaviour.LOAD_CHUNK_NEVER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    ChunkHelper() {
    }

    public static String a(byte[] bArr) {
        try {
            return new String(bArr, PngHelperInternal.b);
        } catch (UnsupportedEncodingException e2) {
            throw new PngBadCharsetException(e2);
        }
    }

    public static String a(byte[] bArr, int i, int i2) {
        try {
            return new String(bArr, i, i2, PngHelperInternal.b);
        } catch (UnsupportedEncodingException e2) {
            throw new PngBadCharsetException(e2);
        }
    }

    public static List<PngChunk> a(List<PngChunk> list, ChunkPredicate chunkPredicate) {
        ArrayList arrayList = new ArrayList();
        for (PngChunk pngChunk : list) {
            if (chunkPredicate.a(pngChunk)) {
                arrayList.add(pngChunk);
            }
        }
        return arrayList;
    }

    private static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        synchronized (e) {
            while (true) {
                int read = inputStream.read(e);
                if (read > 0) {
                    outputStream.write(e, 0, read);
                }
            }
        }
    }

    public static boolean a(PngChunk pngChunk) {
        return pngChunk instanceof PngChunkUNKNOWN;
    }

    public static final boolean a(PngChunk pngChunk, PngChunk pngChunk2) {
        if (pngChunk == pngChunk2) {
            return true;
        }
        if (pngChunk == null || pngChunk2 == null || !pngChunk.f3667a.equals(pngChunk2.f3667a) || pngChunk.b || pngChunk.getClass() != pngChunk2.getClass()) {
            return false;
        }
        if (pngChunk2.a()) {
            if (pngChunk instanceof PngChunkTextVar) {
                return ((PngChunkTextVar) pngChunk).e().equals(((PngChunkTextVar) pngChunk2).e());
            }
            if (pngChunk instanceof PngChunkSPLT) {
                return ((PngChunkSPLT) pngChunk).e().equals(((PngChunkSPLT) pngChunk2).e());
            }
            return false;
        }
        return true;
    }

    public static byte[] a(String str) {
        try {
            return str.getBytes(PngHelperInternal.b);
        } catch (UnsupportedEncodingException e2) {
            throw new PngBadCharsetException(e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.util.zip.DeflaterOutputStream] */
    public static byte[] a(byte[] bArr, int i, int i2, boolean z) {
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
            if (!z) {
                byteArrayInputStream = new InflaterInputStream(byteArrayInputStream);
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ByteArrayOutputStream deflaterOutputStream = z ? new DeflaterOutputStream(byteArrayOutputStream) : byteArrayOutputStream;
            a(byteArrayInputStream, deflaterOutputStream);
            byteArrayInputStream.close();
            deflaterOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            throw new PngjException(e2);
        }
    }

    public static String b(byte[] bArr) {
        try {
            return new String(bArr, PngHelperInternal.d);
        } catch (UnsupportedEncodingException e2) {
            throw new PngBadCharsetException(e2);
        }
    }

    public static String b(byte[] bArr, int i, int i2) {
        try {
            return new String(bArr, i, i2, PngHelperInternal.d);
        } catch (UnsupportedEncodingException e2) {
            throw new PngBadCharsetException(e2);
        }
    }

    public static boolean b(String str) {
        return Character.isUpperCase(str.charAt(0));
    }

    public static int c(byte[] bArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return -1;
            }
            if (bArr[i2] == 0) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public static boolean c(String str) {
        return Character.isUpperCase(str.charAt(1));
    }

    public static boolean d(String str) {
        return !Character.isUpperCase(str.charAt(3));
    }
}
