package android.telecom;

import android.net.Uri;
import android.net.wifi.WifiEnterpriseConfig;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.Surface;
import com.android.internal.telecom.IConnectionService;
import com.android.internal.telecom.IVideoCallback;
import com.android.internal.telecom.IVideoProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-9557208-dex2jar.jar:android/telecom/RemoteConnection.class */
public final class RemoteConnection {
    private Uri mAddress;
    private int mAddressPresentation;
    private int mCallProperties;
    private int mCallSubstate;
    private final Set<Callback> mCallbacks;
    private String mCallerDisplayName;
    private int mCallerDisplayNamePresentation;
    private RemoteConference mConference;
    private final List<RemoteConnection> mConferenceableConnections;
    private boolean mConnected;
    private int mConnectionCapabilities;
    private final String mConnectionId;
    private IConnectionService mConnectionService;
    private DisconnectCause mDisconnectCause;
    private boolean mIsVoipAudioMode;
    private boolean mRingbackRequested;
    private int mState;
    private StatusHints mStatusHints;
    private final List<RemoteConnection> mUnmodifiableconferenceableConnections;
    private VideoProvider mVideoProvider;
    private int mVideoState;

    /* loaded from: source-9557208-dex2jar.jar:android/telecom/RemoteConnection$Callback.class */
    public static abstract class Callback {
        public void onAddressChanged(RemoteConnection remoteConnection, Uri uri, int i) {
        }

        @Deprecated
        public void onCallCapabilitiesChanged(RemoteConnection remoteConnection, int i) {
        }

        public void onCallPropertiesChanged(RemoteConnection remoteConnection, int i) {
        }

        public void onCallSubstateChanged(RemoteConnection remoteConnection, int i) {
        }

        public void onCallerDisplayNameChanged(RemoteConnection remoteConnection, String str, int i) {
        }

        public void onConferenceChanged(RemoteConnection remoteConnection, RemoteConference remoteConference) {
        }

        public void onConferenceableConnectionsChanged(RemoteConnection remoteConnection, List<RemoteConnection> list) {
        }

        public void onConnectionCapabilitiesChanged(RemoteConnection remoteConnection, int i) {
        }

        public void onDestroyed(RemoteConnection remoteConnection) {
        }

        public void onDisconnected(RemoteConnection remoteConnection, DisconnectCause disconnectCause) {
        }

        public void onPostDialChar(RemoteConnection remoteConnection, char c2) {
        }

        public void onPostDialWait(RemoteConnection remoteConnection, String str) {
        }

        public void onRingbackRequested(RemoteConnection remoteConnection, boolean z) {
        }

        public void onStateChanged(RemoteConnection remoteConnection, int i) {
        }

        public void onStatusHintsChanged(RemoteConnection remoteConnection, StatusHints statusHints) {
        }

        public void onVideoProviderChanged(RemoteConnection remoteConnection, VideoProvider videoProvider) {
        }

        public void onVideoStateChanged(RemoteConnection remoteConnection, int i) {
        }

        public void onVoipAudioChanged(RemoteConnection remoteConnection, boolean z) {
        }

