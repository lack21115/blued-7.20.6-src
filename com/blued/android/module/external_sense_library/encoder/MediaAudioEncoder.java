package com.blued.android.module.external_sense_library.encoder;

import android.media.AudioRecord;
import android.os.Process;
import android.util.Log;
import java.nio.ByteBuffer;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/encoder/MediaAudioEncoder.class */
public class MediaAudioEncoder extends MediaEncoder {
    private static final int[] k = {1, 0, 5, 7, 6};
    private AudioThread j;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/encoder/MediaAudioEncoder$AudioThread.class */
    class AudioThread extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MediaAudioEncoder f11239a;

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(-19);
            try {
                int minBufferSize = AudioRecord.getMinBufferSize(44100, 16, 2);
                int i = 25600;
                if (25600 < minBufferSize) {
                    i = ((minBufferSize / 1024) + 1) * 1024 * 2;
                }
                int[] iArr = MediaAudioEncoder.k;
                int length = iArr.length;
                AudioRecord audioRecord = null;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= length) {
                        break;
                    }
                    try {
                        audioRecord = new AudioRecord(iArr[i3], 44100, 16, 2, i);
                        if (audioRecord.getState() != 1) {
                            audioRecord = null;
                        }
                    } catch (Exception e) {
                        audioRecord = null;
                    }
                    if (audioRecord != null) {
                        break;
                    }
                    i2 = i3 + 1;
                }
                if (audioRecord == null) {
                    Log.e("MediaAudioEncoder", "failed to initialize AudioRecord");
                    return;
                }
                if (this.f11239a.b) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(1024);
                    audioRecord.startRecording();
                    while (this.f11239a.b && !this.f11239a.f11241c && !this.f11239a.d) {
                        allocateDirect.clear();
                        int read = audioRecord.read(allocateDirect, 1024);
                        if (read > 0) {
                            allocateDirect.position(read);
                            allocateDirect.flip();
                            this.f11239a.a(allocateDirect, read, this.f11239a.f());
                            this.f11239a.c();
                        }
                    }
                    this.f11239a.c();
                    audioRecord.stop();
                }
                audioRecord.release();
            } catch (Exception e2) {
                Log.e("MediaAudioEncoder", "AudioThread#run", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.module.external_sense_library.encoder.MediaEncoder
    public void a() {
        this.j = null;
        super.a();
    }
}
