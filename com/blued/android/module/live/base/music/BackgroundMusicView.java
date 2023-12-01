package com.blued.android.module.live.base.music;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.view.FlowLayout;
import com.blued.android.module.live.base.R;
import com.blued.android.module.live.base.databinding.FragmentYyMusicBinding;
import com.blued.android.module.live.base.manager.YYMusicManager;
import com.blued.android.module.live.base.music.BackgroundMusicView;
import com.blued.android.module.live.base.music.adapter.YYMusicTabAdapter;
import com.blued.android.module.live.base.music.model.LiveMusicModel;
import com.blued.android.module.live.base.music.model.TrtcMusicModel;
import com.blued.android.module.live.base.music.model.YYKtvMusicDetailModel;
import com.blued.android.module.live.base.music.model.YYKtvMusicModel;
import com.blued.android.module.live.base.music.model.YYKtvMusicTypeModel;
import com.blued.android.module.live.base.utils.LiveBasePreferences;
import com.blued.android.module.live.base.utils.LiveTimeAndDateUtils;
import com.blued.android.module.live.base.view.TabLinearLayoutManager;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.google.gson.reflect.TypeToken;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.tencent.txcopyrightedmedia.ITXCMMusicTrack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/music/BackgroundMusicView.class */
public final class BackgroundMusicView extends FrameLayout implements View.OnClickListener, MusicPlayMusicInfoCallback {
    private final BlackMusicListener a;
    private final Fragment b;
    private final ActivityFragmentActive c;
    private final FragmentYyMusicBinding d;
    private final ActivityFragmentActive e;
    private final FragmentManager f;
    private YYMusicTabAdapter g;
    private YYMusicPageAdapter h;
    private View.OnClickListener i;
    private YyBackgroundItemFragment j;
    private final Observer<String> k;
    private final YYPlayMusicListener l;
    private boolean m;
    private final Observer<String> n;
    private final Observer<TrtcMusicModel> o;
    private final TextWatcher p;

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/music/BackgroundMusicView$YYMusicPageAdapter.class */
    public final class YYMusicPageAdapter extends FragmentPagerAdapter {
        final /* synthetic */ BackgroundMusicView a;
        private final BackgroundMusicView b;
        private List<? extends YYKtvMusicTypeModel> c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public YYMusicPageAdapter(BackgroundMusicView this$0, FragmentManager fm, BackgroundMusicView mus) {
            super(fm);
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(fm, "fm");
            Intrinsics.e(mus, "mus");
            this.a = this$0;
            this.b = mus;
            this.c = new ArrayList();
        }

        public final void a(List<? extends YYKtvMusicTypeModel> list) {
            Intrinsics.e(list, "<set-?>");
            this.c = list;
        }

        public int getCount() {
            return this.c.size();
        }

