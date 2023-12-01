package androidx.appcompat.widget;

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
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.content.ContextCompat;
import androidx.cursoradapter.widget.ResourceCursorAdapter;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.bytedance.applog.tracker.Tracker;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/SuggestionsAdapter.class */
class SuggestionsAdapter extends ResourceCursorAdapter implements View.OnClickListener {
    private final SearchView j;
    private final SearchableInfo k;
    private final Context l;
    private final WeakHashMap<String, Drawable.ConstantState> m;
    private final int n;
    private boolean o;
    private int p;
    private ColorStateList q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/SuggestionsAdapter$ChildViewCache.class */
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
        this.o = false;
        this.p = 1;
        this.r = -1;
        this.s = -1;
        this.t = -1;
        this.u = -1;
        this.v = -1;
        this.w = -1;
        this.j = searchView;
        this.k = searchableInfo;
        this.n = searchView.getSuggestionCommitIconResId();
        this.l = context;
        this.m = weakHashMap;
    }

    private Drawable a(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        if (!this.m.containsKey(flattenToShortString)) {
            Drawable b = b(componentName);
            this.m.put(flattenToShortString, b == null ? null : b.getConstantState());
            return b;
        }
        Drawable.ConstantState constantState = this.m.get(flattenToShortString);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable(this.l.getResources());
    }

    private Drawable a(String str) {
        Drawable drawable = null;
        if (str != null) {
            drawable = null;
            if (!str.isEmpty()) {
                if ("0".equals(str)) {
                    return null;
                }
                try {
                    int parseInt = Integer.parseInt(str);
                    String str2 = "android.resource://" + this.l.getPackageName() + BridgeUtil.SPLIT_MARK + parseInt;
                    Drawable b = b(str2);
                    if (b != null) {
                        return b;
                    }
                    Drawable drawable2 = ContextCompat.getDrawable(this.l, parseInt);
                    a(str2, drawable2);
                    return drawable2;
                } catch (Resources.NotFoundException e) {
                    Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
                    return null;
                } catch (NumberFormatException e2) {
                    Drawable b2 = b(str);
                    if (b2 != null) {
                        return b2;
                    }
                    drawable = b(Uri.parse(str));
                    a(str, drawable);
                }
            }
        }
        return drawable;
    }

    private CharSequence a(CharSequence charSequence) {
        if (this.q == null) {
            TypedValue typedValue = new TypedValue();
            this.l.getTheme().resolveAttribute(R.attr.textColorSearchUrl, typedValue, true);
            this.q = this.l.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.q, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private static String a(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    private void a(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean(SearchManager.CURSOR_EXTRA_KEY_IN_PROGRESS)) {
        }
    }

    private void a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private void a(String str, Drawable drawable) {
        if (drawable != null) {
            this.m.put(str, drawable.getConstantState());
        }
    }

    private Drawable b() {
        Drawable a2 = a(this.k.getSearchActivity());
        return a2 != null ? a2 : this.l.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable b(ComponentName componentName) {
        PackageManager packageManager = this.l.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable == null) {
                Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
                return null;
            }
            return drawable;
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("SuggestionsAdapter", e.toString());
            return null;
        }
    }

    private Drawable b(Cursor cursor) {
        int i = this.u;
        if (i == -1) {
            return null;
        }
        Drawable a2 = a(cursor.getString(i));
        return a2 != null ? a2 : b();
    }

    private Drawable b(Uri uri) {
        try {
            if (ContentResolver.SCHEME_ANDROID_RESOURCE.equals(uri.getScheme())) {
                try {
                    return a(uri);
                } catch (Resources.NotFoundException e) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream openInputStream = this.l.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
            try {
                openInputStream.close();
                return createFromStream;
            } catch (IOException e2) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e2);
                return createFromStream;
            }
        } catch (FileNotFoundException e3) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
        return null;
    }

    private Drawable b(String str) {
        Drawable.ConstantState constantState = this.m.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private Drawable c(Cursor cursor) {
        int i = this.v;
        if (i == -1) {
            return null;
        }
        return a(cursor.getString(i));
    }

    public static String getColumnString(Cursor cursor, String str) {
        return a(cursor, cursor.getColumnIndex(str));
    }

    Cursor a(SearchableInfo searchableInfo, String str, int i) {
        String suggestAuthority;
        String[] strArr;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath(SearchManager.SUGGEST_URI_PATH_QUERY);
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
            strArr = null;
        }
        if (i > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.l.getContentResolver().query(fragment.build(), null, suggestSelection, strArr, null);
    }

    Drawable a(Uri uri) throws FileNotFoundException {
        int parseInt;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.l.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    parseInt = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException e) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else if (size != 2) {
                throw new FileNotFoundException("More than two path segments: " + uri);
            } else {
                parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (parseInt != 0) {
                return resourcesForApplication.getDrawable(parseInt);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (PackageManager.NameNotFoundException e2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        ChildViewCache childViewCache = (ChildViewCache) view.getTag();
        int i = this.w;
        int i2 = i != -1 ? cursor.getInt(i) : 0;
        if (childViewCache.mText1 != null) {
            a(childViewCache.mText1, a(cursor, this.r));
        }
        if (childViewCache.mText2 != null) {
            String a2 = a(cursor, this.t);
            String a3 = a2 != null ? a((CharSequence) a2) : a(cursor, this.s);
            if (TextUtils.isEmpty(a3)) {
                if (childViewCache.mText1 != null) {
                    childViewCache.mText1.setSingleLine(false);
                    childViewCache.mText1.setMaxLines(2);
                }
            } else if (childViewCache.mText1 != null) {
                childViewCache.mText1.setSingleLine(true);
                childViewCache.mText1.setMaxLines(1);
            }
            a(childViewCache.mText2, a3);
        }
        if (childViewCache.mIcon1 != null) {
            a(childViewCache.mIcon1, b(cursor), 4);
        }
        if (childViewCache.mIcon2 != null) {
            a(childViewCache.mIcon2, c(cursor), 8);
        }
        int i3 = this.p;
        if (i3 != 2 && (i3 != 1 || (i2 & 1) == 0)) {
            childViewCache.mIconRefine.setVisibility(8);
            return;
        }
        childViewCache.mIconRefine.setVisibility(0);
        childViewCache.mIconRefine.setTag(childViewCache.mText1.getText());
        childViewCache.mIconRefine.setOnClickListener(this);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public void changeCursor(Cursor cursor) {
        if (this.o) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.changeCursor(cursor);
            if (cursor != null) {
                this.r = cursor.getColumnIndex(SearchManager.SUGGEST_COLUMN_TEXT_1);
                this.s = cursor.getColumnIndex(SearchManager.SUGGEST_COLUMN_TEXT_2);
                this.t = cursor.getColumnIndex(SearchManager.SUGGEST_COLUMN_TEXT_2_URL);
                this.u = cursor.getColumnIndex(SearchManager.SUGGEST_COLUMN_ICON_1);
                this.v = cursor.getColumnIndex(SearchManager.SUGGEST_COLUMN_ICON_2);
                this.w = cursor.getColumnIndex(SearchManager.SUGGEST_COLUMN_FLAGS);
            }
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    public void close() {
        changeCursor(null);
        this.o = true;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public CharSequence convertToString(Cursor cursor) {
        String columnString;
        String columnString2;
        if (cursor == null) {
            return null;
        }
        String columnString3 = getColumnString(cursor, SearchManager.SUGGEST_COLUMN_QUERY);
        if (columnString3 != null) {
            return columnString3;
        }
        if (!this.k.shouldRewriteQueryFromData() || (columnString2 = getColumnString(cursor, SearchManager.SUGGEST_COLUMN_INTENT_DATA)) == null) {
            if (!this.k.shouldRewriteQueryFromText() || (columnString = getColumnString(cursor, SearchManager.SUGGEST_COLUMN_TEXT_1)) == null) {
                return null;
            }
            return columnString;
        }
        return columnString2;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View newDropDownView = newDropDownView(this.l, getCursor(), viewGroup);
            if (newDropDownView != null) {
                ((ChildViewCache) newDropDownView.getTag()).mText1.setText(e.toString());
            }
            return newDropDownView;
        }
    }

    public int getQueryRefinement() {
        return this.p;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View newView = newView(this.l, getCursor(), viewGroup);
            if (newView != null) {
                ((ChildViewCache) newView.getTag()).mText1.setText(e.toString());
            }
            return newView;
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // androidx.cursoradapter.widget.ResourceCursorAdapter, androidx.cursoradapter.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View newView = super.newView(context, cursor, viewGroup);
        newView.setTag(new ChildViewCache(newView));
        ((ImageView) newView.findViewById(R.id.edit_query)).setImageResource(this.n);
        return newView;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        a(getCursor());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        a(getCursor());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.j.a((CharSequence) tag);
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.j.getVisibility() == 0 && this.j.getWindowVisibility() == 0) {
            try {
                Cursor a2 = a(this.k, charSequence2, 50);
                if (a2 != null) {
                    a2.getCount();
                    return a2;
                }
                return null;
            } catch (RuntimeException e) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
                return null;
            }
        }
        return null;
    }

    public void setQueryRefinement(int i) {
        this.p = i;
    }
}
