package com.soft.blued.ui.feed.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.community.http.CircleHttpUtils;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.FeedNotice;
import com.blued.community.ui.comment.model.FeedComment;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.fragment.CommonWriteTextFragment;
import com.soft.blued.utils.StringUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/ReplyCommentFragment.class */
public class ReplyCommentFragment extends CommonWriteTextFragment {
    private static String k = "REPLY_ID";
    private static String l = "REPLY_UID";
    private static String m = "FID";
    private static String n = "FEED_ID";
    private static String o = "IS_ADS";
    private static String p = "AID";
    private static String q = "VID";
    private static String r = "IS_FEED";
    private static String s = "IS_ANONYMOUS";
    private boolean A;
    private int B;
    private Dialog C;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private boolean z;

    public static void a(Context context, FeedNotice feedNotice) {
        Bundle bundle = new Bundle();
        bundle.putString(DownloadSettingKeys.RetryScheduleConfig.MAX_COUNT, "256");
        bundle.putString("string_edit_hint", context.getResources().getString(2131892810));
        bundle.putString("string_edit", "");
        bundle.putString("string_center", context.getResources().getString(2131891494));
        bundle.putString("string_right", context.getResources().getString(R.string.send));
        bundle.putInt("REQUEST_CODE_KEY", 3);
        bundle.putString(k, feedNotice.comment_id);
        bundle.putString(n, feedNotice.feed_id);
        bundle.putInt(o, feedNotice.is_ads);
        bundle.putString(p, feedNotice.aid);
        bundle.putBoolean(r, feedNotice.from == 0);
        String str = s;
        boolean z = false;
        if (feedNotice.must_anonym_reply == 1) {
            z = true;
        }
        bundle.putBoolean(str, z);
        TerminalActivity.d(context, ReplyCommentFragment.class, bundle);
    }

    @Override // com.soft.blued.fragment.CommonWriteTextFragment
    public void a() {
        this.j.setCenterText(getString(2131891494));
        this.j.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.ReplyCommentFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ReplyCommentFragment.this.a(0);
            }
        });
        this.j.setRightText(R.string.send);
        this.j.setRightTextColor(2131101204);
        this.j.setRightClickListener(null);
        if (getArguments() != null) {
            this.t = getArguments().getString(k);
            this.u = getArguments().getString(l);
            this.v = getArguments().getString(m);
            this.w = getArguments().getString(n);
            this.B = getArguments().getInt(o);
            this.x = getArguments().getString(p);
            this.y = getArguments().getString(q);
            this.z = getArguments().getBoolean(r);
            this.A = getArguments().getBoolean(s);
        }
        a((TextWatcher) null);
    }

    @Override // com.soft.blued.fragment.CommonWriteTextFragment
    public void a(final TextWatcher textWatcher) {
        super.a(new TextWatcher() { // from class: com.soft.blued.ui.feed.fragment.ReplyCommentFragment.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                TextWatcher textWatcher2 = textWatcher;
                if (textWatcher2 != null) {
                    textWatcher2.afterTextChanged(editable);
                }
                if (StringUtils.d(editable.toString())) {
                    ReplyCommentFragment.this.j.setRightTextColor(2131101219);
                    ReplyCommentFragment.this.j.setRightClickListener(null);
                    return;
                }
                ReplyCommentFragment.this.j.setRightTextColor(2131101190);
                ReplyCommentFragment.this.j.setRightClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.ReplyCommentFragment.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        if (ReplyCommentFragment.this.d.length() > ReplyCommentFragment.this.b) {
                            AppMethods.a((CharSequence) String.format(ReplyCommentFragment.this.f29642a.getResources().getString(R.string.max_input_limit), Integer.valueOf(ReplyCommentFragment.this.b)));
                        } else {
                            ReplyCommentFragment.this.a(-1);
                        }
                    }
                });
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                TextWatcher textWatcher2 = textWatcher;
                if (textWatcher2 != null) {
                    textWatcher2.beforeTextChanged(charSequence, i, i2, i3);
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                TextWatcher textWatcher2 = textWatcher;
                if (textWatcher2 != null) {
                    textWatcher2.onTextChanged(charSequence, i, i2, i3);
                }
            }
        });
    }

    @Override // com.soft.blued.fragment.CommonWriteTextFragment
    public boolean a(int i, String str) {
        if (i != -1 || TextUtils.isEmpty(str) || getFragmentActive() == null || !getFragmentActive().isActive()) {
            return true;
        }
        if (this.C == null) {
            this.C = DialogUtils.a(getActivity());
        }
        FeedComment feedComment = new FeedComment();
        feedComment.comment_id = this.t;
        feedComment.is_ads = this.B;
        feedComment.aid = this.x;
        BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
        bluedIngSelfFeed.feed_id = this.w;
        BluedUIHttpResponse bluedUIHttpResponse = new BluedUIHttpResponse(getFragmentActive()) { // from class: com.soft.blued.ui.feed.fragment.ReplyCommentFragment.3
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(ReplyCommentFragment.this.C);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(ReplyCommentFragment.this.C);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                AppMethods.d((int) R.string.done);
                ReplyCommentFragment.this.getActivity().finish();
            }
        };
        if (this.z) {
            FeedHttpUtils.a(bluedUIHttpResponse, bluedIngSelfFeed, feedComment, str, getFragmentActive());
            return false;
        }
        CircleHttpUtils.a(bluedUIHttpResponse, bluedIngSelfFeed, feedComment, str, this.A, -1, getFragmentActive());
        return false;
    }
}
