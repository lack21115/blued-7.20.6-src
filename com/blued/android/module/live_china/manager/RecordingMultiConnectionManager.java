package com.blued.android.module.live_china.manager;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.AssetsUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.common.ZegoCommonHelper;
import com.blued.android.module.live_china.common.ZegoMixStreamHelper;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveInviteUserModel;
import com.blued.android.module.live_china.model.RelationInfo;
import com.blued.android.module.live_china.utils.LiveCloakingUtil;
import com.blued.android.module.live_china.view.LiveMultiPKFirstPayView;
import com.blued.android.module.live_china.view.LiveMultiPKItemView;
import com.blued.android.module.live_china.view.LiveMultiPKPayMVPView;
import com.blued.android.module.live_china.view.LiveMultiPKResult;
import com.blued.android.module.live_china.view.LiveMultiPKTitle;
import com.blued.android.module.live_china.view.LivePKProgressView;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAParser;
import com.blued.android.module.svgaplayer.SVGAVideoEntity;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/RecordingMultiConnectionManager.class */
public class RecordingMultiConnectionManager {
    public static int a = 0;
    public static int b = 0;
    public static int c = 0;
    public static int d = 0;
    public static double e = 0.85d;
    public static int f;
    List<LiveInviteUserModel> g = new ArrayList();
    private Context h;
    private RecordingOnliveFragment i;

    public RecordingMultiConnectionManager(RecordingOnliveFragment recordingOnliveFragment) {
        this.i = recordingOnliveFragment;
        this.h = recordingOnliveFragment.getContext();
        a = AppInfo.l / 2;
        int i = (int) (AppInfo.l * e);
        b = i;
        c = i / 2;
        d = DensityUtils.a(this.h, 148);
        f = StatusBarHelper.a() ? d - StatusBarHelper.a((Context) recordingOnliveFragment.getActivity()) : d;
    }