        public Fragment getItem(int i) {
            YyBackgroundItemFragment yyBackgroundItemFragment = new YyBackgroundItemFragment();
            yyBackgroundItemFragment.a(this.a.getBaseYYStudioFragment());
            yyBackgroundItemFragment.a(this.b);
            Bundle bundle = new Bundle();
            bundle.putString("sheetId", this.c.get(i).sheetId);
            bundle.putInt("isPersonal", 0);
            bundle.putString("collectId", "0");
            bundle.putBoolean("searchPage", false);
            bundle.putString("roomId", this.a.getBaseYYStudioFragment().f());
            yyBackgroundItemFragment.setArguments(bundle);
            return yyBackgroundItemFragment;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundMusicView(Context context, BlackMusicListener baseYYStudioFragment, Fragment fragment, ActivityFragmentActive activityFragmentActive) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(baseYYStudioFragment, "baseYYStudioFragment");
        Intrinsics.e(fragment, "fragment");
        this.a = baseYYStudioFragment;
        this.b = fragment;
        this.c = activityFragmentActive;
        FragmentYyMusicBinding a = FragmentYyMusicBinding.a(LayoutInflater.from(context), this, true);
        Intrinsics.c(a, "inflate(LayoutInflater.from(context), this, true)");
        this.d = a;
        this.e = this.c;
        FragmentManager childFragmentManager = this.b.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "fragment.childFragmentManager");
        this.f = childFragmentManager;
        YYMusicManager.a.c().a(YYMusicManager.a.c().h(), this);
        this.k = new Observer() { // from class: com.blued.android.module.live.base.music.-$$Lambda$BackgroundMusicView$ZMh8naBnnyqZ6VmG4y24LIB_KCs
            public final void onChanged(Object obj) {
                BackgroundMusicView.b(BackgroundMusicView.this, (String) obj);
            }
        };
        this.l = new YYPlayMusicListener() { // from class: com.blued.android.module.live.base.music.BackgroundMusicView$playMusicListener$1
            @Override // com.blued.android.module.live.base.music.YYPlayMusicListener
            public void a() {
                BlackMusicListener recordingStudioFragment = BackgroundMusicView.this.getRecordingStudioFragment();
                if (recordingStudioFragment == null) {
                    return;
                }
                recordingStudioFragment.L_();
            }

            @Override // com.blued.android.module.live.base.music.YYPlayMusicListener
            public void a(final YYKtvMusicModel yYKtvMusicModel) {
                if (yYKtvMusicModel == null) {
                    return;
                }
                if (YYMusicManager.a.c().c()) {
                    YYKtvMusicModel b = YYMusicManager.a.c().b();
                    if (BackgroundMusicView.this.getBaseYYStudioFragment().f() != null && b != null) {
                        BackgroundMusicView.this.getBaseYYStudioFragment().a(null, LiveProtos.Event.LIVE_MUSIC_CHANGE, BackgroundMusicView.this.getBaseYYStudioFragment().f(), b.sheetId, b.musicId, b.playTime);
                    }
                }
                YYMusicManager.a.c().a(yYKtvMusicModel);
                if (BackgroundMusicView.this.getBaseYYStudioFragment().f() != null) {
                    BackgroundMusicView.this.getBaseYYStudioFragment().a(ChatRoomProtos.Event.CHAT_ROOM_TOOLBOX_MUSIC_PLAY_CLICK, LiveProtos.Event.LIVE_MUSIC_PLAY_CLICK, BackgroundMusicView.this.getBaseYYStudioFragment().f(), yYKtvMusicModel.sheetId, yYKtvMusicModel.musicId);
                }
                BackgroundMusicView backgroundMusicView = BackgroundMusicView.this;
                String str = yYKtvMusicModel.musicId;
                Intrinsics.c(str, "musicModel.musicId");
                final ActivityFragmentActive fragmentActive = BackgroundMusicView.this.getFragmentActive();
                final BackgroundMusicView backgroundMusicView2 = BackgroundMusicView.this;
                backgroundMusicView.a(str, new BluedUIHttpResponse<BluedEntityA<YYKtvMusicDetailModel>>(backgroundMusicView2, fragmentActive) { // from class: com.blued.android.module.live.base.music.BackgroundMusicView$playMusicListener$1$playMusic$1
                    final /* synthetic */ BackgroundMusicView b;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(fragmentActive);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    /* renamed from: a */
                    public void onUIUpdate(BluedEntityA<YYKtvMusicDetailModel> bluedEntityA) {
                        YYKtvMusicDetailModel singleData;
                        if (bluedEntityA == null || (singleData = bluedEntityA.getSingleData()) == null) {
                            return;
                        }
                        YYKtvMusicModel yYKtvMusicModel2 = YYKtvMusicModel.this;
                        BackgroundMusicView backgroundMusicView3 = this.b;
                        LiveMusicModel liveMusicModel = new LiveMusicModel();
                        liveMusicModel.music_id = yYKtvMusicModel2.musicId;
                        liveMusicModel.sheet_id = yYKtvMusicModel2.sheetId;
                        liveMusicModel.name = yYKtvMusicModel2.musicName;
                        liveMusicModel.artist = yYKtvMusicModel2.artist;
                        liveMusicModel.duration = yYKtvMusicModel2.duration;
                        liveMusicModel.cover = yYKtvMusicModel2.coverUrl;
                        liveMusicModel.file_url = singleData.PlayToken;
                        backgroundMusicView3.a(liveMusicModel);
                    }
                }, BackgroundMusicView.this.getFragmentActive());
            }

            @Override // com.blued.android.module.live.base.music.YYPlayMusicListener
            public boolean a(String str) {
                LiveMusicModel liveMusicModel = BackgroundMusicView.this.getLiveMusicModel();
                return liveMusicModel != null && TextUtils.equals(liveMusicModel.music_id, str) && liveMusicModel.playStatus == 2;
            }

            @Override // com.blued.android.module.live.base.music.YYPlayMusicListener
            public void b() {
                if (BackgroundMusicView.this.getBaseYYStudioFragment() != null) {
                    BackgroundMusicView.this.getBaseYYStudioFragment().a(ChatRoomProtos.Event.CHAT_ROOM_TOOLBOX_MUSIC_PLAY_SEARCH_CLICK, LiveProtos.Event.LIVE_MUSIC_SEARCH_CLICK, BackgroundMusicView.this.getBaseYYStudioFragment().f(), "", "");
                }
            }

            @Override // com.blued.android.module.live.base.music.YYPlayMusicListener
            public void b(YYKtvMusicModel yYKtvMusicModel) {
                if (BackgroundMusicView.this.getBaseYYStudioFragment().f() != null && yYKtvMusicModel != null) {
                    BackgroundMusicView.this.getBaseYYStudioFragment().a(ChatRoomProtos.Event.CHAT_ROOM_TOOLBOX_MUSIC_PLAY_CLICK, LiveProtos.Event.LIVE_MUSIC_PLAY_CLICK, BackgroundMusicView.this.getBaseYYStudioFragment().f(), yYKtvMusicModel.sheetId, yYKtvMusicModel.musicId);
                }
                LiveMusicModel liveMusicModel = BackgroundMusicView.this.getLiveMusicModel();
                if (liveMusicModel != null) {
                    liveMusicModel.playStatus = 2;
                }
                BackgroundMusicView.this.h();
                BlackMusicListener recordingStudioFragment = BackgroundMusicView.this.getRecordingStudioFragment();
                if (recordingStudioFragment != null) {
                    recordingStudioFragment.a();
                }
                BackgroundMusicView.this.getBaseYYStudioFragment().g();
            }

            @Override // com.blued.android.module.live.base.music.YYPlayMusicListener
            public boolean b(String str) {
                return false;
            }

            @Override // com.blued.android.module.live.base.music.YYPlayMusicListener
            public void c(YYKtvMusicModel yYKtvMusicModel) {
                if (BackgroundMusicView.this.getBaseYYStudioFragment().f() != null && yYKtvMusicModel != null) {
                    BackgroundMusicView.this.getBaseYYStudioFragment().a(ChatRoomProtos.Event.CHAT_ROOM_TOOLBOX_MUSIC_PAUSE_CLICK, LiveProtos.Event.LIVE_MUSIC_STOP_CLICK, BackgroundMusicView.this.getBaseYYStudioFragment().f(), yYKtvMusicModel.sheetId, yYKtvMusicModel.musicId);
                }
                LiveMusicModel liveMusicModel = BackgroundMusicView.this.getLiveMusicModel();
                if (liveMusicModel != null) {
                    liveMusicModel.playStatus = 4;
                }
                BlackMusicListener recordingStudioFragment = BackgroundMusicView.this.getRecordingStudioFragment();
                if (recordingStudioFragment != null) {
                    recordingStudioFragment.d();
                }
                BackgroundMusicView.this.getBaseYYStudioFragment().h();
            }

            @Override // com.blued.android.module.live.base.music.YYPlayMusicListener
            public boolean c(String str) {
                if (BackgroundMusicView.this.getLiveMusicModel() != null) {
                    LiveMusicModel liveMusicModel = BackgroundMusicView.this.getLiveMusicModel();
                    if (TextUtils.equals(liveMusicModel == null ? null : liveMusicModel.music_id, str)) {
                        LiveMusicModel liveMusicModel2 = BackgroundMusicView.this.getLiveMusicModel();
                        return liveMusicModel2 != null && liveMusicModel2.playStatus == 3;
                    }
                    return false;
                }
                return false;
            }

            @Override // com.blued.android.module.live.base.music.YYPlayMusicListener
            public void d(YYKtvMusicModel yYKtvMusicModel) {
                if (BackgroundMusicView.this.getBaseYYStudioFragment().f() != null && yYKtvMusicModel != null) {
                    BackgroundMusicView.this.getBaseYYStudioFragment().a(ChatRoomProtos.Event.CHAT_ROOM_TOOLBOX_MUSIC_EXIT_CLICK, LiveProtos.Event.LIVE_MUSIC_EXIT_CLICK, BackgroundMusicView.this.getBaseYYStudioFragment().f(), yYKtvMusicModel.sheetId, yYKtvMusicModel.musicId, yYKtvMusicModel.playTime);
                }
                YYMusicManager.a.c().a((LiveMusicModel) null);
                BlackMusicListener recordingStudioFragment = BackgroundMusicView.this.getRecordingStudioFragment();
                if (recordingStudioFragment != null) {
                    recordingStudioFragment.J_();
                }
                BackgroundMusicView.this.getBaseYYStudioFragment().K_();
                LiveEventBus.get("live_music_changed").post("");
            }

            @Override // com.blued.android.module.live.base.music.YYPlayMusicListener
            public boolean d(String str) {
                LiveMusicModel liveMusicModel = BackgroundMusicView.this.getLiveMusicModel();
                return liveMusicModel != null && TextUtils.equals(liveMusicModel.music_id, str) && liveMusicModel.playStatus == 4;
            }

            @Override // com.blued.android.module.live.base.music.YYPlayMusicListener
            public void e(YYKtvMusicModel yYKtvMusicModel) {
                YYMusicManager.a.c().a((LiveMusicModel) null);
                BlackMusicListener recordingStudioFragment = BackgroundMusicView.this.getRecordingStudioFragment();
                if (recordingStudioFragment != null) {
                    recordingStudioFragment.c();
                }
                YYKtvMusicModel a2 = yYKtvMusicModel != null ? YYMusicManager.a.c().a(yYKtvMusicModel.musicId) : null;
                if (a2 != null) {
                    a(a2);
                    return;
                }
                YYMusicManager.a.c().a((List<? extends YYKtvMusicModel>) null);
                YYMusicManager.a.c().a((YYKtvMusicModel) null);
            }

            @Override // com.blued.android.module.live.base.music.YYPlayMusicListener
            public boolean e(String str) {
                if (BackgroundMusicView.this.getLiveMusicModel() != null) {
                    String str2 = str;
                    if (TextUtils.isEmpty(str2)) {
                        return false;
                    }
                    LiveMusicModel liveMusicModel = BackgroundMusicView.this.getLiveMusicModel();
                    if (TextUtils.equals(str2, liveMusicModel == null ? null : liveMusicModel.music_id)) {
                        LiveMusicModel liveMusicModel2 = BackgroundMusicView.this.getLiveMusicModel();
                        return !TextUtils.isEmpty(liveMusicModel2 == null ? null : liveMusicModel2.file_url);
                    }
                    return false;
                }
                return false;
            }
        };
        this.n = new Observer() { // from class: com.blued.android.module.live.base.music.-$$Lambda$BackgroundMusicView$rVebIxt-tiILXaU3Uc2X1SOsK0c
            public final void onChanged(Object obj) {
                BackgroundMusicView.c(BackgroundMusicView.this, (String) obj);
            }
        };
        this.o = new Observer() { // from class: com.blued.android.module.live.base.music.-$$Lambda$BackgroundMusicView$ioJv4SOtQ_lxmU6OLiHOgUX_15A
            public final void onChanged(Object obj) {
                BackgroundMusicView.a(BackgroundMusicView.this, (TrtcMusicModel) obj);
            }
        };
        this.p = new TextWatcher() { // from class: com.blued.android.module.live.base.music.BackgroundMusicView$searchWatcher$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                Intrinsics.e(s, "s");
                String obj = s.toString();
                int length = obj.length() - 1;
                int i = 0;
                boolean z = false;
                while (i <= length) {
                    boolean z2 = Intrinsics.a((int) obj.charAt(!z ? i : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (z2) {
                        i++;
                    } else {
                        z = true;
                    }
                }
                if (TextUtils.isEmpty(obj.subSequence(i, length + 1).toString())) {
                    return;
                }
                BackgroundMusicView backgroundMusicView = BackgroundMusicView.this;
                backgroundMusicView.c(backgroundMusicView.getMBinding().e.a.getText().toString());
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int i, int i2, int i3) {
                Intrinsics.e(s, "s");
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int i, int i2, int i3) {
                Intrinsics.e(s, "s");
            }
        };
    }

