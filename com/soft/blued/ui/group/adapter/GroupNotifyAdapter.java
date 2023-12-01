package com.soft.blued.ui.group.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.bytedance.applog.tracker.Tracker;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.soft.blued.R;
import com.soft.blued.ui.group.model.BluedMyGroupNotify;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/adapter/GroupNotifyAdapter.class */
public class GroupNotifyAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Dialog f17230a;
    private List<BluedMyGroupNotify> b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f17231c;
    private Context d;
    private LoadOptions e;
    private IRequestHost f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.group.adapter.GroupNotifyAdapter$5  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/adapter/GroupNotifyAdapter$5.class */
    public class AnonymousClass5 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f17237a;
        final /* synthetic */ ViewHolder b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BluedMyGroupNotify f17238c;

        AnonymousClass5(int i, ViewHolder viewHolder, BluedMyGroupNotify bluedMyGroupNotify) {
            this.f17237a = i;
            this.b = viewHolder;
            this.f17238c = bluedMyGroupNotify;
        }

        /* JADX WARN: Removed duplicated region for block: B:56:0x01e0  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x019a A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onClick(android.view.View r7) {
            /*
                Method dump skipped, instructions count: 517
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.group.adapter.GroupNotifyAdapter.AnonymousClass5.onClick(android.view.View):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/adapter/GroupNotifyAdapter$ViewHolder.class */
    public class ViewHolder {
        private RelativeLayout b;

        /* renamed from: c  reason: collision with root package name */
        private LinearLayout f17245c;
        private ImageView d;
        private ImageView e;
        private LinearLayout f;
        private TextView g;
        private TextView h;
        private TextView i;
        private LinearLayout j;
        private TextView k;
        private TextView l;
        private TextView m;
        private TextView n;
        private TextView o;
        private TextView p;
        private TextView q;

        public ViewHolder(View view) {
            this.b = (RelativeLayout) view.findViewById(R.id.rl_group_notify);
            this.d = (ImageView) view.findViewById(R.id.iv_user_head);
            this.e = (ImageView) view.findViewById(R.id.iv_group_notify_verify_icon);
            this.f17245c = (LinearLayout) view.findViewById(R.id.ll_group_notify_item);
            this.f = (LinearLayout) view.findViewById(R.id.ll_group_notify_detail_3Lines);
            this.g = (TextView) view.findViewById(R.id.tv_user_name_3Lines);
            this.h = (TextView) view.findViewById(R.id.tv_group_join_name_3Lines);
            this.i = (TextView) view.findViewById(R.id.tv_group_join_details_3Lines);
            this.j = (LinearLayout) view.findViewById(R.id.ll_group_notify_detail_2Lines);
            this.k = (TextView) view.findViewById(R.id.tv_group_lock_icon);
            this.l = (TextView) view.findViewById(R.id.tv_user_name_2Lines);
            this.m = (TextView) view.findViewById(R.id.tv_group_join_name_2Lines);
            this.n = (TextView) view.findViewById(R.id.tv_group_notify_item_time);
            this.o = (TextView) view.findViewById(R.id.btn_group_join);
            this.p = (TextView) view.findViewById(R.id.tv_group_join);
            this.q = (TextView) view.findViewById(R.id.tv_group_icon);
        }
    }

    public GroupNotifyAdapter(Context context, List<BluedMyGroupNotify> list, IRequestHost iRequestHost) {
        this.f = iRequestHost;
        this.b = list;
        this.d = context;
        this.f17231c = LayoutInflater.from(context);
        LoadOptions loadOptions = new LoadOptions();
        this.e = loadOptions;
        loadOptions.d = 2131237310;
        this.e.b = 2131237310;
        this.f17230a = DialogUtils.a(context);
    }

    private void a(final ViewHolder viewHolder, final BluedMyGroupNotify bluedMyGroupNotify, int i) {
        if (viewHolder == null || bluedMyGroupNotify == null) {
            return;
        }
        viewHolder.n.setVisibility(8);
        viewHolder.f17245c.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.group.adapter.GroupNotifyAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                GroupNotifyAdapter.this.a(bluedMyGroupNotify);
            }
        });
        viewHolder.d.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.group.adapter.GroupNotifyAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                UserBasicModel userBasicModel = new UserBasicModel();
                userBasicModel.uid = bluedMyGroupNotify.getApplied_uid();
                userBasicModel.name = bluedMyGroupNotify.getApplied_name();
                userBasicModel.avatar = bluedMyGroupNotify.getApplied_avatar();
                UserInfoFragmentNew.a(GroupNotifyAdapter.this.d, userBasicModel, (String) null, viewHolder.d);
            }
        });
        UserInfoHelper.a(viewHolder.e, bluedMyGroupNotify.getVbadge(), 3);
        viewHolder.q.setVisibility(8);
        if (bluedMyGroupNotify.getIs_read().equals("1")) {
            viewHolder.b.setBackgroundResource(2131102478);
        } else {
            viewHolder.b.setBackgroundResource(2131100475);
        }
        if (bluedMyGroupNotify.getOps().equals("allowed")) {
            viewHolder.p.setText(R.string.groupjoin_agreed);
            viewHolder.o.setVisibility(8);
            viewHolder.p.setVisibility(0);
        } else if (bluedMyGroupNotify.getOps().equals(NetworkUtil.NETWORK_CLASS_DENIED)) {
            viewHolder.p.setText(R.string.group_notify_declined);
            viewHolder.o.setVisibility(8);
            viewHolder.p.setVisibility(0);
        } else {
            viewHolder.o.setText(R.string.groupjoin_agree);
            viewHolder.o.setVisibility(0);
            viewHolder.p.setVisibility(8);
        }
        ImageLoader.a(this.f, bluedMyGroupNotify.getApplied_avatar()).b(2131237310).c().a(viewHolder.d);
        if (StringUtils.d(bluedMyGroupNotify.getReason())) {
            viewHolder.f.setVisibility(8);
            viewHolder.j.setVisibility(0);
            if (StringUtils.d(bluedMyGroupNotify.getApplied_name())) {
                viewHolder.l.setVisibility(4);
            } else {
                viewHolder.l.setVisibility(0);
                viewHolder.l.setText(bluedMyGroupNotify.getApplied_name());
            }
            if (StringUtils.d(bluedMyGroupNotify.getGroups_name())) {
                viewHolder.m.setVisibility(4);
            } else {
                viewHolder.m.setVisibility(0);
                TextView textView = viewHolder.m;
                textView.setText(this.d.getResources().getString(R.string.group_apply_hint) + " " + bluedMyGroupNotify.getGroups_name());
            }
        } else {
            viewHolder.f.setVisibility(0);
            viewHolder.j.setVisibility(8);
            if (StringUtils.d(bluedMyGroupNotify.getApplied_name())) {
                viewHolder.g.setVisibility(4);
            } else {
                viewHolder.g.setVisibility(0);
                viewHolder.g.setText(bluedMyGroupNotify.getApplied_name());
            }
            if (StringUtils.d(bluedMyGroupNotify.getGroups_name())) {
                viewHolder.h.setVisibility(4);
            } else {
                viewHolder.h.setVisibility(0);
                TextView textView2 = viewHolder.h;
                textView2.setText(this.d.getResources().getString(R.string.group_apply_hint) + " " + bluedMyGroupNotify.getGroups_name());
            }
            viewHolder.i.setText(bluedMyGroupNotify.getReason());
        }
        if (bluedMyGroupNotify.getGroupsStatus() == 2) {
            viewHolder.o.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.group.adapter.GroupNotifyAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    AppMethods.d((int) R.string.group_notify_apply_dismissed);
                }
            });
        } else if (bluedMyGroupNotify.getGroupsStatus() == 1) {
            viewHolder.o.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.group.adapter.GroupNotifyAdapter.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    AppMethods.d((int) R.string.group_notify_apply_locked);
                }
            });
        } else {
            viewHolder.o.setOnClickListener(new AnonymousClass5(i, viewHolder, bluedMyGroupNotify));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.soft.blued.ui.group.model.BluedMyGroupNotify r6) {
        /*
            Method dump skipped, instructions count: 748
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.group.adapter.GroupNotifyAdapter.a(com.soft.blued.ui.group.model.BluedMyGroupNotify):void");
    }

    private void b(ViewHolder viewHolder, final BluedMyGroupNotify bluedMyGroupNotify, int i) {
        String str;
        if (viewHolder == null || bluedMyGroupNotify == null) {
            return;
        }
        viewHolder.f17245c.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.group.adapter.GroupNotifyAdapter.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                GroupNotifyAdapter.this.a(bluedMyGroupNotify);
            }
        });
        viewHolder.f.setVisibility(8);
        viewHolder.j.setVisibility(0);
        viewHolder.o.setVisibility(8);
        viewHolder.p.setVisibility(8);
        viewHolder.e.setVisibility(8);
        if (bluedMyGroupNotify.getIs_read().equals("1")) {
            viewHolder.b.setBackgroundResource(2131102478);
        } else {
            viewHolder.b.setBackgroundResource(2131100475);
        }
        ImageLoader.a(this.f, bluedMyGroupNotify.getApplied_avatar()).b(2131237310).c().a(viewHolder.d);
        viewHolder.d.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.group.adapter.GroupNotifyAdapter.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                GroupNotifyAdapter.this.a(bluedMyGroupNotify);
            }
        });
        String str2 = "";
        if (1 == i) {
            viewHolder.q.setVisibility(0);
            viewHolder.k.setVisibility(8);
            str2 = bluedMyGroupNotify.getGroups_name();
            str = this.d.getResources().getString(R.string.group_notify_dismissed);
        } else if (3 == i) {
            viewHolder.q.setVisibility(0);
            viewHolder.k.setVisibility(8);
            str2 = bluedMyGroupNotify.getApplied_name();
            str = this.d.getResources().getString(R.string.group_notify_kicked);
        } else if (i == 0) {
            viewHolder.q.setVisibility(8);
            viewHolder.k.setVisibility(0);
            str2 = bluedMyGroupNotify.getGroups_name();
            str = this.d.getResources().getString(R.string.group_notify_info_locked_detail);
        } else {
            str = "";
        }
        if (StringUtils.d(bluedMyGroupNotify.getGroups_name())) {
            viewHolder.l.setVisibility(4);
        } else {
            viewHolder.l.setVisibility(0);
            viewHolder.l.setText(bluedMyGroupNotify.getGroups_name());
        }
        if (StringUtils.d(str2)) {
            viewHolder.m.setVisibility(4);
        } else {
            viewHolder.m.setVisibility(0);
            viewHolder.m.setText(String.format(str, str2));
        }
        if (StringUtils.d(bluedMyGroupNotify.getTimestamp())) {
            viewHolder.n.setVisibility(8);
            return;
        }
        String g = TimeAndDateUtils.g(this.d, TimeAndDateUtils.c(bluedMyGroupNotify.getTimestamp()));
        viewHolder.n.setVisibility(0);
        viewHolder.n.setText(g);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        BluedMyGroupNotify bluedMyGroupNotify = this.b.get(i);
        if (view == null) {
            view = this.f17231c.inflate(R.layout.item_group_notify_show, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        if (i == 13) {
            Logger.a("GroupNotify_test", "applied_type = ", Integer.valueOf(bluedMyGroupNotify.getAppliedType()));
        }
        if (bluedMyGroupNotify.getAppliedType() == 0) {
            b(viewHolder, bluedMyGroupNotify, 0);
            return view;
        } else if (3 == bluedMyGroupNotify.getAppliedType()) {
            b(viewHolder, bluedMyGroupNotify, 3);
            return view;
        } else if (1 == bluedMyGroupNotify.getAppliedType()) {
            b(viewHolder, bluedMyGroupNotify, 1);
            return view;
        } else {
            if (2 == bluedMyGroupNotify.getAppliedType()) {
                a(viewHolder, bluedMyGroupNotify, i);
            }
            return view;
        }
    }
}
