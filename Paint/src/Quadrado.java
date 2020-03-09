import java.awt.*;
import java.util.StringTokenizer;

public class Quadrado extends Figura {
    protected Ponto p1,p2;

    public Quadrado(int x1, int y1, int x2, int y2){
        this(x1,y1,x2,y2,Color.BLACK,Color.BLACK);
    }

    public Quadrado(int x1, int y1, int x2, int y2, Color corContorno, Color corPreenchimento){
        super(corContorno,corPreenchimento);
        this.p1 = new Ponto(x1,y1,corContorno);
        this.p2 = new Ponto(x2,y2,corContorno);
    }

    public Quadrado(String s){
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

    @Override
    public void torneSeVisivel(Graphics g) {

        if(corPreenchimento != null)
        {
            g.setColor(this.corPreenchimento);
            if(p1.getX() < p2.getX() && p1.getY() < p2.getY()){
                g.fillRect( p1.getX(), p1.getY(), (p2.getX() - p1.getX()), (p2.getX() - p1.getX()));
            }else{
                if(p1.getX() < p2.getX() && p1.getY() > p2.getY()){
                    g.fillRect(p1.getX(), p2.getY(), p2.getX() - p1.getX(), p2.getX() - p1.getX());
                }else{
                    if(p1.getX() > p2.getX() && p1.getY() < p2.getY()){
                        g.fillRect(p2.getX(), p1.getY(), p1.getX() - p2.getX(), p1.getX() - p2.getX());
                    }else{
                        g.fillRect(p2.getX(), p2.getY(), p1.getX() - p2.getX(), p1.getX() - p2.getX());
                    }
                }
            }
        }
        g.setColor(this.corContorno);

        if(p1.getX() < p2.getX() && p1.getY() < p2.getY()){
            g.drawRect( p1.getX(), p1.getY(), (p2.getX() - p1.getX()), (p2.getX() - p1.getX()));
        }else{
            if(p1.getX() < p2.getX() && p1.getY() > p2.getY()){
                g.drawRect(p1.getX(), p2.getY(), p2.getX() - p1.getX(), p2.getX() - p1.getX());
            }else{
                if(p1.getX() > p2.getX() && p1.getY() < p2.getY()){
                    g.drawRect(p2.getX(), p1.getY(), p1.getX() - p2.getX(), p1.getX() - p2.getX());
                }else{
                    g.drawRect(p2.getX(), p2.getY(), p1.getX() - p2.getX(), p1.getX() - p2.getX());
                }
            }
        }


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
