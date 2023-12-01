package a.a.a.a.a.g;

import a.a.a.a.a.e.e;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import com.qiniu.pili.droid.streaming.microphone.OnAudioMixListener;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/g/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public MediaExtractor f1375a;
    public MediaCodec b;

    /* renamed from: c  reason: collision with root package name */
    public MediaFormat f1376c;
    public ByteBuffer d;
    public int e;
    public long f;
    public long g;
    public boolean h = false;
    public boolean i = false;
    public OnAudioMixListener j;

    public int a() {
        MediaCodec mediaCodec = this.b;
        int i = 0;
        int i2 = 0;
        if (mediaCodec != null) {
            ByteBuffer[] outputBuffers = mediaCodec.getOutputBuffers();
            int i3 = 0;
            while (true) {
                i = i3;
                if (i2 >= outputBuffers.length) {
                    break;
                }
                int capacity = outputBuffers[i2].capacity();
                e.j.b("AudioDecoder", "output buffer " + i2 + " position:" + outputBuffers[i2].position() + " limit:" + outputBuffers[i2].limit() + " capacity:" + capacity);
                int i4 = i;
                if (capacity > i) {
                    i4 = capacity;
                }
                i2++;
                i3 = i4;
            }
        }
        e.j.c("AudioDecoder", "max output buffer size " + i);
        return i;
    }

    public void a(long j) {
        this.f1375a.seekTo(j, 0);
    }

    public void a(OnAudioMixListener onAudioMixListener) {
        this.j = onAudioMixListener;
    }

    public boolean a(String str, boolean z) throws IOException {
        this.h = z;
        MediaExtractor mediaExtractor = new MediaExtractor();
        this.f1375a = mediaExtractor;
        mediaExtractor.setDataSource(str);
        MediaFormat i = i();
        this.f1376c = i;
        if (i == null) {
            e eVar = e.j;
            eVar.e("AudioDecoder", "cannot find audio track in " + str);
            return false;
        }
        MediaCodec j = j();
        this.b = j;
        if (j == null) {
            e.j.e("AudioDecoder", "init decoder failed!!!");
            return false;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        this.f = Long.parseLong(mediaMetadataRetriever.extractMetadata(9)) * 1000;
        return true;
    }

    public long b() {
        return this.f;
    }

    public int c() {
        return this.f1376c == null ? -1 : 16;
    }

    public int d() {
        MediaFormat mediaFormat = this.f1376c;
        if (mediaFormat == null) {
            return -1;
        }
        return mediaFormat.getInteger(MediaFormat.KEY_SAMPLE_RATE);
    }

    public int e() {
        MediaFormat mediaFormat = this.f1376c;
        if (mediaFormat == null) {
            return -1;
        }
        return mediaFormat.getInteger(MediaFormat.KEY_CHANNEL_COUNT);
    }

    public ByteBuffer f() {
        while (true) {
            int dequeueInputBuffer = this.b.dequeueInputBuffer(1000L);
            if (dequeueInputBuffer >= 0) {
                int readSampleData = this.f1375a.readSampleData(this.b.getInputBuffers()[dequeueInputBuffer], 0);
                int i = readSampleData;
                if (readSampleData < 0) {
                    i = readSampleData;
                    if (this.h) {
                        this.f1375a.seekTo(0L, 0);
                        i = this.f1375a.readSampleData(this.b.getInputBuffers()[dequeueInputBuffer], 0);
                    }
                }
                if (i < 0) {
                    e.j.c("AudioDecoder", "EOF, no more encoded samples.");
                    this.i = true;
                    return null;
                }
                this.i = false;
                long sampleTime = this.f1375a.getSampleTime();
                if (this.j != null && Math.abs(sampleTime - this.g) > 1000000) {
                    this.j.onProgress(sampleTime, this.f);
                    this.g = sampleTime;
                }
                this.b.queueInputBuffer(dequeueInputBuffer, 0, i, sampleTime, 0);
                this.f1375a.advance();
                e eVar = e.j;
                eVar.b("AudioDecoder", "input: index = " + dequeueInputBuffer + ", sample size = " + i);
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                int dequeueOutputBuffer = this.b.dequeueOutputBuffer(bufferInfo, 1000L);
                if (dequeueOutputBuffer == -3) {
                    e.j.c("AudioDecoder", "output buffers changed");
                } else if (dequeueOutputBuffer == -2) {
                    e.j.c("AudioDecoder", "new format");
                } else if (dequeueOutputBuffer != -1) {
                    ByteBuffer byteBuffer = this.b.getOutputBuffers()[dequeueOutputBuffer];
                    this.d = byteBuffer;
                    byteBuffer.position(bufferInfo.offset);
                    this.d.limit(bufferInfo.offset + bufferInfo.size);
                    this.e = dequeueOutputBuffer;
                    return this.d;
                } else {
                    e.j.c("AudioDecoder", "wait for available output buffer timed out!!!");
                }
            } else {
                e.j.c("AudioDecoder", "wait for available input buffer timeout!!!");
            }
        }
    }

    public void g() {
        this.d.clear();
        if (this.i) {
            return;
        }
        this.b.releaseOutputBuffer(this.e, false);
    }

    public void h() {
        MediaCodec mediaCodec = this.b;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.b.release();
            this.b = null;
        }
        this.f1376c = null;
        MediaExtractor mediaExtractor = this.f1375a;
        if (mediaExtractor != null) {
            mediaExtractor.release();
            this.f1375a = null;
        }
    }

    public final MediaFormat i() {
        int trackCount = this.f1375a.getTrackCount();
        e eVar = e.j;
        eVar.c("AudioDecoder", "tracks count :" + trackCount);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= trackCount) {
                return null;
            }
            MediaFormat trackFormat = this.f1375a.getTrackFormat(i2);
            if (trackFormat.getString(MediaFormat.KEY_MIME).startsWith("audio")) {
                e eVar2 = e.j;
                eVar2.c("AudioDecoder", "selected track:" + i2);
                this.f1375a.selectTrack(i2);
                return trackFormat;
            }
            i = i2 + 1;
        }
    }

    public final MediaCodec j() {
        String string = this.f1376c.getString(MediaFormat.KEY_MIME);
        int integer = this.f1376c.getInteger(MediaFormat.KEY_SAMPLE_RATE);
        int integer2 = this.f1376c.getInteger(MediaFormat.KEY_CHANNEL_COUNT);
        e eVar = e.j;
        eVar.c("AudioDecoder", "mime:" + string + " sampleRate:" + integer + " channels:" + integer2);
        try {
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(string);
            createDecoderByType.configure(this.f1376c, null, null, 0);
            createDecoderByType.start();
            return createDecoderByType;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
