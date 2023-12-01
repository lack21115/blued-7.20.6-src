package android.view.accessibility;

/* loaded from: source-4181928-dex2jar.jar:android/view/accessibility/AccessibilityEventSource.class */
public interface AccessibilityEventSource {
    void sendAccessibilityEvent(int i);

    void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent);
}
