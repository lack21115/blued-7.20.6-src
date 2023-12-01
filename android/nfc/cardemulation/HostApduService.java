package android.nfc.cardemulation;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/nfc/cardemulation/HostApduService.class */
public abstract class HostApduService extends Service {
    public static final int DEACTIVATION_DESELECTED = 1;
    public static final int DEACTIVATION_LINK_LOSS = 0;
    public static final String KEY_DATA = "data";
    public static final int MSG_COMMAND_APDU = 0;
    public static final int MSG_DEACTIVATED = 2;
    public static final int MSG_RESPONSE_APDU = 1;
    public static final int MSG_UNHANDLED = 3;
    public static final String SERVICE_INTERFACE = "android.nfc.cardemulation.action.HOST_APDU_SERVICE";
    public static final String SERVICE_META_DATA = "android.nfc.cardemulation.host_apdu_service";
    static final String TAG = "ApduService";
    Messenger mNfcService = null;
    final Messenger mMessenger = new Messenger(new MsgHandler());

    /* loaded from: source-9557208-dex2jar.jar:android/nfc/cardemulation/HostApduService$MsgHandler.class */
    final class MsgHandler extends Handler {
        MsgHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    Bundle data = message.getData();
                    if (data != null) {
                        if (HostApduService.this.mNfcService == null) {
                            HostApduService.this.mNfcService = message.replyTo;
                        }
                        byte[] byteArray = data.getByteArray("data");
                        if (byteArray == null) {
                            Log.e(HostApduService.TAG, "Received MSG_COMMAND_APDU without data.");
                            return;
                        }
                        byte[] processCommandApdu = HostApduService.this.processCommandApdu(byteArray, null);
                        if (processCommandApdu != null) {
                            if (HostApduService.this.mNfcService == null) {
                                Log.e(HostApduService.TAG, "Response not sent; service was deactivated.");
                                return;
                            }
                            Message obtain = Message.obtain((Handler) null, 1);
                            Bundle bundle = new Bundle();
                            bundle.putByteArray("data", processCommandApdu);
                            obtain.setData(bundle);
                            obtain.replyTo = HostApduService.this.mMessenger;
                            try {
                                HostApduService.this.mNfcService.send(obtain);
                                return;
                            } catch (RemoteException e) {
                                Log.e("TAG", "Response not sent; RemoteException calling into NfcService.");
                                return;
                            }
                        }
                        return;
                    }
                    return;
                case 1:
                    if (HostApduService.this.mNfcService == null) {
                        Log.e(HostApduService.TAG, "Response not sent; service was deactivated.");
                        return;
                    }
                    try {
                        message.replyTo = HostApduService.this.mMessenger;
                        HostApduService.this.mNfcService.send(message);
                        return;
                    } catch (RemoteException e2) {
                        Log.e(HostApduService.TAG, "RemoteException calling into NfcService.");
                        return;
                    }
                case 2:
                    HostApduService.this.mNfcService = null;
                    HostApduService.this.onDeactivated(message.arg1);
                    return;
                case 3:
                    if (HostApduService.this.mNfcService == null) {
                        Log.e(HostApduService.TAG, "notifyUnhandled not sent; service was deactivated.");
                        return;
                    }
                    try {
                        message.replyTo = HostApduService.this.mMessenger;
                        HostApduService.this.mNfcService.send(message);
                        return;
                    } catch (RemoteException e3) {
                        Log.e(HostApduService.TAG, "RemoteException calling into NfcService.");
                        return;
                    }
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    public final void notifyUnhandled() {
        try {
            this.mMessenger.send(Message.obtain((Handler) null, 3));
        } catch (RemoteException e) {
            Log.e("TAG", "Local messenger has died.");
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.mMessenger.getBinder();
    }

    public abstract void onDeactivated(int i);

    public abstract byte[] processCommandApdu(byte[] bArr, Bundle bundle);

    public final void sendResponseApdu(byte[] bArr) {
        Message obtain = Message.obtain((Handler) null, 1);
        Bundle bundle = new Bundle();
        bundle.putByteArray("data", bArr);
        obtain.setData(bundle);
        try {
            this.mMessenger.send(obtain);
        } catch (RemoteException e) {
            Log.e("TAG", "Local messenger has died.");
        }
    }
}
