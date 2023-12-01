package android.telecom;

import android.net.Uri;
import android.os.Bundle;
import android.telecom.InCallService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/telecom/Call.class */
public final class Call {
    public static final String AVAILABLE_PHONE_ACCOUNTS = "selectPhoneAccountAccounts";
    public static final int STATE_ACTIVE = 4;
    public static final int STATE_CONNECTING = 9;
    public static final int STATE_DIALING = 1;
    public static final int STATE_DISCONNECTED = 7;
    public static final int STATE_DISCONNECTING = 10;
    public static final int STATE_HOLDING = 3;
    public static final int STATE_NEW = 0;
    public static final int STATE_PRE_DIAL_WAIT = 8;
    public static final int STATE_RINGING = 2;
    private List<String> mCannedTextResponses;
    private final List<Call> mChildren;
    private boolean mChildrenCached;
    private final List<String> mChildrenIds;
    private final List<Call> mConferenceableCalls;
    private Details mDetails;
    private final InCallAdapter mInCallAdapter;
    public boolean mIsActiveSub;
    private final List<Listener> mListeners;
    private String mParentId;
    private final Phone mPhone;
    private String mRemainingPostDialSequence;
    private int mState;
    private final String mTelecomCallId;
    private final List<Call> mUnmodifiableChildren;
    private final List<Call> mUnmodifiableConferenceableCalls;
    private InCallService.VideoCall mVideoCall;

    /* loaded from: source-9557208-dex2jar.jar:android/telecom/Call$Details.class */
    public static class Details {
        public static final int ADD_PARTICIPANT = 32768;
        public static final int CALL_TYPE_MODIFIABLE = 131072;
        public static final int CAPABILITY_ADD_PARTICIPANT = 524288;
        public static final int CAPABILITY_CALL_TYPE_MODIFIABLE = 131072;
        public static final int CAPABILITY_DISCONNECT_FROM_CONFERENCE = 8192;
        public static final int CAPABILITY_GENERIC_CONFERENCE = 16384;
        public static final int CAPABILITY_HIGH_DEF_AUDIO = 1024;
        public static final int CAPABILITY_HOLD = 1;
        public static final int CAPABILITY_MANAGE_CONFERENCE = 128;
        public static final int CAPABILITY_MERGE_CONFERENCE = 4;
        public static final int CAPABILITY_MUTE = 64;
        public static final int CAPABILITY_RESPOND_VIA_TEXT = 32;
        public static final int CAPABILITY_SEPARATE_FROM_CONFERENCE = 4096;
        public static final int CAPABILITY_SPEED_UP_MT_AUDIO = 262144;
        public static final int CAPABILITY_SUPPORTS_VT_LOCAL = 256;
        public static final int CAPABILITY_SUPPORTS_VT_REMOTE = 512;
        public static final int CAPABILITY_SUPPORT_HOLD = 2;
        public static final int CAPABILITY_SWAP_CONFERENCE = 8;
        public static final int CAPABILITY_UNUSED = 16;
        public static final int CAPABILITY_VoWIFI = 2048;
        private final PhoneAccountHandle mAccountHandle;
        private final int mCallCapabilities;
        private final int mCallProperties;
        private final int mCallSubstate;
        private final String mCallerDisplayName;
        private final int mCallerDisplayNamePresentation;
        private final long mConnectTimeMillis;
        private final long mCreateTimeMillis;
        private final DisconnectCause mDisconnectCause;
        private final Bundle mExtras;
        private final GatewayInfo mGatewayInfo;
        private final Uri mHandle;
        private final int mHandlePresentation;
        private final StatusHints mStatusHints;
        private final int mVideoState;

        public Details(Uri uri, int i, String str, int i2, PhoneAccountHandle phoneAccountHandle, int i3, int i4, DisconnectCause disconnectCause, long j, long j2, GatewayInfo gatewayInfo, int i5, StatusHints statusHints, Bundle bundle, int i6) {
            this.mHandle = uri;
            this.mHandlePresentation = i;
            this.mCallerDisplayName = str;
            this.mCallerDisplayNamePresentation = i2;
            this.mAccountHandle = phoneAccountHandle;
            this.mCallCapabilities = i3;
            this.mCallProperties = i4;
            this.mDisconnectCause = disconnectCause;
            this.mCreateTimeMillis = j;
            this.mConnectTimeMillis = j2;
            this.mGatewayInfo = gatewayInfo;
            this.mVideoState = i5;
            this.mStatusHints = statusHints;
            this.mExtras = bundle;
            this.mCallSubstate = i6;
        }

