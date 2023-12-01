package android.preference;

import android.app.Fragment;
import android.app.FragmentBreadCrumbs;
import android.app.FragmentTransaction;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.android.internal.R;
import com.android.internal.util.XmlUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/preference/PreferenceActivity.class */
public abstract class PreferenceActivity extends ListActivity implements PreferenceManager.OnPreferenceTreeClickListener, PreferenceFragment.OnPreferenceStartFragmentCallback {
    private static final String BACK_STACK_PREFS = ":android:prefs";
    private static final String CUR_HEADER_TAG = ":android:cur_header";
    public static final String EXTRA_NO_HEADERS = ":android:no_headers";
    private static final String EXTRA_PREFS_SET_BACK_TEXT = "extra_prefs_set_back_text";
    private static final String EXTRA_PREFS_SET_NEXT_TEXT = "extra_prefs_set_next_text";
    private static final String EXTRA_PREFS_SHOW_BUTTON_BAR = "extra_prefs_show_button_bar";
    private static final String EXTRA_PREFS_SHOW_SKIP = "extra_prefs_show_skip";
    public static final String EXTRA_SHOW_FRAGMENT = ":android:show_fragment";
    public static final String EXTRA_SHOW_FRAGMENT_ARGUMENTS = ":android:show_fragment_args";
    public static final String EXTRA_SHOW_FRAGMENT_SHORT_TITLE = ":android:show_fragment_short_title";
    public static final String EXTRA_SHOW_FRAGMENT_TITLE = ":android:show_fragment_title";
    private static final int FIRST_REQUEST_CODE = 100;
    private static final String HEADERS_TAG = ":android:headers";
    public static final long HEADER_ID_UNDEFINED = -1;
    private static final int MSG_BIND_PREFERENCES = 1;
    private static final int MSG_BUILD_HEADERS = 2;
    private static final String PREFERENCES_TAG = ":android:preferences";
    private static final String TAG = "PreferenceActivity";
    private Header mCurHeader;
    private FragmentBreadCrumbs mFragmentBreadCrumbs;
    private FrameLayout mListFooter;
    private Button mNextButton;
    private PreferenceManager mPreferenceManager;
    private ViewGroup mPrefsContainer;
    private Bundle mSavedInstanceState;
    private boolean mSinglePane;
    private final ArrayList<Header> mHeaders = new ArrayList<>();
    private int mPreferenceHeaderItemResId = 0;
    private boolean mPreferenceHeaderRemoveEmptyIcon = false;
    private Handler mHandler = new Handler() { // from class: android.preference.PreferenceActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Header findBestMatchingHeader;
            switch (message.what) {
                case 1:
                    PreferenceActivity.this.bindPreferences();
                    return;
                case 2:
                    ArrayList<Header> arrayList = new ArrayList<>(PreferenceActivity.this.mHeaders);
                    PreferenceActivity.this.mHeaders.clear();
                    PreferenceActivity.this.onBuildHeaders(PreferenceActivity.this.mHeaders);
                    if (PreferenceActivity.this.mAdapter instanceof BaseAdapter) {
                        ((BaseAdapter) PreferenceActivity.this.mAdapter).notifyDataSetChanged();
                    }
                    Header onGetNewHeader = PreferenceActivity.this.onGetNewHeader();
                    if (onGetNewHeader == null || onGetNewHeader.fragment == null) {
                        if (PreferenceActivity.this.mCurHeader == null || (findBestMatchingHeader = PreferenceActivity.this.findBestMatchingHeader(PreferenceActivity.this.mCurHeader, PreferenceActivity.this.mHeaders)) == null) {
                            return;
                        }
                        PreferenceActivity.this.setSelectedHeader(findBestMatchingHeader);
                        return;
                    }
                    Header findBestMatchingHeader2 = PreferenceActivity.this.findBestMatchingHeader(onGetNewHeader, arrayList);
                    if (findBestMatchingHeader2 == null || PreferenceActivity.this.mCurHeader != findBestMatchingHeader2) {
                        PreferenceActivity.this.switchToHeader(onGetNewHeader);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    /* loaded from: source-9557208-dex2jar.jar:android/preference/PreferenceActivity$Header.class */
    public static final class Header implements Parcelable {
        public static final Parcelable.Creator<Header> CREATOR = new Parcelable.Creator<Header>() { // from class: android.preference.PreferenceActivity.Header.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Header createFromParcel(Parcel parcel) {
                return new Header(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Header[] newArray(int i) {
                return new Header[i];
            }
        };
        public CharSequence breadCrumbShortTitle;
        public int breadCrumbShortTitleRes;
        public CharSequence breadCrumbTitle;
        public int breadCrumbTitleRes;
        public Bundle extras;
        public String fragment;
        public Bundle fragmentArguments;
        public int iconRes;
        public long id = -1;
        public Intent intent;
        public CharSequence summary;
        public int summaryRes;
        public CharSequence title;
        public int titleRes;

        public Header() {
        }

        Header(Parcel parcel) {
            readFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public CharSequence getBreadCrumbShortTitle(Resources resources) {
            return this.breadCrumbShortTitleRes != 0 ? resources.getText(this.breadCrumbShortTitleRes) : this.breadCrumbShortTitle;
        }

        public CharSequence getBreadCrumbTitle(Resources resources) {
            return this.breadCrumbTitleRes != 0 ? resources.getText(this.breadCrumbTitleRes) : this.breadCrumbTitle;
        }

        public CharSequence getSummary(Resources resources) {
            return this.summaryRes != 0 ? resources.getText(this.summaryRes) : this.summary;
        }

        public CharSequence getTitle(Resources resources) {
            return this.titleRes != 0 ? resources.getText(this.titleRes) : this.title;
        }

        public void readFromParcel(Parcel parcel) {
            this.id = parcel.readLong();
            this.titleRes = parcel.readInt();
            this.title = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.summaryRes = parcel.readInt();
            this.summary = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.breadCrumbTitleRes = parcel.readInt();
            this.breadCrumbTitle = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.breadCrumbShortTitleRes = parcel.readInt();
            this.breadCrumbShortTitle = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.iconRes = parcel.readInt();
            this.fragment = parcel.readString();
            this.fragmentArguments = parcel.readBundle();
            if (parcel.readInt() != 0) {
                this.intent = Intent.CREATOR.createFromParcel(parcel);
            }
            this.extras = parcel.readBundle();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.id);
            parcel.writeInt(this.titleRes);
            TextUtils.writeToParcel(this.title, parcel, i);
            parcel.writeInt(this.summaryRes);
            TextUtils.writeToParcel(this.summary, parcel, i);
            parcel.writeInt(this.breadCrumbTitleRes);
            TextUtils.writeToParcel(this.breadCrumbTitle, parcel, i);
            parcel.writeInt(this.breadCrumbShortTitleRes);
            TextUtils.writeToParcel(this.breadCrumbShortTitle, parcel, i);
            parcel.writeInt(this.iconRes);
            parcel.writeString(this.fragment);
            parcel.writeBundle(this.fragmentArguments);
            if (this.intent != null) {
                parcel.writeInt(1);
                this.intent.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeBundle(this.extras);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/preference/PreferenceActivity$HeaderAdapter.class */
    private static class HeaderAdapter extends ArrayAdapter<Header> {
        private LayoutInflater mInflater;
        private int mLayoutResId;
        private boolean mRemoveIconIfEmpty;

        /* loaded from: source-9557208-dex2jar.jar:android/preference/PreferenceActivity$HeaderAdapter$HeaderViewHolder.class */
        private static class HeaderViewHolder {
            ImageView icon;
            TextView summary;
            TextView title;

            private HeaderViewHolder() {
            }
        }

        public HeaderAdapter(Context context, List<Header> list, int i, boolean z) {
            super(context, 0, list);
            this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.mLayoutResId = i;
            this.mRemoveIconIfEmpty = z;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            HeaderViewHolder headerViewHolder;
            if (view == null) {
                view2 = this.mInflater.inflate(this.mLayoutResId, viewGroup, false);
                headerViewHolder = new HeaderViewHolder();
                headerViewHolder.icon = (ImageView) view2.findViewById(16908294);
                headerViewHolder.title = (TextView) view2.findViewById(16908310);
                headerViewHolder.summary = (TextView) view2.findViewById(16908304);
                view2.setTag(headerViewHolder);
            } else {
                view2 = view;
                headerViewHolder = (HeaderViewHolder) view2.getTag();
            }
            Header item = getItem(i);
            if (!this.mRemoveIconIfEmpty) {
                headerViewHolder.icon.setImageResource(item.iconRes);
            } else if (item.iconRes == 0) {
                headerViewHolder.icon.setVisibility(8);
            } else {
                headerViewHolder.icon.setVisibility(0);
                headerViewHolder.icon.setImageResource(item.iconRes);
            }
            headerViewHolder.title.setText(item.getTitle(getContext().getResources()));
            CharSequence summary = item.getSummary(getContext().getResources());
            if (TextUtils.isEmpty(summary)) {
                headerViewHolder.summary.setVisibility(8);
                return view2;
            }
            headerViewHolder.summary.setVisibility(0);
            headerViewHolder.summary.setText(summary);
            return view2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindPreferences() {
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            preferenceScreen.bind(getListView());
            if (this.mSavedInstanceState != null) {
                super.onRestoreInstanceState(this.mSavedInstanceState);
                this.mSavedInstanceState = null;
            }
        }
    }

    private void postBindPreferences() {
        if (this.mHandler.hasMessages(1)) {
            return;
        }
        this.mHandler.obtainMessage(1).sendToTarget();
    }

    private void requirePreferenceManager() {
        if (this.mPreferenceManager == null) {
            if (this.mAdapter != null) {
                throw new RuntimeException("Modern two-pane PreferenceActivity requires use of a PreferenceFragment");
            }
            throw new RuntimeException("This should be called after super.onCreate.");
        }
    }

    private void switchToHeaderInner(String str, Bundle bundle) {
        getFragmentManager().popBackStack(BACK_STACK_PREFS, 1);
        if (!isValidFragment(str)) {
            throw new IllegalArgumentException("Invalid fragment for this activity: " + str);
        }
        Fragment instantiate = Fragment.instantiate(this, str, bundle);
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.setTransition(4099);
        beginTransaction.replace(R.id.prefs, instantiate);
        beginTransaction.commitAllowingStateLoss();
    }

    @Deprecated
    public void addPreferencesFromIntent(Intent intent) {
        requirePreferenceManager();
        setPreferenceScreen(this.mPreferenceManager.inflateFromIntent(intent, getPreferenceScreen()));
    }

    @Deprecated
    public void addPreferencesFromResource(int i) {
        requirePreferenceManager();
        setPreferenceScreen(this.mPreferenceManager.inflateFromResource(this, i, getPreferenceScreen()));
    }

    Header findBestMatchingHeader(Header header, ArrayList<Header> arrayList) {
        Header header2;
        Header header3;
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                break;
            }
            header3 = arrayList.get(i2);
            if (header == header3 || (header.id != -1 && header.id == header3.id)) {
                break;
            }
            if (header.fragment != null) {
                if (header.fragment.equals(header3.fragment)) {
                    arrayList2.add(header3);
                }
            } else if (header.intent != null) {
                if (header.intent.equals(header3.intent)) {
                    arrayList2.add(header3);
                }
            } else if (header.title != null && header.title.equals(header3.title)) {
                arrayList2.add(header3);
            }
            i = i2 + 1;
        }
        arrayList2.clear();
        arrayList2.add(header3);
        int size = arrayList2.size();
        if (size == 1) {
            header2 = (Header) arrayList2.get(0);
        } else if (size <= 1) {
            return null;
        } else {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= size) {
                    return null;
                }
                Header header4 = (Header) arrayList2.get(i4);
                if (header.fragmentArguments != null) {
                    header2 = header4;
                    if (header.fragmentArguments.equals(header4.fragmentArguments)) {
                        break;
                    }
                }
                if (header.extras != null) {
                    header2 = header4;
                    if (header.extras.equals(header4.extras)) {
                        break;
                    }
                }
                if (header.title != null) {
                    header2 = header4;
                    if (header.title.equals(header4.title)) {
                        break;
                    }
                }
                i3 = i4 + 1;
            }
        }
        return header2;
    }

    @Deprecated
    public Preference findPreference(CharSequence charSequence) {
        if (this.mPreferenceManager == null) {
            return null;
        }
        return this.mPreferenceManager.findPreference(charSequence);
    }

    public void finishPreferencePanel(Fragment fragment, int i, Intent intent) {
        if (this.mSinglePane) {
            setResult(i, intent);
            finish();
            return;
        }
        onBackPressed();
        if (fragment == null || fragment.getTargetFragment() == null) {
            return;
        }
        fragment.getTargetFragment().onActivityResult(fragment.getTargetRequestCode(), i, intent);
    }

    public List<Header> getHeaders() {
        return this.mHeaders;
    }

    protected Button getNextButton() {
        return this.mNextButton;
    }

    @Deprecated
    public PreferenceManager getPreferenceManager() {
        return this.mPreferenceManager;
    }

    @Deprecated
    public PreferenceScreen getPreferenceScreen() {
        if (this.mPreferenceManager != null) {
            return this.mPreferenceManager.getPreferenceScreen();
        }
        return null;
    }

    public boolean hasHeaders() {
        return getListView().getVisibility() == 0 && this.mPreferenceManager == null;
    }

    protected boolean hasNextButton() {
        return this.mNextButton != null;
    }

    public void invalidateHeaders() {
        if (this.mHandler.hasMessages(2)) {
            return;
        }
        this.mHandler.sendEmptyMessage(2);
    }

    public boolean isMultiPane() {
        return hasHeaders() && this.mPrefsContainer.getVisibility() == 0;
    }

    protected boolean isValidFragment(String str) {
        if (getApplicationInfo().targetSdkVersion >= 19) {
            throw new RuntimeException("Subclasses of PreferenceActivity must override isValidFragment(String) to verify that the Fragment class is valid! " + getClass().getName() + " has not checked if fragment " + str + " is valid.");
        }
        return true;
    }

    public void loadHeadersFromResource(int i, List<Header> list) {
        int next;
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                XmlResourceParser xml = getResources().getXml(i);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 1) {
                        break;
                    }
                } while (next != 2);
                String name = xml.getName();
                if (!"preference-headers".equals(name)) {
                    throw new RuntimeException("XML document must start with <preference-headers> tag; found" + name + " at " + xml.getPositionDescription());
                }
                Bundle bundle = null;
                int depth = xml.getDepth();
                while (true) {
                    int next2 = xml.next();
                    if (next2 == 1 || (next2 == 3 && xml.getDepth() <= depth)) {
                        break;
                    } else if (next2 != 3 && next2 != 4) {
                        if ("header".equals(xml.getName())) {
                            Header header = new Header();
                            TypedArray obtainStyledAttributes = obtainStyledAttributes(asAttributeSet, R.styleable.PreferenceHeader);
                            header.id = obtainStyledAttributes.getResourceId(1, -1);
                            TypedValue peekValue = obtainStyledAttributes.peekValue(2);
                            if (peekValue != null && peekValue.type == 3) {
                                if (peekValue.resourceId != 0) {
                                    header.titleRes = peekValue.resourceId;
                                } else {
                                    header.title = peekValue.string;
                                }
                            }
                            TypedValue peekValue2 = obtainStyledAttributes.peekValue(3);
                            if (peekValue2 != null && peekValue2.type == 3) {
                                if (peekValue2.resourceId != 0) {
                                    header.summaryRes = peekValue2.resourceId;
                                } else {
                                    header.summary = peekValue2.string;
                                }
                            }
                            TypedValue peekValue3 = obtainStyledAttributes.peekValue(5);
                            if (peekValue3 != null && peekValue3.type == 3) {
                                if (peekValue3.resourceId != 0) {
                                    header.breadCrumbTitleRes = peekValue3.resourceId;
                                } else {
                                    header.breadCrumbTitle = peekValue3.string;
                                }
                            }
                            TypedValue peekValue4 = obtainStyledAttributes.peekValue(6);
                            if (peekValue4 != null && peekValue4.type == 3) {
                                if (peekValue4.resourceId != 0) {
                                    header.breadCrumbShortTitleRes = peekValue4.resourceId;
                                } else {
                                    header.breadCrumbShortTitle = peekValue4.string;
                                }
                            }
                            header.iconRes = obtainStyledAttributes.getResourceId(0, 0);
                            header.fragment = obtainStyledAttributes.getString(4);
                            obtainStyledAttributes.recycle();
                            Bundle bundle2 = bundle;
                            if (bundle == null) {
                                bundle2 = new Bundle();
                            }
                            int depth2 = xml.getDepth();
                            while (true) {
                                int next3 = xml.next();
                                if (next3 == 1 || (next3 == 3 && xml.getDepth() <= depth2)) {
                                    break;
                                } else if (next3 != 3 && next3 != 4) {
                                    String name2 = xml.getName();
                                    if (name2.equals("extra")) {
                                        getResources().parseBundleExtra("extra", asAttributeSet, bundle2);
                                        XmlUtils.skipCurrentTag(xml);
                                    } else if (name2.equals("intent")) {
                                        header.intent = Intent.parseIntent(getResources(), xml, asAttributeSet);
                                    } else {
                                        XmlUtils.skipCurrentTag(xml);
                                    }
                                }
                            }
                            bundle = bundle2;
                            if (bundle2.size() > 0) {
                                header.fragmentArguments = bundle2;
                                bundle = null;
                            }
                            list.add(header);
                        } else {
                            XmlUtils.skipCurrentTag(xml);
                        }
                    }
                }
                if (xml != null) {
                    xml.close();
                }
            } catch (IOException e) {
                throw new RuntimeException("Error parsing headers", e);
            } catch (XmlPullParserException e2) {
                throw new RuntimeException("Error parsing headers", e2);
            }
        } catch (Throwable th) {
            if (0 != 0) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.mPreferenceManager != null) {
            this.mPreferenceManager.dispatchActivityResult(i, i2, intent);
        }
    }

