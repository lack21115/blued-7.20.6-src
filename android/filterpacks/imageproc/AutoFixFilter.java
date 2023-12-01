package android.filterpacks.imageproc;

import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import android.filterfw.core.Frame;
import android.filterfw.core.FrameFormat;
import android.filterfw.core.GenerateFieldPort;
import android.filterfw.core.MutableFrameFormat;
import android.filterfw.core.Program;
import android.filterfw.core.ShaderProgram;
import android.filterfw.format.ImageFormat;
import android.os.BatteryManager;
import android.provider.Downloads;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.blued.das.live.LiveProtos;
import com.tencent.thumbplayer.core.common.TPCodecParamers;

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/imageproc/AutoFixFilter.class */
public class AutoFixFilter extends Filter {
    private static final int[] normal_cdf = {9, 33, 50, 64, 75, 84, 92, 99, 106, 112, 117, 122, 126, 130, 134, 138, 142, 145, 148, 150, 154, 157, 159, 162, 164, 166, 169, 170, 173, 175, 177, 179, 180, 182, 184, 186, 188, 189, 190, 192, 194, 195, 197, 198, 199, 200, 202, 203, 205, 206, 207, 208, 209, 210, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 229, 230, 231, 232, 233, 234, 235, 236, 236, 237, 238, 239, 239, 240, 240, 242, 242, 243, 244, 245, 245, 246, 247, 247, 248, 249, 249, 250, 250, 251, 252, 253, 253, 254, 255, 255, 256, 256, 257, 258, 258, 259, 259, 259, 260, 261, 262, 262, 263, 263, 264, 264, 265, 265, 266, 267, 267, 268, 268, 269, 269, 269, 270, 270, 271, 272, 272, 273, 273, 274, 274, 275, 275, 276, 276, 277, 277, 277, 278, 278, 279, 279, 279, 280, 280, 281, 282, 282, 282, 283, 283, 284, 284, 285, 285, 285, 286, 286, 287, 287, 288, 288, 288, 289, 289, 289, 290, 290, 290, 291, 292, 292, 292, 293, 293, 294, 294, 294, 295, 295, 296, 296, 296, 297, 297, 297, 298, 298, 298, 299, 299, 299, 299, 300, 300, 301, 301, 302, 302, 302, 303, 303, 304, 304, 304, 305, 305, 305, 306, 306, 306, 307, 307, 307, 308, 308, 308, 309, 309, 309, 309, 310, 310, 310, 310, 311, 312, 312, 312, 313, 313, 313, 314, 314, 314, 315, 315, 315, 315, 316, 316, 316, 317, 317, 317, 318, 318, 318, 319, 319, 319, 319, 319, 320, 320, 320, 321, 321, 322, 322, 322, 323, 323, 323, 323, 324, 324, 324, 325, 325, 325, 325, 326, 326, 326, 327, 327, 327, 327, 328, 328, 328, 329, 329, 329, 329, 329, 330, 330, 330, 330, 331, 331, 332, 332, 332, 333, 333, 333, 333, 334, 334, 334, 334, 335, 335, 335, 336, 336, 336, 336, 337, 337, 337, 337, 338, 338, 338, 339, 339, 339, 339, 339, 339, 340, 340, 340, 340, 341, 341, 342, 342, 342, 342, 343, 343, 343, 344, 344, 344, 344, 345, 345, 345, 345, 346, 346, 346, 346, 347, 347, 347, 347, 348, 348, 348, 348, 349, 349, 349, 349, 349, 349, 350, 350, 350, 350, 351, 351, 352, 352, 352, 352, 353, 353, 353, 353, 354, 354, 354, 354, 355, 355, 355, 355, 356, 356, 356, 356, 357, 357, 357, 357, 358, 358, 358, 358, 359, 359, 359, 359, 359, 359, 359, 360, 360, 360, 360, 361, 361, 362, 362, 362, 362, 363, 363, 363, 363, 364, 364, 364, 364, 365, 365, 365, 365, 366, 366, 366, 366, 366, 367, 367, 367, 367, 368, 368, 368, 368, 369, 369, 369, 369, 369, 369, 370, 370, 370, 370, 370, 371, 371, 372, 372, 372, 372, 373, 373, 373, 373, 374, 374, 374, 374, 374, 375, 375, 375, 375, 376, 376, 376, 376, 377, 377, 377, 377, 378, 378, 378, 378, 378, 379, 379, 379, 379, 379, 379, 380, 380, 380, 380, 381, 381, 381, 382, 382, 382, 382, 383, 383, 383, 383, 384, 384, 384, 384, 385, 385, 385, 385, 385, 386, 386, 386, 386, 387, 387, 387, 387, 388, 388, 388, 388, 388, 389, 389, 389, 389, 389, 389, 390, 390, 390, 390, ChatRoomProtos.Event.YY_MADE_CAR_PAGE_RECORD_CLICK_VALUE, ChatRoomProtos.Event.YY_MADE_CAR_PAGE_RECORD_CLICK_VALUE, 392, 392, 392, 392, 392, 393, 393, 393, 393, 394, 394, 394, 394, ChatRoomProtos.Event.YY_LIFT_MASK_POP_SHOW_VALUE, ChatRoomProtos.Event.YY_LIFT_MASK_POP_SHOW_VALUE, ChatRoomProtos.Event.YY_LIFT_MASK_POP_SHOW_VALUE, ChatRoomProtos.Event.YY_LIFT_MASK_POP_SHOW_VALUE, ChatRoomProtos.Event.YY_LIFT_MASK_POP_CANCEL_CLICK_VALUE, ChatRoomProtos.Event.YY_LIFT_MASK_POP_CANCEL_CLICK_VALUE, ChatRoomProtos.Event.YY_LIFT_MASK_POP_CANCEL_CLICK_VALUE, ChatRoomProtos.Event.YY_LIFT_MASK_POP_CANCEL_CLICK_VALUE, ChatRoomProtos.Event.YY_LIFT_MASK_POP_CANCEL_CLICK_VALUE, ChatRoomProtos.Event.YY_LIFT_MASK_POP_USE_CLICK_VALUE, ChatRoomProtos.Event.YY_LIFT_MASK_POP_USE_CLICK_VALUE, ChatRoomProtos.Event.YY_LIFT_MASK_POP_USE_CLICK_VALUE, ChatRoomProtos.Event.YY_LIFT_MASK_POP_USE_CLICK_VALUE, ChatRoomProtos.Event.YY_LIFT_MASK_USER_POP_SHOW_VALUE, ChatRoomProtos.Event.YY_LIFT_MASK_USER_POP_SHOW_VALUE, ChatRoomProtos.Event.YY_LIFT_MASK_USER_POP_SHOW_VALUE, ChatRoomProtos.Event.YY_LIFT_MASK_USER_POP_SHOW_VALUE, 399, 399, 399, 399, 399, 399, 400, 400, 400, 400, 400, 401, 401, 402, 402, 402, 402, 403, 403, 403, 403, 404, 404, 404, 404, 405, 405, 405, 405, 406, 406, 406, 406, 406, 407, 407, 407, 407, 408, 408, 408, 408, 409, 409, 409, 409, 409, 409, 410, 410, 410, 410, 411, 411, 412, 412, 412, 412, 413, 413, 413, 413, 414, 414, 414, 414, 415, 415, 415, 415, 416, 416, 416, 416, 417, 417, 417, 417, 418, 418, 418, 418, 419, 419, 419, 419, 419, 419, 420, 420, 420, 420, 421, 421, 422, 422, 422, 422, 423, 423, 423, 423, 424, 424, 424, 425, 425, 425, 425, 426, 426, 426, 426, 427, 427, 427, 427, 428, 428, 428, 429, 429, 429, 429, 429, 429, 430, 430, 430, 430, 431, 431, 432, 432, 432, 433, 433, 433, 433, 434, 434, 434, 435, 435, 435, 435, 436, 436, 436, 436, 437, 437, 437, 438, 438, 438, 438, 439, 439, 439, 439, 439, 440, 440, 440, 441, 441, 442, 442, 442, LiveProtos.Event.LIVE_CHALLENGE_PK_EXPLAIN_CLICK_VALUE, LiveProtos.Event.LIVE_CHALLENGE_PK_EXPLAIN_CLICK_VALUE, LiveProtos.Event.LIVE_CHALLENGE_PK_EXPLAIN_CLICK_VALUE, LiveProtos.Event.LIVE_CHALLENGE_PK_EXPLAIN_CLICK_VALUE, 444, 444, 444, 445, 445, 445, 446, 446, 446, 446, 447, 447, 447, 448, 448, 448, 449, 449, 449, 449, 449, 450, 450, 450, 451, 451, 452, 452, 452, 453, 453, 453, 454, 454, 454, 455, 455, 455, 456, 456, 456, 457, 457, 457, LiveProtos.Event.LIVE_PK_USER_VOICE_ICON_SHOW_VALUE, LiveProtos.Event.LIVE_PK_USER_VOICE_ICON_SHOW_VALUE, LiveProtos.Event.LIVE_PK_USER_VOICE_ICON_SHOW_VALUE, LiveProtos.Event.LIVE_PK_USER_VOICE_ICON_CLICK_VALUE, LiveProtos.Event.LIVE_PK_USER_VOICE_ICON_CLICK_VALUE, LiveProtos.Event.LIVE_PK_USER_VOICE_ICON_CLICK_VALUE, LiveProtos.Event.LIVE_PK_USER_VOICE_ICON_CLICK_VALUE, LiveProtos.Event.LIVE_ROOM_CONFIG_POP_SHOW_VALUE, LiveProtos.Event.LIVE_ROOM_CONFIG_POP_SHOW_VALUE, LiveProtos.Event.LIVE_ROOM_CONFIG_POP_SHOW_VALUE, LiveProtos.Event.LIVE_ROOM_CONFIG_POP_LINK_CLICK_VALUE, LiveProtos.Event.LIVE_ROOM_CONFIG_POP_LINK_CLICK_VALUE, LiveProtos.Event.LIVE_ROOM_CONFIG_POP_CLOSE_CLICK_VALUE, LiveProtos.Event.LIVE_ROOM_CONFIG_POP_CLOSE_CLICK_VALUE, LiveProtos.Event.LIVE_ROOM_CONFIG_POP_CLOSE_CLICK_VALUE, LiveProtos.Event.LIVE_LIST_CONFIG_POP_SHOW_VALUE, LiveProtos.Event.LIVE_LIST_CONFIG_POP_SHOW_VALUE, LiveProtos.Event.LIVE_LIST_CONFIG_POP_SHOW_VALUE, LiveProtos.Event.LIVE_LIST_CONFIG_POP_LINK_CLICK_VALUE, LiveProtos.Event.LIVE_LIST_CONFIG_POP_LINK_CLICK_VALUE, LiveProtos.Event.LIVE_LIST_CONFIG_POP_CLOSE_CLICK_VALUE, LiveProtos.Event.LIVE_LIST_CONFIG_POP_CLOSE_CLICK_VALUE, LiveProtos.Event.LIVE_LIST_CONFIG_POP_CLOSE_CLICK_VALUE, LiveProtos.Event.LIVE_VIP_ICON_SHOW_VALUE, LiveProtos.Event.LIVE_VIP_ICON_SHOW_VALUE, LiveProtos.Event.LIVE_VIP_ICON_SHOW_VALUE, LiveProtos.Event.LIVE_VIP_ICON_CLICK_VALUE, LiveProtos.Event.LIVE_VIP_ICON_CLICK_VALUE, LiveProtos.Event.LIVE_VIP_ICON_CLICK_VALUE, LiveProtos.Event.LIVE_HOT_BANNER_SHOW_VALUE, LiveProtos.Event.LIVE_HOT_BANNER_SHOW_VALUE, LiveProtos.Event.LIVE_HOT_BANNER_CLICK_VALUE, LiveProtos.Event.LIVE_HOT_BANNER_CLICK_VALUE, LiveProtos.Event.LIVE_HOT_BANNER_CLICK_VALUE, LiveProtos.Event.LIVE_HOT_BANNER_CLICK_VALUE, LiveProtos.Event.LIVE_FIRST_TAB_SHOW_VALUE, LiveProtos.Event.LIVE_FIRST_TAB_SHOW_VALUE, LiveProtos.Event.LIVE_FIRST_TAB_SHOW_VALUE, LiveProtos.Event.LIVE_SECOND_TAB_SHOW_VALUE, LiveProtos.Event.LIVE_GROUP_CHAT_BTN_SHOW_VALUE, LiveProtos.Event.LIVE_GROUP_CHAT_BTN_SHOW_VALUE, LiveProtos.Event.LIVE_GROUP_CHAT_BTN_SHOW_VALUE, LiveProtos.Event.LIVE_FOLLOWED_HORI_RECOMMEND_SHOW_VALUE, LiveProtos.Event.LIVE_FOLLOWED_HORI_RECOMMEND_SHOW_VALUE, 474, 474, 474, LiveProtos.Event.LIVE_DOWN_SETTINGS_SHOW_VALUE, LiveProtos.Event.LIVE_DOWN_SETTINGS_SHOW_VALUE, LiveProtos.Event.LIVE_DOWN_SETTINGS_CLICK_VALUE, LiveProtos.Event.LIVE_DOWN_SETTINGS_CLICK_VALUE, LiveProtos.Event.LIVE_DOWN_SETTINGS_CLICK_VALUE, LiveProtos.Event.LIVE_DOWN_COLLECTION_SHOW_VALUE, LiveProtos.Event.LIVE_DOWN_COLLECTION_SHOW_VALUE, LiveProtos.Event.LIVE_DOWN_COLLECTION_CLICK_VALUE, LiveProtos.Event.LIVE_DOWN_COLLECTION_CLICK_VALUE, LiveProtos.Event.LIVE_DOWN_COLLECTION_CLICK_VALUE, LiveProtos.Event.LIVE_DOWN_COLLECTION_FEATURE_CLICK_VALUE, LiveProtos.Event.LIVE_DOWN_COLLECTION_FEATURE_CLICK_VALUE, LiveProtos.Event.LIVE_DOWN_COLLECTION_FEATURE_CLICK_VALUE, 480, 480, 480, LiveProtos.Event.LIVE_GIFT_WALL_PAGE_SHOW_VALUE, LiveProtos.Event.LIVE_GIFT_WALL_PAGE_WEEK_SHOW_VALUE, LiveProtos.Event.LIVE_GIFT_WALL_PAGE_WEEK_SHOW_VALUE, LiveProtos.Event.LIVE_GIFT_WALL_PAGE_QUARTER_SHOW_VALUE, LiveProtos.Event.LIVE_GIFT_WALL_PAGE_QUARTER_SHOW_VALUE, LiveProtos.Event.LIVE_GIFT_WALL_PAGE_HISTORY_SHOW_VALUE, LiveProtos.Event.LIVE_GIFT_WALL_PAGE_HISTORY_SHOW_VALUE, LiveProtos.Event.LIVE_GIFT_WALL_PAGE_HISTORY_SHOW_VALUE, LiveProtos.Event.LIVE_GIFT_WALL_PAGE_PLAY_EXPLAIN_SHOW_VALUE, LiveProtos.Event.LIVE_GIFT_WALL_PAGE_PLAY_EXPLAIN_SHOW_VALUE, LiveProtos.Event.LIVE_GIFT_WALL_PAGE_LIGHT_CLICK_VALUE, LiveProtos.Event.LIVE_GIFT_WALL_PAGE_LIGHT_CLICK_VALUE, LiveProtos.Event.LIVE_GIFT_WALL_PAGE_HISTORY_ONE_CLICK_VALUE, LiveProtos.Event.LIVE_GIFT_WALL_PAGE_HISTORY_ONE_CLICK_VALUE, 488, 488, 488, 489, 489, 489, 490, 490, Downloads.Impl.STATUS_UNKNOWN_ERROR, Downloads.Impl.STATUS_FILE_ERROR, Downloads.Impl.STATUS_FILE_ERROR, Downloads.Impl.STATUS_UNHANDLED_REDIRECT, Downloads.Impl.STATUS_UNHANDLED_REDIRECT, 494, 494, 495, 495, 496, 496, 497, 497, 498, 498, 499, 499, 499, 500, 501, 502, 502, 503, 503, 504, 504, 505, 505, 506, 507, 507, 508, 508, 509, 509, 510, 510, 511, 512, 513, 513, 514, 515, 515, 516, 517, 517, 518, 519, 519, 519, 520, LiveProtos.Event.LIVE_HOUR_LIST_TOP_TAB_SHOW_VALUE, LiveProtos.Event.LIVE_HOUR_LIST_POTENTIAL_TAB_SHOW_VALUE, LiveProtos.Event.LIVE_HOUR_LIST_TIME_TAB_SHOW_VALUE, 524, 524, LiveProtos.Event.LIVE_ANCHOR_PACKAGE_SHOW_VALUE, LiveProtos.Event.LIVE_END_PAGE_SHOW_VALUE, LiveProtos.Event.LIVE_END_PAGE_SHOW_VALUE, LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE, 528, LiveProtos.Event.LIVE_PK_START_BTN_CLICK_VALUE, LiveProtos.Event.LIVE_PK_START_BTN_CLICK_VALUE, LiveProtos.Event.LIVE_PK_EXIT_BTN_SHOW_VALUE, LiveProtos.Event.LIVE_PK_EXIT_BTN_CLICK_VALUE, 532, LiveProtos.Event.LIVE_PK_EXIT_POP_NO_CLICK_VALUE, LiveProtos.Event.LIVE_PK_TIPS_SHOW_VALUE, LiveProtos.Event.LIVE_PK_TIPS_CLICK_VALUE, LiveProtos.Event.LIVE_PK_TIPS_CLICK_VALUE, LiveProtos.Event.LIVE_PK_SCORE_BTN_SHOW_VALUE, LiveProtos.Event.LIVE_PK_SCORE_BTN_CLICK_VALUE, LiveProtos.Event.LIVE_PK_CONTRIBUTION_PAGE_SHOW_VALUE, LiveProtos.Event.LIVE_PK_CONTRIBUTION_PAGE_RULE_CLICK_VALUE, LiveProtos.Event.LIVE_PK_CONTRIBUTION_PAGE_RULE_CLICK_VALUE, LiveProtos.Event.LIVE_BAG_CHAT_MARK_SHOW_VALUE, LiveProtos.Event.LIVE_BAG_CHAT_MARK_CANCEL_CLICK_VALUE, LiveProtos.Event.LIVE_GIFT_EFFECT_BTN_SHOW_VALUE, LiveProtos.Event.LIVE_GIFT_EFFECT_BTN_CLICK_VALUE, 545, 546, LiveProtos.Event.LIVE_GIFT_VALIDITY_POP_YES_CLICK_VALUE, LiveProtos.Event.LIVE_GIFT_VALIDITY_POP_CLOSE_CLICK_VALUE, LiveProtos.Event.LIVE_ANCHOR_PACK_ONE_SHOW_VALUE, LiveProtos.Event.LIVE_ANCHOR_PACK_ONE_SHOW_VALUE, LiveProtos.Event.LIVE_ANCHOR_PACK_ONE_USE_VALUE, LiveProtos.Event.LIVE_RECOMMEND_POP_CLOSE_VALUE, LiveProtos.Event.LIVE_FANS_GUIDE_ICON_SHOW_VALUE, LiveProtos.Event.LIVE_FANS_GUIDE_ICON_CLICK_VALUE, LiveProtos.Event.LIVE_ONLINE_USER_PAGE_SHOW_VALUE, LiveProtos.Event.LIVE_SCREEN_BARRAGE_CLICK_VALUE, LiveProtos.Event.LIVE_USER_CAR_SHOW_VALUE, LiveProtos.Event.LIVE_SUPER_SPEAK_PAGE_SHOW_VALUE, LiveProtos.Event.LIVE_SUPER_SPEAK_PAGE_SHOW_VALUE, LiveProtos.Event.LIVE_PROFILE_CARD_KICK_OUT_CLICK_VALUE, 562, LiveProtos.Event.LIVE_NOBLE_MSG_SHOW_VALUE, LiveProtos.Event.LIVE_NOBLE_MSG_GO_CLICK_VALUE, 566, 568, 569, 570, 572, 574, 575, 577, TPCodecParamers.TP_PROFILE_H264_CONSTRAINED_BASELINE, LiveProtos.Event.LIVE_ONLINE_NOBLE_PAGE_SHOW_VALUE, LiveProtos.Event.FANS_CLUB_PAGE_JOIN_PAGE_BTN_SHOW_VALUE, LiveProtos.Event.LIVE_EXCHANGE_PAGE_BANNER_SHOW_VALUE, LiveProtos.Event.LIVE_TIPS_SHOW_VALUE, LiveProtos.Event.LIVE_PK_MORE_START_BTN_SHOW_VALUE, LiveProtos.Event.LIVE_PK_MORE_PERSONAL_PAGE_SHOW_VALUE, LiveProtos.Event.LIVE_PK_MORE_TEAM_PAGE_SHOW_VALUE, LiveProtos.Event.LIVE_PK_MORE_SCORE_BTN_SHOW_VALUE, LiveProtos.Event.LIVE_PK_MORE_ASSIST_PAGE_SHOW_VALUE, LiveProtos.Event.LIVE_PK_MORE_EXIT_BTN_SHOW_VALUE, 
    LiveProtos.Event.LIVE_PK_MORE_EXIT_YES_CLICK_VALUE, 602, 604, 607, 609, 612, LiveProtos.Event.LIVE_BATTLE_PASS_TASK_GO_CLICK_VALUE, LiveProtos.Event.LIVE_BATTLE_PASS_TOP_PAGE_SHOW_VALUE, LiveProtos.Event.LIVE_BATTLE_PASS_BASIC_POP_SHOW_VALUE, LiveProtos.Event.LIVE_BATTLE_PASS_TOP_POP_YES_CLICK_VALUE, LiveProtos.Event.LIVE_BATTLE_PASS_BUBBLE_SHOW_VALUE, LiveProtos.Event.LIVE_SET_GIFT_EXPLAIN_PAGE_SHOW_VALUE, LiveProtos.Event.LIVE_SET_GIFT_PAGE_SEND_ONE_CLICK_VALUE, LiveProtos.Event.LIVE_GIFT_POP_DRESS_TAB_PROFILE_CARD_USE_CLICK_VALUE, LiveProtos.Event.LIVE_STAR_EXPLORE_PAGE_CLICK_VALUE, LiveProtos.Event.LIVE_FOLLOW_PAGE_SHOW_VALUE, LiveProtos.Event.LIVE_NEW_FIRST_PAY_POP_MORE_CLICK_VALUE, LiveProtos.Event.LIVE_PROFILE_CARD_SUBSTITUTE_ME_CLICK_VALUE, 666, LiveProtos.Event.LIVE_USER_RANDOM_GIFT_PAGE_LOTTERY_CLICK_VALUE, LiveProtos.Event.LIVE_CUSTOM_MADE_SEAL_PAGE_SHOW_VALUE, LiveProtos.Event.LIVE_EXCHANGE_VIP_POP_CLOSE_CLICK_VALUE, 700, LiveProtos.Event.LIVE_SHOW_PAGE_GUILD_PAGE_SHOW_VALUE};
    private final String mAutoFixShader;
    private Frame mDensityFrame;
    private int mHeight;
    private Frame mHistFrame;
    private Program mNativeProgram;
    @GenerateFieldPort(name = BatteryManager.EXTRA_SCALE)
    private float mScale;
    private Program mShaderProgram;
    private int mTarget;
    @GenerateFieldPort(hasDefault = true, name = "tile_size")
    private int mTileSize;
    private int mWidth;

