package com.antlr4.demo;

import com.antlr4.parser.ExprLexer;
import com.antlr4.parser.ExprParser;
import com.antlr4.parser.impl.ExprBaseListenerImpl;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * @author apktool
 * @package com.antlr4.demo
 * @class AppListen
 * @description TODO
 * @date 2020-01-07 23:05
 */
public class AppListen {
    public static void main(String[] args) {
        String expr = "(2 * ( 4 + 1 ) - 1) / 3\n";
        CharStream stream = CharStreams.fromString(expr);
        ExprLexer lexer = new ExprLexer(stream);
        TokenStream token = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(token);
        ExprParser.ExprContext tree = parser.expr();

        ParseTreeWalker walker = new ParseTreeWalker();
        ExprBaseListenerImpl listener = new ExprBaseListenerImpl();
        walker.walk(listener, tree);

        System.out.println(listener.getResult());


    }
}
