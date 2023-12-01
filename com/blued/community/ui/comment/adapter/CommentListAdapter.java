package com.blued.community.ui.comment.adapter;

import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.database.DataSetObserver;
import android.os.Build;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.RegExpUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.common.widget.menu.ActionSheet;
import com.blued.android.module.common.widget.menu.CommonShowBottomWindow;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.http.CircleHttpUtils;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.manager.CommunityConstants;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.circle.manager.CircleMethods;
import com.blued.community.ui.circle.model.CircleAddPoints;
import com.blued.community.ui.comment.model.FeedComment;
import com.blued.community.ui.feed.observer.CommentListDataObserver;
import com.blued.community.utils.StringUtils;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/comment/adapter/CommentListAdapter.class */
public class CommentListAdapter extends BaseAdapter implements CommentListDataObserver.ICommentDataObserver {

    /* renamed from: a  reason: collision with root package name */
    private Context f19406a;
    private LayoutInflater b;

    /* renamed from: c  reason: collision with root package name */
    private List<FeedComment> f19407c;
    private int d;
    private IRequestHost e;
    private BluedIngSelfFeed f;
    private FeedCommentListner g;
    private boolean h;
    private String i;
    private String j;
    private int k;
    private int l;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/comment/adapter/CommentListAdapter$FeedCommentListner.class */
    public interface FeedCommentListner {
        void contentClick(FeedComment feedComment);
    }

    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/comment/adapter/CommentListAdapter$LIKED.class */
    interface LIKED {
    }

    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/comment/adapter/CommentListAdapter$ViewHolder.class */
    class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f19425a;
        public ImageView b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f19426c;
        public TextView d;
        public TextView e;
        public ImageView f;
        public ImageView g;
        public TextView h;
        public ImageView i;
        public ImageView j;
        public ImageView k;
        public LinearLayout l;
        public TextView m;
        public View n;

