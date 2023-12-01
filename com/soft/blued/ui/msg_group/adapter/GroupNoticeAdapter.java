package com.soft.blued.ui.msg_group.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.widget.dialog.BluedAlertDialog;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.das.client.socialnet.SocialNetWorkProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.http.MsgGroupHttpUtils;
import com.soft.blued.ui.msg_group.constant.GroupConstant;
import com.soft.blued.ui.msg_group.fragment.GroupInfoFragment;
import com.soft.blued.ui.msg_group.model.GroupNoticeModel;
import com.soft.blued.ui.msg_group.model.GroupPrivilegeModel;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.web.WebViewShowInfoFragment;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/adapter/GroupNoticeAdapter.class */
public class GroupNoticeAdapter extends BaseMultiItemQuickAdapter<GroupNoticeModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private IRequestHost f18949a;
    private Dialog b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f18950c;

    public GroupNoticeAdapter(IRequestHost iRequestHost) {
        super(null);
        this.f18949a = iRequestHost;
        addItemType(1, R.layout.item_group_notice_member_operate);
        addItemType(3, R.layout.item_group_notice_member_operate);
        addItemType(2, R.layout.item_group_notice_apply);
        addItemType(12, R.layout.item_group_notice_create_succeed);
        addItemType(4, R.layout.item_group_notice_common);
        addItemType(5, R.layout.item_group_notice_common);
        addItemType(6, R.layout.item_group_notice_common);
        addItemType(7, R.layout.item_group_notice_common);
        addItemType(8, R.layout.item_group_notice_common);
        addItemType(9, R.layout.item_group_notice_common);
        addItemType(10, R.layout.item_group_notice_common);
        addItemType(11, R.layout.item_group_notice_common);
        addItemType(14, R.layout.item_group_notice_common);
        addItemType(15, R.layout.item_group_notice_common);
        addItemType(16, R.layout.item_group_notice_common);
        addItemType(17, R.layout.item_group_notice_common);
        addItemType(18, R.layout.item_group_notice_common);
        addItemType(19, R.layout.item_group_notice_common);
        addItemType(20, R.layout.item_group_notice_apply);
        addItemType(21, R.layout.item_group_notice_apply);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i, final BaseViewHolder baseViewHolder, final GroupNoticeModel groupNoticeModel) {
        MsgGroupHttpUtils.c(this.f18949a, groupNoticeModel.id, i, new BluedUIHttpResponse(this.f18949a) { // from class: com.soft.blued.ui.msg_group.adapter.GroupNoticeAdapter.7
            public boolean onUIFailure(int i2, String str) {
                if (i2 == 40319014) {
                    groupNoticeModel.result = 3;
                    GroupNoticeAdapter.this.notifyItemChanged(baseViewHolder.getAdapterPosition());
                } else if (i2 == 40319050) {
                    GroupNoticeAdapter.this.a(groupNoticeModel.is_owner);
                    return true;
                }
                return super.onUIFailure(i2, str);
            }

            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                DialogUtils.b(GroupNoticeAdapter.this.b);
                if (z) {
                    groupNoticeModel.result = i;
                    GroupNoticeAdapter.this.notifyItemChanged(baseViewHolder.getAdapterPosition());
                }
            }

            public void onUIStart() {
                super.onUIStart();
                if (GroupNoticeAdapter.this.b == null) {
                    GroupNoticeAdapter groupNoticeAdapter = GroupNoticeAdapter.this;
                    groupNoticeAdapter.b = DialogUtils.a(groupNoticeAdapter.mContext);
                }
                DialogUtils.a(GroupNoticeAdapter.this.b);
            }

            public void onUIUpdate(BluedEntity bluedEntity) {
            }
        });
    }

    private void a(ImageView imageView, TextView textView, final GroupNoticeModel groupNoticeModel) {
        if (textView != null) {
            textView.setText(groupNoticeModel.ops_name);
        }
        if (imageView != null) {
            ImageLoader.a(this.f18949a, groupNoticeModel.ops_avatar).b(2131237310).c().a(imageView);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.adapter.GroupNoticeAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    Context context = GroupNoticeAdapter.this.mContext;
                    UserInfoFragmentNew.a(context, groupNoticeModel.ops_uid + "", "group_chatting");
                }
            });
        }
    }

    private void a(TextView textView, int i) {
        if (textView != null) {
            switch (i) {
                case 2:
                    textView.setText(this.mContext.getString(R.string.group_add_apply));
                    return;
                case 3:
                default:
                    return;
                case 4:
                    textView.setText(this.mContext.getString(R.string.group_notice_type_danger));
                    return;
                case 5:
                    textView.setText(this.mContext.getString(R.string.group_notice_type_set_admin));
                    return;
                case 6:
                    textView.setText(this.mContext.getString(R.string.group_notice_type_invalid_admin));
                    return;
                case 7:
                    textView.setText(this.mContext.getString(R.string.group_transfer));
                    return;
                case 8:
                    textView.setText(this.mContext.getString(R.string.group_notice_type_owner_auto_change));
                    return;
                case 9:
                    textView.setText(this.mContext.getString(R.string.group_notice_type_refuse_joined));
                    return;
                case 10:
                    textView.setText(this.mContext.getString(R.string.group_transfer_accept));
                    return;
                case 11:
                    textView.setText(this.mContext.getString(R.string.group_transfer_refuse));
                    return;
                case 12:
                    textView.setText(this.mContext.getString(R.string.group_create_succeed_title));
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            IRequestHost iRequestHost = this.f18949a;
            MsgGroupHttpUtils.a(iRequestHost, new BluedUIHttpResponse<BluedEntityA<GroupPrivilegeModel>>(iRequestHost) { // from class: com.soft.blued.ui.msg_group.adapter.GroupNoticeAdapter.8
                /* JADX INFO: Access modifiers changed from: protected */
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<GroupPrivilegeModel> bluedEntityA) {
                    Context context;
                    int i;
                    if (bluedEntityA.hasData()) {
                        GroupPrivilegeModel groupPrivilegeModel = (GroupPrivilegeModel) bluedEntityA.getSingleData();
                        String format = String.format(GroupNoticeAdapter.this.mContext.getString(R.string.group_add_member_limit_owner), groupPrivilegeModel.getSuper_max_population() + "");
                        if (groupPrivilegeModel.getPrivilege() == 1) {
                            context = GroupNoticeAdapter.this.mContext;
                            i = 2131888452;
                        } else {
                            context = GroupNoticeAdapter.this.mContext;
                            i = 2131888394;
                        }
                        CommonAlertDialog.a(GroupNoticeAdapter.this.mContext, GroupNoticeAdapter.this.mContext.getString(R.string.group_upper_limit), format, context.getString(i), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.adapter.GroupNoticeAdapter.8.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                Tracker.onClick(dialogInterface, i2);
                                dialogInterface.dismiss();
                                Context context2 = GroupNoticeAdapter.this.mContext;
                                WebViewShowInfoFragment.show(context2, GroupConstant.f18972a + "group_apply");
                            }
                        }, GroupNoticeAdapter.this.mContext.getString(2131886885), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.adapter.GroupNoticeAdapter.8.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                Tracker.onClick(dialogInterface, i2);
                                dialogInterface.dismiss();
                            }
                        }, (DialogInterface.OnDismissListener) null);
                    }
                }
            });
            return;
        }
        CommonAlertDialog.a(this.mContext, this.mContext.getString(R.string.group_upper_limit), this.mContext.getString(R.string.group_add_member_limit_manager), this.mContext.getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.adapter.GroupNoticeAdapter.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                dialogInterface.dismiss();
            }
        }, (DialogInterface.OnDismissListener) null, 0);
    }

    private void b(TextView textView, int i) {
        if (textView == null) {
            return;
        }
        textView.setText(TimeAndDateUtils.a(i + "", (String) null));
    }

    private void b(BaseViewHolder baseViewHolder, final GroupNoticeModel groupNoticeModel) {
        GroupUtil.b(this.f18949a, groupNoticeModel.group_cover, (ImageView) baseViewHolder.getView(R.id.iv_header));
        baseViewHolder.setText(R.id.tv_info, groupNoticeModel.text);
        baseViewHolder.getView(R.id.ll_bottom_btn_single).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.adapter.GroupNoticeAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                Context context = GroupNoticeAdapter.this.mContext;
                GroupInfoFragment.a(context, groupNoticeModel.group_id + "", null, SocialNetWorkProtos.SourceType.UNKNOWN_SOURCE_TYPE);
            }
        });
    }

    private void c(final BaseViewHolder baseViewHolder, final GroupNoticeModel groupNoticeModel) {
        if (!TextUtils.isEmpty(groupNoticeModel.title)) {
            baseViewHolder.setText(2131372754, groupNoticeModel.title);
        }
        baseViewHolder.setText(2131371186, groupNoticeModel.text);
        baseViewHolder.setTextColor(2131372754, BluedSkinUtils.a(this.mContext, groupNoticeModel.type == 4 ? 2131102251 : 2131102254));
        if (groupNoticeModel.type != 7) {
            baseViewHolder.setGone(2131362488, false);
            baseViewHolder.setGone(R.id.tv_operated, false);
            baseViewHolder.setGone(R.id.ll_bottom_btn, false);
            return;
        }
        baseViewHolder.setGone(2131362488, true);
        baseViewHolder.setGone(R.id.tv_operated, groupNoticeModel.result != 0);
        boolean z = false;
        if (groupNoticeModel.result == 0) {
            z = true;
        }
        baseViewHolder.setGone(R.id.ll_bottom_btn, z);
        if (groupNoticeModel.result == 0) {
            if (groupNoticeModel.type == 7) {
                baseViewHolder.setText(R.id.tv_refuse, this.mContext.getString(R.string.group_notify_decline));
                baseViewHolder.setText(R.id.tv_agree, this.mContext.getString(R.string.group_notice_accept));
            }
            baseViewHolder.getView(R.id.tv_refuse).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.adapter.GroupNoticeAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    GroupNoticeAdapter.this.a(2, baseViewHolder, groupNoticeModel);
                }
            });
            baseViewHolder.getView(R.id.tv_agree).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.adapter.GroupNoticeAdapter.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    GroupNoticeAdapter.this.a(1, baseViewHolder, groupNoticeModel);
                }
            });
            return;
        }
        int i = groupNoticeModel.result;
        if (i == 1) {
            baseViewHolder.setText(R.id.tv_operated, this.mContext.getString(R.string.group_accepted));
        } else if (i == 2) {
            baseViewHolder.setText(R.id.tv_operated, this.mContext.getString(R.string.group_notify_decline));
        } else if (i != 3) {
        } else {
            baseViewHolder.setText(R.id.tv_operated, this.mContext.getString(R.string.group_apply_invalid));
        }
    }

    private void d(BaseViewHolder baseViewHolder, GroupNoticeModel groupNoticeModel) {
        baseViewHolder.setText(2131371186, groupNoticeModel.text);
        GroupUtil.a((TextView) baseViewHolder.getView(R.id.tv_identity), groupNoticeModel.ops_group_ago_role);
        ShapeHelper.b(baseViewHolder.getView(R.id.item_bg), groupNoticeModel.ops_group_ago_role == 2 ? 2131101114 : 2131102360);
    }

    private void e(final BaseViewHolder baseViewHolder, final GroupNoticeModel groupNoticeModel) {
        baseViewHolder.setText(R.id.tv_add_group_name, groupNoticeModel.group_title);
        baseViewHolder.setText(R.id.tv_add_group_reason, groupNoticeModel.reason);
        if (groupNoticeModel.ops_vbadge == 3 || groupNoticeModel.ops_vbadge == 5) {
            baseViewHolder.setGone(R.id.tv_info, false);
        } else {
            baseViewHolder.setGone(R.id.tv_info, true);
            StringBuilder sb = new StringBuilder();
            sb.append(groupNoticeModel.ops_age);
            sb.append("/");
            sb.append(groupNoticeModel.ops_height);
            sb.append("/");
            sb.append(groupNoticeModel.ops_weight);
            sb.append("/");
            sb.append(UserInfoHelper.a(this.mContext, groupNoticeModel.ops_role + ""));
            baseViewHolder.setText(R.id.tv_info, sb.toString());
        }
        int i = 2131888268;
        if (groupNoticeModel.type == 21) {
            baseViewHolder.setVisible(R.id.tv_second_apply, true);
            baseViewHolder.setVisible(R.id.tv_operated, true);
            baseViewHolder.setGone(R.id.ll_bottom_btn, false);
            baseViewHolder.setText(R.id.tv_operated, this.mContext.getString(R.string.group_add_apply_declined_forever));
            return;
        }
        if (groupNoticeModel.type == 20) {
            baseViewHolder.setVisible(R.id.tv_second_apply, true);
            baseViewHolder.setTextColor(R.id.tv_refuse, BluedSkinUtils.a(this.mContext, 2131102251));
            baseViewHolder.setText(R.id.tv_refuse, R.string.group_add_apply_decline_forever);
        }
        baseViewHolder.setGone(R.id.tv_operated, groupNoticeModel.result != 0);
        boolean z = false;
        if (groupNoticeModel.result == 0) {
            z = true;
        }
        baseViewHolder.setGone(R.id.ll_bottom_btn, z);
        if (groupNoticeModel.result == 0) {
            baseViewHolder.getView(R.id.tv_refuse).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.adapter.GroupNoticeAdapter.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (groupNoticeModel.type == 20) {
                        GroupNoticeAdapter.this.f(baseViewHolder, groupNoticeModel);
                    } else {
                        GroupNoticeAdapter.this.a(2, baseViewHolder, groupNoticeModel);
                    }
                }
            });
            baseViewHolder.getView(R.id.tv_agree).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.adapter.GroupNoticeAdapter.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    GroupNoticeAdapter.this.a(1, baseViewHolder, groupNoticeModel);
                }
            });
            return;
        }
        int i2 = groupNoticeModel.result;
        if (i2 == 1) {
            baseViewHolder.setText(R.id.tv_operated, this.mContext.getString(R.string.group_notice_agreed));
        } else if (i2 != 2) {
            if (i2 != 3) {
                return;
            }
            baseViewHolder.setText(R.id.tv_operated, this.mContext.getString(R.string.group_apply_invalid));
        } else {
            if (groupNoticeModel.type != 20) {
                i = 2131888520;
            }
            baseViewHolder.setText(R.id.tv_operated, this.mContext.getString(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final BaseViewHolder baseViewHolder, final GroupNoticeModel groupNoticeModel) {
        Dialog dialog = this.f18950c;
        if (dialog == null || !dialog.isShowing()) {
            BluedAlertDialog a2 = new BluedAlertDialog.Builder(this.mContext).d((int) R.string.group_add_apply_declined_alert).e((int) R.string.group_add_apply_declined_message).b((int) R.string.common_cancel, (DialogInterface.OnClickListener) null).f(2131102251).a((int) R.string.group_add_apply_decline_forever, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.adapter.GroupNoticeAdapter.10
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    GroupNoticeAdapter.this.a(2, baseViewHolder, groupNoticeModel);
                }
            }).a();
            this.f18950c = a2;
            a2.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, GroupNoticeModel groupNoticeModel) {
        baseViewHolder.setBackgroundColor(R.id.content_bg, BluedSkinUtils.a(this.mContext, groupNoticeModel.is_read == 1 ? 2131101796 : 2131101780));
        b((TextView) baseViewHolder.getView(R.id.tv_date), groupNoticeModel.timestamp);
        a((TextView) baseViewHolder.getView(2131372754), groupNoticeModel.type);
        int i = groupNoticeModel.type;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 12) {
                        b(baseViewHolder, groupNoticeModel);
                        return;
                    } else if (i != 20 && i != 21) {
                        c(baseViewHolder, groupNoticeModel);
                        a((ImageView) baseViewHolder.getView(R.id.iv_header), (TextView) baseViewHolder.getView(2131372046), groupNoticeModel);
                        return;
                    }
                }
            }
            e(baseViewHolder, groupNoticeModel);
            a((ImageView) baseViewHolder.getView(R.id.iv_header), (TextView) baseViewHolder.getView(2131372046), groupNoticeModel);
            return;
        }
        d(baseViewHolder, groupNoticeModel);
        a((ImageView) baseViewHolder.getView(R.id.iv_header), (TextView) baseViewHolder.getView(2131372046), groupNoticeModel);
    }
}
