package com.blued.android.module.external_sense_library.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.android.internal.telephony.RILConstants;
import com.blued.android.module.external_sense_library.config.BluedFilterType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/utils/FileUtils.class */
public class FileUtils {
    public static File a(int i) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "Camera");
        if (!file.exists() && !file.mkdirs()) {
            LogUtils.d("FileUtil", "failed to create directory", new Object[0]);
            return null;
        }
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINESE).format(new Date());
        return new File(file.getPath() + File.separator + i + "_IMG_" + format + ".jpg");
    }

    public static String a() {
        return "models/M_SenseME_Face_Video_7.0.0.model";
    }

    public static String a(Context context, String str) {
        File externalFilesDir = context.getApplicationContext().getExternalFilesDir(null);
        if (externalFilesDir != null) {
            return externalFilesDir.getAbsolutePath() + File.separator + str;
        }
        return "";
    }

    public static String a(File file, File file2) {
        if (file == null || !file.exists() || file2 == null) {
            return "";
        }
        if (!file2.exists()) {
            file2.mkdir();
        }
        if (!file.isDirectory()) {
            return b(file, new File(file2.getAbsolutePath() + File.separator + file.getName()));
        }
        File[] listFiles = file.listFiles();
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return "";
            }
            File file3 = listFiles[i2];
            if (file3 != null) {
                File file4 = new File(file2.getAbsolutePath() + File.separator + file3.getName());
                return file3.isDirectory() ? a(file3, file4) : b(file3, file4);
            }
            i = i2 + 1;
        }
    }

    public static boolean a(Context context, String str, String str2) {
        String a = a(context, str2 + File.separator + str);
        if (a == null) {
            return true;
        }
        File file = new File(a);
        if (file.exists()) {
            return true;
        }
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            AssetManager assets = context.getAssets();
            InputStream open = assets.open(str2 + File.separator + str);
            if (open == null) {
                LogUtils.d("copyMode", "the src is not existed", new Object[0]);
                return false;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = open.read(bArr);
                if (read <= 0) {
                    open.close();
                    fileOutputStream.close();
                    return true;
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (IOException e) {
            file.delete();
            return false;
        }
    }

    private static String b(File file, File file2) {
        if (file != null) {
            try {
                if (file.exists() && file2 != null) {
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                    FileInputStream fileInputStream = new FileInputStream(file);
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    byte[] bArr = new byte[RILConstants.RIL_UNSOL_CDMA_OTA_PROVISION_STATUS];
                    while (true) {
                        int read = fileInputStream.read(bArr, 0, RILConstants.RIL_UNSOL_CDMA_OTA_PROVISION_STATUS);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    fileInputStream.close();
                }
            } catch (Exception e) {
                return "";
            }
        }
        return file2.getAbsolutePath();
    }

    public static Map<BluedFilterType.FILER, String> b(Context context, String str) {
        String[] strArr;
        File externalFilesDir;
        String str2;
        BluedFilterType.FILER a;
        HashMap hashMap = new HashMap();
        if (context == null) {
            return hashMap;
        }
        try {
            if (Build.VERSION.SDK_INT == 22 && Build.MANUFACTURER.toLowerCase().contains("oppo")) {
                strArr = new String[1];
                strArr[0] = str;
            } else {
                strArr = context.getAssets().list(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
            strArr = null;
        }
        if (context.getExternalFilesDir(null) != null) {
            String str3 = externalFilesDir.getAbsolutePath() + File.separator + str;
            File file = new File(str3);
            str2 = str3;
            if (!file.exists()) {
                file.mkdir();
                str2 = str3;
            }
        } else {
            str2 = "";
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                break;
            }
            String str4 = strArr[i2];
            if (str4.indexOf(".model") != -1) {
                a(context, str4, str);
            }
            i = i2 + 1;
        }
        if (TextUtils.isEmpty(str2)) {
            return hashMap;
        }
        File[] listFiles = new File(str2).listFiles();
        if (listFiles != null) {
            if (listFiles.length == 0) {
                return hashMap;
            }
            for (int i3 = 0; i3 < listFiles.length; i3++) {
                if (listFiles[i3] != null && !listFiles[i3].isDirectory()) {
                    String name = listFiles[i3].getName();
                    String absolutePath = listFiles[i3].getAbsolutePath();
                    listFiles[i3].getPath();
                    if (name.trim().toLowerCase().endsWith(".model") && name.indexOf("filter") != -1 && (a = FilterUitls.a(name)) != null) {
                        hashMap.put(a, absolutePath);
                    }
                }
            }
        }
        return hashMap;
    }

    public static List<String> c(Context context, String str) {
        String[] list;
        ArrayList arrayList = new ArrayList();
        try {
            if (Build.VERSION.SDK_INT == 22 && Build.MANUFACTURER.toLowerCase().contains("oppo")) {
                list = new String[1];
                list[0] = str;
            } else {
                list = context.getAssets().list(str);
            }
            for (String str2 : list) {
                if (str2.indexOf(".model") != -1) {
                    arrayList.add(str2);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
