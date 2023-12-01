package android.location;

import android.location.ICountryListener;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import java.util.HashMap;

/* loaded from: source-9557208-dex2jar.jar:android/location/CountryDetector.class */
public class CountryDetector {
    private static final String TAG = "CountryDetector";
    private final HashMap<CountryListener, ListenerTransport> mListeners = new HashMap<>();
    private final ICountryDetector mService;

    /* loaded from: source-9557208-dex2jar.jar:android/location/CountryDetector$ListenerTransport.class */
    private static final class ListenerTransport extends ICountryListener.Stub {
        private final Handler mHandler;
        private final CountryListener mListener;

        public ListenerTransport(CountryListener countryListener, Looper looper) {
            this.mListener = countryListener;
            if (looper != null) {
                this.mHandler = new Handler(looper);
            } else {
                this.mHandler = new Handler();
            }
        }

        @Override // android.location.ICountryListener
        public void onCountryDetected(final Country country) {
            this.mHandler.post(new Runnable() { // from class: android.location.CountryDetector.ListenerTransport.1
                @Override // java.lang.Runnable
                public void run() {
                    ListenerTransport.this.mListener.onCountryDetected(country);
                }
            });
        }
    }

    public CountryDetector(ICountryDetector iCountryDetector) {
        this.mService = iCountryDetector;
    }

    public void addCountryListener(CountryListener countryListener, Looper looper) {
        synchronized (this.mListeners) {
            if (!this.mListeners.containsKey(countryListener)) {
                ListenerTransport listenerTransport = new ListenerTransport(countryListener, looper);
                try {
                    this.mService.addCountryListener(listenerTransport);
                    this.mListeners.put(countryListener, listenerTransport);
                } catch (RemoteException e) {
                    Log.e(TAG, "addCountryListener: RemoteException", e);
                }
            }
        }
    }

    public Country detectCountry() {
        try {
            return this.mService.detectCountry();
        } catch (RemoteException e) {
            Log.e(TAG, "detectCountry: RemoteException", e);
            return null;
        }
    }

    public void removeCountryListener(CountryListener countryListener) {
        synchronized (this.mListeners) {
            ListenerTransport listenerTransport = this.mListeners.get(countryListener);
            if (listenerTransport != null) {
                try {
                    this.mListeners.remove(countryListener);
                    this.mService.removeCountryListener(listenerTransport);
                } catch (RemoteException e) {
                    Log.e(TAG, "removeCountryListener: RemoteException", e);
                }
            }
        }
    }
}
