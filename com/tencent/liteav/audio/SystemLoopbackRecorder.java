package com.tencent.liteav.audio;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioPlaybackCaptureConfiguration;
import android.media.AudioRecord;
import android.media.projection.MediaProjection;
import android.os.Process;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

@JNINamespace("liteav::audio")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/SystemLoopbackRecorder.class */
public class SystemLoopbackRecorder {
    private static final String TAG = "SystemLoopbackRecorder";
    private static final Object mLock = new Object();
    private static final List<SystemLoopbackRecorder> sListeners = new LinkedList();
    private volatile long mNativeSystemLoopbackRecorder;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/SystemLoopbackRecorder$Recorder.class */
    static class Recorder {

        /* renamed from: a  reason: collision with root package name */
        private AudioRecord f22530a;
        private AudioManager b;

        public Recorder() {
            Context applicationContext = ContextUtils.getApplicationContext();
            ContextUtils.getApplicationContext();
            this.b = (AudioManager) applicationContext.getSystemService("audio");
        }

        private static AudioRecord a(MediaProjection mediaProjection, int i, int i2, int i3) {
            AudioPlaybackCaptureConfiguration.Builder builder = new AudioPlaybackCaptureConfiguration.Builder(mediaProjection);
            builder.addMatchingUsage(1);
            builder.addMatchingUsage(14);
            AudioPlaybackCaptureConfiguration build = builder.build();
            if (build == null) {
                return null;
            }
            int i4 = i2 == 1 ? 16 : 12;
            AudioFormat build2 = new AudioFormat.Builder().setEncoding(2).setSampleRate(i).setChannelMask(i4).build();
            int minBufferSize = AudioRecord.getMinBufferSize(i, i4, 2);
            AudioRecord audioRecord = null;
            int i5 = 1;
            while (true) {
                int i6 = i5;
                if (i6 > 2 || audioRecord != null) {
                    break;
                }
                int i7 = minBufferSize * i6;
                if (i7 >= i3 * 4 || i6 >= 2) {
                    audioRecord = new AudioRecord.Builder().setAudioFormat(build2).setBufferSizeInBytes(i7).setAudioPlaybackCaptureConfig(build).build();
                    if (audioRecord.getState() != 1) {
                        Log.e(SystemLoopbackRecorder.TAG, "Audio record state error", new Object[0]);
                        a(audioRecord);
                        audioRecord = null;
                    } else {
                        audioRecord.startRecording();
                        Log.i(SystemLoopbackRecorder.TAG, "Create audio record success", new Object[0]);
                    }
                }
                i5 = i6 + 1;
            }
            return audioRecord;
        }

        private void a(int i) {
            try {
                if (this.b != null) {
                    this.b.setMode(i);
                }
            } catch (Throwable th) {
                Log.e(SystemLoopbackRecorder.TAG, "Set audio mode exception " + th.getMessage(), new Object[0]);
            }
        }

        private static void a(AudioRecord audioRecord) {
            if (audioRecord == null) {
                return;
            }
            try {
                if (audioRecord.getRecordingState() == 3) {
                    audioRecord.stop();
                }
                audioRecord.release();
            } catch (Throwable th) {
                Log.e(SystemLoopbackRecorder.TAG, "Destroy AudioRecord failed." + th.getMessage(), new Object[0]);
            }
        }

        public int read(ByteBuffer byteBuffer, int i) {
            if (this.f22530a == null) {
                return -1;
            }
            byteBuffer.position(0);
            int read = this.f22530a.read(byteBuffer, i);
            if (read <= 0) {
                Log.e(SystemLoopbackRecorder.TAG, "Read failed ".concat(String.valueOf(read)), new Object[0]);
                return -1;
            }
            return read;
        }

        public int startRecording(MediaProjection mediaProjection, int i, int i2, int i3) {
            try {
                if (this.b != null) {
                    this.b.setAllowedCapturePolicy(3);
                }
            } catch (Throwable th) {
                Log.e(SystemLoopbackRecorder.TAG, "ForbidCaptureAudioFromCurrentApp error " + th.getMessage(), new Object[0]);
            }
            AudioManager audioManager = this.b;
            int mode = audioManager != null ? audioManager.getMode() : 0;
            a(0);
            this.f22530a = a(mediaProjection, i, i2, i3);
            a(mode);
            if (this.f22530a == null) {
                return -1;
            }
            Process.setThreadPriority(-19);
            return 0;
        }

        public void stopRecording() {
            a(this.f22530a);
            this.f22530a = null;
        }
    }

    public SystemLoopbackRecorder(long j) {
        this.mNativeSystemLoopbackRecorder = j;
    }

    private static native void nativeSetMediaProjectionSession(long j, MediaProjection mediaProjection);

    public static void notifyMediaProjectionState(MediaProjection mediaProjection) {
        StringBuilder sb = new StringBuilder("Received MediaProjection state ");
        sb.append(mediaProjection != null);
        Log.i(TAG, sb.toString(), new Object[0]);
        synchronized (mLock) {
            for (SystemLoopbackRecorder systemLoopbackRecorder : sListeners) {
                systemLoopbackRecorder.setMediaProjectionSession(mediaProjection);
            }
        }
    }

    public void registerMediaProjectionListener() {
        synchronized (mLock) {
            sListeners.add(this);
        }
    }

    public void setMediaProjectionSession(MediaProjection mediaProjection) {
        if (this.mNativeSystemLoopbackRecorder != 0) {
            nativeSetMediaProjectionSession(this.mNativeSystemLoopbackRecorder, mediaProjection);
        }
    }

    public void unregisterMediaProjectionListener() {
        synchronized (mLock) {
            sListeners.remove(this);
        }
    }
}
