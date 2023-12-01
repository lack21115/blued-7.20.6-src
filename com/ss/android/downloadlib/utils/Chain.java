package com.ss.android.downloadlib.utils;

import java.lang.ref.SoftReference;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/utils/Chain.class */
public class Chain<P, R> implements Runnable {
    private int b;
    private Chain<?, P> h;
    private SoftReference<mb<P, R>> hj;
    private P mb;
    private R ox;
    private Chain<R, ?> u;

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/utils/Chain$ThreadType.class */
    public @interface ThreadType {
        public static final int CPU = 1;
        public static final int IO = 2;
        public static final int MAIN = 0;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/utils/Chain$mb.class */
    public interface mb<PARAM, RESULT> {
        RESULT mb(PARAM param);
    }

    private Chain(int i, mb<P, R> mbVar, P p) {
        this.b = i;
        this.hj = new SoftReference<>(mbVar);
        this.mb = p;
    }

    public static <P, R> Chain<P, R> mb(mb<P, R> mbVar, P p) {
        return new Chain<>(2, mbVar, p);
    }

    private R ox() {
        return this.ox;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <NR> Chain<R, NR> mb(int i, mb<R, NR> mbVar) {
        Chain chain = (Chain<R, ?>) new Chain(i, mbVar, null);
        this.u = chain;
        chain.h = this;
        return chain;
    }

    public <NR> Chain<R, NR> mb(mb<R, NR> mbVar) {
        return mb(0, mbVar);
    }

    public void mb() {
        Chain<?, P> chain = this.h;
        if (chain != null) {
            chain.mb();
        } else {
            run();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Chain<?, P> chain;
        if (this.b == 0 && !jb.mb()) {
            com.ss.android.downloadlib.ko.mb().ox().post(this);
        } else if (this.b == 1 && jb.mb()) {
            com.ss.android.downloadlib.hj.mb().mb(this);
        } else if (this.b == 2 && jb.mb()) {
            com.ss.android.downloadlib.hj.mb().ox(this);
        } else {
            if (this.mb == null && (chain = this.h) != null) {
                this.mb = chain.ox();
            }
            mb<P, R> mbVar = this.hj.get();
            if (mbVar == null) {
                return;
            }
            this.ox = mbVar.mb(this.mb);
            Chain<R, ?> chain2 = this.u;
            if (chain2 != null) {
                chain2.run();
            }
        }
    }
}
