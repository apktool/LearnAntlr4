package com.antlr4.parser.impl;

import com.antlr4.parser.ExprBaseVisitor;
import com.antlr4.parser.ExprParser;

/**
 * @author apktool
 * @package com.antlr4.parser.impl
 * @class ExprBaseVisitorImpl
 * @description TODO
 * @date 2020-01-07 22:57
 */
public class ExprBaseVisitorImpl extends ExprBaseVisitor<Integer> {
    @Override
    public Integer visitMulDiv(ExprParser.MulDivContext ctx) {
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        if (ctx.op.getType() == ExprParser.MUL) {
            return left * right;
        } else {
            return left / right;
        }
    }

    @Override
    public Integer visitAddSub(ExprParser.AddSubContext ctx) {
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        if (ctx.op.getType() == ExprParser.ADD) {
            return left + right;
        } else {
            return left - right;
        }
    }

    @Override
    public Integer visitParens(ExprParser.ParensContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Integer visitInt(ExprParser.IntContext ctx) {
        return Integer.valueOf(ctx.INT().getText());
    }
}
