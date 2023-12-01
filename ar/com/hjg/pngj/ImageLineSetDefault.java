package ar.com.hjg.pngj;

import ar.com.hjg.pngj.IImageLine;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/ImageLineSetDefault.class */
public abstract class ImageLineSetDefault<T extends IImageLine> implements IImageLineSet<T> {
    public static IImageLineSetFactory<ImageLineInt> a() {
        return a(ImageLineInt.a());
    }

    public static <T extends IImageLine> IImageLineSetFactory<T> a(final IImageLineFactory<T> iImageLineFactory) {
        return (IImageLineSetFactory<T>) new IImageLineSetFactory<T>() { // from class: ar.com.hjg.pngj.ImageLineSetDefault.1

            /* renamed from: ar.com.hjg.pngj.ImageLineSetDefault$1$1  reason: invalid class name and collision with other inner class name */
            /* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/ImageLineSetDefault$1$1.class */
            class C00361 extends ImageLineSetDefault<T> {
            }
        };
    }

    public static IImageLineSetFactory<ImageLineByte> b() {
        return a(ImageLineByte.a());
    }
}
