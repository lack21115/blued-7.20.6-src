package android.media.tv;

import android.graphics.Rect;
import android.media.tv.ITvInputClient;
import android.media.tv.ITvInputHardwareCallback;
import android.media.tv.ITvInputManagerCallback;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Pools;
import android.util.SparseArray;
import android.view.InputChannel;
import android.view.InputEvent;
import android.view.InputEventSender;
import android.view.KeyEvent;
import android.view.Surface;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: source-9557208-dex2jar.jar:android/media/tv/TvInputManager.class */
public final class TvInputManager {
    public static final String ACTION_BLOCKED_RATINGS_CHANGED = "android.media.tv.action.BLOCKED_RATINGS_CHANGED";
    public static final String ACTION_PARENTAL_CONTROLS_ENABLED_CHANGED = "android.media.tv.action.PARENTAL_CONTROLS_ENABLED_CHANGED";
    public static final String ACTION_QUERY_CONTENT_RATING_SYSTEMS = "android.media.tv.action.QUERY_CONTENT_RATING_SYSTEMS";
    public static final int INPUT_STATE_CONNECTED = 0;
    public static final int INPUT_STATE_CONNECTED_STANDBY = 1;
    public static final int INPUT_STATE_DISCONNECTED = 2;
    public static final int INPUT_STATE_UNKNOWN = -1;
    public static final String META_DATA_CONTENT_RATING_SYSTEMS = "android.media.tv.metadata.CONTENT_RATING_SYSTEMS";
    private static final String TAG = "TvInputManager";
    public static final int VIDEO_UNAVAILABLE_REASON_BUFFERING = 3;
    static final int VIDEO_UNAVAILABLE_REASON_END = 3;
    static final int VIDEO_UNAVAILABLE_REASON_START = 0;
    public static final int VIDEO_UNAVAILABLE_REASON_TUNING = 1;
    public static final int VIDEO_UNAVAILABLE_REASON_UNKNOWN = 0;
    public static final int VIDEO_UNAVAILABLE_REASON_WEAK_SIGNAL = 2;
    private int mNextSeq;
    private final ITvInputManager mService;
    private final int mUserId;
    private final Object mLock = new Object();
    private final List<TvInputCallbackRecord> mCallbackRecords = new LinkedList();
    private final Map<String, Integer> mStateMap = new ArrayMap();
    private final SparseArray<SessionCallbackRecord> mSessionCallbackRecordMap = new SparseArray<>();
    private final ITvInputClient mClient = new ITvInputClient.Stub() { // from class: android.media.tv.TvInputManager.1
        private void postVideoSizeChangedIfNeededLocked(SessionCallbackRecord sessionCallbackRecord) {
            TvTrackInfo videoTrackToNotify = sessionCallbackRecord.mSession.getVideoTrackToNotify();
            if (videoTrackToNotify != null) {
                sessionCallbackRecord.postVideoSizeChanged(videoTrackToNotify.getVideoWidth(), videoTrackToNotify.getVideoHeight());
            }
        }

        @Override // android.media.tv.ITvInputClient
        public void onChannelRetuned(Uri uri, int i) {
            synchronized (TvInputManager.this.mSessionCallbackRecordMap) {
                SessionCallbackRecord sessionCallbackRecord = (SessionCallbackRecord) TvInputManager.this.mSessionCallbackRecordMap.get(i);
                if (sessionCallbackRecord == null) {
                    Log.e(TvInputManager.TAG, "Callback not found for seq " + i);
                } else {
                    sessionCallbackRecord.postChannelRetuned(uri);
                }
            }
        }

        @Override // android.media.tv.ITvInputClient
        public void onContentAllowed(int i) {
            synchronized (TvInputManager.this.mSessionCallbackRecordMap) {
                SessionCallbackRecord sessionCallbackRecord = (SessionCallbackRecord) TvInputManager.this.mSessionCallbackRecordMap.get(i);
                if (sessionCallbackRecord == null) {
                    Log.e(TvInputManager.TAG, "Callback not found for seq " + i);
                } else {
                    sessionCallbackRecord.postContentAllowed();
                }
            }
        }

        @Override // android.media.tv.ITvInputClient
        public void onContentBlocked(String str, int i) {
            synchronized (TvInputManager.this.mSessionCallbackRecordMap) {
                SessionCallbackRecord sessionCallbackRecord = (SessionCallbackRecord) TvInputManager.this.mSessionCallbackRecordMap.get(i);
                if (sessionCallbackRecord == null) {
                    Log.e(TvInputManager.TAG, "Callback not found for seq " + i);
                } else {
                    sessionCallbackRecord.postContentBlocked(TvContentRating.unflattenFromString(str));
                }
            }
        }

        @Override // android.media.tv.ITvInputClient
        public void onLayoutSurface(int i, int i2, int i3, int i4, int i5) {
            synchronized (TvInputManager.this.mSessionCallbackRecordMap) {
                SessionCallbackRecord sessionCallbackRecord = (SessionCallbackRecord) TvInputManager.this.mSessionCallbackRecordMap.get(i5);
                if (sessionCallbackRecord == null) {
                    Log.e(TvInputManager.TAG, "Callback not found for seq " + i5);
                } else {
                    sessionCallbackRecord.postLayoutSurface(i, i2, i3, i4);
                }
            }
        }

        @Override // android.media.tv.ITvInputClient
        public void onSessionCreated(String str, IBinder iBinder, InputChannel inputChannel, int i) {
            synchronized (TvInputManager.this.mSessionCallbackRecordMap) {
                SessionCallbackRecord sessionCallbackRecord = (SessionCallbackRecord) TvInputManager.this.mSessionCallbackRecordMap.get(i);
                if (sessionCallbackRecord == null) {
                    Log.e(TvInputManager.TAG, "Callback not found for " + iBinder);
                    return;
                }
                Session session = null;
                if (iBinder != null) {
                    session = new Session(iBinder, inputChannel, TvInputManager.this.mService, TvInputManager.this.mUserId, i, TvInputManager.this.mSessionCallbackRecordMap);
                }
                sessionCallbackRecord.postSessionCreated(session);
            }
        }

        @Override // android.media.tv.ITvInputClient
        public void onSessionEvent(String str, Bundle bundle, int i) {
            synchronized (TvInputManager.this.mSessionCallbackRecordMap) {
                SessionCallbackRecord sessionCallbackRecord = (SessionCallbackRecord) TvInputManager.this.mSessionCallbackRecordMap.get(i);
                if (sessionCallbackRecord == null) {
                    Log.e(TvInputManager.TAG, "Callback not found for seq " + i);
                } else {
                    sessionCallbackRecord.postSessionEvent(str, bundle);
                }
            }
        }

        @Override // android.media.tv.ITvInputClient
        public void onSessionReleased(int i) {
            synchronized (TvInputManager.this.mSessionCallbackRecordMap) {
                SessionCallbackRecord sessionCallbackRecord = (SessionCallbackRecord) TvInputManager.this.mSessionCallbackRecordMap.get(i);
                TvInputManager.this.mSessionCallbackRecordMap.delete(i);
                if (sessionCallbackRecord == null) {
                    Log.e(TvInputManager.TAG, "Callback not found for seq:" + i);
                    return;
                }
                sessionCallbackRecord.mSession.releaseInternal();
                sessionCallbackRecord.postSessionReleased();
            }
        }

        @Override // android.media.tv.ITvInputClient
        public void onTrackSelected(int i, String str, int i2) {
            synchronized (TvInputManager.this.mSessionCallbackRecordMap) {
                SessionCallbackRecord sessionCallbackRecord = (SessionCallbackRecord) TvInputManager.this.mSessionCallbackRecordMap.get(i2);
                if (sessionCallbackRecord == null) {
                    Log.e(TvInputManager.TAG, "Callback not found for seq " + i2);
                    return;
                }
                if (sessionCallbackRecord.mSession.updateTrackSelection(i, str)) {
                    sessionCallbackRecord.postTrackSelected(i, str);
                    postVideoSizeChangedIfNeededLocked(sessionCallbackRecord);
                }
            }
        }

        @Override // android.media.tv.ITvInputClient
        public void onTracksChanged(List<TvTrackInfo> list, int i) {
            synchronized (TvInputManager.this.mSessionCallbackRecordMap) {
                SessionCallbackRecord sessionCallbackRecord = (SessionCallbackRecord) TvInputManager.this.mSessionCallbackRecordMap.get(i);
                if (sessionCallbackRecord == null) {
                    Log.e(TvInputManager.TAG, "Callback not found for seq " + i);
                    return;
                }
                if (sessionCallbackRecord.mSession.updateTracks(list)) {
                    sessionCallbackRecord.postTracksChanged(list);
                    postVideoSizeChangedIfNeededLocked(sessionCallbackRecord);
                }
            }
        }

        @Override // android.media.tv.ITvInputClient
        public void onVideoAvailable(int i) {
            synchronized (TvInputManager.this.mSessionCallbackRecordMap) {
                SessionCallbackRecord sessionCallbackRecord = (SessionCallbackRecord) TvInputManager.this.mSessionCallbackRecordMap.get(i);
                if (sessionCallbackRecord == null) {
                    Log.e(TvInputManager.TAG, "Callback not found for seq " + i);
                } else {
                    sessionCallbackRecord.postVideoAvailable();
                }
            }
        }

        @Override // android.media.tv.ITvInputClient
        public void onVideoUnavailable(int i, int i2) {
            synchronized (TvInputManager.this.mSessionCallbackRecordMap) {
                SessionCallbackRecord sessionCallbackRecord = (SessionCallbackRecord) TvInputManager.this.mSessionCallbackRecordMap.get(i2);
                if (sessionCallbackRecord == null) {
                    Log.e(TvInputManager.TAG, "Callback not found for seq " + i2);
                } else {
                    sessionCallbackRecord.postVideoUnavailable(i);
                }
            }
        }
    };
    private final ITvInputManagerCallback mManagerCallback = new ITvInputManagerCallback.Stub() { // from class: android.media.tv.TvInputManager.2
        @Override // android.media.tv.ITvInputManagerCallback
        public void onInputAdded(String str) {
            synchronized (TvInputManager.this.mLock) {
                TvInputManager.this.mStateMap.put(str, 0);
                for (TvInputCallbackRecord tvInputCallbackRecord : TvInputManager.this.mCallbackRecords) {
                    tvInputCallbackRecord.postInputAdded(str);
                }
            }
        }

        @Override // android.media.tv.ITvInputManagerCallback
        public void onInputRemoved(String str) {
            synchronized (TvInputManager.this.mLock) {
                TvInputManager.this.mStateMap.remove(str);
                for (TvInputCallbackRecord tvInputCallbackRecord : TvInputManager.this.mCallbackRecords) {
                    tvInputCallbackRecord.postInputRemoved(str);
                }
            }
        }

        @Override // android.media.tv.ITvInputManagerCallback
        public void onInputStateChanged(String str, int i) {
            synchronized (TvInputManager.this.mLock) {
                TvInputManager.this.mStateMap.put(str, Integer.valueOf(i));
                for (TvInputCallbackRecord tvInputCallbackRecord : TvInputManager.this.mCallbackRecords) {
                    tvInputCallbackRecord.postInputStateChanged(str, i);
                }
            }
        }

        @Override // android.media.tv.ITvInputManagerCallback
        public void onInputUpdated(String str) {
            synchronized (TvInputManager.this.mLock) {
                for (TvInputCallbackRecord tvInputCallbackRecord : TvInputManager.this.mCallbackRecords) {
                    tvInputCallbackRecord.postInputUpdated(str);
                }
            }
        }
    };

