package com.tencent.qcloud.core.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/util/QCloudUtils.class */
public class QCloudUtils {
    public static boolean doesUriFileExist(Uri uri, ContentResolver contentResolver) {
        try {
            contentResolver.openFileDescriptor(uri, "r").close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public static long getUriContentLength(Uri uri, ContentResolver contentResolver) {
        String scheme = uri.getScheme();
        if (!"content".equals(scheme)) {
            if (ContentResolver.SCHEME_FILE.equals(scheme)) {
                return new File(uri.getPath()).length();
            }
            return -1L;
        }
        Cursor query = contentResolver.query(uri, null, null, null, null);
        if (query != null) {
            try {
                int columnIndex = query.getColumnIndex("_size");
                if (query.moveToFirst()) {
                    return query.getLong(columnIndex);
                }
                query.close();
                return -1L;
            } finally {
                query.close();
            }
        }
        return -1L;
    }

    public static long getUriContentLength2(Uri uri, ContentResolver contentResolver) {
        String scheme = uri.getScheme();
        if ("content".equals(scheme)) {
            return getUriContentLengthByRead(uri, contentResolver);
        }
        if (ContentResolver.SCHEME_FILE.equals(scheme)) {
            return new File(uri.getPath()).length();
        }
        return -1L;
    }

    private static long getUriContentLengthByRead(Uri uri, ContentResolver contentResolver) {
        InputStream inputStream = null;
        long j = null;
        try {
            try {
                InputStream openInputStream = contentResolver.openInputStream(uri);
                long j2 = 0;
                byte[] bArr = new byte[8192];
                while (true) {
                    j = openInputStream;
                    inputStream = openInputStream;
                    int read = openInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    j2 = j + read;
                }
                if (openInputStream != null) {
                    try {
                        openInputStream.close();
                        return j;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return j;
            } catch (Exception e2) {
                e2.printStackTrace();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return -1L;
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        return -1L;
                    }
                }
                return -1L;
            }
        } finally {
            if (j != null) {
                try {
                    j.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    private static long getUriContentLengthBySkip(Uri uri, ContentResolver contentResolver) {
        long j;
        InputStream inputStream = null;
        InputStream inputStream2 = null;
        try {
            try {
                InputStream openInputStream = contentResolver.openInputStream(uri);
                long j2 = 0;
                while (true) {
                    j = j2;
                    inputStream2 = openInputStream;
                    inputStream = openInputStream;
                    long skip = openInputStream.skip(8192);
                    if (skip == -1) {
                        break;
                    }
                    j2 = j + skip;
                }
                if (openInputStream != null) {
                    try {
                        openInputStream.close();
                        return j;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return j;
            } catch (Exception e2) {
                e2.printStackTrace();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return -1L;
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        return -1L;
                    }
                }
                return -1L;
            }
        } catch (Throwable th) {
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static boolean isNetworkConnected() {
        ConnectivityManager connectivityManager;
        Context appContext = ContextHolder.getAppContext();
        if (appContext == null || (connectivityManager = (ConnectivityManager) appContext.getSystemService(Context.CONNECTIVITY_SERVICE)) == null) {
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static boolean isNotEmpty(String str) {
        return !TextUtils.isEmpty(str);
    }

    public static byte[] readBytesFromFile(String str) {
        byte[] bArr = null;
        try {
            File file = new File(str);
            byte[] bArr2 = new byte[(int) file.length()];
            bArr = bArr2;
            new FileInputStream(file).read(bArr2);
            return bArr2;
        } catch (IOException e) {
            e.printStackTrace();
            return bArr;
        }
    }

    public static byte[] toBytes(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = null;
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            objectOutputStream.close();
            bArr = byteArray;
            byteArrayOutputStream.close();
            return byteArray;
        } catch (IOException e) {
            e.printStackTrace();
            return bArr;
        }
    }

    public static Object toObject(byte[] bArr) {
        Object obj = null;
        Object obj2 = null;
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Object readObject = objectInputStream.readObject();
            objectInputStream.close();
            obj = readObject;
            obj2 = readObject;
            byteArrayInputStream.close();
            return readObject;
        } catch (IOException e) {
            e.printStackTrace();
            return obj2;
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return obj;
        }
    }

    public static void writeToFile(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(str);
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e = e;
                        fileOutputStream2 = fileOutputStream;
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th) {
                        fileOutputStream2 = fileOutputStream;
                        th = th;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e3) {
                e = e3;
                fileOutputStream = null;
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }
}
