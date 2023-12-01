package com.blued.android.module.external_sense_library.config;

import com.android.internal.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/config/BluedBeautifyKey.class */
public interface BluedBeautifyKey {

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY.class */
    public enum KEY implements BluedBeautifyKey {
        ST_BEAUTIFY_WHITEN_STRENGTH(0, 101),
        ST_BEAUTIFY_REDDEN_STRENGTH(1, 102),
        ST_BEAUTIFY_SMOOTH_STRENGTH(2, 103),
        ST_BEAUTIFY_SHRINK_FACE_RATIO(4, 201),
        ST_BEAUTIFY_ENLARGE_EYE_RATIO(5, 202),
        ST_BEAUTIFY_SHRINK_JAW_RATIO(6, 203),
        ST_BEAUTIFY_NARROW_FACE_STRENGTH(7, 204),
        ST_BEAUTIFY_CONSTRACT_STRENGTH(8, 601),
        ST_BEAUTIFY_SATURATION_STRENGTH(9, 602),
        ST_BEAUTIFY_ROUND_EYE_RATIO(10, 205),
        ST_BEAUTIFY_3D_NARROW_NOSE_RATIO(11, R.styleable.Theme_findOnPagePreviousDrawable),
        ST_BEAUTIFY_3D_NOSE_LENGTH_RATIO(12, R.styleable.Theme_colorSwitchThumbNormal),
        ST_BEAUTIFY_3D_CHIN_LENGTH_RATIO(13, 303),
        ST_BEAUTIFY_3D_MOUTH_SIZE_RATIO(14, R.styleable.Theme_lightZ),
        ST_BEAUTIFY_3D_PHILTRUM_LENGTH_RATIO(15, R.styleable.Theme_lightRadius),
        ST_BEAUTIFY_3D_HAIRLINE_HEIGHT_RATIO(16, 304),
        ST_BEAUTIFY_3D_THIN_FACE_SHAPE_RATIO(17, 302),
        ST_BEAUTIFY_3D_EYE_DISTANCE_RATIO(18, 311),
        ST_BEAUTIFY_3D_EYE_ANGLE_RATIO(19, 312),
        ST_BEAUTIFY_3D_OPEN_CANTHUS_RATIO(20, 313),
        ST_BEAUTIFY_3D_PROFILE_RHINOPLASTY_RATIO(21, R.styleable.Theme_lightY),
        ST_BEAUTIFY_3D_BRIGHT_EYE_RATIO(22, 314),
        ST_BEAUTIFY_3D_REMOVE_DARK_CIRCLES_RATIO(23, 315),
        ST_BEAUTIFY_3D_REMOVE_NASOLABIAL_FOLDS_RATIO(24, 316),
        ST_BEAUTIFY_3D_WHITE_TEETH_RATIO(25, 317),
        ST_BEAUTIFY_3D_APPLE_MUSLE_RATIO(26, 305);
        
        private int index;
        private int stBeautyParamsType;

        KEY(int i, int i2) {
            this.index = i;
            this.stBeautyParamsType = i2;
        }

        public int getBeautyParamsType() {
            return this.stBeautyParamsType;
        }

        public int getIndex() {
            return this.index;
        }
    }
}
