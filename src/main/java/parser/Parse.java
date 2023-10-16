package parser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.IOException;
import java.util.ArrayList;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Parse {

    public static void parse(String file){
        try {
            String source = file;
            CharStream cs = fromFileName(source);
            GLexer lexer = new GLexer(cs);
            CommonTokenStream token = new CommonTokenStream(lexer);
            GParser parser = new GParser(token);
            ParseTree tree = parser.prule();

            MyVisitor visitor = new MyVisitor();
            visitor.visit(tree);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
