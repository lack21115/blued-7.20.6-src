package android.media;

import android.media.MediaFocusControl;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/media/FocusRequester.class */
public class FocusRequester {
    private static final boolean DEBUG = false;
    private static final String TAG = "MediaFocusControl";
    private final AudioAttributes mAttributes;
    private final int mCallingUid;
    private final String mClientId;
    private MediaFocusControl.AudioFocusDeathHandler mDeathHandler;
    private final MediaFocusControl mFocusController;
    private final IAudioFocusDispatcher mFocusDispatcher;
    private final int mFocusGainRequest;
    private int mFocusLossReceived = 0;
    private final int mGrantFlags;
    private final String mPackageName;
    private final IBinder mSourceRef;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FocusRequester(AudioAttributes audioAttributes, int i, int i2, IAudioFocusDispatcher iAudioFocusDispatcher, IBinder iBinder, String str, MediaFocusControl.AudioFocusDeathHandler audioFocusDeathHandler, String str2, int i3, MediaFocusControl mediaFocusControl) {
        this.mAttributes = audioAttributes;
        this.mFocusDispatcher = iAudioFocusDispatcher;
        this.mSourceRef = iBinder;
        this.mClientId = str;
        this.mDeathHandler = audioFocusDeathHandler;
        this.mPackageName = str2;
        this.mCallingUid = i3;
        this.mFocusGainRequest = i;
        this.mGrantFlags = i2;
        this.mFocusController = mediaFocusControl;
    }

    private static String flagsToString(int i) {
        String str = new String();
        String str2 = str;
        if ((i & 1) != 0) {
            str2 = str + "DELAY_OK";
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            String str4 = str2;
            if (!str2.isEmpty()) {
                str4 = str2 + "|";
            }
            str3 = str4 + "LOCK";
        }
        String str5 = str3;
        if ((i & 2) != 0) {
            String str6 = str3;
            if (!str3.isEmpty()) {
                str6 = str3 + "|";
            }
            str5 = str6 + "PAUSES_ON_DUCKABLE_LOSS";
        }
        return str5;
    }

    private static String focusChangeToString(int i) {
        switch (i) {
            case -3:
                return "LOSS_TRANSIENT_CAN_DUCK";
            case -2:
                return "LOSS_TRANSIENT";
            case -1:
                return "LOSS";
            case 0:
                return "none";
            case 1:
                return "GAIN";
            case 2:
                return "GAIN_TRANSIENT";
            case 3:
                return "GAIN_TRANSIENT_MAY_DUCK";
            case 4:
                return "GAIN_TRANSIENT_EXCLUSIVE";
            default:
                return "[invalid focus change" + i + "]";
        }
    }

