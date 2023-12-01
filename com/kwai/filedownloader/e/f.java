package com.kwai.filedownloader.e;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.kwad.sdk.utils.ap;
import com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/e/f.class */
public class f {
    private static long aJA = 2000;
    private static String aJB;
    private static Boolean aJC;
    private static Boolean aJD;
    private static final Pattern aJE = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
    private static int aJz = 65536;

    private static int Jd() {
        return aJz;
    }

    private static long Je() {
        return aJA;
    }

    private static String Jf() {
        if (TextUtils.isEmpty(aJB)) {
            return (c.IZ().getExternalCacheDir() == null ? Environment.getDownloadCacheDirectory() : c.IZ().getExternalCacheDir()).getAbsolutePath();
        }
        return aJB;
    }

    public static boolean Jg() {
        ConnectivityManager connectivityManager = (ConnectivityManager) c.IZ().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) {
            d.h(f.class, "failed to get connectivity manager!", new Object[0]);
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo == null || activeNetworkInfo.getType() != 1;
    }

    public static String Jh() {
        return j("FileDownloader/%s", "3.3.40");
    }

    public static String a(int i, com.kwai.filedownloader.kwai.b bVar) {
        if (bVar != null) {
            String o = bVar.o(DownloadUtils.ETAG);
            if (d.aJq) {
                d.g(f.class, "etag find %s for task(%d)", o, Integer.valueOf(i));
            }
            return o;
        }
        throw new RuntimeException("connection is null when findEtag");
    }

    public static String a(com.kwai.filedownloader.kwai.b bVar, String str) {
        String fC = fC(bVar.o("Content-Disposition"));
        String str2 = fC;
        if (TextUtils.isEmpty(fC)) {
            str2 = fA(str);
        }
        return str2.replaceAll("\\/", BridgeUtil.UNDERLINE_STR);
    }

    public static String a(String str, boolean z, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str;
        if (z) {
            if (str2 == null) {
                return null;
            }
            str3 = ap(str, str2);
        }
        return str3;
    }

    private static boolean a(int i, com.kwai.filedownloader.c.c cVar, Boolean bool) {
        if (cVar == null) {
            if (d.aJq) {
                d.g(f.class, "can't continue %d model == null", Integer.valueOf(i));
                return false;
            }
            return false;
        } else if (cVar.HT() == null) {
            if (d.aJq) {
                d.g(f.class, "can't continue %d temp path == null", Integer.valueOf(i));
                return false;
            }
            return false;
        } else {
            return a(i, cVar, cVar.HT(), null);
        }
    }

    public static boolean a(int i, com.kwai.filedownloader.c.c cVar, String str, Boolean bool) {
        if (str == null) {
            if (d.aJq) {
                d.g(f.class, "can't continue %d path = null", Integer.valueOf(i));
                return false;
            }
            return false;
        }
        File file = new File(str);
        boolean exists = file.exists();
        boolean isDirectory = file.isDirectory();
        if (!exists || isDirectory) {
            if (d.aJq) {
                d.g(f.class, "can't continue %d file not suit, exists[%B], directory[%B]", Integer.valueOf(i), Boolean.valueOf(exists), Boolean.valueOf(isDirectory));
                return false;
            }
            return false;
        }
        long length = file.length();
        long IB = cVar.IB();
        if (cVar.ID() <= 1 && IB == 0) {
            if (d.aJq) {
                d.g(f.class, "can't continue %d the downloaded-record is zero.", Integer.valueOf(i));
                return false;
            }
            return false;
        }
        long total = cVar.getTotal();
        if (length < IB || (total != -1 && (length > total || IB >= total))) {
            if (d.aJq) {
                d.g(f.class, "can't continue %d dirty data fileLength[%d] sofar[%d] total[%d]", Integer.valueOf(i), Long.valueOf(length), Long.valueOf(IB), Long.valueOf(total));
                return false;
            }
            return false;
        } else if (bool == null || bool.booleanValue() || total != length) {
            return true;
        } else {
            if (d.aJq) {
                d.g(f.class, "can't continue %d, because of the output stream doesn't support seek, but the task has already pre-allocated, so we only can download it from the very beginning.", Integer.valueOf(i));
                return false;
            }
            return false;
        }
    }

    private static String ap(String str, String str2) {
        if (str2 != null) {
            if (str != null) {
                return j("%s%s%s", str, File.separator, str2);
            }
            throw new IllegalStateException("can't generate real path, the directory is null");
        }
        throw new IllegalStateException("can't generate real path, the file name is null");
    }

    public static int aq(String str, String str2) {
        return com.kwai.filedownloader.download.b.HF().HG().k(str, str2, false);
    }

