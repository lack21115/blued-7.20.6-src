package com.wrapper.proxyapplication;

import android.content.Context;
import android.os.Process;
import com.android.dex.DexFormat;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: source-63640-dex2jar.jar:com/wrapper/proxyapplication/Util.class */
public class Util {
    static final int ERROR_EXCEPTION = -2;
    static final int ERROR_FALSE = 0;
    static final int ERROR_FILE_EXIST = 2;
    static final int ERROR_FILE_NOT_FOUND = -1;
    static final int ERROR_FILE_NOT_FOUND_INZIP = -3;
    static final int ERROR_SUCCESS = 1;
    public static String libname;
    public static int MAX_DEX_NUM = 300;
    public static String TAG = "Util";
    public static String CPUABI = null;
    public static String simplelibname = "tosprotection";
    public static String securename0 = "00O000ll111l.dex";
    public static String securename1 = "00O000ll111l.jar";
    public static String securename2 = "000O00ll111l.dex";
    public static String securename3 = "0000000lllll.dex";
    public static String securename4 = "000000olllll.dex";
    public static String securename5 = "0OO00l111l1l";
    public static String securename6 = "o0oooOO0ooOo.dat";
    public static String securename7 = "exportService.txt";
    public static String securename8 = ".flag00O000ll111l.dex";
    public static String securename9 = ".updateIV.dat";
    public static String versionname = "tosversion";
    public static String securename11 = ".flag00O000ll111l.vdex";
    public static String securename14 = "00O000ll111l.vdex";
    public static String securename15 = "00O000ll111l.odex";
    public static String dexname = DexFormat.DEX_IN_JAR_NAME;
    public static boolean ifoverwrite = true;

    static {
        libname = "";
        libname = "shell-super.2019";
    }

