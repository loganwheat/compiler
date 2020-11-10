class Name extends Token
{
    String id;
    Expr expr;

    public Name(String i, Expr e)
    {
        id = i;
        expr = e;
    }
    public Name(String i)
    {
        id = i;
        expr = null;
    }
    public String nameId()
    {
        return id;
    }
    public String nameType() throws TypeCheckException
    {
        String nType = "";

        try {
            if(expr != null) {
                nType += expr.getType();
            } else {
                return nType;
            }
        } catch (TypeCheckException e) {}
        return nType;
    }

    public String toString(int t)
    {
        String ret = "";
        if(expr != null && id != null){
            ret = id + "[" + expr.toString(t) + "]";
        }
        else if (id != null){
            ret = id;
        }
        return ret;
    }

    public void typeCheck(Scope s) throws TypeCheckException
    {
        if(expr != null){
            expr.typeCheck(s);
        }
    }
}