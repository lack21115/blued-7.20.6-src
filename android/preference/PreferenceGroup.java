package android.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.preference.GenericInflater;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.android.internal.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/preference/PreferenceGroup.class */
public abstract class PreferenceGroup extends Preference implements GenericInflater.Parent<Preference> {
    private boolean mAttachedToActivity;
    private int mCurrentPreferenceOrder;
    private boolean mOrderingAsAdded;
    private List<Preference> mPreferenceList;

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mOrderingAsAdded = true;
        this.mCurrentPreferenceOrder = 0;
        this.mAttachedToActivity = false;
        this.mPreferenceList = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PreferenceGroup, i, i2);
        this.mOrderingAsAdded = obtainStyledAttributes.getBoolean(0, this.mOrderingAsAdded);
        obtainStyledAttributes.recycle();
    }

    private boolean removePreferenceInt(Preference preference) {
        boolean remove;
        synchronized (this) {
            preference.onPrepareForRemoval();
            remove = this.mPreferenceList.remove(preference);
        }
        return remove;
    }

    @Override // android.preference.GenericInflater.Parent
    public void addItemFromInflater(Preference preference) {
        addPreference(preference);
    }

    public boolean addPreference(Preference preference) {
        if (this.mPreferenceList.contains(preference)) {
            return true;
        }
        if (preference.getOrder() == Integer.MAX_VALUE) {
            if (this.mOrderingAsAdded) {
                int i = this.mCurrentPreferenceOrder;
                this.mCurrentPreferenceOrder = i + 1;
                preference.setOrder(i);
            }
            if (preference instanceof PreferenceGroup) {
                ((PreferenceGroup) preference).setOrderingAsAdded(this.mOrderingAsAdded);
            }
        }
        int binarySearch = Collections.binarySearch(this.mPreferenceList, preference);
        int i2 = binarySearch;
        if (binarySearch < 0) {
            i2 = (binarySearch * (-1)) - 1;
        }
        if (onPrepareAddPreference(preference)) {
            synchronized (this) {
                this.mPreferenceList.add(i2, preference);
            }
            preference.onAttachedToHierarchy(getPreferenceManager());
            if (this.mAttachedToActivity) {
                preference.onAttachedToActivity();
            }
            notifyHierarchyChanged();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.preference.Preference
    public void dispatchRestoreInstanceState(Bundle bundle) {
        super.dispatchRestoreInstanceState(bundle);
        int preferenceCount = getPreferenceCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= preferenceCount) {
                return;
            }
            getPreference(i2).dispatchRestoreInstanceState(bundle);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.preference.Preference
    public void dispatchSaveInstanceState(Bundle bundle) {
        super.dispatchSaveInstanceState(bundle);
        int preferenceCount = getPreferenceCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= preferenceCount) {
                return;
            }
            getPreference(i2).dispatchSaveInstanceState(bundle);
            i = i2 + 1;
        }
    }

    public Preference findPreference(CharSequence charSequence) {
        Preference findPreference;
        if (TextUtils.equals(getKey(), charSequence)) {
            return this;
        }
        int preferenceCount = getPreferenceCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= preferenceCount) {
                return null;
            }
            Preference preference = getPreference(i2);
            String key = preference.getKey();
            if (key != null && key.equals(charSequence)) {
                return preference;
            }
            if ((preference instanceof PreferenceGroup) && (findPreference = ((PreferenceGroup) preference).findPreference(charSequence)) != null) {
                return findPreference;
            }
            i = i2 + 1;
        }
    }

    public Preference getPreference(int i) {
        return this.mPreferenceList.get(i);
    }

    public int getPreferenceCount() {
        return this.mPreferenceList.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isOnSameScreenAsChildren() {
        return true;
    }

    public boolean isOrderingAsAdded() {
        return this.mOrderingAsAdded;
    }

    @Override // android.preference.Preference
    public void notifyDependencyChange(boolean z) {
        super.notifyDependencyChange(z);
        int preferenceCount = getPreferenceCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= preferenceCount) {
                return;
            }
            getPreference(i2).onParentChanged(this, z);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.preference.Preference
    public void onAttachedToActivity() {
        super.onAttachedToActivity();
        this.mAttachedToActivity = true;
        int preferenceCount = getPreferenceCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= preferenceCount) {
                return;
            }
            getPreference(i2).onAttachedToActivity();
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onPrepareAddPreference(Preference preference) {
        preference.onParentChanged(this, shouldDisableDependents());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.preference.Preference
    public void onPrepareForRemoval() {
        super.onPrepareForRemoval();
        this.mAttachedToActivity = false;
    }

    public void removeAll() {
        synchronized (this) {
            List<Preference> list = this.mPreferenceList;
            int size = list.size();
            while (true) {
                int i = size - 1;
                if (i >= 0) {
                    removePreferenceInt(list.get(0));
                    size = i;
                }
            }
        }
        notifyHierarchyChanged();
    }

    public boolean removePreference(Preference preference) {
        boolean removePreferenceInt = removePreferenceInt(preference);
        notifyHierarchyChanged();
        return removePreferenceInt;
    }

    public void setOrderingAsAdded(boolean z) {
        this.mOrderingAsAdded = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sortPreferences() {
        synchronized (this) {
            Collections.sort(this.mPreferenceList);
        }
    }
}
