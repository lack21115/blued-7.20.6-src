package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.LabeledTextView;
import com.soft.blued.ui.user.model.VIPBuyOptionForJsonParse;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/VIPAgreementAdapter.class */
public class VIPAgreementAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private List<VIPBuyOptionForJsonParse._rule_list> f20089a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f20090c;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/VIPAgreementAdapter$ViewHolder.class */
    public class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public LabeledTextView f20091a;
        public View b;

        public ViewHolder() {
        }
    }

    public VIPAgreementAdapter(Context context, List<VIPBuyOptionForJsonParse._rule_list> list) {
        this.b = context;
        this.f20090c = LayoutInflater.from(context);
        if (list != null) {
            this.f20089a = list;
        } else {
            this.f20089a = new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(VIPBuyOptionForJsonParse._rule_list _rule_listVar, View view) {
        Tracker.onClick(view);
        String str = _rule_listVar.url;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        WebViewShowInfoFragment.show(this.b, str, 0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f20089a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f20089a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = this.f20090c.inflate(R.layout.item_vip_agreement, viewGroup, false);
            viewHolder.f20091a = (LabeledTextView) view2.findViewById(2131372046);
            viewHolder.b = view2.findViewById(2131366859);
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.b.setBackgroundColor(BluedSkinUtils.a(this.b, 2131101780));
        final VIPBuyOptionForJsonParse._rule_list _rule_listVar = this.f20089a.get(i);
        if (_rule_listVar != null) {
            viewHolder.f20091a.setTextTitle(_rule_listVar.title);
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.adapter.-$$Lambda$VIPAgreementAdapter$S58YcNxqzL7x6PZpQ9ZnpGvGILA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                VIPAgreementAdapter.this.a(_rule_listVar, view3);
            }
        });
        return view2;
    }
}
