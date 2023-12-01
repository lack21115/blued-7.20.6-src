package com.tencent.tinker.lib.patch;

import com.tencent.tinker.commons.util.IOHelper;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/lib/patch/BasePatchInternal.class */
public class BasePatchInternal {
    protected static final String ARKHOT_META_FILE = "assets/arkHot_meta.txt";
    protected static final String DEX_META_FILE = "assets/dex_meta.txt";
    protected static final String DEX_OPTIMIZE_PATH = "odex";
    protected static final String DEX_PATH = "dex";
    protected static final int MAX_EXTRACT_ATTEMPTS = 2;
    protected static final String RES_META_FILE = "assets/res_meta.txt";
    protected static final String SO_META_FILE = "assets/so_meta.txt";
    protected static final String SO_PATH = "lib";
    protected static final String TAG = "Tinker.BasePatchInternal";
    protected static final int TYPE_ARKHOT_SO = 8;
    protected static final int TYPE_CLASS_N_DEX = 7;
    protected static final int TYPE_DEX = 3;
    protected static final int TYPE_LIBRARY = 5;
    protected static final int TYPE_RESOURCE = 6;

    public static boolean extract(ZipFile zipFile, ZipEntry zipEntry, File file, String str, boolean z) throws IOException {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream2;
        BufferedOutputStream bufferedOutputStream2;
        int i = 0;
        boolean z2 = false;
        while (i < 2 && !z2) {
            i++;
            ShareTinkerLog.i(TAG, "try Extracting " + file.getPath(), new Object[0]);
            try {
                bufferedInputStream2 = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                try {
                    bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = null;
                    bufferedInputStream = bufferedInputStream2;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = null;
                bufferedOutputStream = null;
            }
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = bufferedInputStream2.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    bufferedOutputStream2.write(bArr, 0, read);
                }
                IOHelper.closeQuietly(bufferedOutputStream2);
                IOHelper.closeQuietly(bufferedInputStream2);
                z2 = str != null ? z ? SharePatchFileUtil.verifyDexFileMd5(file, str) : SharePatchFileUtil.verifyFileMd5(file, str) : true;
                ShareTinkerLog.i(TAG, "isExtractionSuccessful: %b", Boolean.valueOf(z2));
                if (!z2 && (!file.delete() || file.exists())) {
                    ShareTinkerLog.e(TAG, "Failed to delete corrupted dex " + file.getPath(), new Object[0]);
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = bufferedOutputStream2;
                bufferedInputStream = bufferedInputStream2;
                IOHelper.closeQuietly(bufferedOutputStream);
                IOHelper.closeQuietly(bufferedInputStream);
                throw th;
            }
        }
        return z2;
    }

    public static int getMetaCorruptedCode(int i) {
        if (i == 3) {
            return -3;
        }
        if (i == 5) {
            return -4;
        }
        return i == 6 ? -8 : 0;
    }
}
