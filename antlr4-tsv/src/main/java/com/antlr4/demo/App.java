package com.antlr4.demo;

import com.antlr4.parser.RowsLexer;
import com.antlr4.parser.RowsParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * @author apktool
 * @package com.antlr4.demo
 * @class App
 * @description TODO
 * @date 2020-01-08 22:12
 */
public class App {
    public static void main(String[] args){
        String tsv = "parrt\tTerence Parr\t101\n" +
            "tombu\tTom Burns\t020\n" +
            "bke\tKevin Edgar\t008\n";
        int col = 1;

        CharStream input = CharStreams.fromString(tsv);
        RowsLexer lexer = new RowsLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        RowsParser parser = new RowsParser(tokens, col);    // pass column number!
        parser.setBuildParseTree(false);    // don't waste time bulding a tree
        parser.file();
    }
}
