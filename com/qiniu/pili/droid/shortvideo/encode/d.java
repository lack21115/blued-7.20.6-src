package com.qiniu.pili.droid.shortvideo.encode;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/encode/d.class */
public abstract class d extends com.qiniu.pili.droid.shortvideo.encode.a {
    private static long g = 500;
    protected MediaCodec e;
    protected volatile boolean f;
    private volatile long h;
    private volatile boolean i;

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/encode/d$a.class */
    public enum a {
        VIDEO_ENCODER,
        AUDIO_ENCODER
    }

    private boolean n() {
        synchronized (this) {
            com.qiniu.pili.droid.shortvideo.f.e.h.c(j(), "startEncode +");
            this.b = 0;
            this.f13962c = 0;
            MediaFormat g2 = g();
            try {
                MediaCodec createEncoderByType = MediaCodec.createEncoderByType(h());
                this.e = createEncoderByType;
                createEncoderByType.configure(g2, null, null, 1);
                if (i() == a.VIDEO_ENCODER) {
                    Surface createInputSurface = this.e.createInputSurface();
                    if (this.d != null) {
                        this.d.a(createInputSurface);
                    }
                }
                this.e.start();
                if (this.d != null) {
                    this.d.a(true);
                }
                com.qiniu.pili.droid.shortvideo.f.e.h.c(j(), "startEncode -");
            } catch (Exception e) {
                this.e = null;
                com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.h;
                String j = j();
                eVar.e(j, "start encoder failed: " + e.getMessage());
                if (this.d != null) {
                    this.d.a(false);
                }
                com.qiniu.pili.droid.shortvideo.f.e.h.c(j(), "startEncode -");
                return false;
            }
        }
        return true;
    }

    private void o() {
        synchronized (this) {
            com.qiniu.pili.droid.shortvideo.f.e.h.c(j(), "stopEncode +");
            if (this.e == null) {
                com.qiniu.pili.droid.shortvideo.f.e.h.d(j(), "encoder is null.");
                return;
            }
            try {
                this.e.stop();
                this.e.release();
                this.e = null;
            } catch (Exception e) {
                com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.h;
                String j = j();
                eVar.e(j, "encoder stop, release failed: " + e.getMessage());
            }
            if (this.d != null) {
                this.d.b(this.f);
            }
            this.f = false;
            this.i = false;
            this.h = 0L;
            com.qiniu.pili.droid.shortvideo.f.e.h.c(j(), "stopEncode -");
        }
    }

    @Override // com.qiniu.pili.droid.shortvideo.encode.a
    public boolean a(long j) {
        com.qiniu.pili.droid.shortvideo.f.e.h.d(j(), "unimplemented !");
        return false;
    }

