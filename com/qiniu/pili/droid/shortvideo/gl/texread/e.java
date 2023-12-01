package com.qiniu.pili.droid.shortvideo.gl.texread;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/gl/texread/e.class */
public class e {

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/gl/texread/e$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Thread f27730a = Thread.currentThread();

        public void a() {
            if (this.f27730a == null) {
                this.f27730a = Thread.currentThread();
            }
            if (Thread.currentThread() != this.f27730a) {
                throw new IllegalStateException("Wrong thread");
            }
        }
    }
}
