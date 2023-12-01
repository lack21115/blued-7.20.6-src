package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.user.model.PictureTabModel;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/PictureTabAdapter.class */
public class PictureTabAdapter extends RecyclerView.Adapter<MyViewHolder> implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f20054a;
    private MyItemClickListener b;

    /* renamed from: c  reason: collision with root package name */
    private List<PictureTabModel> f20055c;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/PictureTabAdapter$MyItemClickListener.class */
    public interface MyItemClickListener {
        void a(View view, int i);
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/PictureTabAdapter$MyViewHolder.class */
    public class MyViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f20056a;
        public TextView b;

        public MyViewHolder(View view) {
            super(view);
            this.b = (TextView) view.findViewById(R.id.tv_tab_name);
            this.f20056a = view.findViewById(2131363911);
        }
    }

    public PictureTabAdapter(Context context, List<PictureTabModel> list) {
        this.f20054a = context;
        this.f20055c = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(this.f20054a).inflate(R.layout.item_grid_picture_tab, viewGroup, false));
        myViewHolder.f20056a.setOnClickListener(this);
        return myViewHolder;
    }

    public void a(MyItemClickListener myItemClickListener) {
        this.b = myItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        PictureTabModel pictureTabModel = this.f20055c.get(i);
        if (myViewHolder == null || pictureTabModel == null) {
            return;
        }
        myViewHolder.b.setText(pictureTabModel.name);
        myViewHolder.f20056a.setTag(Integer.valueOf(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<PictureTabModel> list = this.f20055c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        MyItemClickListener myItemClickListener = this.b;
        if (myItemClickListener != null) {
            myItemClickListener.a(view, ((Integer) view.getTag()).intValue());
        }
    }
}
