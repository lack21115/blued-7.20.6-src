package android.preference;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.preference.VolumePreference;
import android.provider.Settings;
import android.util.Log;
import android.widget.SeekBar;

/* loaded from: source-9557208-dex2jar.jar:android/preference/SeekBarVolumizer.class */
public class SeekBarVolumizer implements SeekBar.OnSeekBarChangeListener, Handler.Callback {
    private static final int CHECK_RINGTONE_PLAYBACK_DELAY_MS = 1000;
    private static final int MSG_INIT_SAMPLE = 3;
    private static final int MSG_SET_STREAM_VOLUME = 0;
    private static final int MSG_START_SAMPLE = 1;
    private static final int MSG_STOP_SAMPLE = 2;
    private static final String TAG = "SeekBarVolumizer";
    private boolean mAffectedByRingerMode;
    private final AudioManager mAudioManager;
    private final Callback mCallback;
    private final Context mContext;
    private final Uri mDefaultUri;
    private Handler mHandler;
    private final int mMaxStreamVolume;
    private boolean mMuted;
    private boolean mNotificationOrRing;
    private int mOriginalStreamVolume;
    private int mRingerMode;
    private Ringtone mRingtone;
    private SeekBar mSeekBar;
    private final int mStreamType;
    private final boolean mVoiceCapable;
    private Observer mVolumeObserver;
    private final H mUiHandler = new H();
    private final Receiver mReceiver = new Receiver();
    private int mLastProgress = -1;
    private int mVolumeBeforeMute = -1;

    /* loaded from: source-9557208-dex2jar.jar:android/preference/SeekBarVolumizer$Callback.class */
    public interface Callback {
        void onMuted(boolean z);

        void onProgressChanged(SeekBar seekBar, int i, boolean z);

