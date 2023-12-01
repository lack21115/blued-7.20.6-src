package com.tencent.ugc.videoprocessor.transitions;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/transitions/CircleCropFilter.class */
public class CircleCropFilter extends TXCGPUTransitionFilterBase {
    private static final String FRAGMENT = "precision mediump float;\nvarying mediump vec2 _uv;\nuniform sampler2D inputImageTexture;\nuniform float progress;\nuniform float ratio;\nconst vec4 bgcolor = vec4(0.0, 0.0, 0.0, 1.0);\nvec4 getFromColor(in vec2 uv){\n    vec2 fromTexture = vec2(uv.x,1.0 - uv.y);\n    vec4 fromColor = texture2D(inputImageTexture,fromTexture);\n    return fromColor;\n}\nvec4 getToColor(in vec2 uv){\n    vec2 toTexture = vec2(uv.x,1.0-uv.y);\n    vec4 toColor = texture2D(inputImageTexture,toTexture);\n    return toColor;\n}\nvec4 transition(vec2 p) {\n  vec2 ratio2 = vec2(1.0, 1.0 / ratio);\n  float s = pow(2.0 * abs(progress - 0.5), 3.0);\n  float dist = length((vec2(p) - 0.5) * ratio2);\n  // branching is ok here as we statically depend on progress uniform (branching won't change over pixels)\n  return mix(\n    progress < 0.5 ? getFromColor(p) : getToColor(p),    bgcolor,\n    step(s, dist)\n  );\n}\nvoid main() {\n    gl_FragColor = transition(_uv);\n}";

    public CircleCropFilter(int i) {
        super("attribute vec2 position; \nvarying mediump vec2 _uv;\n  \nvoid main() \n{ \n    gl_Position = vec4(position,0,1); \n    vec2 uv = position * 0.5 + 0.5;\n    _uv = vec2(uv.x,1.0 - uv.y);\n}", FRAGMENT, i);
    }
}
