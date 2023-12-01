package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.tencent.smtt.export.external.DexLoader;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/TbsVideoCacheTask.class */
public class TbsVideoCacheTask {
    public static final String KEY_VIDEO_CACHE_PARAM_FILENAME = "filename";
    public static final String KEY_VIDEO_CACHE_PARAM_FOLDERPATH = "folderPath";
    public static final String KEY_VIDEO_CACHE_PARAM_HEADER = "header";
    public static final String KEY_VIDEO_CACHE_PARAM_URL = "url";

    /* renamed from: a  reason: collision with root package name */
    Context f25100a;
    TbsVideoCacheListener b;
    private String e;
    private String f;

    /* renamed from: c  reason: collision with root package name */
    private boolean f25101c = false;
    private q d = null;
    private Object g = null;

    public TbsVideoCacheTask(Context context, Bundle bundle, TbsVideoCacheListener tbsVideoCacheListener) {
        this.f25100a = null;
        this.b = null;
        this.f25100a = context;
        this.b = tbsVideoCacheListener;
        if (bundle != null) {
            this.e = bundle.getString(DBDefinition.TASK_ID);
            this.f = bundle.getString("url");
        }
        a(bundle);
    }

    private void a(Bundle bundle) {
        TbsVideoCacheListener tbsVideoCacheListener;
        String str;
        DexLoader dexLoader;
        if (this.d == null) {
            f.a(true).a(this.f25100a, false, false);
            u a2 = f.a(true).a();
            if (a2 != null) {
                dexLoader = a2.b();
            } else {
                this.b.onVideoDownloadError(this, -1, "init engine error!", null);
                dexLoader = null;
            }
            if (dexLoader != null) {
                this.d = new q(dexLoader);
            } else {
                this.b.onVideoDownloadError(this, -1, "Java dexloader invalid!", null);
            }
        }
        q qVar = this.d;
        if (qVar != null) {
            Object a3 = qVar.a(this.f25100a, this, bundle);
            this.g = a3;
            if (a3 != null) {
                return;
            }
            tbsVideoCacheListener = this.b;
            str = "init task error!";
        } else {
            tbsVideoCacheListener = this.b;
            if (tbsVideoCacheListener == null) {
                return;
            }
            str = "init error!";
        }
        tbsVideoCacheListener.onVideoDownloadError(this, -1, str, null);
    }

    public long getContentLength() {
        q qVar = this.d;
        if (qVar == null || this.g == null) {
            TbsVideoCacheListener tbsVideoCacheListener = this.b;
            if (tbsVideoCacheListener != null) {
                tbsVideoCacheListener.onVideoDownloadError(this, -1, "getContentLength failed, init uncompleted!", null);
                return 0L;
            }
            return 0L;
        }
        return qVar.d();
    }

    public int getDownloadedSize() {
        q qVar = this.d;
        if (qVar == null || this.g == null) {
            TbsVideoCacheListener tbsVideoCacheListener = this.b;
            if (tbsVideoCacheListener != null) {
                tbsVideoCacheListener.onVideoDownloadError(this, -1, "getDownloadedSize failed, init uncompleted!", null);
                return 0;
            }
            return 0;
        }
        return qVar.e();
    }

    public int getProgress() {
        q qVar = this.d;
        if (qVar == null || this.g == null) {
            TbsVideoCacheListener tbsVideoCacheListener = this.b;
            if (tbsVideoCacheListener != null) {
                tbsVideoCacheListener.onVideoDownloadError(this, -1, "getProgress failed, init uncompleted!", null);
                return 0;
            }
            return 0;
        }
        return qVar.f();
    }

    public String getTaskID() {
        return this.e;
    }

    public String getTaskUrl() {
        return this.f;
    }

    public void pauseTask() {
        q qVar = this.d;
        if (qVar != null && this.g != null) {
            qVar.a();
            return;
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.b;
        if (tbsVideoCacheListener != null) {
            tbsVideoCacheListener.onVideoDownloadError(this, -1, "pauseTask failed, init uncompleted!", null);
        }
    }

    public void removeTask(boolean z) {
        q qVar = this.d;
        if (qVar != null && this.g != null) {
            qVar.a(z);
            return;
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.b;
        if (tbsVideoCacheListener != null) {
            tbsVideoCacheListener.onVideoDownloadError(this, -1, "removeTask failed, init uncompleted!", null);
        }
    }

    public void resumeTask() {
        q qVar = this.d;
        if (qVar != null && this.g != null) {
            qVar.b();
            return;
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.b;
        if (tbsVideoCacheListener != null) {
            tbsVideoCacheListener.onVideoDownloadError(this, -1, "resumeTask failed, init uncompleted!", null);
        }
    }

    public void stopTask() {
        q qVar = this.d;
        if (qVar != null && this.g != null) {
            qVar.c();
            return;
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.b;
        if (tbsVideoCacheListener != null) {
            tbsVideoCacheListener.onVideoDownloadError(this, -1, "stopTask failed, init uncompleted!", null);
        }
    }
}
