package android.telecom;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.android.internal.os.SomeArgs;
import com.android.internal.telecom.IConnectionServiceAdapter;
import com.android.internal.telecom.IVideoProvider;
import com.android.internal.telecom.RemoteServiceCallback;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/telecom/ConnectionServiceAdapterServant.class */
public final class ConnectionServiceAdapterServant {
    private static final int MSG_ADD_CONFERENCE_CALL = 10;
    private static final int MSG_ADD_EXISTING_CONNECTION = 21;
    private static final int MSG_HANDLE_CREATE_CONNECTION_COMPLETE = 1;
    private static final int MSG_ON_POST_DIAL_CHAR = 22;
    private static final int MSG_ON_POST_DIAL_WAIT = 12;
    private static final int MSG_QUERY_REMOTE_CALL_SERVICES = 13;
    private static final int MSG_REMOVE_CALL = 11;
    private static final int MSG_SET_ACTIVE = 2;
    private static final int MSG_SET_ADDRESS = 18;
    private static final int MSG_SET_CALLER_DISPLAY_NAME = 19;
    private static final int MSG_SET_CALL_PROPERTIES = 27;
    private static final int MSG_SET_CALL_SUBSTATE = 25;
    private static final int MSG_SET_CONFERENCEABLE_CONNECTIONS = 20;
    private static final int MSG_SET_CONNECTION_CAPABILITIES = 8;
    private static final int MSG_SET_DIALING = 4;
    private static final int MSG_SET_DISCONNECTED = 5;
    private static final int MSG_SET_DISCONNECTED_WITH_SUPP_NOTIFICATION = 23;
    private static final int MSG_SET_EXTRAS = 26;
    private static final int MSG_SET_IS_CONFERENCED = 9;
    private static final int MSG_SET_IS_VOIP_AUDIO_MODE = 16;
    private static final int MSG_SET_ON_HOLD = 6;
    private static final int MSG_SET_PHONE_ACCOUNT = 24;
    private static final int MSG_SET_RINGBACK_REQUESTED = 7;
    private static final int MSG_SET_RINGING = 3;
    private static final int MSG_SET_STATUS_HINTS = 17;
    private static final int MSG_SET_VIDEO_CALL_PROVIDER = 15;
    private static final int MSG_SET_VIDEO_STATE = 14;
    private final IConnectionServiceAdapter mDelegate;
    private final Handler mHandler = new Handler() { // from class: android.telecom.ConnectionServiceAdapterServant.1
        private void internalHandleMessage(Message message) throws RemoteException {
            SomeArgs someArgs;
            boolean z = true;
            switch (message.what) {
                case 1:
                    someArgs = (SomeArgs) message.obj;
                    try {
                        ConnectionServiceAdapterServant.this.mDelegate.handleCreateConnectionComplete((String) someArgs.arg1, (ConnectionRequest) someArgs.arg2, (ParcelableConnection) someArgs.arg3);
                        return;
                    } finally {
                    }
                case 2:
                    ConnectionServiceAdapterServant.this.mDelegate.setActive((String) message.obj);
                    return;
                case 3:
                    ConnectionServiceAdapterServant.this.mDelegate.setRinging((String) message.obj);
                    return;
                case 4:
                    ConnectionServiceAdapterServant.this.mDelegate.setDialing((String) message.obj);
                    return;
                case 5:
                    someArgs = (SomeArgs) message.obj;
                    try {
                        ConnectionServiceAdapterServant.this.mDelegate.setDisconnected((String) someArgs.arg1, (DisconnectCause) someArgs.arg2);
                        return;
                    } finally {
                    }
                case 6:
                    ConnectionServiceAdapterServant.this.mDelegate.setOnHold((String) message.obj);
                    return;
                case 7:
                    IConnectionServiceAdapter iConnectionServiceAdapter = ConnectionServiceAdapterServant.this.mDelegate;
                    String str = (String) message.obj;
                    if (message.arg1 != 1) {
                        z = false;
                    }
                    iConnectionServiceAdapter.setRingbackRequested(str, z);
                    return;
                case 8:
                    ConnectionServiceAdapterServant.this.mDelegate.setConnectionCapabilities((String) message.obj, message.arg1);
                    return;
                case 9:
                    someArgs = (SomeArgs) message.obj;
                    try {
                        ConnectionServiceAdapterServant.this.mDelegate.setIsConferenced((String) someArgs.arg1, (String) someArgs.arg2);
                        return;
                    } finally {
                    }
                case 10:
                    someArgs = (SomeArgs) message.obj;
                    try {
                        ConnectionServiceAdapterServant.this.mDelegate.addConferenceCall((String) someArgs.arg1, (ParcelableConference) someArgs.arg2);
                        return;
                    } finally {
                    }
                case 11:
                    ConnectionServiceAdapterServant.this.mDelegate.removeCall((String) message.obj);
                    return;
                case 12:
                    someArgs = (SomeArgs) message.obj;
                    try {
                        ConnectionServiceAdapterServant.this.mDelegate.onPostDialWait((String) someArgs.arg1, (String) someArgs.arg2);
                        return;
                    } finally {
                    }
                case 13:
                    ConnectionServiceAdapterServant.this.mDelegate.queryRemoteConnectionServices((RemoteServiceCallback) message.obj);
                    return;
                case 14:
                    ConnectionServiceAdapterServant.this.mDelegate.setVideoState((String) message.obj, message.arg1);
                    return;
                case 15:
                    someArgs = (SomeArgs) message.obj;
                    try {
                        ConnectionServiceAdapterServant.this.mDelegate.setVideoProvider((String) someArgs.arg1, (IVideoProvider) someArgs.arg2);
                        return;
                    } finally {
                    }
                case 16:
                    ConnectionServiceAdapterServant.this.mDelegate.setIsVoipAudioMode((String) message.obj, message.arg1 == 1);
                    return;
                case 17:
                    someArgs = (SomeArgs) message.obj;
                    try {
                        ConnectionServiceAdapterServant.this.mDelegate.setStatusHints((String) someArgs.arg1, (StatusHints) someArgs.arg2);
                        return;
                    } finally {
                    }
                case 18:
                    someArgs = (SomeArgs) message.obj;
                    try {
                        ConnectionServiceAdapterServant.this.mDelegate.setAddress((String) someArgs.arg1, (Uri) someArgs.arg2, someArgs.argi1);
                        return;
                    } finally {
                    }
                case 19:
                    someArgs = (SomeArgs) message.obj;
                    try {
                        ConnectionServiceAdapterServant.this.mDelegate.setCallerDisplayName((String) someArgs.arg1, (String) someArgs.arg2, someArgs.argi1);
                        return;
                    } finally {
                    }
                case 20:
                    someArgs = (SomeArgs) message.obj;
                    try {
                        ConnectionServiceAdapterServant.this.mDelegate.setConferenceableConnections((String) someArgs.arg1, (List) someArgs.arg2);
                        return;
                    } finally {
                    }
                case 21:
                    someArgs = (SomeArgs) message.obj;
                    try {
                        ConnectionServiceAdapterServant.this.mDelegate.addExistingConnection((String) someArgs.arg1, (ParcelableConnection) someArgs.arg2);
                        return;
                    } finally {
                    }
                case 22:
                    someArgs = (SomeArgs) message.obj;
                    try {
                        ConnectionServiceAdapterServant.this.mDelegate.onPostDialChar((String) someArgs.arg1, (char) someArgs.argi1);
                        return;
                    } finally {
                    }
                case 23:
                default:
                    return;
                case 24:
                    someArgs = (SomeArgs) message.obj;
                    try {
                        ConnectionServiceAdapterServant.this.mDelegate.setPhoneAccountHandle((String) someArgs.arg1, (PhoneAccountHandle) someArgs.arg2);
                        return;
                    } finally {
                    }
                case 25:
                    ConnectionServiceAdapterServant.this.mDelegate.setCallSubstate((String) message.obj, message.arg1);
                    return;
                case 26:
                    someArgs = (SomeArgs) message.obj;
                    try {
                        ConnectionServiceAdapterServant.this.mDelegate.setExtras((String) someArgs.arg1, (Bundle) someArgs.arg2);
                        return;
                    } finally {
                    }
                case 27:
                    ConnectionServiceAdapterServant.this.mDelegate.setCallProperties((String) message.obj, message.arg1);
                    return;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                internalHandleMessage(message);
            } catch (RemoteException e) {
            }
        }
    };
    private final IConnectionServiceAdapter mStub = new IConnectionServiceAdapter.Stub() { // from class: android.telecom.ConnectionServiceAdapterServant.2
        public void addConferenceCall(String str, ParcelableConference parcelableConference) {
            SomeArgs obtain = SomeArgs.obtain();
            obtain.arg1 = str;
            obtain.arg2 = parcelableConference;
            ConnectionServiceAdapterServant.this.mHandler.obtainMessage(10, obtain).sendToTarget();
        }

        public final void addExistingConnection(String str, ParcelableConnection parcelableConnection) {
            SomeArgs obtain = SomeArgs.obtain();
            obtain.arg1 = str;
            obtain.arg2 = parcelableConnection;
            ConnectionServiceAdapterServant.this.mHandler.obtainMessage(21, obtain).sendToTarget();
        }

        public void handleCreateConnectionComplete(String str, ConnectionRequest connectionRequest, ParcelableConnection parcelableConnection) {
            SomeArgs obtain = SomeArgs.obtain();
            obtain.arg1 = str;
            obtain.arg2 = connectionRequest;
            obtain.arg3 = parcelableConnection;
            ConnectionServiceAdapterServant.this.mHandler.obtainMessage(1, obtain).sendToTarget();
        }

        public void onPostDialChar(String str, char c2) {
            SomeArgs obtain = SomeArgs.obtain();
            obtain.arg1 = str;
            obtain.argi1 = c2;
            ConnectionServiceAdapterServant.this.mHandler.obtainMessage(22, obtain).sendToTarget();
        }

        public void onPostDialWait(String str, String str2) {
            SomeArgs obtain = SomeArgs.obtain();
            obtain.arg1 = str;
            obtain.arg2 = str2;
            ConnectionServiceAdapterServant.this.mHandler.obtainMessage(12, obtain).sendToTarget();
        }

        public void queryRemoteConnectionServices(RemoteServiceCallback remoteServiceCallback) {
            ConnectionServiceAdapterServant.this.mHandler.obtainMessage(13, remoteServiceCallback).sendToTarget();
        }

        public void removeCall(String str) {
            ConnectionServiceAdapterServant.this.mHandler.obtainMessage(11, str).sendToTarget();
        }

        public void setActive(String str) {
            ConnectionServiceAdapterServant.this.mHandler.obtainMessage(2, str).sendToTarget();
        }

        public final void setAddress(String str, Uri uri, int i) {
            SomeArgs obtain = SomeArgs.obtain();
            obtain.arg1 = str;
            obtain.arg2 = uri;
            obtain.argi1 = i;
            ConnectionServiceAdapterServant.this.mHandler.obtainMessage(18, obtain).sendToTarget();
        }

        public void setCallProperties(String str, int i) {
            ConnectionServiceAdapterServant.this.mHandler.obtainMessage(27, i, 0, str).sendToTarget();
        }

        public void setCallSubstate(String str, int i) {
            ConnectionServiceAdapterServant.this.mHandler.obtainMessage(25, i, 0, str).sendToTarget();
        }

        public final void setCallerDisplayName(String str, String str2, int i) {
            SomeArgs obtain = SomeArgs.obtain();
            obtain.arg1 = str;
            obtain.arg2 = str2;
            obtain.argi1 = i;
            ConnectionServiceAdapterServant.this.mHandler.obtainMessage(19, obtain).sendToTarget();
        }

        public final void setConferenceableConnections(String str, List<String> list) {
            SomeArgs obtain = SomeArgs.obtain();
            obtain.arg1 = str;
            obtain.arg2 = list;
            ConnectionServiceAdapterServant.this.mHandler.obtainMessage(20, obtain).sendToTarget();
        }

        public void setConnectionCapabilities(String str, int i) {
            ConnectionServiceAdapterServant.this.mHandler.obtainMessage(8, i, 0, str).sendToTarget();
        }

        public void setDialing(String str) {
            ConnectionServiceAdapterServant.this.mHandler.obtainMessage(4, str).sendToTarget();
        }

        public void setDisconnected(String str, DisconnectCause disconnectCause) {
            SomeArgs obtain = SomeArgs.obtain();
            obtain.arg1 = str;
            obtain.arg2 = disconnectCause;
            ConnectionServiceAdapterServant.this.mHandler.obtainMessage(5, obtain).sendToTarget();
        }

        public void setExtras(String str, Bundle bundle) {
            SomeArgs obtain = SomeArgs.obtain();
            obtain.arg1 = str;
            obtain.arg2 = bundle;
            ConnectionServiceAdapterServant.this.mHandler.obtainMessage(26, obtain).sendToTarget();
        }

        public void setIsConferenced(String str, String str2) {
            SomeArgs obtain = SomeArgs.obtain();
            obtain.arg1 = str;
            obtain.arg2 = str2;
            ConnectionServiceAdapterServant.this.mHandler.obtainMessage(9, obtain).sendToTarget();
        }

        public final void setIsVoipAudioMode(String str, boolean z) {
            ConnectionServiceAdapterServant.this.mHandler.obtainMessage(16, z ? 1 : 0, 0, str).sendToTarget();
        }

        public void setOnHold(String str) {
            ConnectionServiceAdapterServant.this.mHandler.obtainMessage(6, str).sendToTarget();
        }

        public final void setPhoneAccountHandle(String str, PhoneAccountHandle phoneAccountHandle) {
            SomeArgs obtain = SomeArgs.obtain();
            obtain.arg1 = str;
            obtain.arg2 = phoneAccountHandle;
            ConnectionServiceAdapterServant.this.mHandler.obtainMessage(24, obtain).sendToTarget();
        }

        public void setRingbackRequested(String str, boolean z) {
            ConnectionServiceAdapterServant.this.mHandler.obtainMessage(7, z ? 1 : 0, 0, str).sendToTarget();
        }

        public void setRinging(String str) {
            ConnectionServiceAdapterServant.this.mHandler.obtainMessage(3, str).sendToTarget();
        }

        public final void setStatusHints(String str, StatusHints statusHints) {
            SomeArgs obtain = SomeArgs.obtain();
            obtain.arg1 = str;
            obtain.arg2 = statusHints;
            ConnectionServiceAdapterServant.this.mHandler.obtainMessage(17, obtain).sendToTarget();
        }

        public void setVideoProvider(String str, IVideoProvider iVideoProvider) {
            SomeArgs obtain = SomeArgs.obtain();
            obtain.arg1 = str;
            obtain.arg2 = iVideoProvider;
            ConnectionServiceAdapterServant.this.mHandler.obtainMessage(15, obtain).sendToTarget();
        }

        public void setVideoState(String str, int i) {
            ConnectionServiceAdapterServant.this.mHandler.obtainMessage(14, i, 0, str).sendToTarget();
        }
    };

    public ConnectionServiceAdapterServant(IConnectionServiceAdapter iConnectionServiceAdapter) {
        this.mDelegate = iConnectionServiceAdapter;
    }

    public IConnectionServiceAdapter getStub() {
        return this.mStub;
    }
}
