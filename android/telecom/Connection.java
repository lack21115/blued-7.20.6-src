package android.telecom;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.telecom.Conference;
import android.view.Surface;
import com.android.internal.telecom.IVideoCallback;
import com.android.internal.telecom.IVideoProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-9557208-dex2jar.jar:android/telecom/Connection.class */
public abstract class Connection implements IConferenceable {
    public static final int ADD_PARTICIPANT = 32768;
    public static final int CALL_SUBSTATE_ALL = 15;
    public static final int CALL_SUBSTATE_AUDIO_CONNECTED_SUSPENDED = 1;
    public static final int CALL_SUBSTATE_AVP_RETRY = 4;
    public static final int CALL_SUBSTATE_MEDIA_PAUSED = 8;
    public static final int CALL_SUBSTATE_NONE = 0;
    public static final int CALL_SUBSTATE_VIDEO_CONNECTED_SUSPENDED = 2;
    public static final int CALL_TYPE_MODIFIABLE = 131072;
    public static final int CAPABILITY_DISCONNECT_FROM_CONFERENCE = 8192;
    public static final int CAPABILITY_GENERIC_CONFERENCE = 16384;
    public static final int CAPABILITY_HIGH_DEF_AUDIO = 1024;
    public static final int CAPABILITY_HOLD = 1;
    public static final int CAPABILITY_MANAGE_CONFERENCE = 128;
    public static final int CAPABILITY_MERGE_CONFERENCE = 4;
    public static final int CAPABILITY_MUTE = 64;
    public static final int CAPABILITY_RESPOND_VIA_TEXT = 32;
    public static final int CAPABILITY_SEPARATE_FROM_CONFERENCE = 4096;
    public static final int CAPABILITY_SPEED_UP_MT_AUDIO = 262144;
    public static final int CAPABILITY_SUPPORTS_VT_LOCAL = 256;
    public static final int CAPABILITY_SUPPORTS_VT_REMOTE = 512;
    public static final int CAPABILITY_SUPPORT_HOLD = 2;
    public static final int CAPABILITY_SWAP_CONFERENCE = 8;
    public static final int CAPABILITY_UNUSED = 16;
    public static final int CAPABILITY_VoWIFI = 2048;
    private static final boolean DBG = false;
    private static final boolean PII_DEBUG = Log.isLoggable(3);
    public static final int STATE_ACTIVE = 4;
    public static final int STATE_DIALING = 3;
    public static final int STATE_DISCONNECTED = 6;
    public static final int STATE_HOLDING = 5;
    public static final int STATE_INITIALIZING = 0;
    public static final int STATE_NEW = 1;
    public static final int STATE_RINGING = 2;
    private Uri mAddress;
    private int mAddressPresentation;
    private boolean mAudioModeIsVoip;
    private AudioState mAudioState;
    private int mCallProperties;
    private int mCallSubstate;
    private String mCallerDisplayName;
    private int mCallerDisplayNamePresentation;
    private Conference mConference;
    private int mConnectionCapabilities;
    private ConnectionService mConnectionService;
    private DisconnectCause mDisconnectCause;
    private StatusHints mStatusHints;
    private VideoProvider mVideoProvider;
    private int mVideoState;
    private final Listener mConnectionDeathListener = new Listener() { // from class: android.telecom.Connection.1
        @Override // android.telecom.Connection.Listener
        public void onDestroyed(Connection connection) {
            if (Connection.this.mConferenceables.remove(connection)) {
                Connection.this.fireOnConferenceableConnectionsChanged();
            }
        }
    };
    private final Conference.Listener mConferenceDeathListener = new Conference.Listener() { // from class: android.telecom.Connection.2
        @Override // android.telecom.Conference.Listener
        public void onDestroyed(Conference conference) {
            if (Connection.this.mConferenceables.remove(conference)) {
                Connection.this.fireOnConferenceableConnectionsChanged();
            }
        }
    };
    private final Set<Listener> mListeners = Collections.newSetFromMap(new ConcurrentHashMap(8, 0.9f, 1));
    private final List<IConferenceable> mConferenceables = new ArrayList();
    private final List<IConferenceable> mUnmodifiableConferenceables = Collections.unmodifiableList(this.mConferenceables);
    private int mState = 1;
    private boolean mRingbackRequested = false;
    private PhoneAccountHandle mPhoneAccountHandle = null;

