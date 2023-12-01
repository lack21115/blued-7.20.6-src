package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import androidx.cursoradapter.widget.CursorFilter;

/* loaded from: source-8756600-dex2jar.jar:androidx/cursoradapter/widget/CursorAdapter.class */
public abstract class CursorAdapter extends BaseAdapter implements Filterable, CursorFilter.CursorFilterClient {
    @Deprecated
    public static final int FLAG_AUTO_REQUERY = 1;
    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2;

    /* renamed from: a  reason: collision with root package name */
    protected boolean f2766a;
    protected boolean b;

    /* renamed from: c  reason: collision with root package name */
    protected Cursor f2767c;
    protected Context d;
    protected int e;
    protected ChangeObserver f;
    protected DataSetObserver g;
    protected CursorFilter h;
    protected FilterQueryProvider i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/cursoradapter/widget/CursorAdapter$ChangeObserver.class */
    public class ChangeObserver extends ContentObserver {
        ChangeObserver() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            CursorAdapter.this.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/cursoradapter/widget/CursorAdapter$MyDataSetObserver.class */
    public class MyDataSetObserver extends DataSetObserver {
        MyDataSetObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            CursorAdapter.this.f2766a = true;
            CursorAdapter.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            CursorAdapter.this.f2766a = false;
            CursorAdapter.this.notifyDataSetInvalidated();
        }
    }

    @Deprecated
    public CursorAdapter(Context context, Cursor cursor) {
        a(context, cursor, 1);
    }

    public CursorAdapter(Context context, Cursor cursor, int i) {
        a(context, cursor, i);
    }

    public CursorAdapter(Context context, Cursor cursor, boolean z) {
        a(context, cursor, z ? 1 : 2);
    }

    protected void a() {
        Cursor cursor;
        if (!this.b || (cursor = this.f2767c) == null || cursor.isClosed()) {
            return;
        }
        this.f2766a = this.f2767c.requery();
    }

    void a(Context context, Cursor cursor, int i) {
        boolean z = false;
        if ((i & 1) == 1) {
            i |= 2;
            this.b = true;
        } else {
            this.b = false;
        }
        if (cursor != null) {
            z = true;
        }
        this.f2767c = cursor;
        this.f2766a = z;
        this.d = context;
        this.e = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.f = new ChangeObserver();
            this.g = new MyDataSetObserver();
        } else {
            this.f = null;
            this.g = null;
        }
        if (z) {
            ChangeObserver changeObserver = this.f;
            if (changeObserver != null) {
                cursor.registerContentObserver(changeObserver);
            }
            DataSetObserver dataSetObserver = this.g;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract void bindView(View view, Context context, Cursor cursor);

    public void changeCursor(Cursor cursor) {
        Cursor swapCursor = swapCursor(cursor);
        if (swapCursor != null) {
            swapCursor.close();
        }
    }

    public CharSequence convertToString(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f2766a || (cursor = this.f2767c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public Cursor getCursor() {
        return this.f2767c;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (this.f2766a) {
            this.f2767c.moveToPosition(i);
            View view2 = view;
            if (view == null) {
                view2 = newDropDownView(this.d, this.f2767c, viewGroup);
            }
            bindView(view2, this.d, this.f2767c);
            return view2;
        }
        return null;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.h == null) {
            this.h = new CursorFilter(this);
        }
        return this.h;
    }

    public FilterQueryProvider getFilterQueryProvider() {
        return this.i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Cursor cursor;
        if (!this.f2766a || (cursor = this.f2767c) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.f2767c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        Cursor cursor;
        if (this.f2766a && (cursor = this.f2767c) != null && cursor.moveToPosition(i)) {
            return this.f2767c.getLong(this.e);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.f2766a) {
            if (!this.f2767c.moveToPosition(i)) {
                throw new IllegalStateException("couldn't move cursor to position " + i);
            }
            View view2 = view;
            if (view == null) {
                view2 = newView(this.d, this.f2767c, viewGroup);
            }
            bindView(view2, this.d, this.f2767c);
            return view2;
        }
        throw new IllegalStateException("this should only be called when the cursor is valid");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return newView(context, cursor, viewGroup);
    }

    public abstract View newView(Context context, Cursor cursor, ViewGroup viewGroup);

    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        FilterQueryProvider filterQueryProvider = this.i;
        return filterQueryProvider != null ? filterQueryProvider.runQuery(charSequence) : this.f2767c;
    }

    public void setFilterQueryProvider(FilterQueryProvider filterQueryProvider) {
        this.i = filterQueryProvider;
    }

    public Cursor swapCursor(Cursor cursor) {
        Cursor cursor2 = this.f2767c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            ChangeObserver changeObserver = this.f;
            if (changeObserver != null) {
                cursor2.unregisterContentObserver(changeObserver);
            }
            DataSetObserver dataSetObserver = this.g;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f2767c = cursor;
        if (cursor == null) {
            this.e = -1;
            this.f2766a = false;
            notifyDataSetInvalidated();
            return cursor2;
        }
        ChangeObserver changeObserver2 = this.f;
        if (changeObserver2 != null) {
            cursor.registerContentObserver(changeObserver2);
        }
        DataSetObserver dataSetObserver2 = this.g;
        if (dataSetObserver2 != null) {
            cursor.registerDataSetObserver(dataSetObserver2);
        }
        this.e = cursor.getColumnIndexOrThrow("_id");
        this.f2766a = true;
        notifyDataSetChanged();
        return cursor2;
    }
}
