package com.baidu.aip.face.stat;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/face/stat/Dev.class */
public class Dev {
    private static final String INSTALLATION = "INSTALLATION";
    private String uniqueID = "";
    private String brand = "";
    private String sysVersion = "";
    private String packagename = "";
    private String sdkVersion = "2.1.0.0";
    private boolean firstRun = false;

    private String generateUniquePsuedoID(Context context) {
        String uuid;
        String str = BaseWrapper.ENTER_ID_OAPS_SPEECH_ASSIST + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10);
        try {
            uuid = Build.class.getField("SERIAL").get(null).toString();
        } catch (Exception e) {
            uuid = UUID.randomUUID().toString();
        }
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        String str2 = string;
        if ("9774d56d682e549c".equals(string)) {
            str2 = UUID.randomUUID().toString();
        }
        return md5(uuid + str2 + str);
    }

    public static String md5(String str) {
        try {
            String bigInteger = new BigInteger(1, MessageDigest.getInstance("MD5").digest(str.getBytes())).toString(16);
            while (bigInteger.length() < 32) {
                bigInteger = "0" + bigInteger;
            }
            return bigInteger;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private String readInstallationFile(File file) throws IOException {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(file, "r");
                try {
                    byte[] bArr = new byte[(int) randomAccessFile.length()];
                    randomAccessFile.readFully(bArr);
                    String str = new String(bArr);
                    randomAccessFile.close();
                    return str;
                } catch (Exception e) {
                    e = e;
                    randomAccessFile2 = randomAccessFile;
                    e.printStackTrace();
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                        return "";
                    }
                    return "";
                } catch (Throwable th) {
                    randomAccessFile2 = randomAccessFile;
                    th = th;
                    if (randomAccessFile2 != null) {
                        randomAccessFile2.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
            randomAccessFile = null;
        }
    }

    private void writeInstallationFile(Context context, String str) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(new File(context.getFilesDir(), INSTALLATION));
                    try {
                        fileOutputStream.write(str.getBytes());
                        fileOutputStream.close();
                    } catch (FileNotFoundException e) {
                        e = e;
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (IOException e2) {
                        e = e2;
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
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e4) {
                    e = e4;
                    fileOutputStream = null;
                } catch (IOException e5) {
                    e = e5;
                    fileOutputStream = null;
                }
            } catch (IOException e6) {
                e6.printStackTrace();
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public String getBrand() {
        return this.brand;
    }

    public boolean getFirstRun() {
        return this.firstRun;
    }

    public String getPackagename() {
        return this.packagename;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public String getSysVersion() {
        return this.sysVersion;
    }

    public String getUniqueID() {
        return this.uniqueID;
    }

    public String getUniqueIdFromFile(Context context) {
        String str;
        synchronized (this) {
            if (TextUtils.isEmpty(this.uniqueID)) {
                try {
                    this.uniqueID = readInstallationFile(new File(context.getFilesDir(), INSTALLATION));
                } catch (IOException e) {
                    e.printStackTrace();
                    this.uniqueID = "uncreate";
                }
            }
            str = this.uniqueID;
        }
        return str;
    }

    public void init(Context context) {
        if (context == null) {
            return;
        }
        this.brand = Build.MODEL.replace(" ", "");
        this.sysVersion = Build.VERSION.RELEASE;
        this.packagename = context.getPackageName();
        String uniqueIdFromFile = getUniqueIdFromFile(context);
        this.uniqueID = uniqueIdFromFile;
        if (TextUtils.isEmpty(uniqueIdFromFile)) {
            this.firstRun = true;
            String generateUniquePsuedoID = generateUniquePsuedoID(context);
            this.uniqueID = generateUniquePsuedoID;
            writeInstallationFile(context, generateUniquePsuedoID);
        }
    }

    public void setFirstRun(boolean z) {
        this.firstRun = z;
    }

    public void setSdkVersion(String str) {
        this.sdkVersion = str;
    }
}
