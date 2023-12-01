package com.qiniu.pili.droid.shortvideo.f;

import java.nio.ByteBuffer;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/f/i.class */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<Boolean> f27683a = new ArrayList<>();
    private ArrayList<ByteBuffer> b = new ArrayList<>();

    public ByteBuffer a(int i) {
        if (i < 0 || i >= this.f27683a.size()) {
            return null;
        }
        return this.b.get(i);
    }

    public void a() {
        this.f27683a.clear();
        this.b.clear();
    }

    public void a(int i, int i2) {
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return;
            }
            this.f27683a.add(false);
            this.b.add(ByteBuffer.allocate(i));
            i3 = i4 + 1;
        }
    }

    public int b() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f27683a.size()) {
                return -1;
            }
            if (!this.f27683a.get(i2).booleanValue()) {
                this.f27683a.set(i2, true);
                return i2;
            }
            i = i2 + 1;
        }
    }

    public void b(int i) {
        if (i < 0 || i >= this.f27683a.size()) {
            return;
        }
        this.f27683a.set(i, false);
        this.b.get(i).clear();
    }
}
