import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean (name="calc")
@SessionScoped
public class calc
{
    public String aField = "";
    public String bField = "";
    public String opField = "";
    public String outputField = "";

    public String getRes()
    {
        return outputField;
    }

    public void setRes(String res)
    {
        this.outputField = res;
    }

    public void setA(String a)
    {
        this.aField = a;
    }

    public void setB(String b)
    {
        this.bField = b;
    }

    public void setOp(String op)
    {
        this.opField = op;
    }

    public String getA()
    {
        return aField;
    }

    public String getB()
    {
        return bField;
    }

    public String getOp()
    {
        return opField;
    }

    public void calculate()
    {
        int a = Integer.parseInt(aField);
        int b = Integer.parseInt(bField);
        char op = opField.charAt(0);

        switch (op)
        {
            case '+': outputField = "" + (a + b); break;
            case '-': outputField = "" + (a - b); break;
            case '*': outputField = "" + (a * b); break;
            case '/': outputField = "" + (a / b); break;
        }
    }
}
