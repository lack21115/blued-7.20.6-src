package android.app;

import android.app.ISearchManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Log;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/app/SearchManager.class */
public class SearchManager implements DialogInterface.OnDismissListener, DialogInterface.OnCancelListener {
    public static final String ACTION_KEY = "action_key";
    public static final String ACTION_MSG = "action_msg";
    public static final String APP_DATA = "app_data";
    public static final String CONTEXT_IS_VOICE = "android.search.CONTEXT_IS_VOICE";
    public static final String CURSOR_EXTRA_KEY_IN_PROGRESS = "in_progress";
    private static final boolean DBG = false;
    public static final String DISABLE_VOICE_SEARCH = "android.search.DISABLE_VOICE_SEARCH";
    public static final String EXTRA_DATA_KEY = "intent_extra_data_key";
    public static final String EXTRA_NEW_SEARCH = "new_search";
    public static final String EXTRA_SELECT_QUERY = "select_query";
    public static final String EXTRA_WEB_SEARCH_PENDINGINTENT = "web_search_pendingintent";
    public static final int FLAG_QUERY_REFINEMENT = 1;
    public static final String INTENT_ACTION_GLOBAL_SEARCH = "android.search.action.GLOBAL_SEARCH";
    public static final String INTENT_ACTION_SEARCHABLES_CHANGED = "android.search.action.SEARCHABLES_CHANGED";
    public static final String INTENT_ACTION_SEARCH_SETTINGS = "android.search.action.SEARCH_SETTINGS";
    public static final String INTENT_ACTION_SEARCH_SETTINGS_CHANGED = "android.search.action.SETTINGS_CHANGED";
    public static final String INTENT_ACTION_WEB_SEARCH_SETTINGS = "android.search.action.WEB_SEARCH_SETTINGS";
    public static final String INTENT_GLOBAL_SEARCH_ACTIVITY_CHANGED = "android.search.action.GLOBAL_SEARCH_ACTIVITY_CHANGED";
    public static final char MENU_KEY = 's';
    public static final int MENU_KEYCODE = 47;
    public static final String QUERY = "query";
    public static final String SEARCH_MODE = "search_mode";
    public static final String SHORTCUT_MIME_TYPE = "vnd.android.cursor.item/vnd.android.search.suggest";
    public static final String SUGGEST_COLUMN_AUDIO_CHANNEL_CONFIG = "suggest_audio_channel_config";
    public static final String SUGGEST_COLUMN_CONTENT_TYPE = "suggest_content_type";
    public static final String SUGGEST_COLUMN_DURATION = "suggest_duration";
    public static final String SUGGEST_COLUMN_FLAGS = "suggest_flags";
    public static final String SUGGEST_COLUMN_FORMAT = "suggest_format";
    public static final String SUGGEST_COLUMN_ICON_1 = "suggest_icon_1";
    public static final String SUGGEST_COLUMN_ICON_2 = "suggest_icon_2";
    public static final String SUGGEST_COLUMN_INTENT_ACTION = "suggest_intent_action";
    public static final String SUGGEST_COLUMN_INTENT_DATA = "suggest_intent_data";
    public static final String SUGGEST_COLUMN_INTENT_DATA_ID = "suggest_intent_data_id";
    public static final String SUGGEST_COLUMN_INTENT_EXTRA_DATA = "suggest_intent_extra_data";
    public static final String SUGGEST_COLUMN_IS_LIVE = "suggest_is_live";
    public static final String SUGGEST_COLUMN_LAST_ACCESS_HINT = "suggest_last_access_hint";
    public static final String SUGGEST_COLUMN_PRODUCTION_YEAR = "suggest_production_year";
    public static final String SUGGEST_COLUMN_PURCHASE_PRICE = "suggest_purchase_price";
    public static final String SUGGEST_COLUMN_QUERY = "suggest_intent_query";
    public static final String SUGGEST_COLUMN_RATING_SCORE = "suggest_rating_score";
    public static final String SUGGEST_COLUMN_RATING_STYLE = "suggest_rating_style";
    public static final String SUGGEST_COLUMN_RENTAL_PRICE = "suggest_rental_price";
    public static final String SUGGEST_COLUMN_RESULT_CARD_IMAGE = "suggest_result_card_image";
    public static final String SUGGEST_COLUMN_SHORTCUT_ID = "suggest_shortcut_id";
    public static final String SUGGEST_COLUMN_SPINNER_WHILE_REFRESHING = "suggest_spinner_while_refreshing";
    public static final String SUGGEST_COLUMN_TEXT_1 = "suggest_text_1";
    public static final String SUGGEST_COLUMN_TEXT_2 = "suggest_text_2";
    public static final String SUGGEST_COLUMN_TEXT_2_URL = "suggest_text_2_url";
    public static final String SUGGEST_COLUMN_VIDEO_HEIGHT = "suggest_video_height";
    public static final String SUGGEST_COLUMN_VIDEO_WIDTH = "suggest_video_width";
    public static final String SUGGEST_MIME_TYPE = "vnd.android.cursor.dir/vnd.android.search.suggest";
    public static final String SUGGEST_NEVER_MAKE_SHORTCUT = "_-1";
    public static final String SUGGEST_PARAMETER_LIMIT = "limit";
    public static final String SUGGEST_URI_PATH_QUERY = "search_suggest_query";
    public static final String SUGGEST_URI_PATH_SHORTCUT = "search_suggest_shortcut";
    private static final String TAG = "SearchManager";
    public static final String USER_QUERY = "user_query";
    private static ISearchManager mService;
    private final Context mContext;
    final Handler mHandler;
    private SearchDialog mSearchDialog;
    OnDismissListener mDismissListener = null;
    OnCancelListener mCancelListener = null;

