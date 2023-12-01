package android.filterfw.core;

import android.filterfw.format.ObjectFormat;
import android.filterfw.io.GraphIOException;
import android.filterfw.io.TextGraphReader;
import android.util.Log;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/Filter.class */
public abstract class Filter {
    static final int STATUS_ERROR = 6;
    static final int STATUS_FINISHED = 5;
    static final int STATUS_PREINIT = 0;
    static final int STATUS_PREPARED = 2;
    static final int STATUS_PROCESSING = 3;
    static final int STATUS_RELEASED = 7;
    static final int STATUS_SLEEPING = 4;
    static final int STATUS_UNPREPARED = 1;
    private static final String TAG = "Filter";
    private long mCurrentTimestamp;
    private HashMap<String, InputPort> mInputPorts;
    private String mName;
    private HashMap<String, OutputPort> mOutputPorts;
    private int mSleepDelay;
    private int mStatus;
    private int mInputCount = -1;
    private int mOutputCount = -1;
    private boolean mIsOpen = false;
    private HashSet<Frame> mFramesToRelease = new HashSet<>();
    private HashMap<String, Frame> mFramesToSet = new HashMap<>();
    private boolean mLogVerbose = Log.isLoggable(TAG, 2);

    public Filter(String str) {
        this.mStatus = 0;
        this.mName = str;
        this.mStatus = 0;
    }

