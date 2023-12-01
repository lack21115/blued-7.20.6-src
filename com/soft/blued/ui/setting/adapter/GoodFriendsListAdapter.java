package com.soft.blued.ui.setting.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.setting.model.BluedBlackList;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/adapter/GoodFriendsListAdapter.class */
public class GoodFriendsListAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f33284a;
    private LayoutInflater b;

    /* renamed from: c  reason: collision with root package name */
    private List<BluedBlackList> f33285c = new ArrayList();
    private String d = GoodFriendsListAdapter.class.getSimpleName();
    private int e;
    private Dialog f;
    private IRequestHost g;
    private String h;
    private LoadOptions i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/adapter/GoodFriendsListAdapter$ViewHolder.class */
    public class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f33293a;
        public TextView b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f33294c;
        public TextView d;
        public TextView e;
        public ImageView f;
        public ImageView g;
        public View h;

        private ViewHolder() {
        }
    }

    public GoodFriendsListAdapter(Context context, IRequestHost iRequestHost) {
        this.g = iRequestHost;
        this.f33284a = context;
        this.b = LayoutInflater.from(context);
        this.e = context.getResources().getDisplayMetrics().widthPixels;
        this.f = DialogUtils.a(context);
        LoadOptions loadOptions = new LoadOptions();
        this.i = loadOptions;
        loadOptions.d = 2131237310;
        this.i.b = 2131237310;
        LoadOptions loadOptions2 = this.i;
        int i = this.e;
        loadOptions2.a(i / 2, i / 2);
    }

    private String a(int i) {
        return this.f33284a.getResources().getString(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ViewHolder viewHolder) {
        int i = AppInfo.l;
        TextView textView = viewHolder.b;
        int a2 = DensityUtils.a(this.f33284a, 105.0f);
        int i2 = 0;
        int width = viewHolder.h.getVisibility() == 0 ? viewHolder.h.getWidth() : 0;
        int width2 = viewHolder.f33294c.getVisibility() == 0 ? viewHolder.f33294c.getWidth() : 0;
        int width3 = viewHolder.g.getVisibility() == 0 ? viewHolder.g.getWidth() : 0;
        if (viewHolder.d.getVisibility() == 0) {
            i2 = viewHolder.d.getWidth();
        }
        textView.setMaxWidth(((((i - a2) - width) - width2) - width3) - i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final BluedBlackList bluedBlackList) {
        CommonAlertDialog.a(this.f33284a, a(R.string.common_string_notice), 20, (String) null, (String) null, (String) null, bluedBlackList.note, a(R.string.please_input_user_comment), new CommonAlertDialog.TextOnClickListener() { // from class: com.soft.blued.ui.setting.adapter.GoodFriendsListAdapter.3
            @Override // com.blued.android.module.common.widget.dialog.CommonAlertDialog.TextOnClickListener
            public void a(final String str) {
                if (str.equals(bluedBlackList.note)) {
                    AppMethods.d((int) R.string.please_input_user_comment);
                } else {
                    MineHttpUtils.h(GoodFriendsListAdapter.this.f33284a, new BluedUIHttpResponse() { // from class: com.soft.blued.ui.setting.adapter.GoodFriendsListAdapter.3.1
                        @Override // com.blued.android.framework.http.BluedUIHttpResponse
                        public void onUIFinish() {
                            super.onUIFinish();
                            DialogUtils.b(GoodFriendsListAdapter.this.f);
                        }

                        @Override // com.blued.android.framework.http.BluedUIHttpResponse
                        public void onUIStart() {
                            super.onUIStart();
                            DialogUtils.a(GoodFriendsListAdapter.this.f);
                        }

                        @Override // com.blued.android.framework.http.BluedUIHttpResponse
                        public void onUIUpdate(BluedEntity bluedEntity) {
                            DialogUtils.b(GoodFriendsListAdapter.this.f);
                            AppMethods.d((int) R.string.modify_note_success);
                            bluedBlackList.note = str;
                            bluedBlackList.name = str;
                            GoodFriendsListAdapter.this.notifyDataSetChanged();
                        }
                    }, UserInfo.getInstance().getLoginUserInfo().getUid(), str, bluedBlackList.uid, GoodFriendsListAdapter.this.g);
                }
            }
        }, (DialogInterface.OnClickListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(int i, ViewHolder viewHolder, final BluedBlackList bluedBlackList, View view) {
        if (i < 0 || i > this.f33285c.size()) {
            return true;
        }
        String[] stringArray = AppInfo.d().getResources().getStringArray(R.array.friendslist_longclick_items);
        Context context = this.f33284a;
        CommonAlertDialog.a(context, ((Object) viewHolder.b.getText()) + "", stringArray, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.adapter.GoodFriendsListAdapter.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Tracker.onClick(dialogInterface, i2);
                if (i2 == 0) {
                    GoodFriendsListAdapter.this.a(bluedBlackList);
                } else if (i2 != 1) {
                } else {
                    GoodFriendsListAdapter.this.b(bluedBlackList);
                }
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final BluedBlackList bluedBlackList) {
        CommonAlertDialog.a(this.f33284a, (String) null, a(R.string.confirm_remove_from_friends_list), a(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.adapter.GoodFriendsListAdapter.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                UserHttpUtils.a(GoodFriendsListAdapter.this.f33284a, new UserRelationshipUtils.IAddOrRemoveAttentionDone() { // from class: com.soft.blued.ui.setting.adapter.GoodFriendsListAdapter.4.1
                    @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
                    public void a() {
                        DialogUtils.a(GoodFriendsListAdapter.this.f);
                    }

                    @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
                    public void a(String str) {
                    }

                    @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
                    public void b() {
                        DialogUtils.b(GoodFriendsListAdapter.this.f);
                    }

                    @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
                    public void b(String str) {
                        UserInfo.getInstance().getLoginUserInfo().setFriendsCount(-1);
                        DialogUtils.b(GoodFriendsListAdapter.this.f);
                        GoodFriendsListAdapter.this.f33285c.remove(bluedBlackList);
                        GoodFriendsListAdapter.this.notifyDataSetChanged();
                    }

                    @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
                    public void c() {
                        DialogUtils.b(GoodFriendsListAdapter.this.f);
                    }
                }, bluedBlackList.uid, "", GoodFriendsListAdapter.this.g);
            }
        }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    public void a(List<BluedBlackList> list, String str) {
        this.h = str;
        this.f33285c.clear();
        if (list != null && list.size() > 0) {
            this.f33285c.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void b(List<BluedBlackList> list, String str) {
        this.h = str;
        if (list == null || list.size() <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                this.f33285c.addAll(list);
                notifyDataSetChanged();
                return;
            }
            list.get(i2).height = StringUtils.a(list.get(i2).height, BlueAppLocal.c(), false);
            list.get(i2).weight = StringUtils.b(list.get(i2).weight, BlueAppLocal.c(), false);
            i = i2 + 1;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f33285c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
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
            view2 = this.b.inflate(R.layout.item_friend_list, viewGroup, false);
            viewHolder.f33293a = (ImageView) view2.findViewById(2131364232);
            viewHolder.b = (TextView) view2.findViewById(2131368652);
            viewHolder.f33294c = (TextView) view2.findViewById(2131363246);
            viewHolder.d = (TextView) view2.findViewById(R.id.online_time_view);
            viewHolder.e = (TextView) view2.findViewById(R.id.description_view);
            viewHolder.f = (ImageView) view2.findViewById(2131364720);
            viewHolder.g = (ImageView) view2.findViewById(2131364459);
            viewHolder.h = view2.findViewById(2131372167);
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        final BluedBlackList bluedBlackList = this.f33285c.get(i);
        UserInfoHelper.a(viewHolder.f, bluedBlackList.vbadge, 3);
        final ViewHolder viewHolder2 = viewHolder;
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.adapter.GoodFriendsListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                Tracker.onClick(view3);
                UserInfoFragmentNew.a(GoodFriendsListAdapter.this.f33284a, bluedBlackList, "my_friends", viewHolder2.f33293a);
            }
        });
        ImageLoader.a(this.g, bluedBlackList.avatar).b(2131237310).c().a(viewHolder.f33293a);
        if (TextUtils.isEmpty(bluedBlackList.location) || bluedBlackList.vbadge == 3) {
            viewHolder.f33294c.setText("");
        } else {
            viewHolder.f33294c.setText(bluedBlackList.location);
        }
        if (TextUtils.isEmpty(bluedBlackList.description)) {
            viewHolder.e.setText("");
        } else {
            viewHolder.e.setText(bluedBlackList.description);
        }
        if (!TextUtils.isEmpty(bluedBlackList.note)) {
            viewHolder.b.setText(bluedBlackList.note);
        } else if (TextUtils.isEmpty(bluedBlackList.name)) {
            viewHolder.b.setText("");
        } else {
            viewHolder.b.setText(bluedBlackList.name);
        }
        UserRelationshipUtils.a(this.f33284a, viewHolder.b, bluedBlackList);
        if (bluedBlackList.online_state == 1) {
            viewHolder.h.setVisibility(0);
        } else {
            viewHolder.h.setVisibility(8);
        }
        TypefaceUtils.a(this.f33284a, viewHolder.b, this.h, this.f33284a.getResources().getColor(2131100629));
        UserRelationshipUtils.a(viewHolder.g, bluedBlackList);
        if (bluedBlackList.vbadge != 3) {
            viewHolder.d.setVisibility(0);
            if (TextUtils.isEmpty(bluedBlackList.last_operate)) {
                viewHolder.d.setText(a(R.string.biao_time_just));
            } else {
                Long valueOf = Long.valueOf(TimeAndDateUtils.c(bluedBlackList.last_operate));
                if (StringUtils.d(TimeAndDateUtils.f(AppInfo.d(), valueOf.longValue()))) {
                    viewHolder.d.setText(a(R.string.biao_time_just));
                } else {
                    viewHolder.d.setText(TimeAndDateUtils.f(AppInfo.d(), valueOf.longValue()));
                }
            }
        } else {
            viewHolder.d.setVisibility(8);
        }
        TypefaceUtils.a(this.f33284a, viewHolder.d, bluedBlackList.is_hide_last_operate, 1);
        final ViewHolder viewHolder3 = viewHolder;
        viewHolder.d.post(new Runnable() { // from class: com.soft.blued.ui.setting.adapter.-$$Lambda$GoodFriendsListAdapter$jdq_B4z1miylmbbzr2KIx3VCla8
            @Override // java.lang.Runnable
            public final void run() {
                GoodFriendsListAdapter.this.a(viewHolder3);
            }
        });
        final ViewHolder viewHolder4 = viewHolder;
        view2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.soft.blued.ui.setting.adapter.-$$Lambda$GoodFriendsListAdapter$jHVfX4Z7Z_ZlMqatTCgs3UgMqsQ
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view3) {
                boolean a2;
                a2 = GoodFriendsListAdapter.this.a(i, viewHolder4, bluedBlackList, view3);
                return a2;
            }
        });
        return view2;
    }
}
