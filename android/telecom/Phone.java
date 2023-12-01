package android.telecom;

import android.util.ArrayMap;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/telecom/Phone.class */
public final class Phone {
    private AudioState mAudioState;
    private final InCallAdapter mInCallAdapter;
    private final Map<String, Call> mCallByTelecomCallId = new ArrayMap();
    private final List<Call> mCalls = new CopyOnWriteArrayList();
    private final List<Call> mUnmodifiableCalls = Collections.unmodifiableList(this.mCalls);
    private final List<Listener> mListeners = new CopyOnWriteArrayList();
    private boolean mCanAddCall = true;

    /* loaded from: source-9557208-dex2jar.jar:android/telecom/Phone$Listener.class */
    public static abstract class Listener {
        public void onAudioStateChanged(Phone phone, AudioState audioState) {
        }

        public void onBringToForeground(Phone phone, boolean z) {
        }

        public void onCallAdded(Phone phone, Call call) {
        }

        public void onCallRemoved(Phone phone, Call call) {
        }

        public void onCanAddCallChanged(Phone phone, boolean z) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Phone(InCallAdapter inCallAdapter) {
        this.mInCallAdapter = inCallAdapter;
    }

    private void checkCallTree(ParcelableCall parcelableCall) {
        if (parcelableCall.getParentCallId() != null && !this.mCallByTelecomCallId.containsKey(parcelableCall.getParentCallId())) {
            Log.wtf(this, "ParcelableCall %s has nonexistent parent %s", parcelableCall.getId(), parcelableCall.getParentCallId());
        }
        if (parcelableCall.getChildCallIds() == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= parcelableCall.getChildCallIds().size()) {
                return;
            }
            if (!this.mCallByTelecomCallId.containsKey(parcelableCall.getChildCallIds().get(i2))) {
                Log.wtf(this, "ParcelableCall %s has nonexistent child %s", parcelableCall.getId(), parcelableCall.getChildCallIds().get(i2));
            }
            i = i2 + 1;
        }
    }

    private void fireAudioStateChanged(AudioState audioState) {
        for (Listener listener : this.mListeners) {
            listener.onAudioStateChanged(this, audioState);
        }
    }

    private void fireBringToForeground(boolean z) {
        for (Listener listener : this.mListeners) {
            listener.onBringToForeground(this, z);
        }
    }

    private void fireCallAdded(Call call) {
        for (Listener listener : this.mListeners) {
            listener.onCallAdded(this, call);
        }
    }

    private void fireCallRemoved(Call call) {
        for (Listener listener : this.mListeners) {
            listener.onCallRemoved(this, call);
        }
    }

    private void fireCanAddCallChanged(boolean z) {
        for (Listener listener : this.mListeners) {
            listener.onCanAddCallChanged(this, z);
        }
    }

    public final void addListener(Listener listener) {
        this.mListeners.add(listener);
    }

    public final boolean canAddCall() {
        return this.mCanAddCall;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void destroy() {
        for (Call call : this.mCalls) {
            if (call.getState() != 7) {
                call.internalSetDisconnected();
            }
        }
    }

    public final AudioState getAudioState() {
        return this.mAudioState;
    }

    public final List<Call> getCalls() {
        return this.mUnmodifiableCalls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void internalAddCall(ParcelableCall parcelableCall) {
        Call call = new Call(this, parcelableCall.getId(), this.mInCallAdapter, parcelableCall.mIsActiveSub, parcelableCall.getState());
        this.mCallByTelecomCallId.put(parcelableCall.getId(), call);
        this.mCalls.add(call);
        checkCallTree(parcelableCall);
        call.internalUpdate(parcelableCall, this.mCallByTelecomCallId);
        fireCallAdded(call);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void internalAudioStateChanged(AudioState audioState) {
        if (Objects.equals(this.mAudioState, audioState)) {
            return;
        }
        this.mAudioState = audioState;
        fireAudioStateChanged(audioState);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void internalBringToForeground(boolean z) {
        fireBringToForeground(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Call internalGetCallByTelecomId(String str) {
        return this.mCallByTelecomCallId.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void internalRemoveCall(Call call) {
        this.mCallByTelecomCallId.remove(call.internalGetCallId());
        this.mCalls.remove(call);
        fireCallRemoved(call);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void internalSetCanAddCall(boolean z) {
        if (this.mCanAddCall != z) {
            this.mCanAddCall = z;
            fireCanAddCallChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void internalSetPostDialWait(String str, String str2) {
        Call call = this.mCallByTelecomCallId.get(str);
        if (call != null) {
            call.internalSetPostDialWait(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void internalUpdateCall(ParcelableCall parcelableCall) {
        Call call = this.mCallByTelecomCallId.get(parcelableCall.getId());
        if (call != null) {
            checkCallTree(parcelableCall);
            call.internalUpdate(parcelableCall, this.mCallByTelecomCallId);
        }
    }

    public final void removeListener(Listener listener) {
        if (listener != null) {
            this.mListeners.remove(listener);
        }
    }

    public final void setAudioRoute(int i) {
        this.mInCallAdapter.setAudioRoute(i);
    }

    public final void setMuted(boolean z) {
        this.mInCallAdapter.mute(z);
    }

    public final void setProximitySensorOff(boolean z) {
        this.mInCallAdapter.turnProximitySensorOff(z);
    }

    public final void setProximitySensorOn() {
        this.mInCallAdapter.turnProximitySensorOn();
    }

    public void switchToOtherActiveSub(String str, boolean z) {
        this.mInCallAdapter.switchToOtherActiveSub(str, z);
    }
}
