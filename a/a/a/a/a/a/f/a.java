package a.a.a.a.a.a.f;

import a.a.a.a.a.e.e;
import com.qiniu.pili.droid.streaming.av.common.PLAVFrame;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/f/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public List<PLAVFrame> f1178a = new ArrayList();
    public final Object b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public int f1179c;

    public a(int i) {
        this.f1179c = 3;
        this.f1179c = i;
    }

    public PLAVFrame a(int i) {
        synchronized (this.b) {
            e.f.a("PLAVFramePool", "remove:reqSize:" + i);
            if (i <= 0) {
                return null;
            }
            if (this.f1178a.isEmpty()) {
                PLAVFrame pLAVFrame = new PLAVFrame(ByteBuffer.allocateDirect(i), 0, 0L);
                pLAVFrame.usedCounter++;
                return pLAVFrame;
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.f1178a.size()) {
                    break;
                }
                int capacity = this.f1178a.get(i3).mBuffer.capacity();
                if (capacity < i) {
                    i2 = i3 + 1;
                } else if (capacity == i || (capacity * 0.8f <= i && i < capacity)) {
                    PLAVFrame remove = this.f1178a.remove(i3);
                    remove.usedCounter++;
                    return remove;
                }
            }
            PLAVFrame pLAVFrame2 = new PLAVFrame(ByteBuffer.allocateDirect(i), 0, 0L);
            pLAVFrame2.usedCounter++;
            return pLAVFrame2;
        }
    }

    public void a() {
        synchronized (this.b) {
            this.f1178a.clear();
        }
    }

    public void a(PLAVFrame pLAVFrame) {
        synchronized (this.b) {
            if (this.f1178a.isEmpty()) {
                pLAVFrame.mBuffer.clear();
                this.f1178a.add(pLAVFrame);
                return;
            }
            int capacity = pLAVFrame.mBuffer.capacity();
            if (this.f1178a.get(this.f1178a.size() - 1).mBuffer.capacity() < capacity) {
                pLAVFrame.mBuffer.clear();
                this.f1178a.add(this.f1178a.size(), pLAVFrame);
                b(this.f1178a.size());
                return;
            }
            int size = this.f1178a.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                int capacity2 = this.f1178a.get(i2).mBuffer.capacity();
                if (capacity2 > capacity) {
                    pLAVFrame.mBuffer.clear();
                    this.f1178a.add(i2, pLAVFrame);
                    b(i2);
                    return;
                } else if (capacity2 == capacity) {
                    return;
                } else {
                    i = i2 + 1;
                }
            }
        }
    }

    public final void b(int i) {
        if (this.f1178a.size() > this.f1179c) {
            int i2 = 0;
            long j = this.f1178a.get(0).usedCounter;
            int i3 = 1;
            while (i3 < this.f1178a.size()) {
                int i4 = i2;
                long j2 = j;
                if (i3 != i) {
                    i4 = i2;
                    j2 = j;
                    if (this.f1178a.get(i3).usedCounter < j) {
                        j2 = this.f1178a.get(i3).usedCounter;
                        i4 = i3;
                    }
                }
                i3++;
                i2 = i4;
                j = j2;
            }
            PLAVFrame remove = this.f1178a.remove(i2);
            e.f.a("PLAVFramePool", "usedCounter:" + remove.usedCounter + ",buffer:" + remove.mBuffer + ",index:" + i2);
        }
    }
}
