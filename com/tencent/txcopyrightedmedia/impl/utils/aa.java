package com.tencent.txcopyrightedmedia.impl.utils;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/aa.class */
public final class aa {
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f40038c;
    private boolean d;
    private boolean e;
    private boolean g;
    private final Object f = new Object();

    /* renamed from: a  reason: collision with root package name */
    public byte[] f40037a = new byte[0];

    public final int a(byte[] bArr) {
        int i;
        int i2;
        synchronized (this.f) {
            if (this.e) {
                if (this.b <= bArr.length) {
                    i2 = this.b;
                    System.arraycopy((Object) this.f40037a, 0, (Object) bArr, 0, i2);
                    this.b = 0;
                } else {
                    int length = bArr.length;
                    System.arraycopy((Object) this.f40037a, 0, (Object) bArr, 0, bArr.length);
                    int length2 = bArr.length;
                    int i3 = 0;
                    while (true) {
                        i = i3;
                        if (length2 >= this.b) {
                            break;
                        }
                        this.f40037a[i] = this.f40037a[length2];
                        length2++;
                        i3 = i + 1;
                    }
                    this.b = i;
                    i2 = length;
                }
                this.e = false;
                this.f.notifyAll();
                return i2;
            }
            return 0;
        }
    }

    public final void a() {
        synchronized (this.f) {
            while (true) {
                if (!this.e && !this.d) {
                    this.b = 0;
                    new StringBuilder("clear finish. pid: ").append(Thread.currentThread().getId());
                    this.f.notifyAll();
                }
                try {
                    new StringBuilder("clear wait cause by write mode. pid: ").append(Thread.currentThread().getId());
                    this.f.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void a(int i) {
        int i2;
        synchronized (this.f) {
            while (true) {
                if (!this.e && !this.d) {
                    break;
                }
                try {
                    new StringBuilder("resize wait cause by write mode. pid: ").append(Thread.currentThread().getId());
                    this.f.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            byte[] bArr = new byte[i];
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (i2 >= i || i2 >= this.b) {
                    break;
                }
                bArr[i2] = this.f40037a[i2];
                i3 = i2 + 1;
            }
            this.b = i2;
            this.f40037a = bArr;
            new StringBuilder("resize finish. pid: ").append(Thread.currentThread().getId());
            this.f.notifyAll();
        }
    }

    public final int b(int i) {
        StringBuilder sb;
        long id;
        synchronized (this.f) {
            if (i > this.f40037a.length) {
                return -1;
            }
            do {
                if (!this.e && !this.d && this.b + i <= this.f40037a.length) {
                    this.d = true;
                    new StringBuilder("set writeMode. pid: ").append(Thread.currentThread().getId());
                    this.f40038c = i;
                    return this.b;
                }
                if (this.b + i > this.f40037a.length) {
                    if (this.g) {
                        new StringBuilder("write fail cause by no space and no read anymore. pid: ").append(Thread.currentThread().getId());
                        return -1;
                    }
                    sb = new StringBuilder("write wait cause by no space. pid: ");
                    id = Thread.currentThread().getId();
                } else if (this.e) {
                    sb = new StringBuilder("write wait cause by read mode. pid: ");
                    id = Thread.currentThread().getId();
                } else {
                    sb = new StringBuilder("write wait cause by write mode. pid: ");
                    id = Thread.currentThread().getId();
                }
                sb.append(id);
                try {
                    this.f.wait();
                    new StringBuilder("requireWrite wake up. pid: ").append(Thread.currentThread().getId());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (i <= this.f40037a.length);
            return -1;
        }
    }

    public final void b() {
        synchronized (this.f) {
            if (this.d) {
                this.b += this.f40038c;
                this.d = false;
                new StringBuilder("flushWrite. pid: ").append(Thread.currentThread().getId());
                this.f.notifyAll();
            }
        }
    }

    public final int c() {
        StringBuilder sb;
        long id;
        synchronized (this.f) {
            while (true) {
                if (!this.e && !this.d && this.b != 0) {
                    this.e = true;
                    return 0;
                }
                if (this.b == 0) {
                    if (this.g) {
                        new StringBuilder("read nothing cause by stream end. pid: ").append(Thread.currentThread().getId());
                        return -1;
                    }
                    sb = new StringBuilder("read wait cause by no data. pid: ");
                    id = Thread.currentThread().getId();
                } else if (this.d) {
                    sb = new StringBuilder("read wait cause by writeMode. pid: ");
                    id = Thread.currentThread().getId();
                } else {
                    sb = new StringBuilder("read wait cause by readMode. pid: ");
                    id = Thread.currentThread().getId();
                }
                sb.append(id);
                try {
                    this.f.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void d() {
        synchronized (this.f) {
            this.g = true;
            this.f.notifyAll();
        }
    }
}
