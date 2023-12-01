package com.opos.mobad;

import android.content.Context;
import android.os.Build;
import com.opos.mobad.e.a.n;
import com.opos.mobad.n.b;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/d.class */
final class d {

    /* renamed from: a  reason: collision with root package name */
    private Context f25938a;

    private void a(final Context context) {
        String str = Build.BRAND != null ? Build.BRAND : "";
        com.opos.cmn.an.b.a.a(context, str);
        com.opos.mobad.cmn.service.pkginstall.c.a().a(context);
        com.opos.mobad.d.d.a().a(context);
        com.opos.mobad.cmn.service.b.a.a().a(context, str, com.opos.cmn.a.a.b());
        com.opos.mobad.o.e.b.a().a(new com.opos.mobad.n.b() { // from class: com.opos.mobad.d.1
            @Override // com.opos.mobad.n.b
            public void a(String str2) {
                com.opos.mobad.cmn.service.b.a.a().a(str2);
            }

            @Override // com.opos.mobad.n.b
            public void a(String str2, final b.a aVar) {
                File a2 = com.opos.mobad.cmn.service.b.a.a().a(context, str2);
                if (a2 != null) {
                    n.a(str2, a2.getAbsolutePath(), new com.opos.mobad.e.a.h() { // from class: com.opos.mobad.d.1.1
                        @Override // com.opos.mobad.e.a.h
                        public void a(boolean z, String str3) {
                            b.a aVar2 = aVar;
                            if (aVar2 != null) {
                                aVar2.a(z, str3);
                            }
                        }
                    });
                } else if (aVar != null) {
                    aVar.a(false, "");
                }
            }
        });
    }

