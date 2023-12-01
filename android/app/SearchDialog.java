package android.app;

import android.R;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

/* loaded from: source-9557208-dex2jar.jar:android/app/SearchDialog.class */
public class SearchDialog extends Dialog {
    private static final boolean DBG = false;
    private static final String IME_OPTION_NO_MICROPHONE = "nm";
    private static final String INSTANCE_KEY_APPDATA = "data";
    private static final String INSTANCE_KEY_COMPONENT = "comp";
    private static final String INSTANCE_KEY_USER_QUERY = "uQry";
    private static final String LOG_TAG = "SearchDialog";
    private static final int SEARCH_PLATE_LEFT_PADDING_NON_GLOBAL = 7;
    private Context mActivityContext;
    private ImageView mAppIcon;
    private Bundle mAppSearchData;
    private TextView mBadgeLabel;
    private View mCloseSearch;
    private BroadcastReceiver mConfChangeListener;
    private ComponentName mLaunchComponent;
    private final SearchView.OnCloseListener mOnCloseListener;
    private final SearchView.OnQueryTextListener mOnQueryChangeListener;
    private final SearchView.OnSuggestionListener mOnSuggestionSelectionListener;
    private AutoCompleteTextView mSearchAutoComplete;
    private int mSearchAutoCompleteImeOptions;
    private View mSearchPlate;
    private SearchView mSearchView;
    private SearchableInfo mSearchable;
    private String mUserQuery;
    private final Intent mVoiceAppSearchIntent;
    private final Intent mVoiceWebSearchIntent;
    private Drawable mWorkingSpinner;

    /* loaded from: source-9557208-dex2jar.jar:android/app/SearchDialog$SearchBar.class */
    public static class SearchBar extends LinearLayout {
        private SearchDialog mSearchDialog;

        public SearchBar(Context context) {
            super(context);
        }

        public SearchBar(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public void setSearchDialog(SearchDialog searchDialog) {
            this.mSearchDialog = searchDialog;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
            return null;
        }
    }

    public SearchDialog(Context context, SearchManager searchManager) {
        super(context, resolveDialogTheme(context));
        this.mConfChangeListener = new BroadcastReceiver() { // from class: android.app.SearchDialog.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (intent.getAction().equals(Intent.ACTION_CONFIGURATION_CHANGED)) {
                    SearchDialog.this.onConfigurationChanged();
                }
            }
        };
        this.mOnCloseListener = new SearchView.OnCloseListener() { // from class: android.app.SearchDialog.3
            @Override // android.widget.SearchView.OnCloseListener
            public boolean onClose() {
                return SearchDialog.this.onClosePressed();
            }
        };
        this.mOnQueryChangeListener = new SearchView.OnQueryTextListener() { // from class: android.app.SearchDialog.4
            @Override // android.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(String str) {
                return false;
            }

