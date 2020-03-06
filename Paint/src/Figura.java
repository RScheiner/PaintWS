import java.awt.*;

public abstract class Figura
{
    protected Color corContorno;
    protected Color corPreenchimento;

    protected Figura ()
    {
        this (Color.BLACK);
    }
	  
    protected Figura (Color corContorno)
    {
        this.corContorno = corContorno;
    }

    public Figura(Color corContorno, Color corPreenchimento) {
        this.corContorno =corContorno;
        this.corPreenchimento = corPreenchimento;
    }

    public void setCorContorno(Color corContorno)
    {
        this.corContorno = corContorno;
    }
	  
    public Color getCorContorno()
    {
    	return this.corContorno;
    }

    public Color getCorPreenchimento() {
        return corPreenchimento;
    }

    public void setCorPreenchimento(Color corPreenchimento) {
        this.corPreenchimento = corPreenchimento;
    }

  //public abstract boolean equals         (Object obj);
  //public abstract int     hashCode       ();
  //public abstract Object  clone          ();
    public abstract String  toString       ();
    public abstract void    torneSeVisivel (Graphics g);
}
