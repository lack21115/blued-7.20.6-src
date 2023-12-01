package com.blued.das.vip;

import com.google.common.net.HttpHeaders;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-7206380-dex2jar.jar:com/blued/das/vip/VipProtos.class */
public final class VipProtos {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000fVipProtos.proto\u0012\u0011com.blued.das.vip\"\u00ad\b\n\bVipProto\u0012'\n\u0005event\u0018\u0001 \u0001(\u000e2\u0018.com.blued.das.vip.Event\u0012%\n\u0004name\u0018\u0002 \u0001(\u000e2\u0017.com.blued.das.vip.Name\u0012)\n\u0004from\u0018\u0003 \u0001(\u000e2\u001b.com.blued.das.vip.FromType\u00124\n\fstealth_type\u0018\u0004 \u0001(\u000e2\u001e.com.blued.das.vip.StealthType\u0012\u0010\n\bis_range\u0018\u0005 \u0001(\b\u00126\n\rvocative_type\u0018\u0006 \u0001(\u000e2\u001f.com.blued.das.vip.VocativeType\u00124\n\fpage_version\u0018\u0007 \u0001(\u000e2\u001e.com.blued.das.vip.PageVersion\u00126\n\ridentity_type\u0018\b \u0001(\u000e2\u001f.com.blued.das.vip.IdentityType\u0012\u0016\n\u000eis_buy_success\u0018\t \u0001(\b\u0012\u000f\n\u0007is_open\u0018\n \u0001(\b\u00120\n\npage_level\u0018\u000b \u0001(\u000e2\u001c.com.blued.das.vip.PageLevel\u0012.\n\thide_type\u0018\f \u0001(\u000e2\u001b.com.blued.das.vip.HideType\u0012\u0013\n\u000bis_hide_all\u0018\r \u0001(\b\u0012\u0018\n\u0010is_hide_distance\u0018\u000e \u0001(\b\u0012\u0014\n\fis_hide_role\u0018\u000f \u0001(\b\u0012\u0013\n\u000bis_hide_age\u0018\u0010 \u0001(\b\u0012\u0012\n\nbanner_url\u0018\u0011 \u0001(\t\u0012\u0014\n\fprivilege_id\u0018\u0012 \u0001(\t\u0012,\n\bbtn_type\u0018\u0013 \u0001(\u000e2\u001a.com.blued.das.vip.BtnType\u0012\u0011\n\tbanner_id\u0018\u0014 \u0001(\t\u00120\n\norder_type\u0018\u0015 \u0001(\u000e2\u001c.com.blued.das.vip.OrderType\u0012*\n\u0007ad_page\u0018\u0016 \u0001(\u000e2\u0019.com.blued.das.vip.AdPage\u0012\u000f\n\u0007ad_type\u0018\u0017 \u0001(\t\u0012\u0011\n\tlongitude\u0018\u0018 \u0001(\t\u0012\u0010\n\blatitude\u0018\u0019 \u0001(\t\u0012\u0010\n\bimage_id\u0018\u001a \u0001(\t\u0012\u0010\n\bthird_id\u0018\u001b \u0001(\t\u0012\u0011\n\tis_shadow\u0018\u001c \u0001(\b\u0012\n\n\u0002id\u0018\u001d \u0001(\t\u0012\u000b\n\u0003num\u0018\u001e \u0001(\u0005\u0012\u0012\n\nis_success\u0018\u001f \u0001(\b\u0012\r\n\u0005count\u0018  \u0001(\u0005\u0012\u0010\n\border_id\u0018! \u0001(\t\u0012\u000b\n\u0003url\u0018\" \u0001(\t\u0012\u0012\n\ntarget_uid\u0018# \u0001(\t\u0012\f\n\u0004type\u0018$ \u0001(\t\u0012\u0010\n\bis_vague\u0018% \u0001(\b\u0012\u000e\n\u0006sku_id\u0018& \u0001(\t*Ú\u0018\n\u0005Event\u0012\u0011\n\rUNKNOWN_EVENT\u0010��\u0012\u0010\n\fVIP_BUY_SHOW\u0010\u0001\u0012\u001c\n\u0018VIP_BUY_SWITCH_BTN_CLICK\u0010\u0002\u0012\u001a\n\u0016VIP_BUY_OPEN_BTN_CLICK\u0010\u0003\u0012\u0015\n\u0011STEALTH_BTN_CLICK\u0010\u0004\u0012,\n(VOCATIVE_OPEN_GET_MORE_EXPOSURE_BTN_SHOW\u0010\u0005\u0012-\n)VOCATIVE_OPEN_GET_MORE_EXPOSURE_BTN_CLICK\u0010\u0006\u0012\u001e\n\u001aFEATURED_FOR_YOU_PAGE_SHOW\u0010\u0007\u0012,\n(FEATURED_FOR_YOU_PAGE_BUY_SVIP_BTN_CLICK\u0010\b\u0012\u001b\n\u0017VOCATIVE_BACK_BTN_CLICK\u0010\t\u0012\u001b\n\u0017MAP_FIND_BACK_BTN_CLICK\u0010\n\u0012\u001d\n\u0019VIP_CENTRE_BACK_BTN_CLICK\u0010\u000b\u0012\u001a\n\u0016VIP_BUY_BACK_BTN_CLICK\u0010\f\u0012\u0010\n\fVIP_BUY_SVIP\u0010\r\u0012\u0018\n\u0014VIP_CENTRE_PAGE_SHOW\u0010\u000e\u0012 \n\u001cVIP_CENTRE_VIP_UP_SVIP_CLICK\u0010\u000f\u0012*\n&VIP_CENTRE_SUPER_HIDE_SECOND_PAGE_SHOW\u0010\u0010\u0012*\n&VIP_CENTRE_SUPER_HIDE_SECOND_BTN_CLICK\u0010\u0011\u0012,\n(VIP_CENTRE_SUPER_HIDE_COMPLETE_BTN_CLICK\u0010\u0012\u0012\"\n\u001eVIP_CENTRE_RESUME_BUY_BTN_SHOW\u0010\u0013\u0012#\n\u001fVIP_CENTRE_RESUME_BUY_BTN_CLICK\u0010\u0014\u0012\u001a\n\u0016VIP_CENTRE_BANNER_SHOW\u0010\u0015\u0012\u001b\n\u0017VIP_CENTRE_BANNER_CLICK\u0010\u0016\u0012\u001e\n\u001aVIP_CENTER_PRIVILEGE_CLICK\u0010\u0017\u0012\"\n\u001eVIP_CENTER_CAROUSEL_AREA_CLICK\u0010\u0018\u0012!\n\u001dVISIT_PAGE_NO_TRACE_BTN_CLICK\u0010\u0019\u0012\u001d\n\u0019MINE_RANGE_TIME_BTN_CLICK\u0010\u001a\u0012\u001c\n\u0018MINE_HIDE_TINE_BTN_CLICK\u0010\u001b\u0012\u001d\n\u0019MINE_HIDE_RANGE_BTN_CLICK\u0010\u001c\u0012\"\n\u001eVIP_CENTER_TOP_RENEW_NOW_CLICK\u0010\u001d\u0012\u001f\n\u001bMAP_FIND_SETTINGS_BTN_CLICK\u0010\u001e\u0012-\n)MAP_FIND_SETTINGS_PAGE_SETTINGS_BTN_CLICK\u0010\u001f\u0012\u0015\n\u0011ORDER_COUPON_SHOW\u0010 \u0012\u0016\n\u0012ORDER_COUPON_CLICK\u0010!\u0012\u001e\n\u001aVIP_BUY_PAGE_MORE_BTN_SHOW\u0010\"\u0012\u001f\n\u001bVIP_BUY_PAGE_MORE_BTN_CLICK\u0010#\u0012 \n\u001cVIP_BUY_PAGE_CANCEL_POP_SHOW\u0010$\u0012(\n$VIP_BUY_PAGE_CANCEL_POP_CANCEL_CLICK\u0010%\u0012%\n!VIP_BUY_PAGE_CANCEL_POP_BUY_CLICK\u0010&\u0012\u0018\n\u0014NO_AD_PROPAGATE_SHOW\u0010'\u0012\u001d\n\u0019NO_AD_PROPAGATE_BUY_CLICK\u0010(\u0012\u001e\n\u001aNO_AD_PROPAGATE_OPEN_CLICK\u0010)\u0012\u001f\n\u001bNO_AD_PROPAGATE_CLOSE_CLICK\u0010*\u0012\u001d\n\u0019NO_AD_PROPAGATE_BAN_CLICK\u0010+\u0012\u0017\n\u0013VIP_LEVEL_PAGE_SHOW\u0010,\u0012\"\n\u001eVIP_LEVEL_PAGE_UP_BLUEDX_CLICK\u0010-\u0012\"\n\u001eVIP_CHANGE_ICON_SAVE_BTN_CLICK\u0010.\u0012*\n&VIP_BACKFROUND_CHOOSE_SYSTEM_BTN_CLICK\u0010/\u0012)\n%VIP_BACKFROUND_CHOOSE_PHOTO_BTN_CLICK\u00100\u0012'\n#VIP_BACKFROUND_PHOTOGRAPH_BTN_CLICK\u00101\u0012\u0018\n\u0014IOS_PAY_THIRD_STATUS\u00102\u0012\"\n\u001eVIP_PRIVACY_PHOTO_EXPAND_CLICK\u00103\u0012!\n\u001dVIP_PRIVACY_PHOTO_LOCKED_SHOW\u00104\u0012\"\n\u001eVIP_PRIVACY_PHOTO_LOCKED_CLICK\u00105\u0012(\n$VIP_PRIVACY_PHOTO_LOCKED_RENEW_CLICK\u00106\u0012\u001e\n\u001aVISIT_PAGE_SHADOW_BTN_SHOW\u00107\u0012\u001f\n\u001bVISIT_PAGE_SHADOW_BTN_CLICK\u00108\u0012\"\n\u001eVIP_CENTER_PHOTO_PENDANT_CLICK\u00109\u0012!\n\u001dPHOTO_PENDANT_PAGE_SAVE_CLICK\u0010:\u0012 \n\u001cPHOTO_PENDANT_PAGE_VIP_CLICK\u0010;\u0012\u0019\n\u0015VIP_CENTER_RENEW_SHOW\u0010<\u0012\u001a\n\u0016VIP_CENTER_RENEW_CLICK\u0010=\u0012\u001b\n\u0017IOS_REPEAT_BUY_POP_SHOW\u0010>\u0012\u0019\n\u0015PAY_CASHIER_PAGE_SHOW\u0010?\u0012\u0019\n\u0015NEW_USER_VIP_POP_SHOW\u0010@\u0012\u001e\n\u001aNEW_USER_VIP_POP_BUY_CLICK\u0010A\u0012\"\n\u001eVIP_LEVEL_PAGE_PRIVILEGE_CLICK\u0010C\u0012\u001c\n\u0018NEARBY_USER_VIP_POP_SHOW\u0010D\u0012!\n\u001dNEARBY_USER_VIP_POP_BUY_CLICK\u0010E\u0012 \n\u001cNEARBY_USER_VIP_UNLOCK_CLICK\u0010F\u0012\u001d\n\u0019LITE_HOME_PAGE_CALL_CLICK\u0010G\u0012\u001c\n\u0018LITE_MSG_PAGE_CALL_CLICK\u0010H\u0012\u0015\n\u0011VIRTUAL_BUY_CLICK\u0010I\u0012\u001d\n\u0019VIRTUAL_BUY_POP_YES_CLICK\u0010J\u0012\u001c\n\u0018VIRTUAL_BUY_POP_NO_CLICK\u0010K\u0012#\n\u001fVIRTUAL_EDIT_PAGE_ACTIVITY_SHOW\u0010L\u0012$\n VIRTUAL_EDIT_PAGE_ACTIVITY_CLICK\u0010M\u0012\u001f\n\u001bVIRTUAL_EDIT_PAGE_BUY_CLICK\u0010N\u0012\"\n\u001eVIRTUAL_EDIT_PAGE_WANDOU_CLICK\u0010O\u0012\u0019\n\u0015MAP_FIND_PASSBY_CLICK\u0010P\u0012$\n MAP_FIND_PASSBY_POP_SWITCH_CLICK\u0010Q\u0012!\n\u001dMAP_FIND_PASSBY_POP_USER_SHOW\u0010R\u0012(\n$MAP_FIND_PASSBY_POP_USER_PHOTO_CLICK\u0010S\u0012'\n#MAP_FIND_PASSBY_POP_USER_CHAT_CLICK\u0010T\u0012$\n MAP_FIND_PASSBY_POP_RED_DOT_SHOW\u0010U\u0012\u0016\n\u0012MAP_FIND_USER_SHOW\u0010V\u0012\u0017\n\u0013MAP_FIND_USER_CLICK\u0010W\u0012\u001a\n\u0016VIRTUAL_PACK_TAB_CLICK\u0010X\u0012%\n!VIP_BUY_PAGE_CANCEL_POP_NOW_CLICK\u0010Y\u0012\u001a\n\u0016VISIT_PAGE_OFTEN_CLICK\u0010Z\u0012\u0019\n\u0015VISIT_PAGE_EACH_CLICK\u0010[\u0012\u001a\n\u0016VISIT_PAGE_VAGUE_CLICK\u0010\\\u0012\u001f\n\u001bNEW_USER_VIP_GUIDE_POP_SHOW\u0010]\u0012$\n NEW_USER_VIP_GUIDE_POP_BUY_CLICK\u0010^\u0012\u001a\n\u0016VIP_UP_BLUEDX_POP_SHOW\u0010_\u0012\u001f\n\u001bVIP_UP_BLUEDX_POP_BUY_CLICK\u0010`*c\n\u0007BtnType\u0012\u0014\n\u0010UNKNOWN_BTN_TYPE\u0010��\u0012\u000b\n\u0007NOW_BUY\u0010\u0001\u0012\u000e\n\nNOW_RESUME\u0010\u0002\u0012\t\n\u0005RENEW\u0010\u0003\u0012\u0007\n\u0003BUY\u0010\u0004\u0012\u0007\n\u0003USE\u0010\u0005\u0012\b\n\u0004LOOK\u0010\u0006*+\n\u0004Name\u0012\u0010\n\fUNKNOWN_NAME\u0010��\u0012\u0007\n\u0003VIP\u0010\u0001\u0012\b\n\u0004SVIP\u0010\u0002*ê\u0006\n\bFromType\u0012\u0010\n\fUNKNOWN_FROM\u0010��\u0012\u000b\n\u0007HISTORY\u0010\u0001\u0012\u0016\n\u0012TODAY_VISIT_REMAIN\u0010\u0002\u0012\u0017\n\u0013FIFTEEN_VISIT_TREND\u0010\u0003\u0012\u0012\n\u000eVISIT_ONLY_ONE\u0010\u0004\u0012\u000e\n\nVISIT_NONE\u0010\u0005\u0012\r\n\tAPP_STORE\u0010\u0006\u0012\u000e\n\nMSG_BUBBLE\u0010\u0007\u0012\u0015\n\u0011FEED_DYNAMIC_SKIN\u0010\b\u0012\u0018\n\u0014PRIVACY_PHOTO_EXPAND\u0010\t\u0012\u001e\n\u001aPRIVACY_PHOTO_LOCKED_RENEW\u0010\n\u0012\u0015\n\u0011PHOTO_PENDANT_OWN\u0010\u000b\u0012\u0017\n\u0013PHOTO_PENDANT_OTHER\u0010\f\u0012\u0010\n\fMAP_FIND_BUY\u0010\r\u0012\u001c\n\u0018PHOTO_PENDANT_VIP_CENTER\u0010\u000e\u0012\u001c\n\u0018NEARBY_FRIEND_AVATAR_LOC\u0010\u000f\u0012%\n!NEARBY_FRIEND_MAP_FIND_NONE_TRIAL\u0010\u0010\u0012 \n\u001cNEARBY_FRIEND_MAP_FIND_TRIAL\u0010\u0011\u0012\u0010\n\fPHOTO_FILTER\u0010\u0012\u0012\u0018\n\u0014CONSTELLATION_FILTER\u0010\u0013\u0012\u0011\n\rFIND_MAP_PASS\u0010\u0014\u0012\u0013\n\u000fFLASH_PRIVILEGE\u0010\u0015\u0012\u000f\n\u000bVISIT_OFTEN\u0010\u0016\u0012\u000e\n\nVISIT_EACH\u0010\u0017\u0012\u000f\n\u000bVISIT_VAGUE\u0010\u0018\u0012\u0018\n\u0014AUTHENTICATED_FILTER\u0010\u0019\u0012\u000e\n\nVIP_FILTER\u0010\u001a\u0012\u0013\n\u000fDISTANCE_FILTER\u0010\u001b\u0012\u0011\n\rONLINE_FILTER\u0010\u001c\u0012\u0012\n\u000eNEW_USER_GUIDE\u0010\u001d\u0012\u0010\n\fSPECIAL_CARE\u0010\u001e\u0012\u0014\n\u0010VIP_SPECIAL_CARE\u0010\u001f\u0012\u0010\n\fVIP_PAY_PAGE\u0010 \u0012\u000f\n\u000bHIDE_CUSTOM\u0010!\u0012\u0012\n\u000eFOLLOW_QUIETLY\u0010\"\u0012\f\n\bHIDE_FOR\u0010#\u0012\u0010\n\fLOOK_QUIETLY\u0010$\u0012\u0013\n\u000fTRACELESS_VISIT\u0010%\u0012\r\n\tMSG_GUIDE\u0010&\u0012\u0010\n\fVIP_HIDE_FOR\u0010'\u0012\u0012\n\u000eLEVEL_DISCOUNT\u0010(*<\n\u000bStealthType\u0012\u0018\n\u0014UNKNOWN_STEALTH_TYPE\u0010��\u0012\t\n\u0005WHOLE\u0010\u0001\u0012\b\n\u0004HALF\u0010\u0002*G\n\fVocativeType\u0012\u0019\n\u0015UNKNOWN_VOCATIVE_TYPE\u0010��\u0012\f\n\bNO_TIMES\u0010\u0001\u0012\u000e\n\nHAVE_TIMES\u0010\u0002*?\n\u000bPageVersion\u0012\u0018\n\u0014UNKNOWN_PAGE_VERSION\u0010��\u0012\n\n\u0006V_0730\u0010\u0001\u0012\n\n\u0006V_0813\u0010\u0002*s\n\fIdentityType\u0012\u0019\n\u0015UNKNOWN_IDENTITY_TYPE\u0010��\u0012\b\n\u0004NONE\u0010\u0001\u0012\f\n\bVIP_TYPE\u0010\u0002\u0012\r\n\tSVIP_TYPE\u0010\u0003\u0012\u000f\n\u000bVIP_EXPIRED\u0010\u0004\u0012\u0010\n\fSVIP_EXPIRED\u0010\u0005*N\n\tPageLevel\u0012\u0016\n\u0012UNKNOWN_PAGE_LEVEL\u0010��\u0012\f\n\bVIP_PAGE\u0010\u0001\u0012\r\n\tSVIP_PAGE\u0010\u0002\u0012\f\n\bVIP_BACK\u0010\u0003*_\n\bHideType\u0012\u0015\n\u0011UNKNOWN_HIDE_TYPE\u0010��\u0012\f\n\bHIDE_ALL\u0010\u0001\u0012\u0011\n\rHIDE_DISTANCE\u0010\u0002\u0012\r\n\tHIDE_ROLE\u0010\u0003\u0012\f\n\bHIDE_AGE\u0010\u0004*\u009c\u0001\n\tOrderType\u0012\u0016\n\u0012UNKNOWN_ORDER_TYPE\u0010��\u0012\r\n\tORDER_VIP\u0010\u0001\u0012\u000e\n\nORDER_SVIP\u0010\u0002\u0012\u000e\n\nORDER_CALL\u0010\u0003\u0012\u0012\n\u000eORDER_EXPOSURE\u0010\u0004\u0012\u0010\n\fORDER_SHADOW\u0010\u0005\u0012\u0010\n\fORDER_WANDOU\u0010\u0006\u0012\u0010\n\fORDER_SOCIAL\u0010\u0007*\u0093\u0001\n\u0006AdPage\u0012\u0013\n\u000fUNKNOWN_AD_PAGE\u0010��\u0012\f\n\bAD_VISIT\u0010\u0001\u0012\r\n\tAD_BANNER\u0010\u0002\u0012\u000b\n\u0007AD_HOME\u0010\u0003\u0012\u000f\n\u000bAD_HOME_POP\u0010\u0004\u0012\u0013\n\u000fAD_HOME_BANNER1\u0010\u0005\u0012\u0013\n\u000fAD_HOME_BANNER2\u0010\u0006\u0012\u000f\n\u000bAD_PERSONAL\u0010\u0007B\u0006¢\u0002\u0003VIPb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_com_blued_das_vip_VipProto_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_vip_VipProto_fieldAccessorTable;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/vip/VipProtos$AdPage.class */
    public enum AdPage implements ProtocolMessageEnum {
        UNKNOWN_AD_PAGE(0),
        AD_VISIT(1),
        AD_BANNER(2),
        AD_HOME(3),
        AD_HOME_POP(4),
        AD_HOME_BANNER1(5),
        AD_HOME_BANNER2(6),
        AD_PERSONAL(7),
        UNRECOGNIZED(-1);
        
