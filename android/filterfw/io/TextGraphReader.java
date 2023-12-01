package android.filterfw.io;

import android.filterfw.core.Filter;
import android.filterfw.core.FilterFactory;
import android.filterfw.core.FilterGraph;
import android.filterfw.core.KeyValueMap;
import android.filterfw.core.ProtocolException;
import com.huawei.openalliance.ad.constant.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/io/TextGraphReader.class */
public class TextGraphReader extends GraphReader {
    private KeyValueMap mBoundReferences;
    private ArrayList<Command> mCommands = new ArrayList<>();
    private Filter mCurrentFilter;
    private FilterGraph mCurrentGraph;
    private FilterFactory mFactory;
    private KeyValueMap mSettings;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/filterfw/io/TextGraphReader$AddLibraryCommand.class */
    public class AddLibraryCommand implements Command {
        private String mLibraryName;

        public AddLibraryCommand(String str) {
            this.mLibraryName = str;
        }

        @Override // android.filterfw.io.TextGraphReader.Command
        public void execute(TextGraphReader textGraphReader) {
            FilterFactory unused = textGraphReader.mFactory;
            FilterFactory.addFilterLibrary(this.mLibraryName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/filterfw/io/TextGraphReader$AllocateFilterCommand.class */
    public class AllocateFilterCommand implements Command {
        private String mClassName;
        private String mFilterName;

        public AllocateFilterCommand(String str, String str2) {
            this.mClassName = str;
            this.mFilterName = str2;
        }

        @Override // android.filterfw.io.TextGraphReader.Command
        public void execute(TextGraphReader textGraphReader) throws GraphIOException {
            try {
                textGraphReader.mCurrentFilter = textGraphReader.mFactory.createFilterByClassName(this.mClassName, this.mFilterName);
            } catch (IllegalArgumentException e) {
                throw new GraphIOException(e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/filterfw/io/TextGraphReader$Command.class */
    public interface Command {
        void execute(TextGraphReader textGraphReader) throws GraphIOException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/filterfw/io/TextGraphReader$ConnectCommand.class */
    public class ConnectCommand implements Command {
        private String mSourceFilter;
        private String mSourcePort;
        private String mTargetFilter;
        private String mTargetName;

        public ConnectCommand(String str, String str2, String str3, String str4) {
            this.mSourceFilter = str;
            this.mSourcePort = str2;
            this.mTargetFilter = str3;
            this.mTargetName = str4;
        }

        @Override // android.filterfw.io.TextGraphReader.Command
        public void execute(TextGraphReader textGraphReader) {
            textGraphReader.mCurrentGraph.connect(this.mSourceFilter, this.mSourcePort, this.mTargetFilter, this.mTargetName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/filterfw/io/TextGraphReader$ImportPackageCommand.class */
    public class ImportPackageCommand implements Command {
        private String mPackageName;

        public ImportPackageCommand(String str) {
            this.mPackageName = str;
        }

        @Override // android.filterfw.io.TextGraphReader.Command
        public void execute(TextGraphReader textGraphReader) throws GraphIOException {
            try {
                textGraphReader.mFactory.addPackage(this.mPackageName);
            } catch (IllegalArgumentException e) {
                throw new GraphIOException(e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/filterfw/io/TextGraphReader$InitFilterCommand.class */
    public class InitFilterCommand implements Command {
        private KeyValueMap mParams;

        public InitFilterCommand(KeyValueMap keyValueMap) {
            this.mParams = keyValueMap;
        }

        @Override // android.filterfw.io.TextGraphReader.Command
        public void execute(TextGraphReader textGraphReader) throws GraphIOException {
            try {
                textGraphReader.mCurrentFilter.initWithValueMap(this.mParams);
                textGraphReader.mCurrentGraph.addFilter(TextGraphReader.this.mCurrentFilter);
            } catch (ProtocolException e) {
                throw new GraphIOException(e.getMessage());
            }
        }
    }

    private void applySettings() throws GraphIOException {
        for (String str : this.mSettings.keySet()) {
            Object obj = this.mSettings.get(str);
            if (str.equals("autoBranch")) {
                expectSettingClass(str, obj, String.class);
                if (obj.equals("synced")) {
                    this.mCurrentGraph.setAutoBranchMode(1);
                } else if (obj.equals("unsynced")) {
                    this.mCurrentGraph.setAutoBranchMode(2);
                } else if (!obj.equals("off")) {
                    throw new GraphIOException("Unknown autobranch setting: " + obj + "!");
                } else {
                    this.mCurrentGraph.setAutoBranchMode(0);
                }
            } else if (!str.equals("discardUnconnectedOutputs")) {
                throw new GraphIOException("Unknown @setting '" + str + "'!");
            } else {
                expectSettingClass(str, obj, Boolean.class);
                this.mCurrentGraph.setDiscardUnconnectedOutputs(((Boolean) obj).booleanValue());
            }
        }
    }

    private void bindExternal(String str) throws GraphIOException {
        if (!this.mReferences.containsKey(str)) {
            throw new GraphIOException("Unknown external variable '" + str + "'! You must add a reference to this external in the host program using addReference(...)!");
        }
        this.mBoundReferences.put(str, this.mReferences.get(str));
    }

    private void checkReferences() throws GraphIOException {
        for (String str : this.mReferences.keySet()) {
            if (!this.mBoundReferences.containsKey(str)) {
                throw new GraphIOException("Host program specifies reference to '" + str + "', which is not declared @external in graph file!");
            }
        }
    }

    private void executeCommands() throws GraphIOException {
        Iterator<Command> it = this.mCommands.iterator();
        while (it.hasNext()) {
            it.next().execute(this);
        }
    }

    private void expectSettingClass(String str, Object obj, Class cls) throws GraphIOException {
        if (obj.getClass() != cls) {
            throw new GraphIOException("Setting '" + str + "' must have a value of type " + cls.getSimpleName() + ", but found a value of type " + obj.getClass().getSimpleName() + "!");
        }
    }

    private void parseString(String str) throws GraphIOException {
        Pattern compile = Pattern.compile("@[a-zA-Z]+");
        Pattern compile2 = Pattern.compile("\\}");
        Pattern compile3 = Pattern.compile("\\{");
        Pattern compile4 = Pattern.compile("(\\s+|//[^\\n]*\\n)+");
        Pattern compile5 = Pattern.compile("[a-zA-Z\\.]+");
        Pattern compile6 = Pattern.compile("[a-zA-Z\\./:]+");
        Pattern compile7 = Pattern.compile("\\[[a-zA-Z0-9\\-_]+\\]");
        Pattern compile8 = Pattern.compile("=>");
        Pattern compile9 = Pattern.compile(t.aE);
        Pattern compile10 = Pattern.compile("[a-zA-Z0-9\\-_]+");
        boolean z = false;
        PatternScanner patternScanner = new PatternScanner(str, compile4);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        while (!patternScanner.atEnd()) {
            switch (z) {
                case false:
                    String eat = patternScanner.eat(compile, "<command>");
                    if (eat.equals("@import")) {
                        z = true;
                        break;
                    } else if (eat.equals("@library")) {
                        z = true;
                        break;
                    } else if (eat.equals("@filter")) {
                        z = true;
                        break;
                    } else if (eat.equals("@connect")) {
                        z = true;
                        break;
                    } else if (eat.equals("@set")) {
                        z = true;
                        break;
                    } else if (eat.equals("@external")) {
                        z = true;
                        break;
                    } else if (!eat.equals("@setting")) {
                        throw new GraphIOException("Unknown command '" + eat + "'!");
                    } else {
                        z = true;
                        break;
                    }
                case true:
                    this.mCommands.add(new ImportPackageCommand(patternScanner.eat(compile5, "<package-name>")));
                    z = true;
                    break;
                case true:
                    this.mCommands.add(new AddLibraryCommand(patternScanner.eat(compile6, "<library-name>")));
                    z = true;
                    break;
                case true:
                    str2 = patternScanner.eat(compile10, "<class-name>");
                    z = true;
                    break;
                case true:
                    this.mCommands.add(new AllocateFilterCommand(str2, patternScanner.eat(compile10, "<filter-name>")));
                    z = true;
                    break;
                case true:
                    patternScanner.eat(compile3, "{");
                    z = true;
                    break;
                case true:
                    this.mCommands.add(new InitFilterCommand(readKeyValueAssignments(patternScanner, compile2)));
                    z = true;
                    break;
                case true:
                    patternScanner.eat(compile2, "}");
                    z = false;
                    break;
                case true:
                    str3 = patternScanner.eat(compile10, "<source-filter-name>");
                    z = true;
                    break;
                case true:
                    String eat2 = patternScanner.eat(compile7, "[<source-port-name>]");
                    str4 = eat2.substring(1, eat2.length() - 1);
                    z = true;
                    break;
                case true:
                    patternScanner.eat(compile8, "=>");
                    z = true;
                    break;
                case true:
                    str5 = patternScanner.eat(compile10, "<target-filter-name>");
                    z = true;
                    break;
                case true:
                    String eat3 = patternScanner.eat(compile7, "[<target-port-name>]");
                    this.mCommands.add(new ConnectCommand(str3, str4, str5, eat3.substring(1, eat3.length() - 1)));
                    z = true;
                    break;
                case true:
                    this.mBoundReferences.putAll(readKeyValueAssignments(patternScanner, compile9));
                    z = true;
                    break;
                case true:
                    bindExternal(patternScanner.eat(compile10, "<external-identifier>"));
                    z = true;
                    break;
                case true:
                    this.mSettings.putAll(readKeyValueAssignments(patternScanner, compile9));
                    z = true;
                    break;
                case true:
                    patternScanner.eat(compile9, t.aE);
                    z = false;
                    break;
            }
        }
        if (!z && z) {
            throw new GraphIOException("Unexpected end of input!");
        }
    }

    private KeyValueMap readKeyValueAssignments(PatternScanner patternScanner, Pattern pattern) throws GraphIOException {
        Pattern compile = Pattern.compile("=");
        Pattern compile2 = Pattern.compile(t.aE);
        Pattern compile3 = Pattern.compile("[a-zA-Z]+[a-zA-Z0-9]*");
        Pattern compile4 = Pattern.compile("'[^']*'|\\\"[^\\\"]*\\\"");
        Pattern compile5 = Pattern.compile("[0-9]+");
        Pattern compile6 = Pattern.compile("[0-9]*\\.[0-9]+f?");
        Pattern compile7 = Pattern.compile("\\$[a-zA-Z]+[a-zA-Z0-9]");
        Pattern compile8 = Pattern.compile("true|false");
        boolean z = false;
        KeyValueMap keyValueMap = new KeyValueMap();
        String str = null;
        while (!patternScanner.atEnd() && (pattern == null || !patternScanner.peek(pattern))) {
            switch (z) {
                case false:
                    str = patternScanner.eat(compile3, "<identifier>");
                    z = true;
                    break;
                case true:
                    patternScanner.eat(compile, "=");
                    z = true;
                    break;
                case true:
                    String tryEat = patternScanner.tryEat(compile4);
                    if (tryEat != null) {
                        keyValueMap.put(str, tryEat.substring(1, tryEat.length() - 1));
                    } else {
                        String tryEat2 = patternScanner.tryEat(compile7);
                        if (tryEat2 != null) {
                            String substring = tryEat2.substring(1, tryEat2.length());
                            Object obj = this.mBoundReferences != null ? this.mBoundReferences.get(substring) : null;
                            if (obj == null) {
                                throw new GraphIOException("Unknown object reference to '" + substring + "'!");
                            }
                            keyValueMap.put(str, obj);
                        } else {
                            String tryEat3 = patternScanner.tryEat(compile8);
                            if (tryEat3 != null) {
                                keyValueMap.put(str, Boolean.valueOf(Boolean.parseBoolean(tryEat3)));
                            } else {
                                String tryEat4 = patternScanner.tryEat(compile6);
                                if (tryEat4 != null) {
                                    keyValueMap.put(str, Float.valueOf(Float.parseFloat(tryEat4)));
                                } else {
                                    String tryEat5 = patternScanner.tryEat(compile5);
                                    if (tryEat5 == null) {
                                        throw new GraphIOException(patternScanner.unexpectedTokenMessage("<value>"));
                                    }
                                    keyValueMap.put(str, Integer.valueOf(Integer.parseInt(tryEat5)));
                                }
                            }
                        }
                    }
                    z = true;
                    break;
                case true:
                    patternScanner.eat(compile2, t.aE);
                    z = false;
                    break;
            }
        }
        if (!z || z) {
            return keyValueMap;
        }
        throw new GraphIOException("Unexpected end of assignments on line " + patternScanner.lineNo() + "!");
    }

    private void reset() {
        this.mCurrentGraph = null;
        this.mCurrentFilter = null;
        this.mCommands.clear();
        this.mBoundReferences = new KeyValueMap();
        this.mSettings = new KeyValueMap();
        this.mFactory = new FilterFactory();
    }

    @Override // android.filterfw.io.GraphReader
    public FilterGraph readGraphString(String str) throws GraphIOException {
        FilterGraph filterGraph = new FilterGraph();
        reset();
        this.mCurrentGraph = filterGraph;
        parseString(str);
        applySettings();
        executeCommands();
        reset();
        return filterGraph;
    }

    @Override // android.filterfw.io.GraphReader
    public KeyValueMap readKeyValueAssignments(String str) throws GraphIOException {
        return readKeyValueAssignments(new PatternScanner(str, Pattern.compile("\\s+")), null);
    }
}
