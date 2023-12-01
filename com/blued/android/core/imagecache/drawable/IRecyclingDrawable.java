package com.blued.android.core.imagecache.drawable;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/drawable/IRecyclingDrawable.class */
public interface IRecyclingDrawable {

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/drawable/IRecyclingDrawable$CountRef.class */
    public static class CountRef {

        /* renamed from: a  reason: collision with root package name */
        private IRecyclingDrawable f9617a;
        private int b = 0;

        /* renamed from: c  reason: collision with root package name */
        private int f9618c = 0;
        private boolean d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public CountRef(IRecyclingDrawable iRecyclingDrawable) {
            this.f9617a = null;
            this.f9617a = iRecyclingDrawable;
        }

        private void a() {
            synchronized (this) {
                if (this.b <= 0 && this.f9618c <= 0 && this.d && this.f9617a.c()) {
                    this.f9617a.d();
                }
            }
        }

        public void a(boolean z) {
            synchronized (this) {
                if (z) {
                    this.f9618c++;
                    this.d = true;
                } else {
                    this.f9618c--;
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
