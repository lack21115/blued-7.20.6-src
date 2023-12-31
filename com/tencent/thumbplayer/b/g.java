package com.tencent.thumbplayer.b;

import com.tencent.thumbplayer.api.composition.ITPMediaTrack;
import com.tencent.thumbplayer.api.composition.ITPMediaTrackClip;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/b/g.class */
public class g extends d implements ITPMediaTrack, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private int f25535a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private List<ITPMediaTrackClip> f25536c;

    public g(int i) {
        this.f25535a = -1;
        this.b = i;
        this.f25536c = new ArrayList();
    }

    public g(int i, int i2) {
        this.f25535a = -1;
        this.f25535a = i;
        this.b = i2;
        this.f25536c = new ArrayList();
    }

    private void a(ITPMediaTrackClip iTPMediaTrackClip) {
        synchronized (this) {
            if (iTPMediaTrackClip == null) {
                throw new IllegalArgumentException("add track clip , clip can not be null");
            }
            if (iTPMediaTrackClip.getMediaType() != this.b) {
                throw new IllegalArgumentException("add track clip failed, media type is not same");
            }
        }
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrack
    public int addTrackClip(ITPMediaTrackClip iTPMediaTrackClip) {
        synchronized (this) {
            a(iTPMediaTrackClip);
            if (!this.f25536c.contains(iTPMediaTrackClip)) {
                this.f25536c.add(iTPMediaTrackClip);
                return iTPMediaTrackClip.getClipId();
            }
            TPLogUtil.i("TPMediaCompositionTrack", "add track clip failed, clip already exists : " + iTPMediaTrackClip.getClipId());
            return iTPMediaTrackClip.getClipId();
        }
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrack
    public List<ITPMediaTrackClip> getAllTrackClips() {
        List<ITPMediaTrackClip> list;
        synchronized (this) {
            list = this.f25536c;
        }
        return list;
    }

    @Override // com.tencent.thumbplayer.b.d, com.tencent.thumbplayer.api.composition.ITPMediaAsset
    public int getMediaType() {
        int i;
        synchronized (this) {
            i = this.b;
        }
        return i;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrack
    public long getTimelineDurationMs() {
        long j;
        synchronized (this) {
            j = 0;
            for (ITPMediaTrackClip iTPMediaTrackClip : this.f25536c) {
                j += iTPMediaTrackClip.getOriginalDurationMs();
            }
        }
        return j;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrack
    public ITPMediaTrackClip getTrackClip(int i) {
        ITPMediaTrackClip next;
        synchronized (this) {
            Iterator<ITPMediaTrackClip> it = this.f25536c.iterator();
            do {
                if (!it.hasNext()) {
                    return null;
                }
                next = it.next();
            } while (next.getClipId() != i);
            return next;
        }
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrack
    public int getTrackId() {
        int i;
        synchronized (this) {
            i = this.f25535a;
        }
        return i;
    }

    @Override // com.tencent.thumbplayer.b.d, com.tencent.thumbplayer.api.composition.ITPMediaAsset
    public String getUrl() {
        String a2;
        synchronized (this) {
            try {
                a2 = i.a(this.f25536c, this.b);
            } catch (IOException e) {
                TPLogUtil.e("TPMediaCompositionTrack", e);
                return null;
            }
        }
        return a2;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrack
    public int insertTrackClip(ITPMediaTrackClip iTPMediaTrackClip, int i) {
        synchronized (this) {
            a(iTPMediaTrackClip);
            if (this.f25536c.contains(iTPMediaTrackClip)) {
                TPLogUtil.i("TPMediaCompositionTrack", "add track clip failed, clip already exists : " + iTPMediaTrackClip.getClipId());
                return iTPMediaTrackClip.getClipId();
            }
            if (i == -1) {
                this.f25536c.add(0, iTPMediaTrackClip);
                return iTPMediaTrackClip.getClipId();
            }
            int size = this.f25536c.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f25536c.get(i2).getClipId() == i) {
                    this.f25536c.add(i2 + 1, iTPMediaTrackClip);
                    return iTPMediaTrackClip.getClipId();
                }
            }
            this.f25536c.add(iTPMediaTrackClip);
            TPLogUtil.i("TPMediaCompositionTrack", "insert track clip into the end, coz after clip not found :".concat(String.valueOf(i)));
            return iTPMediaTrackClip.getClipId();
        }
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrack
    public void removeAllTrackClips() {
        synchronized (this) {
            this.f25536c.clear();
        }
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrack
    public boolean removeTrackClip(ITPMediaTrackClip iTPMediaTrackClip) {
        boolean remove;
        synchronized (this) {
            if (iTPMediaTrackClip == null) {
                throw new IllegalArgumentException("remove track clip , clip can not be null");
            }
            remove = this.f25536c.remove(iTPMediaTrackClip);
        }
        return remove;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrack
    public boolean swapTrackClip(int i, int i2) {
        synchronized (this) {
            if (i >= 0) {
                if (i < this.f25536c.size()) {
                    if (i2 >= 0 && i2 < this.f25536c.size()) {
                        Collections.swap(this.f25536c, i, i2);
                        return true;
                    }
                    TPLogUtil.w("TPMediaCompositionTrack", "swap clip failed, to pos invalid , to pos :".concat(String.valueOf(i2)));
                    return false;
                }
            }
            TPLogUtil.w("TPMediaCompositionTrack", "swap clip failed, from pos invalid , from pos : ".concat(String.valueOf(i)));
            return false;
        }
    }
}
