package com.opos.cmn.biz.web.a.a;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import android.webkit.WebResourceResponse;
import com.opos.cmn.an.g.f;
import com.opos.cmn.func.a.a;
import com.opos.cmn.func.a.c;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/web/a/a/b.class */
public class b implements a {
    private static String e = "";

    /* renamed from: a  reason: collision with root package name */
    private Context f11021a;
    private volatile boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private com.opos.cmn.biz.web.a.b.b f11022c;
    private ThreadPoolExecutor d;

    public static List<File> a(Context context) {
        File[] listFiles;
        ArrayList arrayList = new ArrayList();
        try {
            String b = b(context);
            if (com.opos.cmn.an.d.b.a.b(b) && (listFiles = new File(b).listFiles()) != null && listFiles.length > 0) {
                int length = listFiles.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    File file = listFiles[i2];
                    if (file != null) {
                        if (!TextUtils.isEmpty(file.getName()) && file.getName().endsWith(".adweb")) {
                            arrayList.add(file);
                        }
                    }
                    i = i2 + 1;
                }
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("WebViewCacheImpl", "", e2);
        }
        return arrayList;
    }

    private void a(final Context context, List<com.opos.cmn.biz.web.a.b.a> list) {
        com.opos.cmn.an.f.a.c("WebViewCacheImpl", "downloadResource");
        final CountDownLatch countDownLatch = new CountDownLatch(list.size());
        for (final com.opos.cmn.biz.web.a.b.a aVar : list) {
            if (aVar != null) {
                try {
                    if (!TextUtils.isEmpty(aVar.f11026a)) {
                        this.d.execute(new Runnable() { // from class: com.opos.cmn.biz.web.a.a.b.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    try {
                                        try {
                                            com.opos.cmn.func.a.b a2 = c.a(context, new a.C0465a().b(b.b(context, aVar.f11026a)).a(0).a(b.this.b(aVar.f11026a)).a(aVar.b).a());
                                            if (a2 == null || !a2.f11119a) {
                                                com.opos.cmn.an.f.a.b("WebViewCacheImpl", "download resource failed, url:" + aVar);
                                            } else {
                                                com.opos.cmn.an.f.a.b("WebViewCacheImpl", "download resource success:" + aVar);
                                                File file = new File(b.b(context, aVar.f11026a));
                                                if (file.exists()) {
                                                    file.setLastModified(System.currentTimeMillis());
                                                }
                                            }
                                            countDownLatch.countDown();
                                            if (countDownLatch.getCount() <= 0) {
                                                b.this.c(context);
                                            }
                                        } catch (Exception e2) {
                                            com.opos.cmn.an.f.a.c("WebViewCacheImpl", "download resource", e2);
                                            com.opos.cmn.an.f.a.b("WebViewCacheImpl", "download resource failed, url:" + aVar);
                                            countDownLatch.countDown();
                                            if (countDownLatch.getCount() <= 0) {
                                                b.this.c(context);
                                            }
                                        }
                                    } catch (Throwable th) {
                                        try {
                                            com.opos.cmn.an.f.a.b("WebViewCacheImpl", "download resource failed, url:" + aVar);
                                            countDownLatch.countDown();
                                            if (countDownLatch.getCount() <= 0) {
                                                b.this.c(context);
                                            }
                                        } catch (Exception e3) {
                                            com.opos.cmn.an.f.a.c("WebViewCacheImpl", "downloadResource", e3);
                                        }
                                        throw th;
                                    }
                                } catch (Exception e4) {
                                    com.opos.cmn.an.f.a.c("WebViewCacheImpl", "downloadResource", e4);
                                }
                            }
                        });
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b("WebViewCacheImpl", "downloadUrl url:" + aVar + " :fail", e2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f b(String str) {
        try {
            return new f.a().b(str).a("GET").a();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.d("WebViewCacheImpl", "getNetRequest fail", e2);
            return null;
        }
    }

    private static String b(Context context) {
        if (TextUtils.isEmpty(e)) {
            try {
                e = context.getExternalFilesDir("") + File.separator + ".opos_ad_webview_cache";
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.d("WebViewCacheImpl", "getMatSaveFolder fail", e2);
            }
        }
        return e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return b(context) + File.separator + com.opos.cmn.an.a.c.a(str) + ".adweb";
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.d("WebViewCacheImpl", "getMatSavePath fail", e2);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context) {
        String str;
        com.opos.cmn.an.f.a.b("WebViewCacheImpl", "tryRecycleCache");
        try {
            List<File> a2 = a(context);
            if (a2 == null || a2.size() <= 0) {
                return;
            }
            ArrayList<File> arrayList = new ArrayList();
            long j = 0;
            for (File file : a2) {
                if (file.lastModified() <= System.currentTimeMillis() - 604800000) {
                    String name = file.getName();
                    com.opos.cmn.an.f.a.b("WebViewCacheImpl", com.opos.cmn.an.d.b.a.e(file) ? "delete mat file success.file path=" + name : "delete mat file  fail.file path=" + name);
                } else {
                    arrayList.add(file);
                    j = file.length() + j;
                }
            }
            long j2 = j;
            if (j > this.f11022c.f11028a) {
                Collections.sort(arrayList, new Comparator<File>() { // from class: com.opos.cmn.biz.web.a.a.b.2
                    @Override // java.util.Comparator
                    /* renamed from: a */
                    public int compare(File file2, File file3) {
                        return file2.lastModified() - file3.lastModified() > 0 ? 1 : -1;
                    }
                });
                for (File file2 : arrayList) {
                    com.opos.cmn.an.f.a.b("WebViewCacheImpl", "noPeriodMat=" + file2.getName() + " lastModified:" + file2.lastModified());
                }
                Iterator it = arrayList.iterator();
                do {
                    j2 = j;
                    if (!it.hasNext()) {
                        break;
                    }
                    File file3 = (File) it.next();
                    String name2 = file3.getName();
                    long length = file3.length();
                    if (com.opos.cmn.an.d.b.a.e(file3)) {
                        j2 = j - length;
                        str = "delete mat file success.file path=" + name2;
                    } else {
                        str = "delete mat file  fail.file path=" + name2;
                        j2 = j;
                    }
                    com.opos.cmn.an.f.a.b("WebViewCacheImpl", str);
                    j = j2;
                } while (j2 > this.f11022c.f11028a);
            }
            com.opos.cmn.an.f.a.b("WebViewCacheImpl", "tryRecycleCache nowCachedSize:" + (((float) j2) / 1048576.0f) + "M maxCacheSize:" + (((float) this.f11022c.f11028a) / 1048576.0f) + "M");
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("WebViewCacheImpl", "tryRecycleCache", e2);
        }
    }

    @Override // com.opos.cmn.biz.web.a.a.a
    public WebResourceResponse a(String str) {
        if (!this.b) {
            com.opos.cmn.an.f.a.b("WebViewCacheImpl", "please call init first");
            return null;
        }
        try {
            File file = new File(b(this.f11021a, str));
            if (!file.exists()) {
                com.opos.cmn.an.f.a.b("WebViewCacheImpl", "loadResourceFormLocalCache cache not exits:" + str);
                return null;
            }
            WebResourceResponse webResourceResponse = new WebResourceResponse(MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str)), "", new FileInputStream(file));
            com.opos.cmn.an.f.a.b("WebViewCacheImpl", "loadResourceFormLocalCache from cache:" + str);
            return webResourceResponse;
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("WebViewCacheImpl", "loadResourceFormLocalCache url:" + str, e2);
            return null;
        }
    }

    @Override // com.opos.cmn.biz.web.a.a.a
    public void a(Context context, com.opos.cmn.biz.web.a.b.b bVar) {
        if (this.b) {
            return;
        }
        this.f11021a = context.getApplicationContext();
        this.f11022c = bVar;
        this.d = new ThreadPoolExecutor(0, this.f11022c.b, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.opos.cmn.biz.web.a.a.a.b("web_cache"), new ThreadPoolExecutor.DiscardPolicy());
        this.b = true;
    }

    @Override // com.opos.cmn.biz.web.a.a.a
    public void a(List<com.opos.cmn.biz.web.a.b.a> list) {
        if (!this.b) {
            com.opos.cmn.an.f.a.b("WebViewCacheImpl", "please call init first");
            return;
        }
        com.opos.cmn.an.f.a.c("WebViewCacheImpl", "startCacheResource");
        if (this.f11021a == null || list == null || list.size() <= 0) {
            return;
        }
        a(this.f11021a, list);
    }
}