    /* loaded from: source-9557208-dex2jar.jar:android/telecom/Connection$FailureSignalingConnection.class */
    private static class FailureSignalingConnection extends Connection {
        private boolean mImmutable;

        public FailureSignalingConnection(DisconnectCause disconnectCause) {
            this.mImmutable = false;
            setDisconnected(disconnectCause);
            this.mImmutable = true;
        }

        @Override // android.telecom.Connection
        public void checkImmutable() {
            if (this.mImmutable) {
                throw new UnsupportedOperationException("Connection is immutable");
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/telecom/Connection$Listener.class */
    public static abstract class Listener {
        public void onAddressChanged(Connection connection, Uri uri, int i) {
        }

        public void onAudioModeIsVoipChanged(Connection connection, boolean z) {
        }

        public void onCallPropertiesChanged(Connection connection, int i) {
        }

        public void onCallSubstateChanged(Connection connection, int i) {
        }

        public void onCallerDisplayNameChanged(Connection connection, String str, int i) {
        }

        public void onConferenceChanged(Connection connection, Conference conference) {
        }

        public void onConferenceParticipantsChanged(Connection connection, List<ConferenceParticipant> list) {
        }

        public void onConferenceStarted() {
        }

        public void onConferenceablesChanged(Connection connection, List<IConferenceable> list) {
        }

        public void onConnectionCapabilitiesChanged(Connection connection, int i) {
        }

        public void onDestroyed(Connection connection) {
        }

        public void onDisconnected(Connection connection, DisconnectCause disconnectCause) {
        }

        public void onExtrasUpdated(Connection connection, Bundle bundle) {
        }

        public void onPhoneAccountChanged(Connection connection, PhoneAccountHandle phoneAccountHandle) {
        }

        public void onPostDialChar(Connection connection, char c2) {
        }

        public void onPostDialWait(Connection connection, String str) {
        }

        public void onRingbackRequested(Connection connection, boolean z) {
        }

        public void onStateChanged(Connection connection, int i) {
        }

        public void onStatusHintsChanged(Connection connection, StatusHints statusHints) {
        }

        public void onVideoProviderChanged(Connection connection, VideoProvider videoProvider) {
        }

        public void onVideoStateChanged(Connection connection, int i) {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/telecom/Connection$VideoProvider.class */
    public static abstract class VideoProvider {
        private static final int MSG_REQUEST_CAMERA_CAPABILITIES = 9;
        private static final int MSG_REQUEST_CONNECTION_DATA_USAGE = 10;
        private static final int MSG_SEND_SESSION_MODIFY_REQUEST = 7;
        private static final int MSG_SEND_SESSION_MODIFY_RESPONSE = 8;
        private static final int MSG_SET_CAMERA = 2;
        private static final int MSG_SET_DEVICE_ORIENTATION = 5;
        private static final int MSG_SET_DISPLAY_SURFACE = 4;
        private static final int MSG_SET_PAUSE_IMAGE = 11;
        private static final int MSG_SET_PREVIEW_SURFACE = 3;
        private static final int MSG_SET_VIDEO_CALLBACK = 1;
        private static final int MSG_SET_ZOOM = 6;
        public static final int SESSION_EVENT_CAMERA_FAILURE = 5;
        public static final int SESSION_EVENT_CAMERA_READY = 6;
        public static final int SESSION_EVENT_RX_PAUSE = 1;
        public static final int SESSION_EVENT_RX_RESUME = 2;
        public static final int SESSION_EVENT_TX_START = 3;
        public static final int SESSION_EVENT_TX_STOP = 4;
        public static final int SESSION_MODIFY_REQUEST_FAIL = 2;
        public static final int SESSION_MODIFY_REQUEST_INVALID = 3;
        public static final int SESSION_MODIFY_REQUEST_REJECTED_BY_REMOTE = 5;
        public static final int SESSION_MODIFY_REQUEST_SUCCESS = 1;
        public static final int SESSION_MODIFY_REQUEST_TIMED_OUT = 4;
        private IVideoCallback mVideoCallback;
        private final VideoProviderHandler mMessageHandler = new VideoProviderHandler();
        private final VideoProviderBinder mBinder = new VideoProviderBinder();

        /* loaded from: source-9557208-dex2jar.jar:android/telecom/Connection$VideoProvider$VideoProviderBinder.class */
        private final class VideoProviderBinder extends IVideoProvider.Stub {
            private VideoProviderBinder() {
            }

            @Override // com.android.internal.telecom.IVideoProvider
            public void requestCallDataUsage() {
                VideoProvider.this.mMessageHandler.obtainMessage(10).sendToTarget();
            }

            @Override // com.android.internal.telecom.IVideoProvider
            public void requestCameraCapabilities() {
                VideoProvider.this.mMessageHandler.obtainMessage(9).sendToTarget();
            }

            @Override // com.android.internal.telecom.IVideoProvider
            public void sendSessionModifyRequest(VideoProfile videoProfile) {
                VideoProvider.this.mMessageHandler.obtainMessage(7, videoProfile).sendToTarget();
            }

            @Override // com.android.internal.telecom.IVideoProvider
            public void sendSessionModifyResponse(VideoProfile videoProfile) {
                VideoProvider.this.mMessageHandler.obtainMessage(8, videoProfile).sendToTarget();
            }

            @Override // com.android.internal.telecom.IVideoProvider
            public void setCamera(String str) {
                VideoProvider.this.mMessageHandler.obtainMessage(2, str).sendToTarget();
            }

            @Override // com.android.internal.telecom.IVideoProvider
            public void setDeviceOrientation(int i) {
                VideoProvider.this.mMessageHandler.obtainMessage(5, i, 0).sendToTarget();
            }

            @Override // com.android.internal.telecom.IVideoProvider
            public void setDisplaySurface(Surface surface) {
                VideoProvider.this.mMessageHandler.obtainMessage(4, surface).sendToTarget();
            }

            @Override // com.android.internal.telecom.IVideoProvider
            public void setPauseImage(String str) {
                VideoProvider.this.mMessageHandler.obtainMessage(11, str).sendToTarget();
            }

            @Override // com.android.internal.telecom.IVideoProvider
            public void setPreviewSurface(Surface surface) {
                VideoProvider.this.mMessageHandler.obtainMessage(3, surface).sendToTarget();
            }

            @Override // com.android.internal.telecom.IVideoProvider
            public void setVideoCallback(IBinder iBinder) {
                VideoProvider.this.mMessageHandler.obtainMessage(1, iBinder).sendToTarget();
            }

            @Override // com.android.internal.telecom.IVideoProvider
            public void setZoom(float f) {
                VideoProvider.this.mMessageHandler.obtainMessage(6, Float.valueOf(f)).sendToTarget();
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/telecom/Connection$VideoProvider$VideoProviderHandler.class */
        private final class VideoProviderHandler extends Handler {
            private VideoProviderHandler() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        VideoProvider.this.mVideoCallback = IVideoCallback.Stub.asInterface((IBinder) message.obj);
                        return;
                    case 2:
                        VideoProvider.this.onSetCamera((String) message.obj);
                        return;
                    case 3:
                        VideoProvider.this.onSetPreviewSurface((Surface) message.obj);
                        return;
                    case 4:
                        VideoProvider.this.onSetDisplaySurface((Surface) message.obj);
                        return;
                    case 5:
                        VideoProvider.this.onSetDeviceOrientation(message.arg1);
                        return;
                    case 6:
                        VideoProvider.this.onSetZoom(((Float) message.obj).floatValue());
                        return;
                    case 7:
                        VideoProvider.this.onSendSessionModifyRequest((VideoProfile) message.obj);
                        return;
                    case 8:
                        VideoProvider.this.onSendSessionModifyResponse((VideoProfile) message.obj);
                        return;
                    case 9:
                        VideoProvider.this.onRequestCameraCapabilities();
                        return;
                    case 10:
                        VideoProvider.this.onRequestConnectionDataUsage();
                        return;
                    case 11:
                        VideoProvider.this.onSetPauseImage((String) message.obj);
                        return;
                    default:
                        return;
                }
            }
        }

        public void changeCallDataUsage(int i) {
            if (this.mVideoCallback != null) {
                try {
                    this.mVideoCallback.changeCallDataUsage(i);
                } catch (RemoteException e) {
                }
            }
        }

        public void changeCameraCapabilities(CameraCapabilities cameraCapabilities) {
            if (this.mVideoCallback != null) {
                try {
                    this.mVideoCallback.changeCameraCapabilities(cameraCapabilities);
                } catch (RemoteException e) {
                }
            }
        }

        public void changePeerDimensions(int i, int i2) {
            if (this.mVideoCallback != null) {
                try {
                    this.mVideoCallback.changePeerDimensions(i, i2);
                } catch (RemoteException e) {
                }
            }
        }

        public void changeVideoQuality(int i) {
            if (this.mVideoCallback != null) {
                try {
                    this.mVideoCallback.changeVideoQuality(i);
                } catch (RemoteException e) {
                }
            }
        }

        public final IVideoProvider getInterface() {
            return this.mBinder;
        }

        public void handleCallSessionEvent(int i) {
            if (this.mVideoCallback != null) {
                try {
                    this.mVideoCallback.handleCallSessionEvent(i);
                } catch (RemoteException e) {
                }
            }
        }

        public abstract void onRequestCameraCapabilities();

        public abstract void onRequestConnectionDataUsage();

        public abstract void onSendSessionModifyRequest(VideoProfile videoProfile);

        public abstract void onSendSessionModifyResponse(VideoProfile videoProfile);

        public abstract void onSetCamera(String str);

        public abstract void onSetDeviceOrientation(int i);

        public abstract void onSetDisplaySurface(Surface surface);

        public abstract void onSetPauseImage(String str);

        public abstract void onSetPreviewSurface(Surface surface);

        public abstract void onSetZoom(float f);

        public void receiveSessionModifyRequest(VideoProfile videoProfile) {
            if (this.mVideoCallback != null) {
                try {
                    this.mVideoCallback.receiveSessionModifyRequest(videoProfile);
                } catch (RemoteException e) {
                }
            }
        }

        public void receiveSessionModifyResponse(int i, VideoProfile videoProfile, VideoProfile videoProfile2) {
            if (this.mVideoCallback != null) {
                try {
                    this.mVideoCallback.receiveSessionModifyResponse(i, videoProfile, videoProfile2);
                } catch (RemoteException e) {
                }
            }
        }
    }

    public static boolean can(int i, int i2) {
        return (i & i2) != 0;
    }

    public static String capabilitiesToString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("[Capabilities:");
        if (can(i, 1)) {
            sb.append(" CAPABILITY_HOLD");
        }
        if (can(i, 2)) {
            sb.append(" CAPABILITY_SUPPORT_HOLD");
        }
        if (can(i, 4)) {
            sb.append(" CAPABILITY_MERGE_CONFERENCE");
        }
        if (can(i, 8)) {
            sb.append(" CAPABILITY_SWAP_CONFERENCE");
        }
        if (can(i, 32)) {
            sb.append(" CAPABILITY_RESPOND_VIA_TEXT");
        }
        if (can(i, 64)) {
            sb.append(" CAPABILITY_MUTE");
        }
        if (can(i, 128)) {
            sb.append(" CAPABILITY_MANAGE_CONFERENCE");
        }
        if (can(i, 256)) {
            sb.append(" CAPABILITY_SUPPORTS_VT_LOCAL");
        }
        if (can(i, 512)) {
            sb.append(" CAPABILITY_SUPPORTS_VT_REMOTE");
        }
        if (can(i, 1024)) {
            sb.append(" CAPABILITY_HIGH_DEF_AUDIO");
        }
        if (can(i, 2048)) {
            sb.append(" CAPABILITY_VoWIFI");
        }
        if (can(i, 16384)) {
            sb.append(" CAPABILITY_GENERIC_CONFERENCE");
        }
        if (can(i, 131072)) {
            sb.append(" CALL_TYPE_MODIFIABLE");
        }
        if (can(i, 32768)) {
            sb.append(" ADD_PARTICIPANT");
        }
        if (can(i, 262144)) {
            sb.append(" CAPABILITY_SPEED_UP_IMS_MT_AUDIO");
        }
        sb.append("]");
        return sb.toString();
    }

    private final void clearConferenceableList() {
        for (IConferenceable iConferenceable : this.mConferenceables) {
            if (iConferenceable instanceof Connection) {
                ((Connection) iConferenceable).removeConnectionListener(this.mConnectionDeathListener);
            } else if (iConferenceable instanceof Conference) {
                ((Conference) iConferenceable).removeListener(this.mConferenceDeathListener);
            }
        }
        this.mConferenceables.clear();
    }

    public static Connection createCanceledConnection() {
        return new FailureSignalingConnection(new DisconnectCause(4));
    }

    public static Connection createFailedConnection(DisconnectCause disconnectCause) {
        return new FailureSignalingConnection(disconnectCause);
    }

    private final void fireConferenceChanged() {
        for (Listener listener : this.mListeners) {
            listener.onConferenceChanged(this, this.mConference);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fireOnConferenceableConnectionsChanged() {
        for (Listener listener : this.mListeners) {
            listener.onConferenceablesChanged(this, getConferenceables());
        }
    }

    private void setState(int i) {
        checkImmutable();
        if (this.mState == 6 && this.mState != i) {
            Log.d(this, "Connection already DISCONNECTED; cannot transition out of this state.", new Object[0]);
        } else if (this.mState != i) {
            Log.d(this, "setState: %s", stateToString(i));
            this.mState = i;
            onStateChanged(i);
            for (Listener listener : this.mListeners) {
                listener.onStateChanged(this, i);
            }
        }
    }

    public static String stateToString(int i) {
        switch (i) {
            case 0:
                return "STATE_INITIALIZING";
            case 1:
                return "STATE_NEW";
            case 2:
                return "STATE_RINGING";
            case 3:
                return "STATE_DIALING";
            case 4:
                return "STATE_ACTIVE";
            case 5:
                return "STATE_HOLDING";
            case 6:
                return "DISCONNECTED";
            default:
                Log.wtf(Connection.class, "Unknown state %d", Integer.valueOf(i));
                return "UNKNOWN";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String toLogSafePhoneNumber(String str) {
        String str2;
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
            if (!PII_DEBUG) {
                StringBuilder sb = new StringBuilder();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= str.length()) {
                        return sb.toString();
                    }
                    char charAt = str.charAt(i2);
                    if (charAt == '-' || charAt == '@' || charAt == '.') {
                        sb.append(charAt);
                    } else {
                        sb.append('x');
                    }
                    i = i2 + 1;
                }
            }
        }
        return str2;
    }

    public void addCapability(int i) {
        this.mConnectionCapabilities |= i;
    }

    public final Connection addConnectionListener(Listener listener) {
        this.mListeners.add(listener);
        return this;
    }

    public boolean can(int i) {
        return can(this.mConnectionCapabilities, i);
    }

    public void checkImmutable() {
    }

    public final void destroy() {
        for (Listener listener : this.mListeners) {
            listener.onDestroyed(this);
        }
    }

    public final Uri getAddress() {
        return this.mAddress;
    }

    public final int getAddressPresentation() {
        return this.mAddressPresentation;
    }

    public final boolean getAudioModeIsVoip() {
        return this.mAudioModeIsVoip;
    }

    public final AudioState getAudioState() {
        return this.mAudioState;
    }

    @Deprecated
    public final int getCallCapabilities() {
        return getConnectionCapabilities();
    }

    public final int getCallProperties() {
        return this.mCallProperties;
    }

    public final int getCallSubstate() {
        return this.mCallSubstate;
    }

    public final String getCallerDisplayName() {
        return this.mCallerDisplayName;
    }

    public final int getCallerDisplayNamePresentation() {
        return this.mCallerDisplayNamePresentation;
    }

    public final Conference getConference() {
        return this.mConference;
    }

    public final List<IConferenceable> getConferenceables() {
        return this.mUnmodifiableConferenceables;
    }

    public final int getConnectionCapabilities() {
        return this.mConnectionCapabilities;
    }

    public final ConnectionService getConnectionService() {
        return this.mConnectionService;
    }

    public final DisconnectCause getDisconnectCause() {
        return this.mDisconnectCause;
    }

    public final PhoneAccountHandle getPhoneAccountHandle() {
        return this.mPhoneAccountHandle;
    }

    public final int getState() {
        return this.mState;
    }

    public final StatusHints getStatusHints() {
        return this.mStatusHints;
    }

    public final VideoProvider getVideoProvider() {
        return this.mVideoProvider;
    }

    public final int getVideoState() {
        return this.mVideoState;
    }

    public final boolean isRingbackRequested() {
        return this.mRingbackRequested;
    }

    protected void notifyConferenceStarted() {
        for (Listener listener : this.mListeners) {
            listener.onConferenceStarted();
        }
    }

    public void onAbort() {
    }

    public void onAnswer() {
        onAnswer(0);
    }

    public void onAnswer(int i) {
    }

    public void onAudioStateChanged(AudioState audioState) {
    }

    public void onConferenceChanged() {
    }

    public void onConferenceWith(Connection connection) {
    }

    public void onDeflect(String str) {
    }

    public void onDisconnect() {
    }

    public void onDisconnectConferenceParticipant(Uri uri) {
    }

    public void onHold() {
    }

    public void onPlayDtmfTone(char c2) {
    }

    public void onPostDialContinue(boolean z) {
    }

    public void onReject() {
    }

    public void onSeparate() {
    }

    public void onStateChanged(int i) {
    }

    public void onStopDtmfTone() {
    }

    public void onUnhold() {
    }

    public void removeCapability(int i) {
        this.mConnectionCapabilities &= i ^ (-1);
    }

    public final Connection removeConnectionListener(Listener listener) {
        if (listener != null) {
            this.mListeners.remove(listener);
        }
        return this;
    }

    public final void resetConference() {
        if (this.mConference != null) {
            Log.d(this, "Conference reset", new Object[0]);
            this.mConference = null;
            fireConferenceChanged();
        }
    }

    public final void setActive() {
        checkImmutable();
        setRingbackRequested(false);
        setState(4);
    }

    public void setActiveSubscription() {
    }

    public final void setAddress(Uri uri, int i) {
        checkImmutable();
        Log.d(this, "setAddress %s", uri);
        this.mAddress = uri;
        this.mAddressPresentation = i;
        for (Listener listener : this.mListeners) {
            listener.onAddressChanged(this, uri, i);
        }
    }

    public final void setAudioModeIsVoip(boolean z) {
        checkImmutable();
        this.mAudioModeIsVoip = z;
        for (Listener listener : this.mListeners) {
            listener.onAudioModeIsVoipChanged(this, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setAudioState(AudioState audioState) {
        checkImmutable();
        Log.d(this, "setAudioState %s", audioState);
        this.mAudioState = audioState;
        onAudioStateChanged(audioState);
    }

    @Deprecated
    public final void setCallCapabilities(int i) {
        setConnectionCapabilities(i);
    }

    public final void setCallProperties(int i) {
        if (this.mCallProperties != i) {
            this.mCallProperties = i;
            for (Listener listener : this.mListeners) {
                listener.onCallPropertiesChanged(this, this.mCallProperties);
            }
        }
    }

    public final void setCallSubstate(int i) {
        Log.d(this, "setCallSubstate %d", Integer.valueOf(i));
        this.mCallSubstate = i;
        for (Listener listener : this.mListeners) {
            listener.onCallSubstateChanged(this, this.mCallSubstate);
        }
    }

    public final void setCallerDisplayName(String str, int i) {
        checkImmutable();
        Log.d(this, "setCallerDisplayName %s", str);
        this.mCallerDisplayName = str;
        this.mCallerDisplayNamePresentation = i;
        for (Listener listener : this.mListeners) {
            listener.onCallerDisplayNameChanged(this, str, i);
        }
    }

    public final boolean setConference(Conference conference) {
        checkImmutable();
        if (this.mConference == null) {
            this.mConference = conference;
            if (this.mConnectionService == null || !this.mConnectionService.containsConference(conference)) {
                return true;
            }
            fireConferenceChanged();
            onConferenceChanged();
            return true;
        }
        return false;
    }

    public final void setConferenceableConnections(List<Connection> list) {
        checkImmutable();
        clearConferenceableList();
        for (Connection connection : list) {
            if (!this.mConferenceables.contains(connection)) {
                connection.addConnectionListener(this.mConnectionDeathListener);
                this.mConferenceables.add(connection);
            }
        }
        fireOnConferenceableConnectionsChanged();
    }

    public final void setConferenceables(List<IConferenceable> list) {
        clearConferenceableList();
        for (IConferenceable iConferenceable : list) {
            if (!this.mConferenceables.contains(iConferenceable)) {
                if (iConferenceable instanceof Connection) {
                    ((Connection) iConferenceable).addConnectionListener(this.mConnectionDeathListener);
                } else if (iConferenceable instanceof Conference) {
                    ((Conference) iConferenceable).addListener(this.mConferenceDeathListener);
                }
                this.mConferenceables.add(iConferenceable);
            }
        }
        fireOnConferenceableConnectionsChanged();
    }

    public final void setConnectionCapabilities(int i) {
        checkImmutable();
        if (this.mConnectionCapabilities != i) {
            this.mConnectionCapabilities = i;
            for (Listener listener : this.mListeners) {
                listener.onConnectionCapabilitiesChanged(this, this.mConnectionCapabilities);
            }
        }
    }

    public final void setConnectionService(ConnectionService connectionService) {
        checkImmutable();
        if (this.mConnectionService != null) {
            Log.e(this, new Exception(), "Trying to set ConnectionService on a connection which is already associated with another ConnectionService.", new Object[0]);
        } else {
            this.mConnectionService = connectionService;
        }
    }

    public final void setDialing() {
        checkImmutable();
        setState(3);
    }

    public final void setDisconnected(DisconnectCause disconnectCause) {
        checkImmutable();
        this.mDisconnectCause = disconnectCause;
        setState(6);
        Log.d(this, "Disconnected with cause %s", disconnectCause);
        for (Listener listener : this.mListeners) {
            listener.onDisconnected(this, disconnectCause);
        }
    }

    public final void setExtras(Bundle bundle) {
        for (Listener listener : this.mListeners) {
            listener.onExtrasUpdated(this, bundle);
        }
    }

    public final void setInitialized() {
        checkImmutable();
        setState(1);
    }

    public final void setInitializing() {
        checkImmutable();
        setState(0);
    }

    public void setLocalCallHold(int i) {
    }

    public final void setNextPostDialWaitChar(char c2) {
        checkImmutable();
        for (Listener listener : this.mListeners) {
            listener.onPostDialChar(this, c2);
        }
    }

    public final void setOnHold() {
        checkImmutable();
        setState(5);
    }

    public final void setPhoneAccountHandle(PhoneAccountHandle phoneAccountHandle) {
        this.mPhoneAccountHandle = phoneAccountHandle;
        for (Listener listener : this.mListeners) {
            listener.onPhoneAccountChanged(this, phoneAccountHandle);
        }
    }

    public final void setPostDialWait(String str) {
        checkImmutable();
        for (Listener listener : this.mListeners) {
            listener.onPostDialWait(this, str);
        }
    }

    public final void setRingbackRequested(boolean z) {
        checkImmutable();
        if (this.mRingbackRequested != z) {
            this.mRingbackRequested = z;
            for (Listener listener : this.mListeners) {
                listener.onRingbackRequested(this, z);
            }
        }
    }

    public final void setRinging() {
        checkImmutable();
        setState(2);
    }

    public final void setStatusHints(StatusHints statusHints) {
        checkImmutable();
        this.mStatusHints = statusHints;
        for (Listener listener : this.mListeners) {
            listener.onStatusHintsChanged(this, statusHints);
        }
    }

    public final void setVideoProvider(VideoProvider videoProvider) {
        checkImmutable();
        this.mVideoProvider = videoProvider;
        for (Listener listener : this.mListeners) {
            listener.onVideoProviderChanged(this, videoProvider);
        }
    }

    public final void setVideoState(int i) {
        checkImmutable();
        Log.d(this, "setVideoState %d", Integer.valueOf(i));
        this.mVideoState = i;
        for (Listener listener : this.mListeners) {
            listener.onVideoStateChanged(this, this.mVideoState);
        }
    }

    public final void unsetConnectionService(ConnectionService connectionService) {
        if (this.mConnectionService != connectionService) {
            Log.e(this, new Exception(), "Trying to remove ConnectionService from a Connection that does not belong to the ConnectionService.", new Object[0]);
        } else {
            this.mConnectionService = null;
        }
    }

    protected final void updateConferenceParticipants(List<ConferenceParticipant> list) {
        for (Listener listener : this.mListeners) {
            listener.onConferenceParticipantsChanged(this, list);
        }
    }
}
