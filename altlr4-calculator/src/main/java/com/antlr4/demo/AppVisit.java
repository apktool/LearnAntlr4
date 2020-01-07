package com.antlr4.demo;

import com.antlr4.parser.ExprLexer;
import com.antlr4.parser.ExprParser;
import com.antlr4.parser.ExprVisitor;
import com.antlr4.parser.impl.ExprBaseVisitorImpl;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

/**
 * @author apktool
 * @package com.antlr4.demo
 * @class AppVisit
 * @description TODO
 * @date 2020-01-07 22:25
 */
public class AppVisit {
    public static void main(String[] args) {
        String expr = "(3 * ( 4 + 1 ) - 3) / 3\n";
        CharStream stream = CharStreams.fromString(expr);
        ExprLexer lexer = new ExprLexer(stream);
        TokenStream token = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(token);
        ExprParser.ExprContext tree = parser.expr();

        ExprVisitor visitor = new ExprBaseVisitorImpl();
        Integer result = (Integer) visitor.visit(tree);

        System.out.println(result);
    }
}
