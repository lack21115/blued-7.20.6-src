package com.blued.android.module.yy_china.manager;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.module.yy_china.model.DoublePeopleNoticeImNode;
import com.blued.android.module.yy_china.model.YYGlobalMsgMarqueeModel;
import com.blued.android.module.yy_china.model.YYHostUpMode;
import com.blued.android.module.yy_china.model.YYMsgMarqueeModel;
import com.blued.android.module.yy_china.model.YYUpMode;
import com.blued.android.module.yy_china.view.YYDoublePeopleMarriageNotice;
import com.blued.android.module.yy_china.view.YYHonorUpMarriageNotice;
import com.blued.android.module.yy_china.view.YYHostUpMarriageNotice;
import com.blued.android.module.yy_china.view.YYVipMarriageNotice;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/manager/YYVipNotifyManager.class */
public final class YYVipNotifyManager {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f17597a = new Companion(null);

    /* renamed from: c  reason: collision with root package name */
    private ViewGroup f17598c;
    private ActivityFragmentActive d;
    private boolean f;
    private final ArrayList<YYMsgMarqueeModel> b = new ArrayList<>();
    private Integer e = 0;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/manager/YYVipNotifyManager$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final YYVipNotifyManager a() {
            return InstanceHelper.f17599a.a();
        }
    }

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/manager/YYVipNotifyManager$InstanceHelper.class */
    public static final class InstanceHelper {

        /* renamed from: a  reason: collision with root package name */
        public static final InstanceHelper f17599a = new InstanceHelper();
        private static final YYVipNotifyManager b = new YYVipNotifyManager();

        private InstanceHelper() {
        }

        public final YYVipNotifyManager a() {
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        if (this.b.isEmpty()) {
            return;
        }
        YYMsgMarqueeModel remove = this.b.remove(0);
        Intrinsics.c(remove, "globalMsg.removeAt(0)");
        ActivityFragmentActive activityFragmentActive = this.d;
        if (activityFragmentActive != null) {
            if (!((activityFragmentActive == null || activityFragmentActive.isActive()) ? false : true)) {
                ViewGroup viewGroup = this.f17598c;
                if (viewGroup == null) {
                    return;
                }
                this.f = true;
                YYMsgMarqueeModel yYMsgMarqueeModel = remove;
                String str = yYMsgMarqueeModel.type;
                YYVipMarriageNotice yYVipMarriageNotice = null;
                if (str != null) {
                    switch (str.hashCode()) {
                        case -1469220378:
                            if (!str.equals(YYMsgMarqueeModel.HOST_UP_MARRIAGE)) {
                                yYVipMarriageNotice = null;
                                break;
                            } else {
                                Context context = viewGroup.getContext();
                                Intrinsics.c(context, "it.context");
                                YYHostUpMarriageNotice yYHostUpMarriageNotice = new YYHostUpMarriageNotice(context);
                                YYHostUpMarriageNotice yYHostUpMarriageNotice2 = yYHostUpMarriageNotice;
                                Object data = yYMsgMarqueeModel.getData();
                                if (data == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.yy_china.model.YYHostUpMode");
                                }
                                yYHostUpMarriageNotice2.a((YYHostUpMode) data);
                                yYHostUpMarriageNotice2.setAnimatorEndListener(new YYVipMarriageNotice.AnimatorEndListener() { // from class: com.blued.android.module.yy_china.manager.YYVipNotifyManager$loopMessage$1$3
                                    @Override // com.blued.android.module.yy_china.view.YYVipMarriageNotice.AnimatorEndListener
                                    public void a() {
                                        YYVipNotifyManager.this.f = false;
                                        YYVipNotifyManager.this.b();
                                    }
                                });
                                ActivityFragmentActive activityFragmentActive2 = this.d;
                                yYVipMarriageNotice = yYHostUpMarriageNotice;
                                if (activityFragmentActive2 != null) {
                                    Intrinsics.a(activityFragmentActive2);
                                    yYHostUpMarriageNotice2.a(viewGroup, activityFragmentActive2);
                                    yYVipMarriageNotice = yYHostUpMarriageNotice;
                                    break;
                                }
                            }
                            break;
                        case -25849794:
                            if (!str.equals(YYMsgMarqueeModel.DOUBLE_PEOPLE_MARRIAGE)) {
                                yYVipMarriageNotice = null;
                                break;
                            } else {
                                Context context2 = viewGroup.getContext();
                                Intrinsics.c(context2, "it.context");
                                yYVipMarriageNotice = new YYDoublePeopleMarriageNotice(context2);
                                YYDoublePeopleMarriageNotice yYDoublePeopleMarriageNotice = yYVipMarriageNotice;
                                Object data2 = yYMsgMarqueeModel.getData();
                                if (data2 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.yy_china.model.DoublePeopleNoticeImNode");
                                }
                                yYDoublePeopleMarriageNotice.a((DoublePeopleNoticeImNode) data2);
                                yYDoublePeopleMarriageNotice.setAnimatorEndListener(new YYDoublePeopleMarriageNotice.AnimatorEndListener() { // from class: com.blued.android.module.yy_china.manager.YYVipNotifyManager$loopMessage$1$1
                                    @Override // com.blued.android.module.yy_china.view.YYDoublePeopleMarriageNotice.AnimatorEndListener
                                    public void a() {
                                        YYVipNotifyManager.this.f = false;
                                        YYVipNotifyManager.this.b();
                                    }
                                });
                                ActivityFragmentActive activityFragmentActive3 = this.d;
                                Intrinsics.a(activityFragmentActive3);
                                yYDoublePeopleMarriageNotice.a(viewGroup, activityFragmentActive3);
                                break;
                            }
                        case 414062110:
                            if (!str.equals(YYMsgMarqueeModel.UP_MARRIAGE)) {
                                yYVipMarriageNotice = null;
                                break;
                            } else {
                                Context context3 = viewGroup.getContext();
                                Intrinsics.c(context3, "it.context");
                                YYHonorUpMarriageNotice yYHonorUpMarriageNotice = new YYHonorUpMarriageNotice(context3);
                                YYHonorUpMarriageNotice yYHonorUpMarriageNotice2 = yYHonorUpMarriageNotice;
                                Object data3 = yYMsgMarqueeModel.getData();
                                if (data3 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.yy_china.model.YYUpMode");
                                }
                                yYHonorUpMarriageNotice2.a((YYUpMode) data3);
                                yYHonorUpMarriageNotice2.setAnimatorEndListener(new YYVipMarriageNotice.AnimatorEndListener() { // from class: com.blued.android.module.yy_china.manager.YYVipNotifyManager$loopMessage$1$4
                                    @Override // com.blued.android.module.yy_china.view.YYVipMarriageNotice.AnimatorEndListener
                                    public void a() {
                                        YYVipNotifyManager.this.f = false;
                                        YYVipNotifyManager.this.b();
                                    }
                                });
                                ActivityFragmentActive activityFragmentActive4 = this.d;
                                yYVipMarriageNotice = yYHonorUpMarriageNotice;
                                if (activityFragmentActive4 != null) {
                                    Intrinsics.a(activityFragmentActive4);
                                    yYHonorUpMarriageNotice2.a(viewGroup, activityFragmentActive4);
                                    yYVipMarriageNotice = yYHonorUpMarriageNotice;
                                    break;
                                }
                            }
                            break;
                        case 1626324197:
                            if (!str.equals(YYMsgMarqueeModel.VIP_MARRIAGE)) {
                                yYVipMarriageNotice = null;
                                break;
                            } else {
                                Context context4 = viewGroup.getContext();
                                Intrinsics.c(context4, "it.context");
                                YYVipMarriageNotice yYVipMarriageNotice2 = new YYVipMarriageNotice(context4);
                                YYVipMarriageNotice yYVipMarriageNotice3 = yYVipMarriageNotice2;
                                Object data4 = yYMsgMarqueeModel.getData();
                                if (data4 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.yy_china.model.YYGlobalMsgMarqueeModel");
                                }
                                yYVipMarriageNotice3.a((YYGlobalMsgMarqueeModel) data4);
                                yYVipMarriageNotice3.setAnimatorEndListener(new YYVipMarriageNotice.AnimatorEndListener() { // from class: com.blued.android.module.yy_china.manager.YYVipNotifyManager$loopMessage$1$2
                                    @Override // com.blued.android.module.yy_china.view.YYVipMarriageNotice.AnimatorEndListener
                                    public void a() {
                                        YYVipNotifyManager.this.f = false;
                                        YYVipNotifyManager.this.b();
                                    }
                                });
                                ActivityFragmentActive activityFragmentActive5 = this.d;
                                yYVipMarriageNotice = yYVipMarriageNotice2;
                                if (activityFragmentActive5 != null) {
                                    Intrinsics.a(activityFragmentActive5);
                                    yYVipMarriageNotice3.a(viewGroup, activityFragmentActive5);
                                    yYVipMarriageNotice = yYVipMarriageNotice2;
                                    break;
                                }
                            }
                            break;
                        default:
                            yYVipMarriageNotice = null;
                            break;
                    }
                }
                if (yYVipMarriageNotice == null) {
                    return;
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                Integer num = this.e;
                Intrinsics.a(num);
                layoutParams.topMargin = num.intValue();
                viewGroup.addView(yYVipMarriageNotice, layoutParams);
                return;
            }
        }
        this.f = false;
        this.b.clear();
    }

    public final void a() {
        this.f17598c = null;
        this.d = null;
        this.f = false;
        this.b.clear();
    }

    public final void a(ViewGroup rootView, ActivityFragmentActive active, int i) {
        Intrinsics.e(rootView, "rootView");
        Intrinsics.e(active, "active");
        this.f17598c = rootView;
        this.d = active;
        this.e = Integer.valueOf(i);
    }

    public final void a(YYMsgMarqueeModel message) {
        Intrinsics.e(message, "message");
        this.b.add(message);
        if (this.f) {
            return;
        }
        b();
    }
}
