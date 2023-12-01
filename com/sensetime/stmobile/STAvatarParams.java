package com.sensetime.stmobile;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/STAvatarParams.class */
public class STAvatarParams {
    public static final int AVATAR_DISPLAY_BODY_TRACKING = 2;
    public static final int AVATAR_DISPLAY_FACE_TRACKING = 1;
    public static final int AVATAR_DISPLAY_PINCHING = 0;
    public static final int AVATAR_FACING_BODY_FRONT = 0;
    public static final int AVATAR_FACING_BODY_LEFT_45 = 1;
    public static final int AVATAR_FACING_BODY_RIGHT_45 = 2;
    public static final int AVATAR_FACING_HEAD_FRONT = 3;
    public static final int AVATAR_FACING_HEAD_LEFT_45 = 4;
    public static final int AVATAR_FACING_HEAD_RIGHT_45 = 5;
    public static final int AVATAR_FEATURE_IDX_BROW = 4;
    public static final int ST_AVATAR_CTRL_BODY_SIZE = 61;
    public static final int ST_AVATAR_CTRL_BROW_ARCH_HORIZONTAL = 4;
    public static final int ST_AVATAR_CTRL_BROW_ARCH_VERTICAL = 5;
    public static final int ST_AVATAR_CTRL_BROW_HEADER_HORIZONTAL = 2;
    public static final int ST_AVATAR_CTRL_BROW_HEADER_VERTICAL = 3;
    public static final int ST_AVATAR_CTRL_BROW_HORIZONTAL = 0;
    public static final int ST_AVATAR_CTRL_BROW_TAIL_HORIZONTAL = 6;
    public static final int ST_AVATAR_CTRL_BROW_TAIL_VERTICAL = 7;
    public static final int ST_AVATAR_CTRL_BROW_VERTICAL = 1;
    public static final int ST_AVATAR_CTRL_CHEEK_THICK = 54;
    public static final int ST_AVATAR_CTRL_CHEEK_WIDTH = 53;
    public static final int ST_AVATAR_CTRL_CHEST_HEIGHT = 55;
    public static final int ST_AVATAR_CTRL_CHEST_SIZE = 56;
    public static final int ST_AVATAR_CTRL_EYE_DISTANCE = 9;
    public static final int ST_AVATAR_CTRL_EYE_IN_CORNER_HORIZONTAL = 13;
    public static final int ST_AVATAR_CTRL_EYE_IN_CORNER_VERTICAL = 12;
    public static final int ST_AVATAR_CTRL_EYE_OPEN = 10;
    public static final int ST_AVATAR_CTRL_EYE_OUT_CORNER_HORIZONTAL = 19;
    public static final int ST_AVATAR_CTRL_EYE_OUT_CORNER_VERTICAL = 18;
    public static final int ST_AVATAR_CTRL_EYE_SIZE = 11;
    public static final int ST_AVATAR_CTRL_EYE_VERTICAL = 8;
    public static final int ST_AVATAR_CTRL_EYE_VERTICAL_SIZE = 60;
    public static final int ST_AVATAR_CTRL_FOREHEAD_HEIGHT = 46;
    public static final int ST_AVATAR_CTRL_FOREHEAD_WIDTH = 47;
    public static final int ST_AVATAR_CTRL_HEAD_HORIZONTAL_SIZE = 44;
    public static final int ST_AVATAR_CTRL_HEAD_VERTICAL_SIZE = 45;
    public static final int ST_AVATAR_CTRL_HIPS_HEIGHT = 59;
    public static final int ST_AVATAR_CTRL_HIPS_SIZE = 58;
    public static final int ST_AVATAR_CTRL_JAW_HEIGHT = 51;
    public static final int ST_AVATAR_CTRL_JAW_LENGTH = 49;
    public static final int ST_AVATAR_CTRL_JAW_POINT_LENGTH = 48;
    public static final int ST_AVATAR_CTRL_JAW_SQUARENESS = 50;
    public static final int ST_AVATAR_CTRL_JAW_WIDTH = 52;
    public static final int ST_AVATAR_CTRL_LIP_ARC = 37;
    public static final int ST_AVATAR_CTRL_LIP_ARC_UP_DOWN = 39;
    public static final int ST_AVATAR_CTRL_LIP_MARK_UP_DOWN = 38;
    public static final int ST_AVATAR_CTRL_LIP_MARK_VERTICAL = 36;
    public static final int ST_AVATAR_CTRL_LOWER_EYELID_HORIZONTAL = 16;
    public static final int ST_AVATAR_CTRL_LOWER_EYELID_VERTICAL = 17;
    public static final int ST_AVATAR_CTRL_LOWER_LIP = 40;
    public static final int ST_AVATAR_CTRL_LOWER_LIP_PEAK = 41;
    public static final int ST_AVATAR_CTRL_LOWER_LIP_SIDE = 42;
    public static final int ST_AVATAR_CTRL_LOWER_LIP_SQURENESS = 35;
    public static final int ST_AVATAR_CTRL_LOWER_LIP_THICK = 34;
    public static final int ST_AVATAR_CTRL_MOUTH_CORNER = 43;
    public static final int ST_AVATAR_CTRL_MOUTH_CORNER_LENGTH = 30;
    public static final int ST_AVATAR_CTRL_MOUTH_CORNER_VERTICAL = 31;
    public static final int ST_AVATAR_CTRL_MOUTH_SIZE = 28;
    public static final int ST_AVATAR_CTRL_MOUTH_VERTICAL = 29;
    public static final int ST_AVATAR_CTRL_NOSE_ANGLE = 22;
    public static final int ST_AVATAR_CTRL_NOSE_BRIDGE_HEIGHT = 25;
    public static final int ST_AVATAR_CTRL_NOSE_HEAD_ANGLE = 27;
    public static final int ST_AVATAR_CTRL_NOSE_HEAD_SIZE = 26;
    public static final int ST_AVATAR_CTRL_NOSE_LENGTH = 20;
    public static final int ST_AVATAR_CTRL_NOSE_SIZE = 21;
    public static final int ST_AVATAR_CTRL_NOSTRIL_SIZE = 23;
    public static final int ST_AVATAR_CTRL_NOSTRIL_VERTICAL = 24;
    public static final int ST_AVATAR_CTRL_UPPER_EYELID_HORIZONTAL = 14;
    public static final int ST_AVATAR_CTRL_UPPER_EYELID_VERTICAL = 15;
    public static final int ST_AVATAR_CTRL_UPPER_LIP_PEAK = 33;
    public static final int ST_AVATAR_CTRL_UPPER_LIP_THICK = 32;
    public static final int ST_AVATAR_CTRL_WAIST_SIZE = 57;

