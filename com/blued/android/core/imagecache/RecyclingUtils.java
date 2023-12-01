package com.blued.android.core.imagecache;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.alipay.sdk.cons.b;
import com.android.internal.telephony.PhoneConstants;
import com.anythink.core.common.l;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.FailReason;
import com.blued.android.core.imagecache.drawable.IRecyclingDrawable;
import com.blued.android.core.imagecache.drawable.RecyclingBitmapDrawable;
import com.blued.android.core.imagecache.glide.Util;
import com.blued.android.core.net.BinaryHttpResponseHandler;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.utils.ByteArrayPool;
import com.blued.android.core.utils.Log;
import com.blued.android.core.utils.Md5;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import pl.droidsonroids.gif.GifDrawable;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/RecyclingUtils.class */
public class RecyclingUtils {

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/RecyclingUtils$CropType.class */
    public enum CropType {
        CROP_NOTHING,
        CROP_HEAD,
        CROP_MIDDLE
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/RecyclingUtils$ImageBinaryDownloadResponse.class */
    public static abstract class ImageBinaryDownloadResponse extends BinaryHttpResponseHandler {
        protected Drawable e;
        protected Throwable f;

        private ImageBinaryDownloadResponse() {
            this.e = null;
            this.f = null;
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/RecyclingUtils$Scheme.class */
    public enum Scheme {
        HTTP("http"),
        HTTPS(b.a),
        FILE("file"),
        CONTENT(l.y),
        ASSETS("assets"),
        DRAWABLE("drawable"),
        UNKNOWN("");
        
        private String h;
        private String i;

        Scheme(String str) {
            this.h = str;
            this.i = str + "://";
        }

        public static Scheme a(String str) {
            if (str != null) {
                Scheme[] values = values();
                int length = values.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    Scheme scheme = values[i2];
                    if (scheme.d(str)) {
                        return scheme;
                    }
                    i = i2 + 1;
                }
            }
            return UNKNOWN;
        }

        private boolean d(String str) {
            return str.startsWith(this.i);
        }

        public String b(String str) {
            return this.i + str;
        }

        public String c(String str) {
            if (d(str)) {
                return str.substring(this.i.length());
            }
            throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", str, this.h));
        }
    }

    public static int a(float f) {
        if (f < 0.05f || f > 0.8f) {
            throw new IllegalArgumentException("setMemCacheSizePercent - percent must be between 0.05 and 0.8 (inclusive)");
        }
        return Math.round(f * ((float) Runtime.getRuntime().maxMemory()));
    }

