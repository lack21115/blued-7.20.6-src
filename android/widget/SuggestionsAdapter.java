package android.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import com.android.internal.R;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.WeakHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-4181928-dex2jar.jar:android/widget/SuggestionsAdapter.class */
public class SuggestionsAdapter extends ResourceCursorAdapter implements View.OnClickListener {
    private static final boolean DBG = false;
    private static final long DELETE_KEY_POST_DELAY = 500;
    static final int INVALID_INDEX = -1;
    private static final String LOG_TAG = "SuggestionsAdapter";
    private static final int QUERY_LIMIT = 50;
    static final int REFINE_ALL = 2;
    static final int REFINE_BY_ENTRY = 1;
    static final int REFINE_NONE = 0;
    private boolean mClosed;
    private final int mCommitIconResId;
    private int mFlagsCol;
    private int mIconName1Col;
    private int mIconName2Col;
    private final WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache;
    private final Context mProviderContext;
    private int mQueryRefinement;
    private final SearchManager mSearchManager;
    private final SearchView mSearchView;
    private final SearchableInfo mSearchable;
    private int mText1Col;
    private int mText2Col;
    private int mText2UrlCol;
    private ColorStateList mUrlColor;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/SuggestionsAdapter$ChildViewCache.class */
    public static final class ChildViewCache {
        public final ImageView mIcon1;
        public final ImageView mIcon2;
        public final ImageView mIconRefine;
        public final TextView mText1;
        public final TextView mText2;

        public ChildViewCache(View view) {
            this.mText1 = (TextView) view.findViewById(16908308);
            this.mText2 = (TextView) view.findViewById(16908309);
            this.mIcon1 = (ImageView) view.findViewById(16908295);
            this.mIcon2 = (ImageView) view.findViewById(16908296);
            this.mIconRefine = (ImageView) view.findViewById(R.id.edit_query);
        }
    }

