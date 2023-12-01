package com.qiniu.pili.droid.shortvideo.f;

import android.graphics.Bitmap;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import com.qiniu.pili.droid.shortvideo.PLVideoFrame;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/f/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private String f27674a;
    private MediaExtractor b;

    /* renamed from: c  reason: collision with root package name */
    private MediaExtractor f27675c;
    private MediaFormat d;
    private MediaFormat e;
    private List<Long> f;
    private List<Long> g;
    private boolean h;

    public f(String str) {
        this(str, true, true);
    }

    public f(String str, boolean z, boolean z2) {
        if (str == null) {
            e.w.e("MediaFile", "Create MediaFile failed, empty path");
            return;
        }
        this.f27674a = str;
        if (z) {
            a(str);
        }
        if (z2) {
            b(str);
        }
    }

    private int a(MediaExtractor mediaExtractor, String str) {
        int trackCount = mediaExtractor.getTrackCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= trackCount) {
                return -1;
            }
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i2);
            String string = trackFormat.getString(MediaFormat.KEY_MIME);
            if (string.startsWith(str)) {
                e eVar = e.w;
                eVar.b("MediaFile", "Extractor selected track " + i2 + " (" + string + "): " + trackFormat);
                return i2;
            }
            i = i2 + 1;
        }
    }

    private List<Long> a(MediaExtractor mediaExtractor, long j) {
        LinkedList linkedList = new LinkedList();
        if (mediaExtractor == null) {
            return linkedList;
        }
        do {
            long sampleTime = mediaExtractor.getSampleTime();
            if (sampleTime >= 0) {
                long j2 = sampleTime + j;
                linkedList.add(Long.valueOf(j2));
                e eVar = e.w;
                eVar.b("MediaFile", "cache video timestamp: " + j2);
            }
        } while (mediaExtractor.advance());
        Collections.sort(linkedList);
        mediaExtractor.seekTo(0L, 0);
        return linkedList;
    }

    private boolean a(String str) {
        MediaExtractor mediaExtractor = new MediaExtractor();
        this.b = mediaExtractor;
        try {
            mediaExtractor.setDataSource(str);
            int a2 = a(this.b, "video/");
            if (a2 >= 0) {
                this.b.selectTrack(a2);
                this.d = this.b.getTrackFormat(a2);
                return true;
            }
            e eVar = e.w;
            eVar.e("MediaFile", "failed to select video track: " + this.f27674a);
            return false;
        } catch (IOException e) {
            e.w.e("MediaFile", e.getMessage());
            return false;
        }
    }

    private PLVideoFrame b(long j, boolean z, int i, int i2) {
        PLVideoFrame.a aVar;
        e eVar = e.w;
        eVar.c("MediaFile", "getVideoFrame at in Us: " + j + " is key frame: " + z);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(this.f27674a);
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(j, z ? 2 : 3);
            if (frameAtTime != null) {
                Bitmap.Config config = frameAtTime.getConfig();
                if (config == Bitmap.Config.RGB_565) {
                    aVar = PLVideoFrame.a.RGB_565;
                } else if (config != Bitmap.Config.ARGB_8888) {
                    e eVar2 = e.w;
                    eVar2.d("MediaFile", config + " config not supported");
                    return null;
                } else {
                    aVar = PLVideoFrame.a.ARGB_8888;
                }
                Bitmap bitmap = frameAtTime;
                if (i != 0) {
                    bitmap = frameAtTime;
                    if (i2 != 0) {
                        bitmap = ThumbnailUtils.extractThumbnail(frameAtTime, i, i2);
                    }
                }
                ByteBuffer allocate = ByteBuffer.allocate(bitmap.getByteCount());
                bitmap.copyPixelsToBuffer(allocate);
                PLVideoFrame pLVideoFrame = new PLVideoFrame();
                pLVideoFrame.setTimestampMs(j / 1000);
                pLVideoFrame.setData(allocate.array());
                pLVideoFrame.setDataFormat(aVar);
                pLVideoFrame.setIsKeyFrame(z);
                pLVideoFrame.setWidth(bitmap.getWidth());
                pLVideoFrame.setHeight(bitmap.getHeight());
                pLVideoFrame.setRotation(0);
                return pLVideoFrame;
            }
            return null;
        } catch (RuntimeException e) {
            e.w.e("MediaFile", "Illegal file path for MediaMetadataRetriever");
            return null;
        }
    }

    private boolean b(String str) {
        MediaExtractor mediaExtractor = new MediaExtractor();
        this.f27675c = mediaExtractor;
        try {
            mediaExtractor.setDataSource(str);
            int a2 = a(this.f27675c, "audio/");
            if (a2 >= 0) {
                this.f27675c.selectTrack(a2);
                this.e = this.f27675c.getTrackFormat(a2);
                return true;
            }
            e eVar = e.w;
            eVar.e("MediaFile", "failed to select audio track: " + this.f27674a);
            return false;
        } catch (IOException e) {
            e.w.e("MediaFile", e.getMessage());
            return false;
        }
    }

    private boolean q() {
        int i;
        e.w.c("MediaFile", "initFrameInfo +");
        long currentTimeMillis = System.currentTimeMillis();
        this.f = new ArrayList();
        this.g = new ArrayList();
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            mediaExtractor.setDataSource(this.f27674a);
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= mediaExtractor.getTrackCount()) {
                    i = -1;
                    break;
                } else if (mediaExtractor.getTrackFormat(i).getString(MediaFormat.KEY_MIME).startsWith("video")) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            if (i == -1) {
                e.w.e("MediaFile", "cannot find video track");
                return false;
            }
            mediaExtractor.selectTrack(i);
            do {
                if ((mediaExtractor.getSampleFlags() & 1) > 0) {
                    this.f.add(Long.valueOf(mediaExtractor.getSampleTime()));
                }
                this.g.add(Long.valueOf(mediaExtractor.getSampleTime()));
                if (!mediaExtractor.advance()) {
                    break;
                }
            } while (mediaExtractor.getSampleTime() >= 0);
            long currentTimeMillis2 = System.currentTimeMillis();
            e.w.c("MediaFile", "frame count: " + this.g.size() + " key frame count: " + this.f.size() + " cost timeMs: " + (currentTimeMillis2 - currentTimeMillis));
            e.w.c("MediaFile", "initFrameInfo -");
            return true;
        } catch (IOException e) {
            e.w.e("MediaFile", e.getMessage());
            return false;
        }
    }

    public int a(boolean z) {
        if (this.g == null || this.f == null) {
            this.h = q();
        }
        if (this.h) {
            if (z && !this.f.isEmpty()) {
                e eVar = e.w;
                eVar.b("MediaFile", "already got key frame count: " + this.f.size());
                return this.f.size();
            } else if (z || this.g.isEmpty()) {
                return (z ? this.f : this.g).size();
            } else {
                e eVar2 = e.w;
                eVar2.b("MediaFile", "already got frame count: " + this.g.size());
                return this.g.size();
            }
        }
        return -1;
    }

    public PLVideoFrame a(int i, boolean z) {
        return a(i, z, 0, 0);
    }

    public PLVideoFrame a(int i, boolean z, int i2, int i3) {
        if (this.g == null || this.f == null) {
            this.h = q();
        }
        if (this.h) {
            return b((z ? this.f : this.g).get(i).longValue(), z, i2, i3);
        }
        return null;
    }

    public PLVideoFrame a(long j, boolean z) {
        return a(j, z, 0, 0);
    }

    public PLVideoFrame a(long j, boolean z, int i, int i2) {
        return b(j * 1000, z, i, i2);
    }

    public void a() {
        MediaExtractor mediaExtractor = this.b;
        if (mediaExtractor != null) {
            mediaExtractor.release();
            this.b = null;
        }
        MediaExtractor mediaExtractor2 = this.f27675c;
        if (mediaExtractor2 != null) {
            mediaExtractor2.release();
            this.f27675c = null;
        }
    }

    public String b() {
        return this.f27674a;
    }

    public MediaExtractor c() {
        return this.b;
    }

    public MediaExtractor d() {
        return this.f27675c;
    }

    public MediaFormat e() {
        return this.d;
    }

    public MediaFormat f() {
        return this.e;
    }

    public long g() {
        return g.a((Object) this.f27674a);
    }

    public int h() {
        MediaFormat mediaFormat = this.d;
        if (mediaFormat == null || !mediaFormat.containsKey("width")) {
            e eVar = e.w;
            eVar.d("MediaFile", "failed to get video width: " + this.f27674a);
            return 0;
        }
        return this.d.getInteger("width");
    }

    public int i() {
        MediaFormat mediaFormat = this.d;
        if (mediaFormat == null || !mediaFormat.containsKey("height")) {
            e eVar = e.w;
            eVar.d("MediaFile", "failed to get video height: " + this.f27674a);
            return 0;
        }
        return this.d.getInteger("height");
    }

    public int j() {
        MediaFormat mediaFormat = this.d;
        int integer = (mediaFormat == null || !mediaFormat.containsKey(MediaFormat.KEY_FRAME_RATE)) ? 0 : this.d.getInteger(MediaFormat.KEY_FRAME_RATE);
        if (integer == 0) {
            if (g() != 0) {
                return (int) ((a(false) * 1000) / g());
            }
            e eVar = e.w;
            eVar.d("MediaFile", "failed to get video framerate: " + this.f27674a + ", illegal video duration value.");
        }
        return integer;
    }

    public int k() {
        MediaFormat mediaFormat = this.d;
        if (mediaFormat == null || !mediaFormat.containsKey(MediaFormat.KEY_BIT_RATE)) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(this.f27674a);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(20);
            if (extractMetadata != null) {
                return Integer.parseInt(extractMetadata);
            }
            e eVar = e.w;
            eVar.d("MediaFile", "failed to get video bitrate: " + this.f27674a);
            return 0;
        }
        return this.d.getInteger(MediaFormat.KEY_BIT_RATE);
    }

    public int l() {
        MediaFormat mediaFormat = this.d;
        if (mediaFormat == null || !mediaFormat.containsKey(MediaFormat.KEY_I_FRAME_INTERVAL)) {
            e eVar = e.w;
            eVar.d("MediaFile", "failed to get video i interval: " + this.f27674a);
            return 0;
        }
        return this.d.getInteger(MediaFormat.KEY_I_FRAME_INTERVAL);
    }

    public int m() {
        return g.d(this.f27674a);
    }

    public int n() {
        MediaFormat mediaFormat = this.e;
        if (mediaFormat == null || !mediaFormat.containsKey(MediaFormat.KEY_CHANNEL_COUNT)) {
            e eVar = e.w;
            eVar.d("MediaFile", "failed to get audio channels: " + this.f27674a);
            return 0;
        }
        return this.e.getInteger(MediaFormat.KEY_CHANNEL_COUNT);
    }

    public int o() {
        MediaFormat mediaFormat = this.e;
        if (mediaFormat == null || !mediaFormat.containsKey(MediaFormat.KEY_SAMPLE_RATE)) {
            e eVar = e.w;
            eVar.d("MediaFile", "failed to get audio samplerate: " + this.f27674a);
            return 0;
        }
        return this.e.getInteger(MediaFormat.KEY_SAMPLE_RATE);
    }

    public List<Long> p() {
        return a(this.b, 0L);
    }
}
