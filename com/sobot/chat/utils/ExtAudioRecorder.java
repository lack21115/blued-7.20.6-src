package com.sobot.chat.utils;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/ExtAudioRecorder.class */
public class ExtAudioRecorder {
    public static final boolean RECORDING_COMPRESSED = false;
    public static final boolean RECORDING_UNCOMPRESSED = true;
    private static final int TIMER_INTERVAL = 120;
    private static final int[] sampleRates = {44100, 22050, 11025, 8000};
    private int aFormat;
    private int aSource;
    private AudioRecord audioRecorder;
    private short bSamples;
    private byte[] buffer;
    private int bufferSize;
    private int cAmplitude;
    private String filePath;
    private int framePeriod;
    private MediaRecorder mediaRecorder;
    private short nChannels;
    private int payloadSize;
    private boolean rUncompressed;
    private RandomAccessFile randomAccessWriter;
    private int sRate;
    private State state;
    private AudioRecord.OnRecordPositionUpdateListener updateListener = new AudioRecord.OnRecordPositionUpdateListener() { // from class: com.sobot.chat.utils.ExtAudioRecorder.1
        @Override // android.media.AudioRecord.OnRecordPositionUpdateListener
        public void onMarkerReached(AudioRecord audioRecord) {
        }

        @Override // android.media.AudioRecord.OnRecordPositionUpdateListener
        public void onPeriodicNotification(AudioRecord audioRecord) {
            ExtAudioRecorder.this.audioRecorder.read(ExtAudioRecorder.this.buffer, 0, ExtAudioRecorder.this.buffer.length);
            try {
                ExtAudioRecorder.this.randomAccessWriter.write(ExtAudioRecorder.this.buffer);
                ExtAudioRecorder.this.payloadSize += ExtAudioRecorder.this.buffer.length;
                if (ExtAudioRecorder.this.bSamples != 16) {
                    for (int i = 0; i < ExtAudioRecorder.this.buffer.length; i++) {
                        if (ExtAudioRecorder.this.buffer[i] > ExtAudioRecorder.this.cAmplitude) {
                            ExtAudioRecorder.this.cAmplitude = ExtAudioRecorder.this.buffer[i];
                        }
                    }
                    return;
                }
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= ExtAudioRecorder.this.buffer.length / 2) {
                        return;
                    }
                    int i4 = i3 * 2;
                    short s = ExtAudioRecorder.this.getShort(ExtAudioRecorder.this.buffer[i4], ExtAudioRecorder.this.buffer[i4 + 1]);
                    if (s > ExtAudioRecorder.this.cAmplitude) {
                        ExtAudioRecorder.this.cAmplitude = s;
                    }
                    i2 = i3 + 1;
                }
            } catch (IOException e) {
            }
        }
    };

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/ExtAudioRecorder$AudioRecorderListener.class */
    public interface AudioRecorderListener {
        void onHasPermission();

        void onNoPermission();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/ExtAudioRecorder$State.class */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED
    }

    public ExtAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.audioRecorder = null;
        this.mediaRecorder = null;
        this.cAmplitude = 0;
        this.filePath = null;
        try {
            this.rUncompressed = z;
            if (z) {
                if (i4 == 2) {
                    this.bSamples = (short) 16;
                } else {
                    this.bSamples = (short) 8;
                }
                if (i3 == 2) {
                    this.nChannels = (short) 1;
                } else {
                    this.nChannels = (short) 2;
                }
                this.aSource = i;
                this.sRate = i2;
                this.aFormat = i4;
                int i5 = (i2 * 120) / 1000;
                this.framePeriod = i5;
                int i6 = (((i5 * 2) * this.bSamples) * this.nChannels) / 8;
                this.bufferSize = i6;
                if (i6 < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    int minBufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.bufferSize = minBufferSize;
                    this.framePeriod = minBufferSize / (((this.bSamples * 2) * this.nChannels) / 8);
                    String name = ExtAudioRecorder.class.getName();
                    Log.w(name, "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                AudioRecord audioRecord = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                this.audioRecorder = audioRecord;
                if (audioRecord.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
                this.audioRecorder.setRecordPositionUpdateListener(this.updateListener);
                this.audioRecorder.setPositionNotificationPeriod(this.framePeriod);
            } else {
                MediaRecorder mediaRecorder = new MediaRecorder();
                this.mediaRecorder = mediaRecorder;
                mediaRecorder.setAudioSource(1);
                this.mediaRecorder.setOutputFormat(1);
                this.mediaRecorder.setAudioEncoder(1);
            }
            this.cAmplitude = 0;
            this.filePath = null;
            this.state = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.e(ExtAudioRecorder.class.getName(), e.getMessage());
            } else {
                Log.e(ExtAudioRecorder.class.getName(), "Unknown error occured while initializing recording");
            }
            this.state = State.ERROR;
        }
    }

    public static ExtAudioRecorder getInstanse(Boolean bool) {
        ExtAudioRecorder extAudioRecorder;
        boolean z;
        boolean z2;
        if (bool.booleanValue()) {
            return new ExtAudioRecorder(false, 1, sampleRates[3], 2, 2);
        }
        int i = 0;
        do {
            extAudioRecorder = new ExtAudioRecorder(true, 1, sampleRates[3], 2, 2);
            z = true;
            i++;
            z2 = i < sampleRates.length;
            if (extAudioRecorder.getState() == State.INITIALIZING) {
                z = false;
            }
        } while (z & z2);
        return extAudioRecorder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public short getShort(byte b, byte b2) {
        return (short) (b | (b2 << 8));
    }

    public int getMaxAmplitude() {
        if (this.state == State.RECORDING) {
            if (!this.rUncompressed) {
                try {
                    return this.mediaRecorder.getMaxAmplitude();
                } catch (IllegalStateException e) {
                    return 0;
                }
            }
            int i = this.cAmplitude;
            this.cAmplitude = 0;
            return i;
        }
        return 0;
    }

    public State getState() {
        return this.state;
    }

    public void prepare() {
        try {
            if (this.state != State.INITIALIZING) {
                release();
                this.state = State.ERROR;
            } else if (!this.rUncompressed) {
                this.mediaRecorder.prepare();
                this.state = State.READY;
            } else {
                if (!(this.audioRecorder.getState() == 1) || !(this.filePath != null)) {
                    Log.e(ExtAudioRecorder.class.getName(), "prepare() method called on uninitialized recorder");
                    this.state = State.ERROR;
                    return;
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(this.filePath, "rw");
                this.randomAccessWriter = randomAccessFile;
                randomAccessFile.setLength(0L);
                this.randomAccessWriter.writeBytes("RIFF");
                this.randomAccessWriter.writeInt(0);
                this.randomAccessWriter.writeBytes("WAVE");
                this.randomAccessWriter.writeBytes("fmt ");
                this.randomAccessWriter.writeInt(Integer.reverseBytes(16));
                this.randomAccessWriter.writeShort(Short.reverseBytes((short) 1));
                this.randomAccessWriter.writeShort(Short.reverseBytes(this.nChannels));
                this.randomAccessWriter.writeInt(Integer.reverseBytes(this.sRate));
                this.randomAccessWriter.writeInt(Integer.reverseBytes(((this.sRate * this.bSamples) * this.nChannels) / 8));
                this.randomAccessWriter.writeShort(Short.reverseBytes((short) ((this.nChannels * this.bSamples) / 8)));
                this.randomAccessWriter.writeShort(Short.reverseBytes(this.bSamples));
                this.randomAccessWriter.writeBytes("data");
                this.randomAccessWriter.writeInt(0);
                this.buffer = new byte[((this.framePeriod * this.bSamples) / 8) * this.nChannels];
                this.state = State.READY;
            }
        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.e(ExtAudioRecorder.class.getName(), e.getMessage());
            } else {
                Log.e(ExtAudioRecorder.class.getName(), "Unknown error occured in prepare()");
            }
            this.state = State.ERROR;
        }
    }

    public void release() {
        if (this.state == State.RECORDING) {
            stop();
        } else {
            if ((this.state == State.READY) & this.rUncompressed) {
                try {
                    this.randomAccessWriter.close();
                } catch (IOException e) {
                    Log.e(ExtAudioRecorder.class.getName(), "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.rUncompressed) {
            AudioRecord audioRecord = this.audioRecorder;
            if (audioRecord != null) {
                audioRecord.release();
                return;
            }
            return;
        }
        MediaRecorder mediaRecorder = this.mediaRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.release();
        }
    }

    public void reset() {
        try {
            if (this.state != State.ERROR) {
                release();
                this.filePath = null;
                this.cAmplitude = 0;
                if (this.rUncompressed) {
                    this.audioRecorder = new AudioRecord(this.aSource, this.sRate, this.nChannels + 1, this.aFormat, this.bufferSize);
                } else {
                    MediaRecorder mediaRecorder = new MediaRecorder();
                    this.mediaRecorder = mediaRecorder;
                    mediaRecorder.setAudioSource(1);
                    this.mediaRecorder.setOutputFormat(1);
                    this.mediaRecorder.setAudioEncoder(1);
                }
                this.state = State.INITIALIZING;
            }
        } catch (Exception e) {
            Log.e(ExtAudioRecorder.class.getName(), e.getMessage());
            this.state = State.ERROR;
        }
    }

    public void setOutputFile(String str) {
        try {
            if (this.state == State.INITIALIZING) {
                this.filePath = str;
                if (this.rUncompressed) {
                    return;
                }
                this.mediaRecorder.setOutputFile(str);
            }
        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.e(ExtAudioRecorder.class.getName(), e.getMessage());
            } else {
                Log.e(ExtAudioRecorder.class.getName(), "Unknown error occured while setting output path");
            }
            this.state = State.ERROR;
        }
    }

    public void start(AudioRecorderListener audioRecorderListener) {
        if (this.state != State.READY) {
            Log.e(ExtAudioRecorder.class.getName(), "start() called on illegal state");
            this.state = State.ERROR;
            return;
        }
        if (this.rUncompressed) {
            this.payloadSize = 0;
            this.audioRecorder.startRecording();
            AudioRecord audioRecord = this.audioRecorder;
            byte[] bArr = this.buffer;
            int read = audioRecord.read(bArr, 0, bArr.length);
            LogUtils.i("volume----r:" + read);
            if (read > 0) {
                audioRecorderListener.onHasPermission();
            } else {
                this.state = State.RECORDING;
                stop();
                release();
                audioRecorderListener.onNoPermission();
            }
        } else {
            this.mediaRecorder.start();
        }
        this.state = State.RECORDING;
    }

    public void stop() {
        if (this.state != State.RECORDING) {
            Log.e(ExtAudioRecorder.class.getName(), "stop() called on illegal state");
            this.state = State.ERROR;
            return;
        }
        if (this.rUncompressed) {
            this.audioRecorder.stop();
            try {
                this.randomAccessWriter.seek(4L);
                this.randomAccessWriter.writeInt(Integer.reverseBytes(this.payloadSize + 36));
                this.randomAccessWriter.seek(40L);
                this.randomAccessWriter.writeInt(Integer.reverseBytes(this.payloadSize));
                this.randomAccessWriter.close();
            } catch (IOException e) {
                Log.e(ExtAudioRecorder.class.getName(), "I/O exception occured while closing output file");
                this.state = State.ERROR;
            }
        } else {
            this.mediaRecorder.stop();
        }
        this.state = State.STOPPED;
    }
}
