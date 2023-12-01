package com.android.internal.inputmethod;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodSubtype;
import com.alipay.sdk.util.i;
import com.android.internal.inputmethod.InputMethodUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.TreeMap;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/inputmethod/InputMethodSubtypeSwitchingController.class */
public class InputMethodSubtypeSwitchingController {
    private static final boolean DEBUG = false;
    private static final int NOT_A_SUBTYPE_ID = -1;
    private static final String TAG = InputMethodSubtypeSwitchingController.class.getSimpleName();
    private ControllerImpl mController;
    private final InputMethodUtils.InputMethodSettings mSettings;
    private InputMethodAndSubtypeList mSubtypeList;

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/inputmethod/InputMethodSubtypeSwitchingController$ControllerImpl.class */
    public static class ControllerImpl {
        private final DynamicRotationList mSwitchingAwareRotationList;
        private final StaticRotationList mSwitchingUnawareRotationList;

        private ControllerImpl(DynamicRotationList dynamicRotationList, StaticRotationList staticRotationList) {
            this.mSwitchingAwareRotationList = dynamicRotationList;
            this.mSwitchingUnawareRotationList = staticRotationList;
        }

        public static ControllerImpl createFrom(ControllerImpl controllerImpl, List<ImeSubtypeListItem> list) {
            List<ImeSubtypeListItem> filterImeSubtypeList = filterImeSubtypeList(list, true);
            DynamicRotationList dynamicRotationList = null;
            if (controllerImpl != null) {
                dynamicRotationList = null;
                if (controllerImpl.mSwitchingAwareRotationList != null) {
                    dynamicRotationList = null;
                    if (Objects.equals(controllerImpl.mSwitchingAwareRotationList.mImeSubtypeList, filterImeSubtypeList)) {
                        dynamicRotationList = controllerImpl.mSwitchingAwareRotationList;
                    }
                }
            }
            DynamicRotationList dynamicRotationList2 = dynamicRotationList;
            if (dynamicRotationList == null) {
                dynamicRotationList2 = new DynamicRotationList(filterImeSubtypeList);
            }
            List<ImeSubtypeListItem> filterImeSubtypeList2 = filterImeSubtypeList(list, false);
            StaticRotationList staticRotationList = null;
            if (controllerImpl != null) {
                staticRotationList = null;
                if (controllerImpl.mSwitchingUnawareRotationList != null) {
                    staticRotationList = null;
                    if (Objects.equals(controllerImpl.mSwitchingUnawareRotationList.mImeSubtypeList, filterImeSubtypeList2)) {
                        staticRotationList = controllerImpl.mSwitchingUnawareRotationList;
                    }
                }
            }
            StaticRotationList staticRotationList2 = staticRotationList;
            if (staticRotationList == null) {
                staticRotationList2 = new StaticRotationList(filterImeSubtypeList2);
            }
            return new ControllerImpl(dynamicRotationList2, staticRotationList2);
        }