    @Override // com.qiniu.pili.droid.shortvideo.encode.a
    public boolean a(ByteBuffer byteBuffer, int i, long j) {
        synchronized (this) {
            if (m()) {
                com.qiniu.pili.droid.shortvideo.f.e.h.d(j(), "stop is marked, not accepting anymore frames.");
                return false;
            } else if (this.e == null) {
                com.qiniu.pili.droid.shortvideo.f.e.h.d(j(), "encoder is null.");
                return false;
            } else {
                long b = b(j);
                if (b < 0) {
                    return false;
                }
                try {
                    int dequeueInputBuffer = this.e.dequeueInputBuffer(-1L);
                    if (dequeueInputBuffer < 0) {
                        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.h;
                        String j2 = j();
                        eVar.e(j2, "dequeueInputBuffer failed: " + dequeueInputBuffer);
                        return false;
                    }
                    ByteBuffer byteBuffer2 = this.e.getInputBuffers()[dequeueInputBuffer];
                    if (byteBuffer2 != null && byteBuffer != null) {
                        byteBuffer.limit(Math.min(Math.min(byteBuffer.position() + i, byteBuffer.capacity()), byteBuffer2.remaining()));
                        byteBuffer2.put(byteBuffer);
                    }
                    try {
                        this.e.queueInputBuffer(dequeueInputBuffer, 0, i, b, 0);
                        d();
                        com.qiniu.pili.droid.shortvideo.f.e eVar2 = com.qiniu.pili.droid.shortvideo.f.e.h;
                        String j3 = j();
                        eVar2.b(j3, "input frame: " + this.b + " buffer:" + byteBuffer + " size:" + i + " timestampUs:" + b);
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                } catch (Exception e2) {
                    com.qiniu.pili.droid.shortvideo.f.e eVar3 = com.qiniu.pili.droid.shortvideo.f.e.h;
                    String j4 = j();
                    eVar3.e(j4, "dequeueInputBuffer failed: " + e2.getMessage());
                    return false;
                }
            }
        }
    }

    protected abstract MediaFormat g();

    protected abstract String h();

    protected abstract a i();

    protected void k() {
        if (this.e == null) {
            com.qiniu.pili.droid.shortvideo.f.e.h.d(j(), "encoder is null.");
            return;
        }
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        try {
            int dequeueOutputBuffer = this.e.dequeueOutputBuffer(bufferInfo, 1000L);
            if (dequeueOutputBuffer == -3) {
                com.qiniu.pili.droid.shortvideo.f.e.h.c(j(), "output buffers changed !");
            } else if (dequeueOutputBuffer == -2) {
                MediaFormat outputFormat = this.e.getOutputFormat();
                if (this.d != null) {
                    this.d.a(outputFormat);
                }
            } else if (dequeueOutputBuffer >= 0) {
                if ((bufferInfo.flags & 2) != 0) {
                    com.qiniu.pili.droid.shortvideo.f.e.h.c(j(), "ignoring BUFFER_FLAG_CODEC_CONFIG");
                } else {
                    ByteBuffer byteBuffer = this.e.getOutputBuffers()[dequeueOutputBuffer];
                    byteBuffer.position(bufferInfo.offset);
                    byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                    if (this.d != null) {
                        this.d.a(byteBuffer, bufferInfo);
                    }
                    byteBuffer.clear();
                    e();
                    this.h = System.currentTimeMillis();
                }
                try {
                    this.e.releaseOutputBuffer(dequeueOutputBuffer, false);
                } catch (Exception e) {
                    com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.h;
                    String j = j();
                    eVar.e(j, "releaseOutputBuffer failed: " + e.getMessage());
                    return;
                }
            }
            if (dequeueOutputBuffer == -1) {
                if (!m() || System.currentTimeMillis() - this.h <= g) {
                    return;
                }
                String str = i() == a.VIDEO_ENCODER ? "video" : "audio";
                com.qiniu.pili.droid.shortvideo.f.e eVar2 = com.qiniu.pili.droid.shortvideo.f.e.h;
                String j2 = j();
                eVar2.e(j2, str + " frame output time out, stop encode!  input frame count: " + this.b + " output frame count: " + this.f13962c + " drop frames: " + (this.b - this.f13962c));
                this.i = true;
                return;
            }
            com.qiniu.pili.droid.shortvideo.f.e eVar3 = com.qiniu.pili.droid.shortvideo.f.e.h;
            String j3 = j();
            StringBuilder sb = new StringBuilder();
            sb.append("output frame: ");
            sb.append(this.f13962c);
            sb.append(" index:");
            sb.append(dequeueOutputBuffer);
            sb.append(" key frame:");
            sb.append((bufferInfo.flags & 1) != 0);
            sb.append(" eos:");
            sb.append((bufferInfo.flags & 4) != 0);
            sb.append(" config:");
            sb.append((bufferInfo.flags & 2) != 0);
            sb.append(" sync:");
            sb.append((bufferInfo.flags & 1) != 0);
            sb.append(" time:");
            sb.append(bufferInfo.presentationTimeUs);
            sb.append(" size:");
            sb.append(bufferInfo.size);
            eVar3.b(j3, sb.toString());
        } catch (Exception e2) {
            com.qiniu.pili.droid.shortvideo.f.e eVar4 = com.qiniu.pili.droid.shortvideo.f.e.h;
            String j4 = j();
            eVar4.e(j4, "dequeueOutputBuffer failed: " + e2.getMessage());
            this.f = true;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!n()) {
            com.qiniu.pili.droid.shortvideo.f.e.h.e(j(), "encoder start failed");
            return;
        }
        while (true) {
            if ((!m() || f()) && !this.f && !this.i) {
                k();
            }
        }
        o();
    }
}
