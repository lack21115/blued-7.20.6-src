package com.blued.android.framework.utils.upload.qiniu;

import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.upload.qiniu.IUploadTask;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/upload/qiniu/UploadTaskHandle.class */
public class UploadTaskHandle {
    private static final String a = UploadTaskHandle.class.getSimpleName();
    private static UploadTaskHandle b;
    private IUploadTask d;
    private ArrayList<IUploadTask> c = new ArrayList<>();
    private ArrayList<String> e = new ArrayList<>();

    private UploadTaskHandle() {
    }

    public static UploadTaskHandle a() {
        if (b == null) {
            synchronized (UploadTaskHandle.class) {
                try {
                    if (b == null) {
                        b = new UploadTaskHandle();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    private IUploadTask b() {
        IUploadTask remove;
        b("getStackTopTask");
        if (this.c.size() <= 0 || (remove = this.c.remove(0)) == null) {
            return null;
        }
        b("getStackTopTask  | taskId:" + remove.a());
        return remove;
    }

    private void b(String str) {
        if (AppInfo.m()) {
            Logger.c(MediaSender.a, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        synchronized (this) {
            if (this.d == null) {
                IUploadTask b2 = b();
                this.d = b2;
                if (b2 != null) {
                    b("开始消费下一个任务:" + this.d.a());
                    this.d.a(new IUploadTask.IUploadStateListener() { // from class: com.blued.android.framework.utils.upload.qiniu.UploadTaskHandle.1
                        @Override // com.blued.android.framework.utils.upload.qiniu.IUploadTask.IUploadStateListener
                        public void a() {
                            UploadTaskHandle.this.d = null;
                            UploadTaskHandle.this.c();
                        }
                    });
                } else {
                    b("没有可消费的任务!!!");
                }
            } else {
                b("没有可消费的任务!!!");
            }
        }
    }

    public void a(String str) {
        IUploadTask iUploadTask;
        synchronized (this) {
            if (this.d == null || !this.d.a().equals(str)) {
                Iterator<IUploadTask> it = this.c.iterator();
                while (true) {
                    iUploadTask = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    iUploadTask = it.next();
                    if (iUploadTask != null && iUploadTask.a().equals(str)) {
                        iUploadTask.b();
                        break;
                    }
                }
                if (iUploadTask != null) {
                    this.c.remove(iUploadTask);
                }
            } else {
                IUploadTask iUploadTask2 = this.d;
                iUploadTask2.b();
                this.c.remove(iUploadTask2);
                this.d = null;
            }
            this.e.remove(str);
        }
    }

    public boolean a(IUploadTask iUploadTask) {
        synchronized (this) {
            if (iUploadTask == null) {
                return false;
            }
            if (this.e.contains(iUploadTask.a())) {
                return false;
            }
            this.c.add(iUploadTask);
            this.e.add(iUploadTask.a());
            c();
            b("添加上传任务, taskId" + iUploadTask.a());
            return true;
        }
    }
}
