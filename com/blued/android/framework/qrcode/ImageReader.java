package com.blued.android.framework.qrcode;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.google.common.base.Charsets;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.common.GlobalHistogramBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

/* loaded from: source-8756600-dex2jar.jar:com/blued/android/framework/qrcode/ImageReader.class */
public class ImageReader {

    /* renamed from: com.blued.android.framework.qrcode.ImageReader$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/blued/android/framework/qrcode/ImageReader$1.class */
    class AnonymousClass1 extends ThreadExecutor {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f6643a;
        final /* synthetic */ OnReadFinishListener b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Rect f6644c;
        final /* synthetic */ ImageReader d;

        public void execute() {
            String a2 = this.d.a(this.f6643a);
            if (!this.d.a(a2, this.f6643a)) {
                this.d.a(a2, this.f6644c, this.b);
            } else if (this.b != null) {
                AppInfo.n().post(new Runnable() { // from class: com.blued.android.framework.qrcode.ImageReader.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1.this.b.a(null, null);
                    }
                });
            }
        }
    }

    /* renamed from: com.blued.android.framework.qrcode.ImageReader$3  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/blued/android/framework/qrcode/ImageReader$3.class */
    class AnonymousClass3 extends ThreadExecutor {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f6648a;
        final /* synthetic */ Rect b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ OnReadFinishListener f6649c;
        final /* synthetic */ ImageReader d;

        public void execute() {
            this.d.a(this.f6648a, this.b, this.f6649c);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/blued/android/framework/qrcode/ImageReader$OnReadFinishListener.class */
    public interface OnReadFinishListener {
        void a(String str, String str2);
    }

    private SharedPreferences a() {
        if (AppInfo.d() != null) {
            return AppInfo.d().getSharedPreferences("qrcode_recent_list", 0);
        }
        return null;
    }

    private Bitmap a(String str, Rect rect) {
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                int i = 1;
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                options.inJustDecodeBounds = false;
                int i2 = options.outWidth;
                int i3 = options.outHeight;
                if (rect == null) {
                    int max = (int) (Math.max(i2, i3) / 1000.0f);
                    if (max > 0) {
                        i = max;
                    }
                    options.inSampleSize = i;
                    return BitmapFactory.decodeFile(str, options);
                }
                int i4 = (rect.left * i2) / 100;
                int i5 = (rect.top * i3) / 100;
                int i6 = ((rect.right - rect.left) * i2) / 100;
                int i7 = ((rect.bottom - rect.top) * i3) / 100;
                int i8 = i6;
                if (i4 + i6 > options.outWidth) {
                    i8 = options.outWidth - i4;
                }
                int i9 = i7;
                if (i5 + i7 > options.outHeight) {
                    i9 = options.outHeight - i5;
                }
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                Bitmap createBitmap = Bitmap.createBitmap(decodeFile, i4, i5, i8, i9);
                decodeFile.recycle();
                int max2 = Math.max(i8, i9);
                float f = max2 < 150 ? 2.0f : max2 > 500 ? 0.5f : 1.0f;
                return f != 1.0f ? Bitmap.createScaledBitmap(createBitmap, (int) (i8 * f), (int) (i9 * f), false) : createBitmap;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private Result a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            bitmap.recycle();
            BinaryBitmap binaryBitmap = new BinaryBitmap(new GlobalHistogramBinarizer(new RGBLuminanceSource(width, height, iArr)));
            QRCodeReader qRCodeReader = new QRCodeReader();
            Vector vector = new Vector();
            vector.add(BarcodeFormat.DATA_MATRIX);
            vector.add(BarcodeFormat.QR_CODE);
            vector.add(BarcodeFormat.AZTEC);
            Hashtable hashtable = new Hashtable(3);
            hashtable.put(DecodeHintType.POSSIBLE_FORMATS, vector);
            hashtable.put(DecodeHintType.CHARACTER_SET, "utf-8");
            hashtable.put(DecodeHintType.TRY_HARDER, true);
            return qRCodeReader.decode(binaryBitmap, hashtable);
        } catch (ChecksumException e) {
            e.printStackTrace();
            return null;
        } catch (FormatException e2) {
            e2.printStackTrace();
            return null;
        } catch (NotFoundException e3) {
            e3.printStackTrace();
            return null;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        } catch (OutOfMemoryError e5) {
            e5.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(long r10) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.framework.qrcode.ImageReader.a(long):java.lang.String");
    }

    private String a(String str) {
        String str2 = str;
        try {
            if (Charset.forName("ISO-8859-1").newEncoder().canEncode(str)) {
                return new String(str.getBytes(Charsets.ISO_8859_1), "GB2312");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            str2 = "";
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, Rect rect, final OnReadFinishListener onReadFinishListener) {
        Result a2;
        String a3 = (!a(rect) || (a2 = a(a(str, rect))) == null) ? null : a(a2.getText());
        if (onReadFinishListener != null) {
            final String str2 = a3;
            AppInfo.n().post(new Runnable() { // from class: com.blued.android.framework.qrcode.ImageReader.4
                @Override // java.lang.Runnable
                public void run() {
                    onReadFinishListener.a(str, str2);
                }
            });
        }
    }

    private boolean a(Rect rect) {
        if (rect != null) {
            return rect.left >= 0 && rect.top >= 0 && rect.right <= 100 && rect.bottom <= 100 && rect.left < rect.right && rect.top < rect.bottom;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, long j) {
        SharedPreferences a2;
        boolean z = false;
        if (TextUtils.isEmpty(str) || (a2 = a()) == null) {
            return false;
        }
        boolean z2 = false;
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<Map.Entry<String, ?>> it = a2.getAll().entrySet().iterator();
            while (true) {
                boolean z3 = z;
                if (!it.hasNext()) {
                    break;
                }
                boolean z4 = z;
                Map.Entry<String, ?> next = it.next();
                boolean z5 = z;
                String key = next.getKey();
                boolean z6 = z;
                if (!TextUtils.isEmpty(key)) {
                    boolean z7 = z;
                    if (System.currentTimeMillis() < Long.parseLong(key) + (j * 1000)) {
                        boolean z8 = z;
                        String obj = next.getValue().toString();
                        boolean z9 = z;
                        if (!TextUtils.isEmpty(obj)) {
                            boolean z10 = z;
                            if (TextUtils.equals(obj, str)) {
                                z = true;
                            }
                        }
                    } else {
                        arrayList.add(key);
                    }
                }
            }
            if (arrayList.size() > 0) {
                boolean z11 = z;
                SharedPreferences.Editor edit = a2.edit();
                boolean z12 = z;
                Iterator it2 = arrayList.iterator();
                while (true) {
                    boolean z13 = z;
                    if (!it2.hasNext()) {
                        break;
                    }
                    boolean z14 = z;
                    edit.remove((String) it2.next());
                }
                edit.commit();
                boolean z15 = z;
                arrayList.clear();
            }
            if (!z) {
                SharedPreferences.Editor edit2 = a2.edit();
                boolean z16 = z;
                edit2.putString(String.valueOf(System.currentTimeMillis()), str);
                z2 = z;
                edit2.commit();
            }
            return z;
        } catch (Exception e) {
            return z2;
        }
    }

    public void a(final String str, final OnReadFinishListener onReadFinishListener) {
        if (onReadFinishListener == null) {
            return;
        }
        ThreadManager.a().a(new ThreadExecutor("ReadImageQRCode") { // from class: com.blued.android.framework.qrcode.ImageReader.2
            public void execute() {
                ImageReader.this.a(str, (Rect) null, onReadFinishListener);
            }
        });
    }
}
