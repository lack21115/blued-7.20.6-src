package com.sensetime.stmobile.params;

import android.content.pm.PackageManager;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/params/STResultCode.class */
public enum STResultCode {
    ST_OK(0),
    ST_E_INVALIDARG(-1),
    ST_E_HANDLE(-2),
    ST_E_OUTOFMEMORY(-3),
    ST_E_FAIL(-4),
    ST_E_DELNOTFOUND(-5),
    ST_E_INVALID_PIXEL_FORMAT(-6),
    ST_E_FILE_NOT_FOUND(-7),
    ST_E_INVALID_FILE_FORMAT(-8),
    ST_E_FILE_EXPIRE(-9),
    ST_E_INVALID_AUTH(-13),
    ST_E_INVALID_APPID(-14),
    ST_E_AUTH_EXPIRE(-15),
    ST_E_UUID_MISMATCH(-16),
    ST_E_ONLINE_AUTH_CONNECT_FAIL(-17),
    ST_E_ONLINE_AUTH_TIMEOUT(-18),
    ST_E_ONLINE_AUTH_INVALID(-19),
    ST_E_LICENSE_IS_NOT_ACTIVABLE(-20),
    ST_E_ACTIVE_FAIL(-21),
    ST_E_ACTIVE_CODE_INVALID(-22),
    ST_E_NO_CAPABILITY(-23),
    ST_E_PLATFORM_NOTSUPPORTED(-24),
    ST_E_SUBMODEL_NOT_EXIST(-26),
    ST_E_ONLINE_ACTIVATE_NO_NEED(-27),
    ST_E_ONLINE_ACTIVATE_FAIL(-28),
    ST_E_ONLINE_ACTIVATE_CODE_INVALID(-29),
    ST_E_ONLINE_ACTIVATE_CONNECT_FAIL(-30),
    ST_E_UNSUPPORTED_ZIP(-32),
    ST_E_ZIP_EXIST_IN_MEMORY(-33),
    ST_E_NOT_CONNECT_TO_NETWORK(-34),
    ST_E_OTHER_LINK_ERRORS_IN_HTTPS(-35),
    ST_E_CERTIFICAT_NOT_BE_TRUSTED(-36),
    ST_E_LICENSE_LIMIT_EXCEEDED(-37),
    ST_E_NOFACE(-38),
    ST_E_API_UNSUPPORTED(-39),
    ST_E_API_DEPRECATED(-40),
    ST_E_ARG_UNSUPPORTED(-41),
    ST_E_PRECONDITION(-42),
    ST_E_SIGN_ACTIVATION_CODE_TOKEN_EXPIRE(-43),
    ST_E_SIGN_ACTIVATION_CODE_EXPIRE(-44),
    ST_E_INVALID_GL_CONTEXT(-100),
    ST_E_RENDER_DISABLED(PackageManager.INSTALL_PARSE_FAILED_BAD_MANIFEST);
    
    private final int Q;

    STResultCode(int i) {
        this.Q = i;
    }
}