    private String focusGainToString() {
        return focusChangeToString(this.mFocusGainRequest);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:817)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARN: Removed duplicated region for block: B:5:0x003b A[PHI: r6 
      PHI: (r6v3 int) = (r6v0 int), (r6v1 int), (r6v2 int), (r6v4 int) binds: [B:12:0x008a, B:10:0x0066, B:8:0x0043, B:4:0x0020] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int focusLossForGainRequest(int r5) {
        /*
            r4 = this;
            r0 = -1
            r7 = r0
            r0 = r5
            switch(r0) {
                case 1: goto L3d;
                case 2: goto L60;
                case 3: goto L84;
                case 4: goto L60;
                default: goto L20;
            }
        L20:
            java.lang.String r0 = "MediaFocusControl"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = r1
            r2.<init>()
            java.lang.String r2 = "focusLossForGainRequest() for invalid focus request "
            java.lang.StringBuilder r1 = r1.append(r2)
            r2 = r5
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            int r0 = android.util.Log.e(r0, r1)
            r0 = 0
            r6 = r0
        L3b:
            r0 = r6
            return r0
        L3d:
            r0 = r7
            r6 = r0
            r0 = r4
            int r0 = r0.mFocusLossReceived
            switch(r0) {
                case -3: goto L3b;
                case -2: goto L3b;
                case -1: goto L3b;
                case 0: goto L3b;
                default: goto L60;
            }
        L60:
            r0 = r7
            r6 = r0
            r0 = r4
            int r0 = r0.mFocusLossReceived
            switch(r0) {
                case -3: goto Lae;
                case -2: goto Lae;
                case -1: goto L3b;
                case 0: goto Lae;
                default: goto L84;
            }
        L84:
            r0 = r7
            r6 = r0
            r0 = r4
            int r0 = r0.mFocusLossReceived
            switch(r0) {
                case -3: goto Lab;
                case -2: goto Lb1;
                case -1: goto L3b;
                case 0: goto Lab;
                default: goto La8;
            }
        La8:
            goto L20
        Lab:
            r0 = -3
            return r0
        Lae:
            r0 = -2
            return r0
        Lb1:
            r0 = -2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.media.FocusRequester.focusLossForGainRequest(int):int");
    }

    private String focusLossToString() {
        return focusChangeToString(this.mFocusLossReceived);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dump(PrintWriter printWriter) {
        printWriter.println("  source:" + this.mSourceRef + " -- pack: " + this.mPackageName + " -- client: " + this.mClientId + " -- gain: " + focusGainToString() + " -- flags: " + flagsToString(this.mGrantFlags) + " -- loss: " + focusLossToString() + " -- uid: " + this.mCallingUid + " -- attr: " + this.mAttributes);
    }

    protected void finalize() throws Throwable {
        release();
        super.finalize();
    }

    AudioAttributes getAudioAttributes() {
        return this.mAttributes;
    }

    String getClientId() {
        return this.mClientId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getGainRequest() {
        return this.mFocusGainRequest;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getGrantFlags() {
        return this.mGrantFlags;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleExternalFocusGain(int i) {
        handleFocusLoss(focusLossForGainRequest(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleFocusGain(int i) {
        try {
            this.mFocusLossReceived = 0;
            this.mFocusController.notifyExtPolicyFocusGrant_syncAf(toAudioFocusInfo(), 1);
            if (this.mFocusDispatcher != null) {
                this.mFocusDispatcher.dispatchAudioFocusChange(i, this.mClientId);
            }
        } catch (RemoteException e) {
            Log.e(TAG, "Failure to signal gain of audio focus due to: ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleFocusLoss(int i) {
        try {
            if (i != this.mFocusLossReceived) {
                this.mFocusLossReceived = i;
                if (!this.mFocusController.mustNotifyFocusOwnerOnDuck() && this.mFocusLossReceived == -3 && (this.mGrantFlags & 2) == 0) {
                    this.mFocusController.notifyExtPolicyFocusLoss_syncAf(toAudioFocusInfo(), false);
                } else if (this.mFocusDispatcher != null) {
                    this.mFocusController.notifyExtPolicyFocusLoss_syncAf(toAudioFocusInfo(), true);
                    this.mFocusDispatcher.dispatchAudioFocusChange(this.mFocusLossReceived, this.mClientId);
                }
            }
        } catch (RemoteException e) {
            Log.e(TAG, "Failure to signal loss of audio focus due to:", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasSameBinder(IBinder iBinder) {
        return this.mSourceRef != null && this.mSourceRef.equals(iBinder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasSameClient(String str) {
        boolean z = false;
        try {
            if (this.mClientId.compareTo(str) == 0) {
                z = true;
            }
            return z;
        } catch (NullPointerException e) {
            return false;
        }
    }

    boolean hasSamePackage(String str) {
        boolean z = false;
        try {
            if (this.mPackageName.compareTo(str) == 0) {
                z = true;
            }
            return z;
        } catch (NullPointerException e) {
            return false;
        }
    }

    boolean hasSameUid(int i) {
        return this.mCallingUid == i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isLockedFocusOwner() {
        return (this.mGrantFlags & 4) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        try {
            if (this.mSourceRef == null || this.mDeathHandler == null) {
                return;
            }
            this.mSourceRef.unlinkToDeath(this.mDeathHandler, 0);
            this.mDeathHandler = null;
        } catch (NoSuchElementException e) {
            Log.e(TAG, "FocusRequester.release() hit ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioFocusInfo toAudioFocusInfo() {
        return new AudioFocusInfo(this.mAttributes, this.mClientId, this.mPackageName, this.mFocusGainRequest, this.mFocusLossReceived, this.mGrantFlags);
    }
}
