package com.tencent.ugc.videoprocessor.transitions;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/transitions/DirectionalWarpFilter.class */
public class DirectionalWarpFilter extends TXCGPUTransitionFilterBase {
    private static final String FRAGMENT = "precision mediump float;\nvarying mediump vec2 _uv;\nuniform sampler2D inputImageTexture;\nuniform float progress;\nuniform float ratio;\nconst vec2 direction = vec2(-1.0, 1.0);\nconst float smoothness = 0.5;\nconst vec2 center = vec2(0.5, 0.5);\nvec4 getFromColor(in vec2 uv){\n    vec2 fromTexture = vec2(uv.x,1.0 - uv.y);\n    vec4 fromColor = texture2D(inputImageTexture,fromTexture);\n    return fromColor;\n}\nvec4 getToColor(in vec2 uv){\n    vec2 toTexture = vec2(uv.x,1.0-uv.y);\n    vec4 toColor = texture2D(inputImageTexture,toTexture);\n    return toColor;\n}\nvec2 zoom(vec2 uv, float amount) {\n    return 0.5 + ((uv - 0.5) * (1.0-amount));\n}\n\nvec4 transition (vec2 uv) {\n  vec2 v = normalize(direction);\n  v /= abs(v.x) + abs(v.y);\n  float d = v.x * center.x + v.y * center.y;\n  float m = 1.0 - smoothstep(-smoothness, 0.0, v.x * uv.x + v.y * uv.y   - (d - 0.5 + progress * (1.0 + smoothness)));\n  return mix(getFromColor((uv - 0.5) * (1.0 - m) + 0.5), getToColor((uv - 0.5) * m + 0.5), m);\n}\nvoid main() {\n    gl_FragColor = transition(_uv);\n}";

    public DirectionalWarpFilter(int i) {
        super("attribute vec2 position; \nvarying mediump vec2 _uv;\n  \nvoid main() \n{ \n    gl_Position = vec4(position,0,1); \n    vec2 uv = position * 0.5 + 0.5;\n    _uv = vec2(uv.x,1.0 - uv.y);\n}", FRAGMENT, i);
    }
}
