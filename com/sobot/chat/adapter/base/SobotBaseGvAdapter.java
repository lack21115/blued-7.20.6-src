package com.sobot.chat.adapter.base;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sobot.chat.utils.ResourceUtils;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/base/SobotBaseGvAdapter.class */
public abstract class SobotBaseGvAdapter<T> extends SobotBaseAdapter {
    protected LayoutInflater mInflater;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/base/SobotBaseGvAdapter$BaseViewHolder.class */
    public static abstract class BaseViewHolder<T> {
        protected Context mContext;
        protected View mItemView;

        public BaseViewHolder(Context context, View view) {
            this.mContext = context;
            this.mItemView = view;
        }

        public abstract void bindData(T t, int i);
    }

    public SobotBaseGvAdapter(Context context, List<T> list) {
        super(context, list);
        this.mInflater = LayoutInflater.from(context);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [int[], int[][]] */
    protected ColorStateList createColorStateList(int i, int i2, int i3, int i4) {
        return new ColorStateList(new int[]{new int[]{R.attr.state_pressed, R.attr.state_enabled}, new int[]{R.attr.state_enabled, R.attr.state_focused}, new int[]{R.attr.state_enabled}, new int[]{R.attr.state_focused}, new int[]{R.attr.state_window_focused}, new int[0]}, new int[]{i2, i3, i, i3, i4, i});
    }

    protected abstract String getContentLayoutName();

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        BaseViewHolder baseViewHolder;
        if (view == null) {
            view = this.mInflater.inflate(ResourceUtils.getResLayoutId(this.context, getContentLayoutName()), (ViewGroup) null);
            baseViewHolder = getViewHolder(this.context, view);
            view.setTag(baseViewHolder);
        } else {
            baseViewHolder = (BaseViewHolder) view.getTag();
        }
        baseViewHolder.bindData(this.list.get(i), i);
        return view;
    }

    protected abstract BaseViewHolder getViewHolder(Context context, View view);
}