        private static List<ImeSubtypeListItem> filterImeSubtypeList(List<ImeSubtypeListItem> list, boolean z) {
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return arrayList;
                }
                ImeSubtypeListItem imeSubtypeListItem = list.get(i2);
                if (imeSubtypeListItem.mImi.supportsSwitchingToNextInputMethod() == z) {
                    arrayList.add(imeSubtypeListItem);
                }
                i = i2 + 1;
            }
        }

        public ImeSubtypeListItem getNextInputMethod(boolean z, InputMethodInfo inputMethodInfo, InputMethodSubtype inputMethodSubtype) {
            if (inputMethodInfo == null) {
                return null;
            }
            return inputMethodInfo.supportsSwitchingToNextInputMethod() ? this.mSwitchingAwareRotationList.getNextInputMethodLocked(z, inputMethodInfo, inputMethodSubtype) : this.mSwitchingUnawareRotationList.getNextInputMethodLocked(z, inputMethodInfo, inputMethodSubtype);
        }

        public void onUserActionLocked(InputMethodInfo inputMethodInfo, InputMethodSubtype inputMethodSubtype) {
            if (inputMethodInfo != null && inputMethodInfo.supportsSwitchingToNextInputMethod()) {
                this.mSwitchingAwareRotationList.onUserAction(inputMethodInfo, inputMethodSubtype);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/inputmethod/InputMethodSubtypeSwitchingController$DynamicRotationList.class */
    public static class DynamicRotationList {
        private static final String TAG = DynamicRotationList.class.getSimpleName();
        private final List<ImeSubtypeListItem> mImeSubtypeList;
        private final int[] mUsageHistoryOfSubtypeListItemIndex;

        private DynamicRotationList(List<ImeSubtypeListItem> list) {
            this.mImeSubtypeList = list;
            this.mUsageHistoryOfSubtypeListItemIndex = new int[this.mImeSubtypeList.size()];
            int size = this.mImeSubtypeList.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                this.mUsageHistoryOfSubtypeListItemIndex[i2] = i2;
                i = i2 + 1;
            }
        }

        private int getUsageRank(InputMethodInfo inputMethodInfo, InputMethodSubtype inputMethodSubtype) {
            int calculateSubtypeId = InputMethodSubtypeSwitchingController.calculateSubtypeId(inputMethodInfo, inputMethodSubtype);
            int length = this.mUsageHistoryOfSubtypeListItemIndex.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return -1;
                }
                ImeSubtypeListItem imeSubtypeListItem = this.mImeSubtypeList.get(this.mUsageHistoryOfSubtypeListItemIndex[i2]);
                if (imeSubtypeListItem.mImi.equals(inputMethodInfo) && imeSubtypeListItem.mSubtypeId == calculateSubtypeId) {
                    return i2;
                }
                i = i2 + 1;
            }
        }

        public ImeSubtypeListItem getNextInputMethodLocked(boolean z, InputMethodInfo inputMethodInfo, InputMethodSubtype inputMethodSubtype) {
            ImeSubtypeListItem imeSubtypeListItem;
            int usageRank = getUsageRank(inputMethodInfo, inputMethodSubtype);
            if (usageRank < 0) {
                imeSubtypeListItem = null;
            } else {
                int length = this.mUsageHistoryOfSubtypeListItemIndex.length;
                int i = 1;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        return null;
                    }
                    ImeSubtypeListItem imeSubtypeListItem2 = this.mImeSubtypeList.get(this.mUsageHistoryOfSubtypeListItemIndex[(usageRank + i2) % length]);
                    imeSubtypeListItem = imeSubtypeListItem2;
                    if (!z) {
                        break;
                    }
                    imeSubtypeListItem = imeSubtypeListItem2;
                    if (inputMethodInfo.equals(imeSubtypeListItem2.mImi)) {
                        break;
                    }
                    i = i2 + 1;
                }
            }
            return imeSubtypeListItem;
        }

        public void onUserAction(InputMethodInfo inputMethodInfo, InputMethodSubtype inputMethodSubtype) {
            int usageRank = getUsageRank(inputMethodInfo, inputMethodSubtype);
            if (usageRank <= 0) {
                return;
            }
            int i = this.mUsageHistoryOfSubtypeListItemIndex[usageRank];
            System.arraycopy(this.mUsageHistoryOfSubtypeListItemIndex, 0, this.mUsageHistoryOfSubtypeListItemIndex, 1, usageRank);
            this.mUsageHistoryOfSubtypeListItemIndex[0] = i;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/inputmethod/InputMethodSubtypeSwitchingController$ImeSubtypeListItem.class */
    public static class ImeSubtypeListItem implements Comparable<ImeSubtypeListItem> {
        public final CharSequence mImeName;
        public final InputMethodInfo mImi;
        public final boolean mIsSystemLanguage;
        public final boolean mIsSystemLocale;
        public final int mSubtypeId;
        public final CharSequence mSubtypeName;

        public ImeSubtypeListItem(CharSequence charSequence, CharSequence charSequence2, InputMethodInfo inputMethodInfo, int i, String str, String str2) {
            boolean z = true;
            this.mImeName = charSequence;
            this.mSubtypeName = charSequence2;
            this.mImi = inputMethodInfo;
            this.mSubtypeId = i;
            if (TextUtils.isEmpty(str)) {
                this.mIsSystemLocale = false;
                this.mIsSystemLanguage = false;
                return;
            }
            this.mIsSystemLocale = str.equals(str2);
            if (this.mIsSystemLocale) {
                this.mIsSystemLanguage = true;
                return;
            }
            String parseLanguageFromLocaleString = parseLanguageFromLocaleString(str2);
            this.mIsSystemLanguage = (parseLanguageFromLocaleString.length() < 2 || !parseLanguageFromLocaleString.equals(parseLanguageFromLocaleString(str))) ? false : z;
        }

        private static String parseLanguageFromLocaleString(String str) {
            int indexOf = str.indexOf(95);
            return indexOf < 0 ? str : str.substring(0, indexOf);
        }

        @Override // java.lang.Comparable
        public int compareTo(ImeSubtypeListItem imeSubtypeListItem) {
            if (TextUtils.isEmpty(this.mImeName)) {
                return 1;
            }
            if (TextUtils.isEmpty(imeSubtypeListItem.mImeName)) {
                return -1;
            }
            if (TextUtils.equals(this.mImeName, imeSubtypeListItem.mImeName)) {
                if (TextUtils.equals(this.mSubtypeName, imeSubtypeListItem.mSubtypeName)) {
                    return 0;
                }
                if (this.mIsSystemLocale) {
                    return -1;
                }
                if (imeSubtypeListItem.mIsSystemLocale) {
                    return 1;
                }
                if (this.mIsSystemLanguage) {
                    return -1;
                }
                if (imeSubtypeListItem.mIsSystemLanguage || TextUtils.isEmpty(this.mSubtypeName)) {
                    return 1;
                }
                if (TextUtils.isEmpty(imeSubtypeListItem.mSubtypeName)) {
                    return -1;
                }
                return this.mSubtypeName.toString().compareTo(imeSubtypeListItem.mSubtypeName.toString());
            }
            return this.mImeName.toString().compareTo(imeSubtypeListItem.mImeName.toString());
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ImeSubtypeListItem) {
                ImeSubtypeListItem imeSubtypeListItem = (ImeSubtypeListItem) obj;
                return Objects.equals(this.mImi, imeSubtypeListItem.mImi) && this.mSubtypeId == imeSubtypeListItem.mSubtypeId;
            }
            return false;
        }

        public String toString() {
            return "ImeSubtypeListItem{mImeName=" + ((Object) this.mImeName) + " mSubtypeName=" + ((Object) this.mSubtypeName) + " mSubtypeId=" + this.mSubtypeId + " mIsSystemLocale=" + this.mIsSystemLocale + " mIsSystemLanguage=" + this.mIsSystemLanguage + i.d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/inputmethod/InputMethodSubtypeSwitchingController$InputMethodAndSubtypeList.class */
    public static class InputMethodAndSubtypeList {
        private final Context mContext;
        private final PackageManager mPm;
        private final InputMethodUtils.InputMethodSettings mSettings;
        private final TreeMap<InputMethodInfo, List<InputMethodSubtype>> mSortedImmis = new TreeMap<>(new Comparator<InputMethodInfo>() { // from class: com.android.internal.inputmethod.InputMethodSubtypeSwitchingController.InputMethodAndSubtypeList.1
            @Override // java.util.Comparator
            public int compare(InputMethodInfo inputMethodInfo, InputMethodInfo inputMethodInfo2) {
                if (inputMethodInfo2 == null) {
                    return 0;
                }
                if (inputMethodInfo == null) {
                    return 1;
                }
                if (InputMethodAndSubtypeList.this.mPm == null) {
                    return inputMethodInfo.getId().compareTo(inputMethodInfo2.getId());
                }
                return (((Object) inputMethodInfo.loadLabel(InputMethodAndSubtypeList.this.mPm)) + BridgeUtil.SPLIT_MARK + inputMethodInfo.getId()).toString().compareTo((((Object) inputMethodInfo2.loadLabel(InputMethodAndSubtypeList.this.mPm)) + BridgeUtil.SPLIT_MARK + inputMethodInfo2.getId()).toString());
            }
        });
        private final String mSystemLocaleStr;

        public InputMethodAndSubtypeList(Context context, InputMethodUtils.InputMethodSettings inputMethodSettings) {
            this.mContext = context;
            this.mSettings = inputMethodSettings;
            this.mPm = context.getPackageManager();
            Locale locale = context.getResources().getConfiguration().locale;
            this.mSystemLocaleStr = locale != null ? locale.toString() : "";
        }

        public List<ImeSubtypeListItem> getSortedInputMethodAndSubtypeList() {
            return getSortedInputMethodAndSubtypeList(true, false, false);
        }

        public List<ImeSubtypeListItem> getSortedInputMethodAndSubtypeList(boolean z, boolean z2, boolean z3) {
            ArrayList arrayList = new ArrayList();
            HashMap<InputMethodInfo, List<InputMethodSubtype>> explicitlyOrImplicitlyEnabledInputMethodsAndSubtypeListLocked = this.mSettings.getExplicitlyOrImplicitlyEnabledInputMethodsAndSubtypeListLocked(this.mContext);
            if (explicitlyOrImplicitlyEnabledInputMethodsAndSubtypeListLocked == null || explicitlyOrImplicitlyEnabledInputMethodsAndSubtypeListLocked.size() == 0) {
                return Collections.emptyList();
            }
            this.mSortedImmis.clear();
            this.mSortedImmis.putAll(explicitlyOrImplicitlyEnabledInputMethodsAndSubtypeListLocked);
            for (InputMethodInfo inputMethodInfo : this.mSortedImmis.keySet()) {
                if (inputMethodInfo != null) {
                    List<InputMethodSubtype> list = explicitlyOrImplicitlyEnabledInputMethodsAndSubtypeListLocked.get(inputMethodInfo);
                    HashSet hashSet = new HashSet();
                    for (InputMethodSubtype inputMethodSubtype : list) {
                        hashSet.add(String.valueOf(inputMethodSubtype.hashCode()));
                    }
                    CharSequence loadLabel = inputMethodInfo.loadLabel(this.mPm);
                    if (!z || hashSet.size() <= 0) {
                        arrayList.add(new ImeSubtypeListItem(loadLabel, null, inputMethodInfo, -1, null, this.mSystemLocaleStr));
                    } else {
                        int subtypeCount = inputMethodInfo.getSubtypeCount();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < subtypeCount) {
                                InputMethodSubtype subtypeAt = inputMethodInfo.getSubtypeAt(i2);
                                String valueOf = String.valueOf(subtypeAt.hashCode());
                                if (hashSet.contains(valueOf) && ((z2 && !z3) || !subtypeAt.isAuxiliary())) {
                                    arrayList.add(new ImeSubtypeListItem(loadLabel, subtypeAt.overridesImplicitlyEnabledSubtype() ? null : subtypeAt.getDisplayName(this.mContext, inputMethodInfo.getPackageName(), inputMethodInfo.getServiceInfo().applicationInfo), inputMethodInfo, i2, subtypeAt.getLocale(), this.mSystemLocaleStr));
                                    hashSet.remove(valueOf);
                                }
                                i = i2 + 1;
                            }
                        }
                    }
                }
            }
            Collections.sort(arrayList);
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/inputmethod/InputMethodSubtypeSwitchingController$StaticRotationList.class */
    public static class StaticRotationList {
        private final List<ImeSubtypeListItem> mImeSubtypeList;

        public StaticRotationList(List<ImeSubtypeListItem> list) {
            this.mImeSubtypeList = list;
        }

        private int getIndex(InputMethodInfo inputMethodInfo, InputMethodSubtype inputMethodSubtype) {
            int calculateSubtypeId = InputMethodSubtypeSwitchingController.calculateSubtypeId(inputMethodInfo, inputMethodSubtype);
            int size = this.mImeSubtypeList.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return -1;
                }
                ImeSubtypeListItem imeSubtypeListItem = this.mImeSubtypeList.get(i2);
                if (inputMethodInfo.equals(imeSubtypeListItem.mImi) && imeSubtypeListItem.mSubtypeId == calculateSubtypeId) {
                    return i2;
                }
                i = i2 + 1;
            }
        }

        public ImeSubtypeListItem getNextInputMethodLocked(boolean z, InputMethodInfo inputMethodInfo, InputMethodSubtype inputMethodSubtype) {
            int index;
            ImeSubtypeListItem imeSubtypeListItem;
            if (inputMethodInfo == null) {
                imeSubtypeListItem = null;
            } else if (this.mImeSubtypeList.size() <= 1 || (index = getIndex(inputMethodInfo, inputMethodSubtype)) < 0) {
                return null;
            } else {
                int size = this.mImeSubtypeList.size();
                int i = 1;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        return null;
                    }
                    ImeSubtypeListItem imeSubtypeListItem2 = this.mImeSubtypeList.get((index + i2) % size);
                    imeSubtypeListItem = imeSubtypeListItem2;
                    if (!z) {
                        break;
                    }
                    imeSubtypeListItem = imeSubtypeListItem2;
                    if (inputMethodInfo.equals(imeSubtypeListItem2.mImi)) {
                        break;
                    }
                    i = i2 + 1;
                }
            }
            return imeSubtypeListItem;
        }
    }

    private InputMethodSubtypeSwitchingController(InputMethodUtils.InputMethodSettings inputMethodSettings, Context context) {
        this.mSettings = inputMethodSettings;
        resetCircularListLocked(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int calculateSubtypeId(InputMethodInfo inputMethodInfo, InputMethodSubtype inputMethodSubtype) {
        if (inputMethodSubtype != null) {
            return InputMethodUtils.getSubtypeIdFromHashCode(inputMethodInfo, inputMethodSubtype.hashCode());
        }
        return -1;
    }

    public static InputMethodSubtypeSwitchingController createInstanceLocked(InputMethodUtils.InputMethodSettings inputMethodSettings, Context context) {
        return new InputMethodSubtypeSwitchingController(inputMethodSettings, context);
    }

    public ImeSubtypeListItem getNextInputMethodLocked(boolean z, InputMethodInfo inputMethodInfo, InputMethodSubtype inputMethodSubtype) {
        if (this.mController == null) {
            return null;
        }
        return this.mController.getNextInputMethod(z, inputMethodInfo, inputMethodSubtype);
    }

    public List<ImeSubtypeListItem> getSortedInputMethodAndSubtypeListLocked(boolean z, boolean z2, boolean z3) {
        return this.mSubtypeList.getSortedInputMethodAndSubtypeList(z, z2, z3);
    }

    public void onUserActionLocked(InputMethodInfo inputMethodInfo, InputMethodSubtype inputMethodSubtype) {
        if (this.mController == null) {
            return;
        }
        this.mController.onUserActionLocked(inputMethodInfo, inputMethodSubtype);
    }

    public void resetCircularListLocked(Context context) {
        this.mSubtypeList = new InputMethodAndSubtypeList(context, this.mSettings);
        this.mController = ControllerImpl.createFrom(this.mController, this.mSubtypeList.getSortedInputMethodAndSubtypeList());
    }
}