    public void onBuildHeaders(List<Header> list) {
    }

    public Intent onBuildStartFragmentIntent(String str, Bundle bundle, int i, int i2) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setClass(this, getClass());
        intent.putExtra(EXTRA_SHOW_FRAGMENT, str);
        intent.putExtra(EXTRA_SHOW_FRAGMENT_ARGUMENTS, bundle);
        intent.putExtra(EXTRA_SHOW_FRAGMENT_TITLE, i);
        intent.putExtra(EXTRA_SHOW_FRAGMENT_SHORT_TITLE, i2);
        intent.putExtra(EXTRA_NO_HEADERS, true);
        return intent;
    }

    @Override // android.app.ListActivity, android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        super.onContentChanged();
        if (this.mPreferenceManager != null) {
            postBindPreferences();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TypedArray obtainStyledAttributes = obtainStyledAttributes(null, R.styleable.PreferenceActivity, R.attr.preferenceActivityStyle, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, R.layout.preference_list_content);
        this.mPreferenceHeaderItemResId = obtainStyledAttributes.getResourceId(1, R.layout.preference_header_item);
        this.mPreferenceHeaderRemoveEmptyIcon = obtainStyledAttributes.getBoolean(2, false);
        obtainStyledAttributes.recycle();
        setContentView(resourceId);
        this.mListFooter = (FrameLayout) findViewById(R.id.list_footer);
        this.mPrefsContainer = (ViewGroup) findViewById(R.id.prefs_frame);
        this.mSinglePane = onIsHidingHeaders() || !onIsMultiPane();
        String stringExtra = getIntent().getStringExtra(EXTRA_SHOW_FRAGMENT);
        Bundle bundleExtra = getIntent().getBundleExtra(EXTRA_SHOW_FRAGMENT_ARGUMENTS);
        int intExtra = getIntent().getIntExtra(EXTRA_SHOW_FRAGMENT_TITLE, 0);
        int intExtra2 = getIntent().getIntExtra(EXTRA_SHOW_FRAGMENT_SHORT_TITLE, 0);
        if (bundle != null) {
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(HEADERS_TAG);
            if (parcelableArrayList != null) {
                this.mHeaders.addAll(parcelableArrayList);
                int i = bundle.getInt(CUR_HEADER_TAG, -1);
                if (i >= 0 && i < this.mHeaders.size()) {
                    setSelectedHeader(this.mHeaders.get(i));
                }
            }
        } else if (stringExtra == null || !this.mSinglePane) {
            onBuildHeaders(this.mHeaders);
            if (this.mHeaders.size() > 0 && !this.mSinglePane) {
                if (stringExtra == null) {
                    switchToHeader(onGetInitialHeader());
                } else {
                    switchToHeader(stringExtra, bundleExtra);
                }
            }
        } else {
            switchToHeader(stringExtra, bundleExtra);
            if (intExtra != 0) {
                showBreadCrumbs(getText(intExtra), intExtra2 != 0 ? getText(intExtra2) : null);
            }
        }
        if (stringExtra != null && this.mSinglePane) {
            findViewById(R.id.headers).setVisibility(8);
            this.mPrefsContainer.setVisibility(0);
            if (intExtra != 0) {
                showBreadCrumbs(getText(intExtra), intExtra2 != 0 ? getText(intExtra2) : null);
            }
        } else if (this.mHeaders.size() > 0) {
            setListAdapter(new HeaderAdapter(this, this.mHeaders, this.mPreferenceHeaderItemResId, this.mPreferenceHeaderRemoveEmptyIcon));
            if (!this.mSinglePane) {
                getListView().setChoiceMode(1);
                if (this.mCurHeader != null) {
                    setSelectedHeader(this.mCurHeader);
                }
                this.mPrefsContainer.setVisibility(0);
            }
        } else {
            setContentView(R.layout.preference_list_content_single);
            this.mListFooter = (FrameLayout) findViewById(R.id.list_footer);
            this.mPrefsContainer = (ViewGroup) findViewById(R.id.prefs);
            this.mPreferenceManager = new PreferenceManager(this, 100);
            this.mPreferenceManager.setOnPreferenceTreeClickListener(this);
        }
        Intent intent = getIntent();
        if (intent.getBooleanExtra(EXTRA_PREFS_SHOW_BUTTON_BAR, false)) {
            findViewById(R.id.button_bar).setVisibility(0);
            Button button = (Button) findViewById(R.id.back_button);
            button.setOnClickListener(new View.OnClickListener() { // from class: android.preference.PreferenceActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PreferenceActivity.this.setResult(0);
                    PreferenceActivity.this.finish();
                }
            });
            Button button2 = (Button) findViewById(R.id.skip_button);
            button2.setOnClickListener(new View.OnClickListener() { // from class: android.preference.PreferenceActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PreferenceActivity.this.setResult(-1);
                    PreferenceActivity.this.finish();
                }
            });
            this.mNextButton = (Button) findViewById(R.id.next_button);
            this.mNextButton.setOnClickListener(new View.OnClickListener() { // from class: android.preference.PreferenceActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PreferenceActivity.this.setResult(-1);
                    PreferenceActivity.this.finish();
                }
            });
            if (intent.hasExtra(EXTRA_PREFS_SET_NEXT_TEXT)) {
                String stringExtra2 = intent.getStringExtra(EXTRA_PREFS_SET_NEXT_TEXT);
                if (TextUtils.isEmpty(stringExtra2)) {
                    this.mNextButton.setVisibility(8);
                } else {
                    this.mNextButton.setText(stringExtra2);
                }
            }
            if (intent.hasExtra(EXTRA_PREFS_SET_BACK_TEXT)) {
                String stringExtra3 = intent.getStringExtra(EXTRA_PREFS_SET_BACK_TEXT);
                if (TextUtils.isEmpty(stringExtra3)) {
                    button.setVisibility(8);
                } else {
                    button.setText(stringExtra3);
                }
            }
            if (intent.getBooleanExtra(EXTRA_PREFS_SHOW_SKIP, false)) {
                button2.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.ListActivity, android.app.Activity
    public void onDestroy() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        super.onDestroy();
        if (this.mPreferenceManager != null) {
            this.mPreferenceManager.dispatchActivityDestroy();
        }
    }

    public Header onGetInitialHeader() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mHeaders.size()) {
                throw new IllegalStateException("Must have at least one header with a fragment");
            }
            Header header = this.mHeaders.get(i2);
            if (header.fragment != null) {
                return header;
            }
            i = i2 + 1;
        }
    }

    public Header onGetNewHeader() {
        return null;
    }

    public void onHeaderClick(Header header, int i) {
        if (header.fragment == null) {
            if (header.intent != null) {
                startActivity(header.intent);
            }
        } else if (!this.mSinglePane) {
            switchToHeader(header);
        } else {
            int i2 = header.breadCrumbTitleRes;
            int i3 = header.breadCrumbShortTitleRes;
            int i4 = i2;
            if (i2 == 0) {
                i4 = header.titleRes;
                i3 = 0;
            }
            startWithFragment(header.fragment, header.fragmentArguments, null, 0, i4, i3);
        }
    }

    public boolean onIsHidingHeaders() {
        return getIntent().getBooleanExtra(EXTRA_NO_HEADERS, false);
    }

    public boolean onIsMultiPane() {
        return getResources().getBoolean(R.bool.preferences_prefer_dual_pane);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.ListActivity
    public void onListItemClick(ListView listView, View view, int i, long j) {
        if (isResumed()) {
            super.onListItemClick(listView, view, i, j);
            if (this.mAdapter != null) {
                Object item = this.mAdapter.getItem(i);
                if (item instanceof Header) {
                    onHeaderClick((Header) item, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        if (this.mPreferenceManager != null) {
            this.mPreferenceManager.dispatchNewIntent(intent);
        }
    }

    @Override // android.preference.PreferenceFragment.OnPreferenceStartFragmentCallback
    public boolean onPreferenceStartFragment(PreferenceFragment preferenceFragment, Preference preference) {
        startPreferencePanel(preference.getFragment(), preference.getExtras(), preference.getTitleRes(), preference.getTitle(), null, 0);
        return true;
    }

    @Override // android.preference.PreferenceManager.OnPreferenceTreeClickListener
    @Deprecated
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.ListActivity, android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Bundle bundle2;
        PreferenceScreen preferenceScreen;
        if (this.mPreferenceManager == null || (bundle2 = bundle.getBundle(PREFERENCES_TAG)) == null || (preferenceScreen = getPreferenceScreen()) == null) {
            super.onRestoreInstanceState(bundle);
            return;
        }
        preferenceScreen.restoreHierarchyState(bundle2);
        this.mSavedInstanceState = bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        PreferenceScreen preferenceScreen;
        int indexOf;
        super.onSaveInstanceState(bundle);
        if (this.mHeaders.size() > 0) {
            bundle.putParcelableArrayList(HEADERS_TAG, this.mHeaders);
            if (this.mCurHeader != null && (indexOf = this.mHeaders.indexOf(this.mCurHeader)) >= 0) {
                bundle.putInt(CUR_HEADER_TAG, indexOf);
            }
        }
        if (this.mPreferenceManager == null || (preferenceScreen = getPreferenceScreen()) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        preferenceScreen.saveHierarchyState(bundle2);
        bundle.putBundle(PREFERENCES_TAG, bundle2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mPreferenceManager != null) {
            this.mPreferenceManager.dispatchActivityStop();
        }
    }

    public void setListFooter(View view) {
        this.mListFooter.removeAllViews();
        this.mListFooter.addView(view, new FrameLayout.LayoutParams(-1, -2));
    }

    public void setParentTitle(CharSequence charSequence, CharSequence charSequence2, View.OnClickListener onClickListener) {
        if (this.mFragmentBreadCrumbs != null) {
            this.mFragmentBreadCrumbs.setParentTitle(charSequence, charSequence2, onClickListener);
        }
    }

    @Deprecated
    public void setPreferenceScreen(PreferenceScreen preferenceScreen) {
        requirePreferenceManager();
        if (!this.mPreferenceManager.setPreferences(preferenceScreen) || preferenceScreen == null) {
            return;
        }
        postBindPreferences();
        CharSequence title = getPreferenceScreen().getTitle();
        if (title != null) {
            setTitle(title);
        }
    }

    void setSelectedHeader(Header header) {
        this.mCurHeader = header;
        int indexOf = this.mHeaders.indexOf(header);
        if (indexOf >= 0) {
            getListView().setItemChecked(indexOf, true);
        } else {
            getListView().clearChoices();
        }
        showBreadCrumbs(header);
    }

    void showBreadCrumbs(Header header) {
        if (header == null) {
            showBreadCrumbs(getTitle(), null);
            return;
        }
        CharSequence breadCrumbTitle = header.getBreadCrumbTitle(getResources());
        CharSequence charSequence = breadCrumbTitle;
        if (breadCrumbTitle == null) {
            charSequence = header.getTitle(getResources());
        }
        CharSequence charSequence2 = charSequence;
        if (charSequence == null) {
            charSequence2 = getTitle();
        }
        showBreadCrumbs(charSequence2, header.getBreadCrumbShortTitle(getResources()));
    }

    public void showBreadCrumbs(CharSequence charSequence, CharSequence charSequence2) {
        if (this.mFragmentBreadCrumbs == null) {
            try {
                this.mFragmentBreadCrumbs = (FragmentBreadCrumbs) findViewById(16908310);
                if (this.mFragmentBreadCrumbs == null) {
                    if (charSequence != null) {
                        setTitle(charSequence);
                        return;
                    }
                    return;
                }
                if (this.mSinglePane) {
                    this.mFragmentBreadCrumbs.setVisibility(8);
                    View findViewById = findViewById(R.id.breadcrumb_section);
                    if (findViewById != null) {
                        findViewById.setVisibility(8);
                    }
                    setTitle(charSequence);
                }
                this.mFragmentBreadCrumbs.setMaxVisible(2);
                this.mFragmentBreadCrumbs.setActivity(this);
            } catch (ClassCastException e) {
                setTitle(charSequence);
                return;
            }
        }
        if (this.mFragmentBreadCrumbs.getVisibility() != 0) {
            setTitle(charSequence);
            return;
        }
        this.mFragmentBreadCrumbs.setTitle(charSequence, charSequence2);
        this.mFragmentBreadCrumbs.setParentTitle(null, null, null);
    }

    public void startPreferenceFragment(Fragment fragment, boolean z) {
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.prefs, fragment);
        if (z) {
            beginTransaction.setTransition(4097);
            beginTransaction.addToBackStack(BACK_STACK_PREFS);
        } else {
            beginTransaction.setTransition(4099);
        }
        beginTransaction.commitAllowingStateLoss();
    }

    public void startPreferencePanel(String str, Bundle bundle, int i, CharSequence charSequence, Fragment fragment, int i2) {
        if (this.mSinglePane) {
            startWithFragment(str, bundle, fragment, i2, i, 0);
            return;
        }
        Fragment instantiate = Fragment.instantiate(this, str, bundle);
        if (fragment != null) {
            instantiate.setTargetFragment(fragment, i2);
        }
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.prefs, instantiate);
        if (i != 0) {
            beginTransaction.setBreadCrumbTitle(i);
        } else if (charSequence != null) {
            beginTransaction.setBreadCrumbTitle(charSequence);
        }
        beginTransaction.setTransition(4097);
        beginTransaction.addToBackStack(BACK_STACK_PREFS);
        beginTransaction.commitAllowingStateLoss();
    }

    public void startWithFragment(String str, Bundle bundle, Fragment fragment, int i) {
        startWithFragment(str, bundle, fragment, i, 0, 0);
    }

    public void startWithFragment(String str, Bundle bundle, Fragment fragment, int i, int i2, int i3) {
        Intent onBuildStartFragmentIntent = onBuildStartFragmentIntent(str, bundle, i2, i3);
        if (fragment == null) {
            startActivity(onBuildStartFragmentIntent);
        } else {
            fragment.startActivityForResult(onBuildStartFragmentIntent, i);
        }
    }

    public void switchToHeader(Header header) {
        if (this.mCurHeader == header) {
            getFragmentManager().popBackStack(BACK_STACK_PREFS, 1);
        } else if (header.fragment == null) {
            throw new IllegalStateException("can't switch to header that has no fragment");
        } else {
            switchToHeaderInner(header.fragment, header.fragmentArguments);
            setSelectedHeader(header);
        }
    }

    public void switchToHeader(String str, Bundle bundle) {
        Header header;
        int i = 0;
        while (true) {
            int i2 = i;
            header = null;
            if (i2 >= this.mHeaders.size()) {
                break;
            } else if (str.equals(this.mHeaders.get(i2).fragment)) {
                header = this.mHeaders.get(i2);
                break;
            } else {
                i = i2 + 1;
            }
        }
        setSelectedHeader(header);
        switchToHeaderInner(str, bundle);
    }
}
