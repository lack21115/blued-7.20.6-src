package com.tencent.ugc.videoprocessor.transitions;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/transitions/LinearBlurFilter.class */
public class LinearBlurFilter extends TXCGPUTransitionFilterBase {
    private static final String FRAGMENT = "precision mediump float;\nvarying mediump vec2 _uv;\nuniform sampler2D inputImageTexture;\nuniform float progress;\nuniform float ratio;\nconst float intensity = 0.1;\nconst int passes = 6;vec4 getFromColor(in vec2 uv){\n    vec2 fromTexture = vec2(uv.x,1.0 - uv.y);\n    vec4 fromColor = texture2D(inputImageTexture,fromTexture);\n    return fromColor;\n}\nvec4 getToColor(in vec2 uv){\n    vec2 toTexture = vec2(uv.x,1.0-uv.y);\n    vec4 toColor = texture2D(inputImageTexture,toTexture);\n    return toColor;\n}\nvec2 zoom(vec2 uv, float amount) {\n    return 0.5 + ((uv - 0.5) * (1.0-amount));\n}\n\nvec4 transition(vec2 uv) {\n    vec4 c1 = vec4(0.0);\n    vec4 c2 = vec4(0.0);\n\n    float disp = intensity*(0.5-distance(0.5, progress));\n    for (int xi=0; xi<passes; xi++)\n    {\n        float x = float(xi) / float(passes) - 0.5;\n        for (int yi=0; yi<passes; yi++)\n        {\n            float y = float(yi) / float(passes) - 0.5;\n            vec2 v = vec2(x,y);\n            float d = disp;\n            c1 += getFromColor( uv + d*v);\n            c2 += getToColor( uv + d*v);\n        }\n    }\n    c1 /= float(passes*passes);\n    c2 /= float(passes*passes);\n    return mix(c1, c2, progress);\n}\nvoid main() {\n    gl_FragColor = transition(_uv);\n}";

    public LinearBlurFilter(int i) {
        super("attribute vec2 position; \nvarying mediump vec2 _uv;\n  \nvoid main() \n{ \n    gl_Position = vec4(position,0,1); \n    vec2 uv = position * 0.5 + 0.5;\n    _uv = vec2(uv.x,1.0 - uv.y);\n}", FRAGMENT, i);
    }
}
