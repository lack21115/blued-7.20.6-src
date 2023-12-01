package android.telecom;

import android.net.Uri;
import android.net.wifi.WifiEnterpriseConfig;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.telecom.RemoteConference;
import android.telecom.RemoteConnection;
import com.android.internal.telecom.IConnectionService;
import com.android.internal.telecom.IConnectionServiceAdapter;
import com.android.internal.telecom.IVideoProvider;
import com.android.internal.telecom.RemoteServiceCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/telecom/RemoteConnectionService.class */
public final class RemoteConnectionService {
    private final ConnectionService mOurConnectionServiceImpl;
    private final IConnectionService mOutgoingConnectionServiceRpc;
    private static final RemoteConnection NULL_CONNECTION = new RemoteConnection(WifiEnterpriseConfig.EMPTY_VALUE, (IConnectionService) null, (ConnectionRequest) null);
    private static final RemoteConference NULL_CONFERENCE = new RemoteConference(WifiEnterpriseConfig.EMPTY_VALUE, null);
    private final IConnectionServiceAdapter mServantDelegate = new IConnectionServiceAdapter() { // from class: android.telecom.RemoteConnectionService.1
        @Override // com.android.internal.telecom.IConnectionServiceAdapter
        public void addConferenceCall(final String str, ParcelableConference parcelableConference) {
            RemoteConference remoteConference = new RemoteConference(str, RemoteConnectionService.this.mOutgoingConnectionServiceRpc);
            for (String str2 : parcelableConference.getConnectionIds()) {
                RemoteConnection remoteConnection = (RemoteConnection) RemoteConnectionService.this.mConnectionById.get(str2);
                if (remoteConnection != null) {
                    remoteConference.addConnection(remoteConnection);
                }
            }
            if (remoteConference.getConnections().size() == 0) {
                return;
            }
            remoteConference.setState(parcelableConference.getState());
            remoteConference.setConnectionCapabilities(parcelableConference.getConnectionCapabilities());
            RemoteConnectionService.this.mConferenceById.put(str, remoteConference);
            remoteConference.registerCallback(new RemoteConference.Callback() { // from class: android.telecom.RemoteConnectionService.1.1
                @Override // android.telecom.RemoteConference.Callback
                public void onDestroyed(RemoteConference remoteConference2) {
                    RemoteConnectionService.this.mConferenceById.remove(str);
                    RemoteConnectionService.this.maybeDisconnectAdapter();
                }
            });
            RemoteConnectionService.this.mOurConnectionServiceImpl.addRemoteConference(remoteConference);
        }

        @Override // com.android.internal.telecom.IConnectionServiceAdapter
        public void addExistingConnection(String str, ParcelableConnection parcelableConnection) {
            RemoteConnectionService.this.mOurConnectionServiceImpl.addRemoteExistingConnection(new RemoteConnection(str, RemoteConnectionService.this.mOutgoingConnectionServiceRpc, parcelableConnection));
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            throw new UnsupportedOperationException();
        }

        @Override // com.android.internal.telecom.IConnectionServiceAdapter
        public void handleCreateConnectionComplete(String str, ConnectionRequest connectionRequest, ParcelableConnection parcelableConnection) {
            RemoteConnection findConnectionForAction = RemoteConnectionService.this.findConnectionForAction(str, "handleCreateConnectionSuccessful");
            if (findConnectionForAction == RemoteConnectionService.NULL_CONNECTION || !RemoteConnectionService.this.mPendingConnections.contains(findConnectionForAction)) {
                return;
            }
            RemoteConnectionService.this.mPendingConnections.remove(findConnectionForAction);
            findConnectionForAction.setConnectionCapabilities(parcelableConnection.getConnectionCapabilities());
            findConnectionForAction.setCallProperties(parcelableConnection.getProperties());
            findConnectionForAction.setAddress(parcelableConnection.getHandle(), parcelableConnection.getHandlePresentation());
            findConnectionForAction.setCallerDisplayName(parcelableConnection.getCallerDisplayName(), parcelableConnection.getCallerDisplayNamePresentation());
            if (parcelableConnection.getState() == 6) {
                findConnectionForAction.setDisconnected(parcelableConnection.getDisconnectCause());
            } else {
                findConnectionForAction.setState(parcelableConnection.getState());
            }
            ArrayList arrayList = new ArrayList();
            for (String str2 : parcelableConnection.getConferenceableConnectionIds()) {
                if (RemoteConnectionService.this.mConnectionById.containsKey(str2)) {
                    arrayList.add(RemoteConnectionService.this.mConnectionById.get(str2));
                }
            }
            findConnectionForAction.setConferenceableConnections(arrayList);
            findConnectionForAction.setVideoState(parcelableConnection.getVideoState());
            findConnectionForAction.setCallSubstate(parcelableConnection.getCallSubstate());
            if (findConnectionForAction.getState() == 6) {
                findConnectionForAction.setDestroyed();
            }
        }

        @Override // com.android.internal.telecom.IConnectionServiceAdapter
        public void onPostDialChar(String str, char c2) {
            RemoteConnectionService.this.findConnectionForAction(str, "onPostDialChar").onPostDialChar(c2);
        }

        @Override // com.android.internal.telecom.IConnectionServiceAdapter
        public void onPostDialWait(String str, String str2) {
            RemoteConnectionService.this.findConnectionForAction(str, "onPostDialWait").setPostDialWait(str2);
        }

        @Override // com.android.internal.telecom.IConnectionServiceAdapter
        public void queryRemoteConnectionServices(RemoteServiceCallback remoteServiceCallback) {
        }

        @Override // com.android.internal.telecom.IConnectionServiceAdapter
        public void removeCall(String str) {
            if (RemoteConnectionService.this.mConnectionById.containsKey(str)) {
                RemoteConnectionService.this.findConnectionForAction(str, "removeCall").setDestroyed();
            } else {
                RemoteConnectionService.this.findConferenceForAction(str, "removeCall").setDestroyed();
            }
        }

        @Override // com.android.internal.telecom.IConnectionServiceAdapter
        public void setActive(String str) {
            if (RemoteConnectionService.this.mConnectionById.containsKey(str)) {
                RemoteConnectionService.this.findConnectionForAction(str, "setActive").setState(4);
            } else {
                RemoteConnectionService.this.findConferenceForAction(str, "setActive").setState(4);
            }
        }

        @Override // com.android.internal.telecom.IConnectionServiceAdapter
        public void setAddress(String str, Uri uri, int i) {
            RemoteConnectionService.this.findConnectionForAction(str, "setAddress").setAddress(uri, i);
        }

        @Override // com.android.internal.telecom.IConnectionServiceAdapter
        public void setCallProperties(String str, int i) {
            if (RemoteConnectionService.this.mConnectionById.containsKey(str)) {
                RemoteConnectionService.this.findConnectionForAction(str, "setCallProperties").setCallProperties(i);
            } else {
                RemoteConnectionService.this.findConferenceForAction(str, "setCallProperties").setCallProperties(i);
            }
        }

        @Override // com.android.internal.telecom.IConnectionServiceAdapter
        public void setCallSubstate(String str, int i) {
            RemoteConnectionService.this.findConnectionForAction(str, "callSubstate").setCallSubstate(i);
        }

        @Override // com.android.internal.telecom.IConnectionServiceAdapter
        public void setCallerDisplayName(String str, String str2, int i) {
            RemoteConnectionService.this.findConnectionForAction(str, "setCallerDisplayName").setCallerDisplayName(str2, i);
        }

        @Override // com.android.internal.telecom.IConnectionServiceAdapter
        public final void setConferenceableConnections(String str, List<String> list) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                if (RemoteConnectionService.this.mConnectionById.containsKey(str2)) {
                    arrayList.add(RemoteConnectionService.this.mConnectionById.get(str2));
                }
            }
            if (RemoteConnectionService.this.hasConnection(str)) {
                RemoteConnectionService.this.findConnectionForAction(str, "setConferenceableConnections").setConferenceableConnections(arrayList);
            } else {
                RemoteConnectionService.this.findConferenceForAction(str, "setConferenceableConnections").setConferenceableConnections(arrayList);
            }
        }

        @Override // com.android.internal.telecom.IConnectionServiceAdapter
        public void setConnectionCapabilities(String str, int i) {
            if (RemoteConnectionService.this.mConnectionById.containsKey(str)) {
                RemoteConnectionService.this.findConnectionForAction(str, "setConnectionCapabilities").setConnectionCapabilities(i);
            } else {
                RemoteConnectionService.this.findConferenceForAction(str, "setConnectionCapabilities").setConnectionCapabilities(i);
            }
        }

        @Override // com.android.internal.telecom.IConnectionServiceAdapter
        public void setDialing(String str) {
            RemoteConnectionService.this.findConnectionForAction(str, "setDialing").setState(3);
        }

        @Override // com.android.internal.telecom.IConnectionServiceAdapter
        public void setDisconnected(String str, DisconnectCause disconnectCause) {
            if (RemoteConnectionService.this.mConnectionById.containsKey(str)) {
                RemoteConnectionService.this.findConnectionForAction(str, "setDisconnected").setDisconnected(disconnectCause);
            } else {
                RemoteConnectionService.this.findConferenceForAction(str, "setDisconnected").setDisconnected(disconnectCause);
            }
        }

        @Override // com.android.internal.telecom.IConnectionServiceAdapter
        public void setExtras(String str, Bundle bundle) {
        }

        @Override // com.android.internal.telecom.IConnectionServiceAdapter
        public void setIsConferenced(String str, String str2) {
            RemoteConnection findConnectionForAction = RemoteConnectionService.this.findConnectionForAction(str, "setIsConferenced");
            if (findConnectionForAction != RemoteConnectionService.NULL_CONNECTION) {
                if (str2 == null) {
                    if (findConnectionForAction.getConference() != null) {
                        findConnectionForAction.getConference().removeConnection(findConnectionForAction);
                        return;
                    }
                    return;
                }
                RemoteConference findConferenceForAction = RemoteConnectionService.this.findConferenceForAction(str2, "setIsConferenced");
                if (findConferenceForAction != RemoteConnectionService.NULL_CONFERENCE) {
                    findConferenceForAction.addConnection(findConnectionForAction);
                }
            }
        }

        @Override // com.android.internal.telecom.IConnectionServiceAdapter
        public void setIsVoipAudioMode(String str, boolean z) {
            RemoteConnectionService.this.findConnectionForAction(str, "setIsVoipAudioMode").setIsVoipAudioMode(z);
        }

        @Override // com.android.internal.telecom.IConnectionServiceAdapter
        public void setOnHold(String str) {
            if (RemoteConnectionService.this.mConnectionById.containsKey(str)) {
                RemoteConnectionService.this.findConnectionForAction(str, "setOnHold").setState(5);
            } else {
                RemoteConnectionService.this.findConferenceForAction(str, "setOnHold").setState(5);
            }
        }

        @Override // com.android.internal.telecom.IConnectionServiceAdapter
        public void setPhoneAccountHandle(String str, PhoneAccountHandle phoneAccountHandle) {
            RemoteConnectionService.this.findConnectionForAction(str, "setPhoneAccountHandle").setPhoneAccountHandle(phoneAccountHandle);
        }

        @Override // com.android.internal.telecom.IConnectionServiceAdapter
        public void setRingbackRequested(String str, boolean z) {
            RemoteConnectionService.this.findConnectionForAction(str, "setRingbackRequested").setRingbackRequested(z);
        }

        @Override // com.android.internal.telecom.IConnectionServiceAdapter
        public void setRinging(String str) {
            RemoteConnectionService.this.findConnectionForAction(str, "setRinging").setState(2);
        }

        @Override // com.android.internal.telecom.IConnectionServiceAdapter
        public void setStatusHints(String str, StatusHints statusHints) {
            RemoteConnectionService.this.findConnectionForAction(str, "setStatusHints").setStatusHints(statusHints);
        }

        @Override // com.android.internal.telecom.IConnectionServiceAdapter
        public void setVideoProvider(String str, IVideoProvider iVideoProvider) {
            RemoteConnectionService.this.findConnectionForAction(str, "setVideoProvider").setVideoProvider(new RemoteConnection.VideoProvider(iVideoProvider));
        }

        @Override // com.android.internal.telecom.IConnectionServiceAdapter
        public void setVideoState(String str, int i) {
            RemoteConnectionService.this.findConnectionForAction(str, "setVideoState").setVideoState(i);
        }
    };
    private final ConnectionServiceAdapterServant mServant = new ConnectionServiceAdapterServant(this.mServantDelegate);
    private final IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient() { // from class: android.telecom.RemoteConnectionService.2
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            for (RemoteConnection remoteConnection : RemoteConnectionService.this.mConnectionById.values()) {
                remoteConnection.setDestroyed();
            }
            for (RemoteConference remoteConference : RemoteConnectionService.this.mConferenceById.values()) {
                remoteConference.setDestroyed();
            }
            RemoteConnectionService.this.mConnectionById.clear();
            RemoteConnectionService.this.mConferenceById.clear();
            RemoteConnectionService.this.mPendingConnections.clear();
            RemoteConnectionService.this.mOutgoingConnectionServiceRpc.asBinder().unlinkToDeath(RemoteConnectionService.this.mDeathRecipient, 0);
        }
    };
    private final Map<String, RemoteConnection> mConnectionById = new HashMap();
    private final Map<String, RemoteConference> mConferenceById = new HashMap();
    private final Set<RemoteConnection> mPendingConnections = new HashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    public RemoteConnectionService(IConnectionService iConnectionService, ConnectionService connectionService) throws RemoteException {
        this.mOutgoingConnectionServiceRpc = iConnectionService;
        this.mOutgoingConnectionServiceRpc.asBinder().linkToDeath(this.mDeathRecipient, 0);
        this.mOurConnectionServiceImpl = connectionService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RemoteConference findConferenceForAction(String str, String str2) {
        if (this.mConferenceById.containsKey(str)) {
            return this.mConferenceById.get(str);
        }
        Log.w(this, "%s - Cannot find Conference %s", str2, str);
        return NULL_CONFERENCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RemoteConnection findConnectionForAction(String str, String str2) {
        if (this.mConnectionById.containsKey(str)) {
            return this.mConnectionById.get(str);
        }
        Log.w(this, "%s - Cannot find Connection %s", str2, str);
        return NULL_CONNECTION;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasConnection(String str) {
        return this.mConnectionById.containsKey(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeDisconnectAdapter() {
        if (this.mConnectionById.isEmpty() && this.mConferenceById.isEmpty()) {
            try {
                this.mOutgoingConnectionServiceRpc.removeConnectionServiceAdapter(this.mServant.getStub());
            } catch (RemoteException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final RemoteConnection createRemoteConnection(PhoneAccountHandle phoneAccountHandle, ConnectionRequest connectionRequest, boolean z) {
        final String uuid = UUID.randomUUID().toString();
        ConnectionRequest connectionRequest2 = new ConnectionRequest(connectionRequest.getAccountHandle(), connectionRequest.getAddress(), connectionRequest.getExtras(), connectionRequest.getVideoState());
        try {
            if (this.mConnectionById.isEmpty()) {
                this.mOutgoingConnectionServiceRpc.addConnectionServiceAdapter(this.mServant.getStub());
            }
            RemoteConnection remoteConnection = new RemoteConnection(uuid, this.mOutgoingConnectionServiceRpc, connectionRequest2);
            this.mPendingConnections.add(remoteConnection);
            this.mConnectionById.put(uuid, remoteConnection);
            this.mOutgoingConnectionServiceRpc.createConnection(phoneAccountHandle, uuid, connectionRequest2, z, false);
            remoteConnection.registerCallback(new RemoteConnection.Callback() { // from class: android.telecom.RemoteConnectionService.3
                @Override // android.telecom.RemoteConnection.Callback
                public void onDestroyed(RemoteConnection remoteConnection2) {
                    RemoteConnectionService.this.mConnectionById.remove(uuid);
                    RemoteConnectionService.this.maybeDisconnectAdapter();
                }
            });
            return remoteConnection;
        } catch (RemoteException e) {
            return RemoteConnection.failure(new DisconnectCause(1, e.toString()));
        }
    }

    public String toString() {
        return "[RemoteCS - " + this.mOutgoingConnectionServiceRpc.asBinder().toString() + "]";
    }
}
