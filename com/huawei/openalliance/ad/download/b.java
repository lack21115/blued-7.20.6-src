package com.huawei.openalliance.ad.download;

import android.content.Context;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.download.DownloadTask;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/download/b.class */
public class b<T extends DownloadTask> {
    private static final String Z = "DownloadManager";
    protected Context Code;
    protected c<T> I;
    protected DownloadListener<T> V;

    public b(Context context) {
        this.Code = context.getApplicationContext();
    }

    public T Code(String str) {
        return this.I.Code(str);
    }

    public void Code() {
        if (this.I == null) {
            this.I = new c<>();
        }
    }

    public void Code(DownloadListener<T> downloadListener) {
        this.V = downloadListener;
    }

    public void Code(T t) {
        this.I.Code((c<T>) t);
        if (ge.Code()) {
            ge.Code(Z, "addTask, task:%s, priority:%s", t.F(), Integer.valueOf(t.C()));
        }
    }

    public boolean I(T t) {
        if (t == null) {
            return false;
        }
        boolean V = this.I.V(t);
        ge.V(Z, "removeTask, succ:" + V);
        if (V) {
            Z(t);
            return true;
        }
        return true;
    }

    public void V() {
        ge.V(Z, "cancelAllDownload");
        for (T t : this.I.Code()) {
            Z(t);
        }
        this.I.V();
    }

    public void V(T t) {
        if (t == null) {
            return;
        }
        ge.V(Z, "deleteTask, succ:%s, taskId:%s", Boolean.valueOf(this.I.V(t)), t.F());
    }

    protected void Z(T t) {
        if (t == null) {
            return;
        }
        if (ge.Code()) {
            ge.Code(Z, "onDownloadDeleted, taskId:%s", t.F());
        }
        DownloadListener<T> downloadListener = this.V;
        if (downloadListener != null) {
            downloadListener.onDownloadDeleted(t);
        }
    }
}
