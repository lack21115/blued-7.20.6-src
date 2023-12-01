package com.soft.blued.ui.group.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.group.GroupAdminSetFragment;
import com.soft.blued.ui.group.model.BluedGroupAdminLists;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.StringUtils;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/adapter/GroupAdminSetAdapter.class */
public class GroupAdminSetAdapter extends BaseAdapter {
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private List<BluedGroupAdminLists> f17205c;
    private LayoutInflater d;
    private Dialog f;
    private ListView g;
    private LinearLayout h;
    private ImageView i;
    private TextView j;
    private TextView k;
    private View l;
    private IRequestHost m;

    /* renamed from: a  reason: collision with root package name */
    public boolean f17204a = false;
    private LoadOptions e = new LoadOptions();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.group.adapter.GroupAdminSetAdapter$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/adapter/GroupAdminSetAdapter$1.class */
    public class AnonymousClass1 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f17206a;
        final /* synthetic */ BluedGroupAdminLists b;

        AnonymousClass1(int i, BluedGroupAdminLists bluedGroupAdminLists) {
            this.f17206a = i;
            this.b = bluedGroupAdminLists;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            CommonAlertDialog.a(GroupAdminSetAdapter.this.b, (View) null, GroupAdminSetAdapter.this.b.getResources().getString(R.string.group_admin_remove_warning), GroupAdminSetAdapter.this.b.getResources().getString(R.string.group_admin_remove_dialog), GroupAdminSetAdapter.this.b.getResources().getString(2131886885), GroupAdminSetAdapter.this.b.getResources().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.group.adapter.GroupAdminSetAdapter.1.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    GroupHttpUtils.h(GroupAdminSetAdapter.this.b, new BluedUIHttpResponse<BluedEntityA<BluedGroupAdminLists>>() { // from class: com.soft.blued.ui.group.adapter.GroupAdminSetAdapter.1.1.1
                        /* JADX INFO: Access modifiers changed from: protected */
                        /* renamed from: a */
                        public void onUIUpdate(BluedEntityA<BluedGroupAdminLists> bluedEntityA) {
                            if (bluedEntityA != null) {
                                try {
                                    AppMethods.d((int) R.string.group_admin_cancel_prompt);
                                    GroupAdminSetAdapter.this.f17205c.remove(AnonymousClass1.this.f17206a);
                                    TextView textView = GroupAdminSetAdapter.this.k;
                                    textView.setText("(" + GroupAdminSetAdapter.this.f17205c.size() + "/" + GroupAdminSetFragment.f17065c + ")");
                                    GroupAdminSetFragment.d = StringUtils.a(GroupAdminSetAdapter.this.f17205c.size(), "0");
                                    if (GroupAdminSetFragment.d.equals("0")) {
                                        GroupAdminSetAdapter.this.f17204a = false;
                                        GroupAdminSetAdapter.this.l.setVisibility(4);
                                    } else {
                                        GroupAdminSetAdapter.this.l.setVisibility(0);
                                    }
                                    if (GroupAdminSetFragment.d.equals(GroupAdminSetFragment.f17065c)) {
                                        GroupAdminSetAdapter.this.h.setClickable(false);
                                        GroupAdminSetAdapter.this.i.setImageResource(R.drawable.icon_group_add_admin_gray);
                                        GroupAdminSetAdapter.this.j.setTextColor(GroupAdminSetAdapter.this.b.getResources().getColor(2131100461));
                                    } else {
                                        GroupAdminSetAdapter.this.h.setClickable(true);
                                        GroupAdminSetAdapter.this.i.setImageResource(R.drawable.icon_group_add_admin_blue);
                                        GroupAdminSetAdapter.this.j.setTextColor(GroupAdminSetAdapter.this.b.getResources().getColor(2131100275));
                                    }
                                    GroupAdminSetAdapter.this.notifyDataSetChanged();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }

                        public void onUIFinish() {
                            super.onUIFinish();
                            DialogUtils.b(GroupAdminSetAdapter.this.f);
                        }

                        public void onUIStart() {
                            super.onUIStart();
                            DialogUtils.a(GroupAdminSetAdapter.this.f);
                        }
                    }, GroupAdminSetFragment.b, AnonymousClass1.this.b.users_uid, GroupAdminSetAdapter.this.m);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.group.adapter.GroupAdminSetAdapter.1.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                }
            }, (DialogInterface.OnCancelListener) null, true);
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/adapter/GroupAdminSetAdapter$ViewHolder.class */
    public class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f17213a;
        public TextView b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17214c;
        public TextView d;
        public TextView e;
        public ImageView f;
        public ImageView g;

        public ViewHolder() {
        }
    }

