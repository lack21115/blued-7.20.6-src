package android.speech.tts;

import android.media.AudioFormat;
import android.media.AudioTrack;
import android.speech.tts.TextToSpeechService;
import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/speech/tts/BlockingAudioTrack.class */
public class BlockingAudioTrack {
    private static final boolean DBG = false;
    private static final long MAX_PROGRESS_WAIT_MS = 2500;
    private static final long MAX_SLEEP_TIME_MS = 2500;
    private static final int MIN_AUDIO_BUFFER_SIZE = 8192;
    private static final long MIN_SLEEP_TIME_MS = 20;
    private static final String TAG = "TTS.BlockingAudioTrack";
    private final int mAudioFormat;
    private final TextToSpeechService.AudioOutputParams mAudioParams;
    private final int mBytesPerFrame;
    private int mBytesWritten;
    private final int mChannelCount;
    private final int mSampleRateInHz;
    private int mSessionId;
    private Object mAudioTrackLock = new Object();
    private boolean mIsShortUtterance = false;
    private int mAudioBufferSize = 0;
    private AudioTrack mAudioTrack = null;
    private volatile boolean mStopped = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BlockingAudioTrack(TextToSpeechService.AudioOutputParams audioOutputParams, int i, int i2, int i3) {
        this.mBytesWritten = 0;
        this.mAudioParams = audioOutputParams;
        this.mSampleRateInHz = i;
        this.mAudioFormat = i2;
        this.mChannelCount = i3;
        this.mBytesPerFrame = AudioFormat.getBytesPerSample(this.mAudioFormat) * this.mChannelCount;
        this.mBytesWritten = 0;
    }

    private void blockUntilCompletion(AudioTrack audioTrack) {
        int i = this.mBytesWritten / this.mBytesPerFrame;
        int i2 = -1;
        long j = 0;
        while (true) {
            int playbackHeadPosition = audioTrack.getPlaybackHeadPosition();
            if (playbackHeadPosition >= i || audioTrack.getPlayState() != 3 || this.mStopped) {
                return;
            }
            long clip = clip(((i - playbackHeadPosition) * 1000) / audioTrack.getSampleRate(), 20L, 2500L);
            if (playbackHeadPosition == i2) {
                long j2 = j + clip;
                j = j2;
                if (j2 > 2500) {
                    Log.w(TAG, "Waited unsuccessfully for 2500ms for AudioTrack to make progress, Aborting");
                    return;
                }
            } else {
                j = 0;
            }
            i2 = playbackHeadPosition;
            try {
                Thread.sleep(clip);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    private void blockUntilDone(AudioTrack audioTrack) {
        if (this.mBytesWritten <= 0) {
            return;
        }
        if (this.mIsShortUtterance) {
            blockUntilEstimatedCompletion();
        } else {
            blockUntilCompletion(audioTrack);
        }
    }

    private void blockUntilEstimatedCompletion() {
        try {
            Thread.sleep(((this.mBytesWritten / this.mBytesPerFrame) * 1000) / this.mSampleRateInHz);
        } catch (InterruptedException e) {
        }
    }

    private static final float clip(float f, float f2, float f3) {
        return f < f2 ? f2 : f < f3 ? f : f3;
    }

    private static final long clip(long j, long j2, long j3) {
        return j < j2 ? j2 : j < j3 ? j : j3;
    }

    private AudioTrack createStreamingAudioTrack() {
        int channelConfig = getChannelConfig(this.mChannelCount);
        int max = Math.max(8192, AudioTrack.getMinBufferSize(this.mSampleRateInHz, channelConfig, this.mAudioFormat));
        AudioTrack audioTrack = new AudioTrack(this.mAudioParams.mAudioAttributes, new AudioFormat.Builder().setChannelMask(channelConfig).setEncoding(this.mAudioFormat).setSampleRate(this.mSampleRateInHz).build(), max, 1, this.mAudioParams.mSessionId);
        if (audioTrack.getState() != 1) {
            Log.w(TAG, "Unable to create audio track.");
            audioTrack.release();
            return null;
        }
        this.mAudioBufferSize = max;
        setupVolume(audioTrack, this.mAudioParams.mVolume, this.mAudioParams.mPan);
        return audioTrack;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getChannelConfig(int i) {
        if (i == 1) {
            return 4;
        }
        return i == 2 ? 12 : 0;
    }

    private static void setupVolume(AudioTrack audioTrack, float f, float f2) {
        float f3;
        float f4;
        float clip = clip(f, 0.0f, 1.0f);
        float clip2 = clip(f2, -1.0f, 1.0f);
        if (clip2 > 0.0f) {
            f3 = clip * (1.0f - clip2);
            f4 = clip;
        } else {
            f3 = clip;
            f4 = clip;
            if (clip2 < 0.0f) {
                f4 = clip * (1.0f + clip2);
                f3 = clip;
            }
        }
        if (audioTrack.setStereoVolume(f3, f4) != 0) {
            Log.e(TAG, "Failed to set volume");
        }
    }

    private static int writeToAudioTrack(AudioTrack audioTrack, byte[] bArr) {
        int i;
        int write;
        if (audioTrack.getPlayState() != 3) {
            audioTrack.play();
        }
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= bArr.length || (write = audioTrack.write(bArr, i, bArr.length)) <= 0) {
                break;
            }
            i2 = i + write;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getAudioLengthMs(int i) {
        return ((i / this.mBytesPerFrame) * 1000) / this.mSampleRateInHz;
    }

    public boolean init() {
        AudioTrack createStreamingAudioTrack = createStreamingAudioTrack();
        synchronized (this.mAudioTrackLock) {
            this.mAudioTrack = createStreamingAudioTrack;
        }
        return createStreamingAudioTrack != null;
    }

    public void stop() {
        synchronized (this.mAudioTrackLock) {
            if (this.mAudioTrack != null) {
                this.mAudioTrack.stop();
            }
            this.mStopped = true;
        }
    }

    public void waitAndRelease() {
        AudioTrack audioTrack;
        synchronized (this.mAudioTrackLock) {
            audioTrack = this.mAudioTrack;
        }
        if (audioTrack == null) {
            return;
        }
        if (this.mBytesWritten < this.mAudioBufferSize && !this.mStopped) {
            this.mIsShortUtterance = true;
            audioTrack.stop();
        }
        if (!this.mStopped) {
            blockUntilDone(this.mAudioTrack);
        }
        synchronized (this.mAudioTrackLock) {
            this.mAudioTrack = null;
        }
        audioTrack.release();
    }

    public int write(byte[] bArr) {
        AudioTrack audioTrack;
        synchronized (this.mAudioTrackLock) {
            audioTrack = this.mAudioTrack;
        }
        if (audioTrack == null || this.mStopped) {
            return -1;
        }
        int writeToAudioTrack = writeToAudioTrack(audioTrack, bArr);
        this.mBytesWritten += writeToAudioTrack;
        return writeToAudioTrack;
    }
}
