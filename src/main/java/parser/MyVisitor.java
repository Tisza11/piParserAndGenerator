package parser;


import piConcurrent.Fun;

import java.util.ArrayList;

import static piConcurrent.Main.funok;

public class MyVisitor extends GBaseVisitor<Object>{
//    @Override public Object visitFunctionDefinition(GParser.FunctionDefinitionContext ctx) {
//        System.out.println("Siker");
//        System.out.println(ctx.children.get(1).getText());
//        System.out.println(ctx.start.getLine());
//        System.out.println(ctx.stop.getLine());
//        return visitChildren(ctx);
//    }
    @Override public Object visitPrule(GParser.PruleContext ctx){
        return visitChildren(ctx);
    }

    @Override public Object visitFunc(GParser.FuncContext ctx){
        Fun tarolo = new Fun();
        tarolo.name = ctx.fnName().WORD().toString();
        tarolo.startLine = (int)ctx.braces().start.getLine();
        tarolo.endLine = (int)ctx.curlys().stop.getLine();
        tarolo.startCurly = (int)ctx.curlys().start.getLine();
        funok.add(tarolo);
        return visitChildren(ctx);
    }
}