        public static boolean can(int i, int i2) {
            return (i & i2) != 0;
        }

        public static String capabilitiesToString(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append("[Capabilities:");
            if (can(i, 1)) {
                sb.append(" CAPABILITY_HOLD");
            }
            if (can(i, 2)) {
                sb.append(" CAPABILITY_SUPPORT_HOLD");
            }
            if (can(i, 4)) {
                sb.append(" CAPABILITY_MERGE_CONFERENCE");
            }
            if (can(i, 8)) {
                sb.append(" CAPABILITY_SWAP_CONFERENCE");
            }
            if (can(i, 32)) {
                sb.append(" CAPABILITY_RESPOND_VIA_TEXT");
            }
            if (can(i, 64)) {
                sb.append(" CAPABILITY_MUTE");
            }
            if (can(i, 128)) {
                sb.append(" CAPABILITY_MANAGE_CONFERENCE");
            }
            if (can(i, 256)) {
                sb.append(" CAPABILITY_SUPPORTS_VT_LOCAL");
            }
            if (can(i, 512)) {
                sb.append(" CAPABILITY_SUPPORTS_VT_REMOTE");
            }
            if (can(i, 1024)) {
                sb.append(" CAPABILITY_HIGH_DEF_AUDIO");
            }
            if (can(i, 2048)) {
                sb.append(" CAPABILITY_VoWIFI");
            }
            if (can(i, 16384)) {
                sb.append(" CAPABILITY_GENERIC_CONFERENCE");
            }
            if (can(i, 131072)) {
                sb.append(" CALL_TYPE_MODIFIABLE");
            }
            if (can(i, 32768)) {
                sb.append(" ADD_PARTICIPANT");
            }
            if (can(i, 262144)) {
                sb.append(" CAPABILITY_SPEED_UP_IMS_MT_AUDIO");
            }
            sb.append("]");
            return sb.toString();
        }

        public boolean can(int i) {
            return can(this.mCallCapabilities, i);
        }

