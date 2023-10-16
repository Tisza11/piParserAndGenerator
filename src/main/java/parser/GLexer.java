// Generated from C:/egyetem masolat/felev7/Szakdoga/piParserAndGenerator/grammar/G.g4 by ANTLR 4.13.1
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class GLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, WS=17, 
		NL=18, BC=19, LC=20, WORD=21, INT=22, END=23, STAR=24, OTHER=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "WS", "NL", 
			"BC", "LC", "WORD", "INT", "END", "STAR", "OTHER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'='", "'!='", "'>'", "'<'", "'&'", "','", "':'", 
			"'?'", "'['", "']'", "'('", "')'", "'{'", "'}'", null, null, null, null, 
			null, null, "';'", "'*'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "WS", "NL", "BC", "LC", "WORD", "INT", 
			"END", "STAR", "OTHER"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public GLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "G.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0019\u0094\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0004\u0010V\b\u0010\u000b\u0010\f\u0010"+
		"W\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0003\u0011^\b\u0011"+
		"\u0001\u0011\u0003\u0011a\b\u0011\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012i\b\u0012\n\u0012\f\u0012"+
		"l\t\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013w\b\u0013"+
		"\n\u0013\f\u0013z\t\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0004\u0014"+
		"\u007f\b\u0014\u000b\u0014\f\u0014\u0080\u0001\u0014\u0004\u0014\u0084"+
		"\b\u0014\u000b\u0014\f\u0014\u0085\u0001\u0015\u0004\u0015\u0089\b\u0015"+
		"\u000b\u0015\f\u0015\u008a\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001j\u0000\u0019\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d"+
		"\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/"+
		"\u00181\u0019\u0001\u0000\u0005\u0002\u0000\t\t  \u0002\u0000\n\n\r\r"+
		"\u0002\u0000AZaz\u0002\u000009__\u0001\u000009\u009c\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000"+
		"\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'"+
		"\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000"+
		"\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000"+
		"\u00001\u0001\u0000\u0000\u0000\u00013\u0001\u0000\u0000\u0000\u00035"+
		"\u0001\u0000\u0000\u0000\u00057\u0001\u0000\u0000\u0000\u00079\u0001\u0000"+
		"\u0000\u0000\t<\u0001\u0000\u0000\u0000\u000b>\u0001\u0000\u0000\u0000"+
		"\r@\u0001\u0000\u0000\u0000\u000fB\u0001\u0000\u0000\u0000\u0011D\u0001"+
		"\u0000\u0000\u0000\u0013F\u0001\u0000\u0000\u0000\u0015H\u0001\u0000\u0000"+
		"\u0000\u0017J\u0001\u0000\u0000\u0000\u0019L\u0001\u0000\u0000\u0000\u001b"+
		"N\u0001\u0000\u0000\u0000\u001dP\u0001\u0000\u0000\u0000\u001fR\u0001"+
		"\u0000\u0000\u0000!U\u0001\u0000\u0000\u0000#`\u0001\u0000\u0000\u0000"+
		"%d\u0001\u0000\u0000\u0000\'r\u0001\u0000\u0000\u0000)\u0083\u0001\u0000"+
		"\u0000\u0000+\u0088\u0001\u0000\u0000\u0000-\u008c\u0001\u0000\u0000\u0000"+
		"/\u008e\u0001\u0000\u0000\u00001\u0090\u0001\u0000\u0000\u000034\u0005"+
		"+\u0000\u00004\u0002\u0001\u0000\u0000\u000056\u0005-\u0000\u00006\u0004"+
		"\u0001\u0000\u0000\u000078\u0005=\u0000\u00008\u0006\u0001\u0000\u0000"+
		"\u00009:\u0005!\u0000\u0000:;\u0005=\u0000\u0000;\b\u0001\u0000\u0000"+
		"\u0000<=\u0005>\u0000\u0000=\n\u0001\u0000\u0000\u0000>?\u0005<\u0000"+
		"\u0000?\f\u0001\u0000\u0000\u0000@A\u0005&\u0000\u0000A\u000e\u0001\u0000"+
		"\u0000\u0000BC\u0005,\u0000\u0000C\u0010\u0001\u0000\u0000\u0000DE\u0005"+
		":\u0000\u0000E\u0012\u0001\u0000\u0000\u0000FG\u0005?\u0000\u0000G\u0014"+
		"\u0001\u0000\u0000\u0000HI\u0005[\u0000\u0000I\u0016\u0001\u0000\u0000"+
		"\u0000JK\u0005]\u0000\u0000K\u0018\u0001\u0000\u0000\u0000LM\u0005(\u0000"+
		"\u0000M\u001a\u0001\u0000\u0000\u0000NO\u0005)\u0000\u0000O\u001c\u0001"+
		"\u0000\u0000\u0000PQ\u0005{\u0000\u0000Q\u001e\u0001\u0000\u0000\u0000"+
		"RS\u0005}\u0000\u0000S \u0001\u0000\u0000\u0000TV\u0007\u0000\u0000\u0000"+
		"UT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000"+
		"\u0000WX\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000YZ\u0006\u0010"+
		"\u0000\u0000Z\"\u0001\u0000\u0000\u0000[]\u0005\r\u0000\u0000\\^\u0005"+
		"n\u0000\u0000]\\\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^a\u0001"+
		"\u0000\u0000\u0000_a\u0005\n\u0000\u0000`[\u0001\u0000\u0000\u0000`_\u0001"+
		"\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000bc\u0006\u0011\u0000\u0000"+
		"c$\u0001\u0000\u0000\u0000de\u0005/\u0000\u0000ef\u0005*\u0000\u0000f"+
		"j\u0001\u0000\u0000\u0000gi\t\u0000\u0000\u0000hg\u0001\u0000\u0000\u0000"+
		"il\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000"+
		"\u0000km\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000mn\u0005*\u0000"+
		"\u0000no\u0005/\u0000\u0000op\u0001\u0000\u0000\u0000pq\u0006\u0012\u0000"+
		"\u0000q&\u0001\u0000\u0000\u0000rs\u0005/\u0000\u0000st\u0005/\u0000\u0000"+
		"tx\u0001\u0000\u0000\u0000uw\b\u0001\u0000\u0000vu\u0001\u0000\u0000\u0000"+
		"wz\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000"+
		"\u0000y{\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000{|\u0006\u0013"+
		"\u0000\u0000|(\u0001\u0000\u0000\u0000}\u007f\u0007\u0002\u0000\u0000"+
		"~}\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080~"+
		"\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0084"+
		"\u0001\u0000\u0000\u0000\u0082\u0084\u0007\u0003\u0000\u0000\u0083~\u0001"+
		"\u0000\u0000\u0000\u0083\u0082\u0001\u0000\u0000\u0000\u0084\u0085\u0001"+
		"\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001"+
		"\u0000\u0000\u0000\u0086*\u0001\u0000\u0000\u0000\u0087\u0089\u0007\u0004"+
		"\u0000\u0000\u0088\u0087\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000"+
		"\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000"+
		"\u0000\u0000\u008b,\u0001\u0000\u0000\u0000\u008c\u008d\u0005;\u0000\u0000"+
		"\u008d.\u0001\u0000\u0000\u0000\u008e\u008f\u0005*\u0000\u0000\u008f0"+
		"\u0001\u0000\u0000\u0000\u0090\u0091\t\u0000\u0000\u0000\u0091\u0092\u0001"+
		"\u0000\u0000\u0000\u0092\u0093\u0006\u0018\u0000\u0000\u00932\u0001\u0000"+
		"\u0000\u0000\n\u0000W]`jx\u0080\u0083\u0085\u008a\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}