package com.tencent.thumbplayer.b;

import com.tencent.thumbplayer.api.composition.ITPMediaComposition;
import com.tencent.thumbplayer.api.composition.ITPMediaTrack;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/b/e.class */
public class e extends d implements ITPMediaComposition {

    /* renamed from: a  reason: collision with root package name */
    private int f25531a = 0;
    private int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f25532c = 0;
    private List<ITPMediaTrack> d = new ArrayList(1);
    private List<ITPMediaTrack> e = new ArrayList(1);
    private List<ITPMediaTrack> f = new ArrayList(1);

    private int d() {
        int i;
        synchronized (this) {
            i = this.f25531a + 1;
            this.f25531a = i;
        }
        return i;
    }

    private int e() {
        int i;
        synchronized (this) {
            i = this.b + 1;
            this.b = i;
        }
        return i;
    }

    private int f() {
        int i;
        synchronized (this) {
            i = this.f25532c + 1;
            this.f25532c = i;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long a() {
        List<ITPMediaTrack> list = this.d;
        long j = 0;
        long j2 = 0;
        if (list != null) {
            Iterator<ITPMediaTrack> it = list.iterator();
            while (true) {
                j2 = j;
                if (!it.hasNext()) {
                    break;
                }
                ITPMediaTrack next = it.next();
                if (j < next.getTimelineDurationMs()) {
                    j = next.getTimelineDurationMs();
                }
            }
        }
        return j2;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaComposition
    public ITPMediaTrack addAVTrack() {
        g gVar;
        synchronized (this) {
            gVar = new g(f(), 1);
            this.f.add(gVar);
        }
        return gVar;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaComposition
    public ITPMediaTrack addAudioTrack() {
        g gVar;
        synchronized (this) {
            gVar = new g(e(), 3);
            this.e.add(gVar);
        }
        return gVar;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaComposition
    public ITPMediaTrack addVideoTrack() {
        g gVar;
        synchronized (this) {
            gVar = new g(d(), 2);
            this.d.add(gVar);
        }
        return gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long b() {
        List<ITPMediaTrack> list = this.e;
        long j = 0;
        long j2 = 0;
        if (list != null) {
            Iterator<ITPMediaTrack> it = list.iterator();
            while (true) {
                j2 = j;
                if (!it.hasNext()) {
                    break;
                }
                ITPMediaTrack next = it.next();
                if (j < next.getTimelineDurationMs()) {
                    j = next.getTimelineDurationMs();
                }
            }
        }
        return j2;
    }

    long c() {
        List<ITPMediaTrack> list = this.f;
        long j = 0;
        long j2 = 0;
        if (list != null) {
            Iterator<ITPMediaTrack> it = list.iterator();
            while (true) {
                j2 = j;
                if (!it.hasNext()) {
                    break;
                }
                ITPMediaTrack next = it.next();
                if (j < next.getTimelineDurationMs()) {
                    j = next.getTimelineDurationMs();
                }
            }
        }
        return j2;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaComposition
    public List<ITPMediaTrack> getAllAVTracks() {
        return this.f;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaComposition
    public List<ITPMediaTrack> getAllAudioTracks() {
        List<ITPMediaTrack> list;
        synchronized (this) {
            list = this.e;
        }
        return list;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaComposition
    public List<ITPMediaTrack> getAllVideoTracks() {
        List<ITPMediaTrack> list;
        synchronized (this) {
            list = this.d;
        }
        return list;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0096, code lost:
        if (r0 > 0) goto L30;
     */
    @Override // com.tencent.thumbplayer.api.composition.ITPMediaComposition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long getDurationMs() {
        /*
            r5 = this;
            r0 = r5
            java.util.List<com.tencent.thumbplayer.api.composition.ITPMediaTrack> r0 = r0.f
            boolean r0 = com.tencent.thumbplayer.utils.b.a(r0)
            if (r0 != 0) goto Lf
            r0 = r5
            long r0 = r0.c()
            return r0
        Lf:
            r0 = r5
            long r0 = r0.b()
            r9 = r0
            r0 = r5
            long r0 = r0.a()
            r11 = r0
            r0 = r11
            r1 = r9
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            r7 = r0
            r0 = r7
            if (r0 <= 0) goto L2c
            r0 = r11
            r13 = r0
            goto L30
        L2c:
            r0 = r9
            r13 = r0
        L30:
            java.lang.String r0 = com.tencent.thumbplayer.b.f.f25533a
            r17 = r0
            r0 = -1
            r6 = r0
            r0 = r17
            int r0 = r0.hashCode()
            r8 = r0
            r0 = r8
            r1 = -2046821033(0xffffffff85fffd57, float:-2.4073147E-35)
            if (r0 == r1) goto L70
            r0 = r8
            r1 = -491658008(0xffffffffe2b1e4e8, float:-1.640784E21)
            if (r0 == r1) goto L61
            r0 = r8
            r1 = -472621683(0xffffffffe3d45d8d, float:-7.8349016E21)
            if (r0 == r1) goto L52
            goto L7c
        L52:
            r0 = r17
            java.lang.String r1 = "base_video"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L7c
            r0 = 0
            r6 = r0
            goto L7c
        L61:
            r0 = r17
            java.lang.String r1 = "base_audio"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L7c
            r0 = 1
            r6 = r0
            goto L7c
        L70:
            r0 = r17
            java.lang.String r1 = "base_longer"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L7c
            r0 = 2
            r6 = r0
        L7c:
            r0 = r6
            if (r0 == 0) goto L99
            r0 = r9
            r15 = r0
            r0 = r6
            r1 = 1
            if (r0 == r1) goto L9d
            r0 = r6
            r1 = 2
            if (r0 == r1) goto L91
            r0 = r13
            return r0
        L91:
            r0 = r9
            r15 = r0
            r0 = r7
            if (r0 <= 0) goto L9d
        L99:
            r0 = r11
            r15 = r0
        L9d:
            r0 = r15
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.b.e.getDurationMs():long");
    }

    @Override // com.tencent.thumbplayer.b.d, com.tencent.thumbplayer.api.composition.ITPMediaAsset
    public int getMediaType() {
        return 4;
    }

    @Override // com.tencent.thumbplayer.b.d, com.tencent.thumbplayer.api.composition.ITPMediaAsset
    public String getUrl() {
        try {
            return i.a(this);
        } catch (Exception e) {
            TPLogUtil.e("TPMediaComposition", e);
            return null;
        }
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaComposition
    public void release() {
        List<ITPMediaTrack> list = this.d;
        if (list != null) {
            list.clear();
            this.d = null;
        }
        List<ITPMediaTrack> list2 = this.e;
        if (list2 != null) {
            list2.clear();
            this.e = null;
        }
        List<ITPMediaTrack> list3 = this.f;
        if (list3 != null) {
            list3.clear();
            this.f = null;
        }
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaComposition
    public boolean removeAVTrack(ITPMediaTrack iTPMediaTrack) {
        if (iTPMediaTrack != null) {
            return this.f.remove(iTPMediaTrack);
        }
        throw new IllegalArgumentException("remove audio track , track is null .");
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaComposition
    public boolean removeAudioTrack(ITPMediaTrack iTPMediaTrack) {
        boolean remove;
        synchronized (this) {
            if (iTPMediaTrack == null) {
                throw new IllegalArgumentException("remove audio track , track is null .");
            }
            remove = this.e.remove(iTPMediaTrack);
        }
        return remove;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaComposition
    public boolean removeVideoTrack(ITPMediaTrack iTPMediaTrack) {
        boolean remove;
        synchronized (this) {
            if (iTPMediaTrack == null) {
                throw new IllegalArgumentException("remove video track , track is null .");
            }
            remove = this.d.remove(iTPMediaTrack);
        }
        return remove;
    }
}
