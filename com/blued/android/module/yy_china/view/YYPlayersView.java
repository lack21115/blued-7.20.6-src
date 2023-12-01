package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.YYPlayerAdapter;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYPlayersView.class */
public class YYPlayersView extends LinearLayout {
    private TextView a;
    private RecyclerView b;
    private YYPlayerAdapter c;

    public YYPlayersView(Context context) {
        super(context);
        a();
    }

    public YYPlayersView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public YYPlayersView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.yy_set_time_view, (ViewGroup) this, true);
        this.a = (TextView) findViewById(R.id.tv_time_title);
        this.b = findViewById(R.id.rv_times_lsit);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.b.setLayoutManager(linearLayoutManager);
        YYPlayerAdapter yYPlayerAdapter = new YYPlayerAdapter();
        this.c = yYPlayerAdapter;
        this.b.setAdapter(yYPlayerAdapter);
    }

    public void setMarginTop(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
        if (i >= 0) {
            layoutParams.topMargin = i;
        }
    }

    public void setOnClickTimeItemListener(BaseQuickAdapter.OnItemClickListener onItemClickListener) {
        this.c.setOnItemClickListener(onItemClickListener);
    }

    public void setPlayerList(List<YYSeatMemberModel> list) {
        this.c.setNewData(list);
    }

    public void setPlayerTitle(String str) {
        this.a.setText(str);
    }
}
