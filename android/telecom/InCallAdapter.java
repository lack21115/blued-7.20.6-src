package android.telecom;

import android.os.RemoteException;
import com.android.internal.telecom.IInCallAdapter;

/* loaded from: source-9557208-dex2jar.jar:android/telecom/InCallAdapter.class */
public final class InCallAdapter {
    private final IInCallAdapter mAdapter;

    public InCallAdapter(IInCallAdapter iInCallAdapter) {
        this.mAdapter = iInCallAdapter;
    }

    public void answerCall(String str, int i) {
        try {
            this.mAdapter.answerCall(str, i);
        } catch (RemoteException e) {
        }
    }

    public void conference(String str, String str2) {
        try {
            this.mAdapter.conference(str, str2);
        } catch (RemoteException e) {
        }
    }

    public void deflectCall(String str, String str2) {
        try {
            this.mAdapter.deflectCall(str, str2);
        } catch (RemoteException e) {
        }
    }

    public void disconnectCall(String str) {
        try {
            this.mAdapter.disconnectCall(str);
        } catch (RemoteException e) {
        }
    }

    public void holdCall(String str) {
        try {
            this.mAdapter.holdCall(str);
        } catch (RemoteException e) {
        }
    }

    public void mergeConference(String str) {
        try {
            this.mAdapter.mergeConference(str);
        } catch (RemoteException e) {
        }
    }

    public void mute(boolean z) {
        try {
            this.mAdapter.mute(z);
        } catch (RemoteException e) {
        }
    }

    public void phoneAccountSelected(String str, PhoneAccountHandle phoneAccountHandle, boolean z) {
        try {
            this.mAdapter.phoneAccountSelected(str, phoneAccountHandle, z);
        } catch (RemoteException e) {
        }
    }

    public void playDtmfTone(String str, char c2) {
        try {
            this.mAdapter.playDtmfTone(str, c2);
        } catch (RemoteException e) {
        }
    }

    public void postDialContinue(String str, boolean z) {
        try {
            this.mAdapter.postDialContinue(str, z);
        } catch (RemoteException e) {
        }
    }

    public void rejectCall(String str, boolean z, String str2) {
        try {
            this.mAdapter.rejectCall(str, z, str2);
        } catch (RemoteException e) {
        }
    }

    public void setAudioRoute(int i) {
        try {
            this.mAdapter.setAudioRoute(i);
        } catch (RemoteException e) {
        }
    }

    public void splitFromConference(String str) {
        try {
            this.mAdapter.splitFromConference(str);
        } catch (RemoteException e) {
        }
    }

    public void stopDtmfTone(String str) {
        try {
            this.mAdapter.stopDtmfTone(str);
        } catch (RemoteException e) {
        }
    }

    public void swapConference(String str) {
        try {
            this.mAdapter.swapConference(str);
        } catch (RemoteException e) {
        }
    }

    public void switchToOtherActiveSub(String str, boolean z) {
        try {
            this.mAdapter.switchToOtherActiveSub(str, z);
        } catch (RemoteException e) {
        }
    }

    public void turnProximitySensorOff(boolean z) {
        try {
            this.mAdapter.turnOffProximitySensor(z);
        } catch (RemoteException e) {
        }
    }

    public void turnProximitySensorOn() {
        try {
            this.mAdapter.turnOnProximitySensor();
        } catch (RemoteException e) {
        }
    }

    public void unholdCall(String str) {
        try {
            this.mAdapter.unholdCall(str);
        } catch (RemoteException e) {
        }
    }
}
