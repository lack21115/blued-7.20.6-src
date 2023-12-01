package com.sobot.chat.widget.horizontalgridpage;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/horizontalgridpage/PageGridAdapter.class */
public class PageGridAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private PageCallBack callBack;
    private int column;
    private ArrayList<T> data;
    private int itemWidth;
    private int pageMargin;
    private int row;
    private ZhiChiMessageBase zhiChiMessageBase;

    public PageGridAdapter(PageCallBack pageCallBack) {
        this(null, pageCallBack);
    }

    public PageGridAdapter(ArrayList<T> arrayList, PageCallBack pageCallBack) {
        this.data = convert(arrayList);
        this.callBack = pageCallBack;
    }

    private ArrayList<T> convert(ArrayList<T> arrayList) {
        if (arrayList == null) {
            return new ArrayList<>();
        }
        ArrayList<T> arrayList2 = new ArrayList<>();
        int i = this.row * this.column;
        int ceil = (int) Math.ceil(arrayList.size() / i);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= ceil) {
                return arrayList2;
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < this.column) {
                    int i6 = 0;
                    while (true) {
                        int i7 = i6;
                        if (i7 < this.row) {
                            int i8 = (this.column * i7) + i5 + (i3 * i);
                            if (i8 < arrayList.size()) {
                                arrayList2.add(arrayList.get(i8));
                            } else {
                                arrayList2.add(null);
                            }
                            i6 = i7 + 1;
                        }
                    }
                    i4 = i5 + 1;
                }
            }
            i2 = i3 + 1;
        }
    }

    private void setListener(RecyclerView.ViewHolder viewHolder) {
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.widget.horizontalgridpage.PageGridAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PageGridAdapter.this.callBack.onItemClickListener(view, ((Integer) view.getTag()).intValue());
            }
        });
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.sobot.chat.widget.horizontalgridpage.PageGridAdapter.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                PageGridAdapter.this.callBack.onItemLongClickListener(view, ((Integer) view.getTag()).intValue());
                return true;
            }
        });
    }

    public ArrayList<T> getData() {
        return this.data;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    public ZhiChiMessageBase getZhiChiMessageBaseData() {
        return this.zhiChiMessageBase;
    }

    public void init(PageBuilder pageBuilder) {
        this.row = pageBuilder.getGrid()[0];
        this.column = pageBuilder.getGrid()[1];
        this.pageMargin = pageBuilder.getPageMargin();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int i2 = this.column;
        if (i2 == 1) {
            viewHolder.itemView.getLayoutParams().width = this.itemWidth + (this.pageMargin * 2);
            View view = viewHolder.itemView;
            int i3 = this.pageMargin;
            view.setPadding(i3, 0, i3, 0);
        } else {
            int i4 = this.row;
            int i5 = i % (i4 * i2);
            if (i5 < i4) {
                viewHolder.itemView.getLayoutParams().width = this.itemWidth + this.pageMargin;
                viewHolder.itemView.setPadding(this.pageMargin, 0, 0, 0);
            } else if (i5 >= (i2 * i4) - i4) {
                viewHolder.itemView.getLayoutParams().width = this.itemWidth + this.pageMargin;
                viewHolder.itemView.setPadding(0, 0, this.pageMargin, 0);
            } else {
                viewHolder.itemView.getLayoutParams().width = this.itemWidth;
                viewHolder.itemView.setPadding(0, 0, 0, 0);
            }
        }
        viewHolder.itemView.setTag(Integer.valueOf(i));
        setListener(viewHolder);
        if (i >= this.data.size() || this.data.get(i) == null) {
            viewHolder.itemView.setVisibility(8);
            return;
        }
        viewHolder.itemView.setVisibility(0);
        this.callBack.onBindViewHolder(viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.itemWidth <= 0) {
            this.itemWidth = (viewGroup.getMeasuredWidth() - (this.pageMargin * 2)) / this.column;
        }
        RecyclerView.ViewHolder onCreateViewHolder = this.callBack.onCreateViewHolder(viewGroup, i);
        onCreateViewHolder.itemView.measure(0, 0);
        onCreateViewHolder.itemView.getLayoutParams().width = this.itemWidth;
        onCreateViewHolder.itemView.getLayoutParams().height = onCreateViewHolder.itemView.getMeasuredHeight();
        return onCreateViewHolder;
    }

    public void setData(ArrayList<T> arrayList) {
        this.data.clear();
        this.data.addAll(convert(arrayList));
        notifyDataSetChanged();
    }

    public void setZhiChiMessageBaseData(ZhiChiMessageBase zhiChiMessageBase) {
        this.zhiChiMessageBase = zhiChiMessageBase;
    }
}
