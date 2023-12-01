package android.telecom;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.telecom.Connection;
import com.android.internal.telecom.IConnectionServiceAdapter;
import com.android.internal.telecom.IVideoProvider;
import com.android.internal.telecom.RemoteServiceCallback;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/telecom/ConnectionServiceAdapter.class */
public final class ConnectionServiceAdapter implements IBinder.DeathRecipient {
    private final Set<IConnectionServiceAdapter> mAdapters = Collections.newSetFromMap(new ConcurrentHashMap(8, 0.9f, 1));

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addAdapter(IConnectionServiceAdapter iConnectionServiceAdapter) {
        if (this.mAdapters.add(iConnectionServiceAdapter)) {
            try {
                iConnectionServiceAdapter.asBinder().linkToDeath(this, 0);
            } catch (RemoteException e) {
                this.mAdapters.remove(iConnectionServiceAdapter);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addConferenceCall(String str, ParcelableConference parcelableConference) {
        for (IConnectionServiceAdapter iConnectionServiceAdapter : this.mAdapters) {
            try {
                iConnectionServiceAdapter.addConferenceCall(str, parcelableConference);
            } catch (RemoteException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addExistingConnection(String str, ParcelableConnection parcelableConnection) {
        Log.v(this, "addExistingConnection: %s", str);
        for (IConnectionServiceAdapter iConnectionServiceAdapter : this.mAdapters) {
            try {
                iConnectionServiceAdapter.addExistingConnection(str, parcelableConnection);
            } catch (RemoteException e) {
            }
        }
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        Iterator<IConnectionServiceAdapter> it = this.mAdapters.iterator();
        while (it.hasNext()) {
            IConnectionServiceAdapter next = it.next();
            if (!next.asBinder().isBinderAlive()) {
                it.remove();
                next.asBinder().unlinkToDeath(this, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleCreateConnectionComplete(String str, ConnectionRequest connectionRequest, ParcelableConnection parcelableConnection) {
        for (IConnectionServiceAdapter iConnectionServiceAdapter : this.mAdapters) {
            try {
                iConnectionServiceAdapter.handleCreateConnectionComplete(str, connectionRequest, parcelableConnection);
            } catch (RemoteException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPostDialChar(String str, char c2) {
        for (IConnectionServiceAdapter iConnectionServiceAdapter : this.mAdapters) {
            try {
                iConnectionServiceAdapter.onPostDialChar(str, c2);
            } catch (RemoteException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPostDialWait(String str, String str2) {
        for (IConnectionServiceAdapter iConnectionServiceAdapter : this.mAdapters) {
            try {
                iConnectionServiceAdapter.onPostDialWait(str, str2);
            } catch (RemoteException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void queryRemoteConnectionServices(RemoteServiceCallback remoteServiceCallback) {
        if (this.mAdapters.size() == 1) {
            try {
                this.mAdapters.iterator().next().queryRemoteConnectionServices(remoteServiceCallback);
            } catch (RemoteException e) {
                Log.e(this, e, "Exception trying to query for remote CSs", new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeAdapter(IConnectionServiceAdapter iConnectionServiceAdapter) {
        if (iConnectionServiceAdapter == null || !this.mAdapters.remove(iConnectionServiceAdapter)) {
            return;
        }
        iConnectionServiceAdapter.asBinder().unlinkToDeath(this, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeCall(String str) {
        for (IConnectionServiceAdapter iConnectionServiceAdapter : this.mAdapters) {
            try {
                iConnectionServiceAdapter.removeCall(str);
            } catch (RemoteException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setActive(String str) {
        for (IConnectionServiceAdapter iConnectionServiceAdapter : this.mAdapters) {
            try {
                iConnectionServiceAdapter.setActive(str);
            } catch (RemoteException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAddress(String str, Uri uri, int i) {
        for (IConnectionServiceAdapter iConnectionServiceAdapter : this.mAdapters) {
            try {
                iConnectionServiceAdapter.setAddress(str, uri, i);
            } catch (RemoteException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCallProperties(String str, int i) {
        for (IConnectionServiceAdapter iConnectionServiceAdapter : this.mAdapters) {
            try {
                iConnectionServiceAdapter.setCallProperties(str, i);
            } catch (RemoteException e) {
            }
        }
    }

    public final void setCallSubstate(String str, int i) {
        Log.v(this, "setCallSubstate: %d", Integer.valueOf(i));
        for (IConnectionServiceAdapter iConnectionServiceAdapter : this.mAdapters) {
            try {
                iConnectionServiceAdapter.setCallSubstate(str, i);
            } catch (RemoteException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCallerDisplayName(String str, String str2, int i) {
        for (IConnectionServiceAdapter iConnectionServiceAdapter : this.mAdapters) {
            try {
                iConnectionServiceAdapter.setCallerDisplayName(str, str2, i);
            } catch (RemoteException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setConferenceableConnections(String str, List<String> list) {
        Log.v(this, "setConferenceableConnections: %s, %s", str, list);
        for (IConnectionServiceAdapter iConnectionServiceAdapter : this.mAdapters) {
            try {
                iConnectionServiceAdapter.setConferenceableConnections(str, list);
            } catch (RemoteException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setConnectionCapabilities(String str, int i) {
        for (IConnectionServiceAdapter iConnectionServiceAdapter : this.mAdapters) {
            try {
                iConnectionServiceAdapter.setConnectionCapabilities(str, i);
            } catch (RemoteException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDialing(String str) {
        for (IConnectionServiceAdapter iConnectionServiceAdapter : this.mAdapters) {
            try {
                iConnectionServiceAdapter.setDialing(str);
            } catch (RemoteException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDisconnected(String str, DisconnectCause disconnectCause) {
        for (IConnectionServiceAdapter iConnectionServiceAdapter : this.mAdapters) {
            try {
                iConnectionServiceAdapter.setDisconnected(str, disconnectCause);
            } catch (RemoteException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setExtras(String str, Bundle bundle) {
        for (IConnectionServiceAdapter iConnectionServiceAdapter : this.mAdapters) {
            try {
                iConnectionServiceAdapter.setExtras(str, bundle);
            } catch (RemoteException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIsConferenced(String str, String str2) {
        for (IConnectionServiceAdapter iConnectionServiceAdapter : this.mAdapters) {
            try {
                Log.d(this, "sending connection %s with conference %s", str, str2);
                iConnectionServiceAdapter.setIsConferenced(str, str2);
            } catch (RemoteException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIsVoipAudioMode(String str, boolean z) {
        for (IConnectionServiceAdapter iConnectionServiceAdapter : this.mAdapters) {
            try {
                iConnectionServiceAdapter.setIsVoipAudioMode(str, z);
            } catch (RemoteException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnHold(String str) {
        for (IConnectionServiceAdapter iConnectionServiceAdapter : this.mAdapters) {
            try {
                iConnectionServiceAdapter.setOnHold(str);
            } catch (RemoteException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPhoneAccountHandle(String str, PhoneAccountHandle phoneAccountHandle) {
        Log.v(this, "setPhoneAccountHandle: %s, %s", str, phoneAccountHandle);
        for (IConnectionServiceAdapter iConnectionServiceAdapter : this.mAdapters) {
            try {
                iConnectionServiceAdapter.setPhoneAccountHandle(str, phoneAccountHandle);
            } catch (RemoteException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRingbackRequested(String str, boolean z) {
        for (IConnectionServiceAdapter iConnectionServiceAdapter : this.mAdapters) {
            try {
                iConnectionServiceAdapter.setRingbackRequested(str, z);
            } catch (RemoteException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRinging(String str) {
        for (IConnectionServiceAdapter iConnectionServiceAdapter : this.mAdapters) {
            try {
                iConnectionServiceAdapter.setRinging(str);
            } catch (RemoteException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStatusHints(String str, StatusHints statusHints) {
        for (IConnectionServiceAdapter iConnectionServiceAdapter : this.mAdapters) {
            try {
                iConnectionServiceAdapter.setStatusHints(str, statusHints);
            } catch (RemoteException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setVideoProvider(String str, Connection.VideoProvider videoProvider) {
        IVideoProvider iVideoProvider;
        for (IConnectionServiceAdapter iConnectionServiceAdapter : this.mAdapters) {
            if (videoProvider == null) {
                iVideoProvider = null;
            } else {
                try {
                    iVideoProvider = videoProvider.getInterface();
                } catch (RemoteException e) {
                }
            }
            iConnectionServiceAdapter.setVideoProvider(str, iVideoProvider);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setVideoState(String str, int i) {
        Log.v(this, "setVideoState: %d", Integer.valueOf(i));
        for (IConnectionServiceAdapter iConnectionServiceAdapter : this.mAdapters) {
            try {
                iConnectionServiceAdapter.setVideoState(str, i);
            } catch (RemoteException e) {
            }
        }
    }
}
