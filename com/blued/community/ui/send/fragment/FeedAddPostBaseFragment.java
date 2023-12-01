package com.blued.community.ui.send.fragment;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.util.Pair;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.sdk.util.i;
import com.app.share.model.ShareEntity;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.activity.BroadcastFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.upload.qiniu.UploadModel;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.base.data_statistics.StatisticsProxy;
import com.blued.android.module.base.shortvideo.ISaveInterface;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;
import com.blued.android.module.base.shortvideo.StvResultModel;
import com.blued.android.module.common.db.NewFeedDao;
import com.blued.android.module.common.db.model.NewFeedModel;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.android.module.common.utils.click.SingleItemChildClickProxy;
import com.blued.android.module.common.utils.gaode.GaoDeUtils;
import com.blued.android.module.common.utils.gaode.OnPOIListener;
import com.blued.android.module.common.utils.gaode.PositionPOIModel;
import com.blued.android.module.common.widget.emoji.manager.Emoji;
import com.blued.android.module.common.widget.emoji.view.EmojiKeyboardLayout;
import com.blued.android.module.common.widget.emoticon.ui.Emotion;
import com.blued.android.module.common.widget.menu.ActionSheet;
import com.blued.android.module.common.widget.menu.CommonShowBottomWindow;
import com.blued.android.module.common.widget.pop.BluedPopupWindow;
import com.blued.android.module.common.widget.pop.GestureAnimTipView;
import com.blued.android.module.media.selector.model.AlbumSelectInfo;
import com.blued.android.module.shortvideo.model.EditDataModel;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.manager.ChildPhotoManager;
import com.blued.community.manager.CommunityManager;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.FeedExtra;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.circle.model.MyCircleModel;
import com.blued.community.ui.event.model.EventDetailsModel;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.send.adapter.AddPostImageAdapter;
import com.blued.community.ui.send.dialog.AlbumSelectDialogFragment;
import com.blued.community.ui.send.dialog.SelectLocationDialogFragment;
import com.blued.community.ui.send.fragment.FeedAddPostBaseFragment;
import com.blued.community.ui.send.manager.FeedSendManager;
import com.blued.community.ui.send.manager.SelectPhotoManager;
import com.blued.community.ui.send.manager.VideoUploadManager;
import com.blued.community.ui.send.model.ChildImageInfo;
import com.blued.community.ui.send.observer.IAddPost;
import com.blued.community.ui.send.observer.OnAddPostTitleListener;
import com.blued.community.ui.send.view.FeedPostAuthView;
import com.blued.community.ui.send.vm.FeedPostViewModel;
import com.blued.community.ui.send.vm.SelectAlbumViewModel;
import com.blued.community.ui.send.vm.SelectLocationViewModel;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.community.utils.AtUserHelper;
import com.blued.community.utils.CommunityPreferences;
import com.blued.community.utils.MarkDownLinkHelper;
import com.blued.community.utils.StringUtils;
import com.blued.community.utils.UserInfoUtils;
import com.blued.community.utils.ViewUtils;
import com.blued.community.view.EditInputNumView;
import com.blued.community.view.SelectionEditText;
import com.blued.community.view.TextViewFixTouchForDynamic;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/fragment/FeedAddPostBaseFragment.class */
public class FeedAddPostBaseFragment extends BroadcastFragment implements View.OnClickListener, IAddPost {
    protected TextView A;
    protected LinearLayout B;
    protected TextViewFixTouchForDynamic C;
    protected LinearLayout D;
    protected ImageView E;
    protected TextView F;
    protected CardView G;
    protected ImageView H;
    protected ImageView I;
    protected View J;
    protected View K;
    protected ShapeLinearLayout L;
    protected ImageView M;
    protected TextView N;
    protected ImageView O;
    protected FeedPostAuthView P;
    protected View Q;
    protected ImageView R;
    protected ImageView S;
    protected ImageView T;
    protected ImageView U;
    protected ImageView V;
    protected EmojiKeyboardLayout W;
    protected View X;
    protected CheckBox Y;
    protected Bundle aA;
    BluedPopupWindow aM;
    GestureAnimTipView aN;
    private int aQ;
    private FeedPostViewModel aR;
    private SelectLocationViewModel aS;
    private OnAddPostTitleListener aT;
    private int aV;
    private int aW;
    private SpannableStringBuilder aX;
    private SpannableStringBuilder aY;
    protected AlbumSelectDialogFragment aa;
    protected RecyclerView ab;
    protected AddPostImageAdapter ac;
    protected boolean ae;
    protected Emotion af;
    protected BluedIngSelfFeed ag;
    protected NewFeedModel ah;
    protected ShareEntity ai;
    protected BluedTopic aj;
    protected MyCircleModel ak;
    protected StvResultModel al;
    protected EventDetailsModel am;
    protected boolean ao;
    protected boolean ap;
    protected String aq;
    protected boolean ar;
    protected boolean as;
    protected boolean at;
    protected boolean au;
    protected boolean av;
    protected StvResultModel aw;
    protected String ax;
    protected EditDataModel.SerializableData ay;
    public SelectAlbumViewModel az;
    protected Context c;
    protected View j;
    protected KeyboardListenLinearLayout k;
    protected LinearLayout l;
    protected ImageView m;
    protected ShapeTextView n;
    protected SelectionEditText o;
    protected View p;
    protected EditInputNumView q;
    protected LinearLayout r;
    protected CardView s;
    protected LinearLayout t;
    protected ImageView u;
    protected TextView v;
    protected TextView w;
    protected LinearLayout x;
    protected TextView y;
    protected ImageView z;
    private int b = KeyboardUtils.a();
    protected boolean Z = true;
    protected boolean ad = false;
    protected int an = -1;
    private boolean aO = false;
    private boolean aP = false;
    protected String aB = "";
    protected String aC = "";
    protected String aD = "";
    protected final int aE = 0;
    protected final int aF = 1;
    protected final int aG = 2;
    protected final int aH = 3;
    protected int aI = 0;
    protected int aJ = 0;
    protected int aK = 0;
    protected int aL = 0;
    private TextWatcher aU = new TextWatcher() { // from class: com.blued.community.ui.send.fragment.FeedAddPostBaseFragment.14
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            FeedAddPostBaseFragment.this.a(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            FeedAddPostBaseFragment.this.aX = new SpannableStringBuilder(charSequence);
            FeedAddPostBaseFragment feedAddPostBaseFragment = FeedAddPostBaseFragment.this;
            feedAddPostBaseFragment.aV = feedAddPostBaseFragment.o.getSelectionStart();
            FeedAddPostBaseFragment feedAddPostBaseFragment2 = FeedAddPostBaseFragment.this;
            feedAddPostBaseFragment2.aW = feedAddPostBaseFragment2.o.getSelectionEnd();
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            FeedAddPostBaseFragment.this.aY = new SpannableStringBuilder(charSequence);
        }
    };
    private DialogInterface.OnDismissListener aZ = new DialogInterface.OnDismissListener() { // from class: com.blued.community.ui.send.fragment.FeedAddPostBaseFragment.16
        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            FeedAddPostBaseFragment.this.af();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.community.ui.send.fragment.FeedAddPostBaseFragment$1  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/fragment/FeedAddPostBaseFragment$1.class */
    public class AnonymousClass1 implements PermissionCallbacks {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(int i, List list, boolean z) {
            if (i != 0 || list.size() <= 0) {
                return;
            }
            String str = ((PositionPOIModel) list.get(0)).city;
            String str2 = ((PositionPOIModel) list.get(0)).area;
            String str3 = str2;
            if (str2 != null) {
                str3 = str2;
                if (str != null) {
                    str3 = str2;
                    if (!str2.contains(str)) {
                        str3 = str + str2;
                    }
                }
            }
            FeedAddPostBaseFragment.this.aS.e().postValue(str);
            FeedAddPostBaseFragment.this.aS.f().postValue(str3);
            FeedAddPostBaseFragment.this.aS.a(((PositionPOIModel) list.get(0)).address);
            FeedAddPostBaseFragment.this.aS.c(((PositionPOIModel) list.get(0)).latitude);
            FeedAddPostBaseFragment.this.aS.b(((PositionPOIModel) list.get(0)).longitude);
            FeedAddPostBaseFragment.this.aj();
        }

        @Override // com.blued.android.framework.permission.PermissionCallbacks
        public void U_() {
            GaoDeUtils.a(FeedAddPostBaseFragment.this.getViewLifecycleOwner(), 0, new OnPOIListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedAddPostBaseFragment$1$Hmopc83uDqozydGy-3-VqrNwgds
                @Override // com.blued.android.module.common.utils.gaode.OnPOIListener
                public final void onComplete(int i, List list, boolean z) {
                    FeedAddPostBaseFragment.AnonymousClass1.this.a(i, list, z);
                }
            });
        }

        @Override // com.blued.android.framework.permission.PermissionCallbacks
        public void a(String[] strArr) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.community.ui.send.fragment.FeedAddPostBaseFragment$11  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/fragment/FeedAddPostBaseFragment$11.class */
    public class AnonymousClass11 implements OnItemDragListener {
        AnonymousClass11() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            FeedAddPostBaseFragment.this.ac.b();
        }

        public void a(RecyclerView.ViewHolder viewHolder, int i) {
            FeedAddPostBaseFragment.this.ah();
            FeedAddPostBaseFragment.this.d("onItemDragStart");
            ((BaseViewHolder) viewHolder).setGone(R.id.drag, true);
        }

        public void a(RecyclerView.ViewHolder viewHolder, int i, RecyclerView.ViewHolder viewHolder2, int i2) {
        }

        public void b(RecyclerView.ViewHolder viewHolder, int i) {
            ((BaseViewHolder) viewHolder).setGone(R.id.drag, false);
            FeedAddPostBaseFragment.this.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedAddPostBaseFragment$11$4_Jm0GUGtoHGhe6i6aRjGHWByA4
                @Override // java.lang.Runnable
                public final void run() {
                    FeedAddPostBaseFragment.AnonymousClass11.this.a();
                }
            });
        }
    }

    private void A() {
        BluedIngSelfFeed bluedIngSelfFeed = this.ag;
        if (bluedIngSelfFeed == null || bluedIngSelfFeed.repost == null) {
            this.Y.setVisibility(8);
            return;
        }
        this.ap = true;
        this.Y.setVisibility(0);
        if (this.ag.repost.is_url == 1) {
            this.B.setVisibility(0);
            if (this.ag.repost.is_feed_anonym == 1) {
                BluedIngSelfFeed bluedIngSelfFeed2 = this.ag.repost;
                bluedIngSelfFeed2.feed_content = this.ag.repost.user_name + "：" + this.ag.repost.feed_content;
            } else {
                BluedIngSelfFeed bluedIngSelfFeed3 = this.ag.repost;
                bluedIngSelfFeed3.feed_content = StringUtils.b(this.ag.repost.user_name, this.ag.repost.feed_uid) + "：" + this.ag.repost.feed_content;
            }
            this.C.setText(StringUtils.a(AtUserHelper.a(StringUtils.a(this.ag.repost.feed_content, (int) this.C.getTextSize(), 0), BluedSkinUtils.a(this.c, R.color.syc_m)), true, new boolean[0]));
            this.C.setVisibility(0);
            if (this.ag.repost.feed_extras != null) {
                if (!TextUtils.isEmpty(this.ag.repost.feed_extras.title)) {
                    this.F.setText(this.ag.repost.feed_extras.title);
                }
                if (this.ag.repost.feed_extras.thumb == null || this.ag.repost.feed_extras.thumb.size() <= 0) {
                    return;
                }
                ImageLoader.a(getFragmentActive(), this.ag.repost.feed_extras.thumb.get(0)).b(R.drawable.feed_photo_default).a(this.E);
                return;
            }
            return;
        }
        this.s.setVisibility(0);
        BluedIngSelfFeed bluedIngSelfFeed4 = this.ag.repost;
        if (bluedIngSelfFeed4 != null) {
            if (bluedIngSelfFeed4.is_share_super_topics == 1) {
                this.v.setText(bluedIngSelfFeed4.share_s_t_name);
                ImageLoader.a(getFragmentActive(), bluedIngSelfFeed4.share_s_t_avatar).b(R.drawable.defaultpicture).a(this.u);
                if (TextUtils.isEmpty(bluedIngSelfFeed4.share_s_t_des)) {
                    this.w.setText(this.c.getResources().getString(R.string.share_topic_to_you));
                } else {
                    this.w.setText(a(bluedIngSelfFeed4.share_s_t_des));
                }
                this.s.findViewById(R.id.view_share_corner).setVisibility(0);
            } else if (this.ag.is_share_posting == 1) {
                this.ar = true;
                this.Y.setVisibility(0);
                this.v.setText(bluedIngSelfFeed4.circle_title);
                if (bluedIngSelfFeed4.is_video_posts == 1 && bluedIngSelfFeed4.feed_videos != null && bluedIngSelfFeed4.feed_videos.length > 0) {
                    ImageLoader.a(getFragmentActive(), bluedIngSelfFeed4.feed_videos[0]).b(R.drawable.circle_default_icon).a(this.u);
                } else if (bluedIngSelfFeed4.feed_pics == null || bluedIngSelfFeed4.feed_pics.length <= 0) {
                    this.u.setImageResource(R.drawable.circle_default_icon);
                } else {
                    ImageLoader.a(getFragmentActive(), bluedIngSelfFeed4.feed_pics[0]).b(R.drawable.circle_default_icon).a(this.u);
                }
                this.w.setText(a(bluedIngSelfFeed4.feed_pure_content));
            } else if (bluedIngSelfFeed4.is_share_posting == 1) {
                this.ar = true;
                this.Y.setVisibility(0);
                this.v.setText(bluedIngSelfFeed4.share_circle_title);
                ImageLoader.a(getFragmentActive(), bluedIngSelfFeed4.share_circle_posting_pic).b(R.drawable.circle_default_icon).d(R.drawable.circle_default_icon).a(this.u);
                this.w.setText(a(bluedIngSelfFeed4.share_circle_posting_content));
            } else if (this.ag.is_share_circle == 1 || bluedIngSelfFeed4.is_share_circle == 1) {
                if (this.ag.is_share_circle == 1) {
                    this.ag.feed_content = null;
                    bluedIngSelfFeed4 = this.ag;
                }
                this.as = true;
                this.Y.setVisibility(0);
                this.s.setVisibility(0);
                NewFeedModel newFeedModel = new NewFeedModel();
                this.ah = newFeedModel;
                newFeedModel.is_share_circle = 1;
                this.ah.share_circle_id = bluedIngSelfFeed4.join_circle_id;
                this.ah.forwardName = bluedIngSelfFeed4.join_circle_title;
                this.ah.forwardContent = bluedIngSelfFeed4.join_circle_description;
                this.ah.forwardImage = bluedIngSelfFeed4.join_circle_pic;
            } else if (this.ag.is_share_activity != 1 && bluedIngSelfFeed4.is_share_activity != 1) {
                this.v.setText(bluedIngSelfFeed4.user_name);
                String str = (bluedIngSelfFeed4.feed_pics == null || bluedIngSelfFeed4.feed_pics.length <= 0) ? bluedIngSelfFeed4.user_avatar : bluedIngSelfFeed4.feed_pics[0];
                ImageWrapper b = ImageLoader.a(getFragmentActive(), str).b(R.drawable.defaultpicture);
                if (bluedIngSelfFeed4.is_feed_anonym == 1 && TextUtils.equals(str, bluedIngSelfFeed4.user_avatar)) {
                    b.d();
                }
                b.a(this.u);
                if (!TextUtils.isEmpty(bluedIngSelfFeed4.feed_content)) {
                    this.w.setText(a(bluedIngSelfFeed4.feed_content));
                } else if ("1".equals(bluedIngSelfFeed4.is_videos)) {
                    this.w.setText(this.c.getResources().getString(R.string.repost_share_video));
                } else {
                    this.w.setText(this.c.getResources().getString(R.string.repost_share_pic));
                }
            } else {
                if (this.ag.is_share_activity == 1) {
                    this.ag.feed_content = null;
                    bluedIngSelfFeed4 = this.ag;
                }
                this.au = true;
                this.s.setVisibility(0);
                this.w.setVisibility(8);
                this.x.setVisibility(0);
                this.v.setTextSize(17.0f);
                NewFeedModel newFeedModel2 = new NewFeedModel();
                this.ah = newFeedModel2;
                newFeedModel2.is_share_activity = 1;
                this.ah.share_activity_id = bluedIngSelfFeed4.share_activity_id;
                this.ah.forwardImage = bluedIngSelfFeed4.share_activity_pic;
                this.ah.forwardName = bluedIngSelfFeed4.share_activity_title;
                this.ah.share_activity_time = TimeAndDateUtils.e(TimeAndDateUtils.j(bluedIngSelfFeed4.share_activity_time));
                this.ah.share_activity_location = bluedIngSelfFeed4.share_activity_address;
                this.ah.share_activity_mode_id = bluedIngSelfFeed4.share_activity_mode_id;
            }
        }
    }

    private void B() {
        A();
        O();
        int i = this.an;
        if (i != 0 && i != 2) {
            if (i == 1) {
                c(this.ai.content);
                return;
            } else if (i == 1) {
                c(this.ai.content);
                return;
            } else {
                return;
            }
        }
        this.ao = true;
        this.s.setVisibility(0);
        this.v.setLines(2);
        String str = this.ai.netImgUrl;
        String str2 = str;
        if (this.ai.flag == 0) {
            str2 = str;
            if (!TextUtils.isEmpty(this.ai.fileUrl)) {
                str2 = this.ai.fileUrl;
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            (str2.contains("http") ? ImageLoader.a(getFragmentActive(), str2) : ImageLoader.d(getFragmentActive(), str2)).b(R.drawable.feed_photo_default).a(this.u);
        }
        ShareEntity shareEntity = this.ai;
        if (shareEntity != null) {
            if (TextUtils.isEmpty(shareEntity.title)) {
                this.v.setText(this.ai.linkUrl);
            } else {
                this.v.setText(this.ai.title);
            }
            this.w.setVisibility(8);
        }
    }

    private void C() {
        this.q.init(this.o, s());
        this.o.setHint(G());
        this.o.addTextChangedListener(this.aU);
        if (this.an == 0 && this.ai != null) {
            this.o.setText("");
            return;
        }
        BluedIngSelfFeed bluedIngSelfFeed = this.ag;
        if (bluedIngSelfFeed != null) {
            String str = bluedIngSelfFeed.feed_content;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            c(str);
            this.aq = this.o.getText().toString();
            this.o.setSelection(0);
        }
        NewFeedModel newFeedModel = this.ah;
        if (newFeedModel != null) {
            String content = newFeedModel.getContent();
            if (TextUtils.isEmpty(content)) {
                return;
            }
            c(content);
        }
    }

    private void D() {
        this.o = this.j.findViewById(R.id.edt_news_feed);
        this.p = this.j.findViewById(R.id.feed_add_post_text_num_layout);
        this.q = this.j.findViewById(R.id.inv_word_count);
        this.af = new Emotion(this.c);
        this.o.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.community.ui.send.fragment.FeedAddPostBaseFragment.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == FeedAddPostBaseFragment.this.o.getId()) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    if (motionEvent.getAction() == 1) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    FeedAddPostBaseFragment.this.a(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        MarkDownLinkHelper.a(this.o);
        AtUserHelper.a(this.o);
    }

    private void E() {
        EmojiKeyboardLayout emojiKeyboardLayout = (EmojiKeyboardLayout) this.j.findViewById(R.id.emoticon_layout);
        this.W = emojiKeyboardLayout;
        emojiKeyboardLayout.setKeyboardColor(2);
        this.W.setFragmentManager(getChildFragmentManager());
        this.W.setEmojiCallback(new EmojiKeyboardLayout.EmojiCallback() { // from class: com.blued.community.ui.send.fragment.FeedAddPostBaseFragment.9
            @Override // com.blued.android.module.common.widget.emoji.view.EmojiKeyboardLayout.EmojiCallback
            public void a() {
                FeedAddPostBaseFragment.this.o.onKeyDown(67, new KeyEvent(0, 67));
            }

            @Override // com.blued.android.module.common.widget.emoji.view.EmojiKeyboardLayout.EmojiCallback
            public void a(Emoji emoji) {
                SpannableString spannableString = new SpannableString(emoji.a());
                if (FeedAddPostBaseFragment.this.f.getText().length() + spannableString.length() <= FeedAddPostBaseFragment.this.s()) {
                    FeedAddPostBaseFragment.this.o.getText().insert(FeedAddPostBaseFragment.this.o.getSelectionStart(), spannableString);
                }
            }
        });
    }

    private void F() {
        KeyboardListenLinearLayout keyboardListenLinearLayout = (KeyboardListenLinearLayout) this.j.findViewById(R.id.keyboardLinearLayout);
        this.k = keyboardListenLinearLayout;
        keyboardListenLinearLayout.setBackgroundColor(BluedSkinUtils.a(this.c, R.color.syc_b));
        super.a(this.X, this.k, this.o);
    }

    private CharSequence a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return AtUserHelper.a(MarkDownLinkHelper.a(AppInfo.d(), StringUtils.a(new SpannableStringBuilder(str), DensityUtils.a(this.c, 14.0f), 1), true, R.color.syc_m, false, (MarkDownLinkHelper.MDLinkOnClickListener) null), BluedSkinUtils.a(this.c, R.color.syc_m));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent) {
        StvResultModel stvResultModel;
        if (intent == null || (stvResultModel = (StvResultModel) intent.getSerializableExtra("result_model")) == null) {
            return;
        }
        if (!stvResultModel.a()) {
            this.av = false;
            ChildImageInfo childImageInfo = new ChildImageInfo();
            childImageInfo.mImagePath = stvResultModel.b();
            SelectPhotoManager.a().a(childImageInfo);
            this.az.a(stvResultModel.b());
            R();
            return;
        }
        Log.d("chenjiemei", "SHINE_OR_TAKE_PHOTO");
        if (intent.getSerializableExtra("serializeble_data") != null) {
            this.ay = (EditDataModel.SerializableData) intent.getSerializableExtra("serializeble_data");
        }
        this.av = true;
        this.aw = stvResultModel;
        Log.d("chenjiemei", "SHINE_OR_TAKE_PHOTO stvResultModel firstimage" + this.aw.c());
        this.G.setVisibility(0);
        ImageLoader.d(getFragmentActive(), this.aw.c()).b(R.drawable.feed_photo_default).a(this.H);
        ap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(File file, Exception exc) {
        if (file == null || !file.exists()) {
            ImageFileLoader.a(getFragmentActive()).a("http://7vznnm.com2.z0.glb.qiniucdn.com/blued-logo.png-500").a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedAddPostBaseFragment$y2jI3l28Mn9f3vtou0du5y8aJoU
                @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
                public final void onUIFinish(File file2, Exception exc2) {
                    FeedAddPostBaseFragment.this.b(file2, exc2);
                }
            }).a();
            return;
        }
        SelectPhotoManager.a().a(new ChildImageInfo(file.getPath()));
        this.ac.a();
    }

    private void ai() {
        this.ab = this.j.findViewById(R.id.rv_photo);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.c, 3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.blued.community.ui.send.fragment.FeedAddPostBaseFragment.10
            public int getSpanSize(int i) {
                return ((ChildImageInfo) FeedAddPostBaseFragment.this.ac.getData().get(i)).itemType == 1 ? 2 : 1;
            }
        });
        this.ab.setLayoutManager(gridLayoutManager);
        AnonymousClass11 anonymousClass11 = new AnonymousClass11();
        this.ac = new AddPostImageAdapter(getFragmentActive());
        ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback(this.ac);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);
        itemTouchHelper.attachToRecyclerView(this.ab);
        itemDragAndSwipeCallback.a(15);
        itemDragAndSwipeCallback.b(48);
        this.ac.h();
        this.ac.a(itemTouchHelper);
        this.ac.a(anonymousClass11);
        this.ac.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.community.ui.send.fragment.FeedAddPostBaseFragment.12
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                FeedAddPostBaseFragment.this.ah();
                CommunityServiceManager.b().a((Context) FeedAddPostBaseFragment.this.getActivity(), i, 0, (LoadOptions) null);
            }
        });
        this.ac.setOnItemChildClickListener(new SingleItemChildClickProxy(new BaseQuickAdapter.OnItemChildClickListener() { // from class: com.blued.community.ui.send.fragment.FeedAddPostBaseFragment.13
            public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                int id = view.getId();
                if (id != R.id.iv_image_delete) {
                    if (id != R.id.img_add) {
                        int i2 = R.id.add_post_audit_layout;
                        return;
                    }
                    EventTrackFeed.a(FeedProtos.Event.FEED_ADD_PHOTO, FeedProtos.AddType.ADD, FeedAddPostBaseFragment.this.u());
                    FeedAddPostBaseFragment.this.al();
                    return;
                }
                SelectPhotoManager.a().b((ChildImageInfo) FeedAddPostBaseFragment.this.ac.getData().get(i));
                AlbumSelectInfo albumSelectInfo = (AlbumSelectInfo) FeedAddPostBaseFragment.this.az.f().getValue();
                if (albumSelectInfo != null) {
                    albumSelectInfo.a(((ChildImageInfo) FeedAddPostBaseFragment.this.ac.getData().get(i)).mImagePath);
                }
                FeedAddPostBaseFragment.this.az.h().setValue(((ChildImageInfo) FeedAddPostBaseFragment.this.ac.getData().get(i)).mImagePath);
                FeedAddPostBaseFragment.this.ac.a();
                FeedAddPostBaseFragment.this.aa_();
                FeedAddPostBaseFragment.this.S();
                FeedAddPostBaseFragment.this.aw();
            }
        }));
        this.ab.setAdapter(this.ac);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj() {
        if (TextUtils.isEmpty((CharSequence) this.aS.f().getValue())) {
            this.N.setText(R.string.feed_post_location);
            ShapeHelper.b(this.L, R.color.syc_x);
            this.O.setVisibility(8);
            return;
        }
        this.N.setText((CharSequence) this.aS.f().getValue());
        ShapeHelper.b(this.L, R.color.syc_a_10);
        this.O.setVisibility(0);
    }

    private void ak() {
        if (this.aI == 2) {
            KeyboardUtils.c(getActivity());
            return;
        }
        LogUtils.c("onClickEmotion: " + this.ae);
        if (!this.ae) {
            au();
            return;
        }
        this.aJ = 2;
        d("onClickEmotion");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al() {
        if (q()) {
            return;
        }
        this.az.m();
        ag();
        int f = this.ac.f();
        if (t() || 9 - f != 9) {
            AlbumSelectDialogFragment a = AlbumSelectDialogFragment.a.a(getActivity(), 4, 1, 9, 109, this.Z);
            this.aa = a;
            a.a(this.aZ);
        } else {
            AlbumSelectDialogFragment a2 = AlbumSelectDialogFragment.a.a(getActivity(), 4, 3, 9, 109, this.Z);
            this.aa = a2;
            a2.a(this.aZ);
            this.aQ = 1;
        }
        this.Z = false;
    }

    private boolean am() {
        return V() || W() || an();
    }

    private boolean an() {
        if (this.au) {
            AppMethods.d(R.string.event_repost_no);
            return true;
        }
        return false;
    }

    private void ao() {
        if (this.ay != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("serializeble_data", this.ay);
            int i = 0;
            if (t()) {
                i = 3;
            }
            ShortVideoProxy.e().a(this, bundle, i, 120);
        }
    }

    private void ap() {
        if (this.ay != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("serializeble_data", this.ay);
            int i = 0;
            if (t()) {
                i = 3;
            }
            ShortVideoProxy.e().a(bundle, i, new ISaveInterface() { // from class: com.blued.community.ui.send.fragment.FeedAddPostBaseFragment.17
                @Override // com.blued.android.module.base.shortvideo.ISaveInterface
                public void a() {
                    Logger.b("FeedSend", "saveVideoNoUI onSaveVideoCanceled");
                }

                @Override // com.blued.android.module.base.shortvideo.ISaveInterface
                public void a(float f) {
                    Logger.b("FeedSend", "saveVideoNoUI onProgress v" + f);
                }

                @Override // com.blued.android.module.base.shortvideo.ISaveInterface
                public void a(int i2) {
                    Logger.b("FeedSend", "saveVideoNoUI onSaveFailed");
                }

                @Override // com.blued.android.module.base.shortvideo.ISaveInterface
                public void a(StvResultModel stvResultModel) {
                    FeedAddPostBaseFragment.this.aw = stvResultModel;
                    FeedAddPostBaseFragment.this.ay = null;
                    Logger.b("FeedSend", "saveVideoNoUI onSaveSucess videoFeed" + FeedAddPostBaseFragment.this.aw.f());
                    FeedAddPostBaseFragment.this.ar();
                }

                @Override // com.blued.android.module.base.shortvideo.ISaveInterface
                public void b() {
                }
            });
        }
    }

    private void aq() {
        Log.d("FendSend", "cancleUploadVideo");
        if (TextUtils.isEmpty(this.ax)) {
            return;
        }
        VideoUploadManager.a().a(this.ax);
        this.ax = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar() {
        Log.d("FeedSend", "uploadVideo videoFeed.getFirstFrameImgPath()" + this.aw.c());
        StvResultModel stvResultModel = this.aw;
        if (stvResultModel == null || TextUtils.isEmpty(stvResultModel.f())) {
            return;
        }
        VideoUploadManager.a().a(new Pair<>(this.aw.c(), ""), new Pair<>(this.aw.f(), ""), new VideoUploadManager.VideoUploadListener() { // from class: com.blued.community.ui.send.fragment.FeedAddPostBaseFragment.18
            @Override // com.blued.community.ui.send.manager.VideoUploadManager.VideoUploadListener
            public void a(String str, int i) {
                FeedAddPostBaseFragment.this.ax = str;
            }

            @Override // com.blued.community.ui.send.manager.VideoUploadManager.VideoUploadListener
            public void a(String str, boolean z, ArrayList<Pair<String, UploadModel>> arrayList, List<Pair<String, String>> list) {
                FeedAddPostBaseFragment.this.ax = str;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as() {
        getActivity().finish();
    }

    private void at() {
        boolean z;
        this.X.setVisibility(0);
        int[] iArr = new int[2];
        this.X.getLocationInWindow(iArr);
        int i = AppInfo.m;
        int i2 = iArr[1];
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.X.getLayoutParams();
        if (i - i2 > FeedMethods.c(50)) {
            marginLayoutParams.height = this.b;
            z = false;
        } else {
            marginLayoutParams.height = 0;
            z = true;
        }
        this.X.setLayoutParams(marginLayoutParams);
        if (z) {
            ValueAnimator ofInt = ValueAnimator.ofInt(0, this.b);
            ofInt.setInterpolator(new AccelerateInterpolator());
            ofInt.setDuration(300L).start();
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.community.ui.send.fragment.FeedAddPostBaseFragment.22
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    LogUtils.c("onAnimationUpdate.values = " + intValue);
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) FeedAddPostBaseFragment.this.X.getLayoutParams();
                    marginLayoutParams2.height = intValue;
                    FeedAddPostBaseFragment.this.X.setLayoutParams(marginLayoutParams2);
                }
            });
        }
    }

    private void au() {
        ae();
        c(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av() {
        if (w() && CommunityPreferences.e() && this.aN == null) {
            GestureAnimTipView gestureAnimTipView = new GestureAnimTipView(this.c);
            this.aN = gestureAnimTipView;
            gestureAnimTipView.setText(R.string.feed_post_drag_photo_tip);
            BluedPopupWindow a = BluedPopupWindow.Builder.a((Activity) getContext(), this.aN).a(true).a();
            this.aM = a;
            a.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.blued.community.ui.send.fragment.FeedAddPostBaseFragment.23
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    FeedAddPostBaseFragment.this.aM = null;
                    FeedAddPostBaseFragment.this.aN = null;
                }
            });
            this.aN.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.FeedAddPostBaseFragment.24
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    FeedAddPostBaseFragment.this.ah();
                }
            });
            this.aM.setOutsideTouchable(false);
            this.aM.a(this.ab, 1, 3, DensityUtils.a(this.c, 15.0f), 0, false);
            this.aN.a("gesture_anim_tip_anim_774.png", getFragmentActive());
            CommunityPreferences.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aw() {
        if (this.ab.getVisibility() != 0 || this.ac.c() < 2) {
            ah();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(File file, Exception exc) {
        if (file == null || !file.exists()) {
            return;
        }
        SelectPhotoManager.a().a(new ChildImageInfo(file.getPath()));
        this.ac.a();
    }

    private void k() {
        this.aL = this.aA.getInt("page_from");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String G() {
        return this.as ? getString(R.string.circle_add_post_share_hint) : this.au ? getString(R.string.event_add_post_share_hint) : getString(R.string.feed_post_hint);
    }

    protected int H() {
        return R.layout.fragment_feed_post;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: I */
    public void ay() {
        this.aR.a(this.j.getHeight());
        this.az.a(this.j.getHeight());
        this.aS.a(this.j.getHeight());
    }

    protected void J() {
        this.aR.a(u());
        EventTrackFeed.a(FeedProtos.Event.FEED_ADD_PHOTO, FeedProtos.AddType.HALF_SCREEN, u());
        AlbumSelectDialogFragment a = AlbumSelectDialogFragment.a.a(getActivity(), 4, t() ? 1 : 3, 9, 109, this.Z);
        this.aa = a;
        this.Z = false;
        a.a(new AlbumSelectDialogFragment.AlbumSelectOnDismissListener() { // from class: com.blued.community.ui.send.fragment.FeedAddPostBaseFragment.3
            @Override // com.blued.community.ui.send.dialog.AlbumSelectDialogFragment.AlbumSelectOnDismissListener
            public View a(MotionEvent motionEvent) {
                return FeedAddPostBaseFragment.this.a(motionEvent);
            }

            @Override // com.blued.community.ui.send.dialog.AlbumSelectDialogFragment.AlbumSelectOnDismissListener
            public void a(DialogFragment dialogFragment, View view) {
                FeedAddPostBaseFragment.this.a(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K() {
        this.aR = (FeedPostViewModel) new ViewModelProvider(getActivity().getViewModelStore(), new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication())).get(FeedPostViewModel.class);
        this.az = (SelectAlbumViewModel) new ViewModelProvider(getActivity().getViewModelStore(), new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication())).get(SelectAlbumViewModel.class);
        SelectLocationViewModel selectLocationViewModel = (SelectLocationViewModel) new ViewModelProvider(getActivity().getViewModelStore(), new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication())).get(SelectLocationViewModel.class);
        this.aS = selectLocationViewModel;
        selectLocationViewModel.f().observe(getViewLifecycleOwner(), new Observer<String>() { // from class: com.blued.community.ui.send.fragment.FeedAddPostBaseFragment.4
            /* renamed from: a */
            public void onChanged(String str) {
                FeedAddPostBaseFragment.this.aj();
            }
        });
        this.az.e().observe(getViewLifecycleOwner(), new Observer<Integer>() { // from class: com.blued.community.ui.send.fragment.FeedAddPostBaseFragment.5
            /* renamed from: a */
            public void onChanged(Integer num) {
                if (num.intValue() > 0) {
                    FeedAddPostBaseFragment.this.b = num.intValue();
                    FeedAddPostBaseFragment.this.c(1);
                    ViewGroup.LayoutParams layoutParams = FeedAddPostBaseFragment.this.X.getLayoutParams();
                    layoutParams.height = num.intValue();
                    FeedAddPostBaseFragment.this.X.setLayoutParams(layoutParams);
                }
            }
        });
        this.az.j().observe(getViewLifecycleOwner(), new Observer<Boolean>() { // from class: com.blued.community.ui.send.fragment.FeedAddPostBaseFragment.6
            /* renamed from: a */
            public void onChanged(Boolean bool) {
                FeedAddPostBaseFragment.this.R();
                if (FeedAddPostBaseFragment.this.w()) {
                    FeedAddPostBaseFragment.this.av();
                } else {
                    FeedAddPostBaseFragment.this.aw();
                }
            }
        });
        this.az.g().observe(getViewLifecycleOwner(), new Observer<Intent>() { // from class: com.blued.community.ui.send.fragment.FeedAddPostBaseFragment.7
            /* renamed from: a */
            public void onChanged(Intent intent) {
                FeedAddPostBaseFragment.this.a(intent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L() {
    }

    protected void M() {
        NewFeedModel newFeedModel;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.ag = (BluedIngSelfFeed) arguments.getSerializable("feed_data");
            this.ah = (NewFeedModel) arguments.getSerializable("feed_send_data");
            this.aj = (BluedTopic) arguments.getSerializable("super_topic_key");
            this.ak = (MyCircleModel) arguments.getSerializable("share_circle_key");
            this.am = (EventDetailsModel) arguments.getSerializable("share_event_key");
            this.al = (StvResultModel) arguments.getSerializable("music_video_data");
            ShareEntity serializable = arguments.getSerializable("share_entity");
            this.ai = serializable;
            if (serializable != null) {
                this.an = serializable.shareType;
            }
            this.aO = arguments.getBoolean("is_attention_show_dot");
            this.aP = arguments.getBoolean("is_show_promotion");
            if (arguments.getBoolean("is_back")) {
                this.m.setImageDrawable(BluedSkinUtils.b(this.c, R.drawable.icon_title_back));
            }
        }
        StvResultModel stvResultModel = this.al;
        if (stvResultModel != null && stvResultModel.a()) {
            this.av = true;
            this.aw = this.al;
            this.G.setVisibility(0);
            ImageLoader.d(getFragmentActive(), this.aw.c()).b(R.drawable.feed_photo_default).a(this.H);
            this.ab.setVisibility(8);
            ap();
        }
        if (this.an == 0 && (newFeedModel = this.ah) != null) {
            newFeedModel.is_url = 1;
        }
        if (this.ah != null) {
            this.aS.f().setValue(this.ah.address);
            this.aS.c(this.ah.getLat());
            this.aS.c(this.ah.getLng());
            this.P.setAuthValue(this.ah.reading_scope);
            this.P.setCommentValue(this.ah.allow_comments);
        }
        N();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void N() {
        NewFeedModel newFeedModel = this.ah;
        if (newFeedModel == null) {
            return;
        }
        String pics = newFeedModel.getPics();
        if (TextUtils.isEmpty(pics)) {
            return;
        }
        String[] split = pics.split(i.b);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= split.length) {
                break;
            }
            if (split[i2].contains("http://") || split[i2].contains("https://")) {
                ImageFileLoader.a(getFragmentActive()).a(split[i2]).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedAddPostBaseFragment$1HnLIPfivNcTU68Pu2hcbw6xe-E
                    @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
                    public final void onUIFinish(File file, Exception exc) {
                        FeedAddPostBaseFragment.this.a(file, exc);
                    }
                }).a();
            } else {
                SelectPhotoManager.a().a(new ChildImageInfo(split[i2]));
            }
            i = i2 + 1;
        }
        for (ChildImageInfo childImageInfo : SelectPhotoManager.a().c()) {
            this.az.a(childImageInfo.mImagePath);
        }
    }

    protected void O() {
        if (this.ah == null) {
            return;
        }
        Log.v("drb", "重新编辑");
        if (this.ah.is_repost == 1) {
            Log.v("drb", "重新编辑 is_repost == 1");
            this.ap = true;
            this.Y.setVisibility(0);
            this.Y.setChecked(this.ah.repost_also_comment == 1);
            this.s.setVisibility(0);
            ImageLoader.a(getFragmentActive(), this.ah.forwardImage).b(R.drawable.defaultpicture).a(this.u);
            this.v.setText(this.ah.forwardName);
            if (!TextUtils.isEmpty(this.ah.forwardContent)) {
                this.w.setText(a(this.ah.forwardContent));
            } else if (this.ah.isVideo == 1) {
                this.w.setText(this.c.getResources().getString(R.string.repost_share_video));
            } else {
                this.w.setText(this.c.getResources().getString(R.string.repost_share_pic));
            }
        } else if (this.ah.isVideo != 1) {
            if (TextUtils.isEmpty(this.ah.share_posting_id)) {
                return;
            }
            Log.v("drb", "重新编辑 mNewFeedModel.share_posting_id :" + this.ah.share_posting_id);
            this.ar = true;
            this.s.setVisibility(0);
            this.v.setText(this.ah.forwardName);
            ImageLoader.a(getFragmentActive(), this.ah.forwardImage).b(R.drawable.circle_default_icon).a(this.u);
            this.w.setText(a(this.ah.forwardContent));
        } else {
            Log.v("drb", "重新编辑 isVideo == 1");
            this.av = true;
            this.G.setVisibility(0);
            ImageLoader.d(getFragmentActive(), this.ah.localPath).b(R.drawable.feed_photo_default).a(this.H);
            if (this.aw == null) {
                this.aw = new StvResultModel();
            }
            this.aw.c(this.ah.videoPath);
            this.aw.c(this.ah.localVideoPath);
            this.aw.a(true);
            this.aw.b(this.ah.localPath);
            this.aw.b(this.ah.videoSize);
            this.aw.a(this.ah.duration * 1000.0f);
            this.aw.a(this.ah.videoWidth);
            this.aw.b(this.ah.videoHeight);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P() {
        if (this.aj != null) {
            this.at = true;
            this.s.setVisibility(0);
            NewFeedModel newFeedModel = new NewFeedModel();
            this.ah = newFeedModel;
            newFeedModel.is_share_super_topics = 1;
            this.ah.share_s_t_did = this.aj.super_did;
            this.ah.forwardName = this.aj.name;
            this.ah.forwardContent = this.aj.description;
            this.ah.forwardImage = this.aj.avatar;
        }
        if (this.ak != null) {
            this.as = true;
            this.s.setVisibility(0);
            NewFeedModel newFeedModel2 = new NewFeedModel();
            this.ah = newFeedModel2;
            newFeedModel2.is_share_circle = 1;
            this.ah.share_circle_id = this.ak.circle_id;
            NewFeedModel newFeedModel3 = this.ah;
            newFeedModel3.forwardName = this.ak.title + this.c.getString(R.string.base);
            this.ah.forwardContent = StringUtils.d(this.ak.description) ? this.c.getString(R.string.circle_share_default) : this.ak.description;
            this.ah.forwardImage = this.ak.cover;
        }
        if (this.am != null) {
            this.au = true;
            this.s.setVisibility(0);
            this.w.setVisibility(8);
            this.x.setVisibility(0);
            this.v.setTextSize(17.0f);
            NewFeedModel newFeedModel4 = new NewFeedModel();
            this.ah = newFeedModel4;
            newFeedModel4.is_share_activity = 1;
            this.ah.share_activity_id = this.am.id;
            this.ah.forwardImage = this.am.pic;
            this.ah.forwardName = this.am.name;
            this.ah.share_activity_time = TimeAndDateUtils.e(TimeAndDateUtils.j(this.am.activity_date));
            this.ah.share_activity_mode_id = this.am.mode_id;
            if (this.am.mode_id == 1) {
                NewFeedModel newFeedModel5 = this.ah;
                newFeedModel5.share_activity_location = this.am.city + "·" + this.am.location;
            } else {
                this.ah.share_activity_location = this.c.getString(R.string.event_online_event);
            }
        }
        NewFeedModel newFeedModel6 = this.ah;
        if (newFeedModel6 != null) {
            if (newFeedModel6.is_share_super_topics == 1) {
                this.at = true;
            } else if (this.ah.is_share_circle == 1) {
                this.as = true;
            } else if (this.ah.is_share_activity == 1) {
                this.au = true;
            }
        }
        if (this.at) {
            this.s.setVisibility(0);
            View findViewById = this.s.findViewById(R.id.view_share_corner);
            ImageView imageView = (ImageView) this.s.findViewById(R.id.icon);
            if (CommunityServiceManager.a().D() == 1) {
                imageView.setImageResource(R.drawable.feed_post_subject_icon_corner);
            } else {
                imageView.setImageResource(R.drawable.icon_share_topic_corner);
            }
            ((TextView) this.s.findViewById(R.id.tv)).setText(R.string.super_topic);
            findViewById.setVisibility(0);
            ImageLoader.a(getFragmentActive(), this.ah.forwardImage).b(R.drawable.defaultpicture).a(this.u);
            this.v.setText(this.ah.forwardName);
            this.w.setText(a(this.ah.forwardContent));
        } else if (this.as) {
            this.s.setVisibility(0);
            View findViewById2 = this.s.findViewById(R.id.view_share_corner);
            ((ImageView) this.s.findViewById(R.id.icon)).setImageResource(R.drawable.icon_share_circle_corner);
            ((TextView) this.s.findViewById(R.id.tv)).setText(R.string.base);
            findViewById2.setVisibility(0);
            ImageLoader.a(getFragmentActive(), this.ah.forwardImage).b(R.drawable.defaultpicture).a(this.u);
            this.v.setText(this.ah.forwardName);
            this.w.setText(a(this.ah.forwardContent));
        } else if (this.au) {
            this.s.setVisibility(0);
            this.w.setVisibility(8);
            this.x.setVisibility(0);
            this.v.setTextSize(17.0f);
            View findViewById3 = this.s.findViewById(R.id.view_share_corner);
            ((ImageView) this.s.findViewById(R.id.icon)).setImageResource(R.drawable.icon_share_event_corner);
            ((TextView) this.s.findViewById(R.id.tv)).setText(R.string.event_events);
            findViewById3.setVisibility(0);
            this.s.findViewById(R.id.img_event_icon).setVisibility(0);
            ImageLoader.a(getFragmentActive(), this.ah.forwardImage).b(R.drawable.event_avatar_square).d(R.drawable.event_avatar_square).a(this.u);
            this.v.setText(this.ah.forwardName);
            this.y.setText(this.ah.share_activity_time);
            this.A.setText(this.ah.share_activity_location);
            if (this.ah.share_activity_mode_id == 1) {
                this.z.setImageDrawable(BluedSkinUtils.b(this.c, R.drawable.icon_eventcard_location));
            } else {
                this.z.setImageDrawable(BluedSkinUtils.b(this.c, R.drawable.icon_share_event_icon));
            }
        }
    }

    public void Q() {
        this.l = (LinearLayout) this.j.findViewById(R.id.ll_title);
        this.m = (ImageView) this.j.findViewById(R.id.iv_close);
        this.n = (ShapeTextView) this.j.findViewById(R.id.tv_post);
        this.m.setOnClickListener(new SingleClickProxy(this));
        this.n.setOnClickListener(new SingleClickProxy(this));
        if (this.aT != null) {
            this.l.setVisibility(8);
        }
        this.r = (LinearLayout) this.j.findViewById(R.id.layout_res);
        this.s = this.j.findViewById(R.id.layout_forward);
        this.t = (LinearLayout) this.j.findViewById(R.id.layout_forward_bg);
        this.u = (ImageView) this.j.findViewById(R.id.forward_image);
        this.v = (TextView) this.j.findViewById(R.id.forward_name);
        this.w = (TextView) this.j.findViewById(R.id.forward_content);
        this.x = (LinearLayout) this.j.findViewById(R.id.forward_event);
        this.y = (TextView) this.j.findViewById(R.id.forward_event_time);
        this.z = (ImageView) this.j.findViewById(R.id.iv_event_address);
        this.A = (TextView) this.j.findViewById(R.id.forward_event_location);
        this.B = (LinearLayout) this.j.findViewById(R.id.ll_share_root_view);
        this.C = this.j.findViewById(R.id.tv_origin_share_content);
        this.D = (LinearLayout) this.j.findViewById(R.id.share_content_layout);
        this.E = (ImageView) this.j.findViewById(R.id.img_share);
        this.F = (TextView) this.j.findViewById(R.id.tv_share_content);
        this.G = this.j.findViewById(R.id.layout_video);
        this.H = (ImageView) this.j.findViewById(R.id.img_video);
        ImageView imageView = (ImageView) this.j.findViewById(R.id.iv_video_delete);
        this.I = imageView;
        imageView.setOnClickListener(new SingleClickProxy(this));
        this.H.setOnClickListener(new SingleClickProxy(this));
        this.J = this.j.findViewById(R.id.location_and_auth_divider);
        this.K = this.j.findViewById(R.id.layout_location_and_auth);
        this.L = (ShapeLinearLayout) this.j.findViewById(R.id.layout_location);
        this.M = (ImageView) this.j.findViewById(R.id.iv_location);
        this.N = (TextView) this.j.findViewById(R.id.tv_location);
        this.O = (ImageView) this.j.findViewById(R.id.iv_location_close);
        this.L.setOnClickListener(new SingleClickProxy(this));
        this.O.setOnClickListener(new SingleClickProxy(this));
        FeedPostAuthView feedPostAuthView = (FeedPostAuthView) this.j.findViewById(R.id.feed_post_auth_view);
        this.P = feedPostAuthView;
        feedPostAuthView.setOwnFragment(this);
        this.P.setAnonymousTopic(this.ad);
        this.Q = this.j.findViewById(R.id.layout_tools);
        this.R = (ImageView) this.j.findViewById(R.id.iv_image);
        this.S = (ImageView) this.j.findViewById(R.id.iv_photograph);
        this.T = (ImageView) this.j.findViewById(R.id.iv_at);
        this.U = (ImageView) this.j.findViewById(R.id.iv_emoji);
        this.R.setOnClickListener(new SingleClickProxy(this));
        this.S.setOnClickListener(new SingleClickProxy(this));
        this.T.setOnClickListener(new SingleClickProxy(this));
        this.U.setOnClickListener(this);
        ImageView imageView2 = (ImageView) this.j.findViewById(R.id.iv_voting);
        this.V = imageView2;
        imageView2.setOnClickListener(new SingleClickProxy(this));
        View findViewById = this.j.findViewById(R.id.feed_add_bottom_bg_view);
        this.X = findViewById;
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = KeyboardUtils.a();
        this.X.setLayoutParams(layoutParams);
        this.Y = (CheckBox) this.j.findViewById(R.id.cb_comment);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void R() {
        if (r()) {
            this.ab.setVisibility(8);
            return;
        }
        this.ac.a();
        if (!this.ad || this.ac.c() > 0) {
            this.ab.setVisibility(0);
        } else {
            this.ab.setVisibility(8);
        }
        aa_();
        S();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void S() {
        if (p()) {
            this.n.setAlpha(1.0f);
        } else {
            this.n.setAlpha(0.3f);
        }
        OnAddPostTitleListener onAddPostTitleListener = this.aT;
        if (onAddPostTitleListener != null) {
            onAddPostTitleListener.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean T() {
        if (this.at || !TextUtils.isEmpty(this.o.getText().toString().trim()) || this.ac.d()) {
            return true;
        }
        if ((!this.av || this.aw == null) && !this.ao) {
            return this.ap ? !this.ar : this.as || this.au;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean U() {
        return this.ap || this.ar || this.ao || this.at || this.as || this.au;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean V() {
        if (this.ar) {
            AppMethods.d(R.string.circle_post_repost_no);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean W() {
        if (this.as) {
            AppMethods.d(R.string.circle_repost_no);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean X() {
        if (this.az.l()) {
            this.az.m();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Editable Y() {
        return AtUserHelper.a(MarkDownLinkHelper.a(Editable.Factory.getInstance().newEditable(this.o.getText())));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public NewFeedModel Z() {
        if (a(true)) {
            return l();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(MotionEvent motionEvent) {
        View b = b(motionEvent);
        if (b != null) {
            if (b.getId() == R.id.img_add || b.getId() == this.R.getId()) {
                b.setTag(101);
            }
            if (b.getId() == this.L.getId() || b.getId() == this.P.getId() || b.getId() == this.O.getId() || b.getId() == R.id.iv_image_delete || b.getId() == R.id.root_layout) {
                b.setTag(102);
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public NewFeedModel a(NewFeedModel newFeedModel) {
        if (newFeedModel != null) {
            StringBuffer stringBuffer = new StringBuffer();
            List data = this.ac.getData();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= data.size()) {
                    break;
                }
                if (i2 == 0) {
                    newFeedModel.localPath = ((ChildImageInfo) data.get(i2)).mImagePath;
                }
                if (!TextUtils.isEmpty(((ChildImageInfo) data.get(i2)).mImagePath)) {
                    stringBuffer.append(((ChildImageInfo) data.get(i2)).mImagePath + i.b);
                }
                i = i2 + 1;
            }
            newFeedModel.setPics(stringBuffer.toString());
            newFeedModel.setSize(data.size());
        }
        return newFeedModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Editable editable) {
        try {
            this.o.removeTextChangedListener(this.aU);
            if (!this.ad && AtUserHelper.a(this.aX.toString(), this.aY.toString(), this.o.getSelectionEnd())) {
                CommunityServiceManager.b().a(this, new Bundle(), 9090);
            }
            MarkDownLinkHelper.a(this.o, this.aX, this.aY, editable, this.aV, this.aW);
            AtUserHelper.a(this.o, this.aX, this.aY, editable, this.aV, this.aW);
            this.o.addTextChangedListener(this.aU);
        } catch (Exception e) {
            e.printStackTrace();
        }
        S();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view) {
        if (view == null) {
            af();
        } else if (view.getId() == this.U.getId()) {
            au();
        } else if (view.getId() == this.L.getId() || view.getId() == this.P.getId()) {
            view.callOnClick();
        } else {
            view.callOnClick();
            if (view.getId() == R.id.layout_read_auth) {
                int i = this.aI;
                if ((i == 0 || i == 1) && this.X.getVisibility() == 0) {
                    ag();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, MotionEvent motionEvent) {
    }

    public void a(OnAddPostTitleListener onAddPostTitleListener) {
        this.aT = onAddPostTitleListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(boolean z) {
        if (this.q.isOutOfBounds()) {
            if (z) {
                String string = getString(R.string.community_max_input_limit);
                AppMethods.a((CharSequence) String.format(string, this.q.getEditMaxLength() + ""));
                return false;
            }
            return false;
        }
        if (this.ad) {
            if (this.av && this.aw != null) {
                if (z) {
                    AppMethods.d(R.string.feed_post_anonymous_video_toast);
                    return false;
                }
                return false;
            } else if (AtUserHelper.b(Y().toString())) {
                if (z) {
                    AppMethods.d(R.string.feed_post_anonymous_at_toast);
                    return false;
                }
                return false;
            }
        }
        if (T()) {
            return true;
        }
        if (z) {
            AppMethods.a((CharSequence) getString(R.string.send_feed_all_null));
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aa() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aa_() {
    }

    public void ab() {
        if (!o()) {
            as();
            return;
        }
        EventTrackFeed.c(FeedProtos.Event.PUBLISH_RETAIN_POP_SHOW, v());
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.c.getResources().getString(R.string.feed_post_save_title));
        arrayList.add(this.c.getResources().getString(R.string.feed_post_save));
        arrayList.add(this.c.getResources().getString(R.string.feed_post_not_save));
        CommonShowBottomWindow.a(this.c, (String[]) arrayList.toArray(new String[arrayList.size()]), true, new ActionSheet.ActionSheetListener() { // from class: com.blued.community.ui.send.fragment.FeedAddPostBaseFragment.19
            @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
            public void a(ActionSheet actionSheet, int i) {
                String a = actionSheet.a(i);
                if (a.equals(FeedAddPostBaseFragment.this.c.getResources().getString(R.string.feed_post_save))) {
                    EventTrackFeed.c(FeedProtos.Event.PUBLISH_RETAIN_POP_YES_CLICK, FeedAddPostBaseFragment.this.v());
                    FeedAddPostBaseFragment.this.n();
                    FeedAddPostBaseFragment.this.d(a);
                    FeedAddPostBaseFragment.this.as();
                } else if (a.equals(FeedAddPostBaseFragment.this.c.getResources().getString(R.string.feed_post_not_save))) {
                    EventTrackFeed.c(FeedProtos.Event.PUBLISH_RETAIN_POP_NO_CLICK, FeedAddPostBaseFragment.this.v());
                    FeedMethods.c();
                    FeedAddPostBaseFragment.this.d(a);
                    FeedAddPostBaseFragment.this.as();
                }
            }

            @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
            public void a(ActionSheet actionSheet, boolean z) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ab_() {
        if (CommunityManager.a.a().s()) {
            this.R.setImageResource(R.drawable.feed_post_tools_image_dark);
            this.S.setImageResource(R.drawable.feed_post_tools_photograph_dark);
            this.T.setImageResource(R.drawable.feed_post_tools_at_dark);
        } else {
            this.R.setImageResource(R.drawable.feed_post_tools_image);
            this.S.setImageResource(R.drawable.feed_post_tools_photograph);
            this.T.setImageResource(R.drawable.feed_post_tools_at);
        }
        ad();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ac() {
        SelectPhotoManager.a().d();
        ChildPhotoManager.a().d();
    }

    protected void ad() {
        if (CommunityManager.a.a().s()) {
            this.U.setImageResource(R.drawable.feed_post_tools_emoji_dark);
        } else {
            this.U.setImageResource(R.drawable.feed_post_tools_emoji);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ae() {
        if (!this.o.isFocusable()) {
            this.o.setFocusable(true);
            this.o.setFocusableInTouchMode(true);
        }
        this.o.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void af() {
        LogUtils.c("showKeyboard");
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.send.fragment.FeedAddPostBaseFragment.21
            @Override // java.lang.Runnable
            public void run() {
                if (!FeedAddPostBaseFragment.this.getFragmentActive().isActive() || FeedAddPostBaseFragment.this.ae) {
                    return;
                }
                FeedAddPostBaseFragment.this.ae();
                KeyboardUtils.c(FeedAddPostBaseFragment.this.getActivity());
                FeedAddPostBaseFragment.this.X.setVisibility(8);
                LogUtils.c("KeyboardUtils.openKeyboard");
            }
        }, 150L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ag() {
        this.X.setVisibility(8);
        this.aI = 0;
        ad();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ah() {
        GestureAnimTipView gestureAnimTipView;
        BluedPopupWindow bluedPopupWindow = this.aM;
        if (bluedPopupWindow == null || (gestureAnimTipView = this.aN) == null) {
            return;
        }
        gestureAnimTipView.a(bluedPopupWindow);
    }

    protected View b(MotionEvent motionEvent) {
        for (View view : ViewUtils.a(this.j)) {
            if (ViewUtils.a(view, motionEvent) && view.getVisibility() == 0) {
                return view;
            }
        }
        return null;
    }

    public void b(NewFeedModel newFeedModel) {
        if (newFeedModel == null) {
            return;
        }
        String str = newFeedModel.activity_id;
        int length = !StringUtils.d(newFeedModel.getPics()) ? newFeedModel.getPics().split(i.b).length : 0;
        aa();
        StvResultModel stvResultModel = this.aw;
        EventTrackFeed.a(newFeedModel, stvResultModel != null ? stvResultModel.j() : "", this.Y.isChecked(), this.ad, str, length, this.aB, this.aC, this.aD, this.aL);
        if (newFeedModel.getSize() > 0) {
            CommunityServiceManager.d().c("feed_send_click", 2);
        } else if (this.B.getVisibility() == 8) {
            CommunityServiceManager.d().c("feed_send_click", 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(boolean z) {
        if (z) {
            c(1);
            J();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i) {
        this.aI = i;
        if (i == 1) {
            this.X.setVisibility(0);
        } else {
            at();
        }
        if (this.aI == 2) {
            this.W.setVisibility(0);
            this.U.setImageDrawable(BluedSkinUtils.b(this.c, R.drawable.feed_post_keyboard));
        } else {
            ad();
            this.W.setVisibility(8);
        }
        d("onLayoutFuncShow: " + i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(String str) {
        this.o.setText(AtUserHelper.a(MarkDownLinkHelper.a(getContext(), StringUtils.a(str, (int) this.o.getTextSize(), 3), true, R.color.syc_m), BluedSkinUtils.a(this.c, R.color.syc_m)));
        SelectionEditText selectionEditText = this.o;
        selectionEditText.setSelection(selectionEditText.length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(boolean z) {
        LogUtils.c("editSetFocusable: " + z);
        if (z) {
            af();
        } else {
            ae();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(String str) {
        if (this.ae) {
            KeyboardUtils.a((Activity) getActivity());
            LogUtils.c(str + ".closeKeyboard");
        }
    }

    protected void h() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: i */
    public void ax() {
        if (this.ag == null && this.ah == null && this.ai == null) {
            PermissionUtils.f(new PermissionCallbacks() { // from class: com.blued.community.ui.send.fragment.FeedAddPostBaseFragment.2
                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void U_() {
                    FeedAddPostBaseFragment.this.b(true);
                }

                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void a(String[] strArr) {
                    FeedAddPostBaseFragment.this.b(false);
                }
            });
            return;
        }
        ag();
        af();
    }

    protected void j() {
    }

    @Override // com.blued.android.framework.activity.keyboardpage.KeyBoardFragment
    public void j_(int i) {
        if (i == -3) {
            this.ae = true;
            ag();
            this.o.setCursorVisible(true);
            ad();
        } else if (i != -2) {
        } else {
            this.ae = false;
            int i2 = this.aJ;
            if (i2 != 0) {
                c(i2);
            } else {
                ad();
            }
            this.aJ = 0;
            if (this.aI != 2) {
                this.o.setCursorVisible(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public NewFeedModel l() {
        StvResultModel stvResultModel;
        String obj = Y().toString();
        String str = obj;
        if (!TextUtils.isEmpty(obj)) {
            str = obj;
            if (obj.equals(this.aq)) {
                str = this.c.getString(R.string.feed_meanwhile_forward_) + obj;
            }
        }
        NewFeedModel newFeedModel = new NewFeedModel();
        if (this.Y.getVisibility() == 0 && this.Y.isChecked()) {
            newFeedModel.repost_also_comment = 1;
        } else {
            newFeedModel.repost_also_comment = 0;
        }
        BluedIngSelfFeed bluedIngSelfFeed = this.ag;
        String str2 = str;
        if (bluedIngSelfFeed != null) {
            str2 = str;
            if (TextUtils.equals(bluedIngSelfFeed.feed_content, str)) {
                str2 = this.c.getString(R.string.feed_meanwhile_forward_) + str;
            }
        }
        newFeedModel.setContent(str2);
        newFeedModel.setLoadName(Long.parseLong(UserInfoUtils.c()));
        newFeedModel.address = (String) this.aS.f().getValue();
        newFeedModel.setLat(String.valueOf(this.aS.i()));
        newFeedModel.setLng(String.valueOf(this.aS.h()));
        newFeedModel.reading_scope = this.P.getAuthValue() != null ? this.P.getAuthValue().intValue() : 0;
        newFeedModel.allow_comments = this.P.getCommentValue() != null ? this.P.getCommentValue().intValue() : 0;
        if (this.an == 0 && this.ai != null) {
            newFeedModel.is_url = 1;
            FeedExtra feedExtra = new FeedExtra();
            feedExtra.url = this.ai.linkUrl;
            if (!TextUtils.isEmpty(feedExtra.url) && Uri.parse(feedExtra.url) != null) {
                feedExtra.domain = Uri.parse(feedExtra.url).getHost();
            }
            feedExtra.title = this.ai.title;
            feedExtra.description = this.ai.content;
            newFeedModel.extraJSON = AppInfo.f().toJson(feedExtra);
        }
        if (!this.av || (stvResultModel = this.aw) == null) {
            a(newFeedModel);
        } else {
            newFeedModel.videoPath = stvResultModel.f();
            newFeedModel.localVideoPath = this.aw.f();
            newFeedModel.isVideo = 1;
            newFeedModel.localPath = this.aw.c();
            newFeedModel.setPics(this.aw.c());
            newFeedModel.setSize(1);
            newFeedModel.videoSize = this.aw.e();
            newFeedModel.duration = ((float) this.aw.d()) / 1000.0f;
            newFeedModel.videoTaskID = this.ax;
            newFeedModel.music_id = this.aw.j();
            newFeedModel.videoWidth = this.aw.g();
            newFeedModel.videoHeight = this.aw.h();
        }
        newFeedModel.setState(1);
        newFeedModel.setTime(System.currentTimeMillis());
        BluedIngSelfFeed bluedIngSelfFeed2 = this.ag;
        if (bluedIngSelfFeed2 != null) {
            BluedIngSelfFeed bluedIngSelfFeed3 = bluedIngSelfFeed2.repost;
            if (bluedIngSelfFeed3 != null) {
                if (this.ag.is_share_posting == 1) {
                    newFeedModel.feed_id = this.ag.feed_id;
                    newFeedModel.share_posting_id = this.ag.feed_id;
                    newFeedModel.is_repost = 0;
                    newFeedModel.forwardName = bluedIngSelfFeed3.circle_title;
                    newFeedModel.forwardContent = bluedIngSelfFeed3.feed_pure_content;
                    if (bluedIngSelfFeed3.is_video_posts == 1 && bluedIngSelfFeed3.feed_videos != null && bluedIngSelfFeed3.feed_videos.length > 0) {
                        newFeedModel.forwardImage = bluedIngSelfFeed3.feed_videos[0];
                    } else if (bluedIngSelfFeed3.feed_pics != null && bluedIngSelfFeed3.feed_pics.length > 0) {
                        newFeedModel.forwardImage = bluedIngSelfFeed3.feed_pics[0];
                    }
                    newFeedModel.isForwardHeader = 1;
                } else if (bluedIngSelfFeed3.is_share_posting == 1) {
                    newFeedModel.feed_id = this.ag.feed_id;
                    newFeedModel.share_posting_id = bluedIngSelfFeed3.feed_id;
                    newFeedModel.is_repost = 1;
                    newFeedModel.forwardName = bluedIngSelfFeed3.share_circle_title;
                    newFeedModel.forwardContent = bluedIngSelfFeed3.share_circle_posting_content;
                    newFeedModel.forwardImage = bluedIngSelfFeed3.share_circle_posting_pic;
                    newFeedModel.isForwardHeader = 1;
                } else {
                    newFeedModel.feed_id = this.ag.feed_id;
                    newFeedModel.is_repost = 1;
                    newFeedModel.is_ads = bluedIngSelfFeed3.is_ads;
                    newFeedModel.forwardName = bluedIngSelfFeed3.user_name;
                    newFeedModel.forwardContent = bluedIngSelfFeed3.feed_content;
                    if (bluedIngSelfFeed3.feed_pics == null || bluedIngSelfFeed3.feed_pics.length <= 0) {
                        newFeedModel.forwardImage = bluedIngSelfFeed3.user_avatar;
                        newFeedModel.isForwardHeader = 0;
                    } else {
                        newFeedModel.forwardImage = bluedIngSelfFeed3.feed_pics[0];
                        newFeedModel.isForwardHeader = 1;
                    }
                }
            }
        } else {
            NewFeedModel newFeedModel2 = this.ah;
            if (newFeedModel2 != null) {
                newFeedModel.feed_id = newFeedModel2.feed_id;
                newFeedModel.is_repost = this.ah.is_repost;
                newFeedModel.forwardName = this.ah.forwardName;
                newFeedModel.forwardContent = this.ah.forwardContent;
                newFeedModel.forwardImage = this.ah.forwardImage;
                newFeedModel.is_ads = this.ah.is_ads;
                newFeedModel.share_posting_id = this.ah.share_posting_id;
                newFeedModel.dontNeedCompress = this.ah.dontNeedCompress;
                newFeedModel.tt_type = this.ah.tt_type;
                NewFeedDao.a().d(this.ah);
                FeedSendManager.a().c(this.ah);
            }
        }
        if (this.at) {
            newFeedModel.is_share_super_topics = 1;
            newFeedModel.share_s_t_did = this.aj.super_did;
        }
        if (this.as) {
            newFeedModel.is_share_circle = 1;
            newFeedModel.share_circle_id = this.ah.share_circle_id;
        }
        if (this.au) {
            newFeedModel.is_share_activity = 1;
            newFeedModel.share_activity_id = this.ah.share_activity_id;
            newFeedModel.share_activity_time = this.ah.share_activity_time;
            newFeedModel.share_activity_location = this.ah.share_activity_location;
            newFeedModel.share_activity_mode_id = this.ah.share_activity_mode_id;
        }
        if (this.aO) {
            newFeedModel.is_attention_show_dot = 1;
        }
        return newFeedModel;
    }

    public void m() {
        NewFeedModel Z = Z();
        if (Z == null) {
            return;
        }
        NewFeedDao.a().a(Z);
        CommunityServiceManager.e().a(this.aP);
        FeedSendManager.a().a(Z);
        ac();
        FeedMethods.c();
        d("onSend");
        Intent intent = new Intent();
        intent.putExtra("close_page", true);
        getActivity().setResult(-1, intent);
        as();
        b(Z);
    }

    protected void n() {
        NewFeedModel Z = Z();
        if (Z == null) {
            return;
        }
        FeedMethods.c();
        Z.is_draft = 1;
        NewFeedDao.a().b(Z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean o() {
        if ((TextUtils.isEmpty(this.o.getText().toString().trim()) && !this.ac.d() && (!this.av || this.aw == null)) || this.ao || this.ap || this.ar || this.as || this.au || this.at || this.ag != null) {
            return false;
        }
        NewFeedModel newFeedModel = this.ah;
        return (newFeedModel == null || newFeedModel.is_draft == 1) && this.ai == null && this.aj == null && this.al == null;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        StvResultModel stvResultModel;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 109) {
                a(intent);
            } else if (i != 120) {
                if (i == 9090) {
                    AtUserHelper.a(this.o, intent.getStringExtra("USER_NAME"), EncryptTool.b(intent.getStringExtra("UID")), this.aU, BluedSkinUtils.a(this.c, R.color.syc_m));
                }
            } else if (intent != null && (stvResultModel = (StvResultModel) intent.getSerializableExtra("result_model")) != null && stvResultModel.a()) {
                this.av = true;
                this.aw = stvResultModel;
                Log.d("chenjiemei", "VEDIO_SAVE_SUCCESS,stvResultModel firstimage" + this.aw.c());
                postSafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.send.fragment.FeedAddPostBaseFragment.20
                    @Override // java.lang.Runnable
                    public void run() {
                        FeedAddPostBaseFragment.this.m();
                    }
                });
                StatisticsProxy.a().a("sv_music_used", stvResultModel.j());
                StatisticsProxy.a().a("sv_filter_used", stvResultModel.k());
                int i3 = this.aQ;
                if (i3 == 5) {
                    StatisticsProxy.a().a("feed_send_click", (Object) 0);
                } else if (i3 == 1) {
                    StatisticsProxy.a().a("feed_send_click", (Object) 1);
                }
            }
        }
        if (i == 109 || i == 110 || i == 9090) {
            af();
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        if (this.aI == 2) {
            ag();
            return true;
        }
        ab();
        return true;
    }

    public void onClick(View view) {
        Tracker.onClick(view);
        final boolean z = this.ae;
        int id = view.getId();
        if (id == R.id.iv_close) {
            x();
        } else if (id == R.id.tv_post) {
            y();
        } else if (id == R.id.iv_video_delete) {
            this.G.setVisibility(8);
            this.av = false;
            R();
            aq();
        } else if (id == R.id.img_video) {
            if (am()) {
                return;
            }
            if (this.aw == null || this.ay == null) {
                if (this.aw != null) {
                    ShortVideoProxy.e().a(this, this.aw.f(), this.aw.c(), 0);
                    return;
                }
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable("serializeble_data", this.ay);
            ShortVideoProxy.e().a(this, bundle, 0);
        } else if (id == R.id.layout_location) {
            if (V() || W()) {
                return;
            }
            d("layout_location");
            if (this.aI == 2) {
                ag();
            }
            SelectLocationDialogFragment.a.a(getFragmentManager()).a(new DialogInterface.OnDismissListener() { // from class: com.blued.community.ui.send.fragment.FeedAddPostBaseFragment.15
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    FeedAddPostBaseFragment.this.c(z);
                }
            });
        } else if (id == R.id.iv_location_close) {
            this.aS.f().setValue("");
            this.aS.c((String) null);
            this.aS.b((String) null);
        } else if (id == R.id.iv_image) {
            EventTrackFeed.a(FeedProtos.Event.FEED_ADD_PHOTO, FeedProtos.AddType.ICON, u());
            al();
        } else if (id != R.id.iv_photograph) {
            if (id == R.id.iv_at) {
                this.o.getText().replace(this.o.getSelectionStart(), this.o.getSelectionEnd(), "");
                this.o.getText().insert(this.o.getSelectionStart(), "@");
            } else if (id == R.id.iv_emoji) {
                ak();
            } else if (id == R.id.iv_voting) {
                j();
            }
        } else if (q() || X()) {
        } else {
            d("iv_photograph");
            ag();
            if (CommunityServiceManager.a().b(this.c)) {
                return;
            }
            if (t()) {
                ShortVideoProxy.e().b(this, 3, 109);
                return;
            }
            ShortVideoProxy.e().b(this, 0, 109);
            this.aQ = 5;
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.c = getActivity();
        Bundle arguments = getArguments();
        this.aA = arguments;
        if (arguments == null) {
            this.aA = new Bundle();
        }
        k();
        View view = this.j;
        if (view == null) {
            this.j = layoutInflater.inflate(H(), viewGroup, false);
            getActivity().getWindow().setSoftInputMode(18);
            Q();
            D();
            E();
            ai();
            F();
            K();
            M();
            B();
            P();
            C();
            h();
            L();
            postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedAddPostBaseFragment$6zu5BNSrJL2yoC_XIYfkMax1cK8
                @Override // java.lang.Runnable
                public final void run() {
                    FeedAddPostBaseFragment.this.ay();
                }
            }, 100L);
            postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedAddPostBaseFragment$SDfNw7PpG0liefunWweWXRGDdjo
                @Override // java.lang.Runnable
                public final void run() {
                    FeedAddPostBaseFragment.this.ax();
                }
            }, 200L);
        } else if (view.getParent() != null) {
            ((ViewGroup) this.j.getParent()).removeView(this.j);
        }
        return this.j;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onDestroy() {
        super.onDestroy();
        ac();
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onResume() {
        super.onResume();
        R();
        ae();
        S();
    }

    @Override // com.blued.android.framework.activity.HomeTabFragment, com.blued.android.core.ui.BaseFragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ab_();
        int i = this.aA.getInt("nearby_guide_type", 0);
        this.aK = i;
        if (i == 1) {
            PermissionUtils.c(new AnonymousClass1());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean p() {
        return a(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean q() {
        if (am()) {
            return true;
        }
        if (this.ap || this.ao || this.at) {
            AppMethods.d(R.string.feed_post_is_repost);
            return true;
        } else if (this.av) {
            AppMethods.d(R.string.feed_post_is_video);
            return true;
        } else if (this.ac.f() >= 9) {
            AppMethods.a((CharSequence) String.format(getResources().getString(R.string.max_select_num), 9));
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean r() {
        return this.ap || this.av || this.ao || this.at || this.ar || this.as || this.au;
    }

    public int s() {
        return !this.ap ? 512 : 256;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean t() {
        return this.ac.f() > 0 || this.ad || this.az.l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FeedProtos.FeedType u() {
        return FeedProtos.FeedType.COMMON;
    }

    protected String v() {
        return "feed";
    }

    protected boolean w() {
        return this.ab.getVisibility() == 0 && this.ac.c() >= 2;
    }

    @Override // com.blued.community.ui.send.observer.IAddPost
    public void x() {
        ab();
    }

    @Override // com.blued.community.ui.send.observer.IAddPost
    public void y() {
        if (!this.av || this.ay == null) {
            m();
        } else {
            ao();
        }
    }

    @Override // com.blued.community.ui.send.observer.IAddPost
    public boolean z() {
        return p();
    }
}
