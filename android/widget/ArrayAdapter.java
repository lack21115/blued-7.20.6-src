package android.widget;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: source-4181928-dex2jar.jar:android/widget/ArrayAdapter.class */
public class ArrayAdapter<T> extends BaseAdapter implements Filterable {
    private Context mContext;
    private int mDropDownResource;
    private ArrayAdapter<T>.ArrayFilter mFilter;
    private LayoutInflater mInflater;
    private List<T> mObjects;
    private ArrayList<T> mOriginalValues;
    private int mResource;
    private final Object mLock = new Object();
    private int mFieldId = 0;
    private boolean mNotifyOnChange = true;

    /* loaded from: source-4181928-dex2jar.jar:android/widget/ArrayAdapter$ArrayFilter.class */
    private class ArrayFilter extends Filter {
        private ArrayFilter() {
        }

        @Override // android.widget.Filter
        protected Filter.FilterResults performFiltering(CharSequence charSequence) {
            ArrayList arrayList;
            ArrayList arrayList2;
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (ArrayAdapter.this.mOriginalValues == null) {
                synchronized (ArrayAdapter.this.mLock) {
                    ArrayAdapter.this.mOriginalValues = new ArrayList(ArrayAdapter.this.mObjects);
                }
            }
            if (charSequence == null || charSequence.length() == 0) {
                synchronized (ArrayAdapter.this.mLock) {
                    arrayList = new ArrayList(ArrayAdapter.this.mOriginalValues);
                }
                filterResults.values = arrayList;
                filterResults.count = arrayList.size();
                return filterResults;
            }
            String lowerCase = charSequence.toString().toLowerCase();
            synchronized (ArrayAdapter.this.mLock) {
                arrayList2 = new ArrayList(ArrayAdapter.this.mOriginalValues);
            }
            int size = arrayList2.size();
            ArrayList arrayList3 = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    filterResults.values = arrayList3;
                    filterResults.count = arrayList3.size();
                    return filterResults;
                }
                Object obj = arrayList2.get(i2);
                String lowerCase2 = obj.toString().toLowerCase();
                if (lowerCase2.startsWith(lowerCase)) {
                    arrayList3.add(obj);
                } else {
                    String[] split = lowerCase2.split(" ");
                    int length = split.length;
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= length) {
                            break;
                        } else if (split[i4].startsWith(lowerCase)) {
                            arrayList3.add(obj);
                            break;
                        } else {
                            i3 = i4 + 1;
                        }
                    }
                }
                i = i2 + 1;
            }
        }

        @Override // android.widget.Filter
        protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            ArrayAdapter.this.mObjects = (List) filterResults.values;
            if (filterResults.count > 0) {
                ArrayAdapter.this.notifyDataSetChanged();
            } else {
                ArrayAdapter.this.notifyDataSetInvalidated();
            }
        }
    }

    public ArrayAdapter(Context context, int i) {
        init(context, i, 0, new ArrayList());
    }

    public ArrayAdapter(Context context, int i, int i2) {
        init(context, i, i2, new ArrayList());
    }

    public ArrayAdapter(Context context, int i, int i2, List<T> list) {
        init(context, i, i2, list);
    }

    public ArrayAdapter(Context context, int i, int i2, T[] tArr) {
        init(context, i, i2, Arrays.asList(tArr));
    }

    public ArrayAdapter(Context context, int i, List<T> list) {
        init(context, i, 0, list);
    }

    public ArrayAdapter(Context context, int i, T[] tArr) {
        init(context, i, 0, Arrays.asList(tArr));
    }

    public static ArrayAdapter<CharSequence> createFromResource(Context context, int i, int i2) {
        return new ArrayAdapter<>(context, i2, context.getResources().getTextArray(i));
    }

    private View createViewFromResource(int i, View view, ViewGroup viewGroup, int i2) {
        if (view == null) {
            view = this.mInflater.inflate(i2, viewGroup, false);
        }
        try {
            TextView textView = this.mFieldId == 0 ? (TextView) view : (TextView) view.findViewById(this.mFieldId);
            T item = getItem(i);
            if (item instanceof CharSequence) {
                textView.setText((CharSequence) item);
                return view;
            }
            textView.setText(item.toString());
            return view;
        } catch (ClassCastException e) {
            Log.e("ArrayAdapter", "You must supply a resource ID for a TextView");
            throw new IllegalStateException("ArrayAdapter requires the resource ID to be a TextView", e);
        }
    }

    private void init(Context context, int i, int i2, List<T> list) {
        this.mContext = context;
        this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mDropDownResource = i;
        this.mResource = i;
        this.mObjects = list;
        this.mFieldId = i2;
    }

    public void add(T t) {
        synchronized (this.mLock) {
            if (this.mOriginalValues != null) {
                this.mOriginalValues.add(t);
            } else {
                this.mObjects.add(t);
            }
        }
        if (this.mNotifyOnChange) {
            notifyDataSetChanged();
        }
    }

    public void addAll(Collection<? extends T> collection) {
        synchronized (this.mLock) {
            if (this.mOriginalValues != null) {
                this.mOriginalValues.addAll(collection);
            } else {
                this.mObjects.addAll(collection);
            }
        }
        if (this.mNotifyOnChange) {
            notifyDataSetChanged();
        }
    }

    public void addAll(T... tArr) {
        synchronized (this.mLock) {
            if (this.mOriginalValues != null) {
                Collections.addAll(this.mOriginalValues, tArr);
            } else {
                Collections.addAll(this.mObjects, tArr);
            }
        }
        if (this.mNotifyOnChange) {
            notifyDataSetChanged();
        }
    }

    public void clear() {
        synchronized (this.mLock) {
            if (this.mOriginalValues != null) {
                this.mOriginalValues.clear();
            } else {
                this.mObjects.clear();
            }
        }
        if (this.mNotifyOnChange) {
            notifyDataSetChanged();
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mObjects.size();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return createViewFromResource(i, view, viewGroup, this.mDropDownResource);
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.mFilter == null) {
            this.mFilter = new ArrayFilter();
        }
        return this.mFilter;
    }

    @Override // android.widget.Adapter
    public T getItem(int i) {
        return this.mObjects.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public int getPosition(T t) {
        return this.mObjects.indexOf(t);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return createViewFromResource(i, view, viewGroup, this.mResource);
    }

    public void insert(T t, int i) {
        synchronized (this.mLock) {
            if (this.mOriginalValues != null) {
                this.mOriginalValues.add(i, t);
            } else {
                this.mObjects.add(i, t);
            }
        }
        if (this.mNotifyOnChange) {
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.mNotifyOnChange = true;
    }

    public void remove(T t) {
        synchronized (this.mLock) {
            if (this.mOriginalValues != null) {
                this.mOriginalValues.remove(t);
            } else {
                this.mObjects.remove(t);
            }
        }
        if (this.mNotifyOnChange) {
            notifyDataSetChanged();
        }
    }

    public void setDropDownViewResource(int i) {
        this.mDropDownResource = i;
    }

    public void setNotifyOnChange(boolean z) {
        this.mNotifyOnChange = z;
    }

    public void sort(Comparator<? super T> comparator) {
        synchronized (this.mLock) {
            if (this.mOriginalValues != null) {
                Collections.sort(this.mOriginalValues, comparator);
            } else {
                Collections.sort(this.mObjects, comparator);
            }
        }
        if (this.mNotifyOnChange) {
            notifyDataSetChanged();
        }
    }
}
