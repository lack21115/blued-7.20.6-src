package com.youzan.spiderman.cache;

import android.content.Context;
import com.youzan.spiderman.utils.FileCallback;
import com.youzan.spiderman.utils.Logger;
import com.youzan.spiderman.utils.OkHttpUtil;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/cache/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f28104a;
    private Set<String> b;

    /* renamed from: c  reason: collision with root package name */
    private String f28105c;
    private String d;
    private String e;

    private a() {
        this.b = null;
        this.f28105c = null;
        this.d = null;
        this.e = null;
        this.b = new HashSet();
        this.f28105c = g.c();
        this.d = g.f();
        this.e = g.g();
        File file = new File(this.f28105c);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(this.d);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        File file3 = new File(this.e);
        if (file3.exists()) {
            return;
        }
        file3.mkdirs();
    }

    public static a a() {
        if (f28104a == null) {
            f28104a = new a();
        }
        return f28104a;
    }

    public final void a(Context context, final CacheUrl cacheUrl, final FileCallback fileCallback) {
        File file = new File(this.f28105c);
        if (!(file.exists() || file.mkdirs())) {
            Logger.e("CacheDownLoader", "downloading dir not exists and make dir failed", new Object[0]);
            return;
        }
        final String md5 = cacheUrl.getMd5();
        if (this.b.contains(md5)) {
            if (fileCallback != null) {
                fileCallback.fail(-1, null);
                return;
            }
            return;
        }
        this.b.add(md5);
        final File file2 = new File(this.f28105c, md5);
        OkHttpUtil.downloadFile(context, cacheUrl.getUri().toString(), file2, new FileCallback() { // from class: com.youzan.spiderman.cache.a.1
            @Override // com.youzan.spiderman.utils.FileCallback
            public final void fail(int i, Exception exc) {
                Logger.e("CacheDownLoader", "download file failed, url:" + cacheUrl.getUri().toString(), new Object[0]);
                a.this.b.remove(md5);
                FileCallback fileCallback2 = fileCallback;
                if (fileCallback2 != null) {
                    fileCallback2.fail(i, exc);
                }
            }

            @Override // com.youzan.spiderman.utils.FileCallback
            public final void success() {
                File file3 = cacheUrl.isScript() ? new File(a.this.d, md5) : new File(a.this.e, md5);
                boolean renameTo = file2.renameTo(file3);
                a.this.b.remove(md5);
                if (renameTo) {
                    com.youzan.spiderman.b.f.a().a(cacheUrl, file3);
                    FileCallback fileCallback2 = fileCallback;
                    if (fileCallback2 != null) {
                        fileCallback2.success();
                        return;
                    }
                    return;
                }
                Logger.e("CacheDownLoader", "rename file failed, src file:" + file2 + " dest file:" + file3, new Object[0]);
                FileCallback fileCallback3 = fileCallback;
                if (fileCallback3 != null) {
                    fileCallback3.fail(-1, null);
                }
            }
        });
    }
}
