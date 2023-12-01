package android.media;

import android.app.ActivityThread;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.MediaTimeProvider;
import android.media.SubtitleController;
import android.media.SubtitleTrack;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.alipay.sdk.util.i;
import com.android.internal.app.IAppOpsService;
import com.anythink.expressad.exoplayer.b;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.InetSocketAddress;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;
import libcore.io.IoBridge;
import libcore.io.Libcore;

/* loaded from: source-9557208-dex2jar.jar:android/media/MediaPlayer.class */
public class MediaPlayer implements SubtitleController.Listener {
    public static final boolean APPLY_METADATA_FILTER = true;
    public static final boolean BYPASS_METADATA_FILTER = false;
    private static final String IMEDIA_PLAYER = "android.media.IMediaPlayer";
    private static final int INVOKE_ID_ADD_EXTERNAL_SOURCE = 2;
    private static final int INVOKE_ID_ADD_EXTERNAL_SOURCE_FD = 3;
    private static final int INVOKE_ID_DESELECT_TRACK = 5;
    private static final int INVOKE_ID_GET_SELECTED_TRACK = 7;
    private static final int INVOKE_ID_GET_TRACK_INFO = 1;
    private static final int INVOKE_ID_SELECT_TRACK = 4;
    private static final int INVOKE_ID_SET_VIDEO_SCALE_MODE = 6;
    private static final int KEY_PARAMETER_AUDIO_ATTRIBUTES = 1400;
    private static final int MEDIA_BUFFERING_UPDATE = 3;
    private static final int MEDIA_ERROR = 100;
    public static final int MEDIA_ERROR_IO = -1004;
    public static final int MEDIA_ERROR_MALFORMED = -1007;
    public static final int MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 200;
    public static final int MEDIA_ERROR_SERVER_DIED = 100;
    public static final int MEDIA_ERROR_TIMED_OUT = -110;
    public static final int MEDIA_ERROR_UNKNOWN = 1;
    public static final int MEDIA_ERROR_UNSUPPORTED = -1010;
    private static final int MEDIA_INFO = 200;
    public static final int MEDIA_INFO_BAD_INTERLEAVING = 800;
    public static final int MEDIA_INFO_BUFFERING_END = 702;
    public static final int MEDIA_INFO_BUFFERING_START = 701;
    public static final int MEDIA_INFO_EXTERNAL_METADATA_UPDATE = 803;
    public static final int MEDIA_INFO_METADATA_UPDATE = 802;
    public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
    public static final int MEDIA_INFO_STARTED_AS_NEXT = 2;
    public static final int MEDIA_INFO_SUBTITLE_TIMED_OUT = 902;
    public static final int MEDIA_INFO_TIMED_TEXT_ERROR = 900;
    public static final int MEDIA_INFO_UNKNOWN = 1;
    public static final int MEDIA_INFO_UNSUPPORTED_SUBTITLE = 901;
    public static final int MEDIA_INFO_VIDEO_RENDERING_START = 3;
    public static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;
    public static final String MEDIA_MIMETYPE_TEXT_CEA_608 = "text/cea-608";
    public static final String MEDIA_MIMETYPE_TEXT_SUBRIP = "application/x-subrip";
    public static final String MEDIA_MIMETYPE_TEXT_VTT = "text/vtt";
    private static final int MEDIA_NOP = 0;
    private static final int MEDIA_PAUSED = 7;
    private static final int MEDIA_PLAYBACK_COMPLETE = 2;
    private static final int MEDIA_PREPARED = 1;
    private static final int MEDIA_SEEK_COMPLETE = 4;
    private static final int MEDIA_SET_VIDEO_SIZE = 5;
    private static final int MEDIA_SKIPPED = 9;
    private static final int MEDIA_STARTED = 6;
    private static final int MEDIA_STOPPED = 8;
    private static final int MEDIA_SUBTITLE_DATA = 201;
    private static final int MEDIA_TIMED_TEXT = 99;
    public static final boolean METADATA_ALL = false;
    public static final boolean METADATA_UPDATE_ONLY = true;
    private static final String TAG = "MediaPlayer";
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT = 1;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING = 2;
    private final IAppOpsService mAppOps;
    private EventHandler mEventHandler;
    private SubtitleTrack[] mInbandSubtitleTracks;
    private int mListenerContext;
    private long mNativeContext;
    private long mNativeSurfaceTexture;
    private OnBufferingUpdateListener mOnBufferingUpdateListener;
    private OnCompletionListener mOnCompletionListener;
    private OnErrorListener mOnErrorListener;
    private OnInfoListener mOnInfoListener;
    private OnPreparedListener mOnPreparedListener;
    private OnSeekCompleteListener mOnSeekCompleteListener;
    private OnSubtitleDataListener mOnSubtitleDataListener;
    private OnTimedTextListener mOnTimedTextListener;
    private OnVideoSizeChangedListener mOnVideoSizeChangedListener;
    private Vector<InputStream> mOpenSubtitleSources;
    private Vector<SubtitleTrack> mOutOfBandSubtitleTracks;
    private boolean mScreenOnWhilePlaying;
    private boolean mStayAwake;
    private SubtitleController mSubtitleController;
    private SurfaceHolder mSurfaceHolder;
    private TimeProvider mTimeProvider;
    private PowerManager.WakeLock mWakeLock = null;
    private int mStreamType = Integer.MIN_VALUE;
    private int mUsage = -1;
    private final Object mInbandSubtitleLock = new Object();
    private int mSelectedSubtitleTrackIndex = -1;
    private OnSubtitleDataListener mSubtitleDataListener = new OnSubtitleDataListener() { // from class: android.media.MediaPlayer.1
        @Override // android.media.MediaPlayer.OnSubtitleDataListener
        public void onSubtitleData(MediaPlayer mediaPlayer, SubtitleData subtitleData) {
            SubtitleTrack subtitleTrack;
            int trackIndex = subtitleData.getTrackIndex();
            if (trackIndex < MediaPlayer.this.mInbandSubtitleTracks.length && (subtitleTrack = MediaPlayer.this.mInbandSubtitleTracks[trackIndex]) != null) {
                subtitleTrack.onData(subtitleData);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaPlayer$EventHandler.class */
    public class EventHandler extends Handler {
        private MediaPlayer mMediaPlayer;

        public EventHandler(MediaPlayer mediaPlayer, Looper looper) {
            super(looper);
            this.mMediaPlayer = mediaPlayer;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z = false;
            if (this.mMediaPlayer.mNativeContext == 0) {
                Log.w(MediaPlayer.TAG, "mediaplayer went away with unhandled events");
                return;
            }
            switch (message.what) {
                case 0:
                    return;
                case 1:
                    MediaPlayer.this.scanInternalSubtitleTracks();
                    if (MediaPlayer.this.mOnPreparedListener != null) {
                        MediaPlayer.this.mOnPreparedListener.onPrepared(this.mMediaPlayer);
                        return;
                    }
                    return;
                case 2:
                    if (MediaPlayer.this.mOnCompletionListener != null) {
                        MediaPlayer.this.mOnCompletionListener.onCompletion(this.mMediaPlayer);
                    }
                    MediaPlayer.this.stayAwake(false);
                    return;
                case 3:
                    if (MediaPlayer.this.mOnBufferingUpdateListener != null) {
                        MediaPlayer.this.mOnBufferingUpdateListener.onBufferingUpdate(this.mMediaPlayer, message.arg1);
                        return;
                    }
                    return;
                case 4:
                    if (MediaPlayer.this.mOnSeekCompleteListener != null) {
                        MediaPlayer.this.mOnSeekCompleteListener.onSeekComplete(this.mMediaPlayer);
                        break;
                    }
                    break;
                case 5:
                    if (MediaPlayer.this.mOnVideoSizeChangedListener != null) {
                        MediaPlayer.this.mOnVideoSizeChangedListener.onVideoSizeChanged(this.mMediaPlayer, message.arg1, message.arg2);
                        return;
                    }
                    return;
                case 6:
                case 7:
                    if (MediaPlayer.this.mTimeProvider != null) {
                        TimeProvider timeProvider = MediaPlayer.this.mTimeProvider;
                        if (message.what == 7) {
                            z = true;
                        }
                        timeProvider.onPaused(z);
                        return;
                    }
                    return;
                case 8:
                    if (MediaPlayer.this.mTimeProvider != null) {
                        MediaPlayer.this.mTimeProvider.onStopped();
                        return;
                    }
                    return;
                case 9:
                    break;
                case 99:
                    if (MediaPlayer.this.mOnTimedTextListener != null) {
                        if (message.obj == null) {
                            MediaPlayer.this.mOnTimedTextListener.onTimedText(this.mMediaPlayer, null);
                            return;
                        } else if (message.obj instanceof Parcel) {
                            Parcel parcel = (Parcel) message.obj;
                            TimedText timedText = new TimedText(parcel);
                            parcel.recycle();
                            MediaPlayer.this.mOnTimedTextListener.onTimedText(this.mMediaPlayer, timedText);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 100:
                    Log.e(MediaPlayer.TAG, "Error (" + message.arg1 + "," + message.arg2 + ")");
                    boolean z2 = false;
                    if (MediaPlayer.this.mOnErrorListener != null) {
                        z2 = MediaPlayer.this.mOnErrorListener.onError(this.mMediaPlayer, message.arg1, message.arg2);
                    }
                    if (MediaPlayer.this.mOnCompletionListener != null && !z2) {
                        MediaPlayer.this.mOnCompletionListener.onCompletion(this.mMediaPlayer);
                    }
                    MediaPlayer.this.stayAwake(false);
                    return;
                case 200:
                    switch (message.arg1) {
                        case 700:
                            Log.i(MediaPlayer.TAG, "Info (" + message.arg1 + "," + message.arg2 + ")");
                            break;
                        case 802:
                            MediaPlayer.this.scanInternalSubtitleTracks();
                        case 803:
                            message.arg1 = 802;
                            if (MediaPlayer.this.mSubtitleController != null) {
                                MediaPlayer.this.mSubtitleController.selectDefaultTrack();
                                break;
                            }
                            break;
                    }
                    if (MediaPlayer.this.mOnInfoListener != null) {
                        MediaPlayer.this.mOnInfoListener.onInfo(this.mMediaPlayer, message.arg1, message.arg2);
                        return;
                    }
                    return;
                case 201:
                    if (MediaPlayer.this.mOnSubtitleDataListener == null || !(message.obj instanceof Parcel)) {
                        return;
                    }
                    Parcel parcel2 = (Parcel) message.obj;
                    SubtitleData subtitleData = new SubtitleData(parcel2);
                    parcel2.recycle();
                    MediaPlayer.this.mOnSubtitleDataListener.onSubtitleData(this.mMediaPlayer, subtitleData);
                    return;
                default:
                    Log.e(MediaPlayer.TAG, "Unknown message type " + message.what);
                    return;
            }
            if (MediaPlayer.this.mTimeProvider != null) {
                MediaPlayer.this.mTimeProvider.onSeekComplete(this.mMediaPlayer);
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaPlayer$OnBufferingUpdateListener.class */
    public interface OnBufferingUpdateListener {
        void onBufferingUpdate(MediaPlayer mediaPlayer, int i);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaPlayer$OnCompletionListener.class */
    public interface OnCompletionListener {
        void onCompletion(MediaPlayer mediaPlayer);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaPlayer$OnErrorListener.class */
    public interface OnErrorListener {
        boolean onError(MediaPlayer mediaPlayer, int i, int i2);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaPlayer$OnInfoListener.class */
    public interface OnInfoListener {
        boolean onInfo(MediaPlayer mediaPlayer, int i, int i2);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaPlayer$OnPreparedListener.class */
    public interface OnPreparedListener {
        void onPrepared(MediaPlayer mediaPlayer);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaPlayer$OnSeekCompleteListener.class */
    public interface OnSeekCompleteListener {
        void onSeekComplete(MediaPlayer mediaPlayer);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaPlayer$OnSubtitleDataListener.class */
    public interface OnSubtitleDataListener {
        void onSubtitleData(MediaPlayer mediaPlayer, SubtitleData subtitleData);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaPlayer$OnTimedTextListener.class */
    public interface OnTimedTextListener {
        void onTimedText(MediaPlayer mediaPlayer, TimedText timedText);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaPlayer$OnVideoSizeChangedListener.class */
    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaPlayer$TimeProvider.class */
    public static class TimeProvider implements OnSeekCompleteListener, MediaTimeProvider {
        private static final long MAX_EARLY_CALLBACK_US = 1000;
        private static final long MAX_NS_WITHOUT_POSITION_CHECK = 5000000000L;
        private static final int NOTIFY = 1;
        private static final int NOTIFY_SEEK = 3;
        private static final int NOTIFY_STOP = 2;
        private static final int NOTIFY_TIME = 0;
        private static final int REFRESH_AND_NOTIFY_TIME = 1;
        private static final String TAG = "MTP";
        private static final long TIME_ADJUSTMENT_RATE = 2;
        private Handler mEventHandler;
        private HandlerThread mHandlerThread;
        private long mLastNanoTime;
        private long mLastReportedTime;
        private long mLastTimeUs;
        private MediaTimeProvider.OnMediaTimeListener[] mListeners;
        private MediaPlayer mPlayer;
        private boolean mRefresh;
        private long mTimeAdjustment;
        private long[] mTimes;
        private boolean mPaused = true;
        private boolean mStopped = true;
        private boolean mPausing = false;
        private boolean mSeeking = false;
        public boolean DEBUG = false;

        /* loaded from: source-9557208-dex2jar.jar:android/media/MediaPlayer$TimeProvider$EventHandler.class */
        private class EventHandler extends Handler {
            public EventHandler(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    switch (message.arg1) {
                        case 0:
                            TimeProvider.this.notifyTimedEvent(false);
                            return;
                        case 1:
                            TimeProvider.this.notifyTimedEvent(true);
                            return;
                        case 2:
                            TimeProvider.this.notifyStop();
                            return;
                        case 3:
                            TimeProvider.this.notifySeek();
                            return;
                        default:
                            return;
                    }
                }
            }
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x008d -> B:4:0x0033). Please submit an issue!!! */
        public TimeProvider(MediaPlayer mediaPlayer) {
            this.mLastTimeUs = 0L;
            this.mRefresh = false;
            this.mPlayer = mediaPlayer;
            try {
                getCurrentTimeUs(true, false);
            } catch (IllegalStateException e) {
                this.mRefresh = true;
            }
            Looper myLooper = Looper.myLooper();
            Looper looper = myLooper;
            if (myLooper == null) {
                Looper mainLooper = Looper.getMainLooper();
                looper = mainLooper;
                if (mainLooper == null) {
                    this.mHandlerThread = new HandlerThread("MediaPlayerMTPEventThread", -2);
                    this.mHandlerThread.start();
                    looper = this.mHandlerThread.getLooper();
                }
            }
            this.mEventHandler = new EventHandler(looper);
            this.mListeners = new MediaTimeProvider.OnMediaTimeListener[0];
            this.mTimes = new long[0];
            this.mLastTimeUs = 0L;
            this.mTimeAdjustment = 0L;
        }

        private long getEstimatedTime(long j, boolean z) {
            if (this.mPaused) {
                this.mLastReportedTime = this.mLastTimeUs + this.mTimeAdjustment;
            } else {
                long j2 = (j - this.mLastNanoTime) / 1000;
                this.mLastReportedTime = this.mLastTimeUs + j2;
                if (this.mTimeAdjustment > 0) {
                    long j3 = this.mTimeAdjustment - (j2 / 2);
                    if (j3 <= 0) {
                        this.mTimeAdjustment = 0L;
                    } else {
                        this.mLastReportedTime += j3;
                    }
                }
            }
            return this.mLastReportedTime;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void notifySeek() {
            MediaTimeProvider.OnMediaTimeListener onMediaTimeListener;
            synchronized (this) {
                this.mSeeking = false;
                try {
                    long currentTimeUs = getCurrentTimeUs(true, false);
                    if (this.DEBUG) {
                        Log.d(TAG, "onSeekComplete at " + currentTimeUs);
                    }
                    MediaTimeProvider.OnMediaTimeListener[] onMediaTimeListenerArr = this.mListeners;
                    int length = onMediaTimeListenerArr.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length || (onMediaTimeListener = onMediaTimeListenerArr[i2]) == null) {
                            break;
                        }
                        onMediaTimeListener.onSeek(currentTimeUs);
                        i = i2 + 1;
                    }
                } catch (IllegalStateException e) {
                    if (this.DEBUG) {
                        Log.d(TAG, "onSeekComplete but no player");
                    }
                    this.mPausing = true;
                    notifyTimedEvent(false);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void notifyStop() {
            MediaTimeProvider.OnMediaTimeListener onMediaTimeListener;
            synchronized (this) {
                MediaTimeProvider.OnMediaTimeListener[] onMediaTimeListenerArr = this.mListeners;
                int length = onMediaTimeListenerArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length || (onMediaTimeListener = onMediaTimeListenerArr[i2]) == null) {
                        break;
                    }
                    onMediaTimeListener.onStop();
                    i = i2 + 1;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void notifyTimedEvent(boolean z) {
            long currentTimeUs;
            long j;
            synchronized (this) {
                try {
                    currentTimeUs = getCurrentTimeUs(z, true);
                } catch (IllegalStateException e) {
                    this.mRefresh = true;
                    this.mPausing = true;
                    currentTimeUs = getCurrentTimeUs(z, true);
                }
                long j2 = currentTimeUs;
                if (!this.mSeeking) {
                    if (this.DEBUG) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("notifyTimedEvent(").append(this.mLastTimeUs).append(" -> ").append(currentTimeUs).append(") from {");
                        boolean z2 = true;
                        long[] jArr = this.mTimes;
                        int length = jArr.length;
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= length) {
                                break;
                            }
                            long j3 = jArr[i2];
                            if (j3 != -1) {
                                if (!z2) {
                                    sb.append(", ");
                                }
                                sb.append(j3);
                                z2 = false;
                            }
                            i = i2 + 1;
                        }
                        sb.append(i.d);
                        Log.d(TAG, sb.toString());
                    }
                    Vector vector = new Vector();
                    int i3 = 0;
                    while (i3 < this.mTimes.length && this.mListeners[i3] != null) {
                        if (this.mTimes[i3] <= -1) {
                            j = j2;
                        } else if (this.mTimes[i3] <= 1000 + currentTimeUs) {
                            vector.add(this.mListeners[i3]);
                            if (this.DEBUG) {
                                Log.d(TAG, Environment.MEDIA_REMOVED);
                            }
                            this.mTimes[i3] = -1;
                            j = j2;
                        } else {
                            if (j2 != currentTimeUs) {
                                j = j2;
                                if (this.mTimes[i3] >= j2) {
                                }
                            }
                            j = this.mTimes[i3];
                        }
                        i3++;
                        j2 = j;
                    }
                    if (j2 <= currentTimeUs || this.mPaused) {
                        this.mEventHandler.removeMessages(1);
                    } else {
                        if (this.DEBUG) {
                            Log.d(TAG, "scheduling for " + j2 + " and " + currentTimeUs);
                        }
                        scheduleNotification(0, j2 - currentTimeUs);
                    }
                    Iterator<E> it = vector.iterator();
                    while (it.hasNext()) {
                        ((MediaTimeProvider.OnMediaTimeListener) it.next()).onTimedEvent(currentTimeUs);
                    }
                }
            }
        }

        private int registerListener(MediaTimeProvider.OnMediaTimeListener onMediaTimeListener) {
            int i;
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.mListeners.length || this.mListeners[i] == onMediaTimeListener || this.mListeners[i] == null) {
                    break;
                }
                i2 = i + 1;
            }
            if (i >= this.mListeners.length) {
                MediaTimeProvider.OnMediaTimeListener[] onMediaTimeListenerArr = new MediaTimeProvider.OnMediaTimeListener[i + 1];
                long[] jArr = new long[i + 1];
                System.arraycopy(this.mListeners, 0, onMediaTimeListenerArr, 0, this.mListeners.length);
                System.arraycopy(this.mTimes, 0, jArr, 0, this.mTimes.length);
                this.mListeners = onMediaTimeListenerArr;
                this.mTimes = jArr;
            }
            if (this.mListeners[i] == null) {
                this.mListeners[i] = onMediaTimeListener;
                this.mTimes[i] = -1;
            }
            return i;
        }

        private void scheduleNotification(int i, long j) {
            if (this.mSeeking && (i == 0 || i == 1)) {
                return;
            }
            if (this.DEBUG) {
                Log.v(TAG, "scheduleNotification " + i + " in " + j);
            }
            this.mEventHandler.removeMessages(1);
            this.mEventHandler.sendMessageDelayed(this.mEventHandler.obtainMessage(1, i, 0), (int) (j / 1000));
        }

        @Override // android.media.MediaTimeProvider
        public void cancelNotifications(MediaTimeProvider.OnMediaTimeListener onMediaTimeListener) {
            synchronized (this) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.mListeners.length) {
                        if (this.mListeners[i2] != onMediaTimeListener) {
                            if (this.mListeners[i2] == null) {
                                break;
                            }
                            i = i2 + 1;
                        } else {
                            System.arraycopy(this.mListeners, i2 + 1, this.mListeners, i2, (this.mListeners.length - i2) - 1);
                            System.arraycopy(this.mTimes, i2 + 1, this.mTimes, i2, (this.mTimes.length - i2) - 1);
                            this.mListeners[this.mListeners.length - 1] = null;
                            this.mTimes[this.mTimes.length - 1] = -1;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                scheduleNotification(0, 0L);
            }
        }

        public void close() {
            this.mEventHandler.removeMessages(1);
            if (this.mHandlerThread != null) {
                this.mHandlerThread.quitSafely();
                this.mHandlerThread = null;
            }
        }

        protected void finalize() {
            if (this.mHandlerThread != null) {
                this.mHandlerThread.quitSafely();
            }
        }

        @Override // android.media.MediaTimeProvider
        public long getCurrentTimeUs(boolean z, boolean z2) throws IllegalStateException {
            synchronized (this) {
                if (this.mPaused && !z) {
                    return this.mLastReportedTime;
                }
                long nanoTime = System.nanoTime();
                if (z || nanoTime >= this.mLastNanoTime + MAX_NS_WITHOUT_POSITION_CHECK) {
                    try {
                        this.mLastTimeUs = this.mPlayer.getCurrentPosition() * 1000;
                        this.mPaused = !this.mPlayer.isPlaying();
                        if (this.DEBUG) {
                            Log.v(TAG, (this.mPaused ? "paused" : "playing") + " at " + this.mLastTimeUs);
                        }
                        this.mLastNanoTime = nanoTime;
                        if (!z2 || this.mLastTimeUs >= this.mLastReportedTime) {
                            this.mTimeAdjustment = 0L;
                        } else {
                            this.mTimeAdjustment = this.mLastReportedTime - this.mLastTimeUs;
                            if (this.mTimeAdjustment > 1000000) {
                                this.mStopped = false;
                                this.mSeeking = true;
                                scheduleNotification(3, 0L);
                            }
                        }
                    } catch (IllegalStateException e) {
                        if (this.mPausing) {
                            this.mPausing = false;
                            getEstimatedTime(nanoTime, z2);
                            this.mPaused = true;
                            if (this.DEBUG) {
                                Log.d(TAG, "illegal state, but pausing: estimating at " + this.mLastReportedTime);
                            }
                            return this.mLastReportedTime;
                        }
                        throw e;
                    }
                }
                return getEstimatedTime(nanoTime, z2);
            }
        }

        @Override // android.media.MediaTimeProvider
        public void notifyAt(long j, MediaTimeProvider.OnMediaTimeListener onMediaTimeListener) {
            synchronized (this) {
                if (this.DEBUG) {
                    Log.d(TAG, "notifyAt " + j);
                }
                this.mTimes[registerListener(onMediaTimeListener)] = j;
                scheduleNotification(0, 0L);
            }
        }

        public void onNewPlayer() {
            if (this.mRefresh) {
                synchronized (this) {
                    this.mStopped = false;
                    this.mSeeking = true;
                    scheduleNotification(3, 0L);
                }
            }
        }

        public void onPaused(boolean z) {
            synchronized (this) {
                if (this.DEBUG) {
                    Log.d(TAG, "onPaused: " + z);
                }
                if (this.mStopped) {
                    this.mStopped = false;
                    this.mSeeking = true;
                    scheduleNotification(3, 0L);
                } else {
                    this.mPausing = z;
                    this.mSeeking = false;
                    scheduleNotification(1, 0L);
                }
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            synchronized (this) {
                this.mStopped = false;
                this.mSeeking = true;
                scheduleNotification(3, 0L);
            }
        }

        public void onStopped() {
            synchronized (this) {
                if (this.DEBUG) {
                    Log.d(TAG, "onStopped");
                }
                this.mPaused = true;
                this.mStopped = true;
                this.mSeeking = false;
                scheduleNotification(2, 0L);
            }
        }

        @Override // android.media.MediaTimeProvider
        public void scheduleUpdate(MediaTimeProvider.OnMediaTimeListener onMediaTimeListener) {
            synchronized (this) {
                if (this.DEBUG) {
                    Log.d(TAG, "scheduleUpdate");
                }
                int registerListener = registerListener(onMediaTimeListener);
                if (!this.mStopped) {
                    this.mTimes[registerListener] = 0;
                    scheduleNotification(0, 0L);
                }
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaPlayer$TrackInfo.class */
    public static class TrackInfo implements Parcelable {
        static final Parcelable.Creator<TrackInfo> CREATOR = new Parcelable.Creator<TrackInfo>() { // from class: android.media.MediaPlayer.TrackInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TrackInfo createFromParcel(Parcel parcel) {
                return new TrackInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TrackInfo[] newArray(int i) {
                return new TrackInfo[i];
            }
        };
        public static final int MEDIA_TRACK_TYPE_AUDIO = 2;
        public static final int MEDIA_TRACK_TYPE_SUBTITLE = 4;
        public static final int MEDIA_TRACK_TYPE_TIMEDTEXT = 3;
        public static final int MEDIA_TRACK_TYPE_UNKNOWN = 0;
        public static final int MEDIA_TRACK_TYPE_VIDEO = 1;
        final MediaFormat mFormat;
        final int mTrackType;

        TrackInfo(int i, MediaFormat mediaFormat) {
            this.mTrackType = i;
            this.mFormat = mediaFormat;
        }

        TrackInfo(Parcel parcel) {
            this.mTrackType = parcel.readInt();
            String readString = parcel.readString();
            if (this.mTrackType == 3) {
                this.mFormat = MediaFormat.createSubtitleFormat("application/x-subrip", readString);
            } else if (this.mTrackType != 4) {
                this.mFormat = new MediaFormat();
                this.mFormat.setString("language", readString);
            } else {
                this.mFormat = MediaFormat.createSubtitleFormat(parcel.readString(), readString);
                this.mFormat.setInteger(MediaFormat.KEY_IS_AUTOSELECT, parcel.readInt());
                this.mFormat.setInteger(MediaFormat.KEY_IS_DEFAULT, parcel.readInt());
                this.mFormat.setInteger(MediaFormat.KEY_IS_FORCED_SUBTITLE, parcel.readInt());
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public MediaFormat getFormat() {
            if (this.mTrackType == 3 || this.mTrackType == 4) {
                return this.mFormat;
            }
            return null;
        }

        public String getLanguage() {
            String string = this.mFormat.getString("language");
            String str = string;
            if (string == null) {
                str = b.f7166ar;
            }
            return str;
        }

        public int getTrackType() {
            return this.mTrackType;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append(getClass().getName());
            sb.append('{');
            switch (this.mTrackType) {
                case 1:
                    sb.append("VIDEO");
                    break;
                case 2:
                    sb.append("AUDIO");
                    break;
                case 3:
                    sb.append("TIMEDTEXT");
                    break;
                case 4:
                    sb.append("SUBTITLE");
                    break;
                default:
                    sb.append("UNKNOWN");
                    break;
            }
            sb.append(", " + this.mFormat.toString());
            sb.append(i.d);
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mTrackType);
            parcel.writeString(getLanguage());
            if (this.mTrackType == 4) {
                parcel.writeString(this.mFormat.getString(MediaFormat.KEY_MIME));
                parcel.writeInt(this.mFormat.getInteger(MediaFormat.KEY_IS_AUTOSELECT));
                parcel.writeInt(this.mFormat.getInteger(MediaFormat.KEY_IS_DEFAULT));
                parcel.writeInt(this.mFormat.getInteger(MediaFormat.KEY_IS_FORCED_SUBTITLE));
            }
        }
    }

    static {
        System.loadLibrary("media_jni");
        native_init();
    }

    public MediaPlayer() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.mEventHandler = new EventHandler(this, myLooper);
        } else {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null) {
                this.mEventHandler = new EventHandler(this, mainLooper);
            } else {
                this.mEventHandler = null;
            }
        }
        this.mTimeProvider = new TimeProvider(this);
        this.mOutOfBandSubtitleTracks = new Vector<>();
        this.mOpenSubtitleSources = new Vector<>();
        this.mInbandSubtitleTracks = new SubtitleTrack[0];
        this.mAppOps = IAppOpsService.Stub.asInterface(ServiceManager.getService(Context.APP_OPS_SERVICE));
        native_setup(new WeakReference(this));
    }

    private native int _getAudioStreamType() throws IllegalStateException;

    private native void _pause() throws IllegalStateException;

    private native void _prepare() throws IOException, IllegalStateException;

    private native void _release();

    private native void _reset();

    private native boolean _resume();

    private native void _setAudioStreamType(int i);

    private native void _setAuxEffectSendLevel(float f);

    private native void _setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException, IllegalArgumentException, IllegalStateException;

    private native void _setVideoSurface(Surface surface);

    private native void _setVolume(float f, float f2);

    private native void _start() throws IllegalStateException;

    private native void _stop() throws IllegalStateException;

    private native boolean _suspend();

    private static boolean availableMimeTypeForExternalSource(String str) {
        return "application/x-subrip".equals(str);
    }

    public static MediaPlayer create(Context context, int i) {
        int newAudioSessionId = AudioSystem.newAudioSessionId();
        if (newAudioSessionId <= 0) {
            newAudioSessionId = 0;
        }
        return create(context, i, null, newAudioSessionId);
    }

    public static MediaPlayer create(Context context, int i, AudioAttributes audioAttributes, int i2) {
        try {
            AssetFileDescriptor openRawResourceFd = context.getResources().openRawResourceFd(i);
            if (openRawResourceFd == null) {
                return null;
            }
            MediaPlayer mediaPlayer = new MediaPlayer();
            if (audioAttributes == null) {
                audioAttributes = new AudioAttributes.Builder().build();
            }
            mediaPlayer.setAudioAttributes(audioAttributes);
            mediaPlayer.setAudioSessionId(i2);
            mediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
            openRawResourceFd.close();
            mediaPlayer.prepare();
            return mediaPlayer;
        } catch (IOException e) {
            Log.d(TAG, "create failed:", e);
            return null;
        } catch (IllegalArgumentException e2) {
            Log.d(TAG, "create failed:", e2);
            return null;
        } catch (SecurityException e3) {
            Log.d(TAG, "create failed:", e3);
            return null;
        }
    }

    public static MediaPlayer create(Context context, Uri uri) {
        return create(context, uri, null);
    }

    public static MediaPlayer create(Context context, Uri uri, SurfaceHolder surfaceHolder) {
        int newAudioSessionId = AudioSystem.newAudioSessionId();
        if (newAudioSessionId <= 0) {
            newAudioSessionId = 0;
        }
        return create(context, uri, surfaceHolder, null, newAudioSessionId);
    }

    public static MediaPlayer create(Context context, Uri uri, SurfaceHolder surfaceHolder, AudioAttributes audioAttributes, int i) {
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            if (audioAttributes == null) {
                audioAttributes = new AudioAttributes.Builder().build();
            }
            mediaPlayer.setAudioAttributes(audioAttributes);
            mediaPlayer.setAudioSessionId(i);
            mediaPlayer.setDataSource(context, uri);
            if (surfaceHolder != null) {
                mediaPlayer.setDisplay(surfaceHolder);
            }
            mediaPlayer.prepare();
            return mediaPlayer;
        } catch (IOException e) {
            Log.d(TAG, "create failed:", e);
            return null;
        } catch (IllegalArgumentException e2) {
            Log.d(TAG, "create failed:", e2);
            return null;
        } catch (SecurityException e3) {
            Log.d(TAG, "create failed:", e3);
            return null;
        }
    }

    private int getAudioStreamType() {
        if (this.mStreamType == Integer.MIN_VALUE) {
            this.mStreamType = _getAudioStreamType();
        }
        return this.mStreamType;
    }

    private TrackInfo[] getInbandTrackInfo() throws IllegalStateException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(IMEDIA_PLAYER);
            obtain.writeInt(1);
            invoke(obtain, obtain2);
            return (TrackInfo[]) obtain2.createTypedArray(TrackInfo.CREATOR);
        } finally {
            obtain.recycle();
            obtain2.recycle();
        }
    }

    private boolean isRestricted() {
        try {
            return this.mAppOps.checkAudioOperation(28, this.mUsage != -1 ? this.mUsage : AudioAttributes.usageForLegacyStreamType(getAudioStreamType()), Process.myUid(), ActivityThread.currentPackageName()) != 0;
        } catch (RemoteException e) {
            return false;
        }
    }

    private boolean isVideoScalingModeSupported(int i) {
        return i == 1 || i == 2;
    }

    private native void nativeSetDataSource(IBinder iBinder, String str, String[] strArr, String[] strArr2) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    private final native void native_finalize();

    private final native boolean native_getMetadata(boolean z, boolean z2, Parcel parcel);

    private static final native void native_init();

    private final native int native_invoke(Parcel parcel, Parcel parcel2);

    public static native int native_pullBatteryData(Parcel parcel);

    private final native int native_setMetadataFilter(Parcel parcel);

    private final native int native_setRetransmitEndpoint(String str, int i);

    private final native void native_setup(Object obj);

    private static void postEventFromNative(Object obj, int i, int i2, int i3, Object obj2) {
        MediaPlayer mediaPlayer = (MediaPlayer) ((WeakReference) obj).get();
        if (mediaPlayer == null) {
            return;
        }
        if (i == 200 && i2 == 2) {
            mediaPlayer.start();
        }
        if (mediaPlayer.mEventHandler != null) {
            mediaPlayer.mEventHandler.sendMessage(mediaPlayer.mEventHandler.obtainMessage(i, i2, i3, obj2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scanInternalSubtitleTracks() {
        if (this.mSubtitleController == null) {
            Log.e(TAG, "Should have subtitle controller already set");
            return;
        }
        TrackInfo[] inbandTrackInfo = getInbandTrackInfo();
        synchronized (this.mInbandSubtitleLock) {
            SubtitleTrack[] subtitleTrackArr = new SubtitleTrack[inbandTrackInfo.length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < inbandTrackInfo.length) {
                    if (inbandTrackInfo[i2].getTrackType() == 4) {
                        if (i2 < this.mInbandSubtitleTracks.length) {
                            subtitleTrackArr[i2] = this.mInbandSubtitleTracks[i2];
                        } else {
                            subtitleTrackArr[i2] = this.mSubtitleController.addTrack(inbandTrackInfo[i2].getFormat());
                        }
                    }
                    i = i2 + 1;
                } else {
                    this.mInbandSubtitleTracks = subtitleTrackArr;
                }
            }
        }
        this.mSubtitleController.selectDefaultTrack();
    }

    private void selectOrDeselectInbandTrack(int i, boolean z) throws IllegalStateException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(IMEDIA_PLAYER);
            obtain.writeInt(z ? 4 : 5);
            obtain.writeInt(i);
            invoke(obtain, obtain2);
        } finally {
            obtain.recycle();
            obtain2.recycle();
        }
    }

    private void selectOrDeselectTrack(int i, boolean z) throws IllegalStateException {
        int selectedTrack;
        SubtitleTrack subtitleTrack = null;
        synchronized (this.mInbandSubtitleLock) {
            if (this.mInbandSubtitleTracks.length == 0) {
                TrackInfo[] inbandTrackInfo = getInbandTrackInfo();
                this.mInbandSubtitleTracks = new SubtitleTrack[inbandTrackInfo.length];
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= inbandTrackInfo.length) {
                        break;
                    }
                    if (inbandTrackInfo[i3].getTrackType() == 4) {
                        this.mInbandSubtitleTracks[i3] = this.mSubtitleController.addTrack(inbandTrackInfo[i3].getFormat());
                    }
                    i2 = i3 + 1;
                }
            }
        }
        if (i < this.mInbandSubtitleTracks.length) {
            subtitleTrack = this.mInbandSubtitleTracks[i];
        } else if (i < this.mInbandSubtitleTracks.length + this.mOutOfBandSubtitleTracks.size()) {
            subtitleTrack = this.mOutOfBandSubtitleTracks.get(i - this.mInbandSubtitleTracks.length);
        }
        if (this.mSubtitleController == null || subtitleTrack == null) {
            selectOrDeselectInbandTrack(i, z);
        } else if (!z) {
            if (this.mSubtitleController.getSelectedTrack() == subtitleTrack) {
                this.mSubtitleController.selectTrack(null);
            } else {
                Log.w(TAG, "trying to deselect track that was not selected");
            }
        } else {
            if (subtitleTrack.isTimedText() && (selectedTrack = getSelectedTrack(3)) >= 0 && selectedTrack < this.mInbandSubtitleTracks.length) {
                selectOrDeselectInbandTrack(selectedTrack, false);
            }
            this.mSubtitleController.selectTrack(subtitleTrack);
        }
    }

    private void setDataSource(String str, String[] strArr, String[] strArr2) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        String str2;
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (ContentResolver.SCHEME_FILE.equals(scheme)) {
            str2 = parse.getPath();
        } else {
            str2 = str;
            if (scheme != null) {
                nativeSetDataSource(MediaHTTPService.createHttpServiceBinderIfNecessary(str), str, strArr, strArr2);
                return;
            }
        }
        File file = new File(str2);
        if (!file.exists()) {
            throw new IOException("setDataSource failed.");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        setDataSource(fileInputStream.getFD());
        fileInputStream.close();
    }

    private native boolean setParameter(int i, Parcel parcel);

    /* JADX INFO: Access modifiers changed from: private */
    public void stayAwake(boolean z) {
        if (this.mWakeLock != null) {
            if (z && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            } else if (!z && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        }
        this.mStayAwake = z;
        updateSurfaceScreenOn();
    }

    private void updateSurfaceScreenOn() {
        if (this.mSurfaceHolder != null) {
            this.mSurfaceHolder.setKeepScreenOn(this.mScreenOnWhilePlaying && this.mStayAwake);
        }
    }

    public void addSubtitleSource(final InputStream inputStream, final MediaFormat mediaFormat) throws IllegalStateException {
        synchronized (this.mOpenSubtitleSources) {
            this.mOpenSubtitleSources.add(inputStream);
        }
        final HandlerThread handlerThread = new HandlerThread("SubtitleReadThread", 9);
        handlerThread.start();
        new Handler(handlerThread.getLooper()).post(new Runnable() { // from class: android.media.MediaPlayer.2
            private int addTrack() {
                SubtitleTrack addTrack;
                if (inputStream == null || MediaPlayer.this.mSubtitleController == null || (addTrack = MediaPlayer.this.mSubtitleController.addTrack(mediaFormat)) == null) {
                    return 901;
                }
                Scanner scanner = new Scanner(inputStream, "UTF-8");
                String next = scanner.useDelimiter("\\A").next();
                synchronized (MediaPlayer.this.mOpenSubtitleSources) {
                    MediaPlayer.this.mOpenSubtitleSources.remove(inputStream);
                }
                scanner.close();
                MediaPlayer.this.mOutOfBandSubtitleTracks.add(addTrack);
                addTrack.onData(next.getBytes(), true, -1L);
                return 803;
            }

            @Override // java.lang.Runnable
            public void run() {
                int addTrack = addTrack();
                if (MediaPlayer.this.mEventHandler != null) {
                    MediaPlayer.this.mEventHandler.sendMessage(MediaPlayer.this.mEventHandler.obtainMessage(200, addTrack, 0, null));
                }
                handlerThread.getLooper().quitSafely();
            }
        });
    }

    public void addTimedTextSource(Context context, Uri uri, String str) throws IOException, IllegalArgumentException, IllegalStateException {
        String scheme = uri.getScheme();
        if (scheme == null || scheme.equals(ContentResolver.SCHEME_FILE)) {
            addTimedTextSource(uri.getPath(), str);
            return;
        }
        AssetFileDescriptor assetFileDescriptor = null;
        AssetFileDescriptor assetFileDescriptor2 = null;
        AssetFileDescriptor assetFileDescriptor3 = null;
        try {
            AssetFileDescriptor openAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, "r");
            if (openAssetFileDescriptor == null) {
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                    return;
                }
                return;
            }
            assetFileDescriptor3 = openAssetFileDescriptor;
            assetFileDescriptor = openAssetFileDescriptor;
            assetFileDescriptor2 = openAssetFileDescriptor;
            addTimedTextSource(openAssetFileDescriptor.getFileDescriptor(), str);
            if (openAssetFileDescriptor != null) {
                openAssetFileDescriptor.close();
            }
        } catch (IOException e) {
            if (assetFileDescriptor != null) {
                assetFileDescriptor.close();
            }
        } catch (SecurityException e2) {
            if (assetFileDescriptor3 != null) {
                assetFileDescriptor3.close();
            }
        } catch (Throwable th) {
            if (assetFileDescriptor2 != null) {
                assetFileDescriptor2.close();
            }
            throw th;
        }
    }

    public void addTimedTextSource(FileDescriptor fileDescriptor, final long j, final long j2, String str) throws IllegalArgumentException, IllegalStateException {
        if (!availableMimeTypeForExternalSource(str)) {
            throw new IllegalArgumentException("Illegal mimeType for timed text source: " + str);
        }
        try {
            final FileDescriptor dup = Libcore.os.dup(fileDescriptor);
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString(MediaFormat.KEY_MIME, str);
            mediaFormat.setInteger(MediaFormat.KEY_IS_TIMED_TEXT, 1);
            Application currentApplication = ActivityThread.currentApplication();
            if (this.mSubtitleController == null) {
                this.mSubtitleController = new SubtitleController(currentApplication, this.mTimeProvider, this);
                this.mSubtitleController.setAnchor(new SubtitleController.Anchor() { // from class: android.media.MediaPlayer.3
                    @Override // android.media.SubtitleController.Anchor
                    public Looper getSubtitleLooper() {
                        return Looper.getMainLooper();
                    }

                    @Override // android.media.SubtitleController.Anchor
                    public void setSubtitleWidget(SubtitleTrack.RenderingWidget renderingWidget) {
                    }
                });
            }
            if (!this.mSubtitleController.hasRendererFor(mediaFormat)) {
                this.mSubtitleController.registerRenderer(new SRTRenderer(currentApplication, this.mEventHandler));
            }
            final SubtitleTrack addTrack = this.mSubtitleController.addTrack(mediaFormat);
            this.mOutOfBandSubtitleTracks.add(addTrack);
            final HandlerThread handlerThread = new HandlerThread("TimedTextReadThread", 9);
            handlerThread.start();
            new Handler(handlerThread.getLooper()).post(new Runnable() { // from class: android.media.MediaPlayer.4
                private int addTrack() {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        try {
                            Libcore.os.lseek(dup, j, OsConstants.SEEK_SET);
                            byte[] bArr = new byte[4096];
                            long j3 = 0;
                            while (true) {
                                long j4 = j3;
                                if (j4 >= j2) {
                                    break;
                                }
                                int read = IoBridge.read(dup, bArr, 0, (int) Math.min(bArr.length, j2 - j4));
                                if (read < 0) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                                j3 = j4 + read;
                            }
                            addTrack.onData(byteArrayOutputStream.toByteArray(), true, -1L);
                            try {
                                Libcore.os.close(dup);
                                return 803;
                            } catch (ErrnoException e) {
                                Log.e(MediaPlayer.TAG, e.getMessage(), e);
                                return 803;
                            }
                        } catch (Exception e2) {
                            Log.e(MediaPlayer.TAG, e2.getMessage(), e2);
                            try {
                                Libcore.os.close(dup);
                                return 900;
                            } catch (ErrnoException e3) {
                                Log.e(MediaPlayer.TAG, e3.getMessage(), e3);
                                return 900;
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            Libcore.os.close(dup);
                        } catch (ErrnoException e4) {
                            Log.e(MediaPlayer.TAG, e4.getMessage(), e4);
                        }
                        throw th;
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int addTrack2 = addTrack();
                    if (MediaPlayer.this.mEventHandler != null) {
                        MediaPlayer.this.mEventHandler.sendMessage(MediaPlayer.this.mEventHandler.obtainMessage(200, addTrack2, 0, null));
                    }
                    handlerThread.getLooper().quitSafely();
                }
            });
        } catch (ErrnoException e) {
            Log.e(TAG, e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    public void addTimedTextSource(FileDescriptor fileDescriptor, String str) throws IllegalArgumentException, IllegalStateException {
        addTimedTextSource(fileDescriptor, 0L, 576460752303423487L, str);
    }

    public void addTimedTextSource(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        if (!availableMimeTypeForExternalSource(str2)) {
            throw new IllegalArgumentException("Illegal mimeType for timed text source: " + str2);
        }
        File file = new File(str);
        if (!file.exists()) {
            throw new IOException(str);
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        addTimedTextSource(fileInputStream.getFD(), str2);
        fileInputStream.close();
    }

    public native void attachAuxEffect(int i);

    public void deselectTrack(int i) throws IllegalStateException {
        selectOrDeselectTrack(i, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finalize() {
        native_finalize();
    }

    public native int getAudioSessionId();

    public native int getCurrentPosition();

    public Uri getCurrentRingtoneUriByType(Context context, int i, Uri uri) {
        return i == 1 ? RingtoneManager.getActualRingtoneUriBySubId(context, RingtoneManager.getDefaultRingtoneSubIdByUri(uri)) : RingtoneManager.getActualDefaultRingtoneUri(context, i);
    }

    public native int getDuration();

    public MediaTimeProvider getMediaTimeProvider() {
        if (this.mTimeProvider == null) {
            this.mTimeProvider = new TimeProvider(this);
        }
        return this.mTimeProvider;
    }

    public Metadata getMetadata(boolean z, boolean z2) {
        Metadata metadata;
        Parcel obtain = Parcel.obtain();
        Metadata metadata2 = new Metadata();
        if (native_getMetadata(z, z2, obtain)) {
            metadata = metadata2;
            if (!metadata2.parse(obtain)) {
                obtain.recycle();
                return null;
            }
        } else {
            obtain.recycle();
            metadata = null;
        }
        return metadata;
    }

    public int getSelectedTrack(int i) throws IllegalStateException {
        SubtitleTrack selectedTrack;
        int indexOf;
        if (i != 4 || this.mSubtitleController == null || (selectedTrack = this.mSubtitleController.getSelectedTrack()) == null || (indexOf = this.mOutOfBandSubtitleTracks.indexOf(selectedTrack)) < 0) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IMEDIA_PLAYER);
                obtain.writeInt(7);
                obtain.writeInt(i);
                invoke(obtain, obtain2);
                return obtain2.readInt();
            } finally {
                obtain.recycle();
                obtain2.recycle();
            }
        }
        return this.mInbandSubtitleTracks.length + indexOf;
    }

    public TrackInfo[] getTrackInfo() throws IllegalStateException {
        TrackInfo[] inbandTrackInfo = getInbandTrackInfo();
        TrackInfo[] trackInfoArr = new TrackInfo[inbandTrackInfo.length + this.mOutOfBandSubtitleTracks.size()];
        System.arraycopy(inbandTrackInfo, 0, trackInfoArr, 0, inbandTrackInfo.length);
        int length = inbandTrackInfo.length;
        Iterator<SubtitleTrack> it = this.mOutOfBandSubtitleTracks.iterator();
        while (it.hasNext()) {
            SubtitleTrack next = it.next();
            trackInfoArr[length] = new TrackInfo(next.isTimedText() ? 3 : 4, next.getFormat());
            length++;
        }
        return trackInfoArr;
    }

    public native int getVideoHeight();

    public native int getVideoWidth();

    public void invoke(Parcel parcel, Parcel parcel2) {
        int native_invoke = native_invoke(parcel, parcel2);
        parcel2.setDataPosition(0);
        if (native_invoke != 0) {
            throw new RuntimeException("failure code: " + native_invoke);
        }
    }

    public native boolean isLooping();

    public native boolean isPlaying();

    public Parcel newRequest() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(IMEDIA_PLAYER);
        return obtain;
    }

    @Override // android.media.SubtitleController.Listener
    public void onSubtitleTrackSelected(SubtitleTrack subtitleTrack) {
        if (this.mSelectedSubtitleTrackIndex >= 0) {
            try {
                selectOrDeselectInbandTrack(this.mSelectedSubtitleTrackIndex, false);
            } catch (IllegalStateException e) {
            }
            this.mSelectedSubtitleTrackIndex = -1;
        }
        setOnSubtitleDataListener(null);
        if (subtitleTrack == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mInbandSubtitleTracks.length) {
                return;
            }
            if (this.mInbandSubtitleTracks[i2] == subtitleTrack) {
                Log.v(TAG, "Selecting subtitle track " + i2);
                this.mSelectedSubtitleTrackIndex = i2;
                try {
                    selectOrDeselectInbandTrack(this.mSelectedSubtitleTrackIndex, true);
                } catch (IllegalStateException e2) {
                }
                setOnSubtitleDataListener(this.mSubtitleDataListener);
                return;
            }
            i = i2 + 1;
        }
    }

    public void pause() throws IllegalStateException {
        stayAwake(false);
        _pause();
    }

    public void prepare() throws IOException, IllegalStateException {
        _prepare();
        scanInternalSubtitleTracks();
    }

    public native void prepareAsync() throws IllegalStateException;

    public void release() {
        stayAwake(false);
        updateSurfaceScreenOn();
        this.mOnPreparedListener = null;
        this.mOnBufferingUpdateListener = null;
        this.mOnCompletionListener = null;
        this.mOnSeekCompleteListener = null;
        this.mOnErrorListener = null;
        this.mOnInfoListener = null;
        this.mOnVideoSizeChangedListener = null;
        this.mOnTimedTextListener = null;
        if (this.mTimeProvider != null) {
            this.mTimeProvider.close();
            this.mTimeProvider = null;
        }
        this.mOnSubtitleDataListener = null;
        _release();
    }

    public void reset() {
        this.mSelectedSubtitleTrackIndex = -1;
        synchronized (this.mOpenSubtitleSources) {
            Iterator<InputStream> it = this.mOpenSubtitleSources.iterator();
            while (it.hasNext()) {
                try {
                    it.next().close();
                } catch (IOException e) {
                }
            }
            this.mOpenSubtitleSources.clear();
        }
        this.mOutOfBandSubtitleTracks.clear();
        this.mInbandSubtitleTracks = new SubtitleTrack[0];
        if (this.mSubtitleController != null) {
            this.mSubtitleController.reset();
        }
        if (this.mTimeProvider != null) {
            this.mTimeProvider.close();
            this.mTimeProvider = null;
        }
        stayAwake(false);
        _reset();
        if (this.mEventHandler != null) {
            this.mEventHandler.removeCallbacksAndMessages(null);
        }
    }

    public boolean resume() {
        return _resume();
    }

    public native void seekTo(int i) throws IllegalStateException;

    public void selectTrack(int i) throws IllegalStateException {
        selectOrDeselectTrack(i, true);
    }

    public void setAudioAttributes(AudioAttributes audioAttributes) throws IllegalArgumentException {
        if (audioAttributes == null) {
            throw new IllegalArgumentException("Cannot set AudioAttributes to null");
        }
        this.mUsage = audioAttributes.getUsage();
        Parcel obtain = Parcel.obtain();
        audioAttributes.writeToParcel(obtain, 1);
        setParameter(KEY_PARAMETER_AUDIO_ATTRIBUTES, obtain);
        obtain.recycle();
    }

    public native void setAudioSessionId(int i) throws IllegalArgumentException, IllegalStateException;

    public void setAudioStreamType(int i) {
        _setAudioStreamType(i);
        this.mStreamType = i;
    }

    public void setAuxEffectSendLevel(float f) {
        if (isRestricted()) {
            return;
        }
        _setAuxEffectSendLevel(f);
    }

    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        setDataSource(context, uri, (Map<String, String>) null);
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        String scheme = uri.getScheme();
        if (ContentResolver.SCHEME_FILE.equals(scheme)) {
            setDataSource(uri.getPath());
            return;
        }
        Uri uri2 = uri;
        if ("content".equals(scheme)) {
            uri2 = uri;
            if ("settings".equals(uri.getAuthority())) {
                Uri currentRingtoneUriByType = getCurrentRingtoneUriByType(context, RingtoneManager.getDefaultType(uri), uri);
                uri2 = currentRingtoneUriByType;
                if (currentRingtoneUriByType == null) {
                    throw new FileNotFoundException("Failed to resolve default ringtone");
                }
            }
        }
        AutoCloseable autoCloseable = null;
        AutoCloseable autoCloseable2 = null;
        AutoCloseable autoCloseable3 = null;
        try {
            AssetFileDescriptor openAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri2, "r");
            if (openAssetFileDescriptor == null) {
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                    return;
                }
                return;
            }
            if (openAssetFileDescriptor.getDeclaredLength() < 0) {
                setDataSource(openAssetFileDescriptor.getFileDescriptor());
            } else {
                setDataSource(openAssetFileDescriptor.getFileDescriptor(), openAssetFileDescriptor.getStartOffset(), openAssetFileDescriptor.getDeclaredLength());
            }
            if (openAssetFileDescriptor != null) {
                openAssetFileDescriptor.close();
            }
        } catch (IOException e) {
            if (0 != 0) {
                autoCloseable.close();
            }
            Log.d(TAG, "Couldn't open file on client side, trying server side");
            setDataSource(uri2.toString(), map);
        } catch (SecurityException e2) {
            if (0 != 0) {
                autoCloseable3.close();
            }
            Log.d(TAG, "Couldn't open file on client side, trying server side");
            setDataSource(uri2.toString(), map);
        } catch (Throwable th) {
            if (0 != 0) {
                autoCloseable2.close();
            }
            throw th;
        }
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException {
        setDataSource(fileDescriptor, 0L, 576460752303423487L);
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException, IllegalArgumentException, IllegalStateException {
        _setDataSource(fileDescriptor, j, j2);
    }

    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        setDataSource(str, (String[]) null, (String[]) null);
    }

    public void setDataSource(String str, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        String[] strArr = null;
        String[] strArr2 = null;
        if (map != null) {
            String[] strArr3 = new String[map.size()];
            String[] strArr4 = new String[map.size()];
            int i = 0;
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (true) {
                strArr = strArr3;
                strArr2 = strArr4;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, String> next = it.next();
                strArr3[i] = next.getKey();
                strArr4[i] = next.getValue();
                i++;
            }
        }
        setDataSource(str, strArr, strArr2);
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        _setVideoSurface(surfaceHolder != null ? surfaceHolder.getSurface() : null);
        updateSurfaceScreenOn();
    }

    public native void setLooping(boolean z);

    public int setMetadataFilter(Set<Integer> set, Set<Integer> set2) {
        Parcel newRequest = newRequest();
        int dataSize = newRequest.dataSize() + ((set.size() + 1 + 1 + set2.size()) * 4);
        if (newRequest.dataCapacity() < dataSize) {
            newRequest.setDataCapacity(dataSize);
        }
        newRequest.writeInt(set.size());
        for (Integer num : set) {
            newRequest.writeInt(num.intValue());
        }
        newRequest.writeInt(set2.size());
        for (Integer num2 : set2) {
            newRequest.writeInt(num2.intValue());
        }
        return native_setMetadataFilter(newRequest);
    }

    public native void setNextMediaPlayer(MediaPlayer mediaPlayer);

    public void setOnBufferingUpdateListener(OnBufferingUpdateListener onBufferingUpdateListener) {
        this.mOnBufferingUpdateListener = onBufferingUpdateListener;
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    public void setOnInfoListener(OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    public void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListener = onSeekCompleteListener;
    }

    public void setOnSubtitleDataListener(OnSubtitleDataListener onSubtitleDataListener) {
        this.mOnSubtitleDataListener = onSubtitleDataListener;
    }

    public void setOnTimedTextListener(OnTimedTextListener onTimedTextListener) {
        this.mOnTimedTextListener = onTimedTextListener;
    }

    public void setOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mOnVideoSizeChangedListener = onVideoSizeChangedListener;
    }

    public void setRetransmitEndpoint(InetSocketAddress inetSocketAddress) throws IllegalStateException, IllegalArgumentException {
        String str = null;
        int i = 0;
        if (inetSocketAddress != null) {
            str = inetSocketAddress.getAddress().getHostAddress();
            i = inetSocketAddress.getPort();
        }
        int native_setRetransmitEndpoint = native_setRetransmitEndpoint(str, i);
        if (native_setRetransmitEndpoint != 0) {
            throw new IllegalArgumentException("Illegal re-transmit endpoint; native ret " + native_setRetransmitEndpoint);
        }
    }

    public void setScreenOnWhilePlaying(boolean z) {
        if (this.mScreenOnWhilePlaying != z) {
            if (z && this.mSurfaceHolder == null) {
                Log.w(TAG, "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
            }
            this.mScreenOnWhilePlaying = z;
            updateSurfaceScreenOn();
        }
    }

    public void setSubtitleAnchor(SubtitleController subtitleController, SubtitleController.Anchor anchor) {
        this.mSubtitleController = subtitleController;
        this.mSubtitleController.setAnchor(anchor);
    }

    public void setSurface(Surface surface) {
        if (this.mScreenOnWhilePlaying && surface != null) {
            Log.w(TAG, "setScreenOnWhilePlaying(true) is ineffective for Surface");
        }
        this.mSurfaceHolder = null;
        _setVideoSurface(surface);
        updateSurfaceScreenOn();
    }

    public void setVideoScalingMode(int i) {
        if (!isVideoScalingModeSupported(i)) {
            throw new IllegalArgumentException("Scaling mode " + i + " is not supported");
        }
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(IMEDIA_PLAYER);
            obtain.writeInt(6);
            obtain.writeInt(i);
            invoke(obtain, obtain2);
        } finally {
            obtain.recycle();
            obtain2.recycle();
        }
    }

    public void setVolume(float f) {
        setVolume(f, f);
    }

    public void setVolume(float f, float f2) {
        if (isRestricted()) {
            return;
        }
        _setVolume(f, f2);
    }

    public void setWakeMode(Context context, int i) {
        boolean z = false;
        if (this.mWakeLock != null) {
            z = false;
            if (this.mWakeLock.isHeld()) {
                z = true;
                this.mWakeLock.release();
            }
            this.mWakeLock = null;
        }
        this.mWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(536870912 | i, MediaPlayer.class.getName());
        this.mWakeLock.setReferenceCounted(false);
        if (z) {
            this.mWakeLock.acquire();
        }
    }

    public void start() throws IllegalStateException {
        if (isRestricted()) {
            _setVolume(0.0f, 0.0f);
        }
        stayAwake(true);
        _start();
    }

    public void stop() throws IllegalStateException {
        stayAwake(false);
        _stop();
    }

    public boolean suspend() {
        stayAwake(false);
        return _suspend();
    }
}
