package metroscript;

public enum TokenType {
    PLUS, MINUS, STAR, SLASH,
    COMMA,

    ASSIGN, EQ, NOT_EQ,
    LT, GT, LEQ, GEQ, SEMICOLON,

    AND, NOT, OR,

    LEFT_PAREN, RIGHT_PAREN, LEFT_SQR, RIGHT_SQR, LEFT_CUR, RIGHT_CUR,

    IF, ELSE, FOR, WHILE,

    INT, DOUBLE, BOOL, STRING,

    INT_LIT, DOUBLE_LIT, BOOL_LIT, STRING_LIT,
    IDENTIFIER,
    ERROR;
}
