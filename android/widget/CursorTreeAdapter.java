package android.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorFilter;

/* loaded from: source-4181928-dex2jar.jar:android/widget/CursorTreeAdapter.class */
public abstract class CursorTreeAdapter extends BaseExpandableListAdapter implements Filterable, CursorFilter.CursorFilterClient {
    private boolean mAutoRequery;
    SparseArray<MyCursorHelper> mChildrenCursorHelpers;
    private Context mContext;
    CursorFilter mCursorFilter;
    FilterQueryProvider mFilterQueryProvider;
    MyCursorHelper mGroupCursorHelper;
    private Handler mHandler;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/CursorTreeAdapter$MyCursorHelper.class */
    public class MyCursorHelper {
        private MyContentObserver mContentObserver;
        private Cursor mCursor;
        private MyDataSetObserver mDataSetObserver;
        private boolean mDataValid;
        private int mRowIDColumn;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-4181928-dex2jar.jar:android/widget/CursorTreeAdapter$MyCursorHelper$MyContentObserver.class */
        public class MyContentObserver extends ContentObserver {
            public MyContentObserver() {
                super(CursorTreeAdapter.this.mHandler);
            }

            @Override // android.database.ContentObserver
            public boolean deliverSelfNotifications() {
                return true;
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                if (!CursorTreeAdapter.this.mAutoRequery || MyCursorHelper.this.mCursor == null || MyCursorHelper.this.mCursor.isClosed()) {
                    return;
                }
                MyCursorHelper.this.mDataValid = MyCursorHelper.this.mCursor.requery();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-4181928-dex2jar.jar:android/widget/CursorTreeAdapter$MyCursorHelper$MyDataSetObserver.class */
        public class MyDataSetObserver extends DataSetObserver {
            private MyDataSetObserver() {
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                MyCursorHelper.this.mDataValid = true;
                CursorTreeAdapter.this.notifyDataSetChanged();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                MyCursorHelper.this.mDataValid = false;
                CursorTreeAdapter.this.notifyDataSetInvalidated();
            }
        }

        MyCursorHelper(Cursor cursor) {
            boolean z = cursor != null;
            this.mCursor = cursor;
            this.mDataValid = z;
            this.mRowIDColumn = z ? cursor.getColumnIndex("_id") : -1;
            this.mContentObserver = new MyContentObserver();
            this.mDataSetObserver = new MyDataSetObserver();
            if (z) {
                cursor.registerContentObserver(this.mContentObserver);
                cursor.registerDataSetObserver(this.mDataSetObserver);
            }
        }

        void changeCursor(Cursor cursor, boolean z) {
            if (cursor == this.mCursor) {
                return;
            }
            deactivate();
            this.mCursor = cursor;
            if (cursor == null) {
                this.mRowIDColumn = -1;
                this.mDataValid = false;
                CursorTreeAdapter.this.notifyDataSetInvalidated();
                return;
            }
            cursor.registerContentObserver(this.mContentObserver);
            cursor.registerDataSetObserver(this.mDataSetObserver);
            this.mRowIDColumn = cursor.getColumnIndex("_id");
            this.mDataValid = true;
            CursorTreeAdapter.this.notifyDataSetChanged(z);
        }

        void deactivate() {
            if (this.mCursor == null) {
                return;
            }
            this.mCursor.unregisterContentObserver(this.mContentObserver);
            this.mCursor.unregisterDataSetObserver(this.mDataSetObserver);
            this.mCursor.close();
            this.mCursor = null;
        }

        int getCount() {
            if (!this.mDataValid || this.mCursor == null) {
                return 0;
            }
            return this.mCursor.getCount();
        }

        Cursor getCursor() {
            return this.mCursor;
        }

        long getId(int i) {
            long j = 0;
            if (this.mDataValid) {
                j = 0;
                if (this.mCursor != null) {
                    j = 0;
                    if (this.mCursor.moveToPosition(i)) {
                        j = this.mCursor.getLong(this.mRowIDColumn);
                    }
                }
            }
            return j;
        }

        boolean isValid() {
            return this.mDataValid && this.mCursor != null;
        }

        Cursor moveTo(int i) {
            if (this.mDataValid && this.mCursor != null && this.mCursor.moveToPosition(i)) {
                return this.mCursor;
            }
            return null;
        }
    }

    public CursorTreeAdapter(Cursor cursor, Context context) {
        init(cursor, context, true);
    }

    public CursorTreeAdapter(Cursor cursor, Context context, boolean z) {
        init(cursor, context, z);
    }

    private void init(Cursor cursor, Context context, boolean z) {
        this.mContext = context;
        this.mHandler = new Handler();
        this.mAutoRequery = z;
        this.mGroupCursorHelper = new MyCursorHelper(cursor);
        this.mChildrenCursorHelpers = new SparseArray<>();
    }

