package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import java.util.Arrays;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/TbsCoreLoadStat.class */
public class TbsCoreLoadStat {
    private static TbsCoreLoadStat d;
    public static volatile int mLoadErrorCode = -1;

    /* renamed from: a  reason: collision with root package name */
    private TbsSequenceQueue f38757a = null;
    private boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private final int f38758c = 3;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/TbsCoreLoadStat$TbsSequenceQueue.class */
    public class TbsSequenceQueue {
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f38760c;
        private int[] d;
        private int e;
        private int f;

        public TbsSequenceQueue() {
            this.b = 10;
            this.e = 0;
            this.f = 0;
            this.f38760c = 10;
            this.d = new int[10];
        }

        public TbsSequenceQueue(int i, int i2) {
            this.b = 10;
            this.e = 0;
            this.f = 0;
            this.f38760c = i2;
            int[] iArr = new int[i2];
            this.d = iArr;
            iArr[0] = i;
            this.f = 0 + 1;
        }

        public void add(int i) {
            int i2 = this.f;
            if (i2 > this.f38760c - 1) {
                throw new IndexOutOfBoundsException("sequeue is full");
            }
            int[] iArr = this.d;
            this.f = i2 + 1;
            iArr[i2] = i;
        }

        public void clear() {
            Arrays.fill(this.d, 0);
            this.e = 0;
            this.f = 0;
        }

        public int element() {
            if (empty()) {
                throw new IndexOutOfBoundsException("sequeue is null");
            }
            return this.d[this.e];
        }

        public boolean empty() {
            return this.f == this.e;
        }

        public int length() {
            return this.f - this.e;
        }

        public int remove() {
            if (empty()) {
                throw new IndexOutOfBoundsException("sequeue is null");
            }
            int[] iArr = this.d;
            int i = this.e;
            int i2 = iArr[i];
            this.e = i + 1;
            iArr[i] = 0;
            return i2;
        }

        public String toString() {
            if (empty()) {
                return "";
            }
            StringBuilder sb = new StringBuilder("[");
            int i = this.e;
            while (true) {
                int i2 = i;
                if (i2 >= this.f) {
                    int length = sb.length();
                    StringBuilder delete = sb.delete(length - 1, length);
                    delete.append("]");
                    return delete.toString();
                }
                sb.append(String.valueOf(this.d[i2]) + ",");
                i = i2 + 1;
            }
        }
    }

    private TbsCoreLoadStat() {
    }

    public static TbsCoreLoadStat getInstance() {
        if (d == null) {
            d = new TbsCoreLoadStat();
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        TbsSequenceQueue tbsSequenceQueue = this.f38757a;
        if (tbsSequenceQueue != null) {
            tbsSequenceQueue.clear();
        }
        this.b = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, int i) {
        a(context, i, null);
        TbsLog.e(TbsListener.tag_load_error, "" + i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, int i, Throwable th) {
        synchronized (this) {
            if (mLoadErrorCode != -1) {
                TbsLog.w("TbsCoreLoadStat", "setLoadErrorCode :: error(" + mLoadErrorCode + ") was already reported; " + i + " is duplicated. Try to remove it!");
                return;
            }
            mLoadErrorCode = i;
            TbsLog.addLog(998, "code=%d,desc=%s", Integer.valueOf(i), String.valueOf(th));
            if (th != null) {
                TbsLogReport.getInstance(context).setLoadErrorCode(i, th);
            } else {
                TbsLog.e("TbsCoreLoadStat", "setLoadErrorCode :: error is null with errorCode: " + i + "; Check & correct it!");
            }
        }
    }
}