        void onSampleStarting(SeekBarVolumizer seekBarVolumizer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/preference/SeekBarVolumizer$H.class */
    public final class H extends Handler {
        private static final int UPDATE_SLIDER = 1;

        private H() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z = true;
            if (message.what != 1 || SeekBarVolumizer.this.mSeekBar == null) {
                return;
            }
            SeekBarVolumizer.this.mLastProgress = message.arg1;
            if (message.arg2 == 0) {
                z = false;
            }
            if (z != SeekBarVolumizer.this.mMuted) {
                SeekBarVolumizer.this.mMuted = z;
                if (SeekBarVolumizer.this.mCallback != null) {
                    SeekBarVolumizer.this.mCallback.onMuted(SeekBarVolumizer.this.mMuted);
                }
            }
            SeekBarVolumizer.this.updateSeekBar();
        }

        public void postUpdateSlider(int i, boolean z) {
            obtainMessage(1, i, z ? 1 : 0).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/preference/SeekBarVolumizer$Observer.class */
    public final class Observer extends ContentObserver {
        public Observer(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            SeekBarVolumizer.this.updateSlider();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/preference/SeekBarVolumizer$Receiver.class */
    public final class Receiver extends BroadcastReceiver {
        private boolean mListening;

        private Receiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (!"android.media.VOLUME_CHANGED_ACTION".equals(action)) {
                if (AudioManager.INTERNAL_RINGER_MODE_CHANGED_ACTION.equals(action)) {
                    if (SeekBarVolumizer.this.mNotificationOrRing) {
                        SeekBarVolumizer.this.mRingerMode = SeekBarVolumizer.this.mAudioManager.getRingerModeInternal();
                    }
                    if (SeekBarVolumizer.this.mAffectedByRingerMode) {
                        SeekBarVolumizer.this.updateSlider();
                        return;
                    }
                    return;
                }
                return;
            }
            int intExtra = intent.getIntExtra(AudioManager.EXTRA_VOLUME_STREAM_TYPE, -1);
            int intExtra2 = intent.getIntExtra(AudioManager.EXTRA_VOLUME_STREAM_VALUE, -1);
            boolean isNotificationOrRing = (SeekBarVolumizer.this.mNotificationOrRing && SeekBarVolumizer.this.isNotificationStreamLinked()) ? SeekBarVolumizer.this.isNotificationOrRing(intExtra) : intExtra == SeekBarVolumizer.this.mStreamType;
            if (SeekBarVolumizer.this.mSeekBar == null || !isNotificationOrRing || intExtra2 == -1) {
                return;
            }
            SeekBarVolumizer.this.mUiHandler.postUpdateSlider(intExtra2, SeekBarVolumizer.this.mAudioManager.isStreamMute(SeekBarVolumizer.this.mStreamType));
        }

        public void setListening(boolean z) {
            if (this.mListening == z) {
                return;
            }
            this.mListening = z;
            if (!z) {
                SeekBarVolumizer.this.mContext.unregisterReceiver(this);
                return;
            }
            IntentFilter intentFilter = new IntentFilter("android.media.VOLUME_CHANGED_ACTION");
            intentFilter.addAction(AudioManager.INTERNAL_RINGER_MODE_CHANGED_ACTION);
            SeekBarVolumizer.this.mContext.registerReceiver(this, intentFilter);
        }
    }

    public SeekBarVolumizer(Context context, int i, Uri uri, Callback callback) {
        this.mContext = context;
        this.mAudioManager = (AudioManager) context.getSystemService("audio");
        this.mStreamType = i;
        this.mAffectedByRingerMode = this.mAudioManager.isStreamAffectedByRingerMode(this.mStreamType);
        this.mNotificationOrRing = isNotificationOrRing(this.mStreamType);
        if (this.mNotificationOrRing) {
            this.mRingerMode = this.mAudioManager.getRingerModeInternal();
        }
        this.mMaxStreamVolume = this.mAudioManager.getStreamMaxVolume(this.mStreamType);
        this.mVoiceCapable = context.getResources().getBoolean(17956958);
        this.mCallback = callback;
        this.mOriginalStreamVolume = this.mAudioManager.getStreamVolume(this.mStreamType);
        this.mMuted = this.mAudioManager.isStreamMute(this.mStreamType);
        if (this.mCallback != null) {
            this.mCallback.onMuted(this.mMuted);
        }
        this.mDefaultUri = uri == null ? this.mStreamType == 2 ? Settings.System.DEFAULT_RINGTONE_URI : this.mStreamType == 5 ? Settings.System.DEFAULT_NOTIFICATION_URI : Settings.System.DEFAULT_ALARM_ALERT_URI : uri;
    }

    private boolean enableSeekBar() {
        return (this.mStreamType == 5 && isNotificationStreamLinked()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNotificationOrRing(int i) {
        return i == 2 || i == 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNotificationStreamLinked() {
        return this.mVoiceCapable && Settings.Secure.getInt(this.mContext.getContentResolver(), Settings.Secure.VOLUME_LINK_NOTIFICATION, 1) == 1;
    }

    private void onInitSample() {
        this.mRingtone = RingtoneManager.getRingtone(this.mContext, this.mDefaultUri);
        if (this.mRingtone != null) {
            this.mRingtone.setStreamType(this.mStreamType);
        }
    }

    private void onStartSample() {
        if (isSamplePlaying()) {
            return;
        }
        if (this.mCallback != null) {
            this.mCallback.onSampleStarting(this);
        }
        if (this.mRingtone != null) {
            try {
                this.mRingtone.play();
            } catch (Throwable th) {
                Log.w(TAG, "Error playing ringtone, stream " + this.mStreamType, th);
            }
        }
    }

    private void onStopSample() {
        if (this.mRingtone != null) {
            this.mRingtone.stop();
        }
    }

    private void postSetVolume(int i) {
        if (this.mHandler == null) {
            return;
        }
        this.mLastProgress = i;
        this.mHandler.removeMessages(0);
        this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
    }

    private void postStartSample() {
        if (this.mHandler == null) {
            return;
        }
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), isSamplePlaying() ? 1000L : 0L);
    }

    private void postStopSample() {
        if (this.mHandler == null) {
            return;
        }
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSlider() {
        if (this.mSeekBar == null || this.mAudioManager == null) {
            return;
        }
        this.mUiHandler.postUpdateSlider(this.mAudioManager.getStreamVolume(this.mStreamType), this.mAudioManager.isStreamMute(this.mStreamType));
    }

    public void changeVolumeBy(int i) {
        this.mSeekBar.incrementProgressBy(i);
        postSetVolume(this.mSeekBar.getProgress());
        postStartSample();
        this.mVolumeBeforeMute = -1;
    }

    public SeekBar getSeekBar() {
        return this.mSeekBar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.mAudioManager.setStreamVolume(this.mStreamType, this.mLastProgress, 1024);
                return true;
            case 1:
                onStartSample();
                return true;
            case 2:
                onStopSample();
                return true;
            case 3:
                onInitSample();
                return true;
            default:
                Log.e(TAG, "invalid SeekBarVolumizer message: " + message.what);
                return true;
        }
    }

    public boolean isSamplePlaying() {
        return this.mRingtone != null && this.mRingtone.isPlaying();
    }

    public void muteVolume() {
        if (this.mVolumeBeforeMute != -1) {
            this.mSeekBar.setProgress(this.mVolumeBeforeMute);
            postSetVolume(this.mVolumeBeforeMute);
            postStartSample();
            this.mVolumeBeforeMute = -1;
            return;
        }
        this.mVolumeBeforeMute = this.mSeekBar.getProgress();
        this.mSeekBar.setProgress(0);
        postStopSample();
        postSetVolume(0);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z && enableSeekBar()) {
            postSetVolume(i);
        }
        if (this.mCallback != null) {
            this.mCallback.onProgressChanged(seekBar, i, z);
        }
    }

    public void onRestoreInstanceState(VolumePreference.VolumeStore volumeStore) {
        if (volumeStore.volume != -1) {
            this.mOriginalStreamVolume = volumeStore.originalVolume;
            this.mLastProgress = volumeStore.volume;
            postSetVolume(this.mLastProgress);
        }
    }

    public void onSaveInstanceState(VolumePreference.VolumeStore volumeStore) {
        if (this.mLastProgress >= 0) {
            volumeStore.volume = this.mLastProgress;
            volumeStore.originalVolume = this.mOriginalStreamVolume;
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        postStartSample();
    }

    public void revertVolume() {
        this.mAudioManager.setStreamVolume(this.mStreamType, this.mOriginalStreamVolume, 0);
    }

    public void setSeekBar(SeekBar seekBar) {
        if (this.mSeekBar != null) {
            this.mSeekBar.setOnSeekBarChangeListener(null);
        }
        this.mSeekBar = seekBar;
        this.mSeekBar.setOnSeekBarChangeListener(null);
        this.mSeekBar.setMax(this.mMaxStreamVolume);
        updateSeekBar();
        this.mSeekBar.setOnSeekBarChangeListener(this);
    }

    public void start() {
        if (this.mHandler != null) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("SeekBarVolumizer.CallbackHandler");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this);
        this.mHandler.sendEmptyMessage(3);
        this.mVolumeObserver = new Observer(this.mHandler);
        this.mContext.getContentResolver().registerContentObserver(Settings.System.getUriFor(Settings.System.VOLUME_SETTINGS[this.mStreamType]), false, this.mVolumeObserver);
        this.mReceiver.setListening(true);
    }

    public void startSample() {
        postStartSample();
    }

    public void stop() {
        if (this.mHandler == null) {
            return;
        }
        postStopSample();
        this.mContext.getContentResolver().unregisterContentObserver(this.mVolumeObserver);
        this.mReceiver.setListening(false);
        this.mSeekBar.setOnSeekBarChangeListener(null);
        this.mHandler.getLooper().quitSafely();
        this.mHandler = null;
        this.mVolumeObserver = null;
    }

    public void stopSample() {
        postStopSample();
    }

    protected void updateSeekBar() {
        if (this.mNotificationOrRing && this.mRingerMode == 1) {
            this.mSeekBar.setEnabled(enableSeekBar());
            this.mSeekBar.setProgress(0);
        } else if (this.mMuted) {
            this.mSeekBar.setEnabled(false);
            this.mSeekBar.setProgress(0);
        } else {
            this.mSeekBar.setEnabled(enableSeekBar());
            this.mSeekBar.setProgress(this.mLastProgress > -1 ? this.mLastProgress : this.mOriginalStreamVolume);
        }
    }
}
