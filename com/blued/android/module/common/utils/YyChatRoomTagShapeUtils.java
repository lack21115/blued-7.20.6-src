package com.blued.android.module.common.utils;

import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.module.common.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/YyChatRoomTagShapeUtils.class */
public final class YyChatRoomTagShapeUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final YyChatRoomTagShapeUtils f10915a = new YyChatRoomTagShapeUtils();

    private YyChatRoomTagShapeUtils() {
    }

    public final void a(ShapeHelper.ShapeView con, String str) {
        Intrinsics.e(con, "con");
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 57) {
                if (hashCode != 1567) {
                    switch (hashCode) {
                        case 50:
                            if (str.equals("2")) {
                                ShapeHelper.a(con, R.color.syc_38B5FF, R.color.syc_1A7EFF);
                                return;
                            }
                            break;
                        case 51:
                            if (str.equals("3")) {
                                ShapeHelper.a(con, R.color.syc_FB8E45, R.color.syc_DF3812);
                                return;
                            }
                            break;
                        case 52:
                            if (str.equals("4")) {
                                ShapeHelper.a(con, R.color.syc_FC5394, R.color.syc_F7295B);
                                return;
                            }
                            break;
                        case 53:
                            if (str.equals("5")) {
                                ShapeHelper.a(con, R.color.syc_456BFB, R.color.syc_122ADF);
                                return;
                            }
                            break;
                        case 54:
                            if (str.equals("6")) {
                                ShapeHelper.a(con, R.color.syc_B353FC, R.color.syc_8A29F7);
                                return;
                            }
                            break;
                        case 55:
                            if (str.equals("7")) {
                                ShapeHelper.a(con, R.color.syc_FFB200, R.color.syc_FF7B00);
                                return;
                            }
                            break;
                    }
                } else if (str.equals("10")) {
                    ShapeHelper.a(con, R.color.syc_00E0AB, R.color.syc_649FFF);
                    return;
                }
            } else if (str.equals("9")) {
                ShapeHelper.a(con, R.color.syc_FF7CD3, R.color.syc_E205F2);
                return;
            }
        }
        ShapeHelper.a(con, R.color.syc_FFB200, R.color.syc_FF7B00);
    }

    public final void b(ShapeHelper.ShapeView con, String str) {
        Intrinsics.e(con, "con");
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 57) {
                if (hashCode != 1567) {
                    switch (hashCode) {
                        case 50:
                            if (str.equals("2")) {
                                ShapeHelper.a(con, R.color.syc_3000A2FF, R.color.syc_0000CAFF);
                                return;
                            }
                            break;
                        case 51:
                            if (str.equals("3")) {
                                ShapeHelper.a(con, R.color.syc_30FF5700, R.color.syc_00FFCD00);
                                return;
                            }
                            break;
                        case 52:
                            if (str.equals("4")) {
                                ShapeHelper.a(con, R.color.syc_30FF0030, R.color.syc_00FF00AB);
                                return;
                            }
                            break;
                        case 53:
                            if (str.equals("5")) {
                                ShapeHelper.a(con, R.color.syc_300008FF, R.color.syc_000074FF);
                                return;
                            }
                            break;
                        case 54:
                            if (str.equals("6")) {
                                ShapeHelper.a(con, R.color.syc_30A900FF, R.color.syc_00FF00AB);
                                return;
                            }
                            break;
                        case 55:
                            if (str.equals("7")) {
                                ShapeHelper.a(con, R.color.syc_30FFAC00, R.color.syc_00FFCD00);
                                return;
                            }
                            break;
                    }
                } else if (str.equals("10")) {
                    ShapeHelper.a(con, R.color.syc_3000E0AB, R.color.syc_00649FFF);
                    return;
                }
            } else if (str.equals("9")) {
                ShapeHelper.a(con, R.color.syc_30FF0030, R.color.syc_00FF00AB);
                return;
            }
        }
        ShapeHelper.a(con, R.color.syc_30FFAC00, R.color.syc_00FFCD00);
    }
}
