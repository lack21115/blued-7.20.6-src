package android.service.voice;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.service.voice.IVoiceInteractionSessionService;
import com.android.internal.app.IVoiceInteractionManagerService;
import com.android.internal.os.HandlerCaller;
import com.android.internal.os.SomeArgs;

/* loaded from: source-9557208-dex2jar.jar:android/service/voice/VoiceInteractionSessionService.class */
public abstract class VoiceInteractionSessionService extends Service {
    static final int MSG_NEW_SESSION = 1;
    HandlerCaller mHandlerCaller;
    VoiceInteractionSession mSession;
    IVoiceInteractionManagerService mSystemService;
    IVoiceInteractionSessionService mInterface = new IVoiceInteractionSessionService.Stub() { // from class: android.service.voice.VoiceInteractionSessionService.1
        @Override // android.service.voice.IVoiceInteractionSessionService
        public void newSession(IBinder iBinder, Bundle bundle) {
            VoiceInteractionSessionService.this.mHandlerCaller.sendMessage(VoiceInteractionSessionService.this.mHandlerCaller.obtainMessageOO(1, iBinder, bundle));
        }
    };
    final HandlerCaller.Callback mHandlerCallerCallback = new HandlerCaller.Callback() { // from class: android.service.voice.VoiceInteractionSessionService.2
        @Override // com.android.internal.os.HandlerCaller.Callback
        public void executeMessage(Message message) {
            SomeArgs someArgs = (SomeArgs) message.obj;
            switch (message.what) {
                case 1:
                    VoiceInteractionSessionService.this.doNewSession((IBinder) someArgs.arg1, (Bundle) someArgs.arg2);
                    return;
                default:
                    return;
            }
        }
    };

    void doNewSession(IBinder iBinder, Bundle bundle) {
        if (this.mSession != null) {
            this.mSession.doDestroy();
            this.mSession = null;
        }
        this.mSession = onNewSession(bundle);
        try {
            this.mSystemService.deliverNewSession(iBinder, this.mSession.mSession, this.mSession.mInteractor);
            this.mSession.doCreate(this.mSystemService, iBinder, bundle);
        } catch (RemoteException e) {
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mInterface.asBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mSystemService = IVoiceInteractionManagerService.Stub.asInterface(ServiceManager.getService(Context.VOICE_INTERACTION_MANAGER_SERVICE));
        this.mHandlerCaller = new HandlerCaller(this, Looper.myLooper(), this.mHandlerCallerCallback, true);
    }

    public abstract VoiceInteractionSession onNewSession(Bundle bundle);
}
