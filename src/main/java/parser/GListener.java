// Generated from C:/egyetem masolat/felev7/Szakdoga/piParserAndGenerator/grammar/G.g4 by ANTLR 4.13.1
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GParser}.
 */
public interface GListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GParser#operands}.
	 * @param ctx the parse tree
	 */
	void enterOperands(GParser.OperandsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#operands}.
	 * @param ctx the parse tree
	 */
	void exitOperands(GParser.OperandsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#brackets}.
	 * @param ctx the parse tree
	 */
	void enterBrackets(GParser.BracketsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#brackets}.
	 * @param ctx the parse tree
	 */
	void exitBrackets(GParser.BracketsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#braces}.
	 * @param ctx the parse tree
	 */
	void enterBraces(GParser.BracesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#braces}.
	 * @param ctx the parse tree
	 */
	void exitBraces(GParser.BracesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#curlys}.
	 * @param ctx the parse tree
	 */
	void enterCurlys(GParser.CurlysContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#curlys}.
	 * @param ctx the parse tree
	 */
	void exitCurlys(GParser.CurlysContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#returnType}.
	 * @param ctx the parse tree
	 */
	void enterReturnType(GParser.ReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#returnType}.
	 * @param ctx the parse tree
	 */
	void exitReturnType(GParser.ReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#fnName}.
	 * @param ctx the parse tree
	 */
	void enterFnName(GParser.FnNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#fnName}.
	 * @param ctx the parse tree
	 */
	void exitFnName(GParser.FnNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(GParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(GParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#prule}.
	 * @param ctx the parse tree
	 */
	void enterPrule(GParser.PruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#prule}.
	 * @param ctx the parse tree
	 */
	void exitPrule(GParser.PruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#sthing}.
	 * @param ctx the parse tree
	 */
	void enterSthing(GParser.SthingContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#sthing}.
	 * @param ctx the parse tree
	 */
	void exitSthing(GParser.SthingContext ctx);
}