    public static void ar(long j) {
        if (!du(c.IZ())) {
            throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-time'.");
        }
        aJA = j;
    }

    public static void ar(String str, String str2) {
        fI(str2);
        fJ(str);
    }

    public static long b(int i, com.kwai.filedownloader.kwai.b bVar) {
        long fG = fG(bVar.o("Content-Length"));
        String o = bVar.o("Transfer-Encoding");
        long j = fG;
        if (fG < 0) {
            if (!(o != null && o.equals(DownloadUtils.VALUE_CHUNKED))) {
                if (!e.Jb().aJt) {
                    throw new FileDownloadGiveUpRetryException("can't know the size of the download file, and its Transfer-Encoding is not Chunked either.\nyou can ignore such exception by add http.lenient=true to the filedownloader.properties");
                }
                if (d.aJq) {
                    d.g(f.class, "%d response header is not legal but HTTP lenient is true, so handle as the case of transfer encoding chunk", Integer.valueOf(i));
                }
            }
            j = -1;
        }
        return j;
    }

    public static boolean b(int i, com.kwai.filedownloader.c.c cVar) {
        return a(i, cVar, (Boolean) null);
    }

    public static void dk(int i) {
        if (!du(c.IZ())) {
            throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-step'.");
        }
        aJz = i;
    }

    public static boolean du(Context context) {
        boolean endsWith;
        Boolean bool = aJC;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (e.Jb().aJu) {
            endsWith = true;
        } else if (((ActivityManager) context.getSystemService("activity")) == null) {
            d.h(f.class, "fail to get the activity manager!", new Object[0]);
            return false;
        } else {
            endsWith = ap.getProcessName(context).endsWith(":filedownloader");
        }
        Boolean valueOf = Boolean.valueOf(endsWith);
        aJC = valueOf;
        return valueOf.booleanValue();
    }

    public static void dv(Context context) {
        File dw = dw(context);
        try {
            dw.getParentFile().mkdirs();
            dw.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static File dw(Context context) {
        return new File(context.getFilesDir().getAbsolutePath() + File.separator + "filedownloader", ".old_file_converted");
    }

    public static String eC(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            int length = digest.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return sb.toString();
                }
                int i3 = digest[i2] & 255;
                if (i3 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i3));
                i = i2 + 1;
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException("Huh, MD5 should be supported?", e2);
        }
    }

    private static String fA(String str) {
        return eC(str);
    }

    public static String fB(String str) {
        return j("%s.temp", str);
    }

    public static String fC(String str) {
        if (str == null) {
            return null;
        }
        try {
            Matcher matcher = aJE.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
            return null;
        } catch (IllegalStateException e) {
            return null;
        }
    }

    public static String fD(String str) {
        int length = str.length();
        int i = 2;
        int i2 = (File.separatorChar == '\\' && length > 2 && str.charAt(1) == ':') ? 2 : 0;
        int lastIndexOf = str.lastIndexOf(File.separatorChar);
        if (lastIndexOf != -1 || i2 <= 0) {
            i = lastIndexOf;
        }
        if (i == -1 || str.charAt(length - 1) == File.separatorChar) {
            return null;
        }
        return (str.indexOf(File.separatorChar) == i && str.charAt(i2) == File.separatorChar) ? str.substring(0, i + 1) : str.substring(0, i);
    }

    public static String fE(String str) {
        return "FileDownloader-" + str;
    }

    public static boolean fF(String str) {
        return c.IZ().checkCallingOrSelfPermission(str) == 0;
    }

    private static long fG(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            return -1L;
        }
    }

    public static com.kwai.filedownloader.d.a fH(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("found invalid internal destination path, empty");
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            file.delete();
            if (!file.createNewFile()) {
                throw new RuntimeException(j("found invalid internal destination path[%s], & path is directory[%B]", str, Boolean.valueOf(file.isDirectory())));
            }
        }
        if (file.exists() || file.createNewFile()) {
            return com.kwai.filedownloader.download.b.HF().ab(file);
        }
        throw new IOException(j("create new file error  %s", file.getAbsolutePath()));
    }

    private static void fI(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static void fJ(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static String fz(String str) {
        return ap(Jf(), fA(str));
    }

    public static boolean h(long j, long j2) {
        return j > ((long) Jd()) && j2 > Je();
    }

    public static String j(String str, Object... objArr) {
        return String.format(Locale.ENGLISH, str, objArr);
    }

    public static int k(String str, String str2, boolean z) {
        return com.kwai.filedownloader.download.b.HF().HG().k(str, str2, z);
    }
}
