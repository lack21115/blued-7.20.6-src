package com.tencent.tinker.loader.shareutil;

import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/shareutil/SharePatchInfo.class */
public class SharePatchInfo {
    public static final String DEFAULT_DIR = "odex";
    public static final String FINGER_PRINT = "print";
    public static final String IS_PROTECTED_APP = "is_protected_app";
    public static final String IS_REMOVE_INTERPRET_OAT_DIR = "is_remove_interpret_oat_dir";
    public static final String IS_REMOVE_NEW_VERSION = "is_remove_new_version";
    public static final int MAX_EXTRACT_ATTEMPTS = 2;
    public static final String NEW_VERSION = "new";
    public static final String OAT_DIR = "dir";
    public static final String OLD_VERSION = "old";
    private static final String TAG = "Tinker.PatchInfo";
    public String fingerPrint;
    public boolean isProtectedApp;
    public boolean isRemoveInterpretOATDir;
    public boolean isRemoveNewVersion;
    public String newVersion;
    public String oatDir;
    public String oldVersion;

    public SharePatchInfo(String str, String str2, boolean z, boolean z2, String str3, String str4, boolean z3) {
        this.oldVersion = str;
        this.newVersion = str2;
        this.isProtectedApp = z;
        this.isRemoveNewVersion = z2;
        this.fingerPrint = str3;
        this.oatDir = str4;
        this.isRemoveInterpretOATDir = z3;
    }

    private static SharePatchInfo readAndCheckProperty(File file) {
        boolean z;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        boolean z2;
        String str;
        String str2;
        boolean z3;
        boolean z4;
        String str3;
        String str4;
        int i = 0;
        boolean z5 = false;
        String str5 = null;
        String str6 = null;
        boolean z6 = false;
        boolean z7 = false;
        String str7 = null;
        String str8 = null;
        boolean z8 = false;
        while (true) {
            z = z8;
            if (i >= 2 || z5) {
                break;
            }
            i++;
            Properties properties = new Properties();
            try {
                fileInputStream2 = new FileInputStream(file);
                fileInputStream = fileInputStream2;
                str = str5;
                str2 = str6;
                z3 = z6;
                z4 = z7;
                str3 = str7;
                str4 = str8;
            } catch (IOException e) {
                e = e;
                fileInputStream2 = null;
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
            try {
                try {
                    properties.load(fileInputStream2);
                    str5 = properties.getProperty("old");
                    str6 = properties.getProperty("new");
                    String property = properties.getProperty("is_protected_app");
                    z6 = (property == null || property.isEmpty() || "0".equals(property)) ? false : true;
                    String property2 = properties.getProperty(IS_REMOVE_NEW_VERSION);
                    z7 = (property2 == null || property2.isEmpty() || "0".equals(property2)) ? false : true;
                    str7 = properties.getProperty("print");
                    str8 = properties.getProperty(OAT_DIR);
                    String property3 = properties.getProperty(IS_REMOVE_INTERPRET_OAT_DIR);
                    z2 = (property3 == null || property3.isEmpty() || "0".equals(property3)) ? false : true;
                } catch (IOException e2) {
                    e = e2;
                    str5 = str;
                    str6 = str2;
                    z6 = z3;
                    z7 = z4;
                    str7 = str3;
                    str8 = str4;
                    StringBuilder sb = new StringBuilder();
                    FileInputStream fileInputStream3 = fileInputStream2;
                    sb.append("read property failed, e:");
                    FileInputStream fileInputStream4 = fileInputStream2;
                    sb.append(e);
                    FileInputStream fileInputStream5 = fileInputStream2;
                    ShareTinkerLog.w(TAG, sb.toString(), new Object[0]);
                    z2 = z;
                    SharePatchFileUtil.closeQuietly(fileInputStream2);
                    if (str5 != null) {
                        if (str5.equals("")) {
                        }
                        z5 = true;
                        z8 = z2;
                    }
                    z8 = z2;
                }
                SharePatchFileUtil.closeQuietly(fileInputStream2);
                if (str5 != null && str6 != null) {
                    if ((!str5.equals("") || SharePatchFileUtil.checkIfMd5Valid(str5)) && SharePatchFileUtil.checkIfMd5Valid(str6)) {
                        z5 = true;
                        z8 = z2;
                    } else {
                        ShareTinkerLog.w(TAG, "path info file  corrupted:" + file.getAbsolutePath(), new Object[0]);
                    }
                }
                z8 = z2;
            } catch (Throwable th2) {
                th = th2;
                SharePatchFileUtil.closeQuietly(fileInputStream);
                throw th;
            }
        }
        if (z5) {
            return new SharePatchInfo(str5, str6, z6, z7, str7, str8, z);
        }
        return null;
    }

    public static SharePatchInfo readAndCheckPropertyWithLock(File file, File file2) {
        ShareFileLockHelper shareFileLockHelper = null;
        ShareFileLockHelper shareFileLockHelper2 = null;
        if (file == null || file2 == null) {
            return null;
        }
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            try {
                ShareFileLockHelper fileLock = ShareFileLockHelper.getFileLock(file2);
                shareFileLockHelper2 = fileLock;
                shareFileLockHelper = fileLock;
                SharePatchInfo readAndCheckProperty = readAndCheckProperty(file);
                if (fileLock != null) {
                    try {
                        fileLock.close();
                        return readAndCheckProperty;
                    } catch (IOException e) {
                        ShareTinkerLog.w(TAG, "releaseInfoLock error", e);
                    }
                }
                return readAndCheckProperty;
            } catch (Throwable th) {
                if (shareFileLockHelper2 != null) {
                    try {
                        shareFileLockHelper2.close();
                    } catch (IOException e2) {
                        ShareTinkerLog.w(TAG, "releaseInfoLock error", e2);
                    }
                }
                throw th;
            }
        } catch (Exception e3) {
            shareFileLockHelper2 = shareFileLockHelper;
            throw new TinkerRuntimeException("readAndCheckPropertyWithLock fail", e3);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private static boolean rewritePatchInfoFile(File file, SharePatchInfo sharePatchInfo) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public static boolean rewritePatchInfoFileWithLock(File file, SharePatchInfo sharePatchInfo, File file2) {
        if (file == null || sharePatchInfo == null || file2 == null) {
            return false;
        }
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        ShareFileLockHelper shareFileLockHelper = null;
        ShareFileLockHelper shareFileLockHelper2 = null;
        try {
            try {
                ShareFileLockHelper fileLock = ShareFileLockHelper.getFileLock(file2);
                shareFileLockHelper2 = fileLock;
                shareFileLockHelper = fileLock;
                boolean rewritePatchInfoFile = rewritePatchInfoFile(file, sharePatchInfo);
                if (fileLock != null) {
                    try {
                        fileLock.close();
                        return rewritePatchInfoFile;
                    } catch (IOException e) {
                        ShareTinkerLog.i(TAG, "releaseInfoLock error", e);
                    }
                }
                return rewritePatchInfoFile;
            } catch (Exception e2) {
                throw new TinkerRuntimeException("rewritePatchInfoFileWithLock fail", e2);
            }
        } catch (Throwable th) {
            if (shareFileLockHelper2 != null) {
                try {
                    shareFileLockHelper2.close();
                } catch (IOException e3) {
                    ShareTinkerLog.i(TAG, "releaseInfoLock error", e3);
                }
            }
            throw th;
        }
    }
}
