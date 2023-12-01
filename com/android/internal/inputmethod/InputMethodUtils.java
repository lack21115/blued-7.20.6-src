package com.android.internal.inputmethod;

import android.app.AppOpsManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Slog;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodSubtype;
import android.view.textservice.SpellCheckerInfo;
import android.view.textservice.TextServicesManager;
import com.android.internal.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/inputmethod/InputMethodUtils.class */
public class InputMethodUtils {
    public static final boolean DEBUG = false;
    public static final int NOT_A_SUBTYPE_ID = -1;
    public static final String SUBTYPE_MODE_KEYBOARD = "keyboard";
    public static final String SUBTYPE_MODE_VOICE = "voice";
    private static final String TAG = "InputMethodUtils";
    private static final String TAG_ASCII_CAPABLE = "AsciiCapable";
    private static final String TAG_ENABLED_WHEN_DEFAULT_IS_NOT_ASCII_CAPABLE = "EnabledWhenDefaultIsNotAsciiCapable";
    public static final String SUBTYPE_MODE_ANY = null;
    private static final Locale ENGLISH_LOCALE = new Locale("en");
    private static final String NOT_A_SUBTYPE_ID_STR = String.valueOf(-1);
    private static final Locale[] SEARCH_ORDER_OF_FALLBACK_LOCALES = {Locale.ENGLISH, Locale.US, Locale.UK};

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/inputmethod/InputMethodUtils$InputMethodListBuilder.class */
    public static final class InputMethodListBuilder {
        private final LinkedHashSet<InputMethodInfo> mInputMethodSet;

        private InputMethodListBuilder() {
            this.mInputMethodSet = new LinkedHashSet<>();
        }

        public ArrayList<InputMethodInfo> build() {
            return new ArrayList<>(this.mInputMethodSet);
        }

