package android.telecom;

import android.telecom.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: source-9557208-dex2jar.jar:android/telecom/Conference.class */
public abstract class Conference implements IConferenceable {
    public static long CONNECT_TIME_NOT_SPECIFIED = 0;
    public static final long NO_CONNECTTIME = 0;
    private AudioState mAudioState;
    private int mConnectionCapabilities;
    private DisconnectCause mDisconnectCause;
    private String mDisconnectMessage;
    protected PhoneAccountHandle mPhoneAccount;
    private final Set<Listener> mListeners = new CopyOnWriteArraySet();
    private final List<Connection> mChildConnections = new CopyOnWriteArrayList();
    private final List<Connection> mUnmodifiableChildConnections = Collections.unmodifiableList(this.mChildConnections);
    private final List<Connection> mConferenceableConnections = new ArrayList();
    private final List<Connection> mUnmodifiableConferenceableConnections = Collections.unmodifiableList(this.mConferenceableConnections);
    private int mState = 1;
    private long mConnectTimeMillis = 0;
    private final Connection.Listener mConnectionDeathListener = new Connection.Listener() { // from class: android.telecom.Conference.1
        @Override // android.telecom.Connection.Listener
        public void onDestroyed(Connection connection) {
            if (Conference.this.mConferenceableConnections.remove(connection)) {
                Conference.this.fireOnConferenceableConnectionsChanged();
            }
        }
    };

    /* loaded from: source-9557208-dex2jar.jar:android/telecom/Conference$Listener.class */
    public static abstract class Listener {
        public void onConferenceableConnectionsChanged(Conference conference, List<Connection> list) {
        }

        public void onConnectionAdded(Conference conference, Connection connection) {
        }

        public void onConnectionCapabilitiesChanged(Conference conference, int i) {
        }

        public void onConnectionRemoved(Conference conference, Connection connection) {
        }

        public void onDestroyed(Conference conference) {
        }

        public void onDisconnected(Conference conference, DisconnectCause disconnectCause) {
        }

        public void onStateChanged(Conference conference, int i, int i2) {
        }

        public void onVideoProviderChanged(Conference conference, Connection.VideoProvider videoProvider) {
        }

        public void onVideoStateChanged(Conference conference, int i) {
        }
    }

    public Conference(PhoneAccountHandle phoneAccountHandle) {
        this.mPhoneAccount = phoneAccountHandle;
    }

    public static boolean can(int i, int i2) {
        return (i & i2) != 0;
    }