    /* loaded from: source-9557208-dex2jar.jar:android/app/SearchManager$OnCancelListener.class */
    public interface OnCancelListener {
        void onCancel();
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/SearchManager$OnDismissListener.class */
    public interface OnDismissListener {
        void onDismiss();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SearchManager(Context context, Handler handler) {
        this.mContext = context;
        this.mHandler = handler;
        mService = ISearchManager.Stub.asInterface(ServiceManager.getService("search"));
    }

    private void ensureSearchDialog() {
        if (this.mSearchDialog == null) {
            this.mSearchDialog = new SearchDialog(this.mContext, this);
            this.mSearchDialog.setOnCancelListener(this);
            this.mSearchDialog.setOnDismissListener(this);
        }
    }

    public Intent getAssistIntent(Context context, boolean z) {
        return getAssistIntent(context, z, UserHandle.myUserId());
    }

    public Intent getAssistIntent(Context context, boolean z, int i) {
        Intent intent;
        ComponentName assistIntent;
        try {
        } catch (RemoteException e) {
            Log.e(TAG, "getAssistIntent() failed: " + e);
            intent = null;
        }
        if (mService == null || (assistIntent = mService.getAssistIntent(i)) == null) {
            return null;
        }
        Intent intent2 = new Intent(Intent.ACTION_ASSIST);
        intent2.setComponent(assistIntent);
        intent = intent2;
        if (z) {
            Bundle assistContextExtras = ActivityManagerNative.getDefault().getAssistContextExtras(0);
            intent = intent2;
            if (assistContextExtras != null) {
                intent2.replaceExtras(assistContextExtras);
                return intent2;
            }
        }
        return intent;
    }

    public List<ResolveInfo> getGlobalSearchActivities() {
        try {
            return mService.getGlobalSearchActivities();
        } catch (RemoteException e) {
            Log.e(TAG, "getGlobalSearchActivities() failed: " + e);
            return null;
        }
    }

    public ComponentName getGlobalSearchActivity() {
        try {
            return mService.getGlobalSearchActivity();
        } catch (RemoteException e) {
            Log.e(TAG, "getGlobalSearchActivity() failed: " + e);
            return null;
        }
    }

