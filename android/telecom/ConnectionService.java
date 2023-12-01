package android.telecom;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.telecom.Conference;
import android.telecom.Connection;
import com.android.internal.os.SomeArgs;
import com.android.internal.telecom.IConnectionService;
import com.android.internal.telecom.IConnectionServiceAdapter;
import com.android.internal.telecom.RemoteServiceCallback;
import com.igexin.push.core.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-9557208-dex2jar.jar:android/telecom/ConnectionService.class */
public abstract class ConnectionService extends Service {
    private static final int MSG_ABORT = 3;
    private static final int MSG_ADD_CONNECTION_SERVICE_ADAPTER = 1;
    private static final int MSG_ADD_PARTICIPANT_WITH_CONFERENCE = 23;
    private static final int MSG_ANSWER = 4;
    private static final int MSG_ANSWER_VIDEO = 17;
    private static final int MSG_CONFERENCE = 12;
    private static final int MSG_CREATE_CONNECTION = 2;
    private static final int MSG_DEFLECT = 22;
    private static final int MSG_DISCONNECT = 6;
    private static final int MSG_HOLD = 7;
    private static final int MSG_MERGE_CONFERENCE = 18;
    private static final int MSG_ON_AUDIO_STATE_CHANGED = 9;
    private static final int MSG_ON_POST_DIAL_CONTINUE = 14;
    private static final int MSG_PLAY_DTMF_TONE = 10;
    private static final int MSG_REJECT = 5;
    private static final int MSG_REMOVE_CONNECTION_SERVICE_ADAPTER = 16;
    private static final int MSG_SET_ACTIVE_SUB = 21;
    private static final int MSG_SET_LOCAL_HOLD = 20;
    private static final int MSG_SPLIT_FROM_CONFERENCE = 13;
    private static final int MSG_STOP_DTMF_TONE = 11;
    private static final int MSG_SWAP_CONFERENCE = 19;
    private static final int MSG_UNHOLD = 8;
    private static final boolean PII_DEBUG = Log.isLoggable(3);
    public static final String SERVICE_INTERFACE = "android.telecom.ConnectionService";
    private static Connection sNullConnection;
    private Conference sNullConference;
    private final Map<String, Connection> mConnectionById = new ConcurrentHashMap();
    private final Map<Connection, String> mIdByConnection = new ConcurrentHashMap();
    private final Map<String, Conference> mConferenceById = new ConcurrentHashMap();
    private final Map<Conference, String> mIdByConference = new ConcurrentHashMap();
    private final RemoteConnectionManager mRemoteConnectionManager = new RemoteConnectionManager(this);
    private final List<Runnable> mPreInitializationConnectionRequests = new ArrayList();
    private final ConnectionServiceAdapter mAdapter = new ConnectionServiceAdapter();
    private boolean mAreAccountsInitialized = false;
    private final IBinder mBinder = new IConnectionService.Stub() { // from class: android.telecom.ConnectionService.1
        public void abort(String str) {
            ConnectionService.this.mHandler.obtainMessage(3, str).sendToTarget();
        }

        public void addConnectionServiceAdapter(IConnectionServiceAdapter iConnectionServiceAdapter) {
            ConnectionService.this.mHandler.obtainMessage(1, iConnectionServiceAdapter).sendToTarget();
        }

        public void addParticipantWithConference(String str, String str2) {
            SomeArgs obtain = SomeArgs.obtain();
            obtain.arg1 = str;
            obtain.arg2 = str2;
            ConnectionService.this.mHandler.obtainMessage(23, obtain).sendToTarget();
        }

        public void answer(String str) {
            ConnectionService.this.mHandler.obtainMessage(4, str).sendToTarget();
        }

        public void answerVideo(String str, int i) {
            SomeArgs obtain = SomeArgs.obtain();
            obtain.arg1 = str;
            obtain.argi1 = i;
            ConnectionService.this.mHandler.obtainMessage(17, obtain).sendToTarget();
        }

        public void conference(String str, String str2) {
            SomeArgs obtain = SomeArgs.obtain();
            obtain.arg1 = str;
            obtain.arg2 = str2;
            ConnectionService.this.mHandler.obtainMessage(12, obtain).sendToTarget();
        }

        public void createConnection(PhoneAccountHandle phoneAccountHandle, String str, ConnectionRequest connectionRequest, boolean z, boolean z2) {
            SomeArgs obtain = SomeArgs.obtain();
            obtain.arg1 = phoneAccountHandle;
            obtain.arg2 = str;
            obtain.arg3 = connectionRequest;
            obtain.argi1 = z ? 1 : 0;
            obtain.argi2 = z2 ? 1 : 0;
            ConnectionService.this.mHandler.obtainMessage(2, obtain).sendToTarget();
        }

        public void deflect(String str, String str2) {
            SomeArgs obtain = SomeArgs.obtain();
            obtain.arg1 = str;
            obtain.arg2 = str2;
            ConnectionService.this.mHandler.obtainMessage(22, obtain).sendToTarget();
        }

        public void disconnect(String str) {
            ConnectionService.this.mHandler.obtainMessage(6, str).sendToTarget();
        }

        public void hold(String str) {
            ConnectionService.this.mHandler.obtainMessage(7, str).sendToTarget();
        }

        public void mergeConference(String str) {
            ConnectionService.this.mHandler.obtainMessage(18, str).sendToTarget();
        }

        public void onAudioStateChanged(String str, AudioState audioState) {
            SomeArgs obtain = SomeArgs.obtain();
            obtain.arg1 = str;
            obtain.arg2 = audioState;
            ConnectionService.this.mHandler.obtainMessage(9, obtain).sendToTarget();
        }

        public void onPostDialContinue(String str, boolean z) {
            SomeArgs obtain = SomeArgs.obtain();
            obtain.arg1 = str;
            obtain.argi1 = z ? 1 : 0;
            ConnectionService.this.mHandler.obtainMessage(14, obtain).sendToTarget();
        }

        public void playDtmfTone(String str, char c2) {
            ConnectionService.this.mHandler.obtainMessage(10, c2, 0, str).sendToTarget();
        }

        public void reject(String str) {
            ConnectionService.this.mHandler.obtainMessage(5, str).sendToTarget();
        }

        public void removeConnectionServiceAdapter(IConnectionServiceAdapter iConnectionServiceAdapter) {
            ConnectionService.this.mHandler.obtainMessage(16, iConnectionServiceAdapter).sendToTarget();
        }

        public void setActiveSubscription(String str) {
            Log.i(this, "setActiveSubscription %s", str);
            ConnectionService.this.mHandler.obtainMessage(21, str).sendToTarget();
        }

        public void setLocalCallHold(String str, int i) {
            SomeArgs obtain = SomeArgs.obtain();
            obtain.arg1 = str;
            obtain.argi1 = i;
            ConnectionService.this.mHandler.obtainMessage(20, obtain).sendToTarget();
        }

        public void splitFromConference(String str) {
            ConnectionService.this.mHandler.obtainMessage(13, str).sendToTarget();
        }

        public void stopDtmfTone(String str) {
            ConnectionService.this.mHandler.obtainMessage(11, str).sendToTarget();
        }

        public void swapConference(String str) {
            ConnectionService.this.mHandler.obtainMessage(19, str).sendToTarget();
        }

        public void unhold(String str) {
            ConnectionService.this.mHandler.obtainMessage(8, str).sendToTarget();
        }
    };
    private final Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: android.telecom.ConnectionService.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SomeArgs someArgs;
            switch (message.what) {
                case 1:
                    ConnectionService.this.mAdapter.addAdapter((IConnectionServiceAdapter) message.obj);
                    ConnectionService.this.onAdapterAttached();
                    return;
                case 2:
                    someArgs = (SomeArgs) message.obj;
                    try {
                        final PhoneAccountHandle phoneAccountHandle = (PhoneAccountHandle) someArgs.arg1;
                        final String str = (String) someArgs.arg2;
                        final ConnectionRequest connectionRequest = (ConnectionRequest) someArgs.arg3;
                        boolean z = someArgs.argi1 == 1;
                        boolean z2 = someArgs.argi2 == 1;
                        if (ConnectionService.this.mAreAccountsInitialized) {
                            ConnectionService.this.createConnection(phoneAccountHandle, str, connectionRequest, z, z2);
                        } else {
                            Log.d(this, "Enqueueing pre-init request %s", str);
                            final boolean z3 = z;
                            final boolean z4 = z2;
                            ConnectionService.this.mPreInitializationConnectionRequests.add(new Runnable() { // from class: android.telecom.ConnectionService.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ConnectionService.this.createConnection(phoneAccountHandle, str, connectionRequest, z3, z4);
                                }
                            });
                        }
                        return;
                    } finally {
                    }
                case 3:
                    ConnectionService.this.abort((String) message.obj);
                    return;
                case 4:
                    ConnectionService.this.answer((String) message.obj);
                    return;
                case 5:
                    ConnectionService.this.reject((String) message.obj);
                    return;
                case 6:
                    ConnectionService.this.disconnect((String) message.obj);
                    return;
                case 7:
                    ConnectionService.this.hold((String) message.obj);
                    return;
                case 8:
                    ConnectionService.this.unhold((String) message.obj);
                    return;
                case 9:
                    someArgs = (SomeArgs) message.obj;
                    try {
                        ConnectionService.this.onAudioStateChanged((String) someArgs.arg1, (AudioState) someArgs.arg2);
                        return;
                    } finally {
                    }
                case 10:
                    ConnectionService.this.playDtmfTone((String) message.obj, (char) message.arg1);
                    return;
                case 11:
                    ConnectionService.this.stopDtmfTone((String) message.obj);
                    return;
                case 12:
                    someArgs = (SomeArgs) message.obj;
                    try {
                        ConnectionService.this.conference((String) someArgs.arg1, (String) someArgs.arg2);
                        return;
                    } finally {
                    }
                case 13:
                    ConnectionService.this.splitFromConference((String) message.obj);
                    return;
                case 14:
                    someArgs = (SomeArgs) message.obj;
                    try {
                        ConnectionService.this.onPostDialContinue((String) someArgs.arg1, someArgs.argi1 == 1);
                        return;
                    } finally {
                    }
                case 15:
                default:
                    return;
                case 16:
                    ConnectionService.this.mAdapter.removeAdapter((IConnectionServiceAdapter) message.obj);
                    return;
                case 17:
                    someArgs = (SomeArgs) message.obj;
                    try {
                        ConnectionService.this.answerVideo((String) someArgs.arg1, someArgs.argi1);
                        return;
                    } finally {
                    }
                case 18:
                    ConnectionService.this.mergeConference((String) message.obj);
                    return;
                case 19:
                    ConnectionService.this.swapConference((String) message.obj);
                    return;
                case 20:
                    someArgs = (SomeArgs) message.obj;
                    try {
                        ConnectionService.this.setLocalCallHold((String) someArgs.arg1, someArgs.argi1);
                        return;
                    } finally {
                    }
                case 21:
                    ConnectionService.this.setActiveSubscription((String) message.obj);
                    return;
                case 22:
                    someArgs = (SomeArgs) message.obj;
                    try {
                        ConnectionService.this.deflect((String) someArgs.arg1, (String) someArgs.arg2);
                        return;
                    } finally {
                    }
                case 23:
                    someArgs = (SomeArgs) message.obj;
                    try {
                        ConnectionService.this.addParticipantWithConference((String) someArgs.arg1, (String) someArgs.arg2);
                        return;
                    } finally {
                    }
            }
        }
    };
    private final Conference.Listener mConferenceListener = new Conference.Listener() { // from class: android.telecom.ConnectionService.3
        @Override // android.telecom.Conference.Listener
        public void onConferenceableConnectionsChanged(Conference conference, List<Connection> list) {
            ConnectionService.this.mAdapter.setConferenceableConnections((String) ConnectionService.this.mIdByConference.get(conference), ConnectionService.this.createConnectionIdList(list));
        }

        @Override // android.telecom.Conference.Listener
        public void onConnectionAdded(Conference conference, Connection connection) {
        }

        @Override // android.telecom.Conference.Listener
        public void onConnectionCapabilitiesChanged(Conference conference, int i) {
            String str = (String) ConnectionService.this.mIdByConference.get(conference);
            Log.d(this, "call capabilities: conference: %s", Connection.capabilitiesToString(i));
            ConnectionService.this.mAdapter.setConnectionCapabilities(str, i);
        }

        @Override // android.telecom.Conference.Listener
        public void onConnectionRemoved(Conference conference, Connection connection) {
        }

        @Override // android.telecom.Conference.Listener
        public void onDestroyed(Conference conference) {
            ConnectionService.this.removeConference(conference);
        }

        @Override // android.telecom.Conference.Listener
        public void onDisconnected(Conference conference, DisconnectCause disconnectCause) {
            ConnectionService.this.mAdapter.setDisconnected((String) ConnectionService.this.mIdByConference.get(conference), disconnectCause);
        }

        @Override // android.telecom.Conference.Listener
        public void onStateChanged(Conference conference, int i, int i2) {
            String str = (String) ConnectionService.this.mIdByConference.get(conference);
            switch (i2) {
                case 4:
                    ConnectionService.this.mAdapter.setActive(str);
                    return;
                case 5:
                    ConnectionService.this.mAdapter.setOnHold(str);
                    return;
                default:
                    return;
            }
        }

        @Override // android.telecom.Conference.Listener
        public void onVideoProviderChanged(Conference conference, Connection.VideoProvider videoProvider) {
            String str = (String) ConnectionService.this.mIdByConference.get(conference);
            Log.d(this, "onVideoProviderChanged: Connection: %s, VideoProvider: %s", conference, videoProvider);
            ConnectionService.this.mAdapter.setVideoProvider(str, videoProvider);
        }

        @Override // android.telecom.Conference.Listener
        public void onVideoStateChanged(Conference conference, int i) {
            String str = (String) ConnectionService.this.mIdByConference.get(conference);
            Log.d(this, "onVideoStateChanged set video state %d", Integer.valueOf(i));
            ConnectionService.this.mAdapter.setVideoState(str, i);
        }
    };
    private final Connection.Listener mConnectionListener = new Connection.Listener() { // from class: android.telecom.ConnectionService.4
        @Override // android.telecom.Connection.Listener
        public void onAddressChanged(Connection connection, Uri uri, int i) {
            ConnectionService.this.mAdapter.setAddress((String) ConnectionService.this.mIdByConnection.get(connection), uri, i);
        }

        @Override // android.telecom.Connection.Listener
        public void onAudioModeIsVoipChanged(Connection connection, boolean z) {
            ConnectionService.this.mAdapter.setIsVoipAudioMode((String) ConnectionService.this.mIdByConnection.get(connection), z);
        }

        @Override // android.telecom.Connection.Listener
        public void onCallPropertiesChanged(Connection connection, int i) {
            String str = (String) ConnectionService.this.mIdByConnection.get(connection);
            Log.d(this, "properties: parcelableconnection: %x", Integer.valueOf(i));
            ConnectionService.this.mAdapter.setCallProperties(str, i);
        }

        @Override // android.telecom.Connection.Listener
        public void onCallSubstateChanged(Connection connection, int i) {
            String str = (String) ConnectionService.this.mIdByConnection.get(connection);
            Log.d(this, "Adapter set call substate %d", Integer.valueOf(i));
            ConnectionService.this.mAdapter.setCallSubstate(str, i);
        }

        @Override // android.telecom.Connection.Listener
        public void onCallerDisplayNameChanged(Connection connection, String str, int i) {
            ConnectionService.this.mAdapter.setCallerDisplayName((String) ConnectionService.this.mIdByConnection.get(connection), str, i);
        }

        @Override // android.telecom.Connection.Listener
        public void onConferenceChanged(Connection connection, Conference conference) {
            String str = (String) ConnectionService.this.mIdByConnection.get(connection);
            if (str != null) {
                String str2 = null;
                if (conference != null) {
                    str2 = (String) ConnectionService.this.mIdByConference.get(conference);
                }
                ConnectionService.this.mAdapter.setIsConferenced(str, str2);
            }
        }

        @Override // android.telecom.Connection.Listener
        public void onConferenceablesChanged(Connection connection, List<IConferenceable> list) {
            ConnectionService.this.mAdapter.setConferenceableConnections((String) ConnectionService.this.mIdByConnection.get(connection), ConnectionService.this.createIdList(list));
        }

        @Override // android.telecom.Connection.Listener
        public void onConnectionCapabilitiesChanged(Connection connection, int i) {
            String str = (String) ConnectionService.this.mIdByConnection.get(connection);
            Log.d(this, "capabilities: parcelableconnection: %s", Connection.capabilitiesToString(i));
            ConnectionService.this.mAdapter.setConnectionCapabilities(str, i);
        }

        @Override // android.telecom.Connection.Listener
        public void onDestroyed(Connection connection) {
            ConnectionService.this.removeConnection(connection);
        }

        @Override // android.telecom.Connection.Listener
        public void onDisconnected(Connection connection, DisconnectCause disconnectCause) {
            String str = (String) ConnectionService.this.mIdByConnection.get(connection);
            Log.d(this, "Adapter set disconnected %s", disconnectCause);
            ConnectionService.this.mAdapter.setDisconnected(str, disconnectCause);
        }

        @Override // android.telecom.Connection.Listener
        public void onExtrasUpdated(Connection connection, Bundle bundle) {
            String str = (String) ConnectionService.this.mIdByConnection.get(connection);
            Log.d(this, "Adapter set extras size=" + bundle.size() + " | call id= " + str, new Object[0]);
            ConnectionService.this.mAdapter.setExtras(str, bundle);
        }

        @Override // android.telecom.Connection.Listener
        public void onPhoneAccountChanged(Connection connection, PhoneAccountHandle phoneAccountHandle) {
            String str = (String) ConnectionService.this.mIdByConnection.get(connection);
            Log.i(this, "Adapter onPhoneAccountChanged %s, %s", connection, phoneAccountHandle);
            ConnectionService.this.mAdapter.setPhoneAccountHandle(str, phoneAccountHandle);
        }

        @Override // android.telecom.Connection.Listener
        public void onPostDialChar(Connection connection, char c2) {
            String str = (String) ConnectionService.this.mIdByConnection.get(connection);
            Log.d(this, "Adapter onPostDialChar %s, %s", connection, Character.valueOf(c2));
            ConnectionService.this.mAdapter.onPostDialChar(str, c2);
        }

        @Override // android.telecom.Connection.Listener
        public void onPostDialWait(Connection connection, String str) {
            String str2 = (String) ConnectionService.this.mIdByConnection.get(connection);
            Log.d(this, "Adapter onPostDialWait %s, %s", connection, str);
            ConnectionService.this.mAdapter.onPostDialWait(str2, str);
        }

        @Override // android.telecom.Connection.Listener
        public void onRingbackRequested(Connection connection, boolean z) {
            String str = (String) ConnectionService.this.mIdByConnection.get(connection);
            Log.d(this, "Adapter onRingback %b", Boolean.valueOf(z));
            ConnectionService.this.mAdapter.setRingbackRequested(str, z);
        }

        @Override // android.telecom.Connection.Listener
        public void onStateChanged(Connection connection, int i) {
            String str = (String) ConnectionService.this.mIdByConnection.get(connection);
            Log.d(this, "Adapter set state %s %s", str, Connection.stateToString(i));
            switch (i) {
                case 1:
                case 6:
                default:
                    return;
                case 2:
                    ConnectionService.this.mAdapter.setRinging(str);
                    return;
                case 3:
                    ConnectionService.this.mAdapter.setDialing(str);
                    return;
                case 4:
                    ConnectionService.this.mAdapter.setActive(str);
                    return;
                case 5:
                    ConnectionService.this.mAdapter.setOnHold(str);
                    return;
            }
        }

        @Override // android.telecom.Connection.Listener
        public void onStatusHintsChanged(Connection connection, StatusHints statusHints) {
            ConnectionService.this.mAdapter.setStatusHints((String) ConnectionService.this.mIdByConnection.get(connection), statusHints);
        }

        @Override // android.telecom.Connection.Listener
        public void onVideoProviderChanged(Connection connection, Connection.VideoProvider videoProvider) {
            String str = (String) ConnectionService.this.mIdByConnection.get(connection);
            Log.d(this, "onVideoProviderChanged: Connection: %s, VideoProvider: %s", connection, videoProvider);
            ConnectionService.this.mAdapter.setVideoProvider(str, videoProvider);
        }

        @Override // android.telecom.Connection.Listener
        public void onVideoStateChanged(Connection connection, int i) {
            String str = (String) ConnectionService.this.mIdByConnection.get(connection);
            Log.d(this, "Adapter set video state %d", Integer.valueOf(i));
            ConnectionService.this.mAdapter.setVideoState(str, i);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void abort(String str) {
        Log.d(this, "abort %s", str);
        findConnectionForAction(str, "abort").onAbort();
    }

    private String addConferenceInternal(Conference conference) {
        if (this.mIdByConference.containsKey(conference)) {
            Log.w(this, "Re-adding an existing conference: %s.", conference);
            return null;
        } else if (conference != null) {
            String uuid = UUID.randomUUID().toString();
            this.mConferenceById.put(uuid, conference);
            this.mIdByConference.put(conference, uuid);
            conference.addListener(this.mConferenceListener);
            return uuid;
        } else {
            return null;
        }
    }

    private void addConnection(String str, Connection connection) {
        this.mConnectionById.put(str, connection);
        this.mIdByConnection.put(connection, str);
        connection.addConnectionListener(this.mConnectionListener);
        connection.setConnectionService(this);
    }

    private String addExistingConnectionInternal(Connection connection) {
        String uuid = UUID.randomUUID().toString();
        addConnection(uuid, connection);
        return uuid;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addParticipantWithConference(String str, String str2) {
        Log.d(this, "ConnectionService addParticipantWithConference(%s, %s)", str2, str);
        Conference findConferenceForAction = findConferenceForAction(str, "addParticipantWithConference");
        Connection findConnectionForAction = findConnectionForAction(str, "addParticipantWithConnection");
        if (findConnectionForAction != getNullConnection()) {
            onAddParticipant(findConnectionForAction, str2);
        } else if (findConferenceForAction != getNullConference()) {
            findConferenceForAction.onAddParticipant(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void answer(String str) {
        Log.d(this, "answer %s", str);
        findConnectionForAction(str, "answer").onAnswer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void answerVideo(String str, int i) {
        Log.d(this, "answerVideo %s", str);
        findConnectionForAction(str, "answer").onAnswer(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void conference(String str, String str2) {
        Log.d(this, "conference %s, %s", str, str2);
        Connection findConnectionForAction = findConnectionForAction(str2, "conference");
        Conference nullConference = getNullConference();
        if (findConnectionForAction == getNullConnection()) {
            Conference findConferenceForAction = findConferenceForAction(str2, "conference");
            nullConference = findConferenceForAction;
            if (findConferenceForAction == getNullConference()) {
                Log.w(this, "Connection2 or Conference2 missing in conference request %s.", str2);
                return;
            }
        }
        Connection findConnectionForAction2 = findConnectionForAction(str, "conference");
        if (findConnectionForAction2 != getNullConnection()) {
            if (nullConference != getNullConference()) {
                nullConference.onMerge(findConnectionForAction2);
                return;
            } else {
                onConference(findConnectionForAction2, findConnectionForAction);
                return;
            }
        }
        Conference findConferenceForAction2 = findConferenceForAction(str, "addConnection");
        if (findConferenceForAction2 == getNullConference()) {
            Log.w(this, "Connection1 or Conference1 missing in conference request %s.", str);
        } else if (findConnectionForAction != getNullConnection()) {
            findConferenceForAction2.onMerge(findConnectionForAction);
        } else {
            Log.wtf(this, "There can only be one conference and an attempt was made to merge two conferences.", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createConnection(PhoneAccountHandle phoneAccountHandle, String str, ConnectionRequest connectionRequest, boolean z, boolean z2) {
        Log.d(this, "createConnection, callManagerAccount: %s, callId: %s, request: %s, isIncoming: %b, isUnknown: %b", phoneAccountHandle, str, connectionRequest, Boolean.valueOf(z), Boolean.valueOf(z2));
        Connection onCreateUnknownConnection = z2 ? onCreateUnknownConnection(phoneAccountHandle, connectionRequest) : z ? onCreateIncomingConnection(phoneAccountHandle, connectionRequest) : onCreateOutgoingConnection(phoneAccountHandle, connectionRequest);
        Log.d(this, "createConnection, connection: %s", onCreateUnknownConnection);
        Connection connection = onCreateUnknownConnection;
        if (onCreateUnknownConnection == null) {
            connection = Connection.createFailedConnection(new DisconnectCause(1));
        }
        if (connection.getState() != 6) {
            addConnection(str, connection);
        }
        Uri address = connection.getAddress();
        Log.v(this, "createConnection, number: %s, state: %s, capabilities: %s, properties: 0x%x", Connection.toLogSafePhoneNumber(address == null ? b.l : address.getSchemeSpecificPart()), Connection.stateToString(connection.getState()), Connection.capabilitiesToString(connection.getConnectionCapabilities()), Integer.valueOf(connection.getCallProperties()));
        Log.d(this, "createConnection, calling handleCreateConnectionSuccessful %s", str);
        this.mAdapter.handleCreateConnectionComplete(str, connectionRequest, new ParcelableConnection(getAccountHandle(connectionRequest, connection), connection.getState(), connection.getConnectionCapabilities(), connection.getCallProperties(), connection.getAddress(), connection.getAddressPresentation(), connection.getCallerDisplayName(), connection.getCallerDisplayNamePresentation(), connection.getVideoProvider() == null ? null : connection.getVideoProvider().getInterface(), connection.getVideoState(), connection.isRingbackRequested(), connection.getAudioModeIsVoip(), connection.getStatusHints(), connection.getDisconnectCause(), createIdList(connection.getConferenceables()), connection.getCallSubstate()));
        if (z2) {
            triggerConferenceRecalculate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> createConnectionIdList(List<Connection> list) {
        ArrayList arrayList = new ArrayList();
        for (Connection connection : list) {
            if (this.mIdByConnection.containsKey(connection)) {
                arrayList.add(this.mIdByConnection.get(connection));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> createIdList(List<IConferenceable> list) {
        ArrayList arrayList = new ArrayList();
        for (IConferenceable iConferenceable : list) {
            if (iConferenceable instanceof Connection) {
                Connection connection = (Connection) iConferenceable;
                if (this.mIdByConnection.containsKey(connection)) {
                    arrayList.add(this.mIdByConnection.get(connection));
                }
            } else if (iConferenceable instanceof Conference) {
                Conference conference = (Conference) iConferenceable;
                if (this.mIdByConference.containsKey(conference)) {
                    arrayList.add(this.mIdByConference.get(conference));
                }
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deflect(String str, String str2) {
        Log.d(this, "deflect %s - %s", str, str2);
        findConnectionForAction(str, "deflect").onDeflect(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disconnect(String str) {
        Log.d(this, "disconnect %s", str);
        if (this.mConnectionById.containsKey(str)) {
            findConnectionForAction(str, "disconnect").onDisconnect();
        } else {
            findConferenceForAction(str, "disconnect").onDisconnect();
        }
    }

    private void endAllConnections() {
        for (Connection connection : this.mIdByConnection.keySet()) {
            if (connection.getConference() == null) {
                connection.onDisconnect();
            }
        }
        for (Conference conference : this.mIdByConference.keySet()) {
            conference.onDisconnect();
        }
    }

    private Conference findConferenceForAction(String str, String str2) {
        if (this.mConferenceById.containsKey(str)) {
            return this.mConferenceById.get(str);
        }
        Log.w(this, "%s - Cannot find conference %s", str2, str);
        return getNullConference();
    }

    private Connection findConnectionForAction(String str, String str2) {
        if (this.mConnectionById.containsKey(str)) {
            return this.mConnectionById.get(str);
        }
        Log.w(this, "%s - Cannot find Connection %s", str2, str);
        return getNullConnection();
    }

    private Conference getNullConference() {
        if (this.sNullConference == null) {
            this.sNullConference = new Conference(null) { // from class: android.telecom.ConnectionService.7
            };
        }
        return this.sNullConference;
    }

    static Connection getNullConnection() {
        Connection connection;
        synchronized (ConnectionService.class) {
            try {
                if (sNullConnection == null) {
                    sNullConnection = new Connection() { // from class: android.telecom.ConnectionService.6
                    };
                }
                connection = sNullConnection;
            } catch (Throwable th) {
                throw th;
            }
        }
        return connection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hold(String str) {
        Log.d(this, "hold %s", str);
        if (this.mConnectionById.containsKey(str)) {
            findConnectionForAction(str, "hold").onHold();
        } else {
            findConferenceForAction(str, "hold").onHold();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeConference(String str) {
        Log.d(this, "mergeConference(%s)", str);
        Conference findConferenceForAction = findConferenceForAction(str, "mergeConference");
        if (findConferenceForAction != null) {
            findConferenceForAction.onMerge();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAccountsInitialized() {
        this.mAreAccountsInitialized = true;
        for (Runnable runnable : this.mPreInitializationConnectionRequests) {
            runnable.run();
        }
        this.mPreInitializationConnectionRequests.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdapterAttached() {
        if (this.mAreAccountsInitialized) {
            return;
        }
        this.mAdapter.queryRemoteConnectionServices(new RemoteServiceCallback.Stub() { // from class: android.telecom.ConnectionService.5
            public void onError() {
                ConnectionService.this.mHandler.post(new Runnable() { // from class: android.telecom.ConnectionService.5.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ConnectionService.this.mAreAccountsInitialized = true;
                    }
                });
            }

            public void onResult(final List<ComponentName> list, final List<IBinder> list2) {
                ConnectionService.this.mHandler.post(new Runnable() { // from class: android.telecom.ConnectionService.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= list.size() || i2 >= list2.size()) {
                                break;
                            }
                            ConnectionService.this.mRemoteConnectionManager.addConnectionService((ComponentName) list.get(i2), IConnectionService.Stub.asInterface((IBinder) list2.get(i2)));
                            i = i2 + 1;
                        }
                        ConnectionService.this.onAccountsInitialized();
                        Log.d(this, "remote connection services found: " + list2, new Object[0]);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAudioStateChanged(String str, AudioState audioState) {
        Log.d(this, "onAudioStateChanged %s %s", str, audioState);
        if (this.mConnectionById.containsKey(str)) {
            findConnectionForAction(str, "onAudioStateChanged").setAudioState(audioState);
        } else {
            findConferenceForAction(str, "onAudioStateChanged").setAudioState(audioState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostDialContinue(String str, boolean z) {
        Log.d(this, "onPostDialContinue(%s)", str);
        findConnectionForAction(str, "stopDtmfTone").onPostDialContinue(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playDtmfTone(String str, char c2) {
        Log.d(this, "playDtmfTone %s %c", str, Character.valueOf(c2));
        if (this.mConnectionById.containsKey(str)) {
            findConnectionForAction(str, "playDtmfTone").onPlayDtmfTone(c2);
        } else {
            findConferenceForAction(str, "playDtmfTone").onPlayDtmfTone(c2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reject(String str) {
        Log.d(this, "reject %s", str);
        findConnectionForAction(str, "reject").onReject();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeConference(Conference conference) {
        if (this.mIdByConference.containsKey(conference)) {
            conference.removeListener(this.mConferenceListener);
            String str = this.mIdByConference.get(conference);
            this.mConferenceById.remove(str);
            this.mIdByConference.remove(conference);
            this.mAdapter.removeCall(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setActiveSubscription(String str) {
        Log.d(this, "setActiveSubscription %s", str);
        findConnectionForAction(str, "setActiveSubscription").setActiveSubscription();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLocalCallHold(String str, int i) {
        Log.d(this, "setLocalCallHold %s", str);
        findConnectionForAction(str, "setLocalCallHold").setLocalCallHold(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void splitFromConference(String str) {
        Log.d(this, "splitFromConference(%s)", str);
        Connection findConnectionForAction = findConnectionForAction(str, "splitFromConference");
        if (findConnectionForAction == getNullConnection()) {
            Log.w(this, "Connection missing in conference request %s.", str);
            return;
        }
        Conference conference = findConnectionForAction.getConference();
        if (conference != null) {
            conference.onSeparate(findConnectionForAction);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopDtmfTone(String str) {
        Log.d(this, "stopDtmfTone %s", str);
        if (this.mConnectionById.containsKey(str)) {
            findConnectionForAction(str, "stopDtmfTone").onStopDtmfTone();
        } else {
            findConferenceForAction(str, "stopDtmfTone").onStopDtmfTone();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void swapConference(String str) {
        Log.d(this, "swapConference(%s)", str);
        Conference findConferenceForAction = findConferenceForAction(str, "swapConference");
        if (findConferenceForAction != null) {
            findConferenceForAction.onSwap();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unhold(String str) {
        Log.d(this, "unhold %s", str);
        if (this.mConnectionById.containsKey(str)) {
            findConnectionForAction(str, "unhold").onUnhold();
        } else {
            findConferenceForAction(str, "unhold").onUnhold();
        }
    }

    public final void addConference(Conference conference) {
        Log.d(this, "addConference: conference=%s", conference);
        String addConferenceInternal = addConferenceInternal(conference);
        if (addConferenceInternal != null) {
            ArrayList arrayList = new ArrayList(2);
            for (Connection connection : conference.getConnections()) {
                if (this.mIdByConnection.containsKey(connection)) {
                    arrayList.add(this.mIdByConnection.get(connection));
                }
            }
            this.mAdapter.addConferenceCall(addConferenceInternal, new ParcelableConference(conference.getPhoneAccountHandle(), conference.getState(), conference.getConnectionCapabilities(), arrayList, conference.getVideoProvider() == null ? null : conference.getVideoProvider().getInterface(), conference.getVideoState(), conference.getConnectTimeMillis()));
            this.mAdapter.setVideoProvider(addConferenceInternal, conference.getVideoProvider());
            this.mAdapter.setVideoState(addConferenceInternal, conference.getVideoState());
            for (Connection connection2 : conference.getConnections()) {
                String str = this.mIdByConnection.get(connection2);
                if (str != null) {
                    this.mAdapter.setIsConferenced(str, addConferenceInternal);
                }
            }
        }
    }

    public final void addExistingConnection(PhoneAccountHandle phoneAccountHandle, Connection connection) {
        String addExistingConnectionInternal = addExistingConnectionInternal(connection);
        if (addExistingConnectionInternal != null) {
            this.mAdapter.addExistingConnection(addExistingConnectionInternal, new ParcelableConnection(phoneAccountHandle, connection.getState(), connection.getConnectionCapabilities(), connection.getCallProperties(), connection.getAddress(), connection.getAddressPresentation(), connection.getCallerDisplayName(), connection.getCallerDisplayNamePresentation(), connection.getVideoProvider() == null ? null : connection.getVideoProvider().getInterface(), connection.getVideoState(), connection.isRingbackRequested(), connection.getAudioModeIsVoip(), connection.getStatusHints(), connection.getDisconnectCause(), new ArrayList(0), connection.getCallSubstate()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addRemoteConference(RemoteConference remoteConference) {
        onRemoteConferenceAdded(remoteConference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addRemoteExistingConnection(RemoteConnection remoteConnection) {
        onRemoteExistingConnectionAdded(remoteConnection);
    }

    public final void conferenceRemoteConnections(RemoteConnection remoteConnection, RemoteConnection remoteConnection2) {
        this.mRemoteConnectionManager.conferenceRemoteConnections(remoteConnection, remoteConnection2);
    }

    public boolean containsConference(Conference conference) {
        return this.mIdByConference.containsKey(conference);
    }

    public final RemoteConnection createRemoteIncomingConnection(PhoneAccountHandle phoneAccountHandle, ConnectionRequest connectionRequest) {
        return this.mRemoteConnectionManager.createRemoteConnection(phoneAccountHandle, connectionRequest, true);
    }

    public final RemoteConnection createRemoteOutgoingConnection(PhoneAccountHandle phoneAccountHandle, ConnectionRequest connectionRequest) {
        return this.mRemoteConnectionManager.createRemoteConnection(phoneAccountHandle, connectionRequest, false);
    }

    public PhoneAccountHandle getAccountHandle(ConnectionRequest connectionRequest, Connection connection) {
        PhoneAccountHandle phoneAccountHandle = connection.getPhoneAccountHandle();
        if (phoneAccountHandle != null) {
            Log.i(this, "getAccountHandle, return account handle from local, %s", phoneAccountHandle);
            return phoneAccountHandle;
        }
        return connectionRequest.getAccountHandle();
    }

    public final Collection<Connection> getAllConnections() {
        return this.mConnectionById.values();
    }

    public void onAddParticipant(Connection connection, String str) {
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    public void onConference(Connection connection, Connection connection2) {
    }

    public Connection onCreateIncomingConnection(PhoneAccountHandle phoneAccountHandle, ConnectionRequest connectionRequest) {
        return null;
    }

    public Connection onCreateOutgoingConnection(PhoneAccountHandle phoneAccountHandle, ConnectionRequest connectionRequest) {
        return null;
    }

    public Connection onCreateUnknownConnection(PhoneAccountHandle phoneAccountHandle, ConnectionRequest connectionRequest) {
        return null;
    }

    public void onRemoteConferenceAdded(RemoteConference remoteConference) {
    }

    public void onRemoteExistingConnectionAdded(RemoteConnection remoteConnection) {
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        endAllConnections();
        return super.onUnbind(intent);
    }

    protected void removeConnection(Connection connection) {
        String str = this.mIdByConnection.get(connection);
        connection.unsetConnectionService(this);
        connection.removeConnectionListener(this.mConnectionListener);
        this.mConnectionById.remove(this.mIdByConnection.get(connection));
        this.mIdByConnection.remove(connection);
        this.mAdapter.removeCall(str);
    }

    public void triggerConferenceRecalculate() {
    }
}