    public static List<LiveInviteUserModel> a(List<LiveInviteUserModel> list, List<LiveInviteUserModel> list2) {
        String str;
        int i;
        if (list != null) {
            if (list.size() >= 2) {
                if (list2.size() > 4) {
                    ArrayList arrayList = new ArrayList();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= 4) {
                            break;
                        }
                        arrayList.add(list2.get(i3));
                        i2 = i3 + 1;
                    }
                    list2.clear();
                    list2.addAll(arrayList);
                }
                if (list.get(0) != null) {
                    str = list.get(0).group_id;
                    i = 0;
                } else {
                    str = "0";
                    i = 0;
                }
                while (true) {
                    int i4 = i;
                    if (i4 >= list2.size()) {
                        break;
                    }
                    LiveInviteUserModel liveInviteUserModel = list2.get(i4);
                    LiveInviteUserModel liveInviteUserModel2 = liveInviteUserModel;
                    if (liveInviteUserModel == null) {
                        liveInviteUserModel2 = new LiveInviteUserModel();
                        list2.set(i4, liveInviteUserModel2);
                    }
                    if (i4 < list.size() && list.get(i4) != null) {
                        liveInviteUserModel2.win_streak = list.get(i4).win_streak;
                        liveInviteUserModel2.duration = list.get(i4).duration;
                        liveInviteUserModel2.rank = list.get(i4).rank;
                        liveInviteUserModel2.score = list.get(i4).score;
                        liveInviteUserModel2.status = list.get(i4).status;
                        liveInviteUserModel2.fb_time = list.get(i4).fb_time;
                        liveInviteUserModel2.buff_time = list.get(i4).buff_time;
                        liveInviteUserModel2.first_kill_message = list.get(i4).first_kill_message;
                        liveInviteUserModel2.mvp_uid = list.get(i4).mvp_uid;
                        liveInviteUserModel2.mvp_name = list.get(i4).mvp_name;
                        liveInviteUserModel2.mvp_avatar = list.get(i4).mvp_avatar;
                        liveInviteUserModel2.mvp_hide = list.get(i4).mvp_hide;
                        liveInviteUserModel2.first_kill_uid = list.get(i4).first_kill_uid;
                        liveInviteUserModel2.first_kill_name = list.get(i4).first_kill_name;
                        liveInviteUserModel2.first_kill_avatar = list.get(i4).first_kill_avatar;
                        liveInviteUserModel2.group_id = list.get(i4).group_id;
                        liveInviteUserModel2.my_group_id = str;
                        liveInviteUserModel2.group_score = list.get(i4).group_score;
                        liveInviteUserModel2.first_kill_hide = list.get(i4).first_kill_hide;
                    }
                    i = i4 + 1;
                }
            } else {
                return list2;
            }
        }
        return list2;
    }

    public static void a(FrameLayout frameLayout, int i, List<LiveInviteUserModel> list) {
        LiveMultiPKPayMVPView liveMultiPKPayMVPView;
        LiveInviteUserModel liveInviteUserModel;
        LiveInviteUserModel liveInviteUserModel2;
        int i2;
        if (list == null || list.size() < 2 || frameLayout == null || (liveMultiPKPayMVPView = (LiveMultiPKPayMVPView) frameLayout.findViewById(R.id.live_multi_pk_mvp_view_id)) == null) {
            return;
        }
        if (i != 1) {
            if (i != 2 || (liveInviteUserModel = list.get(0)) == null || StringUtils.a(liveInviteUserModel.mvp_uid, 0) <= 0 || liveMultiPKPayMVPView == null) {
                return;
            }
            liveMultiPKPayMVPView.setVisibility(0);
            liveMultiPKPayMVPView.a(TextUtils.equals(LiveRoomInfo.a().f(), LiveRoomManager.a().g()) ? liveInviteUserModel.mvp_name : LiveCloakingUtil.a(liveInviteUserModel.mvp_name, liveInviteUserModel.mvp_hide), liveInviteUserModel.mvp_avatar);
            return;
        }
        int i3 = -1;
        Iterator<LiveInviteUserModel> it = list.iterator();
        do {
            liveInviteUserModel2 = null;
            i2 = i3;
            if (!it.hasNext()) {
                break;
            }
            liveInviteUserModel2 = it.next();
            i2 = i3 + 1;
            i3 = i2;
        } while (StringUtils.a(liveInviteUserModel2.first_kill_uid, 0) <= 0);
        if (liveInviteUserModel2 != null) {
            liveMultiPKPayMVPView.setVisibility(0);
            liveMultiPKPayMVPView.a(i2, list.size(), TextUtils.equals(LiveRoomInfo.a().f(), LiveRoomManager.a().g()) ? liveInviteUserModel2.first_kill_name : LiveCloakingUtil.a(liveInviteUserModel2.first_kill_name, liveInviteUserModel2.first_kill_hide), liveInviteUserModel2.first_kill_avatar);
        }
    }

    public static void a(FrameLayout frameLayout, RelationInfo relationInfo) {
        FrameLayout frameLayout2;
        int childCount;
        if (relationInfo == null || frameLayout == null) {
            return;
        }
        View findViewById = frameLayout.findViewById(R.id.live_multi_content_view_id);
        if (!(findViewById instanceof FrameLayout) || (childCount = (frameLayout2 = (FrameLayout) findViewById).getChildCount()) <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            View childAt = frameLayout2.getChildAt(i2);
            if (childAt instanceof LiveMultiPKItemView) {
                LiveMultiPKItemView liveMultiPKItemView = (LiveMultiPKItemView) childAt;
                if (TextUtils.equals(liveMultiPKItemView.getItem().uid, relationInfo.getUid())) {
                    liveMultiPKItemView.setRelation(relationInfo.getRelation());
                }
            }
            i = i2 + 1;
        }
    }

    public static void a(FrameLayout frameLayout, String str, boolean z) {
        FrameLayout frameLayout2;
        int childCount;
        if (frameLayout == null || TextUtils.isEmpty(str)) {
            return;
        }
        View findViewById = frameLayout.findViewById(R.id.live_multi_content_view_id);
        if (!(findViewById instanceof FrameLayout) || (childCount = (frameLayout2 = (FrameLayout) findViewById).getChildCount()) <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            View childAt = frameLayout2.getChildAt(i2);
            if (childAt instanceof LiveMultiPKItemView) {
                LiveMultiPKItemView liveMultiPKItemView = (LiveMultiPKItemView) childAt;
                if (str.equals(liveMultiPKItemView.getItem().uid)) {
                    liveMultiPKItemView.a(z);
                }
            }
            i = i2 + 1;
        }
    }

    public static void a(FrameLayout frameLayout, List<LiveInviteUserModel> list) {
        View findViewById;
        FrameLayout frameLayout2;
        int childCount;
        if (list == null || list.size() <= 0 || list.get(0) == null || frameLayout == null || (findViewById = frameLayout.findViewById(R.id.live_multi_title_view_id)) == null) {
            return;
        }
        list.get(0).my_count = 0;
        list.get(0).other_count = 0;
        if (StringUtils.a(list.get(0).my_group_id, 0) > 0) {
            for (LiveInviteUserModel liveInviteUserModel : list) {
                if (StringUtils.a(liveInviteUserModel.group_id, 0) == StringUtils.a(liveInviteUserModel.my_group_id, 0)) {
                    list.get(0).my_count++;
                } else {
                    list.get(0).other_count++;
                }
            }
        }
        if (findViewById instanceof LiveMultiPKTitle) {
            ((LiveMultiPKTitle) findViewById).setTitle(list.get(0));
        }
        View findViewById2 = frameLayout.findViewById(R.id.live_multi_content_view_id);
        if ((findViewById2 instanceof FrameLayout) && (childCount = (frameLayout2 = (FrameLayout) findViewById2).getChildCount()) > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childCount) {
                    break;
                }
                View childAt = frameLayout2.getChildAt(i2);
                if (childAt instanceof LiveMultiPKItemView) {
                    if (i2 < list.size()) {
                        ((LiveMultiPKItemView) childAt).setPkData(list.get(i2));
                    } else {
                        Log.e("==xpm", "startItemPK index out:" + i2 + " view size:" + childCount);
                    }
                }
                i = i2 + 1;
            }
        }
        LivePKProgressView livePKProgressView = (LivePKProgressView) frameLayout.findViewById(R.id.live_multi_pk_progress_view_id);
        livePKProgressView.setVisibility(8);
        livePKProgressView.b();
        if (list.get(0).status == 1) {
            if (list.get(0).isGroup()) {
                final SVGAImageView sVGAImageView = (SVGAImageView) frameLayout.findViewById(R.id.live_multi_pk_multi_start_view_id);
                sVGAImageView.setVisibility(0);
                sVGAImageView.setLoops(1);
                SVGAParser.a.b().a("live_multi_pk_group_start_anim.svga", new SVGAParser.ParseCompletion() { // from class: com.blued.android.module.live_china.manager.RecordingMultiConnectionManager.5
                    @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
                    public void onComplete(SVGAVideoEntity sVGAVideoEntity) {
                        SVGAImageView.this.setVideoItem(sVGAVideoEntity);
                        SVGAImageView.this.a(0, true);
                    }

                    @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
                    public void onError() {
                    }
                }, (SVGAParser.PlayCallback) null);
            } else {
                ImageView imageView = (ImageView) frameLayout.findViewById(R.id.live_multi_pk_start_view_id);
                imageView.setVisibility(0);
                ImageLoader.a((IRequestHost) null, RecyclingUtils.Scheme.FILE.b(AssetsUtils.a("live_multi_pk_start_anim.png", false))).e(imageView.hashCode()).a(imageView);
            }
            ((LiveMultiPKFirstPayView) frameLayout.findViewById(R.id.live_multi_pk_first_view_id)).setText(list.get(0).first_kill_message);
        } else if (list.get(0).status == 2) {
            b(frameLayout, list);
        }
        a(frameLayout, list, false);
    }

    public static void a(FrameLayout frameLayout, List<LiveInviteUserModel> list, int i, int i2, BaseFragment baseFragment) {
        FrameLayout frameLayout2;
        int childCount;
        if (frameLayout == null || list == null || list.size() <= 0) {
            return;
        }
        int i3 = i2 / 2;
        LiveMultiPKTitle liveMultiPKTitle = new LiveMultiPKTitle(AppInfo.d());
        liveMultiPKTitle.setFragment(baseFragment);
        liveMultiPKTitle.setTitle(list.get(0));
        liveMultiPKTitle.setElevation(1.0f);
        liveMultiPKTitle.setId(R.id.live_multi_title_view_id);
        int i4 = i * 2;
        frameLayout.addView(liveMultiPKTitle, new FrameLayout.LayoutParams(i4, i2));
        FrameLayout frameLayout3 = new FrameLayout(AppInfo.d());
        frameLayout3.setId(R.id.live_multi_content_view_id);
        frameLayout.addView(frameLayout3, new FrameLayout.LayoutParams(i4, i2));
        int size = list.size();
        list.get(0).voice_disable = -1;
        if (size == 2) {
            LiveMultiPKItemView liveMultiPKItemView = new LiveMultiPKItemView(AppInfo.d());
            frameLayout3.addView(liveMultiPKItemView, new FrameLayout.LayoutParams(i, i2));
            liveMultiPKItemView.setData(list.get(0));
            LiveMultiPKItemView liveMultiPKItemView2 = new LiveMultiPKItemView(AppInfo.d());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2);
            layoutParams.leftMargin = i;
            frameLayout3.addView(liveMultiPKItemView2, layoutParams);
            liveMultiPKItemView2.setData(list.get(1));
        } else if (size == 3) {
            LiveMultiPKItemView liveMultiPKItemView3 = new LiveMultiPKItemView(AppInfo.d());
            frameLayout3.addView(liveMultiPKItemView3, new FrameLayout.LayoutParams(i, i2));
            liveMultiPKItemView3.setData(list.get(0));
            LiveMultiPKItemView liveMultiPKItemView4 = new LiveMultiPKItemView(AppInfo.d());
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i3);
            layoutParams2.leftMargin = i;
            frameLayout3.addView(liveMultiPKItemView4, layoutParams2);
            liveMultiPKItemView4.setData(list.get(1));
            LiveMultiPKItemView liveMultiPKItemView5 = new LiveMultiPKItemView(AppInfo.d());
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i, i3);
            layoutParams3.leftMargin = i;
            layoutParams3.topMargin = i3;
            frameLayout3.addView(liveMultiPKItemView5, layoutParams3);
            liveMultiPKItemView5.setData(list.get(2));
        } else if (size == 4) {
            LiveMultiPKItemView liveMultiPKItemView6 = new LiveMultiPKItemView(AppInfo.d());
            frameLayout3.addView(liveMultiPKItemView6, new FrameLayout.LayoutParams(i, i3));
            liveMultiPKItemView6.setData(list.get(0));
            LiveMultiPKItemView liveMultiPKItemView7 = new LiveMultiPKItemView(AppInfo.d());
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(i, i3);
            layoutParams4.leftMargin = i;
            frameLayout3.addView(liveMultiPKItemView7, layoutParams4);
            liveMultiPKItemView7.setData(list.get(1));
            LiveMultiPKItemView liveMultiPKItemView8 = new LiveMultiPKItemView(AppInfo.d());
            FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(i, i3);
            layoutParams5.topMargin = i3;
            frameLayout3.addView(liveMultiPKItemView8, layoutParams5);
            liveMultiPKItemView8.setData(list.get(2));
            LiveMultiPKItemView liveMultiPKItemView9 = new LiveMultiPKItemView(AppInfo.d());
            FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(i, i3);
            layoutParams6.leftMargin = i;
            layoutParams6.topMargin = i3;
            frameLayout3.addView(liveMultiPKItemView9, layoutParams6);
            liveMultiPKItemView9.setData(list.get(3));
        }
        View imageView = new ImageView(AppInfo.d());
        imageView.setId(R.id.live_multi_pk_start_view_id);
        imageView.setVisibility(8);
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(AppInfo.l, i2));
        View sVGAImageView = new SVGAImageView(AppInfo.d());
        sVGAImageView.setId(R.id.live_multi_pk_multi_start_view_id);
        sVGAImageView.setVisibility(8);
        frameLayout.addView(sVGAImageView, new FrameLayout.LayoutParams(AppInfo.l, i2));
        View liveMultiPKResult = new LiveMultiPKResult(AppInfo.d());
        liveMultiPKResult.setId(R.id.live_multi_pk_result_view_id);
        liveMultiPKResult.setVisibility(8);
        frameLayout.addView(liveMultiPKResult, new FrameLayout.LayoutParams(AppInfo.l, i2));
        View liveMultiPKPayMVPView = new LiveMultiPKPayMVPView(AppInfo.d());
        liveMultiPKPayMVPView.setId(R.id.live_multi_pk_mvp_view_id);
        liveMultiPKPayMVPView.setVisibility(8);
        frameLayout.addView(liveMultiPKPayMVPView, new FrameLayout.LayoutParams(AppInfo.l, i2));
        LinearLayout linearLayout = new LinearLayout(AppInfo.d());
        linearLayout.setOrientation(1);
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams7.topMargin = i2;
        frameLayout.addView(linearLayout, layoutParams7);
        LivePKProgressView livePKProgressView = new LivePKProgressView(AppInfo.d());
        livePKProgressView.b();
        livePKProgressView.setId(R.id.live_multi_pk_progress_view_id);
        livePKProgressView.setVisibility(8);
        linearLayout.addView(livePKProgressView, new ViewGroup.MarginLayoutParams(-1, -2));
        LiveMultiPKFirstPayView liveMultiPKFirstPayView = new LiveMultiPKFirstPayView(AppInfo.d());
        liveMultiPKFirstPayView.setId(R.id.live_multi_pk_first_view_id);
        liveMultiPKFirstPayView.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.topMargin = DensityUtils.a(AppInfo.d(), 8.5f);
        marginLayoutParams.leftMargin = AppInfo.l - DensityUtils.a(AppInfo.d(), 97.0f);
        linearLayout.addView(liveMultiPKFirstPayView, marginLayoutParams);
        if (list.get(0).status == 1 || list.get(0).status == 2) {
            View findViewById = frameLayout.findViewById(R.id.live_multi_content_view_id);
            if ((findViewById instanceof FrameLayout) && (childCount = (frameLayout2 = (FrameLayout) findViewById).getChildCount()) > 0) {
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= childCount) {
                        break;
                    }
                    View childAt = frameLayout2.getChildAt(i6);
                    if (childAt instanceof LiveMultiPKItemView) {
                        if (i6 < list.size()) {
                            ((LiveMultiPKItemView) childAt).setPkData(list.get(i6));
                        } else {
                            Log.e("==xpm", "startItemPK index out:" + i6 + " view size:" + childCount);
                        }
                    }
                    i5 = i6 + 1;
                }
            }
            ((LiveMultiPKFirstPayView) frameLayout.findViewById(R.id.live_multi_pk_first_view_id)).setText(list.get(0).first_kill_message);
            c(frameLayout, list);
            d(frameLayout, list);
        }
    }

    public static void a(FrameLayout frameLayout, List<LiveInviteUserModel> list, boolean z) {
        FrameLayout frameLayout2;
        int childCount;
        if (list == null || list.size() <= 0 || frameLayout == null) {
            return;
        }
        if (LiveRoomManager.a().m() == 12 || LiveRoomManager.a().m() == 13) {
            View findViewById = frameLayout.findViewById(R.id.live_multi_content_view_id);
            if ((findViewById instanceof FrameLayout) && (childCount = (frameLayout2 = (FrameLayout) findViewById).getChildCount()) > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= childCount) {
                        break;
                    }
                    View childAt = frameLayout2.getChildAt(i2);
                    if (childAt instanceof LiveMultiPKItemView) {
                        if (i2 < list.size()) {
                            LiveMultiPKItemView liveMultiPKItemView = (LiveMultiPKItemView) childAt;
                            LiveInviteUserModel liveInviteUserModel = list.get(i2);
                            if (liveInviteUserModel != null) {
                                liveMultiPKItemView.a(liveInviteUserModel.score, liveInviteUserModel.rank);
                            }
                        } else {
                            Log.e("==xpm", "updateItemPKScore index out:" + i2 + " view size:" + childCount);
                        }
                    }
                    i = i2 + 1;
                }
            }
            if (z) {
                a(frameLayout, 1, list);
            }
            c(frameLayout, list);
            d(frameLayout, list);
        }
    }

    public static List<LiveInviteUserModel> b(List<LiveInviteUserModel> list, List<LiveInviteUserModel> list2) {
        String str;
        int i;
        if (list != null) {
            if (list.size() >= 2) {
                if (list2.size() > 4) {
                    ArrayList arrayList = new ArrayList();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= 4) {
                            break;
                        }
                        arrayList.add(list2.get(i3));
                        i2 = i3 + 1;
                    }
                    list2.clear();
                    list2.addAll(arrayList);
                }
                if (list.get(0) != null) {
                    str = list.get(0).group_id;
                    i = 0;
                } else {
                    str = "0";
                    i = 0;
                }
                while (true) {
                    int i4 = i;
                    if (i4 >= list2.size()) {
                        break;
                    }
                    LiveInviteUserModel liveInviteUserModel = list2.get(i4);
                    LiveInviteUserModel liveInviteUserModel2 = liveInviteUserModel;
                    if (liveInviteUserModel == null) {
                        liveInviteUserModel2 = new LiveInviteUserModel();
                        list2.set(i4, liveInviteUserModel2);
                    }
                    if (i4 < list.size() && list.get(i4) != null) {
                        liveInviteUserModel2.win_streak = list.get(i4).win_streak;
                        liveInviteUserModel2.duration = list.get(i4).duration;
                        liveInviteUserModel2.rank = list.get(i4).rank;
                        liveInviteUserModel2.result = list.get(i4).result;
                        liveInviteUserModel2.status = list.get(i4).status;
                        liveInviteUserModel2.interaction_text = list.get(i4).interaction_text;
                        liveInviteUserModel2.mvp_uid = list.get(i4).mvp_uid;
                        liveInviteUserModel2.mvp_name = list.get(i4).mvp_name;
                        liveInviteUserModel2.mvp_avatar = list.get(i4).mvp_avatar;
                        liveInviteUserModel2.group_id = list.get(i4).group_id;
                        liveInviteUserModel2.my_group_id = str;
                        liveInviteUserModel2.group_score = list.get(i4).group_score;
                        liveInviteUserModel2.mvp_hide = list.get(i4).mvp_hide;
                    }
                    i = i4 + 1;
                }
            } else {
                return list2;
            }
        }
        return list2;
    }

    public static void b(FrameLayout frameLayout) {
        View findViewById;
        FrameLayout frameLayout2;
        int childCount;
        if (frameLayout == null || (findViewById = frameLayout.findViewById(R.id.live_multi_title_view_id)) == null) {
            return;
        }
        if (findViewById instanceof LiveMultiPKTitle) {
            ((LiveMultiPKTitle) findViewById).g();
        }
        View findViewById2 = frameLayout.findViewById(R.id.live_multi_content_view_id);
        if ((findViewById2 instanceof FrameLayout) && (childCount = (frameLayout2 = (FrameLayout) findViewById2).getChildCount()) > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childCount) {
                    break;
                }
                View childAt = frameLayout2.getChildAt(i2);
                if (childAt instanceof LiveMultiPKItemView) {
                    ((LiveMultiPKItemView) childAt).b();
                }
                i = i2 + 1;
            }
        }
        ((LiveMultiPKResult) frameLayout.findViewById(R.id.live_multi_pk_result_view_id)).a();
        frameLayout.findViewById(R.id.live_multi_pk_start_view_id).setVisibility(8);
        frameLayout.findViewById(R.id.live_multi_pk_multi_start_view_id).setVisibility(8);
        ((LiveMultiPKFirstPayView) frameLayout.findViewById(R.id.live_multi_pk_first_view_id)).setVisibility(8);
        ((LivePKProgressView) frameLayout.findViewById(R.id.live_multi_pk_progress_view_id)).setVisibility(8);
    }

    public static void b(final FrameLayout frameLayout, final List<LiveInviteUserModel> list) {
        View findViewById;
        FrameLayout frameLayout2;
        int childCount;
        if (list == null || list.size() <= 0 || list.get(0) == null || frameLayout == null || (findViewById = frameLayout.findViewById(R.id.live_multi_title_view_id)) == null) {
            return;
        }
        if (findViewById instanceof LiveMultiPKTitle) {
            ((LiveMultiPKTitle) findViewById).setTitle(list.get(0));
        }
        View findViewById2 = frameLayout.findViewById(R.id.live_multi_content_view_id);
        if ((findViewById2 instanceof FrameLayout) && (childCount = (frameLayout2 = (FrameLayout) findViewById2).getChildCount()) > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childCount) {
                    break;
                }
                View childAt = frameLayout2.getChildAt(i2);
                if (childAt instanceof LiveMultiPKItemView) {
                    if (i2 < list.size()) {
                        LiveMultiPKItemView liveMultiPKItemView = (LiveMultiPKItemView) childAt;
                        LiveInviteUserModel liveInviteUserModel = list.get(i2);
                        if (liveInviteUserModel != null) {
                            liveMultiPKItemView.b(liveInviteUserModel.result, liveInviteUserModel.win_streak);
                        }
                    } else {
                        Log.e("==xpm", "startItemPK index out:" + i2 + " view size:" + childCount);
                    }
                }
                i = i2 + 1;
            }
        }
        final boolean isGroup = list.get(0).isGroup();
        LiveMultiPKResult liveMultiPKResult = (LiveMultiPKResult) frameLayout.findViewById(R.id.live_multi_pk_result_view_id);
        liveMultiPKResult.setVisibility(0);
        liveMultiPKResult.setCallBack(new LiveMultiPKResult.EventCallBack() { // from class: com.blued.android.module.live_china.manager.RecordingMultiConnectionManager.6
            @Override // com.blued.android.module.live_china.view.LiveMultiPKResult.EventCallBack
            public void a() {
                FrameLayout frameLayout3;
                int childCount2;
                if (!isGroup) {
                    RecordingMultiConnectionManager.a(frameLayout, 2, list);
                    return;
                }
                View findViewById3 = frameLayout.findViewById(R.id.live_multi_content_view_id);
                if (!(findViewById3 instanceof FrameLayout) || (childCount2 = (frameLayout3 = (FrameLayout) findViewById3).getChildCount()) <= 0) {
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= childCount2) {
                        return;
                    }
                    View childAt2 = frameLayout3.getChildAt(i4);
                    if ((childAt2 instanceof LiveMultiPKItemView) && i4 < list.size()) {
                        LiveMultiPKItemView liveMultiPKItemView2 = (LiveMultiPKItemView) childAt2;
                        LiveInviteUserModel liveInviteUserModel2 = (LiveInviteUserModel) list.get(i4);
                        if (liveInviteUserModel2 != null) {
                            liveMultiPKItemView2.a(liveInviteUserModel2.result);
                        }
                    }
                    i3 = i4 + 1;
                }
            }
        });
        liveMultiPKResult.a(list.get(0).result, list.size(), isGroup);
        ((LiveMultiPKFirstPayView) frameLayout.findViewById(R.id.live_multi_pk_first_view_id)).setVisibility(8);
    }

    public static List<LiveInviteUserModel> c(List<LiveInviteUserModel> list, List<LiveInviteUserModel> list2) {
        if (list != null) {
            if (list.size() >= 2) {
                if (list2.size() > 4) {
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= 4) {
                            break;
                        }
                        arrayList.add(list2.get(i2));
                        i = i2 + 1;
                    }
                    list2.clear();
                    list2.addAll(arrayList);
                }
                String str = list.get(0) != null ? list.get(0).group_id : "0";
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= list2.size()) {
                        break;
                    }
                    LiveInviteUserModel liveInviteUserModel = list2.get(i4);
                    LiveInviteUserModel liveInviteUserModel2 = liveInviteUserModel;
                    if (liveInviteUserModel == null) {
                        liveInviteUserModel2 = new LiveInviteUserModel();
                        list2.set(i4, liveInviteUserModel2);
                    }
                    if (i4 < list.size() && list.get(i4) != null) {
                        liveInviteUserModel2.rank = list.get(i4).rank;
                        liveInviteUserModel2.scoreChanged = liveInviteUserModel2.score != list.get(i4).score;
                        liveInviteUserModel2.score = list.get(i4).score;
                        liveInviteUserModel2.incr_score = list.get(i4).incr_score;
                        liveInviteUserModel2.first_kill_uid = list.get(i4).first_kill_uid;
                        liveInviteUserModel2.first_kill_name = list.get(i4).first_kill_name;
                        liveInviteUserModel2.first_kill_avatar = list.get(i4).first_kill_avatar;
                        liveInviteUserModel2.group_id = list.get(i4).group_id;
                        liveInviteUserModel2.my_group_id = str;
                        liveInviteUserModel2.group_score = list.get(i4).group_score;
                        liveInviteUserModel2.first_kill_hide = list.get(i4).first_kill_hide;
                    }
                    i3 = i4 + 1;
                }
            } else {
                return list2;
            }
        }
        return list2;
    }

    public static void c(FrameLayout frameLayout) {
        View findViewById;
        if (frameLayout == null || (findViewById = frameLayout.findViewById(R.id.live_multi_title_view_id)) == null || !(findViewById instanceof LiveMultiPKTitle)) {
            return;
        }
        ((LiveMultiPKTitle) findViewById).h();
    }

    public static void c(FrameLayout frameLayout, List<LiveInviteUserModel> list) {
        LiveMultiPKFirstPayView liveMultiPKFirstPayView = (LiveMultiPKFirstPayView) frameLayout.findViewById(R.id.live_multi_pk_first_view_id);
        if (list.get(0).status != 1) {
            liveMultiPKFirstPayView.setVisibility(8);
            return;
        }
        boolean z = false;
        for (LiveInviteUserModel liveInviteUserModel : list) {
            if (liveInviteUserModel != null && liveInviteUserModel.score > 0.0d) {
                z = true;
            }
        }
        liveMultiPKFirstPayView.setVisibility(!z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.i.ac.c();
        this.i.bJ.removeAllViews();
        int size = this.g.size();
        if (size == 2) {
            FrameLayout frameLayout = new FrameLayout(this.h);
            this.i.bJ.addView(frameLayout, new FrameLayout.LayoutParams(a, b));
            a(frameLayout);
            FrameLayout frameLayout2 = new FrameLayout(this.h);
            frameLayout2.setBackgroundColor(Color.parseColor("#000000"));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a, b);
            layoutParams.leftMargin = a;
            this.i.bJ.addView(frameLayout2, layoutParams);
            a(frameLayout2, this.g.get(1).stream_id);
        } else if (size == 3) {
            FrameLayout frameLayout3 = new FrameLayout(this.h);
            this.i.bJ.addView(frameLayout3, new FrameLayout.LayoutParams(a, b));
            a(frameLayout3);
            FrameLayout frameLayout4 = new FrameLayout(this.h);
            frameLayout4.setBackgroundColor(Color.parseColor("#000000"));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(a, c);
            layoutParams2.leftMargin = a;
            this.i.bJ.addView(frameLayout4, layoutParams2);
            a(frameLayout4, this.g.get(1).stream_id);
            FrameLayout frameLayout5 = new FrameLayout(this.h);
            frameLayout5.setBackgroundColor(Color.parseColor("#000000"));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(a, c);
            layoutParams3.leftMargin = a;
            layoutParams3.topMargin = c;
            this.i.bJ.addView(frameLayout5, layoutParams3);
            a(frameLayout5, this.g.get(2).stream_id);
        } else if (size == 4) {
            FrameLayout frameLayout6 = new FrameLayout(this.h);
            this.i.bJ.addView(frameLayout6, new FrameLayout.LayoutParams(a, c));
            a(frameLayout6);
            FrameLayout frameLayout7 = new FrameLayout(this.h);
            frameLayout7.setBackgroundColor(Color.parseColor("#000000"));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(a, c);
            layoutParams4.leftMargin = a;
            this.i.bJ.addView(frameLayout7, layoutParams4);
            a(frameLayout7, this.g.get(1).stream_id);
            FrameLayout frameLayout8 = new FrameLayout(this.h);
            frameLayout8.setBackgroundColor(Color.parseColor("#000000"));
            FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(a, c);
            layoutParams5.topMargin = c;
            this.i.bJ.addView(frameLayout8, layoutParams5);
            a(frameLayout8, this.g.get(2).stream_id);
            FrameLayout frameLayout9 = new FrameLayout(this.h);
            frameLayout9.setBackgroundColor(Color.parseColor("#000000"));
            FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(a, c);
            layoutParams6.leftMargin = a;
            layoutParams6.topMargin = c;
            this.i.bJ.addView(frameLayout9, layoutParams6);
            a(frameLayout9, this.g.get(3).stream_id);
        }
        a(this.i.bJ, this.g, a, b, this.i);
        ZegoMixStreamHelper.a().a(this.g);
    }

    public static void d(FrameLayout frameLayout, List<LiveInviteUserModel> list) {
        boolean z = false;
        int i = 0;
        int i2 = 0;
        for (LiveInviteUserModel liveInviteUserModel : list) {
            if (liveInviteUserModel.isGroup()) {
                z = true;
                if (liveInviteUserModel.isMyGroup()) {
                    i = (int) liveInviteUserModel.group_score;
                } else {
                    i2 = (int) liveInviteUserModel.group_score;
                }
            }
        }
        LivePKProgressView livePKProgressView = (LivePKProgressView) frameLayout.findViewById(R.id.live_multi_pk_progress_view_id);
        if (!z) {
            livePKProgressView.setVisibility(8);
            return;
        }
        livePKProgressView.setOurProgress(i);
        livePKProgressView.setOtherProgress(i2);
        livePKProgressView.setVisibility(0);
    }

    public static List<LiveInviteUserModel> e(List<LiveInviteUserModel> list) {
        if (list.size() > 4) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 4) {
                    break;
                }
                arrayList.add(list.get(i2));
                i = i2 + 1;
            }
            list.clear();
            list.addAll(arrayList);
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= list.size()) {
                return list;
            }
            LiveInviteUserModel liveInviteUserModel = list.get(i4);
            LiveInviteUserModel liveInviteUserModel2 = liveInviteUserModel;
            if (liveInviteUserModel == null) {
                liveInviteUserModel2 = new LiveInviteUserModel();
                list.set(i4, liveInviteUserModel2);
            }
            liveInviteUserModel2.status = 0;
            i3 = i4 + 1;
        }
    }

    private void f(List<LiveInviteUserModel> list) {
        if (list != null) {
            this.g.clear();
            this.g.addAll(list);
        } else {
            this.g.clear();
        }
        int i = 0;
        if (this.g.size() > 4) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= 4) {
                    break;
                }
                arrayList.add(this.g.get(i3));
                i2 = i3 + 1;
            }
            this.g.clear();
            this.g.addAll(arrayList);
            i = 0;
        }
        while (i < this.g.size()) {
            if (this.g.get(i) == null) {
                this.g.set(i, new LiveInviteUserModel());
            }
            i++;
        }
    }

    public void a() {
        this.g = e(this.g);
        this.i.d_(10);
        LiveRoomManager.a().p().link_type = 5;
        b(this.i.bJ);
    }

    public void a(FrameLayout frameLayout) {
        if (this.i.getContext() == null) {
            return;
        }
        ZegoCommonHelper.b().c().setPreviewView((Object) null);
        this.i.N = new TextureView(this.i.getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout.removeAllViews();
        frameLayout.addView(this.i.N, layoutParams);
        ZegoCommonHelper.b().c().setPreviewView(this.i.N);
    }

    public void a(FrameLayout frameLayout, String str) {
        this.i.ac.b(str);
        View textureView = new TextureView(this.h);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout.removeAllViews();
        frameLayout.addView(textureView, layoutParams);
        ZegoCommonHelper.b().c().startPlayingStream(str, textureView);
        ZegoCommonHelper.b().c().setViewMode(1, str);
    }

    public void a(LiveInviteUserModel liveInviteUserModel) {
        int i;
        int i2;
        ToastUtils.a("退出多人PK\n" + System.currentTimeMillis());
        if (this.g == null || liveInviteUserModel == null) {
            return;
        }
        int i3 = 0;
        if (liveInviteUserModel.is_multi_pk_end == 0) {
            if (TextUtils.equals(liveInviteUserModel.uid, LiveRoomInfo.a().f())) {
                return;
            }
            while (true) {
                i2 = -1;
                if (i3 >= this.g.size()) {
                    break;
                } else if (TextUtils.equals(this.g.get(i3).uid, liveInviteUserModel.uid)) {
                    i2 = i3;
                    break;
                } else {
                    i3++;
                }
            }
            if (i2 >= 0) {
                this.g.remove(i2);
            }
            this.i.bJ.post(new Runnable() { // from class: com.blued.android.module.live_china.manager.RecordingMultiConnectionManager.2
                @Override // java.lang.Runnable
                public void run() {
                    RecordingMultiConnectionManager.this.d();
                }
            });
        } else if (liveInviteUserModel.is_multi_pk_end == 1) {
            this.i.bf();
        } else if (liveInviteUserModel.is_multi_pk_end == 2) {
            int i4 = 0;
            if (TextUtils.equals(liveInviteUserModel.uid, LiveRoomInfo.a().f())) {
                this.i.bf();
                return;
            }
            while (true) {
                i = -1;
                if (i4 >= this.g.size()) {
                    break;
                } else if (TextUtils.equals(this.g.get(i4).uid, liveInviteUserModel.uid)) {
                    i = i4;
                    break;
                } else {
                    i4++;
                }
            }
            if (i >= 0) {
                this.g.remove(i);
            }
            this.i.bJ.post(new Runnable() { // from class: com.blued.android.module.live_china.manager.RecordingMultiConnectionManager.3
                @Override // java.lang.Runnable
                public void run() {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 >= RecordingMultiConnectionManager.this.g.size()) {
                            RecordingMultiConnectionManager.this.d();
                            LiveEventBus.get("live_multi_pk_stop").post(true);
                            return;
                        }
                        if (RecordingMultiConnectionManager.this.g.get(i6) != null) {
                            RecordingMultiConnectionManager.this.g.get(i6).status = 0;
                        }
                        i5 = i6 + 1;
                    }
                }
            });
        }
    }

    public void a(RelationInfo relationInfo) {
        a(this.i.bJ, relationInfo);
    }

    public void a(List<LiveInviteUserModel> list) {
        f(list);
        this.i.ac.c();
        if (this.g.size() < 2) {
            return;
        }
        this.i.d_(10);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, d, 0, 0);
        this.i.bC.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.i.bD.getLayoutParams();
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        this.i.bD.setLayoutParams(layoutParams2);
        if (this.i.N != null) {
            this.i.N.setVisibility(8);
        }
        this.i.bJ.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.i.ac.a(5, this.g.get(1).stream_id);
        this.i.bJ.post(new Runnable() { // from class: com.blued.android.module.live_china.manager.RecordingMultiConnectionManager.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingMultiConnectionManager.this.d();
            }
        });
    }

    public void a(List<LiveInviteUserModel> list, LiveInviteUserModel liveInviteUserModel) {
        f(list);
        this.i.bJ.post(new Runnable() { // from class: com.blued.android.module.live_china.manager.RecordingMultiConnectionManager.4
            @Override // java.lang.Runnable
            public void run() {
                RecordingMultiConnectionManager.this.d();
            }
        });
    }

    public void b() {
        this.i.d_(0);
        c(this.i.bJ);
        this.i.bJ.removeAllViews();
        this.i.ac.d();
        this.i.bC.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.bD.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.i.bD.setLayoutParams(layoutParams);
        this.i.L.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.i.ac.h();
        this.g.clear();
    }

    public void b(List<LiveInviteUserModel> list) {
        List<LiveInviteUserModel> a2 = a(list, this.g);
        this.g = a2;
        if (a2 == null || a2.size() <= 0 || !this.g.get(0).isGroup()) {
            this.i.d_(12);
        } else {
            this.i.d_(13);
        }
        LiveRoomManager.a().p().link_type = 7;
        a(this.i.bJ, this.g);
    }

    public List<LiveInviteUserModel> c() {
        return this.g;
    }

    public void c(List<LiveInviteUserModel> list) {
        this.g = b(list, this.g);
        b(this.i.bJ, this.g);
    }

    public void d(List<LiveInviteUserModel> list) {
        this.g = c(list, this.g);
        a(this.i.bJ, this.g, true);
    }
}
