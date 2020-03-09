import java.awt.*;
import java.util.*;

public class Circulo extends Figura {

    protected Ponto p1,p2;

    public Circulo(int x1,int y1, int x2, int y2){
        this(x1,y1,x2,y2,Color.BLACK,Color.BLACK);
    }

    public Circulo(int x1,int y1, int x2, int y2, Color corContorno, Color corPreenchimento){
        super(corContorno,corPreenchimento);
        this.p1 = new Ponto(x1,y1,corContorno);
        this.p2 = new Ponto(x2,y2,corContorno);
    }

    public Circulo(String s){
        StringTokenizer quebrador = new StringTokenizer(s,":");
        quebrador.nextToken();

        int   x1  = Integer.parseInt(quebrador.nextToken());
        int   y1  = Integer.parseInt(quebrador.nextToken());

        int   x2  = Integer.parseInt(quebrador.nextToken());
        int   y2  = Integer.parseInt(quebrador.nextToken());

        Color cor = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                Integer.parseInt(quebrador.nextToken()),  // G
                Integer.parseInt(quebrador.nextToken())); // B

        this.p1  = new Ponto (x1,y1,cor);
        this.p2  = new Ponto (x2,y2,cor);
        this.corContorno = cor;

    }

    public void setP1 (int x, int y)
    {
        this.p1 = new Ponto (x,y,this.getCorContorno());
    }

    public void setP2 (int x, int y)
    {
        this.p2 = new Ponto (x,y,this.getCorContorno());
    }

    public Ponto getP1 ()
    {
        return this.p1;
    }

    public Ponto getP2 ()
    {
        return this.p2;
    }

    @Override
    public void torneSeVisivel(Graphics g) {

        int Rx=0, Ry=0, initialX, initialY;
        initialX = p1.getX();
        initialY = p1.getY();
        Rx = (p1.getX() - p2.getX());
        Ry = (p1.getY() - p2.getY());

        int H = (int) Math.sqrt((Math.pow((p1.getX() - p2.getX()),2)) + (Math.pow((p1.getY() - p2.getY()),2)));

        if(corPreenchimento != null)
        {
            g.setColor(this.corPreenchimento);
            g.fillOval(Math.round(initialX - H),
                       Math.round(initialY - H),
                       Math.round(H*2),
                       Math.round(H*2));
        }

        g.setColor(this.corContorno);
        g.drawOval( Math.round(initialX - H),
                    Math.round(initialY - H),
                    Math.round(H*2),
                    Math.round(H*2));
    }

    @Override
    public String toString() {
        return "r:" +
                this.p1.getX() +
                ":" +
                this.p1.getY() +
                ":" +
                this.p2.getX() +
                ":" +
                this.p2.getY() +
                ":" +
                this.getCorContorno().getRed() +
                ":" +
                this.getCorContorno().getGreen() +
                ":" +
                this.getCorContorno().getBlue() +
                ":" +
                this.getCorPreenchimento().getRed() +
                ":" +
                this.getCorPreenchimento().getGreen() +
                ":" +
                this.getCorPreenchimento().getBlue();
    }
}
