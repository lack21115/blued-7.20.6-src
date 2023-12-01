package androidx.core.location;

import android.content.Context;
import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.collection.SimpleArrayMap;
import androidx.core.location.GnssStatusCompat;
import androidx.core.location.LocationManagerCompat;
import androidx.core.os.CancellationSignal;
import androidx.core.os.ExecutorCompat;
import androidx.core.util.Consumer;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.function.Predicate;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/location/LocationManagerCompat.class */
public final class LocationManagerCompat {

    /* renamed from: a  reason: collision with root package name */
    static final WeakHashMap<LocationListener, List<WeakReference<LocationListenerTransport>>> f2439a = new WeakHashMap<>();
    private static Field b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f2440c;
    private static Method d;

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/location/LocationManagerCompat$Api28Impl.class */
    static class Api28Impl {
        private Api28Impl() {
        }

        static boolean a(LocationManager locationManager) {
            return locationManager.isLocationEnabled();
        }

        static String b(LocationManager locationManager) {
            return locationManager.getGnssHardwareModelName();
        }

        static int c(LocationManager locationManager) {
            return locationManager.getGnssYearOfHardware();
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/location/LocationManagerCompat$Api30Impl.class */
    static class Api30Impl {
        private Api30Impl() {
        }

        static void a(LocationManager locationManager, String str, CancellationSignal cancellationSignal, Executor executor, final Consumer<Location> consumer) {
            android.os.CancellationSignal cancellationSignal2 = cancellationSignal != null ? (android.os.CancellationSignal) cancellationSignal.getCancellationSignalObject() : null;
            Objects.requireNonNull(consumer);
            locationManager.getCurrentLocation(str, cancellationSignal2, executor, new java.util.function.Consumer() { // from class: androidx.core.location.-$$Lambda$0OhB_BtsGyESugufsOb9t8Ob9OU
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    Consumer.this.accept((Location) obj);
                }
            });
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/location/LocationManagerCompat$Api31Impl.class */
    static class Api31Impl {
        private Api31Impl() {
        }

        static void a(LocationManager locationManager, String str, LocationRequest locationRequest, Executor executor, LocationListener locationListener) {
            locationManager.requestLocationUpdates(str, locationRequest, executor, locationListener);
        }

        static boolean a(LocationManager locationManager, String str) {
            return locationManager.hasProvider(str);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/location/LocationManagerCompat$CancellableLocationListener.class */
    static final class CancellableLocationListener implements LocationListener {

        /* renamed from: a  reason: collision with root package name */
        Runnable f2442a;
        private final LocationManager b;

        /* renamed from: c  reason: collision with root package name */
        private final Executor f2443c;
        private final Handler d = new Handler(Looper.getMainLooper());
        private Consumer<Location> e;
        private boolean f;

        CancellableLocationListener(LocationManager locationManager, Executor executor, Consumer<Location> consumer) {
            this.b = locationManager;
            this.f2443c = executor;
            this.e = consumer;
        }

        private void a() {
            this.e = null;
            this.b.removeUpdates(this);
            Runnable runnable = this.f2442a;
            if (runnable != null) {
                this.d.removeCallbacks(runnable);
                this.f2442a = null;
            }
        }

        public void cancel() {
            synchronized (this) {
                if (this.f) {
                    return;
                }
                this.f = true;
                a();
            }
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(final Location location) {
            synchronized (this) {
                if (this.f) {
                    return;
                }
                this.f = true;
                final Consumer<Location> consumer = this.e;
                this.f2443c.execute(new Runnable() { // from class: androidx.core.location.-$$Lambda$LocationManagerCompat$CancellableLocationListener$xkqavk_dFSiHq_fL2T23gDmb5L0
                    @Override // java.lang.Runnable
                    public final void run() {
                        Consumer.this.accept(location);
                    }
                });
                a();
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            onLocationChanged(null);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }

        public void startTimeout(long j) {
            synchronized (this) {
                if (this.f) {
                    return;
                }
                Runnable runnable = new Runnable() { // from class: androidx.core.location.LocationManagerCompat.CancellableLocationListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CancellableLocationListener.this.f2442a = null;
                        CancellableLocationListener.this.onLocationChanged(null);
                    }
                };
                this.f2442a = runnable;
                this.d.postDelayed(runnable, j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/location/LocationManagerCompat$GnssLazyLoader.class */
    public static class GnssLazyLoader {

        /* renamed from: a  reason: collision with root package name */
        static final SimpleArrayMap<Object, Object> f2445a = new SimpleArrayMap<>();

        private GnssLazyLoader() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/location/LocationManagerCompat$GnssStatusTransport.class */
    public static class GnssStatusTransport extends GnssStatus.Callback {

        /* renamed from: a  reason: collision with root package name */
        final GnssStatusCompat.Callback f2446a;

        GnssStatusTransport(GnssStatusCompat.Callback callback) {
            Preconditions.checkArgument(callback != null, "invalid null callback");
            this.f2446a = callback;
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int i) {
            this.f2446a.onFirstFix(i);
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            this.f2446a.onSatelliteStatusChanged(GnssStatusCompat.wrap(gnssStatus));
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            this.f2446a.onStarted();
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            this.f2446a.onStopped();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/location/LocationManagerCompat$GpsStatusTransport.class */
    public static class GpsStatusTransport implements GpsStatus.Listener {

        /* renamed from: a  reason: collision with root package name */
        final GnssStatusCompat.Callback f2447a;
        volatile Executor b;

        /* renamed from: c  reason: collision with root package name */
        private final LocationManager f2448c;

        GpsStatusTransport(LocationManager locationManager, GnssStatusCompat.Callback callback) {
            Preconditions.checkArgument(callback != null, "invalid null callback");
            this.f2448c = locationManager;
            this.f2447a = callback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(Executor executor) {
            if (this.b != executor) {
                return;
            }
            this.f2447a.onStopped();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(Executor executor, int i) {
            if (this.b != executor) {
                return;
            }
            this.f2447a.onFirstFix(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(Executor executor, GnssStatusCompat gnssStatusCompat) {
            if (this.b != executor) {
                return;
            }
            this.f2447a.onSatelliteStatusChanged(gnssStatusCompat);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(Executor executor) {
            if (this.b != executor) {
                return;
            }
            this.f2447a.onStarted();
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i) {
            GpsStatus gpsStatus;
            final Executor executor = this.b;
            if (executor == null) {
                return;
            }
            if (i == 1) {
                executor.execute(new Runnable() { // from class: androidx.core.location.-$$Lambda$LocationManagerCompat$GpsStatusTransport$E7bbTN5atk4WHGiq0D19H9Se9KM
                    @Override // java.lang.Runnable
                    public final void run() {
                        LocationManagerCompat.GpsStatusTransport.this.b(executor);
                    }
                });
            } else if (i == 2) {
                executor.execute(new Runnable() { // from class: androidx.core.location.-$$Lambda$LocationManagerCompat$GpsStatusTransport$Io7nnU3tyjoAX2q5UAXjffp6pO8
                    @Override // java.lang.Runnable
                    public final void run() {
                        LocationManagerCompat.GpsStatusTransport.this.a(executor);
                    }
                });
            } else if (i != 3) {
                if (i == 4 && (gpsStatus = this.f2448c.getGpsStatus(null)) != null) {
                    final GnssStatusCompat wrap = GnssStatusCompat.wrap(gpsStatus);
                    executor.execute(new Runnable() { // from class: androidx.core.location.-$$Lambda$LocationManagerCompat$GpsStatusTransport$aujm7bjwJtMuNWVDZIS2NiOn7vw
                        @Override // java.lang.Runnable
                        public final void run() {
                            LocationManagerCompat.GpsStatusTransport.this.a(executor, wrap);
                        }
                    });
                }
            } else {
                GpsStatus gpsStatus2 = this.f2448c.getGpsStatus(null);
                if (gpsStatus2 != null) {
                    final int timeToFirstFix = gpsStatus2.getTimeToFirstFix();
                    executor.execute(new Runnable() { // from class: androidx.core.location.-$$Lambda$LocationManagerCompat$GpsStatusTransport$EGbl3DPznTOhaGSsRQ0Se9W86Uo
                        @Override // java.lang.Runnable
                        public final void run() {
                            LocationManagerCompat.GpsStatusTransport.this.a(executor, timeToFirstFix);
                        }
                    });
                }
            }
        }

        public void register(Executor executor) {
            Preconditions.checkState(this.b == null);
            this.b = executor;
        }

        public void unregister() {
            this.b = null;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/location/LocationManagerCompat$InlineHandlerExecutor.class */
    static final class InlineHandlerExecutor implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f2449a;

        InlineHandlerExecutor(Handler handler) {
            this.f2449a = (Handler) Preconditions.checkNotNull(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (Looper.myLooper() == this.f2449a.getLooper()) {
                runnable.run();
            } else if (this.f2449a.post((Runnable) Preconditions.checkNotNull(runnable))) {
            } else {
                throw new RejectedExecutionException(this.f2449a + " is shutting down");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/location/LocationManagerCompat$LocationListenerTransport.class */
    public static class LocationListenerTransport implements LocationListener {

        /* renamed from: a  reason: collision with root package name */
        volatile LocationListenerCompat f2450a;
        final Executor b;

        LocationListenerTransport(LocationListenerCompat locationListenerCompat, Executor executor) {
            this.f2450a = (LocationListenerCompat) ObjectsCompat.requireNonNull(locationListenerCompat, "invalid null listener");
            this.b = executor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(LocationListenerCompat locationListenerCompat, int i) {
            if (this.f2450a != locationListenerCompat) {
                return;
            }
            locationListenerCompat.onFlushComplete(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(LocationListenerCompat locationListenerCompat, Location location) {
            if (this.f2450a != locationListenerCompat) {
                return;
            }
            locationListenerCompat.onLocationChanged(location);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(LocationListenerCompat locationListenerCompat, String str) {
            if (this.f2450a != locationListenerCompat) {
                return;
            }
            locationListenerCompat.onProviderDisabled(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(LocationListenerCompat locationListenerCompat, String str, int i, Bundle bundle) {
            if (this.f2450a != locationListenerCompat) {
                return;
            }
            locationListenerCompat.onStatusChanged(str, i, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(LocationListenerCompat locationListenerCompat, List list) {
            if (this.f2450a != locationListenerCompat) {
                return;
            }
            locationListenerCompat.onLocationChanged(list);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean a(WeakReference weakReference) {
            return weakReference.get() == null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(LocationListenerCompat locationListenerCompat, String str) {
            if (this.f2450a != locationListenerCompat) {
                return;
            }
            locationListenerCompat.onProviderEnabled(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean b(WeakReference weakReference) {
            return weakReference.get() == null;
        }

        public void onFlushComplete(final int i) {
            final LocationListenerCompat locationListenerCompat = this.f2450a;
            if (locationListenerCompat == null) {
                return;
            }
            this.b.execute(new Runnable() { // from class: androidx.core.location.-$$Lambda$LocationManagerCompat$LocationListenerTransport$6XNAi_lUeMkJkH1UPrMcuoiPCME
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.LocationListenerTransport.this.a(locationListenerCompat, i);
                }
            });
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(final Location location) {
            final LocationListenerCompat locationListenerCompat = this.f2450a;
            if (locationListenerCompat == null) {
                return;
            }
            this.b.execute(new Runnable() { // from class: androidx.core.location.-$$Lambda$LocationManagerCompat$LocationListenerTransport$xJ5JGE-TFDB_DC-oWgBpGk1ihSo
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.LocationListenerTransport.this.a(locationListenerCompat, location);
                }
            });
        }

        public void onLocationChanged(final List<Location> list) {
            final LocationListenerCompat locationListenerCompat = this.f2450a;
            if (locationListenerCompat == null) {
                return;
            }
            this.b.execute(new Runnable() { // from class: androidx.core.location.-$$Lambda$LocationManagerCompat$LocationListenerTransport$d6sn-5-QdYaSCtXjO4WxQ7Fkpkc
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.LocationListenerTransport.this.a(locationListenerCompat, list);
                }
            });
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(final String str) {
            final LocationListenerCompat locationListenerCompat = this.f2450a;
            if (locationListenerCompat == null) {
                return;
            }
            this.b.execute(new Runnable() { // from class: androidx.core.location.-$$Lambda$LocationManagerCompat$LocationListenerTransport$Pn7llc1kuKRe9OYnvZtQaqb_AIU
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.LocationListenerTransport.this.a(locationListenerCompat, str);
                }
            });
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(final String str) {
            final LocationListenerCompat locationListenerCompat = this.f2450a;
            if (locationListenerCompat == null) {
                return;
            }
            this.b.execute(new Runnable() { // from class: androidx.core.location.-$$Lambda$LocationManagerCompat$LocationListenerTransport$1rKE8yfs6Uh08YGZHPXMCYdA5dY
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.LocationListenerTransport.this.b(locationListenerCompat, str);
                }
            });
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(final String str, final int i, final Bundle bundle) {
            final LocationListenerCompat locationListenerCompat = this.f2450a;
            if (locationListenerCompat == null) {
                return;
            }
            this.b.execute(new Runnable() { // from class: androidx.core.location.-$$Lambda$LocationManagerCompat$LocationListenerTransport$yUmsUia5rrtWbi0Yp2eQ0EJ7C3A
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.LocationListenerTransport.this.a(locationListenerCompat, str, i, bundle);
                }
            });
        }

        public void register() {
            ArrayList arrayList;
            List<WeakReference<LocationListenerTransport>> list = LocationManagerCompat.f2439a.get(this.f2450a);
            if (list != null) {
                if (Build.VERSION.SDK_INT < 24) {
                    Iterator<WeakReference<LocationListenerTransport>> it = list.iterator();
                    while (true) {
                        arrayList = list;
                        if (!it.hasNext()) {
                            break;
                        } else if (it.next().get() == null) {
                            it.remove();
                        }
                    }
                } else {
                    list.removeIf(new Predicate() { // from class: androidx.core.location.-$$Lambda$LocationManagerCompat$LocationListenerTransport$he6IewwrJp9ugG486TeYQ6yy9_s
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            boolean b;
                            b = LocationManagerCompat.LocationListenerTransport.b((WeakReference) obj);
                            return b;
                        }
                    });
                    arrayList = list;
                }
            } else {
                arrayList = new ArrayList(1);
                LocationManagerCompat.f2439a.put(this.f2450a, arrayList);
            }
            arrayList.add(new WeakReference<>(this));
        }

        public boolean unregister() {
            LocationListenerCompat locationListenerCompat = this.f2450a;
            if (locationListenerCompat == null) {
                return false;
            }
            this.f2450a = null;
            List<WeakReference<LocationListenerTransport>> list = LocationManagerCompat.f2439a.get(locationListenerCompat);
            if (list != null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    list.removeIf(new Predicate() { // from class: androidx.core.location.-$$Lambda$LocationManagerCompat$LocationListenerTransport$YO_NVm-iIeAOAHsk_sesNQKF4Vo
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            boolean a2;
                            a2 = LocationManagerCompat.LocationListenerTransport.a((WeakReference) obj);
                            return a2;
                        }
                    });
                } else {
                    Iterator<WeakReference<LocationListenerTransport>> it = list.iterator();
                    while (it.hasNext()) {
                        if (it.next().get() == null) {
                            it.remove();
                        }
                    }
                }
                if (list.isEmpty()) {
                    LocationManagerCompat.f2439a.remove(locationListenerCompat);
                    return true;
                }
                return true;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/location/LocationManagerCompat$PreRGnssStatusTransport.class */
    public static class PreRGnssStatusTransport extends GnssStatus.Callback {

        /* renamed from: a  reason: collision with root package name */
        final GnssStatusCompat.Callback f2451a;
        volatile Executor b;

        PreRGnssStatusTransport(GnssStatusCompat.Callback callback) {
            Preconditions.checkArgument(callback != null, "invalid null callback");
            this.f2451a = callback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(Executor executor) {
            if (this.b != executor) {
                return;
            }
            this.f2451a.onStopped();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(Executor executor, int i) {
            if (this.b != executor) {
                return;
            }
            this.f2451a.onFirstFix(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(Executor executor, GnssStatus gnssStatus) {
            if (this.b != executor) {
                return;
            }
            this.f2451a.onSatelliteStatusChanged(GnssStatusCompat.wrap(gnssStatus));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(Executor executor) {
            if (this.b != executor) {
                return;
            }
            this.f2451a.onStarted();
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(final int i) {
            final Executor executor = this.b;
            if (executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: androidx.core.location.-$$Lambda$LocationManagerCompat$PreRGnssStatusTransport$u7gM2v98ZKSrX51zb4DdWcrUIT8
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.PreRGnssStatusTransport.this.a(executor, i);
                }
            });
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(final GnssStatus gnssStatus) {
            final Executor executor = this.b;
            if (executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: androidx.core.location.-$$Lambda$LocationManagerCompat$PreRGnssStatusTransport$490lR7FaQ471enxX8ZQpXd3Bljo
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.PreRGnssStatusTransport.this.a(executor, gnssStatus);
                }
            });
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            final Executor executor = this.b;
            if (executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: androidx.core.location.-$$Lambda$LocationManagerCompat$PreRGnssStatusTransport$FfM9NqnNMSc7fL6946VQ0aagLxs
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.PreRGnssStatusTransport.this.b(executor);
                }
            });
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            final Executor executor = this.b;
            if (executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: androidx.core.location.-$$Lambda$LocationManagerCompat$PreRGnssStatusTransport$fRKKcoWIQCP6rqGMvofBKzrWLRw
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.PreRGnssStatusTransport.this.a(executor);
                }
            });
        }

        public void register(Executor executor) {
            Preconditions.checkArgument(executor != null, "invalid null executor");
            Preconditions.checkState(this.b == null);
            this.b = executor;
        }

        public void unregister() {
            this.b = null;
        }
    }

    private LocationManagerCompat() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean a(LocationManager locationManager, GpsStatusTransport gpsStatusTransport) throws Exception {
        return Boolean.valueOf(locationManager.addGpsStatusListener(gpsStatusTransport));
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x023c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(final android.location.LocationManager r7, android.os.Handler r8, java.util.concurrent.Executor r9, androidx.core.location.GnssStatusCompat.Callback r10) {
        /*
            Method dump skipped, instructions count: 648
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.location.LocationManagerCompat.a(android.location.LocationManager, android.os.Handler, java.util.concurrent.Executor, androidx.core.location.GnssStatusCompat$Callback):boolean");
    }

    public static void getCurrentLocation(LocationManager locationManager, String str, CancellationSignal cancellationSignal, Executor executor, final Consumer<Location> consumer) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.a(locationManager, str, cancellationSignal, executor, consumer);
            return;
        }
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        final Location lastKnownLocation = locationManager.getLastKnownLocation(str);
        if (lastKnownLocation != null && SystemClock.elapsedRealtime() - LocationCompat.getElapsedRealtimeMillis(lastKnownLocation) < 10000) {
            executor.execute(new Runnable() { // from class: androidx.core.location.-$$Lambda$LocationManagerCompat$G5QRO0e2OsgRA2LQFtlVhOXqWfk
                @Override // java.lang.Runnable
                public final void run() {
                    Consumer.this.accept(lastKnownLocation);
                }
            });
            return;
        }
        final CancellableLocationListener cancellableLocationListener = new CancellableLocationListener(locationManager, executor, consumer);
        locationManager.requestLocationUpdates(str, 0L, 0.0f, cancellableLocationListener, Looper.getMainLooper());
        if (cancellationSignal != null) {
            cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.core.location.LocationManagerCompat.1
                @Override // androidx.core.os.CancellationSignal.OnCancelListener
                public void onCancel() {
                    CancellableLocationListener.this.cancel();
                }
            });
        }
        cancellableLocationListener.startTimeout(30000L);
    }

    public static String getGnssHardwareModelName(LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.b(locationManager);
        }
        return null;
    }

    public static int getGnssYearOfHardware(LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.c(locationManager);
        }
        return 0;
    }

    public static boolean hasProvider(LocationManager locationManager, String str) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.a(locationManager, str);
        }
        if (locationManager.getAllProviders().contains(str)) {
            return true;
        }
        try {
            return locationManager.getProvider(str) != null;
        } catch (SecurityException e) {
            return false;
        }
    }

    public static boolean isLocationEnabled(LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.a(locationManager);
        }
        boolean z = false;
        if (Build.VERSION.SDK_INT <= 19) {
            try {
                if (b == null) {
                    Field declaredField = LocationManager.class.getDeclaredField("mContext");
                    b = declaredField;
                    declaredField.setAccessible(true);
                }
                Context context = (Context) b.get(locationManager);
                if (context != null) {
                    return Build.VERSION.SDK_INT == 19 ? Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.LOCATION_MODE, 0) != 0 : !TextUtils.isEmpty(Settings.Secure.getString(context.getContentResolver(), "location_providers_allowed"));
                }
            } catch (ClassCastException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
            }
        }
        if (locationManager.isProviderEnabled("network") || locationManager.isProviderEnabled("gps")) {
            z = true;
        }
        return z;
    }

    public static boolean registerGnssStatusCallback(LocationManager locationManager, GnssStatusCompat.Callback callback, Handler handler) {
        return Build.VERSION.SDK_INT >= 30 ? registerGnssStatusCallback(locationManager, ExecutorCompat.create(handler), callback) : registerGnssStatusCallback(locationManager, new InlineHandlerExecutor(handler), callback);
    }

    public static boolean registerGnssStatusCallback(LocationManager locationManager, Executor executor, GnssStatusCompat.Callback callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            return a(locationManager, null, executor, callback);
        }
        Looper myLooper = Looper.myLooper();
        Looper looper = myLooper;
        if (myLooper == null) {
            looper = Looper.getMainLooper();
        }
        return a(locationManager, new Handler(looper), executor, callback);
    }

    public static void removeUpdates(LocationManager locationManager, LocationListenerCompat locationListenerCompat) {
        synchronized (f2439a) {
            List<WeakReference<LocationListenerTransport>> remove = f2439a.remove(locationListenerCompat);
            if (remove != null) {
                for (WeakReference<LocationListenerTransport> weakReference : remove) {
                    LocationListenerTransport locationListenerTransport = weakReference.get();
                    if (locationListenerTransport != null && locationListenerTransport.unregister()) {
                        locationManager.removeUpdates(locationListenerTransport);
                    }
                }
            }
        }
        locationManager.removeUpdates(locationListenerCompat);
    }

    public static void requestLocationUpdates(LocationManager locationManager, String str, LocationRequestCompat locationRequestCompat, LocationListenerCompat locationListenerCompat, Looper looper) {
        if (Build.VERSION.SDK_INT >= 31) {
            Api31Impl.a(locationManager, str, locationRequestCompat.toLocationRequest(), ExecutorCompat.create(new Handler(looper)), locationListenerCompat);
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                if (d == null) {
                    Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", LocationRequest.class, LocationListener.class, Looper.class);
                    d = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                try {
                    LocationRequest locationRequest = locationRequestCompat.toLocationRequest(str);
                    if (locationRequest != null) {
                        d.invoke(locationManager, locationRequest, locationListenerCompat, looper);
                        return;
                    }
                } catch (IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException e) {
                }
            } catch (IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException e2) {
            }
        }
        locationManager.requestLocationUpdates(str, locationRequestCompat.getIntervalMillis(), locationRequestCompat.getMinUpdateDistanceMeters(), locationListenerCompat, looper);
    }

    public static void requestLocationUpdates(LocationManager locationManager, String str, LocationRequestCompat locationRequestCompat, Executor executor, LocationListenerCompat locationListenerCompat) {
        if (Build.VERSION.SDK_INT >= 31) {
            Api31Impl.a(locationManager, str, locationRequestCompat.toLocationRequest(), executor, locationListenerCompat);
            return;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                if (f2440c == null) {
                    Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", LocationRequest.class, Executor.class, LocationListener.class);
                    f2440c = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                LocationRequest locationRequest = locationRequestCompat.toLocationRequest(str);
                if (locationRequest != null) {
                    f2440c.invoke(locationManager, locationRequest, executor, locationListenerCompat);
                    return;
                }
            } catch (IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException e) {
            }
        }
        LocationListenerTransport locationListenerTransport = new LocationListenerTransport(locationListenerCompat, executor);
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                if (d == null) {
                    Method declaredMethod2 = LocationManager.class.getDeclaredMethod("requestLocationUpdates", LocationRequest.class, LocationListener.class, Looper.class);
                    d = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                }
                LocationRequest locationRequest2 = locationRequestCompat.toLocationRequest(str);
                if (locationRequest2 != null) {
                    synchronized (f2439a) {
                        d.invoke(locationManager, locationRequest2, locationListenerTransport, Looper.getMainLooper());
                        locationListenerTransport.register();
                    }
                    return;
                }
            } catch (IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException e2) {
            }
        }
        synchronized (f2439a) {
            locationManager.requestLocationUpdates(str, locationRequestCompat.getIntervalMillis(), locationRequestCompat.getMinUpdateDistanceMeters(), locationListenerTransport, Looper.getMainLooper());
            locationListenerTransport.register();
        }
    }

    public static void unregisterGnssStatusCallback(LocationManager locationManager, GnssStatusCompat.Callback callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            synchronized (GnssLazyLoader.f2445a) {
                GnssStatus.Callback callback2 = (GnssStatusTransport) GnssLazyLoader.f2445a.remove(callback);
                if (callback2 != null) {
                    locationManager.unregisterGnssStatusCallback(callback2);
                }
            }
        } else if (Build.VERSION.SDK_INT >= 24) {
            synchronized (GnssLazyLoader.f2445a) {
                PreRGnssStatusTransport preRGnssStatusTransport = (PreRGnssStatusTransport) GnssLazyLoader.f2445a.remove(callback);
                if (preRGnssStatusTransport != null) {
                    preRGnssStatusTransport.unregister();
                    locationManager.unregisterGnssStatusCallback(preRGnssStatusTransport);
                }
            }
        } else {
            synchronized (GnssLazyLoader.f2445a) {
                GpsStatusTransport gpsStatusTransport = (GpsStatusTransport) GnssLazyLoader.f2445a.remove(callback);
                if (gpsStatusTransport != null) {
                    gpsStatusTransport.unregister();
                    locationManager.removeGpsStatusListener(gpsStatusTransport);
                }
            }
        }
    }
}