        public void setPhoneAccountHandle(RemoteConnection remoteConnection, PhoneAccountHandle phoneAccountHandle) {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/telecom/RemoteConnection$VideoProvider.class */
    public static class VideoProvider {
        private final IVideoProvider mVideoProviderBinder;
        private final IVideoCallback mVideoCallbackDelegate = new IVideoCallback() { // from class: android.telecom.RemoteConnection.VideoProvider.1
            @Override // android.os.IInterface
            public IBinder asBinder() {
                return null;
            }

            @Override // com.android.internal.telecom.IVideoCallback
            public void changeCallDataUsage(int i) {
                for (Listener listener : VideoProvider.this.mListeners) {
                    listener.onCallDataUsageChanged(VideoProvider.this, i);
                }
            }

            @Override // com.android.internal.telecom.IVideoCallback
            public void changeCameraCapabilities(CameraCapabilities cameraCapabilities) {
                for (Listener listener : VideoProvider.this.mListeners) {
                    listener.onCameraCapabilitiesChanged(VideoProvider.this, cameraCapabilities);
                }
            }

            @Override // com.android.internal.telecom.IVideoCallback
            public void changePeerDimensions(int i, int i2) {
                for (Listener listener : VideoProvider.this.mListeners) {
                    listener.onPeerDimensionsChanged(VideoProvider.this, i, i2);
                }
            }

            @Override // com.android.internal.telecom.IVideoCallback
            public void changeVideoQuality(int i) {
                for (Listener listener : VideoProvider.this.mListeners) {
                    listener.onVideoQualityChanged(VideoProvider.this, i);
                }
            }

            @Override // com.android.internal.telecom.IVideoCallback
            public void handleCallSessionEvent(int i) {
                for (Listener listener : VideoProvider.this.mListeners) {
                    listener.onHandleCallSessionEvent(VideoProvider.this, i);
                }
            }

            @Override // com.android.internal.telecom.IVideoCallback
            public void receiveSessionModifyRequest(VideoProfile videoProfile) {
                for (Listener listener : VideoProvider.this.mListeners) {
                    listener.onReceiveSessionModifyRequest(VideoProvider.this, videoProfile);
                }
            }

            @Override // com.android.internal.telecom.IVideoCallback
            public void receiveSessionModifyResponse(int i, VideoProfile videoProfile, VideoProfile videoProfile2) {
                for (Listener listener : VideoProvider.this.mListeners) {
                    listener.onReceiveSessionModifyResponse(VideoProvider.this, i, videoProfile, videoProfile2);
                }
            }
        };
        private final VideoCallbackServant mVideoCallbackServant = new VideoCallbackServant(this.mVideoCallbackDelegate);
        private final Set<Listener> mListeners = Collections.newSetFromMap(new ConcurrentHashMap(8, 0.9f, 1));

        /* loaded from: source-9557208-dex2jar.jar:android/telecom/RemoteConnection$VideoProvider$Listener.class */
        public static abstract class Listener {
            public void onCallDataUsageChanged(VideoProvider videoProvider, int i) {
            }

            public void onCameraCapabilitiesChanged(VideoProvider videoProvider, CameraCapabilities cameraCapabilities) {
            }

            public void onHandleCallSessionEvent(VideoProvider videoProvider, int i) {
            }

            public void onPeerDimensionsChanged(VideoProvider videoProvider, int i, int i2) {
            }

            public void onReceiveSessionModifyRequest(VideoProvider videoProvider, VideoProfile videoProfile) {
            }

            public void onReceiveSessionModifyResponse(VideoProvider videoProvider, int i, VideoProfile videoProfile, VideoProfile videoProfile2) {
            }

            public void onVideoQualityChanged(VideoProvider videoProvider, int i) {
            }
        }

        public VideoProvider(IVideoProvider iVideoProvider) {
            this.mVideoProviderBinder = iVideoProvider;
            try {
                this.mVideoProviderBinder.setVideoCallback(this.mVideoCallbackServant.getStub().asBinder());
            } catch (RemoteException e) {
            }
        }

        public void addListener(Listener listener) {
            this.mListeners.add(listener);
        }

        public void removeListener(Listener listener) {
            this.mListeners.remove(listener);
        }

        public void requestCallDataUsage() {
            try {
                this.mVideoProviderBinder.requestCallDataUsage();
            } catch (RemoteException e) {
            }
        }

        public void requestCameraCapabilities() {
            try {
                this.mVideoProviderBinder.requestCameraCapabilities();
            } catch (RemoteException e) {
            }
        }

        public void sendSessionModifyRequest(VideoProfile videoProfile) {
            try {
                this.mVideoProviderBinder.sendSessionModifyRequest(videoProfile);
            } catch (RemoteException e) {
            }
        }

        public void sendSessionModifyResponse(VideoProfile videoProfile) {
            try {
                this.mVideoProviderBinder.sendSessionModifyResponse(videoProfile);
            } catch (RemoteException e) {
            }
        }

        public void setCamera(String str) {
            try {
                this.mVideoProviderBinder.setCamera(str);
            } catch (RemoteException e) {
            }
        }

        public void setDeviceOrientation(int i) {
            try {
                this.mVideoProviderBinder.setDeviceOrientation(i);
            } catch (RemoteException e) {
            }
        }

        public void setDisplaySurface(Surface surface) {
            try {
                this.mVideoProviderBinder.setDisplaySurface(surface);
            } catch (RemoteException e) {
            }
        }

        public void setPauseImage(String str) {
            try {
                this.mVideoProviderBinder.setPauseImage(str);
            } catch (RemoteException e) {
            }
        }

        public void setPreviewSurface(Surface surface) {
            try {
                this.mVideoProviderBinder.setPreviewSurface(surface);
            } catch (RemoteException e) {
            }
        }

        public void setZoom(float f) {
            try {
                this.mVideoProviderBinder.setZoom(f);
            } catch (RemoteException e) {
            }
        }
    }

    RemoteConnection(DisconnectCause disconnectCause) {
        this.mCallbacks = Collections.newSetFromMap(new ConcurrentHashMap(8, 0.9f, 1));
        this.mConferenceableConnections = new ArrayList();
        this.mUnmodifiableconferenceableConnections = Collections.unmodifiableList(this.mConferenceableConnections);
        this.mState = 1;
        this.mConnectionId = WifiEnterpriseConfig.EMPTY_VALUE;
        this.mConnected = false;
        this.mState = 6;
        this.mDisconnectCause = disconnectCause;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RemoteConnection(String str, IConnectionService iConnectionService, ConnectionRequest connectionRequest) {
        this.mCallbacks = Collections.newSetFromMap(new ConcurrentHashMap(8, 0.9f, 1));
        this.mConferenceableConnections = new ArrayList();
        this.mUnmodifiableconferenceableConnections = Collections.unmodifiableList(this.mConferenceableConnections);
        this.mState = 1;
        this.mConnectionId = str;
        this.mConnectionService = iConnectionService;
        this.mConnected = true;
        this.mState = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RemoteConnection(String str, IConnectionService iConnectionService, ParcelableConnection parcelableConnection) {
        this.mCallbacks = Collections.newSetFromMap(new ConcurrentHashMap(8, 0.9f, 1));
        this.mConferenceableConnections = new ArrayList();
        this.mUnmodifiableconferenceableConnections = Collections.unmodifiableList(this.mConferenceableConnections);
        this.mState = 1;
        this.mConnectionId = str;
        this.mConnectionService = iConnectionService;
        this.mConnected = true;
        this.mState = parcelableConnection.getState();
        this.mDisconnectCause = parcelableConnection.getDisconnectCause();
        this.mRingbackRequested = parcelableConnection.isRingbackRequested();
        this.mConnectionCapabilities = parcelableConnection.getConnectionCapabilities();
        this.mVideoState = parcelableConnection.getVideoState();
        this.mVideoProvider = new VideoProvider(parcelableConnection.getVideoProvider());
        this.mIsVoipAudioMode = parcelableConnection.getIsVoipAudioMode();
        this.mStatusHints = parcelableConnection.getStatusHints();
        this.mAddress = parcelableConnection.getHandle();
        this.mAddressPresentation = parcelableConnection.getHandlePresentation();
        this.mCallerDisplayName = parcelableConnection.getCallerDisplayName();
        this.mCallerDisplayNamePresentation = parcelableConnection.getCallerDisplayNamePresentation();
        this.mConference = null;
    }

    public static RemoteConnection failure(DisconnectCause disconnectCause) {
        return new RemoteConnection(disconnectCause);
    }

    public void abort() {
        try {
            if (this.mConnected) {
                this.mConnectionService.abort(this.mConnectionId);
            }
        } catch (RemoteException e) {
        }
    }

    public void answer() {
        try {
            if (this.mConnected) {
                this.mConnectionService.answer(this.mConnectionId);
            }
        } catch (RemoteException e) {
        }
    }

    public void answer(int i) {
        try {
            if (this.mConnected) {
                this.mConnectionService.answerVideo(this.mConnectionId, i);
            }
        } catch (RemoteException e) {
        }
    }

    public void disconnect() {
        try {
            if (this.mConnected) {
                this.mConnectionService.disconnect(this.mConnectionId);
            }
        } catch (RemoteException e) {
        }
    }

    public Uri getAddress() {
        return this.mAddress;
    }

    public int getAddressPresentation() {
        return this.mAddressPresentation;
    }

    public int getCallProperties() {
        return this.mCallProperties;
    }

    public int getCallSubstate() {
        return this.mCallSubstate;
    }

    public CharSequence getCallerDisplayName() {
        return this.mCallerDisplayName;
    }

    public int getCallerDisplayNamePresentation() {
        return this.mCallerDisplayNamePresentation;
    }

    public RemoteConference getConference() {
        return this.mConference;
    }

    public List<RemoteConnection> getConferenceableConnections() {
        return this.mUnmodifiableconferenceableConnections;
    }

    public int getConnectionCapabilities() {
        return this.mConnectionCapabilities;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IConnectionService getConnectionService() {
        return this.mConnectionService;
    }

    public DisconnectCause getDisconnectCause() {
        return this.mDisconnectCause;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getId() {
        return this.mConnectionId;
    }

    public int getState() {
        return this.mState;
    }

    public StatusHints getStatusHints() {
        return this.mStatusHints;
    }

    public final VideoProvider getVideoProvider() {
        return this.mVideoProvider;
    }

    public int getVideoState() {
        return this.mVideoState;
    }

    public void hold() {
        try {
            if (this.mConnected) {
                this.mConnectionService.hold(this.mConnectionId);
            }
        } catch (RemoteException e) {
        }
    }

    public boolean isRingbackRequested() {
        return false;
    }

    public boolean isVoipAudioMode() {
        return this.mIsVoipAudioMode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPostDialChar(char c2) {
        for (Callback callback : this.mCallbacks) {
            callback.onPostDialChar(this, c2);
        }
    }

    public void playDtmfTone(char c2) {
        try {
            if (this.mConnected) {
                this.mConnectionService.playDtmfTone(this.mConnectionId, c2);
            }
        } catch (RemoteException e) {
        }
    }

    public void postDialContinue(boolean z) {
        try {
            if (this.mConnected) {
                this.mConnectionService.onPostDialContinue(this.mConnectionId, z);
            }
        } catch (RemoteException e) {
        }
    }

    public void registerCallback(Callback callback) {
        this.mCallbacks.add(callback);
    }

    public void reject() {
        try {
            if (this.mConnected) {
                this.mConnectionService.reject(this.mConnectionId);
            }
        } catch (RemoteException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAddress(Uri uri, int i) {
        this.mAddress = uri;
        this.mAddressPresentation = i;
        for (Callback callback : this.mCallbacks) {
            callback.onAddressChanged(this, uri, i);
        }
    }

    public void setAudioState(AudioState audioState) {
        try {
            if (this.mConnected) {
                this.mConnectionService.onAudioStateChanged(this.mConnectionId, audioState);
            }
        } catch (RemoteException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCallProperties(int i) {
        this.mCallProperties = i;
        for (Callback callback : this.mCallbacks) {
            callback.onCallPropertiesChanged(this, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCallSubstate(int i) {
        this.mCallSubstate = i;
        for (Callback callback : this.mCallbacks) {
            callback.onCallSubstateChanged(this, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCallerDisplayName(String str, int i) {
        this.mCallerDisplayName = str;
        this.mCallerDisplayNamePresentation = i;
        for (Callback callback : this.mCallbacks) {
            callback.onCallerDisplayNameChanged(this, str, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setConference(RemoteConference remoteConference) {
        if (this.mConference != remoteConference) {
            this.mConference = remoteConference;
            for (Callback callback : this.mCallbacks) {
                callback.onConferenceChanged(this, remoteConference);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setConferenceableConnections(List<RemoteConnection> list) {
        this.mConferenceableConnections.clear();
        this.mConferenceableConnections.addAll(list);
        for (Callback callback : this.mCallbacks) {
            callback.onConferenceableConnectionsChanged(this, this.mUnmodifiableconferenceableConnections);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setConnectionCapabilities(int i) {
        this.mConnectionCapabilities = i;
        for (Callback callback : this.mCallbacks) {
            callback.onConnectionCapabilitiesChanged(this, i);
            callback.onCallCapabilitiesChanged(this, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDestroyed() {
        if (this.mCallbacks.isEmpty()) {
            return;
        }
        if (this.mState != 6) {
            setDisconnected(new DisconnectCause(1, "Connection destroyed."));
        }
        for (Callback callback : this.mCallbacks) {
            callback.onDestroyed(this);
        }
        this.mCallbacks.clear();
        this.mConnected = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDisconnected(DisconnectCause disconnectCause) {
        if (this.mState != 6) {
            this.mState = 6;
            this.mDisconnectCause = disconnectCause;
            for (Callback callback : this.mCallbacks) {
                callback.onDisconnected(this, this.mDisconnectCause);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIsVoipAudioMode(boolean z) {
        this.mIsVoipAudioMode = z;
        for (Callback callback : this.mCallbacks) {
            callback.onVoipAudioChanged(this, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPhoneAccountHandle(PhoneAccountHandle phoneAccountHandle) {
        for (Callback callback : this.mCallbacks) {
            callback.setPhoneAccountHandle(this, phoneAccountHandle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPostDialWait(String str) {
        for (Callback callback : this.mCallbacks) {
            callback.onPostDialWait(this, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRingbackRequested(boolean z) {
        if (this.mRingbackRequested != z) {
            this.mRingbackRequested = z;
            for (Callback callback : this.mCallbacks) {
                callback.onRingbackRequested(this, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setState(int i) {
        if (this.mState != i) {
            this.mState = i;
            for (Callback callback : this.mCallbacks) {
                callback.onStateChanged(this, i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStatusHints(StatusHints statusHints) {
        this.mStatusHints = statusHints;
        for (Callback callback : this.mCallbacks) {
            callback.onStatusHintsChanged(this, statusHints);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setVideoProvider(VideoProvider videoProvider) {
        this.mVideoProvider = videoProvider;
        for (Callback callback : this.mCallbacks) {
            callback.onVideoProviderChanged(this, videoProvider);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setVideoState(int i) {
        this.mVideoState = i;
        for (Callback callback : this.mCallbacks) {
            callback.onVideoStateChanged(this, i);
        }
    }

    public void stopDtmfTone() {
        try {
            if (this.mConnected) {
                this.mConnectionService.stopDtmfTone(this.mConnectionId);
            }
        } catch (RemoteException e) {
        }
    }

    public void unhold() {
        try {
            if (this.mConnected) {
                this.mConnectionService.unhold(this.mConnectionId);
            }
        } catch (RemoteException e) {
        }
    }

    public void unregisterCallback(Callback callback) {
        if (callback != null) {
            this.mCallbacks.remove(callback);
        }
    }
}
