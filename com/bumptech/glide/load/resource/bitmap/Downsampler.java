package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.ImageReader;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/Downsampler.class */
public final class Downsampler {

    /* renamed from: a  reason: collision with root package name */
    public static final Option<DecodeFormat> f7345a = Option.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.f7090c);
    public static final Option<PreferredColorSpace> b = Option.a("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", PreferredColorSpace.SRGB);
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final Option<DownsampleStrategy> f7346c = DownsampleStrategy.h;
    public static final Option<Boolean> d = Option.a("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", false);
    public static final Option<Boolean> e = Option.a("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", false);
    private static final Set<String> f = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
    private static final DecodeCallbacks g = new DecodeCallbacks() { // from class: com.bumptech.glide.load.resource.bitmap.Downsampler.1
        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public void a() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public void a(BitmapPool bitmapPool, Bitmap bitmap) {
        }
    };
    private static final Set<ImageHeaderParser.ImageType> h = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
    private static final Queue<BitmapFactory.Options> i = Util.a(0);
    private final BitmapPool j;
    private final DisplayMetrics k;
    private final ArrayPool l;
    private final List<ImageHeaderParser> m;
    private final HardwareConfigState n = HardwareConfigState.a();

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/Downsampler$DecodeCallbacks.class */
    public interface DecodeCallbacks {
        void a();

        void a(BitmapPool bitmapPool, Bitmap bitmap) throws IOException;
    }

    public Downsampler(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this.m = list;
        this.k = (DisplayMetrics) Preconditions.a(displayMetrics);
        this.j = (BitmapPool) Preconditions.a(bitmapPool);
        this.l = (ArrayPool) Preconditions.a(arrayPool);
    }

    private static int a(double d2) {
        int b2 = b(d2);
        int c2 = c(b2 * d2);
        return c((d2 / (c2 / b2)) * c2);
    }

    private Bitmap a(ImageReader imageReader, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, PreferredColorSpace preferredColorSpace, boolean z, int i2, int i3, boolean z2, DecodeCallbacks decodeCallbacks) throws IOException {
        long a2 = LogTime.a();
        int[] a3 = a(imageReader, options, decodeCallbacks, this.j);
        int i4 = a3[0];
        int i5 = a3[1];
        String str = options.outMimeType;
        if (i4 == -1 || i5 == -1) {
            z = false;
        }
        int b2 = imageReader.b();
        int a4 = TransformationUtils.a(b2);
        boolean b3 = TransformationUtils.b(b2);
        int i6 = i2 == Integer.MIN_VALUE ? a(a4) ? i5 : i4 : i2;
        int i7 = i3;
        if (i7 == Integer.MIN_VALUE) {
            i7 = a(a4) ? i4 : i5;
        }
        ImageHeaderParser.ImageType a5 = imageReader.a();
        a(a5, imageReader, decodeCallbacks, this.j, downsampleStrategy, a4, i4, i5, i6, i7, options);
        a(imageReader, decodeFormat, z, b3, options, i6, i7);
        boolean z3 = Build.VERSION.SDK_INT >= 19;
        if ((options.inSampleSize == 1 || z3) && a(a5)) {
            if (i4 < 0 || i5 < 0 || !z2 || !z3) {
                float f2 = a(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                int i8 = options.inSampleSize;
                float f3 = i4;
                float f4 = i8;
                int ceil = (int) Math.ceil(f3 / f4);
                int ceil2 = (int) Math.ceil(i5 / f4);
                int round = Math.round(ceil * f2);
                int round2 = Math.round(ceil2 * f2);
                i6 = round;
                i7 = round2;
                if (Log.isLoggable("Downsampler", 2)) {
                    Log.v("Downsampler", "Calculated target [" + round + "x" + round2 + "] for source [" + i4 + "x" + i5 + "], sampleSize: " + i8 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f2);
                    i7 = round2;
                    i6 = round;
                }
            }
            if (i6 > 0 && i7 > 0) {
                a(options, this.j, i6, i7);
            }
        }
        if (Build.VERSION.SDK_INT >= 28) {
            boolean z4 = false;
            if (preferredColorSpace == PreferredColorSpace.DISPLAY_P3) {
                z4 = false;
                if (options.outColorSpace != null) {
                    z4 = false;
                    if (options.outColorSpace.isWideGamut()) {
                        z4 = true;
                    }
                }
            }
            options.inPreferredColorSpace = ColorSpace.get(z4 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
        } else if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        Bitmap b4 = b(imageReader, options, decodeCallbacks, this.j);
        decodeCallbacks.a(this.j, b4);
        if (Log.isLoggable("Downsampler", 2)) {
            a(i4, i5, str, options, b4, i2, i3, a2);
        }
        Bitmap bitmap = null;
        if (b4 != null) {
            b4.setDensity(this.k.densityDpi);
            Bitmap a6 = TransformationUtils.a(this.j, b4, b2);
            bitmap = a6;
            if (!b4.equals(a6)) {
                this.j.a(b4);
                bitmap = a6;
            }
        }
        return bitmap;
    }

    private static BitmapFactory.Options a() {
        BitmapFactory.Options poll;
        BitmapFactory.Options options;
        synchronized (Downsampler.class) {
            try {
                synchronized (i) {
                    poll = i.poll();
                }
                options = poll;
                if (poll == null) {
                    options = new BitmapFactory.Options();
                    d(options);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return options;
    }

    private Resource<Bitmap> a(ImageReader imageReader, int i2, int i3, Options options, DecodeCallbacks decodeCallbacks) throws IOException {
        byte[] bArr = (byte[]) this.l.a(65536, byte[].class);
        BitmapFactory.Options a2 = a();
        a2.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) options.a(f7345a);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) options.a(b);
        try {
            return BitmapResource.a(a(imageReader, a2, (DownsampleStrategy) options.a(DownsampleStrategy.h), decodeFormat, preferredColorSpace, options.a(e) != null && ((Boolean) options.a(e)).booleanValue(), i2, i3, ((Boolean) options.a(d)).booleanValue(), decodeCallbacks), this.j);
        } finally {
            c(a2);
            this.l.a((ArrayPool) bArr);
        }
    }

    private static IOException a(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i2 + ", outHeight: " + i3 + ", outMimeType: " + str + ", inBitmap: " + b(options), illegalArgumentException);
    }

    private static String a(Bitmap bitmap) {
        String str;
        if (bitmap == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            str = " (" + bitmap.getAllocationByteCount() + ")";
        } else {
            str = "";
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + str;
    }

    private static void a(int i2, int i3, String str, BitmapFactory.Options options, Bitmap bitmap, int i4, int i5, long j) {
        Log.v("Downsampler", "Decoded " + a(bitmap) + " from [" + i2 + "x" + i3 + "] " + str + " with inBitmap " + b(options) + " for [" + i4 + "x" + i5 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + LogTime.a(j));
    }

    private static void a(BitmapFactory.Options options, BitmapPool bitmapPool, int i2, int i3) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig == Bitmap.Config.HARDWARE) {
            return;
        } else {
            config = options.outConfig;
        }
        Bitmap.Config config2 = config;
        if (config == null) {
            config2 = options.inPreferredConfig;
        }
        options.inBitmap = bitmapPool.b(i2, i3, config2);
    }

    private static void a(ImageHeaderParser.ImageType imageType, ImageReader imageReader, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool, DownsampleStrategy downsampleStrategy, int i2, int i3, int i4, int i5, int i6, BitmapFactory.Options options) throws IOException {
        int i7;
        int i8;
        int i9;
        int floor;
        double floor2;
        int i10;
        if (i3 <= 0 || i4 <= 0) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Unable to determine dimensions for: " + imageType + " with target [" + i5 + "x" + i6 + "]");
                return;
            }
            return;
        }
        if (a(i2)) {
            i8 = i3;
            i7 = i4;
        } else {
            i7 = i3;
            i8 = i4;
        }
        float a2 = downsampleStrategy.a(i7, i8, i5, i6);
        if (a2 <= 0.0f) {
            throw new IllegalArgumentException("Cannot scale with factor: " + a2 + " from: " + downsampleStrategy + ", source: [" + i3 + "x" + i4 + "], target: [" + i5 + "x" + i6 + "]");
        }
        DownsampleStrategy.SampleSizeRounding b2 = downsampleStrategy.b(i7, i8, i5, i6);
        if (b2 == null) {
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        float f2 = i7;
        int c2 = c(a2 * f2);
        float f3 = i8;
        int c3 = c(a2 * f3);
        int i11 = i7 / c2;
        int i12 = i8 / c3;
        int max = b2 == DownsampleStrategy.SampleSizeRounding.MEMORY ? Math.max(i11, i12) : Math.min(i11, i12);
        if (Build.VERSION.SDK_INT > 23 || !f.contains(options.outMimeType)) {
            int max2 = Math.max(1, Integer.highestOneBit(max));
            i9 = max2;
            if (b2 == DownsampleStrategy.SampleSizeRounding.MEMORY) {
                i9 = max2;
                if (max2 < 1.0f / a2) {
                    i9 = max2 << 1;
                }
            }
        } else {
            i9 = 1;
        }
        options.inSampleSize = i9;
        if (imageType == ImageHeaderParser.ImageType.JPEG) {
            float min = Math.min(i9, 8);
            int ceil = (int) Math.ceil(f2 / min);
            int ceil2 = (int) Math.ceil(f3 / min);
            int i13 = i9 / 8;
            i10 = ceil2;
            floor = ceil;
            if (i13 > 0) {
                floor = ceil / i13;
                i10 = ceil2 / i13;
            }
        } else {
            if (imageType == ImageHeaderParser.ImageType.PNG || imageType == ImageHeaderParser.ImageType.PNG_A) {
                float f4 = i9;
                floor = (int) Math.floor(f2 / f4);
                floor2 = Math.floor(f3 / f4);
            } else if (imageType == ImageHeaderParser.ImageType.WEBP || imageType == ImageHeaderParser.ImageType.WEBP_A) {
                if (Build.VERSION.SDK_INT >= 24) {
                    float f5 = i9;
                    floor = Math.round(f2 / f5);
                    i10 = Math.round(f3 / f5);
                } else {
                    float f6 = i9;
                    floor = (int) Math.floor(f2 / f6);
                    floor2 = Math.floor(f3 / f6);
                }
            } else if (i7 % i9 == 0 && i8 % i9 == 0) {
                floor = i7 / i9;
                i10 = i8 / i9;
            } else {
                int[] a3 = a(imageReader, options, decodeCallbacks, bitmapPool);
                floor = a3[0];
                i10 = a3[1];
            }
            i10 = (int) floor2;
        }
        double a4 = downsampleStrategy.a(floor, i10, i5, i6);
        if (Build.VERSION.SDK_INT >= 19) {
            options.inTargetDensity = a(a4);
            options.inDensity = b(a4);
        }
        if (a(options)) {
            options.inScaled = true;
        } else {
            options.inTargetDensity = 0;
            options.inDensity = 0;
        }
        if (Log.isLoggable("Downsampler", 2)) {
            Log.v("Downsampler", "Calculate scaling, source: [" + i3 + "x" + i4 + "], degreesToRotate: " + i2 + ", target: [" + i5 + "x" + i6 + "], power of two scaled: [" + floor + "x" + i10 + "], exact scale factor: " + a2 + ", power of 2 sample size: " + i9 + ", adjusted scale factor: " + a4 + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
        }
    }

    private void a(ImageReader imageReader, DecodeFormat decodeFormat, boolean z, boolean z2, BitmapFactory.Options options, int i2, int i3) {
        boolean z3;
        if (this.n.a(i2, i3, options, z, z2)) {
            return;
        }
        if (decodeFormat == DecodeFormat.PREFER_ARGB_8888 || Build.VERSION.SDK_INT == 16) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return;
        }
        try {
            z3 = imageReader.a().hasAlpha();
        } catch (IOException e2) {
            z3 = false;
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e2);
                z3 = false;
            }
        }
        options.inPreferredConfig = z3 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        if (options.inPreferredConfig == Bitmap.Config.RGB_565) {
            options.inDither = true;
        }
    }

    private static boolean a(int i2) {
        return i2 == 90 || i2 == 270;
    }

    private static boolean a(BitmapFactory.Options options) {
        return options.inTargetDensity > 0 && options.inDensity > 0 && options.inTargetDensity != options.inDensity;
    }

    private boolean a(ImageHeaderParser.ImageType imageType) {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return h.contains(imageType);
    }

    private static int[] a(ImageReader imageReader, BitmapFactory.Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool) throws IOException {
        options.inJustDecodeBounds = true;
        b(imageReader, options, decodeCallbacks, bitmapPool);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static int b(double d2) {
        if (d2 > 1.0d) {
            d2 = 1.0d / d2;
        }
        return (int) Math.round(d2 * 2.147483647E9d);
    }

    private static Bitmap b(ImageReader imageReader, BitmapFactory.Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool) throws IOException {
        if (!options.inJustDecodeBounds) {
            decodeCallbacks.a();
            imageReader.c();
        }
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        String str = options.outMimeType;
        TransformationUtils.a().lock();
        try {
            try {
                Bitmap a2 = imageReader.a(options);
                TransformationUtils.a().unlock();
                return a2;
            } catch (IllegalArgumentException e2) {
                IOException a3 = a(e2, i2, i3, str, options);
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", a3);
                }
                if (options.inBitmap != null) {
                    try {
                        bitmapPool.a(options.inBitmap);
                        options.inBitmap = null;
                        Bitmap b2 = b(imageReader, options, decodeCallbacks, bitmapPool);
                        TransformationUtils.a().unlock();
                        return b2;
                    } catch (IOException e3) {
                        throw a3;
                    }
                }
                throw a3;
            }
        } catch (Throwable th) {
            TransformationUtils.a().unlock();
            throw th;
        }
    }

    private static String b(BitmapFactory.Options options) {
        return a(options.inBitmap);
    }

    private static int c(double d2) {
        return (int) (d2 + 0.5d);
    }

    private static void c(BitmapFactory.Options options) {
        d(options);
        synchronized (i) {
            i.offer(options);
        }
    }

    private static void d(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public Resource<Bitmap> a(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, Options options) throws IOException {
        return a(new ImageReader.ParcelFileDescriptorImageReader(parcelFileDescriptor, this.m, this.l), i2, i3, options, g);
    }

    public Resource<Bitmap> a(InputStream inputStream, int i2, int i3, Options options) throws IOException {
        return a(inputStream, i2, i3, options, g);
    }

    public Resource<Bitmap> a(InputStream inputStream, int i2, int i3, Options options, DecodeCallbacks decodeCallbacks) throws IOException {
        return a(new ImageReader.InputStreamImageReader(inputStream, this.m, this.l), i2, i3, options, decodeCallbacks);
    }

    public boolean a(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.c();
    }

    public boolean a(InputStream inputStream) {
        return true;
    }

    public boolean a(ByteBuffer byteBuffer) {
        return true;
    }
}
