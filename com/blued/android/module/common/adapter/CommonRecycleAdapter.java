package com.blued.android.module.common.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adapter/CommonRecycleAdapter.class */
public abstract class CommonRecycleAdapter<T> extends RecyclerView.Adapter<CommonAdapterHolder> {
    public final List<T> dataList = new ArrayList();
    protected LayoutInflater layoutInflater;
    public Context mContext;
    protected IRequestHost requestHost;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adapter/CommonRecycleAdapter$CommonAdapterHolder.class */
    public static class CommonAdapterHolder extends RecyclerView.ViewHolder {
        private SparseArray<View> a;
        private View b;
        private IRequestHost c;

        public CommonAdapterHolder(View view, IRequestHost iRequestHost) {
            super(view);
            this.b = view;
            this.a = new SparseArray<>();
            this.c = iRequestHost;
        }

        public View a() {
            return this.b;
        }

        /* JADX WARN: Incorrect return type in method signature: <T:Landroid/view/View;>(I)TT; */
        public View a(int i) {
            View view = this.a.get(i);
            View view2 = view;
            if (view == null) {
                view2 = this.b.findViewById(i);
                this.a.put(i, view2);
            }
            return view2;
        }

        public CommonAdapterHolder a(int i, int i2) {
            TextView textView = (TextView) a(i);
            if (textView != null) {
                textView.setTextColor(i2);
            }
            return this;
        }

        public CommonAdapterHolder a(int i, int i2, String str) {
            TextView textView = (TextView) a(i);
            if (textView != null) {
                textView.setText(str);
                textView.setTextColor(i2);
            }
            return this;
        }

        public CommonAdapterHolder a(int i, View.OnClickListener onClickListener) {
            View a = a(i);
            if (a != null) {
                a.setOnClickListener(onClickListener);
            }
            return this;
        }

        public CommonAdapterHolder a(int i, String str) {
            TextView textView = (TextView) a(i);
            if (textView != null) {
                textView.setText(str);
            }
            return this;
        }

        public CommonAdapterHolder a(int i, String str, float f, int i2) {
            ImageView imageView = (ImageView) a(i);
            if (imageView != null) {
                if (f <= 0.0f) {
                    ImageLoader.a(this.c, str).b(i2).a(imageView);
                    return this;
                }
                ImageLoader.a(this.c, str).b(i2).a(f).a(imageView);
            }
            return this;
        }

        public CommonAdapterHolder a(int i, String str, int i2) {
            return a(i, str, 0.0f, i2);
        }

        public CommonAdapterHolder b(int i, int i2) {
            View a = a(i);
            if (a != null) {
                a.setVisibility(i2);
            }
            return this;
        }

        public CommonAdapterHolder b(int i, String str) {
            return a(i, str, 0);
        }

        public CommonAdapterHolder c(int i, int i2) {
            View a = a(i);
            if (a != null) {
                a.setBackgroundResource(i2);
            }
            return this;
        }

        public CommonAdapterHolder c(int i, String str) {
            ImageView imageView = (ImageView) a(i);
            if (imageView != null) {
                ImageLoader.a(this.c, str).f(imageView.hashCode()).g(-1).a(imageView);
            }
            return this;
        }

        public CommonAdapterHolder d(int i, int i2) {
            ImageView imageView = (ImageView) a(i);
            if (imageView != null) {
                imageView.setImageResource(i2);
            }
            return this;
        }
    }

    public CommonRecycleAdapter(Context context) {
        this.mContext = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public CommonRecycleAdapter(Context context, IRequestHost iRequestHost) {
        this.mContext = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.requestHost = iRequestHost;
    }

    public void addDataAndNotify(List<T> list) {
        if (list != null) {
            this.dataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    public List<T> getDataList() {
        return this.dataList;
    }

    public int getItemCount() {
        return this.dataList.size();
    }

    public int getItemViewType(int i) {
        return super.getItemViewType(i);
    }

    protected abstract int getLayoutId(int i);

    public void onBindViewHolder(CommonAdapterHolder commonAdapterHolder, int i) {
        if (this.dataList.size() < i) {
            return;
        }
        onBindViewHolderData(this.dataList.get(i), i, commonAdapterHolder);
    }

    protected abstract void onBindViewHolderData(T t, int i, CommonAdapterHolder commonAdapterHolder);

    public CommonAdapterHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new CommonAdapterHolder(this.layoutInflater.inflate(getLayoutId(i), viewGroup, false), this.requestHost);
    }

    public void setDataAndNotify(List<T> list) {
        if (list != null) {
            this.dataList.clear();
            this.dataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void updateItemAndNotify(int i, T t) {
        if (i < 0 || i >= this.dataList.size()) {
            return;
        }
        this.dataList.set(i, t);
        notifyItemChanged(i);
    }
}
