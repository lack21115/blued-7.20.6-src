package android.net;

import android.content.Context;
import android.net.SamplingDataTracker;
import android.os.Handler;
import android.os.Messenger;
import com.android.internal.util.Preconditions;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-9557208-dex2jar.jar:android/net/BaseNetworkStateTracker.class */
public abstract class BaseNetworkStateTracker implements NetworkStateTracker {
    public static final String PROP_TCP_BUFFER_UNKNOWN = "net.tcp.buffersize.unknown";
    public static final String PROP_TCP_BUFFER_WIFI = "net.tcp.buffersize.wifi";
    protected Context mContext;
    private AtomicBoolean mDefaultRouteSet;
    protected LinkProperties mLinkProperties;
    protected Network mNetwork;
    protected NetworkCapabilities mNetworkCapabilities;
    protected NetworkInfo mNetworkInfo;
    private AtomicBoolean mPrivateDnsRouteSet;
    private Handler mTarget;
    private AtomicBoolean mTeardownRequested;

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseNetworkStateTracker() {
        this.mNetwork = new Network(0);
        this.mTeardownRequested = new AtomicBoolean(false);
        this.mPrivateDnsRouteSet = new AtomicBoolean(false);
        this.mDefaultRouteSet = new AtomicBoolean(false);
    }

    public BaseNetworkStateTracker(int i) {
        this.mNetwork = new Network(0);
        this.mTeardownRequested = new AtomicBoolean(false);
        this.mPrivateDnsRouteSet = new AtomicBoolean(false);
        this.mDefaultRouteSet = new AtomicBoolean(false);
        this.mNetworkInfo = new NetworkInfo(i, -1, ConnectivityManager.getNetworkTypeName(i), null);
        this.mLinkProperties = new LinkProperties();
        this.mNetworkCapabilities = new NetworkCapabilities();
    }

    @Override // android.net.NetworkStateTracker
    public void captivePortalCheckCompleted(boolean z) {
    }

    @Override // android.net.NetworkStateTracker
    public void defaultRouteSet(boolean z) {
        this.mDefaultRouteSet.set(z);
    }

    protected final void dispatchConfigurationChanged() {
        this.mTarget.obtainMessage(NetworkStateTracker.EVENT_CONFIGURATION_CHANGED, getNetworkInfo()).sendToTarget();
    }

    protected final void dispatchStateChanged() {
        this.mTarget.obtainMessage(458752, getNetworkInfo()).sendToTarget();
    }

    @Override // android.net.NetworkStateTracker
    public LinkProperties getLinkProperties() {
        return new LinkProperties(this.mLinkProperties);
    }

    @Override // android.net.NetworkStateTracker
    public LinkQualityInfo getLinkQualityInfo() {
        return null;
    }

    @Override // android.net.NetworkStateTracker
    public Network getNetwork() {
        return this.mNetwork;
    }

    @Override // android.net.NetworkStateTracker
    public NetworkCapabilities getNetworkCapabilities() {
        return new NetworkCapabilities(this.mNetworkCapabilities);
    }

    @Override // android.net.NetworkStateTracker
    public NetworkInfo getNetworkInfo() {
        return new NetworkInfo(this.mNetworkInfo);
    }

    @Override // android.net.NetworkStateTracker
    public String getNetworkInterfaceName() {
        if (this.mLinkProperties != null) {
            return this.mLinkProperties.getInterfaceName();
        }
        return null;
    }

    @Deprecated
    protected Handler getTargetHandler() {
        return this.mTarget;
    }

    @Override // android.net.NetworkStateTracker
    public boolean isAvailable() {
        return this.mNetworkInfo.isAvailable();
    }

    @Override // android.net.NetworkStateTracker
    public boolean isDefaultRouteSet() {
        return this.mDefaultRouteSet.get();
    }

    @Override // android.net.NetworkStateTracker
    public boolean isPrivateDnsRouteSet() {
        return this.mPrivateDnsRouteSet.get();
    }

    @Override // android.net.NetworkStateTracker
    public boolean isTeardownRequested() {
        return this.mTeardownRequested.get();
    }

    @Override // android.net.NetworkStateTracker
    public void privateDnsRouteSet(boolean z) {
        this.mPrivateDnsRouteSet.set(z);
    }

    @Override // android.net.NetworkStateTracker
    public void setDependencyMet(boolean z) {
    }

    @Override // android.net.NetworkStateTracker
    public void setNetId(int i) {
        this.mNetwork = new Network(i);
    }

    @Override // android.net.NetworkStateTracker
    public void setPolicyDataEnable(boolean z) {
    }

    @Override // android.net.NetworkStateTracker
    public boolean setRadio(boolean z) {
        return true;
    }

    @Override // android.net.NetworkStateTracker
    public void setTeardownRequested(boolean z) {
        this.mTeardownRequested.set(z);
    }

    @Override // android.net.NetworkStateTracker
    public void setUserDataEnable(boolean z) {
    }

    @Override // android.net.NetworkStateTracker
    public void startMonitoring(Context context, Handler handler) {
        this.mContext = (Context) Preconditions.checkNotNull(context);
        this.mTarget = (Handler) Preconditions.checkNotNull(handler);
        startMonitoringInternal();
    }

    protected void startMonitoringInternal() {
    }

    @Override // android.net.NetworkStateTracker
    public void startSampling(SamplingDataTracker.SamplingSnapshot samplingSnapshot) {
    }

    @Override // android.net.NetworkStateTracker
    public void stopSampling(SamplingDataTracker.SamplingSnapshot samplingSnapshot) {
    }

    @Override // android.net.NetworkStateTracker
    public void supplyMessenger(Messenger messenger) {
    }
}