    /* loaded from: source-9557208-dex2jar.jar:android/media/tv/TvInputManager$Hardware.class */
    public static final class Hardware {
        private final ITvInputHardware mInterface;

        private Hardware(ITvInputHardware iTvInputHardware) {
            this.mInterface = iTvInputHardware;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ITvInputHardware getInterface() {
            return this.mInterface;
        }

        public boolean dispatchKeyEventToHdmi(KeyEvent keyEvent) {
            try {
                return this.mInterface.dispatchKeyEventToHdmi(keyEvent);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        public void overrideAudioSink(int i, String str, int i2, int i3, int i4) {
            try {
                this.mInterface.overrideAudioSink(i, str, i2, i3, i4);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        public void setStreamVolume(float f) {
            try {
                this.mInterface.setStreamVolume(f);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        public boolean setSurface(Surface surface, TvStreamConfig tvStreamConfig) {
            try {
                return this.mInterface.setSurface(surface, tvStreamConfig);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/tv/TvInputManager$HardwareCallback.class */
    public static abstract class HardwareCallback {
        public abstract void onReleased();

        public abstract void onStreamConfigChanged(TvStreamConfig[] tvStreamConfigArr);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/tv/TvInputManager$Session.class */
    public static final class Session {
        static final int DISPATCH_HANDLED = 1;
        static final int DISPATCH_IN_PROGRESS = -1;
        static final int DISPATCH_NOT_HANDLED = 0;
        private static final long INPUT_SESSION_NOT_RESPONDING_TIMEOUT = 2500;
        private final List<TvTrackInfo> mAudioTracks;
        private InputChannel mChannel;
        private final InputEventHandler mHandler;
        private final Pools.Pool<PendingEvent> mPendingEventPool;
        private final SparseArray<PendingEvent> mPendingEvents;
        private String mSelectedAudioTrackId;
        private String mSelectedSubtitleTrackId;
        private String mSelectedVideoTrackId;
        private TvInputEventSender mSender;
        private final int mSeq;
        private final ITvInputManager mService;
        private final SparseArray<SessionCallbackRecord> mSessionCallbackRecordMap;
        private final List<TvTrackInfo> mSubtitleTracks;
        private IBinder mToken;
        private final Object mTrackLock;
        private final int mUserId;
        private int mVideoHeight;
        private final List<TvTrackInfo> mVideoTracks;
        private int mVideoWidth;

        /* loaded from: source-9557208-dex2jar.jar:android/media/tv/TvInputManager$Session$FinishedInputEventCallback.class */
        public interface FinishedInputEventCallback {
            void onFinishedInputEvent(Object obj, boolean z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-9557208-dex2jar.jar:android/media/tv/TvInputManager$Session$InputEventHandler.class */
        public final class InputEventHandler extends Handler {
            public static final int MSG_FLUSH_INPUT_EVENT = 3;
            public static final int MSG_SEND_INPUT_EVENT = 1;
            public static final int MSG_TIMEOUT_INPUT_EVENT = 2;

            InputEventHandler(Looper looper) {
                super(looper, null, true);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        Session.this.sendInputEventAndReportResultOnMainLooper((PendingEvent) message.obj);
                        return;
                    case 2:
                        Session.this.finishedInputEvent(message.arg1, false, true);
                        return;
                    case 3:
                        Session.this.finishedInputEvent(message.arg1, false, false);
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-9557208-dex2jar.jar:android/media/tv/TvInputManager$Session$PendingEvent.class */
        public final class PendingEvent implements Runnable {
            public FinishedInputEventCallback mCallback;
            public InputEvent mEvent;
            public Handler mEventHandler;
            public Object mEventToken;
            public boolean mHandled;

            private PendingEvent() {
            }

            public void recycle() {
                this.mEvent = null;
                this.mEventToken = null;
                this.mCallback = null;
                this.mEventHandler = null;
                this.mHandled = false;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.mCallback.onFinishedInputEvent(this.mEventToken, this.mHandled);
                synchronized (this.mEventHandler) {
                    Session.this.recyclePendingEventLocked(this);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-9557208-dex2jar.jar:android/media/tv/TvInputManager$Session$TvInputEventSender.class */
        public final class TvInputEventSender extends InputEventSender {
            public TvInputEventSender(InputChannel inputChannel, Looper looper) {
                super(inputChannel, looper);
            }

            @Override // android.view.InputEventSender
            public void onInputEventFinished(int i, boolean z) {
                Session.this.finishedInputEvent(i, z, false);
            }
        }

        private Session(IBinder iBinder, InputChannel inputChannel, ITvInputManager iTvInputManager, int i, int i2, SparseArray<SessionCallbackRecord> sparseArray) {
            this.mHandler = new InputEventHandler(Looper.getMainLooper());
            this.mPendingEventPool = new Pools.SimplePool(20);
            this.mPendingEvents = new SparseArray<>(20);
            this.mTrackLock = new Object();
            this.mAudioTracks = new ArrayList();
            this.mVideoTracks = new ArrayList();
            this.mSubtitleTracks = new ArrayList();
            this.mToken = iBinder;
            this.mChannel = inputChannel;
            this.mService = iTvInputManager;
            this.mUserId = i;
            this.mSeq = i2;
            this.mSessionCallbackRecordMap = sparseArray;
        }

        private boolean containsTrack(List<TvTrackInfo> list, String str) {
            for (TvTrackInfo tvTrackInfo : list) {
                if (tvTrackInfo.getId().equals(str)) {
                    return true;
                }
            }
            return false;
        }

        private void flushPendingEventsLocked() {
            this.mHandler.removeMessages(3);
            int size = this.mPendingEvents.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                Message obtainMessage = this.mHandler.obtainMessage(3, this.mPendingEvents.keyAt(i2), 0);
                obtainMessage.setAsynchronous(true);
                obtainMessage.sendToTarget();
                i = i2 + 1;
            }
        }

        private PendingEvent obtainPendingEventLocked(InputEvent inputEvent, Object obj, FinishedInputEventCallback finishedInputEventCallback, Handler handler) {
            PendingEvent acquire = this.mPendingEventPool.acquire();
            PendingEvent pendingEvent = acquire;
            if (acquire == null) {
                pendingEvent = new PendingEvent();
            }
            pendingEvent.mEvent = inputEvent;
            pendingEvent.mEventToken = obj;
            pendingEvent.mCallback = finishedInputEventCallback;
            pendingEvent.mEventHandler = handler;
            return pendingEvent;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void recyclePendingEventLocked(PendingEvent pendingEvent) {
            pendingEvent.recycle();
            this.mPendingEventPool.release(pendingEvent);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void releaseInternal() {
            this.mToken = null;
            synchronized (this.mHandler) {
                if (this.mChannel != null) {
                    if (this.mSender != null) {
                        flushPendingEventsLocked();
                        this.mSender.dispose();
                        this.mSender = null;
                    }
                    this.mChannel.dispose();
                    this.mChannel = null;
                }
            }
            synchronized (this.mSessionCallbackRecordMap) {
                this.mSessionCallbackRecordMap.remove(this.mSeq);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void sendInputEventAndReportResultOnMainLooper(PendingEvent pendingEvent) {
            synchronized (this.mHandler) {
                if (sendInputEventOnMainLooperLocked(pendingEvent) == -1) {
                    return;
                }
                invokeFinishedInputEventCallback(pendingEvent, false);
            }
        }

        private int sendInputEventOnMainLooperLocked(PendingEvent pendingEvent) {
            if (this.mChannel != null) {
                if (this.mSender == null) {
                    this.mSender = new TvInputEventSender(this.mChannel, this.mHandler.getLooper());
                }
                InputEvent inputEvent = pendingEvent.mEvent;
                int sequenceNumber = inputEvent.getSequenceNumber();
                if (!this.mSender.sendInputEvent(sequenceNumber, inputEvent)) {
                    Log.w(TvInputManager.TAG, "Unable to send input event to session: " + this.mToken + " dropping:" + inputEvent);
                    return 0;
                }
                this.mPendingEvents.put(sequenceNumber, pendingEvent);
                Message obtainMessage = this.mHandler.obtainMessage(2, pendingEvent);
                obtainMessage.setAsynchronous(true);
                this.mHandler.sendMessageDelayed(obtainMessage, INPUT_SESSION_NOT_RESPONDING_TIMEOUT);
                return -1;
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void createOverlayView(View view, Rect rect) {
            if (view == null) {
                throw new IllegalArgumentException("view cannot be null");
            }
            if (rect == null) {
                throw new IllegalArgumentException("frame cannot be null");
            }
            if (view.getWindowToken() == null) {
                throw new IllegalStateException("view must be attached to a window");
            }
            if (this.mToken == null) {
                Log.w(TvInputManager.TAG, "The session has been already released");
                return;
            }
            try {
                this.mService.createOverlayView(this.mToken, view.getWindowToken(), rect, this.mUserId);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        public int dispatchInputEvent(InputEvent inputEvent, Object obj, FinishedInputEventCallback finishedInputEventCallback, Handler handler) {
            if (inputEvent == null) {
                throw new IllegalArgumentException("event cannot be null");
            }
            if (finishedInputEventCallback == null || handler != null) {
                synchronized (this.mHandler) {
                    if (this.mChannel == null) {
                        return 0;
                    }
                    PendingEvent obtainPendingEventLocked = obtainPendingEventLocked(inputEvent, obj, finishedInputEventCallback, handler);
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        return sendInputEventOnMainLooperLocked(obtainPendingEventLocked);
                    }
                    Message obtainMessage = this.mHandler.obtainMessage(1, obtainPendingEventLocked);
                    obtainMessage.setAsynchronous(true);
                    this.mHandler.sendMessage(obtainMessage);
                    return -1;
                }
            }
            throw new IllegalArgumentException("handler cannot be null");
        }

        public void dispatchSurfaceChanged(int i, int i2, int i3) {
            if (this.mToken == null) {
                Log.w(TvInputManager.TAG, "The session has been already released");
                return;
            }
            try {
                this.mService.dispatchSurfaceChanged(this.mToken, i, i2, i3, this.mUserId);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        void finishedInputEvent(int i, boolean z, boolean z2) {
            synchronized (this.mHandler) {
                int indexOfKey = this.mPendingEvents.indexOfKey(i);
                if (indexOfKey < 0) {
                    return;
                }
                PendingEvent valueAt = this.mPendingEvents.valueAt(indexOfKey);
                this.mPendingEvents.removeAt(indexOfKey);
                if (z2) {
                    Log.w(TvInputManager.TAG, "Timeout waiting for seesion to handle input event after 2500 ms: " + this.mToken);
                } else {
                    this.mHandler.removeMessages(2, valueAt);
                }
                invokeFinishedInputEventCallback(valueAt, z);
            }
        }

        public String getSelectedTrack(int i) {
            synchronized (this.mTrackLock) {
                if (i == 0) {
                    return this.mSelectedAudioTrackId;
                } else if (i == 1) {
                    return this.mSelectedVideoTrackId;
                } else if (i == 2) {
                    return this.mSelectedSubtitleTrackId;
                } else {
                    throw new IllegalArgumentException("invalid type: " + i);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public IBinder getToken() {
            return this.mToken;
        }

        public List<TvTrackInfo> getTracks(int i) {
            synchronized (this.mTrackLock) {
                if (i == 0) {
                    if (this.mAudioTracks == null) {
                        return null;
                    }
                    return new ArrayList(this.mAudioTracks);
                } else if (i == 1) {
                    if (this.mVideoTracks == null) {
                        return null;
                    }
                    return new ArrayList(this.mVideoTracks);
                } else if (i == 2) {
                    if (this.mSubtitleTracks == null) {
                        return null;
                    }
                    return new ArrayList(this.mSubtitleTracks);
                } else {
                    throw new IllegalArgumentException("invalid type: " + i);
                }
            }
        }

        TvTrackInfo getVideoTrackToNotify() {
            synchronized (this.mTrackLock) {
                if (!this.mVideoTracks.isEmpty() && this.mSelectedVideoTrackId != null) {
                    for (TvTrackInfo tvTrackInfo : this.mVideoTracks) {
                        if (tvTrackInfo.getId().equals(this.mSelectedVideoTrackId)) {
                            int videoWidth = tvTrackInfo.getVideoWidth();
                            int videoHeight = tvTrackInfo.getVideoHeight();
                            if (this.mVideoWidth != videoWidth || this.mVideoHeight != videoHeight) {
                                this.mVideoWidth = videoWidth;
                                this.mVideoHeight = videoHeight;
                                return tvTrackInfo;
                            }
                        }
                    }
                }
                return null;
            }
        }

        void invokeFinishedInputEventCallback(PendingEvent pendingEvent, boolean z) {
            pendingEvent.mHandled = z;
            if (pendingEvent.mEventHandler.getLooper().isCurrentThread()) {
                pendingEvent.run();
                return;
            }
            Message obtain = Message.obtain(pendingEvent.mEventHandler, pendingEvent);
            obtain.setAsynchronous(true);
            obtain.sendToTarget();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void relayoutOverlayView(Rect rect) {
            if (rect == null) {
                throw new IllegalArgumentException("frame cannot be null");
            }
            if (this.mToken == null) {
                Log.w(TvInputManager.TAG, "The session has been already released");
                return;
            }
            try {
                this.mService.relayoutOverlayView(this.mToken, rect, this.mUserId);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        public void release() {
            if (this.mToken == null) {
                Log.w(TvInputManager.TAG, "The session has been already released");
                return;
            }
            try {
                this.mService.releaseSession(this.mToken, this.mUserId);
                releaseInternal();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void removeOverlayView() {
            if (this.mToken == null) {
                Log.w(TvInputManager.TAG, "The session has been already released");
                return;
            }
            try {
                this.mService.removeOverlayView(this.mToken, this.mUserId);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void requestUnblockContent(TvContentRating tvContentRating) {
            if (this.mToken == null) {
                Log.w(TvInputManager.TAG, "The session has been already released");
            } else if (tvContentRating == null) {
                throw new IllegalArgumentException("unblockedRating cannot be null");
            } else {
                try {
                    this.mService.requestUnblockContent(this.mToken, tvContentRating.flattenToString(), this.mUserId);
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public void selectTrack(int i, String str) {
            synchronized (this.mTrackLock) {
                if (i == 0) {
                    if (str != null && !containsTrack(this.mAudioTracks, str)) {
                        Log.w(TvInputManager.TAG, "Invalid audio trackId: " + str);
                        return;
                    }
                } else if (i == 1) {
                    if (str != null && !containsTrack(this.mVideoTracks, str)) {
                        Log.w(TvInputManager.TAG, "Invalid video trackId: " + str);
                        return;
                    }
                } else if (i != 2) {
                    throw new IllegalArgumentException("invalid type: " + i);
                } else {
                    if (str != null && !containsTrack(this.mSubtitleTracks, str)) {
                        Log.w(TvInputManager.TAG, "Invalid subtitle trackId: " + str);
                        return;
                    }
                }
                if (this.mToken == null) {
                    Log.w(TvInputManager.TAG, "The session has been already released");
                    return;
                }
                try {
                    this.mService.selectTrack(this.mToken, i, str, this.mUserId);
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public void sendAppPrivateCommand(String str, Bundle bundle) {
            if (this.mToken == null) {
                Log.w(TvInputManager.TAG, "The session has been already released");
                return;
            }
            try {
                this.mService.sendAppPrivateCommand(this.mToken, str, bundle, this.mUserId);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        public void setCaptionEnabled(boolean z) {
            if (this.mToken == null) {
                Log.w(TvInputManager.TAG, "The session has been already released");
                return;
            }
            try {
                this.mService.setCaptionEnabled(this.mToken, z, this.mUserId);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setMain() {
            if (this.mToken == null) {
                Log.w(TvInputManager.TAG, "The session has been already released");
                return;
            }
            try {
                this.mService.setMainSession(this.mToken, this.mUserId);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        public void setStreamVolume(float f) {
            if (this.mToken == null) {
                Log.w(TvInputManager.TAG, "The session has been already released");
                return;
            }
            try {
                if (f < 0.0f || f > 1.0f) {
                    throw new IllegalArgumentException("volume should be between 0.0f and 1.0f");
                }
                this.mService.setVolume(this.mToken, f, this.mUserId);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        public void setSurface(Surface surface) {
            if (this.mToken == null) {
                Log.w(TvInputManager.TAG, "The session has been already released");
                return;
            }
            try {
                this.mService.setSurface(this.mToken, surface, this.mUserId);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        public void tune(Uri uri) {
            tune(uri, null);
        }

        public void tune(Uri uri, Bundle bundle) {
            if (uri == null) {
                throw new IllegalArgumentException("channelUri cannot be null");
            }
            if (this.mToken == null) {
                Log.w(TvInputManager.TAG, "The session has been already released");
                return;
            }
            synchronized (this.mTrackLock) {
                this.mAudioTracks.clear();
                this.mVideoTracks.clear();
                this.mSubtitleTracks.clear();
                this.mSelectedAudioTrackId = null;
                this.mSelectedVideoTrackId = null;
                this.mSelectedSubtitleTrackId = null;
                this.mVideoWidth = 0;
                this.mVideoHeight = 0;
            }
            try {
                this.mService.tune(this.mToken, uri, bundle, this.mUserId);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        boolean updateTrackSelection(int i, String str) {
            synchronized (this.mTrackLock) {
                if (i == 0) {
                    if (str != this.mSelectedAudioTrackId) {
                        this.mSelectedAudioTrackId = str;
                        return true;
                    }
                }
                if (i == 1 && str != this.mSelectedVideoTrackId) {
                    this.mSelectedVideoTrackId = str;
                    return true;
                } else if (i != 2 || str == this.mSelectedSubtitleTrackId) {
                    return false;
                } else {
                    this.mSelectedSubtitleTrackId = str;
                    return true;
                }
            }
        }

        boolean updateTracks(List<TvTrackInfo> list) {
            boolean z;
            synchronized (this.mTrackLock) {
                this.mAudioTracks.clear();
                this.mVideoTracks.clear();
                this.mSubtitleTracks.clear();
                for (TvTrackInfo tvTrackInfo : list) {
                    if (tvTrackInfo.getType() == 0) {
                        this.mAudioTracks.add(tvTrackInfo);
                    } else if (tvTrackInfo.getType() == 1) {
                        this.mVideoTracks.add(tvTrackInfo);
                    } else if (tvTrackInfo.getType() == 2) {
                        this.mSubtitleTracks.add(tvTrackInfo);
                    }
                }
                z = true;
                if (this.mAudioTracks.isEmpty()) {
                    z = true;
                    if (this.mVideoTracks.isEmpty()) {
                        z = !this.mSubtitleTracks.isEmpty();
                    }
                }
            }
            return z;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/tv/TvInputManager$SessionCallback.class */
    public static abstract class SessionCallback {
        public void onChannelRetuned(Session session, Uri uri) {
        }

        public void onContentAllowed(Session session) {
        }

        public void onContentBlocked(Session session, TvContentRating tvContentRating) {
        }

        public void onLayoutSurface(Session session, int i, int i2, int i3, int i4) {
        }

        public void onSessionCreated(Session session) {
        }

        public void onSessionEvent(Session session, String str, Bundle bundle) {
        }

        public void onSessionReleased(Session session) {
        }

        public void onTrackSelected(Session session, int i, String str) {
        }

        public void onTracksChanged(Session session, List<TvTrackInfo> list) {
        }

        public void onVideoAvailable(Session session) {
        }

        public void onVideoSizeChanged(Session session, int i, int i2) {
        }

        public void onVideoUnavailable(Session session, int i) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/tv/TvInputManager$SessionCallbackRecord.class */
    public static final class SessionCallbackRecord {
        private final Handler mHandler;
        private Session mSession;
        private final SessionCallback mSessionCallback;

        SessionCallbackRecord(SessionCallback sessionCallback, Handler handler) {
            this.mSessionCallback = sessionCallback;
            this.mHandler = handler;
        }

        void postChannelRetuned(final Uri uri) {
            this.mHandler.post(new Runnable() { // from class: android.media.tv.TvInputManager.SessionCallbackRecord.3
                @Override // java.lang.Runnable
                public void run() {
                    SessionCallbackRecord.this.mSessionCallback.onChannelRetuned(SessionCallbackRecord.this.mSession, uri);
                }
            });
        }

        void postContentAllowed() {
            this.mHandler.post(new Runnable() { // from class: android.media.tv.TvInputManager.SessionCallbackRecord.9
                @Override // java.lang.Runnable
                public void run() {
                    SessionCallbackRecord.this.mSessionCallback.onContentAllowed(SessionCallbackRecord.this.mSession);
                }
            });
        }

        void postContentBlocked(final TvContentRating tvContentRating) {
            this.mHandler.post(new Runnable() { // from class: android.media.tv.TvInputManager.SessionCallbackRecord.10
                @Override // java.lang.Runnable
                public void run() {
                    SessionCallbackRecord.this.mSessionCallback.onContentBlocked(SessionCallbackRecord.this.mSession, tvContentRating);
                }
            });
        }

        void postLayoutSurface(final int i, final int i2, final int i3, final int i4) {
            this.mHandler.post(new Runnable() { // from class: android.media.tv.TvInputManager.SessionCallbackRecord.11
                @Override // java.lang.Runnable
                public void run() {
                    SessionCallbackRecord.this.mSessionCallback.onLayoutSurface(SessionCallbackRecord.this.mSession, i, i2, i3, i4);
                }
            });
        }

        void postSessionCreated(final Session session) {
            this.mSession = session;
            this.mHandler.post(new Runnable() { // from class: android.media.tv.TvInputManager.SessionCallbackRecord.1
                @Override // java.lang.Runnable
                public void run() {
                    SessionCallbackRecord.this.mSessionCallback.onSessionCreated(session);
                }
            });
        }

        void postSessionEvent(final String str, final Bundle bundle) {
            this.mHandler.post(new Runnable() { // from class: android.media.tv.TvInputManager.SessionCallbackRecord.12
                @Override // java.lang.Runnable
                public void run() {
                    SessionCallbackRecord.this.mSessionCallback.onSessionEvent(SessionCallbackRecord.this.mSession, str, bundle);
                }
            });
        }

        void postSessionReleased() {
            this.mHandler.post(new Runnable() { // from class: android.media.tv.TvInputManager.SessionCallbackRecord.2
                @Override // java.lang.Runnable
                public void run() {
                    SessionCallbackRecord.this.mSessionCallback.onSessionReleased(SessionCallbackRecord.this.mSession);
                }
            });
        }

        void postTrackSelected(final int i, final String str) {
            this.mHandler.post(new Runnable() { // from class: android.media.tv.TvInputManager.SessionCallbackRecord.5
                @Override // java.lang.Runnable
                public void run() {
                    SessionCallbackRecord.this.mSessionCallback.onTrackSelected(SessionCallbackRecord.this.mSession, i, str);
                }
            });
        }

        void postTracksChanged(final List<TvTrackInfo> list) {
            this.mHandler.post(new Runnable() { // from class: android.media.tv.TvInputManager.SessionCallbackRecord.4
                @Override // java.lang.Runnable
                public void run() {
                    SessionCallbackRecord.this.mSessionCallback.onTracksChanged(SessionCallbackRecord.this.mSession, list);
                }
            });
        }

        void postVideoAvailable() {
            this.mHandler.post(new Runnable() { // from class: android.media.tv.TvInputManager.SessionCallbackRecord.7
                @Override // java.lang.Runnable
                public void run() {
                    SessionCallbackRecord.this.mSessionCallback.onVideoAvailable(SessionCallbackRecord.this.mSession);
                }
            });
        }

        void postVideoSizeChanged(final int i, final int i2) {
            this.mHandler.post(new Runnable() { // from class: android.media.tv.TvInputManager.SessionCallbackRecord.6
                @Override // java.lang.Runnable
                public void run() {
                    SessionCallbackRecord.this.mSessionCallback.onVideoSizeChanged(SessionCallbackRecord.this.mSession, i, i2);
                }
            });
        }

        void postVideoUnavailable(final int i) {
            this.mHandler.post(new Runnable() { // from class: android.media.tv.TvInputManager.SessionCallbackRecord.8
                @Override // java.lang.Runnable
                public void run() {
                    SessionCallbackRecord.this.mSessionCallback.onVideoUnavailable(SessionCallbackRecord.this.mSession, i);
                }
            });
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/tv/TvInputManager$TvInputCallback.class */
    public static abstract class TvInputCallback {
        public void onInputAdded(String str) {
        }

        public void onInputRemoved(String str) {
        }

        public void onInputStateChanged(String str, int i) {
        }

        public void onInputUpdated(String str) {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/tv/TvInputManager$TvInputCallbackRecord.class */
    private static final class TvInputCallbackRecord {
        private final TvInputCallback mCallback;
        private final Handler mHandler;

        public TvInputCallbackRecord(TvInputCallback tvInputCallback, Handler handler) {
            this.mCallback = tvInputCallback;
            this.mHandler = handler;
        }

        public TvInputCallback getCallback() {
            return this.mCallback;
        }

        public void postInputAdded(final String str) {
            this.mHandler.post(new Runnable() { // from class: android.media.tv.TvInputManager.TvInputCallbackRecord.2
                @Override // java.lang.Runnable
                public void run() {
                    TvInputCallbackRecord.this.mCallback.onInputAdded(str);
                }
            });
        }

        public void postInputRemoved(final String str) {
            this.mHandler.post(new Runnable() { // from class: android.media.tv.TvInputManager.TvInputCallbackRecord.3
                @Override // java.lang.Runnable
                public void run() {
                    TvInputCallbackRecord.this.mCallback.onInputRemoved(str);
                }
            });
        }

        public void postInputStateChanged(final String str, final int i) {
            this.mHandler.post(new Runnable() { // from class: android.media.tv.TvInputManager.TvInputCallbackRecord.1
                @Override // java.lang.Runnable
                public void run() {
                    TvInputCallbackRecord.this.mCallback.onInputStateChanged(str, i);
                }
            });
        }

        public void postInputUpdated(final String str) {
            this.mHandler.post(new Runnable() { // from class: android.media.tv.TvInputManager.TvInputCallbackRecord.4
                @Override // java.lang.Runnable
                public void run() {
                    TvInputCallbackRecord.this.mCallback.onInputUpdated(str);
                }
            });
        }
    }

    public TvInputManager(ITvInputManager iTvInputManager, int i) {
        this.mService = iTvInputManager;
        this.mUserId = i;
        try {
            if (this.mService != null) {
                this.mService.registerCallback(this.mManagerCallback, this.mUserId);
                List<TvInputInfo> tvInputList = this.mService.getTvInputList(this.mUserId);
                synchronized (this.mLock) {
                    for (TvInputInfo tvInputInfo : tvInputList) {
                        String id = tvInputInfo.getId();
                        int tvInputState = this.mService.getTvInputState(id, this.mUserId);
                        if (tvInputState != -1) {
                            this.mStateMap.put(id, Integer.valueOf(tvInputState));
                        }
                    }
                }
            }
        } catch (RemoteException e) {
            Log.e(TAG, "TvInputManager initialization failed: " + e);
        }
    }

    public Hardware acquireTvInputHardware(int i, final HardwareCallback hardwareCallback, TvInputInfo tvInputInfo) {
        try {
            return new Hardware(this.mService.acquireTvInputHardware(i, new ITvInputHardwareCallback.Stub() { // from class: android.media.tv.TvInputManager.3
                @Override // android.media.tv.ITvInputHardwareCallback
                public void onReleased() {
                    hardwareCallback.onReleased();
                }

                @Override // android.media.tv.ITvInputHardwareCallback
                public void onStreamConfigChanged(TvStreamConfig[] tvStreamConfigArr) {
                    hardwareCallback.onStreamConfigChanged(tvStreamConfigArr);
                }
            }, tvInputInfo, this.mUserId));
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void addBlockedRating(TvContentRating tvContentRating) {
        if (tvContentRating == null) {
            throw new IllegalArgumentException("rating cannot be null");
        }
        try {
            this.mService.addBlockedRating(tvContentRating.flattenToString(), this.mUserId);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean captureFrame(String str, Surface surface, TvStreamConfig tvStreamConfig) {
        try {
            return this.mService.captureFrame(str, surface, tvStreamConfig, this.mUserId);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void createSession(String str, SessionCallback sessionCallback, Handler handler) {
        if (str == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
        if (sessionCallback == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }
        if (handler == null) {
            throw new IllegalArgumentException("handler cannot be null");
        }
        SessionCallbackRecord sessionCallbackRecord = new SessionCallbackRecord(sessionCallback, handler);
        synchronized (this.mSessionCallbackRecordMap) {
            int i = this.mNextSeq;
            this.mNextSeq = i + 1;
            this.mSessionCallbackRecordMap.put(i, sessionCallbackRecord);
            try {
                this.mService.createSession(this.mClient, str, i, this.mUserId);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<TvStreamConfig> getAvailableTvStreamConfigList(String str) {
        try {
            return this.mService.getAvailableTvStreamConfigList(str, this.mUserId);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public List<TvContentRating> getBlockedRatings() {
        try {
            ArrayList arrayList = new ArrayList();
            for (String str : this.mService.getBlockedRatings(this.mUserId)) {
                arrayList.add(TvContentRating.unflattenFromString(str));
            }
            return arrayList;
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public List<TvInputHardwareInfo> getHardwareList() {
        try {
            return this.mService.getHardwareList();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public int getInputState(String str) {
        int intValue;
        if (str == null) {
            throw new IllegalArgumentException("inputId cannot be null");
        }
        synchronized (this.mLock) {
            Integer num = this.mStateMap.get(str);
            if (num == null) {
                throw new IllegalArgumentException("Unrecognized input ID: " + str);
            }
            intValue = num.intValue();
        }
        return intValue;
    }

    public List<TvContentRatingSystemInfo> getTvContentRatingSystemList() {
        try {
            return this.mService.getTvContentRatingSystemList(this.mUserId);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public TvInputInfo getTvInputInfo(String str) {
        if (str == null) {
            throw new IllegalArgumentException("inputId cannot be null");
        }
        try {
            return this.mService.getTvInputInfo(str, this.mUserId);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public List<TvInputInfo> getTvInputList() {
        try {
            return this.mService.getTvInputList(this.mUserId);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isParentalControlsEnabled() {
        try {
            return this.mService.isParentalControlsEnabled(this.mUserId);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isRatingBlocked(TvContentRating tvContentRating) {
        if (tvContentRating == null) {
            throw new IllegalArgumentException("rating cannot be null");
        }
        try {
            return this.mService.isRatingBlocked(tvContentRating.flattenToString(), this.mUserId);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isSingleSessionActive() {
        try {
            return this.mService.isSingleSessionActive(this.mUserId);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void registerCallback(TvInputCallback tvInputCallback, Handler handler) {
        if (tvInputCallback == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }
        if (handler == null) {
            throw new IllegalArgumentException("handler cannot be null");
        }
        synchronized (this.mLock) {
            this.mCallbackRecords.add(new TvInputCallbackRecord(tvInputCallback, handler));
        }
    }

    public void releaseTvInputHardware(int i, Hardware hardware) {
        try {
            this.mService.releaseTvInputHardware(i, hardware.getInterface(), this.mUserId);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeBlockedRating(TvContentRating tvContentRating) {
        if (tvContentRating == null) {
            throw new IllegalArgumentException("rating cannot be null");
        }
        try {
            this.mService.removeBlockedRating(tvContentRating.flattenToString(), this.mUserId);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void setParentalControlsEnabled(boolean z) {
        try {
            this.mService.setParentalControlsEnabled(z, this.mUserId);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void unregisterCallback(TvInputCallback tvInputCallback) {
        if (tvInputCallback == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }
        synchronized (this.mLock) {
            Iterator<TvInputCallbackRecord> it = this.mCallbackRecords.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().getCallback() == tvInputCallback) {
                    it.remove();
                    break;
                }
            }
        }
    }
}