    public SuggestionsAdapter(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), (Cursor) null, true);
        this.mClosed = false;
        this.mQueryRefinement = 1;
        this.mText1Col = -1;
        this.mText2Col = -1;
        this.mText2UrlCol = -1;
        this.mIconName1Col = -1;
        this.mIconName2Col = -1;
        this.mFlagsCol = -1;
        this.mSearchManager = (SearchManager) this.mContext.getSystemService("search");
        this.mSearchView = searchView;
        this.mSearchable = searchableInfo;
        this.mCommitIconResId = searchView.getSuggestionCommitIconResId();
        this.mProviderContext = this.mSearchable.getProviderContext(this.mContext, this.mSearchable.getActivityContext(this.mContext));
        this.mOutsideDrawablesCache = weakHashMap;
        getFilter().setDelayer(new Filter.Delayer() { // from class: android.widget.SuggestionsAdapter.1
            private int mPreviousLength = 0;

            @Override // android.widget.Filter.Delayer
            public long getPostingDelay(CharSequence charSequence) {
                long j = 0;
                if (charSequence == null) {
                    return 0L;
                }
                if (charSequence.length() < this.mPreviousLength) {
                    j = 500;
                }
                this.mPreviousLength = charSequence.length();
                return j;
            }
        });
    }

    private Drawable checkIconCache(String str) {
        Drawable.ConstantState constantState = this.mOutsideDrawablesCache.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private CharSequence formatUrl(CharSequence charSequence) {
        if (this.mUrlColor == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(R.attr.textColorSearchUrl, typedValue, true);
            this.mUrlColor = this.mContext.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.mUrlColor, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private Drawable getActivityIcon(ComponentName componentName) {
        Drawable drawable;
        PackageManager packageManager = this.mContext.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                drawable = null;
            } else {
                Drawable drawable2 = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
                drawable = drawable2;
                if (drawable2 == null) {
                    Log.w(LOG_TAG, "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
                    return null;
                }
            }
            return drawable;
        } catch (PackageManager.NameNotFoundException e) {
            Log.w(LOG_TAG, e.toString());
            return null;
        }
    }

    private Drawable getActivityIconWithCache(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        if (!this.mOutsideDrawablesCache.containsKey(flattenToShortString)) {
            Drawable activityIcon = getActivityIcon(componentName);
            this.mOutsideDrawablesCache.put(flattenToShortString, activityIcon == null ? null : activityIcon.getConstantState());
            return activityIcon;
        }
        Drawable.ConstantState constantState = this.mOutsideDrawablesCache.get(flattenToShortString);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable(this.mProviderContext.getResources());
    }

    public static String getColumnString(Cursor cursor, String str) {
        return getStringOrNull(cursor, cursor.getColumnIndex(str));
    }

    private Drawable getDefaultIcon1(Cursor cursor) {
        Drawable activityIconWithCache = getActivityIconWithCache(this.mSearchable.getSearchActivity());
        return activityIconWithCache != null ? activityIconWithCache : this.mContext.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable getDrawable(Uri uri) {
        try {
            if (ContentResolver.SCHEME_ANDROID_RESOURCE.equals(uri.getScheme())) {
                ContentResolver.OpenResourceIdResult resourceId = this.mProviderContext.getContentResolver().getResourceId(uri);
                try {
                    return resourceId.r.getDrawable(resourceId.id, this.mContext.getTheme());
                } catch (Resources.NotFoundException e) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream openInputStream = this.mProviderContext.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
            try {
                openInputStream.close();
                return createFromStream;
            } catch (IOException e2) {
                Log.e(LOG_TAG, "Error closing icon stream for " + uri, e2);
                return createFromStream;
            }
        } catch (FileNotFoundException e3) {
            Log.w(LOG_TAG, "Icon not found: " + uri + ", " + e3.getMessage());
            return null;
        }
        Log.w(LOG_TAG, "Icon not found: " + uri + ", " + e3.getMessage());
        return null;
    }

    private Drawable getDrawableFromResourceValue(String str) {
        Drawable drawable;
        if (str == null || str.length() == 0 || "0".equals(str)) {
            drawable = null;
        } else {
            try {
                int parseInt = Integer.parseInt(str);
                String str2 = "android.resource://" + this.mProviderContext.getPackageName() + BridgeUtil.SPLIT_MARK + parseInt;
                Drawable checkIconCache = checkIconCache(str2);
                drawable = checkIconCache;
                if (checkIconCache == null) {
                    Drawable drawable2 = this.mProviderContext.getDrawable(parseInt);
                    storeInIconCache(str2, drawable2);
                    return drawable2;
                }
            } catch (Resources.NotFoundException e) {
                Log.w(LOG_TAG, "Icon resource not found: " + str);
                return null;
            } catch (NumberFormatException e2) {
                Drawable checkIconCache2 = checkIconCache(str);
                drawable = checkIconCache2;
                if (checkIconCache2 == null) {
                    Drawable drawable3 = getDrawable(Uri.parse(str));
                    storeInIconCache(str, drawable3);
                    return drawable3;
                }
            }
        }
        return drawable;
    }

    private Drawable getIcon1(Cursor cursor) {
        Drawable drawable;
        if (this.mIconName1Col == -1) {
            drawable = null;
        } else {
            Drawable drawableFromResourceValue = getDrawableFromResourceValue(cursor.getString(this.mIconName1Col));
            drawable = drawableFromResourceValue;
            if (drawableFromResourceValue == null) {
                return getDefaultIcon1(cursor);
            }
        }
        return drawable;
    }

    private Drawable getIcon2(Cursor cursor) {
        if (this.mIconName2Col == -1) {
            return null;
        }
        return getDrawableFromResourceValue(cursor.getString(this.mIconName2Col));
    }

    private static String getStringOrNull(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e) {
            Log.e(LOG_TAG, "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    private void setViewDrawable(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void setViewText(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private void storeInIconCache(String str, Drawable drawable) {
        if (drawable != null) {
            this.mOutsideDrawablesCache.put(str, drawable.getConstantState());
        }
    }

    private void updateSpinnerState(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean(SearchManager.CURSOR_EXTRA_KEY_IN_PROGRESS)) {
        }
    }

    @Override // android.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        ChildViewCache childViewCache = (ChildViewCache) view.getTag();
        int i = 0;
        if (this.mFlagsCol != -1) {
            i = cursor.getInt(this.mFlagsCol);
        }
        if (childViewCache.mText1 != null) {
            setViewText(childViewCache.mText1, getStringOrNull(cursor, this.mText1Col));
        }
        if (childViewCache.mText2 != null) {
            String stringOrNull = getStringOrNull(cursor, this.mText2UrlCol);
            String formatUrl = stringOrNull != null ? formatUrl(stringOrNull) : getStringOrNull(cursor, this.mText2Col);
            if (TextUtils.isEmpty(formatUrl)) {
                if (childViewCache.mText1 != null) {
                    childViewCache.mText1.setSingleLine(false);
                    childViewCache.mText1.setMaxLines(2);
                }
            } else if (childViewCache.mText1 != null) {
                childViewCache.mText1.setSingleLine(true);
                childViewCache.mText1.setMaxLines(1);
            }
            setViewText(childViewCache.mText2, formatUrl);
        }
        if (childViewCache.mIcon1 != null) {
            setViewDrawable(childViewCache.mIcon1, getIcon1(cursor), 4);
        }
        if (childViewCache.mIcon2 != null) {
            setViewDrawable(childViewCache.mIcon2, getIcon2(cursor), 8);
        }
        if (this.mQueryRefinement != 2 && (this.mQueryRefinement != 1 || (i & 1) == 0)) {
            childViewCache.mIconRefine.setVisibility(8);
            return;
        }
        childViewCache.mIconRefine.setVisibility(0);
        childViewCache.mIconRefine.setTag(childViewCache.mText1.getText());
        childViewCache.mIconRefine.setOnClickListener(this);
    }

    @Override // android.widget.CursorAdapter, android.widget.CursorFilter.CursorFilterClient
    public void changeCursor(Cursor cursor) {
        if (this.mClosed) {
            Log.w(LOG_TAG, "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.changeCursor(cursor);
            if (cursor != null) {
                this.mText1Col = cursor.getColumnIndex(SearchManager.SUGGEST_COLUMN_TEXT_1);
                this.mText2Col = cursor.getColumnIndex(SearchManager.SUGGEST_COLUMN_TEXT_2);
                this.mText2UrlCol = cursor.getColumnIndex(SearchManager.SUGGEST_COLUMN_TEXT_2_URL);
                this.mIconName1Col = cursor.getColumnIndex(SearchManager.SUGGEST_COLUMN_ICON_1);
                this.mIconName2Col = cursor.getColumnIndex(SearchManager.SUGGEST_COLUMN_ICON_2);
                this.mFlagsCol = cursor.getColumnIndex(SearchManager.SUGGEST_COLUMN_FLAGS);
            }
        } catch (Exception e) {
            Log.e(LOG_TAG, "error changing cursor and caching columns", e);
        }
    }

    public void close() {
        changeCursor(null);
        this.mClosed = true;
    }

    @Override // android.widget.CursorAdapter, android.widget.CursorFilter.CursorFilterClient
    public CharSequence convertToString(Cursor cursor) {
        String str;
        String columnString;
        String columnString2;
        if (cursor == null) {
            str = null;
        } else {
            String columnString3 = getColumnString(cursor, SearchManager.SUGGEST_COLUMN_QUERY);
            str = columnString3;
            if (columnString3 == null) {
                if (!this.mSearchable.shouldRewriteQueryFromData() || (columnString2 = getColumnString(cursor, SearchManager.SUGGEST_COLUMN_INTENT_DATA)) == null) {
                    if (!this.mSearchable.shouldRewriteQueryFromText() || (columnString = getColumnString(cursor, SearchManager.SUGGEST_COLUMN_TEXT_1)) == null) {
                        return null;
                    }
                    return columnString;
                }
                return columnString2;
            }
        }
        return str;
    }

    public int getQueryRefinement() {
        return this.mQueryRefinement;
    }

    @Override // android.widget.CursorAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        try {
            view2 = super.getView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w(LOG_TAG, "Search suggestions cursor threw exception.", e);
            View newView = newView(this.mContext, this.mCursor, viewGroup);
            view2 = newView;
            if (newView != null) {
                ((ChildViewCache) newView.getTag()).mText1.setText(e.toString());
                return newView;
            }
        }
        return view2;
    }

    @Override // android.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.ResourceCursorAdapter, android.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View newView = super.newView(context, cursor, viewGroup);
        newView.setTag(new ChildViewCache(newView));
        ((ImageView) newView.findViewById(R.id.edit_query)).setImageResource(this.mCommitIconResId);
        return newView;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        updateSpinnerState(getCursor());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        updateSpinnerState(getCursor());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.mSearchView.onQueryRefine((CharSequence) tag);
        }
    }

    @Override // android.widget.CursorAdapter, android.widget.CursorFilter.CursorFilterClient
    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.mSearchView.getVisibility() == 0 && this.mSearchView.getWindowVisibility() == 0) {
            try {
                Cursor suggestions = this.mSearchManager.getSuggestions(this.mSearchable, charSequence2, 50);
                if (suggestions != null) {
                    suggestions.getCount();
                    return suggestions;
                }
                return null;
            } catch (RuntimeException e) {
                Log.w(LOG_TAG, "Search suggestions query threw an exception.", e);
                return null;
            }
        }
        return null;
    }

    public void setQueryRefinement(int i) {
        this.mQueryRefinement = i;
    }
}