        public InputMethodListBuilder fillAuxiliaryImes(ArrayList<InputMethodInfo> arrayList, Context context) {
            Iterator<InputMethodInfo> it = this.mInputMethodSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    boolean z = false;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= arrayList.size()) {
                            break;
                        }
                        InputMethodInfo inputMethodInfo = arrayList.get(i2);
                        if (InputMethodUtils.isSystemAuxilialyImeThatHasAutomaticSubtype(inputMethodInfo, context, true)) {
                            this.mInputMethodSet.add(inputMethodInfo);
                            z = true;
                        }
                        i = i2 + 1;
                    }
                    if (!z) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= arrayList.size()) {
                                break;
                            }
                            InputMethodInfo inputMethodInfo2 = arrayList.get(i4);
                            if (InputMethodUtils.isSystemAuxilialyImeThatHasAutomaticSubtype(inputMethodInfo2, context, false)) {
                                this.mInputMethodSet.add(inputMethodInfo2);
                            }
                            i3 = i4 + 1;
                        }
                    }
                } else if (it.next().isAuxiliaryIme()) {
                    break;
                }
            }
            return this;
        }

        public InputMethodListBuilder fillImes(ArrayList<InputMethodInfo> arrayList, Context context, boolean z, Locale locale, boolean z2, String str) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    return this;
                }
                InputMethodInfo inputMethodInfo = arrayList.get(i2);
                if (InputMethodUtils.isSystemImeThatHasSubtypeOf(inputMethodInfo, context, z, locale, z2, str)) {
                    this.mInputMethodSet.add(inputMethodInfo);
                }
                i = i2 + 1;
            }
        }

        public boolean isEmpty() {
            return this.mInputMethodSet.isEmpty();
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/inputmethod/InputMethodUtils$InputMethodSettings.class */
    public static class InputMethodSettings {
        private static final char INPUT_METHOD_SEPARATER = ':';
        private static final char INPUT_METHOD_SUBTYPE_SEPARATER = ';';
        private int mCurrentUserId;
        private String mEnabledInputMethodsStrCache;
        private final ArrayList<InputMethodInfo> mMethodList;
        private final HashMap<String, InputMethodInfo> mMethodMap;
        private final Resources mRes;
        private final ContentResolver mResolver;
        private final TextUtils.SimpleStringSplitter mInputMethodSplitter = new TextUtils.SimpleStringSplitter(':');
        private final TextUtils.SimpleStringSplitter mSubtypeSplitter = new TextUtils.SimpleStringSplitter(';');
        private int[] mCurrentProfileIds = new int[0];

        public InputMethodSettings(Resources resources, ContentResolver contentResolver, HashMap<String, InputMethodInfo> hashMap, ArrayList<InputMethodInfo> arrayList, int i) {
            setCurrentUserId(i);
            this.mRes = resources;
            this.mResolver = contentResolver;
            this.mMethodMap = hashMap;
            this.mMethodList = arrayList;
        }

        private void addSubtypeToHistory(String str, String str2) {
            List<Pair<String, String>> loadInputMethodAndSubtypeHistoryLocked = loadInputMethodAndSubtypeHistoryLocked();
            Iterator<Pair<String, String>> it = loadInputMethodAndSubtypeHistoryLocked.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Pair<String, String> next = it.next();
                if (((String) next.first).equals(str)) {
                    loadInputMethodAndSubtypeHistoryLocked.remove(next);
                    break;
                }
            }
            saveSubtypeHistory(loadInputMethodAndSubtypeHistoryLocked, str, str2);
        }

        private static void buildEnabledInputMethodsSettingString(StringBuilder sb, Pair<String, ArrayList<String>> pair) {
            sb.append((String) pair.first);
            Iterator it = ((ArrayList) pair.second).iterator();
            while (it.hasNext()) {
                sb.append(';').append((String) it.next());
            }
        }

        private List<Pair<InputMethodInfo, ArrayList<String>>> createEnabledInputMethodAndSubtypeHashCodeListLocked(List<Pair<String, ArrayList<String>>> list) {
            ArrayList arrayList = new ArrayList();
            for (Pair<String, ArrayList<String>> pair : list) {
                InputMethodInfo inputMethodInfo = this.mMethodMap.get(pair.first);
                if (inputMethodInfo != null) {
                    arrayList.add(new Pair(inputMethodInfo, pair.second));
                }
            }
            return arrayList;
        }

        private List<InputMethodInfo> createEnabledInputMethodListLocked(List<Pair<String, ArrayList<String>>> list) {
            ArrayList arrayList = new ArrayList();
            for (Pair<String, ArrayList<String>> pair : list) {
                InputMethodInfo inputMethodInfo = this.mMethodMap.get(pair.first);
                if (inputMethodInfo != null) {
                    arrayList.add(inputMethodInfo);
                }
            }
            return arrayList;
        }

        private String getEnabledSubtypeHashCodeForInputMethodAndSubtypeLocked(List<Pair<String, ArrayList<String>>> list, String str, String str2) {
            ArrayList implicitlyApplicableSubtypesLocked;
            for (Pair<String, ArrayList<String>> pair : list) {
                if (((String) pair.first).equals(str)) {
                    ArrayList arrayList = (ArrayList) pair.second;
                    InputMethodInfo inputMethodInfo = this.mMethodMap.get(str);
                    if (arrayList.size() != 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            String str3 = (String) it.next();
                            if (str3.equals(str2)) {
                                try {
                                    return InputMethodUtils.isValidSubtypeId(inputMethodInfo, Integer.valueOf(str2).intValue()) ? str3 : InputMethodUtils.NOT_A_SUBTYPE_ID_STR;
                                } catch (NumberFormatException e) {
                                    return InputMethodUtils.NOT_A_SUBTYPE_ID_STR;
                                }
                            }
                        }
                    } else if (inputMethodInfo != null && inputMethodInfo.getSubtypeCount() > 0 && (implicitlyApplicableSubtypesLocked = InputMethodUtils.getImplicitlyApplicableSubtypesLocked(this.mRes, inputMethodInfo)) != null) {
                        int size = implicitlyApplicableSubtypesLocked.size();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= size) {
                                break;
                            } else if (String.valueOf(((InputMethodSubtype) implicitlyApplicableSubtypesLocked.get(i2)).hashCode()).equals(str2)) {
                                return str2;
                            } else {
                                i = i2 + 1;
                            }
                        }
                    }
                    return InputMethodUtils.NOT_A_SUBTYPE_ID_STR;
                }
            }
            return null;
        }

        private Pair<String, String> getLastSubtypeForInputMethodLockedInternal(String str) {
            List<Pair<String, ArrayList<String>>> enabledInputMethodsAndSubtypeListLocked = getEnabledInputMethodsAndSubtypeListLocked();
            for (Pair<String, String> pair : loadInputMethodAndSubtypeHistoryLocked()) {
                String str2 = (String) pair.first;
                if (TextUtils.isEmpty(str) || str2.equals(str)) {
                    String enabledSubtypeHashCodeForInputMethodAndSubtypeLocked = getEnabledSubtypeHashCodeForInputMethodAndSubtypeLocked(enabledInputMethodsAndSubtypeListLocked, str2, (String) pair.second);
                    if (!TextUtils.isEmpty(enabledSubtypeHashCodeForInputMethodAndSubtypeLocked)) {
                        return new Pair<>(str2, enabledSubtypeHashCodeForInputMethodAndSubtypeLocked);
                    }
                }
            }
            return null;
        }

        private int getSelectedInputMethodSubtypeHashCode() {
            try {
                return Settings.Secure.getIntForUser(this.mResolver, "selected_input_method_subtype", this.mCurrentUserId);
            } catch (Settings.SettingNotFoundException e) {
                return -1;
            }
        }

        private String getSubtypeHistoryStr() {
            return Settings.Secure.getStringForUser(this.mResolver, "input_methods_subtype_history", this.mCurrentUserId);
        }

        private List<Pair<String, String>> loadInputMethodAndSubtypeHistoryLocked() {
            ArrayList arrayList = new ArrayList();
            String subtypeHistoryStr = getSubtypeHistoryStr();
            if (!TextUtils.isEmpty(subtypeHistoryStr)) {
                this.mInputMethodSplitter.setString(subtypeHistoryStr);
                while (this.mInputMethodSplitter.hasNext()) {
                    this.mSubtypeSplitter.setString(this.mInputMethodSplitter.next());
                    if (this.mSubtypeSplitter.hasNext()) {
                        String str = InputMethodUtils.NOT_A_SUBTYPE_ID_STR;
                        String next = this.mSubtypeSplitter.next();
                        if (this.mSubtypeSplitter.hasNext()) {
                            str = this.mSubtypeSplitter.next();
                        }
                        arrayList.add(new Pair(next, str));
                    }
                }
            }
            return arrayList;
        }

        private void putEnabledInputMethodsStr(String str) {
            Settings.Secure.putStringForUser(this.mResolver, "enabled_input_methods", str, this.mCurrentUserId);
            this.mEnabledInputMethodsStrCache = str;
        }

        private void putSubtypeHistoryStr(String str) {
            Settings.Secure.putStringForUser(this.mResolver, "input_methods_subtype_history", str, this.mCurrentUserId);
        }

        private void saveSubtypeHistory(List<Pair<String, String>> list, String str, String str2) {
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            if (!TextUtils.isEmpty(str)) {
                z = false;
                if (!TextUtils.isEmpty(str2)) {
                    sb.append(str).append(';').append(str2);
                    z = true;
                }
            }
            for (Pair<String, String> pair : list) {
                String str3 = (String) pair.first;
                String str4 = (String) pair.second;
                String str5 = str4;
                if (TextUtils.isEmpty(str4)) {
                    str5 = InputMethodUtils.NOT_A_SUBTYPE_ID_STR;
                }
                if (z) {
                    sb.append(':');
                } else {
                    z = true;
                }
                sb.append(str3).append(';').append(str5);
            }
            putSubtypeHistoryStr(sb.toString());
        }

        public void appendAndPutEnabledInputMethodLocked(String str, boolean z) {
            if (z) {
                getEnabledInputMethodsStr();
            }
            if (TextUtils.isEmpty(this.mEnabledInputMethodsStrCache)) {
                putEnabledInputMethodsStr(str);
            } else {
                putEnabledInputMethodsStr(this.mEnabledInputMethodsStrCache + ':' + str);
            }
        }

        public boolean buildAndPutEnabledInputMethodsStrRemovingIdLocked(StringBuilder sb, List<Pair<String, ArrayList<String>>> list, String str) {
            boolean z = false;
            boolean z2 = false;
            for (Pair<String, ArrayList<String>> pair : list) {
                if (((String) pair.first).equals(str)) {
                    z = true;
                } else {
                    if (z2) {
                        sb.append(':');
                    } else {
                        z2 = true;
                    }
                    buildEnabledInputMethodsSettingString(sb, pair);
                }
            }
            if (z) {
                putEnabledInputMethodsStr(sb.toString());
            }
            return z;
        }

        public void enableAllIMEsIfThereIsNoEnabledIME() {
            if (!TextUtils.isEmpty(getEnabledInputMethodsStr())) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            int size = this.mMethodList.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    putEnabledInputMethodsStr(sb.toString());
                    return;
                }
                InputMethodInfo inputMethodInfo = this.mMethodList.get(i2);
                Slog.i(InputMethodUtils.TAG, "Adding: " + inputMethodInfo.getId());
                if (i2 > 0) {
                    sb.append(':');
                }
                sb.append(inputMethodInfo.getId());
                i = i2 + 1;
            }
        }

        public int getCurrentUserId() {
            return this.mCurrentUserId;
        }

        public String getDisabledSystemInputMethods() {
            return Settings.Secure.getStringForUser(this.mResolver, "disabled_system_input_methods", this.mCurrentUserId);
        }

        public List<Pair<InputMethodInfo, ArrayList<String>>> getEnabledInputMethodAndSubtypeHashCodeListLocked() {
            return createEnabledInputMethodAndSubtypeHashCodeListLocked(getEnabledInputMethodsAndSubtypeListLocked());
        }

        public List<InputMethodInfo> getEnabledInputMethodListLocked() {
            return createEnabledInputMethodListLocked(getEnabledInputMethodsAndSubtypeListLocked());
        }

        public List<InputMethodSubtype> getEnabledInputMethodSubtypeListLocked(Context context, InputMethodInfo inputMethodInfo, boolean z) {
            List<InputMethodSubtype> enabledInputMethodSubtypeListLocked = getEnabledInputMethodSubtypeListLocked(inputMethodInfo);
            ArrayList arrayList = enabledInputMethodSubtypeListLocked;
            if (z) {
                arrayList = enabledInputMethodSubtypeListLocked;
                if (enabledInputMethodSubtypeListLocked.isEmpty()) {
                    arrayList = InputMethodUtils.getImplicitlyApplicableSubtypesLocked(context.getResources(), inputMethodInfo);
                }
            }
            return InputMethodSubtype.sort(context, 0, inputMethodInfo, arrayList);
        }

        public List<InputMethodSubtype> getEnabledInputMethodSubtypeListLocked(InputMethodInfo inputMethodInfo) {
            List<Pair<String, ArrayList<String>>> enabledInputMethodsAndSubtypeListLocked = getEnabledInputMethodsAndSubtypeListLocked();
            ArrayList arrayList = new ArrayList();
            if (inputMethodInfo != null) {
                Iterator<Pair<String, ArrayList<String>>> it = enabledInputMethodsAndSubtypeListLocked.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Pair<String, ArrayList<String>> next = it.next();
                    InputMethodInfo inputMethodInfo2 = this.mMethodMap.get(next.first);
                    if (inputMethodInfo2 != null && inputMethodInfo2.getId().equals(inputMethodInfo.getId())) {
                        int subtypeCount = inputMethodInfo2.getSubtypeCount();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= subtypeCount) {
                                break;
                            }
                            InputMethodSubtype subtypeAt = inputMethodInfo2.getSubtypeAt(i2);
                            Iterator it2 = ((ArrayList) next.second).iterator();
                            while (it2.hasNext()) {
                                if (String.valueOf(subtypeAt.hashCode()).equals((String) it2.next())) {
                                    arrayList.add(subtypeAt);
                                }
                            }
                            i = i2 + 1;
                        }
                    }
                }
            }
            return arrayList;
        }

        public List<Pair<String, ArrayList<String>>> getEnabledInputMethodsAndSubtypeListLocked() {
            ArrayList arrayList = new ArrayList();
            String enabledInputMethodsStr = getEnabledInputMethodsStr();
            if (!TextUtils.isEmpty(enabledInputMethodsStr)) {
                this.mInputMethodSplitter.setString(enabledInputMethodsStr);
                while (this.mInputMethodSplitter.hasNext()) {
                    this.mSubtypeSplitter.setString(this.mInputMethodSplitter.next());
                    if (this.mSubtypeSplitter.hasNext()) {
                        ArrayList arrayList2 = new ArrayList();
                        String next = this.mSubtypeSplitter.next();
                        while (this.mSubtypeSplitter.hasNext()) {
                            arrayList2.add(this.mSubtypeSplitter.next());
                        }
                        arrayList.add(new Pair(next, arrayList2));
                    }
                }
            }
            return arrayList;
        }

        public String getEnabledInputMethodsStr() {
            this.mEnabledInputMethodsStrCache = Settings.Secure.getStringForUser(this.mResolver, "enabled_input_methods", this.mCurrentUserId);
            return this.mEnabledInputMethodsStrCache;
        }

        public HashMap<InputMethodInfo, List<InputMethodSubtype>> getExplicitlyOrImplicitlyEnabledInputMethodsAndSubtypeListLocked(Context context) {
            HashMap<InputMethodInfo, List<InputMethodSubtype>> hashMap = new HashMap<>();
            for (InputMethodInfo inputMethodInfo : getEnabledInputMethodListLocked()) {
                hashMap.put(inputMethodInfo, getEnabledInputMethodSubtypeListLocked(context, inputMethodInfo, true));
            }
            return hashMap;
        }

        public Pair<String, String> getLastInputMethodAndSubtypeLocked() {
            return getLastSubtypeForInputMethodLockedInternal(null);
        }

        public String getLastSubtypeForInputMethodLocked(String str) {
            Pair<String, String> lastSubtypeForInputMethodLockedInternal = getLastSubtypeForInputMethodLockedInternal(str);
            if (lastSubtypeForInputMethodLockedInternal != null) {
                return (String) lastSubtypeForInputMethodLockedInternal.second;
            }
            return null;
        }

        public String getSelectedInputMethod() {
            return Settings.Secure.getStringForUser(this.mResolver, "default_input_method", this.mCurrentUserId);
        }

        public int getSelectedInputMethodSubtypeId(String str) {
            InputMethodInfo inputMethodInfo = this.mMethodMap.get(str);
            if (inputMethodInfo == null) {
                return -1;
            }
            return InputMethodUtils.getSubtypeIdFromHashCode(inputMethodInfo, getSelectedInputMethodSubtypeHashCode());
        }

        public boolean isCurrentProfile(int i) {
            synchronized (this) {
                if (i == this.mCurrentUserId) {
                    return true;
                }
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= this.mCurrentProfileIds.length) {
                        return false;
                    }
                    if (i == this.mCurrentProfileIds[i3]) {
                        return true;
                    }
                    i2 = i3 + 1;
                }
            }
        }

        public boolean isShowImeWithHardKeyboardEnabled() {
            return Settings.Secure.getIntForUser(this.mResolver, "show_ime_with_hard_keyboard", 0, this.mCurrentUserId) == 1;
        }

        public boolean isSubtypeSelected() {
            return getSelectedInputMethodSubtypeHashCode() != -1;
        }

        public void putSelectedInputMethod(String str) {
            Settings.Secure.putStringForUser(this.mResolver, "default_input_method", str, this.mCurrentUserId);
        }

        public void putSelectedSubtype(int i) {
            Settings.Secure.putIntForUser(this.mResolver, "selected_input_method_subtype", i, this.mCurrentUserId);
        }

        public void saveCurrentInputMethodAndSubtypeToHistory(String str, InputMethodSubtype inputMethodSubtype) {
            String str2 = InputMethodUtils.NOT_A_SUBTYPE_ID_STR;
            if (inputMethodSubtype != null) {
                str2 = String.valueOf(inputMethodSubtype.hashCode());
            }
            if (InputMethodUtils.canAddToLastInputMethod(inputMethodSubtype)) {
                addSubtypeToHistory(str, str2);
            }
        }

        public void setCurrentProfileIds(int[] iArr) {
            synchronized (this) {
                this.mCurrentProfileIds = iArr;
            }
        }

        public void setCurrentUserId(int i) {
            this.mCurrentUserId = i;
        }

        public void setShowImeWithHardKeyboard(boolean z) {
            Settings.Secure.putIntForUser(this.mResolver, "show_ime_with_hard_keyboard", z ? 1 : 0, this.mCurrentUserId);
        }
    }

    private InputMethodUtils() {
    }

    public static boolean canAddToLastInputMethod(InputMethodSubtype inputMethodSubtype) {
        return inputMethodSubtype == null || !inputMethodSubtype.isAuxiliary();
    }

    public static boolean checkIfPackageBelongsToUid(AppOpsManager appOpsManager, int i, String str) {
        try {
            appOpsManager.checkPackage(i, str);
            return true;
        } catch (SecurityException e) {
            return false;
        }
    }

    @Deprecated
    public static boolean containsSubtypeOf(InputMethodInfo inputMethodInfo, String str, String str2) {
        int subtypeCount = inputMethodInfo.getSubtypeCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= subtypeCount) {
                return false;
            }
            InputMethodSubtype subtypeAt = inputMethodInfo.getSubtypeAt(i2);
            if (subtypeAt.getLocale().startsWith(str) && (str2 == SUBTYPE_MODE_ANY || TextUtils.isEmpty(str2) || str2.equalsIgnoreCase(subtypeAt.getMode()))) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static boolean containsSubtypeOf(InputMethodInfo inputMethodInfo, Locale locale, boolean z, String str) {
        if (locale == null) {
            return false;
        }
        int subtypeCount = inputMethodInfo.getSubtypeCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= subtypeCount) {
                return false;
            }
            InputMethodSubtype subtypeAt = inputMethodInfo.getSubtypeAt(i2);
            if (!z) {
                if (!new Locale(getLanguageFromLocaleString(subtypeAt.getLocale())).getLanguage().equals(locale.getLanguage())) {
                    continue;
                    i = i2 + 1;
                }
                return str != SUBTYPE_MODE_ANY ? true : true;
            }
            if (!TextUtils.equals(subtypeAt.getLocale(), locale.toString())) {
                continue;
                i = i2 + 1;
            }
            if (str != SUBTYPE_MODE_ANY || TextUtils.isEmpty(str) || str.equalsIgnoreCase(subtypeAt.getMode())) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static InputMethodSubtype findLastResortApplicableSubtypeLocked(Resources resources, List<InputMethodSubtype> list, String str, String str2, boolean z) {
        InputMethodSubtype inputMethodSubtype;
        InputMethodSubtype inputMethodSubtype2;
        InputMethodSubtype inputMethodSubtype3;
        InputMethodSubtype inputMethodSubtype4;
        boolean z2;
        if (list == null || list.size() == 0) {
            inputMethodSubtype = null;
        } else {
            String str3 = str2;
            if (TextUtils.isEmpty(str2)) {
                str3 = resources.getConfiguration().locale.toString();
            }
            String languageFromLocaleString = getLanguageFromLocaleString(str3);
            boolean z3 = false;
            InputMethodSubtype inputMethodSubtype5 = null;
            InputMethodSubtype inputMethodSubtype6 = null;
            int size = list.size();
            int i = 0;
            while (true) {
                inputMethodSubtype2 = inputMethodSubtype5;
                inputMethodSubtype = inputMethodSubtype6;
                if (i >= size) {
                    break;
                }
                inputMethodSubtype2 = list.get(i);
                String locale = inputMethodSubtype2.getLocale();
                String languageFromLocaleString2 = getLanguageFromLocaleString(locale);
                if (str != null) {
                    inputMethodSubtype3 = inputMethodSubtype5;
                    inputMethodSubtype4 = inputMethodSubtype6;
                    z2 = z3;
                    if (!list.get(i).getMode().equalsIgnoreCase(str)) {
                        continue;
                        i++;
                        inputMethodSubtype5 = inputMethodSubtype3;
                        inputMethodSubtype6 = inputMethodSubtype4;
                        z3 = z2;
                    }
                }
                inputMethodSubtype = inputMethodSubtype6;
                if (inputMethodSubtype6 == null) {
                    inputMethodSubtype = inputMethodSubtype2;
                }
                if (str3.equals(locale)) {
                    break;
                }
                inputMethodSubtype3 = inputMethodSubtype5;
                inputMethodSubtype4 = inputMethodSubtype;
                z2 = z3;
                if (!z3) {
                    inputMethodSubtype3 = inputMethodSubtype5;
                    inputMethodSubtype4 = inputMethodSubtype;
                    z2 = z3;
                    if (languageFromLocaleString.equals(languageFromLocaleString2)) {
                        z2 = true;
                        inputMethodSubtype4 = inputMethodSubtype;
                        inputMethodSubtype3 = inputMethodSubtype2;
                    }
                }
                i++;
                inputMethodSubtype5 = inputMethodSubtype3;
                inputMethodSubtype6 = inputMethodSubtype4;
                z3 = z2;
            }
            if (inputMethodSubtype2 != null || !z) {
                return inputMethodSubtype2;
            }
        }
        return inputMethodSubtype;
    }

    public static String getApiCallStack() {
        String str = "";
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 >= stackTrace.length) {
                    break;
                }
                String stackTraceElement = stackTrace[i2].toString();
                if (!TextUtils.isEmpty(str) && stackTraceElement.indexOf("Transact(") >= 0) {
                    break;
                }
                str = stackTraceElement;
                i = i2 + 1;
            }
            return str;
        }
    }

    public static ArrayList<InputMethodInfo> getDefaultEnabledImes(Context context, boolean z, ArrayList<InputMethodInfo> arrayList) {
        Locale fallbackLocaleForDefaultIme = getFallbackLocaleForDefaultIme(arrayList, context);
        if (z) {
            Locale systemLocaleFromContext = getSystemLocaleFromContext(context);
            return getMinimumKeyboardSetWithSystemLocale(arrayList, context, systemLocaleFromContext, fallbackLocaleForDefaultIme).fillImes(arrayList, context, true, systemLocaleFromContext, true, SUBTYPE_MODE_ANY).fillAuxiliaryImes(arrayList, context).build();
        }
        return getMinimumKeyboardSetWithoutSystemLocale(arrayList, context, fallbackLocaleForDefaultIme).fillImes(arrayList, context, true, fallbackLocaleForDefaultIme, true, SUBTYPE_MODE_ANY).build();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0039, code lost:
        return r12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Locale getFallbackLocaleForDefaultIme(java.util.ArrayList<android.view.inputmethod.InputMethodInfo> r7, android.content.Context r8) {
        /*
            java.util.Locale[] r0 = com.android.internal.inputmethod.InputMethodUtils.SEARCH_ORDER_OF_FALLBACK_LOCALES
            r13 = r0
            r0 = r13
            int r0 = r0.length
            r11 = r0
            r0 = 0
            r9 = r0
        Lc:
            r0 = r9
            r1 = r11
            if (r0 >= r1) goto L48
            r0 = r13
            r1 = r9
            r0 = r0[r1]
            r12 = r0
            r0 = 0
            r10 = r0
        L1a:
            r0 = r10
            r1 = r7
            int r1 = r1.size()
            if (r0 >= r1) goto L41
            r0 = r7
            r1 = r10
            java.lang.Object r0 = r0.get(r1)
            android.view.inputmethod.InputMethodInfo r0 = (android.view.inputmethod.InputMethodInfo) r0
            r1 = r8
            r2 = 1
            r3 = r12
            r4 = 1
            java.lang.String r5 = "keyboard"
            boolean r0 = isSystemImeThatHasSubtypeOf(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto L3a
        L37:
            r0 = r12
            return r0
        L3a:
            r0 = r10
            r1 = 1
            int r0 = r0 + r1
            r10 = r0
            goto L1a
        L41:
            r0 = r9
            r1 = 1
            int r0 = r0 + r1
            r9 = r0
            goto Lc
        L48:
            java.util.Locale[] r0 = com.android.internal.inputmethod.InputMethodUtils.SEARCH_ORDER_OF_FALLBACK_LOCALES
            r14 = r0
            r0 = r14
            int r0 = r0.length
            r11 = r0
            r0 = 0
            r9 = r0
        L54:
            r0 = r9
            r1 = r11
            if (r0 >= r1) goto L91
            r0 = r14
            r1 = r9
            r0 = r0[r1]
            r13 = r0
            r0 = 0
            r10 = r0
        L62:
            r0 = r10
            r1 = r7
            int r1 = r1.size()
            if (r0 >= r1) goto L8a
            r0 = r13
            r12 = r0
            r0 = r7
            r1 = r10
            java.lang.Object r0 = r0.get(r1)
            android.view.inputmethod.InputMethodInfo r0 = (android.view.inputmethod.InputMethodInfo) r0
            r1 = r8
            r2 = 0
            r3 = r13
            r4 = 1
            java.lang.String r5 = "keyboard"
            boolean r0 = isSystemImeThatHasSubtypeOf(r0, r1, r2, r3, r4, r5)
            if (r0 != 0) goto L37
            r0 = r10
            r1 = 1
            int r0 = r0 + r1
            r10 = r0
            goto L62
        L8a:
            r0 = r9
            r1 = 1
            int r0 = r0 + r1
            r9 = r0
            goto L54
        L91:
            java.lang.String r0 = "InputMethodUtils"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = r1
            r2.<init>()
            java.lang.String r2 = "Found no fallback locale. imis="
            java.lang.StringBuilder r1 = r1.append(r2)
            r2 = r7
            java.lang.Object[] r2 = r2.toArray()
            java.lang.String r2 = java.util.Arrays.toString(r2)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            int r0 = android.util.Slog.w(r0, r1)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.inputmethod.InputMethodUtils.getFallbackLocaleForDefaultIme(java.util.ArrayList, android.content.Context):java.util.Locale");
    }

    public static CharSequence getImeAndSubtypeDisplayName(Context context, InputMethodInfo inputMethodInfo, InputMethodSubtype inputMethodSubtype) {
        CharSequence loadLabel = inputMethodInfo.loadLabel(context.getPackageManager());
        CharSequence charSequence = loadLabel;
        if (inputMethodSubtype != null) {
            charSequence = TextUtils.concat(inputMethodSubtype.getDisplayName(context, inputMethodInfo.getPackageName(), inputMethodInfo.getServiceInfo().applicationInfo), TextUtils.isEmpty(loadLabel) ? "" : " - " + ((Object) loadLabel));
        }
        return charSequence;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ArrayList<InputMethodSubtype> getImplicitlyApplicableSubtypesLocked(Resources resources, InputMethodInfo inputMethodInfo) {
        ArrayList<InputMethodSubtype> arrayList;
        InputMethodSubtype inputMethodSubtype;
        ArrayList<InputMethodSubtype> subtypes = getSubtypes(inputMethodInfo);
        String locale = resources.getConfiguration().locale.toString();
        if (TextUtils.isEmpty(locale)) {
            arrayList = new ArrayList<>();
        } else {
            String language = resources.getConfiguration().locale.getLanguage();
            HashMap hashMap = new HashMap();
            int size = subtypes.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                InputMethodSubtype inputMethodSubtype2 = subtypes.get(i2);
                if (inputMethodSubtype2.overridesImplicitlyEnabledSubtype()) {
                    String mode = inputMethodSubtype2.getMode();
                    if (!hashMap.containsKey(mode)) {
                        hashMap.put(mode, inputMethodSubtype2);
                    }
                }
                i = i2 + 1;
            }
            if (hashMap.size() > 0) {
                return new ArrayList<>(hashMap.values());
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= size) {
                    break;
                }
                InputMethodSubtype inputMethodSubtype3 = subtypes.get(i4);
                String locale2 = inputMethodSubtype3.getLocale();
                String mode2 = inputMethodSubtype3.getMode();
                if (getLanguageFromLocaleString(locale2).equals(language) && locale.startsWith(locale2) && ((inputMethodSubtype = (InputMethodSubtype) hashMap.get(mode2)) == null || (!locale.equals(inputMethodSubtype.getLocale()) && locale.equals(locale2)))) {
                    hashMap.put(mode2, inputMethodSubtype3);
                }
                i3 = i4 + 1;
            }
            InputMethodSubtype inputMethodSubtype4 = (InputMethodSubtype) hashMap.get(SUBTYPE_MODE_KEYBOARD);
            ArrayList<InputMethodSubtype> arrayList2 = new ArrayList<>(hashMap.values());
            if (inputMethodSubtype4 != null && !inputMethodSubtype4.containsExtraValueKey(TAG_ASCII_CAPABLE)) {
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= size) {
                        break;
                    }
                    InputMethodSubtype inputMethodSubtype5 = subtypes.get(i6);
                    if (SUBTYPE_MODE_KEYBOARD.equals(inputMethodSubtype5.getMode()) && inputMethodSubtype5.containsExtraValueKey(TAG_ENABLED_WHEN_DEFAULT_IS_NOT_ASCII_CAPABLE)) {
                        arrayList2.add(inputMethodSubtype5);
                    }
                    i5 = i6 + 1;
                }
            }
            arrayList = arrayList2;
            if (inputMethodSubtype4 == null) {
                InputMethodSubtype findLastResortApplicableSubtypeLocked = findLastResortApplicableSubtypeLocked(resources, subtypes, SUBTYPE_MODE_KEYBOARD, locale, true);
                arrayList = arrayList2;
                if (findLastResortApplicableSubtypeLocked != null) {
                    arrayList2.add(findLastResortApplicableSubtypeLocked);
                    return arrayList2;
                }
            }
        }
        return arrayList;
    }

    public static String getLanguageFromLocaleString(String str) {
        int indexOf = str.indexOf(95);
        return indexOf < 0 ? str : str.substring(0, indexOf);
    }

    private static InputMethodListBuilder getMinimumKeyboardSetWithSystemLocale(ArrayList<InputMethodInfo> arrayList, Context context, Locale locale, Locale locale2) {
        InputMethodListBuilder inputMethodListBuilder = new InputMethodListBuilder();
        inputMethodListBuilder.fillImes(arrayList, context, true, locale, true, SUBTYPE_MODE_KEYBOARD);
        if (inputMethodListBuilder.isEmpty()) {
            inputMethodListBuilder.fillImes(arrayList, context, true, locale, false, SUBTYPE_MODE_KEYBOARD);
            if (inputMethodListBuilder.isEmpty()) {
                inputMethodListBuilder.fillImes(arrayList, context, true, locale2, true, SUBTYPE_MODE_KEYBOARD);
                if (inputMethodListBuilder.isEmpty()) {
                    inputMethodListBuilder.fillImes(arrayList, context, true, locale2, false, SUBTYPE_MODE_KEYBOARD);
                    if (inputMethodListBuilder.isEmpty()) {
                        inputMethodListBuilder.fillImes(arrayList, context, false, locale2, true, SUBTYPE_MODE_KEYBOARD);
                        if (inputMethodListBuilder.isEmpty()) {
                            inputMethodListBuilder.fillImes(arrayList, context, false, locale2, false, SUBTYPE_MODE_KEYBOARD);
                            if (inputMethodListBuilder.isEmpty()) {
                                Slog.w(TAG, "No software keyboard is found. imis=" + Arrays.toString(arrayList.toArray()) + " systemLocale=" + locale + " fallbackLocale=" + locale2);
                                return inputMethodListBuilder;
                            }
                        }
                    }
                }
            }
        }
        return inputMethodListBuilder;
    }

    private static InputMethodListBuilder getMinimumKeyboardSetWithoutSystemLocale(ArrayList<InputMethodInfo> arrayList, Context context, Locale locale) {
        InputMethodListBuilder inputMethodListBuilder = new InputMethodListBuilder();
        inputMethodListBuilder.fillImes(arrayList, context, true, locale, true, SUBTYPE_MODE_KEYBOARD);
        if (inputMethodListBuilder.isEmpty()) {
            inputMethodListBuilder.fillImes(arrayList, context, false, locale, true, SUBTYPE_MODE_KEYBOARD);
            if (inputMethodListBuilder.isEmpty()) {
                inputMethodListBuilder.fillImes(arrayList, context, true, locale, false, SUBTYPE_MODE_KEYBOARD);
                if (inputMethodListBuilder.isEmpty()) {
                    inputMethodListBuilder.fillImes(arrayList, context, false, locale, false, SUBTYPE_MODE_KEYBOARD);
                    if (inputMethodListBuilder.isEmpty()) {
                        Slog.w(TAG, "No software keyboard is found. imis=" + Arrays.toString(arrayList.toArray()) + " fallbackLocale=" + locale);
                        return inputMethodListBuilder;
                    }
                }
            }
        }
        return inputMethodListBuilder;
    }

    public static InputMethodInfo getMostApplicableDefaultIME(List<InputMethodInfo> list) {
        InputMethodInfo inputMethodInfo;
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            int i = -1;
            while (size > 0) {
                int i2 = size - 1;
                InputMethodInfo inputMethodInfo2 = list.get(i2);
                if (isSystemImeThatHasEnglishKeyboardSubtype(inputMethodInfo2)) {
                    inputMethodInfo = inputMethodInfo2;
                    if (!inputMethodInfo2.isAuxiliaryIme()) {
                    }
                }
                size = i2;
                if (i < 0) {
                    size = i2;
                    if (isSystemIme(inputMethodInfo2)) {
                        size = i2;
                        if (!inputMethodInfo2.isAuxiliaryIme()) {
                            i = i2;
                            size = i2;
                        }
                    }
                }
            }
            return list.get(Math.max(i, 0));
        }
        inputMethodInfo = null;
        return inputMethodInfo;
    }

    public static ArrayList<InputMethodSubtype> getOverridingImplicitlyEnabledSubtypes(InputMethodInfo inputMethodInfo, String str) {
        ArrayList<InputMethodSubtype> arrayList = new ArrayList<>();
        int subtypeCount = inputMethodInfo.getSubtypeCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= subtypeCount) {
                return arrayList;
            }
            InputMethodSubtype subtypeAt = inputMethodInfo.getSubtypeAt(i2);
            if (subtypeAt.overridesImplicitlyEnabledSubtype() && subtypeAt.getMode().equals(str)) {
                arrayList.add(subtypeAt);
            }
            i = i2 + 1;
        }
    }

    public static String getStackTrace() {
        StringBuilder sb = new StringBuilder();
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 >= stackTrace.length) {
                    return sb.toString();
                }
                sb.append(stackTrace[i2].toString() + "\n");
                i = i2 + 1;
            }
        }
    }

    public static int getSubtypeIdFromHashCode(InputMethodInfo inputMethodInfo, int i) {
        if (inputMethodInfo == null) {
            return -1;
        }
        int subtypeCount = inputMethodInfo.getSubtypeCount();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= subtypeCount) {
                return -1;
            }
            if (i == inputMethodInfo.getSubtypeAt(i3).hashCode()) {
                return i3;
            }
            i2 = i3 + 1;
        }
    }

    public static ArrayList<InputMethodSubtype> getSubtypes(InputMethodInfo inputMethodInfo) {
        ArrayList<InputMethodSubtype> arrayList = new ArrayList<>();
        int subtypeCount = inputMethodInfo.getSubtypeCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= subtypeCount) {
                return arrayList;
            }
            arrayList.add(inputMethodInfo.getSubtypeAt(i2));
            i = i2 + 1;
        }
    }

    public static Locale getSystemLocaleFromContext(Context context) {
        try {
            return context.getResources().getConfiguration().locale;
        } catch (Resources.NotFoundException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isSystemAuxilialyImeThatHasAutomaticSubtype(InputMethodInfo inputMethodInfo, Context context, boolean z) {
        if (!isSystemIme(inputMethodInfo)) {
            return false;
        }
        if ((z && !inputMethodInfo.isDefault(context)) || !inputMethodInfo.isAuxiliaryIme()) {
            return false;
        }
        int subtypeCount = inputMethodInfo.getSubtypeCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= subtypeCount) {
                return false;
            }
            if (inputMethodInfo.getSubtypeAt(i2).overridesImplicitlyEnabledSubtype()) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static boolean isSystemIme(InputMethodInfo inputMethodInfo) {
        return (inputMethodInfo.getServiceInfo().applicationInfo.flags & 1) != 0;
    }

    @Deprecated
    public static boolean isSystemImeThatHasEnglishKeyboardSubtype(InputMethodInfo inputMethodInfo) {
        if (isSystemIme(inputMethodInfo)) {
            return containsSubtypeOf(inputMethodInfo, ENGLISH_LOCALE.getLanguage(), SUBTYPE_MODE_KEYBOARD);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isSystemImeThatHasSubtypeOf(InputMethodInfo inputMethodInfo, Context context, boolean z, Locale locale, boolean z2, String str) {
        if (isSystemIme(inputMethodInfo)) {
            return (!z || inputMethodInfo.isDefault(context)) && containsSubtypeOf(inputMethodInfo, locale, z2, str);
        }
        return false;
    }

    public static boolean isValidSubtypeId(InputMethodInfo inputMethodInfo, int i) {
        return getSubtypeIdFromHashCode(inputMethodInfo, i) != -1;
    }

    @Deprecated
    public static boolean isValidSystemDefaultIme(boolean z, InputMethodInfo inputMethodInfo, Context context) {
        if (z && isSystemIme(inputMethodInfo)) {
            if (inputMethodInfo.getIsDefaultResourceId() != 0) {
                try {
                    if (inputMethodInfo.isDefault(context)) {
                        if (containsSubtypeOf(inputMethodInfo, context.getResources().getConfiguration().locale.getLanguage(), SUBTYPE_MODE_ANY)) {
                            return true;
                        }
                    }
                } catch (Resources.NotFoundException e) {
                }
            }
            if (inputMethodInfo.getSubtypeCount() == 0) {
                Slog.w(TAG, "Found no subtypes in a system IME: " + inputMethodInfo.getPackageName());
                return false;
            }
            return false;
        }
        return false;
    }

    private static void setDisabledUntilUsed(PackageManager packageManager, String str) {
        int applicationEnabledSetting = packageManager.getApplicationEnabledSetting(str);
        if (applicationEnabledSetting == 0 || applicationEnabledSetting == 1) {
            packageManager.setApplicationEnabledSetting(str, 4, 0);
        }
    }

    public static void setNonSelectedSystemImesDisabledUntilUsed(PackageManager packageManager, List<InputMethodInfo> list) {
        boolean z;
        String[] stringArray = Resources.getSystem().getStringArray(R.array.config_disabledUntilUsedPreinstalledImes);
        if (stringArray == null || stringArray.length == 0) {
            return;
        }
        SpellCheckerInfo currentSpellChecker = TextServicesManager.getInstance().getCurrentSpellChecker();
        int length = stringArray.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            String str = stringArray[i2];
            int i3 = 0;
            while (true) {
                int i4 = i3;
                z = false;
                if (i4 >= list.size()) {
                    break;
                } else if (str.equals(list.get(i4).getPackageName())) {
                    z = true;
                    break;
                } else {
                    i3 = i4 + 1;
                }
            }
            if (!z && (currentSpellChecker == null || !str.equals(currentSpellChecker.getPackageName()))) {
                ApplicationInfo applicationInfo = null;
                try {
                    applicationInfo = packageManager.getApplicationInfo(str, 32768);
                } catch (PackageManager.NameNotFoundException e) {
                    Slog.w(TAG, "NameNotFoundException: " + str, e);
                }
                if (applicationInfo != null) {
                    if ((applicationInfo.flags & 1) != 0) {
                        setDisabledUntilUsed(packageManager, str);
                    }
                }
            }
            i = i2 + 1;
        }
    }
}
