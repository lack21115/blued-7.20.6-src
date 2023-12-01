package android.location;

import android.content.Context;
import android.location.GpsMeasurementsEvent;
import android.location.IGpsMeasurementsListener;
import android.location.LocalListenerHelper;
import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/location/GpsMeasurementListenerTransport.class */
public class GpsMeasurementListenerTransport extends LocalListenerHelper<GpsMeasurementsEvent.Listener> {
    private final IGpsMeasurementsListener mListenerTransport;
    private final ILocationManager mLocationManager;

    /* loaded from: source-9557208-dex2jar.jar:android/location/GpsMeasurementListenerTransport$ListenerTransport.class */
    private class ListenerTransport extends IGpsMeasurementsListener.Stub {
        private ListenerTransport() {
        }

        @Override // android.location.IGpsMeasurementsListener
        public void onGpsMeasurementsReceived(final GpsMeasurementsEvent gpsMeasurementsEvent) {
            GpsMeasurementListenerTransport.this.foreach(new LocalListenerHelper.ListenerOperation<GpsMeasurementsEvent.Listener>() { // from class: android.location.GpsMeasurementListenerTransport.ListenerTransport.1
                @Override // android.location.LocalListenerHelper.ListenerOperation
                public void execute(GpsMeasurementsEvent.Listener listener) throws RemoteException {
                    listener.onGpsMeasurementsReceived(gpsMeasurementsEvent);
                }
            });
        }

        @Override // android.location.IGpsMeasurementsListener
        public void onStatusChanged(final int i) {
            GpsMeasurementListenerTransport.this.foreach(new LocalListenerHelper.ListenerOperation<GpsMeasurementsEvent.Listener>() { // from class: android.location.GpsMeasurementListenerTransport.ListenerTransport.2
                @Override // android.location.LocalListenerHelper.ListenerOperation
                public void execute(GpsMeasurementsEvent.Listener listener) throws RemoteException {
                    listener.onStatusChanged(i);
                }
            });
        }
    }

    public GpsMeasurementListenerTransport(Context context, ILocationManager iLocationManager) {
        super(context, "GpsMeasurementListenerTransport");
        this.mListenerTransport = new ListenerTransport();
        this.mLocationManager = iLocationManager;
    }

    @Override // android.location.LocalListenerHelper
    protected boolean registerWithServer() throws RemoteException {
        return this.mLocationManager.addGpsMeasurementsListener(this.mListenerTransport, getContext().getPackageName());
    }

    @Override // android.location.LocalListenerHelper
    protected void unregisterFromServer() throws RemoteException {
        this.mLocationManager.removeGpsMeasurementsListener(this.mListenerTransport);
    }
}