    public static int Comparetxtinzip(ZipFile zipFile, String str, File file) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        ZipEntry entry = zipFile.getEntry(str);
        if (entry == null) {
            try {
                if (0 != 0) {
                    try {
                        throw new NullPointerException();
                    } catch (IOException e) {
                        e.printStackTrace();
                        if (0 != 0) {
                            try {
                                throw new NullPointerException();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                                return -2;
                            }
                        }
                        return -2;
                    }
                }
                return -3;
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        throw new NullPointerException();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        return -2;
                    }
                }
                throw th;
            }
        }
        BufferedInputStream bufferedInputStream3 = null;
        BufferedInputStream bufferedInputStream4 = null;
        try {
            try {
                byte[] bArr = new byte[1024];
                byte[] bArr2 = new byte[1024];
                bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(entry));
                try {
                    String substring = new String(bArr).substring(0, bufferedInputStream.read(bArr));
                    bufferedInputStream3 = new BufferedInputStream(new FileInputStream(file));
                    try {
                        int i = new String(bArr2).substring(0, bufferedInputStream3.read(bArr2)).equals(substring) ? 1 : 0;
                        try {
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                    if (bufferedInputStream3 != null) {
                                        try {
                                            bufferedInputStream3.close();
                                        } catch (IOException e4) {
                                            e4.printStackTrace();
                                            return -2;
                                        }
                                    }
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                    if (bufferedInputStream3 != null) {
                                        try {
                                            bufferedInputStream3.close();
                                            return -2;
                                        } catch (IOException e6) {
                                            e6.printStackTrace();
                                            return -2;
                                        }
                                    }
                                    return -2;
                                }
                            }
                            return i;
                        } catch (Throwable th2) {
                            if (bufferedInputStream3 != null) {
                                try {
                                    bufferedInputStream3.close();
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                    return -2;
                                }
                            }
                            throw th2;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        bufferedInputStream2 = bufferedInputStream3;
                        bufferedInputStream3 = bufferedInputStream2;
                        bufferedInputStream4 = bufferedInputStream;
                        e.printStackTrace();
                        if (bufferedInputStream != null) {
                            try {
                                try {
                                    bufferedInputStream.close();
                                    if (bufferedInputStream2 != null) {
                                        try {
                                            bufferedInputStream2.close();
                                            return -2;
                                        } catch (IOException e9) {
                                            e9.printStackTrace();
                                            return -2;
                                        }
                                    }
                                    return -2;
                                } catch (Throwable th3) {
                                    if (bufferedInputStream2 != null) {
                                        try {
                                            bufferedInputStream2.close();
                                        } catch (IOException e10) {
                                            e10.printStackTrace();
                                            return -2;
                                        }
                                    }
                                    throw th3;
                                }
                            } catch (IOException e11) {
                                e11.printStackTrace();
                                if (bufferedInputStream2 != null) {
                                    try {
                                        bufferedInputStream2.close();
                                        return -2;
                                    } catch (IOException e12) {
                                        e12.printStackTrace();
                                        return -2;
                                    }
                                }
                                return -2;
                            }
                        }
                        return -2;
                    } catch (Throwable th4) {
                        bufferedInputStream4 = bufferedInputStream;
                        th = th4;
                        try {
                            if (bufferedInputStream4 != null) {
                                try {
                                    bufferedInputStream4.close();
                                    if (bufferedInputStream3 != null) {
                                        try {
                                            bufferedInputStream3.close();
                                        } catch (IOException e13) {
                                            e13.printStackTrace();
                                            return -2;
                                        }
                                    }
                                } catch (IOException e14) {
                                    e14.printStackTrace();
                                    if (bufferedInputStream3 != null) {
                                        try {
                                            bufferedInputStream3.close();
                                            return -2;
                                        } catch (IOException e15) {
                                            e15.printStackTrace();
                                            return -2;
                                        }
                                    }
                                    return -2;
                                }
                            }
                            throw th;
                        } catch (Throwable th5) {
                            if (bufferedInputStream3 != null) {
                                try {
                                    bufferedInputStream3.close();
                                } catch (IOException e16) {
                                    e16.printStackTrace();
                                    return -2;
                                }
                            }
                            throw th5;
                        }
                    }
                } catch (Exception e17) {
                    e = e17;
                    bufferedInputStream2 = null;
                } catch (Throwable th6) {
                    bufferedInputStream3 = null;
                    bufferedInputStream4 = bufferedInputStream;
                    th = th6;
                }
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (Exception e18) {
            e = e18;
            bufferedInputStream = null;
            bufferedInputStream2 = null;
        }
    }

    public static String CreatenewFileName(String str, String str2, String str3) {
        int lastIndexOf = str.lastIndexOf(str2);
        if (lastIndexOf >= 0) {
            return String.valueOf(str.substring(0, lastIndexOf)) + str3 + str.substring(lastIndexOf, str.length());
        }
        return null;
    }

    public static int DeleteFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            return !file.delete() ? -2 : 1;
        }
        return -1;
    }

    public static int PrepareSecurefiles(Context context, ZipFile zipFile) {
        String str;
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        File file;
        int i;
        FileChannel fileChannel = null;
        FileChannel fileChannel2 = null;
        FileLock fileLock2 = null;
        RandomAccessFile randomAccessFile2 = null;
        File file2 = new File(String.valueOf(context.getFilesDir().getAbsolutePath()) + "/prodexdir");
        if (!file2.isDirectory()) {
            file2.mkdir();
        }
        String str2 = String.valueOf(str) + BridgeUtil.SPLIT_MARK + versionname;
        String str3 = String.valueOf(str) + "/backUp";
        String str4 = String.valueOf(str) + "/firstLoad";
        String str5 = "assets/" + versionname;
        String str6 = "libtosprotection." + CPUABI + ".so";
        try {
            try {
                randomAccessFile = new RandomAccessFile(str2, "rw");
                FileChannel fileChannel3 = null;
                FileLock fileLock3 = null;
                FileChannel fileChannel4 = null;
                FileLock fileLock4 = null;
                try {
                    fileChannel2 = randomAccessFile.getChannel();
                    fileLock = fileChannel2.lock();
                    fileChannel3 = fileChannel2;
                    fileLock3 = fileLock;
                    fileChannel4 = fileChannel2;
                    fileLock4 = fileLock;
                    file = new File(str2);
                } catch (Exception e) {
                    e = e;
                    fileChannel2 = fileChannel4;
                    fileLock = fileLock4;
                } catch (Throwable th) {
                    th = th;
                    fileChannel2 = fileChannel3;
                    fileLock = fileLock3;
                }
                try {
                    if (file.length() != 0) {
                        int Comparetxtinzip = Comparetxtinzip(zipFile, str5, file);
                        if (Comparetxtinzip == 1 && checkCopiedFileCrc(zipFile, "assets/" + securename5, new File(String.valueOf(str) + BridgeUtil.SPLIT_MARK + securename5)) && checkCopiedFileCrc(zipFile, "assets/" + securename6, new File(String.valueOf(str) + BridgeUtil.SPLIT_MARK + securename6))) {
                            ZipEntry entry = zipFile.getEntry("assets/" + str6);
                            if (entry != null && !isFileValid(String.valueOf(str) + BridgeUtil.SPLIT_MARK + libname, entry.getSize())) {
                                UnzipFile(zipFile, "assets/" + str6, new File(String.valueOf(str) + BridgeUtil.SPLIT_MARK + libname));
                            }
                            ZipEntry entry2 = zipFile.getEntry("assets/" + str6);
                            if (entry2 != null && !isFileValid(String.valueOf(str) + BridgeUtil.SPLIT_MARK + securename6, entry2.getSize())) {
                                UnzipFile(zipFile, "assets/" + securename6, new File(String.valueOf(str) + BridgeUtil.SPLIT_MARK + securename6));
                            }
                            ZipEntry entry3 = zipFile.getEntry("assets/" + str6);
                            if (entry3 != null && !isFileValid(String.valueOf(str) + BridgeUtil.SPLIT_MARK + securename7, entry3.getSize())) {
                                UnzipFile(zipFile, "assets/" + securename7, new File(String.valueOf(str) + BridgeUtil.SPLIT_MARK + securename7));
                            }
                            ZipEntry entry4 = zipFile.getEntry(str5);
                            if (entry4 != null && !isFileValid(str2, entry4.getSize())) {
                                UnzipFile(zipFile, str5, new File(str2));
                            }
                            try {
                                if (fileLock != null) {
                                    try {
                                        fileLock.release();
                                        try {
                                            if (fileChannel2 != null) {
                                                try {
                                                    fileChannel2.close();
                                                    if (randomAccessFile != null) {
                                                        try {
                                                            randomAccessFile.close();
                                                            return 2;
                                                        } catch (IOException e2) {
                                                            e2.printStackTrace();
                                                            return -1;
                                                        }
                                                    }
                                                    return 2;
                                                } catch (IOException e3) {
                                                    e3.printStackTrace();
                                                    if (randomAccessFile != null) {
                                                        try {
                                                            randomAccessFile.close();
                                                            return -1;
                                                        } catch (IOException e4) {
                                                            e4.printStackTrace();
                                                            return -1;
                                                        }
                                                    }
                                                    return -1;
                                                }
                                            }
                                            return 2;
                                        } catch (Throwable th2) {
                                            if (randomAccessFile != null) {
                                                try {
                                                    randomAccessFile.close();
                                                } catch (IOException e5) {
                                                    e5.printStackTrace();
                                                    return -1;
                                                }
                                            }
                                            throw th2;
                                        }
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                        if (fileChannel2 != null) {
                                            try {
                                                try {
                                                    fileChannel2.close();
                                                    if (randomAccessFile != null) {
                                                        try {
                                                            randomAccessFile.close();
                                                            return -1;
                                                        } catch (IOException e7) {
                                                            e7.printStackTrace();
                                                            return -1;
                                                        }
                                                    }
                                                    return -1;
                                                } catch (Throwable th3) {
                                                    if (randomAccessFile != null) {
                                                        try {
                                                            randomAccessFile.close();
                                                        } catch (IOException e8) {
                                                            e8.printStackTrace();
                                                            return -1;
                                                        }
                                                    }
                                                    throw th3;
                                                }
                                            } catch (IOException e9) {
                                                e9.printStackTrace();
                                                if (randomAccessFile != null) {
                                                    try {
                                                        randomAccessFile.close();
                                                        return -1;
                                                    } catch (IOException e10) {
                                                        e10.printStackTrace();
                                                        return -1;
                                                    }
                                                }
                                                return -1;
                                            }
                                        }
                                        return -1;
                                    }
                                }
                                return 2;
                            } catch (Throwable th4) {
                                try {
                                    if (fileChannel2 != null) {
                                        try {
                                            fileChannel2.close();
                                            if (randomAccessFile != null) {
                                                try {
                                                    randomAccessFile.close();
                                                } catch (IOException e11) {
                                                    e11.printStackTrace();
                                                    return -1;
                                                }
                                            }
                                        } catch (IOException e12) {
                                            e12.printStackTrace();
                                            if (randomAccessFile != null) {
                                                try {
                                                    randomAccessFile.close();
                                                    return -1;
                                                } catch (IOException e13) {
                                                    e13.printStackTrace();
                                                    return -1;
                                                }
                                            }
                                            return -1;
                                        }
                                    }
                                    throw th4;
                                } catch (Throwable th5) {
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.close();
                                        } catch (IOException e14) {
                                            e14.printStackTrace();
                                            return -1;
                                        }
                                    }
                                    throw th5;
                                }
                            }
                        } else if (Comparetxtinzip == -1 || Comparetxtinzip == -3) {
                            Process.killProcess(Process.myPid());
                            System.exit(0);
                        }
                    }
                    DeleteFile(String.valueOf(str) + BridgeUtil.SPLIT_MARK + libname);
                    DeleteFile(String.valueOf(str) + BridgeUtil.SPLIT_MARK + securename6);
                    int i2 = 0;
                    while (true) {
                        i = i2;
                        if (i < MAX_DEX_NUM) {
                            int DeleteFile = DeleteFile(String.valueOf(str) + BridgeUtil.SPLIT_MARK + CreatenewFileName(securename0, ".", BridgeUtil.UNDERLINE_STR + i));
                            int DeleteFile2 = DeleteFile(String.valueOf(str) + BridgeUtil.SPLIT_MARK + CreatenewFileName(securename1, ".", BridgeUtil.UNDERLINE_STR + i));
                            int DeleteFile3 = DeleteFile(String.valueOf(str) + BridgeUtil.SPLIT_MARK + "odexdir" + BridgeUtil.SPLIT_MARK + CreatenewFileName(securename0, ".", BridgeUtil.UNDERLINE_STR + i));
                            DeleteFile(String.valueOf(str) + BridgeUtil.SPLIT_MARK + "odexdir" + BridgeUtil.SPLIT_MARK + CreatenewFileName(securename8, ".", BridgeUtil.UNDERLINE_STR + i));
                            DeleteFile(String.valueOf(str) + BridgeUtil.SPLIT_MARK + "oat/arm" + BridgeUtil.SPLIT_MARK + CreatenewFileName(securename11, ".", BridgeUtil.UNDERLINE_STR + i));
                            DeleteFile(String.valueOf(str) + BridgeUtil.SPLIT_MARK + "oat/arm64" + BridgeUtil.SPLIT_MARK + CreatenewFileName(securename11, ".", BridgeUtil.UNDERLINE_STR + i));
                            DeleteFile(String.valueOf(str) + BridgeUtil.SPLIT_MARK + "oat/arm" + BridgeUtil.SPLIT_MARK + CreatenewFileName(securename14, ".", BridgeUtil.UNDERLINE_STR + i));
                            DeleteFile(String.valueOf(str) + BridgeUtil.SPLIT_MARK + "oat/arm" + BridgeUtil.SPLIT_MARK + CreatenewFileName(securename15, ".", BridgeUtil.UNDERLINE_STR + i));
                            DeleteFile(String.valueOf(str) + BridgeUtil.SPLIT_MARK + "oat/arm64" + BridgeUtil.SPLIT_MARK + CreatenewFileName(securename14, ".", BridgeUtil.UNDERLINE_STR + i));
                            DeleteFile(String.valueOf(str) + BridgeUtil.SPLIT_MARK + "oat/arm64" + BridgeUtil.SPLIT_MARK + CreatenewFileName(securename15, ".", BridgeUtil.UNDERLINE_STR + i));
                            if (-1 == DeleteFile && -1 == DeleteFile2 && -1 == DeleteFile3) {
                                break;
                            }
                            if (-2 == DeleteFile || -2 == DeleteFile2 || -2 == DeleteFile3) {
                                Process.killProcess(Process.myPid());
                                System.exit(0);
                            }
                            i2 = i + 1;
                        } else {
                            break;
                        }
                    }
                    DeleteFile(String.valueOf(str) + BridgeUtil.SPLIT_MARK + securename9);
                    DeleteFile(String.valueOf(str) + BridgeUtil.SPLIT_MARK + securename5);
                    UnzipFile(zipFile, "assets/" + securename5, new File(String.valueOf(str) + BridgeUtil.SPLIT_MARK + securename5));
                    UnzipFile(zipFile, "assets/" + libname, new File(String.valueOf(str) + BridgeUtil.SPLIT_MARK + libname));
                    UnzipFile(zipFile, "assets/" + securename6, new File(String.valueOf(str) + BridgeUtil.SPLIT_MARK + securename6));
                    UnzipFile(zipFile, "assets/" + securename7, new File(String.valueOf(str) + BridgeUtil.SPLIT_MARK + securename7));
                    UnzipFile(zipFile, str5, new File(str2));
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 < i) {
                            int DeleteFile4 = DeleteFile(String.valueOf(str3) + BridgeUtil.SPLIT_MARK + CreatenewFileName(securename0, ".", BridgeUtil.UNDERLINE_STR + i4));
                            int DeleteFile5 = DeleteFile(String.valueOf(str3) + BridgeUtil.SPLIT_MARK + CreatenewFileName(securename1, ".", BridgeUtil.UNDERLINE_STR + i4));
                            int DeleteFile6 = DeleteFile(String.valueOf(str3) + BridgeUtil.SPLIT_MARK + "odexdir" + BridgeUtil.SPLIT_MARK + CreatenewFileName(securename0, ".", BridgeUtil.UNDERLINE_STR + i4));
                            DeleteFile(String.valueOf(str3) + BridgeUtil.SPLIT_MARK + "odexdir" + BridgeUtil.SPLIT_MARK + CreatenewFileName(securename8, ".", BridgeUtil.UNDERLINE_STR + i4));
                            DeleteFile(String.valueOf(str3) + BridgeUtil.SPLIT_MARK + "oat/arm" + BridgeUtil.SPLIT_MARK + CreatenewFileName(securename11, ".", BridgeUtil.UNDERLINE_STR + i4));
                            DeleteFile(String.valueOf(str3) + BridgeUtil.SPLIT_MARK + "oat/arm64" + BridgeUtil.SPLIT_MARK + CreatenewFileName(securename11, ".", BridgeUtil.UNDERLINE_STR + i4));
                            DeleteFile(String.valueOf(str3) + BridgeUtil.SPLIT_MARK + "oat/arm" + BridgeUtil.SPLIT_MARK + CreatenewFileName(securename14, ".", BridgeUtil.UNDERLINE_STR + i4));
                            DeleteFile(String.valueOf(str3) + BridgeUtil.SPLIT_MARK + "oat/arm" + BridgeUtil.SPLIT_MARK + CreatenewFileName(securename15, ".", BridgeUtil.UNDERLINE_STR + i4));
                            DeleteFile(String.valueOf(str3) + BridgeUtil.SPLIT_MARK + "oat/arm64" + BridgeUtil.SPLIT_MARK + CreatenewFileName(securename14, ".", BridgeUtil.UNDERLINE_STR + i4));
                            DeleteFile(String.valueOf(str3) + BridgeUtil.SPLIT_MARK + "oat/arm64" + BridgeUtil.SPLIT_MARK + CreatenewFileName(securename15, ".", BridgeUtil.UNDERLINE_STR + i4));
                            if (-1 == DeleteFile4 && -1 == DeleteFile5 && -1 == DeleteFile6) {
                                break;
                            }
                            if (-2 == DeleteFile4 || -2 == DeleteFile5 || -2 == DeleteFile6) {
                                Process.killProcess(Process.myPid());
                                System.exit(0);
                            }
                            i3 = i4 + 1;
                        } else {
                            break;
                        }
                    }
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 < i) {
                            int DeleteFile7 = DeleteFile(String.valueOf(str4) + BridgeUtil.SPLIT_MARK + CreatenewFileName(securename0, ".", BridgeUtil.UNDERLINE_STR + i6));
                            int DeleteFile8 = DeleteFile(String.valueOf(str4) + BridgeUtil.SPLIT_MARK + CreatenewFileName(securename1, ".", BridgeUtil.UNDERLINE_STR + i6));
                            int DeleteFile9 = DeleteFile(String.valueOf(str4) + BridgeUtil.SPLIT_MARK + "odexdir" + BridgeUtil.SPLIT_MARK + CreatenewFileName(securename0, ".", BridgeUtil.UNDERLINE_STR + i6));
                            DeleteFile(String.valueOf(str4) + BridgeUtil.SPLIT_MARK + "odexdir" + BridgeUtil.SPLIT_MARK + CreatenewFileName(securename8, ".", BridgeUtil.UNDERLINE_STR + i6));
                            DeleteFile(String.valueOf(str4) + BridgeUtil.SPLIT_MARK + "oat/arm" + BridgeUtil.SPLIT_MARK + CreatenewFileName(securename11, ".", BridgeUtil.UNDERLINE_STR + i6));
                            DeleteFile(String.valueOf(str4) + BridgeUtil.SPLIT_MARK + "oat/arm64" + BridgeUtil.SPLIT_MARK + CreatenewFileName(securename11, ".", BridgeUtil.UNDERLINE_STR + i6));
                            DeleteFile(String.valueOf(str4) + BridgeUtil.SPLIT_MARK + "oat/arm" + BridgeUtil.SPLIT_MARK + CreatenewFileName(securename14, ".", BridgeUtil.UNDERLINE_STR + i6));
                            DeleteFile(String.valueOf(str4) + BridgeUtil.SPLIT_MARK + "oat/arm" + BridgeUtil.SPLIT_MARK + CreatenewFileName(securename15, ".", BridgeUtil.UNDERLINE_STR + i6));
                            DeleteFile(String.valueOf(str4) + BridgeUtil.SPLIT_MARK + "oat/arm64" + BridgeUtil.SPLIT_MARK + CreatenewFileName(securename14, ".", BridgeUtil.UNDERLINE_STR + i6));
                            DeleteFile(String.valueOf(str4) + BridgeUtil.SPLIT_MARK + "oat/arm64" + BridgeUtil.SPLIT_MARK + CreatenewFileName(securename15, ".", BridgeUtil.UNDERLINE_STR + i6));
                            if (-1 == DeleteFile7 && -1 == DeleteFile8 && -1 == DeleteFile9) {
                                break;
                            }
                            if (-2 == DeleteFile7 || -2 == DeleteFile8 || -2 == DeleteFile9) {
                                Process.killProcess(Process.myPid());
                                System.exit(0);
                            }
                            i5 = i6 + 1;
                        } else {
                            break;
                        }
                    }
                    ZipEntry entry5 = zipFile.getEntry("assets/" + str6);
                    if (entry5 != null && !isFileValid(String.valueOf(str) + BridgeUtil.SPLIT_MARK + libname, entry5.getSize())) {
                        UnzipFile(zipFile, "assets/" + str6, new File(String.valueOf(str) + BridgeUtil.SPLIT_MARK + libname));
                    }
                    ZipEntry entry6 = zipFile.getEntry("assets/" + str6);
                    if (entry6 != null && !isFileValid(String.valueOf(str) + BridgeUtil.SPLIT_MARK + securename6, entry6.getSize())) {
                        UnzipFile(zipFile, "assets/" + securename6, new File(String.valueOf(str) + BridgeUtil.SPLIT_MARK + securename6));
                    }
                    ZipEntry entry7 = zipFile.getEntry("assets/" + str6);
                    if (entry7 != null && !isFileValid(String.valueOf(str) + BridgeUtil.SPLIT_MARK + securename7, entry7.getSize())) {
                        UnzipFile(zipFile, "assets/" + securename7, new File(String.valueOf(str) + BridgeUtil.SPLIT_MARK + securename7));
                    }
                    ZipEntry entry8 = zipFile.getEntry(str5);
                    if (entry8 != null && !isFileValid(str2, entry8.getSize())) {
                        UnzipFile(zipFile, str5, new File(str2));
                    }
                    if (fileLock != null) {
                        try {
                            try {
                                fileLock.release();
                                try {
                                    if (fileChannel2 != null) {
                                        try {
                                            fileChannel2.close();
                                            if (randomAccessFile != null) {
                                                try {
                                                    randomAccessFile.close();
                                                    return 0;
                                                } catch (IOException e15) {
                                                    e15.printStackTrace();
                                                    return -1;
                                                }
                                            }
                                            return 0;
                                        } catch (IOException e16) {
                                            e16.printStackTrace();
                                            if (randomAccessFile != null) {
                                                try {
                                                    randomAccessFile.close();
                                                    return -1;
                                                } catch (IOException e17) {
                                                    e17.printStackTrace();
                                                    return -1;
                                                }
                                            }
                                            return -1;
                                        }
                                    }
                                    return 0;
                                } catch (Throwable th6) {
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.close();
                                        } catch (IOException e18) {
                                            e18.printStackTrace();
                                            return -1;
                                        }
                                    }
                                    throw th6;
                                }
                            } catch (IOException e19) {
                                e19.printStackTrace();
                                try {
                                    if (fileChannel2 != null) {
                                        try {
                                            fileChannel2.close();
                                            if (randomAccessFile != null) {
                                                try {
                                                    randomAccessFile.close();
                                                    return -1;
                                                } catch (IOException e20) {
                                                    e20.printStackTrace();
                                                    return -1;
                                                }
                                            }
                                            return -1;
                                        } catch (IOException e21) {
                                            e21.printStackTrace();
                                            if (randomAccessFile != null) {
                                                try {
                                                    randomAccessFile.close();
                                                    return -1;
                                                } catch (IOException e22) {
                                                    e22.printStackTrace();
                                                    return -1;
                                                }
                                            }
                                            return -1;
                                        }
                                    }
                                    return -1;
                                } catch (Throwable th7) {
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.close();
                                        } catch (IOException e23) {
                                            e23.printStackTrace();
                                            return -1;
                                        }
                                    }
                                    throw th7;
                                }
                            }
                        } catch (Throwable th8) {
                            try {
                                if (fileChannel2 != null) {
                                    try {
                                        fileChannel2.close();
                                        if (randomAccessFile != null) {
                                            try {
                                                randomAccessFile.close();
                                            } catch (IOException e24) {
                                                e24.printStackTrace();
                                                return -1;
                                            }
                                        }
                                    } catch (IOException e25) {
                                        e25.printStackTrace();
                                        if (randomAccessFile != null) {
                                            try {
                                                randomAccessFile.close();
                                                return -1;
                                            } catch (IOException e26) {
                                                e26.printStackTrace();
                                                return -1;
                                            }
                                        }
                                        return -1;
                                    }
                                }
                                throw th8;
                            } catch (Throwable th9) {
                                if (randomAccessFile != null) {
                                    try {
                                        randomAccessFile.close();
                                    } catch (IOException e27) {
                                        e27.printStackTrace();
                                        return -1;
                                    }
                                }
                                throw th9;
                            }
                        }
                    }
                    return 0;
                } catch (Exception e28) {
                    e = e28;
                    fileChannel = fileChannel2;
                    fileLock2 = fileLock;
                    randomAccessFile2 = randomAccessFile;
                    e.printStackTrace();
                    ZipEntry entry9 = zipFile.getEntry("assets/" + str6);
                    if (entry9 != null && !isFileValid(String.valueOf(str) + BridgeUtil.SPLIT_MARK + libname, entry9.getSize())) {
                        UnzipFile(zipFile, "assets/" + str6, new File(String.valueOf(str) + BridgeUtil.SPLIT_MARK + libname));
                    }
                    ZipEntry entry10 = zipFile.getEntry("assets/" + str6);
                    if (entry10 != null && !isFileValid(String.valueOf(str) + BridgeUtil.SPLIT_MARK + securename6, entry10.getSize())) {
                        UnzipFile(zipFile, "assets/" + securename6, new File(String.valueOf(str) + BridgeUtil.SPLIT_MARK + securename6));
                    }
                    ZipEntry entry11 = zipFile.getEntry("assets/" + str6);
                    if (entry11 != null && !isFileValid(String.valueOf(str) + BridgeUtil.SPLIT_MARK + securename7, entry11.getSize())) {
                        UnzipFile(zipFile, "assets/" + securename7, new File(String.valueOf(str) + BridgeUtil.SPLIT_MARK + securename7));
                    }
                    ZipEntry entry12 = zipFile.getEntry(str5);
                    if (entry12 != null && !isFileValid(str2, entry12.getSize())) {
                        UnzipFile(zipFile, str5, new File(str2));
                    }
                    if (fileLock != null) {
                        try {
                            try {
                                fileLock.release();
                                try {
                                    if (fileChannel2 != null) {
                                        try {
                                            fileChannel2.close();
                                            if (randomAccessFile != null) {
                                                try {
                                                    randomAccessFile.close();
                                                    return -1;
                                                } catch (IOException e29) {
                                                    e29.printStackTrace();
                                                    return -1;
                                                }
                                            }
                                            return -1;
                                        } catch (IOException e30) {
                                            e30.printStackTrace();
                                            if (randomAccessFile != null) {
                                                try {
                                                    randomAccessFile.close();
                                                    return -1;
                                                } catch (IOException e31) {
                                                    e31.printStackTrace();
                                                    return -1;
                                                }
                                            }
                                            return -1;
                                        }
                                    }
                                    return -1;
                                } catch (Throwable th10) {
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.close();
                                        } catch (IOException e32) {
                                            e32.printStackTrace();
                                            return -1;
                                        }
                                    }
                                    throw th10;
                                }
                            } catch (Throwable th11) {
                                try {
                                    if (fileChannel2 != null) {
                                        try {
                                            fileChannel2.close();
                                            if (randomAccessFile != null) {
                                                try {
                                                    randomAccessFile.close();
                                                } catch (IOException e33) {
                                                    e33.printStackTrace();
                                                    return -1;
                                                }
                                            }
                                        } catch (IOException e34) {
                                            e34.printStackTrace();
                                            if (randomAccessFile != null) {
                                                try {
                                                    randomAccessFile.close();
                                                    return -1;
                                                } catch (IOException e35) {
                                                    e35.printStackTrace();
                                                    return -1;
                                                }
                                            }
                                            return -1;
                                        }
                                    }
                                    throw th11;
                                } catch (Throwable th12) {
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.close();
                                        } catch (IOException e36) {
                                            e36.printStackTrace();
                                            return -1;
                                        }
                                    }
                                    throw th12;
                                }
                            }
                        } catch (IOException e37) {
                            e37.printStackTrace();
                            if (fileChannel2 != null) {
                                try {
                                    try {
                                        fileChannel2.close();
                                        if (randomAccessFile != null) {
                                            try {
                                                randomAccessFile.close();
                                                return -1;
                                            } catch (IOException e38) {
                                                e38.printStackTrace();
                                                return -1;
                                            }
                                        }
                                        return -1;
                                    } catch (Throwable th13) {
                                        if (randomAccessFile != null) {
                                            try {
                                                randomAccessFile.close();
                                            } catch (IOException e39) {
                                                e39.printStackTrace();
                                                return -1;
                                            }
                                        }
                                        throw th13;
                                    }
                                } catch (IOException e40) {
                                    e40.printStackTrace();
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.close();
                                            return -1;
                                        } catch (IOException e41) {
                                            e41.printStackTrace();
                                            return -1;
                                        }
                                    }
                                    return -1;
                                }
                            }
                            return -1;
                        }
                    }
                    return -1;
                } catch (Throwable th14) {
                    th = th14;
                    ZipEntry entry13 = zipFile.getEntry("assets/" + str6);
                    if (entry13 != null && !isFileValid(String.valueOf(str) + BridgeUtil.SPLIT_MARK + libname, entry13.getSize())) {
                        UnzipFile(zipFile, "assets/" + str6, new File(String.valueOf(str) + BridgeUtil.SPLIT_MARK + libname));
                    }
                    ZipEntry entry14 = zipFile.getEntry("assets/" + str6);
                    if (entry14 != null && !isFileValid(String.valueOf(str) + BridgeUtil.SPLIT_MARK + securename6, entry14.getSize())) {
                        UnzipFile(zipFile, "assets/" + securename6, new File(String.valueOf(str) + BridgeUtil.SPLIT_MARK + securename6));
                    }
                    ZipEntry entry15 = zipFile.getEntry("assets/" + str6);
                    if (entry15 != null && !isFileValid(String.valueOf(str) + BridgeUtil.SPLIT_MARK + securename7, entry15.getSize())) {
                        UnzipFile(zipFile, "assets/" + securename7, new File(String.valueOf(str) + BridgeUtil.SPLIT_MARK + securename7));
                    }
                    ZipEntry entry16 = zipFile.getEntry(str5);
                    if (entry16 != null && !isFileValid(str2, entry16.getSize())) {
                        UnzipFile(zipFile, str5, new File(str2));
                    }
                    if (fileLock != null) {
                        try {
                            try {
                                fileLock.release();
                                try {
                                    if (fileChannel2 != null) {
                                        try {
                                            fileChannel2.close();
                                            if (randomAccessFile != null) {
                                                try {
                                                    randomAccessFile.close();
                                                } catch (IOException e42) {
                                                    e42.printStackTrace();
                                                    return -1;
                                                }
                                            }
                                        } catch (IOException e43) {
                                            e43.printStackTrace();
                                            if (randomAccessFile != null) {
                                                try {
                                                    randomAccessFile.close();
                                                    return -1;
                                                } catch (IOException e44) {
                                                    e44.printStackTrace();
                                                    return -1;
                                                }
                                            }
                                            return -1;
                                        }
                                    }
                                } catch (Throwable th15) {
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.close();
                                        } catch (IOException e45) {
                                            e45.printStackTrace();
                                            return -1;
                                        }
                                    }
                                    throw th15;
                                }
                            } catch (Throwable th16) {
                                try {
                                    if (fileChannel2 != null) {
                                        try {
                                            fileChannel2.close();
                                            if (randomAccessFile != null) {
                                                try {
                                                    randomAccessFile.close();
                                                } catch (IOException e46) {
                                                    e46.printStackTrace();
                                                    return -1;
                                                }
                                            }
                                        } catch (IOException e47) {
                                            e47.printStackTrace();
                                            if (randomAccessFile != null) {
                                                try {
                                                    randomAccessFile.close();
                                                    return -1;
                                                } catch (IOException e48) {
                                                    e48.printStackTrace();
                                                    return -1;
                                                }
                                            }
                                            return -1;
                                        }
                                    }
                                    throw th16;
                                } catch (Throwable th17) {
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.close();
                                        } catch (IOException e49) {
                                            e49.printStackTrace();
                                            return -1;
                                        }
                                    }
                                    throw th17;
                                }
                            }
                        } catch (IOException e50) {
                            e50.printStackTrace();
                            try {
                                if (fileChannel2 != null) {
                                    try {
                                        fileChannel2.close();
                                        if (randomAccessFile != null) {
                                            try {
                                                randomAccessFile.close();
                                                return -1;
                                            } catch (IOException e51) {
                                                e51.printStackTrace();
                                                return -1;
                                            }
                                        }
                                        return -1;
                                    } catch (IOException e52) {
                                        e52.printStackTrace();
                                        if (randomAccessFile != null) {
                                            try {
                                                randomAccessFile.close();
                                                return -1;
                                            } catch (IOException e53) {
                                                e53.printStackTrace();
                                                return -1;
                                            }
                                        }
                                        return -1;
                                    }
                                }
                                return -1;
                            } catch (Throwable th18) {
                                if (randomAccessFile != null) {
                                    try {
                                        randomAccessFile.close();
                                    } catch (IOException e54) {
                                        e54.printStackTrace();
                                        return -1;
                                    }
                                }
                                throw th18;
                            }
                        }
                    }
                    throw th;
                }
            } catch (Throwable th19) {
                th = th19;
                randomAccessFile = randomAccessFile2;
                fileLock = fileLock2;
                fileChannel2 = fileChannel;
            }
        } catch (Exception e55) {
            e = e55;
            randomAccessFile = null;
            fileLock = null;
        }
    }

    public static boolean SafeUnzipFile(ZipFile zipFile, String str, File file) {
        return SafeUnzipFile(zipFile, str, file, 0L);
    }

    public static boolean SafeUnzipFile(ZipFile zipFile, String str, File file, long j) {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                ZipEntry entry = zipFile.getEntry(str);
                if (entry == null) {
                    try {
                        if (0 != 0) {
                            try {
                                throw new NullPointerException();
                            } catch (IOException e) {
                                e.printStackTrace();
                                if (0 != 0) {
                                    try {
                                        throw new NullPointerException();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                        return false;
                                    }
                                }
                                return false;
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        if (0 != 0) {
                            try {
                                throw new NullPointerException();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                return false;
                            }
                        }
                        throw th;
                    }
                } else if (j != 0 && entry.getCrc() == j) {
                    if (0 != 0) {
                        try {
                            try {
                                throw new NullPointerException();
                            } catch (Throwable th2) {
                                if (0 != 0) {
                                    try {
                                        throw new NullPointerException();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                        return false;
                                    }
                                }
                                throw th2;
                            }
                        } catch (IOException e5) {
                            e5.printStackTrace();
                            if (0 != 0) {
                                try {
                                    throw new NullPointerException();
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                    return false;
                                }
                            }
                            return false;
                        }
                    }
                    return true;
                } else {
                    byte[] UnzipFile = UnzipFile(zipFile, entry);
                    bufferedOutputStream = null;
                    if (1 != 0) {
                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                        try {
                            bufferedOutputStream.write(UnzipFile, 0, UnzipFile.length);
                        } catch (Exception e7) {
                            e = e7;
                            e.printStackTrace();
                            if (bufferedOutputStream != null) {
                                try {
                                    try {
                                        bufferedOutputStream.close();
                                        if (0 != 0) {
                                            try {
                                                throw new NullPointerException();
                                            } catch (IOException e8) {
                                                e8.printStackTrace();
                                                return false;
                                            }
                                        }
                                        return false;
                                    } catch (Throwable th3) {
                                        if (0 != 0) {
                                            try {
                                                throw new NullPointerException();
                                            } catch (IOException e9) {
                                                e9.printStackTrace();
                                                return false;
                                            }
                                        }
                                        throw th3;
                                    }
                                } catch (IOException e10) {
                                    e10.printStackTrace();
                                    if (0 != 0) {
                                        try {
                                            throw new NullPointerException();
                                        } catch (IOException e11) {
                                            e11.printStackTrace();
                                            return false;
                                        }
                                    }
                                    return false;
                                }
                            }
                            return false;
                        } catch (Throwable th4) {
                            bufferedOutputStream2 = bufferedOutputStream;
                            th = th4;
                            try {
                                if (bufferedOutputStream2 != null) {
                                    try {
                                        bufferedOutputStream2.close();
                                        if (0 != 0) {
                                            try {
                                                throw new NullPointerException();
                                            } catch (IOException e12) {
                                                e12.printStackTrace();
                                                return false;
                                            }
                                        }
                                    } catch (IOException e13) {
                                        e13.printStackTrace();
                                        if (0 != 0) {
                                            try {
                                                throw new NullPointerException();
                                            } catch (IOException e14) {
                                                e14.printStackTrace();
                                                return false;
                                            }
                                        }
                                        return false;
                                    }
                                }
                                throw th;
                            } catch (Throwable th5) {
                                if (0 != 0) {
                                    try {
                                        throw new NullPointerException();
                                    } catch (IOException e15) {
                                        e15.printStackTrace();
                                        return false;
                                    }
                                }
                                throw th5;
                            }
                        }
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            try {
                                bufferedOutputStream.close();
                                if (0 != 0) {
                                    try {
                                        throw new NullPointerException();
                                    } catch (IOException e16) {
                                        e16.printStackTrace();
                                        return false;
                                    }
                                }
                                return true;
                            } catch (Throwable th6) {
                                if (0 != 0) {
                                    try {
                                        throw new NullPointerException();
                                    } catch (IOException e17) {
                                        e17.printStackTrace();
                                        return false;
                                    }
                                }
                                throw th6;
                            }
                        } catch (IOException e18) {
                            e18.printStackTrace();
                            if (0 != 0) {
                                try {
                                    throw new NullPointerException();
                                } catch (IOException e19) {
                                    e19.printStackTrace();
                                    return false;
                                }
                            }
                            return false;
                        }
                    }
                    return true;
                }
            } catch (Exception e20) {
                e = e20;
                bufferedOutputStream = null;
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    public static boolean UnzipFile(ZipFile zipFile, String str, File file) {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                ZipEntry entry = zipFile.getEntry(str);
                if (entry == null) {
                    if (0 != 0) {
                        try {
                            try {
                                throw new NullPointerException();
                            } catch (IOException e) {
                                e.printStackTrace();
                                if (0 != 0) {
                                    try {
                                        throw new NullPointerException();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                        return false;
                                    }
                                }
                                return false;
                            }
                        } catch (Throwable th) {
                            if (0 != 0) {
                                try {
                                    throw new NullPointerException();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                    return false;
                                }
                            }
                            throw th;
                        }
                    }
                    return false;
                }
                BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    byte[] bArr = new byte[65536];
                    BufferedInputStream bufferedInputStream3 = new BufferedInputStream(zipFile.getInputStream(entry));
                    while (true) {
                        try {
                            int read = bufferedInputStream3.read(bArr);
                            if (read < 0) {
                                break;
                            }
                            bufferedOutputStream3.write(bArr, 0, read);
                        } catch (Exception e4) {
                            e = e4;
                            bufferedOutputStream = bufferedOutputStream3;
                            bufferedInputStream = bufferedInputStream3;
                            e.printStackTrace();
                            try {
                                if (bufferedOutputStream != null) {
                                    try {
                                        bufferedOutputStream.close();
                                        if (bufferedInputStream != null) {
                                            try {
                                                bufferedInputStream.close();
                                                return false;
                                            } catch (IOException e5) {
                                                e5.printStackTrace();
                                                return false;
                                            }
                                        }
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                        if (bufferedInputStream != null) {
                                            try {
                                                bufferedInputStream.close();
                                                return false;
                                            } catch (IOException e7) {
                                                e7.printStackTrace();
                                                return false;
                                            }
                                        }
                                    }
                                    return false;
                                }
                                return false;
                            } catch (Throwable th2) {
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e8) {
                                        e8.printStackTrace();
                                        return false;
                                    }
                                }
                                throw th2;
                            }
                        } catch (Throwable th3) {
                            bufferedOutputStream2 = bufferedOutputStream3;
                            bufferedInputStream2 = bufferedInputStream3;
                            th = th3;
                            try {
                                if (bufferedOutputStream2 != null) {
                                    try {
                                        bufferedOutputStream2.close();
                                        if (bufferedInputStream2 != null) {
                                            try {
                                                bufferedInputStream2.close();
                                            } catch (IOException e9) {
                                                e9.printStackTrace();
                                                return false;
                                            }
                                        }
                                    } catch (IOException e10) {
                                        e10.printStackTrace();
                                        if (bufferedInputStream2 != null) {
                                            try {
                                                bufferedInputStream2.close();
                                                return false;
                                            } catch (IOException e11) {
                                                e11.printStackTrace();
                                                return false;
                                            }
                                        }
                                        return false;
                                    }
                                }
                                throw th;
                            } catch (Throwable th4) {
                                if (bufferedInputStream2 != null) {
                                    try {
                                        bufferedInputStream2.close();
                                    } catch (IOException e12) {
                                        e12.printStackTrace();
                                        return false;
                                    }
                                }
                                throw th4;
                            }
                        }
                    }
                    try {
                        if (bufferedOutputStream3 != null) {
                            try {
                                bufferedOutputStream3.close();
                                if (bufferedInputStream3 != null) {
                                    try {
                                        bufferedInputStream3.close();
                                        return true;
                                    } catch (IOException e13) {
                                        e13.printStackTrace();
                                        return false;
                                    }
                                }
                                return true;
                            } catch (IOException e14) {
                                e14.printStackTrace();
                                if (bufferedInputStream3 != null) {
                                    try {
                                        bufferedInputStream3.close();
                                        return false;
                                    } catch (IOException e15) {
                                        e15.printStackTrace();
                                        return false;
                                    }
                                }
                                return false;
                            }
                        }
                        return true;
                    } catch (Throwable th5) {
                        if (bufferedInputStream3 != null) {
                            try {
                                bufferedInputStream3.close();
                            } catch (IOException e16) {
                                e16.printStackTrace();
                                return false;
                            }
                        }
                        throw th5;
                    }
                } catch (Exception e17) {
                    e = e17;
                    bufferedOutputStream = bufferedOutputStream3;
                    bufferedInputStream = null;
                } catch (Throwable th6) {
                    th = th6;
                    bufferedOutputStream2 = bufferedOutputStream3;
                    bufferedInputStream2 = null;
                }
            } catch (Exception e18) {
                e = e18;
                bufferedOutputStream = null;
                bufferedInputStream = null;
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    public static byte[] UnzipFile(ZipFile zipFile, ZipEntry zipEntry) throws IOException {
        byte[] bArr = new byte[(int) zipEntry.getSize()];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
        int i = 0;
        while (true) {
            int read = bufferedInputStream.read(bArr, i, ((int) zipEntry.getSize()) - i);
            if (read >= 0) {
                int i2 = i + read;
                i = i2;
                if (i2 == zipEntry.getSize()) {
                    i = i2;
                    break;
                }
            } else {
                break;
            }
        }
        if (i != ((int) zipEntry.getSize())) {
            throw new IOException("incorrect zip file size");
        }
        return bArr;
    }

    private static boolean checkCopiedFileCrc(ZipFile zipFile, String str, File file) {
        long fileCRC32 = getFileCRC32(file);
        if (fileCRC32 == -1) {
            return false;
        }
        try {
            ZipEntry entry = zipFile.getEntry(str);
            if (entry == null || fileCRC32 == 0) {
                return false;
            }
            return entry.getCrc() == fileCRC32;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean deleteDir(File file) {
        boolean z = true;
        if (file.isDirectory()) {
            String[] list = file.list();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.length) {
                    break;
                } else if (!deleteDir(new File(file, list[i2]))) {
                    return false;
                } else {
                    i = i2 + 1;
                }
            }
        }
        if (file.exists()) {
            z = file.delete();
        }
        return z;
    }

    public static long getCRC32(File file) {
        long j = 0;
        try {
            try {
                CheckedInputStream checkedInputStream = new CheckedInputStream(new BufferedInputStream(new FileInputStream(file)), new CRC32());
                long j2 = 0;
                long j3 = 0;
                try {
                    do {
                    } while (checkedInputStream.read(new byte[65536]) >= 0);
                    long value = checkedInputStream.getChecksum().getValue();
                    j2 = value;
                    j3 = value;
                    checkedInputStream.close();
                    return value;
                } catch (FileNotFoundException e) {
                    e = e;
                    j = j3;
                    e.printStackTrace();
                    return j;
                } catch (IOException e2) {
                    e = e2;
                    j = j2;
                    e.printStackTrace();
                    return j;
                }
            } catch (FileNotFoundException e3) {
                e = e3;
            } catch (IOException e4) {
                e = e4;
            }
        } catch (FileNotFoundException e5) {
            e = e5;
        } catch (IOException e6) {
            e = e6;
        }
    }

    private static long getFileCRC32(File file) {
        BufferedInputStream bufferedInputStream;
        FileNotFoundException e;
        long j = -1;
        byte[] bArr = new byte[(int) file.length()];
        BufferedInputStream bufferedInputStream2 = null;
        CRC32 crc32 = new CRC32();
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                int i = 0;
                while (true) {
                    try {
                        int i2 = i;
                        int read = bufferedInputStream.read(bArr);
                        if (read < 0) {
                            break;
                        }
                        crc32.update(bArr);
                        i = i2 + read;
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        bufferedInputStream2 = bufferedInputStream;
                        e.printStackTrace();
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                                return -1L;
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                return -1L;
                            }
                        }
                        return j;
                    } catch (IOException e4) {
                        e = e4;
                        bufferedInputStream2 = bufferedInputStream;
                        e.printStackTrace();
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                                return -1L;
                            } catch (IOException e5) {
                                e5.printStackTrace();
                                return -1L;
                            }
                        }
                        return j;
                    } catch (Throwable th) {
                        bufferedInputStream2 = bufferedInputStream;
                        th = th;
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                j = crc32.getValue();
            } catch (FileNotFoundException e7) {
                bufferedInputStream = null;
                e = e7;
            } catch (IOException e8) {
                e = e8;
                bufferedInputStream = null;
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                    return j;
                } catch (IOException e9) {
                    e9.printStackTrace();
                }
            }
            return j;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean isFileValid(String str, long j) {
        File file = new File(str);
        return file.exists() && file.length() == j;
    }
}