            @Override // android.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(String str) {
                SearchDialog.this.dismiss();
                return false;
            }
        };
        this.mOnSuggestionSelectionListener = new SearchView.OnSuggestionListener() { // from class: android.app.SearchDialog.5
            @Override // android.widget.SearchView.OnSuggestionListener
            public boolean onSuggestionClick(int i) {
                SearchDialog.this.dismiss();
                return false;
            }

            @Override // android.widget.SearchView.OnSuggestionListener
            public boolean onSuggestionSelect(int i) {
                return false;
            }
        };
        this.mVoiceWebSearchIntent = new Intent(RecognizerIntent.ACTION_WEB_SEARCH);
        this.mVoiceWebSearchIntent.addFlags(268435456);
        this.mVoiceWebSearchIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
        this.mVoiceAppSearchIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        this.mVoiceAppSearchIntent.addFlags(268435456);
    }

    private void createContentView() {
        setContentView(17367230);
        ((SearchBar) findViewById(16909188)).setSearchDialog(this);
        this.mSearchView = (SearchView) findViewById(16909190);
        this.mSearchView.setIconified(false);
        this.mSearchView.setOnCloseListener(this.mOnCloseListener);
        this.mSearchView.setOnQueryTextListener(this.mOnQueryChangeListener);
        this.mSearchView.setOnSuggestionListener(this.mOnSuggestionSelectionListener);
        this.mSearchView.onActionViewExpanded();
        this.mCloseSearch = findViewById(R.id.closeButton);
        this.mCloseSearch.setOnClickListener(new View.OnClickListener() { // from class: android.app.SearchDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchDialog.this.dismiss();
            }
        });
        this.mBadgeLabel = (TextView) this.mSearchView.findViewById(16909192);
        this.mSearchAutoComplete = (AutoCompleteTextView) this.mSearchView.findViewById(16909197);
        this.mAppIcon = (ImageView) findViewById(16909189);
        this.mSearchPlate = this.mSearchView.findViewById(16909196);
        this.mWorkingSpinner = getContext().getDrawable(17303045);
        setWorking(false);
        this.mBadgeLabel.setVisibility(8);
        this.mSearchAutoCompleteImeOptions = this.mSearchAutoComplete.getImeOptions();
    }

    private Intent createIntent(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra(SearchManager.USER_QUERY, this.mUserQuery);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra(SearchManager.EXTRA_DATA_KEY, str2);
        }
        if (this.mAppSearchData != null) {
            intent.putExtra(SearchManager.APP_DATA, this.mAppSearchData);
        }
        if (i != 0) {
            intent.putExtra(SearchManager.ACTION_KEY, i);
            intent.putExtra(SearchManager.ACTION_MSG, str4);
        }
        intent.setComponent(this.mSearchable.getSearchActivity());
        return intent;
    }

    private boolean doShow(String str, boolean z, ComponentName componentName, Bundle bundle) {
        if (show(componentName, bundle)) {
            setUserQuery(str);
            if (z) {
                this.mSearchAutoComplete.selectAll();
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean isEmpty(AutoCompleteTextView autoCompleteTextView) {
        return TextUtils.getTrimmedLength(autoCompleteTextView.getText()) == 0;
    }

    static boolean isLandscapeMode(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private boolean isOutOfBounds(View view, MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int scaledWindowTouchSlop = ViewConfiguration.get(this.mContext).getScaledWindowTouchSlop();
        return x < (-scaledWindowTouchSlop) || y < (-scaledWindowTouchSlop) || x > view.getWidth() + scaledWindowTouchSlop || y > view.getHeight() + scaledWindowTouchSlop;
    }

    private void launchIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        Log.d(LOG_TAG, "launching " + intent);
        try {
            getContext().startActivity(intent);
            dismiss();
        } catch (RuntimeException e) {
            Log.e(LOG_TAG, "Failed launch activity: " + intent, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onClosePressed() {
        if (isEmpty(this.mSearchAutoComplete)) {
            dismiss();
            return true;
        }
        return false;
    }

    static int resolveDialogTheme(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(18219046, typedValue, true);
        return typedValue.resourceId;
    }

    private void setUserQuery(String str) {
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        this.mUserQuery = str2;
        this.mSearchAutoComplete.setText(str2);
        this.mSearchAutoComplete.setSelection(str2.length());
    }

    private boolean show(ComponentName componentName, Bundle bundle) {
        this.mSearchable = ((SearchManager) this.mContext.getSystemService("search")).getSearchableInfo(componentName);
        if (this.mSearchable == null) {
            return false;
        }
        this.mLaunchComponent = componentName;
        this.mAppSearchData = bundle;
        this.mActivityContext = this.mSearchable.getActivityContext(getContext());
        if (!isShowing()) {
            createContentView();
            this.mSearchView.setSearchableInfo(this.mSearchable);
            this.mSearchView.setAppSearchData(this.mAppSearchData);
            show();
        }
        updateUI();
        return true;
    }

    private void updateSearchAppIcon() {
        Drawable defaultActivityIcon;
        PackageManager packageManager = getContext().getPackageManager();
        try {
            defaultActivityIcon = packageManager.getApplicationIcon(packageManager.getActivityInfo(this.mLaunchComponent, 0).applicationInfo);
        } catch (PackageManager.NameNotFoundException e) {
            defaultActivityIcon = packageManager.getDefaultActivityIcon();
            Log.w(LOG_TAG, this.mLaunchComponent + " not found, using generic app icon");
        }
        this.mAppIcon.setImageDrawable(defaultActivityIcon);
        this.mAppIcon.setVisibility(0);
        this.mSearchPlate.setPadding(7, this.mSearchPlate.getPaddingTop(), this.mSearchPlate.getPaddingRight(), this.mSearchPlate.getPaddingBottom());
    }

    private void updateSearchAutoComplete() {
        this.mSearchAutoComplete.setDropDownDismissedOnCompletion(false);
        this.mSearchAutoComplete.setForceIgnoreOutsideTouch(false);
    }

    private void updateSearchBadge() {
        Drawable drawable;
        int i = 8;
        String str = null;
        if (this.mSearchable.useBadgeIcon()) {
            drawable = this.mActivityContext.getDrawable(this.mSearchable.getIconId());
            i = 0;
        } else {
            drawable = null;
            if (this.mSearchable.useBadgeLabel()) {
                str = this.mActivityContext.getResources().getText(this.mSearchable.getLabelId()).toString();
                i = 0;
                drawable = null;
            }
        }
        this.mBadgeLabel.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.mBadgeLabel.setText(str);
        this.mBadgeLabel.setVisibility(i);
    }

    private void updateUI() {
        if (this.mSearchable != null) {
            this.mDecor.setVisibility(0);
            updateSearchAutoComplete();
            updateSearchAppIcon();
            updateSearchBadge();
            int inputType = this.mSearchable.getInputType();
            int i = inputType;
            if ((inputType & 15) == 1) {
                int i2 = inputType & (-65537);
                i = i2;
                if (this.mSearchable.getSuggestAuthority() != null) {
                    i = i2 | 65536;
                }
            }
            this.mSearchAutoComplete.setInputType(i);
            this.mSearchAutoCompleteImeOptions = this.mSearchable.getImeOptions();
            this.mSearchAutoComplete.setImeOptions(this.mSearchAutoCompleteImeOptions);
            if (this.mSearchable.getVoiceSearchEnabled()) {
                this.mSearchAutoComplete.setPrivateImeOptions(IME_OPTION_NO_MICROPHONE);
            } else {
                this.mSearchAutoComplete.setPrivateImeOptions(null);
            }
        }
    }

    @Override // android.app.Dialog
    public void hide() {
        if (isShowing()) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
            }
            super.hide();
        }
    }

    public void launchQuerySearch() {
        launchQuerySearch(0, null);
    }

    protected void launchQuerySearch(int i, String str) {
        launchIntent(createIntent(Intent.ACTION_SEARCH, null, null, this.mSearchAutoComplete.getText().toString(), i, str));
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null && inputMethodManager.isFullscreenMode() && inputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0)) {
            return;
        }
        cancel();
    }

    public void onConfigurationChanged() {
        if (this.mSearchable == null || !isShowing()) {
            return;
        }
        updateSearchAppIcon();
        updateSearchBadge();
        if (isLandscapeMode(getContext())) {
            this.mSearchAutoComplete.ensureImeVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        attributes.gravity = 55;
        attributes.softInputMode = 16;
        window.setAttributes(attributes);
        setCanceledOnTouchOutside(true);
    }

    @Override // android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (doShow(bundle.getString(INSTANCE_KEY_USER_QUERY), false, (ComponentName) bundle.getParcelable(INSTANCE_KEY_COMPONENT), bundle.getBundle("data"))) {
        }
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        if (isShowing()) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(INSTANCE_KEY_COMPONENT, this.mLaunchComponent);
            bundle.putBundle("data", this.mAppSearchData);
            bundle.putString(INSTANCE_KEY_USER_QUERY, this.mUserQuery);
            return bundle;
        }
        return null;
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_CONFIGURATION_CHANGED);
        getContext().registerReceiver(this.mConfChangeListener, intentFilter);
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        getContext().unregisterReceiver(this.mConfChangeListener);
        this.mLaunchComponent = null;
        this.mAppSearchData = null;
        this.mSearchable = null;
        this.mUserQuery = null;
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mSearchAutoComplete.isPopupShowing() || !isOutOfBounds(this.mSearchPlate, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        cancel();
        return true;
    }

    public void setListSelection(int i) {
        this.mSearchAutoComplete.setListSelection(i);
    }

    public void setWorking(boolean z) {
        this.mWorkingSpinner.setAlpha(z ? 255 : 0);
        this.mWorkingSpinner.setVisible(z, false);
        this.mWorkingSpinner.invalidateSelf();
    }

    public boolean show(String str, boolean z, ComponentName componentName, Bundle bundle) {
        boolean doShow = doShow(str, z, componentName, bundle);
        if (doShow) {
            this.mSearchAutoComplete.showDropDownAfterLayout();
        }
        return doShow;
    }
}
