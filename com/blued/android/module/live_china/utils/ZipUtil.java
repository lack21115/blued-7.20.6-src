package com.blued.android.module.live_china.utils;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.live.base.utils.LiveTimeAndDateUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/ZipUtil.class */
public final class ZipUtil {
    public static final Companion a = new Companion(null);
    private static final Lazy<ZipUtil> b = LazyKt.a(new Function0<ZipUtil>() { // from class: com.blued.android.module.live_china.utils.ZipUtil$Companion$instance$2
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final ZipUtil invoke() {
            return new ZipUtil();
        }
    });

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/ZipUtil$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZipUtil a() {
            return (ZipUtil) ZipUtil.b.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ZipUtil this$0, String str, String log) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(log, "$log");
        String a2 = this$0.a();
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(a2, str);
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (file.length() > 102400) {
                    try {
                        if (file.delete()) {
                            file.createNewFile();
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                String str2 = "\r\n\"" + ((Object) LiveTimeAndDateUtils.c(System.currentTimeMillis())) + " ::::: " + log;
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
                try {
                    byte[] bytes = str2.getBytes(Charsets.b);
                    Intrinsics.c(bytes, "this as java.lang.String).getBytes(charset)");
                    fileOutputStream2.write(bytes);
                    fileOutputStream2.close();
                } catch (Exception e3) {
                    fileOutputStream = fileOutputStream2;
                    e = e3;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    private final void a(File file, ZipOutputStream zipOutputStream, String str) throws Exception {
        byte[] bArr = new byte[2048];
        int i = 0;
        if (!file.isFile()) {
            File[] listFiles = file.listFiles();
            Intrinsics.c(listFiles, "sourceFile.listFiles()");
            if (listFiles.length == 0) {
                zipOutputStream.putNextEntry(new ZipEntry(Intrinsics.a(str, (Object) BridgeUtil.SPLIT_MARK)));
                zipOutputStream.closeEntry();
                return;
            }
            int length = listFiles.length;
            while (i < length) {
                File file2 = listFiles[i];
                i++;
                a(file2, zipOutputStream, str + '/' + ((Object) file2.getName()));
            }
            return;
        }
        zipOutputStream.putNextEntry(new ZipEntry(str));
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read == -1) {
                zipOutputStream.closeEntry();
                fileInputStream.close();
                return;
            }
            zipOutputStream.write(bArr, 0, read);
        }
    }

    public final String a() {
        File file = new File(AppInfo.d().getExternalFilesDir(null), "live_log");
        try {
            if (!file.exists()) {
                file.mkdirs();
            }
            String absolutePath = file.getAbsolutePath();
            Intrinsics.c(absolutePath, "filePath.absolutePath");
            return absolutePath;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public final void a(String log) {
        Intrinsics.e(log, "log");
        b(log, "live_log.txt");
    }

    public final void a(String srcFileString, String zipFileString) {
        FileOutputStream fileOutputStream;
        ZipOutputStream zipOutputStream;
        ZipOutputStream zipOutputStream2;
        Intrinsics.e(srcFileString, "srcFileString");
        Intrinsics.e(zipFileString, "zipFileString");
        try {
            fileOutputStream = new FileOutputStream(new File(zipFileString));
            try {
                zipOutputStream2 = new ZipOutputStream(fileOutputStream);
            } catch (Exception e) {
                zipOutputStream = null;
            }
        } catch (Exception e2) {
            fileOutputStream = null;
            zipOutputStream = null;
        }
        try {
            File file = new File(srcFileString);
            String name = file.getName();
            Intrinsics.c(name, "f.getName()");
            a(file, zipOutputStream2, name);
            zipOutputStream2.flush();
            zipOutputStream2.close();
            fileOutputStream.close();
        } catch (Exception e3) {
            zipOutputStream = zipOutputStream2;
            if (zipOutputStream != null) {
                try {
                    zipOutputStream.close();
                } catch (IOException e4) {
                    return;
                }
            }
            if (fileOutputStream == null) {
                return;
            }
            fileOutputStream.close();
        }
    }

    public final void b(final String log, final String str) {
        Intrinsics.e(log, "log");
        ThreadManager.a().b(new Runnable() { // from class: com.blued.android.module.live_china.utils.-$$Lambda$ZipUtil$L7UG-xdSYj7iecBHxKj-XKXQ93M
            @Override // java.lang.Runnable
            public final void run() {
                ZipUtil.a(ZipUtil.this, str, log);
            }
        });
    }
}
