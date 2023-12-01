package com.sobot.chat.camera.util;

import android.hardware.Camera;
import android.media.AudioRecord;
import android.util.Log;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/camera/util/CheckPermission.class */
public class CheckPermission {
    public static final int STATE_NO_PERMISSION = -2;
    public static final int STATE_RECORDING = -1;
    public static final int STATE_SUCCESS = 1;

    public static int getRecordState() {
        int minBufferSize = AudioRecord.getMinBufferSize(44100, 16, 2);
        AudioRecord audioRecord = new AudioRecord(0, 44100, 16, 2, minBufferSize * 100);
        short[] sArr = new short[minBufferSize];
        try {
            audioRecord.startRecording();
            if (audioRecord.getRecordingState() != 3) {
                audioRecord.stop();
                audioRecord.release();
                Log.d("CheckAudioPermission", "录音机被占用");
                return -1;
            } else if (audioRecord.read(sArr, 0, minBufferSize) > 0) {
                audioRecord.stop();
                audioRecord.release();
                return 1;
            } else {
                audioRecord.stop();
                audioRecord.release();
                Log.d("CheckAudioPermission", "录音的结果为空");
                return -2;
            }
        } catch (Exception e) {
            audioRecord.release();
            return -2;
        }
    }

    public static boolean isCameraUseable(int i) {
        boolean z;
        synchronized (CheckPermission.class) {
            Camera camera = null;
            try {
                try {
                    Camera open = Camera.open(i);
                    camera = open;
                    open.setParameters(open.getParameters());
                    z = false;
                    if (open != null) {
                        open.release();
                        z = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    z = false;
                    if (camera != null) {
                        camera.release();
                        z = false;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }
}
