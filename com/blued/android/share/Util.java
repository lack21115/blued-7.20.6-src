package com.blued.android.share;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.anythink.core.common.b.g;
import com.blued.android.core.imagecache.MemoryRequest;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module_share_china.R;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/share/Util.class */
public class Util {
    private static final String TAG = "SDK_Sample.Util";

    public static byte[] bmpToByteArray(Bitmap bitmap, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        if (z) {
            bitmap.recycle();
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception e) {
            e.printStackTrace();
            return byteArray;
        }
    }

    public static byte[] getHtmlByteArray(String str) {
        InputStream inputStream;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            inputStream = null;
            if (httpURLConnection.getResponseCode() == 200) {
                inputStream = httpURLConnection.getInputStream();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            inputStream = null;
        } catch (IOException e2) {
            e2.printStackTrace();
            inputStream = null;
        }
        return inputStreamToByte(inputStream);
    }

    public static void hideProgressDialog(ProgressDialog progressDialog) {
        if (progressDialog != null) {
            progressDialog.cancel();
        }
    }

    public static Bitmap imageZoomToSize(Bitmap bitmap, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        double length = byteArrayOutputStream.toByteArray().length / 1024;
        Logger.b("xpf", "origin bitmap size___:" + length);
        double d = (double) i;
        if (length <= d || i <= 0) {
            return bitmap;
        }
        double d2 = length / d;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() / Math.sqrt(d2)), (int) (bitmap.getHeight() / Math.sqrt(d2)), true);
        if (bitmap != null && !bitmap.equals(createScaledBitmap)) {
            bitmap.recycle();
        }
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        createScaledBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream2);
        byte[] byteArray = byteArrayOutputStream2.toByteArray();
        Logger.b("xpf", "new bitmap size:" + (byteArray.length / 1024));
        return createScaledBitmap;
    }

    public static Bitmap imageZoomToSize(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            return decodeFile == null ? decodeFile : imageZoomToSize(decodeFile, i);
        } catch (OutOfMemoryError e) {
            MemoryRequest.a().b();
            return null;
        }
    }

    public static byte[] inputStreamToByte(InputStream inputStream) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = inputStream.read();
                if (read == -1) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
                byteArrayOutputStream.write(read);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isClientAvailable(Context context, String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static byte[] readFromFile(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            Logger.b(TAG, "readFromFile: file not found");
            return null;
        }
        int i3 = i2;
        if (i2 == -1) {
            i3 = (int) file.length();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("readFromFile : offset = ");
        sb.append(i);
        sb.append(" len = ");
        sb.append(i3);
        sb.append(" offset + len = ");
        int i4 = i + i3;
        sb.append(i4);
        Logger.c(TAG, sb.toString());
        if (i < 0) {
            Logger.e(TAG, "readFromFile invalid offset:" + i);
            return null;
        } else if (i3 <= 0) {
            Logger.e(TAG, "readFromFile invalid len:" + i3);
            return null;
        } else if (i4 > ((int) file.length())) {
            Logger.e(TAG, "readFromFile invalid file len:" + file.length());
            return null;
        } else {
            byte[] bArr = null;
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(str, g.o.o);
                byte[] bArr2 = new byte[i3];
                randomAccessFile.seek(i);
                randomAccessFile.readFully(bArr2);
                bArr = bArr2;
                randomAccessFile.close();
                return bArr2;
            } catch (Exception e) {
                Logger.e(TAG, "readFromFile : errMsg = " + e.getMessage());
                e.printStackTrace();
                return bArr;
            }
        }
    }

    public static File saveBitmapToFile(String str, Bitmap bitmap, int i, boolean z) {
        BufferedOutputStream bufferedOutputStream;
        if (bitmap == null) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        } else if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, i, bufferedOutputStream);
                        if (z) {
                            bitmap.recycle();
                        }
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        return file;
                    } catch (IOException e2) {
                        e = e2;
                        bufferedOutputStream2 = bufferedOutputStream;
                        e.printStackTrace();
                        if (bufferedOutputStream != null) {
                            if (z) {
                                bitmap.recycle();
                            }
                            bufferedOutputStream.flush();
                            bufferedOutputStream.close();
                            return file;
                        }
                        return file;
                    } catch (Throwable th) {
                        bufferedOutputStream2 = bufferedOutputStream;
                        th = th;
                        if (bufferedOutputStream2 != null) {
                            if (z) {
                                try {
                                    bitmap.recycle();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                    throw th;
                                }
                            }
                            bufferedOutputStream2.flush();
                            bufferedOutputStream2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e4) {
                e = e4;
                bufferedOutputStream = null;
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }

    public static String saveBitmapToLocal(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return "";
        }
        String str = RecyclingUtils.e("shareImg") + ".jpg";
        saveBitmapToFile(str, bitmap, 100, z);
        return str;
    }

    public static ProgressDialog showProgressDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(0);
        progressDialog.setTitle(context.getString(R.string.share_loading));
        progressDialog.setMessage(context.getString(R.string.initializing_content));
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.show();
        return progressDialog;
    }
}