    public AutoFixFilter(String str) {
        super(str);
        this.mTileSize = 640;
        this.mAutoFixShader = "precision mediump float;\nuniform sampler2D tex_sampler_0;\nuniform sampler2D tex_sampler_1;\nuniform sampler2D tex_sampler_2;\nuniform float scale;\nuniform float shift_scale;\nuniform float hist_offset;\nuniform float hist_scale;\nuniform float density_offset;\nuniform float density_scale;\nvarying vec2 v_texcoord;\nvoid main() {\n  const vec3 weights = vec3(0.33333, 0.33333, 0.33333);\n  vec4 color = texture2D(tex_sampler_0, v_texcoord);\n  float energy = dot(color.rgb, weights);\n  float mask_value = energy - 0.5;\n  float alpha;\n  if (mask_value > 0.0) {\n    alpha = (pow(2.0 * mask_value, 1.5) - 1.0) * scale + 1.0;\n  } else { \n    alpha = (pow(2.0 * mask_value, 2.0) - 1.0) * scale + 1.0;\n  }\n  float index = energy * hist_scale + hist_offset;\n  vec4 temp = texture2D(tex_sampler_1, vec2(index, 0.5));\n  float value = temp.g + temp.r * shift_scale;\n  index = value * density_scale + density_offset;\n  temp = texture2D(tex_sampler_2, vec2(index, 0.5));\n  value = temp.g + temp.r * shift_scale;\n  float dst_energy = energy * alpha + value * (1.0 - alpha);\n  float max_energy = energy / max(color.r, max(color.g, color.b));\n  if (dst_energy > max_energy) {\n    dst_energy = max_energy;\n  }\n  if (energy == 0.0) {\n    gl_FragColor = color;\n  } else {\n    gl_FragColor = vec4(color.rgb * dst_energy / energy, color.a);\n  }\n}\n";
        this.mWidth = 0;
        this.mHeight = 0;
        this.mTarget = 0;
    }

