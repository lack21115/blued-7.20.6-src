package com.soft.blued.ui.notify.adapter;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.community.http.CircleHttpUtils;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.circle.fragment.CircleDetailsFragment;
import com.blued.community.ui.circle.fragment.CirclePostDetailsFragment;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.notify.model.CircleNotify;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.web.WebViewShowInfoFragment;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/notify/adapter/CircleNotifyAdapter.class */
public class CircleNotifyAdapter extends BaseQuickAdapter<CircleNotify, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Context f19179a;
    private IRequestHost b;

    public CircleNotifyAdapter(Context context, IRequestHost iRequestHost) {
        super((int) R.layout.item_circle_notify);
        this.f19179a = context;
        this.b = iRequestHost;
    }

    private void a(BaseViewHolder baseViewHolder, final CircleNotify circleNotify, boolean z) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_circle);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_circle);
        ShapeTextView view = baseViewHolder.getView(R.id.stv_to_circle);
        ImageLoader.a(this.b, circleNotify.cover).b((int) R.drawable.circle_default_icon).a(8.0f).a(imageView);
        textView.setText(circleNotify.title);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.soft.blued.ui.notify.adapter.CircleNotifyAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                CircleDetailsFragment.b(CircleNotifyAdapter.this.f19179a, circleNotify.circle_id, circleNotify.from);
            }
        };
        imageView.setOnClickListener(onClickListener);
        textView.setOnClickListener(onClickListener);
        if (!z) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        view.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CircleNotify circleNotify) {
        CircleHttpUtils.b(new BluedUIHttpResponse(this.b) { // from class: com.soft.blued.ui.notify.adapter.CircleNotifyAdapter.7
            public void onUIUpdate(BluedEntity bluedEntity) {
            }
        }, circleNotify.id, 1, this.b);
    }

    private void b(BaseViewHolder baseViewHolder, final CircleNotify circleNotify) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_circle_feed);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_circle_feed);
        ShapeTextView view = baseViewHolder.getView(R.id.stv_to_circle_feed);
        ImageLoader.a(this.b, circleNotify.cover).b((int) R.drawable.circle_default_icon).a(8.0f).a(imageView);
        textView.setText(circleNotify.title);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.soft.blued.ui.notify.adapter.CircleNotifyAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                EventTrackFeed.d(FeedProtos.Event.MSG_NOTICE_CIRCLE_VIEW_CLICK, circleNotify.circle_id, circleNotify.posting_id);
                if (circleNotify.type == 5) {
                    WebViewShowInfoFragment.show(CircleNotifyAdapter.this.f19179a, H5Url.a(57, new Object[]{EncryptTool.b(circleNotify.circle_id)}));
                } else {
                    CirclePostDetailsFragment.a(CircleNotifyAdapter.this.f19179a, circleNotify.posting_id, FeedProtos.NoteSource.CIRCLE_ESSENCE);
                }
            }
        };
        imageView.setOnClickListener(onClickListener);
        textView.setOnClickListener(onClickListener);
        view.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CircleNotify circleNotify) {
        CircleHttpUtils.b(new BluedUIHttpResponse(this.b) { // from class: com.soft.blued.ui.notify.adapter.CircleNotifyAdapter.8
            public void onUIUpdate(BluedEntity bluedEntity) {
            }
        }, circleNotify.id, 2, this.b);
    }

    private void c(BaseViewHolder baseViewHolder, final CircleNotify circleNotify) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_user_header);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_user_name);
        ImageLoader.a(this.b, circleNotify.ops_avatar).b(2131237310).a(40.0f).a(imageView);
        textView.setText(circleNotify.ops_name);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.soft.blued.ui.notify.adapter.CircleNotifyAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackFeed.f(FeedProtos.Event.MSG_NOTICE_CIRCLE_JOIN_USER_CLICK, circleNotify.circle_id, circleNotify.ops_uid);
                UserInfoFragmentNew.a(CircleNotifyAdapter.this.f19179a, circleNotify.ops_uid, "CIRCLE_NOTIFY");
            }
        };
        imageView.setOnClickListener(onClickListener);
        textView.setOnClickListener(onClickListener);
        ShapeTextView view = baseViewHolder.getView(R.id.stv_agree);
        ShapeTextView view2 = baseViewHolder.getView(R.id.stv_deny);
        int i = circleNotify.result;
        if (i == 0) {
            view.setVisibility(0);
            view2.setVisibility(0);
            view.setText((int) R.string.circle_agree);
            view2.setText((int) R.string.circle_deny);
            view.setTextColor(BluedSkinUtils.a(this.f19179a, 2131101766));
            view2.setTextColor(BluedSkinUtils.a(this.f19179a, 2131101766));
            view.setEnabled(true);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.notify.adapter.CircleNotifyAdapter.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Tracker.onClick(view3);
                    EventTrackFeed.a(FeedProtos.Event.MSG_NOTICE_CIRCLE_JOIN_AGREE_CLICK, circleNotify.circle_id, circleNotify.ops_uid, circleNotify.type == 1);
                    CircleNotifyAdapter.this.a(circleNotify);
                    circleNotify.result = 1;
                    CircleNotifyAdapter.this.notifyDataSetChanged();
                }
            });
            view2.setEnabled(true);
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.notify.adapter.CircleNotifyAdapter.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Tracker.onClick(view3);
                    FeedProtos.Event event = FeedProtos.Event.MSG_NOTICE_CIRCLE_JOIN_REJECT_CLICK;
                    String str = circleNotify.circle_id;
                    String str2 = circleNotify.ops_uid;
                    boolean z = true;
                    if (circleNotify.type != 1) {
                        z = false;
                    }
                    EventTrackFeed.a(event, str, str2, z);
                    CircleNotifyAdapter.this.b(circleNotify);
                    circleNotify.result = 2;
                    CircleNotifyAdapter.this.notifyDataSetChanged();
                }
            });
        } else if (i == 1) {
            view.setVisibility(0);
            view2.setVisibility(8);
            view.setText((int) R.string.circle_agreed);
            view.setTextColor(BluedSkinUtils.a(this.f19179a, 2131102263));
            view.setOnClickListener((View.OnClickListener) null);
            view.setEnabled(false);
        } else if (i != 2) {
        } else {
            view.setVisibility(8);
            view2.setVisibility(0);
            view2.setText((int) R.string.circle_denied);
            view2.setTextColor(BluedSkinUtils.a(this.f19179a, 2131102263));
            view2.setOnClickListener((View.OnClickListener) null);
            view2.setEnabled(false);
        }
    }

    private void d(BaseViewHolder baseViewHolder, final CircleNotify circleNotify) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_circle_top);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_circle_top);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_mute_range);
        baseViewHolder.setGone(R.id.tv_mute_range, circleNotify.mute_type > 0);
        if (circleNotify.mute_type > 0) {
            int i = circleNotify.mute_type;
            if (i == 1) {
                String string = this.f19179a.getResources().getString(R.string.user_muted_once);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f19179a.getResources().getColor(2131102254)), string.length() - 2, string.length() - 1, 34);
                textView2.setText(spannableStringBuilder);
            } else if (i == 2) {
                String string2 = this.f19179a.getResources().getString(R.string.user_muted_twice);
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(string2);
                spannableStringBuilder2.setSpan(new ForegroundColorSpan(this.f19179a.getResources().getColor(2131102254)), string2.length() - 2, string2.length() - 1, 34);
                textView2.setText(spannableStringBuilder2);
            } else if (i == 1009) {
                textView2.setText(this.f19179a.getResources().getString(R.string.user_muted_circle));
            } else if (i == 1010) {
                textView2.setText(this.f19179a.getResources().getString(R.string.user_muted_all_circle));
            }
        }
        ImageLoader.a(this.b, circleNotify.cover).b((int) R.drawable.circle_default_icon).a(8.0f).a(imageView);
        textView.setText(circleNotify.title);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.soft.blued.ui.notify.adapter.CircleNotifyAdapter.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CircleDetailsFragment.b(CircleNotifyAdapter.this.f19179a, circleNotify.circle_id, circleNotify.from);
            }
        };
        imageView.setOnClickListener(onClickListener);
        textView.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, CircleNotify circleNotify) {
        int i = circleNotify.type;
        if (i == 1) {
            baseViewHolder.setGone(R.id.layout_circle_top, true);
            baseViewHolder.setGone(R.id.layout_user, true);
            baseViewHolder.setGone(R.id.layout_circle, false);
            baseViewHolder.setGone(R.id.layout_circle_feed, false);
            d(baseViewHolder, circleNotify);
            c(baseViewHolder, circleNotify);
        } else if (i == 2) {
            baseViewHolder.setGone(R.id.layout_circle_top, false);
            baseViewHolder.setGone(R.id.layout_user, false);
            baseViewHolder.setGone(R.id.layout_circle, true);
            baseViewHolder.setGone(R.id.layout_circle_feed, false);
            a(baseViewHolder, circleNotify, true);
        } else if (i == 3) {
            baseViewHolder.setGone(R.id.layout_circle_top, false);
            baseViewHolder.setGone(R.id.layout_user, false);
            baseViewHolder.setGone(R.id.layout_circle, true);
            baseViewHolder.setGone(R.id.layout_circle_feed, false);
            a(baseViewHolder, circleNotify, false);
        } else if (i == 4 || i == 5) {
            baseViewHolder.setGone(R.id.layout_circle_top, false);
            baseViewHolder.setGone(R.id.layout_user, false);
            baseViewHolder.setGone(R.id.layout_circle, false);
            baseViewHolder.setGone(R.id.layout_circle_feed, true);
            b(baseViewHolder, circleNotify);
        }
        baseViewHolder.setText(R.id.stv_content, circleNotify.text);
        baseViewHolder.setText(R.id.tv_date_time, TimeAndDateUtils.e(this.f19179a, TimeAndDateUtils.c(circleNotify.timestamp)));
    }
}
