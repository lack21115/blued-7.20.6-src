package com.soft.blued.ui.msg;

import android.content.Context;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.xpop.core.AttachPopupView;
import com.soft.blued.R;
import com.soft.blued.ui.msg.adapter.ServiceMenuPopAdapter;
import com.soft.blued.ui.user.model.ServiceMenuModel;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/ServiceMenuPopWindow.class */
public class ServiceMenuPopWindow extends AttachPopupView {
    private Context t;
    private RecyclerView u;
    private ServiceMenuPopAdapter v;
    private long w;
    private List<ServiceMenuModel> x;
    private int y;

    public ServiceMenuPopWindow(Context context) {
        super(context);
        this.t = context;
    }

    public void a(List<ServiceMenuModel> list, long j, int i) {
        this.w = j;
        this.x = list;
        this.y = i;
    }

    @Override // com.blued.android.framework.ui.xpop.core.AttachPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        CardView cardView = (CardView) findViewById(2131363153);
        if (BluedSkinUtils.c()) {
            cardView.setBackgroundColor(ContextCompat.getColor(this.t, 2131101699));
        } else {
            cardView.setBackgroundColor(ContextCompat.getColor(this.t, 2131101508));
        }
        ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        cardView.setLayoutParams(layoutParams);
        this.u = (RecyclerView) findViewById(2131369105);
        this.v = new ServiceMenuPopAdapter(this, this.y);
        this.u.setLayoutManager(new LinearLayoutManager(this.t));
        this.u.setAdapter(this.v);
        this.v.a(this.w);
        this.v.setNewData(this.x);
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.pop_service_menu_list;
    }
}
