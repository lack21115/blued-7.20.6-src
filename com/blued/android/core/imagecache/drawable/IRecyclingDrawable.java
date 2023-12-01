package com.blued.android.core.imagecache.drawable;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/drawable/IRecyclingDrawable.class */
public interface IRecyclingDrawable {

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/drawable/IRecyclingDrawable$CountRef.class */
    public static class CountRef {
        private IRecyclingDrawable a;
        private int b = 0;
        private int c = 0;
        private boolean d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public CountRef(IRecyclingDrawable iRecyclingDrawable) {
            this.a = null;
            this.a = iRecyclingDrawable;
        }

        private void a() {
            synchronized (this) {
                if (this.b <= 0 && this.c <= 0 && this.d && this.a.c()) {
                    this.a.d();
                }
            }
        }

        public void a(boolean z) {
            synchronized (this) {
                if (z) {
                    this.c++;
                    this.d = true;
                } else {
                    this.c--;
                }
            }
            a();
        }

        public void b(boolean z) {
            synchronized (this) {
                if (z) {
                    this.b++;
                } else {
                    this.b--;
                }
            }
            a();
        }
    }

    void a(String str);

    void a(boolean z);

    boolean a();

    String b();

    void b(boolean z);

    boolean c();

    void d();

    int e();
}
