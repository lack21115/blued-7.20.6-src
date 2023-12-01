package com.anythink.core.common.res;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.i;
import com.anythink.core.common.k.j;
import com.anythink.core.common.res.a;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/res/d.class */
public class d {
    public static final String a = "about:blank";
    private static final String d = "anythink_internal_resouce";
    private static final String e = "anythink_custom_resouce";
    private static final String f = "anythink_internal_extra_resource";
    private static final String g = "anythink_internal_video_resource";
    private static final String h = "anythink_internal_html_resouce";
    private static volatile d i;
    private Context j;
    private File k;
    private final String c = getClass().getSimpleName();
    ConcurrentHashMap<Integer, a> b = new ConcurrentHashMap<>();

    private d(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.j = applicationContext;
        this.k = j.a(applicationContext);
    }

    private a a(int i2, File file) {
        a aVar;
        synchronized (this) {
            a aVar2 = this.b.get(Integer.valueOf(i2));
            aVar = aVar2;
            if (aVar2 == null) {
                aVar = a.a(file, n.a().d(i2));
                this.b.put(Integer.valueOf(i2), aVar);
            }
        }
        return aVar;
    }

    public static d a(Context context) {
        if (i == null) {
            synchronized (d.class) {
                try {
                    if (i == null) {
                        i = new d(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return i;
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(a(1) + File.separator + str + ".0").exists();
    }

    public final FileInputStream a(int i2, String str) {
        InputStream a2;
        if (i2 == 4) {
            try {
                return new FileInputStream(new File(b(4, str)));
            } catch (Throwable th) {
                return null;
            }
        }
        String a3 = a(i2);
        if (TextUtils.isEmpty(a3)) {
            return null;
        }
        File file = new File(a3);
        if (!file.exists()) {
            file.mkdirs();
        }
        a a4 = a(i2, file);
        if (a4 != null) {
            try {
                a.c a5 = a4.a(str);
                if (a5 == null || (a2 = a5.a()) == null) {
                    return null;
                }
                return (FileInputStream) a2;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public final String a() {
        return this.k.getAbsolutePath();
    }

    public final String a(int i2) {
        return new File(this.k, i2 != 1 ? i2 != 3 ? i2 != 4 ? e : g : f : d).getAbsolutePath();
    }

    public final String a(String str, com.anythink.core.common.e.j jVar, i iVar) {
        FileOutputStream fileOutputStream;
        byte[] bytes;
        File file = new File(this.k, h);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, jVar.d + BridgeUtil.UNDERLINE_STR + iVar.p() + ".html");
        try {
            bytes = str.getBytes("utf-8");
            fileOutputStream = new FileOutputStream(file2);
        } catch (Throwable th) {
            fileOutputStream = null;
        }
        try {
            fileOutputStream.write(bytes, 0, bytes.length);
            String url = file2.toURL().toString();
            try {
                fileOutputStream.close();
                return url;
            } catch (Throwable th2) {
                return url;
            }
        } catch (Throwable th3) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                    return "";
                } catch (Throwable th4) {
                    return "";
                }
            }
            return "";
        }
    }

    public final void a(com.anythink.core.common.e.j jVar, i iVar) {
        try {
            File file = new File(new File(this.k, h), jVar.d + BridgeUtil.UNDERLINE_STR + iVar.p() + ".html");
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable th) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0152 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(int r6, java.lang.String r7, java.io.InputStream r8) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.res.d.a(int, java.lang.String, java.io.InputStream):boolean");
    }

    public final File b(com.anythink.core.common.e.j jVar, i iVar) {
        File file = new File(new File(this.k, h), jVar.d + BridgeUtil.UNDERLINE_STR + iVar.p() + ".html");
        if (file.exists()) {
            return file;
        }
        return null;
    }

    public final String b(int i2, String str) {
        if (i2 == 4) {
            return a(i2) + File.separator + str;
        }
        return a(i2) + File.separator + str + ".0";
    }

    public final void b() {
        File[] listFiles;
        try {
            File file = new File(this.k, h);
            if (!file.exists() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
                return;
            }
            int length = listFiles.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return;
                }
                File file2 = listFiles[i3];
                try {
                    if (file2.isFile() && System.currentTimeMillis() - file2.lastModified() > 86400000) {
                        file2.delete();
                    }
                } catch (Throwable th) {
                }
                i2 = i3 + 1;
            }
        } catch (Throwable th2) {
        }
    }
}
