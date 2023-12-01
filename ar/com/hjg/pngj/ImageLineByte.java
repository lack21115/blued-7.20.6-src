package ar.com.hjg.pngj;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/ImageLineByte.class */
public class ImageLineByte implements IImageLine, IImageLineArray {

    /* renamed from: a  reason: collision with root package name */
    public final ImageInfo f3640a;
    final byte[] b;

    public static IImageLineFactory<ImageLineByte> a() {
        return new IImageLineFactory<ImageLineByte>() { // from class: ar.com.hjg.pngj.ImageLineByte.1
        };
    }

    public String toString() {
        return " cols=" + this.f3640a.f3638a + " bpc=" + this.f3640a.f3639c + " size=" + this.b.length;
    }
}
