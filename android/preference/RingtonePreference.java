package android.preference;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.media.RingtoneManager;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.android.internal.R;

/* loaded from: source-9557208-dex2jar.jar:android/preference/RingtonePreference.class */
public class RingtonePreference extends Preference implements PreferenceManager.OnActivityResultListener {
    private static final String TAG = "RingtonePreference";
    private int mDialogStyle;
    private int mRequestCode;
    private int mRingtoneType;
    private boolean mShowDefault;
    private boolean mShowSilent;
    private int mSubscriptionID;

    public RingtonePreference(Context context) {
        this(context, null);
    }

    public RingtonePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842899);
    }

    public RingtonePreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public RingtonePreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mSubscriptionID = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RingtonePreference, i, i2);
        this.mRingtoneType = obtainStyledAttributes.getInt(0, 1);
        this.mShowDefault = obtainStyledAttributes.getBoolean(1, true);
        this.mShowSilent = obtainStyledAttributes.getBoolean(2, true);
        this.mDialogStyle = obtainStyledAttributes.getResourceId(3, 0);
        obtainStyledAttributes.recycle();
    }

    public int getDialogStyle() {
        return this.mDialogStyle;
    }

    public int getRingtoneType() {
        return this.mRingtoneType;
    }

    public boolean getShowDefault() {
        return this.mShowDefault;
    }

    public boolean getShowSilent() {
        return this.mShowSilent;
    }

    public int getSubId() {
        return this.mSubscriptionID;
    }

    @Override // android.preference.PreferenceManager.OnActivityResultListener
    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (i == this.mRequestCode) {
            if (intent != null) {
                Uri uri = (Uri) intent.getParcelableExtra(RingtoneManager.EXTRA_RINGTONE_PICKED_URI);
                if (callChangeListener(uri != null ? uri.toString() : "")) {
                    onSaveRingtone(uri);
                    return true;
                }
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.preference.Preference
    public void onAttachedToHierarchy(PreferenceManager preferenceManager) {
        super.onAttachedToHierarchy(preferenceManager);
        preferenceManager.registerOnActivityResultListener(this);
        this.mRequestCode = preferenceManager.getNextRequestCode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.preference.Preference
    public void onClick() {
        Intent intent = new Intent(RingtoneManager.ACTION_RINGTONE_PICKER);
        onPrepareRingtonePickerIntent(intent);
        PreferenceFragment fragment = getPreferenceManager().getFragment();
        if (fragment != null) {
            fragment.startActivityForResult(intent, this.mRequestCode);
        } else {
            getPreferenceManager().getActivity().startActivityForResult(intent, this.mRequestCode);
        }
    }

    @Override // android.preference.Preference
    protected Object onGetDefaultValue(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    protected void onPrepareRingtonePickerIntent(Intent intent) {
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_EXISTING_URI, onRestoreRingtone());
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_SHOW_DEFAULT, this.mShowDefault);
        if (this.mShowDefault) {
            if (getRingtoneType() == 1) {
                intent.putExtra(RingtoneManager.EXTRA_RINGTONE_DEFAULT_URI, RingtoneManager.getDefaultRingtoneUriBySubId(getSubId()));
            } else {
                intent.putExtra(RingtoneManager.EXTRA_RINGTONE_DEFAULT_URI, RingtoneManager.getDefaultUri(getRingtoneType()));
            }
        }
        if (this.mDialogStyle != 0) {
            intent.putExtra(RingtoneManager.EXTRA_RINGTONE_DIALOG_THEME, this.mDialogStyle);
        }
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_SHOW_SILENT, this.mShowSilent);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE, this.mRingtoneType);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TITLE, getTitle());
    }

    protected Uri onRestoreRingtone() {
        Uri uri = null;
        String persistedString = getPersistedString(null);
        if (!TextUtils.isEmpty(persistedString)) {
            uri = Uri.parse(persistedString);
        }
        return uri;
    }

    protected void onSaveRingtone(Uri uri) {
        persistString(uri != null ? uri.toString() : "");
    }

    @Override // android.preference.Preference
    protected void onSetInitialValue(boolean z, Object obj) {
        String str = (String) obj;
        if (z || TextUtils.isEmpty(str)) {
            return;
        }
        onSaveRingtone(Uri.parse(str));
    }

    public void setDialogStyle(int i) {
        this.mDialogStyle = i;
    }

    public void setRingtoneType(int i) {
        this.mRingtoneType = i;
    }

    public void setShowDefault(boolean z) {
        this.mShowDefault = z;
    }

    public void setShowSilent(boolean z) {
        this.mShowSilent = z;
    }

    public void setSubId(int i) {
        this.mSubscriptionID = i;
    }
}
