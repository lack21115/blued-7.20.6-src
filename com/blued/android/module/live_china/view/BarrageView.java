package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.model.LiveFansLevelModel;
import com.blued.android.module.common.utils.BitmapUtils;
import com.blued.android.module.common.view.LiveFansLevelView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.liveForMsg.LiveMsgManager;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveLiangModel;
import com.blued.android.module.live_china.model.LiveNobleModel;
import com.blued.android.module.live_china.utils.LiveCloakingUtil;
import com.blued.android.module.live_china.utils.LiveUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/BarrageView.class */
public class BarrageView extends View {

    /* renamed from: a  reason: collision with root package name */
    public BaseFragment f14220a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f14221c;
    private List<Bubble> d;
    private List<Bubble> e;
    private Random f;
    private int g;
    private Context h;
    private Paint i;
    private LayoutInflater j;
    private int[] k;
    private int l;
    private View m;
    private View n;
    private View o;
    private Bitmap p;
    private final int q;
    private LoadOptions r;

    /* renamed from: com.blued.android.module.live_china.view.BarrageView$3  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/BarrageView$3.class */
    class AnonymousClass3 implements ImageFileLoader.OnLoadFileListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f14224a;
        final /* synthetic */ LiveChattingModel b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BarrageView f14225c;

        @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
        public void onUIFinish(File file, Exception exc) {
            Map<String, String> a2 = BluedHttpTools.a();
            a2.put("ifSuccess", this.f14224a + "");
            this.f14225c.a(this.b, 2, a2, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/BarrageView$Bubble.class */
    public class Bubble {

        /* renamed from: a  reason: collision with root package name */
        public LiveChattingModel f14227a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public String f14228c;
        public int d;
        public String e;
        public String f;
        public String g;
        public int h;
        public boolean i;
        public int j;
        public String k;
        public int l;
        public int m;
        public String n;
        public int o;
        public int p;
        public boolean q;
        public boolean r;
        public float s;
        public View t;
        public Bitmap u;
        public int v;
        private float x;
        private float y;

        private Bubble() {
            this.b = "";
            this.f14228c = "";
            this.e = "";
            this.f = "";
            this.g = "";
            this.h = 0;
            this.i = false;
            this.j = 0;
            this.k = "";
            this.q = false;
            this.r = false;
        }

        private void d() {
            TextView textView = (TextView) this.t.findViewById(R.id.tv_name);
            TextView textView2 = (TextView) this.t.findViewById(R.id.tv_content);
            LinearLayout linearLayout = (LinearLayout) this.t.findViewById(R.id.ll_content);
            ImageView imageView = (ImageView) this.t.findViewById(R.id.img_rich_rank);
            ImageView imageView2 = (ImageView) this.t.findViewById(R.id.img_manager_icon);
            ImageView imageView3 = (ImageView) this.t.findViewById(R.id.img_noble_icon);
            ImageView imageView4 = (ImageView) this.t.findViewById(R.id.img_star);
            LiveFansLevelView liveFansLevelView = (LiveFansLevelView) this.t.findViewById(R.id.fans_level);
            if (this.h == 1) {
                imageView2.setVisibility(0);
            } else {
                imageView2.setVisibility(8);
            }
            BitmapUtils.a(BarrageView.this.h, imageView, this.d);
            LiveNobleModel b = BarrageView.this.b(this.f14227a);
            if (b == null || TextUtils.isEmpty(this.k)) {
                imageView3.setVisibility(8);
            } else {
                Bitmap a2 = BitmapUtils.a(this.k, DensityUtils.a(AppInfo.d(), 30.0f));
                if (b == null || b.getNameplate_img_width().intValue() <= 0 || b.getNameplate_img_height().intValue() <= 0 || a2 == null) {
                    imageView3.setVisibility(8);
                } else {
                    int a3 = AppMethods.a(15);
                    int intValue = (b.getNameplate_img_width().intValue() * a3) / b.getNameplate_img_height().intValue();
                    ViewGroup.LayoutParams layoutParams = imageView3.getLayoutParams();
                    layoutParams.width = intValue;
                    layoutParams.height = a3;
                    imageView3.setLayoutParams(layoutParams);
                    imageView3.setVisibility(0);
                    imageView3.setImageBitmap(a2);
                }
            }
            LiveFansLevelModel i = LiveMsgManager.i(this.f14227a);
            if (i.in_fan_club != 0) {
                liveFansLevelView.setFansLevel(i);
                liveFansLevelView.setVisibility(0);
            } else {
                liveFansLevelView.setVisibility(8);
            }
            textView.setText(this.e);
            textView2.setText(this.f);
            BarrageView.a(BarrageView.this.h, linearLayout, this.d, this.i);
            if (this.d >= 30) {
                imageView4.setVisibility(0);
                if (this.d >= 34) {
                    linearLayout.setPadding(0, 0, DisplayUtil.a(AppInfo.d(), 25.0f), 0);
                    imageView4.setImageResource(R.drawable.live_msg_list_star_wang);
                } else {
                    linearLayout.setPadding(0, 0, DisplayUtil.a(AppInfo.d(), 20.0f), 0);
                    imageView4.setImageResource(R.drawable.live_msg_list_star);
                }
            } else {
                linearLayout.setPadding(0, 0, DisplayUtil.a(AppInfo.d(), 6.0f), 0);
                imageView4.setVisibility(8);
            }
            View findViewById = this.t.findViewById(R.id.ll_level);
            if (this.l == 0) {
                findViewById.setVisibility(8);
                return;
            }
            findViewById.setVisibility(0);
            TextView textView3 = (TextView) this.t.findViewById(R.id.tv_level_num);
            TextView textView4 = (TextView) this.t.findViewById(R.id.tv_fans_name);
            textView3.setText(this.m + "");
            textView4.setText(this.n);
            ImageView imageView5 = (ImageView) this.t.findViewById(R.id.iv_heart);
            int i2 = this.o;
            if (i2 == 1) {
                findViewById.setBackgroundResource(R.drawable.live_fans_heart_level_badge_bg);
                imageView5.setImageResource(R.drawable.live_fans_heart_level_badge_heart);
            } else if (i2 == 2) {
                findViewById.setBackgroundResource(R.drawable.live_fans_heart_level_badge_bg_grey);
                imageView5.setImageResource(R.drawable.live_fans_heart_level_badge_heart_grey);
            }
        }

        private void e() {
            TextView textView = (TextView) this.t.findViewById(R.id.tv_name);
            TextView textView2 = (TextView) this.t.findViewById(R.id.tv_content_part1);
            TextView textView3 = (TextView) this.t.findViewById(R.id.tv_content_part2);
            LinearLayout linearLayout = (LinearLayout) this.t.findViewById(R.id.ll_content);
            BitmapUtils.a(BarrageView.this.h, (ImageView) this.t.findViewById(R.id.img_rich_rank), this.d);
            textView.setText(this.e);
            if (!this.r) {
                textView2.setText(BarrageView.this.h.getResources().getString(R.string.claw_game_fail));
                textView3.setVisibility(8);
                linearLayout.setBackground(BarrageView.this.h.getResources().getDrawable(R.drawable.shape_wawaji_result_fail));
                return;
            }
            textView2.setText(BarrageView.this.h.getResources().getString(R.string.claw_game_success_part1));
            textView3.setText(BarrageView.this.h.getResources().getString(R.string.claw_game_success_part2));
            textView3.setVisibility(0);
            linearLayout.setBackground(BarrageView.this.h.getResources().getDrawable(R.drawable.shape_wawaji_result_success));
        }

        private void f() {
            ImageView imageView = (ImageView) this.t.findViewById(R.id.img_header);
            TextView textView = (TextView) this.t.findViewById(R.id.tv_name);
            TextView textView2 = (TextView) this.t.findViewById(R.id.tv_content);
            ImageLoader.a((IRequestHost) null, this.f14228c).b(R.drawable.user_bg_round).c().a(imageView);
            textView.setText(this.e);
            textView2.setText(this.f);
        }

        public Bitmap a() {
            Bitmap bitmap = this.u;
            if (bitmap != null) {
                return bitmap;
            }
            if (this.t != null) {
                int i = this.j;
                if (i == 1) {
                    e();
                } else if (i != 2) {
                    d();
                } else {
                    f();
                }
                try {
                    this.t.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    this.t.layout(0, 0, this.t.getMeasuredWidth(), this.t.getMeasuredHeight());
                    BarrageView.this.p = Bitmap.createBitmap(this.t.getMeasuredWidth(), this.t.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                    this.t.draw(new Canvas(BarrageView.this.p));
                    this.u = BarrageView.this.p;
                    return BarrageView.this.p;
                } catch (Exception e) {
                    return null;
                }
            }
            return null;
        }

        public void a(float f) {
            this.y = f;
        }

        public float b() {
            return this.y;
        }

        public void b(float f) {
            this.x = f;
        }

        public float c() {
            return this.x;
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/BarrageView$MSG_TYPE.class */
    interface MSG_TYPE {
    }

    public BarrageView(Context context) {
        super(context);
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new Random();
        this.i = new Paint();
        this.k = new int[]{0, 40, 80, 120};
        this.l = 0;
        this.b = 4;
        this.f14221c = true;
        this.q = 130;
        this.h = context;
        a();
    }

    public BarrageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new Random();
        this.i = new Paint();
        this.k = new int[]{0, 40, 80, 120};
        this.l = 0;
        this.b = 4;
        this.f14221c = true;
        this.q = 130;
        this.h = context;
        a();
    }

    public BarrageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new Random();
        this.i = new Paint();
        this.k = new int[]{0, 40, 80, 120};
        this.l = 0;
        this.b = 4;
        this.f14221c = true;
        this.q = 130;
        this.h = context;
        a();
    }

    private void a() {
        this.i.reset();
        this.i.setAntiAlias(true);
        this.i.setFilterBitmap(true);
        this.i.setColor(this.h.getResources().getColor(R.color.transparent));
        this.i.setAlpha(255);
        LoadOptions loadOptions = new LoadOptions();
        this.r = loadOptions;
        loadOptions.b = R.drawable.user_bg_round;
        this.r.d = R.drawable.user_bg_round;
        LayoutInflater from = LayoutInflater.from(this.h);
        this.j = from;
        View inflate = from.inflate(R.layout.item_barrage, (ViewGroup) null);
        this.m = inflate;
        inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        View view = this.m;
        view.layout(0, 0, view.getMeasuredWidth(), this.m.getMeasuredHeight());
        this.l = this.m.getHeight();
        this.n = this.j.inflate(R.layout.item_wawaji_result, (ViewGroup) null);
        this.o = this.j.inflate(R.layout.item_wawaji_list_result, (ViewGroup) null);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.live_china.view.BarrageView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (BarrageView.this.f14220a != null) {
                    String b = BarrageView.this.b((int) motionEvent.getY());
                    if (TextUtils.isEmpty(b)) {
                        return false;
                    }
                    UserCardDialogFragment userCardDialogFragment = new UserCardDialogFragment(BarrageView.this.f14220a);
                    userCardDialogFragment.e(b);
                    userCardDialogFragment.show(BarrageView.this.f14220a.getFragmentManager(), "userCardDialog");
                    return false;
                }
                return false;
            }
        });
    }