    private void createHistogramFrame(FilterContext filterContext, int i, int i2, int[] iArr) {
        int[] iArr2 = new int[766];
        int i3 = (int) (i2 * 0.05f);
        int i4 = (int) (i * 0.05f);
        int i5 = i3;
        while (true) {
            int i6 = i5;
            if (i6 >= i2 - i3) {
                break;
            }
            int i7 = i4;
            while (true) {
                int i8 = i7;
                if (i8 < i - i4) {
                    int i9 = (i6 * i) + i8;
                    int i10 = (iArr[i9] & 255) + ((iArr[i9] >> 8) & 255) + ((iArr[i9] >> 16) & 255);
                    iArr2[i10] = iArr2[i10] + 1;
                    i7 = i8 + 1;
                }
            }
            i5 = i6 + 1;
        }
        int i11 = 1;
        while (true) {
            int i12 = i11;
            if (i12 >= 766) {
                break;
            }
            iArr2[i12] = iArr2[i12] + iArr2[i12 - 1];
            i11 = i12 + 1;
        }
        int i13 = 0;
        while (true) {
            int i14 = i13;
            if (i14 >= 766) {
                break;
            }
            iArr2[i14] = (int) ((65535 * iArr2[i14]) / ((i - (i4 * 2)) * (i2 - (i3 * 2))));
            i13 = i14 + 1;
        }
        MutableFrameFormat create = ImageFormat.create(766, 1, 3, 3);
        if (this.mHistFrame != null) {
            this.mHistFrame.release();
        }
        this.mHistFrame = filterContext.getFrameManager().newFrame(create);
        this.mHistFrame.setInts(iArr2);
    }

