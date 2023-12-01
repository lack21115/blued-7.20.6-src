package com.baidu.idl.license;

import android.content.Context;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/idl/license/LicenseReaderUtils.class */
class LicenseReaderUtils {
    public static final String TAG = "License-SDK";

    LicenseReaderUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.io.InputStream] */
    public static InputStream get_local_license_file_inputstream(Context context, String str) {
        if (context == null) {
            return null;
        }
        FileInputStream read_license_from_data = read_license_from_data(context, str);
        Log.e("License-SDK", "read_license_from_data");
        FileInputStream fileInputStream = read_license_from_data;
        if (read_license_from_data == null) {
            Log.e("License-SDK", "read_license_from_asset");
            fileInputStream = read_license_from_asset(context, str);
        }
        return fileInputStream;
    }

    private static ArrayList<String> read_license_content(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayList<String> arrayList = new ArrayList<>();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return arrayList;
            }
            arrayList.add(readLine);
        }
    }

    private static InputStream read_license_from_asset(Context context, String str) {
        if (context == null) {
            Log.e("License-SDK", "read_license_from_asset context is null");
            return null;
        }
        try {
            return context.getAssets().open(str);
        } catch (IOException e) {
            Log.e("License-SDK", "read_license_from_asset IOException");
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            Log.e("License-SDK", "read_license_from_asset Exception " + e2.getMessage());
            e2.printStackTrace();
            return null;
        }
    }

    private static FileInputStream read_license_from_data(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            File dir = context.getDir(str, 0);
            if (dir != null && dir.exists() && dir.isFile()) {
                if (dir.length() == 0) {
                    Log.e("License-SDK", "read_license_from_data file is empty");
                    return null;
                }
                return new FileInputStream(dir);
            }
            Log.e("License-SDK", "read_license_from_data file not found");
            return null;
        } catch (FileNotFoundException e) {
            Log.e("License-SDK", "read_license_from_data FileNotFoundException");
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            Log.e("License-SDK", "read_license_from_data Exception " + e2.getMessage());
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19, types: [java.io.FileOutputStream] */
    public static boolean write_license_content(Context context, String str, ArrayList<String> arrayList) {
        FileOutputStream fileOutputStream;
        Log.e("License-SDK", "write_license_content");
        if (arrayList == null || arrayList.size() == 0 || context == null) {
            return false;
        }
        File dir = context.getDir(str, 0);
        if (dir != null && dir.exists()) {
            dir.delete();
        }
        if (dir != null && !dir.exists()) {
            try {
                dir.createNewFile();
            } catch (IOException e) {
                Log.e("License-SDK", "write_license_content IOException");
                e.printStackTrace();
            }
        }
        FileOutputStream e2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(dir);
                    try {
                        Iterator<String> it = arrayList.iterator();
                        while (it.hasNext()) {
                            fileOutputStream.write(it.next().getBytes());
                            fileOutputStream.write(10);
                        }
                        fileOutputStream.close();
                        return true;
                    } catch (FileNotFoundException e3) {
                        e = e3;
                        Log.e("License-SDK", "write_license_content FileNotFoundException");
                        FileOutputStream fileOutputStream2 = fileOutputStream;
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                            return false;
                        }
                        return false;
                    } catch (IOException e4) {
                        e = e4;
                        Log.e("License-SDK", "write_license_content IOException");
                        FileOutputStream fileOutputStream3 = fileOutputStream;
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                            return false;
                        }
                        return false;
                    } catch (Throwable th) {
                        e2 = fileOutputStream;
                        th = th;
                        if (e2 != null) {
                            try {
                                e2.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e6) {
                    e = e6;
                    fileOutputStream = null;
                } catch (IOException e7) {
                    e = e7;
                    fileOutputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e8) {
            e2 = e8;
            e2.printStackTrace();
            return false;
        }
    }
}