    public static void a(Context context, View view, int i, boolean z) {
        if (view != null) {
            if (i <= 15) {
                view.setBackground(context.getResources().getDrawable(R.drawable.shape_round_live_msg_item_bg));
            } else if (i <= 20) {
                view.setBackground(context.getResources().getDrawable(R.drawable.shape_gradient_name_level_yellow));
            } else if (i <= 25) {
                view.setBackground(context.getResources().getDrawable(R.drawable.shape_gradient_name_level_orange));
            } else if (i < 30) {
                view.setBackground(context.getResources().getDrawable(R.drawable.shape_gradient_name_level_red));
            } else if (i == 30) {
                view.setBackground(context.getResources().getDrawable(R.drawable.shape_gradient_name_level_30));
            } else if (i == 31) {
                view.setBackground(context.getResources().getDrawable(R.drawable.shape_gradient_name_level_31));
            } else if (i == 32) {
                view.setBackground(context.getResources().getDrawable(R.drawable.shape_gradient_name_level_32));
            } else if (i == 33) {
                view.setBackground(context.getResources().getDrawable(R.drawable.shape_gradient_name_level_33));
            } else if (i == 34) {
                view.setBackground(context.getResources().getDrawable(R.drawable.shape_gradient_name_level_34));
            } else if (i == 35) {
                view.setBackground(context.getResources().getDrawable(R.drawable.shape_gradient_name_level_35));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(int i) {
        int[] iArr;
        int i2;
        int i3;
        if (this.l <= 0 || this.d.size() <= 0) {
            return "";
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            i2 = -1;
            i3 = 0;
            if (i5 >= this.k.length) {
                break;
            }
            int a2 = DensityUtils.a(this.h, iArr[i5]);
            int a3 = DensityUtils.a(this.h, this.k[i5]);
            int i6 = this.l;
            if (i >= a2 && i <= a3 + i6) {
                i2 = i5;
                i3 = 0;
                break;
            }
            i4 = i5 + 1;
        }
        while (i3 < this.d.size()) {
            if (i2 == this.d.get(i3).v) {
                return this.d.get(i3).q ? "" : this.d.get(i3).b;
            }
            i3++;
        }
        return "";
    }

    public int a(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? DensityUtils.a(this.h, this.k[0]) : DensityUtils.a(this.h, this.k[3]) : DensityUtils.a(this.h, this.k[2]) : DensityUtils.a(this.h, this.k[1]) : DensityUtils.a(this.h, this.k[0]);
    }

    public void a(final LiveChattingModel liveChattingModel) {
        LiveNobleModel b = b(liveChattingModel);
        if (b == null || TextUtils.isEmpty(b.getNameplate_img())) {
            a(liveChattingModel, "");
        } else {
            ImageFileLoader.a((IRequestHost) null).a(b.getNameplate_img()).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.android.module.live_china.view.BarrageView.2
                @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
                public void onUIFinish(File file, Exception exc) {
                    BarrageView.this.a(liveChattingModel, file != null ? file.getAbsolutePath() : "");
                }
            }).a();
        }
    }

    protected void a(LiveChattingModel liveChattingModel, int i, Map<String, String> map, String str) {
        if (this.g == 0) {
            this.g = getWidth();
        }
        final Bubble bubble = new Bubble();
        bubble.k = str;
        if (i == 1) {
            bubble.t = this.n;
        } else if (i != 2) {
            bubble.t = this.m;
        } else {
            bubble.t = this.o;
        }
        bubble.a(this.g);
        bubble.f14227a = liveChattingModel;
        bubble.b = liveChattingModel.fromId + "";
        bubble.q = liveChattingModel.fromPrivilege == 1;
        bubble.e = LiveCloakingUtil.a(liveChattingModel.fromNickName, bubble.q);
        bubble.g = liveChattingModel.fromVBadge + "";
        bubble.f = liveChattingModel.msgContent;
        bubble.j = i;
        bubble.f14228c = liveChattingModel.fromAvatar;
        bubble.h = liveChattingModel.fromLiveManager;
        LiveFansLevelModel i2 = LiveMsgManager.i(liveChattingModel);
        if (i2 != null) {
            bubble.n = i2.fan_club_name;
            bubble.m = i2.fan_club_level;
            bubble.l = i2.in_fan_club;
            bubble.o = i2.fans_status;
        }
        LiveLiangModel b = LiveUtils.b(liveChattingModel);
        if (b != null) {
            bubble.p = b.liang_type;
        }
        if (i == 1) {
            if (map != null) {
                bubble.r = "1".equals(map.get("ifSuccess"));
            } else {
                bubble.r = false;
            }
        }
        if (bubble.b.equals(LiveRoomInfo.a().f())) {
            bubble.d = LiveRoomInfo.a().r();
        } else {
            bubble.d = liveChattingModel.fromRichLevel;
        }
        bubble.u = null;
        if ((liveChattingModel.fromId + "").equals(LiveRoomInfo.a().f())) {
            bubble.i = true;
        }
        bubble.b(-(DensityUtils.a(this.h, 1.0f) + this.f.nextInt(DensityUtils.a(this.h, 1.0f))));
        if (i == 1 || i == 2) {
            bubble.b(-DensityUtils.a(this.h, 3.0f));
        }
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.BarrageView.4
            @Override // java.lang.Runnable
            public void run() {
                if (BarrageView.this.d.size() >= BarrageView.this.b) {
                    if (bubble.i) {
                        BarrageView.this.e.add(0, bubble);
                        return;
                    } else if (BarrageView.this.e.size() < 130) {
                        BarrageView.this.e.add(bubble);
                        return;
                    } else {
                        return;
                    }
                }
                if (BarrageView.this.e.size() == 0) {
                    bubble.v = BarrageView.this.getEmptyPosition();
                    Bubble bubble2 = bubble;
                    bubble2.s = BarrageView.this.a(bubble2.v);
                    BarrageView.this.d.add(bubble);
                } else if (bubble.i) {
                    BarrageView.this.e.add(0, bubble);
                } else if (BarrageView.this.e.size() < 130) {
                    BarrageView.this.e.add(bubble);
                }
                BarrageView.this.invalidate();
            }
        });
    }

    protected void a(LiveChattingModel liveChattingModel, String str) {
        a(liveChattingModel, 0, (Map<String, String>) null, str);
    }

    public LiveNobleModel b(LiveChattingModel liveChattingModel) {
        if (liveChattingModel == null) {
            return null;
        }
        if (liveChattingModel.nobleModel == null || TextUtils.isEmpty(liveChattingModel.nobleModel.getNameplate_img())) {
            LiveNobleModel liveNobleModel = null;
            if (liveChattingModel.fromId != 0) {
                liveNobleModel = null;
                if (TextUtils.equals(liveChattingModel.fromId + "", LiveRoomInfo.a().f())) {
                    liveNobleModel = LiveRoomManager.a().N();
                }
            }
            return liveNobleModel;
        }
        return liveChattingModel.nobleModel;
    }

    public int getEmptyPosition() {
        if (this.d.size() < this.b) {
            StringBuffer stringBuffer = new StringBuffer();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.d.size()) {
                    break;
                }
                stringBuffer.append(this.d.get(i2).v);
                i = i2 + 1;
            }
            String stringBuffer2 = stringBuffer.toString();
            if (!this.f14221c || this.b <= 1) {
                if (stringBuffer2.contains("0")) {
                    if (stringBuffer2.contains("1")) {
                        if (stringBuffer2.contains("2")) {
                            return !stringBuffer2.contains("3") ? 3 : 0;
                        }
                        return 2;
                    }
                    return 1;
                }
                return 0;
            } else if (stringBuffer2.contains("3")) {
                if (stringBuffer2.contains("2")) {
                    if (stringBuffer2.contains("1")) {
                        stringBuffer2.contains("0");
                        return 0;
                    }
                    return 1;
                }
                return 2;
            } else {
                return 3;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.d.size() > 0) {
            Iterator<Bubble> it = this.d.iterator();
            while (it.hasNext()) {
                Bubble next = it.next();
                if (next != null) {
                    if (next.b() + next.c() > (-(next.a().getWidth() - next.c()))) {
                        next.a(next.b() + next.c());
                    } else if (this.e.size() > 0) {
                        Bubble bubble = this.e.get(0);
                        next.b = bubble.b;
                        next.e = bubble.e;
                        next.f = bubble.f;
                        next.a(bubble.b());
                        next.b(bubble.c());
                        next.u = bubble.a();
                        this.e.remove(0);
                    } else {
                        it.remove();
                    }
                    canvas.drawBitmap(next.a(), next.b(), next.s, this.i);
                }
            }
            invalidate();
        }
    }

    public void setBaseFragment(BaseFragment baseFragment) {
        this.f14220a = baseFragment;
    }
}