    private void initParameters() {
        this.mShaderProgram.setHostValue("shift_scale", Float.valueOf(0.00390625f));
        this.mShaderProgram.setHostValue("hist_offset", Float.valueOf(6.527415E-4f));
        this.mShaderProgram.setHostValue("hist_scale", Float.valueOf(0.99869454f));
        this.mShaderProgram.setHostValue("density_offset", Float.valueOf(4.8828125E-4f));
        this.mShaderProgram.setHostValue("density_scale", Float.valueOf(0.99902344f));
        this.mShaderProgram.setHostValue(BatteryManager.EXTRA_SCALE, Float.valueOf(this.mScale));
    }

    @Override // android.filterfw.core.Filter
    public void fieldPortValueUpdated(String str, FilterContext filterContext) {
        if (this.mShaderProgram != null) {
            this.mShaderProgram.setHostValue(BatteryManager.EXTRA_SCALE, Float.valueOf(this.mScale));
        }
    }

    @Override // android.filterfw.core.Filter
    public FrameFormat getOutputFormat(String str, FrameFormat frameFormat) {
        return frameFormat;
    }

    public void initProgram(FilterContext filterContext, int i) {
        switch (i) {
            case 3:
                ShaderProgram shaderProgram = new ShaderProgram(filterContext, "precision mediump float;\nuniform sampler2D tex_sampler_0;\nuniform sampler2D tex_sampler_1;\nuniform sampler2D tex_sampler_2;\nuniform float scale;\nuniform float shift_scale;\nuniform float hist_offset;\nuniform float hist_scale;\nuniform float density_offset;\nuniform float density_scale;\nvarying vec2 v_texcoord;\nvoid main() {\n  const vec3 weights = vec3(0.33333, 0.33333, 0.33333);\n  vec4 color = texture2D(tex_sampler_0, v_texcoord);\n  float energy = dot(color.rgb, weights);\n  float mask_value = energy - 0.5;\n  float alpha;\n  if (mask_value > 0.0) {\n    alpha = (pow(2.0 * mask_value, 1.5) - 1.0) * scale + 1.0;\n  } else { \n    alpha = (pow(2.0 * mask_value, 2.0) - 1.0) * scale + 1.0;\n  }\n  float index = energy * hist_scale + hist_offset;\n  vec4 temp = texture2D(tex_sampler_1, vec2(index, 0.5));\n  float value = temp.g + temp.r * shift_scale;\n  index = value * density_scale + density_offset;\n  temp = texture2D(tex_sampler_2, vec2(index, 0.5));\n  value = temp.g + temp.r * shift_scale;\n  float dst_energy = energy * alpha + value * (1.0 - alpha);\n  float max_energy = energy / max(color.r, max(color.g, color.b));\n  if (dst_energy > max_energy) {\n    dst_energy = max_energy;\n  }\n  if (energy == 0.0) {\n    gl_FragColor = color;\n  } else {\n    gl_FragColor = vec4(color.rgb * dst_energy / energy, color.a);\n  }\n}\n");
                shaderProgram.setMaximumTileSize(this.mTileSize);
                this.mShaderProgram = shaderProgram;
                this.mTarget = i;
                return;
            default:
                throw new RuntimeException("Filter Sharpen does not support frames of target " + i + "!");
        }
    }

