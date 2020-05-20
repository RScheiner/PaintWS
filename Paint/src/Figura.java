import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Figura
{
    protected int count;
    protected Font fonte;
    protected Color corContorno;
    protected Color corPreenchimento;
    protected ArrayList<Integer> coordenadaX;
    protected ArrayList<Integer> coordenadaY;
    protected Figura ()
    {
        this (Color.BLACK);
    }
	  
    protected Figura (Color corContorno)
    {
        this.corContorno = corContorno;
    }
    protected Figura(Color corPreenchimento, Font fonteInformada){
        this.corPreenchimento = corPreenchimento;
        this.fonte = fonteInformada;
    }
    public Figura(Color corContorno, Color corPreenchimento) {
        this.corContorno =corContorno;
        this.corPreenchimento = corPreenchimento;
    }

    public Figura(ArrayList<Integer> coordX, ArrayList<Integer> coordY, int count, Color corContorno, Color corPreenchimento) {
        for(int i = 0; i< count; i++){

            coordenadaX.add(coordX.get(i));
            coordenadaY.add(coordY.get(i));
        }
        this.count = count;
        this.corPreenchimento =corPreenchimento;
        this.corContorno = corContorno;
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
