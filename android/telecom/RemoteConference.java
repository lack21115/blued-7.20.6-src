package android.telecom;

import android.os.RemoteException;
import com.android.internal.telecom.IConnectionService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: source-9557208-dex2jar.jar:android/telecom/RemoteConference.class */
public final class RemoteConference {
    private int mCallProperties;
    private int mConnectionCapabilities;
    private final IConnectionService mConnectionService;
    private DisconnectCause mDisconnectCause;
    private final String mId;
    private final Set<Callback> mCallbacks = new CopyOnWriteArraySet();
    private final List<RemoteConnection> mChildConnections = new CopyOnWriteArrayList();
    private final List<RemoteConnection> mUnmodifiableChildConnections = Collections.unmodifiableList(this.mChildConnections);
    private final List<RemoteConnection> mConferenceableConnections = new ArrayList();
    private final List<RemoteConnection> mUnmodifiableConferenceableConnections = Collections.unmodifiableList(this.mConferenceableConnections);
    private int mState = 1;

    /* loaded from: source-9557208-dex2jar.jar:android/telecom/RemoteConference$Callback.class */
    public static abstract class Callback {
        public void onConferenceableConnectionsChanged(RemoteConference remoteConference, List<RemoteConnection> list) {
        }

        public void onConnectionAdded(RemoteConference remoteConference, RemoteConnection remoteConnection) {
        }

        public void onConnectionCapabilitiesChanged(RemoteConference remoteConference, int i) {
        }

        public void onConnectionRemoved(RemoteConference remoteConference, RemoteConnection remoteConnection) {
        }

        public void onDestroyed(RemoteConference remoteConference) {
        }

        public void onDisconnected(RemoteConference remoteConference, DisconnectCause disconnectCause) {
        }

        public void onPropertiesChanged(RemoteConference remoteConference, int i) {
        }

        public void onStateChanged(RemoteConference remoteConference, int i, int i2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RemoteConference(String str, IConnectionService iConnectionService) {
        this.mId = str;
        this.mConnectionService = iConnectionService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addConnection(RemoteConnection remoteConnection) {
        if (this.mChildConnections.contains(remoteConnection)) {
            return;
        }
        this.mChildConnections.add(remoteConnection);
        remoteConnection.setConference(this);
        for (Callback callback : this.mCallbacks) {
            callback.onConnectionAdded(this, remoteConnection);
        }
    }

    public void disconnect() {
        try {
            this.mConnectionService.disconnect(this.mId);
        } catch (RemoteException e) {
        }
    }

    @Deprecated
    public final int getCallCapabilities() {
        return getConnectionCapabilities();
    }

    public final int getCallProperties() {
        return this.mCallProperties;
    }

    public List<RemoteConnection> getConferenceableConnections() {
        return this.mUnmodifiableConferenceableConnections;
    }

    public final int getConnectionCapabilities() {
        return this.mConnectionCapabilities;
    }

    public final List<RemoteConnection> getConnections() {
        return this.mUnmodifiableChildConnections;
    }

    public DisconnectCause getDisconnectCause() {
        return this.mDisconnectCause;
    }

    String getId() {
        return this.mId;
    }

    public final int getState() {
        return this.mState;
    }

    public void hold() {
        try {
            this.mConnectionService.hold(this.mId);
        } catch (RemoteException e) {
        }
    }

    public void merge() {
        try {
            this.mConnectionService.mergeConference(this.mId);
        } catch (RemoteException e) {
        }
    }

    public void playDtmfTone(char c2) {
        try {
            this.mConnectionService.playDtmfTone(this.mId, c2);
        } catch (RemoteException e) {
        }
    }

    public final void registerCallback(Callback callback) {
        this.mCallbacks.add(callback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeConnection(RemoteConnection remoteConnection) {
        if (this.mChildConnections.contains(remoteConnection)) {
            this.mChildConnections.remove(remoteConnection);
            remoteConnection.setConference(null);
            for (Callback callback : this.mCallbacks) {
                callback.onConnectionRemoved(this, remoteConnection);
            }
        }
    }

    public void separate(RemoteConnection remoteConnection) {
        if (this.mChildConnections.contains(remoteConnection)) {
            try {
                this.mConnectionService.splitFromConference(remoteConnection.getId());
            } catch (RemoteException e) {
            }
        }
    }

    public void setAudioState(AudioState audioState) {
        try {
            this.mConnectionService.onAudioStateChanged(this.mId, audioState);
        } catch (RemoteException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCallProperties(int i) {
        if (this.mCallProperties != i) {
            this.mCallProperties = i;
            for (Callback callback : this.mCallbacks) {
                callback.onPropertiesChanged(this, this.mCallProperties);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setConferenceableConnections(List<RemoteConnection> list) {
        this.mConferenceableConnections.clear();
        this.mConferenceableConnections.addAll(list);
        for (Callback callback : this.mCallbacks) {
            callback.onConferenceableConnectionsChanged(this, this.mUnmodifiableConferenceableConnections);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setConnectionCapabilities(int i) {
        if (this.mConnectionCapabilities != i) {
            this.mConnectionCapabilities = i;
            for (Callback callback : this.mCallbacks) {
                callback.onConnectionCapabilitiesChanged(this, this.mConnectionCapabilities);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDestroyed() {
        for (RemoteConnection remoteConnection : this.mChildConnections) {
            remoteConnection.setConference(null);
        }
        for (Callback callback : this.mCallbacks) {
            callback.onDestroyed(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDisconnected(DisconnectCause disconnectCause) {
        if (this.mState != 6) {
            this.mDisconnectCause = disconnectCause;
            setState(6);
            for (Callback callback : this.mCallbacks) {
                callback.onDisconnected(this, disconnectCause);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setState(int i) {
        if (i != 4 && i != 5 && i != 6) {
            Log.w(this, "Unsupported state transition for Conference call.", Connection.stateToString(i));
        } else if (this.mState != i) {
            int i2 = this.mState;
            this.mState = i;
            for (Callback callback : this.mCallbacks) {
                callback.onStateChanged(this, i2, i);
            }
        }
    }

    public void stopDtmfTone() {
        try {
            this.mConnectionService.stopDtmfTone(this.mId);
        } catch (RemoteException e) {
        }
    }

    public void swap() {
        try {
            this.mConnectionService.swapConference(this.mId);
        } catch (RemoteException e) {
        }
    }

    public void unhold() {
        try {
            this.mConnectionService.unhold(this.mId);
        } catch (RemoteException e) {
        }
    }

    public final void unregisterCallback(Callback callback) {
        this.mCallbacks.remove(callback);
    }
}