    public GroupAdminSetAdapter(Context context, List<BluedGroupAdminLists> list, ListView listView, TextView textView, LinearLayout linearLayout, ImageView imageView, TextView textView2, View view, IRequestHost iRequestHost) {
        this.b = context;
        this.f17205c = list;
        this.g = listView;
        this.h = linearLayout;
        this.i = imageView;
        this.j = textView2;
        this.k = textView;
        this.l = view;
        this.m = iRequestHost;
        this.d = LayoutInflater.from(context);
        this.f = DialogUtils.a(context);
        this.e.d = 2131237310;
        this.e.b = 2131237310;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f17205c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f17205c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        ViewHolder viewHolder;
        final BluedGroupAdminLists bluedGroupAdminLists = this.f17205c.get(i);
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = this.d.inflate(R.layout.item_group_admins_show, viewGroup, false);
            viewHolder.f17213a = (ImageView) view2.findViewById(R.id.iv_user_head);
            viewHolder.b = (TextView) view2.findViewById(R.id.tv_user_name);
            viewHolder.f17214c = (TextView) view2.findViewById(R.id.tv_user_distance);
            viewHolder.d = (TextView) view2.findViewById(R.id.tv_last_activate_time);
            viewHolder.e = (TextView) view2.findViewById(R.id.tv_group_user_details);
            viewHolder.f = (ImageView) view2.findViewById(R.id.iv_group_admin_set);
            viewHolder.g = (ImageView) view2.findViewById(R.id.member_img_verify);
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        if (this.f17204a) {
            viewHolder.f.setVisibility(0);
        } else {
            viewHolder.f.setVisibility(8);
        }
        ImageLoader.a(this.m, bluedGroupAdminLists.users_avatar).b(2131237310).c().a(viewHolder.f17213a);
        UserInfoHelper.a(viewHolder.g, bluedGroupAdminLists.users_vbadge, 3);
        if (!StringUtils.d(bluedGroupAdminLists.users_note)) {
            viewHolder.b.setText(bluedGroupAdminLists.users_note);
        } else if (StringUtils.d(bluedGroupAdminLists.users_name)) {
            viewHolder.b.setVisibility(4);
        } else {
            viewHolder.b.setText(bluedGroupAdminLists.users_name);
        }
        if (StringUtils.d(bluedGroupAdminLists.users_distance)) {
            viewHolder.f17214c.setVisibility(4);
        } else {
            viewHolder.f17214c.setText(DistanceUtils.a(bluedGroupAdminLists.users_distance, BlueAppLocal.c(), false));
        }
        if (StringUtils.d(bluedGroupAdminLists.last_active_time)) {
            viewHolder.d.setText("");
        } else {
            viewHolder.d.setText(TimeAndDateUtils.f(this.b, TimeAndDateUtils.c(bluedGroupAdminLists.last_active_time)));
        }
        TextView textView = viewHolder.e;
        textView.setText(bluedGroupAdminLists.users_age + " / " + bluedGroupAdminLists.users_height + " / " + bluedGroupAdminLists.users_weight + " - " + UserInfoHelper.a(this.b, bluedGroupAdminLists.users_role));
        viewHolder.f.setOnClickListener(new AnonymousClass1(i, bluedGroupAdminLists));
        final ViewHolder viewHolder2 = viewHolder;
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.group.adapter.GroupAdminSetAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                Tracker.onClick(view3);
                UserBasicModel userBasicModel = new UserBasicModel();
                userBasicModel.uid = bluedGroupAdminLists.users_uid;
                userBasicModel.name = bluedGroupAdminLists.users_name;
                userBasicModel.avatar = bluedGroupAdminLists.users_avatar;
                UserInfoFragmentNew.a(GroupAdminSetAdapter.this.b, userBasicModel, (String) null, viewHolder2.f17213a);
            }
        });
        return view2;
    }
}
