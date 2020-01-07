package com.antlr4.parser.impl;

import com.antlr4.parser.ExprBaseListener;
import com.antlr4.parser.ExprParser;

import java.util.Stack;

/**
 * @author apktool
 * @package com.antlr4.parser.impl
 * @class ExprBaseListenerImpl
 * @description TODO
 * @date 2020-01-07 23:01
 */
public class ExprBaseListenerImpl extends ExprBaseListener {
    private Stack<Integer> stack = new Stack<>();

    public Integer getResult() {
        return stack.peek();
    }

    @Override
    public void exitMulDiv(ExprParser.MulDivContext ctx) {
        int right = stack.pop();
        int left = stack.pop();
        int result;
        if (ctx.op.getType() == ExprParser.MUL) {
            result = left * right;
        } else {
            result = left / right;
        }
        stack.push(result);
    }

    @Override
    public void exitAddSub(ExprParser.AddSubContext ctx) {
        int right = stack.pop();
        int left = stack.pop();
        int result;
        if (ctx.op.getType() == ExprParser.ADD) {
            result = left + right;
        } else {
            result = left - right;
        }
        stack.push(result);
    }

    @Override
    public void exitInt(ExprParser.IntContext ctx) {
        stack.push(Integer.valueOf(ctx.INT().getText()));
    }
}
