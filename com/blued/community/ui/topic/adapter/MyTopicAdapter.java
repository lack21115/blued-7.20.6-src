package com.blued.community.ui.topic.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.common.widget.menu.ActionSheet;
import com.blued.android.module.common.widget.menu.CommonShowBottomWindow;
import com.blued.community.R;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.ui.feed.manager.FeedConstants;
import com.blued.community.ui.topic.fragment.SuperTopicDetailFragment;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseViewHolder;

/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/topic/adapter/MyTopicAdapter.class */
public class MyTopicAdapter extends SuperTopicAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f20238a;
    public MY_TOPIC_PAGE b;

    /* renamed from: c  reason: collision with root package name */
    public IRequestHost f20239c;
    public Dialog d;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/topic/adapter/MyTopicAdapter$MY_TOPIC_PAGE.class */
    public enum MY_TOPIC_PAGE {
        CREATED,
        JOINED
    }

    public MyTopicAdapter(Context context, MY_TOPIC_PAGE my_topic_page, IRequestHost iRequestHost) {
        super(context, iRequestHost, R.layout.item_mine_topic);
        this.f20238a = context;
        this.b = my_topic_page;
        this.f20239c = iRequestHost;
        this.d = DialogUtils.a(context);
    }

    public void a(final int i, final String str) {
        CommonShowBottomWindow.a((FragmentActivity) this.f20238a, new String[]{this.f20238a.getResources().getString(R.string.delete)}, new ActionSheet.ActionSheetListener() { // from class: com.blued.community.ui.topic.adapter.MyTopicAdapter.3
            @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
            public void a(ActionSheet actionSheet, int i2) {
                if (TextUtils.equals(actionSheet.a(i2), MyTopicAdapter.this.f20238a.getResources().getString(R.string.delete))) {
                    MyTopicAdapter.this.b(i, str);
                }
            }

            @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
            public void a(ActionSheet actionSheet, boolean z) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.community.ui.topic.adapter.SuperTopicAdapter, com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(final BaseViewHolder baseViewHolder, final BluedTopic bluedTopic) {
        super.convert(baseViewHolder, bluedTopic);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_status);
        View view = baseViewHolder.getView(R.id.layout);
        textView.setVisibility(0);
        if (bluedTopic.is_audited == 1) {
            view.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.topic.adapter.MyTopicAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    if (MyTopicAdapter.this.b == MY_TOPIC_PAGE.JOINED) {
                        FeedConstants.b = FeedProtos.DetailFrom.SUPER_TOPIC_JOIN;
                    } else if (MyTopicAdapter.this.b == MY_TOPIC_PAGE.CREATED) {
                        FeedConstants.b = FeedProtos.DetailFrom.SUPER_TOPIC_CREATE;
                    }
                    SuperTopicDetailFragment.a(MyTopicAdapter.this.f20238a, bluedTopic.super_did);
                }
            }));
            if (this.b == MY_TOPIC_PAGE.JOINED) {
                view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.blued.community.ui.topic.adapter.MyTopicAdapter.2
                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view2) {
                        MyTopicAdapter.this.a(baseViewHolder.getAdapterPosition(), bluedTopic.super_did);
                        return true;
                    }
                });
            } else {
                view.setOnLongClickListener(null);
            }
            if (TextUtils.isEmpty(bluedTopic.ranking)) {
                textView.setVisibility(8);
            } else {
                if ("en".equals(BlueAppLocal.c().getLanguage())) {
                    textView.setText("NO." + bluedTopic.ranking);
                } else {
                    textView.setText(bluedTopic.ranking + "名");
                }
                textView.setTextColor(this.f20238a.getResources().getColor(R.color.syc_h));
            }
        } else {
            view.setOnClickListener(null);
            view.setOnLongClickListener(null);
            textView.setText(R.string.community_under_review);
            textView.setTextColor(this.f20238a.getResources().getColor(R.color.syc_a));
        }
        if (this.b == MY_TOPIC_PAGE.JOINED) {
            textView.setVisibility(8);
        } else if (this.b == MY_TOPIC_PAGE.CREATED) {
            textView.setVisibility(0);
        }
    }

    public void b(final int i, final String str) {
        Context context = this.f20238a;
        CommonAlertDialog.a(context, "", context.getResources().getString(R.string.feed_confirm_delete), this.f20238a.getResources().getString(R.string.common_ok), new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.topic.adapter.MyTopicAdapter.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Tracker.onClick(dialogInterface, i2);
                FeedHttpUtils.d(new BluedUIHttpResponse<BluedEntityA<UserBasicModel>>(MyTopicAdapter.this.f20239c) { // from class: com.blued.community.ui.topic.adapter.MyTopicAdapter.4.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    /* renamed from: a */
                    public void onUIUpdate(BluedEntityA<UserBasicModel> bluedEntityA) {
                        if (i >= 0) {
                            MyTopicAdapter.this.remove(i);
                            MyTopicAdapter.this.notifyDataSetChanged();
                        }
                    }

                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    public void onUIFinish() {
                        super.onUIFinish();
                        DialogUtils.b(MyTopicAdapter.this.d);
                    }

                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    public void onUIStart() {
                        super.onUIStart();
                        DialogUtils.a(MyTopicAdapter.this.d);
                    }
                }, str, MyTopicAdapter.this.f20239c);
            }
        }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }
}