    /* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/STAvatarParams$BackgroundType.class */
    public enum BackgroundType {
        ST_BACKGROUND_IMG_JPEG,
        ST_BACKGROUND_IMG_PNG,
        ST_BACKGROUND_IMG_TGA,
        ST_BACKGROUND_SEQUENCE
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/STAvatarParams$DataFormat.class */
    public enum DataFormat {
        AVATAR_PINCH_DATA_ZIP,
        AVATAR_PINCH_DATA_JSON
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/STAvatarParams$FacePoseType.class */
    enum FacePoseType {
        ST_RESET_FACE_POSE_FRONT,
        ST_RESET_FACE_POSE_CURRENT
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/STAvatarParams$STAvatarEyebrow.class */
    public class STAvatarEyebrow {
        public static final int AVATAR_FEMALE_BENT_EYEBROW = 9;
        public static final int AVATAR_FEMALE_THICK_FLAT_EYEBROW = 6;
        public static final int AVATAR_FEMALE_THICK_RAISED_EYEBROW = 8;
        public static final int AVATAR_FEMALE_THIN_FLAT_EYEBROW = 5;
        public static final int AVATAR_FEMALE_THIN_RAISED_EYEBROW = 7;
        public static final int AVATAR_MALE_DASHING_EYEBROW = 3;
        public static final int AVATAR_MALE_SLANTED_EYEBROW = 4;
        public static final int AVATAR_MALE_THICK_FLAT_EYEBROW = 2;
        public static final int AVATAR_MALE_THIN_FLAT_EYEBROW = 1;
        public static final int AVATAR_UNKNOWN_EYEBROW = 0;

        public STAvatarEyebrow() {
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/STAvatarParams$STAvatarPart.class */
    public enum STAvatarPart {
        ST_AVATAR_PART_HEAD,
        ST_AVATAR_PART_UP_BODY,
        ST_AVATAR_PART_COUNT
    }
}
