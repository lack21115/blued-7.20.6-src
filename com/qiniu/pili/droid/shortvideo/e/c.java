package com.qiniu.pili.droid.shortvideo.e;

import com.qiniu.pili.droid.shortvideo.PLMixAudioFile;
import com.qiniu.pili.droid.shortvideo.f.e;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/e/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private List<PLMixAudioFile> f27648a = new LinkedList();

    public PLMixAudioFile a() {
        if (this.f27648a.size() <= 0) {
            return null;
        }
        return this.f27648a.get(0);
    }

    public void a(int i) {
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i3 >= this.f27648a.size()) {
                return;
            }
            PLMixAudioFile pLMixAudioFile = this.f27648a.get(i3);
            a a2 = pLMixAudioFile.a();
            if (pLMixAudioFile.a(i * 1000)) {
                if (a2 != null) {
                    a2.d();
                }
                pLMixAudioFile.setNeedUpdatePosition(true);
            }
            i2 = i3 + 1;
        }
    }

    public void a(long j) {
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= this.f27648a.size()) {
                return;
            }
            PLMixAudioFile pLMixAudioFile = this.f27648a.get(i2);
            if (pLMixAudioFile.a(1000 * j) && pLMixAudioFile.a() != null) {
                pLMixAudioFile.a().b();
            }
            i = i2 + 1;
        }
    }

    public void a(long j, boolean z) {
        PLMixAudioFile pLMixAudioFile;
        a a2;
        long j2 = j * 1000;
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= this.f27648a.size() || (a2 = (pLMixAudioFile = this.f27648a.get(i2)).a()) == null) {
                return;
            }
            if (pLMixAudioFile.a(j2)) {
                if (z) {
                    if (!a2.c()) {
                        a2.b();
                    }
                    if (pLMixAudioFile.f()) {
                        a2.a(pLMixAudioFile.b(j2));
                        pLMixAudioFile.setNeedUpdatePosition(false);
                    }
                }
            } else if (a2.c()) {
                a2.e();
            }
            i = i2 + 1;
        }
    }

    public void a(PLMixAudioFile pLMixAudioFile) {
        this.f27648a.add(pLMixAudioFile);
    }

    public int b() {
        return this.f27648a.size();
    }

    public void b(long j) {
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= this.f27648a.size()) {
                return;
            }
            PLMixAudioFile pLMixAudioFile = this.f27648a.get(i2);
            if (pLMixAudioFile.a(1000 * j) && pLMixAudioFile.a() != null) {
                pLMixAudioFile.a().f();
            }
            i = i2 + 1;
        }
    }

    public void b(PLMixAudioFile pLMixAudioFile) {
        if (!this.f27648a.contains(pLMixAudioFile)) {
            e.q.e("MultiMixAudioPlayer", "can not find the mix audio file!");
            return;
        }
        this.f27648a.remove(pLMixAudioFile);
        if (pLMixAudioFile.a() != null) {
            pLMixAudioFile.a().d();
        }
        pLMixAudioFile.c();
    }

    public List<PLMixAudioFile> c() {
        return this.f27648a;
    }

    public void c(PLMixAudioFile pLMixAudioFile) {
        if (this.f27648a.size() <= 0) {
            this.f27648a.add(pLMixAudioFile);
        } else {
            this.f27648a.set(0, pLMixAudioFile);
        }
    }

    public void d() {
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= this.f27648a.size()) {
                return;
            }
            if (this.f27648a.get(i2).a() != null) {
                this.f27648a.get(i2).a().e();
            }
            i = i2 + 1;
        }
    }

    public void e() {
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= this.f27648a.size()) {
                return;
            }
            if (this.f27648a.get(i2).a() != null) {
                this.f27648a.get(i2).a().d();
            }
            i = i2 + 1;
        }
    }

    public void f() {
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= this.f27648a.size()) {
                return;
            }
            PLMixAudioFile pLMixAudioFile = this.f27648a.get(i2);
            if (pLMixAudioFile.a() != null) {
                pLMixAudioFile.a().a(pLMixAudioFile.getStartTime() / 1000);
            }
            i = i2 + 1;
        }
    }
}