    public SearchableInfo getSearchableInfo(ComponentName componentName) {
        try {
            return mService.getSearchableInfo(componentName);
        } catch (RemoteException e) {
            Log.e(TAG, "getSearchableInfo() failed: " + e);
            return null;
        }
    }

    public List<SearchableInfo> getSearchablesInGlobalSearch() {
        try {
            return mService.getSearchablesInGlobalSearch();
        } catch (RemoteException e) {
            Log.e(TAG, "getSearchablesInGlobalSearch() failed: " + e);
            return null;
        }
    }

    public Cursor getSuggestions(SearchableInfo searchableInfo, String str) {
        return getSuggestions(searchableInfo, str, -1);
    }

    public Cursor getSuggestions(SearchableInfo searchableInfo, String str, int i) {
        String suggestAuthority;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath(SUGGEST_URI_PATH_QUERY);
        String suggestSelection = searchableInfo.getSuggestSelection();
        String[] strArr = null;
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        if (i > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.mContext.getContentResolver().query(fragment.build(), null, suggestSelection, strArr, null);
    }

    public ComponentName getWebSearchActivity() {
        try {
            return mService.getWebSearchActivity();
        } catch (RemoteException e) {
            Log.e(TAG, "getWebSearchActivity() failed: " + e);
            return null;
        }
    }

    public boolean isVisible() {
        if (this.mSearchDialog == null) {
            return false;
        }
        return this.mSearchDialog.isShowing();
    }

    public boolean launchAssistAction(int i, String str, int i2) {
        try {
            if (mService == null) {
                return false;
            }
            return mService.launchAssistAction(i, str, i2);
        } catch (RemoteException e) {
            Log.e(TAG, "launchAssistAction() failed: " + e);
            return false;
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    @Deprecated
    public void onCancel(DialogInterface dialogInterface) {
        if (this.mCancelListener != null) {
            this.mCancelListener.onCancel();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    @Deprecated
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.mDismissListener != null) {
            this.mDismissListener.onDismiss();
        }
    }

    public void setOnCancelListener(OnCancelListener onCancelListener) {
        this.mCancelListener = onCancelListener;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.mDismissListener = onDismissListener;
    }

    void startGlobalSearch(String str, boolean z, Bundle bundle, Rect rect) {
        ComponentName globalSearchActivity = getGlobalSearchActivity();
        if (globalSearchActivity == null) {
            Log.w(TAG, "No global search activity found.");
            return;
        }
        Intent intent = new Intent(INTENT_ACTION_GLOBAL_SEARCH);
        intent.addFlags(268435456);
        intent.setComponent(globalSearchActivity);
        Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        if (!bundle2.containsKey("source")) {
            bundle2.putString("source", this.mContext.getPackageName());
        }
        intent.putExtra(APP_DATA, bundle2);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("query", str);
        }
        if (z) {
            intent.putExtra(EXTRA_SELECT_QUERY, z);
        }
        intent.setSourceBounds(rect);
        try {
            this.mContext.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Log.e(TAG, "Global search activity not found: " + globalSearchActivity);
        }
    }

    public void startSearch(String str, boolean z, ComponentName componentName, Bundle bundle, boolean z2) {
        startSearch(str, z, componentName, bundle, z2, null);
    }

    public void startSearch(String str, boolean z, ComponentName componentName, Bundle bundle, boolean z2, Rect rect) {
        if (z2) {
            startGlobalSearch(str, z, bundle, rect);
        } else if (new UiModeManager().getCurrentModeType() != 4) {
            ensureSearchDialog();
            this.mSearchDialog.show(str, z, componentName, bundle);
        }
    }

    public void stopSearch() {
        if (this.mSearchDialog != null) {
            this.mSearchDialog.cancel();
        }
    }

    public void triggerSearch(String str, ComponentName componentName, Bundle bundle) {
        if (str == null || TextUtils.getTrimmedLength(str) == 0) {
            Log.w(TAG, "triggerSearch called with empty query, ignoring.");
            return;
        }
        startSearch(str, false, componentName, bundle, false);
        this.mSearchDialog.launchQuerySearch();
    }
}