    private final void clearConferenceableList() {
        for (Connection connection : this.mConferenceableConnections) {
            connection.removeConnectionListener(this.mConnectionDeathListener);
        }
        this.mConferenceableConnections.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fireOnConferenceableConnectionsChanged() {
        for (Listener listener : this.mListeners) {
            listener.onConferenceableConnectionsChanged(this, getConferenceableConnections());
        }
    }

    private void setState(int i) {
        if (i != 4 && i != 3 && i != 5 && i != 6) {
            Log.w(this, "Unsupported state transition for Conference call.", Connection.stateToString(i));
        } else if (this.mState != i) {
            int i2 = this.mState;
            this.mState = i;
            for (Listener listener : this.mListeners) {
                listener.onStateChanged(this, i2, i);
            }
        }
    }

    public void addCapability(int i) {
        setConnectionCapabilities(this.mConnectionCapabilities | i);
    }

    public final boolean addConnection(Connection connection) {
        boolean z;
        Log.d(this, "Connection=%s, connection=", connection);
        if (connection != null && !this.mChildConnections.contains(connection) && connection.setConference(this)) {
            this.mChildConnections.add(connection);
            onConnectionAdded(connection);
            Iterator<Listener> it = this.mListeners.iterator();
            while (true) {
                z = true;
                if (!it.hasNext()) {
                    break;
                }
                it.next().onConnectionAdded(this, connection);
            }
        } else {
            z = false;
        }
        return z;
    }

    public final Conference addListener(Listener listener) {
        this.mListeners.add(listener);
        return this;
    }

    public boolean can(int i) {
        return can(this.mConnectionCapabilities, i);
    }

    public final void destroy() {
        Log.d(this, "destroying conference : %s", this);
        for (Connection connection : this.mChildConnections) {
            Log.d(this, "removing connection %s", connection);
            removeConnection(connection);
        }
        if (this.mState != 6) {
            Log.d(this, "setting to disconnected", new Object[0]);
            setDisconnected(new DisconnectCause(2));
        }
        for (Listener listener : this.mListeners) {
            listener.onDestroyed(this);
        }
    }

    public final AudioState getAudioState() {
        return this.mAudioState;
    }

    @Deprecated
    public final int getCapabilities() {
        return getConnectionCapabilities();
    }

    public final List<Connection> getConferenceableConnections() {
        return this.mUnmodifiableConferenceableConnections;
    }

    public long getConnectTimeMillis() {
        return this.mConnectTimeMillis;
    }

    public final int getConnectionCapabilities() {
        return this.mConnectionCapabilities;
    }

    public final List<Connection> getConnections() {
        return this.mUnmodifiableChildConnections;
    }

    public final DisconnectCause getDisconnectCause() {
        return this.mDisconnectCause;
    }

    public final PhoneAccountHandle getPhoneAccountHandle() {
        return this.mPhoneAccount;
    }

    public Connection getPrimaryConnection() {
        if (this.mUnmodifiableChildConnections == null || this.mUnmodifiableChildConnections.isEmpty()) {
            return null;
        }
        return this.mUnmodifiableChildConnections.get(0);
    }

    public final int getState() {
        return this.mState;
    }

    public Connection.VideoProvider getVideoProvider() {
        return null;
    }

    public int getVideoState() {
        return 0;
    }

    public void onAddParticipant(String str) {
    }

    public void onAudioStateChanged(AudioState audioState) {
    }

    public void onConnectionAdded(Connection connection) {
    }

    public void onDisconnect() {
    }

    public void onHold() {
    }

    public void onMerge() {
    }

    public void onMerge(Connection connection) {
    }

    public void onPlayDtmfTone(char c2) {
    }

    public void onSeparate(Connection connection) {
    }

    public void onStopDtmfTone() {
    }

    public void onSwap() {
    }

    public void onUnhold() {
    }

    public void removeCapability(int i) {
        setConnectionCapabilities(this.mConnectionCapabilities & (i ^ (-1)));
    }

    public final void removeConnection(Connection connection) {
        Log.d(this, "removing %s from %s", connection, this.mChildConnections);
        if (connection == null || !this.mChildConnections.remove(connection)) {
            return;
        }
        connection.resetConference();
        for (Listener listener : this.mListeners) {
            listener.onConnectionRemoved(this, connection);
        }
    }

    public final Conference removeListener(Listener listener) {
        this.mListeners.remove(listener);
        return this;
    }

    public final void setActive() {
        setState(4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setAudioState(AudioState audioState) {
        Log.d(this, "setAudioState %s", audioState);
        this.mAudioState = audioState;
        onAudioStateChanged(audioState);
    }

    @Deprecated
    public final void setCapabilities(int i) {
        setConnectionCapabilities(i);
    }

    public final void setConferenceableConnections(List<Connection> list) {
        clearConferenceableList();
        for (Connection connection : list) {
            if (!this.mConferenceableConnections.contains(connection)) {
                connection.addConnectionListener(this.mConnectionDeathListener);
                this.mConferenceableConnections.add(connection);
            }
        }
        fireOnConferenceableConnectionsChanged();
    }

    public void setConnectTimeMillis(long j) {
        this.mConnectTimeMillis = j;
    }

    public final void setConnectionCapabilities(int i) {
        if (i != this.mConnectionCapabilities) {
            this.mConnectionCapabilities = i;
            for (Listener listener : this.mListeners) {
                listener.onConnectionCapabilitiesChanged(this, this.mConnectionCapabilities);
            }
        }
    }

    public final void setDialing() {
        setState(3);
    }

    public final void setDisconnected(DisconnectCause disconnectCause) {
        this.mDisconnectCause = disconnectCause;
        setState(6);
        for (Listener listener : this.mListeners) {
            listener.onDisconnected(this, this.mDisconnectCause);
        }
    }

    public final void setOnHold() {
        setState(5);
    }

    public final void setVideoProvider(Connection connection, Connection.VideoProvider videoProvider) {
        Log.d(this, "setVideoProvider Conference: %s Connection: %s VideoState: %s", this, connection, videoProvider);
        for (Listener listener : this.mListeners) {
            listener.onVideoProviderChanged(this, videoProvider);
        }
    }

    public final void setVideoState(Connection connection, int i) {
        Log.d(this, "setVideoState Conference: %s Connection: %s VideoState: %s", this, connection, Integer.valueOf(i));
        for (Listener listener : this.mListeners) {
            listener.onVideoStateChanged(this, i);
        }
    }

    public String toString() {
        return String.format(Locale.US, "[State: %s,Capabilites: %s, VideoState: %s, VideoProvider: %s, ThisObject %s]", Connection.stateToString(this.mState), PhoneCapabilities.toString(this.mConnectionCapabilities), Integer.valueOf(getVideoState()), getVideoProvider(), super.toString());
    }
}