        public static final int AD_BANNER_VALUE = 2;
        public static final int AD_HOME_BANNER1_VALUE = 5;
        public static final int AD_HOME_BANNER2_VALUE = 6;
        public static final int AD_HOME_POP_VALUE = 4;
        public static final int AD_HOME_VALUE = 3;
        public static final int AD_PERSONAL_VALUE = 7;
        public static final int AD_VISIT_VALUE = 1;
        public static final int UNKNOWN_AD_PAGE_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<AdPage> internalValueMap = new Internal.EnumLiteMap<AdPage>() { // from class: com.blued.das.vip.VipProtos.AdPage.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public AdPage findValueByNumber(int i) {
                return AdPage.forNumber(i);
            }
        };
        private static final AdPage[] VALUES = values();

        AdPage(int i) {
            this.value = i;
        }

        public static AdPage forNumber(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN_AD_PAGE;
                case 1:
                    return AD_VISIT;
                case 2:
                    return AD_BANNER;
                case 3:
                    return AD_HOME;
                case 4:
                    return AD_HOME_POP;
                case 5:
                    return AD_HOME_BANNER1;
                case 6:
                    return AD_HOME_BANNER2;
                case 7:
                    return AD_PERSONAL;
                default:
                    return null;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return VipProtos.getDescriptor().getEnumTypes().get(11);
        }

        public static Internal.EnumLiteMap<AdPage> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static AdPage valueOf(int i) {
            return forNumber(i);
        }

        public static AdPage valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                return enumValueDescriptor.getIndex() == -1 ? UNRECOGNIZED : VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/vip/VipProtos$BtnType.class */
    public enum BtnType implements ProtocolMessageEnum {
        UNKNOWN_BTN_TYPE(0),
        NOW_BUY(1),
        NOW_RESUME(2),
        RENEW(3),
        BUY(4),
        USE(5),
        LOOK(6),
        UNRECOGNIZED(-1);
        
        public static final int BUY_VALUE = 4;
        public static final int LOOK_VALUE = 6;
        public static final int NOW_BUY_VALUE = 1;
        public static final int NOW_RESUME_VALUE = 2;
        public static final int RENEW_VALUE = 3;
        public static final int UNKNOWN_BTN_TYPE_VALUE = 0;
        public static final int USE_VALUE = 5;
        private final int value;
        private static final Internal.EnumLiteMap<BtnType> internalValueMap = new Internal.EnumLiteMap<BtnType>() { // from class: com.blued.das.vip.VipProtos.BtnType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public BtnType findValueByNumber(int i) {
                return BtnType.forNumber(i);
            }
        };
        private static final BtnType[] VALUES = values();

        BtnType(int i) {
            this.value = i;
        }

        public static BtnType forNumber(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN_BTN_TYPE;
                case 1:
                    return NOW_BUY;
                case 2:
                    return NOW_RESUME;
                case 3:
                    return RENEW;
                case 4:
                    return BUY;
                case 5:
                    return USE;
                case 6:
                    return LOOK;
                default:
                    return null;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return VipProtos.getDescriptor().getEnumTypes().get(1);
        }

        public static Internal.EnumLiteMap<BtnType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static BtnType valueOf(int i) {
            return forNumber(i);
        }

        public static BtnType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                return enumValueDescriptor.getIndex() == -1 ? UNRECOGNIZED : VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/vip/VipProtos$Event.class */
    public enum Event implements ProtocolMessageEnum {
        UNKNOWN_EVENT(0),
        VIP_BUY_SHOW(1),
        VIP_BUY_SWITCH_BTN_CLICK(2),
        VIP_BUY_OPEN_BTN_CLICK(3),
        STEALTH_BTN_CLICK(4),
        VOCATIVE_OPEN_GET_MORE_EXPOSURE_BTN_SHOW(5),
        VOCATIVE_OPEN_GET_MORE_EXPOSURE_BTN_CLICK(6),
        FEATURED_FOR_YOU_PAGE_SHOW(7),
        FEATURED_FOR_YOU_PAGE_BUY_SVIP_BTN_CLICK(8),
        VOCATIVE_BACK_BTN_CLICK(9),
        MAP_FIND_BACK_BTN_CLICK(10),
        VIP_CENTRE_BACK_BTN_CLICK(11),
        VIP_BUY_BACK_BTN_CLICK(12),
        VIP_BUY_SVIP(13),
        VIP_CENTRE_PAGE_SHOW(14),
        VIP_CENTRE_VIP_UP_SVIP_CLICK(15),
        VIP_CENTRE_SUPER_HIDE_SECOND_PAGE_SHOW(16),
        VIP_CENTRE_SUPER_HIDE_SECOND_BTN_CLICK(17),
        VIP_CENTRE_SUPER_HIDE_COMPLETE_BTN_CLICK(18),
        VIP_CENTRE_RESUME_BUY_BTN_SHOW(19),
        VIP_CENTRE_RESUME_BUY_BTN_CLICK(20),
        VIP_CENTRE_BANNER_SHOW(21),
        VIP_CENTRE_BANNER_CLICK(22),
        VIP_CENTER_PRIVILEGE_CLICK(23),
        VIP_CENTER_CAROUSEL_AREA_CLICK(24),
        VISIT_PAGE_NO_TRACE_BTN_CLICK(25),
        MINE_RANGE_TIME_BTN_CLICK(26),
        MINE_HIDE_TINE_BTN_CLICK(27),
        MINE_HIDE_RANGE_BTN_CLICK(28),
        VIP_CENTER_TOP_RENEW_NOW_CLICK(29),
        MAP_FIND_SETTINGS_BTN_CLICK(30),
        MAP_FIND_SETTINGS_PAGE_SETTINGS_BTN_CLICK(31),
        ORDER_COUPON_SHOW(32),
        ORDER_COUPON_CLICK(33),
        VIP_BUY_PAGE_MORE_BTN_SHOW(34),
        VIP_BUY_PAGE_MORE_BTN_CLICK(35),
        VIP_BUY_PAGE_CANCEL_POP_SHOW(36),
        VIP_BUY_PAGE_CANCEL_POP_CANCEL_CLICK(37),
        VIP_BUY_PAGE_CANCEL_POP_BUY_CLICK(38),
        NO_AD_PROPAGATE_SHOW(39),
        NO_AD_PROPAGATE_BUY_CLICK(40),
        NO_AD_PROPAGATE_OPEN_CLICK(41),
        NO_AD_PROPAGATE_CLOSE_CLICK(42),
        NO_AD_PROPAGATE_BAN_CLICK(43),
        VIP_LEVEL_PAGE_SHOW(44),
        VIP_LEVEL_PAGE_UP_BLUEDX_CLICK(45),
        VIP_CHANGE_ICON_SAVE_BTN_CLICK(46),
        VIP_BACKFROUND_CHOOSE_SYSTEM_BTN_CLICK(47),
        VIP_BACKFROUND_CHOOSE_PHOTO_BTN_CLICK(48),
        VIP_BACKFROUND_PHOTOGRAPH_BTN_CLICK(49),
        IOS_PAY_THIRD_STATUS(50),
        VIP_PRIVACY_PHOTO_EXPAND_CLICK(51),
        VIP_PRIVACY_PHOTO_LOCKED_SHOW(52),
        VIP_PRIVACY_PHOTO_LOCKED_CLICK(53),
        VIP_PRIVACY_PHOTO_LOCKED_RENEW_CLICK(54),
        VISIT_PAGE_SHADOW_BTN_SHOW(55),
        VISIT_PAGE_SHADOW_BTN_CLICK(56),
        VIP_CENTER_PHOTO_PENDANT_CLICK(57),
        PHOTO_PENDANT_PAGE_SAVE_CLICK(58),
        PHOTO_PENDANT_PAGE_VIP_CLICK(59),
        VIP_CENTER_RENEW_SHOW(60),
        VIP_CENTER_RENEW_CLICK(61),
        IOS_REPEAT_BUY_POP_SHOW(62),
        PAY_CASHIER_PAGE_SHOW(63),
        NEW_USER_VIP_POP_SHOW(64),
        NEW_USER_VIP_POP_BUY_CLICK(65),
        VIP_LEVEL_PAGE_PRIVILEGE_CLICK(67),
        NEARBY_USER_VIP_POP_SHOW(68),
        NEARBY_USER_VIP_POP_BUY_CLICK(69),
        NEARBY_USER_VIP_UNLOCK_CLICK(70),
        LITE_HOME_PAGE_CALL_CLICK(71),
        LITE_MSG_PAGE_CALL_CLICK(72),
        VIRTUAL_BUY_CLICK(73),
        VIRTUAL_BUY_POP_YES_CLICK(74),
        VIRTUAL_BUY_POP_NO_CLICK(75),
        VIRTUAL_EDIT_PAGE_ACTIVITY_SHOW(76),
        VIRTUAL_EDIT_PAGE_ACTIVITY_CLICK(77),
        VIRTUAL_EDIT_PAGE_BUY_CLICK(78),
        VIRTUAL_EDIT_PAGE_WANDOU_CLICK(79),
        MAP_FIND_PASSBY_CLICK(80),
        MAP_FIND_PASSBY_POP_SWITCH_CLICK(81),
        MAP_FIND_PASSBY_POP_USER_SHOW(82),
        MAP_FIND_PASSBY_POP_USER_PHOTO_CLICK(83),
        MAP_FIND_PASSBY_POP_USER_CHAT_CLICK(84),
        MAP_FIND_PASSBY_POP_RED_DOT_SHOW(85),
        MAP_FIND_USER_SHOW(86),
        MAP_FIND_USER_CLICK(87),
        VIRTUAL_PACK_TAB_CLICK(88),
        VIP_BUY_PAGE_CANCEL_POP_NOW_CLICK(89),
        VISIT_PAGE_OFTEN_CLICK(90),
        VISIT_PAGE_EACH_CLICK(91),
        VISIT_PAGE_VAGUE_CLICK(92),
        NEW_USER_VIP_GUIDE_POP_SHOW(93),
        NEW_USER_VIP_GUIDE_POP_BUY_CLICK(94),
        VIP_UP_BLUEDX_POP_SHOW(95),
        VIP_UP_BLUEDX_POP_BUY_CLICK(96),
        UNRECOGNIZED(-1);
        
