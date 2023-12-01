package android.hardware.input;

import android.hardware.display.DisplayViewport;
import android.view.InputEvent;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/input/InputManagerInternal.class */
public abstract class InputManagerInternal {
    public abstract boolean injectInputEvent(InputEvent inputEvent, int i, int i2);

    public abstract void setDisplayViewports(DisplayViewport displayViewport, DisplayViewport displayViewport2);

    public abstract void setInteractive(boolean z);
}
