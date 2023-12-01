package com.tencent.open;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.open.a.f;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/e.class */
public class e extends AsyncTask<Bitmap, Void, HashMap<String, Object>> {

    /* renamed from: a  reason: collision with root package name */
    private static final SimpleDateFormat f38266a = new SimpleDateFormat("yyyy-MM-dd-HHmmss", Locale.CHINA);
    private a b;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/e$a.class */
    public interface a {
        void a(String str);

        void b(String str);
    }

    public e(a aVar) {
        this.b = aVar;
    }

    private int a(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 > i2 || i4 > i) {
            int round = Math.round(i3 / i2);
            int round2 = Math.round(i4 / i);
            int i5 = round2;
            if (round < round2) {
                i5 = round;
            }
            return i5;
        }
        return 1;
    }

    private Bitmap a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        if (byteArrayOutputStream.toByteArray().length / 1024 > 1024) {
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i = 1;
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeStream(byteArrayInputStream, null, options);
        } catch (OutOfMemoryError e) {
            f.c("openSDK_LOG.VoiceHelper", "VoiceHelper decodeStream has OutOfMemoryError!");
        }
        options.inJustDecodeBounds = false;
        int a2 = a(options, 320, 320);
        if (a2 > 0) {
            i = a2;
        }
        f.c("openSDK_LOG.VoiceHelper", "comp be=" + i);
        options.inSampleSize = i;
        try {
            return BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), null, options);
        } catch (OutOfMemoryError e2) {
            f.c("openSDK_LOG.VoiceHelper", "VoiceHelper decodeStream has OutOfMemoryError!");
            return null;
        }
    }

    private String a(long j) {
        return f38266a.format(new Date(j));
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
        }
    }

    public static boolean a() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED) || new File("/mnt/sdcard-ext").isDirectory();
    }

    private String b() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED) ? Environment.getExternalStorageDirectory().getAbsolutePath() : new File("/mnt/sdcard-ext").isDirectory() ? "/mnt/sdcard-ext" : ".";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String b(Bitmap bitmap) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        String str;
        try {
            try {
                String str2 = b() + File.separator + ".AppCenterWebBuffer";
                str = str2 + File.separator + (a(System.currentTimeMillis()) + ".png");
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(str);
                if (file2.exists()) {
                    file2.delete();
                }
                file2.createNewFile();
                fileOutputStream2 = new FileOutputStream(file2);
            } catch (Exception e) {
                fileOutputStream2 = null;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream2);
                fileOutputStream2.flush();
                fileOutputStream2.close();
                return str;
            } catch (Exception e2) {
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                    return "";
                }
                return "";
            } catch (Throwable th2) {
                fileOutputStream = fileOutputStream2;
                th = th2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
                throw th;
            }
        } catch (IOException e4) {
            return bitmap;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public HashMap<String, Object> doInBackground(Bitmap... bitmapArr) {
        String b;
        HashMap<String, Object> hashMap = new HashMap<>();
        Bitmap bitmap = bitmapArr[0];
        if (bitmap != null) {
            try {
                if (bitmap.getWidth() <= 320 && bitmap.getHeight() <= 320) {
                    b = b(bitmap);
                    bitmap.recycle();
                    hashMap.put("ResultType", 1);
                    hashMap.put("ResultValue", b);
                    return hashMap;
                }
                Bitmap a2 = a(bitmap);
                b = b(a2);
                a2.recycle();
                bitmap.recycle();
                hashMap.put("ResultType", 1);
                hashMap.put("ResultValue", b);
                return hashMap;
            } catch (Exception e) {
                hashMap.put("ResultType", 0);
                hashMap.put("ResultValue", e.getMessage());
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(HashMap<String, Object> hashMap) {
        if (((Integer) hashMap.get("ResultType")).intValue() == 1) {
            this.b.a((String) hashMap.get("ResultValue"));
        } else {
            this.b.b((String) hashMap.get("ResultValue"));
        }
        super.onPostExecute(hashMap);
    }
}