    @Override // android.filterfw.core.Filter
    protected void prepare(FilterContext filterContext) {
        int[] iArr = new int[1024];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 1024) {
                this.mDensityFrame = filterContext.getFrameManager().newFrame(ImageFormat.create(1024, 1, 3, 3));
                this.mDensityFrame.setInts(iArr);
                return;
            }
            iArr[i2] = (int) ((normal_cdf[i2] * 65535) / 766);
            i = i2 + 1;
        }
    }

    @Override // android.filterfw.core.Filter
    public void process(FilterContext filterContext) {
        Frame pullInput = pullInput("image");
        FrameFormat format = pullInput.getFormat();
        if (this.mShaderProgram == null || format.getTarget() != this.mTarget) {
            initProgram(filterContext, format.getTarget());
            initParameters();
        }
        if (format.getWidth() != this.mWidth || format.getHeight() != this.mHeight) {
            this.mWidth = format.getWidth();
            this.mHeight = format.getHeight();
            createHistogramFrame(filterContext, this.mWidth, this.mHeight, pullInput.getInts());
        }
        Frame newFrame = filterContext.getFrameManager().newFrame(format);
        this.mShaderProgram.process(new Frame[]{pullInput, this.mHistFrame, this.mDensityFrame}, newFrame);
        pushOutput("image", newFrame);
        newFrame.release();
    }

    @Override // android.filterfw.core.Filter
    public void setupPorts() {
        addMaskedInputPort("image", ImageFormat.create(3));
        addOutputBasedOnInput("image", "image");
    }

    @Override // android.filterfw.core.Filter
    public void tearDown(FilterContext filterContext) {
        if (this.mDensityFrame != null) {
            this.mDensityFrame.release();
            this.mDensityFrame = null;
        }
        if (this.mHistFrame != null) {
            this.mHistFrame.release();
            this.mHistFrame = null;
        }
    }
}
