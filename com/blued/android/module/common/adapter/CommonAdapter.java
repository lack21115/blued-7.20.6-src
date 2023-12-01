package com.blued.android.module.common.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adapter/CommonAdapter.class */
public abstract class CommonAdapter<T> extends BaseAdapter {
    public Context a;
    protected final List<T> b;
    public MultiItemTypeSupport<T> c;
    private int d;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adapter/CommonAdapter$ViewHolder.class */
    public static class ViewHolder {
        public int a;
        public int b;
        public int c;
        private SparseArray<View> d;
        private View e;

        private ViewHolder(Context context, ViewGroup viewGroup, int i, int i2, int i3) {
            this.d = new SparseArray<>();
            View inflate = LayoutInflater.from(context).inflate(i, viewGroup, false);
            this.e = inflate;
            this.a = i;
            inflate.setTag(this);
            this.b = i2;
            this.c = i3;
        }

        public View a() {
            return this.e;
        }

        /* JADX WARN: Incorrect return type in method signature: <T:Landroid/view/View;>(I)TT; */
        public View a(int i) {
            View view = this.d.get(i);
            View view2 = view;
            if (view == null) {
                view2 = this.e.findViewById(i);
                this.d.put(i, view2);
            }
            return view2;
        }

        public ViewHolder a(int i, int i2) {
            TextView textView = (TextView) a(i);
            if (textView != null) {
                textView.setTextColor(i2);
            }
            return this;
        }

        public ViewHolder a(int i, int i2, String str) {
            TextView textView = (TextView) a(i);
            if (textView != null) {
                textView.setText(str);
                textView.setTextColor(i2);
            }
            return this;
        }

        public ViewHolder a(int i, View.OnClickListener onClickListener) {
            View a = a(i);
            if (a != null) {
                a.setOnClickListener(onClickListener);
            }
            return this;
        }

        public ViewHolder a(int i, String str) {
            TextView textView = (TextView) a(i);
            if (textView != null) {
                textView.setText(str);
            }
            return this;
        }

        public ViewHolder a(int i, String str, int i2) {
            ImageView imageView = (ImageView) a(i);
            if (imageView != null) {
                ImageLoader.a((IRequestHost) null, str).b(R.drawable.defaultpicture).a(i2).a(imageView);
            }
            return this;
        }

        public ViewHolder a(View.OnClickListener onClickListener) {
            if (a() != null) {
                a().setOnClickListener(onClickListener);
            }
            return this;
        }

        public ViewHolder a(ImageView imageView, String str) {
            if (imageView != null) {
                ImageLoader.a((IRequestHost) null, str).b(R.drawable.defaultpicture).a(imageView);
            }
            return this;
        }

        public ViewHolder b(int i) {
            View view = this.e;
            if (view != null) {
                view.setBackgroundResource(i);
            }
            return this;
        }

        public ViewHolder b(int i, int i2) {
            View a = a(i);
            if (a != null) {
                a.setVisibility(i2);
            }
            return this;
        }

        public ViewHolder b(int i, String str) {
            ImageView imageView = (ImageView) a(i);
            if (imageView != null) {
                ImageLoader.a((IRequestHost) null, str).f(imageView.hashCode()).g(-1).a(imageView);
            }
            return this;
        }

        public ViewHolder c(int i, int i2) {
            View a = a(i);
            if (a != null) {
                a.setBackgroundResource(i2);
            }
            return this;
        }

        public ViewHolder c(int i, String str) {
            return a((ImageView) a(i), str);
        }

        public ViewHolder d(int i, String str) {
            ImageView imageView = (ImageView) a(i);
            if (imageView != null) {
                ImageLoader.a((IRequestHost) null, str).b(R.drawable.user_bg_round).c().a(imageView);
            }
            return this;
        }

        public ViewHolder e(int i, String str) {
            ImageView imageView = (ImageView) a(i);
            if (imageView != null) {
                ImageLoader.a((IRequestHost) null, str).b(R.drawable.defaultpicture).c().a(imageView);
            }
            return this;
        }
    }

    public CommonAdapter(int i) {
        this.b = new ArrayList();
        this.a = AppInfo.d();
        this.d = i;
    }

    public CommonAdapter(List<T> list, int i) {
        this(i);
        if (list != null) {
            this.b.addAll(list);
        }
    }

    public CommonAdapter(List<T> list, MultiItemTypeSupport<T> multiItemTypeSupport) {
        this(list, 0);
        this.c = multiItemTypeSupport;
    }

    public ViewHolder a(int i, View view, ViewGroup viewGroup, int i2) {
        MultiItemTypeSupport<T> multiItemTypeSupport = this.c;
        return multiItemTypeSupport != null ? a(this.a, view, viewGroup, multiItemTypeSupport.a(i, this.b.get(i)), i, i2) : a(this.a, view, viewGroup, this.d, i2, i);
    }

    ViewHolder a(Context context, View view, ViewGroup viewGroup, int i, int i2, int i3) {
        if (view == null) {
            return new ViewHolder(context, viewGroup, i, i2, i3);
        }
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        if (viewHolder.a != i) {
            return new ViewHolder(context, viewGroup, i, i2, i3);
        }
        viewHolder.c = i3;
        return viewHolder;
    }

    public List<T> a() {
        return Collections.unmodifiableList(this.b);
    }

    public abstract void a(ViewHolder viewHolder, T t, int i);

    public void a(List list) {
        if (list == null) {
            return;
        }
        this.b.clear();
        this.b.addAll(list);
        notifyDataSetChanged();
    }

    public void b(List<T> list) {
        if (list == null) {
            return;
        }
        this.b.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public T getItem(int i) {
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.c == null) {
            return i >= this.b.size() ? 0 : 1;
        } else if (i >= this.b.size()) {
            return 0;
        } else {
            return this.c.b(i, this.b.get(i));
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder a = a(i, view, viewGroup, getCount());
        a(a, getItem(i), i);
        return a.a();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        MultiItemTypeSupport<T> multiItemTypeSupport = this.c;
        if (multiItemTypeSupport != null) {
            return multiItemTypeSupport.a();
        }
        return 1;
    }
}