    private void releaseCursorHelpers() {
        synchronized (this) {
            int size = this.mChildrenCursorHelpers.size();
            while (true) {
                int i = size - 1;
                if (i >= 0) {
                    this.mChildrenCursorHelpers.valueAt(i).deactivate();
                    size = i;
                } else {
                    this.mChildrenCursorHelpers.clear();
                }
            }
        }
    }

    protected abstract void bindChildView(View view, Context context, Cursor cursor, boolean z);

    protected abstract void bindGroupView(View view, Context context, Cursor cursor, boolean z);

    @Override // android.widget.CursorFilter.CursorFilterClient
    public void changeCursor(Cursor cursor) {
        this.mGroupCursorHelper.changeCursor(cursor, true);
    }

    @Override // android.widget.CursorFilter.CursorFilterClient
    public String convertToString(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    void deactivateChildrenCursorHelper(int i) {
        synchronized (this) {
            MyCursorHelper childrenCursorHelper = getChildrenCursorHelper(i, true);
            this.mChildrenCursorHelpers.remove(i);
            childrenCursorHelper.deactivate();
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public Cursor getChild(int i, int i2) {
        return getChildrenCursorHelper(i, true).moveTo(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        return getChildrenCursorHelper(i, true).getId(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        Cursor moveTo = getChildrenCursorHelper(i, true).moveTo(i2);
        if (moveTo == null) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (view == null) {
            view = newChildView(this.mContext, moveTo, z, viewGroup);
        }
        bindChildView(view, this.mContext, moveTo, z);
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        MyCursorHelper childrenCursorHelper = getChildrenCursorHelper(i, true);
        if (!this.mGroupCursorHelper.isValid() || childrenCursorHelper == null) {
            return 0;
        }
        return childrenCursorHelper.getCount();
    }

    protected abstract Cursor getChildrenCursor(Cursor cursor);

    MyCursorHelper getChildrenCursorHelper(int i, boolean z) {
        MyCursorHelper myCursorHelper;
        synchronized (this) {
            MyCursorHelper myCursorHelper2 = this.mChildrenCursorHelpers.get(i);
            myCursorHelper = myCursorHelper2;
            if (myCursorHelper2 == null) {
                if (this.mGroupCursorHelper.moveTo(i) == null) {
                    myCursorHelper = null;
                } else {
                    myCursorHelper = new MyCursorHelper(getChildrenCursor(this.mGroupCursorHelper.getCursor()));
                    this.mChildrenCursorHelpers.put(i, myCursorHelper);
                }
            }
        }
        return myCursorHelper;
    }

    @Override // android.widget.CursorFilter.CursorFilterClient
    public Cursor getCursor() {
        return this.mGroupCursorHelper.getCursor();
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.mCursorFilter == null) {
            this.mCursorFilter = new CursorFilter(this);
        }
        return this.mCursorFilter;
    }

    public FilterQueryProvider getFilterQueryProvider() {
        return this.mFilterQueryProvider;
    }

    @Override // android.widget.ExpandableListAdapter
    public Cursor getGroup(int i) {
        return this.mGroupCursorHelper.moveTo(i);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.mGroupCursorHelper.getCount();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i) {
        return this.mGroupCursorHelper.getId(i);
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        Cursor moveTo = this.mGroupCursorHelper.moveTo(i);
        if (moveTo == null) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (view == null) {
            view = newGroupView(this.mContext, moveTo, z, viewGroup);
        }
        bindGroupView(view, this.mContext, moveTo, z);
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    protected abstract View newChildView(Context context, Cursor cursor, boolean z, ViewGroup viewGroup);

    protected abstract View newGroupView(Context context, Cursor cursor, boolean z, ViewGroup viewGroup);

    @Override // android.widget.BaseExpandableListAdapter
    public void notifyDataSetChanged() {
        notifyDataSetChanged(true);
    }

    public void notifyDataSetChanged(boolean z) {
        if (z) {
            releaseCursorHelpers();
        }
        super.notifyDataSetChanged();
    }

    @Override // android.widget.BaseExpandableListAdapter
    public void notifyDataSetInvalidated() {
        releaseCursorHelpers();
        super.notifyDataSetInvalidated();
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.ExpandableListAdapter
    public void onGroupCollapsed(int i) {
        deactivateChildrenCursorHelper(i);
    }

    @Override // android.widget.CursorFilter.CursorFilterClient
    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        return this.mFilterQueryProvider != null ? this.mFilterQueryProvider.runQuery(charSequence) : this.mGroupCursorHelper.getCursor();
    }

    public void setChildrenCursor(int i, Cursor cursor) {
        getChildrenCursorHelper(i, false).changeCursor(cursor, false);
    }

    public void setFilterQueryProvider(FilterQueryProvider filterQueryProvider) {
        this.mFilterQueryProvider = filterQueryProvider;
    }

    public void setGroupCursor(Cursor cursor) {
        this.mGroupCursorHelper.changeCursor(cursor, false);
    }
}
