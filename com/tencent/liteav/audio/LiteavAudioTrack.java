package com.tencent.liteav.audio;

import android.media.AudioTrack;
import android.os.Process;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import java.nio.ByteBuffer;

@JNINamespace("liteav::audio")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/LiteavAudioTrack.class */
public class LiteavAudioTrack {
    private static final String TAG = "LiteavAudioTrack";
    private AudioTrack mAudioTrack;
    private byte[] mPlayBuffer;

    private static AudioTrack createStartedAudioTrack(int i, int i2, int i3, int i4) {
        AudioTrack audioTrack;
        try {
            audioTrack = new AudioTrack(i4, i, i2, 2, i3, 1);
            try {
                if (audioTrack.getState() == 1) {
                    audioTrack.play();
                    Log.i(TAG, "create AudioTrack success. sampleRate: %d, channelConfig: %d, bufferSize: %d, streamType: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), streamTypeToString(i4));
                    return audioTrack;
                }
                throw new RuntimeException("AudioTrack is not initialized.");
            } catch (Throwable th) {
                Log.w(TAG, "create AudioTrack failed. sampleRate: %d, channelConfig: %d, bufferSize: %d, streamType: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), streamTypeToString(i4));
                destroyAudioTrack(audioTrack);
                return null;
            }
        } catch (Throwable th2) {
            audioTrack = null;
        }
    }

    private static void destroyAudioTrack(AudioTrack audioTrack) {
        if (audioTrack == null) {
            return;
        }
        try {
            if (audioTrack.getPlayState() == 3) {
                audioTrack.stop();
                audioTrack.flush();
            }
            audioTrack.release();
        } catch (Exception e) {
            Log.e(TAG, "stop AudioTrack failed.", e);
        }
    }

    private static String streamTypeToString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "STREAM_INVALID" : "STREAM_NOTIFICATION" : "STREAM_ALARM" : "STREAM_MUSIC" : "STREAM_RING" : "STREAM_SYSTEM" : "STREAM_VOICE_CALL";
    }

    public int startPlayout(int i, int i2, int i3, int i4) {
        int i5 = i3 == 1 ? 4 : 12;
        int minBufferSize = AudioTrack.getMinBufferSize(i2, i5, 2);
        if (minBufferSize <= 0) {
            Log.e(TAG, "AudioTrack.getMinBufferSize return error: ".concat(String.valueOf(minBufferSize)), new Object[0]);
            return -2;
        }
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= 4 || this.mAudioTrack != null) {
                break;
            }
            int i8 = new int[]{i, 0, 3, 1}[i7];
            int i9 = 1;
            while (true) {
                int i10 = i9;
                if (i10 <= 2 && this.mAudioTrack == null) {
                    int i11 = minBufferSize * i10;
                    if (i11 >= i4 * 4 || i10 >= 2) {
                        this.mAudioTrack = createStartedAudioTrack(i2, i5, i11, i8);
                    }
                    i9 = i10 + 1;
                }
            }
            i6 = i7 + 1;
        }
        if (this.mAudioTrack == null) {
            return -1;
        }
        Process.setThreadPriority(-19);
        return 0;
    }

    public void stopPlayout() {
        destroyAudioTrack(this.mAudioTrack);
        this.mAudioTrack = null;
    }

    public int write(ByteBuffer byteBuffer, int i, int i2) {
        int write;
        if (this.mAudioTrack == null) {
            return -1;
        }
        byteBuffer.position(i);
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 21) {
            write = this.mAudioTrack.write(byteBuffer, i2, 0);
        } else {
            byte[] bArr = this.mPlayBuffer;
            if (bArr == null || bArr.length < i2) {
                this.mPlayBuffer = new byte[i2];
            }
            byteBuffer.get(this.mPlayBuffer, 0, i2);
            write = this.mAudioTrack.write(this.mPlayBuffer, 0, i2);
        }
        if (write <= 0) {
            Log.e(TAG, "write audio data to AudioTrack failed. ".concat(String.valueOf(write)), new Object[0]);
            return -1;
        }
        return write;
    }
}