    private final void a(long j) {
        YYKtvMusicModel currentSheet;
        if (getCurrentSheet() != null && (currentSheet = getCurrentSheet()) != null) {
            currentSheet.playTime = (int) (j / 1000);
        }
        this.d.h.setText(LiveTimeAndDateUtils.a(j / 1000, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(BackgroundMusicView this$0, int i) {
        Intrinsics.e(this$0, "this$0");
        this$0.d.d.f.setCurrentItem(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(BackgroundMusicView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        View.OnClickListener onClickListener = this$0.i;
        if (onClickListener == null) {
            return;
        }
        onClickListener.onClick(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(BackgroundMusicView this$0, View view, int i) {
        Intrinsics.e(this$0, "this$0");
        if (view instanceof TextView) {
            this$0.d.e.a.setText(((TextView) view).getText().toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(BackgroundMusicView this$0, TrtcMusicModel trtcMusicModel) {
        LiveMusicModel a;
        Intrinsics.e(this$0, "this$0");
        LogUtils.c("music", "更新进度条");
        if (trtcMusicModel == null || (a = YYMusicManager.a.c().a()) == null) {
            return;
        }
        a.curDuration = trtcMusicModel.curPtsMS;
        this$0.a(trtcMusicModel.curPtsMS);
    }

    private final void a(String str) {
        int i;
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        ArrayList<String> searchHistoryDatas = getSearchHistoryDatas();
        ArrayList<String> arrayList = searchHistoryDatas;
        if (searchHistoryDatas == null) {
            arrayList = new ArrayList<>();
        }
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            i = -1;
            if (i3 >= size) {
                break;
            } else if (TextUtils.equals(arrayList.get(i3), str2)) {
                i = i3;
                break;
            } else {
                i2 = i3 + 1;
            }
        }
        if (i >= 0 && i < arrayList.size()) {
            arrayList.remove(i);
        }
        ArrayList arrayList2 = new ArrayList();
        int size2 = arrayList.size();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= size2) {
                break;
            }
            if (i5 < 9) {
                arrayList2.add(arrayList.get(i5));
            }
            i4 = i5 + 1;
        }
        arrayList2.add(0, str);
        try {
            LiveBasePreferences.c(AppInfo.f().toJson(arrayList2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        getSearchHistory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(BackgroundMusicView this$0, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.e(this$0, "this$0");
        if (i == 3) {
            this$0.a(this$0.d.e.a.getText().toString());
            this$0.c(this$0.d.e.a.getText().toString());
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(BackgroundMusicView this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        this$0.d.c.setVisibility(8);
        this$0.a(0L);
        this$0.j();
    }

    private final void b(String str) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.live_music_search_label_view, (ViewGroup) null);
        if (inflate == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        }
        TextView textView = (TextView) inflate;
        textView.setMaxLines(1);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.rightMargin = DensityUtils.a(getContext(), 10.0f);
        this.d.e.e.addView(textView, marginLayoutParams);
        textView.setText(str);
        this.d.e.e.setOnItemClickListener(new FlowLayout.OnItemClickListener() { // from class: com.blued.android.module.live.base.music.-$$Lambda$BackgroundMusicView$Ol5eMbLW7Rxfo-2FzfDrXRz_Vkw
            @Override // com.blued.android.module.common.view.FlowLayout.OnItemClickListener
            public final void onItemClick(View view, int i) {
                BackgroundMusicView.a(BackgroundMusicView.this, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(BackgroundMusicView this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        Log.i("xpm", "KEY_EVENT_LIVE_MUSIC_CHANGED");
        this$0.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(String str) {
        if (TextUtils.isEmpty(str)) {
            getSearchHistory();
            this.d.e.c.setVisibility(8);
            return;
        }
        YyBackgroundItemFragment yyBackgroundItemFragment = this.j;
        if (yyBackgroundItemFragment != null) {
            yyBackgroundItemFragment.a(str);
        }
        this.d.e.d.setVisibility(8);
        this.d.e.c.setVisibility(0);
    }

    private final void g() {
        FragmentTransaction beginTransaction = this.f.beginTransaction();
        Intrinsics.c(beginTransaction, "childFragmentManager.beginTransaction()");
        YyBackgroundItemFragment yyBackgroundItemFragment = this.j;
        if (yyBackgroundItemFragment != null) {
            Intrinsics.a(yyBackgroundItemFragment);
            if (yyBackgroundItemFragment.isAdded()) {
                return;
            }
            YyBackgroundItemFragment yyBackgroundItemFragment2 = this.j;
            Intrinsics.a(yyBackgroundItemFragment2);
            beginTransaction.show(yyBackgroundItemFragment2);
            beginTransaction.commitNowAllowingStateLoss();
            return;
        }
        YyBackgroundItemFragment yyBackgroundItemFragment3 = new YyBackgroundItemFragment();
        yyBackgroundItemFragment3.a(this.a);
        yyBackgroundItemFragment3.a(this);
        this.j = yyBackgroundItemFragment3;
        Bundle bundle = new Bundle();
        bundle.putLong("lid", 0L);
        bundle.putBoolean("searchPage", true);
        bundle.putString("roomId", this.a.f());
        YyBackgroundItemFragment yyBackgroundItemFragment4 = this.j;
        Intrinsics.a(yyBackgroundItemFragment4);
        yyBackgroundItemFragment4.setArguments(bundle);
        int i = R.id.live_music_search_container_layout_id;
        YyBackgroundItemFragment yyBackgroundItemFragment5 = this.j;
        Intrinsics.a(yyBackgroundItemFragment5);
        beginTransaction.add(i, yyBackgroundItemFragment5, "SearchMusicList");
        beginTransaction.commitNowAllowingStateLoss();
    }

    private final void getSearchHistory() {
        this.d.e.e.removeAllViews();
        ArrayList<String> searchHistoryDatas = getSearchHistoryDatas();
        if (searchHistoryDatas == null || searchHistoryDatas.size() <= 0) {
            this.d.e.d.setVisibility(8);
            return;
        }
        this.d.e.d.setVisibility(0);
        for (String str : searchHistoryDatas) {
            b(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        boolean z;
        LiveMusicModel liveMusicModel;
        YYPlayMusicListener yYPlayMusicListener;
        Log.i("==record", "updateStartBtnStatus");
        if (getLiveMusicModel() == null || (yYPlayMusicListener = this.l) == null) {
            z = false;
        } else {
            LiveMusicModel liveMusicModel2 = getLiveMusicModel();
            z = yYPlayMusicListener.c(liveMusicModel2 == null ? null : liveMusicModel2.music_id);
        }
        if (z) {
            Log.i("==record", "musicStart:1");
            this.m = false;
            a(0L);
            this.d.f.setImageResource(R.drawable.live_music_start_gray);
            YYPlayMusicListener yYPlayMusicListener2 = this.l;
            if (yYPlayMusicListener2 == null) {
                return;
            }
            yYPlayMusicListener2.e(getCurrentSheet());
            return;
        }
        Log.i("==record", "musicStart:2");
        YYPlayMusicListener yYPlayMusicListener3 = this.l;
        if (yYPlayMusicListener3 != null) {
            LiveMusicModel liveMusicModel3 = getLiveMusicModel();
            if (yYPlayMusicListener3.d(liveMusicModel3 == null ? null : liveMusicModel3.music_id) && (liveMusicModel = getLiveMusicModel()) != null) {
                a(liveMusicModel.curDuration);
            }
        }
        YYPlayMusicListener yYPlayMusicListener4 = this.l;
        if (yYPlayMusicListener4 != null) {
            LiveMusicModel liveMusicModel4 = getLiveMusicModel();
            this.m = yYPlayMusicListener4.a(liveMusicModel4 == null ? null : liveMusicModel4.music_id);
        }
        this.d.f.setImageResource(this.m ? R.drawable.live_music_pause : R.drawable.live_music_start);
    }

    private final void i() {
        this.d.e.e.removeAllViews();
        LiveBasePreferences.c("");
        this.d.e.d.setVisibility(8);
    }

    private final void j() {
        FragmentActivity activity = this.b.getActivity();
        Object systemService = activity == null ? null : activity.getSystemService("input_method");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
        ((InputMethodManager) systemService).hideSoftInputFromWindow(this.d.e.a.getWindowToken(), 0);
    }

    private final void k() {
        this.d.e.a.setFocusableInTouchMode(true);
        this.d.e.a.setFocusable(true);
        this.d.e.a.requestFocus();
        FragmentActivity activity = this.b.getActivity();
        Object systemService = activity == null ? null : activity.getSystemService("input_method");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
        ((InputMethodManager) systemService).showSoftInput(this.d.e.a, 0);
    }

    public final void a() {
        YYPlayMusicListener yYPlayMusicListener;
        this.d.d.c.setVisibility(0);
        this.d.e.d.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.live.base.music.-$$Lambda$BackgroundMusicView$AUNvAd1MaMtcsHp4euny124SOY0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean a;
                a = BackgroundMusicView.a(view, motionEvent);
                return a;
            }
        });
        this.d.d.d.setLayoutManager(new TabLinearLayoutManager(getContext(), 0, false));
        YYMusicTabAdapter yYMusicTabAdapter = new YYMusicTabAdapter(getContext(), this.d.d.d);
        this.g = yYMusicTabAdapter;
        if (yYMusicTabAdapter != null) {
            yYMusicTabAdapter.a(new YYMusicTabAdapter.EventCallBack() { // from class: com.blued.android.module.live.base.music.-$$Lambda$BackgroundMusicView$ynI58gKl6q2kV0Fs9BZs7Vo3_bA
                @Override // com.blued.android.module.live.base.music.adapter.YYMusicTabAdapter.EventCallBack
                public final void onItemClick(int i) {
                    BackgroundMusicView.a(BackgroundMusicView.this, i);
                }
            });
        }
        this.d.d.d.setAdapter(this.g);
        this.h = new YYMusicPageAdapter(this, this.f, this);
        this.d.d.f.setAdapter(this.h);
        this.d.d.f.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.live.base.music.BackgroundMusicView$initView$3
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                YYMusicTabAdapter tabAdapter = BackgroundMusicView.this.getTabAdapter();
                if (tabAdapter == null) {
                    return;
                }
                tabAdapter.a(i);
            }
        });
        if (getLiveMusicModel() == null || (yYPlayMusicListener = this.l) == null) {
            this.d.c.setVisibility(8);
        } else {
            LiveMusicModel liveMusicModel = getLiveMusicModel();
            if (yYPlayMusicListener.e(liveMusicModel == null ? null : liveMusicModel.music_id)) {
                this.d.c.setVisibility(0);
                h();
            } else {
                this.d.c.setVisibility(8);
            }
        }
        getSearchHistory();
        g();
        BackgroundMusicView backgroundMusicView = this;
        this.d.e.b.setOnClickListener(backgroundMusicView);
        this.d.d.b.setOnClickListener(backgroundMusicView);
        this.d.e.g.setOnClickListener(backgroundMusicView);
        this.d.a.setOnClickListener(backgroundMusicView);
        this.d.f.setOnClickListener(backgroundMusicView);
        this.d.g.setOnClickListener(backgroundMusicView);
        this.d.e.f.setOnClickListener(backgroundMusicView);
        this.d.d.a.a.setOnClickListener(backgroundMusicView);
        this.d.e.a.addTextChangedListener(this.p);
        this.d.e.a.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.blued.android.module.live.base.music.-$$Lambda$BackgroundMusicView$kMKpjmzTcER0ysJXktukvxZ4whg
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean a;
                a = BackgroundMusicView.a(BackgroundMusicView.this, textView, i, keyEvent);
                return a;
            }
        });
        this.d.a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live.base.music.-$$Lambda$BackgroundMusicView$qOGsQ8KNiD-ugsFcOdTEmnl3Wlg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BackgroundMusicView.a(BackgroundMusicView.this, view);
            }
        });
    }

    public final void a(BluedUIHttpResponse<?> bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        String a = Intrinsics.a(BluedHttpUrl.q(), (Object) "/users/chatroom/ktv/playlist");
        Map<String, String> params = BluedHttpTools.a();
        Intrinsics.c(params, "params");
        params.put("is_background", "1");
        if (YYMusicManager.a.c().c()) {
            params.put("source_type", "1");
            params.put("live_submitted_uid", YYMusicManager.a.c().d());
            params.put("live_submitted_room_id", YYMusicManager.a.c().e());
        }
        HttpManager.a(a, bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(params).h();
    }

    public final void a(LiveMusicModel music) {
        Intrinsics.e(music, "music");
        music.playStatus = 2;
        YYMusicManager.a.c().a(music);
        BlackMusicListener recordingStudioFragment = getRecordingStudioFragment();
        if (recordingStudioFragment != null) {
            recordingStudioFragment.a(music);
        }
        c();
        YYMusicManager.a.c().a(music.music_id, music.file_url, true);
    }

    public final void a(YYKtvMusicModel yYKtvMusicModel) {
        YYPlayMusicListener yYPlayMusicListener = this.l;
        if (yYPlayMusicListener != null) {
            yYPlayMusicListener.a(yYKtvMusicModel);
        }
    }

    public final void a(String musicId, BluedUIHttpResponse<?> bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Intrinsics.e(musicId, "musicId");
        String a = Intrinsics.a(BluedHttpUrl.q(), (Object) "/users/chatroom/ktv/musicInfo");
        Map<String, String> params = BluedHttpTools.a();
        Intrinsics.c(params, "params");
        params.put("musicId", musicId);
        params.put("is_background", "1");
        if (YYMusicManager.a.c().c()) {
            params.put("source_type", "1");
            params.put("live_submitted_uid", YYMusicManager.a.c().d());
            params.put("live_submitted_room_id", YYMusicManager.a.c().e());
        }
        HttpManager.a(a, bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(params).h();
    }

    @Override // com.blued.android.module.live.base.music.MusicPlayMusicInfoCallback
    public void a(String str, ITXCMMusicTrack iTXCMMusicTrack, String str2, String str3) {
        this.a.b(str2);
        this.a.a(iTXCMMusicTrack);
    }

    @Override // com.blued.android.module.live.base.music.MusicPlayMusicInfoCallback
    public void a(String str, String str2) {
    }

    @Override // com.blued.android.module.live.base.music.MusicPlayMusicInfoCallback
    public void a(String str, String str2, float f) {
    }

    @Override // com.blued.android.module.live.base.music.MusicPlayMusicInfoCallback
    public void a(String str, String str2, int i, String str3) {
    }

    public final void b() {
        final ActivityFragmentActive activityFragmentActive = this.e;
        a(new BluedUIHttpResponse<BluedEntityA<YYKtvMusicTypeModel>>(activityFragmentActive) { // from class: com.blued.android.module.live.base.music.BackgroundMusicView$loadData$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYKtvMusicTypeModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    BackgroundMusicView.this.getMBinding().d.a.getRoot().setVisibility(0);
                    return;
                }
                BackgroundMusicView.this.getMBinding().d.a.getRoot().setVisibility(8);
                BackgroundMusicView.YYMusicPageAdapter pageAdapter = BackgroundMusicView.this.getPageAdapter();
                if (pageAdapter != null) {
                    List<YYKtvMusicTypeModel> list = bluedEntityA.data;
                    Intrinsics.c(list, "result.data");
                    pageAdapter.a(list);
                }
                YYMusicTabAdapter tabAdapter = BackgroundMusicView.this.getTabAdapter();
                if (tabAdapter != null) {
                    tabAdapter.a(bluedEntityA.data, 0);
                }
                BackgroundMusicView.YYMusicPageAdapter pageAdapter2 = BackgroundMusicView.this.getPageAdapter();
                if (pageAdapter2 == null) {
                    return;
                }
                pageAdapter2.notifyDataSetChanged();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                BackgroundMusicView.this.getMBinding().d.c.setVisibility(8);
            }
        }, this.e);
        d();
    }

    public final void c() {
        a(0L);
        this.d.c.setVisibility(0);
        this.m = true;
        this.d.f.setImageResource(R.drawable.live_music_pause);
    }

    public final void d() {
        LiveEventBus.get("live_music_changed", String.class).observeForever(this.n);
        LiveEventBus.get("live_music_play_progress", TrtcMusicModel.class).observeForever(this.o);
        LiveEventBus.get("live_music_exit", String.class).observeForever(this.k);
    }

    public final void e() {
        LiveEventBus.get("live_music_changed", String.class).removeObserver(this.n);
        LiveEventBus.get("live_music_play_progress", TrtcMusicModel.class).removeObserver(this.o);
        LiveEventBus.get("live_music_exit", String.class).removeObserver(this.k);
    }

    public final void f() {
        YYMusicManager.a.c().d(YYMusicManager.a.c().h());
    }

    public final ActivityFragmentActive getActive() {
        return this.c;
    }

    public final BlackMusicListener getBaseYYStudioFragment() {
        return this.a;
    }

    public final FragmentManager getChildFragmentManager() {
        return this.f;
    }

    public final YYKtvMusicModel getCurrentSheet() {
        return YYMusicManager.a.c().b();
    }

    public final View.OnClickListener getDissListener() {
        return this.i;
    }

    public final Fragment getFragment() {
        return this.b;
    }

    public final ActivityFragmentActive getFragmentActive() {
        return this.e;
    }

    public final LiveMusicModel getLiveMusicModel() {
        return YYMusicManager.a.c().a();
    }

    public final FragmentYyMusicBinding getMBinding() {
        return this.d;
    }

    public final YYMusicPageAdapter getPageAdapter() {
        return this.h;
    }

    public final YYPlayMusicListener getPlayMusicListener() {
        return this.l;
    }

    public final BlackMusicListener getRecordingStudioFragment() {
        BlackMusicListener blackMusicListener = this.a;
        if (blackMusicListener instanceof BlackMusicListener) {
            return blackMusicListener;
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.blued.android.module.live.base.music.BackgroundMusicView$getSearchHistoryDatas$list$1] */
    public final ArrayList<String> getSearchHistoryDatas() {
        ArrayList<String> arrayList;
        ArrayList<String> arrayList2 = (ArrayList) AppInfo.f().fromJson(LiveBasePreferences.c(), new TypeToken<ArrayList<String>>() { // from class: com.blued.android.module.live.base.music.BackgroundMusicView$getSearchHistoryDatas$list$1
        }.getType());
        if (arrayList2 != null) {
            Iterator<String> it = arrayList2.iterator();
            while (true) {
                arrayList = arrayList2;
                if (!it.hasNext()) {
                    break;
                }
                Log.i("==abcd", Intrinsics.a("get:", (Object) it.next()));
            }
        } else {
            arrayList = new ArrayList<>();
        }
        return arrayList;
    }

    public final YYMusicTabAdapter getTabAdapter() {
        return this.g;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        YYPlayMusicListener yYPlayMusicListener;
        Tracker.onClick(view);
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        int i = R.id.iv_search;
        if (valueOf != null && valueOf.intValue() == i) {
            this.d.d.getRoot().setVisibility(8);
            this.d.e.getRoot().setVisibility(0);
            k();
            YYPlayMusicListener yYPlayMusicListener2 = this.l;
            if (yYPlayMusicListener2 == null) {
                return;
            }
            yYPlayMusicListener2.b();
            return;
        }
        int i2 = R.id.iv_search_clear;
        if (valueOf != null && valueOf.intValue() == i2) {
            this.d.e.a.setText("");
            this.d.e.d.setVisibility(0);
            this.d.e.c.setVisibility(8);
            return;
        }
        int i3 = R.id.tv_search_close;
        if (valueOf != null && valueOf.intValue() == i3) {
            this.d.e.a.setText("");
            this.d.d.getRoot().setVisibility(0);
            this.d.e.d.setVisibility(0);
            this.d.e.c.setVisibility(8);
            this.d.e.getRoot().setVisibility(8);
            j();
            return;
        }
        int i4 = R.id.empty_view;
        if (valueOf != null && valueOf.intValue() == i4) {
            YYPlayMusicListener yYPlayMusicListener3 = this.l;
            if (yYPlayMusicListener3 != null) {
                yYPlayMusicListener3.a();
            }
            j();
            return;
        }
        int i5 = R.id.iv_start;
        if (valueOf != null && valueOf.intValue() == i5) {
            if (getLiveMusicModel() != null && (yYPlayMusicListener = this.l) != null) {
                LiveMusicModel liveMusicModel = getLiveMusicModel();
                if (!yYPlayMusicListener.c(liveMusicModel == null ? null : liveMusicModel.music_id)) {
                    this.m = !this.m;
                    this.d.f.setImageResource(this.m ? R.drawable.live_music_pause : R.drawable.live_music_start);
                    if (this.m) {
                        YYPlayMusicListener yYPlayMusicListener4 = this.l;
                        if (yYPlayMusicListener4 != null) {
                            yYPlayMusicListener4.b(getCurrentSheet());
                            return;
                        }
                        return;
                    }
                    YYPlayMusicListener yYPlayMusicListener5 = this.l;
                    if (yYPlayMusicListener5 != null) {
                        yYPlayMusicListener5.c(getCurrentSheet());
                        return;
                    }
                    return;
                }
            }
            Log.i("==record", "play isCompleted");
            return;
        }
        int i6 = R.id.tv_exit;
        if (valueOf != null && valueOf.intValue() == i6) {
            this.d.c.setVisibility(8);
            YYPlayMusicListener yYPlayMusicListener6 = this.l;
            if (yYPlayMusicListener6 != null) {
                yYPlayMusicListener6.d(getCurrentSheet());
                this.l.a();
            }
            a(0L);
            j();
            return;
        }
        int i7 = R.id.tv_history_clear;
        if (valueOf != null && valueOf.intValue() == i7) {
            i();
            return;
        }
        int i8 = R.id.tv_reload;
        if (valueOf != null && valueOf.intValue() == i8) {
            getSearchHistory();
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    public final void setDissListener(View.OnClickListener onClickListener) {
        this.i = onClickListener;
    }

    public final void setPageAdapter(YYMusicPageAdapter yYMusicPageAdapter) {
        this.h = yYMusicPageAdapter;
    }

    public final void setTabAdapter(YYMusicTabAdapter yYMusicTabAdapter) {
        this.g = yYMusicTabAdapter;
    }
}
