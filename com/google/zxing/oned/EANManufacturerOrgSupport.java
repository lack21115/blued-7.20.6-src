package com.google.zxing.oned;

import android.media.AudioSystem;
import com.anythink.expressad.video.dynview.a.a;
import com.blued.das.live.LiveProtos;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.push.core.b;
import com.opos.acs.st.STManager;
import com.tencent.cloud.huiyansdkface.facelivesdk.BuildConfig;
import com.tencent.smtt.sdk.TbsMediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/oned/EANManufacturerOrgSupport.class */
final class EANManufacturerOrgSupport {
    private final List<int[]> ranges = new ArrayList();
    private final List<String> countryIdentifiers = new ArrayList();

    private void add(int[] iArr, String str) {
        this.ranges.add(iArr);
        this.countryIdentifiers.add(str);
    }

    private void initIfNeeded() {
        synchronized (this) {
            if (this.ranges.isEmpty()) {
                add(new int[]{0, 19}, "US/CA");
                add(new int[]{30, 39}, "US");
                add(new int[]{60, 139}, "US/CA");
                add(new int[]{300, 379}, "FR");
                add(new int[]{380}, "BG");
                add(new int[]{383}, "SI");
                add(new int[]{385}, "HR");
                add(new int[]{387}, "BA");
                add(new int[]{400, 440}, "DE");
                add(new int[]{450, LiveProtos.Event.LIVE_PK_USER_VOICE_ICON_CLICK_VALUE}, "JP");
                add(new int[]{LiveProtos.Event.LIVE_ROOM_CONFIG_POP_SHOW_VALUE, LiveProtos.Event.LIVE_HOT_BANNER_CLICK_VALUE}, "RU");
                add(new int[]{LiveProtos.Event.LIVE_SECOND_TAB_SHOW_VALUE}, "TW");
                add(new int[]{474}, "EE");
                add(new int[]{LiveProtos.Event.LIVE_DOWN_SETTINGS_SHOW_VALUE}, "LV");
                add(new int[]{LiveProtos.Event.LIVE_DOWN_SETTINGS_CLICK_VALUE}, "AZ");
                add(new int[]{LiveProtos.Event.LIVE_DOWN_COLLECTION_SHOW_VALUE}, "LT");
                add(new int[]{LiveProtos.Event.LIVE_DOWN_COLLECTION_CLICK_VALUE}, "UZ");
                add(new int[]{LiveProtos.Event.LIVE_DOWN_COLLECTION_FEATURE_CLICK_VALUE}, "LK");
                add(new int[]{480}, STManager.REGION_OF_PH);
                add(new int[]{LiveProtos.Event.LIVE_GIFT_WALL_PAGE_SHOW_VALUE}, "BY");
                add(new int[]{LiveProtos.Event.LIVE_GIFT_WALL_PAGE_WEEK_SHOW_VALUE}, "UA");
                add(new int[]{LiveProtos.Event.LIVE_GIFT_WALL_PAGE_HISTORY_SHOW_VALUE}, "MD");
                add(new int[]{LiveProtos.Event.LIVE_GIFT_WALL_PAGE_PLAY_EXPLAIN_SHOW_VALUE}, "AM");
                add(new int[]{LiveProtos.Event.LIVE_GIFT_WALL_PAGE_LIGHT_CLICK_VALUE}, "GE");
                add(new int[]{LiveProtos.Event.LIVE_GIFT_WALL_PAGE_HISTORY_ONE_CLICK_VALUE}, "KZ");
                add(new int[]{489}, a.ae);
                add(new int[]{490, 499}, "JP");
                add(new int[]{500, 509}, "GB");
                add(new int[]{520}, "GR");
                add(new int[]{528}, "LB");
                add(new int[]{LiveProtos.Event.LIVE_PK_START_BTN_CLICK_VALUE}, "CY");
                add(new int[]{LiveProtos.Event.LIVE_PK_EXIT_BTN_CLICK_VALUE}, "MK");
                add(new int[]{LiveProtos.Event.LIVE_PK_TIPS_CLICK_VALUE}, "MT");
                add(new int[]{LiveProtos.Event.LIVE_PK_CONTRIBUTION_PAGE_RULE_CLICK_VALUE}, "IE");
                add(new int[]{LiveProtos.Event.LIVE_BAG_CHAT_MARK_SHOW_VALUE, LiveProtos.Event.LIVE_ANCHOR_PACK_ONE_SHOW_VALUE}, "BE/LU");
                add(new int[]{560}, AssistPushConsts.MSG_VALUE_PAYLOAD);
                add(new int[]{569}, "IS");
                add(new int[]{570, LiveProtos.Event.LIVE_ONLINE_NOBLE_PAGE_SHOW_VALUE}, "DK");
                add(new int[]{LiveProtos.Event.LIVE_PK_MORE_TEAM_PAGE_SHOW_VALUE}, "PL");
                add(new int[]{LiveProtos.Event.LIVE_PK_MORE_SCORE_BTN_CLICK_VALUE}, "RO");
                add(new int[]{LiveProtos.Event.LIVE_PK_MORE_EXIT_YES_CLICK_VALUE}, "HU");
                add(new int[]{600, 601}, "ZA");
                add(new int[]{603}, "GH");
                add(new int[]{608}, "BH");
                add(new int[]{609}, "MU");
                add(new int[]{611}, "MA");
                add(new int[]{613}, "DZ");
                add(new int[]{LiveProtos.Event.LIVE_BATTLE_PASS_EXPLAIN_SHOW_VALUE}, "KE");
                add(new int[]{LiveProtos.Event.LIVE_BATTLE_PASS_TOP_PAGE_SHOW_VALUE}, "CI");
                add(new int[]{LiveProtos.Event.LIVE_BATTLE_PASS_TOP_PAGE_BUY_CLICK_VALUE}, "TN");
                add(new int[]{LiveProtos.Event.LIVE_BATTLE_PASS_BASIC_POP_YES_CLICK_VALUE}, "SY");
                add(new int[]{LiveProtos.Event.LIVE_BATTLE_PASS_BASIC_POP_BUY_CLICK_VALUE}, "EG");
                add(new int[]{LiveProtos.Event.LIVE_BATTLE_PASS_TOP_POP_YES_CLICK_VALUE}, "LY");
                add(new int[]{LiveProtos.Event.LIVE_BATTLE_PASS_NOTICE_BASIC_SHOW_VALUE}, "JO");
                add(new int[]{LiveProtos.Event.LIVE_BATTLE_PASS_NOTICE_TOP_BUY_CLICK_VALUE}, "IR");
                add(new int[]{LiveProtos.Event.LIVE_BATTLE_PASS_NOTICE_TOP_SHOW_VALUE}, "KW");
                add(new int[]{LiveProtos.Event.LIVE_BATTLE_PASS_BUBBLE_SHOW_VALUE}, "SA");
                add(new int[]{LiveProtos.Event.LIVE_BATTLE_PASS_BUBBLE_TRY_CLICK_VALUE}, "AE");
                add(new int[]{640, LiveProtos.Event.LIVE_FOLLOW_PAGE_SHOW_VALUE}, "FI");
                add(new int[]{LiveProtos.Event.LIVE_EXCHANGE_VIP_POP_CLOSE_CLICK_VALUE, LiveProtos.Event.LIVE_BLIND_BOX_TAB_SHOW_VALUE}, "CN");
                add(new int[]{700, LiveProtos.Event.ANCHOR_END_PAGE_COLLEGE_CLICK_VALUE}, "NO");
                add(new int[]{729}, "IL");
                add(new int[]{730, 739}, "SE");
                add(new int[]{740}, b.i);
                add(new int[]{741}, "SV");
                add(new int[]{742}, "HN");
                add(new int[]{743}, "NI");
                add(new int[]{744}, "CR");
                add(new int[]{745}, "PA");
                add(new int[]{746}, "DO");
                add(new int[]{750}, "MX");
                add(new int[]{754, 755}, "CA");
                add(new int[]{759}, "VE");
                add(new int[]{760, 769}, "CH");
                add(new int[]{770}, "CO");
                add(new int[]{773}, "UY");
                add(new int[]{775}, "PE");
                add(new int[]{777}, "BO");
                add(new int[]{779}, "AR");
                add(new int[]{780}, "CL");
                add(new int[]{784}, "PY");
                add(new int[]{785}, "PE");
                add(new int[]{786}, "EC");
                add(new int[]{789, TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_BUFFERING_PERCENTAGE}, "BR");
                add(new int[]{800, BuildConfig.VERSION_CODE}, "IT");
                add(new int[]{840, 849}, "ES");
                add(new int[]{850}, "CU");
                add(new int[]{858}, "SK");
                add(new int[]{859}, "CZ");
                add(new int[]{860}, "YU");
                add(new int[]{865}, "MN");
                add(new int[]{867}, "KP");
                add(new int[]{868, 869}, "TR");
                add(new int[]{870, 879}, "NL");
                add(new int[]{880}, "KR");
                add(new int[]{885}, STManager.REGION_OF_TH);
                add(new int[]{888}, "SG");
                add(new int[]{890}, STManager.REGION_OF_IN);
                add(new int[]{893}, STManager.REGION_OF_VN);
                add(new int[]{AudioSystem.DEVICE_OUT_ALL_A2DP}, "PK");
                add(new int[]{899}, STManager.REGION_OF_ID);
                add(new int[]{900, 919}, "AT");
                add(new int[]{930, 939}, "AU");
                add(new int[]{940, 949}, "AZ");
                add(new int[]{955}, STManager.REGION_OF_MY);
                add(new int[]{958}, "MO");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String lookupCountryIdentifier(String str) {
        initIfNeeded();
        int parseInt = Integer.parseInt(str.substring(0, 3));
        int size = this.ranges.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return null;
            }
            int[] iArr = this.ranges.get(i2);
            int i3 = iArr[0];
            if (parseInt < i3) {
                return null;
            }
            if (iArr.length != 1) {
                i3 = iArr[1];
            }
            if (parseInt <= i3) {
                return this.countryIdentifiers.get(i2);
            }
            i = i2 + 1;
        }
    }
}
