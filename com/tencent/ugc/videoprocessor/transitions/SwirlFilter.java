package com.tencent.ugc.videoprocessor.transitions;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/transitions/SwirlFilter.class */
public class SwirlFilter extends TXCGPUTransitionFilterBase {
    private static final String FRAGMENT = "precision mediump float;\nvarying mediump vec2 _uv;\nuniform sampler2D inputImageTexture;\nuniform float progress;\nuniform float ratio;\nuniform vec4 bgcolor; // = vec4(0.0, 0.0, 0.0, 1.0)\nvec4 getFromColor(in vec2 uv){\n    vec2 fromTexture = vec2(uv.x,1.0 - uv.y);\n    vec4 fromColor = texture2D(inputImageTexture,fromTexture);\n    return fromColor;\n}\nvec4 getToColor(in vec2 uv){\n    vec2 toTexture = vec2(uv.x,1.0-uv.y);\n    vec4 toColor = texture2D(inputImageTexture,toTexture);\n    return toColor;\n}\nvec4 transition(vec2 UV)\n{\nfloat Radius = 1.0;\n\nfloat T = progress;\n\nUV -= vec2( 0.5, 0.5 );\n\nfloat Dist = length(UV);\n\nif ( Dist < Radius )\n{\nfloat Percent = (Radius - Dist) / Radius;\nfloat A = ( T <= 0.5 ) ? mix( 0.0, 1.0, T/0.5 ) : mix( 1.0, 0.0, (T-0.5)/0.5 );\nfloat Theta = Percent * Percent * A * 8.0 * 3.14159;\nfloat S = sin( Theta );\nfloat C = cos( Theta );\nUV = vec2( dot(UV, vec2(C, -S)), dot(UV, vec2(S, C)) );\n}\nUV += vec2( 0.5, 0.5 );\n\nvec4 C0 = getFromColor(UV);\nvec4 C1 = getToColor(UV);\n\nreturn mix( C0, C1, T );\n}\nvoid main() {\n    gl_FragColor = transition(_uv);\n}";

    public SwirlFilter(int i) {
        super("attribute vec2 position; \nvarying mediump vec2 _uv;\n  \nvoid main() \n{ \n    gl_Position = vec4(position,0,1); \n    vec2 uv = position * 0.5 + 0.5;\n    _uv = vec2(uv.x,1.0 - uv.y);\n}", FRAGMENT, i);
    }
}
