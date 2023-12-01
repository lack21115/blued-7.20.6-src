package com.tencent.liteav.audio;

import android.media.AudioRecord;
import android.os.Process;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import java.nio.ByteBuffer;

@JNINamespace("liteav::audio")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/LiteavAudioRecord.class */
class LiteavAudioRecord {
    private static final String TAG = "LiteavAudioRecord";
    private AudioRecord mAudioRecord;

    private static String audioSourceToString(int i) {
        switch (i) {
            case 0:
                return "DEFAULT";
            case 1:
                return "MIC";
            case 2:
                return "VOICE_UPLINK";
            case 3:
                return "VOICE_DOWNLINK";
            case 4:
                return "VOICE_CALL";
            case 5:
                return "CAMCORDER";
            case 6:
                return "VOICE_RECOGNITION";
            case 7:
                return "VOICE_COMMUNICATION";
            case 8:
            default:
                return "INVALID";
            case 9:
                return "UNPROCESSED";
            case 10:
                return "VOICE_PERFORMANCE";
        }
    }

    private static AudioRecord createStartedAudioRecord(int i, int i2, int i3, int i4) {
        AudioRecord audioRecord;
        try {
            audioRecord = new AudioRecord(i, i2, i3, 2, i4);
            try {
                if (audioRecord.getState() == 1) {
                    audioRecord.startRecording();
                    return audioRecord;
                }
                throw new RuntimeException("AudioRecord is not initialized.");
            } catch (Throwable th) {
                Log.w(TAG, "create AudioRecord failed. source: %s, sampleRate: %d, channelConfig: %d, bufferSize: %d", audioSourceToString(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                destroyAudioRecord(audioRecord);
                return null;
            }
        } catch (Throwable th2) {
            audioRecord = null;
        }
    }

    private static void destroyAudioRecord(AudioRecord audioRecord) {
        if (audioRecord == null) {
            return;
        }
        try {
            if (audioRecord.getRecordingState() == 3) {
                audioRecord.stop();
            }
            audioRecord.release();
        } catch (Exception e) {
            Log.e(TAG, "stop AudioRecord failed.", e);
        }
    }

    public int read(ByteBuffer byteBuffer, int i) {
        if (this.mAudioRecord == null) {
            return -1;
        }
        byteBuffer.position(0);
        int read = this.mAudioRecord.read(byteBuffer, i);
        if (read <= 0) {
            Log.e(TAG, "read failed, %d", Integer.valueOf(read));
            return -1;
        }
        return read;
    }

    public int startRecording(int i, int i2, int i3, int i4) {
        int i5 = i3 == 1 ? 16 : 12;
        int minBufferSize = AudioRecord.getMinBufferSize(i2, i5, 2);
        if (minBufferSize <= 0) {
            Log.e(TAG, "AudioRecord.getMinBufferSize return error: ".concat(String.valueOf(minBufferSize)), new Object[0]);
            return -2;
        }
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= 4 || this.mAudioRecord != null) {
                break;
            }
            int i8 = new int[]{i, 1, 5, 0}[i7];
            int i9 = 1;
            while (true) {
                int i10 = i9;
                if (i10 <= 2 && this.mAudioRecord == null) {
                    int i11 = minBufferSize * i10;
                    if (i11 >= i4 * 4 || i10 >= 2) {
                        this.mAudioRecord = createStartedAudioRecord(i8, i2, i5, i11);
                    }
                    i9 = i10 + 1;
                }
            }
            i6 = i7 + 1;
        }
        if (this.mAudioRecord == null) {
            return -1;
        }
        Process.setThreadPriority(-19);
        return 0;
    }

    public void stopRecording() {
        destroyAudioRecord(this.mAudioRecord);
        this.mAudioRecord = null;
    }
}
