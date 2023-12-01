package android.view;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.view.IInputFilter;

/* loaded from: source-9557208-dex2jar.jar:android/view/InputFilter.class */
public abstract class InputFilter extends IInputFilter.Stub {
    private static final int MSG_INPUT_EVENT = 3;
    private static final int MSG_INSTALL = 1;
    private static final int MSG_UNINSTALL = 2;
    private final H mH;
    private IInputFilterHost mHost;
    private final InputEventConsistencyVerifier mInboundInputEventConsistencyVerifier;
    private final InputEventConsistencyVerifier mOutboundInputEventConsistencyVerifier;

    /* loaded from: source-9557208-dex2jar.jar:android/view/InputFilter$H.class */
    private final class H extends Handler {
        public H(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    InputFilter.this.mHost = (IInputFilterHost) message.obj;
                    if (InputFilter.this.mInboundInputEventConsistencyVerifier != null) {
                        InputFilter.this.mInboundInputEventConsistencyVerifier.reset();
                    }
                    if (InputFilter.this.mOutboundInputEventConsistencyVerifier != null) {
                        InputFilter.this.mOutboundInputEventConsistencyVerifier.reset();
                    }
                    InputFilter.this.onInstalled();
                    return;
                case 2:
                    try {
                        InputFilter.this.onUninstalled();
                        return;
                    } finally {
                        InputFilter.this.mHost = null;
                    }
                case 3:
                    InputEvent inputEvent = (InputEvent) message.obj;
                    try {
                        if (InputFilter.this.mInboundInputEventConsistencyVerifier != null) {
                            InputFilter.this.mInboundInputEventConsistencyVerifier.onInputEvent(inputEvent, 0);
                        }
                        InputFilter.this.onInputEvent(inputEvent, message.arg1);
                        return;
                    } finally {
                        inputEvent.recycle();
                    }
                default:
                    return;
            }
        }
    }

    public InputFilter(Looper looper) {
        this.mInboundInputEventConsistencyVerifier = InputEventConsistencyVerifier.isInstrumentationEnabled() ? new InputEventConsistencyVerifier(this, 1, "InputFilter#InboundInputEventConsistencyVerifier") : null;
        this.mOutboundInputEventConsistencyVerifier = InputEventConsistencyVerifier.isInstrumentationEnabled() ? new InputEventConsistencyVerifier(this, 1, "InputFilter#OutboundInputEventConsistencyVerifier") : null;
        this.mH = new H(looper);
    }

    @Override // android.view.IInputFilter
    public final void filterInputEvent(InputEvent inputEvent, int i) {
        this.mH.obtainMessage(3, i, 0, inputEvent).sendToTarget();
    }

    @Override // android.view.IInputFilter
    public final void install(IInputFilterHost iInputFilterHost) {
        this.mH.obtainMessage(1, iInputFilterHost).sendToTarget();
    }

    public void onInputEvent(InputEvent inputEvent, int i) {
        sendInputEvent(inputEvent, i);
    }

    public void onInstalled() {
    }

    public void onUninstalled() {
    }

    public void sendInputEvent(InputEvent inputEvent, int i) {
        if (inputEvent == null) {
            throw new IllegalArgumentException("event must not be null");
        }
        if (this.mHost == null) {
            throw new IllegalStateException("Cannot send input event because the input filter is not installed.");
        }
        if (this.mOutboundInputEventConsistencyVerifier != null) {
            this.mOutboundInputEventConsistencyVerifier.onInputEvent(inputEvent, 0);
        }
        try {
            this.mHost.sendInputEvent(inputEvent, i);
        } catch (RemoteException e) {
        }
    }

    @Override // android.view.IInputFilter
    public final void uninstall() {
        this.mH.obtainMessage(2).sendToTarget();
    }
}
