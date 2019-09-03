/* Generated By:JavaCC: Do not edit this line. CQLParser.java */
import java.io.Reader;
import java.io.StringReader;

public class CQLParser implements CQLParserConstants {
    public CQLParser(String query)
    {
        this((Reader)(new StringReader(query)));
    }

    public static void main(String args[])
    {
        try
        {
            String query = "select * from tabela1";
            CQLParser parser = new CQLParser(query);
            parser.parse();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

  static final public void parse() throws ParseException {
    trace_call("parse");
    try {
      selection();
      fromWhere();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case WHERE:
        withCondition();
        break;
      default:
        jj_la1[0] = jj_gen;
        ;
      }
      jj_consume_token(0);
    } finally {
      trace_return("parse");
    }
  }

  static final public void selection() throws ParseException {
    trace_call("selection");
    try {
      jj_consume_token(SELECT);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case STAR:
      case AVG:
      case SUM:
      case STRING:
      case STRINGCOMMA:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case AVG:
        case SUM:
        case STRINGCOMMA:
          label_1:
          while (true) {
            switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
            case STRINGCOMMA:
              jj_consume_token(STRINGCOMMA);
              break;
            case AVG:
            case SUM:
              aggregation();
              break;
            default:
              jj_la1[1] = jj_gen;
              jj_consume_token(-1);
              throw new ParseException();
            }
            switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
            case AVG:
            case SUM:
            case STRINGCOMMA:
              ;
              break;
            default:
              jj_la1[2] = jj_gen;
              break label_1;
            }
          }
          break;
        case STAR:
          jj_consume_token(STAR);
          break;
        case STRING:
          jj_consume_token(STRING);
          break;
        default:
          jj_la1[3] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
      default:
        jj_la1[4] = jj_gen;
        ;
      }
    } finally {
      trace_return("selection");
    }
  }

  static final public void aggregation() throws ParseException {
    trace_call("aggregation");
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AVG:
        jj_consume_token(AVG);
        break;
      case SUM:
        jj_consume_token(SUM);
        break;
      default:
        jj_la1[5] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(LPAREN);
      jj_consume_token(STRING);
      jj_consume_token(RPAREN);
    } finally {
      trace_return("aggregation");
    }
  }

  static final public void fromWhere() throws ParseException {
    trace_call("fromWhere");
    try {
      jj_consume_token(FROM);
      jj_consume_token(STRING);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case WINDOW:
        jj_consume_token(WINDOW);
        break;
      default:
        jj_la1[6] = jj_gen;
        ;
      }
    } finally {
      trace_return("fromWhere");
    }
  }

  static final public void withCondition() throws ParseException {
    trace_call("withCondition");
    try {
      jj_consume_token(WHERE);
      condition();
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case AND:
        case OR:
          ;
          break;
        default:
          jj_la1[7] = jj_gen;
          break label_2;
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case OR:
          jj_consume_token(OR);
          break;
        case AND:
          jj_consume_token(AND);
          break;
        default:
          jj_la1[8] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        condition();
      }
    } finally {
      trace_return("withCondition");
    }
  }

  static final public void condition() throws ParseException {
    trace_call("condition");
    try {
      jj_consume_token(STRING);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case EQUALS:
        jj_consume_token(EQUALS);
        break;
      case LOWER:
        jj_consume_token(LOWER);
        break;
      case GRATER:
        jj_consume_token(GRATER);
        break;
      case LESSEREQUAL:
        jj_consume_token(LESSEREQUAL);
        break;
      case GRATEREQUAL:
        jj_consume_token(GRATEREQUAL);
        break;
      default:
        jj_la1[9] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(NUMBER);
    } finally {
      trace_return("condition");
    }
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public CQLParserTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[10];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x100,0x1001800,0x1001800,0x1801840,0x1801840,0x1800,0x200000,0x600,0x600,0x1e8000,};
   }

  /** Constructor with InputStream. */
  public CQLParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public CQLParser(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new CQLParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public CQLParser(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new CQLParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public CQLParser(CQLParserTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(CQLParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      trace_token(token, "");
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
      trace_token(token, " (in getNextToken)");
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[26];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 10; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 26; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  static private int trace_indent = 0;
  static private boolean trace_enabled = true;

/** Enable tracing. */
  static final public void enable_tracing() {
    trace_enabled = true;
  }

/** Disable tracing. */
  static final public void disable_tracing() {
    trace_enabled = false;
  }

  static private void trace_call(String s) {
    if (trace_enabled) {
      for (int i = 0; i < trace_indent; i++) { System.out.print(" "); }
      System.out.println("Call:   " + s);
    }
    trace_indent = trace_indent + 2;
  }

  static private void trace_return(String s) {
    trace_indent = trace_indent - 2;
    if (trace_enabled) {
      for (int i = 0; i < trace_indent; i++) { System.out.print(" "); }
      System.out.println("Return: " + s);
    }
  }

  static private void trace_token(Token t, String where) {
    if (trace_enabled) {
      for (int i = 0; i < trace_indent; i++) { System.out.print(" "); }
      System.out.print("Consumed token: <" + tokenImage[t.kind]);
      if (t.kind != 0 && !tokenImage[t.kind].equals("\"" + t.image + "\"")) {
        System.out.print(": \"" + t.image + "\"");
      }
      System.out.println(" at line " + t.beginLine + " column " + t.beginColumn + ">" + where);
    }
  }

  static private void trace_scan(Token t1, int t2) {
    if (trace_enabled) {
      for (int i = 0; i < trace_indent; i++) { System.out.print(" "); }
      System.out.print("Visited token: <" + tokenImage[t1.kind]);
      if (t1.kind != 0 && !tokenImage[t1.kind].equals("\"" + t1.image + "\"")) {
        System.out.print(": \"" + t1.image + "\"");
      }
      System.out.println(" at line " + t1.beginLine + " column " + t1.beginColumn + ">; Expected token: <" + tokenImage[t2] + ">");
    }
  }

}