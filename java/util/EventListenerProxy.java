package java.util;

/* loaded from: source-2895416-dex2jar.jar:java/util/EventListenerProxy.class */
public abstract class EventListenerProxy implements EventListener {
    private final EventListener listener;

    public EventListenerProxy(EventListener eventListener) {
        this.listener = eventListener;
    }

    public EventListener getListener() {
        return this.listener;
    }
}
