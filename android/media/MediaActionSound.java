package android.media;

import android.media.SoundPool;
import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/media/MediaActionSound.class */
public class MediaActionSound {
    public static final int FOCUS_COMPLETE = 1;
    private static final int NUM_MEDIA_SOUND_STREAMS = 1;
    public static final int SHUTTER_CLICK = 0;
    private static final String[] SOUND_FILES = {"/system/media/audio/ui/camera_click.ogg", "/system/media/audio/ui/camera_focus.ogg", "/system/media/audio/ui/VideoRecord.ogg", "/system/media/audio/ui/VideoRecord.ogg"};
    private static final int SOUND_NOT_LOADED = -1;
    public static final int START_VIDEO_RECORDING = 2;
    public static final int STOP_VIDEO_RECORDING = 3;
    private static final String TAG = "MediaActionSound";
    private int mSoundIdToPlay;
    private int[] mSoundIds;
    private SoundPool.OnLoadCompleteListener mLoadCompleteListener = new SoundPool.OnLoadCompleteListener() { // from class: android.media.MediaActionSound.1
        @Override // android.media.SoundPool.OnLoadCompleteListener
        public void onLoadComplete(SoundPool soundPool, int i, int i2) {
            if (i2 != 0) {
                Log.e(MediaActionSound.TAG, "Unable to load sound for playback (status: " + i2 + ")");
            } else if (MediaActionSound.this.mSoundIdToPlay == i) {
                soundPool.play(i, 1.0f, 1.0f, 0, 0, 1.0f);
                MediaActionSound.this.mSoundIdToPlay = -1;
            }
        }
    };
    private SoundPool mSoundPool = new SoundPool(1, 7, 0);

    public MediaActionSound() {
        this.mSoundPool.setOnLoadCompleteListener(this.mLoadCompleteListener);
        this.mSoundIds = new int[SOUND_FILES.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mSoundIds.length) {
                this.mSoundIdToPlay = -1;
                return;
            } else {
                this.mSoundIds[i2] = -1;
                i = i2 + 1;
            }
        }
    }

    public void load(int i) {
        synchronized (this) {
            if (i >= 0) {
                if (i < SOUND_FILES.length) {
                    if (this.mSoundIds[i] == -1) {
                        this.mSoundIds[i] = this.mSoundPool.load(SOUND_FILES[i], 1);
                    }
                }
            }
            throw new RuntimeException("Unknown sound requested: " + i);
        }
    }

    public void play(int i) {
        synchronized (this) {
            if (i >= 0) {
                if (i < SOUND_FILES.length) {
                    if (this.mSoundIds[i] == -1) {
                        this.mSoundIdToPlay = this.mSoundPool.load(SOUND_FILES[i], 1);
                        this.mSoundIds[i] = this.mSoundIdToPlay;
                    } else {
                        this.mSoundPool.play(this.mSoundIds[i], 1.0f, 1.0f, 0, 0, 1.0f);
                    }
                }
            }
            throw new RuntimeException("Unknown sound requested: " + i);
        }
    }

    public void release() {
        if (this.mSoundPool != null) {
            this.mSoundPool.release();
            this.mSoundPool = null;
        }
    }
}
