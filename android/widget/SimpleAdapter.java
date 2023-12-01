package android.widget;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: source-4181928-dex2jar.jar:android/widget/SimpleAdapter.class */
public class SimpleAdapter extends BaseAdapter implements Filterable {
    private List<? extends Map<String, ?>> mData;
    private int mDropDownResource;
    private SimpleFilter mFilter;
    private String[] mFrom;
    private LayoutInflater mInflater;
    private int mResource;
    private int[] mTo;
    private ArrayList<Map<String, ?>> mUnfilteredData;
    private ViewBinder mViewBinder;

    /* loaded from: source-4181928-dex2jar.jar:android/widget/SimpleAdapter$SimpleFilter.class */
    private class SimpleFilter extends Filter {
        private SimpleFilter() {
        }

        @Override // android.widget.Filter
        protected Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (SimpleAdapter.this.mUnfilteredData == null) {
                SimpleAdapter.this.mUnfilteredData = new ArrayList(SimpleAdapter.this.mData);
            }
            if (charSequence == null || charSequence.length() == 0) {
                ArrayList arrayList = SimpleAdapter.this.mUnfilteredData;
                filterResults.values = arrayList;
                filterResults.count = arrayList.size();
                return filterResults;
            }
            String lowerCase = charSequence.toString().toLowerCase();
            ArrayList arrayList2 = SimpleAdapter.this.mUnfilteredData;
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
                Map map = (Map) arrayList2.get(i2);
                if (map != null) {
                    int length = SimpleAdapter.this.mTo.length;
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 < length) {
                            String[] split = ((String) map.get(SimpleAdapter.this.mFrom[i4])).split(" ");
                            int length2 = split.length;
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= length2) {
                                    break;
                                } else if (split[i6].toLowerCase().startsWith(lowerCase)) {
                                    arrayList3.add(map);
                                    break;
                                } else {
                                    i5 = i6 + 1;
                                }
                            }
                            i3 = i4 + 1;
                        }
                    }
                }
                i = i2 + 1;
            }
        }

        @Override // android.widget.Filter
        protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            SimpleAdapter.this.mData = (List) filterResults.values;
            if (filterResults.count > 0) {
                SimpleAdapter.this.notifyDataSetChanged();
            } else {
                SimpleAdapter.this.notifyDataSetInvalidated();
            }
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/SimpleAdapter$ViewBinder.class */
    public interface ViewBinder {
        boolean setViewValue(View view, Object obj, String str);
    }

    public SimpleAdapter(Context context, List<? extends Map<String, ?>> list, int i, String[] strArr, int[] iArr) {
        this.mData = list;
        this.mDropDownResource = i;
        this.mResource = i;
        this.mFrom = strArr;
        this.mTo = iArr;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    private void bindView(int i, View view) {
        Map<String, ?> map = this.mData.get(i);
        if (map == null) {
            return;
        }
        ViewBinder viewBinder = this.mViewBinder;
        String[] strArr = this.mFrom;
        int[] iArr = this.mTo;
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            View findViewById = view.findViewById(iArr[i3]);
            if (findViewById != null) {
                Object obj = map.get(strArr[i3]);
                String obj2 = obj == null ? "" : obj.toString();
                String str = obj2;
                if (obj2 == null) {
                    str = "";
                }
                boolean z = false;
                if (viewBinder != null) {
                    z = viewBinder.setViewValue(findViewById, obj, str);
                }
                if (z) {
                    continue;
                } else if (findViewById instanceof Checkable) {
                    if (obj instanceof Boolean) {
                        ((Checkable) findViewById).setChecked(((Boolean) obj).booleanValue());
                    } else if (!(findViewById instanceof TextView)) {
                        throw new IllegalStateException(findViewById.getClass().getName() + " should be bound to a Boolean, not a " + (obj == null ? "<unknown type>" : obj.getClass()));
                    } else {
                        setViewText((TextView) findViewById, str);
                    }
                } else if (findViewById instanceof TextView) {
                    setViewText((TextView) findViewById, str);
                } else if (!(findViewById instanceof ImageView)) {
                    throw new IllegalStateException(findViewById.getClass().getName() + " is not a  view that can be bounds by this SimpleAdapter");
                } else {
                    if (obj instanceof Integer) {
                        setViewImage((ImageView) findViewById, ((Integer) obj).intValue());
                    } else {
                        setViewImage((ImageView) findViewById, str);
                    }
                }
            }
            i2 = i3 + 1;
        }
    }

    private View createViewFromResource(int i, View view, ViewGroup viewGroup, int i2) {
        if (view == null) {
            view = this.mInflater.inflate(i2, viewGroup, false);
        }
        bindView(i, view);
        return view;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mData.size();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return createViewFromResource(i, view, viewGroup, this.mDropDownResource);
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.mFilter == null) {
            this.mFilter = new SimpleFilter();
        }
        return this.mFilter;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.mData.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return createViewFromResource(i, view, viewGroup, this.mResource);
    }

    public ViewBinder getViewBinder() {
        return this.mViewBinder;
    }

    public void setDropDownViewResource(int i) {
        this.mDropDownResource = i;
    }

    public void setViewBinder(ViewBinder viewBinder) {
        this.mViewBinder = viewBinder;
    }

    public void setViewImage(ImageView imageView, int i) {
        imageView.setImageResource(i);
    }

    public void setViewImage(ImageView imageView, String str) {
        try {
            imageView.setImageResource(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            imageView.setImageURI(Uri.parse(str));
        }
    }

    public void setViewText(TextView textView, String str) {
        textView.setText(str);
    }
}
