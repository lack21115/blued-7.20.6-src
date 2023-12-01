package com.android.internal.app;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.Slog;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/app/ChooserActivity.class */
public class ChooserActivity extends ResolverActivity {
    private static final String TAG = "ChooserActivity";
    private IntentSender mChosenComponentSender;
    private Bundle mReplacementExtras;

    private void modifyTargetIntent(Intent intent) {
        String action = intent.getAction();
        if (Intent.ACTION_SEND.equals(action) || Intent.ACTION_SEND_MULTIPLE.equals(action)) {
            intent.addFlags(134742016);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x004b, code lost:
        if (r5.name.equals(com.android.internal.app.IntentForwarderActivity.FORWARD_INTENT_TO_MANAGED_PROFILE) != false) goto L13;
     */
    @Override // com.android.internal.app.ResolverActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.content.Intent getReplacementIntent(android.content.pm.ActivityInfo r5, android.content.Intent r6) {
        /*
            r4 = this;
            r0 = r6
            r8 = r0
            r0 = r8
            r7 = r0
            r0 = r4
            android.os.Bundle r0 = r0.mReplacementExtras
            if (r0 == 0) goto L32
            r0 = r4
            android.os.Bundle r0 = r0.mReplacementExtras
            r1 = r5
            java.lang.String r1 = r1.packageName
            android.os.Bundle r0 = r0.getBundle(r1)
            r9 = r0
            r0 = r8
            r7 = r0
            r0 = r9
            if (r0 == 0) goto L32
            android.content.Intent r0 = new android.content.Intent
            r1 = r0
            r2 = r6
            r1.<init>(r2)
            r7 = r0
            r0 = r7
            r1 = r9
            android.content.Intent r0 = r0.putExtras(r1)
        L32:
            r0 = r5
            java.lang.String r0 = r0.name
            java.lang.String r1 = com.android.internal.app.IntentForwarderActivity.FORWARD_INTENT_TO_USER_OWNER
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L4e
            r0 = r7
            r6 = r0
            r0 = r5
            java.lang.String r0 = r0.name
            java.lang.String r1 = com.android.internal.app.IntentForwarderActivity.FORWARD_INTENT_TO_MANAGED_PROFILE
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L5c
        L4e:
            r0 = r7
            r1 = r4
            android.content.Intent r1 = r1.getIntent()
            java.lang.String r2 = "android.intent.extra.TITLE"
            java.lang.CharSequence r1 = r1.getCharSequenceExtra(r2)
            android.content.Intent r0 = android.content.Intent.createChooser(r0, r1)
            r6 = r0
        L5c:
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.app.ChooserActivity.getReplacementIntent(android.content.pm.ActivityInfo, android.content.Intent):android.content.Intent");
    }

    @Override // com.android.internal.app.ResolverActivity
    public void onActivityStarted(Intent intent) {
        ComponentName component;
        if (this.mChosenComponentSender == null || (component = intent.getComponent()) == null) {
            return;
        }
        try {
            this.mChosenComponentSender.sendIntent(this, -1, new Intent().putExtra(Intent.EXTRA_CHOSEN_COMPONENT, component), null, null);
        } catch (IntentSender.SendIntentException e) {
            Slog.e(TAG, "Unable to launch supplied IntentSender to report the chosen component: " + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.internal.app.ResolverActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        Parcelable parcelableExtra = intent.getParcelableExtra(Intent.EXTRA_INTENT);
        if (!(parcelableExtra instanceof Intent)) {
            Log.w(TAG, "Target is not an intent: " + parcelableExtra);
            finish();
            super.onCreate(null);
            return;
        }
        Intent intent2 = (Intent) parcelableExtra;
        if (intent2 != null) {
            modifyTargetIntent(intent2);
        }
        this.mReplacementExtras = intent.getBundleExtra(Intent.EXTRA_REPLACEMENT_EXTRAS);
        CharSequence charSequenceExtra = intent.getCharSequenceExtra(Intent.EXTRA_TITLE);
        int i = 0;
        if (charSequenceExtra == null) {
            i = 17040727;
        }
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra(Intent.EXTRA_INITIAL_INTENTS);
        Intent[] intentArr = null;
        if (parcelableArrayExtra != null) {
            Intent[] intentArr2 = new Intent[parcelableArrayExtra.length];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                intentArr = intentArr2;
                if (i3 >= parcelableArrayExtra.length) {
                    break;
                } else if (!(parcelableArrayExtra[i3] instanceof Intent)) {
                    Log.w(TAG, "Initial intent #" + i3 + " not an Intent: " + parcelableArrayExtra[i3]);
                    finish();
                    super.onCreate(null);
                    return;
                } else {
                    Intent intent3 = (Intent) parcelableArrayExtra[i3];
                    modifyTargetIntent(intent3);
                    intentArr2[i3] = intent3;
                    i2 = i3 + 1;
                }
            }
        }
        this.mChosenComponentSender = (IntentSender) intent.getParcelableExtra(Intent.EXTRA_CHOSEN_COMPONENT_INTENT_SENDER);
        setSafeForwardingMode(true);
        super.onCreate(bundle, intent2, charSequenceExtra, i, intentArr, null, false);
    }
}
