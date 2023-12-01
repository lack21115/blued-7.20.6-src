package com.blued.android.module.live_china.utils;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveNobleModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/LiveViewUtils.class */
public final class LiveViewUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f14195a = new Companion(null);

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/LiveViewUtils$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(LiveChattingModel liveChattingModel, ImageView imageView) {
            if (imageView == null) {
                return;
            }
            if (liveChattingModel == null) {
                imageView.setVisibility(8);
                return;
            }
            int a2 = AppMethods.a(15);
            LiveNobleModel N = (liveChattingModel.nobleModel == null || TextUtils.isEmpty(liveChattingModel.nobleModel.getNameplate_img())) ? (liveChattingModel.fromId == 0 || !TextUtils.equals(String.valueOf(liveChattingModel.fromId), LiveRoomInfo.a().f())) ? null : LiveRoomManager.a().N() : liveChattingModel.nobleModel;
            if (N != null) {
                Integer nameplate_img_width = N.getNameplate_img_width();
                Intrinsics.a(nameplate_img_width);
                if (nameplate_img_width.intValue() > 0) {
                    Integer nameplate_img_height = N.getNameplate_img_height();
                    Intrinsics.a(nameplate_img_height);
                    if (nameplate_img_height.intValue() > 0 && !TextUtils.isEmpty(N.getNameplate_img())) {
                        imageView.setVisibility(0);
                        Integer nameplate_img_width2 = N.getNameplate_img_width();
                        Intrinsics.a(nameplate_img_width2);
                        int intValue = nameplate_img_width2.intValue();
                        Integer nameplate_img_height2 = N.getNameplate_img_height();
                        Intrinsics.a(nameplate_img_height2);
                        int intValue2 = (intValue * a2) / nameplate_img_height2.intValue();
                        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                        Intrinsics.c(layoutParams, "view.getLayoutParams()");
                        layoutParams.width = intValue2;
                        layoutParams.height = a2;
                        imageView.setLayoutParams(layoutParams);
                        String nameplate_img = N.getNameplate_img();
                        Intrinsics.a((Object) nameplate_img);
                        ImageLoader.a((IRequestHost) null, nameplate_img).e(imageView.hashCode()).g(-1).a(imageView);
                        return;
                    }
                }
            }
            imageView.setVisibility(8);
        }
    }
}
