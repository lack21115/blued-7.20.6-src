package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.ads.fw;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import dalvik.system.DexClassLoader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/o.class */
public class o {
    private static o d;
    private FileLock f;
    private FileOutputStream g;
    private static final ReentrantLock i = new ReentrantLock();
    private static final Lock j = new ReentrantLock();
    private static FileLock l = null;

    /* renamed from: a  reason: collision with root package name */
    public static ThreadLocal<Integer> f25173a = new ThreadLocal<Integer>() { // from class: com.tencent.smtt.sdk.o.1
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public Integer initialValue() {
            return 0;
        }
    };
    private static Handler m = null;
    private static final Long[][] n = {new Long[]{44006L, 39094008L}, new Long[]{44005L, 39094008L}, new Long[]{43910L, 38917816L}, new Long[]{44027L, 39094008L}, new Long[]{44028L, 39094008L}, new Long[]{44029L, 39094008L}, new Long[]{44030L, 39094008L}, new Long[]{44032L, 39094008L}, new Long[]{44033L, 39094008L}, new Long[]{44034L, 39094008L}, new Long[]{43909L, 38917816L}};
    static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    static final FileFilter f25174c = new FileFilter() { // from class: com.tencent.smtt.sdk.o.2
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (name == null || name.endsWith(".jar_is_first_load_dex_flag_file")) {
                return false;
            }
            if (Build.VERSION.SDK_INT < 21 || !name.endsWith(ShareConstants.DEX_SUFFIX)) {
                if (Build.VERSION.SDK_INT < 26 || !name.endsWith(".prof")) {
                    return Build.VERSION.SDK_INT < 26 || !name.equals(ShareConstants.ANDROID_O_DEX_OPTIMIZE_PATH);
                }
                return false;
            }
            return false;
        }
    };
    private static int o = 0;
    private static boolean p = false;
    private int e = 0;
    private boolean h = false;
    private boolean k = false;

    private o() {
        if (m == null) {
            m = new Handler(n.a().getLooper()) { // from class: com.tencent.smtt.sdk.o.3
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    QbSdk.setTBSInstallingStatus(true);
                    int i2 = message.what;
                    if (i2 == 1) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE");
                        Object[] objArr = (Object[]) message.obj;
                        o.this.b((Context) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue());
                    } else if (i2 == 2) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_COPY_TBS_CORE");
                        Object[] objArr2 = (Object[]) message.obj;
                        o.this.a((Context) objArr2[0], (Context) objArr2[1], ((Integer) objArr2[2]).intValue());
                    } else if (i2 == 3) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE_EX");
                        Object[] objArr3 = (Object[]) message.obj;
                        o.this.b((Context) objArr3[0], (Bundle) objArr3[1]);
                    } else if (i2 != 4) {
                    } else {
                        TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_UNZIP_TBS_CORE");
                        Object[] objArr4 = (Object[]) message.obj;
                        o.this.b((Context) objArr4[0], (File) objArr4[1], ((Integer) objArr4[2]).intValue());
                        QbSdk.setTBSInstallingStatus(false);
                        super.handleMessage(message);
                    }
                }
            };
        }
    }

    private void A(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--deleteOldCore");
        FileUtil.a(q(context), false);
    }

    private void B(Context context) {
        TbsLogReport tbsLogReport;
        int i2;
        TbsLog.i("TbsInstaller", "TbsInstaller--renameShareDir");
        File f = f(context, 0);
        File q = q(context);
        if (f == null || q == null) {
            TbsLog.i("TbsInstaller", "renameTbsCoreShareDir return,tmpTbsCoreUnzipDir=" + f + "tbsSharePath=" + q);
            return;
        }
        boolean renameTo = f.renameTo(q);
        TbsLog.i("TbsInstaller", "renameTbsCoreShareDir rename success=" + renameTo);
        if (context != null && "com.tencent.mm".equals(context.getApplicationContext().getApplicationInfo().packageName)) {
            if (renameTo) {
                tbsLogReport = TbsLogReport.getInstance(context);
                i2 = 230;
            } else {
                tbsLogReport = TbsLogReport.getInstance(context);
                i2 = 231;
            }
            tbsLogReport.setInstallErrorCode(i2, " ");
        }
        g(context, false);
    }

    private void C(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsCoreCopyDir");
        File f = f(context, 1);
        File q = q(context);
        if (f == null || q == null) {
            return;
        }
        f.renameTo(q);
        g(context, false);
    }

    private void D(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsTpatchCoreDir");
        File f = f(context, 5);
        File q = q(context);
        if (f == null || q == null) {
            return;
        }
        f.renameTo(q);
        g(context, false);
    }

    private void E(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--clearNewTbsCore");
        File f = f(context, 0);
        if (f != null) {
            FileUtil.a(f, false);
        }
        m.a(context).c(0, 5);
        m.a(context).c(-1);
        QbSdk.a(context, "TbsInstaller::clearNewTbsCore forceSysWebViewInner!");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o a() {
        o oVar;
        synchronized (o.class) {
            try {
                if (d == null) {
                    synchronized (o.class) {
                        if (d == null) {
                            d = new o();
                        }
                    }
                }
                oVar = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return oVar;
    }

    private void a(int i2, String str, Context context) {
        BufferedInputStream bufferedInputStream;
        new File(str).delete();
        TbsLog.i("TbsInstaller", "Local tbs apk(" + str + ") is deleted!", true);
        File file = new File(QbSdk.getTbsFolderDir(context), "core_unzip_tmp");
        if (!file.canRead()) {
            return;
        }
        File file2 = new File(file, "tbs.conf");
        Properties properties = new Properties();
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file2));
                try {
                    properties.load(bufferedInputStream);
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file2));
                    try {
                        properties.setProperty("tbs_local_installation", fw.Code);
                        properties.store(bufferedOutputStream2, (String) null);
                        TbsLog.i("TbsInstaller", "TBS_LOCAL_INSTALLATION is set!", true);
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        bufferedInputStream.close();
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = bufferedOutputStream2;
                        try {
                            th.printStackTrace();
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                        } catch (Throwable th2) {
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }

    public static void a(Context context) {
        String str;
        if (v(context)) {
            return;
        }
        if (a(context, "core_unzip_tmp")) {
            TbsCoreLoadStat.getInstance().a(context, 417, new Throwable("TMP_TBS_UNZIP_FOLDER_NAME"));
            str = "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_UNZIP_FOLDER_NAME";
        } else if (a(context, "core_share_backup_tmp")) {
            TbsCoreLoadStat.getInstance().a(context, 417, new Throwable("TMP_BACKUP_TBSCORE_FOLDER_NAME"));
            str = "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_BACKUP_TBSCORE_FOLDER_NAME";
        } else if (!a(context, "core_copy_tmp")) {
            return;
        } else {
            TbsCoreLoadStat.getInstance().a(context, 417, new Throwable("TMP_TBS_COPY_FOLDER_NAME"));
            str = "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_COPY_FOLDER_NAME";
        }
        TbsLog.e("TbsInstaller", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x08b2, code lost:
        if (r9 == 88888888) goto L242;
     */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0499 A[Catch: all -> 0x07e1, Exception -> 0x08cd, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x07e1, blocks: (B:20:0x00e7, B:23:0x0105, B:26:0x012d, B:29:0x015e, B:32:0x01aa, B:37:0x01c1, B:40:0x01da, B:42:0x01e1, B:47:0x024f, B:49:0x0256, B:51:0x025d, B:54:0x0269, B:59:0x02a8, B:62:0x02ba, B:65:0x02e4, B:67:0x02f3, B:69:0x0300, B:71:0x0307, B:77:0x0323, B:79:0x035e, B:80:0x0362, B:81:0x0365, B:83:0x038f, B:85:0x039e, B:103:0x0439, B:122:0x0499, B:124:0x04b1, B:128:0x04c0, B:130:0x04ce, B:132:0x04dc, B:134:0x04ea, B:136:0x04f2, B:139:0x0503, B:141:0x0526, B:143:0x0530, B:144:0x0563, B:146:0x05bb, B:150:0x05e9, B:153:0x0621, B:155:0x063a, B:157:0x0642, B:162:0x0657, B:163:0x065a, B:161:0x0651, B:165:0x0667, B:167:0x0676, B:169:0x0681, B:172:0x069c, B:174:0x06d1, B:181:0x074a, B:208:0x084d, B:179:0x0722, B:175:0x06de, B:170:0x068e, B:106:0x044b, B:186:0x0760, B:190:0x0771, B:188:0x076a, B:117:0x0482, B:119:0x048c, B:192:0x0774, B:203:0x07ee, B:205:0x0809, B:207:0x081a, B:195:0x07a8, B:198:0x07c7, B:72:0x0311, B:38:0x01c9), top: B:236:0x00e7, inners: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x05e4  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x063a A[Catch: all -> 0x07e1, Exception -> 0x08cd, TRY_ENTER, TryCatch #1 {all -> 0x07e1, blocks: (B:20:0x00e7, B:23:0x0105, B:26:0x012d, B:29:0x015e, B:32:0x01aa, B:37:0x01c1, B:40:0x01da, B:42:0x01e1, B:47:0x024f, B:49:0x0256, B:51:0x025d, B:54:0x0269, B:59:0x02a8, B:62:0x02ba, B:65:0x02e4, B:67:0x02f3, B:69:0x0300, B:71:0x0307, B:77:0x0323, B:79:0x035e, B:80:0x0362, B:81:0x0365, B:83:0x038f, B:85:0x039e, B:103:0x0439, B:122:0x0499, B:124:0x04b1, B:128:0x04c0, B:130:0x04ce, B:132:0x04dc, B:134:0x04ea, B:136:0x04f2, B:139:0x0503, B:141:0x0526, B:143:0x0530, B:144:0x0563, B:146:0x05bb, B:150:0x05e9, B:153:0x0621, B:155:0x063a, B:157:0x0642, B:162:0x0657, B:163:0x065a, B:161:0x0651, B:165:0x0667, B:167:0x0676, B:169:0x0681, B:172:0x069c, B:174:0x06d1, B:181:0x074a, B:208:0x084d, B:179:0x0722, B:175:0x06de, B:170:0x068e, B:106:0x044b, B:186:0x0760, B:190:0x0771, B:188:0x076a, B:117:0x0482, B:119:0x048c, B:192:0x0774, B:203:0x07ee, B:205:0x0809, B:207:0x081a, B:195:0x07a8, B:198:0x07c7, B:72:0x0311, B:38:0x01c9), top: B:236:0x00e7, inners: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0649  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0651 A[Catch: all -> 0x07e1, Exception -> 0x08cd, TRY_ENTER, TryCatch #1 {all -> 0x07e1, blocks: (B:20:0x00e7, B:23:0x0105, B:26:0x012d, B:29:0x015e, B:32:0x01aa, B:37:0x01c1, B:40:0x01da, B:42:0x01e1, B:47:0x024f, B:49:0x0256, B:51:0x025d, B:54:0x0269, B:59:0x02a8, B:62:0x02ba, B:65:0x02e4, B:67:0x02f3, B:69:0x0300, B:71:0x0307, B:77:0x0323, B:79:0x035e, B:80:0x0362, B:81:0x0365, B:83:0x038f, B:85:0x039e, B:103:0x0439, B:122:0x0499, B:124:0x04b1, B:128:0x04c0, B:130:0x04ce, B:132:0x04dc, B:134:0x04ea, B:136:0x04f2, B:139:0x0503, B:141:0x0526, B:143:0x0530, B:144:0x0563, B:146:0x05bb, B:150:0x05e9, B:153:0x0621, B:155:0x063a, B:157:0x0642, B:162:0x0657, B:163:0x065a, B:161:0x0651, B:165:0x0667, B:167:0x0676, B:169:0x0681, B:172:0x069c, B:174:0x06d1, B:181:0x074a, B:208:0x084d, B:179:0x0722, B:175:0x06de, B:170:0x068e, B:106:0x044b, B:186:0x0760, B:190:0x0771, B:188:0x076a, B:117:0x0482, B:119:0x048c, B:192:0x0774, B:203:0x07ee, B:205:0x0809, B:207:0x081a, B:195:0x07a8, B:198:0x07c7, B:72:0x0311, B:38:0x01c9), top: B:236:0x00e7, inners: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0676 A[Catch: all -> 0x07e1, Exception -> 0x08cd, TRY_LEAVE, TryCatch #1 {all -> 0x07e1, blocks: (B:20:0x00e7, B:23:0x0105, B:26:0x012d, B:29:0x015e, B:32:0x01aa, B:37:0x01c1, B:40:0x01da, B:42:0x01e1, B:47:0x024f, B:49:0x0256, B:51:0x025d, B:54:0x0269, B:59:0x02a8, B:62:0x02ba, B:65:0x02e4, B:67:0x02f3, B:69:0x0300, B:71:0x0307, B:77:0x0323, B:79:0x035e, B:80:0x0362, B:81:0x0365, B:83:0x038f, B:85:0x039e, B:103:0x0439, B:122:0x0499, B:124:0x04b1, B:128:0x04c0, B:130:0x04ce, B:132:0x04dc, B:134:0x04ea, B:136:0x04f2, B:139:0x0503, B:141:0x0526, B:143:0x0530, B:144:0x0563, B:146:0x05bb, B:150:0x05e9, B:153:0x0621, B:155:0x063a, B:157:0x0642, B:162:0x0657, B:163:0x065a, B:161:0x0651, B:165:0x0667, B:167:0x0676, B:169:0x0681, B:172:0x069c, B:174:0x06d1, B:181:0x074a, B:208:0x084d, B:179:0x0722, B:175:0x06de, B:170:0x068e, B:106:0x044b, B:186:0x0760, B:190:0x0771, B:188:0x076a, B:117:0x0482, B:119:0x048c, B:192:0x0774, B:203:0x07ee, B:205:0x0809, B:207:0x081a, B:195:0x07a8, B:198:0x07c7, B:72:0x0311, B:38:0x01c9), top: B:236:0x00e7, inners: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x068e A[Catch: all -> 0x07e1, Exception -> 0x08cd, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x07e1, blocks: (B:20:0x00e7, B:23:0x0105, B:26:0x012d, B:29:0x015e, B:32:0x01aa, B:37:0x01c1, B:40:0x01da, B:42:0x01e1, B:47:0x024f, B:49:0x0256, B:51:0x025d, B:54:0x0269, B:59:0x02a8, B:62:0x02ba, B:65:0x02e4, B:67:0x02f3, B:69:0x0300, B:71:0x0307, B:77:0x0323, B:79:0x035e, B:80:0x0362, B:81:0x0365, B:83:0x038f, B:85:0x039e, B:103:0x0439, B:122:0x0499, B:124:0x04b1, B:128:0x04c0, B:130:0x04ce, B:132:0x04dc, B:134:0x04ea, B:136:0x04f2, B:139:0x0503, B:141:0x0526, B:143:0x0530, B:144:0x0563, B:146:0x05bb, B:150:0x05e9, B:153:0x0621, B:155:0x063a, B:157:0x0642, B:162:0x0657, B:163:0x065a, B:161:0x0651, B:165:0x0667, B:167:0x0676, B:169:0x0681, B:172:0x069c, B:174:0x06d1, B:181:0x074a, B:208:0x084d, B:179:0x0722, B:175:0x06de, B:170:0x068e, B:106:0x044b, B:186:0x0760, B:190:0x0771, B:188:0x076a, B:117:0x0482, B:119:0x048c, B:192:0x0774, B:203:0x07ee, B:205:0x0809, B:207:0x081a, B:195:0x07a8, B:198:0x07c7, B:72:0x0311, B:38:0x01c9), top: B:236:0x00e7, inners: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x06d1 A[Catch: all -> 0x07e1, Exception -> 0x08cd, TRY_LEAVE, TryCatch #1 {all -> 0x07e1, blocks: (B:20:0x00e7, B:23:0x0105, B:26:0x012d, B:29:0x015e, B:32:0x01aa, B:37:0x01c1, B:40:0x01da, B:42:0x01e1, B:47:0x024f, B:49:0x0256, B:51:0x025d, B:54:0x0269, B:59:0x02a8, B:62:0x02ba, B:65:0x02e4, B:67:0x02f3, B:69:0x0300, B:71:0x0307, B:77:0x0323, B:79:0x035e, B:80:0x0362, B:81:0x0365, B:83:0x038f, B:85:0x039e, B:103:0x0439, B:122:0x0499, B:124:0x04b1, B:128:0x04c0, B:130:0x04ce, B:132:0x04dc, B:134:0x04ea, B:136:0x04f2, B:139:0x0503, B:141:0x0526, B:143:0x0530, B:144:0x0563, B:146:0x05bb, B:150:0x05e9, B:153:0x0621, B:155:0x063a, B:157:0x0642, B:162:0x0657, B:163:0x065a, B:161:0x0651, B:165:0x0667, B:167:0x0676, B:169:0x0681, B:172:0x069c, B:174:0x06d1, B:181:0x074a, B:208:0x084d, B:179:0x0722, B:175:0x06de, B:170:0x068e, B:106:0x044b, B:186:0x0760, B:190:0x0771, B:188:0x076a, B:117:0x0482, B:119:0x048c, B:192:0x0774, B:203:0x07ee, B:205:0x0809, B:207:0x081a, B:195:0x07a8, B:198:0x07c7, B:72:0x0311, B:38:0x01c9), top: B:236:0x00e7, inners: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x06de A[Catch: all -> 0x07e1, Exception -> 0x08cd, TRY_ENTER, TryCatch #1 {all -> 0x07e1, blocks: (B:20:0x00e7, B:23:0x0105, B:26:0x012d, B:29:0x015e, B:32:0x01aa, B:37:0x01c1, B:40:0x01da, B:42:0x01e1, B:47:0x024f, B:49:0x0256, B:51:0x025d, B:54:0x0269, B:59:0x02a8, B:62:0x02ba, B:65:0x02e4, B:67:0x02f3, B:69:0x0300, B:71:0x0307, B:77:0x0323, B:79:0x035e, B:80:0x0362, B:81:0x0365, B:83:0x038f, B:85:0x039e, B:103:0x0439, B:122:0x0499, B:124:0x04b1, B:128:0x04c0, B:130:0x04ce, B:132:0x04dc, B:134:0x04ea, B:136:0x04f2, B:139:0x0503, B:141:0x0526, B:143:0x0530, B:144:0x0563, B:146:0x05bb, B:150:0x05e9, B:153:0x0621, B:155:0x063a, B:157:0x0642, B:162:0x0657, B:163:0x065a, B:161:0x0651, B:165:0x0667, B:167:0x0676, B:169:0x0681, B:172:0x069c, B:174:0x06d1, B:181:0x074a, B:208:0x084d, B:179:0x0722, B:175:0x06de, B:170:0x068e, B:106:0x044b, B:186:0x0760, B:190:0x0771, B:188:0x076a, B:117:0x0482, B:119:0x048c, B:192:0x0774, B:203:0x07ee, B:205:0x0809, B:207:0x081a, B:195:0x07a8, B:198:0x07c7, B:72:0x0311, B:38:0x01c9), top: B:236:0x00e7, inners: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0482 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0760 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.content.Context r7, android.content.Context r8, int r9) {
        /*
            Method dump skipped, instructions count: 2262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.o.a(android.content.Context, android.content.Context, int):void");
    }

    private boolean a(Context context, File file) {
        return a(context, file, false);
    }

    private boolean a(Context context, File file, boolean z) {
        TbsDownloadConfig tbsDownloadConfig;
        int i2;
        TbsLog.i("TbsInstaller", "TbsInstaller-unzipTbs start");
        if (FileUtil.c(file)) {
            try {
                File tbsFolderDir = QbSdk.getTbsFolderDir(context);
                File file2 = z ? new File(tbsFolderDir, "core_share_decouple") : new File(tbsFolderDir, "core_unzip_tmp");
                if (file2.exists() && !TbsDownloader.a(context)) {
                    FileUtil.b(file2);
                }
            } catch (Throwable th) {
                TbsLog.e("TbsInstaller", "TbsInstaller-unzipTbs -- delete unzip folder if exists exception" + Log.getStackTraceString(th));
            }
            File f = z ? f(context, 2) : f(context, 0);
            if (f != null) {
                try {
                    try {
                        FileUtil.a(f);
                        if (z) {
                            FileUtil.a(f, true);
                        }
                        boolean a2 = FileUtil.a(file, f);
                        boolean z2 = a2;
                        if (a2) {
                            z2 = a(f, context);
                        }
                        if (z) {
                            String[] list = f.list();
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 < list.length) {
                                    File file3 = new File(f, list[i4]);
                                    if (file3.getName().endsWith(ShareConstants.DEX_SUFFIX)) {
                                        file3.delete();
                                    }
                                    i3 = i4 + 1;
                                } else {
                                    try {
                                        break;
                                    } catch (Exception e) {
                                    }
                                }
                            }
                            new File(s(context), "x5.tbs").delete();
                        }
                        if (z2) {
                            g(context, true);
                            if (z) {
                                File p2 = p(context);
                                FileUtil.a(p2, true);
                                f.renameTo(p2);
                                TbsShareManager.b(context);
                            }
                        } else {
                            FileUtil.b(f);
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-522);
                            TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#1! exist:" + f.exists());
                        }
                        TbsLog.i("TbsInstaller", "TbsInstaller-unzipTbs done");
                        return z2;
                    } catch (IOException e2) {
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-523);
                        TbsLogReport.getInstance(context).setInstallErrorCode(206, e2);
                        if ((f != null && f.exists()) && f != null) {
                            try {
                                FileUtil.b(f);
                                TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exist:" + f.exists());
                            } catch (Throwable th2) {
                                TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exception:" + Log.getStackTraceString(th2));
                            }
                        }
                        TbsLog.i("TbsInstaller", "TbsInstaller-unzipTbs done");
                        return false;
                    } catch (Exception e3) {
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-523);
                        TbsLogReport.getInstance(context).setInstallErrorCode(207, e3);
                        if ((f != null && f.exists()) && f != null) {
                            try {
                                FileUtil.b(f);
                                TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exist:" + f.exists());
                            } catch (Throwable th3) {
                                TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exception:" + Log.getStackTraceString(th3));
                            }
                        }
                        TbsLog.i("TbsInstaller", "TbsInstaller-unzipTbs done");
                        return false;
                    }
                } catch (Throwable th4) {
                    TbsLog.i("TbsInstaller", "TbsInstaller-unzipTbs done");
                    throw th4;
                }
            }
            TbsLogReport.getInstance(context).setInstallErrorCode(205, "tmp unzip dir is null!");
            tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
            i2 = -521;
        } else {
            TbsLogReport.getInstance(context).setInstallErrorCode(204, "apk is invalid!");
            tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
            i2 = -520;
        }
        tbsDownloadConfig.setInstallInterruptCode(i2);
        return false;
    }

    static boolean a(Context context, String str) {
        String str2;
        File file = new File(QbSdk.getTbsFolderDir(context), str);
        if (!file.exists()) {
            str2 = "TbsInstaller-isPrepareTbsCore, #1";
        } else if (new File(file, "tbs.conf").exists()) {
            TbsLog.i("TbsInstaller", "TbsInstaller-isPrepareTbsCore, #3");
            return true;
        } else {
            str2 = "TbsInstaller-isPrepareTbsCore, #2";
        }
        TbsLog.i("TbsInstaller", str2);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0255 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(java.io.File r7, android.content.Context r8) {
        /*
            Method dump skipped, instructions count: 611
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.o.a(java.io.File, android.content.Context):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:280:0x09fd  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x070b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(android.content.Context r7, java.lang.String r8, int r9) {
        /*
            Method dump skipped, instructions count: 2630
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.o.b(android.content.Context, java.lang.String, int):void");
    }

    private boolean b(Context context, File file) {
        try {
            File[] listFiles = file.listFiles(new FileFilter() { // from class: com.tencent.smtt.sdk.o.6
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    return file2.getName().endsWith(ShareConstants.JAR_SUFFIX);
                }
            });
            int length = listFiles.length;
            if (Build.VERSION.SDK_INT < 16 && context.getPackageName() != null && context.getPackageName().equalsIgnoreCase(TbsConfig.APP_DEMO)) {
                try {
                    Thread.sleep(5000L);
                } catch (Exception e) {
                }
            }
            ClassLoader classLoader = context.getClassLoader();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return true;
                }
                TbsLog.i("TbsInstaller", "jarFile: " + listFiles[i3].getAbsolutePath());
                new DexClassLoader(listFiles[i3].getAbsolutePath(), file.getAbsolutePath(), null, classLoader);
                i2 = i3 + 1;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            TbsLogReport.getInstance(context).setInstallErrorCode(209, e2.toString());
            TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt done");
            return false;
        }
    }

    private int c(Context context, Bundle bundle) {
        TbsLogReport tbsLogReport;
        int i2;
        try {
            Bundle a2 = QbSdk.a(context, bundle);
            TbsLog.i("TbsInstaller", "tpatch finished,ret is" + a2);
            int i3 = a2.getInt("patch_result");
            if (i3 != 0) {
                String string = bundle.getString("new_apk_location");
                if (!TextUtils.isEmpty(string)) {
                    FileUtil.b(new File(string));
                }
                TbsLogReport.getInstance(context).setInstallErrorCode(i3, "tpatch fail,patch error_code=" + i3);
                return 1;
            }
            String string2 = bundle.getString("new_apk_location");
            int i4 = bundle.getInt("new_core_ver");
            int a3 = a(new File(string2));
            if (i4 != a3) {
                TbsLog.i("TbsInstaller", "version not equals!!!" + i4 + "patchVersion:" + a3);
                TbsLogReport.getInstance(context).setInstallErrorCode(240, "version=" + i4 + ",patchVersion=" + a3);
                return 1;
            }
            File file = new File(bundle.getString("backup_apk"));
            String a4 = com.tencent.smtt.utils.b.a(context, true, file);
            if ("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(a4)) {
                if (TbsDownloader.a(context)) {
                    TbsLog.i("TbsInstaller", "Tpatch decouple success!");
                    tbsLogReport = TbsLogReport.getInstance(context);
                    i2 = 237;
                } else {
                    TbsLog.i("TbsInstaller", "Tpatch success!");
                    tbsLogReport = TbsLogReport.getInstance(context);
                    i2 = 236;
                }
                tbsLogReport.setInstallErrorCode(i2, "");
                return 0;
            }
            TbsLog.i("TbsInstaller", "tpatch sig not equals!!!" + file + "signature:" + a4);
            TbsLogReport.getInstance(context).setInstallErrorCode(241, "version=" + i4 + ",patchVersion=" + a3);
            FileUtil.b(file);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            TbsLogReport.getInstance(context).setInstallErrorCode(239, "patch exception" + Log.getStackTraceString(e));
            return 1;
        }
    }

    private boolean c(Context context, File file) {
        try {
            File file2 = new File(file, "tbs_sdk_extension_dex.jar");
            File file3 = new File(file, "tbs_sdk_extension_dex.dex");
            new DexClassLoader(file2.getAbsolutePath(), file.getAbsolutePath(), null, context.getClassLoader());
            String a2 = d.a(context, file3.getAbsolutePath());
            if (TextUtils.isEmpty(a2)) {
                TbsLogReport.getInstance(context).setInstallErrorCode(226, "can not find oat command");
                return false;
            }
            File[] listFiles = file.listFiles(new FileFilter() { // from class: com.tencent.smtt.sdk.o.7
                @Override // java.io.FileFilter
                public boolean accept(File file4) {
                    return file4.getName().endsWith(ShareConstants.JAR_SUFFIX);
                }
            });
            int length = listFiles.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return true;
                }
                File file4 = listFiles[i3];
                String substring = file4.getName().substring(0, file4.getName().length() - 4);
                String replaceAll = a2.replaceAll("tbs_sdk_extension_dex", substring);
                Runtime.getRuntime().exec("/system/bin/dex2oat " + replaceAll + " --dex-location=" + a().q(context) + File.separator + substring + ShareConstants.JAR_SUFFIX).waitFor();
                i2 = i3 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            TbsLogReport.getInstance(context).setInstallErrorCode(226, e);
            return false;
        }
    }

    /* JADX WARN: Finally extract failed */
    private boolean c(Context context, boolean z) {
        synchronized (this) {
            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch");
            boolean z2 = false;
            if (t(context)) {
                boolean tryLock = i.tryLock();
                StringBuilder sb = new StringBuilder();
                sb.append("TbsInstaller-enableTbsCoreFromTpatch Locked =");
                sb.append(tryLock);
                TbsLog.i("TbsInstaller", sb.toString());
                if (tryLock) {
                    try {
                        int b2 = m.a(context).b("tpatch_status");
                        int a2 = a(false, context);
                        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch copyStatus =" + b2);
                        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer =" + a2);
                        z2 = false;
                        if (b2 == 1) {
                            if (a2 == 0) {
                                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer = 0", true);
                            } else {
                                z2 = false;
                                if (z) {
                                    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer != 0", true);
                                }
                            }
                            y(context);
                            z2 = true;
                        }
                        i.unlock();
                    } catch (Throwable th) {
                        i.unlock();
                        throw th;
                    }
                }
                boolean z3 = z2;
                b();
                return z2;
            }
            return false;
        }
    }

    /* JADX WARN: Finally extract failed */
    private boolean d(Context context, boolean z) {
        synchronized (this) {
            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy");
            boolean z2 = false;
            if (t(context)) {
                boolean tryLock = i.tryLock();
                StringBuilder sb = new StringBuilder();
                sb.append("TbsInstaller-enableTbsCoreFromCopy Locked =");
                sb.append(tryLock);
                TbsLog.i("TbsInstaller", sb.toString());
                if (tryLock) {
                    try {
                        int b2 = m.a(context).b("copy_status");
                        int a2 = a(false, context);
                        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy copyStatus =" + b2);
                        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer =" + a2);
                        z2 = false;
                        if (b2 == 1) {
                            if (a2 == 0) {
                                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer = 0", true);
                            } else {
                                z2 = false;
                                if (z) {
                                    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer != 0", true);
                                }
                            }
                            z(context);
                            z2 = true;
                        }
                        i.unlock();
                    } catch (Throwable th) {
                        i.unlock();
                        throw th;
                    }
                }
                boolean z3 = z2;
                b();
                return z2;
            }
            return false;
        }
    }

    private boolean e(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    /* JADX WARN: Finally extract failed */
    private boolean e(Context context, boolean z) {
        synchronized (this) {
            if (context != null) {
                if ("com.tencent.mm".equals(context.getApplicationContext().getApplicationInfo().packageName)) {
                    TbsLogReport.getInstance(context).setInstallErrorCode(229, " ");
                }
            }
            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip canRenameTmpDir =" + z);
            TbsLog.i("TbsInstaller", "Tbsinstaller enableTbsCoreFromUnzip #1 ");
            boolean z2 = false;
            boolean z3 = false;
            try {
            } catch (Exception e) {
                QbSdk.a(context, "TbsInstaller::enableTbsCoreFromUnzip Exception: " + e);
                e.printStackTrace();
            }
            if (t(context)) {
                TbsLog.i("TbsInstaller", "Tbsinstaller enableTbsCoreFromUnzip #2 ");
                boolean tryLock = i.tryLock();
                StringBuilder sb = new StringBuilder();
                sb.append("TbsInstaller-enableTbsCoreFromUnzip locked=");
                sb.append(tryLock);
                TbsLog.i("TbsInstaller", sb.toString());
                if (tryLock) {
                    try {
                        int c2 = m.a(context).c();
                        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip installStatus=" + c2);
                        int a2 = a(false, context);
                        z2 = false;
                        if (c2 == 2) {
                            TbsLog.i("TbsInstaller", "Tbsinstaller enableTbsCoreFromUnzip #4 ");
                            if (a2 == 0) {
                                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer = 0", false);
                            } else {
                                z2 = false;
                                if (z) {
                                    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer != 0", false);
                                }
                            }
                            x(context);
                            z2 = true;
                        }
                        i.unlock();
                    } catch (Throwable th) {
                        i.unlock();
                        throw th;
                    }
                }
                boolean z4 = z2;
                b();
                z3 = z2;
                return z3;
            }
            return false;
        }
    }

    private boolean f(Context context, boolean z) {
        synchronized (this) {
        }
        return false;
    }

    private void g(Context context, boolean z) {
        if (context == null) {
            TbsLogReport.getInstance(context).setInstallErrorCode(225, "setTmpFolderCoreToRead context is null");
            return;
        }
        try {
            File file = new File(QbSdk.getTbsFolderDir(context), "tmp_folder_core_to_read.conf");
            if (!z) {
                FileUtil.b(file);
            } else if (file.exists()) {
            } else {
                file.createNewFile();
            }
        } catch (Exception e) {
            TbsLogReport tbsLogReport = TbsLogReport.getInstance(context);
            tbsLogReport.setInstallErrorCode(225, "setTmpFolderCoreToRead Exception message is " + e.getMessage() + " Exception cause is " + e.getCause());
        }
    }

    private void h(Context context, int i2) {
        TbsLog.i("TbsInstaller", "proceedTpatchStatus,result=" + i2);
        if (i2 == 0) {
            if (TbsDownloader.a(context)) {
                i(context, 6);
            } else {
                g(context, true);
                m.a(context).b(TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0), 1);
            }
        }
        QbSdk.setTBSInstallingStatus(false);
    }

    private void i(Context context, int i2) {
        File f = a().f(context, i2);
        a().g(context, true);
        File p2 = p(context);
        FileUtil.a(p2, true);
        f.renameTo(p2);
        TbsShareManager.b(context);
    }

    private boolean j(Context context, int i2) {
        File f;
        boolean z;
        boolean z2;
        TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt start - dirMode: " + i2);
        try {
            if (i2 != 0) {
                if (i2 == 1) {
                    f = f(context, 1);
                } else if (i2 != 2) {
                    TbsLog.e("TbsInstaller", "doDexoptOrDexoat mode error: " + i2);
                    return false;
                } else {
                    f = q(context);
                }
            } else if (TbsDownloader.a(context)) {
                return true;
            } else {
                f = f(context, 0);
            }
            String property = System.getProperty("java.vm.version");
            z = property != null && property.startsWith("2");
            boolean z3 = Build.VERSION.SDK_INT == 23;
            boolean z4 = TbsDownloadConfig.getInstance(context).mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_STOP_PRE_OAT, false);
            z2 = false;
            if (z) {
                z2 = false;
                if (z3) {
                    z2 = false;
                    if (!z4) {
                        z2 = true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            TbsLogReport.getInstance(context).setInstallErrorCode(209, e.toString());
        }
        if (z2 && c(context, f)) {
            TbsLog.i("TbsInstaller", "doTbsDexOpt -- doDexoatForArtVm");
            return true;
        } else if (!z) {
            TbsLog.i("TbsInstaller", "doTbsDexOpt -- doDexoptForDavlikVM");
            return b(context, f);
        } else {
            TbsLog.i("TbsInstaller", "doTbsDexOpt -- is ART mode, skip!");
            TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt done");
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File s(Context context) {
        File file = new File(QbSdk.getTbsFolderDir(context), "core_private");
        if (file.isDirectory() || file.mkdir()) {
            return file;
        }
        return null;
    }

    private int u(Context context) {
        boolean z = true;
        if (m.a(context).d() != 1) {
            z = false;
        }
        boolean a2 = TbsDownloader.a(context);
        return z ? a2 ? 234 : 221 : a2 ? 233 : 200;
    }

    private static boolean v(Context context) {
        String str;
        if (context == null) {
            str = "TbsInstaller-getTmpFolderCoreToRead, #1";
        } else {
            try {
                if (new File(QbSdk.getTbsFolderDir(context), "tmp_folder_core_to_read.conf").exists()) {
                    TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #2");
                    return true;
                }
                TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #3");
                return false;
            } catch (Exception e) {
                str = "TbsInstaller-getTmpFolderCoreToRead, #4";
            }
        }
        TbsLog.i("TbsInstaller", str);
        return true;
    }

    private boolean w(Context context) {
        boolean z;
        TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock #1 ");
        try {
            z = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
        } catch (Throwable th) {
            z = true;
        }
        TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock #2  enabled is " + z);
        l = !z ? w.a().b(context) : FileUtil.f(context);
        if (l == null) {
            TbsLog.i("TbsInstaller", "getTbsCoreRenameFileLock## failed!");
            return false;
        }
        TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock true ");
        return true;
    }

    private void x(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip");
        if (!w(context)) {
            TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
            return;
        }
        try {
            A(context);
            B(context);
            TbsLog.i("TbsInstaller", "after renameTbsCoreShareDir");
            if (TbsShareManager.isThirdPartyApp(context)) {
                TbsLog.i("TbsInstaller", "is thirdapp and not chmod");
            } else {
                TbsLog.i("TbsInstaller", "prepare to shareTbsCore");
                TbsShareManager.a(context);
            }
            m.a(context).a(0);
            m.a(context).b(0);
            m.a(context).d(0);
            m.a(context).a("incrupdate_retry_num", 0);
            m.a(context).c(0, 3);
            m.a(context).a("");
            m.a(context).a("tpatch_num", 0);
            m.a(context).c(-1);
            if (!TbsShareManager.isThirdPartyApp(context)) {
                int i2 = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
                if (i2 <= 0 || i2 == a().h(context) || i2 != a().i(context)) {
                    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip #1 deCoupleCoreVersion is " + i2 + " getTbsCoreShareDecoupleCoreVersion is " + a().h(context) + " getTbsCoreInstalledVerInNolock is " + a().i(context));
                } else {
                    n(context);
                }
            }
            if (TbsShareManager.isThirdPartyApp(context)) {
                TbsShareManager.writeCoreInfoForThirdPartyApp(context, m(context), true);
            }
            f25173a.set(0);
            o = 0;
        } catch (Throwable th) {
            th.printStackTrace();
            TbsLogReport tbsLogReport = TbsLogReport.getInstance(context);
            tbsLogReport.setInstallErrorCode(219, "exception when renameing from unzip:" + th.toString());
            TbsLog.e("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip Exception", true);
        }
        g(context);
    }

    private void y(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromTpatch");
        if (!w(context)) {
            TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
            return;
        }
        try {
            A(context);
            D(context);
            TbsShareManager.a(context);
            m.a(context).b(0, -1);
            m.a(context).a("tpatch_num", 0);
            f25173a.set(0);
        } catch (Exception e) {
            e.printStackTrace();
            TbsLogReport tbsLogReport = TbsLogReport.getInstance(context);
            tbsLogReport.setInstallErrorCode(242, "exception when renameing from tpatch:" + e.toString());
        }
        g(context);
    }

    private void z(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy");
        if (!w(context)) {
            TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
            return;
        }
        try {
            A(context);
            C(context);
            TbsShareManager.a(context);
            m.a(context).a(0, 3);
            m.a(context).a("tpatch_num", 0);
            if (!TbsShareManager.isThirdPartyApp(context)) {
                int i2 = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
                if (i2 <= 0 || i2 == a().h(context) || i2 != a().i(context)) {
                    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy #1 deCoupleCoreVersion is " + i2 + " getTbsCoreShareDecoupleCoreVersion is " + a().h(context) + " getTbsCoreInstalledVerInNolock is " + a().i(context));
                } else {
                    n(context);
                }
            }
            f25173a.set(0);
        } catch (Exception e) {
            e.printStackTrace();
            TbsLogReport tbsLogReport = TbsLogReport.getInstance(context);
            tbsLogReport.setInstallErrorCode(219, "exception when renameing from copy:" + e.toString());
        }
        g(context);
    }

    int a(File file) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsVersion  tbsShareDir is " + file);
            File file2 = new File(file, "tbs.conf");
            if (file2.exists()) {
                Properties properties = new Properties();
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file2));
                try {
                    properties.load(bufferedInputStream);
                    bufferedInputStream.close();
                    String property = properties.getProperty("tbs_core_version");
                    if (property == null) {
                        try {
                            bufferedInputStream.close();
                            return 0;
                        } catch (IOException e) {
                            return 0;
                        }
                    }
                    int parseInt = Integer.parseInt(property);
                    try {
                        bufferedInputStream.close();
                        return parseInt;
                    } catch (IOException e2) {
                        return parseInt;
                    }
                } catch (Exception e3) {
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                            return 0;
                        } catch (IOException e4) {
                            return 0;
                        }
                    }
                    return 0;
                } catch (Throwable th) {
                    bufferedInputStream2 = bufferedInputStream;
                    th = th;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th;
                }
            }
            return 0;
        } catch (Exception e6) {
            bufferedInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(String str) {
        BufferedInputStream bufferedInputStream;
        if (str == null) {
            return 0;
        }
        BufferedInputStream bufferedInputStream2 = null;
        try {
            File file = new File(new File(str), "tbs.conf");
            if (file.exists()) {
                Properties properties = new Properties();
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream);
                    bufferedInputStream.close();
                    String property = properties.getProperty("tbs_core_version");
                    if (property == null) {
                        try {
                            bufferedInputStream.close();
                            return 0;
                        } catch (IOException e) {
                            return 0;
                        }
                    }
                    int parseInt = Integer.parseInt(property);
                    try {
                        bufferedInputStream.close();
                        return parseInt;
                    } catch (IOException e2) {
                        return parseInt;
                    }
                } catch (Exception e3) {
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                            return 0;
                        } catch (IOException e4) {
                            return 0;
                        }
                    }
                    return 0;
                } catch (Throwable th) {
                    bufferedInputStream2 = bufferedInputStream;
                    th = th;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th;
                }
            }
            return 0;
        } catch (Exception e6) {
            bufferedInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public int a(boolean z, Context context) {
        if (z || f25173a.get().intValue() <= 0) {
            f25173a.set(Integer.valueOf(i(context)));
        }
        return f25173a.get().intValue();
    }

    File a(Context context, int i2, boolean z) {
        String str;
        String str2;
        File tbsFolderDir = QbSdk.getTbsFolderDir(context);
        switch (i2) {
            case 0:
                str = "core_unzip_tmp";
                break;
            case 1:
                str = "core_copy_tmp";
                break;
            case 2:
                str = "core_unzip_tmp_decouple";
                break;
            case 3:
                str = "core_share_backup";
                break;
            case 4:
                str = "core_share_backup_tmp";
                break;
            case 5:
                str = "tpatch_tmp";
                break;
            case 6:
                str = "tpatch_decouple_tmp";
                break;
            default:
                str = "";
                break;
        }
        TbsLog.i("TbsInstaller", "type=" + i2 + "needMakeDir=" + z + "folder=" + str);
        File file = new File(tbsFolderDir, str);
        if (!file.isDirectory()) {
            if (z) {
                str2 = file.mkdir() ? "getCoreDir,no need mkdir" : "getCoreDir,mkdir false";
            }
            TbsLog.i("TbsInstaller", str2);
            return null;
        }
        return file;
    }

    public void a(Context context, int i2) {
        g(context, true);
        m.a(context).c(i2, 2);
    }

    void a(Context context, Bundle bundle) {
        if (bundle == null || context == null) {
            return;
        }
        Message message = new Message();
        message.what = 3;
        message.obj = new Object[]{context, bundle};
        m.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, File file, int i2) {
        TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmp,ctx=" + context + "File=" + file + "coreVersion=" + i2);
        if (file == null || context == null) {
            return;
        }
        Message message = new Message();
        message.what = 4;
        message.obj = new Object[]{context, file, Integer.valueOf(i2)};
        m.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, String str, int i2) {
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsApkPath=" + str);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsCoreTargetVer=" + i2);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentThreadName=" + Thread.currentThread().getName());
        Message message = new Message();
        message.what = 1;
        message.obj = new Object[]{context, str, Integer.valueOf(i2)};
        m.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, boolean z) {
        int c2;
        int b2;
        String d2;
        int c3;
        int b3;
        if (z) {
            this.k = true;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentThreadName=" + Thread.currentThread().getName());
        if (t(context)) {
            if (i.tryLock()) {
                try {
                    c2 = m.a(context).c();
                    b2 = m.a(context).b();
                    d2 = m.a(context).d("install_apk_path");
                    c3 = m.a(context).c("copy_core_ver");
                    b3 = m.a(context).b("copy_status");
                    i.unlock();
                } catch (Throwable th) {
                    i.unlock();
                    throw th;
                }
            } else {
                d2 = null;
                c2 = -1;
                b2 = 0;
                c3 = 0;
                b3 = -1;
            }
            b();
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore installStatus=" + c2);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreInstallVer=" + b2);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsApkPath=" + d2);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreCopyVer=" + c3);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore copyStatus=" + b3);
            if (TbsShareManager.isThirdPartyApp(context)) {
                c(context, TbsShareManager.a(context, false));
                return;
            }
            int i2 = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
            boolean z2 = true;
            if (i2 != 1) {
                z2 = true;
                if (i2 != 2) {
                    z2 = i2 == 4;
                }
            }
            if (!z2 && i2 != 0 && i2 != 5) {
                Bundle bundle = new Bundle();
                bundle.putInt("operation", 10001);
                a(context, bundle);
            }
            if (c2 > -1 && c2 < 2) {
                a(context, d2, b2);
            }
            if (b3 == 0) {
                b(context, c3);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.tencent.smtt.sdk.o$4] */
    public boolean a(final Context context, final Context context2) {
        synchronized (this) {
            TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp");
            if (p) {
                return true;
            }
            p = true;
            new Thread() { // from class: com.tencent.smtt.sdk.o.4
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    o oVar;
                    Context context3;
                    File q;
                    TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread start");
                    try {
                        if (context2 == null) {
                            q = new File(TbsShareManager.getHostCorePathAppDefined());
                        } else {
                            if (!TbsShareManager.isThirdPartyApp(context)) {
                                oVar = o.this;
                                context3 = context2;
                            } else if (TbsShareManager.c(context) == null || !TbsShareManager.c(context).contains("decouple")) {
                                oVar = o.this;
                                context3 = context2;
                            } else {
                                q = o.this.p(context2);
                            }
                            q = oVar.q(context3);
                        }
                        File q2 = o.this.q(context);
                        int i2 = Build.VERSION.SDK_INT;
                        if (i2 != 19 && i2 < 21) {
                            FileUtil.a(q, q2, new FileFilter() { // from class: com.tencent.smtt.sdk.o.4.1
                                @Override // java.io.FileFilter
                                public boolean accept(File file) {
                                    return file.getName().endsWith(ShareConstants.DEX_SUFFIX);
                                }
                            });
                        }
                        FileUtil.a(q, q2, new FileFilter() { // from class: com.tencent.smtt.sdk.o.4.2
                            @Override // java.io.FileFilter
                            public boolean accept(File file) {
                                return file.getName().endsWith("tbs.conf");
                            }
                        });
                        TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread done");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            return true;
        }
    }

    public boolean a(Context context, File[] fileArr) {
        return false;
    }

    Context b(Context context, String str) {
        try {
            if (context.getPackageName() == str || !TbsPVConfig.getInstance(context).isEnableNoCoreGray()) {
                return context.createPackageContext(str, 2);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File b(Context context, Context context2) {
        File file = new File(QbSdk.getTbsFolderDir(context2), "core_share");
        if (file.isDirectory() || ((context != null && TbsShareManager.isThirdPartyApp(context)) || file.mkdir())) {
            return file;
        }
        TbsLog.i("TbsInstaller", "getTbsCoreShareDir,mkdir false");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        synchronized (this) {
            if (this.e <= 0) {
                TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock currentTbsFileLockStackCount=" + this.e + "call stack:" + Log.getStackTraceString(new Throwable()));
            } else if (this.e > 1) {
                TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock with skip");
                this.e--;
            } else {
                if (this.e == 1) {
                    TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock without skip");
                    FileUtil.a(this.f, this.g);
                    this.e = 0;
                }
            }
        }
    }

    public void b(Context context) {
        g(context, true);
        m.a(context).c(h(context), 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:153:0x049d  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x04a4  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0643  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x064a  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0704  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x070b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(android.content.Context r7, android.os.Bundle r8) {
        /*
            Method dump skipped, instructions count: 2080
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.o.b(android.content.Context, android.os.Bundle):void");
    }

    public void b(Context context, File file, int i2) {
        FileOutputStream b2 = FileUtil.b(context, true, "core_unzip.lock");
        FileLock a2 = FileUtil.a(context, b2);
        if (a2 == null) {
            TbsLog.i("TbsInstaller", "can not get Core unzip FileLock,skip!!!");
            return;
        }
        TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmpInThread #1");
        boolean a3 = a(context, file, false);
        TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmpInThread result is " + a3);
        if (a3) {
            a().a(context, i2);
        }
        FileUtil.a(a2, b2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Context context, boolean z) {
        String str;
        if (QbSdk.b) {
            return;
        }
        if (Build.VERSION.SDK_INT < 8) {
            TbsLog.e("TbsInstaller", "android version < 2.1 no need install X5 core", true);
            return;
        }
        TbsLog.i("TbsInstaller", "Tbsinstaller installTbsCoreIfNeeded #1 ");
        if (TbsShareManager.isThirdPartyApp(context) && m.a(context).b("remove_old_core") == 1 && z) {
            try {
                FileUtil.b(a().q(context));
                TbsLog.i("TbsInstaller", "thirdAPP success--> delete old core_share Directory");
            } catch (Throwable th) {
                th.printStackTrace();
            }
            m.a(context).a("remove_old_core", 0);
        }
        if (v(context)) {
            TbsLog.i("TbsInstaller", "Tbsinstaller installTbsCoreIfNeeded #2 ");
            if (a(context, "core_unzip_tmp") && e(context, z)) {
                str = "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromUnzip!!";
            } else if (a(context, "core_share_backup_tmp") && f(context, z)) {
                str = "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromBackup!!";
            } else if (a(context, "core_copy_tmp") && d(context, z)) {
                str = "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromCopy!!";
            } else if (!a(context, "tpatch_tmp") || !c(context, z)) {
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, error !!", true);
                return;
            } else {
                str = "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromTpatch!!";
            }
            TbsLog.i("TbsInstaller", str, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Context context, int i2) {
        if (TbsDownloader.getOverSea(context)) {
            return false;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore targetTbsCoreVer=" + i2);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentThreadName=" + Thread.currentThread().getName());
        Context d2 = d(context, i2);
        if (d2 == null) {
            TbsLog.i("TbsInstaller", "TbsInstaller--installLocalTbsCore copy from null");
            return false;
        }
        Message message = new Message();
        message.what = 2;
        message.obj = new Object[]{d2, context, Integer.valueOf(i2)};
        m.sendMessage(message);
        return true;
    }

    int c(Context context, String str) {
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 0);
        if (packageArchiveInfo != null) {
            return packageArchiveInfo.versionCode;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File c(Context context, Context context2) {
        File file = new File(QbSdk.getTbsFolderDir(context2), "core_share_decouple");
        if (file.isDirectory() || ((context != null && TbsShareManager.isThirdPartyApp(context)) || file.mkdir())) {
            return file;
        }
        return null;
    }

    void c(Context context, int i2) {
        int i3;
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreForThirdPartyApp");
        if (i2 > 0 && (i3 = i(context)) != i2) {
            Context e = TbsShareManager.e(context);
            if (e != null || TbsShareManager.getHostCorePathAppDefined() != null) {
                TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp hostContext != null");
                a(context, e);
            } else if (i3 <= 0) {
                TbsLog.i("TbsInstaller", "TbsInstaller--installTbsCoreForThirdPartyApp hostContext == null");
                QbSdk.a(context, "TbsInstaller::installTbsCoreForThirdPartyApp forceSysWebViewInner #2");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(Context context) {
        File file = new File(q(context), "tbs.conf");
        boolean z = false;
        if (!file.exists()) {
            return false;
        }
        Properties properties = new Properties();
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                properties.load(bufferedInputStream2);
                boolean booleanValue = Boolean.valueOf(properties.getProperty("tbs_local_installation", "false")).booleanValue();
                boolean z2 = false;
                if (booleanValue) {
                    z2 = false;
                    try {
                        if (System.currentTimeMillis() - file.lastModified() > 259200000) {
                            z2 = true;
                        }
                    } catch (Throwable th) {
                        th = th;
                        z = booleanValue;
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        try {
                            th.printStackTrace();
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            return z;
                        } catch (Throwable th2) {
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            throw th2;
                        }
                    }
                }
                TbsLog.i("TbsInstaller", "TBS_LOCAL_INSTALLATION is:" + booleanValue + " expired=" + z2);
                boolean z3 = booleanValue & (!z2);
                try {
                    bufferedInputStream2.close();
                    return z3;
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return z3;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            z = false;
        }
    }

    public Context d(Context context, int i2) {
        Context b2;
        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreHostContext tbsCoreTargetVer=" + i2);
        if (i2 <= 0) {
            return null;
        }
        String[] coreProviderAppList = TbsShareManager.getCoreProviderAppList();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= coreProviderAppList.length) {
                return null;
            }
            if (!context.getPackageName().equalsIgnoreCase(coreProviderAppList[i4]) && e(context, coreProviderAppList[i4]) && (b2 = b(context, coreProviderAppList[i4])) != null) {
                if (f(b2)) {
                    int i5 = i(b2);
                    TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext hostTbsCoreVer=" + i5);
                    if (i5 != 0 && i5 == i2) {
                        TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext targetApp=" + coreProviderAppList[i4]);
                        return b2;
                    }
                } else {
                    TbsLog.e("TbsInstaller", "TbsInstaller--getTbsCoreHostContext " + coreProviderAppList[i4] + " illegal signature go on next");
                }
            }
            i3 = i4 + 1;
        }
    }

    public String d(Context context, String str) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            File file = new File(q(context), "tbs.conf");
            if (file.exists()) {
                Properties properties = new Properties();
                bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream2);
                    bufferedInputStream2.close();
                    String property = properties.getProperty(str);
                    try {
                        bufferedInputStream2.close();
                        return property;
                    } catch (IOException e) {
                        return property;
                    }
                } catch (Exception e2) {
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                            return null;
                        } catch (IOException e3) {
                            return null;
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    bufferedInputStream = bufferedInputStream2;
                    th = th;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            }
            return null;
        } catch (Exception e5) {
            bufferedInputStream2 = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
        }
    }

    public void d(Context context) {
        BufferedInputStream bufferedInputStream;
        try {
            File file = new File(q(context), "tbs.conf");
            Properties properties = new Properties();
            BufferedOutputStream bufferedOutputStream = null;
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream);
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        properties.setProperty("tbs_local_installation", "false");
                        properties.store(bufferedOutputStream2, (String) null);
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException e) {
                        }
                    } catch (Throwable th) {
                        bufferedOutputStream = bufferedOutputStream2;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e2) {
                            }
                        }
                        if (bufferedInputStream == null) {
                            return;
                        }
                        bufferedInputStream.close();
                    }
                } catch (Throwable th2) {
                }
            } catch (Throwable th3) {
                bufferedInputStream = null;
            }
            bufferedInputStream.close();
        } catch (Throwable th4) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e(Context context, int i2) {
        return a(f(context, i2));
    }

    public boolean e(Context context) {
        try {
            File file = new File(FileUtil.a(context, 4), TbsDownloader.getBackupFileName(true));
            File f = a().f(context, 2);
            FileUtil.a(f);
            FileUtil.a(f, true);
            FileUtil.a(file, f);
            String[] list = f.list();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= list.length) {
                    i(context, 2);
                    return true;
                }
                File file2 = new File(f, list[i3]);
                if (file2.getName().endsWith(ShareConstants.DEX_SUFFIX)) {
                    file2.delete();
                }
                i2 = i3 + 1;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File f(Context context, int i2) {
        return a(context, i2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(Context context) {
        if (TbsShareManager.getHostCorePathAppDefined() != null) {
            return true;
        }
        try {
            Signature signature = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0];
            return context.getPackageName().equals(TbsConfig.APP_QB) ? signature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a") : context.getPackageName().equals("com.tencent.mm") ? signature.toCharsString().equals("308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499") : context.getPackageName().equals("com.tencent.mobileqq") ? signature.toCharsString().equals("30820253308201bca00302010202044bbb0361300d06092a864886f70d0101050500306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b30090603550403130251513020170d3130303430363039343831375a180f32323834303132303039343831375a306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b300906035504031302515130819f300d06092a864886f70d010101050003818d0030818902818100a15e9756216f694c5915e0b529095254367c4e64faeff07ae13488d946615a58ddc31a415f717d019edc6d30b9603d3e2a7b3de0ab7e0cf52dfee39373bc472fa997027d798d59f81d525a69ecf156e885fd1e2790924386b2230cc90e3b7adc95603ddcf4c40bdc72f22db0f216a99c371d3bf89cba6578c60699e8a0d536950203010001300d06092a864886f70d01010505000381810094a9b80e80691645dd42d6611775a855f71bcd4d77cb60a8e29404035a5e00b21bcc5d4a562482126bd91b6b0e50709377ceb9ef8c2efd12cc8b16afd9a159f350bb270b14204ff065d843832720702e28b41491fbc3a205f5f2f42526d67f17614d8a974de6487b2c866efede3b4e49a0f916baa3c1336fd2ee1b1629652049") : context.getPackageName().equals(TbsConfig.APP_DEMO) ? signature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a") : context.getPackageName().equals("com.qzone") ? signature.toCharsString().equals("308202ad30820216a00302010202044c26cea2300d06092a864886f70d010105050030819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d301e170d3130303632373034303830325a170d3335303632313034303830325a30819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d30819f300d06092a864886f70d010101050003818d003081890281810082d6aca037a9843fbbe88b6dd19f36e9c24ce174c1b398f3a529e2a7fe02de99c27539602c026edf96ad8d43df32a85458bca1e6fbf11958658a7d6751a1d9b782bf43a8c19bd1c06bdbfd94c0516326ae3cf638ac42bb470580e340c46e6f306a772c1ef98f10a559edf867f3f31fe492808776b7bd953b2cba2d2b2d66a44f0203010001300d06092a864886f70d0101050500038181006003b04a8a8c5be9650f350cda6896e57dd13e6e83e7f891fc70f6a3c2eaf75cfa4fc998365deabbd1b9092159edf4b90df5702a0d101f8840b5d4586eb92a1c3cd19d95fbc1c2ac956309eda8eef3944baf08c4a49d3b9b3ffb06bc13dab94ecb5b8eb74e8789aa0ba21cb567f538bbc59c2a11e6919924a24272eb79251677") : !context.getPackageName().equals("com.tencent.qqpimsecure") || signature.toCharsString().equals("30820239308201a2a00302010202044c96f48f300d06092a864886f70d01010505003060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e57753020170d3130303932303035343334335a180f32303635303632333035343334335a3060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e577530819f300d06092a864886f70d010101050003818d0030818902818100b56e79dbb1185a79e52d792bb3d0bb3da8010d9b87da92ec69f7dc5ad66ab6bfdff2a6a1ed285dd2358f28b72a468be7c10a2ce30c4c27323ed4edcc936080e5bedc2cbbca0b7e879c08a631182793f44bb3ea284179b263410c298e5f6831032c9702ba4a74e2ccfc9ef857f12201451602fc8e774ac59d6398511586c83d1d0203010001300d06092a864886f70d0101050500038181002475615bb65b8d8786b890535802948840387d06b1692ff3ea47ef4c435719ba1865b81e6bfa6293ce31747c3cd6b34595b485cc1563fd90107ba5845c28b95c79138f0dec288940395bc10f92f2b69d8dc410999deb38900974ce9984b678030edfba8816582f56160d87e38641288d8588d2a31e20b89f223d788dd35cc9c8");
        } catch (Exception e) {
            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore getPackageInfo fail");
            return false;
        }
    }

    public void g(Context context) {
        boolean z;
        FileLock fileLock;
        try {
            z = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
        } catch (Throwable th) {
            z = true;
        }
        if (z && (fileLock = l) != null) {
            FileUtil.a(context, fileLock);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g(Context context, int i2) {
        File q;
        String str;
        try {
            boolean isThirdPartyApp = TbsShareManager.isThirdPartyApp(context);
            if (!isThirdPartyApp) {
                q = q(context);
            } else if (!TbsShareManager.j(context)) {
                TbsLog.e("TbsInstaller", "321");
                return false;
            } else {
                File file = new File(TbsShareManager.c(context));
                q = file;
                if (file.getAbsolutePath().contains(TbsConfig.APP_DEMO)) {
                    return true;
                }
            }
            if (q != null) {
                Long[][] lArr = n;
                int length = lArr.length;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= length) {
                        return true;
                    }
                    Long[] lArr2 = lArr[i4];
                    if (i2 == lArr2[0].intValue()) {
                        File file2 = new File(q, "libmttwebview.so");
                        if (file2.exists() && file2.length() == lArr2[1].longValue()) {
                            TbsLog.d("TbsInstaller", "check so success: " + i2 + "; file: " + file2);
                            return true;
                        }
                        if (!isThirdPartyApp) {
                            FileUtil.b(QbSdk.getTbsFolderDir(context));
                        }
                        f25173a.set(0);
                        str = "322";
                    } else {
                        i3 = i4 + 1;
                    }
                }
            } else {
                str = "323";
            }
            TbsLog.e("TbsInstaller", str);
            return false;
        } catch (Throwable th) {
            TbsLog.e("TbsInstaller", "ISTBSCORELEGAL exception getMessage is " + th.getMessage());
            TbsLog.e("TbsInstaller", "ISTBSCORELEGAL exception getCause is " + th.getCause());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h(Context context) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            File file = new File(p(context), "tbs.conf");
            if (file.exists()) {
                Properties properties = new Properties();
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream);
                    bufferedInputStream.close();
                    String property = properties.getProperty("tbs_core_version");
                    if (property == null) {
                        try {
                            bufferedInputStream.close();
                            return 0;
                        } catch (IOException e) {
                            return 0;
                        }
                    }
                    int parseInt = Integer.parseInt(property);
                    try {
                        bufferedInputStream.close();
                        return parseInt;
                    } catch (IOException e2) {
                        return parseInt;
                    }
                } catch (Exception e3) {
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                            return 0;
                        } catch (IOException e4) {
                            return 0;
                        }
                    }
                    return 0;
                } catch (Throwable th) {
                    bufferedInputStream2 = bufferedInputStream;
                    th = th;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th;
                }
            }
            return 0;
        } catch (Exception e6) {
            bufferedInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i(Context context) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                File file = new File(q(context), "tbs.conf");
                if (file.exists()) {
                    Properties properties = new Properties();
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    try {
                        properties.load(bufferedInputStream);
                        bufferedInputStream.close();
                        String property = properties.getProperty("tbs_core_version");
                        if (property == null) {
                            try {
                                bufferedInputStream.close();
                                return 0;
                            } catch (IOException e) {
                                TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e.toString());
                                return 0;
                            }
                        }
                        int parseInt = Integer.parseInt(property);
                        if (o == 0) {
                            o = parseInt;
                        }
                        try {
                            bufferedInputStream.close();
                            return parseInt;
                        } catch (IOException e2) {
                            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e2.toString());
                            return parseInt;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        StringBuilder sb = new StringBuilder();
                        BufferedInputStream bufferedInputStream3 = bufferedInputStream;
                        sb.append("TbsInstaller--getTbsCoreInstalledVerInNolock Exception=");
                        BufferedInputStream bufferedInputStream4 = bufferedInputStream;
                        sb.append(e.toString());
                        bufferedInputStream2 = bufferedInputStream;
                        TbsLog.i("TbsInstaller", sb.toString());
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                                return 0;
                            } catch (IOException e4) {
                                TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e4.toString());
                                return 0;
                            }
                        }
                        return 0;
                    } catch (Throwable th) {
                        bufferedInputStream2 = bufferedInputStream;
                        th = th;
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e5) {
                                TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e5.toString());
                            }
                        }
                        throw th;
                    }
                }
                return 0;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            e = e6;
            bufferedInputStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j(Context context) {
        int i2 = o;
        return i2 != 0 ? i2 : i(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Context context) {
        if (o != 0) {
            return;
        }
        o = i(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l(Context context) {
        return new File(q(context), "tbs.conf").exists();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m(Context context) {
        BufferedInputStream bufferedInputStream;
        if (!t(context)) {
            return -1;
        }
        boolean tryLock = i.tryLock();
        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock locked=" + tryLock);
        if (!tryLock) {
            b();
            return 0;
        }
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                File file = new File(q(context), "tbs.conf");
                if (!file.exists()) {
                    try {
                        if (i.isHeldByCurrentThread()) {
                            i.unlock();
                        }
                    } catch (Throwable th) {
                        TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: " + th);
                    }
                    b();
                    return 0;
                }
                Properties properties = new Properties();
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream);
                    bufferedInputStream.close();
                    String property = properties.getProperty("tbs_core_version");
                    if (property == null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e) {
                            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock IOException=" + e.toString());
                        }
                        try {
                            if (i.isHeldByCurrentThread()) {
                                i.unlock();
                            }
                        } catch (Throwable th2) {
                            TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: " + th2);
                        }
                        b();
                        return 0;
                    }
                    f25173a.set(Integer.valueOf(Integer.parseInt(property)));
                    int intValue = f25173a.get().intValue();
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e2) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock IOException=" + e2.toString());
                    }
                    try {
                        if (i.isHeldByCurrentThread()) {
                            i.unlock();
                        }
                    } catch (Throwable th3) {
                        TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: " + th3);
                    }
                    b();
                    return intValue;
                } catch (Exception e3) {
                    e = e3;
                    StringBuilder sb = new StringBuilder();
                    BufferedInputStream bufferedInputStream3 = bufferedInputStream;
                    sb.append("TbsInstaller--getTbsCoreInstalledVerWithLock Exception=");
                    BufferedInputStream bufferedInputStream4 = bufferedInputStream;
                    sb.append(e.toString());
                    bufferedInputStream2 = bufferedInputStream;
                    TbsLog.i("TbsInstaller", sb.toString());
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e4) {
                            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock IOException=" + e4.toString());
                        }
                    }
                    try {
                        if (i.isHeldByCurrentThread()) {
                            i.unlock();
                        }
                    } catch (Throwable th4) {
                        TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: " + th4);
                    }
                    b();
                    return 0;
                } catch (Throwable th5) {
                    bufferedInputStream2 = bufferedInputStream;
                    th = th5;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e5) {
                            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock IOException=" + e5.toString());
                        }
                    }
                    try {
                        if (i.isHeldByCurrentThread()) {
                            i.unlock();
                        }
                    } catch (Throwable th6) {
                        TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: " + th6);
                    }
                    b();
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (Exception e6) {
            e = e6;
            bufferedInputStream = null;
        }
    }

    public boolean n(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple #0");
        File q = q(context);
        File p2 = p(context);
        try {
            FileUtil.a(p2, true);
            FileUtil.a(q, p2, new FileFilter() { // from class: com.tencent.smtt.sdk.o.5
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return (file.getName().endsWith(ShareConstants.DEX_SUFFIX) || file.getName().endsWith(".jar_is_first_load_dex_flag_file")) ? false : true;
                }
            });
            TbsShareManager.b(context);
            TbsLog.i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple success!!!");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--cleanStatusAndTmpDir");
        m.a(context).a(0);
        m.a(context).b(0);
        m.a(context).d(0);
        m.a(context).a("incrupdate_retry_num", 0);
        if (TbsDownloader.a(context)) {
            return;
        }
        m.a(context).c(0, -1);
        m.a(context).a("");
        m.a(context).a("copy_retry_num", 0);
        m.a(context).c(-1);
        m.a(context).a(0, -1);
        FileUtil.a(f(context, 0), true);
        FileUtil.a(f(context, 1), true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File p(Context context) {
        File file = new File(QbSdk.getTbsFolderDir(context), "core_share_decouple");
        if (file.isDirectory() || file.mkdir()) {
            return file;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File q(Context context) {
        return b((Context) null, context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File r(Context context) {
        File file = new File(QbSdk.getTbsFolderDir(context), "share");
        if (file.isDirectory() || file.mkdir()) {
            return file;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t(Context context) {
        synchronized (this) {
            if (this.e > 0) {
                TbsLog.i("TbsInstaller", "getTbsInstallingFileLock success,is cached= true");
                this.e++;
                return true;
            }
            FileOutputStream b2 = FileUtil.b(context, true, "tbslock.txt");
            this.g = b2;
            if (b2 == null) {
                TbsLog.i("TbsInstaller", "getTbsInstallingFileLock get install fos failed");
                return false;
            }
            FileLock a2 = FileUtil.a(context, b2);
            this.f = a2;
            if (a2 == null) {
                TbsLog.i("TbsInstaller", "getTbsInstallingFileLock tbsFileLockFileLock == null");
                return false;
            }
            TbsLog.i("TbsInstaller", "getTbsInstallingFileLock success,is cached= false");
            this.e++;
            return true;
        }
    }
}