        public static final int FEATURED_FOR_YOU_PAGE_BUY_SVIP_BTN_CLICK_VALUE = 8;
        public static final int FEATURED_FOR_YOU_PAGE_SHOW_VALUE = 7;
        public static final int IOS_PAY_THIRD_STATUS_VALUE = 50;
        public static final int IOS_REPEAT_BUY_POP_SHOW_VALUE = 62;
        public static final int LITE_HOME_PAGE_CALL_CLICK_VALUE = 71;
        public static final int LITE_MSG_PAGE_CALL_CLICK_VALUE = 72;
        public static final int MAP_FIND_BACK_BTN_CLICK_VALUE = 10;
        public static final int MAP_FIND_PASSBY_CLICK_VALUE = 80;
        public static final int MAP_FIND_PASSBY_POP_RED_DOT_SHOW_VALUE = 85;
        public static final int MAP_FIND_PASSBY_POP_SWITCH_CLICK_VALUE = 81;
        public static final int MAP_FIND_PASSBY_POP_USER_CHAT_CLICK_VALUE = 84;
        public static final int MAP_FIND_PASSBY_POP_USER_PHOTO_CLICK_VALUE = 83;
        public static final int MAP_FIND_PASSBY_POP_USER_SHOW_VALUE = 82;
        public static final int MAP_FIND_SETTINGS_BTN_CLICK_VALUE = 30;
        public static final int MAP_FIND_SETTINGS_PAGE_SETTINGS_BTN_CLICK_VALUE = 31;
        public static final int MAP_FIND_USER_CLICK_VALUE = 87;
        public static final int MAP_FIND_USER_SHOW_VALUE = 86;
        public static final int MINE_HIDE_RANGE_BTN_CLICK_VALUE = 28;
        public static final int MINE_HIDE_TINE_BTN_CLICK_VALUE = 27;
        public static final int MINE_RANGE_TIME_BTN_CLICK_VALUE = 26;
        public static final int NEARBY_USER_VIP_POP_BUY_CLICK_VALUE = 69;
        public static final int NEARBY_USER_VIP_POP_SHOW_VALUE = 68;
        public static final int NEARBY_USER_VIP_UNLOCK_CLICK_VALUE = 70;
        public static final int NEW_USER_VIP_GUIDE_POP_BUY_CLICK_VALUE = 94;
        public static final int NEW_USER_VIP_GUIDE_POP_SHOW_VALUE = 93;
        public static final int NEW_USER_VIP_POP_BUY_CLICK_VALUE = 65;
        public static final int NEW_USER_VIP_POP_SHOW_VALUE = 64;
        public static final int NO_AD_PROPAGATE_BAN_CLICK_VALUE = 43;
        public static final int NO_AD_PROPAGATE_BUY_CLICK_VALUE = 40;
        public static final int NO_AD_PROPAGATE_CLOSE_CLICK_VALUE = 42;
        public static final int NO_AD_PROPAGATE_OPEN_CLICK_VALUE = 41;
        public static final int NO_AD_PROPAGATE_SHOW_VALUE = 39;
        public static final int ORDER_COUPON_CLICK_VALUE = 33;
        public static final int ORDER_COUPON_SHOW_VALUE = 32;
        public static final int PAY_CASHIER_PAGE_SHOW_VALUE = 63;
        public static final int PHOTO_PENDANT_PAGE_SAVE_CLICK_VALUE = 58;
        public static final int PHOTO_PENDANT_PAGE_VIP_CLICK_VALUE = 59;
        public static final int STEALTH_BTN_CLICK_VALUE = 4;
        public static final int UNKNOWN_EVENT_VALUE = 0;
        public static final int VIP_BACKFROUND_CHOOSE_PHOTO_BTN_CLICK_VALUE = 48;
        public static final int VIP_BACKFROUND_CHOOSE_SYSTEM_BTN_CLICK_VALUE = 47;
        public static final int VIP_BACKFROUND_PHOTOGRAPH_BTN_CLICK_VALUE = 49;
        public static final int VIP_BUY_BACK_BTN_CLICK_VALUE = 12;
        public static final int VIP_BUY_OPEN_BTN_CLICK_VALUE = 3;
        public static final int VIP_BUY_PAGE_CANCEL_POP_BUY_CLICK_VALUE = 38;
        public static final int VIP_BUY_PAGE_CANCEL_POP_CANCEL_CLICK_VALUE = 37;
        public static final int VIP_BUY_PAGE_CANCEL_POP_NOW_CLICK_VALUE = 89;
        public static final int VIP_BUY_PAGE_CANCEL_POP_SHOW_VALUE = 36;
        public static final int VIP_BUY_PAGE_MORE_BTN_CLICK_VALUE = 35;
        public static final int VIP_BUY_PAGE_MORE_BTN_SHOW_VALUE = 34;
        public static final int VIP_BUY_SHOW_VALUE = 1;
        public static final int VIP_BUY_SVIP_VALUE = 13;
        public static final int VIP_BUY_SWITCH_BTN_CLICK_VALUE = 2;
        public static final int VIP_CENTER_CAROUSEL_AREA_CLICK_VALUE = 24;
        public static final int VIP_CENTER_PHOTO_PENDANT_CLICK_VALUE = 57;
        public static final int VIP_CENTER_PRIVILEGE_CLICK_VALUE = 23;
        public static final int VIP_CENTER_RENEW_CLICK_VALUE = 61;
        public static final int VIP_CENTER_RENEW_SHOW_VALUE = 60;
        public static final int VIP_CENTER_TOP_RENEW_NOW_CLICK_VALUE = 29;
        public static final int VIP_CENTRE_BACK_BTN_CLICK_VALUE = 11;
        public static final int VIP_CENTRE_BANNER_CLICK_VALUE = 22;
        public static final int VIP_CENTRE_BANNER_SHOW_VALUE = 21;
        public static final int VIP_CENTRE_PAGE_SHOW_VALUE = 14;
        public static final int VIP_CENTRE_RESUME_BUY_BTN_CLICK_VALUE = 20;
        public static final int VIP_CENTRE_RESUME_BUY_BTN_SHOW_VALUE = 19;
        public static final int VIP_CENTRE_SUPER_HIDE_COMPLETE_BTN_CLICK_VALUE = 18;
        public static final int VIP_CENTRE_SUPER_HIDE_SECOND_BTN_CLICK_VALUE = 17;
        public static final int VIP_CENTRE_SUPER_HIDE_SECOND_PAGE_SHOW_VALUE = 16;
        public static final int VIP_CENTRE_VIP_UP_SVIP_CLICK_VALUE = 15;
        public static final int VIP_CHANGE_ICON_SAVE_BTN_CLICK_VALUE = 46;
        public static final int VIP_LEVEL_PAGE_PRIVILEGE_CLICK_VALUE = 67;
        public static final int VIP_LEVEL_PAGE_SHOW_VALUE = 44;
        public static final int VIP_LEVEL_PAGE_UP_BLUEDX_CLICK_VALUE = 45;
        public static final int VIP_PRIVACY_PHOTO_EXPAND_CLICK_VALUE = 51;
        public static final int VIP_PRIVACY_PHOTO_LOCKED_CLICK_VALUE = 53;
        public static final int VIP_PRIVACY_PHOTO_LOCKED_RENEW_CLICK_VALUE = 54;
        public static final int VIP_PRIVACY_PHOTO_LOCKED_SHOW_VALUE = 52;
        public static final int VIP_UP_BLUEDX_POP_BUY_CLICK_VALUE = 96;
        public static final int VIP_UP_BLUEDX_POP_SHOW_VALUE = 95;
        public static final int VIRTUAL_BUY_CLICK_VALUE = 73;
        public static final int VIRTUAL_BUY_POP_NO_CLICK_VALUE = 75;
        public static final int VIRTUAL_BUY_POP_YES_CLICK_VALUE = 74;
        public static final int VIRTUAL_EDIT_PAGE_ACTIVITY_CLICK_VALUE = 77;
        public static final int VIRTUAL_EDIT_PAGE_ACTIVITY_SHOW_VALUE = 76;
        public static final int VIRTUAL_EDIT_PAGE_BUY_CLICK_VALUE = 78;
        public static final int VIRTUAL_EDIT_PAGE_WANDOU_CLICK_VALUE = 79;
        public static final int VIRTUAL_PACK_TAB_CLICK_VALUE = 88;
        public static final int VISIT_PAGE_EACH_CLICK_VALUE = 91;
        public static final int VISIT_PAGE_NO_TRACE_BTN_CLICK_VALUE = 25;
        public static final int VISIT_PAGE_OFTEN_CLICK_VALUE = 90;
        public static final int VISIT_PAGE_SHADOW_BTN_CLICK_VALUE = 56;
        public static final int VISIT_PAGE_SHADOW_BTN_SHOW_VALUE = 55;
        public static final int VISIT_PAGE_VAGUE_CLICK_VALUE = 92;
        public static final int VOCATIVE_BACK_BTN_CLICK_VALUE = 9;
        public static final int VOCATIVE_OPEN_GET_MORE_EXPOSURE_BTN_CLICK_VALUE = 6;
        public static final int VOCATIVE_OPEN_GET_MORE_EXPOSURE_BTN_SHOW_VALUE = 5;
        private final int value;
        private static final Internal.EnumLiteMap<Event> internalValueMap = new Internal.EnumLiteMap<Event>() { // from class: com.blued.das.vip.VipProtos.Event.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Event findValueByNumber(int i) {
                return Event.forNumber(i);
            }
        };
        private static final Event[] VALUES = values();

        Event(int i) {
            this.value = i;
        }

