package com.blued.android.module.live_china.fitem.msgcontent;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.internal.util.cm.QSConstants;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.liveForMsg.LiveMsgContentManager;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveEmojiModel;
import com.blued.android.module.live_china.model.LiveNobleModel;
import com.blued.android.module.live_china.utils.dslspannable.DslSpanBuilder;
import com.blued.android.module.live_china.utils.dslspannable.DslSpannableStringBuilder;
import com.blued.android.module.live_china.view.LiveTextSpanExKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/msgcontent/FitemMsgText.class */
public final class FitemMsgText extends FitemMsgAboutUser {
    private final LiveChattingModel b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitemMsgText(LiveChattingModel msg) {
        super(msg);
        Intrinsics.e(msg, "msg");
        this.b = msg;
    }

    private final void a(Context context, TextView textView) {
        LiveTextSpanExKt.a(textView, new FitemMsgText$setSpanToText$1(this, context, textView));
        w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View itemView) {
        Intrinsics.e(itemView, "$itemView");
        itemView.getLayoutParams().height = itemView.getHeight();
        itemView.setLayoutParams(itemView.getLayoutParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final View it, FitemMsgText this$0) {
        Intrinsics.e(it, "$it");
        Intrinsics.e(this$0, "this$0");
        final float a = DisplayUtil.a(AppInfo.d(), 15.0f);
        final float width = it.getWidth();
        final float height = it.getHeight();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setInterpolator(new DecelerateInterpolator(1.5f));
        ofFloat.setDuration(500L);
        final AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator(1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgText$p5JJ1RSqESp9kArqxgZpDBOtVDA
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FitemMsgText.a(AccelerateInterpolator.this, it, a, width, a, height, valueAnimator);
            }
        });
        ofFloat.start();
        it.animate().alpha(1.0f).setDuration(300L).start();
        ImageView imageView = (ImageView) this$0.a.a(R.id.live_msg_content_star);
        if (imageView != null && imageView.getVisibility() == 0) {
            imageView.setPivotX(0.0f);
            imageView.setPivotY(imageView.getHeight());
            imageView.getRotation();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, QSConstants.TILE_ROTATION, 0.0f, -18.0f, -25.0f, 0.0f);
            ofFloat2.setDuration(900L);
            ofFloat2.setInterpolator(new DecelerateInterpolator(1.5f));
            ofFloat2.start();
        }
        this$0.e().msgMapExtra.remove("TRANSITION_MSG_TAG");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(AccelerateInterpolator accelerate, View it, float f, float f2, float f3, float f4, ValueAnimator animation) {
        Intrinsics.e(accelerate, "$accelerate");
        Intrinsics.e(it, "$it");
        Intrinsics.e(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
        float floatValue = ((Float) animatedValue).floatValue();
        float interpolation = accelerate.getInterpolation(floatValue);
        it.getLayoutParams().width = (int) (f + ((f2 - f) * floatValue));
        it.getLayoutParams().height = (int) (f3 + ((f4 - f3) * interpolation));
        it.setLayoutParams(it.getLayoutParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemMsgText this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.l();
    }

    private final void b(final Context context, TextView textView) {
        final String q = q();
        String str = q;
        if (!(str == null || str.length() == 0)) {
            LiveTextSpanExKt.a(textView, new Function1<DslSpannableStringBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgText$setSpanToEnter$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void a(DslSpannableStringBuilder buildSpannableString) {
                    Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
                    buildSpannableString.a(FitemMsgText.this.k() + ' ' + context.getResources().getString(R.string.live_come_from), new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgText$setSpanToEnter$1.1
                        public final void a(DslSpanBuilder addText) {
                            Intrinsics.e(addText, "$this$addText");
                            Context d = AppInfo.d();
                            Intrinsics.c(d, "getAppContext()");
                            addText.a(d, R.color.biao_live_msg_name_3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                            a(dslSpanBuilder);
                            return Unit.a;
                        }
                    });
                    StringBuilder sb = new StringBuilder();
                    sb.append(' ');
                    sb.append((Object) q);
                    sb.append(' ');
                    buildSpannableString.a(sb.toString(), new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgText$setSpanToEnter$1.2
                        public final void a(DslSpanBuilder addText) {
                            Intrinsics.e(addText, "$this$addText");
                            Context d = AppInfo.d();
                            Intrinsics.c(d, "getAppContext()");
                            addText.a(d, R.color.syc_dark_FF6533);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                            a(dslSpanBuilder);
                            return Unit.a;
                        }
                    });
                    String string = context.getResources().getString(R.string.live_coming);
                    Intrinsics.c(string, "context.resources.getString(R.string.live_coming)");
                    buildSpannableString.a(string, new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgText$setSpanToEnter$1.3
                        public final void a(DslSpanBuilder addText) {
                            Intrinsics.e(addText, "$this$addText");
                            Context d = AppInfo.d();
                            Intrinsics.c(d, "getAppContext()");
                            addText.a(d, R.color.biao_live_msg_name_3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                            a(dslSpanBuilder);
                            return Unit.a;
                        }
                    });
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Unit invoke(DslSpannableStringBuilder dslSpannableStringBuilder) {
                    a(dslSpannableStringBuilder);
                    return Unit.a;
                }
            });
            return;
        }
        if (!TextUtils.isEmpty(s()) && o() != null) {
            LiveNobleModel o = o();
            Integer valueOf = o == null ? null : Integer.valueOf(o.getNoble_level());
            Intrinsics.a(valueOf);
            if (valueOf.intValue() < 7) {
                LiveTextSpanExKt.a(textView, new Function1<DslSpannableStringBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgText$setSpanToEnter$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    public final void a(DslSpannableStringBuilder buildSpannableString) {
                        Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
                        buildSpannableString.a(FitemMsgText.this.k(), new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgText$setSpanToEnter$2.1
                            public final void a(DslSpanBuilder addText) {
                                Intrinsics.e(addText, "$this$addText");
                                Context d = AppInfo.d();
                                Intrinsics.c(d, "getAppContext()");
                                addText.a(d, R.color.biao_live_msg_name_3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                                a(dslSpanBuilder);
                                return Unit.a;
                            }
                        });
                        buildSpannableString.a(" 大驾光临", new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgText$setSpanToEnter$2.2
                            public final void a(DslSpanBuilder addText) {
                                Intrinsics.e(addText, "$this$addText");
                                Context d = AppInfo.d();
                                Intrinsics.c(d, "getAppContext()");
                                addText.a(d, R.color.syc_dark_F5DEC0);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                                a(dslSpanBuilder);
                                return Unit.a;
                            }
                        });
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* synthetic */ Unit invoke(DslSpannableStringBuilder dslSpannableStringBuilder) {
                        a(dslSpannableStringBuilder);
                        return Unit.a;
                    }
                });
                View a = this.a.a(R.id.live_msg_content_root);
                if (a != null) {
                    a.setBackgroundResource(R.drawable.live_msg_vip_join_item_bg);
                }
                View a2 = this.a.a(R.id.live_msg_vip_shadow);
                if (a2 == null) {
                    return;
                }
                a2.setVisibility(0);
                return;
            }
        }
        if (r() && o() != null) {
            LiveTextSpanExKt.a(textView, new Function1<DslSpannableStringBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgText$setSpanToEnter$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final void a(DslSpannableStringBuilder buildSpannableString) {
                    String u;
                    Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
                    buildSpannableString.a(FitemMsgText.this.k(), new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgText$setSpanToEnter$3.1
                        public final void a(DslSpanBuilder addText) {
                            Intrinsics.e(addText, "$this$addText");
                            Context d = AppInfo.d();
                            Intrinsics.c(d, "getAppContext()");
                            addText.a(d, R.color.biao_live_msg_name_3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                            a(dslSpanBuilder);
                            return Unit.a;
                        }
                    });
                    u = FitemMsgText.this.u();
                    buildSpannableString.a(Intrinsics.a(" ", (Object) u), new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgText$setSpanToEnter$3.2
                        public final void a(DslSpanBuilder addText) {
                            Intrinsics.e(addText, "$this$addText");
                            Context d = AppInfo.d();
                            Intrinsics.c(d, "getAppContext()");
                            addText.a(d, R.color.syc_dark_F5DEC0);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                            a(dslSpanBuilder);
                            return Unit.a;
                        }
                    });
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Unit invoke(DslSpannableStringBuilder dslSpannableStringBuilder) {
                    a(dslSpannableStringBuilder);
                    return Unit.a;
                }
            });
            View a3 = this.a.a(R.id.live_msg_content_root);
            if (a3 == null) {
                return;
            }
            a3.setBackgroundResource(R.drawable.live_msg_noble_join_item_bg);
        } else if (TextUtils.isEmpty(s())) {
            LiveTextSpanExKt.a(textView, new Function1<DslSpannableStringBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgText$setSpanToEnter$5
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void a(DslSpannableStringBuilder buildSpannableString) {
                    Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
                    buildSpannableString.a(FitemMsgText.this.k() + ' ' + context.getResources().getString(R.string.live_coming), new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgText$setSpanToEnter$5.1
                        public final void a(DslSpanBuilder addText) {
                            Intrinsics.e(addText, "$this$addText");
                            Context d = AppInfo.d();
                            Intrinsics.c(d, "getAppContext()");
                            addText.a(d, R.color.biao_live_msg_name_3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                            a(dslSpanBuilder);
                            return Unit.a;
                        }
                    });
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Unit invoke(DslSpannableStringBuilder dslSpannableStringBuilder) {
                    a(dslSpannableStringBuilder);
                    return Unit.a;
                }
            });
        } else {
            LiveTextSpanExKt.a(textView, new Function1<DslSpannableStringBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgText$setSpanToEnter$4
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final void a(DslSpannableStringBuilder buildSpannableString) {
                    Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
                    buildSpannableString.a(FitemMsgText.this.k(), new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgText$setSpanToEnter$4.1
                        public final void a(DslSpanBuilder addText) {
                            Intrinsics.e(addText, "$this$addText");
                            Context d = AppInfo.d();
                            Intrinsics.c(d, "getAppContext()");
                            addText.a(d, R.color.biao_live_msg_name_3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                            a(dslSpanBuilder);
                            return Unit.a;
                        }
                    });
                    buildSpannableString.a(" 大驾光临", new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgText$setSpanToEnter$4.2
                        public final void a(DslSpanBuilder addText) {
                            Intrinsics.e(addText, "$this$addText");
                            Context d = AppInfo.d();
                            Intrinsics.c(d, "getAppContext()");
                            addText.a(d, R.color.syc_dark_F5DEC0);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                            a(dslSpanBuilder);
                            return Unit.a;
                        }
                    });
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Unit invoke(DslSpannableStringBuilder dslSpannableStringBuilder) {
                    a(dslSpannableStringBuilder);
                    return Unit.a;
                }
            });
            View a4 = this.a.a(R.id.live_msg_content_root);
            if (a4 != null) {
                a4.setBackgroundResource(R.drawable.live_msg_vip_join_item_bg);
            }
            View a5 = this.a.a(R.id.live_msg_vip_shadow);
            if (a5 == null) {
                return;
            }
            a5.setVisibility(0);
        }
    }

    private final void c(final Context context, TextView textView) {
        LiveTextSpanExKt.a(textView, new Function1<DslSpannableStringBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgText$setSpanToLike$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void a(DslSpannableStringBuilder buildSpannableString) {
                Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
                buildSpannableString.a(FitemMsgText.this.k() + ' ' + context.getResources().getString(R.string.live_send_a_like), new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgText$setSpanToLike$1.1
                    public final void a(DslSpanBuilder addText) {
                        Intrinsics.e(addText, "$this$addText");
                        Context d = AppInfo.d();
                        Intrinsics.c(d, "getAppContext()");
                        addText.a(d, R.color.biao_live_msg_name_3);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                        a(dslSpanBuilder);
                        return Unit.a;
                    }
                });
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(DslSpannableStringBuilder dslSpannableStringBuilder) {
                a(dslSpannableStringBuilder);
                return Unit.a;
            }
        });
    }

    private final void d(final Context context, TextView textView) {
        LiveTextSpanExKt.a(textView, new Function1<DslSpannableStringBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgText$setSpanToFollow$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void a(DslSpannableStringBuilder buildSpannableString) {
                Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
                buildSpannableString.a(FitemMsgText.this.k() + ' ' + context.getResources().getString(R.string.live_following), new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgText$setSpanToFollow$1.1
                    public final void a(DslSpanBuilder addText) {
                        Intrinsics.e(addText, "$this$addText");
                        Context d = AppInfo.d();
                        Intrinsics.c(d, "getAppContext()");
                        addText.a(d, R.color.biao_live_msg_name_3);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                        a(dslSpanBuilder);
                        return Unit.a;
                    }
                });
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(DslSpannableStringBuilder dslSpannableStringBuilder) {
                a(dslSpannableStringBuilder);
                return Unit.a;
            }
        });
    }

    private final void e(final Context context, TextView textView) {
        LiveTextSpanExKt.a(textView, new Function1<DslSpannableStringBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgText$setSpanToShare$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void a(DslSpannableStringBuilder buildSpannableString) {
                Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
                buildSpannableString.a(FitemMsgText.this.k() + ' ' + context.getResources().getString(R.string.live_shared), new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgText$setSpanToShare$1.1
                    public final void a(DslSpanBuilder addText) {
                        Intrinsics.e(addText, "$this$addText");
                        Context d = AppInfo.d();
                        Intrinsics.c(d, "getAppContext()");
                        addText.a(d, R.color.biao_live_msg_name_3);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                        a(dslSpanBuilder);
                        return Unit.a;
                    }
                });
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(DslSpannableStringBuilder dslSpannableStringBuilder) {
                a(dslSpannableStringBuilder);
                return Unit.a;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String u() {
        return r() ? String.valueOf(e().nobleModel.getNoble_join_text()) : "";
    }

    private final void v() {
        boolean a = LiveMsgContentManager.a.a(e());
        View a2 = this.a.a(R.id.live_msg_content_root);
        a2.setAlpha(a ? 0.0f : 1.0f);
        a2.getLayoutParams().width = -2;
        a2.getLayoutParams().height = -2;
        a2.setLayoutParams(a2.getLayoutParams());
        View view = this.a.itemView;
        if (view != null) {
            view.getLayoutParams().height = -2;
            view.setLayoutParams(view.getLayoutParams());
        }
        View a3 = this.a.a(R.id.live_msg_vip_shadow);
        if (a3 == null) {
            return;
        }
        a3.setVisibility(8);
    }

    private final void w() {
        if (LiveMsgContentManager.a.a(e())) {
            final View view = this.a.itemView;
            if (view != null) {
                view.post(new Runnable() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgText$LA2-CEjEwmymIiGRIcWU5_X7HG0
                    @Override // java.lang.Runnable
                    public final void run() {
                        FitemMsgText.a(View.this);
                    }
                });
            }
            final View a = this.a.a(R.id.live_msg_content_root);
            if (a == null) {
                return;
            }
            a.post(new Runnable() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgText$IflfMmJsqcvpRCTF1blBQL7tt4g
                @Override // java.lang.Runnable
                public final void run() {
                    FitemMsgText.a(View.this, this);
                }
            });
        }
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_msg_text;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0083  */
    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgAboutUser, com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase, com.blued.android.module.common.utils.freedom.FreedomItem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.content.Context r7, com.blued.android.module.common.utils.freedom.BaseViewHolder r8, java.util.List<com.blued.android.module.common.utils.freedom.FreedomItem> r9, int r10) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgText.a(android.content.Context, com.blued.android.module.common.utils.freedom.BaseViewHolder, java.util.List, int):void");
    }

    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgAboutUser, com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase
    public LiveChattingModel e() {
        return this.b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0087, code lost:
        if (r0.length() == 0) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String q() {
        /*
            r4 = this;
            com.google.gson.Gson r0 = com.blued.android.core.AppInfo.f()
            r1 = r4
            com.blued.android.module.live_china.model.LiveChattingModel r1 = r1.e()
            java.lang.String r1 = r1.getMsgExtra()
            java.lang.Class<com.blued.android.module.live_china.model.LivePropCardModel> r2 = com.blued.android.module.live_china.model.LivePropCardModel.class
            java.lang.Object r0 = r0.fromJson(r1, r2)
            com.blued.android.module.live_china.model.LivePropCardModel r0 = (com.blued.android.module.live_china.model.LivePropCardModel) r0
            r8 = r0
            r0 = r8
            if (r0 != 0) goto L1e
            java.lang.String r0 = ""
            return r0
        L1e:
            r0 = r8
            int r0 = r0.getAnchor_pocket_traffic_card()
            r7 = r0
            r0 = 0
            r6 = r0
            r0 = 0
            r5 = r0
            r0 = r7
            r1 = 1
            if (r0 == r1) goto L6f
            r0 = r8
            int r0 = r0.getAnchor_pocket_traffic_card()
            r1 = 2
            if (r0 != r1) goto L39
            goto L6f
        L39:
            r0 = r8
            int r0 = r0.getAnchor_pocket_traffic_card()
            r1 = 3
            if (r0 != r1) goto L6b
            r0 = r8
            java.lang.String r0 = r0.getAnchor_pocket_traffic_card_name()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L5b
            r0 = r9
            int r0 = r0.length()
            if (r0 != 0) goto L5d
        L5b:
            r0 = 1
            r5 = r0
        L5d:
            r0 = r5
            if (r0 == 0) goto L65
            java.lang.String r0 = ""
            return r0
        L65:
            r0 = r8
            java.lang.String r0 = r0.getAnchor_pocket_traffic_card_name()
            return r0
        L6b:
            java.lang.String r0 = ""
            return r0
        L6f:
            r0 = r8
            java.lang.String r0 = r0.getAnchor_pocket_traffic_card_name()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L8a
            r0 = r6
            r5 = r0
            r0 = r9
            int r0 = r0.length()
            if (r0 != 0) goto L8c
        L8a:
            r0 = 1
            r5 = r0
        L8c:
            r0 = r5
            if (r0 == 0) goto L94
            java.lang.String r0 = ""
            return r0
        L94:
            r0 = r8
            java.lang.String r0 = r0.getAnchor_pocket_traffic_card_name()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgText.q():java.lang.String");
    }

    public final boolean r() {
        String noble_join_text = e().nobleModel.getNoble_join_text();
        return !(noble_join_text == null || noble_join_text.length() == 0);
    }

    public final String s() {
        return !TextUtils.isEmpty(e().vip_frame) ? e().vip_frame.toString() : "";
    }

    public final LiveEmojiModel t() {
        try {
            LiveEmojiModel liveEmojiModel = (LiveEmojiModel) AppInfo.f().fromJson(e().getMsgExtra(), LiveEmojiModel.class);
            if (liveEmojiModel == null || StringUtils.a(liveEmojiModel.getEmoji_id(), 0) <= 0 || TextUtils.isEmpty(liveEmojiModel.getEmoji_url()) || liveEmojiModel.getEmoji_w() <= 0) {
                return null;
            }
            if (liveEmojiModel.getEmoji_h() > 0) {
                return liveEmojiModel;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
