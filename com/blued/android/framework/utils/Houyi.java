package com.blued.android.framework.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/Houyi.class */
public class Houyi implements Handler.Callback {
    private String a;
    private String b;
    private OnCompressListener c;
    private Handler d;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/Houyi$Builder.class */
    public static class Builder {
        private String a;
        private String b;
        private OnCompressListener c;

        private Houyi c() {
            return new Houyi(this);
        }

        public Builder a(OnCompressListener onCompressListener) {
            this.c = onCompressListener;
            return this;
        }

        public Builder a(String str) {
            this.a = str;
            return this;
        }

        public Builder a(String str, String str2) {
            this.a = str;
            this.b = str2;
            return this;
        }

        public void a() {
            c().b();
        }

        public boolean b() {
            return c().c();
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/Houyi$OnCompressListener.class */
    public interface OnCompressListener {
        void a();

        void a(String str);

        void a(Throwable th);
    }

    private Houyi(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = new Handler(Looper.getMainLooper(), this);
    }

    private static Bitmap a(int i, Bitmap bitmap) {
        Log.v("Houyi", "rotaingImageView bitmap = " + bitmap);
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private Bitmap a(Bitmap bitmap, float f) {
        Bitmap bitmap2;
        Log.v("Houyi", "scaleImg");
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() >= bitmap.getHeight() && bitmap.getWidth() > f) {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) f, (int) ((bitmap.getHeight() * f) / bitmap.getWidth()), true);
            bitmap2 = createScaledBitmap;
            if (bitmap != null) {
                bitmap2 = createScaledBitmap;
                if (!bitmap.isRecycled()) {
                    bitmap2 = createScaledBitmap;
                    if (!bitmap.equals(createScaledBitmap)) {
                        bitmap.recycle();
                        bitmap2 = createScaledBitmap;
                    }
                }
            }
        } else if (bitmap.getHeight() <= bitmap.getWidth() || bitmap.getHeight() <= f) {
            return bitmap;
        } else {
            Bitmap createScaledBitmap2 = Bitmap.createScaledBitmap(bitmap, (int) ((bitmap.getWidth() * f) / bitmap.getHeight()), (int) f, true);
            bitmap2 = createScaledBitmap2;
            if (bitmap != null) {
                bitmap2 = createScaledBitmap2;
                if (!bitmap.isRecycled()) {
                    bitmap2 = createScaledBitmap2;
                    if (!bitmap.equals(createScaledBitmap2)) {
                        bitmap.recycle();
                        bitmap2 = createScaledBitmap2;
                    }
                }
            }
        }
        return bitmap2;
    }

    /* JADX WARN: Removed duplicated region for block: B:94:0x01f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.graphics.Bitmap a(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 519
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.framework.utils.Houyi.a(java.lang.String):android.graphics.Bitmap");
    }

    public static Builder a() {
        return new Builder();
    }

    private static boolean a(Bitmap bitmap, String str, int i) {
        Log.v("Houyi", "compressBmpToFile bmp = " + bitmap);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean z = false;
        try {
            boolean compress = bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
            StringBuilder sb = new StringBuilder();
            sb.append("compressBmpToFile isCompressSuccess = ");
            sb.append(compress);
            Log.v("Houyi", sb.toString());
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("compressBmpToFile baos.size() = ");
            sb2.append(byteArrayOutputStream.size());
            Log.v("Houyi", sb2.toString());
            fileOutputStream.flush();
            z = compress;
            fileOutputStream.close();
            return compress;
        } catch (Exception e) {
            Log.v("Houyi", "compressBmpToFile e = " + e.toString());
            return z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, String str2) {
        Bitmap a = a(str);
        if (a == null) {
            return false;
        }
        Bitmap a2 = a(b(str), a);
        if (a2 != null) {
            if (a2 != a && a != null && !a.isRecycled()) {
                a.recycle();
            }
            a = a2;
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        boolean a3 = a(a, str, 90);
        if (a != null && !a.isRecycled()) {
            a.recycle();
        }
        return a3;
    }

    private static int b(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt != 3) {
                if (attributeInt != 6) {
                    return attributeInt != 8 ? 0 : 270;
                }
                return 90;
            }
            return 180;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        OnCompressListener onCompressListener;
        if (TextUtils.isEmpty(this.a) && (onCompressListener = this.c) != null) {
            onCompressListener.a(new RuntimeException("image originalPath cannot be null"));
        }
        new Thread(new Runnable() { // from class: com.blued.android.framework.utils.Houyi.1
            @Override // java.lang.Runnable
            public void run() {
                Houyi.this.d.sendMessage(Houyi.this.d.obtainMessage(1));
                Houyi houyi = Houyi.this;
                if (houyi.a(houyi.a, Houyi.this.b)) {
                    Houyi.this.d.sendMessage(Houyi.this.d.obtainMessage(0, !TextUtils.isEmpty(Houyi.this.b) ? Houyi.this.b : Houyi.this.a));
                } else {
                    Houyi.this.d.sendMessage(Houyi.this.d.obtainMessage(2, new RuntimeException("Image processing exception, please try again later.")));
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        return a(this.a, this.b);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.c == null) {
            return false;
        }
        int i = message.what;
        if (i == 0) {
            this.c.a((String) message.obj);
            return false;
        } else if (i == 1) {
            this.c.a();
            return false;
        } else if (i != 2) {
            return false;
        } else {
            this.c.a((Throwable) message.obj);
            return false;
        }
    }
}
