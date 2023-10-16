grammar G;
WS: [ \t]+ -> skip;
NL: ('\r' 'n'? | '\n') -> skip;
BC: '/*' .*? '*/' -> skip;
LC: '//' ~[\r\n]* -> skip;
WORD: ([a-zA-Z]+ | [0-9] | '_' )+;
INT: [0-9]+;
END: ';';
STAR: '*';

operands
    : '+'
    | '-'
    | '='
    | '!='
    | '>'
    | '<'
    | '&'
    | ','
    | ':'
    | '?'
    ;

brackets
    : '[' (brackets | braces | curlys| WORD+ | operands | INT | STAR | END)+ ']'
    | '[' ']'
    | '[' . ']'
    ;
braces
    : '(' (braces | brackets | curlys | WORD+ | operands | INT | STAR | END)+ ')'
    | '(' ')'
    | '(' . ')'
    ;

curlys
    : '{' (WORD+ | operands | INT | STAR | braces | brackets | curlys | END)+ '}'
    | '{' '}'
    | '{' . '}'
    ;

returnType: (WORD+ | STAR)+ ;

fnName: WORD;

func: (returnType STAR* fnName braces curlys);

prule: (func | sthing)+;

sthing
    : WORD
    | operands
    | braces
    | brackets
    | curlys
    | INT
    | END
    | STAR
    | OTHER
    ;

OTHER: . -> skip;