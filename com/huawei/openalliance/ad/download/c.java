package com.huawei.openalliance.ad.download;

import android.text.TextUtils;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.download.DownloadTask;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/download/c.class */
public class c<T extends DownloadTask> {
    private static final String Code = "DownloadQueue";
    private Queue<T> V = new ConcurrentLinkedQueue();

    private T Code(Queue<T> queue, String str) {
        if (ge.Code()) {
            ge.Code(Code, "findTaskFromQueue, taskId:%s", str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (T t : queue) {
            if (str.equals(t.F())) {
                return t;
            }
        }
        return null;
    }

    public T Code(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (ge.Code()) {
            ge.Code(Code, "findTask, workingQueue.size:%s", Integer.valueOf(this.V.size()));
        }
        return Code(this.V, str);
    }

    public Queue<T> Code() {
        return this.V;
    }

    public void Code(T t) {
        if (t == null || this.V.contains(t)) {
            return;
        }
        this.V.offer(t);
    }

    public void V() {
        this.V.clear();
    }

    public boolean V(T t) {
        if (t == null || !this.V.contains(t)) {
            return false;
        }
        this.V.remove(t);
        return true;
    }
}
