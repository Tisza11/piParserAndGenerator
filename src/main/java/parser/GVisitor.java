// Generated from C:/egyetem masolat/felev7/Szakdoga/piParserAndGenerator/grammar/G.g4 by ANTLR 4.13.1
package parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GParser#operands}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperands(GParser.OperandsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#brackets}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBrackets(GParser.BracketsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#braces}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBraces(GParser.BracesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#curlys}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCurlys(GParser.CurlysContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#returnType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnType(GParser.ReturnTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#fnName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFnName(GParser.FnNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(GParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#prule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrule(GParser.PruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#sthing}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSthing(GParser.SthingContext ctx);
}