package android.location;

import android.content.Context;
import android.location.GpsNavigationMessageEvent;
import android.location.IGpsNavigationMessageListener;
import android.location.LocalListenerHelper;
import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/location/GpsNavigationMessageListenerTransport.class */
public class GpsNavigationMessageListenerTransport extends LocalListenerHelper<GpsNavigationMessageEvent.Listener> {
    private final IGpsNavigationMessageListener mListenerTransport;
    private final ILocationManager mLocationManager;

    /* loaded from: source-9557208-dex2jar.jar:android/location/GpsNavigationMessageListenerTransport$ListenerTransport.class */
    private class ListenerTransport extends IGpsNavigationMessageListener.Stub {
        private ListenerTransport() {
        }

        @Override // android.location.IGpsNavigationMessageListener
        public void onGpsNavigationMessageReceived(final GpsNavigationMessageEvent gpsNavigationMessageEvent) {
            GpsNavigationMessageListenerTransport.this.foreach(new LocalListenerHelper.ListenerOperation<GpsNavigationMessageEvent.Listener>() { // from class: android.location.GpsNavigationMessageListenerTransport.ListenerTransport.1
                @Override // android.location.LocalListenerHelper.ListenerOperation
                public void execute(GpsNavigationMessageEvent.Listener listener) throws RemoteException {
                    listener.onGpsNavigationMessageReceived(gpsNavigationMessageEvent);
                }
            });
        }

        @Override // android.location.IGpsNavigationMessageListener
        public void onStatusChanged(final int i) {
            GpsNavigationMessageListenerTransport.this.foreach(new LocalListenerHelper.ListenerOperation<GpsNavigationMessageEvent.Listener>() { // from class: android.location.GpsNavigationMessageListenerTransport.ListenerTransport.2
                @Override // android.location.LocalListenerHelper.ListenerOperation
                public void execute(GpsNavigationMessageEvent.Listener listener) throws RemoteException {
                    listener.onStatusChanged(i);
                }
            });
        }
    }

    public GpsNavigationMessageListenerTransport(Context context, ILocationManager iLocationManager) {
        super(context, "GpsNavigationMessageListenerTransport");
        this.mListenerTransport = new ListenerTransport();
        this.mLocationManager = iLocationManager;
    }

    @Override // android.location.LocalListenerHelper
    protected boolean registerWithServer() throws RemoteException {
        return this.mLocationManager.addGpsNavigationMessageListener(this.mListenerTransport, getContext().getPackageName());
    }

    @Override // android.location.LocalListenerHelper
    protected void unregisterFromServer() throws RemoteException {
        this.mLocationManager.removeGpsNavigationMessageListener(this.mListenerTransport);
    }
}
