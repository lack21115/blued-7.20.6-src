package com.blued.android.module.yy_china.model;

import com.blued.android.module.yy_china.model.YYGiftModel;
import java.util.ArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYPayRequestModel.class */
public class YYPayRequestModel<T extends YYGiftModel> {
    public long beans;
    public String extra_contents;
    public YYGiftModel gift;
    public int giftCount;
    public String goods_id;
    public int goods_type;
    public long hit_id;
    public String payCode;
    public String redPacket_group_id;
    public boolean remember_me;
    public String room_id;
    public String target_uid;
    public ArrayList<YYSeatMemberModel> wantSelect;
    public boolean isFirstToMicsInTeam = true;
    public int pay_from = 0;
    public boolean needFailDialog = true;
}
