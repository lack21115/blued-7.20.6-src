package com.qiniu.pili.droid.shortvideo.muxer;

import android.media.MediaCodec;
import com.qiniu.pili.droid.shortvideo.f.e;
import java.io.File;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/muxer/FFMP4Muxer.class */
public class FFMP4Muxer extends c {
    private long f = 0;

    private native int addAudioStream(long j, int i, int i2, int i3, int i4, int i5);

    private native int addAudioStream2(long j, long j2);

    private native int addVideoStream(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7);

    private native int addVideoStream2(long j, int i, int i2, long j2);

    private native int closeFile(long j);

    private native long createFile(String str);

    private native int setESDSHeader(long j, ByteBuffer byteBuffer, int i);

    private native int setSPSPPSHeader(long j, ByteBuffer byteBuffer, int i);

    private native int start(long j);

    private native int writeAudioFrame(long j, ByteBuffer byteBuffer, int i, long j2, int i2);

    private native int writeAudioFrame2(long j, ByteBuffer byteBuffer, int i, long j2, int i2, int i3, int i4);

    private native int writeVideoFrame(long j, ByteBuffer byteBuffer, int i, boolean z, long j2, long j3);

    private native int writeVideoFrame2(long j, ByteBuffer byteBuffer, int i, boolean z, long j2, long j3, int i2, int i3);

    public void a(int i, ByteBuffer byteBuffer, int i2, boolean z, long j, long j2, int i3, int i4, int i5) {
        synchronized (this) {
            if (this.f != 0 && this.f != -1) {
                if (this.b == i) {
                    writeVideoFrame2(this.f, byteBuffer, i2, z, j, j2, i4, i5);
                } else if (this.f14046c == i) {
                    writeAudioFrame2(this.f, byteBuffer, i2, j, i3, i4, i5);
                }
                return;
            }
            e.n.d("FFMP4Muxer", "write failed, mMediaMuxer == null or trackIndex < 0 !");
        }
    }

    @Override // com.qiniu.pili.droid.shortvideo.muxer.c
    public void a(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this) {
            if (this.f != 0 && this.f != -1) {
                if (this.b == i) {
                    writeVideoFrame(this.f, byteBuffer, bufferInfo.size, (bufferInfo.flags & 1) != 0, bufferInfo.presentationTimeUs, bufferInfo.presentationTimeUs);
                } else if (this.f14046c == i) {
                    writeAudioFrame(this.f, byteBuffer, bufferInfo.size, bufferInfo.presentationTimeUs, 1152);
                }
                return;
            }
            e.n.d("FFMP4Muxer", "write failed, mMediaMuxer == null or trackIndex < 0 !");
        }
    }

    @Override // com.qiniu.pili.droid.shortvideo.muxer.c
    public boolean a() {
        synchronized (this) {
            e.n.c("FFMP4Muxer", "stop +");
            if (this.f != 0 && this.f != -1) {
                closeFile(this.f);
                e.n.c("FFMP4Muxer", "stop -");
                return true;
            }
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x01d6, code lost:
        if (r19 > 0) goto L51;
     */
    @Override // com.qiniu.pili.droid.shortvideo.muxer.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(java.lang.String r13, android.media.MediaFormat r14, android.media.MediaFormat r15, int r16) {
        /*
            Method dump skipped, instructions count: 969
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.pili.droid.shortvideo.muxer.FFMP4Muxer.a(java.lang.String, android.media.MediaFormat, android.media.MediaFormat, int):boolean");
    }

    public boolean a(String str, FFMP4Demuxer fFMP4Demuxer) {
        int i;
        synchronized (this) {
            e.n.c("FFMP4Muxer", "start +");
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                file.delete();
                e.n.c("FFMP4Muxer", "delete existed file: " + str);
            }
            try {
                if (fFMP4Demuxer == null) {
                    e.n.e("FFMP4Muxer", "muxer create failed, demuxer is null");
                    e.n.c("FFMP4Muxer", "start -");
                    return false;
                }
                long createFile = createFile(str);
                this.f = createFile;
                if (createFile == -1) {
                    e.n.e("FFMP4Muxer", "muxer create failed!");
                    e.n.c("FFMP4Muxer", "start -");
                    return false;
                }
                boolean z = true;
                this.b = fFMP4Demuxer.a();
                this.f14046c = fFMP4Demuxer.b();
                int i2 = -1;
                if (this.b >= 0) {
                    int addVideoStream2 = addVideoStream2(this.f, fFMP4Demuxer.c(), fFMP4Demuxer.d(), fFMP4Demuxer.j());
                    i = addVideoStream2;
                    if (addVideoStream2 < 0) {
                        z = false;
                        i = addVideoStream2;
                    }
                } else {
                    i = -1;
                }
                boolean z2 = z;
                if (this.f14046c >= 0) {
                    int addAudioStream2 = addAudioStream2(this.f, fFMP4Demuxer.k());
                    i2 = addAudioStream2;
                    z2 = z;
                    if (addAudioStream2 < 0) {
                        z2 = false;
                        i2 = addAudioStream2;
                    }
                }
                if (z2) {
                    start(this.f);
                    if (i >= 0) {
                        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(1024);
                        int a2 = fFMP4Demuxer.a(allocateDirect, allocateDirect.capacity());
                        allocateDirect.clear();
                        setSPSPPSHeader(this.f, allocateDirect, a2);
                    }
                    if (i2 >= 0) {
                        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(1024);
                        int b = fFMP4Demuxer.b(allocateDirect2, allocateDirect2.capacity());
                        allocateDirect2.clear();
                        setESDSHeader(this.f, allocateDirect2, b);
                    }
                }
                e.n.c("FFMP4Muxer", "start -");
                return z2;
            } catch (Exception e) {
                e.n.e("FFMP4Muxer", e.getMessage());
                e.n.c("FFMP4Muxer", "start -");
                return false;
            }
        }
    }
}
