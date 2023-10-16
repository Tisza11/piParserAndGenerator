// Generated from C:/egyetem masolat/felev7/Szakdoga/piParserAndGenerator/grammar/G.g4 by ANTLR 4.13.1
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class GParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, WS=17, 
		NL=18, BC=19, LC=20, WORD=21, INT=22, END=23, STAR=24, OTHER=25;
	public static final int
		RULE_operands = 0, RULE_brackets = 1, RULE_braces = 2, RULE_curlys = 3, 
		RULE_returnType = 4, RULE_fnName = 5, RULE_func = 6, RULE_prule = 7, RULE_sthing = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"operands", "brackets", "braces", "curlys", "returnType", "fnName", "func", 
			"prule", "sthing"
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

	@Override
	public String getGrammarFileName() { return "G.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OperandsContext extends ParserRuleContext {
		public OperandsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operands; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GListener ) ((GListener)listener).enterOperands(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GListener ) ((GListener)listener).exitOperands(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GVisitor ) return ((GVisitor<? extends T>)visitor).visitOperands(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperandsContext operands() throws RecognitionException {
		OperandsContext _localctx = new OperandsContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_operands);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2046L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BracketsContext extends ParserRuleContext {
		public List<BracketsContext> brackets() {
			return getRuleContexts(BracketsContext.class);
		}
		public BracketsContext brackets(int i) {
			return getRuleContext(BracketsContext.class,i);
		}
		public List<BracesContext> braces() {
			return getRuleContexts(BracesContext.class);
		}
		public BracesContext braces(int i) {
			return getRuleContext(BracesContext.class,i);
		}
		public List<CurlysContext> curlys() {
			return getRuleContexts(CurlysContext.class);
		}
		public CurlysContext curlys(int i) {
			return getRuleContext(CurlysContext.class,i);
		}
		public List<OperandsContext> operands() {
			return getRuleContexts(OperandsContext.class);
		}
		public OperandsContext operands(int i) {
			return getRuleContext(OperandsContext.class,i);
		}
		public List<TerminalNode> INT() { return getTokens(GParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(GParser.INT, i);
		}
		public List<TerminalNode> STAR() { return getTokens(GParser.STAR); }
		public TerminalNode STAR(int i) {
			return getToken(GParser.STAR, i);
		}
		public List<TerminalNode> END() { return getTokens(GParser.END); }
		public TerminalNode END(int i) {
			return getToken(GParser.END, i);
		}
		public List<TerminalNode> WORD() { return getTokens(GParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(GParser.WORD, i);
		}
		public BracketsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_brackets; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GListener ) ((GListener)listener).enterBrackets(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GListener ) ((GListener)listener).exitBrackets(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GVisitor ) return ((GVisitor<? extends T>)visitor).visitBrackets(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BracketsContext brackets() throws RecognitionException {
		BracketsContext _localctx = new BracketsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_brackets);
		int _la;
		try {
			int _alt;
			setState(43);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(20);
				match(T__10);
				setState(33); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(33);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__10:
						{
						setState(21);
						brackets();
						}
						break;
					case T__12:
						{
						setState(22);
						braces();
						}
						break;
					case T__14:
						{
						setState(23);
						curlys();
						}
						break;
					case WORD:
						{
						setState(25); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(24);
								match(WORD);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(27); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					case T__0:
					case T__1:
					case T__2:
					case T__3:
					case T__4:
					case T__5:
					case T__6:
					case T__7:
					case T__8:
					case T__9:
						{
						setState(29);
						operands();
						}
						break;
					case INT:
						{
						setState(30);
						match(INT);
						}
						break;
					case STAR:
						{
						setState(31);
						match(STAR);
						}
						break;
					case END:
						{
						setState(32);
						match(END);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(35); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 31502334L) != 0) );
				setState(37);
				match(T__11);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(38);
				match(T__10);
				setState(39);
				match(T__11);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(40);
				match(T__10);
				setState(41);
				matchWildcard();
				setState(42);
				match(T__11);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BracesContext extends ParserRuleContext {
		public List<BracesContext> braces() {
			return getRuleContexts(BracesContext.class);
		}
		public BracesContext braces(int i) {
			return getRuleContext(BracesContext.class,i);
		}
		public List<BracketsContext> brackets() {
			return getRuleContexts(BracketsContext.class);
		}
		public BracketsContext brackets(int i) {
			return getRuleContext(BracketsContext.class,i);
		}
		public List<CurlysContext> curlys() {
			return getRuleContexts(CurlysContext.class);
		}
		public CurlysContext curlys(int i) {
			return getRuleContext(CurlysContext.class,i);
		}
		public List<OperandsContext> operands() {
			return getRuleContexts(OperandsContext.class);
		}
		public OperandsContext operands(int i) {
			return getRuleContext(OperandsContext.class,i);
		}
		public List<TerminalNode> INT() { return getTokens(GParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(GParser.INT, i);
		}
		public List<TerminalNode> STAR() { return getTokens(GParser.STAR); }
		public TerminalNode STAR(int i) {
			return getToken(GParser.STAR, i);
		}
		public List<TerminalNode> END() { return getTokens(GParser.END); }
		public TerminalNode END(int i) {
			return getToken(GParser.END, i);
		}
		public List<TerminalNode> WORD() { return getTokens(GParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(GParser.WORD, i);
		}
		public BracesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_braces; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GListener ) ((GListener)listener).enterBraces(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GListener ) ((GListener)listener).exitBraces(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GVisitor ) return ((GVisitor<? extends T>)visitor).visitBraces(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BracesContext braces() throws RecognitionException {
		BracesContext _localctx = new BracesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_braces);
		int _la;
		try {
			int _alt;
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				match(T__12);
				setState(58); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(58);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__12:
						{
						setState(46);
						braces();
						}
						break;
					case T__10:
						{
						setState(47);
						brackets();
						}
						break;
					case T__14:
						{
						setState(48);
						curlys();
						}
						break;
					case WORD:
						{
						setState(50); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(49);
								match(WORD);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(52); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					case T__0:
					case T__1:
					case T__2:
					case T__3:
					case T__4:
					case T__5:
					case T__6:
					case T__7:
					case T__8:
					case T__9:
						{
						setState(54);
						operands();
						}
						break;
					case INT:
						{
						setState(55);
						match(INT);
						}
						break;
					case STAR:
						{
						setState(56);
						match(STAR);
						}
						break;
					case END:
						{
						setState(57);
						match(END);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(60); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 31502334L) != 0) );
				setState(62);
				match(T__13);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				match(T__12);
				setState(64);
				match(T__13);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(65);
				match(T__12);
				setState(66);
				matchWildcard();
				setState(67);
				match(T__13);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CurlysContext extends ParserRuleContext {
		public List<OperandsContext> operands() {
			return getRuleContexts(OperandsContext.class);
		}
		public OperandsContext operands(int i) {
			return getRuleContext(OperandsContext.class,i);
		}
		public List<TerminalNode> INT() { return getTokens(GParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(GParser.INT, i);
		}
		public List<TerminalNode> STAR() { return getTokens(GParser.STAR); }
		public TerminalNode STAR(int i) {
			return getToken(GParser.STAR, i);
		}
		public List<BracesContext> braces() {
			return getRuleContexts(BracesContext.class);
		}
		public BracesContext braces(int i) {
			return getRuleContext(BracesContext.class,i);
		}
		public List<BracketsContext> brackets() {
			return getRuleContexts(BracketsContext.class);
		}
		public BracketsContext brackets(int i) {
			return getRuleContext(BracketsContext.class,i);
		}
		public List<CurlysContext> curlys() {
			return getRuleContexts(CurlysContext.class);
		}
		public CurlysContext curlys(int i) {
			return getRuleContext(CurlysContext.class,i);
		}
		public List<TerminalNode> END() { return getTokens(GParser.END); }
		public TerminalNode END(int i) {
			return getToken(GParser.END, i);
		}
		public List<TerminalNode> WORD() { return getTokens(GParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(GParser.WORD, i);
		}
		public CurlysContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_curlys; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GListener ) ((GListener)listener).enterCurlys(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GListener ) ((GListener)listener).exitCurlys(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GVisitor ) return ((GVisitor<? extends T>)visitor).visitCurlys(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CurlysContext curlys() throws RecognitionException {
		CurlysContext _localctx = new CurlysContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_curlys);
		int _la;
		try {
			int _alt;
			setState(93);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				match(T__14);
				setState(83); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(83);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case WORD:
						{
						setState(72); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(71);
								match(WORD);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(74); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					case T__0:
					case T__1:
					case T__2:
					case T__3:
					case T__4:
					case T__5:
					case T__6:
					case T__7:
					case T__8:
					case T__9:
						{
						setState(76);
						operands();
						}
						break;
					case INT:
						{
						setState(77);
						match(INT);
						}
						break;
					case STAR:
						{
						setState(78);
						match(STAR);
						}
						break;
					case T__12:
						{
						setState(79);
						braces();
						}
						break;
					case T__10:
						{
						setState(80);
						brackets();
						}
						break;
					case T__14:
						{
						setState(81);
						curlys();
						}
						break;
					case END:
						{
						setState(82);
						match(END);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(85); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 31502334L) != 0) );
				setState(87);
				match(T__15);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				match(T__14);
				setState(89);
				match(T__15);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(90);
				match(T__14);
				setState(91);
				matchWildcard();
				setState(92);
				match(T__15);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnTypeContext extends ParserRuleContext {
		public List<TerminalNode> STAR() { return getTokens(GParser.STAR); }
		public TerminalNode STAR(int i) {
			return getToken(GParser.STAR, i);
		}
		public List<TerminalNode> WORD() { return getTokens(GParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(GParser.WORD, i);
		}
		public ReturnTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GListener ) ((GListener)listener).enterReturnType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GListener ) ((GListener)listener).exitReturnType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GVisitor ) return ((GVisitor<? extends T>)visitor).visitReturnType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnTypeContext returnType() throws RecognitionException {
		ReturnTypeContext _localctx = new ReturnTypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_returnType);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(101); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(101);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case WORD:
						{
						setState(96); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(95);
								match(WORD);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(98); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					case STAR:
						{
						setState(100);
						match(STAR);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(103); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FnNameContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(GParser.WORD, 0); }
		public FnNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fnName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GListener ) ((GListener)listener).enterFnName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GListener ) ((GListener)listener).exitFnName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GVisitor ) return ((GVisitor<? extends T>)visitor).visitFnName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FnNameContext fnName() throws RecognitionException {
		FnNameContext _localctx = new FnNameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_fnName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(WORD);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FuncContext extends ParserRuleContext {
		public ReturnTypeContext returnType() {
			return getRuleContext(ReturnTypeContext.class,0);
		}
		public FnNameContext fnName() {
			return getRuleContext(FnNameContext.class,0);
		}
		public BracesContext braces() {
			return getRuleContext(BracesContext.class,0);
		}
		public CurlysContext curlys() {
			return getRuleContext(CurlysContext.class,0);
		}
		public List<TerminalNode> STAR() { return getTokens(GParser.STAR); }
		public TerminalNode STAR(int i) {
			return getToken(GParser.STAR, i);
		}
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GListener ) ((GListener)listener).enterFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GListener ) ((GListener)listener).exitFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GVisitor ) return ((GVisitor<? extends T>)visitor).visitFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(107);
			returnType();
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STAR) {
				{
				{
				setState(108);
				match(STAR);
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(114);
			fnName();
			setState(115);
			braces();
			setState(116);
			curlys();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PruleContext extends ParserRuleContext {
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public List<SthingContext> sthing() {
			return getRuleContexts(SthingContext.class);
		}
		public SthingContext sthing(int i) {
			return getRuleContext(SthingContext.class,i);
		}
		public PruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GListener ) ((GListener)listener).enterPrule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GListener ) ((GListener)listener).exitPrule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GVisitor ) return ((GVisitor<? extends T>)visitor).visitPrule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PruleContext prule() throws RecognitionException {
		PruleContext _localctx = new PruleContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_prule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(120);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(118);
					func();
					}
					break;
				case 2:
					{
					setState(119);
					sthing();
					}
					break;
				}
				}
				setState(122); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 65056766L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SthingContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(GParser.WORD, 0); }
		public OperandsContext operands() {
			return getRuleContext(OperandsContext.class,0);
		}
		public BracesContext braces() {
			return getRuleContext(BracesContext.class,0);
		}
		public BracketsContext brackets() {
			return getRuleContext(BracketsContext.class,0);
		}
		public CurlysContext curlys() {
			return getRuleContext(CurlysContext.class,0);
		}
		public TerminalNode INT() { return getToken(GParser.INT, 0); }
		public TerminalNode END() { return getToken(GParser.END, 0); }
		public TerminalNode STAR() { return getToken(GParser.STAR, 0); }
		public TerminalNode OTHER() { return getToken(GParser.OTHER, 0); }
		public SthingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sthing; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GListener ) ((GListener)listener).enterSthing(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GListener ) ((GListener)listener).exitSthing(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GVisitor ) return ((GVisitor<? extends T>)visitor).visitSthing(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SthingContext sthing() throws RecognitionException {
		SthingContext _localctx = new SthingContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_sthing);
		try {
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				match(WORD);
				}
				break;
			case T__0:
			case T__1:
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				operands();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 3);
				{
				setState(126);
				braces();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 4);
				{
				setState(127);
				brackets();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 5);
				{
				setState(128);
				curlys();
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 6);
				{
				setState(129);
				match(INT);
				}
				break;
			case END:
				enterOuterAlt(_localctx, 7);
				{
				setState(130);
				match(END);
				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 8);
				{
				setState(131);
				match(STAR);
				}
				break;
			case OTHER:
				enterOuterAlt(_localctx, 9);
				{
				setState(132);
				match(OTHER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0019\u0088\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0004\u0001\u001a\b\u0001\u000b\u0001\f"+
		"\u0001\u001b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0004\u0001"+
		"\"\b\u0001\u000b\u0001\f\u0001#\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001,\b\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0004\u00023\b\u0002\u000b"+
		"\u0002\f\u00024\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0004"+
		"\u0002;\b\u0002\u000b\u0002\f\u0002<\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002E\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0004\u0003I\b\u0003\u000b\u0003\f\u0003J\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0004"+
		"\u0003T\b\u0003\u000b\u0003\f\u0003U\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003^\b\u0003\u0001\u0004"+
		"\u0004\u0004a\b\u0004\u000b\u0004\f\u0004b\u0001\u0004\u0004\u0004f\b"+
		"\u0004\u000b\u0004\f\u0004g\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0005\u0006n\b\u0006\n\u0006\f\u0006q\t\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0004\u0007y\b"+
		"\u0007\u000b\u0007\f\u0007z\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0003\b\u0086\b\b\u0001\b\u0000\u0000\t\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0000\u0001\u0001\u0000\u0001\n\u00ad"+
		"\u0000\u0012\u0001\u0000\u0000\u0000\u0002+\u0001\u0000\u0000\u0000\u0004"+
		"D\u0001\u0000\u0000\u0000\u0006]\u0001\u0000\u0000\u0000\be\u0001\u0000"+
		"\u0000\u0000\ni\u0001\u0000\u0000\u0000\fk\u0001\u0000\u0000\u0000\u000e"+
		"x\u0001\u0000\u0000\u0000\u0010\u0085\u0001\u0000\u0000\u0000\u0012\u0013"+
		"\u0007\u0000\u0000\u0000\u0013\u0001\u0001\u0000\u0000\u0000\u0014!\u0005"+
		"\u000b\u0000\u0000\u0015\"\u0003\u0002\u0001\u0000\u0016\"\u0003\u0004"+
		"\u0002\u0000\u0017\"\u0003\u0006\u0003\u0000\u0018\u001a\u0005\u0015\u0000"+
		"\u0000\u0019\u0018\u0001\u0000\u0000\u0000\u001a\u001b\u0001\u0000\u0000"+
		"\u0000\u001b\u0019\u0001\u0000\u0000\u0000\u001b\u001c\u0001\u0000\u0000"+
		"\u0000\u001c\"\u0001\u0000\u0000\u0000\u001d\"\u0003\u0000\u0000\u0000"+
		"\u001e\"\u0005\u0016\u0000\u0000\u001f\"\u0005\u0018\u0000\u0000 \"\u0005"+
		"\u0017\u0000\u0000!\u0015\u0001\u0000\u0000\u0000!\u0016\u0001\u0000\u0000"+
		"\u0000!\u0017\u0001\u0000\u0000\u0000!\u0019\u0001\u0000\u0000\u0000!"+
		"\u001d\u0001\u0000\u0000\u0000!\u001e\u0001\u0000\u0000\u0000!\u001f\u0001"+
		"\u0000\u0000\u0000! \u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000\u0000"+
		"#!\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000"+
		"\u0000%,\u0005\f\u0000\u0000&\'\u0005\u000b\u0000\u0000\',\u0005\f\u0000"+
		"\u0000()\u0005\u000b\u0000\u0000)*\t\u0000\u0000\u0000*,\u0005\f\u0000"+
		"\u0000+\u0014\u0001\u0000\u0000\u0000+&\u0001\u0000\u0000\u0000+(\u0001"+
		"\u0000\u0000\u0000,\u0003\u0001\u0000\u0000\u0000-:\u0005\r\u0000\u0000"+
		".;\u0003\u0004\u0002\u0000/;\u0003\u0002\u0001\u00000;\u0003\u0006\u0003"+
		"\u000013\u0005\u0015\u0000\u000021\u0001\u0000\u0000\u000034\u0001\u0000"+
		"\u0000\u000042\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u00005;\u0001"+
		"\u0000\u0000\u00006;\u0003\u0000\u0000\u00007;\u0005\u0016\u0000\u0000"+
		"8;\u0005\u0018\u0000\u00009;\u0005\u0017\u0000\u0000:.\u0001\u0000\u0000"+
		"\u0000:/\u0001\u0000\u0000\u0000:0\u0001\u0000\u0000\u0000:2\u0001\u0000"+
		"\u0000\u0000:6\u0001\u0000\u0000\u0000:7\u0001\u0000\u0000\u0000:8\u0001"+
		"\u0000\u0000\u0000:9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000"+
		"<:\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000"+
		"\u0000>E\u0005\u000e\u0000\u0000?@\u0005\r\u0000\u0000@E\u0005\u000e\u0000"+
		"\u0000AB\u0005\r\u0000\u0000BC\t\u0000\u0000\u0000CE\u0005\u000e\u0000"+
		"\u0000D-\u0001\u0000\u0000\u0000D?\u0001\u0000\u0000\u0000DA\u0001\u0000"+
		"\u0000\u0000E\u0005\u0001\u0000\u0000\u0000FS\u0005\u000f\u0000\u0000"+
		"GI\u0005\u0015\u0000\u0000HG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000"+
		"\u0000JH\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KT\u0001\u0000"+
		"\u0000\u0000LT\u0003\u0000\u0000\u0000MT\u0005\u0016\u0000\u0000NT\u0005"+
		"\u0018\u0000\u0000OT\u0003\u0004\u0002\u0000PT\u0003\u0002\u0001\u0000"+
		"QT\u0003\u0006\u0003\u0000RT\u0005\u0017\u0000\u0000SH\u0001\u0000\u0000"+
		"\u0000SL\u0001\u0000\u0000\u0000SM\u0001\u0000\u0000\u0000SN\u0001\u0000"+
		"\u0000\u0000SO\u0001\u0000\u0000\u0000SP\u0001\u0000\u0000\u0000SQ\u0001"+
		"\u0000\u0000\u0000SR\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000"+
		"US\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000"+
		"\u0000W^\u0005\u0010\u0000\u0000XY\u0005\u000f\u0000\u0000Y^\u0005\u0010"+
		"\u0000\u0000Z[\u0005\u000f\u0000\u0000[\\\t\u0000\u0000\u0000\\^\u0005"+
		"\u0010\u0000\u0000]F\u0001\u0000\u0000\u0000]X\u0001\u0000\u0000\u0000"+
		"]Z\u0001\u0000\u0000\u0000^\u0007\u0001\u0000\u0000\u0000_a\u0005\u0015"+
		"\u0000\u0000`_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000b`\u0001"+
		"\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000cf\u0001\u0000\u0000\u0000"+
		"df\u0005\u0018\u0000\u0000e`\u0001\u0000\u0000\u0000ed\u0001\u0000\u0000"+
		"\u0000fg\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000gh\u0001\u0000"+
		"\u0000\u0000h\t\u0001\u0000\u0000\u0000ij\u0005\u0015\u0000\u0000j\u000b"+
		"\u0001\u0000\u0000\u0000ko\u0003\b\u0004\u0000ln\u0005\u0018\u0000\u0000"+
		"ml\u0001\u0000\u0000\u0000nq\u0001\u0000\u0000\u0000om\u0001\u0000\u0000"+
		"\u0000op\u0001\u0000\u0000\u0000pr\u0001\u0000\u0000\u0000qo\u0001\u0000"+
		"\u0000\u0000rs\u0003\n\u0005\u0000st\u0003\u0004\u0002\u0000tu\u0003\u0006"+
		"\u0003\u0000u\r\u0001\u0000\u0000\u0000vy\u0003\f\u0006\u0000wy\u0003"+
		"\u0010\b\u0000xv\u0001\u0000\u0000\u0000xw\u0001\u0000\u0000\u0000yz\u0001"+
		"\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000"+
		"{\u000f\u0001\u0000\u0000\u0000|\u0086\u0005\u0015\u0000\u0000}\u0086"+
		"\u0003\u0000\u0000\u0000~\u0086\u0003\u0004\u0002\u0000\u007f\u0086\u0003"+
		"\u0002\u0001\u0000\u0080\u0086\u0003\u0006\u0003\u0000\u0081\u0086\u0005"+
		"\u0016\u0000\u0000\u0082\u0086\u0005\u0017\u0000\u0000\u0083\u0086\u0005"+
		"\u0018\u0000\u0000\u0084\u0086\u0005\u0019\u0000\u0000\u0085|\u0001\u0000"+
		"\u0000\u0000\u0085}\u0001\u0000\u0000\u0000\u0085~\u0001\u0000\u0000\u0000"+
		"\u0085\u007f\u0001\u0000\u0000\u0000\u0085\u0080\u0001\u0000\u0000\u0000"+
		"\u0085\u0081\u0001\u0000\u0000\u0000\u0085\u0082\u0001\u0000\u0000\u0000"+
		"\u0085\u0083\u0001\u0000\u0000\u0000\u0085\u0084\u0001\u0000\u0000\u0000"+
		"\u0086\u0011\u0001\u0000\u0000\u0000\u0013\u001b!#+4:<DJSU]begoxz\u0085";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}