    private final void addAndSetFinalPorts(KeyValueMap keyValueMap) {
        Field[] declaredFields = getClass().getDeclaredFields();
        int length = declaredFields.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            Field field = declaredFields[i2];
            Annotation annotation = field.getAnnotation(GenerateFinalPort.class);
            if (annotation != null) {
                GenerateFinalPort generateFinalPort = (GenerateFinalPort) annotation;
                String name = generateFinalPort.name().isEmpty() ? field.getName() : generateFinalPort.name();
                addFieldPort(name, field, generateFinalPort.hasDefault(), true);
                if (keyValueMap.containsKey(name)) {
                    setImmediateInputValue(name, keyValueMap.get(name));
                    keyValueMap.remove(name);
                } else if (!generateFinalPort.hasDefault()) {
                    throw new RuntimeException("No value specified for final input port '" + name + "' of filter " + this + "!");
                }
            }
            i = i2 + 1;
        }
    }

    private final void addAnnotatedPorts() {
        Field[] declaredFields = getClass().getDeclaredFields();
        int length = declaredFields.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            Field field = declaredFields[i2];
            Annotation annotation = field.getAnnotation(GenerateFieldPort.class);
            if (annotation != null) {
                addFieldGenerator((GenerateFieldPort) annotation, field);
            } else {
                Annotation annotation2 = field.getAnnotation(GenerateProgramPort.class);
                if (annotation2 != null) {
                    addProgramGenerator((GenerateProgramPort) annotation2, field);
                } else {
                    Annotation annotation3 = field.getAnnotation(GenerateProgramPorts.class);
                    if (annotation3 != null) {
                        GenerateProgramPort[] value = ((GenerateProgramPorts) annotation3).value();
                        int length2 = value.length;
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 < length2) {
                                addProgramGenerator(value[i4], field);
                                i3 = i4 + 1;
                            }
                        }
                    }
                }
            }
            i = i2 + 1;
        }
    }

    private final void addFieldGenerator(GenerateFieldPort generateFieldPort, Field field) {
        addFieldPort(generateFieldPort.name().isEmpty() ? field.getName() : generateFieldPort.name(), field, generateFieldPort.hasDefault(), false);
    }

    private final void addProgramGenerator(GenerateProgramPort generateProgramPort, Field field) {
        String name = generateProgramPort.name();
        addProgramPort(name, generateProgramPort.variableName().isEmpty() ? name : generateProgramPort.variableName(), field, generateProgramPort.type(), generateProgramPort.hasDefault());
    }

    private final void closePorts() {
        if (this.mLogVerbose) {
            Log.v(TAG, "Closing all ports on " + this + "!");
        }
        for (InputPort inputPort : this.mInputPorts.values()) {
            inputPort.close();
        }
        for (OutputPort outputPort : this.mOutputPorts.values()) {
            outputPort.close();
        }
    }

    private final boolean filterMustClose() {
        for (InputPort inputPort : this.mInputPorts.values()) {
            if (inputPort.filterMustClose()) {
                if (this.mLogVerbose) {
                    Log.v(TAG, "Filter " + this + " must close due to port " + inputPort);
                    return true;
                }
                return true;
            }
        }
        for (OutputPort outputPort : this.mOutputPorts.values()) {
            if (outputPort.filterMustClose()) {
                if (this.mLogVerbose) {
                    Log.v(TAG, "Filter " + this + " must close due to port " + outputPort);
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    private final void initFinalPorts(KeyValueMap keyValueMap) {
        this.mInputPorts = new HashMap<>();
        this.mOutputPorts = new HashMap<>();
        addAndSetFinalPorts(keyValueMap);
    }

    private final void initRemainingPorts(KeyValueMap keyValueMap) {
        addAnnotatedPorts();
        setupPorts();
        setInitialInputValues(keyValueMap);
    }

    private final boolean inputConditionsMet() {
        for (InputPort inputPort : this.mInputPorts.values()) {
            if (!inputPort.isReady()) {
                if (this.mLogVerbose) {
                    Log.v(TAG, "Input condition not met: " + inputPort + "!");
                    return false;
                }
                return false;
            }
        }
        return true;
    }

    public static final boolean isAvailable(String str) {
        try {
            try {
                Thread.currentThread().getContextClassLoader().loadClass(str).asSubclass(Filter.class);
                return true;
            } catch (ClassCastException e) {
                return false;
            }
        } catch (ClassNotFoundException e2) {
            return false;
        }
    }

    private final boolean outputConditionsMet() {
        for (OutputPort outputPort : this.mOutputPorts.values()) {
            if (!outputPort.isReady()) {
                if (this.mLogVerbose) {
                    Log.v(TAG, "Output condition not met: " + outputPort + "!");
                    return false;
                }
                return false;
            }
        }
        return true;
    }

    private final void releasePulledFrames(FilterContext filterContext) {
        Iterator<Frame> it = this.mFramesToRelease.iterator();
        while (it.hasNext()) {
            filterContext.getFrameManager().releaseFrame(it.next());
        }
        this.mFramesToRelease.clear();
    }

    private final void setImmediateInputValue(String str, Object obj) {
        if (this.mLogVerbose) {
            Log.v(TAG, "Setting immediate value " + obj + " for port " + str + "!");
        }
        InputPort inputPort = getInputPort(str);
        inputPort.open();
        inputPort.setFrame(SimpleFrame.wrapObject(obj, null));
    }

    private final void setInitialInputValues(KeyValueMap keyValueMap) {
        for (Map.Entry<String, Object> entry : keyValueMap.entrySet()) {
            setInputValue(entry.getKey(), entry.getValue());
        }
    }

    private final void transferInputFrames(FilterContext filterContext) {
        for (InputPort inputPort : this.mInputPorts.values()) {
            inputPort.transfer(filterContext);
        }
    }

    private final Frame wrapInputValue(String str, Object obj) {
        boolean z = true;
        MutableFrameFormat fromObject = ObjectFormat.fromObject(obj, 1);
        if (obj == null) {
            FrameFormat portFormat = getInputPort(str).getPortFormat();
            fromObject.setObjectClass(portFormat == null ? null : portFormat.getObjectClass());
        }
        if ((obj instanceof Number) || (obj instanceof Boolean) || (obj instanceof String) || !(obj instanceof Serializable)) {
            z = false;
        }
        Frame serializedFrame = z ? new SerializedFrame(fromObject, null) : new SimpleFrame(fromObject, null);
        serializedFrame.setObjectValue(obj);
        return serializedFrame;
    }

    protected void addFieldPort(String str, Field field, boolean z, boolean z2) {
        field.setAccessible(true);
        FinalPort finalPort = z2 ? new FinalPort(this, str, field, z) : new FieldPort(this, str, field, z);
        if (this.mLogVerbose) {
            Log.v(TAG, "Filter " + this + " adding " + finalPort);
        }
        finalPort.setPortFormat(ObjectFormat.fromClass(field.getType(), 1));
        this.mInputPorts.put(str, finalPort);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addInputPort(String str) {
        addMaskedInputPort(str, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addMaskedInputPort(String str, FrameFormat frameFormat) {
        StreamPort streamPort = new StreamPort(this, str);
        if (this.mLogVerbose) {
            Log.v(TAG, "Filter " + this + " adding " + streamPort);
        }
        this.mInputPorts.put(str, streamPort);
        streamPort.setPortFormat(frameFormat);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addOutputBasedOnInput(String str, String str2) {
        OutputPort outputPort = new OutputPort(this, str);
        if (this.mLogVerbose) {
            Log.v(TAG, "Filter " + this + " adding " + outputPort);
        }
        outputPort.setBasePort(getInputPort(str2));
        this.mOutputPorts.put(str, outputPort);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addOutputPort(String str, FrameFormat frameFormat) {
        OutputPort outputPort = new OutputPort(this, str);
        if (this.mLogVerbose) {
            Log.v(TAG, "Filter " + this + " adding " + outputPort);
        }
        outputPort.setPortFormat(frameFormat);
        this.mOutputPorts.put(str, outputPort);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addProgramPort(String str, String str2, Field field, Class cls, boolean z) {
        field.setAccessible(true);
        ProgramPort programPort = new ProgramPort(this, str, str2, field, z);
        if (this.mLogVerbose) {
            Log.v(TAG, "Filter " + this + " adding " + programPort);
        }
        programPort.setPortFormat(ObjectFormat.fromClass(cls, 1));
        this.mInputPorts.put(str, programPort);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean canProcess() {
        boolean z;
        synchronized (this) {
            if (this.mLogVerbose) {
                Log.v(TAG, "Checking if can process: " + this + " (" + this.mStatus + ").");
            }
            z = false;
            if (this.mStatus <= 3) {
                z = false;
                if (inputConditionsMet()) {
                    z = false;
                    if (outputConditionsMet()) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    final void clearInputs() {
        for (InputPort inputPort : this.mInputPorts.values()) {
            inputPort.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void clearOutputs() {
        for (OutputPort outputPort : this.mOutputPorts.values()) {
            outputPort.clear();
        }
    }

    public void close(FilterContext filterContext) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeOutputPort(String str) {
        getOutputPort(str).close();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void delayNextProcess(int i) {
        this.mSleepDelay = i;
        this.mStatus = 4;
    }

    public void fieldPortValueUpdated(String str, FilterContext filterContext) {
    }

    public String getFilterClassName() {
        return getClass().getSimpleName();
    }

    public final FrameFormat getInputFormat(String str) {
        return getInputPort(str).getSourceFormat();
    }

    public final InputPort getInputPort(String str) {
        if (this.mInputPorts == null) {
            throw new NullPointerException("Attempting to access input port '" + str + "' of " + this + " before Filter has been initialized!");
        }
        InputPort inputPort = this.mInputPorts.get(str);
        if (inputPort == null) {
            throw new IllegalArgumentException("Unknown input port '" + str + "' on filter " + this + "!");
        }
        return inputPort;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Collection<InputPort> getInputPorts() {
        return this.mInputPorts.values();
    }

    public final String getName() {
        return this.mName;
    }

    public final int getNumberOfConnectedInputs() {
        int i = 0;
        for (InputPort inputPort : this.mInputPorts.values()) {
            if (inputPort.isConnected()) {
                i++;
            }
        }
        return i;
    }

    public final int getNumberOfConnectedOutputs() {
        int i = 0;
        for (OutputPort outputPort : this.mOutputPorts.values()) {
            if (outputPort.isConnected()) {
                i++;
            }
        }
        return i;
    }

    public final int getNumberOfInputs() {
        if (this.mOutputPorts == null) {
            return 0;
        }
        return this.mInputPorts.size();
    }

    public final int getNumberOfOutputs() {
        if (this.mInputPorts == null) {
            return 0;
        }
        return this.mOutputPorts.size();
    }

    public FrameFormat getOutputFormat(String str, FrameFormat frameFormat) {
        return null;
    }

    public final OutputPort getOutputPort(String str) {
        if (this.mInputPorts == null) {
            throw new NullPointerException("Attempting to access output port '" + str + "' of " + this + " before Filter has been initialized!");
        }
        OutputPort outputPort = this.mOutputPorts.get(str);
        if (outputPort == null) {
            throw new IllegalArgumentException("Unknown output port '" + str + "' on filter " + this + "!");
        }
        return outputPort;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Collection<OutputPort> getOutputPorts() {
        return this.mOutputPorts.values();
    }

    public final int getSleepDelay() {
        return 250;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getStatus() {
        int i;
        synchronized (this) {
            i = this.mStatus;
        }
        return i;
    }

    public final void init() throws ProtocolException {
        initWithValueMap(new KeyValueMap());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initProgramInputs(Program program, FilterContext filterContext) {
        if (program != null) {
            for (InputPort inputPort : this.mInputPorts.values()) {
                if (inputPort.getTarget() == program) {
                    inputPort.transfer(filterContext);
                }
            }
        }
    }

    public final void initWithAssignmentList(Object... objArr) {
        KeyValueMap keyValueMap = new KeyValueMap();
        keyValueMap.setKeyValues(objArr);
        initWithValueMap(keyValueMap);
    }

    public final void initWithAssignmentString(String str) {
        try {
            initWithValueMap(new TextGraphReader().readKeyValueAssignments(str));
        } catch (GraphIOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public final void initWithValueMap(KeyValueMap keyValueMap) {
        initFinalPorts(keyValueMap);
        initRemainingPorts(keyValueMap);
        this.mStatus = 1;
    }

    public boolean isOpen() {
        return this.mIsOpen;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void notifyFieldPortValueUpdated(String str, FilterContext filterContext) {
        if (this.mStatus == 3 || this.mStatus == 2) {
            fieldPortValueUpdated(str, filterContext);
        }
    }

    public void open(FilterContext filterContext) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void openOutputs() {
        if (this.mLogVerbose) {
            Log.v(TAG, "Opening all output ports on " + this + "!");
        }
        for (OutputPort outputPort : this.mOutputPorts.values()) {
            if (!outputPort.isOpen()) {
                outputPort.open();
            }
        }
    }

    protected void parametersUpdated(Set<String> set) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void performClose(FilterContext filterContext) {
        synchronized (this) {
            if (this.mIsOpen) {
                if (this.mLogVerbose) {
                    Log.v(TAG, "Closing " + this);
                }
                this.mIsOpen = false;
                this.mStatus = 2;
                close(filterContext);
                closePorts();
            }
        }
    }

    final void performOpen(FilterContext filterContext) {
        synchronized (this) {
            if (!this.mIsOpen) {
                if (this.mStatus == 1) {
                    if (this.mLogVerbose) {
                        Log.v(TAG, "Preparing " + this);
                    }
                    prepare(filterContext);
                    this.mStatus = 2;
                }
                if (this.mStatus == 2) {
                    if (this.mLogVerbose) {
                        Log.v(TAG, "Opening " + this);
                    }
                    open(filterContext);
                    this.mStatus = 3;
                }
                if (this.mStatus != 3) {
                    throw new RuntimeException("Filter " + this + " was brought into invalid state during opening (state: " + this.mStatus + ")!");
                }
                this.mIsOpen = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void performProcess(FilterContext filterContext) {
        synchronized (this) {
            if (this.mStatus == 7) {
                throw new RuntimeException("Filter " + this + " is already torn down!");
            }
            transferInputFrames(filterContext);
            if (this.mStatus < 3) {
                performOpen(filterContext);
            }
            if (this.mLogVerbose) {
                Log.v(TAG, "Processing " + this);
            }
            this.mCurrentTimestamp = -1L;
            process(filterContext);
            releasePulledFrames(filterContext);
            if (filterMustClose()) {
                performClose(filterContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void performTearDown(FilterContext filterContext) {
        synchronized (this) {
            performClose(filterContext);
            if (this.mStatus != 7) {
                tearDown(filterContext);
                this.mStatus = 7;
            }
        }
    }

    protected void prepare(FilterContext filterContext) {
    }

    public abstract void process(FilterContext filterContext);

    /* JADX INFO: Access modifiers changed from: protected */
    public final Frame pullInput(String str) {
        Frame pullFrame = getInputPort(str).pullFrame();
        if (this.mCurrentTimestamp == -1) {
            this.mCurrentTimestamp = pullFrame.getTimestamp();
            if (this.mLogVerbose) {
                Log.v(TAG, "Default-setting current timestamp from input port " + str + " to " + this.mCurrentTimestamp);
            }
        }
        this.mFramesToRelease.add(pullFrame);
        return pullFrame;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void pushInputFrame(String str, Frame frame) {
        synchronized (this) {
            InputPort inputPort = getInputPort(str);
            if (!inputPort.isOpen()) {
                inputPort.open();
            }
            inputPort.pushFrame(frame);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void pushInputValue(String str, Object obj) {
        synchronized (this) {
            pushInputFrame(str, wrapInputValue(str, obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void pushOutput(String str, Frame frame) {
        if (frame.getTimestamp() == -2) {
            if (this.mLogVerbose) {
                Log.v(TAG, "Default-setting output Frame timestamp on port " + str + " to " + this.mCurrentTimestamp);
            }
            frame.setTimestamp(this.mCurrentTimestamp);
        }
        getOutputPort(str).pushFrame(frame);
    }

    public void setInputFrame(String str, Frame frame) {
        InputPort inputPort = getInputPort(str);
        if (!inputPort.isOpen()) {
            inputPort.open();
        }
        inputPort.setFrame(frame);
    }

    public final void setInputValue(String str, Object obj) {
        setInputFrame(str, wrapInputValue(str, obj));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setWaitsOnInputPort(String str, boolean z) {
        getInputPort(str).setBlocking(z);
    }

    protected void setWaitsOnOutputPort(String str, boolean z) {
        getOutputPort(str).setBlocking(z);
    }

    public abstract void setupPorts();

    public void tearDown(FilterContext filterContext) {
    }

    public String toString() {
        return "'" + getName() + "' (" + getFilterClassName() + ")";
    }

    protected void transferInputPortFrame(String str, FilterContext filterContext) {
        getInputPort(str).transfer(filterContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void unsetStatus(int i) {
        synchronized (this) {
            this.mStatus &= i ^ (-1);
        }
    }
}