        private ViewHolder() {
        }
    }

    public CommentListAdapter(Context context, IRequestHost iRequestHost, BluedIngSelfFeed bluedIngSelfFeed, FeedCommentListner feedCommentListner, String str, String str2) {
        this(context, iRequestHost, bluedIngSelfFeed, feedCommentListner, true, str, str2);
    }

    public CommentListAdapter(Context context, IRequestHost iRequestHost, BluedIngSelfFeed bluedIngSelfFeed, FeedCommentListner feedCommentListner, boolean z, String str, String str2) {
        this.f19407c = new ArrayList();
        this.h = true;
        this.k = 1;
        this.l = -1;
        this.f19406a = context;
        this.g = feedCommentListner;
        this.f = bluedIngSelfFeed;
        this.e = iRequestHost;
        this.h = z;
        this.j = str2;
        this.d = context.getResources().getDisplayMetrics().widthPixels;
        this.b = LayoutInflater.from(context);
        this.i = str;
    }

    private void a(final View view, final FeedComment feedComment) {
        if (feedComment != null) {
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.blued.community.ui.comment.adapter.CommentListAdapter.5
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    ArrayList arrayList = new ArrayList();
                    KeyboardUtils.b(CommentListAdapter.this.f19406a, view);
                    arrayList.add(CommentListAdapter.this.f19406a.getResources().getString(R.string.community_copy));
                    if (feedComment.user_allow_mute == CommentListAdapter.this.k) {
                        arrayList.add(CommentListAdapter.this.f19406a.getResources().getString(feedComment.is_muted == 1 ? R.string.circle_comments_list_cancel_mute : R.string.circle_comments_list_mute));
                    }
                    if (!CircleMethods.a(feedComment.comment_uid)) {
                        arrayList.add(CommentListAdapter.this.f19406a.getResources().getString(R.string.report));
                    }
                    if ("1".equals(feedComment.comment_allow_delete)) {
                        arrayList.add(CommentListAdapter.this.f19406a.getResources().getString(R.string.delete));
                    }
                    CommonShowBottomWindow.a((FragmentActivity) CommentListAdapter.this.f19406a, (String[]) arrayList.toArray(new String[arrayList.size()]), new ActionSheet.ActionSheetListener() { // from class: com.blued.community.ui.comment.adapter.CommentListAdapter.5.1
                        @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
                        public void a(ActionSheet actionSheet, int i) {
                            String a2 = actionSheet.a(i);
                            if (a2.equals(CommentListAdapter.this.f19406a.getResources().getString(R.string.community_copy))) {
                                CommentListAdapter.this.a(feedComment);
                            } else if (a2.equals(CommentListAdapter.this.f19406a.getResources().getString(R.string.delete))) {
                                CommentListAdapter.this.b(feedComment);
                            } else if (!a2.equals(CommentListAdapter.this.f19406a.getResources().getString(R.string.report))) {
                                if (a2.equals(CommentListAdapter.this.f19406a.getResources().getString(feedComment.is_muted == CommentListAdapter.this.k ? R.string.circle_comments_list_cancel_mute : R.string.circle_comments_list_mute))) {
                                    CommentListAdapter.this.a(feedComment, CommentListAdapter.this.e);
                                }
                            } else if (CommentListAdapter.this.b()) {
                                CommunityServiceManager.b().a(CommentListAdapter.this.f19406a, CommunityConstants.ReportType.FEED_COMMENT, feedComment.user_name, feedComment.feed_id, feedComment.comment_id);
                            } else {
                                CommunityServiceManager.b().a(CommentListAdapter.this.f19406a, CommunityConstants.ReportType.CIRCLE_COMMENT, feedComment.user_name, feedComment.feed_id, feedComment.comment_id);
                            }
                        }

                        @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
                        public void a(ActionSheet actionSheet, boolean z) {
                        }
                    });
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(FeedComment feedComment, View view) {
        if (CommunityServiceManager.a().b(this.f19406a)) {
            return;
        }
        this.g.contentClick(feedComment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FeedComment feedComment, ImageView imageView, TextView textView) {
        if (a()) {
            EventTrackFeed.a(FeedProtos.Event.FEED_INTERACTIVE, feedComment.feed_id, feedComment.iliked == 1 ? FeedProtos.InteractiveType.NO_LIKE : FeedProtos.InteractiveType.LIKE, FeedProtos.Location.COMMENT_DETAIL, feedComment.comment_id, feedComment.feed_uid);
        } else {
            EventTrackFeed.a(FeedProtos.Event.FEED_INTERACTIVE, feedComment.feed_id, feedComment.iliked == 1 ? FeedProtos.InteractiveType.NO_LIKE : FeedProtos.InteractiveType.LIKE, FeedProtos.Location.FEED_DETAIL, feedComment.comment_id, feedComment.feed_uid);
        }
        String str = feedComment.comment_id;
        String str2 = feedComment.feed_id;
        int i = feedComment.iliked == 0 ? 1 : 0;
        if (a()) {
            a(str, i);
        } else {
            CommentListDataObserver.a().a(str, i);
        }
        FeedHttpUtils.a(str2, str, i, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<CircleAddPoints>>(this.e) { // from class: com.blued.community.ui.comment.adapter.CommentListAdapter.10
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<CircleAddPoints> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData() || bluedEntityA.getSingleData().circle_active_liked_posting <= 0) {
                    return;
                }
                AppMethods.a((CharSequence) ("点赞成功，积分+" + bluedEntityA.getSingleData().circle_active_liked_posting));
            }
        }, this.e, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        return this.i.equals("feed_comment_floor");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        return TextUtils.isEmpty(this.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BluedIngSelfFeed c() {
        BluedIngSelfFeed bluedIngSelfFeed = this.f;
        BluedIngSelfFeed bluedIngSelfFeed2 = bluedIngSelfFeed;
        if (bluedIngSelfFeed == null) {
            bluedIngSelfFeed2 = new BluedIngSelfFeed();
        }
        return bluedIngSelfFeed2;
    }

    private void c(final FeedComment feedComment) {
        String string = feedComment.mute_type == 0 ? this.f19406a.getResources().getString(R.string.circle_mute_member_dialog_first_title) : feedComment.mute_type == 1 ? this.f19406a.getResources().getString(R.string.circle_mute_member_dialog_second_title) : this.f19406a.getResources().getString(R.string.circle_mute_member_dialog_third_title);
        Context context = this.f19406a;
        CommonAlertDialog.a(context, string, context.getResources().getString(R.string.circle_mute_member_dialog_content), this.f19406a.getResources().getString(R.string.circle_mute_member_dialog_btn), 0, new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.comment.adapter.CommentListAdapter.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                CommentListAdapter.this.d(feedComment);
            }
        }, this.f19406a.getResources().getString(R.string.cancel), this.f19406a.getResources().getColor(R.color.syc_A5A6B3), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final FeedComment feedComment) {
        CircleHttpUtils.a(feedComment.circle_id, new BluedUIHttpResponse(this.e) { // from class: com.blued.community.ui.comment.adapter.CommentListAdapter.8
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                feedComment.is_muted = 1;
                if (feedComment.mute_type == 0) {
                    feedComment.mute_type = 1;
                } else if (feedComment.mute_type == 1) {
                    feedComment.mute_type = 2;
                } else if (feedComment.mute_type == 2) {
                    feedComment.mute_type = 1009;
                } else {
                    feedComment.mute_type = 1009;
                }
                CommentListAdapter.this.notifyDataSetChanged();
                AppMethods.a((CharSequence) AppUtils.a(R.string.circle_post_detail_menu_mute_success));
            }
        }, feedComment.comment_uid, feedComment.is_anonym, feedComment.user_name, feedComment.user_avatar, this.e);
    }

    public void a(int i) {
        this.l = i;
    }

    public void a(FeedComment feedComment) {
        String str = feedComment.comment_content;
        if (Build.VERSION.SDK_INT < 11 || Build.VERSION.SDK_INT == 18) {
            ((ClipboardManager) this.f19406a.getSystemService(Context.CLIPBOARD_SERVICE)).setText(RegExpUtils.a(str));
        } else {
            try {
                ((android.content.ClipboardManager) this.f19406a.getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("simple text", RegExpUtils.a(str)));
            } catch (Exception e) {
            }
        }
        AppMethods.a((CharSequence) this.f19406a.getResources().getString(R.string.copy));
    }

    public void a(final FeedComment feedComment, IRequestHost iRequestHost) {
        if (feedComment.is_muted == 1) {
            CircleHttpUtils.a(feedComment.circle_id, new BluedUIHttpResponse(iRequestHost) { // from class: com.blued.community.ui.comment.adapter.CommentListAdapter.6
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity bluedEntity) {
                    feedComment.is_muted = 0;
                    CommentListAdapter.this.notifyDataSetChanged();
                    AppMethods.a((CharSequence) AppUtils.a(R.string.circle_post_detail_menu_mute_canceled_success));
                    if (feedComment.mute_type == 1009 || feedComment.mute_type == 1010) {
                        feedComment.mute_type = 0;
                    }
                }
            }, feedComment.comment_uid, feedComment.is_anonym, iRequestHost);
        } else {
            c(feedComment);
        }
    }

    @Override // com.blued.community.ui.feed.observer.CommentListDataObserver.ICommentDataObserver
    public void a(FeedComment feedComment, String str) {
        int i;
        int i2;
        if (feedComment != null && this.h) {
            feedComment.vbadge = feedComment.user_vbadge;
            if (a()) {
                int i3 = 0;
                while (true) {
                    i2 = i3;
                    if (i2 >= this.f19407c.size()) {
                        i2 = -1;
                        break;
                    } else if (this.f19407c.get(i2).isLastHotComment) {
                        break;
                    } else {
                        i3 = i2 + 1;
                    }
                }
                if (i2 == -1) {
                    this.f19407c.add(0, feedComment);
                } else {
                    this.f19407c.add(i2 + 1, feedComment);
                }
            } else if (!TextUtils.isEmpty(str)) {
                Iterator<FeedComment> it = this.f19407c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    FeedComment next = it.next();
                    if (str.equals(next.comment_id)) {
                        if (next.comments == null) {
                            next.comments = new ArrayList();
                        }
                        next.comments_count++;
                        next.comments.add(0, feedComment);
                    }
                }
            } else {
                int i4 = 0;
                while (true) {
                    i = i4;
                    if (i >= this.f19407c.size()) {
                        i = -1;
                        break;
                    } else if (this.f19407c.get(i).isLastHotComment) {
                        break;
                    } else {
                        i4 = i + 1;
                    }
                }
                if (i == -1) {
                    this.f19407c.add(0, feedComment);
                } else {
                    this.f19407c.add(i + 1, feedComment);
                }
            }
            notifyDataSetChanged();
        }
        if (feedComment == null || !this.h) {
            return;
        }
        feedComment.vbadge = feedComment.user_vbadge;
        notifyDataSetChanged();
    }

    @Override // com.blued.community.ui.feed.observer.CommentListDataObserver.ICommentDataObserver
    public void a(String str) {
        List<FeedComment> list;
        int i;
        if (TextUtils.isEmpty(str) || (list = this.f19407c) == null || list.size() <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.f19407c.size()) {
                if (str.equals(this.f19407c.get(i3).comment_id) && this.f19407c.get(i3).isLastHotComment && (i = i3 - 1) >= 0) {
                    this.f19407c.get(i).isLastHotComment = this.f19407c.get(i3).isLastHotComment;
                    this.f19407c.get(i).isHasMoreHotComment = this.f19407c.get(i3).isHasMoreHotComment;
                    break;
                }
                i2 = i3 + 1;
            } else {
                break;
            }
        }
        Iterator<FeedComment> it = this.f19407c.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().comment_id)) {
                it.remove();
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.blued.community.ui.feed.observer.CommentListDataObserver.ICommentDataObserver
    public void a(String str, int i) {
        List<FeedComment> list;
        if (TextUtils.isEmpty(str) || (list = this.f19407c) == null || list.size() <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.f19407c.size()) {
                notifyDataSetChanged();
                return;
            }
            if (str.equals(this.f19407c.get(i3).comment_id)) {
                this.f19407c.get(i3).iliked = i;
                if (i == 1) {
                    this.f19407c.get(i3).liked_count++;
                } else {
                    this.f19407c.get(i3).liked_count--;
                }
            }
            i2 = i3 + 1;
        }
    }

    public void a(List<FeedComment> list) {
        this.f19407c.clear();
        if (list != null && list.size() > 0) {
            this.f19407c.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void b(final FeedComment feedComment) {
        StringBuilder sb;
        String str;
        String string = this.f19406a.getString(R.string.hint);
        CharSequence a2 = StringUtils.a(feedComment.comment_content, false, true, false, "feed_detail");
        if (a2.length() > 14) {
            sb = new StringBuilder();
            sb.append((Object) a2.subSequence(0, 14));
            str = "...";
        } else {
            sb = new StringBuilder();
            sb.append((Object) a2);
            str = "";
        }
        sb.append(str);
        String format = String.format(this.f19406a.getResources().getString(R.string.delete_comment_confirm), sb.toString());
        Context context = this.f19406a;
        CommonAlertDialog.a(context, string, format, context.getResources().getString(R.string.delete), new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.comment.adapter.CommentListAdapter.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                FeedHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.blued.community.ui.comment.adapter.CommentListAdapter.9.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    /* renamed from: a */
                    public BluedEntityA<Object> parseData(String str2) {
                        return (BluedEntityA) super.parseData(str2);
                    }

                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    /* renamed from: a */
                    public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                        if (CommentListAdapter.this.a()) {
                            CommentListAdapter.this.a(feedComment.comment_id);
                        } else {
                            CommentListDataObserver.a().a(feedComment.comment_id);
                            LiveEventBus.get("feed_delete_comment").post(feedComment);
                        }
                        AppMethods.a((CharSequence) AppInfo.d().getResources().getString(R.string.del_success));
                    }

                    @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
                    public void onFailure(Throwable th, int i2, String str2) {
                        AppMethods.a((CharSequence) AppInfo.d().getResources().getString(R.string.common_net_error));
                        super.onFailure(th, i2, str2);
                    }
                }, TextUtils.isEmpty(CommentListAdapter.this.j), feedComment.feed_id, feedComment.comment_id, CommentListAdapter.this.c().is_ads, CommentListAdapter.this.e);
            }
        }, this.f19406a.getResources().getString(R.string.common_cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<FeedComment> list = this.f19407c;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x05f2  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x061f  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x066e  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View getView(final int r12, android.view.View r13, android.view.ViewGroup r14) {
        /*
            Method dump skipped, instructions count: 1772
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.community.ui.comment.adapter.CommentListAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        super.registerDataSetObserver(dataSetObserver);
        CommentListDataObserver.a().a(this);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        super.unregisterDataSetObserver(dataSetObserver);
        CommentListDataObserver.a().b(this);
    }
}
