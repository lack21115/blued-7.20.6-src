package com.blued.android.module.live_china.liveForMsg.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.alipay.sdk.cons.c;
import com.alipay.sdk.util.l;
import com.android.internal.util.cm.SpamFilter;
import com.anythink.core.common.g.g;
import com.blued.android.chat.utils.MsgPackHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.model.LiveFansLevelModel;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.utils.LinkMovementClickMethod;
import com.blued.android.module.common.view.LiveFansLevelView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.BaseListAdapter;
import com.blued.android.module.live_china.constant.LiveRoomConstants;
import com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.liveForMsg.ClickMsgTalkerListener;
import com.blued.android.module.live_china.liveForMsg.LiveMsgManager;
import com.blued.android.module.live_china.liveForMsg.ui.VerticalCenterImageSpan;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveBubbleBgModel;
import com.blued.android.module.live_china.model.LiveChatBadgeModel;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveEmojiModel;
import com.blued.android.module.live_china.model.LiveFansInfoModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveGiftScrawlTransModel;
import com.blued.android.module.live_china.model.LiveGuideType;
import com.blued.android.module.live_china.model.LiveMsgReportModel;
import com.blued.android.module.live_china.model.LivePropCardModel;
import com.blued.android.module.live_china.model.LiveWishContestContentModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.same.LiveBitmapUtils;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveCloakingUtil;
import com.blued.android.module.live_china.utils.LiveMemoryBitmapCache;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.LiveUtils;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.LiveMsgBgFrameLayout;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/liveForMsg/data/LiveMsgContentAdapter.class */
public class LiveMsgContentAdapter extends BaseListAdapter<LiveChattingModel> {
    private LiveMsgManager d;
    private Context e;
    private int f;
    private boolean g;
    private int h;
    private int i;

