package com.blued.community.ui.send.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.ImageUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.BitmapUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.community.R;
import com.blued.community.track.EventTrackVote;
import com.blued.community.ui.send.manager.SelectPhotoManager;
import com.blued.community.ui.send.model.ChildImageInfo;
import com.blued.community.view.ScalableImageView;
import com.blued.das.client.vote.VoteProtos;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/fragment/PictureVoteEditFragment.class */
public class PictureVoteEditFragment extends BaseFragment implements View.OnClickListener, View.OnTouchListener {
    private Context a;
    private View b;
    private CommonTopTitleNoTrans c;
    private View d;
    private FrameLayout e;
    private ScalableImageView f;
    private ImageView g;
    private ImageView h;
    private ShapeTextView i;
    private FrameLayout j;
    private ScalableImageView k;
    private ImageView l;
    private ImageView m;
    private ShapeTextView n;
    private LinearLayout o;
    private LinearLayout p;
    private LinearLayout q;
    private LinearLayout r;
    private LinearLayout s;
    private ChildImageInfo u;
    private ChildImageInfo v;
    private int t = 0;
    private boolean w = false;
    private boolean x = false;

    private void a() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.b.findViewById(R.id.title);
        this.c = commonTopTitleNoTrans;
        commonTopTitleNoTrans.setLeftClickListener(this);
        this.c.setRightClickListener(this);
        d();
    }

    private void a(ScalableImageView scalableImageView) {
        if (scalableImageView.isImageMax()) {
            AppMethods.d(R.string.picture_voting_zoom_max);
        } else {
            scalableImageView.postScale(1.15f);
        }
    }

    private void b() {
        this.d = this.b.findViewById(R.id.layout_voting_pic);
        this.e = (FrameLayout) this.b.findViewById(R.id.layout_vote_left);
        this.f = this.b.findViewById(R.id.siv_left);
        this.g = (ImageView) this.b.findViewById(R.id.iv_add_left);
        this.h = (ImageView) this.b.findViewById(R.id.iv_delete_left);
        this.i = (ShapeTextView) this.b.findViewById(R.id.stv_check_box_left);
        this.g.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.f.setOnTouchListener(this);
        this.j = (FrameLayout) this.b.findViewById(R.id.layout_vote_right);
        this.k = this.b.findViewById(R.id.siv_right);
        this.l = (ImageView) this.b.findViewById(R.id.iv_add_right);
        this.m = (ImageView) this.b.findViewById(R.id.iv_delete_right);
        this.n = (ShapeTextView) this.b.findViewById(R.id.stv_check_box_right);
        this.l.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.k.setOnTouchListener(this);
        this.o = (LinearLayout) this.b.findViewById(R.id.layout_tools);
        this.p = (LinearLayout) this.b.findViewById(R.id.layout_enlarge);
        this.q = (LinearLayout) this.b.findViewById(R.id.layout_narrow);
        this.r = (LinearLayout) this.b.findViewById(R.id.layout_rotate);
        this.s = (LinearLayout) this.b.findViewById(R.id.layout_exchange);
        this.p.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.s.setOnClickListener(this);
    }

    private void b(ScalableImageView scalableImageView) {
        if (scalableImageView.isImageMix()) {
            AppMethods.d(R.string.picture_voting_zoom_min);
        } else {
            scalableImageView.postScale(0.85f);
        }
    }

    private void c() {
        if (SelectPhotoManager.a().c().size() > 0) {
            int i = this.t;
            if (i == 1) {
                this.u = SelectPhotoManager.a().c().get(0);
                this.f.loadImageFromLocal(getFragmentActive(), this.u.mImagePath);
                this.g.setVisibility(8);
                this.h.setVisibility(0);
                if (SelectPhotoManager.a().c().size() > 1) {
                    this.v = SelectPhotoManager.a().c().get(1);
                    this.k.loadImageFromLocal(getFragmentActive(), this.v.mImagePath);
                    this.l.setVisibility(8);
                    this.m.setVisibility(0);
                }
            } else if (i == 2) {
                this.v = SelectPhotoManager.a().c().get(0);
                this.k.loadImageFromLocal(getFragmentActive(), this.v.mImagePath);
                this.l.setVisibility(8);
                this.m.setVisibility(0);
                if (SelectPhotoManager.a().c().size() > 1) {
                    this.u = SelectPhotoManager.a().c().get(1);
                    this.f.loadImageFromLocal(getFragmentActive(), this.u.mImagePath);
                    this.g.setVisibility(8);
                    this.h.setVisibility(0);
                }
            }
        }
        SelectPhotoManager.a().c().clear();
        e();
        d();
    }

    private void c(ScalableImageView scalableImageView) {
        scalableImageView.postRotate(90.0f);
    }

    private void d() {
        if (this.u == null || this.v == null) {
            this.c.setRightTextColor(R.color.nafio_u);
        } else {
            this.c.setRightTextColor(R.color.nafio_a);
        }
    }

    private void e() {
        if (this.u != null && this.v == null) {
            this.t = 1;
        } else if (this.u == null && this.v != null) {
            this.t = 2;
        }
        int i = this.t;
        if (i == 1) {
            this.i.setVisibility(0);
            this.n.setVisibility(8);
            this.o.setVisibility(0);
        } else if (i != 2) {
            this.i.setVisibility(8);
            this.n.setVisibility(8);
            this.o.setVisibility(8);
        } else {
            this.i.setVisibility(8);
            this.n.setVisibility(0);
            this.o.setVisibility(0);
        }
    }

    private void f() {
        if (this.u == null && this.v == null) {
            getActivity().finish();
            return;
        }
        Context context = this.a;
        CommonAlertDialog.a(context, context.getResources().getString(R.string.picture_voting_close), this.a.getResources().getString(R.string.picture_voting_close_tip), this.a.getResources().getString(R.string.common_ok), new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.send.fragment.PictureVoteEditFragment.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                PictureVoteEditFragment.this.getActivity().finish();
            }
        }, this.a.getResources().getString(R.string.cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    private void g() {
        if (this.u == null || this.v == null) {
            return;
        }
        this.h.setVisibility(8);
        this.i.setVisibility(8);
        this.m.setVisibility(8);
        this.n.setVisibility(8);
        String str = RecyclingUtils.a() + BridgeUtil.SPLIT_MARK + System.currentTimeMillis() + ".jpg";
        ImageUtils.b(BitmapUtils.a(this.d), str, 100);
        Intent intent = new Intent();
        intent.putExtra("voting_picture_path", str);
        getActivity().setResult(-1, intent);
        getActivity().finish();
    }

    private void h() {
        this.w = true;
        int measuredWidth = this.e.getMeasuredWidth() + DensityUtils.a(this.a, 3.0f);
        int measuredHeight = this.e.getMeasuredHeight() / 2;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.e, "scaleX", 0.5f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.e, "scaleY", 0.5f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.j, "scaleX", 0.5f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.j, "scaleY", 0.5f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
        animatorSet.setDuration(500L);
        animatorSet.start();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.e, "translationX", measuredWidth / 2);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.e, "translationY", (-measuredHeight) * (this.x ? -1 : 1));
        int i = -measuredWidth;
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.j, "translationX", i / 2);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.j, "translationY", measuredHeight * (this.x ? -1 : 1));
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat8);
        animatorSet2.setDuration(500L);
        animatorSet2.setStartDelay(500L);
        animatorSet2.start();
        FrameLayout frameLayout = this.e;
        int i2 = measuredWidth;
        if (this.x) {
            i2 = 0;
        }
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(frameLayout, "translationX", i2);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.e, "translationY", 0.0f);
        FrameLayout frameLayout2 = this.j;
        int i3 = i;
        if (this.x) {
            i3 = 0;
        }
        ObjectAnimator ofFloat11 = ObjectAnimator.ofFloat(frameLayout2, "translationX", i3);
        ObjectAnimator ofFloat12 = ObjectAnimator.ofFloat(this.j, "translationY", 0.0f);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.play(ofFloat9).with(ofFloat10).with(ofFloat11).with(ofFloat12);
        animatorSet3.setDuration(500L);
        animatorSet3.setStartDelay(1000L);
        animatorSet3.start();
        ObjectAnimator ofFloat13 = ObjectAnimator.ofFloat(this.e, "scaleX", 1.0f);
        ObjectAnimator ofFloat14 = ObjectAnimator.ofFloat(this.e, "scaleY", 1.0f);
        ObjectAnimator ofFloat15 = ObjectAnimator.ofFloat(this.j, "scaleX", 1.0f);
        ObjectAnimator ofFloat16 = ObjectAnimator.ofFloat(this.j, "scaleY", 1.0f);
        AnimatorSet animatorSet4 = new AnimatorSet();
        animatorSet4.play(ofFloat13).with(ofFloat14).with(ofFloat15).with(ofFloat16);
        animatorSet4.setDuration(500L);
        animatorSet4.setStartDelay(1500L);
        animatorSet4.start();
        animatorSet4.addListener(new AnimatorListenerAdapter() { // from class: com.blued.community.ui.send.fragment.PictureVoteEditFragment.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                PictureVoteEditFragment.this.w = false;
                PictureVoteEditFragment pictureVoteEditFragment = PictureVoteEditFragment.this;
                pictureVoteEditFragment.x = !pictureVoteEditFragment.x;
            }
        });
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        f();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (this.w) {
            return;
        }
        int id = view.getId();
        if (id == R.id.ctt_left) {
            f();
        } else if (id == R.id.ctt_right) {
            EventTrackVote.a(VoteProtos.Event.VOTE_PHOTO_PAGE_CONFIRM_BTN_CLICK);
            g();
        } else {
            int i = 2;
            if (id == R.id.iv_add_left) {
                EventTrackVote.a(VoteProtos.Event.VOTE_EDIT_PAGE_UPLOAD_CLICK);
                this.t = 1;
                SelectPhotoManager.a().d();
                if (this.v != null) {
                    i = 1;
                }
                AlbumSelectFragment.a(this, 4, 1, i, 0);
            } else if (id == R.id.iv_delete_left) {
                this.t = 0;
                this.u = null;
                this.f.setImageDrawable((Drawable) null);
                this.g.setVisibility(0);
                this.h.setVisibility(8);
                e();
                d();
            } else if (id == R.id.iv_add_right) {
                EventTrackVote.a(VoteProtos.Event.VOTE_EDIT_PAGE_UPLOAD_CLICK);
                this.t = 2;
                SelectPhotoManager.a().d();
                if (this.u != null) {
                    i = 1;
                }
                AlbumSelectFragment.a(this, 4, 1, i, 0);
            } else if (id == R.id.iv_delete_right) {
                this.t = 0;
                this.v = null;
                this.k.setImageDrawable((Drawable) null);
                this.l.setVisibility(0);
                this.m.setVisibility(8);
                e();
                d();
            } else if (id == R.id.layout_enlarge) {
                EventTrackVote.a(VoteProtos.Event.VOTE_EDIT_PAGE_BIG_BTN_CLICK);
                int i2 = this.t;
                if (i2 == 1) {
                    a(this.f);
                } else if (i2 != 2) {
                } else {
                    a(this.k);
                }
            } else if (id == R.id.layout_narrow) {
                EventTrackVote.a(VoteProtos.Event.VOTE_EDIT_PAGE_SMALL_BTN_CLICK);
                int i3 = this.t;
                if (i3 == 1) {
                    b(this.f);
                } else if (i3 != 2) {
                } else {
                    b(this.k);
                }
            } else if (id != R.id.layout_rotate) {
                if (id == R.id.layout_exchange) {
                    EventTrackVote.a(VoteProtos.Event.VOTE_EDIT_PAGE_CHANGE_BTN_CLICK);
                    h();
                }
            } else {
                EventTrackVote.a(VoteProtos.Event.VOTE_EDIT_PAGE_TURN_BTN_CLICK);
                int i4 = this.t;
                if (i4 == 1) {
                    c(this.f);
                } else if (i4 != 2) {
                } else {
                    c(this.k);
                }
            }
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_picture_vote_edit, viewGroup, false);
            a();
            b();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        EventTrackVote.a(VoteProtos.Event.VOTE_EDIT_PAGE_SHOW);
        return this.b;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onDestroy() {
        super.onDestroy();
        SelectPhotoManager.a().c().clear();
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onResume() {
        super.onResume();
        c();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int id = view.getId();
            if (id == R.id.siv_left) {
                if (this.u != null) {
                    this.t = 1;
                }
            } else if (id == R.id.siv_right && this.v != null) {
                this.t = 2;
            }
            e();
            return false;
        }
        return false;
    }
}
