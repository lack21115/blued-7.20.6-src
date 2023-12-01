package com.blued.android.module.live_china.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.chat.utils.MsgPackHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.utils.BitmapUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveCloakingUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/BarrageViewMultiOneRow.class */
public class BarrageViewMultiOneRow extends View {

    /* renamed from: a  reason: collision with root package name */
    public BaseFragment f14229a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    private BubblesRow f14230c;
    private BubblesRow d;
    private BubblesRow e;
    private Context f;
    private Paint g;
    private LayoutInflater h;
    private Float[] i;
    private int j;
    private View k;
    private View l;
    private View m;
    private View n;
    private View o;
    private View p;
    private View q;
    private View r;
    private Bitmap s;
    private final int t;
    private final float u;
    private float v;
    private float w;
    private int x;
    private boolean y;

    /* renamed from: com.blued.android.module.live_china.view.BarrageViewMultiOneRow$2  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/BarrageViewMultiOneRow$2.class */
    class AnonymousClass2 implements ImageFileLoader.OnLoadFileListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LiveChattingModel f14232a;
        final /* synthetic */ BarrageViewMultiOneRow b;

        @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
        public void onUIFinish(File file, Exception exc) {
            this.b.a(this.f14232a, 0);
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/BarrageViewMultiOneRow$BARRAGE_TYPE.class */
    interface BARRAGE_TYPE {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/BarrageViewMultiOneRow$Bubble.class */
    public class Bubble {

        /* renamed from: a  reason: collision with root package name */
        public LiveChattingModel f14235a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public String f14236c;
        public String d;
        public String e;
        public String f;
        public String g;
        public int h;
        public int i;
        public boolean j;
        public View k;
        public Bitmap l;
        public boolean m;
        private float o;
        private float p;

        private Bubble() {
            this.f14236c = "";
            this.d = "";
            this.e = "";
            this.f = "";
            this.g = "";
            this.i = 0;
            this.j = false;
            this.m = true;
        }

        private void d() {
            LinearLayout linearLayout = (LinearLayout) this.k.findViewById(R.id.ll_content);
            TextView textView = (TextView) this.k.findViewById(R.id.tv_name);
            TextView textView2 = (TextView) this.k.findViewById(R.id.tv_content);
            ImageView imageView = (ImageView) this.k.findViewById(R.id.img_rich_rank);
            ImageView imageView2 = (ImageView) this.k.findViewById(R.id.img_manager_icon);
            ImageView imageView3 = (ImageView) this.k.findViewById(R.id.img_star);
            if (this.i == 1) {
                imageView2.setVisibility(0);
            } else {
                imageView2.setVisibility(8);
            }
            BitmapUtils.a(BarrageViewMultiOneRow.this.f, imageView, this.h);
            textView.setText(this.e);
            textView2.setText(this.f);
            BarrageView.a(BarrageViewMultiOneRow.this.f, linearLayout, this.h, this.j);
            if (this.h < 30) {
                imageView3.setVisibility(8);
                linearLayout.setPadding(0, 0, DisplayUtil.a(AppInfo.d(), 6.0f), 0);
                return;
            }
            imageView3.setVisibility(0);
            if (this.h >= 34) {
                linearLayout.setPadding(0, 0, DisplayUtil.a(AppInfo.d(), 25.0f), 0);
            } else {
                linearLayout.setPadding(0, 0, DisplayUtil.a(AppInfo.d(), 20.0f), 0);
            }
        }

        private void e() {
            TextView textView = (TextView) this.k.findViewById(R.id.tv_content);
            TextView textView2 = (TextView) this.k.findViewById(R.id.tv_content_shadow);
            ImageView imageView = (ImageView) this.k.findViewById(R.id.img_rich_rank);
            ImageView imageView2 = (ImageView) this.k.findViewById(R.id.img_manager_icon);
            if (this.i == 1) {
                imageView2.setVisibility(0);
            } else {
                imageView2.setVisibility(8);
            }
            BitmapUtils.a(BarrageViewMultiOneRow.this.f, imageView, this.h);
            textView2.setText(this.e + ": " + this.f);
            if (TextUtils.isEmpty(this.e)) {
                textView.setText(this.e + ": " + this.f);
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.e + ": " + this.f);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(AppInfo.d().getResources().getColor(R.color.syc_f)), 0, this.e.length(), 33);
            textView.setText(spannableStringBuilder);
        }

        private void f() {
            TextView textView = (TextView) this.k.findViewById(R.id.tv_content);
            TextView textView2 = (TextView) this.k.findViewById(R.id.tv_content_shadow);
            ImageView imageView = (ImageView) this.k.findViewById(R.id.img_rich_rank);
            ImageView imageView2 = (ImageView) this.k.findViewById(R.id.img_manager_icon);
            if (this.i == 1) {
                imageView2.setVisibility(0);
            } else {
                imageView2.setVisibility(8);
            }
            textView2.setText(this.e + " " + this.f);
            textView.setText(this.e + " " + this.f);
            BitmapUtils.a(BarrageViewMultiOneRow.this.f, imageView, this.h);
        }

        private void g() {
            TextView textView = (TextView) this.k.findViewById(R.id.tv_name);
            TextView textView2 = (TextView) this.k.findViewById(R.id.tv_count);
            ImageView imageView = (ImageView) this.k.findViewById(R.id.img_gift);
            textView.setText(MsgPackHelper.getStringValue(this.f14235a.msgMapExtra, "name"));
            textView2.setText(MsgPackHelper.getIntValue(this.f14235a.msgMapExtra, "count") + "");
            ImageLoader.a((IRequestHost) null, MsgPackHelper.getStringValue(this.f14235a.msgMapExtra, "image")).b(R.drawable.gift_default_icon).a(imageView);
        }

        private void h() {
            ((TextView) this.k.findViewById(R.id.tv_content)).setText(this.f);
        }

        private void i() {
            ((TextView) this.k.findViewById(R.id.tv_content)).setText(this.f);
        }

        private void j() {
            LiveGiftModel liveGiftModel;
            TextView textView = (TextView) this.k.findViewById(R.id.tv_content);
            TextView textView2 = (TextView) this.k.findViewById(R.id.tv_content_shadow);
            TextView textView3 = (TextView) this.k.findViewById(R.id.tv_gift_count);
            BitmapUtils.a(BarrageViewMultiOneRow.this.f, (ImageView) this.k.findViewById(R.id.img_rich_rank), this.h);
            ImageView imageView = (ImageView) this.k.findViewById(R.id.img_manager_icon);
            if (this.i == 1) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = (ImageView) this.k.findViewById(R.id.img_gift);
            textView.setText(this.e + " " + BarrageViewMultiOneRow.this.f.getResources().getString(R.string.Live_SendPresent_send) + " ");
            textView2.setText(this.e + " " + BarrageViewMultiOneRow.this.f.getResources().getString(R.string.Live_SendPresent_send) + " ");
            if (this.f14235a.msgMapExtra != null) {
                liveGiftModel = (LiveGiftModel) this.f14235a.msgMapExtra.get("gift_model");
            } else if (TextUtils.isEmpty(this.g)) {
                return;
            } else {
                try {
                    liveGiftModel = (LiveGiftModel) AppInfo.f().fromJson(this.g, (Class<Object>) LiveGiftModel.class);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (liveGiftModel == null) {
                return;
            }
            String str = liveGiftModel.images_static;
            int i = liveGiftModel.hit_batch;
            int i2 = liveGiftModel.hit_count;
            if (i == 1) {
                textView3.setVisibility(0);
                textView3.setText("X" + i2);
            } else {
                textView3.setVisibility(8);
            }
            if (TextUtils.isEmpty(str)) {
                imageView2.setImageResource(R.drawable.gift_default_icon);
            } else {
                ImageLoader.a((IRequestHost) null, str).b(R.drawable.gift_default_icon).a(imageView2);
            }
            imageView2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            imageView2.layout(0, 0, imageView2.getMeasuredWidth(), imageView2.getMeasuredHeight());
            int width = (int) ((imageView2.getWidth() / imageView2.getHeight()) * BarrageViewMultiOneRow.this.j);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView2.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = BarrageViewMultiOneRow.this.j;
            imageView2.setLayoutParams(layoutParams);
        }

        private void k() {
            TextView textView = (TextView) this.k.findViewById(R.id.live_msg_content_nickname);
            TextView textView2 = (TextView) this.k.findViewById(R.id.live_msg_content_text);
            textView.setText(this.f14235a.fromNickName);
            String string = BarrageViewMultiOneRow.this.f.getResources().getString(R.string.live_chat_upgrade);
            textView2.setText(String.format(string, this.f14235a.fromRichLevel + ""));
        }

        public Bitmap a() {
            Bitmap bitmap = this.l;
            if (bitmap != null) {
                return bitmap;
            }
            if (this.k != null) {
                switch (this.b) {
                    case 0:
                        j();
                        break;
                    case 1:
                        e();
                        break;
                    case 2:
                        d();
                        break;
                    case 3:
                        g();
                        break;
                    case 4:
                        f();
                        break;
                    case 5:
                        h();
                        break;
                    case 6:
                        i();
                        break;
                    case 7:
                        k();
                        break;
                }
                try {
                    this.k.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    this.k.layout(0, 0, this.k.getMeasuredWidth(), this.k.getMeasuredHeight());
                    BarrageViewMultiOneRow.this.s = Bitmap.createBitmap(this.k.getMeasuredWidth(), this.k.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                    this.k.draw(new Canvas(BarrageViewMultiOneRow.this.s));
                    this.l = BarrageViewMultiOneRow.this.s;
                    return BarrageViewMultiOneRow.this.s;
                } catch (Exception e) {
                    return null;
                }
            }
            return null;
        }

        public void a(float f) {
            this.p = f;
        }

        public float b() {
            return this.p;
        }

        public void b(float f) {
            this.o = f;
        }

        public float c() {
            return this.o;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/BarrageViewMultiOneRow$BubblesRow.class */
    public class BubblesRow {

        /* renamed from: a  reason: collision with root package name */
        public List<Bubble> f14237a;
        public List<Bubble> b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f14238c;
        public int d;

        private BubblesRow() {
            this.f14237a = new ArrayList();
            this.b = new ArrayList();
            this.f14238c = true;
        }

        public int a() {
            return this.b.size();
        }

        public Bubble a(int i, int i2) {
            int i3 = this.d;
            int i4 = BarrageViewMultiOneRow.this.j;
            if (i2 <= i3 || i2 >= i4 + i3) {
                return null;
            }
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= this.f14237a.size()) {
                    return null;
                }
                int i7 = (int) this.f14237a.get(i6).p;
                int i8 = (int) this.f14237a.get(i6).p;
                int width = this.f14237a.get(i6).l.getWidth();
                if (i > i7 && i < i8 + width) {
                    return this.f14237a.get(i6);
                }
                i5 = i6 + 1;
            }
        }
    }

    public BarrageViewMultiOneRow(Context context) {
        super(context);
        this.f14230c = new BubblesRow();
        this.d = new BubblesRow();
        this.e = new BubblesRow();
        this.g = new Paint();
        this.i = new Float[]{Float.valueOf(0.0f), Float.valueOf(27.5f), Float.valueOf(55.0f)};
        this.j = 0;
        this.b = 3;
        this.t = 130;
        this.u = 2.5f;
        this.x = 2;
        this.y = false;
        this.f = context;
        a();
    }

    public BarrageViewMultiOneRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14230c = new BubblesRow();
        this.d = new BubblesRow();
        this.e = new BubblesRow();
        this.g = new Paint();
        this.i = new Float[]{Float.valueOf(0.0f), Float.valueOf(27.5f), Float.valueOf(55.0f)};
        this.j = 0;
        this.b = 3;
        this.t = 130;
        this.u = 2.5f;
        this.x = 2;
        this.y = false;
        this.f = context;
        a();
    }

    public BarrageViewMultiOneRow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14230c = new BubblesRow();
        this.d = new BubblesRow();
        this.e = new BubblesRow();
        this.g = new Paint();
        this.i = new Float[]{Float.valueOf(0.0f), Float.valueOf(27.5f), Float.valueOf(55.0f)};
        this.j = 0;
        this.b = 3;
        this.t = 130;
        this.u = 2.5f;
        this.x = 2;
        this.y = false;
        this.f = context;
        a();
    }

    static /* synthetic */ int a(BarrageViewMultiOneRow barrageViewMultiOneRow) {
        int i = barrageViewMultiOneRow.x;
        barrageViewMultiOneRow.x = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bubble a(int i, int i2) {
        Bubble a2 = this.f14230c.a(i, i2);
        Bubble bubble = a2;
        if (a2 == null) {
            bubble = this.d.a(i, i2);
        }
        Bubble bubble2 = bubble;
        if (bubble == null) {
            bubble2 = this.e.a(i, i2);
        }
        return bubble2;
    }

    private void a() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) this.f).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.v = 0.0f;
        this.w = displayMetrics.widthPixels;
        this.g.reset();
        this.g.setAntiAlias(true);
        this.g.setFilterBitmap(true);
        this.g.setColor(this.f.getResources().getColor(R.color.transparent));
        this.g.setAlpha(255);
        LayoutInflater from = LayoutInflater.from(this.f);
        this.h = from;
        this.k = from.inflate(R.layout.item_barrage, (ViewGroup) null);
        this.l = this.h.inflate(R.layout.item_barrage_msg_multi, (ViewGroup) null);
        this.n = this.h.inflate(R.layout.item_barrage_gift_multi, (ViewGroup) null);
        this.m = this.h.inflate(R.layout.item_barrage_normal_entrance_multi, (ViewGroup) null);
        this.o = this.h.inflate(R.layout.item_barrage_multi_obtain_gift, (ViewGroup) null);
        this.p = this.h.inflate(R.layout.item_barrage_chat_remind_multi, (ViewGroup) null);
        this.q = this.h.inflate(R.layout.item_barrage_attention_remind_multi, (ViewGroup) null);
        this.r = this.h.inflate(R.layout.item_live_msg_content_level, (ViewGroup) null);
        this.k.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        View view = this.k;
        view.layout(0, 0, view.getMeasuredWidth(), this.k.getMeasuredHeight());
        this.j = this.k.getHeight();
        setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.live_china.view.BarrageViewMultiOneRow.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                Bubble a2;
                if (BarrageViewMultiOneRow.this.f14229a == null || (a2 = BarrageViewMultiOneRow.this.a((int) motionEvent.getX(), (int) motionEvent.getY())) == null || a2.m) {
                    return false;
                }
                if (a2.b == 6) {
                    LiveSetDataObserver.a().l();
                    return false;
                } else if (a2.b == 5) {
                    LiveSetDataObserver.a().j();
                    return false;
                } else if (TextUtils.isEmpty(a2.f14236c)) {
                    return false;
                } else {
                    UserCardDialogFragment userCardDialogFragment = new UserCardDialogFragment(BarrageViewMultiOneRow.this.f14229a);
                    userCardDialogFragment.e(a2.f14236c);
                    userCardDialogFragment.show(BarrageViewMultiOneRow.this.f14229a.getFragmentManager(), "userCardDialog");
                    return false;
                }
            }
        });
        this.f14230c.d = DensityUtils.a(this.f, this.i[0].floatValue());
        this.d.d = DensityUtils.a(this.f, this.i[1].floatValue());
        this.e.d = DensityUtils.a(this.f, this.i[2].floatValue());
    }

    protected void a(final LiveChattingModel liveChattingModel) {
        if (liveChattingModel == null || TextUtils.isEmpty(MsgPackHelper.getStringValue(liveChattingModel.msgMapExtra, "image"))) {
            return;
        }
        ImageFileLoader.a((IRequestHost) null).a(MsgPackHelper.getStringValue(liveChattingModel.msgMapExtra, "image")).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.android.module.live_china.view.BarrageViewMultiOneRow.3
            @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
            public void onUIFinish(File file, Exception exc) {
                BarrageViewMultiOneRow.this.a(liveChattingModel, 3);
            }
        }).a();
    }

    protected void a(LiveChattingModel liveChattingModel, int i) {
        if (!this.y) {
            this.y = true;
            this.v = getX();
            this.w = getX() + getWidth();
        }
        final Bubble bubble = new Bubble();
        switch (i) {
            case 0:
                bubble.k = this.n;
                break;
            case 1:
                bubble.k = this.l;
                break;
            case 2:
                bubble.k = this.k;
                break;
            case 3:
                bubble.k = this.o;
                break;
            case 4:
                bubble.k = this.m;
                break;
            case 5:
                bubble.k = this.p;
                break;
            case 6:
                bubble.k = this.q;
                break;
            case 7:
                bubble.k = this.r;
                break;
        }
        bubble.b = i;
        bubble.a(this.w);
        bubble.f14235a = liveChattingModel;
        bubble.f14236c = liveChattingModel.fromId + "";
        bubble.d = liveChattingModel.fromAvatar;
        bubble.m = liveChattingModel.fromPrivilege == 1;
        bubble.e = LiveCloakingUtil.a(liveChattingModel.fromNickName, bubble.m);
        bubble.f = liveChattingModel.msgContent;
        if (LiveFloatManager.a().w()) {
            bubble.i = 1;
        }
        if (bubble.f14236c.equals(LiveRoomInfo.a().f())) {
            bubble.h = LiveRoomInfo.a().r();
        } else {
            bubble.h = liveChattingModel.fromRichLevel;
        }
        bubble.g = liveChattingModel.getMsgExtra();
        bubble.l = null;
        if ((liveChattingModel.fromId + "").equals(LiveRoomInfo.a().f())) {
            bubble.j = true;
        }
        bubble.b(-DensityUtils.a(this.f, 2.5f));
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.BarrageViewMultiOneRow.4
            @Override // java.lang.Runnable
            public void run() {
                if (BarrageViewMultiOneRow.this.getEmptyRow() + BarrageViewMultiOneRow.this.getSlotRow() > -2) {
                    BarrageViewMultiOneRow.this.a(bubble);
                    BarrageViewMultiOneRow.this.invalidate();
                    return;
                }
                BarrageViewMultiOneRow.a(BarrageViewMultiOneRow.this);
                BarrageViewMultiOneRow barrageViewMultiOneRow = BarrageViewMultiOneRow.this;
                barrageViewMultiOneRow.x = barrageViewMultiOneRow.x < 0 ? 2 : BarrageViewMultiOneRow.this.x;
                if (bubble.j) {
                    int i2 = BarrageViewMultiOneRow.this.x;
                    if (i2 == 0) {
                        BarrageViewMultiOneRow.this.f14230c.b.add(0, bubble);
                    } else if (i2 == 1) {
                        BarrageViewMultiOneRow.this.d.b.add(0, bubble);
                    } else if (i2 != 2) {
                    } else {
                        BarrageViewMultiOneRow.this.e.b.add(0, bubble);
                    }
                } else if (BarrageViewMultiOneRow.this.f14230c.a() + BarrageViewMultiOneRow.this.d.a() + BarrageViewMultiOneRow.this.e.a() < 130) {
                    int i3 = BarrageViewMultiOneRow.this.x;
                    if (i3 == 0) {
                        BarrageViewMultiOneRow.this.f14230c.b.add(bubble);
                    } else if (i3 == 1) {
                        BarrageViewMultiOneRow.this.d.b.add(bubble);
                    } else if (i3 != 2) {
                    } else {
                        BarrageViewMultiOneRow.this.e.b.add(bubble);
                    }
                }
            }
        });
    }

    protected void a(Bubble bubble) {
        int emptyRow = getEmptyRow();
        if (emptyRow >= 0) {
            if (emptyRow == 0) {
                this.f14230c.f14237a.add(bubble);
                return;
            } else if (emptyRow == 1) {
                this.d.f14237a.add(bubble);
                return;
            } else if (emptyRow != 2) {
                return;
            } else {
                this.e.f14237a.add(bubble);
                return;
            }
        }
        int slotRow = getSlotRow();
        if (slotRow == 0) {
            this.f14230c.b.add(bubble);
        } else if (slotRow == 1) {
            this.d.b.add(bubble);
        } else if (slotRow != 2) {
        } else {
            this.e.b.add(bubble);
        }
    }

    protected void a(BubblesRow bubblesRow, Canvas canvas) {
        if (bubblesRow.f14237a.size() > 0) {
            Iterator<Bubble> it = bubblesRow.f14237a.iterator();
            while (it.hasNext()) {
                Bubble next = it.next();
                if (next != null) {
                    Bitmap a2 = next.a();
                    if (next.b() + next.l.getWidth() <= this.v) {
                        it.remove();
                    } else if (((next.b() + next.c()) + next.l.getWidth()) - this.w >= 0.0f || (next.b() + next.l.getWidth()) - this.w <= 0.0f) {
                        if (next.b() + a2.getWidth() > this.w) {
                            bubblesRow.f14238c = false;
                        } else {
                            bubblesRow.f14238c = true;
                        }
                        next.a(next.b() + next.c());
                    } else {
                        bubblesRow.f14238c = true;
                        next.a(next.b() + next.c());
                    }
                    canvas.drawBitmap(next.a(), next.b(), bubblesRow.d, this.g);
                }
            }
            if (bubblesRow.b.size() <= 0 || !bubblesRow.f14238c) {
                return;
            }
            bubblesRow.f14237a.add(bubblesRow.b.get(0));
            bubblesRow.b.remove(0);
        }
    }

    public void b(LiveChattingModel liveChattingModel) {
        short s = liveChattingModel.msgType;
        if (s != 1) {
            if (s != 27) {
                if (s == 37) {
                    a(liveChattingModel, 2);
                    return;
                } else if (s == 61) {
                    a(liveChattingModel);
                    return;
                } else if (s != 49 && s != 50) {
                    switch (s) {
                        case 102:
                            a(liveChattingModel, 7);
                            return;
                        case 103:
                            a(liveChattingModel, 6);
                            return;
                        case 104:
                            a(liveChattingModel, 5);
                            return;
                        default:
                            switch (s) {
                                case 106:
                                case 107:
                                case 108:
                                case 109:
                                    break;
                                default:
                                    return;
                            }
                    }
                }
            }
            a(liveChattingModel, 4);
            return;
        }
        a(liveChattingModel, 1);
    }

    protected int getEmptyRow() {
        if (this.e.f14237a.size() == 0) {
            return 2;
        }
        if (this.d.f14237a.size() == 0) {
            return 1;
        }
        return this.f14230c.f14237a.size() == 0 ? 0 : -1;
    }

    protected int getSlotRow() {
        if (this.e.f14238c) {
            return 2;
        }
        if (this.d.f14238c) {
            return 1;
        }
        return this.f14230c.f14238c ? 0 : -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(this.e, canvas);
        a(this.d, canvas);
        a(this.f14230c, canvas);
        invalidate();
    }

    public void setBaseFragment(BaseFragment baseFragment) {
        this.f14229a = baseFragment;
    }
}