    private void a(File file, long j, int i) {
        String str;
        File[] listFiles;
        StringBuilder sb;
        String str2;
        if (file.exists() && file.isDirectory()) {
            long e = com.opos.cmn.an.d.b.a.e(file.getAbsolutePath());
            int b = com.opos.mobad.cmn.a.b.f.b(file.getAbsolutePath());
            if (e >= j || b >= i) {
                com.opos.cmn.an.f.a.b("InterMobAdManager", "video cache size over max size or over max count,start clear video cache.");
                if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
                    return;
                }
                Arrays.sort(listFiles, new Comparator<File>() { // from class: com.opos.mobad.d.4
                    @Override // java.util.Comparator
                    /* renamed from: a */
                    public int compare(File file2, File file3) {
                        int i2 = ((file2.lastModified() - file3.lastModified()) > 0L ? 1 : ((file2.lastModified() - file3.lastModified()) == 0L ? 0 : -1));
                        if (i2 > 0) {
                            return 1;
                        }
                        return i2 == 0 ? 0 : -1;
                    }

                    @Override // java.util.Comparator
                    public boolean equals(Object obj) {
                        return true;
                    }
                });
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= listFiles.length / 2) {
                        return;
                    }
                    File file2 = listFiles[i3];
                    if (file2 != null && file2.exists() && file2.isFile()) {
                        com.opos.cmn.an.f.a.b("InterMobAdManager", "file.lastModified()=" + file2.lastModified() + ",System.currentTimeMillis()=" + com.opos.cmn.b.a.a.b());
                        if (file2.delete()) {
                            sb = new StringBuilder();
                            sb.append("file.lastModified()=");
                            sb.append(file2.lastModified());
                            sb.append(",System.currentTimeMillis()=");
                            sb.append(com.opos.cmn.b.a.a.b());
                            str2 = ",need delete file=";
                        } else {
                            sb = new StringBuilder();
                            sb.append("file.lastModified()=");
                            sb.append(file2.lastModified());
                            sb.append(",System.currentTimeMillis()=");
                            sb.append(com.opos.cmn.b.a.a.b());
                            str2 = ",don't need delete file=";
                        }
                        sb.append(str2);
                        sb.append(file2.getName());
                        com.opos.cmn.an.f.a.b("InterMobAdManager", sb.toString());
                    }
                    i2 = i3 + 1;
                }
            } else {
                str = "video cache size not over max size or over max count,don't need clear video cache.";
            }
        } else {
            str = "folder not exist";
        }
        com.opos.cmn.an.f.a.b("InterMobAdManager", str);
    }

    private void b(Context context) {
        Context applicationContext = context.getApplicationContext();
        com.opos.cmn.an.e.c.a().b();
        com.opos.mobad.cmn.service.pkginstall.b.a(applicationContext).a();
        com.opos.mobad.cmn.service.pkginstall.c.a().b(applicationContext);
        com.opos.mobad.cmn.service.a.a.a(applicationContext).a();
    }

    private void c() {
        com.opos.cmn.an.j.b.a(new Runnable() { // from class: com.opos.mobad.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.d();
                d.this.e();
                d.this.f();
                d.this.g();
                d.this.h();
            }
        });
    }

    private void c(final Context context) {
        com.opos.cmn.an.j.b.a(new Runnable() { // from class: com.opos.mobad.d.2
            @Override // java.lang.Runnable
            public void run() {
                File[] listFiles;
                String str;
                try {
                    File file = new File(com.opos.cmn.d.c.b(context));
                    if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
                        return;
                    }
                    int length = listFiles.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            return;
                        }
                        File file2 = listFiles[i2];
                        if (file2 != null) {
                            if (file2.exists() && file2.isFile()) {
                                com.opos.cmn.an.f.a.b("InterMobAdManager", "file.lastModified()=" + file2.lastModified() + ",System.currentTimeMillis()=" + com.opos.cmn.b.a.a.b());
                                if (file2.lastModified() + 432000000 >= System.currentTimeMillis() || !file2.delete()) {
                                    str = "file.lastModified()=" + file2.lastModified() + ",System.currentTimeMillis()=" + com.opos.cmn.b.a.a.b() + ",don't need delete file=" + file2.getName();
                                } else {
                                    str = "file.lastModified()=" + file2.lastModified() + ",System.currentTimeMillis()=" + com.opos.cmn.b.a.a.b() + ",need delete file=" + file2.getName();
                                }
                                com.opos.cmn.an.f.a.b("InterMobAdManager", str);
                            }
                        }
                        i = i2 + 1;
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("InterMobAdManager", "", (Throwable) e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        com.opos.cmn.an.f.a.b("InterMobAdManager", "clearPublicVideoCache");
        try {
            if (com.opos.cmn.d.d.a(this.f25938a)) {
                a(new File(com.opos.cmn.d.d.a()), 1073741824L, 50);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("InterMobAdManager", "", (Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.opos.cmn.an.f.a.b("InterMobAdManager", "clearPrivateVideoCache");
        try {
            a(new File(com.opos.cmn.d.d.b(this.f25938a)), 536870912L, 25);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("InterMobAdManager", "", (Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.opos.cmn.an.f.a.b("InterMobAdManager", "clearPublicDownloadApkCache");
        try {
            if (com.opos.cmn.d.a.a(this.f25938a)) {
                a(new File(com.opos.cmn.d.a.a()), 1073741824L, 50);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("InterMobAdManager", "", (Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.opos.cmn.an.f.a.b("InterMobAdManager", "clearPrivateDownloadApkCache");
        try {
            a(new File(com.opos.cmn.d.a.c(this.f25938a)), 536870912L, 25);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("InterMobAdManager", "", (Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        com.opos.cmn.an.f.a.b("InterMobAdManager", "clearDynamicUnzipDir");
        try {
            com.opos.mobad.service.c.b.a().b(this.f25938a);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("InterMobAdManager", "", (Throwable) e);
        }
    }

    public void a() {
        if (com.opos.mobad.cmn.a.b.f.d()) {
            try {
                if (!com.opos.mobad.cmn.a.b.f.c() || this.f25938a == null) {
                    return;
                }
                b(this.f25938a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("InterMobAdManager", "", (Throwable) e);
            }
        }
    }

    public void a(Context context, String str) {
        try {
            this.f25938a = context.getApplicationContext();
            com.opos.mobad.cmn.a.b.f.a(str);
            com.opos.cmn.an.f.a.b("InterMobAdManager", "init sdk success.");
            a(this.f25938a);
            com.opos.mobad.cmn.a.b.f.b();
            c(this.f25938a);
            c();
            b();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("InterMobAdManager", "init", e);
        }
    }

    public void b() {
        com.opos.cmn.an.j.b.a(new Runnable() { // from class: com.opos.mobad.d.5
            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.an.f.a.b("InterMobAdManager", "startClearRewardSP");
                Map<String, Long> b = com.opos.mobad.cmn.a.b.f.b(d.this.f25938a);
                if (b == null || b.size() <= 0) {
                    return;
                }
                for (Map.Entry<String, Long> entry : b.entrySet()) {
                    if (entry.getValue().longValue() + 259200000 < com.opos.cmn.b.a.a.c()) {
                        com.opos.cmn.an.f.a.b("InterMobAdManager", "remove pkgName=" + entry.getKey() + ",timestamp=" + entry.getValue());
                        com.opos.mobad.cmn.a.b.f.e(d.this.f25938a, entry.getKey());
                    }
                }
            }
        });
    }
}
