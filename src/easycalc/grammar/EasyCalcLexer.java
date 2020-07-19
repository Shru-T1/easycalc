// Generated from EasyCalc.g4 by ANTLR 4.8
package easycalc.grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EasyCalcLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DSTOP=1, SSTOP=2, BOOL=3, INT=4, REAL=5, ASSIGN=6, READ=7, WRITE=8, LPAREN=9, 
		RRAPEN=10, TINT=11, TREAL=12, MUL=13, DIV=14, ADD=15, SUB=16, LESS=17, 
		GRTR=18, EQUAL=19, AND=20, OR=21, IF=22, THEN=23, ELSE=24, LIT=25, ID=26, 
		WS=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"DSTOP", "SSTOP", "BOOL", "INT", "REAL", "ASSIGN", "READ", "WRITE", "LPAREN", 
			"RRAPEN", "TINT", "TREAL", "MUL", "DIV", "ADD", "SUB", "LESS", "GRTR", 
			"EQUAL", "AND", "OR", "IF", "THEN", "ELSE", "LIT", "ID", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'$$'", "';'", "'bool'", "'int'", "'real'", "':='", "'read'", "'write'", 
			"'('", "')'", "'to_int'", "'to_real'", "'*'", "'/'", "'+'", "'-'", "'<'", 
			"'>'", "'=='", "'and'", "'or'", "'if'", "'then'", "'else'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DSTOP", "SSTOP", "BOOL", "INT", "REAL", "ASSIGN", "READ", "WRITE", 
			"LPAREN", "RRAPEN", "TINT", "TREAL", "MUL", "DIV", "ADD", "SUB", "LESS", 
			"GRTR", "EQUAL", "AND", "OR", "IF", "THEN", "ELSE", "LIT", "ID", "WS"
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


	public EasyCalcLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "EasyCalc.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\35\u00c0\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31"+
		"\3\32\6\32\u0092\n\32\r\32\16\32\u0093\3\32\7\32\u0097\n\32\f\32\16\32"+
		"\u009a\13\32\3\32\3\32\3\32\3\32\5\32\u00a0\n\32\3\32\7\32\u00a3\n\32"+
		"\f\32\16\32\u00a6\13\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5"+
		"\32\u00b1\n\32\3\33\3\33\7\33\u00b5\n\33\f\33\16\33\u00b8\13\33\3\34\6"+
		"\34\u00bb\n\34\r\34\16\34\u00bc\3\34\3\34\2\2\35\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\35\3\2\6\3\2\62;\4\2C\\c|\6\2\62"+
		";C\\aac|\5\2\13\f\17\17\"\"\2\u00c8\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3"+
		"\2\2\2\2\67\3\2\2\2\39\3\2\2\2\5<\3\2\2\2\7>\3\2\2\2\tC\3\2\2\2\13G\3"+
		"\2\2\2\rL\3\2\2\2\17O\3\2\2\2\21T\3\2\2\2\23Z\3\2\2\2\25\\\3\2\2\2\27"+
		"^\3\2\2\2\31e\3\2\2\2\33m\3\2\2\2\35o\3\2\2\2\37q\3\2\2\2!s\3\2\2\2#u"+
		"\3\2\2\2%w\3\2\2\2\'y\3\2\2\2)|\3\2\2\2+\u0080\3\2\2\2-\u0083\3\2\2\2"+
		"/\u0086\3\2\2\2\61\u008b\3\2\2\2\63\u00b0\3\2\2\2\65\u00b2\3\2\2\2\67"+
		"\u00ba\3\2\2\29:\7&\2\2:;\7&\2\2;\4\3\2\2\2<=\7=\2\2=\6\3\2\2\2>?\7d\2"+
		"\2?@\7q\2\2@A\7q\2\2AB\7n\2\2B\b\3\2\2\2CD\7k\2\2DE\7p\2\2EF\7v\2\2F\n"+
		"\3\2\2\2GH\7t\2\2HI\7g\2\2IJ\7c\2\2JK\7n\2\2K\f\3\2\2\2LM\7<\2\2MN\7?"+
		"\2\2N\16\3\2\2\2OP\7t\2\2PQ\7g\2\2QR\7c\2\2RS\7f\2\2S\20\3\2\2\2TU\7y"+
		"\2\2UV\7t\2\2VW\7k\2\2WX\7v\2\2XY\7g\2\2Y\22\3\2\2\2Z[\7*\2\2[\24\3\2"+
		"\2\2\\]\7+\2\2]\26\3\2\2\2^_\7v\2\2_`\7q\2\2`a\7a\2\2ab\7k\2\2bc\7p\2"+
		"\2cd\7v\2\2d\30\3\2\2\2ef\7v\2\2fg\7q\2\2gh\7a\2\2hi\7t\2\2ij\7g\2\2j"+
		"k\7c\2\2kl\7n\2\2l\32\3\2\2\2mn\7,\2\2n\34\3\2\2\2op\7\61\2\2p\36\3\2"+
		"\2\2qr\7-\2\2r \3\2\2\2st\7/\2\2t\"\3\2\2\2uv\7>\2\2v$\3\2\2\2wx\7@\2"+
		"\2x&\3\2\2\2yz\7?\2\2z{\7?\2\2{(\3\2\2\2|}\7c\2\2}~\7p\2\2~\177\7f\2\2"+
		"\177*\3\2\2\2\u0080\u0081\7q\2\2\u0081\u0082\7t\2\2\u0082,\3\2\2\2\u0083"+
		"\u0084\7k\2\2\u0084\u0085\7h\2\2\u0085.\3\2\2\2\u0086\u0087\7v\2\2\u0087"+
		"\u0088\7j\2\2\u0088\u0089\7g\2\2\u0089\u008a\7p\2\2\u008a\60\3\2\2\2\u008b"+
		"\u008c\7g\2\2\u008c\u008d\7n\2\2\u008d\u008e\7u\2\2\u008e\u008f\7g\2\2"+
		"\u008f\62\3\2\2\2\u0090\u0092\t\2\2\2\u0091\u0090\3\2\2\2\u0092\u0093"+
		"\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u00b1\3\2\2\2\u0095"+
		"\u0097\t\2\2\2\u0096\u0095\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2"+
		"\2\2\u0098\u0099\3\2\2\2\u0099\u009f\3\2\2\2\u009a\u0098\3\2\2\2\u009b"+
		"\u009c\7\60\2\2\u009c\u00a0\t\2\2\2\u009d\u009e\t\2\2\2\u009e\u00a0\7"+
		"\60\2\2\u009f\u009b\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a4\3\2\2\2\u00a1"+
		"\u00a3\t\2\2\2\u00a2\u00a1\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2"+
		"\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00b1\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7"+
		"\u00a8\7v\2\2\u00a8\u00a9\7t\2\2\u00a9\u00aa\7w\2\2\u00aa\u00b1\7g\2\2"+
		"\u00ab\u00ac\7h\2\2\u00ac\u00ad\7c\2\2\u00ad\u00ae\7n\2\2\u00ae\u00af"+
		"\7u\2\2\u00af\u00b1\7g\2\2\u00b0\u0091\3\2\2\2\u00b0\u0098\3\2\2\2\u00b0"+
		"\u00a7\3\2\2\2\u00b0\u00ab\3\2\2\2\u00b1\64\3\2\2\2\u00b2\u00b6\t\3\2"+
		"\2\u00b3\u00b5\t\4\2\2\u00b4\u00b3\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4"+
		"\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\66\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9"+
		"\u00bb\t\5\2\2\u00ba\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00ba\3\2"+
		"\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\b\34\2\2\u00bf"+
		"8\3\2\2\2\n\2\u0093\u0098\u009f\u00a4\u00b0\u00b6\u00bc\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}