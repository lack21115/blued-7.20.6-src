package com.sensetime.stmobile;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;
import com.huawei.openalliance.ad.constant.t;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/STSoundPlay.class */
public class STSoundPlay {
    private static String TAG = "STSoundPlay";
    private static STSoundPlay instance;
    private WeakReference<STMobileEffectNative> effectHandleRef;
    private AudioManager mAudioManager;
    private String mCachedPath;
    private Context mContext;
    private String mCurrentPlaying;
    private MediaPlayer mediaPlayer;
    private final String CACHED_FOLDER = "Audio";
    private HashMap<String, SoundMetaData> mSoundMetaDataMap = new HashMap<>();
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() { // from class: com.sensetime.stmobile.STSoundPlay.1
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            try {
                SoundMetaData soundMetaData = (SoundMetaData) STSoundPlay.this.mSoundMetaDataMap.get(STSoundPlay.this.mCurrentPlaying);
                if (soundMetaData != null) {
                    int i = soundMetaData.loop - 1;
                    soundMetaData.loop = i;
                    if (i > 0) {
                        String str = STSoundPlay.TAG;
                        Log.e(str, "loop " + soundMetaData.loop);
                        STSoundPlay.this.mediaPlayer.start();
                        return;
                    }
                }
                Log.e(STSoundPlay.TAG, "play done");
                STSoundPlay.this.setSoundPlayDone(soundMetaData.name);
                STSoundPlay.this.mediaPlayer.stop();
                STSoundPlay.this.mediaPlayer.reset();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: com.sensetime.stmobile.STSoundPlay.2
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            if (i == -2) {
                Log.e(STSoundPlay.TAG, "AUDIOFOCUS_LOSS_TRANSIENT reset");
                if (STSoundPlay.this.mediaPlayer.isPlaying()) {
                    STSoundPlay.this.mediaPlayer.pause();
                }
            } else if (i != 1) {
                if (i == -1) {
                    Log.e(STSoundPlay.TAG, "AUDIOFOCUS_LOSS reset");
                }
            } else {
                Log.e(STSoundPlay.TAG, "AUDIOFOCUS_GAIN");
                if (STSoundPlay.this.mediaPlayer == null || STSoundPlay.this.mediaPlayer.isPlaying()) {
                    return;
                }
                STSoundPlay.this.mediaPlayer.start();
            }
        }
    };
    private MediaPlayer.OnErrorListener mErrorListener = new MediaPlayer.OnErrorListener() { // from class: com.sensetime.stmobile.STSoundPlay.3
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            String str = STSoundPlay.TAG;
            Log.e(str, "MediaPlayer error: " + i + t.aE + i2);
            return true;
        }
    };
    private PlayControlListener mPlayControlDefaultListener = new PlayControlListener() { // from class: com.sensetime.stmobile.STSoundPlay.4
        @Override // com.sensetime.stmobile.STSoundPlay.PlayControlListener
        public void onSoundLoaded(String str, byte[] bArr) {
            if (str == null) {
                return;
            }
            String str2 = STSoundPlay.TAG;
            Log.e(str2, "onSoundLoaded " + str);
            String saveSoundToFile = STSoundPlay.this.saveSoundToFile(str, bArr);
            if (saveSoundToFile == null) {
                Log.e(STSoundPlay.TAG, "SoundFilePath is null");
                return;
            }
            SoundMetaData soundMetaData = (SoundMetaData) STSoundPlay.this.mSoundMetaDataMap.get(str);
            SoundMetaData soundMetaData2 = soundMetaData;
            if (soundMetaData == null) {
                soundMetaData2 = new SoundMetaData();
            }
            soundMetaData2.cachePath = saveSoundToFile;
            soundMetaData2.name = str;
            STSoundPlay.this.mSoundMetaDataMap.put(str, soundMetaData2);
        }

        @Override // com.sensetime.stmobile.STSoundPlay.PlayControlListener
        public void onSoundPause(String str) {
            String str2 = STSoundPlay.TAG;
            Log.e(str2, "onSoundPause " + str);
            if (!str.equals(STSoundPlay.this.mCurrentPlaying)) {
                Log.e(STSoundPlay.TAG, "No meta-data when stop");
            } else if (STSoundPlay.this.mediaPlayer.isPlaying()) {
                Log.e(STSoundPlay.TAG, "Playing when onStopPlay callback");
                STSoundPlay.this.mediaPlayer.pause();
            }
        }

        @Override // com.sensetime.stmobile.STSoundPlay.PlayControlListener
        public void onSoundResume(String str) {
            String str2 = STSoundPlay.TAG;
            Log.e(str2, "onStopPlay " + str);
            if (str.equals(STSoundPlay.this.mCurrentPlaying)) {
                Log.e(STSoundPlay.TAG, "No meta-data when stop");
                STSoundPlay.this.mediaPlayer.start();
            }
        }

        @Override // com.sensetime.stmobile.STSoundPlay.PlayControlListener
        public void onStartPlay(String str, int i) {
            if (STSoundPlay.this.mediaPlayer == null) {
                return;
            }
            SoundMetaData soundMetaData = (SoundMetaData) STSoundPlay.this.mSoundMetaDataMap.get(str);
            if (soundMetaData == null) {
                Log.e(STSoundPlay.TAG, "No meta-data when start");
                return;
            }
            soundMetaData.loop = i;
            String str2 = STSoundPlay.TAG;
            Log.e(str2, "onStartPlay " + str);
            if (STSoundPlay.this.mediaPlayer.isPlaying()) {
                Log.e(STSoundPlay.TAG, "Stop it before play");
                STSoundPlay sTSoundPlay = STSoundPlay.this;
                sTSoundPlay.setSoundPlayDone(sTSoundPlay.mCurrentPlaying);
                STSoundPlay.this.mediaPlayer.reset();
            }
            try {
                MediaPlayer mediaPlayer = STSoundPlay.this.mediaPlayer;
                mediaPlayer.setDataSource(STSoundPlay.this.mCachedPath + File.separator + str);
                STSoundPlay.this.mediaPlayer.prepare();
            } catch (IOException e) {
                String str3 = STSoundPlay.TAG;
                Log.e(str3, "IOException:" + e.toString());
                e.printStackTrace();
            } catch (IllegalStateException e2) {
                String str4 = STSoundPlay.TAG;
                Log.e(str4, "IllegalStateException:" + e2.toString());
                e2.printStackTrace();
            }
            STSoundPlay.this.mCurrentPlaying = str;
            if (i == 0) {
                STSoundPlay.this.mediaPlayer.setLooping(true);
            }
            STSoundPlay.this.mediaPlayer.start();
        }

        @Override // com.sensetime.stmobile.STSoundPlay.PlayControlListener
        public void onStopPlay(String str) {
            if (STSoundPlay.this.mediaPlayer == null) {
                return;
            }
            String str2 = STSoundPlay.TAG;
            Log.e(str2, "onStopPlay " + str);
            if (((SoundMetaData) STSoundPlay.this.mSoundMetaDataMap.get(str)) == null || !str.equals(STSoundPlay.this.mCurrentPlaying)) {
                Log.e(STSoundPlay.TAG, "No meta-data when stop");
            } else if (STSoundPlay.this.mediaPlayer.isPlaying()) {
                Log.e(STSoundPlay.TAG, "Playing when onStopPlay callback");
                STSoundPlay.this.mediaPlayer.reset();
            }
        }
    };

    /* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/STSoundPlay$PlayControlListener.class */
    public interface PlayControlListener {
        void onSoundLoaded(String str, byte[] bArr);

        void onSoundPause(String str);

        void onSoundResume(String str);

        void onStartPlay(String str, int i);

        void onStopPlay(String str);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/STSoundPlay$SoundMetaData.class */
    static class SoundMetaData {
        String cachePath;
        int loop;
        String name;

        private SoundMetaData() {
        }
    }

    private STSoundPlay(Context context) {
        this.mContext = context.getApplicationContext();
        this.mCachedPath = this.mContext.getExternalCacheDir() + File.separator + "Audio";
        this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
        File file = new File(this.mCachedPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        initMediaPlayer();
    }

    public static STSoundPlay getInstance(Context context) {
        if (instance == null) {
            synchronized (STSoundPlay.class) {
                try {
                    instance = new STSoundPlay(context);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    private void initMediaPlayer() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.mediaPlayer = mediaPlayer;
        mediaPlayer.setOnCompletionListener(this.mCompletionListener);
        this.mediaPlayer.setOnErrorListener(this.mErrorListener);
        this.mediaPlayer.reset();
    }

    private void onSoundLoaded(String str, byte[] bArr) {
        PlayControlListener playControlListener = this.mPlayControlDefaultListener;
        if (playControlListener != null) {
            playControlListener.onSoundLoaded(str, bArr);
        }
    }

    private void onSoundPause(String str) {
        PlayControlListener playControlListener = this.mPlayControlDefaultListener;
        if (playControlListener != null) {
            playControlListener.onSoundPause(str);
        }
    }

    private void onSoundResume(String str) {
        PlayControlListener playControlListener = this.mPlayControlDefaultListener;
        if (playControlListener != null) {
            playControlListener.onSoundResume(str);
        }
    }

    private void onStartPlay(String str, int i) {
        PlayControlListener playControlListener = this.mPlayControlDefaultListener;
        if (playControlListener != null) {
            playControlListener.onStartPlay(str, i);
        }
    }

    private void onStopPlay(String str) {
        PlayControlListener playControlListener = this.mPlayControlDefaultListener;
        if (playControlListener != null) {
            playControlListener.onStopPlay(str);
        }
    }

    private boolean requestFocus() {
        return this.mAudioManager.requestAudioFocus(this.afChangeListener, 3, 2) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String saveSoundToFile(String str, byte[] bArr) {
        File file;
        File file2 = new File(this.mCachedPath);
        if (!(!file2.exists() ? file2.mkdirs() : true)) {
            String str2 = TAG;
            Log.e(str2, this.mCachedPath + " is not exist");
            return null;
        }
        try {
            file = new File(file2.getPath() + File.separator + str);
            FileOutputStream fileOutputStream = new FileOutputStream(file, false);
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            String str3 = TAG;
            Log.e(str3, "write file failed:" + e.toString());
            file = null;
        }
        if (file != null) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public void pauseSound() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        Log.e(TAG, "Playing when pauseSound");
        this.mediaPlayer.pause();
    }

    public void release() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.mediaPlayer = null;
            instance = null;
        }
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(this.afChangeListener);
        }
    }

    public void resumeSound() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    public void setEffectHandle(STMobileEffectNative sTMobileEffectNative) {
        if (this.effectHandleRef == null) {
            this.effectHandleRef = new WeakReference<>(sTMobileEffectNative);
        }
    }

    public void setPlayControlListener(PlayControlListener playControlListener) {
        if (playControlListener != null) {
            this.mPlayControlDefaultListener = playControlListener;
        }
    }

    public void setSoundPlayDone(String str) {
        if (this.effectHandleRef.get() != null) {
            this.effectHandleRef.get().setSoundPlayDone(str);
        }
    }
}
