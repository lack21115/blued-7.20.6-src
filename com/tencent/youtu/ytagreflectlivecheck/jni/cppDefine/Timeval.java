package com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/youtu/ytagreflectlivecheck/jni/cppDefine/Timeval.class */
public class Timeval {
    public final long tvSec;
    public final int tvUsec;

    public Timeval(long j, int i) {
        this.tvSec = j;
        this.tvUsec = i;
    }

    public String toString() {
        return "Timeval{tvSec=" + this.tvSec + ", tvUsec=" + this.tvUsec + '}';
    }
}