    private View a(LiveChattingModel liveChattingModel, int i) {
        short s = liveChattingModel.msgType;
        switch (s) {
            case -10005:
                return this.b.inflate(R.layout.item_live_msg_content_pk_dared_egg, (ViewGroup) null);
            case -10004:
                return g(liveChattingModel);
            case -10003:
            case g.k /* -10002 */:
                return this.b.inflate(R.layout.item_live_msg_content_topcard, (ViewGroup) null);
            case g.j /* -10001 */:
            case -10000:
                return this.b.inflate(R.layout.item_live_msg_gift_task, (ViewGroup) null);
            default:
                switch (s) {
                    case 1:
                    case 33:
                    case 221:
                    case 232:
                    case 245:
                    case 251:
                        return this.b.inflate(R.layout.item_live_msg_content_text, (ViewGroup) null);
                    case 27:
                        return this.b.inflate(R.layout.item_live_msg_content_normal_entrance, (ViewGroup) null);
                    case 61:
                        return this.b.inflate(R.layout.item_live_msg_content_get_gift, (ViewGroup) null);
                    case 155:
                        return this.b.inflate(R.layout.item_live_msg_content_level, (ViewGroup) null);
                    case 202:
                        return this.b.inflate(R.layout.item_live_msg_task, (ViewGroup) null);
                    case 224:
                        return this.b.inflate(R.layout.item_live_msg_content_pk_plus, (ViewGroup) null);
                    case 249:
                        return this.b.inflate(R.layout.item_live_msg_content_light_blue, (ViewGroup) null);
                    default:
                        switch (s) {
                            case 49:
                            case 50:
                                return this.b.inflate(R.layout.item_live_msg_content_share, (ViewGroup) null);
                            case 51:
                                return this.b.inflate(R.layout.item_live_msg_content_liked, (ViewGroup) null);
                            default:
                                switch (s) {
                                    case 102:
                                        return this.b.inflate(R.layout.item_live_msg_content_level, (ViewGroup) null);
                                    case 103:
                                        return this.b.inflate(R.layout.item_live_msg_content_attention, (ViewGroup) null);
                                    case 104:
                                        return this.b.inflate(R.layout.item_live_msg_content_chat, (ViewGroup) null);
                                    default:
                                        switch (s) {
                                            case 106:
                                            case 107:
                                            case 108:
                                            case 109:
                                                return this.b.inflate(R.layout.item_live_msg_content_filed_control, (ViewGroup) null);
                                            default:
                                                return null;
                                        }
                                }
                        }
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(int i, int i2, int i3, SpannableStringBuilder spannableStringBuilder, int i4, int i5, TextView textView, String str, Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        bitmapDrawable.setBounds(0, i, i2, i3 + i);
        spannableStringBuilder.setSpan(new VerticalCenterImageSpan(bitmapDrawable, 2), i4, i5, 33);
        textView.setText(spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Drawable drawable, TextView textView, SpannableStringBuilder spannableStringBuilder, int i, String str, String str2) {
        drawable.setBounds(0, 0, AppMethods.a(24), AppMethods.a(24));
        int length = i + str.length() + 1;
        spannableStringBuilder.setSpan(new VerticalCenterImageSpan(drawable, 2), length, str2.length() + length, 33);
        textView.setText(spannableStringBuilder);
    }

    private void a(TextView textView, SpannableStringBuilder spannableStringBuilder, int i, String str, String str2) {
        Drawable drawable = AppInfo.d().getDrawable(R.drawable.live_msg_gift_scrawl);
        if (drawable == null) {
            return;
        }
        drawable.setBounds(0, 0, AppMethods.a(24), AppMethods.a(24));
        int length = i + str.length() + 1;
        spannableStringBuilder.setSpan(new VerticalCenterImageSpan(drawable, 2), length, str2.length() + length, 33);
        textView.setText(spannableStringBuilder);
    }

    private void a(final TextView textView, final SpannableStringBuilder spannableStringBuilder, String str, final int i, final int i2) {
        textView.setTag(R.id.image_bitmap, str);
        LiveMemoryBitmapCache a = LiveMemoryBitmapCache.a();
        Context context = this.e;
        a.a(context, str, DensityUtils.a(context, 20.0f), R.drawable.live_msg_gift_default_bg, new LiveMemoryBitmapCache.BitmapCallback() { // from class: com.blued.android.module.live_china.liveForMsg.data.LiveMsgContentAdapter.14
            @Override // com.blued.android.module.live_china.utils.LiveMemoryBitmapCache.BitmapCallback
            public void onBitmapCreate(String str2, Bitmap bitmap) {
                if (bitmap == null) {
                    return;
                }
                Object tag = textView.getTag(R.id.image_bitmap);
                if (TextUtils.equals(tag instanceof String ? (String) tag : "", str2)) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                    bitmapDrawable.setBounds(0, 0, AppMethods.a(24), AppMethods.a(24));
                    VerticalCenterImageSpan verticalCenterImageSpan = new VerticalCenterImageSpan(bitmapDrawable, 2);
                    SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
                    int i3 = i;
                    spannableStringBuilder2.setSpan(verticalCenterImageSpan, i3, i2 + i3, 33);
                    textView.setText(spannableStringBuilder);
                }
            }
        });
    }

    private void a(final TextView textView, final LiveChattingModel liveChattingModel) {
        LiveGiftModel a;
        int i;
        Bitmap createBitmap;
        if (textView == null || liveChattingModel == null) {
            return;
        }
        String a2 = LiveCloakingUtil.a(liveChattingModel.fromNickName, liveChattingModel.fromPrivilege);
        if (TextUtils.isEmpty(a2) || (a = LiveUtils.a(liveChattingModel)) == null) {
            return;
        }
        h(liveChattingModel);
        int i2 = liveChattingModel.fromLiveManager;
        LiveFansLevelModel d = d(liveChattingModel);
        String str = d.fan_club_name;
        int i3 = d.fan_club_level;
        int i4 = d.in_fan_club;
        int i5 = d.fans_status;
        int c = c(liveChattingModel);
        LiveChatBadgeModel c2 = LiveUtils.c(liveChattingModel);
        String str2 = i2 != 0 ? "field_control " : "";
        String str3 = i4 != 0 ? "fans " : "";
        String str4 = c != 0 ? "rich " : "";
        String str5 = (c2 == null || TextUtils.isEmpty(c2.getChat_badge_url()) || c2.getChat_badge_length().intValue() == 0 || c2.getChat_badge_height().intValue() == 0) ? "" : "rechargeBadge ";
        final String str6 = str2 + str3 + str4 + str5 + "" + a2 + " 开启 lucky_bag 获得了 " + a.name + " lucky_gift 送给主播";
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str6);
        final int a3 = AppMethods.a(1.0f);
        if (i2 != 0) {
            Drawable a4 = LiveBitmapUtils.a();
            a4.setBounds(0, a3, AppMethods.a(29), AppMethods.a(15) + a3);
            spannableStringBuilder.setSpan(new VerticalCenterImageSpan(a4, 2), 0, str2.length() - 1, 33);
        }
        if (i4 != 0) {
            LiveFansLevelView liveFansLevelView = new LiveFansLevelView(this.e);
            liveFansLevelView.setFansLevel(d);
            int a5 = AppMethods.a(54.5f);
            int a6 = AppMethods.a(15.0f);
            try {
                liveFansLevelView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                int measuredWidth = liveFansLevelView.getMeasuredWidth();
                int measuredHeight = liveFansLevelView.getMeasuredHeight();
                liveFansLevelView.layout(0, 0, measuredWidth, measuredHeight);
                createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
                a5 = measuredWidth;
                a6 = measuredHeight;
                liveFansLevelView.draw(new Canvas(createBitmap));
                a5 = measuredWidth;
                a6 = measuredHeight;
            } catch (Exception e) {
                createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(textView.getResources(), createBitmap);
            bitmapDrawable.setBounds(0, a3, a5, a6 + a3);
            spannableStringBuilder.setSpan(new VerticalCenterImageSpan(bitmapDrawable, 2), str6.indexOf(str3), (str6.indexOf(str3) + str3.length()) - 1, 33);
        }
        if (c != 0) {
            Drawable a7 = LiveBitmapUtils.a(AppInfo.d(), c);
            if (c >= 30) {
                a7.setBounds(0, a3, AppMethods.a(44), AppMethods.a(15) + a3);
            } else {
                a7.setBounds(0, a3, AppMethods.a(30), AppMethods.a(15) + a3);
            }
            spannableStringBuilder.setSpan(new VerticalCenterImageSpan(a7, 2), str6.indexOf(str4), (str6.indexOf(str4) + str4.length()) - 1, 33);
        }
        if (!TextUtils.isEmpty(str5) && c2 != null && !TextUtils.isEmpty(c2.getChat_badge_url())) {
            BitmapDrawable bitmapDrawable2 = new BitmapDrawable();
            int a8 = AppMethods.a(15);
            if (c2.getChat_badge_length().intValue() == 0 || c2.getChat_badge_height().intValue() == 0) {
                i = 0;
                a8 = 0;
            } else {
                i = (c2.getChat_badge_length().intValue() * a8) / c2.getChat_badge_height().intValue();
            }
            bitmapDrawable2.setBounds(0, a3, i, a8 + a3);
            final int indexOf = str6.indexOf(str5);
            final int length = (str5.length() + indexOf) - 1;
            if (indexOf < spannableStringBuilder.length() && length < spannableStringBuilder.length()) {
                spannableStringBuilder.setSpan(new VerticalCenterImageSpan(bitmapDrawable2, 2), indexOf, length, 33);
                final int i6 = i;
                final int i7 = a8;
                LiveMemoryBitmapCache.a().a(this.e, c2.getChat_badge_url(), DensityUtils.a(this.e, i), 0, new LiveMemoryBitmapCache.BitmapCallback() { // from class: com.blued.android.module.live_china.liveForMsg.data.-$$Lambda$LiveMsgContentAdapter$av5BgegNMoPwusfC8aPt-gjdJvE
                    @Override // com.blued.android.module.live_china.utils.LiveMemoryBitmapCache.BitmapCallback
                    public final void onBitmapCreate(String str7, Bitmap bitmap) {
                        LiveMsgContentAdapter.c(a3, i6, i7, spannableStringBuilder, indexOf, length, textView, str7, bitmap);
                    }
                });
            }
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.liveForMsg.data.LiveMsgContentAdapter.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                Selection.removeSelection((Spannable) ((TextView) view).getText());
                LiveMsgContentAdapter.this.i(liveChattingModel);
            }
        });
        textView.setTextColor(AppInfo.d().getResources().getColor(R.color.biao_live_msg_name_0));
        textView.setTag(960336433, a.luck_bag_img);
        LiveMemoryBitmapCache.a().a(this.e, a.luck_bag_img, DensityUtils.a(this.e, 30.0f), R.drawable.live_msg_gift_default_bg, new LiveMemoryBitmapCache.BitmapCallback() { // from class: com.blued.android.module.live_china.liveForMsg.data.LiveMsgContentAdapter.22
            @Override // com.blued.android.module.live_china.utils.LiveMemoryBitmapCache.BitmapCallback
            public void onBitmapCreate(String str7, Bitmap bitmap) {
                if (bitmap == null) {
                    return;
                }
                Object tag = textView.getTag(r6.hashCode());
                if (TextUtils.equals(tag instanceof String ? (String) tag : "", str7)) {
                    BitmapDrawable bitmapDrawable3 = new BitmapDrawable(bitmap);
                    bitmapDrawable3.setBounds(0, 0, AppMethods.a(24), AppMethods.a(24));
                    int indexOf2 = str6.indexOf(r6);
                    spannableStringBuilder.setSpan(new VerticalCenterImageSpan(bitmapDrawable3, 2), indexOf2, r6.length() + indexOf2, 33);
                    textView.setText(spannableStringBuilder);
                }
            }
        });
        textView.setMovementMethod(LinkMovementClickMethod.a());
        textView.setText(spannableStringBuilder);
        textView.setTag(R.id.image_bitmap, a.images_static);
        LiveMemoryBitmapCache.a().a(this.e, a.images_static, DensityUtils.a(this.e, 30.0f), R.drawable.live_msg_gift_default_bg, new LiveMemoryBitmapCache.BitmapCallback() { // from class: com.blued.android.module.live_china.liveForMsg.data.LiveMsgContentAdapter.23
            @Override // com.blued.android.module.live_china.utils.LiveMemoryBitmapCache.BitmapCallback
            public void onBitmapCreate(String str7, Bitmap bitmap) {
                if (bitmap == null) {
                    return;
                }
                Object tag = textView.getTag(R.id.image_bitmap);
                if (!TextUtils.equals(tag instanceof String ? (String) tag : "", str7)) {
                    Log.i("==xpp", "ignore for not same tag");
                    return;
                }
                Log.i("==xpp", "set for same tag");
                BitmapDrawable bitmapDrawable3 = new BitmapDrawable(bitmap);
                bitmapDrawable3.setBounds(0, 0, AppMethods.a(24), AppMethods.a(24));
                int indexOf2 = str6.indexOf(r7);
                spannableStringBuilder.setSpan(new VerticalCenterImageSpan(bitmapDrawable3, 2), indexOf2, r7.length() + indexOf2, 33);
                textView.setText(spannableStringBuilder);
            }
        });
    }

    private void a(final TextView textView, LiveChattingModel liveChattingModel, final ClickMsgTalkerListener clickMsgTalkerListener) {
        LiveGiftModel a;
        String str;
        String str2;
        int i;
        int i2;
        String str3;
        int i3;
        String str4;
        int i4;
        int i5;
        Bitmap createBitmap;
        if (textView == null || liveChattingModel == null) {
            return;
        }
        String a2 = LiveCloakingUtil.a(liveChattingModel.fromNickName, liveChattingModel.fromPrivilege);
        if (TextUtils.isEmpty(a2) || (a = LiveUtils.a(liveChattingModel)) == null) {
            return;
        }
        final String str5 = this.e.getString(R.string.Live_SendPresent_send) + " " + a.name + " ";
        h(liveChattingModel);
        int i6 = liveChattingModel.fromLiveManager;
        LiveFansLevelModel d = d(liveChattingModel);
        String str6 = d.fan_club_name;
        int i7 = d.fan_club_level;
        int i8 = d.in_fan_club;
        int i9 = d.fans_status;
        int c = c(liveChattingModel);
        LiveChatBadgeModel c2 = LiveUtils.c(liveChattingModel);
        int length = a2.length();
        int i10 = 14;
        if (i6 != 0) {
            length = a2.length() + 14;
            str = "field_control ";
        } else {
            str = "";
            i10 = 0;
        }
        if (i8 != 0) {
            i2 = i10 + 5;
            i = a2.length() + i2;
            str2 = "fans ";
        } else {
            str2 = "";
            i = length;
            i2 = i10;
        }
        if (c != 0) {
            i2 += 5;
            i3 = i2 + a2.length();
            str3 = "rich ";
        } else {
            str3 = "";
            i3 = i;
        }
        if (c2 == null || TextUtils.isEmpty(c2.getChat_badge_url()) || c2.getChat_badge_length().intValue() == 0 || c2.getChat_badge_height().intValue() == 0) {
            str4 = "";
            i4 = i2;
        } else {
            i4 = i2 + 14;
            i3 = i4 + a2.length();
            str4 = "rechargeBadge ";
        }
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + str2 + str3 + str4 + "" + a2 + " " + str5 + "gift ");
        if (a.getDisplayCount() > 1) {
            String str7 = " X" + a.getDisplayCount();
            int length2 = spannableStringBuilder.length();
            int length3 = str7.length();
            spannableStringBuilder.append((CharSequence) str7);
            spannableStringBuilder.setSpan(new CharacterStyle() { // from class: com.blued.android.module.live_china.liveForMsg.data.LiveMsgContentAdapter.15
                @Override // android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(AppInfo.d().getResources().getColor(R.color.biao_live_msg_name_8));
                    textPaint.setUnderlineText(false);
                    textPaint.clearShadowLayer();
                }
            }, length2, length2 + length3, 33);
        }
        if (a.is_help_wish_list) {
            int length4 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) "，帮助主播实现心愿");
            spannableStringBuilder.setSpan(new CharacterStyle() { // from class: com.blued.android.module.live_china.liveForMsg.data.LiveMsgContentAdapter.16
                @Override // android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(AppInfo.d().getResources().getColor(R.color.white));
                    textPaint.setUnderlineText(false);
                    textPaint.clearShadowLayer();
                }
            }, length4, length4 + 9, 33);
        }
        final int a3 = AppMethods.a(1.0f);
        if (i6 != 0) {
            Drawable a4 = LiveBitmapUtils.a();
            a4.setBounds(0, a3, AppMethods.a(29), a3 + AppMethods.a(15));
            spannableStringBuilder.setSpan(new VerticalCenterImageSpan(a4, 2), 0, str.length() - 1, 33);
        }
        if (i8 != 0) {
            LiveFansLevelView liveFansLevelView = new LiveFansLevelView(this.e);
            liveFansLevelView.setFansLevel(d);
            int a5 = AppMethods.a(54.5f);
            int a6 = AppMethods.a(15.0f);
            try {
                liveFansLevelView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                int measuredWidth = liveFansLevelView.getMeasuredWidth();
                int measuredHeight = liveFansLevelView.getMeasuredHeight();
                liveFansLevelView.layout(0, 0, measuredWidth, measuredHeight);
                createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
                a5 = measuredWidth;
                a6 = measuredHeight;
                liveFansLevelView.draw(new Canvas(createBitmap));
                a5 = measuredWidth;
                a6 = measuredHeight;
            } catch (Exception e) {
                createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(textView.getResources(), createBitmap);
            bitmapDrawable.setBounds(0, a3, a5, a6 + a3);
            spannableStringBuilder.setSpan(new VerticalCenterImageSpan(bitmapDrawable, 2), str.length(), (str.length() + str2.length()) - 1, 33);
        }
        if (c != 0) {
            Drawable a7 = LiveBitmapUtils.a(AppInfo.d(), c);
            if (c >= 30) {
                a7.setBounds(0, a3, AppMethods.a(44), AppMethods.a(15) + a3);
            } else {
                a7.setBounds(0, a3, AppMethods.a(30), AppMethods.a(15) + a3);
            }
            spannableStringBuilder.setSpan(new VerticalCenterImageSpan(a7, 2), str2.length() + str.length(), ((str2.length() + str.length()) + str3.length()) - 1, 33);
        }
        if (!TextUtils.isEmpty(str4) && c2 != null && !TextUtils.isEmpty(c2.getChat_badge_url())) {
            BitmapDrawable bitmapDrawable2 = new BitmapDrawable();
            int a8 = AppMethods.a(15);
            if (c2.getChat_badge_length().intValue() == 0 || c2.getChat_badge_height().intValue() == 0) {
                a8 = 0;
                i5 = 0;
            } else {
                i5 = (c2.getChat_badge_length().intValue() * a8) / c2.getChat_badge_height().intValue();
            }
            bitmapDrawable2.setBounds(0, a3, i5, a8 + a3);
            final int length5 = str2.length() + str.length() + str3.length();
            final int length6 = (str4.length() + length5) - 1;
            if (length5 < spannableStringBuilder.length() && length6 < spannableStringBuilder.length()) {
                spannableStringBuilder.setSpan(new VerticalCenterImageSpan(bitmapDrawable2, 2), length5, length6, 33);
                final int i11 = i5;
                final int i12 = a8;
                LiveMemoryBitmapCache.a().a(this.e, c2.getChat_badge_url(), DensityUtils.a(this.e, i5), 0, new LiveMemoryBitmapCache.BitmapCallback() { // from class: com.blued.android.module.live_china.liveForMsg.data.-$$Lambda$LiveMsgContentAdapter$B5Xkw13jt1-nxbW3TTNFhrj_AyU
                    @Override // com.blued.android.module.live_china.utils.LiveMemoryBitmapCache.BitmapCallback
                    public final void onBitmapCreate(String str8, Bitmap bitmap) {
                        LiveMsgContentAdapter.d(a3, i11, i12, spannableStringBuilder, length5, length6, textView, str8, bitmap);
                    }
                });
            }
        }
        if (a.isReward) {
            int length7 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) "（来自求开播）");
            spannableStringBuilder.setSpan(new CharacterStyle() { // from class: com.blued.android.module.live_china.liveForMsg.data.LiveMsgContentAdapter.17
                @Override // android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setTextSize(DisplayUtil.a(AppInfo.d(), 12.0f));
                    textPaint.setColor(Color.parseColor("#FFD452"));
                    textPaint.setUnderlineText(false);
                    textPaint.clearShadowLayer();
                }
            }, length7, length7 + 7, 33);
        }
        spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.blued.android.module.live_china.liveForMsg.data.LiveMsgContentAdapter.18
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                Selection.removeSelection((Spannable) ((TextView) view).getText());
                clickMsgTalkerListener.onClickMsgTalkerListener();
            }
        }, i4, i3, 33);
        spannableStringBuilder.setSpan(new CharacterStyle() { // from class: com.blued.android.module.live_china.liveForMsg.data.LiveMsgContentAdapter.19
            @Override // android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(AppInfo.d().getResources().getColor(R.color.biao_live_msg_name_0));
                textPaint.setUnderlineText(false);
                textPaint.clearShadowLayer();
            }
        }, i4, str5.length() + i3 + 1, 33);
        textView.setTag(R.id.image_bitmap, a.images_static);
        final int i13 = i3;
        LiveMemoryBitmapCache.a().a(this.e, a.images_static, DensityUtils.a(this.e, 30.0f), R.drawable.live_msg_gift_default_bg, new LiveMemoryBitmapCache.BitmapCallback() { // from class: com.blued.android.module.live_china.liveForMsg.data.LiveMsgContentAdapter.20
            @Override // com.blued.android.module.live_china.utils.LiveMemoryBitmapCache.BitmapCallback
            public void onBitmapCreate(String str8, Bitmap bitmap) {
                if (bitmap == null) {
                    return;
                }
                Object tag = textView.getTag(R.id.image_bitmap);
                if (!TextUtils.equals(tag instanceof String ? (String) tag : "", str8)) {
                    Log.i("==xpp", "ignore for not same tag");
                    return;
                }
                Log.i("==xpp", "set for same tag");
                LiveMsgContentAdapter.this.a(new BitmapDrawable(bitmap), textView, spannableStringBuilder, i13, str5, r9);
            }
        });
        textView.setMovementMethod(LinkMovementClickMethod.a());
        textView.setText(spannableStringBuilder);
    }

    private void a(LiveChattingModel liveChattingModel, View view, View view2) {
        TextView textView = (TextView) view2.findViewById(R.id.live_msg_content_task_text);
        View findViewById = view2.findViewById(R.id.live_msg_task);
        if (TextUtils.isEmpty(liveChattingModel.msgContent)) {
            return;
        }
        textView.setText(liveChattingModel.msgContent);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.liveForMsg.data.LiveMsgContentAdapter.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                Tracker.onClick(view3);
            }
        });
    }

    private void a(LiveChattingModel liveChattingModel, TextView textView) {
        int i;
        long j = liveChattingModel.fromId;
        String str = liveChattingModel.fromNickName;
        int intValue = ((Integer) liveChattingModel.msgMapExtra.get(l.c)).intValue();
        int i2 = 3;
        if (intValue == 1) {
            i = R.string.live_chicken_win_msg;
        } else if (intValue == 2) {
            i = R.string.live_chicken_lose_msg;
            i2 = 5;
        } else if (intValue == 3) {
            i = R.string.live_chicken_tie_msg;
            i2 = 0;
        } else if (intValue != 4) {
            i = -1;
            i2 = -1;
        } else {
            i = R.string.live_chicken_all_win_msg;
        }
        if (i == -1) {
            textView.setText("");
            return;
        }
        String format = String.format(AppInfo.d().getResources().getString(i), str);
        liveChattingModel.msgContent = format;
        liveChattingModel.msgTimestamp = System.currentTimeMillis();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
        spannableStringBuilder.setSpan(new CharacterStyle() { // from class: com.blued.android.module.live_china.liveForMsg.data.LiveMsgContentAdapter.3
            @Override // android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(AppInfo.d().getResources().getColor(R.color.syc_dark_FFD228));
                textPaint.setUnderlineText(false);
                textPaint.clearShadowLayer();
            }
        }, i2, str.length() + i2, 33);
        textView.setText(spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(LiveWishContestContentModel liveWishContestContentModel, View view) {
        if (TextUtils.isEmpty(liveWishContestContentModel.url)) {
            return;
        }
        LiveEventBusUtil.b(liveWishContestContentModel.url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, LiveChattingModel liveChattingModel, View view) {
        if (str == null) {
            return;
        }
        boolean z = true;
        int hashCode = str.hashCode();
        if (hashCode != 47571) {
            if (hashCode != 48532) {
                switch (hashCode) {
                    case 49494:
                        if (str.equals(LiveGuideType.GUIDE_TYPE_FIRST_RECHARGE)) {
                            z = true;
                            break;
                        }
                        break;
                    case 49495:
                        if (str.equals(LiveGuideType.GUIDE_TYPE_BEG_GIFT)) {
                            z = true;
                            break;
                        }
                        break;
                    case 49496:
                        if (str.equals(LiveGuideType.GUIDE_TYPE_JOIN_FANS_GROUP)) {
                            z = true;
                            break;
                        }
                        break;
                    case 49497:
                        if (str.equals(LiveGuideType.GUIDE_TYPE_JOIN_FANS)) {
                            z = true;
                            break;
                        }
                        break;
                }
            } else if (str.equals(LiveGuideType.GUIDE_TYPE_MARKETING_CAMPAIGN_NOTICE)) {
                z = true;
            }
        } else if (str.equals(LiveGuideType.GUIDE_TYPE_OFFICIAL_SAFETY_NOTICE)) {
            z = false;
        }
        if (z) {
            if (liveChattingModel.msgMapExtra == null || !liveChattingModel.msgMapExtra.containsKey("url")) {
                return;
            }
            String str2 = (String) liveChattingModel.msgMapExtra.get("url");
            if (this.d.g) {
                LiveSetDataObserver.a().b(str2, 0);
            } else {
                LiveRefreshUIObserver.a().b(str2, 0);
            }
            EventTrackLive.m(LiveProtos.Event.LIVE_SCREEN_ACTIVITY_NOTICE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), str2);
        } else if (z) {
            EventTrackLive.o(LiveProtos.Event.LIVE_SCREEN_GUIDE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), "recharge");
            LiveRefreshUIObserver.a().v();
        } else if (z) {
            EventTrackLive.o(LiveProtos.Event.LIVE_SCREEN_GUIDE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), "present");
            LiveRefreshUIObserver.a().j();
        } else if (z) {
            EventTrackLive.o(LiveProtos.Event.LIVE_SCREEN_GUIDE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), "fans_club");
            LiveRefreshUIObserver.a().m();
        } else if (!z) {
        } else {
            EventTrackLive.o(LiveProtos.Event.LIVE_SCREEN_GUIDE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), "fans_group");
            LiveRefreshUIObserver.a().n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z, String str, View view) {
        if (!z) {
            LiveSetDataObserver.a().f(str);
        } else if (this.d.g) {
            LiveSetDataObserver.a().b(str, 0);
        } else {
            LiveRefreshUIObserver.a().b(str, 0);
        }
    }

    private int b() {
        if (this.h == 0) {
            this.h = DisplayUtil.a(AppInfo.d(), 20.0f);
        }
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(int i, int i2, int i3, SpannableStringBuilder spannableStringBuilder, int i4, int i5, TextView textView, String str, Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        bitmapDrawable.setBounds(0, i, i2, i3 + i);
        spannableStringBuilder.setSpan(new VerticalCenterImageSpan(bitmapDrawable, 2), i4, i5, 33);
        textView.setText(spannableStringBuilder);
    }

    private void b(final LiveChattingModel liveChattingModel, View view, View view2) {
        int i;
        String str;
        String str2;
        String str3;
        int i2;
        int i3;
        String str4;
        int i4;
        int i5;
        Bitmap createBitmap;
        if (view2 == null || liveChattingModel == null || TextUtils.isEmpty(liveChattingModel.fromNickName)) {
            return;
        }
        final TextView textView = (TextView) view2.findViewById(R.id.live_msg_content_text);
        String str5 = this.e.getString(R.string.Live_SendPresent_send) + " 涂鸦礼物 ";
        h(liveChattingModel);
        int i6 = liveChattingModel.fromLiveManager;
        LiveFansLevelModel d = d(liveChattingModel);
        String str6 = d.fan_club_name;
        int i7 = d.fan_club_level;
        int i8 = d.in_fan_club;
        int i9 = d.fans_status;
        int c = c(liveChattingModel);
        LiveChatBadgeModel c2 = LiveUtils.c(liveChattingModel);
        if (liveChattingModel.fromPrivilege == 1) {
            liveChattingModel.fromNickName = LiveCloakingUtil.a(liveChattingModel.fromNickName);
        }
        int length = liveChattingModel.fromNickName.length();
        int i10 = 14;
        if (i6 != 0) {
            i = 14 + length;
            str = "field_control ";
        } else {
            i = length;
            str = "";
            i10 = 0;
        }
        if (i8 != 0) {
            i10 += 5;
            i = i10 + length;
            str2 = "fans ";
        } else {
            str2 = "";
        }
        if (c != 0) {
            i3 = i10 + 5;
            i2 = i3 + length;
            str3 = "rich ";
        } else {
            str3 = "";
            i2 = i;
            i3 = i10;
        }
        if (c2 == null || TextUtils.isEmpty(c2.getChat_badge_url()) || c2.getChat_badge_length().intValue() == 0 || c2.getChat_badge_height().intValue() == 0) {
            str4 = "";
            i4 = i2;
        } else {
            i3 += 14;
            i4 = length + i3;
            str4 = "rechargeBadge ";
        }
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + str2 + str3 + str4 + "" + liveChattingModel.fromNickName + " " + str5 + "gift ");
        final int a = AppMethods.a(1.0f);
        if (i6 != 0) {
            Drawable a2 = LiveBitmapUtils.a();
            a2.setBounds(0, a, AppMethods.a(29), a + AppMethods.a(15));
            spannableStringBuilder.setSpan(new VerticalCenterImageSpan(a2, 2), 0, str.length() - 1, 33);
        }
        if (i8 != 0) {
            LiveFansLevelView liveFansLevelView = new LiveFansLevelView(this.e);
            liveFansLevelView.setFansLevel(d);
            int a3 = AppMethods.a(54.5f);
            int a4 = AppMethods.a(15.0f);
            try {
                liveFansLevelView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                int measuredWidth = liveFansLevelView.getMeasuredWidth();
                int measuredHeight = liveFansLevelView.getMeasuredHeight();
                liveFansLevelView.layout(0, 0, measuredWidth, measuredHeight);
                createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
                a3 = measuredWidth;
                a4 = measuredHeight;
                liveFansLevelView.draw(new Canvas(createBitmap));
                a3 = measuredWidth;
                a4 = measuredHeight;
            } catch (Exception e) {
                createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(textView.getResources(), createBitmap);
            bitmapDrawable.setBounds(0, a, a3, a4 + a);
            spannableStringBuilder.setSpan(new VerticalCenterImageSpan(bitmapDrawable, 2), str.length(), (str.length() + str2.length()) - 1, 33);
        }
        if (c != 0) {
            Drawable a5 = LiveBitmapUtils.a(AppInfo.d(), c);
            if (c >= 30) {
                a5.setBounds(0, a, AppMethods.a(44), AppMethods.a(15) + a);
            } else {
                a5.setBounds(0, a, AppMethods.a(30), AppMethods.a(15) + a);
            }
            spannableStringBuilder.setSpan(new VerticalCenterImageSpan(a5, 2), str2.length() + str.length(), ((str2.length() + str.length()) + str3.length()) - 1, 33);
        }
        if (!TextUtils.isEmpty(str4) && c2 != null && !TextUtils.isEmpty(c2.getChat_badge_url())) {
            BitmapDrawable bitmapDrawable2 = new BitmapDrawable();
            int a6 = AppMethods.a(15);
            if (c2.getChat_badge_length().intValue() == 0 || c2.getChat_badge_height().intValue() == 0) {
                a6 = 0;
                i5 = 0;
            } else {
                i5 = (c2.getChat_badge_length().intValue() * a6) / c2.getChat_badge_height().intValue();
            }
            bitmapDrawable2.setBounds(0, a, i5, a6 + a);
            final int length2 = str2.length() + str.length() + str3.length();
            final int length3 = (str4.length() + length2) - 1;
            if (length2 < spannableStringBuilder.length() && length3 < spannableStringBuilder.length()) {
                spannableStringBuilder.setSpan(new VerticalCenterImageSpan(bitmapDrawable2, 2), length2, length3, 33);
                final int i11 = i5;
                final int i12 = a6;
                LiveMemoryBitmapCache.a().a(this.e, c2.getChat_badge_url(), DensityUtils.a(this.e, i5), 0, new LiveMemoryBitmapCache.BitmapCallback() { // from class: com.blued.android.module.live_china.liveForMsg.data.-$$Lambda$LiveMsgContentAdapter$iT_qAoyNjxKIP2ly9Afs1ahm0CM
                    @Override // com.blued.android.module.live_china.utils.LiveMemoryBitmapCache.BitmapCallback
                    public final void onBitmapCreate(String str7, Bitmap bitmap) {
                        LiveMsgContentAdapter.e(a, i11, i12, spannableStringBuilder, length2, length3, textView, str7, bitmap);
                    }
                });
            }
        }
        spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.blued.android.module.live_china.liveForMsg.data.LiveMsgContentAdapter.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view3) {
                Selection.removeSelection((Spannable) ((TextView) view3).getText());
                LiveMsgContentAdapter.this.i(liveChattingModel);
            }
        }, i3, i4, 33);
        spannableStringBuilder.setSpan(new CharacterStyle() { // from class: com.blued.android.module.live_china.liveForMsg.data.LiveMsgContentAdapter.6
            @Override // android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(AppInfo.d().getResources().getColor(R.color.biao_live_msg_name_0));
                textPaint.setUnderlineText(false);
                textPaint.clearShadowLayer();
            }
        }, i3, i4 + str5.length() + 1, 33);
        a(textView, spannableStringBuilder, i4, str5, "gift ");
        textView.setMovementMethod(LinkMovementClickMethod.a());
        textView.setText(spannableStringBuilder);
        s(liveChattingModel, view2);
        q(liveChattingModel, view);
    }

    private void b(LiveChattingModel liveChattingModel, TextView textView) {
        textView.setText(LiveUtils.a((CharSequence) new SpannableString((String) liveChattingModel.msgMapExtra.get(c.b)), "#FFD228", false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(LiveWishContestContentModel liveWishContestContentModel, View view) {
        if (TextUtils.isEmpty(liveWishContestContentModel.url)) {
            return;
        }
        TextView textView = (TextView) view;
        if (textView.getSelectionStart() == -1 && textView.getSelectionEnd() == -1) {
            LiveEventBusUtil.b(liveWishContestContentModel.url);
        }
    }

    private int c() {
        if (this.i == 0) {
            this.i = DisplayUtil.a(AppInfo.d(), 12.0f);
        }
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(int i, int i2, int i3, SpannableStringBuilder spannableStringBuilder, int i4, int i5, TextView textView, String str, Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        bitmapDrawable.setBounds(0, i, i2, i3 + i);
        spannableStringBuilder.setSpan(new VerticalCenterImageSpan(bitmapDrawable, 2), i4, i5, 33);
        textView.setText(spannableStringBuilder);
    }

    private void c(LiveChattingModel liveChattingModel, View view) {
        ((TextView) view.findViewById(R.id.live_msg_content_text)).setText(liveChattingModel.msgContent);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.liveForMsg.data.LiveMsgContentAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                if (LiveMsgContentAdapter.this.d != null) {
                    if (LiveMsgContentAdapter.this.d.d instanceof RecordingOnliveFragment) {
                        EventTrackLive.a(LiveProtos.Event.LIVE_PK_WIN_ICON_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
                        ((RecordingOnliveFragment) LiveMsgContentAdapter.this.d.d).d(LiveRoomInfo.a().G(), 0);
                    } else if (LiveMsgContentAdapter.this.d.d instanceof PlayingOnliveBaseModeFragment) {
                        EventTrackLive.a(LiveProtos.Event.LIVE_PK_WIN_ICON_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
                        LiveRefreshUIObserver.a().b(LiveRoomInfo.a().G(), 0);
                    }
                }
            }
        });
    }

    private void c(LiveChattingModel liveChattingModel, View view, View view2) {
        TextView textView = (TextView) view2.findViewById(R.id.live_msg_content_text);
        if (!TextUtils.isEmpty(liveChattingModel.msgContent)) {
            textView.setText(liveChattingModel.msgContent);
        }
        u(liveChattingModel, view2);
        s(liveChattingModel, view2);
        q(liveChattingModel, view);
    }

    public static LiveFansLevelModel d(LiveChattingModel liveChattingModel) {
        LiveFansLevelModel liveFansLevelModel = new LiveFansLevelModel();
        if ((liveChattingModel.fromId + "").equals(LiveRoomInfo.a().f())) {
            LiveFansInfoModel q = LiveRoomManager.a().q();
            if (q != null) {
                liveFansLevelModel.fan_club_name = q.name;
                liveFansLevelModel.fan_club_level = q.level;
                liveFansLevelModel.in_fan_club = q.fans_status;
                liveFansLevelModel.fans_status = q.fans_status;
                return liveFansLevelModel;
            }
        } else if (liveChattingModel.msgMapExtra != null) {
            liveFansLevelModel.fan_club_name = MsgPackHelper.getStringValue(liveChattingModel.msgMapExtra, "fan_club_name");
            liveFansLevelModel.fan_club_level = MsgPackHelper.getIntValue(liveChattingModel.msgMapExtra, "fan_club_level");
            liveFansLevelModel.in_fan_club = MsgPackHelper.getIntValue(liveChattingModel.msgMapExtra, "in_fan_club");
            liveFansLevelModel.fans_status = MsgPackHelper.getIntValue(liveChattingModel.msgMapExtra, "fans_status");
            Log.i("xpp", "from map fan_club_info:" + liveFansLevelModel.fan_club_name + " : " + liveFansLevelModel.fan_club_level + "  : " + liveFansLevelModel.in_fan_club + " : " + liveFansLevelModel.fans_status);
            return liveFansLevelModel;
        } else {
            Gson f = AppInfo.f();
            LiveFansLevelModel liveFansLevelModel2 = null;
            try {
                if (!TextUtils.isEmpty(liveChattingModel.getMsgExtra())) {
                    liveFansLevelModel2 = (LiveFansLevelModel) f.fromJson(liveChattingModel.getMsgExtra(), LiveFansLevelModel.class);
                }
            } catch (Exception e) {
                e.printStackTrace();
                liveFansLevelModel2 = null;
            }
            if (liveFansLevelModel2 != null) {
                liveFansLevelModel.fan_club_name = liveFansLevelModel2.fan_club_name;
                liveFansLevelModel.fan_club_level = liveFansLevelModel2.fan_club_level;
                liveFansLevelModel.in_fan_club = liveFansLevelModel2.in_fan_club;
                liveFansLevelModel.fans_status = liveFansLevelModel2.fans_status;
            }
            Log.i("xpp", "from gson fan_club_info:" + liveFansLevelModel.fan_club_name + " : " + liveFansLevelModel.fan_club_level + "  : " + liveFansLevelModel.in_fan_club + " : " + liveFansLevelModel.fans_status);
        }
        return liveFansLevelModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(int i, int i2, int i3, SpannableStringBuilder spannableStringBuilder, int i4, int i5, TextView textView, String str, Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        bitmapDrawable.setBounds(0, i, i2, i3 + i);
        spannableStringBuilder.setSpan(new VerticalCenterImageSpan(bitmapDrawable, 2), i4, i5, 33);
        textView.setText(spannableStringBuilder);
    }

    private void d(final LiveChattingModel liveChattingModel, View view) {
        TextView textView = (TextView) view.findViewById(R.id.live_msg_content_text);
        final int i = (int) liveChattingModel.fromId;
        String str = liveChattingModel.fromNickName;
        String format = String.format(AppInfo.d().getResources().getString(R.string.live_pk_dared_egg_msg), str, (String) liveChattingModel.msgMapExtra.get("propName"));
        liveChattingModel.msgContent = format;
        liveChattingModel.msgTimestamp = System.currentTimeMillis();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
        spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.blued.android.module.live_china.liveForMsg.data.LiveMsgContentAdapter.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view2) {
                if (i <= 0) {
                    return;
                }
                LiveMsgContentAdapter.this.i(liveChattingModel);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(AppInfo.d().getResources().getColor(R.color.syc_dark_FFD228));
                textPaint.setUnderlineText(false);
                textPaint.clearShadowLayer();
            }
        }, 3, str.length() + 3, 33);
        textView.setMovementMethod(LinkMovementClickMethod.a());
        textView.setText(spannableStringBuilder);
    }

    private void d(LiveChattingModel liveChattingModel, View view, View view2) {
        TextView textView = (TextView) view2.findViewById(R.id.live_msg_content_text);
        if (!TextUtils.isEmpty(liveChattingModel.msgContent)) {
            textView.setText(liveChattingModel.msgContent);
        }
        textView.setTextColor(this.e.getResources().getColor(R.color.syc_dark_d0d0d0));
        u(liveChattingModel, view2);
        s(liveChattingModel, view2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(int i, int i2, int i3, SpannableStringBuilder spannableStringBuilder, int i4, int i5, TextView textView, String str, Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        bitmapDrawable.setBounds(0, i, i2, i3 + i);
        spannableStringBuilder.setSpan(new VerticalCenterImageSpan(bitmapDrawable, 2), i4, i5, 33);
        textView.setText(spannableStringBuilder);
    }

    private void e(LiveChattingModel liveChattingModel, View view) {
        View findViewById = view.findViewById(R.id.live_msg_info_root);
        ImageView imageView = (ImageView) view.findViewById(R.id.live_msg_content_icon);
        TextView textView = (TextView) view.findViewById(R.id.live_msg_content_text);
        if (findViewById != null && liveChattingModel.msgMapExtra != null) {
            final String str = (String) liveChattingModel.msgMapExtra.get("link_url");
            final boolean booleanValue = ((Boolean) liveChattingModel.msgMapExtra.get("link_half_open")).booleanValue();
            if (TextUtils.isEmpty(str)) {
                findViewById.setClickable(false);
            } else {
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.liveForMsg.data.-$$Lambda$LiveMsgContentAdapter$pgl4JvlBg7f2khppQIfg9SHrRUM
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        LiveMsgContentAdapter.this.a(booleanValue, str, view2);
                    }
                });
            }
        }
        if (imageView != null) {
            imageView.setImageResource(R.drawable.live_chicken);
        }
        if (TextUtils.isEmpty((String) liveChattingModel.msgMapExtra.get(c.b))) {
            a(liveChattingModel, textView);
        } else {
            b(liveChattingModel, textView);
        }
    }

    private void e(LiveChattingModel liveChattingModel, View view, View view2) {
        TextView textView = (TextView) view2.findViewById(R.id.live_msg_content_text);
        if (!TextUtils.isEmpty(liveChattingModel.msgContent)) {
            textView.setText(liveChattingModel.msgContent);
        }
        q(liveChattingModel, view);
    }

    private void f(LiveChattingModel liveChattingModel, View view) {
        liveChattingModel.msgContent = this.e.getResources().getString(R.string.live_send_a_like);
        u(liveChattingModel, view);
    }

    private void f(final LiveChattingModel liveChattingModel, View view, View view2) {
        final LiveWishContestContentModel liveWishContestContentModel;
        String str;
        String str2;
        String str3;
        if ((liveChattingModel instanceof LiveChattingModel) && (liveWishContestContentModel = (LiveWishContestContentModel) LiveChattingModel.copy(liveChattingModel).getObjExtra()) != null) {
            final TextView textView = (TextView) view2.findViewById(R.id.live_msg_content_text);
            textView.setTextColor(Color.parseColor("#52EDFF"));
            if (liveWishContestContentModel.event == 1) {
                String str4 = "";
                if (liveWishContestContentModel.msg_event_type == 1) {
                    str = liveWishContestContentModel.anchorName;
                    str4 = liveWishContestContentModel.beans + " 赠豆";
                    str3 = "星之许愿池：恭喜 " + str + " 直播间诞生了许愿争夺战最终擂主，主播获得 " + str4;
                    str2 = "";
                } else {
                    String a = LiveCloakingUtil.a(liveWishContestContentModel.userName, liveWishContestContentModel.isHide);
                    str = a;
                    if (TextUtils.isEmpty(a)) {
                        str = liveWishContestContentModel.userName;
                    }
                    if (liveWishContestContentModel.giftCount > 1) {
                        str2 = " X" + liveWishContestContentModel.giftCount;
                    } else {
                        str2 = "";
                    }
                    str3 = "星之许愿池：恭喜 " + str + " 夺取了本轮许愿争夺战的胜利，获得" + liveWishContestContentModel.giftName + " gift " + str2;
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str3);
                int indexOf = str3.indexOf(str);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f), indexOf, str.length() + indexOf, 33);
                spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.blued.android.module.live_china.liveForMsg.data.LiveMsgContentAdapter.13
                    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
                    @Override // android.text.style.ClickableSpan
                    public void onClick(View view3) {
                        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        textPaint.setColor(LiveMsgContentAdapter.this.f);
                        textPaint.setUnderlineText(false);
                    }
                }, indexOf, str.length() + indexOf, 33);
                if (!TextUtils.isEmpty(str4)) {
                    int indexOf2 = str3.indexOf(str4);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f), indexOf2, str4.length() + indexOf2, 33);
                }
                if (!TextUtils.isEmpty(str2)) {
                    int indexOf3 = str3.indexOf(str2);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f), indexOf3, str2.length() + indexOf3, 33);
                }
                if (liveWishContestContentModel.msg_event_type == 0) {
                    a(textView, spannableStringBuilder, liveWishContestContentModel.giftImage, str3.indexOf("gift "), 5);
                }
                textView.setMovementMethod(LinkMovementClickMethod.a());
                textView.setText(spannableStringBuilder);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.liveForMsg.data.-$$Lambda$LiveMsgContentAdapter$iNMAs7vXOVSmRraSQaQMzoxOL_A
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        LiveMsgContentAdapter.b(LiveWishContestContentModel.this, view3);
                    }
                });
            } else {
                textView.setText("星之许愿池：已开启许愿争夺战，成为擂主并保持到倒计时结束，可以获得最终奖励");
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.liveForMsg.data.-$$Lambda$LiveMsgContentAdapter$kemScz9zdyCJZoe0yRpQ61WQYco
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        LiveMsgContentAdapter.a(LiveWishContestContentModel.this, view3);
                    }
                });
            }
            s(liveChattingModel, view2);
        }
    }

    private View g(LiveChattingModel liveChattingModel) {
        String str = (liveChattingModel.msgMapExtra == null || !liveChattingModel.msgMapExtra.containsKey("guideType")) ? "" : (String) liveChattingModel.msgMapExtra.get("guideType");
        if (TextUtils.isEmpty(str)) {
            return this.b.inflate(R.layout.item_live_msg_content_default, (ViewGroup) null);
        }
        boolean z = true;
        int hashCode = str.hashCode();
        if (hashCode != 47571) {
            if (hashCode != 48532) {
                switch (hashCode) {
                    case 49494:
                        if (str.equals(LiveGuideType.GUIDE_TYPE_FIRST_RECHARGE)) {
                            z = true;
                            break;
                        }
                        break;
                    case 49495:
                        if (str.equals(LiveGuideType.GUIDE_TYPE_BEG_GIFT)) {
                            z = true;
                            break;
                        }
                        break;
                    case 49496:
                        if (str.equals(LiveGuideType.GUIDE_TYPE_JOIN_FANS_GROUP)) {
                            z = true;
                            break;
                        }
                        break;
                    case 49497:
                        if (str.equals(LiveGuideType.GUIDE_TYPE_JOIN_FANS)) {
                            z = true;
                            break;
                        }
                        break;
                }
            } else if (str.equals(LiveGuideType.GUIDE_TYPE_MARKETING_CAMPAIGN_NOTICE)) {
                z = true;
            }
        } else if (str.equals(LiveGuideType.GUIDE_TYPE_OFFICIAL_SAFETY_NOTICE)) {
            z = false;
        }
        return z ? !z ? (z || z || z || z) ? this.b.inflate(R.layout.item_live_msg_content_chat, (ViewGroup) null) : this.b.inflate(R.layout.item_live_msg_content_default, (ViewGroup) null) : this.b.inflate(R.layout.fitem_live_msg_marketing_campaign_notice, (ViewGroup) null) : this.b.inflate(R.layout.fitem_live_msg_official_safety_notice, (ViewGroup) null);
    }

    private void g(LiveChattingModel liveChattingModel, View view) {
        TextView textView = (TextView) view.findViewById(R.id.live_msg_content_text);
        long j = liveChattingModel.fromId;
        String str = liveChattingModel.fromNickName;
        Map mapValue = MsgPackHelper.getMapValue(liveChattingModel.msgMapExtra, "mute_profile");
        long longValue = MsgPackHelper.getLongValue(mapValue, "uid");
        String stringValue = MsgPackHelper.getStringValue(mapValue, "name");
        SpannableStringBuilder a = a(textView, liveChattingModel, String.format(this.e.getString(R.string.live_released_to_speak), CommonStringUtils.a(str, String.valueOf(j)), CommonStringUtils.a(stringValue, String.valueOf(longValue))));
        Logger.a("rrb", "spannableString = ", a);
        CharSequence a2 = a(textView, a);
        Logger.a("rrb", "charSequence = ", a2);
        textView.setText(a2);
    }

    private void g(final LiveChattingModel liveChattingModel, View view, View view2) {
        LiveGiftModel liveGiftModel;
        String str;
        if (liveChattingModel instanceof LiveChattingModel) {
            String a = LiveCloakingUtil.a(liveChattingModel.fromNickName, liveChattingModel.fromPrivilege);
            if (TextUtils.isEmpty(a) || (liveGiftModel = (LiveGiftModel) LiveChattingModel.copy(liveChattingModel).getObjExtra()) == null) {
                return;
            }
            TextView textView = (TextView) view2.findViewById(R.id.live_msg_content_text);
            textView.setTextColor(Color.parseColor("#52EDFF"));
            if (liveGiftModel.getDisplayCount() > 1) {
                str = " X" + liveGiftModel.getDisplayCount();
            } else {
                str = "";
            }
            String str2 = "恭喜 " + a + " 在" + liveGiftModel.source + liveGiftModel.sourceEvent + "获得 " + liveGiftModel.name + " gift " + str;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f), 3, a.length() + 3, 33);
            if (liveGiftModel.getDisplayCount() > 1) {
                int indexOf = str2.indexOf(str);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f), indexOf, str.length() + indexOf, 33);
            }
            a(textView, spannableStringBuilder, liveGiftModel.images_static, str2.indexOf("gift "), 5);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.liveForMsg.data.-$$Lambda$LiveMsgContentAdapter$VFiwUFR75HK5GGqxpSiAqf5SicY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    LiveMsgContentAdapter.this.v(liveChattingModel, view3);
                }
            });
            textView.setText(spannableStringBuilder);
            view2.setBackgroundResource(R.drawable.shape_gradient_live_msg_win_prize_bg);
            s(liveChattingModel, view2);
        }
    }

    private void h(LiveChattingModel liveChattingModel) {
        if ((liveChattingModel.fromId + "").equals(LiveRoomInfo.a().f())) {
            if (LiveFloatManager.a().w()) {
                liveChattingModel.fromLiveManager = 1;
            } else {
                liveChattingModel.fromLiveManager = 0;
            }
        }
    }

    private void h(LiveChattingModel liveChattingModel, View view) {
        TextView textView = (TextView) view.findViewById(R.id.live_msg_content_text);
        long j = liveChattingModel.fromId;
        String str = liveChattingModel.fromNickName;
        Map mapValue = MsgPackHelper.getMapValue(liveChattingModel.msgMapExtra, "mute_profile");
        long longValue = MsgPackHelper.getLongValue(mapValue, "uid");
        String stringValue = MsgPackHelper.getStringValue(mapValue, "name");
        textView.setText(a(textView, a(textView, liveChattingModel, String.format(this.e.getString(R.string.live_forbade_to_speak), CommonStringUtils.a(str, String.valueOf(j)), CommonStringUtils.a(stringValue, String.valueOf(longValue))))));
    }

    private void h(final LiveChattingModel liveChattingModel, View view, View view2) {
        LiveGiftModel a = LiveUtils.a(liveChattingModel);
        if (a == null) {
            return;
        }
        TextView textView = (TextView) view2.findViewById(R.id.live_msg_content_text);
        if (a.is_luck_bag) {
            a(textView, liveChattingModel);
        } else {
            a(textView, liveChattingModel, new ClickMsgTalkerListener() { // from class: com.blued.android.module.live_china.liveForMsg.data.-$$Lambda$LiveMsgContentAdapter$VvJtLWLHffSPmjP4fw-JBCCB-Ug
                @Override // com.blued.android.module.live_china.liveForMsg.ClickMsgTalkerListener
                public final void onClickMsgTalkerListener() {
                    LiveMsgContentAdapter.this.i(liveChattingModel);
                }
            });
        }
        s(liveChattingModel, view2);
        q(liveChattingModel, view);
    }

    private void i(LiveChattingModel liveChattingModel, View view) {
        TextView textView = (TextView) view.findViewById(R.id.live_msg_content_text);
        String format = String.format(this.e.getString(R.string.live_removed_your_manager), CommonStringUtils.a(liveChattingModel.fromNickName, String.valueOf(liveChattingModel.fromId)));
        textView.setTextColor(Color.parseColor("#ffd452"));
        textView.setText(a(textView, format));
    }

    private void j(LiveChattingModel liveChattingModel, View view) {
        TextView textView = (TextView) view.findViewById(R.id.live_msg_content_text);
        String format = String.format(this.e.getString(R.string.live_on_being_manager), CommonStringUtils.a(liveChattingModel.fromNickName, String.valueOf(liveChattingModel.fromId)));
        textView.setTextColor(Color.parseColor("#ffd452"));
        textView.setText(a(textView, format));
    }

    private void k(final LiveChattingModel liveChattingModel, View view) {
        String format;
        TextView textView = (TextView) view.findViewById(R.id.live_msg_content_text);
        String string = this.e.getString(R.string.live_chat_congratulations);
        String a = CommonStringUtils.a(liveChattingModel.fromNickName, String.valueOf(liveChattingModel.fromId));
        if (liveChattingModel.fromRichLevel == 30) {
            format = String.format(this.e.getString(R.string.live_chat_upgrade), "神壕1级");
        } else if (liveChattingModel.fromRichLevel == 31) {
            format = String.format(this.e.getString(R.string.live_chat_upgrade), "神壕2级");
        } else if (liveChattingModel.fromRichLevel == 32) {
            format = String.format(this.e.getString(R.string.live_chat_upgrade), "神壕3级");
        } else if (liveChattingModel.fromRichLevel == 33) {
            format = String.format(this.e.getString(R.string.live_chat_upgrade), "神壕4级");
        } else if (liveChattingModel.fromRichLevel == 34) {
            format = String.format(this.e.getString(R.string.live_chat_upgrade), "神壕5级");
        } else if (liveChattingModel.fromRichLevel == 35) {
            format = "财富等级升为【神壕6级】，获赠1,588,888弯豆";
        } else {
            String string2 = this.e.getString(R.string.live_chat_upgrade);
            format = String.format(string2, liveChattingModel.fromRichLevel + "");
        }
        textView.setText(a(textView, string + a + format));
        view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.liveForMsg.data.LiveMsgContentAdapter.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                LiveMsgContentAdapter.this.i(liveChattingModel);
            }
        });
    }

    private void l(final LiveChattingModel liveChattingModel, View view) {
        TextView textView = (TextView) view.findViewById(R.id.live_msg_content_text);
        String string = this.e.getString(R.string.live_chat_congratulations);
        String a = CommonStringUtils.a(liveChattingModel.fromNickName, String.valueOf(liveChattingModel.fromId));
        int intValue = MsgPackHelper.getIntValue(liveChattingModel.msgMapExtra, "level");
        String string2 = this.e.getString(R.string.live_record_level_msg);
        String format = String.format(string2, intValue + "");
        textView.setText(a(textView, string + a + format));
        view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.liveForMsg.data.LiveMsgContentAdapter.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                LiveMsgContentAdapter.this.i(liveChattingModel);
            }
        });
    }

    private void m(final LiveChattingModel liveChattingModel, View view) {
        ((TextView) view.findViewById(R.id.live_msg_content_text)).setText(liveChattingModel.msgContent);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.liveForMsg.data.LiveMsgContentAdapter.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                LiveSetDataObserver.a().j();
                if (TextUtils.equals(liveChattingModel.msgContent, AppInfo.d().getString(R.string.live_say_hello))) {
                    EventTrackLive.a(LiveProtos.Event.LIVE_SUPPORT_ANCHOR_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
                } else {
                    InstantLog.a("live_chat_guide_click");
                }
                EventTrackLive.a(LiveProtos.Event.LIVE_MSG_GUIDE_CHAT_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            }
        });
    }

    private void n(final LiveChattingModel liveChattingModel, final View view) {
        Logger.a("rrb", "setAttentionRemind");
        if (liveChattingModel.liveChatListFollowed) {
            view.setEnabled(false);
        } else {
            view.setEnabled(true);
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.liveForMsg.data.LiveMsgContentAdapter.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                view.setEnabled(false);
                LiveSetDataObserver.a().l();
                if (LiveRoomManager.a().p() != null) {
                    EventTrackLive.a(LiveProtos.Event.LIVE_FOLLOW_GUIDE_CLICK, String.valueOf(LiveRoomManager.a().d()), LiveRoomManager.a().g());
                }
                InstantLog.a("live_follow_guide_click");
                LiveMsgContentAdapter.this.a.remove(liveChattingModel);
                LiveMsgContentAdapter.this.notifyDataSetChanged();
                EventTrackLive.a(LiveProtos.Event.LIVE_MSG_GUIDE_FOLLOW_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            }
        });
    }

    private void o(final LiveChattingModel liveChattingModel, View view) {
        if (view == null) {
            return;
        }
        String str = (liveChattingModel.msgMapExtra == null || !liveChattingModel.msgMapExtra.containsKey("guideType")) ? "" : (String) liveChattingModel.msgMapExtra.get("guideType");
        TextView textView = (TextView) view.findViewById(R.id.live_msg_content_text);
        if (textView == null) {
            return;
        }
        textView.setText(liveChattingModel.msgContent);
        boolean z = true;
        int hashCode = str.hashCode();
        if (hashCode != 47571) {
            if (hashCode != 48532) {
                switch (hashCode) {
                    case 49494:
                        if (str.equals(LiveGuideType.GUIDE_TYPE_FIRST_RECHARGE)) {
                            z = true;
                            break;
                        }
                        break;
                    case 49495:
                        if (str.equals(LiveGuideType.GUIDE_TYPE_BEG_GIFT)) {
                            z = true;
                            break;
                        }
                        break;
                    case 49496:
                        if (str.equals(LiveGuideType.GUIDE_TYPE_JOIN_FANS_GROUP)) {
                            z = true;
                            break;
                        }
                        break;
                    case 49497:
                        if (str.equals(LiveGuideType.GUIDE_TYPE_JOIN_FANS)) {
                            z = true;
                            break;
                        }
                        break;
                }
            } else if (str.equals(LiveGuideType.GUIDE_TYPE_MARKETING_CAMPAIGN_NOTICE)) {
                z = true;
            }
        } else if (str.equals(LiveGuideType.GUIDE_TYPE_OFFICIAL_SAFETY_NOTICE)) {
            z = false;
        }
        if (z) {
            String str2 = (String) liveChattingModel.msgMapExtra.get("url");
            View findViewById = view.findViewById(R.id.live_msg_content_arrow);
            if (findViewById != null) {
                if (TextUtils.isEmpty(str2)) {
                    findViewById.setVisibility(8);
                    view.setClickable(false);
                    return;
                }
                findViewById.setVisibility(0);
            }
            EventTrackLive.m(LiveProtos.Event.LIVE_SCREEN_ACTIVITY_NOTICE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), str2);
        } else if (z) {
            EventTrackLive.o(LiveProtos.Event.LIVE_SCREEN_GUIDE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), "recharge");
        } else if (z) {
            EventTrackLive.o(LiveProtos.Event.LIVE_SCREEN_GUIDE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), "present");
        } else if (z) {
            EventTrackLive.o(LiveProtos.Event.LIVE_SCREEN_GUIDE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), "fans_club");
        } else if (z) {
            EventTrackLive.o(LiveProtos.Event.LIVE_SCREEN_GUIDE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), "fans_group");
            EventTrackLive.a(LiveProtos.Event.LIVE_FANS_GROUP_GUIDE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        }
        final String str3 = str;
        view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.liveForMsg.data.-$$Lambda$LiveMsgContentAdapter$Rc9Cyk9Tiu5akmqAyzuKoH5zYCA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LiveMsgContentAdapter.this.a(str3, liveChattingModel, view2);
            }
        });
    }

    private void p(final LiveChattingModel liveChattingModel, View view) {
        TextView textView = (TextView) view.findViewById(R.id.live_msg_content_text);
        if (!TextUtils.isEmpty(liveChattingModel.msgContent)) {
            textView.setText(liveChattingModel.msgContent);
        }
        TextView textView2 = (TextView) view.findViewById(R.id.live_msg_content_nickname);
        if (textView2 == null || TextUtils.isEmpty(liveChattingModel.fromNickName)) {
            return;
        }
        textView2.setText(new SpannableStringBuilder(LiveCloakingUtil.a(liveChattingModel.fromNickName, liveChattingModel.fromPrivilege)));
        view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.liveForMsg.data.LiveMsgContentAdapter.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                LiveMsgContentAdapter.this.i(liveChattingModel);
            }
        });
    }

    private void q(LiveChattingModel liveChattingModel, View view) {
        if (LiveRoomManager.a().A()) {
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.live_msg_light);
        if (liveChattingModel == null || imageView == null) {
            return;
        }
        if (liveChattingModel.msgMapExtra == null) {
            liveChattingModel.msgMapExtra = new HashMap();
        }
        if (liveChattingModel.msgMapExtra.containsKey("convertView")) {
            return;
        }
        if (this.g || c(liveChattingModel) < 34) {
            liveChattingModel.msgMapExtra.put("convertView", null);
            return;
        }
        liveChattingModel.msgMapExtra.put("convertView", view);
        this.g = true;
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0.0f, 0, AppInfo.l, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(2000L);
        translateAnimation.setFillAfter(true);
        translateAnimation.setFillBefore(true);
        translateAnimation.setRepeatMode(1);
        translateAnimation.setRepeatCount(1);
        imageView.startAnimation(translateAnimation);
        imageView.setVisibility(0);
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.liveForMsg.data.LiveMsgContentAdapter.12
            @Override // java.lang.Runnable
            public void run() {
                try {
                    LiveMsgContentAdapter.this.g = false;
                    for (LiveChattingModel liveChattingModel2 : LiveMsgContentAdapter.this.a()) {
                        if (liveChattingModel2.msgMapExtra != null) {
                            liveChattingModel2.msgMapExtra.put("convertView", null);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 2000L);
    }

    private void r(LiveChattingModel liveChattingModel, View view) {
        TextView textView = (TextView) view.findViewById(R.id.live_msg_content_text);
        if (!TextUtils.isEmpty(liveChattingModel.msgContent)) {
            textView.setText(liveChattingModel.msgContent);
        }
        u(liveChattingModel, view);
    }

    private void s(LiveChattingModel liveChattingModel, View view) {
        LiveBubbleBgModel liveBubbleBgModel;
        LiveWishContestContentModel liveWishContestContentModel;
        LiveGiftModel liveGiftModel;
        int c = c(liveChattingModel);
        if (!(view instanceof LiveMsgBgFrameLayout)) {
            if (c >= 0 && c <= 15) {
                view.setBackgroundResource(R.drawable.shape_round_live_msg_item_bg);
            } else if (c >= 16 && c <= 20) {
                view.setBackgroundResource(R.drawable.shape_gradient_name_level_yellow);
            } else if (c >= 21 && c <= 25) {
                view.setBackgroundResource(R.drawable.shape_gradient_name_level_orange);
            } else if (c >= 26 && c < 30) {
                view.setBackgroundResource(R.drawable.shape_gradient_name_level_red);
            } else if (c == 30) {
                view.setBackgroundResource(R.drawable.shape_gradient_name_level_30);
            } else if (c == 31) {
                view.setBackgroundResource(R.drawable.shape_gradient_name_level_31);
            } else if (c == 32) {
                view.setBackgroundResource(R.drawable.shape_gradient_name_level_32);
            } else if (c == 33) {
                view.setBackgroundResource(R.drawable.shape_gradient_name_level_33);
            } else if (c == 34) {
                view.setBackgroundResource(R.drawable.shape_gradient_name_level_34);
            } else if (c == 35) {
                view.setBackgroundResource(R.drawable.shape_gradient_name_level_35);
            }
            liveBubbleBgModel = null;
        } else if (liveChattingModel.msgType == 221) {
            LiveGiftScrawlTransModel liveGiftScrawlTransModel = liveChattingModel instanceof LiveChattingModel ? (LiveGiftScrawlTransModel) LiveChattingModel.copy(liveChattingModel).getObjExtra() : null;
            if (liveGiftScrawlTransModel != null && (liveGiftScrawlTransModel.extraModel instanceof LiveBubbleBgModel)) {
                liveBubbleBgModel = (LiveBubbleBgModel) liveGiftScrawlTransModel.extraModel;
                ((LiveMsgBgFrameLayout) view).a(liveBubbleBgModel, c);
            }
            liveBubbleBgModel = null;
            ((LiveMsgBgFrameLayout) view).a(liveBubbleBgModel, c);
        } else if (liveChattingModel.msgType == 33 && liveChattingModel.msgMapExtra != null) {
            LiveGiftModel liveGiftModel2 = (LiveGiftModel) liveChattingModel.msgMapExtra.get("gift_model");
            if (liveGiftModel2 != null && (liveGiftModel2.extraModel instanceof LiveBubbleBgModel)) {
                liveBubbleBgModel = (LiveBubbleBgModel) liveGiftModel2.extraModel;
                ((LiveMsgBgFrameLayout) view).a(liveBubbleBgModel, c);
            }
            liveBubbleBgModel = null;
            ((LiveMsgBgFrameLayout) view).a(liveBubbleBgModel, c);
        } else if (liveChattingModel.msgType == 245) {
            if ((liveChattingModel instanceof LiveChattingModel) && (liveGiftModel = (LiveGiftModel) LiveChattingModel.copy(liveChattingModel).getObjExtra()) != null && (liveGiftModel.extraModel instanceof LiveBubbleBgModel)) {
                liveBubbleBgModel = (LiveBubbleBgModel) liveGiftModel.extraModel;
                ((LiveMsgBgFrameLayout) view).a(liveBubbleBgModel, c);
            }
            liveBubbleBgModel = null;
            ((LiveMsgBgFrameLayout) view).a(liveBubbleBgModel, c);
        } else if (liveChattingModel.msgType == 251) {
            if ((liveChattingModel instanceof LiveChattingModel) && (liveWishContestContentModel = (LiveWishContestContentModel) LiveChattingModel.copy(liveChattingModel).getObjExtra()) != null) {
                liveBubbleBgModel = liveWishContestContentModel.bubbleBgModel;
                ((LiveMsgBgFrameLayout) view).a(liveBubbleBgModel, c);
            }
            liveBubbleBgModel = null;
            ((LiveMsgBgFrameLayout) view).a(liveBubbleBgModel, c);
        } else {
            if (liveChattingModel.msgType == 1 && liveChattingModel.msgMapExtra != null) {
                liveBubbleBgModel = (LiveBubbleBgModel) liveChattingModel.msgMapExtra.get("live_chat_frame_model");
                ((LiveMsgBgFrameLayout) view).a(liveBubbleBgModel, c);
            }
            liveBubbleBgModel = null;
            ((LiveMsgBgFrameLayout) view).a(liveBubbleBgModel, c);
        }
        ImageView imageView = (ImageView) ((View) view.getParent()).findViewById(R.id.live_msg_content_star);
        View findViewById = view.findViewById(R.id.live_msg_content_text);
        int paddingLeft = findViewById.getPaddingLeft();
        int paddingTop = findViewById.getPaddingTop();
        int paddingBottom = findViewById.getPaddingBottom();
        if (imageView != null) {
            if (liveBubbleBgModel != null && liveBubbleBgModel.chat_frame_icon_src > 0) {
                imageView.setVisibility(0);
                imageView.setImageResource(liveBubbleBgModel.chat_frame_icon_src);
                findViewById.setPadding(paddingLeft, paddingTop, b(), paddingBottom);
            } else if (liveBubbleBgModel != null && !TextUtils.isEmpty(liveBubbleBgModel.chat_frame_icon)) {
                imageView.setVisibility(0);
                ImageLoader.a((IRequestHost) null, liveBubbleBgModel.chat_frame_icon).a(imageView);
                findViewById.setPadding(paddingLeft, paddingTop, b(), paddingBottom);
            } else if (c < 30) {
                imageView.setVisibility(8);
                findViewById.setPadding(paddingLeft, paddingTop, c(), paddingBottom);
            } else {
                imageView.setVisibility(0);
                findViewById.setPadding(paddingLeft, paddingTop, b(), paddingBottom);
                if (c == 35 || c == 34) {
                    imageView.setImageResource(R.drawable.live_msg_list_star_emperor);
                } else {
                    imageView.setImageResource(R.drawable.live_msg_list_star);
                }
            }
        }
    }

    private void t(final LiveChattingModel liveChattingModel, View view) {
        MsgPackHelper.getLongValue(liveChattingModel.msgMapExtra, "id");
        int intValue = MsgPackHelper.getIntValue(liveChattingModel.msgMapExtra, SpamFilter.SpamContract.NotificationTable.COUNT);
        String stringValue = MsgPackHelper.getStringValue(liveChattingModel.msgMapExtra, "image");
        String stringValue2 = MsgPackHelper.getStringValue(liveChattingModel.msgMapExtra, "name");
        MsgPackHelper.getIntValue(liveChattingModel.msgMapExtra, "uid");
        TextView textView = (TextView) view.findViewById(R.id.live_msg_content_nickname);
        if (textView != null && !TextUtils.isEmpty(stringValue2)) {
            textView.setText(stringValue2);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.liveForMsg.data.LiveMsgContentAdapter.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    LiveMsgContentAdapter.this.i(liveChattingModel);
                }
            });
        }
        ImageLoader.a((IRequestHost) null, stringValue).d(R.drawable.live_msg_gift_default_bg).a((ImageView) view.findViewById(R.id.live_msg_content_get_icon));
        TextView textView2 = (TextView) view.findViewById(R.id.live_msg_content_get_num);
        textView2.setText(intValue + "");
    }

    private void u(final LiveChattingModel liveChattingModel, View view) {
        TextView textView = (TextView) view.findViewById(R.id.live_msg_content_text);
        h(liveChattingModel);
        if ((liveChattingModel.fromId + "").equals(Long.valueOf(LiveRoomManager.a().f()))) {
            textView.setMaxLines(Integer.MAX_VALUE);
        } else {
            textView.setMaxLines(3);
        }
        textView.setText(a(textView, liveChattingModel, new ClickMsgTalkerListener() { // from class: com.blued.android.module.live_china.liveForMsg.data.LiveMsgContentAdapter.26
            @Override // com.blued.android.module.live_china.liveForMsg.ClickMsgTalkerListener
            public void onClickMsgTalkerListener() {
                LiveMsgContentAdapter.this.i(liveChattingModel);
            }
        }, this.d.g));
        if (TextUtils.isEmpty(liveChattingModel.fromNickName)) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.liveForMsg.data.LiveMsgContentAdapter.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                LiveMsgContentAdapter.this.b(liveChattingModel);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(LiveChattingModel liveChattingModel, View view) {
        i(liveChattingModel);
    }

    public SpannableStringBuilder a(TextView textView, LiveChattingModel liveChattingModel, CharSequence charSequence) {
        int i = liveChattingModel.fromLiveManager;
        int c = c(liveChattingModel);
        String str = i != 0 ? "field_control " : "";
        String str2 = c != 0 ? "rich " : "";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + str2 + ((Object) charSequence));
        int a = AppMethods.a(1.0f);
        if (i != 0) {
            Drawable a2 = LiveBitmapUtils.a();
            a2.setBounds(0, a, AppMethods.a(29), AppMethods.a(15));
            spannableStringBuilder.setSpan(new VerticalCenterImageSpan(a2, 1), 0, str.length() - 1, 33);
        }
        if (c != 0) {
            Drawable a3 = LiveBitmapUtils.a(AppInfo.d(), c);
            if (c >= 30) {
                a3.setBounds(0, a, AppMethods.a(44), AppMethods.a(15) + a);
            } else {
                a3.setBounds(0, a, AppMethods.a(30), AppMethods.a(15) + a);
            }
            spannableStringBuilder.setSpan(new VerticalCenterImageSpan(a3, 1), str.length(), (str.length() + str2.length()) - 1, 33);
        }
        return spannableStringBuilder;
    }

    @Override // com.blued.android.module.live_china.adapter.BaseListAdapter
    public View a(int i, View view, ViewGroup viewGroup) {
        LiveChattingModel liveChattingModel = (LiveChattingModel) this.a.get(i);
        short s = liveChattingModel.msgType;
        View view2 = view;
        if (s == 1) {
            view2 = view;
            if (liveChattingModel.msgMapExtra != null) {
                view2 = view;
                if (liveChattingModel.msgMapExtra.containsKey("convertView")) {
                    view2 = (View) liveChattingModel.msgMapExtra.get("convertView");
                }
            }
        }
        View view3 = view2;
        if (view2 == null) {
            view3 = a(liveChattingModel, i);
        }
        View findViewById = view3.findViewById(R.id.live_msg_content_root);
        switch (s) {
            case -10005:
                d(liveChattingModel, findViewById);
                return view3;
            case -10004:
                o(liveChattingModel, findViewById);
                return view3;
            case -10003:
            case g.k /* -10002 */:
                e(liveChattingModel, view3, findViewById);
                return view3;
            case g.j /* -10001 */:
                b(liveChattingModel, findViewById);
                return view3;
            case -10000:
                a(liveChattingModel, findViewById);
                return view3;
            default:
                switch (s) {
                    case 1:
                        c(liveChattingModel, view3, findViewById);
                        return view3;
                    case 27:
                        r(liveChattingModel, findViewById);
                        return view3;
                    case 33:
                        h(liveChattingModel, view3, findViewById);
                        return view3;
                    case 61:
                        t(liveChattingModel, findViewById);
                        return view3;
                    case 155:
                        l(liveChattingModel, findViewById);
                        return view3;
                    case 202:
                        Logger.a("rrb", "领取奖励消息");
                        a(liveChattingModel, view3, findViewById);
                        return view3;
                    case 221:
                        b(liveChattingModel, view3, findViewById);
                        return view3;
                    case 224:
                        c(liveChattingModel, findViewById);
                        return view3;
                    case 232:
                        d(liveChattingModel, view3, findViewById);
                        return view3;
                    case 245:
                        g(liveChattingModel, view3, findViewById);
                        return view3;
                    case 249:
                        e(liveChattingModel, findViewById);
                        return view3;
                    case 251:
                        f(liveChattingModel, view3, findViewById);
                        return view3;
                    default:
                        switch (s) {
                            case 49:
                            case 50:
                                p(liveChattingModel, findViewById);
                                return view3;
                            case 51:
                                Logger.a("rrb", "点赞消息");
                                f(liveChattingModel, findViewById);
                                return view3;
                            default:
                                switch (s) {
                                    case 102:
                                        k(liveChattingModel, findViewById);
                                        return view3;
                                    case 103:
                                        n(liveChattingModel, findViewById);
                                        return view3;
                                    case 104:
                                        m(liveChattingModel, findViewById);
                                        return view3;
                                    default:
                                        switch (s) {
                                            case 106:
                                                j(liveChattingModel, findViewById);
                                                return view3;
                                            case 107:
                                                i(liveChattingModel, findViewById);
                                                return view3;
                                            case 108:
                                                h(liveChattingModel, findViewById);
                                                Logger.a("rrb", "禁言消息");
                                                return view3;
                                            case 109:
                                                Logger.a("rrb", "解禁消息");
                                                g(liveChattingModel, findViewById);
                                                return view3;
                                            default:
                                                return view3;
                                        }
                                }
                        }
                }
        }
    }

    public CharSequence a(TextView textView, SpannableStringBuilder spannableStringBuilder) {
        CharSequence a = LiveRoomInfo.a().a(spannableStringBuilder, "#ffd452", new LiveRoomConstants.ClickAtLinkListener() { // from class: com.blued.android.module.live_china.liveForMsg.data.LiveMsgContentAdapter.24
            @Override // com.blued.android.module.live_china.constant.LiveRoomConstants.ClickAtLinkListener
            public void a(String str, String str2) {
                if (TextUtils.isEmpty(str2)) {
                    LiveSetDataObserver.a().d(str);
                } else {
                    LiveSetDataObserver.a().e(str2);
                }
            }
        });
        textView.setMovementMethod(LinkMovementClickMethod.a());
        return a;
    }

    public CharSequence a(final TextView textView, LiveChattingModel liveChattingModel, final ClickMsgTalkerListener clickMsgTalkerListener, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        int i;
        int i2;
        String str5;
        int i3;
        String str6;
        int i4;
        int i5;
        int i6;
        Bitmap createBitmap;
        if (textView == null || liveChattingModel == null) {
            return "";
        }
        String a = LiveCloakingUtil.a(liveChattingModel.fromNickName, liveChattingModel.fromPrivilege);
        String str7 = liveChattingModel.msgContent;
        if (liveChattingModel.msgType == 1) {
            String str8 = a + "：";
            str = str8;
            str2 = str7;
            if (f(liveChattingModel) != null) {
                str2 = "";
                str = str8;
            }
        } else {
            str = a;
            str2 = str7;
            if (liveChattingModel.msgType == 27) {
                str = a;
                str2 = str7;
                if (!TextUtils.isEmpty(e(liveChattingModel))) {
                    str = a + AppInfo.d().getString(R.string.live_come_from) + " ";
                    str2 = str7;
                }
            }
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return "";
        }
        int i7 = liveChattingModel.fromLiveManager;
        LiveFansLevelModel d = d(liveChattingModel);
        String str9 = d.fan_club_name;
        int i8 = d.fan_club_level;
        int i9 = d.in_fan_club;
        int i10 = d.fans_status;
        int c = c(liveChattingModel);
        LiveChatBadgeModel c2 = LiveUtils.c(liveChattingModel);
        String e = e(liveChattingModel);
        LiveEmojiModel f = f(liveChattingModel);
        int length = str.length();
        int i11 = 14;
        if (i7 != 0) {
            length = str.length() + 14;
            str3 = "field_control ";
        } else {
            str3 = "";
            i11 = 0;
        }
        if (i9 != 0) {
            i2 = i11 + 5;
            i = str.length() + i2;
            str4 = "fans ";
        } else {
            str4 = "";
            i = length;
            i2 = i11;
        }
        if (c != 0) {
            i2 += 5;
            i3 = i2 + str.length();
            str5 = "rich ";
        } else {
            str5 = "";
            i3 = i;
        }
        if (c2 == null || TextUtils.isEmpty(c2.getChat_badge_url()) || c2.getChat_badge_length().intValue() == 0 || c2.getChat_badge_height().intValue() == 0) {
            str6 = "";
            i4 = i2;
            i5 = i3;
        } else {
            i4 = i2 + 14;
            i5 = i4 + str.length();
            str6 = "rechargeBadge ";
        }
        String str10 = f != null ? "emoji" : "";
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str3 + str4 + str5 + str6 + "" + str + e + str10 + " " + str2);
        final int a2 = AppMethods.a(1.0f);
        if (i7 != 0) {
            Drawable a3 = LiveBitmapUtils.a();
            a3.setBounds(0, a2, AppMethods.a(29), AppMethods.a(15) + a2);
            spannableStringBuilder.setSpan(new VerticalCenterImageSpan(a3, 2), 0, str3.length() - 1, 33);
        }
        if (i9 != 0) {
            LiveFansLevelView liveFansLevelView = new LiveFansLevelView(this.e);
            liveFansLevelView.setFansLevel(d);
            int a4 = AppMethods.a(54.5f);
            int a5 = AppMethods.a(15.0f);
            try {
                liveFansLevelView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                int measuredWidth = liveFansLevelView.getMeasuredWidth();
                int measuredHeight = liveFansLevelView.getMeasuredHeight();
                liveFansLevelView.layout(0, 0, measuredWidth, measuredHeight);
                createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
                a4 = measuredWidth;
                a5 = measuredHeight;
                liveFansLevelView.draw(new Canvas(createBitmap));
                a4 = measuredWidth;
                a5 = measuredHeight;
            } catch (Exception e2) {
                createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(textView.getResources(), createBitmap);
            bitmapDrawable.setBounds(0, a2, a4, a5 + a2);
            spannableStringBuilder.setSpan(new VerticalCenterImageSpan(bitmapDrawable, 2), str3.length(), (str3.length() + str4.length()) - 1, 33);
        }
        if (c != 0) {
            Drawable a6 = LiveBitmapUtils.a(AppInfo.d(), c);
            if (c >= 30) {
                a6.setBounds(0, a2, AppMethods.a(44), AppMethods.a(15) + a2);
            } else {
                a6.setBounds(0, a2, AppMethods.a(30), AppMethods.a(15) + a2);
            }
            spannableStringBuilder.setSpan(new VerticalCenterImageSpan(a6, 2), str4.length() + str3.length(), ((str4.length() + str3.length()) + str5.length()) - 1, 33);
        }
        if (!TextUtils.isEmpty(str6) && c2 != null && !TextUtils.isEmpty(c2.getChat_badge_url())) {
            BitmapDrawable bitmapDrawable2 = new BitmapDrawable();
            int a7 = AppMethods.a(15);
            if (c2.getChat_badge_length().intValue() == 0 || c2.getChat_badge_height().intValue() == 0) {
                i6 = 0;
                a7 = 0;
            } else {
                i6 = (c2.getChat_badge_length().intValue() * a7) / c2.getChat_badge_height().intValue();
            }
            bitmapDrawable2.setBounds(0, a2, i6, a7 + a2);
            final int length2 = str4.length() + str3.length() + str5.length();
            final int length3 = (str6.length() + length2) - 1;
            if (length2 < spannableStringBuilder.length() && length3 < spannableStringBuilder.length()) {
                spannableStringBuilder.setSpan(new VerticalCenterImageSpan(bitmapDrawable2, 2), length2, length3, 33);
                final int i12 = i6;
                final int i13 = a7;
                LiveMemoryBitmapCache.a().a(this.e, c2.getChat_badge_url(), DensityUtils.a(this.e, i6), 0, new LiveMemoryBitmapCache.BitmapCallback() { // from class: com.blued.android.module.live_china.liveForMsg.data.-$$Lambda$LiveMsgContentAdapter$T6z_HOn7yet2hdbqA466aO2SW-s
                    @Override // com.blued.android.module.live_china.utils.LiveMemoryBitmapCache.BitmapCallback
                    public final void onBitmapCreate(String str11, Bitmap bitmap) {
                        LiveMsgContentAdapter.b(a2, i12, i13, spannableStringBuilder, length2, length3, textView, str11, bitmap);
                    }
                });
            }
        }
        spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.blued.android.module.live_china.liveForMsg.data.LiveMsgContentAdapter.30
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                Selection.removeSelection((Spannable) ((TextView) view).getText());
                clickMsgTalkerListener.onClickMsgTalkerListener();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(AppInfo.d().getResources().getColor(R.color.biao_live_msg_name_3));
                textPaint.setUnderlineText(false);
                textPaint.clearShadowLayer();
            }
        }, i4, i5, 33);
        if (!TextUtils.isEmpty(e)) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(AppInfo.d().getResources().getColor(R.color.syc_dark_FF6533)), i5, e.length() + i5, 33);
        } else if (f != null) {
            final int length4 = i5 + str10.length();
            BitmapDrawable bitmapDrawable3 = new BitmapDrawable();
            final int a8 = AppMethods.a(15);
            int a9 = AppMethods.a(15);
            int i14 = a9;
            if (f.getEmoji_w() != 0) {
                i14 = a9;
                if (f.getEmoji_h() != 0) {
                    i14 = (f.getEmoji_w() * a8) / f.getEmoji_h();
                }
            }
            bitmapDrawable3.setBounds(0, a2, i14, a8 + a2);
            spannableStringBuilder.setSpan(new VerticalCenterImageSpan(bitmapDrawable3, 2), i5, length4, 33);
            final int i15 = i14;
            final int i16 = i5;
            LiveMemoryBitmapCache.a().a(this.e, f.getEmoji_url(), DensityUtils.a(this.e, i14), 0, new LiveMemoryBitmapCache.BitmapCallback() { // from class: com.blued.android.module.live_china.liveForMsg.data.-$$Lambda$LiveMsgContentAdapter$i6Y1deegTcLu_M3VhIuzzMSKwjA
                @Override // com.blued.android.module.live_china.utils.LiveMemoryBitmapCache.BitmapCallback
                public final void onBitmapCreate(String str11, Bitmap bitmap) {
                    LiveMsgContentAdapter.a(a2, i15, a8, spannableStringBuilder, i16, length4, textView, str11, bitmap);
                }
            });
        }
        textView.setMovementMethod(LinkMovementClickMethod.a());
        return spannableStringBuilder;
    }

    public CharSequence a(TextView textView, String str) {
        return a(textView, new SpannableStringBuilder(str));
    }

    /* renamed from: a */
    public void i(LiveChattingModel liveChattingModel) {
        if (liveChattingModel == null || liveChattingModel.fromPrivilege == 1) {
            return;
        }
        LiveMsgReportModel liveMsgReportModel = new LiveMsgReportModel();
        if (LiveRoomManager.a().p() != null) {
            liveMsgReportModel.lid = LiveRoomManager.a().e();
        }
        liveMsgReportModel.uid = String.valueOf(liveChattingModel.fromId);
        liveMsgReportModel.reportMsg = liveChattingModel.msgContent;
        liveMsgReportModel.time = String.valueOf(liveChattingModel.msgTimestamp / 1000);
        this.d.d(String.valueOf(liveChattingModel.fromId), liveMsgReportModel);
    }

    public void a(LiveChattingModel liveChattingModel, View view) {
        ((TextView) view.findViewById(R.id.tv_tip)).setText(R.string.live_gift_task_tip_1);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.liveForMsg.data.LiveMsgContentAdapter.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                LiveRoomPreferences.G();
                LiveSetDataObserver.a().v();
                if (LiveMsgContentAdapter.this.d == null || LiveRoomManager.a().p() == null || LiveRoomManager.a().p().profile == null) {
                    return;
                }
                EventTrackLive.a(LiveProtos.Event.LIVE_TODAY_WELFARE_TOAST_CLICK, String.valueOf(LiveMsgContentAdapter.this.d.f), LiveRoomManager.a().g());
            }
        });
    }

    public void b(LiveChattingModel liveChattingModel) {
        if (liveChattingModel == null || liveChattingModel.fromPrivilege == 1) {
            return;
        }
        LiveMsgReportModel liveMsgReportModel = new LiveMsgReportModel();
        if (LiveRoomManager.a().p() != null) {
            liveMsgReportModel.lid = LiveRoomManager.a().e();
        }
        liveMsgReportModel.uid = String.valueOf(liveChattingModel.fromId);
        liveMsgReportModel.reportMsg = liveChattingModel.msgContent;
        liveMsgReportModel.time = String.valueOf(liveChattingModel.msgTimestamp / 1000);
        this.d.c(liveChattingModel.fromNickName, liveMsgReportModel);
    }

    public void b(LiveChattingModel liveChattingModel, View view) {
        ((TextView) view.findViewById(R.id.tv_tip)).setText(R.string.live_gift_task_tip_2);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.liveForMsg.data.LiveMsgContentAdapter.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                LiveRoomPreferences.I();
                LiveSetDataObserver.a().v();
                if (LiveMsgContentAdapter.this.d == null || LiveRoomManager.a().p() == null || LiveRoomManager.a().p().profile == null) {
                    return;
                }
                EventTrackLive.a(LiveProtos.Event.LIVE_GLOW_STICK_TOAST_CLICK, String.valueOf(LiveMsgContentAdapter.this.d.f), LiveRoomManager.a().g());
            }
        });
    }

    public int c(LiveChattingModel liveChattingModel) {
        StringBuilder sb = new StringBuilder();
        sb.append(liveChattingModel.fromId);
        sb.append("");
        return sb.toString().equals(LiveRoomInfo.a().f()) ? LiveRoomInfo.a().r() : liveChattingModel.fromRichLevel;
    }

    public String e(LiveChattingModel liveChattingModel) {
        String str;
        LivePropCardModel livePropCardModel;
        int anchor_pocket_traffic_card;
        if (liveChattingModel == null || liveChattingModel.msgType != 27 || (livePropCardModel = (LivePropCardModel) AppInfo.f().fromJson(liveChattingModel.getMsgExtra(), LivePropCardModel.class)) == null || !((anchor_pocket_traffic_card = livePropCardModel.getAnchor_pocket_traffic_card()) == 1 || anchor_pocket_traffic_card == 2)) {
            str = "";
        } else {
            String anchor_pocket_traffic_card_name = livePropCardModel.getAnchor_pocket_traffic_card_name();
            str = anchor_pocket_traffic_card_name;
            if (TextUtils.isEmpty(anchor_pocket_traffic_card_name)) {
                return "流量卡推荐";
            }
        }
        return str;
    }

    public LiveEmojiModel f(LiveChattingModel liveChattingModel) {
        try {
            LiveEmojiModel liveEmojiModel = (LiveEmojiModel) AppInfo.f().fromJson(liveChattingModel.getMsgExtra(), LiveEmojiModel.class);
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

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        short s = ((LiveChattingModel) this.a.get(i)).msgType;
        return -1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 34;
    }
}
