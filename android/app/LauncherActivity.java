package android.app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.TextView;
import com.android.internal.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/app/LauncherActivity.class */
public abstract class LauncherActivity extends ListActivity {
    IconResizer mIconResizer;
    Intent mIntent;
    PackageManager mPackageManager;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/LauncherActivity$ActivityAdapter.class */
    public class ActivityAdapter extends BaseAdapter implements Filterable {
        private final Object lock = new Object();
        protected List<ListItem> mActivitiesList;
        private Filter mFilter;
        protected final IconResizer mIconResizer;
        protected final LayoutInflater mInflater;
        private ArrayList<ListItem> mOriginalValues;
        private final boolean mShowIcons;

        /* loaded from: source-9557208-dex2jar.jar:android/app/LauncherActivity$ActivityAdapter$ArrayFilter.class */
        private class ArrayFilter extends Filter {
            private ArrayFilter() {
            }

            @Override // android.widget.Filter
            protected Filter.FilterResults performFiltering(CharSequence charSequence) {
                Filter.FilterResults filterResults = new Filter.FilterResults();
                if (ActivityAdapter.this.mOriginalValues == null) {
                    synchronized (ActivityAdapter.this.lock) {
                        ActivityAdapter.this.mOriginalValues = new ArrayList(ActivityAdapter.this.mActivitiesList);
                    }
                }
                if (charSequence == null || charSequence.length() == 0) {
                    synchronized (ActivityAdapter.this.lock) {
                        ArrayList arrayList = new ArrayList(ActivityAdapter.this.mOriginalValues);
                        filterResults.values = arrayList;
                        filterResults.count = arrayList.size();
                    }
                    return filterResults;
                }
                String lowerCase = charSequence.toString().toLowerCase();
                ArrayList arrayList2 = ActivityAdapter.this.mOriginalValues;
                int size = arrayList2.size();
                ArrayList arrayList3 = new ArrayList(size);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        filterResults.values = arrayList3;
                        filterResults.count = arrayList3.size();
                        return filterResults;
                    }
                    ListItem listItem = (ListItem) arrayList2.get(i2);
                    String[] split = listItem.label.toString().toLowerCase().split(" ");
                    int length = split.length;
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= length) {
                            break;
                        } else if (split[i4].startsWith(lowerCase)) {
                            arrayList3.add(listItem);
                            break;
                        } else {
                            i3 = i4 + 1;
                        }
                    }
                    i = i2 + 1;
                }
            }

            @Override // android.widget.Filter
            protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                ActivityAdapter.this.mActivitiesList = (List) filterResults.values;
                if (filterResults.count > 0) {
                    ActivityAdapter.this.notifyDataSetChanged();
                } else {
                    ActivityAdapter.this.notifyDataSetInvalidated();
                }
            }
        }

        public ActivityAdapter(IconResizer iconResizer) {
            this.mIconResizer = iconResizer;
            this.mInflater = (LayoutInflater) LauncherActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.mShowIcons = LauncherActivity.this.onEvaluateShowIcons();
            this.mActivitiesList = LauncherActivity.this.makeListItems();
        }

        private void bindView(View view, ListItem listItem) {
            TextView textView = (TextView) view;
            textView.setText(listItem.label);
            if (this.mShowIcons) {
                if (listItem.icon == null) {
                    listItem.icon = this.mIconResizer.createIconThumbnail(listItem.resolveInfo.loadIcon(LauncherActivity.this.getPackageManager()));
                }
                textView.setCompoundDrawablesWithIntrinsicBounds(listItem.icon, (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.mActivitiesList != null) {
                return this.mActivitiesList.size();
            }
            return 0;
        }

        @Override // android.widget.Filterable
        public Filter getFilter() {
            if (this.mFilter == null) {
                this.mFilter = new ArrayFilter();
            }
            return this.mFilter;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return Integer.valueOf(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.mInflater.inflate(R.layout.activity_list_item_2, viewGroup, false);
            }
            bindView(view, this.mActivitiesList.get(i));
            return view;
        }

        public Intent intentForPosition(int i) {
            Intent intent;
            if (this.mActivitiesList == null) {
                intent = null;
            } else {
                Intent intent2 = new Intent(LauncherActivity.this.mIntent);
                ListItem listItem = this.mActivitiesList.get(i);
                intent2.setClassName(listItem.packageName, listItem.className);
                intent = intent2;
                if (listItem.extras != null) {
                    intent2.putExtras(listItem.extras);
                    return intent2;
                }
            }
            return intent;
        }

        public ListItem itemForPosition(int i) {
            if (this.mActivitiesList == null) {
                return null;
            }
            return this.mActivitiesList.get(i);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/LauncherActivity$IconResizer.class */
    public class IconResizer {
        private int mIconHeight;
        private int mIconWidth;
        private final Rect mOldBounds = new Rect();
        private Canvas mCanvas = new Canvas();

        public IconResizer() {
            this.mIconWidth = -1;
            this.mIconHeight = -1;
            this.mCanvas.setDrawFilter(new PaintFlagsDrawFilter(4, 2));
            int dimension = (int) LauncherActivity.this.getResources().getDimension(17104896);
            this.mIconHeight = dimension;
            this.mIconWidth = dimension;
        }

        public Drawable createIconThumbnail(Drawable drawable) {
            int i;
            int i2 = this.mIconWidth;
            int i3 = this.mIconHeight;
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (drawable instanceof PaintDrawable) {
                PaintDrawable paintDrawable = (PaintDrawable) drawable;
                paintDrawable.setIntrinsicWidth(i2);
                paintDrawable.setIntrinsicHeight(i3);
            }
            BitmapDrawable bitmapDrawable = drawable;
            if (i2 > 0) {
                bitmapDrawable = drawable;
                if (i3 > 0) {
                    if (i2 < intrinsicWidth || i3 < intrinsicHeight) {
                        float f = intrinsicWidth / intrinsicHeight;
                        if (intrinsicWidth > intrinsicHeight) {
                            i = (int) (i2 / f);
                        } else {
                            i = i3;
                            if (intrinsicHeight > intrinsicWidth) {
                                i2 = (int) (i3 * f);
                                i = i3;
                            }
                        }
                        Bitmap createBitmap = Bitmap.createBitmap(this.mIconWidth, this.mIconHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
                        Canvas canvas = this.mCanvas;
                        canvas.setBitmap(createBitmap);
                        this.mOldBounds.set(drawable.getBounds());
                        int i4 = (this.mIconWidth - i2) / 2;
                        int i5 = (this.mIconHeight - i) / 2;
                        drawable.setBounds(i4, i5, i4 + i2, i5 + i);
                        drawable.draw(canvas);
                        drawable.setBounds(this.mOldBounds);
                        bitmapDrawable = new BitmapDrawable(LauncherActivity.this.getResources(), createBitmap);
                        canvas.setBitmap(null);
                    } else {
                        bitmapDrawable = drawable;
                        if (intrinsicWidth < i2) {
                            bitmapDrawable = drawable;
                            if (intrinsicHeight < i3) {
                                Bitmap createBitmap2 = Bitmap.createBitmap(this.mIconWidth, this.mIconHeight, Bitmap.Config.ARGB_8888);
                                Canvas canvas2 = this.mCanvas;
                                canvas2.setBitmap(createBitmap2);
                                this.mOldBounds.set(drawable.getBounds());
                                int i6 = (i2 - intrinsicWidth) / 2;
                                int i7 = (i3 - intrinsicHeight) / 2;
                                drawable.setBounds(i6, i7, i6 + intrinsicWidth, i7 + intrinsicHeight);
                                drawable.draw(canvas2);
                                drawable.setBounds(this.mOldBounds);
                                BitmapDrawable bitmapDrawable2 = new BitmapDrawable(LauncherActivity.this.getResources(), createBitmap2);
                                canvas2.setBitmap(null);
                                return bitmapDrawable2;
                            }
                        }
                    }
                }
            }
            return bitmapDrawable;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/LauncherActivity$ListItem.class */
    public static class ListItem {
        public String className;
        public Bundle extras;
        public Drawable icon;
        public CharSequence label;
        public String packageName;
        public ResolveInfo resolveInfo;

        public ListItem() {
        }

        ListItem(PackageManager packageManager, ResolveInfo resolveInfo, IconResizer iconResizer) {
            this.resolveInfo = resolveInfo;
            this.label = resolveInfo.loadLabel(packageManager);
            ComponentInfo componentInfo = resolveInfo.activityInfo;
            ComponentInfo componentInfo2 = componentInfo == null ? resolveInfo.serviceInfo : componentInfo;
            if (this.label == null && componentInfo2 != null) {
                this.label = resolveInfo.activityInfo.name;
            }
            if (iconResizer != null) {
                this.icon = iconResizer.createIconThumbnail(resolveInfo.loadIcon(packageManager));
            }
            this.packageName = componentInfo2.applicationInfo.packageName;
            this.className = componentInfo2.name;
        }
    }

    private void updateAlertTitle() {
        TextView textView = (TextView) findViewById(R.id.alertTitle);
        if (textView != null) {
            textView.setText(getTitle());
        }
    }

    private void updateButtonText() {
        Button button = (Button) findViewById(16908313);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: android.app.LauncherActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LauncherActivity.this.finish();
                }
            });
        }
    }

    protected Intent getTargetIntent() {
        return new Intent();
    }

    protected Intent intentForPosition(int i) {
        return ((ActivityAdapter) this.mAdapter).intentForPosition(i);
    }

    protected ListItem itemForPosition(int i) {
        return ((ActivityAdapter) this.mAdapter).itemForPosition(i);
    }

    public List<ListItem> makeListItems() {
        List<ResolveInfo> onQueryPackageManager = onQueryPackageManager(this.mIntent);
        onSortResultList(onQueryPackageManager);
        ArrayList arrayList = new ArrayList(onQueryPackageManager.size());
        int size = onQueryPackageManager.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return arrayList;
            }
            arrayList.add(new ListItem(this.mPackageManager, onQueryPackageManager.get(i2), null));
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mPackageManager = getPackageManager();
        if (!this.mPackageManager.hasSystemFeature(PackageManager.FEATURE_WATCH)) {
            requestWindowFeature(5);
            setProgressBarIndeterminateVisibility(true);
        }
        onSetContentView();
        this.mIconResizer = new IconResizer();
        this.mIntent = new Intent(getTargetIntent());
        this.mIntent.setComponent(null);
        this.mAdapter = new ActivityAdapter(this.mIconResizer);
        setListAdapter(this.mAdapter);
        getListView().setTextFilterEnabled(true);
        updateAlertTitle();
        updateButtonText();
        if (this.mPackageManager.hasSystemFeature(PackageManager.FEATURE_WATCH)) {
            return;
        }
        setProgressBarIndeterminateVisibility(false);
    }

    protected boolean onEvaluateShowIcons() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.ListActivity
    public void onListItemClick(ListView listView, View view, int i, long j) {
        startActivity(intentForPosition(i));
    }

    protected List<ResolveInfo> onQueryPackageManager(Intent intent) {
        return this.mPackageManager.queryIntentActivities(intent, 0);
    }

    protected void onSetContentView() {
        setContentView(R.layout.activity_list);
    }

    protected void onSortResultList(List<ResolveInfo> list) {
        Collections.sort(list, new ResolveInfo.DisplayNameComparator(this.mPackageManager));
    }

    @Override // android.app.Activity
    public void setTitle(int i) {
        super.setTitle(i);
        updateAlertTitle();
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        updateAlertTitle();
    }
}
