package libcore.net.event;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-2895416-dex2jar.jar:libcore/net/event/NetworkEventDispatcher.class */
public class NetworkEventDispatcher {
    private static final NetworkEventDispatcher instance = new NetworkEventDispatcher();
    private final List<NetworkEventListener> listeners = new CopyOnWriteArrayList();

    protected NetworkEventDispatcher() {
    }

    public static NetworkEventDispatcher getInstance() {
        return instance;
    }

    public void addListener(NetworkEventListener networkEventListener) {
        if (networkEventListener == null) {
            throw new NullPointerException("toAdd == null");
        }
        this.listeners.add(networkEventListener);
    }

    public void onNetworkConfigurationChanged() {
        for (NetworkEventListener networkEventListener : this.listeners) {
            try {
                networkEventListener.onNetworkConfigurationChanged();
            } catch (RuntimeException e) {
                System.logI("Exception thrown during network event propagation", e);
            }
        }
    }

    public void removeListener(NetworkEventListener networkEventListener) {
        for (NetworkEventListener networkEventListener2 : this.listeners) {
            if (networkEventListener2 == networkEventListener) {
                this.listeners.remove(networkEventListener2);
                return;
            }
        }
    }
}
