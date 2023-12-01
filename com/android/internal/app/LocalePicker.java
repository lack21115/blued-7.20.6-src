package com.android.internal.app;

import android.app.ActivityManagerNative;
import android.app.IActivityManager;
import android.app.ListFragment;
import android.app.backup.BackupManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.android.internal.R;
import com.anythink.expressad.exoplayer.b;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/app/LocalePicker.class */
public class LocalePicker extends ListFragment {
    private static final boolean DEBUG = false;
    private static final String TAG = "LocalePicker";
    LocaleSelectionListener mListener;

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/app/LocalePicker$LocaleInfo.class */
    public static class LocaleInfo implements Comparable<LocaleInfo> {
        static final Collator sCollator = Collator.getInstance();
        String label;
        Locale locale;

        public LocaleInfo(String str, Locale locale) {
            this.label = str;
            this.locale = locale;
        }

        @Override // java.lang.Comparable
        public int compareTo(LocaleInfo localeInfo) {
            return sCollator.compare(this.label, localeInfo.label);
        }

        public String getLabel() {
            return this.label;
        }

        public Locale getLocale() {
            return this.locale;
        }

        public String toString() {
            return this.label;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/app/LocalePicker$LocaleSelectionListener.class */
    public interface LocaleSelectionListener {
        void onLocaleSelected(Locale locale);
    }

    public static ArrayAdapter<LocaleInfo> constructAdapter(Context context) {
        return constructAdapter(context, R.layout.locale_picker_item, R.id.locale);
    }

    public static ArrayAdapter<LocaleInfo> constructAdapter(Context context, final int i, final int i2) {
        boolean z = false;
        if (Settings.Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0) {
            z = true;
        }
        List<LocaleInfo> allAssetLocales = getAllAssetLocales(context, z);
        final LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new ArrayAdapter<LocaleInfo>(context, i, i2, allAssetLocales) { // from class: com.android.internal.app.LocalePicker.1
            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i3, View view, ViewGroup viewGroup) {
                View view2;
                TextView textView;
                if (view == null) {
                    view2 = layoutInflater.inflate(i, viewGroup, false);
                    textView = (TextView) view2.findViewById(i2);
                    view2.setTag(textView);
                } else {
                    view2 = view;
                    textView = (TextView) view2.getTag();
                }
                LocaleInfo item = getItem(i3);
                textView.setText(item.toString());
                textView.setTextLocale(item.getLocale());
                return view2;
            }
        };
    }

    public static List<LocaleInfo> getAllAssetLocales(Context context, boolean z) {
        Resources resources = context.getResources();
        ArrayList<String> localeArray = getLocaleArray(Resources.getSystem().getAssets().getLocales(), resources);
        if (!z) {
            localeArray.remove("ar-XB");
            localeArray.remove("en-XA");
        }
        Collections.sort(localeArray);
        String[] stringArray = resources.getStringArray(R.array.special_locale_codes);
        String[] stringArray2 = resources.getStringArray(R.array.special_locale_names);
        ArrayList arrayList = new ArrayList(localeArray.size());
        Iterator<String> it = localeArray.iterator();
        while (it.hasNext()) {
            Locale forLanguageTag = Locale.forLanguageTag(it.next().replace('_', '-'));
            if (forLanguageTag != null && !b.f7166ar.equals(forLanguageTag.getLanguage()) && !forLanguageTag.getLanguage().isEmpty() && !forLanguageTag.getCountry().isEmpty()) {
                if (arrayList.isEmpty()) {
                    arrayList.add(new LocaleInfo(toTitleCase(forLanguageTag.getDisplayLanguage(forLanguageTag)), forLanguageTag));
                } else {
                    LocaleInfo localeInfo = (LocaleInfo) arrayList.get(arrayList.size() - 1);
                    if (!localeInfo.locale.getLanguage().equals(forLanguageTag.getLanguage()) || localeInfo.locale.getLanguage().equals("zz")) {
                        arrayList.add(new LocaleInfo(toTitleCase(forLanguageTag.getDisplayLanguage(forLanguageTag)), forLanguageTag));
                    } else {
                        localeInfo.label = toTitleCase(getDisplayName(localeInfo.locale, stringArray, stringArray2));
                        arrayList.add(new LocaleInfo(toTitleCase(getDisplayName(forLanguageTag, stringArray, stringArray2)), forLanguageTag));
                    }
                }
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static String getDisplayName(Locale locale, String[] strArr, String[] strArr2) {
        String locale2 = locale.toString();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return locale.getDisplayName(locale);
            }
            if (strArr[i2].equals(locale2)) {
                return strArr2[i2];
            }
            i = i2 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002c, code lost:
        if (r5.length == 0) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<java.lang.String> getLocaleArray(java.lang.String[] r4, android.content.res.Resources r5) {
        /*
            r0 = r5
            r1 = 17039644(0x104011c, float:2.4245367E-38)
            java.lang.String r0 = r0.getString(r1)
            r7 = r0
            r0 = 0
            r6 = r0
            r0 = r6
            r5 = r0
            r0 = r7
            if (r0 == 0) goto L24
            r0 = r6
            r5 = r0
            java.lang.String r0 = ""
            r1 = r7
            java.lang.String r1 = r1.trim()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L24
            r0 = r7
            java.lang.String r1 = ","
            java.lang.String[] r0 = r0.split(r1)
            r5 = r0
        L24:
            r0 = r5
            if (r0 == 0) goto L2f
            r0 = r5
            r6 = r0
            r0 = r5
            int r0 = r0.length
            if (r0 != 0) goto L31
        L2f:
            r0 = r4
            r6 = r0
        L31:
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = r0
            r2 = r6
            java.util.List r2 = java.util.Arrays.asList(r2)
            r1.<init>(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.app.LocalePicker.getLocaleArray(java.lang.String[], android.content.res.Resources):java.util.ArrayList");
    }

    private static String toTitleCase(String str) {
        return str.length() == 0 ? str : Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    public static void updateLocale(Locale locale) {
        try {
            IActivityManager iActivityManager = ActivityManagerNative.getDefault();
            Configuration configuration = iActivityManager.getConfiguration();
            configuration.setLocale(locale);
            iActivityManager.updateConfiguration(configuration);
            BackupManager.dataChanged("com.android.providers.settings");
        } catch (RemoteException e) {
        }
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setListAdapter(constructAdapter(getActivity()));
    }

    @Override // android.app.ListFragment
    public void onListItemClick(ListView listView, View view, int i, long j) {
        if (this.mListener != null) {
            this.mListener.onLocaleSelected(((LocaleInfo) getListAdapter().getItem(i)).locale);
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        getListView().requestFocus();
    }

    public void setLocaleSelectionListener(LocaleSelectionListener localeSelectionListener) {
        this.mListener = localeSelectionListener;
    }
}
