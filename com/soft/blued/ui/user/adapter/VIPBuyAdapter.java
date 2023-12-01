package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.user.model.VIPBuyOption;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/VIPBuyAdapter.class */
public class VIPBuyAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public onGoodClick f33784a;
    private LayoutInflater b;

    /* renamed from: c  reason: collision with root package name */
    private List<VIPBuyOption> f33785c = new ArrayList();
    private Context d;
    private LoadOptions e;
    private int f;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/VIPBuyAdapter$ViewHolder.class */
    class ViewHolder {
        private TextView b;

        /* renamed from: c  reason: collision with root package name */
        private TextView f33787c;
        private TextView d;
        private ConstraintLayout e;
        private TextView f;
        private TextView g;

        private ViewHolder() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/VIPBuyAdapter$onGoodClick.class */
    public interface onGoodClick {
        void onclick(VIPBuyOption vIPBuyOption);
    }

    public VIPBuyAdapter(Context context, int i) {
        this.b = LayoutInflater.from(context);
        this.d = context;
        LoadOptions loadOptions = new LoadOptions();
        this.e = loadOptions;
        loadOptions.d = 2131231620;
        this.e.b = 2131231620;
        this.f = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i, VIPBuyOption vIPBuyOption, View view) {
        Tracker.onClick(view);
        InstantLog.a(this.f33785c.get(i).vip_grade, this.f33785c.get(i).money);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.f33785c.size()) {
                break;
            }
            this.f33785c.get(i3).choosen = false;
            i2 = i3 + 1;
        }
        vIPBuyOption.choosen = true;
        notifyDataSetChanged();
        onGoodClick ongoodclick = this.f33784a;
        if (ongoodclick != null) {
            ongoodclick.onclick(vIPBuyOption);
        }
    }

    public VIPBuyOption a() {
        VIPBuyOption vIPBuyOption = null;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f33785c.size()) {
                return vIPBuyOption;
            }
            if (this.f33785c.get(i2).choosen) {
                vIPBuyOption = this.f33785c.get(i2);
            }
            i = i2 + 1;
        }
    }

    public void a(int i) {
        if (i < this.f33785c.size()) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.f33785c.size()) {
                    break;
                }
                this.f33785c.get(i3).choosen = false;
                i2 = i3 + 1;
            }
            this.f33785c.get(i).choosen = true;
            onGoodClick ongoodclick = this.f33784a;
            if (ongoodclick != null) {
                ongoodclick.onclick(this.f33785c.get(i));
            }
        }
    }

    public void a(onGoodClick ongoodclick) {
        this.f33784a = ongoodclick;
    }

    public void a(List<VIPBuyOption> list) {
        if (list == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                this.f33785c.clear();
                this.f33785c.addAll(list);
                notifyDataSetChanged();
                return;
            }
            list.get(i2).vip_grade = this.f;
            i = i2 + 1;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f33785c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f33785c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View view2;
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = this.b.inflate(R.layout.item_vip_pay_option, viewGroup, false);
            viewHolder.b = (TextView) view2.findViewById(R.id.tv_month);
            viewHolder.f33787c = (TextView) view2.findViewById(2131371262);
            viewHolder.d = (TextView) view2.findViewById(R.id.tv_actual_amount);
            viewHolder.e = (ConstraintLayout) view2.findViewById(R.id.rl_item);
            viewHolder.f = (TextView) view2.findViewById(2131372678);
            viewHolder.g = (TextView) view2.findViewById(R.id.tv_unit);
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        final VIPBuyOption vIPBuyOption = this.f33785c.get(i);
        if (vIPBuyOption != null) {
            String str = ((int) vIPBuyOption.money) + "";
            viewHolder.g.setText(vIPBuyOption.item.price_copy);
            TextView textView = viewHolder.d;
            StringBuilder sb = new StringBuilder();
            sb.append(BlueAppLocal.a().equalsIgnoreCase("en") ? "￥" : "");
            sb.append(str);
            textView.setText(sb.toString());
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.adapter.-$$Lambda$VIPBuyAdapter$5nYFgIXWoEE_8Qwaa2j885_iB0E
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    VIPBuyAdapter.this.a(i, vIPBuyOption, view3);
                }
            });
            if (vIPBuyOption.item != null) {
                viewHolder.b.setText(vIPBuyOption.item.name);
                viewHolder.f33787c.setText(vIPBuyOption.item.description);
                if (TextUtils.isEmpty(vIPBuyOption.item.tag)) {
                    viewHolder.f.setVisibility(8);
                } else {
                    viewHolder.f.setVisibility(0);
                    viewHolder.f.setText(vIPBuyOption.item.tag);
                }
            }
            if (vIPBuyOption.choosen) {
                if (this.f == 2) {
                    viewHolder.e.setBackground(this.d.getResources().getDrawable(R.drawable.shape_buy_svip_choosed_bg));
                    return view2;
                }
                viewHolder.e.setBackground(this.d.getResources().getDrawable(R.drawable.shape_buy_vip_choosed_bg));
                return view2;
            }
            viewHolder.e.setBackground(BluedSkinUtils.b(this.d, R.drawable.shape_buy_vip_unchoose_bg));
        }
        return view2;
    }
}
