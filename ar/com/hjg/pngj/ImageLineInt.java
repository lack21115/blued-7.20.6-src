package ar.com.hjg.pngj;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/ImageLineInt.class */
public class ImageLineInt implements IImageLine, IImageLineArray {

    /* renamed from: a  reason: collision with root package name */
    public final ImageInfo f3643a;
    protected final int[] b;

    public static IImageLineFactory<ImageLineInt> a() {
        return new IImageLineFactory<ImageLineInt>() { // from class: ar.com.hjg.pngj.ImageLineInt.1
        };
    }

    public String toString() {
        return " cols=" + this.f3643a.f3638a + " bpc=" + this.f3643a.f3639c + " size=" + this.b.length;
    }
}
