package com.soft.blued.ui.setting.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.utils.area.AreaUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.msg.controller.tools.MsgCommonUtils;
import com.soft.blued.ui.setting.model.BluedBlackList;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.model.UserInfoEntity;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/adapter/BlackAdapter.class */
public class BlackAdapter extends BaseQuickAdapter<BluedBlackList, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Context f33272a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f33273c;
    private IRequestHost d;

    public BlackAdapter(Context context, IRequestHost iRequestHost) {
        super((int) R.layout.fragment_black_list_item);
        this.b = BlackAdapter.class.getSimpleName();
        this.d = iRequestHost;
        this.f33272a = context;
        this.f33273c = DialogUtils.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final BluedBlackList bluedBlackList) {
        UserHttpUtils.c(this.f33272a, new BluedUIHttpResponse() { // from class: com.soft.blued.ui.setting.adapter.BlackAdapter.3
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(BlackAdapter.this.f33273c);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(BlackAdapter.this.f33273c);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                DialogUtils.b(BlackAdapter.this.f33273c);
                BlackAdapter.this.getData().remove(bluedBlackList);
                BlackAdapter.this.notifyDataSetChanged();
                BlackAdapter.this.notifyDataSetChanged();
                AppMethods.d((int) R.string.cancel_success);
                UserInfoEntity userInfoEntity = new UserInfoEntity();
                userInfoEntity.uid = bluedBlackList.uid;
                userInfoEntity.relationship = "0";
                LiveEventBus.get("feed_relation_ship").post(userInfoEntity);
                LiveEventBus.get(EventBusConstant.KEY_EVENT_REFRESH_BLACK_LIST_NUM).post(true);
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), bluedBlackList.uid, this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(final BaseViewHolder baseViewHolder, final BluedBlackList bluedBlackList) {
        final ImageView imageView = (ImageView) baseViewHolder.getView(2131364232);
        TextView textView = (TextView) baseViewHolder.getView(2131368652);
        TextView textView2 = (TextView) baseViewHolder.getView(2131363246);
        TextView textView3 = (TextView) baseViewHolder.getView(R.id.online_time_view);
        TextView textView4 = (TextView) baseViewHolder.getView(2131362003);
        TextView textView5 = (TextView) baseViewHolder.getView(2131364242);
        TextView textView6 = (TextView) baseViewHolder.getView(2131373390);
        TextView textView7 = (TextView) baseViewHolder.getView(2131369448);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(2131364720);
        TextView textView8 = (TextView) baseViewHolder.getView(R.id.tv_city_settled);
        ImageView imageView3 = (ImageView) baseViewHolder.getView(2131364625);
        ImageView imageView4 = (ImageView) baseViewHolder.getView(2131364726);
        LinearLayout linearLayout = (LinearLayout) baseViewHolder.getView(R.id.ll_personal_info);
        UserInfoHelper.a(imageView2, bluedBlackList.vbadge, 3);
        baseViewHolder.getConvertView().setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.adapter.BlackAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                UserInfoFragmentNew.a(BlackAdapter.this.f33272a, bluedBlackList, "", imageView);
            }
        });
        ImageLoader.a(this.d, bluedBlackList.avatar).c().b(2131237310).a(imageView);
        if (TextUtils.isEmpty(bluedBlackList.distance)) {
            textView2.setText("");
        } else {
            textView2.setText(DistanceUtils.a(bluedBlackList.distance, BlueAppLocal.c(), false));
        }
        if (TextUtils.isEmpty(bluedBlackList.city_settled)) {
            textView8.setText("");
        } else {
            textView8.setText(AreaUtils.getAreaTxt(bluedBlackList.city_settled, BlueAppLocal.c()));
        }
        TypefaceUtils.b(this.f33272a, textView8, bluedBlackList.is_hide_city_settled, 1);
        if (bluedBlackList.online_state == 1) {
            imageView3.setVisibility(0);
        } else {
            imageView3.setVisibility(8);
        }
        if (!TextUtils.isEmpty(bluedBlackList.note)) {
            textView.setText(bluedBlackList.note);
        } else if (TextUtils.isEmpty(bluedBlackList.name)) {
            textView.setText("");
        } else {
            textView.setText(bluedBlackList.name);
        }
        UserRelationshipUtils.a(this.f33272a, textView, bluedBlackList);
        UserRelationshipUtils.a(imageView4, bluedBlackList);
        String string = this.f33272a.getResources().getString(R.string.block_time);
        if (TextUtils.isEmpty(bluedBlackList.black_time)) {
            textView3.setText(string + this.f33272a.getResources().getString(R.string.biao_time_just));
        } else {
            String a2 = MsgCommonUtils.a(AppInfo.d(), Long.valueOf(TimeAndDateUtils.c(bluedBlackList.black_time)).longValue());
            if (StringUtils.d(a2)) {
                textView3.setText(string + this.f33272a.getResources().getString(R.string.biao_time_just));
            } else {
                textView3.setText(string + a2);
            }
        }
        if (UserInfoHelper.c(bluedBlackList.vbadge)) {
            linearLayout.setVisibility(8);
        } else {
            linearLayout.setVisibility(0);
            UserInfoHelper.a(this.f33272a, textView7, bluedBlackList.role);
            if (TextUtils.isEmpty(bluedBlackList.age)) {
                textView4.setText("");
            } else {
                textView4.setText(bluedBlackList.age + this.f33272a.getResources().getString(2131886374));
            }
            if (TextUtils.isEmpty(bluedBlackList.height)) {
                textView5.setText("");
            } else {
                textView5.setText(bluedBlackList.height);
            }
            if (TextUtils.isEmpty(bluedBlackList.weight)) {
                textView6.setText("");
            } else {
                textView6.setText(bluedBlackList.weight);
            }
        }
        baseViewHolder.getConvertView().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.soft.blued.ui.setting.adapter.BlackAdapter.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (baseViewHolder.getAdapterPosition() < 0 || baseViewHolder.getAdapterPosition() > BlackAdapter.this.getData().size()) {
                    return true;
                }
                CommonAlertDialog.a(BlackAdapter.this.f33272a, bluedBlackList.name, new String[]{BlackAdapter.this.f33272a.getResources().getString(R.string.remove_from_blacklist)}, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.adapter.BlackAdapter.2.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Tracker.onClick(dialogInterface, i);
                        if (i != 0) {
                            return;
                        }
                        BlackAdapter.this.a(bluedBlackList);
                    }
                });
                return false;
            }
        });
    }

    public void a(List<BluedBlackList> list) {
        getData().clear();
        if (list != null && list.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                if (BlueAppLocal.d()) {
                    list.get(i2).height = StringUtils.a(list.get(i2).height, BlueAppLocal.c(), false);
                    list.get(i2).weight = StringUtils.b(list.get(i2).weight, BlueAppLocal.c(), false);
                } else {
                    list.get(i2).height = StringUtils.a(list.get(i2).height, BlueAppLocal.c(), true);
                    list.get(i2).weight = StringUtils.b(list.get(i2).weight, BlueAppLocal.c(), true);
                }
                i = i2 + 1;
            }
            getData().addAll(list);
        }
        notifyDataSetChanged();
    }

    public void b(List<BluedBlackList> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                getData().addAll(list);
                notifyDataSetChanged();
                return;
            }
            if (BlueAppLocal.d()) {
                list.get(i2).height = StringUtils.a(list.get(i2).height, BlueAppLocal.c(), false);
                list.get(i2).weight = StringUtils.b(list.get(i2).weight, BlueAppLocal.c(), false);
            } else {
                list.get(i2).height = StringUtils.a(list.get(i2).height, BlueAppLocal.c(), true);
                list.get(i2).weight = StringUtils.b(list.get(i2).weight, BlueAppLocal.c(), true);
            }
            i = i2 + 1;
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }
}