        public boolean equals(Object obj) {
            boolean z = false;
            if (obj instanceof Details) {
                Details details = (Details) obj;
                z = false;
                if (Objects.equals(this.mHandle, details.mHandle)) {
                    z = false;
                    if (Objects.equals(Integer.valueOf(this.mHandlePresentation), Integer.valueOf(details.mHandlePresentation))) {
                        z = false;
                        if (Objects.equals(this.mCallerDisplayName, details.mCallerDisplayName)) {
                            z = false;
                            if (Objects.equals(Integer.valueOf(this.mCallerDisplayNamePresentation), Integer.valueOf(details.mCallerDisplayNamePresentation))) {
                                z = false;
                                if (Objects.equals(this.mAccountHandle, details.mAccountHandle)) {
                                    z = false;
                                    if (Objects.equals(Integer.valueOf(this.mCallCapabilities), Integer.valueOf(details.mCallCapabilities))) {
                                        z = false;
                                        if (Objects.equals(Integer.valueOf(this.mCallProperties), Integer.valueOf(details.mCallProperties))) {
                                            z = false;
                                            if (Objects.equals(this.mDisconnectCause, details.mDisconnectCause)) {
                                                z = false;
                                                if (Objects.equals(Long.valueOf(this.mCreateTimeMillis), Long.valueOf(details.mCreateTimeMillis))) {
                                                    z = false;
                                                    if (Objects.equals(Long.valueOf(this.mConnectTimeMillis), Long.valueOf(details.mConnectTimeMillis))) {
                                                        z = false;
                                                        if (Objects.equals(this.mGatewayInfo, details.mGatewayInfo)) {
                                                            z = false;
                                                            if (Objects.equals(Integer.valueOf(this.mVideoState), Integer.valueOf(details.mVideoState))) {
                                                                z = false;
                                                                if (Objects.equals(this.mStatusHints, details.mStatusHints)) {
                                                                    z = false;
                                                                    if (Objects.equals(this.mExtras, details.mExtras)) {
                                                                        z = false;
                                                                        if (Objects.equals(Integer.valueOf(this.mCallSubstate), Integer.valueOf(details.mCallSubstate))) {
                                                                            z = true;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return z;
        }

        public PhoneAccountHandle getAccountHandle() {
            return this.mAccountHandle;
        }

        public int getCallCapabilities() {
            return this.mCallCapabilities;
        }

        public int getCallProperties() {
            return this.mCallProperties;
        }

        public int getCallSubstate() {
            return this.mCallSubstate;
        }

        public String getCallerDisplayName() {
            return this.mCallerDisplayName;
        }

        public int getCallerDisplayNamePresentation() {
            return this.mCallerDisplayNamePresentation;
        }

        public long getConnectTimeMillis() {
            return this.mConnectTimeMillis;
        }

        public long getCreateTimeMillis() {
            return this.mCreateTimeMillis;
        }

        public DisconnectCause getDisconnectCause() {
            return this.mDisconnectCause;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public GatewayInfo getGatewayInfo() {
            return this.mGatewayInfo;
        }

        public Uri getHandle() {
            return this.mHandle;
        }

        public int getHandlePresentation() {
            return this.mHandlePresentation;
        }

        public StatusHints getStatusHints() {
            return this.mStatusHints;
        }

        public int getVideoState() {
            return this.mVideoState;
        }

        public int hashCode() {
            return Objects.hashCode(this.mHandle) + Objects.hashCode(Integer.valueOf(this.mHandlePresentation)) + Objects.hashCode(this.mCallerDisplayName) + Objects.hashCode(Integer.valueOf(this.mCallerDisplayNamePresentation)) + Objects.hashCode(this.mAccountHandle) + Objects.hashCode(Integer.valueOf(this.mCallCapabilities)) + Objects.hashCode(Integer.valueOf(this.mCallProperties)) + Objects.hashCode(this.mDisconnectCause) + Objects.hashCode(Long.valueOf(this.mCreateTimeMillis)) + Objects.hashCode(Long.valueOf(this.mConnectTimeMillis)) + Objects.hashCode(this.mGatewayInfo) + Objects.hashCode(Integer.valueOf(this.mVideoState)) + Objects.hashCode(this.mStatusHints) + Objects.hashCode(this.mExtras) + Objects.hashCode(Integer.valueOf(this.mCallSubstate));
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/telecom/Call$Listener.class */
    public static abstract class Listener {
        public void onCallDestroyed(Call call) {
        }

        public void onCannedTextResponsesLoaded(Call call, List<String> list) {
        }

        public void onChildrenChanged(Call call, List<Call> list) {
        }

        public void onConferenceableCallsChanged(Call call, List<Call> list) {
        }

        public void onDetailsChanged(Call call, Details details) {
        }

        public void onParentChanged(Call call, Call call2) {
        }

        public void onPostDialWait(Call call, String str) {
        }

        public void onStateChanged(Call call, int i) {
        }

        public void onVideoCallChanged(Call call, InCallService.VideoCall videoCall) {
        }
    }

    Call(Phone phone, String str, InCallAdapter inCallAdapter, boolean z) {
        this.mChildrenIds = new ArrayList();
        this.mChildren = new ArrayList();
        this.mUnmodifiableChildren = Collections.unmodifiableList(this.mChildren);
        this.mListeners = new CopyOnWriteArrayList();
        this.mConferenceableCalls = new ArrayList();
        this.mUnmodifiableConferenceableCalls = Collections.unmodifiableList(this.mConferenceableCalls);
        this.mParentId = null;
        this.mCannedTextResponses = null;
        this.mIsActiveSub = false;
        this.mPhone = phone;
        this.mTelecomCallId = str;
        this.mInCallAdapter = inCallAdapter;
        this.mState = 0;
        this.mIsActiveSub = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Call(Phone phone, String str, InCallAdapter inCallAdapter, boolean z, int i) {
        this.mChildrenIds = new ArrayList();
        this.mChildren = new ArrayList();
        this.mUnmodifiableChildren = Collections.unmodifiableList(this.mChildren);
        this.mListeners = new CopyOnWriteArrayList();
        this.mConferenceableCalls = new ArrayList();
        this.mUnmodifiableConferenceableCalls = Collections.unmodifiableList(this.mConferenceableCalls);
        this.mParentId = null;
        this.mCannedTextResponses = null;
        this.mIsActiveSub = false;
        this.mPhone = phone;
        this.mTelecomCallId = str;
        this.mInCallAdapter = inCallAdapter;
        this.mState = i;
        this.mIsActiveSub = z;
    }

    private void fireCallDestroyed() {
        for (Listener listener : this.mListeners) {
            listener.onCallDestroyed(this);
        }
    }

    private void fireCannedTextResponsesLoaded(List<String> list) {
        for (Listener listener : this.mListeners) {
            listener.onCannedTextResponsesLoaded(this, list);
        }
    }

    private void fireChildrenChanged(List<Call> list) {
        for (Listener listener : this.mListeners) {
            listener.onChildrenChanged(this, list);
        }
    }

    private void fireConferenceableCallsChanged() {
        for (Listener listener : this.mListeners) {
            listener.onConferenceableCallsChanged(this, this.mUnmodifiableConferenceableCalls);
        }
    }

    private void fireDetailsChanged(Details details) {
        for (Listener listener : this.mListeners) {
            listener.onDetailsChanged(this, details);
        }
    }

    private void fireParentChanged(Call call) {
        for (Listener listener : this.mListeners) {
            listener.onParentChanged(this, call);
        }
    }

    private void firePostDialWait(String str) {
        for (Listener listener : this.mListeners) {
            listener.onPostDialWait(this, str);
        }
    }

    private void fireStateChanged(int i) {
        for (Listener listener : this.mListeners) {
            listener.onStateChanged(this, i);
        }
    }

    private void fireVideoCallChanged(InCallService.VideoCall videoCall) {
        for (Listener listener : this.mListeners) {
            listener.onVideoCallChanged(this, videoCall);
        }
    }

    private int stateFromParcelableCallState(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 9;
            case 2:
                return 8;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
                return 4;
            case 6:
                return 3;
            case 7:
                return 7;
            case 8:
                return 7;
            case 9:
                return 10;
            default:
                Log.wtf(this, "Unrecognized CallState %s", Integer.valueOf(i));
                return 0;
        }
    }

    public void addListener(Listener listener) {
        this.mListeners.add(listener);
    }

    public void answer(int i) {
        this.mInCallAdapter.answerCall(this.mTelecomCallId, i);
    }

    public void conference(Call call) {
        if (call != null) {
            this.mInCallAdapter.conference(this.mTelecomCallId, call.mTelecomCallId);
        }
    }

    public void deflectCall(String str) {
        this.mInCallAdapter.deflectCall(this.mTelecomCallId, str);
    }

    public void disconnect() {
        this.mInCallAdapter.disconnectCall(this.mTelecomCallId);
    }

    public List<String> getCannedTextResponses() {
        return this.mCannedTextResponses;
    }

    public List<Call> getChildren() {
        if (!this.mChildrenCached) {
            this.mChildrenCached = true;
            this.mChildren.clear();
            for (String str : this.mChildrenIds) {
                Call internalGetCallByTelecomId = this.mPhone.internalGetCallByTelecomId(str);
                if (internalGetCallByTelecomId == null) {
                    this.mChildrenCached = false;
                } else {
                    this.mChildren.add(internalGetCallByTelecomId);
                }
            }
        }
        return this.mUnmodifiableChildren;
    }

    public List<Call> getConferenceableCalls() {
        return this.mUnmodifiableConferenceableCalls;
    }

    public Details getDetails() {
        return this.mDetails;
    }

    public Call getParent() {
        if (this.mParentId != null) {
            return this.mPhone.internalGetCallByTelecomId(this.mParentId);
        }
        return null;
    }

    public String getRemainingPostDialSequence() {
        return this.mRemainingPostDialSequence;
    }

    public int getState() {
        return this.mState;
    }

    public InCallService.VideoCall getVideoCall() {
        return this.mVideoCall;
    }

    public void hold() {
        this.mInCallAdapter.holdCall(this.mTelecomCallId);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String internalGetCallId() {
        return this.mTelecomCallId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void internalSetDisconnected() {
        if (this.mState != 7) {
            this.mState = 7;
            fireStateChanged(this.mState);
            fireCallDestroyed();
            this.mPhone.internalRemoveCall(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void internalSetPostDialWait(String str) {
        this.mRemainingPostDialSequence = str;
        firePostDialWait(this.mRemainingPostDialSequence);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void internalUpdate(ParcelableCall parcelableCall, Map<String, Call> map) {
        Details details = new Details(parcelableCall.getHandle(), parcelableCall.getHandlePresentation(), parcelableCall.getCallerDisplayName(), parcelableCall.getCallerDisplayNamePresentation(), parcelableCall.getAccountHandle(), parcelableCall.getCapabilities(), parcelableCall.getProperties(), parcelableCall.getDisconnectCause(), parcelableCall.getCreateTimeMillis(), parcelableCall.getConnectTimeMillis(), parcelableCall.getGatewayInfo(), parcelableCall.getVideoState(), parcelableCall.getStatusHints(), parcelableCall.getExtras(), parcelableCall.getCallSubstate());
        boolean z = !Objects.equals(this.mDetails, details);
        if (z) {
            this.mDetails = details;
        }
        if (this.mCannedTextResponses == null && parcelableCall.getCannedSmsResponses() != null && !parcelableCall.getCannedSmsResponses().isEmpty()) {
            this.mCannedTextResponses = Collections.unmodifiableList(parcelableCall.getCannedSmsResponses());
        }
        boolean z2 = !Objects.equals(this.mVideoCall, parcelableCall.getVideoCall());
        if (z2) {
            this.mVideoCall = parcelableCall.getVideoCall();
        }
        int stateFromParcelableCallState = stateFromParcelableCallState(parcelableCall.getState());
        boolean z3 = (this.mState == stateFromParcelableCallState && this.mIsActiveSub == parcelableCall.mIsActiveSub) ? false : true;
        if (z3) {
            this.mState = stateFromParcelableCallState;
            this.mIsActiveSub = parcelableCall.mIsActiveSub;
        }
        String parentCallId = parcelableCall.getParentCallId();
        boolean z4 = !Objects.equals(this.mParentId, parentCallId);
        if (z4) {
            this.mParentId = parentCallId;
        }
        boolean z5 = !Objects.equals(parcelableCall.getChildCallIds(), this.mChildrenIds);
        if (z5) {
            this.mChildrenIds.clear();
            this.mChildrenIds.addAll(parcelableCall.getChildCallIds());
            this.mChildrenCached = false;
        }
        List<String> conferenceableCallIds = parcelableCall.getConferenceableCallIds();
        ArrayList arrayList = new ArrayList(conferenceableCallIds.size());
        for (String str : conferenceableCallIds) {
            if (map.containsKey(str)) {
                arrayList.add(map.get(str));
            }
        }
        if (!Objects.equals(this.mConferenceableCalls, arrayList)) {
            this.mConferenceableCalls.clear();
            this.mConferenceableCalls.addAll(arrayList);
            fireConferenceableCallsChanged();
        }
        if (z3) {
            fireStateChanged(this.mState);
        }
        if (z) {
            fireDetailsChanged(this.mDetails);
        }
        if (0 != 0) {
            fireCannedTextResponsesLoaded(this.mCannedTextResponses);
        }
        if (z2) {
            fireVideoCallChanged(this.mVideoCall);
        }
        if (z4) {
            fireParentChanged(getParent());
        }
        if (z5) {
            fireChildrenChanged(getChildren());
        }
        if (this.mState == 7) {
            fireCallDestroyed();
            this.mPhone.internalRemoveCall(this);
        }
    }

    public void mergeConference() {
        this.mInCallAdapter.mergeConference(this.mTelecomCallId);
    }

    public void phoneAccountSelected(PhoneAccountHandle phoneAccountHandle, boolean z) {
        this.mInCallAdapter.phoneAccountSelected(this.mTelecomCallId, phoneAccountHandle, z);
    }

    public void playDtmfTone(char c2) {
        this.mInCallAdapter.playDtmfTone(this.mTelecomCallId, c2);
    }

    public void postDialContinue(boolean z) {
        this.mInCallAdapter.postDialContinue(this.mTelecomCallId, z);
    }

    public void reject(boolean z, String str) {
        this.mInCallAdapter.rejectCall(this.mTelecomCallId, z, str);
    }

    public void removeListener(Listener listener) {
        if (listener != null) {
            this.mListeners.remove(listener);
        }
    }

    public void splitFromConference() {
        this.mInCallAdapter.splitFromConference(this.mTelecomCallId);
    }

    public void stopDtmfTone() {
        this.mInCallAdapter.stopDtmfTone(this.mTelecomCallId);
    }

    public void swapConference() {
        this.mInCallAdapter.swapConference(this.mTelecomCallId);
    }

    public void unhold() {
        this.mInCallAdapter.unholdCall(this.mTelecomCallId);
    }
}