    public static int a(RecyclingBitmapDrawable recyclingBitmapDrawable) {
        Bitmap bitmap = recyclingBitmapDrawable.getBitmap();
        return AppMethods.c(12) ? bitmap.getByteCount() : bitmap.getRowBytes() * bitmap.getHeight();
    }

    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int indexOf = str.indexOf(BridgeUtil.UNDERLINE_STR);
        if (indexOf > 0) {
            try {
                return Integer.parseInt(str.substring(0, indexOf));
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        try {
            return Integer.valueOf(str).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static Drawable a(Context context, String str, LoadOptions loadOptions) {
        if (ImageLoaderUtils.a) {
            Log.a("IMAGE_LOADER", "decodeLocalDrawable(), uri:" + str);
        }
        return a(str, loadOptions, context.getResources());
    }

    public static Drawable a(String str, LoadOptions loadOptions, Resources resources) {
        Drawable drawable;
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        if (ImageLoaderUtils.a) {
            Log.a("IMAGE_LOADER", "decodeRemoteDrawable(), uri:" + str);
        }
        int a = a(Scheme.DRAWABLE.c(str));
        if (loadOptions.k) {
            try {
                return new GifDrawable(resources, a);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, a, options);
        boolean b = b();
        BitmapFactory.Options a2 = ImageLoaderUtils.a(options, b);
        a2.inSampleSize = ImageLoaderUtils.a(a2.outWidth, a2.outHeight, loadOptions.f);
        Bitmap bitmap4 = null;
        int i = 0;
        while (true) {
            drawable = null;
            bitmap = bitmap4;
            if (i > 3) {
                break;
            }
            i++;
            if (b) {
                bitmap2 = bitmap4;
                bitmap3 = bitmap4;
                try {
                    a(a2);
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                    drawable = null;
                    bitmap = bitmap3;
                    if (!c(a2)) {
                        break;
                    }
                    Log.e("IMAGE_LOADER", "inBitmap cause exception, cancel it and retry");
                    b = false;
                    bitmap4 = bitmap3;
                } catch (OutOfMemoryError e3) {
                    e3.printStackTrace();
                    MemoryRequest.a().b();
                    a2.inSampleSize *= 2;
                    bitmap4 = bitmap2;
                }
            }
            Bitmap bitmap5 = bitmap4;
            Bitmap decodeResource = BitmapFactory.decodeResource(resources, a, a2);
            drawable = null;
            bitmap = decodeResource;
            if (decodeResource != null) {
                break;
            }
            bitmap2 = decodeResource;
            bitmap3 = decodeResource;
            drawable = resources.getDrawable(a);
            bitmap = decodeResource;
            break;
        }
        if (bitmap != null) {
            RecyclingBitmapDrawable recyclingBitmapDrawable = new RecyclingBitmapDrawable(resources, bitmap);
            recyclingBitmapDrawable.a(str);
            recyclingBitmapDrawable.b = a2.outHeight;
            recyclingBitmapDrawable.a = a2.outWidth;
            recyclingBitmapDrawable.c = a2.inSampleSize;
            return recyclingBitmapDrawable;
        }
        return drawable;
    }

    public static Drawable a(String str, LoadOptions loadOptions, Handler handler, ImageLoadingListener imageLoadingListener) throws Throwable {
        boolean z;
        String d = d(str);
        File file = new File(d);
        if (file.exists() && file.length() > 0 && file.canRead()) {
            try {
                Drawable c = c(Scheme.FILE.b(d), loadOptions);
                if (c != null && (c instanceof IRecyclingDrawable)) {
                    ((IRecyclingDrawable) c).a(str);
                }
                return c;
            } finally {
                if (z) {
                }
            }
        }
        if (loadOptions.h) {
            if (loadOptions.m) {
                try {
                    return b(str, loadOptions, handler, imageLoadingListener);
                } catch (Throwable th) {
                    if (th instanceof LoadDrawableException) {
                        if (th.a == FailReason.FailType.NETWORK_DENIED) {
                            throw th;
                        }
                    } else if (th instanceof OutOfMemoryError) {
                        throw th;
                    }
                }
            }
            if (ImageLoaderUtils.a) {
                Log.b("IMAGE_LOADER", "download file failed, try to memory, uri:" + str);
            }
            return c(str, loadOptions, handler, imageLoadingListener);
        }
        return null;
    }

    public static Drawable a(String str, InputStream inputStream, LoadOptions loadOptions) throws Throwable {
        if (ImageLoaderUtils.a) {
            Log.a("IMAGE_LOADER", "decodeInputStreamToDrawable(), uri:" + str);
        }
        if (inputStream == null) {
            return null;
        }
        return a(str, AppMethods.a(inputStream), loadOptions);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable a(java.lang.String r5, byte[] r6, com.blued.android.core.imagecache.LoadOptions r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.core.imagecache.RecyclingUtils.a(java.lang.String, byte[], com.blued.android.core.imagecache.LoadOptions):android.graphics.drawable.Drawable");
    }

    public static File a(File file, String str) {
        if (file == null || !file.exists()) {
            return null;
        }
        File file2 = new File(d(str));
        file2.delete();
        file.renameTo(file2);
        return file2;
    }

    public static String a() {
        File externalFilesDir = AppInfo.d().getExternalFilesDir(null);
        if (externalFilesDir != null) {
            File file = new File(externalFilesDir, "img");
            if (!file.exists()) {
                file.mkdirs();
            }
            if (file.exists() && file.canRead() && file.canWrite()) {
                return file.getAbsolutePath();
            }
        }
        File cacheDir = AppInfo.d().getCacheDir();
        if (cacheDir != null) {
            File file2 = new File(cacheDir, "img");
            if (!file2.exists()) {
                file2.mkdirs();
            }
            if (file2.exists()) {
                return file2.getAbsolutePath();
            }
            return null;
        }
        return null;
    }

    public static String a(int i) {
        return String.valueOf(i);
    }

    public static String a(String str, LoadOptions loadOptions) {
        return str + PhoneConstants.APN_TYPE_ALL + loadOptions.f + PhoneConstants.APN_TYPE_ALL + loadOptions.k;
    }

    protected static void a(BitmapFactory.Options options) {
        if (options.inBitmap != null) {
            return;
        }
        if (!options.inPurgeable) {
            options.inMutable = true;
        }
        Bitmap b = b(options);
        if (b != null) {
            if (ImageLoaderUtils.a) {
                Log.b("IMAGE_LOADER", "Found bitmap to use for inBitmap");
            }
            options.inBitmap = b;
        }
    }

    private static boolean a(File file) {
        FileInputStream fileInputStream;
        FileNotFoundException e;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[13];
                    if (fileInputStream.read(bArr) != 13) {
                        AppMethods.b(fileInputStream);
                        return false;
                    }
                    boolean z = false;
                    if (bArr[0] == 82) {
                        z = false;
                        if (bArr[1] == 73) {
                            z = false;
                            if (bArr[2] == 70) {
                                z = false;
                                if (bArr[3] == 70) {
                                    z = false;
                                    if (bArr[8] == 87) {
                                        z = false;
                                        if (bArr[9] == 69) {
                                            z = false;
                                            if (bArr[10] == 66) {
                                                z = false;
                                                if (bArr[11] == 80) {
                                                    z = true;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    AppMethods.b(fileInputStream);
                    return z;
                } catch (FileNotFoundException e2) {
                    e = e2;
                    e.printStackTrace();
                    AppMethods.b(fileInputStream);
                    return false;
                } catch (IOException e3) {
                    e = e3;
                    e.printStackTrace();
                    AppMethods.b(fileInputStream);
                    return false;
                } catch (Throwable th) {
                    fileInputStream2 = fileInputStream;
                    th = th;
                    AppMethods.b(fileInputStream2);
                    throw th;
                }
            } catch (FileNotFoundException e4) {
                fileInputStream = null;
                e = e4;
            } catch (IOException e5) {
                e = e5;
                fileInputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean a(InputStream inputStream, File file) {
        byte[] bArr = null;
        byte[] bArr2 = null;
        byte[] bArr3 = null;
        try {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file, false);
                byte[] a = ByteArrayPool.a.a(1024);
                while (true) {
                    int read = inputStream.read(a);
                    if (read <= 0) {
                        fileOutputStream.close();
                        bArr = a;
                        bArr2 = a;
                        bArr3 = a;
                        inputStream.close();
                        ByteArrayPool.a.a(a);
                        return true;
                    }
                    fileOutputStream.write(a, 0, read);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                ByteArrayPool.a.a(bArr3);
                return false;
            } catch (IOException e2) {
                e2.printStackTrace();
                ByteArrayPool.a.a(bArr2);
                return false;
            }
        } catch (Throwable th) {
            ByteArrayPool.a.a(bArr);
            throw th;
        }
    }

    protected static Bitmap b(BitmapFactory.Options options) {
        Bitmap a;
        if (options.outHeight <= 0 || options.outWidth <= 0) {
            return null;
        }
        int i = options.outWidth / options.inSampleSize;
        int i2 = options.outHeight / options.inSampleSize;
        synchronized (RecyclingImageLoader.a().b) {
            a = RecyclingImageLoader.a().b.a(i, i2, options.inPreferredConfig);
        }
        return a;
    }

    public static Drawable b(String str, LoadOptions loadOptions) {
        return a(AppInfo.d(), str, loadOptions);
    }

    private static Drawable b(String str, LoadOptions loadOptions, final Handler handler, final ImageLoadingListener imageLoadingListener) throws Throwable {
        String str2;
        Object data;
        Log.a("IMAGE_LOADER", "decodeHttpToDrawable(), uri:" + str);
        File file = new File(e(str));
        if (file.exists()) {
            file.delete();
        }
        FileHttpResponseHandler fileHttpResponseHandler = new FileHttpResponseHandler() { // from class: com.blued.android.core.imagecache.RecyclingUtils.1
            private long c = 0;
            private int d = -1;
            private int e = 0;
            private long f = 0;

            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            /* renamed from: a */
            public void onSuccess(File file2) {
                if (file2 == null) {
                    Log.e("IMAGE_LOADER", "content is null");
                    return;
                }
                if (file2.length() != this.f) {
                    Log.e("IMAGE_LOADER", "文件长度下载不匹配, orgfileLength:" + this.f + ", downloadfileLength:" + file2.length());
                }
                setData(true);
            }

            /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
                if (r0.contains("No space left on device") != false) goto L15;
             */
            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onFailure(java.lang.Throwable r6, int r7, java.io.File r8) {
                /*
                    r5 = this;
                    r0 = r5
                    r1 = r6
                    r2 = r7
                    r3 = r8
                    super.onFailure(r1, r2, r3)
                    r0 = r6
                    boolean r0 = r0 instanceof java.net.UnknownHostException
                    if (r0 != 0) goto L69
                    r0 = r6
                    boolean r0 = r0 instanceof java.net.SocketTimeoutException
                    if (r0 != 0) goto L69
                    r0 = r6
                    boolean r0 = r0 instanceof java.net.SocketException
                    if (r0 == 0) goto L1f
                    goto L69
                L1f:
                    r0 = r6
                    boolean r0 = r0 instanceof java.io.IOException
                    if (r0 == 0) goto L5a
                    r0 = r6
                    java.io.IOException r0 = (java.io.IOException) r0
                    java.lang.String r0 = r0.getMessage()
                    r9 = r0
                    r0 = r6
                    r8 = r0
                    r0 = r9
                    boolean r0 = android.text.TextUtils.isEmpty(r0)
                    if (r0 != 0) goto L77
                    r0 = r9
                    java.lang.String r1 = "ENOSPC"
                    boolean r0 = r0.contains(r1)
                    if (r0 != 0) goto L4f
                    r0 = r6
                    r8 = r0
                    r0 = r9
                    java.lang.String r1 = "No space left on device"
                    boolean r0 = r0.contains(r1)
                    if (r0 == 0) goto L77
                L4f:
                    com.blued.android.core.imagecache.AutoClearImageDiskCache r0 = com.blued.android.core.imagecache.AutoClearImageDiskCache.a()
                    r0.b()
                    r0 = r6
                    r8 = r0
                    goto L77
                L5a:
                    com.blued.android.core.imagecache.LoadDrawableException r0 = new com.blued.android.core.imagecache.LoadDrawableException
                    r1 = r0
                    com.blued.android.core.imagecache.FailReason$FailType r2 = com.blued.android.core.imagecache.FailReason.FailType.NETWORK_DENIED
                    r3 = r6
                    r1.<init>(r2, r3)
                    r6 = r0
                    goto L75
                L69:
                    com.blued.android.core.imagecache.LoadDrawableException r0 = new com.blued.android.core.imagecache.LoadDrawableException
                    r1 = r0
                    com.blued.android.core.imagecache.FailReason$FailType r2 = com.blued.android.core.imagecache.FailReason.FailType.NETWORK_DENIED
                    r3 = r6
                    r1.<init>(r2, r3)
                    r6 = r0
                L75:
                    r0 = r6
                    r8 = r0
                L77:
                    r0 = r5
                    r1 = r8
                    r0.setData(r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.android.core.imagecache.RecyclingUtils.AnonymousClass1.onFailure(java.lang.Throwable, int, java.io.File):void");
            }

            @Override // com.blued.android.core.net.http.AbstractHttpResponseHandler
            public boolean onAccept(int i, long j) {
                this.f = j;
                return super.onAccept(i, j);
            }

            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onCancel() {
                super.onCancel();
            }

            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFinish() {
                super.onFinish();
            }

            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onProgress(final int i, final int i2) {
                int i3;
                super.onProgress(i, i2);
                ImageLoadingListener imageLoadingListener2 = ImageLoadingListener.this;
                if (imageLoadingListener2 == null || !imageLoadingListener2.a()) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if ((currentTimeMillis - this.c < this.e || i == this.d) && i != 100 && (i == (i3 = this.d) || i - i3 < 10)) {
                    return;
                }
                Handler handler2 = handler;
                if (handler2 != null) {
                    handler2.post(new Runnable() { // from class: com.blued.android.core.imagecache.RecyclingUtils.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ImageLoadingListener.this.a(i, i2);
                        }
                    });
                } else {
                    ImageLoadingListener.this.a(i, i2);
                }
                this.c = currentTimeMillis;
                this.d = i;
            }

            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onStart() {
                super.onStart();
                if (ImageLoadingListener.this != null) {
                    this.e = 10;
                }
            }
        };
        boolean z = loadOptions.a() && f(str);
        boolean z2 = false;
        while (true) {
            if (z) {
                str2 = str + ".webp";
            } else {
                str2 = str;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (ImageLoaderUtils.a) {
                Log.a("IMAGE_LOADER", "downloadTest, image downloading, downloadUrl:" + str2);
            }
            FileDownloader.a(str2, file.getAbsolutePath(), fileHttpResponseHandler);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (ImageLoaderUtils.a) {
                Log.a("IMAGE_LOADER", "downloadTest, downloadTime:" + (currentTimeMillis2 - currentTimeMillis) + ", downloadUrl:" + str2);
            }
            data = fileHttpResponseHandler.getData();
            if (data instanceof Boolean) {
                z2 = ((Boolean) data).booleanValue();
            }
            if (z2 || !z) {
                break;
            }
            z = false;
        }
        if (!file.exists() || !z2) {
            LoadDrawableException loadDrawableException = data instanceof Throwable ? (Throwable) data : null;
            LoadDrawableException loadDrawableException2 = loadDrawableException;
            if (loadDrawableException == null) {
                loadDrawableException2 = new LoadDrawableException(FailReason.FailType.NETWORK_DENIED, null);
            }
            throw loadDrawableException2;
        }
        File a = a(file, str);
        if (HttpManager.c()) {
            if (a(a)) {
                Log.a("IMAGE_LOADER", "webp file, url:" + str);
            } else {
                Log.a("IMAGE_LOADER", "not webp file, url:" + str);
            }
        }
        if (loadOptions.i) {
            try {
                Drawable c = c(Scheme.FILE.b(a.getAbsolutePath()), loadOptions);
                if (c != null && (c instanceof IRecyclingDrawable)) {
                    ((IRecyclingDrawable) c).a(str);
                }
                return c;
            } catch (Throwable th) {
                th.printStackTrace();
                throw th;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static InputStream b(String str) throws FileNotFoundException {
        return AppInfo.d().getContentResolver().openInputStream(Uri.parse(str));
    }

    public static boolean b() {
        return true;
    }

    public static int c() {
        int a = Util.a();
        int i = a;
        if (a <= 0) {
            i = 6;
        }
        if (ImageLoaderUtils.a) {
            Log.a("IMAGE_LOADER", "default thread count:" + i);
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 20, insn: 0x0353: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r20 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:104:0x0353 */
    /* JADX WARN: Removed duplicated region for block: B:118:0x035a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x033e  */
    /* JADX WARN: Type inference failed for: r0v47, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v93, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r18v2, types: [java.lang.IllegalArgumentException] */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v4, types: [java.lang.OutOfMemoryError] */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.lang.Object, java.lang.Exception] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable c(java.lang.String r5, com.blued.android.core.imagecache.LoadOptions r6) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 895
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.core.imagecache.RecyclingUtils.c(java.lang.String, com.blued.android.core.imagecache.LoadOptions):android.graphics.drawable.Drawable");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0020 -> B:8:0x0023). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.drawable.Drawable c(final java.lang.String r7, final com.blued.android.core.imagecache.LoadOptions r8, final android.os.Handler r9, final com.blued.android.core.imagecache.ImageLoadingListener r10) throws java.lang.Throwable {
        /*
            com.blued.android.core.imagecache.RecyclingUtils$2 r0 = new com.blued.android.core.imagecache.RecyclingUtils$2
            r1 = r0
            r2 = r10
            r3 = r9
            r4 = r7
            r5 = r8
            r1.<init>()
            r9 = r0
            r0 = r8
            boolean r0 = r0.a()
            if (r0 == 0) goto L20
            r0 = r7
            boolean r0 = f(r0)
            if (r0 == 0) goto L20
            r0 = 1
            r11 = r0
            goto L23
        L20:
            r0 = 0
            r11 = r0
        L23:
            r0 = r11
            if (r0 == 0) goto L46
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r8 = r0
            r0 = r8
            r1 = r7
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r8
            java.lang.String r1 = ".webp"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r8
            java.lang.String r0 = r0.toString()
            r8 = r0
            goto L48
        L46:
            r0 = r7
            r8 = r0
        L48:
            r0 = r8
            r1 = r9
            com.blued.android.core.net.http.FileDownloader.a(r0, r1)
            r0 = r9
            android.graphics.drawable.Drawable r0 = r0.e
            if (r0 != 0) goto L63
            r0 = r9
            java.lang.Throwable r0 = r0.f
            if (r0 == 0) goto L63
            r0 = r11
            if (r0 == 0) goto L63
            goto L20
        L63:
            r0 = r9
            android.graphics.drawable.Drawable r0 = r0.e
            if (r0 == 0) goto L6f
            r0 = r9
            android.graphics.drawable.Drawable r0 = r0.e
            return r0
        L6f:
            r0 = r9
            java.lang.Throwable r0 = r0.f
            r8 = r0
            r0 = r8
            r7 = r0
            r0 = r8
            if (r0 != 0) goto L86
            com.blued.android.core.imagecache.LoadDrawableException r0 = new com.blued.android.core.imagecache.LoadDrawableException
            r1 = r0
            com.blued.android.core.imagecache.FailReason$FailType r2 = com.blued.android.core.imagecache.FailReason.FailType.NETWORK_DENIED
            r3 = 0
            r1.<init>(r2, r3)
            r7 = r0
        L86:
            r0 = r7
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.core.imagecache.RecyclingUtils.c(java.lang.String, com.blued.android.core.imagecache.LoadOptions, android.os.Handler, com.blued.android.core.imagecache.ImageLoadingListener):android.graphics.drawable.Drawable");
    }

    public static InputStream c(String str) throws IOException {
        return AppInfo.d().getAssets().open(Scheme.ASSETS.c(str));
    }

    private static boolean c(BitmapFactory.Options options) {
        if (options.inBitmap != null) {
            options.inBitmap = null;
            return true;
        }
        return false;
    }

    public static String d(String str) {
        File externalFilesDir = AppInfo.d().getExternalFilesDir(null);
        if (externalFilesDir != null) {
            File file = new File(externalFilesDir, "img");
            if (file.exists() || file.mkdirs()) {
                return new File(file, Md5.a(str.toLowerCase().trim())).getAbsolutePath();
            }
        }
        File filesDir = AppInfo.d().getFilesDir();
        if (filesDir != null) {
            File file2 = new File(filesDir, "img");
            if (file2.exists() || file2.mkdirs()) {
                return new File(file2, Md5.a(str.toLowerCase().trim())).getAbsolutePath();
            }
            return null;
        }
        return null;
    }

    public static String e(String str) {
        File externalFilesDir = AppInfo.d().getExternalFilesDir(null);
        if (externalFilesDir != null) {
            File file = new File(externalFilesDir, "img");
            if (file.exists() || file.mkdirs()) {
                return new File(file, "temp_" + System.currentTimeMillis() + BridgeUtil.UNDERLINE_STR + Md5.a(str.toLowerCase().trim())).getAbsolutePath();
            }
        }
        File filesDir = AppInfo.d().getFilesDir();
        if (filesDir != null) {
            File file2 = new File(filesDir, "img");
            if (file2.exists() || file2.mkdirs()) {
                return new File(file2, "temp_" + System.currentTimeMillis() + BridgeUtil.UNDERLINE_STR + Md5.a(str.toLowerCase().trim())).getAbsolutePath();
            }
            return null;
        }
        return null;
    }

    public static boolean f(String str) {
        return true;
    }
}
