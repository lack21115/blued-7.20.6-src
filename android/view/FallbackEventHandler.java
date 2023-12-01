package android.view;

/* loaded from: source-9557208-dex2jar.jar:android/view/FallbackEventHandler.class */
public interface FallbackEventHandler {
    boolean dispatchKeyEvent(KeyEvent keyEvent);

    void preDispatchKeyEvent(KeyEvent keyEvent);

    void setView(View view);
}