        public static Event forNumber(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN_EVENT;
                case 1:
                    return VIP_BUY_SHOW;
                case 2:
                    return VIP_BUY_SWITCH_BTN_CLICK;
                case 3:
                    return VIP_BUY_OPEN_BTN_CLICK;
                case 4:
                    return STEALTH_BTN_CLICK;
                case 5:
                    return VOCATIVE_OPEN_GET_MORE_EXPOSURE_BTN_SHOW;
                case 6:
                    return VOCATIVE_OPEN_GET_MORE_EXPOSURE_BTN_CLICK;
                case 7:
                    return FEATURED_FOR_YOU_PAGE_SHOW;
                case 8:
                    return FEATURED_FOR_YOU_PAGE_BUY_SVIP_BTN_CLICK;
                case 9:
                    return VOCATIVE_BACK_BTN_CLICK;
                case 10:
                    return MAP_FIND_BACK_BTN_CLICK;
                case 11:
                    return VIP_CENTRE_BACK_BTN_CLICK;
                case 12:
                    return VIP_BUY_BACK_BTN_CLICK;
                case 13:
                    return VIP_BUY_SVIP;
                case 14:
                    return VIP_CENTRE_PAGE_SHOW;
                case 15:
                    return VIP_CENTRE_VIP_UP_SVIP_CLICK;
                case 16:
                    return VIP_CENTRE_SUPER_HIDE_SECOND_PAGE_SHOW;
                case 17:
                    return VIP_CENTRE_SUPER_HIDE_SECOND_BTN_CLICK;
                case 18:
                    return VIP_CENTRE_SUPER_HIDE_COMPLETE_BTN_CLICK;
                case 19:
                    return VIP_CENTRE_RESUME_BUY_BTN_SHOW;
                case 20:
                    return VIP_CENTRE_RESUME_BUY_BTN_CLICK;
                case 21:
                    return VIP_CENTRE_BANNER_SHOW;
                case 22:
                    return VIP_CENTRE_BANNER_CLICK;
                case 23:
                    return VIP_CENTER_PRIVILEGE_CLICK;
                case 24:
                    return VIP_CENTER_CAROUSEL_AREA_CLICK;
                case 25:
                    return VISIT_PAGE_NO_TRACE_BTN_CLICK;
                case 26:
                    return MINE_RANGE_TIME_BTN_CLICK;
                case 27:
                    return MINE_HIDE_TINE_BTN_CLICK;
                case 28:
                    return MINE_HIDE_RANGE_BTN_CLICK;
                case 29:
                    return VIP_CENTER_TOP_RENEW_NOW_CLICK;
                case 30:
                    return MAP_FIND_SETTINGS_BTN_CLICK;
                case 31:
                    return MAP_FIND_SETTINGS_PAGE_SETTINGS_BTN_CLICK;
                case 32:
                    return ORDER_COUPON_SHOW;
                case 33:
                    return ORDER_COUPON_CLICK;
                case 34:
                    return VIP_BUY_PAGE_MORE_BTN_SHOW;
                case 35:
                    return VIP_BUY_PAGE_MORE_BTN_CLICK;
                case 36:
                    return VIP_BUY_PAGE_CANCEL_POP_SHOW;
                case 37:
                    return VIP_BUY_PAGE_CANCEL_POP_CANCEL_CLICK;
                case 38:
                    return VIP_BUY_PAGE_CANCEL_POP_BUY_CLICK;
                case 39:
                    return NO_AD_PROPAGATE_SHOW;
                case 40:
                    return NO_AD_PROPAGATE_BUY_CLICK;
                case 41:
                    return NO_AD_PROPAGATE_OPEN_CLICK;
                case 42:
                    return NO_AD_PROPAGATE_CLOSE_CLICK;
                case 43:
                    return NO_AD_PROPAGATE_BAN_CLICK;
                case 44:
                    return VIP_LEVEL_PAGE_SHOW;
                case 45:
                    return VIP_LEVEL_PAGE_UP_BLUEDX_CLICK;
                case 46:
                    return VIP_CHANGE_ICON_SAVE_BTN_CLICK;
                case 47:
                    return VIP_BACKFROUND_CHOOSE_SYSTEM_BTN_CLICK;
                case 48:
                    return VIP_BACKFROUND_CHOOSE_PHOTO_BTN_CLICK;
                case 49:
                    return VIP_BACKFROUND_PHOTOGRAPH_BTN_CLICK;
                case 50:
                    return IOS_PAY_THIRD_STATUS;
                case 51:
                    return VIP_PRIVACY_PHOTO_EXPAND_CLICK;
                case 52:
                    return VIP_PRIVACY_PHOTO_LOCKED_SHOW;
                case 53:
                    return VIP_PRIVACY_PHOTO_LOCKED_CLICK;
                case 54:
                    return VIP_PRIVACY_PHOTO_LOCKED_RENEW_CLICK;
                case 55:
                    return VISIT_PAGE_SHADOW_BTN_SHOW;
                case 56:
                    return VISIT_PAGE_SHADOW_BTN_CLICK;
                case 57:
                    return VIP_CENTER_PHOTO_PENDANT_CLICK;
                case 58:
                    return PHOTO_PENDANT_PAGE_SAVE_CLICK;
                case 59:
                    return PHOTO_PENDANT_PAGE_VIP_CLICK;
                case 60:
                    return VIP_CENTER_RENEW_SHOW;
                case 61:
                    return VIP_CENTER_RENEW_CLICK;
                case 62:
                    return IOS_REPEAT_BUY_POP_SHOW;
                case 63:
                    return PAY_CASHIER_PAGE_SHOW;
                case 64:
                    return NEW_USER_VIP_POP_SHOW;
                case 65:
                    return NEW_USER_VIP_POP_BUY_CLICK;
                case 66:
                default:
                    return null;
                case 67:
                    return VIP_LEVEL_PAGE_PRIVILEGE_CLICK;
                case 68:
                    return NEARBY_USER_VIP_POP_SHOW;
                case 69:
                    return NEARBY_USER_VIP_POP_BUY_CLICK;
                case 70:
                    return NEARBY_USER_VIP_UNLOCK_CLICK;
                case 71:
                    return LITE_HOME_PAGE_CALL_CLICK;
                case 72:
                    return LITE_MSG_PAGE_CALL_CLICK;
                case 73:
                    return VIRTUAL_BUY_CLICK;
                case 74:
                    return VIRTUAL_BUY_POP_YES_CLICK;
                case 75:
                    return VIRTUAL_BUY_POP_NO_CLICK;
                case 76:
                    return VIRTUAL_EDIT_PAGE_ACTIVITY_SHOW;
                case 77:
                    return VIRTUAL_EDIT_PAGE_ACTIVITY_CLICK;
                case 78:
                    return VIRTUAL_EDIT_PAGE_BUY_CLICK;
                case 79:
                    return VIRTUAL_EDIT_PAGE_WANDOU_CLICK;
                case 80:
                    return MAP_FIND_PASSBY_CLICK;
                case 81:
                    return MAP_FIND_PASSBY_POP_SWITCH_CLICK;
                case 82:
                    return MAP_FIND_PASSBY_POP_USER_SHOW;
                case 83:
                    return MAP_FIND_PASSBY_POP_USER_PHOTO_CLICK;
                case 84:
                    return MAP_FIND_PASSBY_POP_USER_CHAT_CLICK;
                case 85:
                    return MAP_FIND_PASSBY_POP_RED_DOT_SHOW;
                case 86:
                    return MAP_FIND_USER_SHOW;
                case 87:
                    return MAP_FIND_USER_CLICK;
                case 88:
                    return VIRTUAL_PACK_TAB_CLICK;
                case 89:
                    return VIP_BUY_PAGE_CANCEL_POP_NOW_CLICK;
                case 90:
                    return VISIT_PAGE_OFTEN_CLICK;
                case 91:
                    return VISIT_PAGE_EACH_CLICK;
                case 92:
                    return VISIT_PAGE_VAGUE_CLICK;
                case 93:
                    return NEW_USER_VIP_GUIDE_POP_SHOW;
                case 94:
                    return NEW_USER_VIP_GUIDE_POP_BUY_CLICK;
                case 95:
                    return VIP_UP_BLUEDX_POP_SHOW;
                case 96:
                    return VIP_UP_BLUEDX_POP_BUY_CLICK;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return VipProtos.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<Event> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static Event valueOf(int i) {
            return forNumber(i);
        }

        public static Event valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                return enumValueDescriptor.getIndex() == -1 ? UNRECOGNIZED : VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/vip/VipProtos$FromType.class */
    public enum FromType implements ProtocolMessageEnum {
        UNKNOWN_FROM(0),
        HISTORY(1),
        TODAY_VISIT_REMAIN(2),
        FIFTEEN_VISIT_TREND(3),
        VISIT_ONLY_ONE(4),
        VISIT_NONE(5),
        APP_STORE(6),
        MSG_BUBBLE(7),
        FEED_DYNAMIC_SKIN(8),
        PRIVACY_PHOTO_EXPAND(9),
        PRIVACY_PHOTO_LOCKED_RENEW(10),
        PHOTO_PENDANT_OWN(11),
        PHOTO_PENDANT_OTHER(12),
        MAP_FIND_BUY(13),
        PHOTO_PENDANT_VIP_CENTER(14),
        NEARBY_FRIEND_AVATAR_LOC(15),
        NEARBY_FRIEND_MAP_FIND_NONE_TRIAL(16),
        NEARBY_FRIEND_MAP_FIND_TRIAL(17),
        PHOTO_FILTER(18),
        CONSTELLATION_FILTER(19),
        FIND_MAP_PASS(20),
        FLASH_PRIVILEGE(21),
        VISIT_OFTEN(22),
        VISIT_EACH(23),
        VISIT_VAGUE(24),
        AUTHENTICATED_FILTER(25),
        VIP_FILTER(26),
        DISTANCE_FILTER(27),
        ONLINE_FILTER(28),
        NEW_USER_GUIDE(29),
        SPECIAL_CARE(30),
        VIP_SPECIAL_CARE(31),
        VIP_PAY_PAGE(32),
        HIDE_CUSTOM(33),
        FOLLOW_QUIETLY(34),
        HIDE_FOR(35),
        LOOK_QUIETLY(36),
        TRACELESS_VISIT(37),
        MSG_GUIDE(38),
        VIP_HIDE_FOR(39),
        LEVEL_DISCOUNT(40),
        UNRECOGNIZED(-1);
        
        public static final int APP_STORE_VALUE = 6;
        public static final int AUTHENTICATED_FILTER_VALUE = 25;
        public static final int CONSTELLATION_FILTER_VALUE = 19;
        public static final int DISTANCE_FILTER_VALUE = 27;
        public static final int FEED_DYNAMIC_SKIN_VALUE = 8;
        public static final int FIFTEEN_VISIT_TREND_VALUE = 3;
        public static final int FIND_MAP_PASS_VALUE = 20;
        public static final int FLASH_PRIVILEGE_VALUE = 21;
        public static final int FOLLOW_QUIETLY_VALUE = 34;
        public static final int HIDE_CUSTOM_VALUE = 33;
        public static final int HIDE_FOR_VALUE = 35;
        public static final int HISTORY_VALUE = 1;
        public static final int LEVEL_DISCOUNT_VALUE = 40;
        public static final int LOOK_QUIETLY_VALUE = 36;
        public static final int MAP_FIND_BUY_VALUE = 13;
        public static final int MSG_BUBBLE_VALUE = 7;
        public static final int MSG_GUIDE_VALUE = 38;
        public static final int NEARBY_FRIEND_AVATAR_LOC_VALUE = 15;
        public static final int NEARBY_FRIEND_MAP_FIND_NONE_TRIAL_VALUE = 16;
        public static final int NEARBY_FRIEND_MAP_FIND_TRIAL_VALUE = 17;
        public static final int NEW_USER_GUIDE_VALUE = 29;
        public static final int ONLINE_FILTER_VALUE = 28;
        public static final int PHOTO_FILTER_VALUE = 18;
        public static final int PHOTO_PENDANT_OTHER_VALUE = 12;
        public static final int PHOTO_PENDANT_OWN_VALUE = 11;
        public static final int PHOTO_PENDANT_VIP_CENTER_VALUE = 14;
        public static final int PRIVACY_PHOTO_EXPAND_VALUE = 9;
        public static final int PRIVACY_PHOTO_LOCKED_RENEW_VALUE = 10;
        public static final int SPECIAL_CARE_VALUE = 30;
        public static final int TODAY_VISIT_REMAIN_VALUE = 2;
        public static final int TRACELESS_VISIT_VALUE = 37;
        public static final int UNKNOWN_FROM_VALUE = 0;
        public static final int VIP_FILTER_VALUE = 26;
        public static final int VIP_HIDE_FOR_VALUE = 39;
        public static final int VIP_PAY_PAGE_VALUE = 32;
        public static final int VIP_SPECIAL_CARE_VALUE = 31;
        public static final int VISIT_EACH_VALUE = 23;
        public static final int VISIT_NONE_VALUE = 5;
        public static final int VISIT_OFTEN_VALUE = 22;
        public static final int VISIT_ONLY_ONE_VALUE = 4;
        public static final int VISIT_VAGUE_VALUE = 24;
        private final int value;
        private static final Internal.EnumLiteMap<FromType> internalValueMap = new Internal.EnumLiteMap<FromType>() { // from class: com.blued.das.vip.VipProtos.FromType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public FromType findValueByNumber(int i) {
                return FromType.forNumber(i);
            }
        };
        private static final FromType[] VALUES = values();

        FromType(int i) {
            this.value = i;
        }

        public static FromType forNumber(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN_FROM;
                case 1:
                    return HISTORY;
                case 2:
                    return TODAY_VISIT_REMAIN;
                case 3:
                    return FIFTEEN_VISIT_TREND;
                case 4:
                    return VISIT_ONLY_ONE;
                case 5:
                    return VISIT_NONE;
                case 6:
                    return APP_STORE;
                case 7:
                    return MSG_BUBBLE;
                case 8:
                    return FEED_DYNAMIC_SKIN;
                case 9:
                    return PRIVACY_PHOTO_EXPAND;
                case 10:
                    return PRIVACY_PHOTO_LOCKED_RENEW;
                case 11:
                    return PHOTO_PENDANT_OWN;
                case 12:
                    return PHOTO_PENDANT_OTHER;
                case 13:
                    return MAP_FIND_BUY;
                case 14:
                    return PHOTO_PENDANT_VIP_CENTER;
                case 15:
                    return NEARBY_FRIEND_AVATAR_LOC;
                case 16:
                    return NEARBY_FRIEND_MAP_FIND_NONE_TRIAL;
                case 17:
                    return NEARBY_FRIEND_MAP_FIND_TRIAL;
                case 18:
                    return PHOTO_FILTER;
                case 19:
                    return CONSTELLATION_FILTER;
                case 20:
                    return FIND_MAP_PASS;
                case 21:
                    return FLASH_PRIVILEGE;
                case 22:
                    return VISIT_OFTEN;
                case 23:
                    return VISIT_EACH;
                case 24:
                    return VISIT_VAGUE;
                case 25:
                    return AUTHENTICATED_FILTER;
                case 26:
                    return VIP_FILTER;
                case 27:
                    return DISTANCE_FILTER;
                case 28:
                    return ONLINE_FILTER;
                case 29:
                    return NEW_USER_GUIDE;
                case 30:
                    return SPECIAL_CARE;
                case 31:
                    return VIP_SPECIAL_CARE;
                case 32:
                    return VIP_PAY_PAGE;
                case 33:
                    return HIDE_CUSTOM;
                case 34:
                    return FOLLOW_QUIETLY;
                case 35:
                    return HIDE_FOR;
                case 36:
                    return LOOK_QUIETLY;
                case 37:
                    return TRACELESS_VISIT;
                case 38:
                    return MSG_GUIDE;
                case 39:
                    return VIP_HIDE_FOR;
                case 40:
                    return LEVEL_DISCOUNT;
                default:
                    return null;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return VipProtos.getDescriptor().getEnumTypes().get(3);
        }

        public static Internal.EnumLiteMap<FromType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static FromType valueOf(int i) {
            return forNumber(i);
        }

        public static FromType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                return enumValueDescriptor.getIndex() == -1 ? UNRECOGNIZED : VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/vip/VipProtos$HideType.class */
    public enum HideType implements ProtocolMessageEnum {
        UNKNOWN_HIDE_TYPE(0),
        HIDE_ALL(1),
        HIDE_DISTANCE(2),
        HIDE_ROLE(3),
        HIDE_AGE(4),
        UNRECOGNIZED(-1);
        
        public static final int HIDE_AGE_VALUE = 4;
        public static final int HIDE_ALL_VALUE = 1;
        public static final int HIDE_DISTANCE_VALUE = 2;
        public static final int HIDE_ROLE_VALUE = 3;
        public static final int UNKNOWN_HIDE_TYPE_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<HideType> internalValueMap = new Internal.EnumLiteMap<HideType>() { // from class: com.blued.das.vip.VipProtos.HideType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public HideType findValueByNumber(int i) {
                return HideType.forNumber(i);
            }
        };
        private static final HideType[] VALUES = values();

        HideType(int i) {
            this.value = i;
        }

        public static HideType forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                return null;
                            }
                            return HIDE_AGE;
                        }
                        return HIDE_ROLE;
                    }
                    return HIDE_DISTANCE;
                }
                return HIDE_ALL;
            }
            return UNKNOWN_HIDE_TYPE;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return VipProtos.getDescriptor().getEnumTypes().get(9);
        }

        public static Internal.EnumLiteMap<HideType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static HideType valueOf(int i) {
            return forNumber(i);
        }

        public static HideType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                return enumValueDescriptor.getIndex() == -1 ? UNRECOGNIZED : VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/vip/VipProtos$IdentityType.class */
    public enum IdentityType implements ProtocolMessageEnum {
        UNKNOWN_IDENTITY_TYPE(0),
        NONE(1),
        VIP_TYPE(2),
        SVIP_TYPE(3),
        VIP_EXPIRED(4),
        SVIP_EXPIRED(5),
        UNRECOGNIZED(-1);
        
        public static final int NONE_VALUE = 1;
        public static final int SVIP_EXPIRED_VALUE = 5;
        public static final int SVIP_TYPE_VALUE = 3;
        public static final int UNKNOWN_IDENTITY_TYPE_VALUE = 0;
        public static final int VIP_EXPIRED_VALUE = 4;
        public static final int VIP_TYPE_VALUE = 2;
        private final int value;
        private static final Internal.EnumLiteMap<IdentityType> internalValueMap = new Internal.EnumLiteMap<IdentityType>() { // from class: com.blued.das.vip.VipProtos.IdentityType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public IdentityType findValueByNumber(int i) {
                return IdentityType.forNumber(i);
            }
        };
        private static final IdentityType[] VALUES = values();

        IdentityType(int i) {
            this.value = i;
        }

        public static IdentityType forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5) {
                                    return null;
                                }
                                return SVIP_EXPIRED;
                            }
                            return VIP_EXPIRED;
                        }
                        return SVIP_TYPE;
                    }
                    return VIP_TYPE;
                }
                return NONE;
            }
            return UNKNOWN_IDENTITY_TYPE;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return VipProtos.getDescriptor().getEnumTypes().get(7);
        }

        public static Internal.EnumLiteMap<IdentityType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static IdentityType valueOf(int i) {
            return forNumber(i);
        }

        public static IdentityType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                return enumValueDescriptor.getIndex() == -1 ? UNRECOGNIZED : VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/vip/VipProtos$Name.class */
    public enum Name implements ProtocolMessageEnum {
        UNKNOWN_NAME(0),
        VIP(1),
        SVIP(2),
        UNRECOGNIZED(-1);
        
        public static final int SVIP_VALUE = 2;
        public static final int UNKNOWN_NAME_VALUE = 0;
        public static final int VIP_VALUE = 1;
        private final int value;
        private static final Internal.EnumLiteMap<Name> internalValueMap = new Internal.EnumLiteMap<Name>() { // from class: com.blued.das.vip.VipProtos.Name.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Name findValueByNumber(int i) {
                return Name.forNumber(i);
            }
        };
        private static final Name[] VALUES = values();

        Name(int i) {
            this.value = i;
        }

        public static Name forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return SVIP;
                }
                return VIP;
            }
            return UNKNOWN_NAME;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return VipProtos.getDescriptor().getEnumTypes().get(2);
        }

        public static Internal.EnumLiteMap<Name> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static Name valueOf(int i) {
            return forNumber(i);
        }

        public static Name valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                return enumValueDescriptor.getIndex() == -1 ? UNRECOGNIZED : VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/vip/VipProtos$OrderType.class */
    public enum OrderType implements ProtocolMessageEnum {
        UNKNOWN_ORDER_TYPE(0),
        ORDER_VIP(1),
        ORDER_SVIP(2),
        ORDER_CALL(3),
        ORDER_EXPOSURE(4),
        ORDER_SHADOW(5),
        ORDER_WANDOU(6),
        ORDER_SOCIAL(7),
        UNRECOGNIZED(-1);
        
        public static final int ORDER_CALL_VALUE = 3;
        public static final int ORDER_EXPOSURE_VALUE = 4;
        public static final int ORDER_SHADOW_VALUE = 5;
        public static final int ORDER_SOCIAL_VALUE = 7;
        public static final int ORDER_SVIP_VALUE = 2;
        public static final int ORDER_VIP_VALUE = 1;
        public static final int ORDER_WANDOU_VALUE = 6;
        public static final int UNKNOWN_ORDER_TYPE_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<OrderType> internalValueMap = new Internal.EnumLiteMap<OrderType>() { // from class: com.blued.das.vip.VipProtos.OrderType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public OrderType findValueByNumber(int i) {
                return OrderType.forNumber(i);
            }
        };
        private static final OrderType[] VALUES = values();

        OrderType(int i) {
            this.value = i;
        }

        public static OrderType forNumber(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN_ORDER_TYPE;
                case 1:
                    return ORDER_VIP;
                case 2:
                    return ORDER_SVIP;
                case 3:
                    return ORDER_CALL;
                case 4:
                    return ORDER_EXPOSURE;
                case 5:
                    return ORDER_SHADOW;
                case 6:
                    return ORDER_WANDOU;
                case 7:
                    return ORDER_SOCIAL;
                default:
                    return null;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return VipProtos.getDescriptor().getEnumTypes().get(10);
        }

        public static Internal.EnumLiteMap<OrderType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static OrderType valueOf(int i) {
            return forNumber(i);
        }

        public static OrderType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                return enumValueDescriptor.getIndex() == -1 ? UNRECOGNIZED : VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/vip/VipProtos$PageLevel.class */
    public enum PageLevel implements ProtocolMessageEnum {
        UNKNOWN_PAGE_LEVEL(0),
        VIP_PAGE(1),
        SVIP_PAGE(2),
        VIP_BACK(3),
        UNRECOGNIZED(-1);
        
        public static final int SVIP_PAGE_VALUE = 2;
        public static final int UNKNOWN_PAGE_LEVEL_VALUE = 0;
        public static final int VIP_BACK_VALUE = 3;
        public static final int VIP_PAGE_VALUE = 1;
        private final int value;
        private static final Internal.EnumLiteMap<PageLevel> internalValueMap = new Internal.EnumLiteMap<PageLevel>() { // from class: com.blued.das.vip.VipProtos.PageLevel.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public PageLevel findValueByNumber(int i) {
                return PageLevel.forNumber(i);
            }
        };
        private static final PageLevel[] VALUES = values();

        PageLevel(int i) {
            this.value = i;
        }

        public static PageLevel forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return null;
                        }
                        return VIP_BACK;
                    }
                    return SVIP_PAGE;
                }
                return VIP_PAGE;
            }
            return UNKNOWN_PAGE_LEVEL;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return VipProtos.getDescriptor().getEnumTypes().get(8);
        }

        public static Internal.EnumLiteMap<PageLevel> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static PageLevel valueOf(int i) {
            return forNumber(i);
        }

        public static PageLevel valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                return enumValueDescriptor.getIndex() == -1 ? UNRECOGNIZED : VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/vip/VipProtos$PageVersion.class */
    public enum PageVersion implements ProtocolMessageEnum {
        UNKNOWN_PAGE_VERSION(0),
        V_0730(1),
        V_0813(2),
        UNRECOGNIZED(-1);
        
        public static final int UNKNOWN_PAGE_VERSION_VALUE = 0;
        public static final int V_0730_VALUE = 1;
        public static final int V_0813_VALUE = 2;
        private final int value;
        private static final Internal.EnumLiteMap<PageVersion> internalValueMap = new Internal.EnumLiteMap<PageVersion>() { // from class: com.blued.das.vip.VipProtos.PageVersion.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public PageVersion findValueByNumber(int i) {
                return PageVersion.forNumber(i);
            }
        };
        private static final PageVersion[] VALUES = values();

        PageVersion(int i) {
            this.value = i;
        }

        public static PageVersion forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return V_0813;
                }
                return V_0730;
            }
            return UNKNOWN_PAGE_VERSION;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return VipProtos.getDescriptor().getEnumTypes().get(6);
        }

        public static Internal.EnumLiteMap<PageVersion> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static PageVersion valueOf(int i) {
            return forNumber(i);
        }

        public static PageVersion valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                return enumValueDescriptor.getIndex() == -1 ? UNRECOGNIZED : VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/vip/VipProtos$StealthType.class */
    public enum StealthType implements ProtocolMessageEnum {
        UNKNOWN_STEALTH_TYPE(0),
        WHOLE(1),
        HALF(2),
        UNRECOGNIZED(-1);
        
        public static final int HALF_VALUE = 2;
        public static final int UNKNOWN_STEALTH_TYPE_VALUE = 0;
        public static final int WHOLE_VALUE = 1;
        private final int value;
        private static final Internal.EnumLiteMap<StealthType> internalValueMap = new Internal.EnumLiteMap<StealthType>() { // from class: com.blued.das.vip.VipProtos.StealthType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public StealthType findValueByNumber(int i) {
                return StealthType.forNumber(i);
            }
        };
        private static final StealthType[] VALUES = values();

        StealthType(int i) {
            this.value = i;
        }

        public static StealthType forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return HALF;
                }
                return WHOLE;
            }
            return UNKNOWN_STEALTH_TYPE;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return VipProtos.getDescriptor().getEnumTypes().get(4);
        }

        public static Internal.EnumLiteMap<StealthType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static StealthType valueOf(int i) {
            return forNumber(i);
        }

        public static StealthType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                return enumValueDescriptor.getIndex() == -1 ? UNRECOGNIZED : VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/vip/VipProtos$VipProto.class */
    public static final class VipProto extends GeneratedMessageV3 implements VipProtoOrBuilder {
        public static final int AD_PAGE_FIELD_NUMBER = 22;
        public static final int AD_TYPE_FIELD_NUMBER = 23;
        public static final int BANNER_ID_FIELD_NUMBER = 20;
        public static final int BANNER_URL_FIELD_NUMBER = 17;
        public static final int BTN_TYPE_FIELD_NUMBER = 19;
        public static final int COUNT_FIELD_NUMBER = 32;
        public static final int EVENT_FIELD_NUMBER = 1;
        public static final int FROM_FIELD_NUMBER = 3;
        public static final int HIDE_TYPE_FIELD_NUMBER = 12;
        public static final int IDENTITY_TYPE_FIELD_NUMBER = 8;
        public static final int ID_FIELD_NUMBER = 29;
        public static final int IMAGE_ID_FIELD_NUMBER = 26;
        public static final int IS_BUY_SUCCESS_FIELD_NUMBER = 9;
        public static final int IS_HIDE_AGE_FIELD_NUMBER = 16;
        public static final int IS_HIDE_ALL_FIELD_NUMBER = 13;
        public static final int IS_HIDE_DISTANCE_FIELD_NUMBER = 14;
        public static final int IS_HIDE_ROLE_FIELD_NUMBER = 15;
        public static final int IS_OPEN_FIELD_NUMBER = 10;
        public static final int IS_RANGE_FIELD_NUMBER = 5;
        public static final int IS_SHADOW_FIELD_NUMBER = 28;
        public static final int IS_SUCCESS_FIELD_NUMBER = 31;
        public static final int IS_VAGUE_FIELD_NUMBER = 37;
        public static final int LATITUDE_FIELD_NUMBER = 25;
        public static final int LONGITUDE_FIELD_NUMBER = 24;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int NUM_FIELD_NUMBER = 30;
        public static final int ORDER_ID_FIELD_NUMBER = 33;
        public static final int ORDER_TYPE_FIELD_NUMBER = 21;
        public static final int PAGE_LEVEL_FIELD_NUMBER = 11;
        public static final int PAGE_VERSION_FIELD_NUMBER = 7;
        public static final int PRIVILEGE_ID_FIELD_NUMBER = 18;
        public static final int SKU_ID_FIELD_NUMBER = 38;
        public static final int STEALTH_TYPE_FIELD_NUMBER = 4;
        public static final int TARGET_UID_FIELD_NUMBER = 35;
        public static final int THIRD_ID_FIELD_NUMBER = 27;
        public static final int TYPE_FIELD_NUMBER = 36;
        public static final int URL_FIELD_NUMBER = 34;
        public static final int VOCATIVE_TYPE_FIELD_NUMBER = 6;
        private static final long serialVersionUID = 0;
        private int adPage_;
        private volatile Object adType_;
        private volatile Object bannerId_;
        private volatile Object bannerUrl_;
        private int btnType_;
        private int count_;
        private int event_;
        private int from_;
        private int hideType_;
        private volatile Object id_;
        private int identityType_;
        private volatile Object imageId_;
        private boolean isBuySuccess_;
        private boolean isHideAge_;
        private boolean isHideAll_;
        private boolean isHideDistance_;
        private boolean isHideRole_;
        private boolean isOpen_;
        private boolean isRange_;
        private boolean isShadow_;
        private boolean isSuccess_;
        private boolean isVague_;
        private volatile Object latitude_;
        private volatile Object longitude_;
        private byte memoizedIsInitialized;
        private int name_;
        private int num_;
        private volatile Object orderId_;
        private int orderType_;
        private int pageLevel_;
        private int pageVersion_;
        private volatile Object privilegeId_;
        private volatile Object skuId_;
        private int stealthType_;
        private volatile Object targetUid_;
        private volatile Object thirdId_;
        private volatile Object type_;
        private volatile Object url_;
        private int vocativeType_;
        private static final VipProto DEFAULT_INSTANCE = new VipProto();
        private static final Parser<VipProto> PARSER = new AbstractParser<VipProto>() { // from class: com.blued.das.vip.VipProtos.VipProto.1
            @Override // com.google.protobuf.Parser
            public VipProto parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new VipProto(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/vip/VipProtos$VipProto$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements VipProtoOrBuilder {
            private int adPage_;
            private Object adType_;
            private Object bannerId_;
            private Object bannerUrl_;
            private int btnType_;
            private int count_;
            private int event_;
            private int from_;
            private int hideType_;
            private Object id_;
            private int identityType_;
            private Object imageId_;
            private boolean isBuySuccess_;
            private boolean isHideAge_;
            private boolean isHideAll_;
            private boolean isHideDistance_;
            private boolean isHideRole_;
            private boolean isOpen_;
            private boolean isRange_;
            private boolean isShadow_;
            private boolean isSuccess_;
            private boolean isVague_;
            private Object latitude_;
            private Object longitude_;
            private int name_;
            private int num_;
            private Object orderId_;
            private int orderType_;
            private int pageLevel_;
            private int pageVersion_;
            private Object privilegeId_;
            private Object skuId_;
            private int stealthType_;
            private Object targetUid_;
            private Object thirdId_;
            private Object type_;
            private Object url_;
            private int vocativeType_;

            private Builder() {
                this.event_ = 0;
                this.name_ = 0;
                this.from_ = 0;
                this.stealthType_ = 0;
                this.vocativeType_ = 0;
                this.pageVersion_ = 0;
                this.identityType_ = 0;
                this.pageLevel_ = 0;
                this.hideType_ = 0;
                this.bannerUrl_ = "";
                this.privilegeId_ = "";
                this.btnType_ = 0;
                this.bannerId_ = "";
                this.orderType_ = 0;
                this.adPage_ = 0;
                this.adType_ = "";
                this.longitude_ = "";
                this.latitude_ = "";
                this.imageId_ = "";
                this.thirdId_ = "";
                this.id_ = "";
                this.orderId_ = "";
                this.url_ = "";
                this.targetUid_ = "";
                this.type_ = "";
                this.skuId_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.event_ = 0;
                this.name_ = 0;
                this.from_ = 0;
                this.stealthType_ = 0;
                this.vocativeType_ = 0;
                this.pageVersion_ = 0;
                this.identityType_ = 0;
                this.pageLevel_ = 0;
                this.hideType_ = 0;
                this.bannerUrl_ = "";
                this.privilegeId_ = "";
                this.btnType_ = 0;
                this.bannerId_ = "";
                this.orderType_ = 0;
                this.adPage_ = 0;
                this.adType_ = "";
                this.longitude_ = "";
                this.latitude_ = "";
                this.imageId_ = "";
                this.thirdId_ = "";
                this.id_ = "";
                this.orderId_ = "";
                this.url_ = "";
                this.targetUid_ = "";
                this.type_ = "";
                this.skuId_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return VipProtos.internal_static_com_blued_das_vip_VipProto_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = VipProto.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VipProto build() {
                VipProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VipProto buildPartial() {
                VipProto vipProto = new VipProto(this);
                vipProto.event_ = this.event_;
                vipProto.name_ = this.name_;
                vipProto.from_ = this.from_;
                vipProto.stealthType_ = this.stealthType_;
                vipProto.isRange_ = this.isRange_;
                vipProto.vocativeType_ = this.vocativeType_;
                vipProto.pageVersion_ = this.pageVersion_;
                vipProto.identityType_ = this.identityType_;
                vipProto.isBuySuccess_ = this.isBuySuccess_;
                vipProto.isOpen_ = this.isOpen_;
                vipProto.pageLevel_ = this.pageLevel_;
                vipProto.hideType_ = this.hideType_;
                vipProto.isHideAll_ = this.isHideAll_;
                vipProto.isHideDistance_ = this.isHideDistance_;
                vipProto.isHideRole_ = this.isHideRole_;
                vipProto.isHideAge_ = this.isHideAge_;
                vipProto.bannerUrl_ = this.bannerUrl_;
                vipProto.privilegeId_ = this.privilegeId_;
                vipProto.btnType_ = this.btnType_;
                vipProto.bannerId_ = this.bannerId_;
                vipProto.orderType_ = this.orderType_;
                vipProto.adPage_ = this.adPage_;
                vipProto.adType_ = this.adType_;
                vipProto.longitude_ = this.longitude_;
                vipProto.latitude_ = this.latitude_;
                vipProto.imageId_ = this.imageId_;
                vipProto.thirdId_ = this.thirdId_;
                vipProto.isShadow_ = this.isShadow_;
                vipProto.id_ = this.id_;
                vipProto.num_ = this.num_;
                vipProto.isSuccess_ = this.isSuccess_;
                vipProto.count_ = this.count_;
                vipProto.orderId_ = this.orderId_;
                vipProto.url_ = this.url_;
                vipProto.targetUid_ = this.targetUid_;
                vipProto.type_ = this.type_;
                vipProto.isVague_ = this.isVague_;
                vipProto.skuId_ = this.skuId_;
                onBuilt();
                return vipProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.event_ = 0;
                this.name_ = 0;
                this.from_ = 0;
                this.stealthType_ = 0;
                this.isRange_ = false;
                this.vocativeType_ = 0;
                this.pageVersion_ = 0;
                this.identityType_ = 0;
                this.isBuySuccess_ = false;
                this.isOpen_ = false;
                this.pageLevel_ = 0;
                this.hideType_ = 0;
                this.isHideAll_ = false;
                this.isHideDistance_ = false;
                this.isHideRole_ = false;
                this.isHideAge_ = false;
                this.bannerUrl_ = "";
                this.privilegeId_ = "";
                this.btnType_ = 0;
                this.bannerId_ = "";
                this.orderType_ = 0;
                this.adPage_ = 0;
                this.adType_ = "";
                this.longitude_ = "";
                this.latitude_ = "";
                this.imageId_ = "";
                this.thirdId_ = "";
                this.isShadow_ = false;
                this.id_ = "";
                this.num_ = 0;
                this.isSuccess_ = false;
                this.count_ = 0;
                this.orderId_ = "";
                this.url_ = "";
                this.targetUid_ = "";
                this.type_ = "";
                this.isVague_ = false;
                this.skuId_ = "";
                return this;
            }

            public Builder clearAdPage() {
                this.adPage_ = 0;
                onChanged();
                return this;
            }

            public Builder clearAdType() {
                this.adType_ = VipProto.getDefaultInstance().getAdType();
                onChanged();
                return this;
            }

            public Builder clearBannerId() {
                this.bannerId_ = VipProto.getDefaultInstance().getBannerId();
                onChanged();
                return this;
            }

            public Builder clearBannerUrl() {
                this.bannerUrl_ = VipProto.getDefaultInstance().getBannerUrl();
                onChanged();
                return this;
            }

            public Builder clearBtnType() {
                this.btnType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearCount() {
                this.count_ = 0;
                onChanged();
                return this;
            }

            public Builder clearEvent() {
                this.event_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearFrom() {
                this.from_ = 0;
                onChanged();
                return this;
            }

            public Builder clearHideType() {
                this.hideType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.id_ = VipProto.getDefaultInstance().getId();
                onChanged();
                return this;
            }

            public Builder clearIdentityType() {
                this.identityType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearImageId() {
                this.imageId_ = VipProto.getDefaultInstance().getImageId();
                onChanged();
                return this;
            }

            public Builder clearIsBuySuccess() {
                this.isBuySuccess_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsHideAge() {
                this.isHideAge_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsHideAll() {
                this.isHideAll_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsHideDistance() {
                this.isHideDistance_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsHideRole() {
                this.isHideRole_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsOpen() {
                this.isOpen_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsRange() {
                this.isRange_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsShadow() {
                this.isShadow_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsSuccess() {
                this.isSuccess_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsVague() {
                this.isVague_ = false;
                onChanged();
                return this;
            }

            public Builder clearLatitude() {
                this.latitude_ = VipProto.getDefaultInstance().getLatitude();
                onChanged();
                return this;
            }

            public Builder clearLongitude() {
                this.longitude_ = VipProto.getDefaultInstance().getLongitude();
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.name_ = 0;
                onChanged();
                return this;
            }

            public Builder clearNum() {
                this.num_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearOrderId() {
                this.orderId_ = VipProto.getDefaultInstance().getOrderId();
                onChanged();
                return this;
            }

            public Builder clearOrderType() {
                this.orderType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearPageLevel() {
                this.pageLevel_ = 0;
                onChanged();
                return this;
            }

            public Builder clearPageVersion() {
                this.pageVersion_ = 0;
                onChanged();
                return this;
            }

            public Builder clearPrivilegeId() {
                this.privilegeId_ = VipProto.getDefaultInstance().getPrivilegeId();
                onChanged();
                return this;
            }

            public Builder clearSkuId() {
                this.skuId_ = VipProto.getDefaultInstance().getSkuId();
                onChanged();
                return this;
            }

            public Builder clearStealthType() {
                this.stealthType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTargetUid() {
                this.targetUid_ = VipProto.getDefaultInstance().getTargetUid();
                onChanged();
                return this;
            }

            public Builder clearThirdId() {
                this.thirdId_ = VipProto.getDefaultInstance().getThirdId();
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = VipProto.getDefaultInstance().getType();
                onChanged();
                return this;
            }

            public Builder clearUrl() {
                this.url_ = VipProto.getDefaultInstance().getUrl();
                onChanged();
                return this;
            }

            public Builder clearVocativeType() {
                this.vocativeType_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2030clone() {
                return (Builder) super.mo2030clone();
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public AdPage getAdPage() {
                AdPage valueOf = AdPage.valueOf(this.adPage_);
                AdPage adPage = valueOf;
                if (valueOf == null) {
                    adPage = AdPage.UNRECOGNIZED;
                }
                return adPage;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public int getAdPageValue() {
                return this.adPage_;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public String getAdType() {
                Object obj = this.adType_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.adType_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public ByteString getAdTypeBytes() {
                Object obj = this.adType_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.adType_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public String getBannerId() {
                Object obj = this.bannerId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.bannerId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public ByteString getBannerIdBytes() {
                Object obj = this.bannerId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.bannerId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public String getBannerUrl() {
                Object obj = this.bannerUrl_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.bannerUrl_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public ByteString getBannerUrlBytes() {
                Object obj = this.bannerUrl_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.bannerUrl_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public BtnType getBtnType() {
                BtnType valueOf = BtnType.valueOf(this.btnType_);
                BtnType btnType = valueOf;
                if (valueOf == null) {
                    btnType = BtnType.UNRECOGNIZED;
                }
                return btnType;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public int getBtnTypeValue() {
                return this.btnType_;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public int getCount() {
                return this.count_;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public VipProto getDefaultInstanceForType() {
                return VipProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return VipProtos.internal_static_com_blued_das_vip_VipProto_descriptor;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public Event getEvent() {
                Event valueOf = Event.valueOf(this.event_);
                Event event = valueOf;
                if (valueOf == null) {
                    event = Event.UNRECOGNIZED;
                }
                return event;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public int getEventValue() {
                return this.event_;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public FromType getFrom() {
                FromType valueOf = FromType.valueOf(this.from_);
                FromType fromType = valueOf;
                if (valueOf == null) {
                    fromType = FromType.UNRECOGNIZED;
                }
                return fromType;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public int getFromValue() {
                return this.from_;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public HideType getHideType() {
                HideType valueOf = HideType.valueOf(this.hideType_);
                HideType hideType = valueOf;
                if (valueOf == null) {
                    hideType = HideType.UNRECOGNIZED;
                }
                return hideType;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public int getHideTypeValue() {
                return this.hideType_;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public String getId() {
                Object obj = this.id_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.id_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public ByteString getIdBytes() {
                Object obj = this.id_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.id_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public IdentityType getIdentityType() {
                IdentityType valueOf = IdentityType.valueOf(this.identityType_);
                IdentityType identityType = valueOf;
                if (valueOf == null) {
                    identityType = IdentityType.UNRECOGNIZED;
                }
                return identityType;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public int getIdentityTypeValue() {
                return this.identityType_;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public String getImageId() {
                Object obj = this.imageId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.imageId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public ByteString getImageIdBytes() {
                Object obj = this.imageId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.imageId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public boolean getIsBuySuccess() {
                return this.isBuySuccess_;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public boolean getIsHideAge() {
                return this.isHideAge_;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public boolean getIsHideAll() {
                return this.isHideAll_;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public boolean getIsHideDistance() {
                return this.isHideDistance_;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public boolean getIsHideRole() {
                return this.isHideRole_;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public boolean getIsOpen() {
                return this.isOpen_;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public boolean getIsRange() {
                return this.isRange_;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public boolean getIsShadow() {
                return this.isShadow_;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public boolean getIsSuccess() {
                return this.isSuccess_;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public boolean getIsVague() {
                return this.isVague_;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public String getLatitude() {
                Object obj = this.latitude_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.latitude_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public ByteString getLatitudeBytes() {
                Object obj = this.latitude_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.latitude_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public String getLongitude() {
                Object obj = this.longitude_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.longitude_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public ByteString getLongitudeBytes() {
                Object obj = this.longitude_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.longitude_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public Name getName() {
                Name valueOf = Name.valueOf(this.name_);
                Name name = valueOf;
                if (valueOf == null) {
                    name = Name.UNRECOGNIZED;
                }
                return name;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public int getNameValue() {
                return this.name_;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public int getNum() {
                return this.num_;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public String getOrderId() {
                Object obj = this.orderId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.orderId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public ByteString getOrderIdBytes() {
                Object obj = this.orderId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.orderId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public OrderType getOrderType() {
                OrderType valueOf = OrderType.valueOf(this.orderType_);
                OrderType orderType = valueOf;
                if (valueOf == null) {
                    orderType = OrderType.UNRECOGNIZED;
                }
                return orderType;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public int getOrderTypeValue() {
                return this.orderType_;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public PageLevel getPageLevel() {
                PageLevel valueOf = PageLevel.valueOf(this.pageLevel_);
                PageLevel pageLevel = valueOf;
                if (valueOf == null) {
                    pageLevel = PageLevel.UNRECOGNIZED;
                }
                return pageLevel;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public int getPageLevelValue() {
                return this.pageLevel_;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public PageVersion getPageVersion() {
                PageVersion valueOf = PageVersion.valueOf(this.pageVersion_);
                PageVersion pageVersion = valueOf;
                if (valueOf == null) {
                    pageVersion = PageVersion.UNRECOGNIZED;
                }
                return pageVersion;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public int getPageVersionValue() {
                return this.pageVersion_;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public String getPrivilegeId() {
                Object obj = this.privilegeId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.privilegeId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public ByteString getPrivilegeIdBytes() {
                Object obj = this.privilegeId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.privilegeId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public String getSkuId() {
                Object obj = this.skuId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.skuId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public ByteString getSkuIdBytes() {
                Object obj = this.skuId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.skuId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public StealthType getStealthType() {
                StealthType valueOf = StealthType.valueOf(this.stealthType_);
                StealthType stealthType = valueOf;
                if (valueOf == null) {
                    stealthType = StealthType.UNRECOGNIZED;
                }
                return stealthType;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public int getStealthTypeValue() {
                return this.stealthType_;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public String getTargetUid() {
                Object obj = this.targetUid_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.targetUid_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public ByteString getTargetUidBytes() {
                Object obj = this.targetUid_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.targetUid_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public String getThirdId() {
                Object obj = this.thirdId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.thirdId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public ByteString getThirdIdBytes() {
                Object obj = this.thirdId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.thirdId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public String getType() {
                Object obj = this.type_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.type_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public ByteString getTypeBytes() {
                Object obj = this.type_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.type_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public String getUrl() {
                Object obj = this.url_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.url_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public ByteString getUrlBytes() {
                Object obj = this.url_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.url_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public VocativeType getVocativeType() {
                VocativeType valueOf = VocativeType.valueOf(this.vocativeType_);
                VocativeType vocativeType = valueOf;
                if (valueOf == null) {
                    vocativeType = VocativeType.UNRECOGNIZED;
                }
                return vocativeType;
            }

            @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
            public int getVocativeTypeValue() {
                return this.vocativeType_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return VipProtos.internal_static_com_blued_das_vip_VipProto_fieldAccessorTable.ensureFieldAccessorsInitialized(VipProto.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(VipProto vipProto) {
                if (vipProto == VipProto.getDefaultInstance()) {
                    return this;
                }
                if (vipProto.event_ != 0) {
                    setEventValue(vipProto.getEventValue());
                }
                if (vipProto.name_ != 0) {
                    setNameValue(vipProto.getNameValue());
                }
                if (vipProto.from_ != 0) {
                    setFromValue(vipProto.getFromValue());
                }
                if (vipProto.stealthType_ != 0) {
                    setStealthTypeValue(vipProto.getStealthTypeValue());
                }
                if (vipProto.getIsRange()) {
                    setIsRange(vipProto.getIsRange());
                }
                if (vipProto.vocativeType_ != 0) {
                    setVocativeTypeValue(vipProto.getVocativeTypeValue());
                }
                if (vipProto.pageVersion_ != 0) {
                    setPageVersionValue(vipProto.getPageVersionValue());
                }
                if (vipProto.identityType_ != 0) {
                    setIdentityTypeValue(vipProto.getIdentityTypeValue());
                }
                if (vipProto.getIsBuySuccess()) {
                    setIsBuySuccess(vipProto.getIsBuySuccess());
                }
                if (vipProto.getIsOpen()) {
                    setIsOpen(vipProto.getIsOpen());
                }
                if (vipProto.pageLevel_ != 0) {
                    setPageLevelValue(vipProto.getPageLevelValue());
                }
                if (vipProto.hideType_ != 0) {
                    setHideTypeValue(vipProto.getHideTypeValue());
                }
                if (vipProto.getIsHideAll()) {
                    setIsHideAll(vipProto.getIsHideAll());
                }
                if (vipProto.getIsHideDistance()) {
                    setIsHideDistance(vipProto.getIsHideDistance());
                }
                if (vipProto.getIsHideRole()) {
                    setIsHideRole(vipProto.getIsHideRole());
                }
                if (vipProto.getIsHideAge()) {
                    setIsHideAge(vipProto.getIsHideAge());
                }
                if (!vipProto.getBannerUrl().isEmpty()) {
                    this.bannerUrl_ = vipProto.bannerUrl_;
                    onChanged();
                }
                if (!vipProto.getPrivilegeId().isEmpty()) {
                    this.privilegeId_ = vipProto.privilegeId_;
                    onChanged();
                }
                if (vipProto.btnType_ != 0) {
                    setBtnTypeValue(vipProto.getBtnTypeValue());
                }
                if (!vipProto.getBannerId().isEmpty()) {
                    this.bannerId_ = vipProto.bannerId_;
                    onChanged();
                }
                if (vipProto.orderType_ != 0) {
                    setOrderTypeValue(vipProto.getOrderTypeValue());
                }
                if (vipProto.adPage_ != 0) {
                    setAdPageValue(vipProto.getAdPageValue());
                }
                if (!vipProto.getAdType().isEmpty()) {
                    this.adType_ = vipProto.adType_;
                    onChanged();
                }
                if (!vipProto.getLongitude().isEmpty()) {
                    this.longitude_ = vipProto.longitude_;
                    onChanged();
                }
                if (!vipProto.getLatitude().isEmpty()) {
                    this.latitude_ = vipProto.latitude_;
                    onChanged();
                }
                if (!vipProto.getImageId().isEmpty()) {
                    this.imageId_ = vipProto.imageId_;
                    onChanged();
                }
                if (!vipProto.getThirdId().isEmpty()) {
                    this.thirdId_ = vipProto.thirdId_;
                    onChanged();
                }
                if (vipProto.getIsShadow()) {
                    setIsShadow(vipProto.getIsShadow());
                }
                if (!vipProto.getId().isEmpty()) {
                    this.id_ = vipProto.id_;
                    onChanged();
                }
                if (vipProto.getNum() != 0) {
                    setNum(vipProto.getNum());
                }
                if (vipProto.getIsSuccess()) {
                    setIsSuccess(vipProto.getIsSuccess());
                }
                if (vipProto.getCount() != 0) {
                    setCount(vipProto.getCount());
                }
                if (!vipProto.getOrderId().isEmpty()) {
                    this.orderId_ = vipProto.orderId_;
                    onChanged();
                }
                if (!vipProto.getUrl().isEmpty()) {
                    this.url_ = vipProto.url_;
                    onChanged();
                }
                if (!vipProto.getTargetUid().isEmpty()) {
                    this.targetUid_ = vipProto.targetUid_;
                    onChanged();
                }
                if (!vipProto.getType().isEmpty()) {
                    this.type_ = vipProto.type_;
                    onChanged();
                }
                if (vipProto.getIsVague()) {
                    setIsVague(vipProto.getIsVague());
                }
                if (!vipProto.getSkuId().isEmpty()) {
                    this.skuId_ = vipProto.skuId_;
                    onChanged();
                }
                mergeUnknownFields(vipProto.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.das.vip.VipProtos.VipProto.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.das.vip.VipProtos.VipProto.access$4500()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.das.vip.VipProtos$VipProto r0 = (com.blued.das.vip.VipProtos.VipProto) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.das.vip.VipProtos$VipProto$Builder r0 = r0.mergeFrom(r1)
                L1a:
                    r0 = r4
                    return r0
                L1c:
                    r6 = move-exception
                    r0 = r7
                    r5 = r0
                    goto L31
                L22:
                    r6 = move-exception
                    r0 = r6
                    com.google.protobuf.MessageLite r0 = r0.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L1c
                    com.blued.das.vip.VipProtos$VipProto r0 = (com.blued.das.vip.VipProtos.VipProto) r0     // Catch: java.lang.Throwable -> L1c
                    r5 = r0
                    r0 = r6
                    java.io.IOException r0 = r0.unwrapIOException()     // Catch: java.lang.Throwable -> L30
                    throw r0     // Catch: java.lang.Throwable -> L30
                L30:
                    r6 = move-exception
                L31:
                    r0 = r5
                    if (r0 == 0) goto L3b
                    r0 = r4
                    r1 = r5
                    com.blued.das.vip.VipProtos$VipProto$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.das.vip.VipProtos.VipProto.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.das.vip.VipProtos$VipProto$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof VipProto) {
                    return mergeFrom((VipProto) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setAdPage(AdPage adPage) {
                if (adPage != null) {
                    this.adPage_ = adPage.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setAdPageValue(int i) {
                this.adPage_ = i;
                onChanged();
                return this;
            }

            public Builder setAdType(String str) {
                if (str != null) {
                    this.adType_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setAdTypeBytes(ByteString byteString) {
                if (byteString != null) {
                    VipProto.checkByteStringIsUtf8(byteString);
                    this.adType_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setBannerId(String str) {
                if (str != null) {
                    this.bannerId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setBannerIdBytes(ByteString byteString) {
                if (byteString != null) {
                    VipProto.checkByteStringIsUtf8(byteString);
                    this.bannerId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setBannerUrl(String str) {
                if (str != null) {
                    this.bannerUrl_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setBannerUrlBytes(ByteString byteString) {
                if (byteString != null) {
                    VipProto.checkByteStringIsUtf8(byteString);
                    this.bannerUrl_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setBtnType(BtnType btnType) {
                if (btnType != null) {
                    this.btnType_ = btnType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setBtnTypeValue(int i) {
                this.btnType_ = i;
                onChanged();
                return this;
            }

            public Builder setCount(int i) {
                this.count_ = i;
                onChanged();
                return this;
            }

            public Builder setEvent(Event event) {
                if (event != null) {
                    this.event_ = event.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setEventValue(int i) {
                this.event_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setFrom(FromType fromType) {
                if (fromType != null) {
                    this.from_ = fromType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setFromValue(int i) {
                this.from_ = i;
                onChanged();
                return this;
            }

            public Builder setHideType(HideType hideType) {
                if (hideType != null) {
                    this.hideType_ = hideType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setHideTypeValue(int i) {
                this.hideType_ = i;
                onChanged();
                return this;
            }

            public Builder setId(String str) {
                if (str != null) {
                    this.id_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setIdBytes(ByteString byteString) {
                if (byteString != null) {
                    VipProto.checkByteStringIsUtf8(byteString);
                    this.id_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setIdentityType(IdentityType identityType) {
                if (identityType != null) {
                    this.identityType_ = identityType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setIdentityTypeValue(int i) {
                this.identityType_ = i;
                onChanged();
                return this;
            }

            public Builder setImageId(String str) {
                if (str != null) {
                    this.imageId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setImageIdBytes(ByteString byteString) {
                if (byteString != null) {
                    VipProto.checkByteStringIsUtf8(byteString);
                    this.imageId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setIsBuySuccess(boolean z) {
                this.isBuySuccess_ = z;
                onChanged();
                return this;
            }

            public Builder setIsHideAge(boolean z) {
                this.isHideAge_ = z;
                onChanged();
                return this;
            }

            public Builder setIsHideAll(boolean z) {
                this.isHideAll_ = z;
                onChanged();
                return this;
            }

            public Builder setIsHideDistance(boolean z) {
                this.isHideDistance_ = z;
                onChanged();
                return this;
            }

            public Builder setIsHideRole(boolean z) {
                this.isHideRole_ = z;
                onChanged();
                return this;
            }

            public Builder setIsOpen(boolean z) {
                this.isOpen_ = z;
                onChanged();
                return this;
            }

            public Builder setIsRange(boolean z) {
                this.isRange_ = z;
                onChanged();
                return this;
            }

            public Builder setIsShadow(boolean z) {
                this.isShadow_ = z;
                onChanged();
                return this;
            }

            public Builder setIsSuccess(boolean z) {
                this.isSuccess_ = z;
                onChanged();
                return this;
            }

            public Builder setIsVague(boolean z) {
                this.isVague_ = z;
                onChanged();
                return this;
            }

            public Builder setLatitude(String str) {
                if (str != null) {
                    this.latitude_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLatitudeBytes(ByteString byteString) {
                if (byteString != null) {
                    VipProto.checkByteStringIsUtf8(byteString);
                    this.latitude_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLongitude(String str) {
                if (str != null) {
                    this.longitude_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLongitudeBytes(ByteString byteString) {
                if (byteString != null) {
                    VipProto.checkByteStringIsUtf8(byteString);
                    this.longitude_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setName(Name name) {
                if (name != null) {
                    this.name_ = name.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setNameValue(int i) {
                this.name_ = i;
                onChanged();
                return this;
            }

            public Builder setNum(int i) {
                this.num_ = i;
                onChanged();
                return this;
            }

            public Builder setOrderId(String str) {
                if (str != null) {
                    this.orderId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setOrderIdBytes(ByteString byteString) {
                if (byteString != null) {
                    VipProto.checkByteStringIsUtf8(byteString);
                    this.orderId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setOrderType(OrderType orderType) {
                if (orderType != null) {
                    this.orderType_ = orderType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setOrderTypeValue(int i) {
                this.orderType_ = i;
                onChanged();
                return this;
            }

            public Builder setPageLevel(PageLevel pageLevel) {
                if (pageLevel != null) {
                    this.pageLevel_ = pageLevel.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setPageLevelValue(int i) {
                this.pageLevel_ = i;
                onChanged();
                return this;
            }

            public Builder setPageVersion(PageVersion pageVersion) {
                if (pageVersion != null) {
                    this.pageVersion_ = pageVersion.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setPageVersionValue(int i) {
                this.pageVersion_ = i;
                onChanged();
                return this;
            }

            public Builder setPrivilegeId(String str) {
                if (str != null) {
                    this.privilegeId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setPrivilegeIdBytes(ByteString byteString) {
                if (byteString != null) {
                    VipProto.checkByteStringIsUtf8(byteString);
                    this.privilegeId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setSkuId(String str) {
                if (str != null) {
                    this.skuId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setSkuIdBytes(ByteString byteString) {
                if (byteString != null) {
                    VipProto.checkByteStringIsUtf8(byteString);
                    this.skuId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setStealthType(StealthType stealthType) {
                if (stealthType != null) {
                    this.stealthType_ = stealthType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setStealthTypeValue(int i) {
                this.stealthType_ = i;
                onChanged();
                return this;
            }

            public Builder setTargetUid(String str) {
                if (str != null) {
                    this.targetUid_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setTargetUidBytes(ByteString byteString) {
                if (byteString != null) {
                    VipProto.checkByteStringIsUtf8(byteString);
                    this.targetUid_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setThirdId(String str) {
                if (str != null) {
                    this.thirdId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setThirdIdBytes(ByteString byteString) {
                if (byteString != null) {
                    VipProto.checkByteStringIsUtf8(byteString);
                    this.thirdId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setType(String str) {
                if (str != null) {
                    this.type_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setTypeBytes(ByteString byteString) {
                if (byteString != null) {
                    VipProto.checkByteStringIsUtf8(byteString);
                    this.type_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public Builder setUrl(String str) {
                if (str != null) {
                    this.url_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setUrlBytes(ByteString byteString) {
                if (byteString != null) {
                    VipProto.checkByteStringIsUtf8(byteString);
                    this.url_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setVocativeType(VocativeType vocativeType) {
                if (vocativeType != null) {
                    this.vocativeType_ = vocativeType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setVocativeTypeValue(int i) {
                this.vocativeType_ = i;
                onChanged();
                return this;
            }
        }

        private VipProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.event_ = 0;
            this.name_ = 0;
            this.from_ = 0;
            this.stealthType_ = 0;
            this.vocativeType_ = 0;
            this.pageVersion_ = 0;
            this.identityType_ = 0;
            this.pageLevel_ = 0;
            this.hideType_ = 0;
            this.bannerUrl_ = "";
            this.privilegeId_ = "";
            this.btnType_ = 0;
            this.bannerId_ = "";
            this.orderType_ = 0;
            this.adPage_ = 0;
            this.adType_ = "";
            this.longitude_ = "";
            this.latitude_ = "";
            this.imageId_ = "";
            this.thirdId_ = "";
            this.id_ = "";
            this.orderId_ = "";
            this.url_ = "";
            this.targetUid_ = "";
            this.type_ = "";
            this.skuId_ = "";
        }

        private VipProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw null;
            }
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 8:
                                    this.event_ = codedInputStream.readEnum();
                                    continue;
                                case 16:
                                    this.name_ = codedInputStream.readEnum();
                                    continue;
                                case 24:
                                    this.from_ = codedInputStream.readEnum();
                                    continue;
                                case 32:
                                    this.stealthType_ = codedInputStream.readEnum();
                                    continue;
                                case 40:
                                    this.isRange_ = codedInputStream.readBool();
                                    continue;
                                case 48:
                                    this.vocativeType_ = codedInputStream.readEnum();
                                    continue;
                                case 56:
                                    this.pageVersion_ = codedInputStream.readEnum();
                                    continue;
                                case 64:
                                    this.identityType_ = codedInputStream.readEnum();
                                    continue;
                                case 72:
                                    this.isBuySuccess_ = codedInputStream.readBool();
                                    continue;
                                case 80:
                                    this.isOpen_ = codedInputStream.readBool();
                                    continue;
                                case 88:
                                    this.pageLevel_ = codedInputStream.readEnum();
                                    continue;
                                case 96:
                                    this.hideType_ = codedInputStream.readEnum();
                                    continue;
                                case 104:
                                    this.isHideAll_ = codedInputStream.readBool();
                                    continue;
                                case 112:
                                    this.isHideDistance_ = codedInputStream.readBool();
                                    continue;
                                case 120:
                                    this.isHideRole_ = codedInputStream.readBool();
                                    continue;
                                case 128:
                                    this.isHideAge_ = codedInputStream.readBool();
                                    continue;
                                case 138:
                                    this.bannerUrl_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 146:
                                    this.privilegeId_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 152:
                                    this.btnType_ = codedInputStream.readEnum();
                                    continue;
                                case 162:
                                    this.bannerId_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 168:
                                    this.orderType_ = codedInputStream.readEnum();
                                    continue;
                                case 176:
                                    this.adPage_ = codedInputStream.readEnum();
                                    continue;
                                case 186:
                                    this.adType_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 194:
                                    this.longitude_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 202:
                                    this.latitude_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 210:
                                    this.imageId_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 218:
                                    this.thirdId_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 224:
                                    this.isShadow_ = codedInputStream.readBool();
                                    continue;
                                case 234:
                                    this.id_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 240:
                                    this.num_ = codedInputStream.readInt32();
                                    continue;
                                case 248:
                                    this.isSuccess_ = codedInputStream.readBool();
                                    continue;
                                case 256:
                                    this.count_ = codedInputStream.readInt32();
                                    continue;
                                case 266:
                                    this.orderId_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 274:
                                    this.url_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 282:
                                    this.targetUid_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 290:
                                    this.type_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 296:
                                    this.isVague_ = codedInputStream.readBool();
                                    continue;
                                case 306:
                                    this.skuId_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                default:
                                    if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                        break;
                                    } else {
                                        continue;
                                    }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw e.setUnfinishedMessage(this);
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        private VipProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static VipProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return VipProtos.internal_static_com_blued_das_vip_VipProto_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(VipProto vipProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(vipProto);
        }

        public static VipProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (VipProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static VipProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (VipProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static VipProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static VipProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static VipProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (VipProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static VipProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (VipProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static VipProto parseFrom(InputStream inputStream) throws IOException {
            return (VipProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static VipProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (VipProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static VipProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static VipProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static VipProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static VipProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<VipProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof VipProto) {
                VipProto vipProto = (VipProto) obj;
                return this.event_ == vipProto.event_ && this.name_ == vipProto.name_ && this.from_ == vipProto.from_ && this.stealthType_ == vipProto.stealthType_ && getIsRange() == vipProto.getIsRange() && this.vocativeType_ == vipProto.vocativeType_ && this.pageVersion_ == vipProto.pageVersion_ && this.identityType_ == vipProto.identityType_ && getIsBuySuccess() == vipProto.getIsBuySuccess() && getIsOpen() == vipProto.getIsOpen() && this.pageLevel_ == vipProto.pageLevel_ && this.hideType_ == vipProto.hideType_ && getIsHideAll() == vipProto.getIsHideAll() && getIsHideDistance() == vipProto.getIsHideDistance() && getIsHideRole() == vipProto.getIsHideRole() && getIsHideAge() == vipProto.getIsHideAge() && getBannerUrl().equals(vipProto.getBannerUrl()) && getPrivilegeId().equals(vipProto.getPrivilegeId()) && this.btnType_ == vipProto.btnType_ && getBannerId().equals(vipProto.getBannerId()) && this.orderType_ == vipProto.orderType_ && this.adPage_ == vipProto.adPage_ && getAdType().equals(vipProto.getAdType()) && getLongitude().equals(vipProto.getLongitude()) && getLatitude().equals(vipProto.getLatitude()) && getImageId().equals(vipProto.getImageId()) && getThirdId().equals(vipProto.getThirdId()) && getIsShadow() == vipProto.getIsShadow() && getId().equals(vipProto.getId()) && getNum() == vipProto.getNum() && getIsSuccess() == vipProto.getIsSuccess() && getCount() == vipProto.getCount() && getOrderId().equals(vipProto.getOrderId()) && getUrl().equals(vipProto.getUrl()) && getTargetUid().equals(vipProto.getTargetUid()) && getType().equals(vipProto.getType()) && getIsVague() == vipProto.getIsVague() && getSkuId().equals(vipProto.getSkuId()) && this.unknownFields.equals(vipProto.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public AdPage getAdPage() {
            AdPage valueOf = AdPage.valueOf(this.adPage_);
            AdPage adPage = valueOf;
            if (valueOf == null) {
                adPage = AdPage.UNRECOGNIZED;
            }
            return adPage;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public int getAdPageValue() {
            return this.adPage_;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public String getAdType() {
            Object obj = this.adType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.adType_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public ByteString getAdTypeBytes() {
            Object obj = this.adType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.adType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public String getBannerId() {
            Object obj = this.bannerId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.bannerId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public ByteString getBannerIdBytes() {
            Object obj = this.bannerId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.bannerId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public String getBannerUrl() {
            Object obj = this.bannerUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.bannerUrl_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public ByteString getBannerUrlBytes() {
            Object obj = this.bannerUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.bannerUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public BtnType getBtnType() {
            BtnType valueOf = BtnType.valueOf(this.btnType_);
            BtnType btnType = valueOf;
            if (valueOf == null) {
                btnType = BtnType.UNRECOGNIZED;
            }
            return btnType;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public int getBtnTypeValue() {
            return this.btnType_;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public int getCount() {
            return this.count_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public VipProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public Event getEvent() {
            Event valueOf = Event.valueOf(this.event_);
            Event event = valueOf;
            if (valueOf == null) {
                event = Event.UNRECOGNIZED;
            }
            return event;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public int getEventValue() {
            return this.event_;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public FromType getFrom() {
            FromType valueOf = FromType.valueOf(this.from_);
            FromType fromType = valueOf;
            if (valueOf == null) {
                fromType = FromType.UNRECOGNIZED;
            }
            return fromType;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public int getFromValue() {
            return this.from_;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public HideType getHideType() {
            HideType valueOf = HideType.valueOf(this.hideType_);
            HideType hideType = valueOf;
            if (valueOf == null) {
                hideType = HideType.UNRECOGNIZED;
            }
            return hideType;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public int getHideTypeValue() {
            return this.hideType_;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public String getId() {
            Object obj = this.id_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.id_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public ByteString getIdBytes() {
            Object obj = this.id_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.id_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public IdentityType getIdentityType() {
            IdentityType valueOf = IdentityType.valueOf(this.identityType_);
            IdentityType identityType = valueOf;
            if (valueOf == null) {
                identityType = IdentityType.UNRECOGNIZED;
            }
            return identityType;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public int getIdentityTypeValue() {
            return this.identityType_;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public String getImageId() {
            Object obj = this.imageId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.imageId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public ByteString getImageIdBytes() {
            Object obj = this.imageId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.imageId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public boolean getIsBuySuccess() {
            return this.isBuySuccess_;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public boolean getIsHideAge() {
            return this.isHideAge_;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public boolean getIsHideAll() {
            return this.isHideAll_;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public boolean getIsHideDistance() {
            return this.isHideDistance_;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public boolean getIsHideRole() {
            return this.isHideRole_;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public boolean getIsRange() {
            return this.isRange_;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public boolean getIsShadow() {
            return this.isShadow_;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public boolean getIsSuccess() {
            return this.isSuccess_;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public boolean getIsVague() {
            return this.isVague_;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public String getLatitude() {
            Object obj = this.latitude_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.latitude_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public ByteString getLatitudeBytes() {
            Object obj = this.latitude_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.latitude_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public String getLongitude() {
            Object obj = this.longitude_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.longitude_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public ByteString getLongitudeBytes() {
            Object obj = this.longitude_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.longitude_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public Name getName() {
            Name valueOf = Name.valueOf(this.name_);
            Name name = valueOf;
            if (valueOf == null) {
                name = Name.UNRECOGNIZED;
            }
            return name;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public int getNameValue() {
            return this.name_;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public int getNum() {
            return this.num_;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public String getOrderId() {
            Object obj = this.orderId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.orderId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public ByteString getOrderIdBytes() {
            Object obj = this.orderId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.orderId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public OrderType getOrderType() {
            OrderType valueOf = OrderType.valueOf(this.orderType_);
            OrderType orderType = valueOf;
            if (valueOf == null) {
                orderType = OrderType.UNRECOGNIZED;
            }
            return orderType;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public int getOrderTypeValue() {
            return this.orderType_;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public PageLevel getPageLevel() {
            PageLevel valueOf = PageLevel.valueOf(this.pageLevel_);
            PageLevel pageLevel = valueOf;
            if (valueOf == null) {
                pageLevel = PageLevel.UNRECOGNIZED;
            }
            return pageLevel;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public int getPageLevelValue() {
            return this.pageLevel_;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public PageVersion getPageVersion() {
            PageVersion valueOf = PageVersion.valueOf(this.pageVersion_);
            PageVersion pageVersion = valueOf;
            if (valueOf == null) {
                pageVersion = PageVersion.UNRECOGNIZED;
            }
            return pageVersion;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public int getPageVersionValue() {
            return this.pageVersion_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<VipProto> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public String getPrivilegeId() {
            Object obj = this.privilegeId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.privilegeId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public ByteString getPrivilegeIdBytes() {
            Object obj = this.privilegeId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.privilegeId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (this.event_ != Event.UNKNOWN_EVENT.getNumber()) {
                i2 = 0 + CodedOutputStream.computeEnumSize(1, this.event_);
            }
            int i3 = i2;
            if (this.name_ != Name.UNKNOWN_NAME.getNumber()) {
                i3 = i2 + CodedOutputStream.computeEnumSize(2, this.name_);
            }
            int i4 = i3;
            if (this.from_ != FromType.UNKNOWN_FROM.getNumber()) {
                i4 = i3 + CodedOutputStream.computeEnumSize(3, this.from_);
            }
            int i5 = i4;
            if (this.stealthType_ != StealthType.UNKNOWN_STEALTH_TYPE.getNumber()) {
                i5 = i4 + CodedOutputStream.computeEnumSize(4, this.stealthType_);
            }
            boolean z = this.isRange_;
            int i6 = i5;
            if (z) {
                i6 = i5 + CodedOutputStream.computeBoolSize(5, z);
            }
            int i7 = i6;
            if (this.vocativeType_ != VocativeType.UNKNOWN_VOCATIVE_TYPE.getNumber()) {
                i7 = i6 + CodedOutputStream.computeEnumSize(6, this.vocativeType_);
            }
            int i8 = i7;
            if (this.pageVersion_ != PageVersion.UNKNOWN_PAGE_VERSION.getNumber()) {
                i8 = i7 + CodedOutputStream.computeEnumSize(7, this.pageVersion_);
            }
            int i9 = i8;
            if (this.identityType_ != IdentityType.UNKNOWN_IDENTITY_TYPE.getNumber()) {
                i9 = i8 + CodedOutputStream.computeEnumSize(8, this.identityType_);
            }
            boolean z2 = this.isBuySuccess_;
            int i10 = i9;
            if (z2) {
                i10 = i9 + CodedOutputStream.computeBoolSize(9, z2);
            }
            boolean z3 = this.isOpen_;
            int i11 = i10;
            if (z3) {
                i11 = i10 + CodedOutputStream.computeBoolSize(10, z3);
            }
            int i12 = i11;
            if (this.pageLevel_ != PageLevel.UNKNOWN_PAGE_LEVEL.getNumber()) {
                i12 = i11 + CodedOutputStream.computeEnumSize(11, this.pageLevel_);
            }
            int i13 = i12;
            if (this.hideType_ != HideType.UNKNOWN_HIDE_TYPE.getNumber()) {
                i13 = i12 + CodedOutputStream.computeEnumSize(12, this.hideType_);
            }
            boolean z4 = this.isHideAll_;
            int i14 = i13;
            if (z4) {
                i14 = i13 + CodedOutputStream.computeBoolSize(13, z4);
            }
            boolean z5 = this.isHideDistance_;
            int i15 = i14;
            if (z5) {
                i15 = i14 + CodedOutputStream.computeBoolSize(14, z5);
            }
            boolean z6 = this.isHideRole_;
            int i16 = i15;
            if (z6) {
                i16 = i15 + CodedOutputStream.computeBoolSize(15, z6);
            }
            boolean z7 = this.isHideAge_;
            int i17 = i16;
            if (z7) {
                i17 = i16 + CodedOutputStream.computeBoolSize(16, z7);
            }
            int i18 = i17;
            if (!getBannerUrlBytes().isEmpty()) {
                i18 = i17 + GeneratedMessageV3.computeStringSize(17, this.bannerUrl_);
            }
            int i19 = i18;
            if (!getPrivilegeIdBytes().isEmpty()) {
                i19 = i18 + GeneratedMessageV3.computeStringSize(18, this.privilegeId_);
            }
            int i20 = i19;
            if (this.btnType_ != BtnType.UNKNOWN_BTN_TYPE.getNumber()) {
                i20 = i19 + CodedOutputStream.computeEnumSize(19, this.btnType_);
            }
            int i21 = i20;
            if (!getBannerIdBytes().isEmpty()) {
                i21 = i20 + GeneratedMessageV3.computeStringSize(20, this.bannerId_);
            }
            int i22 = i21;
            if (this.orderType_ != OrderType.UNKNOWN_ORDER_TYPE.getNumber()) {
                i22 = i21 + CodedOutputStream.computeEnumSize(21, this.orderType_);
            }
            int i23 = i22;
            if (this.adPage_ != AdPage.UNKNOWN_AD_PAGE.getNumber()) {
                i23 = i22 + CodedOutputStream.computeEnumSize(22, this.adPage_);
            }
            int i24 = i23;
            if (!getAdTypeBytes().isEmpty()) {
                i24 = i23 + GeneratedMessageV3.computeStringSize(23, this.adType_);
            }
            int i25 = i24;
            if (!getLongitudeBytes().isEmpty()) {
                i25 = i24 + GeneratedMessageV3.computeStringSize(24, this.longitude_);
            }
            int i26 = i25;
            if (!getLatitudeBytes().isEmpty()) {
                i26 = i25 + GeneratedMessageV3.computeStringSize(25, this.latitude_);
            }
            int i27 = i26;
            if (!getImageIdBytes().isEmpty()) {
                i27 = i26 + GeneratedMessageV3.computeStringSize(26, this.imageId_);
            }
            int i28 = i27;
            if (!getThirdIdBytes().isEmpty()) {
                i28 = i27 + GeneratedMessageV3.computeStringSize(27, this.thirdId_);
            }
            boolean z8 = this.isShadow_;
            int i29 = i28;
            if (z8) {
                i29 = i28 + CodedOutputStream.computeBoolSize(28, z8);
            }
            int i30 = i29;
            if (!getIdBytes().isEmpty()) {
                i30 = i29 + GeneratedMessageV3.computeStringSize(29, this.id_);
            }
            int i31 = this.num_;
            int i32 = i30;
            if (i31 != 0) {
                i32 = i30 + CodedOutputStream.computeInt32Size(30, i31);
            }
            boolean z9 = this.isSuccess_;
            int i33 = i32;
            if (z9) {
                i33 = i32 + CodedOutputStream.computeBoolSize(31, z9);
            }
            int i34 = this.count_;
            int i35 = i33;
            if (i34 != 0) {
                i35 = i33 + CodedOutputStream.computeInt32Size(32, i34);
            }
            int i36 = i35;
            if (!getOrderIdBytes().isEmpty()) {
                i36 = i35 + GeneratedMessageV3.computeStringSize(33, this.orderId_);
            }
            int i37 = i36;
            if (!getUrlBytes().isEmpty()) {
                i37 = i36 + GeneratedMessageV3.computeStringSize(34, this.url_);
            }
            int i38 = i37;
            if (!getTargetUidBytes().isEmpty()) {
                i38 = i37 + GeneratedMessageV3.computeStringSize(35, this.targetUid_);
            }
            int i39 = i38;
            if (!getTypeBytes().isEmpty()) {
                i39 = i38 + GeneratedMessageV3.computeStringSize(36, this.type_);
            }
            boolean z10 = this.isVague_;
            int i40 = i39;
            if (z10) {
                i40 = i39 + CodedOutputStream.computeBoolSize(37, z10);
            }
            int i41 = i40;
            if (!getSkuIdBytes().isEmpty()) {
                i41 = i40 + GeneratedMessageV3.computeStringSize(38, this.skuId_);
            }
            int serializedSize = i41 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public String getSkuId() {
            Object obj = this.skuId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.skuId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public ByteString getSkuIdBytes() {
            Object obj = this.skuId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.skuId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public StealthType getStealthType() {
            StealthType valueOf = StealthType.valueOf(this.stealthType_);
            StealthType stealthType = valueOf;
            if (valueOf == null) {
                stealthType = StealthType.UNRECOGNIZED;
            }
            return stealthType;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public int getStealthTypeValue() {
            return this.stealthType_;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public String getTargetUid() {
            Object obj = this.targetUid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.targetUid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public ByteString getTargetUidBytes() {
            Object obj = this.targetUid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.targetUid_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public String getThirdId() {
            Object obj = this.thirdId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.thirdId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public ByteString getThirdIdBytes() {
            Object obj = this.thirdId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.thirdId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public String getType() {
            Object obj = this.type_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.type_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public ByteString getTypeBytes() {
            Object obj = this.type_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.type_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.url_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public ByteString getUrlBytes() {
            Object obj = this.url_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.url_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public VocativeType getVocativeType() {
            VocativeType valueOf = VocativeType.valueOf(this.vocativeType_);
            VocativeType vocativeType = valueOf;
            if (valueOf == null) {
                vocativeType = VocativeType.UNRECOGNIZED;
            }
            return vocativeType;
        }

        @Override // com.blued.das.vip.VipProtos.VipProtoOrBuilder
        public int getVocativeTypeValue() {
            return this.vocativeType_;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.event_) * 37) + 2) * 53) + this.name_) * 37) + 3) * 53) + this.from_) * 37) + 4) * 53) + this.stealthType_) * 37) + 5) * 53) + Internal.hashBoolean(getIsRange())) * 37) + 6) * 53) + this.vocativeType_) * 37) + 7) * 53) + this.pageVersion_) * 37) + 8) * 53) + this.identityType_) * 37) + 9) * 53) + Internal.hashBoolean(getIsBuySuccess())) * 37) + 10) * 53) + Internal.hashBoolean(getIsOpen())) * 37) + 11) * 53) + this.pageLevel_) * 37) + 12) * 53) + this.hideType_) * 37) + 13) * 53) + Internal.hashBoolean(getIsHideAll())) * 37) + 14) * 53) + Internal.hashBoolean(getIsHideDistance())) * 37) + 15) * 53) + Internal.hashBoolean(getIsHideRole())) * 37) + 16) * 53) + Internal.hashBoolean(getIsHideAge())) * 37) + 17) * 53) + getBannerUrl().hashCode()) * 37) + 18) * 53) + getPrivilegeId().hashCode()) * 37) + 19) * 53) + this.btnType_) * 37) + 20) * 53) + getBannerId().hashCode()) * 37) + 21) * 53) + this.orderType_) * 37) + 22) * 53) + this.adPage_) * 37) + 23) * 53) + getAdType().hashCode()) * 37) + 24) * 53) + getLongitude().hashCode()) * 37) + 25) * 53) + getLatitude().hashCode()) * 37) + 26) * 53) + getImageId().hashCode()) * 37) + 27) * 53) + getThirdId().hashCode()) * 37) + 28) * 53) + Internal.hashBoolean(getIsShadow())) * 37) + 29) * 53) + getId().hashCode()) * 37) + 30) * 53) + getNum()) * 37) + 31) * 53) + Internal.hashBoolean(getIsSuccess())) * 37) + 32) * 53) + getCount()) * 37) + 33) * 53) + getOrderId().hashCode()) * 37) + 34) * 53) + getUrl().hashCode()) * 37) + 35) * 53) + getTargetUid().hashCode()) * 37) + 36) * 53) + getType().hashCode()) * 37) + 37) * 53) + Internal.hashBoolean(getIsVague())) * 37) + 38) * 53) + getSkuId().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return VipProtos.internal_static_com_blued_das_vip_VipProto_fieldAccessorTable.ensureFieldAccessorsInitialized(VipProto.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new VipProto();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.event_ != Event.UNKNOWN_EVENT.getNumber()) {
                codedOutputStream.writeEnum(1, this.event_);
            }
            if (this.name_ != Name.UNKNOWN_NAME.getNumber()) {
                codedOutputStream.writeEnum(2, this.name_);
            }
            if (this.from_ != FromType.UNKNOWN_FROM.getNumber()) {
                codedOutputStream.writeEnum(3, this.from_);
            }
            if (this.stealthType_ != StealthType.UNKNOWN_STEALTH_TYPE.getNumber()) {
                codedOutputStream.writeEnum(4, this.stealthType_);
            }
            boolean z = this.isRange_;
            if (z) {
                codedOutputStream.writeBool(5, z);
            }
            if (this.vocativeType_ != VocativeType.UNKNOWN_VOCATIVE_TYPE.getNumber()) {
                codedOutputStream.writeEnum(6, this.vocativeType_);
            }
            if (this.pageVersion_ != PageVersion.UNKNOWN_PAGE_VERSION.getNumber()) {
                codedOutputStream.writeEnum(7, this.pageVersion_);
            }
            if (this.identityType_ != IdentityType.UNKNOWN_IDENTITY_TYPE.getNumber()) {
                codedOutputStream.writeEnum(8, this.identityType_);
            }
            boolean z2 = this.isBuySuccess_;
            if (z2) {
                codedOutputStream.writeBool(9, z2);
            }
            boolean z3 = this.isOpen_;
            if (z3) {
                codedOutputStream.writeBool(10, z3);
            }
            if (this.pageLevel_ != PageLevel.UNKNOWN_PAGE_LEVEL.getNumber()) {
                codedOutputStream.writeEnum(11, this.pageLevel_);
            }
            if (this.hideType_ != HideType.UNKNOWN_HIDE_TYPE.getNumber()) {
                codedOutputStream.writeEnum(12, this.hideType_);
            }
            boolean z4 = this.isHideAll_;
            if (z4) {
                codedOutputStream.writeBool(13, z4);
            }
            boolean z5 = this.isHideDistance_;
            if (z5) {
                codedOutputStream.writeBool(14, z5);
            }
            boolean z6 = this.isHideRole_;
            if (z6) {
                codedOutputStream.writeBool(15, z6);
            }
            boolean z7 = this.isHideAge_;
            if (z7) {
                codedOutputStream.writeBool(16, z7);
            }
            if (!getBannerUrlBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 17, this.bannerUrl_);
            }
            if (!getPrivilegeIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 18, this.privilegeId_);
            }
            if (this.btnType_ != BtnType.UNKNOWN_BTN_TYPE.getNumber()) {
                codedOutputStream.writeEnum(19, this.btnType_);
            }
            if (!getBannerIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 20, this.bannerId_);
            }
            if (this.orderType_ != OrderType.UNKNOWN_ORDER_TYPE.getNumber()) {
                codedOutputStream.writeEnum(21, this.orderType_);
            }
            if (this.adPage_ != AdPage.UNKNOWN_AD_PAGE.getNumber()) {
                codedOutputStream.writeEnum(22, this.adPage_);
            }
            if (!getAdTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 23, this.adType_);
            }
            if (!getLongitudeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 24, this.longitude_);
            }
            if (!getLatitudeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 25, this.latitude_);
            }
            if (!getImageIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 26, this.imageId_);
            }
            if (!getThirdIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 27, this.thirdId_);
            }
            boolean z8 = this.isShadow_;
            if (z8) {
                codedOutputStream.writeBool(28, z8);
            }
            if (!getIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 29, this.id_);
            }
            int i = this.num_;
            if (i != 0) {
                codedOutputStream.writeInt32(30, i);
            }
            boolean z9 = this.isSuccess_;
            if (z9) {
                codedOutputStream.writeBool(31, z9);
            }
            int i2 = this.count_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(32, i2);
            }
            if (!getOrderIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 33, this.orderId_);
            }
            if (!getUrlBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 34, this.url_);
            }
            if (!getTargetUidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 35, this.targetUid_);
            }
            if (!getTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 36, this.type_);
            }
            boolean z10 = this.isVague_;
            if (z10) {
                codedOutputStream.writeBool(37, z10);
            }
            if (!getSkuIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 38, this.skuId_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/vip/VipProtos$VipProtoOrBuilder.class */
    public interface VipProtoOrBuilder extends MessageOrBuilder {
        AdPage getAdPage();

        int getAdPageValue();

        String getAdType();

        ByteString getAdTypeBytes();

        String getBannerId();

        ByteString getBannerIdBytes();

        String getBannerUrl();

        ByteString getBannerUrlBytes();

        BtnType getBtnType();

        int getBtnTypeValue();

        int getCount();

        Event getEvent();

        int getEventValue();

        FromType getFrom();

        int getFromValue();

        HideType getHideType();

        int getHideTypeValue();

        String getId();

        ByteString getIdBytes();

        IdentityType getIdentityType();

        int getIdentityTypeValue();

        String getImageId();

        ByteString getImageIdBytes();

        boolean getIsBuySuccess();

        boolean getIsHideAge();

        boolean getIsHideAll();

        boolean getIsHideDistance();

        boolean getIsHideRole();

        boolean getIsOpen();

        boolean getIsRange();

        boolean getIsShadow();

        boolean getIsSuccess();

        boolean getIsVague();

        String getLatitude();

        ByteString getLatitudeBytes();

        String getLongitude();

        ByteString getLongitudeBytes();

        Name getName();

        int getNameValue();

        int getNum();

        String getOrderId();

        ByteString getOrderIdBytes();

        OrderType getOrderType();

        int getOrderTypeValue();

        PageLevel getPageLevel();

        int getPageLevelValue();

        PageVersion getPageVersion();

        int getPageVersionValue();

        String getPrivilegeId();

        ByteString getPrivilegeIdBytes();

        String getSkuId();

        ByteString getSkuIdBytes();

        StealthType getStealthType();

        int getStealthTypeValue();

        String getTargetUid();

        ByteString getTargetUidBytes();

        String getThirdId();

        ByteString getThirdIdBytes();

        String getType();

        ByteString getTypeBytes();

        String getUrl();

        ByteString getUrlBytes();

        VocativeType getVocativeType();

        int getVocativeTypeValue();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/vip/VipProtos$VocativeType.class */
    public enum VocativeType implements ProtocolMessageEnum {
        UNKNOWN_VOCATIVE_TYPE(0),
        NO_TIMES(1),
        HAVE_TIMES(2),
        UNRECOGNIZED(-1);
        
        public static final int HAVE_TIMES_VALUE = 2;
        public static final int NO_TIMES_VALUE = 1;
        public static final int UNKNOWN_VOCATIVE_TYPE_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<VocativeType> internalValueMap = new Internal.EnumLiteMap<VocativeType>() { // from class: com.blued.das.vip.VipProtos.VocativeType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public VocativeType findValueByNumber(int i) {
                return VocativeType.forNumber(i);
            }
        };
        private static final VocativeType[] VALUES = values();

        VocativeType(int i) {
            this.value = i;
        }

        public static VocativeType forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return HAVE_TIMES;
                }
                return NO_TIMES;
            }
            return UNKNOWN_VOCATIVE_TYPE;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return VipProtos.getDescriptor().getEnumTypes().get(5);
        }

        public static Internal.EnumLiteMap<VocativeType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static VocativeType valueOf(int i) {
            return forNumber(i);
        }

        public static VocativeType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                return enumValueDescriptor.getIndex() == -1 ? UNRECOGNIZED : VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_blued_das_vip_VipProto_descriptor = descriptor2;
        internal_static_com_blued_das_vip_VipProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Event", "Name", HttpHeaders.FROM, "StealthType", "IsRange", "VocativeType", "PageVersion", "IdentityType", "IsBuySuccess", "IsOpen", "PageLevel", "HideType", "IsHideAll", "IsHideDistance", "IsHideRole", "IsHideAge", "BannerUrl", "PrivilegeId", "BtnType", "BannerId", "OrderType", "AdPage", "AdType", "Longitude", "Latitude", "ImageId", "ThirdId", "IsShadow", "Id", "Num", "IsSuccess", "Count", "OrderId", "Url", "TargetUid", "Type", "IsVague", "SkuId"});
    }

    private VipProtos() {
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
