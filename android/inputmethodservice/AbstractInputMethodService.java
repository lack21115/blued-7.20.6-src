package android.inputmethodservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodSession;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: source-9557208-dex2jar.jar:android/inputmethodservice/AbstractInputMethodService.class */
public abstract class AbstractInputMethodService extends Service implements KeyEvent.Callback {
    final KeyEvent.DispatcherState mDispatcherState = new KeyEvent.DispatcherState();
    private InputMethod mInputMethod;

    /* loaded from: source-9557208-dex2jar.jar:android/inputmethodservice/AbstractInputMethodService$AbstractInputMethodImpl.class */
    public abstract class AbstractInputMethodImpl implements InputMethod {
        public AbstractInputMethodImpl() {
        }

        @Override // android.view.inputmethod.InputMethod
        public void createSession(InputMethod.SessionCallback sessionCallback) {
            sessionCallback.sessionCreated(AbstractInputMethodService.this.onCreateInputMethodSessionInterface());
        }

        @Override // android.view.inputmethod.InputMethod
        public void revokeSession(InputMethodSession inputMethodSession) {
            ((AbstractInputMethodSessionImpl) inputMethodSession).revokeSelf();
        }

        @Override // android.view.inputmethod.InputMethod
        public void setSessionEnabled(InputMethodSession inputMethodSession, boolean z) {
            ((AbstractInputMethodSessionImpl) inputMethodSession).setEnabled(z);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/inputmethodservice/AbstractInputMethodService$AbstractInputMethodSessionImpl.class */
    public abstract class AbstractInputMethodSessionImpl implements InputMethodSession {
        boolean mEnabled = true;
        boolean mRevoked;

        public AbstractInputMethodSessionImpl() {
        }

        @Override // android.view.inputmethod.InputMethodSession
        public void dispatchGenericMotionEvent(int i, MotionEvent motionEvent, InputMethodSession.EventCallback eventCallback) {
            boolean onGenericMotionEvent = AbstractInputMethodService.this.onGenericMotionEvent(motionEvent);
            if (eventCallback != null) {
                eventCallback.finishedEvent(i, onGenericMotionEvent);
            }
        }

        @Override // android.view.inputmethod.InputMethodSession
        public void dispatchKeyEvent(int i, KeyEvent keyEvent, InputMethodSession.EventCallback eventCallback) {
            boolean dispatch = keyEvent.dispatch(AbstractInputMethodService.this, AbstractInputMethodService.this.mDispatcherState, this);
            if (eventCallback != null) {
                eventCallback.finishedEvent(i, dispatch);
            }
        }

        @Override // android.view.inputmethod.InputMethodSession
        public void dispatchTrackballEvent(int i, MotionEvent motionEvent, InputMethodSession.EventCallback eventCallback) {
            boolean onTrackballEvent = AbstractInputMethodService.this.onTrackballEvent(motionEvent);
            if (eventCallback != null) {
                eventCallback.finishedEvent(i, onTrackballEvent);
            }
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public boolean isRevoked() {
            return this.mRevoked;
        }

        public void revokeSelf() {
            this.mRevoked = true;
            this.mEnabled = false;
        }

        public void setEnabled(boolean z) {
            if (this.mRevoked) {
                return;
            }
            this.mEnabled = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Service
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public KeyEvent.DispatcherState getKeyDispatcherState() {
        return this.mDispatcherState;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        if (this.mInputMethod == null) {
            this.mInputMethod = onCreateInputMethodInterface();
        }
        return new IInputMethodWrapper(this, this.mInputMethod);
    }

    public abstract AbstractInputMethodImpl onCreateInputMethodInterface();

    public abstract AbstractInputMethodSessionImpl onCreateInputMethodSessionInterface();

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        return false;
    }
}
