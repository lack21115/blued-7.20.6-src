package android.speech.tts;

import android.media.AudioFormat;
import android.speech.tts.TextToSpeechService;
import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;

/* loaded from: source-9557208-dex2jar.jar:android/speech/tts/FileSynthesisCallback.class */
class FileSynthesisCallback extends AbstractSynthesisCallback {
    private static final boolean DBG = false;
    private static final int MAX_AUDIO_BUFFER_SIZE = 8192;
    private static final String TAG = "FileSynthesisRequest";
    private static final short WAV_FORMAT_PCM = 1;
    private static final int WAV_HEADER_LENGTH = 44;
    private int mAudioFormat;
    private final Object mCallerIdentity;
    private int mChannelCount;
    private final TextToSpeechService.UtteranceProgressDispatcher mDispatcher;
    private boolean mDone;
    private FileChannel mFileChannel;
    private int mSampleRateInHz;
    private boolean mStarted;
    private final Object mStateLock;
    protected int mStatusCode;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileSynthesisCallback(FileChannel fileChannel, TextToSpeechService.UtteranceProgressDispatcher utteranceProgressDispatcher, Object obj, boolean z) {
        super(z);
        this.mStateLock = new Object();
        this.mStarted = false;
        this.mDone = false;
        this.mFileChannel = fileChannel;
        this.mDispatcher = utteranceProgressDispatcher;
        this.mCallerIdentity = obj;
        this.mStatusCode = 0;
    }

    private void cleanUp() {
        closeFile();
    }

    private void closeFile() {
        this.mFileChannel = null;
    }

    private ByteBuffer makeWavHeader(int i, int i2, int i3, int i4) {
        int bytesPerSample = AudioFormat.getBytesPerSample(i2);
        short s = (short) (bytesPerSample * i3);
        short s2 = (short) (bytesPerSample * 8);
        ByteBuffer wrap = ByteBuffer.wrap(new byte[44]);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        wrap.put(new byte[]{82, 73, 70, 70});
        wrap.putInt((i4 + 44) - 8);
        wrap.put(new byte[]{87, 65, 86, 69});
        wrap.put(new byte[]{102, 109, 116, 32});
        wrap.putInt(16);
        wrap.putShort((short) 1);
        wrap.putShort((short) i3);
        wrap.putInt(i);
        wrap.putInt(i * bytesPerSample * i3);
        wrap.putShort(s);
        wrap.putShort(s2);
        wrap.put(new byte[]{100, 97, 116, 97});
        wrap.putInt(i4);
        wrap.flip();
        return wrap;
    }

    @Override // android.speech.tts.SynthesisCallback
    public int audioAvailable(byte[] bArr, int i, int i2) {
        synchronized (this.mStateLock) {
            if (this.mStatusCode == -2) {
                return errorCodeOnStop();
            } else if (this.mStatusCode != 0) {
                return -1;
            } else {
                if (this.mFileChannel == null) {
                    Log.e(TAG, "File not open");
                    this.mStatusCode = -5;
                    return -1;
                } else if (!this.mStarted) {
                    Log.e(TAG, "Start method was not called");
                    return -1;
                } else {
                    FileChannel fileChannel = this.mFileChannel;
                    try {
                        fileChannel.write(ByteBuffer.wrap(bArr, i, i2));
                        return 0;
                    } catch (IOException e) {
                        Log.e(TAG, "Failed to write to output file descriptor", e);
                        synchronized (this.mStateLock) {
                            cleanUp();
                            this.mStatusCode = -5;
                            return -1;
                        }
                    }
                }
            }
        }
    }

    @Override // android.speech.tts.SynthesisCallback
    public int done() {
        synchronized (this.mStateLock) {
            if (this.mDone) {
                Log.w(TAG, "Duplicate call to done()");
                return -1;
            } else if (this.mStatusCode == -2) {
                return errorCodeOnStop();
            } else if (this.mDispatcher != null && this.mStatusCode != 0 && this.mStatusCode != -2) {
                this.mDispatcher.dispatchOnError(this.mStatusCode);
                return -1;
            } else if (this.mFileChannel == null) {
                Log.e(TAG, "File not open");
                return -1;
            } else {
                this.mDone = true;
                FileChannel fileChannel = this.mFileChannel;
                int i = this.mSampleRateInHz;
                int i2 = this.mAudioFormat;
                int i3 = this.mChannelCount;
                try {
                    fileChannel.position(0L);
                    fileChannel.write(makeWavHeader(i, i2, i3, (int) (fileChannel.size() - 44)));
                    synchronized (this.mStateLock) {
                        closeFile();
                        if (this.mDispatcher != null) {
                            this.mDispatcher.dispatchOnSuccess();
                        }
                    }
                    return 0;
                } catch (IOException e) {
                    Log.e(TAG, "Failed to write to output file descriptor", e);
                    synchronized (this.mStateLock) {
                        cleanUp();
                        return -1;
                    }
                }
            }
        }
    }

    @Override // android.speech.tts.SynthesisCallback
    public void error() {
        error(-3);
    }

    @Override // android.speech.tts.SynthesisCallback
    public void error(int i) {
        synchronized (this.mStateLock) {
            if (this.mDone) {
                return;
            }
            cleanUp();
            this.mStatusCode = i;
        }
    }

    @Override // android.speech.tts.SynthesisCallback
    public int getMaxBufferSize() {
        return 8192;
    }

    @Override // android.speech.tts.SynthesisCallback
    public boolean hasFinished() {
        boolean z;
        synchronized (this.mStateLock) {
            z = this.mDone;
        }
        return z;
    }

    @Override // android.speech.tts.SynthesisCallback
    public boolean hasStarted() {
        boolean z;
        synchronized (this.mStateLock) {
            z = this.mStarted;
        }
        return z;
    }

    @Override // android.speech.tts.SynthesisCallback
    public int start(int i, int i2, int i3) {
        synchronized (this.mStateLock) {
            if (this.mStatusCode == -2) {
                return errorCodeOnStop();
            } else if (this.mStatusCode != 0) {
                return -1;
            } else {
                if (this.mStarted) {
                    Log.e(TAG, "Start called twice");
                    return -1;
                }
                this.mStarted = true;
                this.mSampleRateInHz = i;
                this.mAudioFormat = i2;
                this.mChannelCount = i3;
                if (this.mDispatcher != null) {
                    this.mDispatcher.dispatchOnStart();
                }
                FileChannel fileChannel = this.mFileChannel;
                try {
                    fileChannel.write(ByteBuffer.allocate(44));
                    return 0;
                } catch (IOException e) {
                    Log.e(TAG, "Failed to write wav header to output file descriptor", e);
                    synchronized (this.mStateLock) {
                        cleanUp();
                        this.mStatusCode = -5;
                        return -1;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.speech.tts.AbstractSynthesisCallback
    public void stop() {
        synchronized (this.mStateLock) {
            if (this.mDone) {
                return;
            }
            if (this.mStatusCode == -2) {
                return;
            }
            this.mStatusCode = -2;
            cleanUp();
            if (this.mDispatcher != null) {
                this.mDispatcher.dispatchOnStop();
            }
        }
    }
}
