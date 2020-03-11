import java.awt.*;
import java.util.StringTokenizer;

public class Elipse extends Figura {

    protected Ponto p1,p2;

    public Elipse(int x1,int y1, int x2, int y2){
        this(x1,y1,x2,y2,Color.BLACK,Color.BLACK);
    }

    public Elipse(int x1,int y1, int x2, int y2, Color corContorno,Color corPreenchimento){
        super(corContorno,corPreenchimento);
        this.p1 = new Ponto(x1,y1,corContorno);
        this.p2 = new Ponto(x2,y2,corContorno);
    }

    public Elipse(String s){
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

        int Rx=0, Ry=0 ,Cx,Cy;
        //int H = (int) Math.sqrt((Math.pow((p1.getX() - p2.getX()),2)) + (Math.pow((p1.getY() - p2.getY()),2)));

        Rx = Math.abs(p1.getX() - p2.getX());
        Ry = Math.abs(p1.getY() - p2.getY());
        Cx = (p1.getX() + p2.getX()) / 2;
        Cy = (p1.getY() + p2.getY()) / 2;
        //verificar valores, fazer teste de mesa
        //System.out.println("p1X"+ p1.getX()+"p1Y"+p1.getY());

        if(this.corPreenchimento != null){
            g.setColor(this.corPreenchimento);
            g.fillOval( Math.round(Cx) - Math.round(Rx/2),
                        Math.round(Cy) - Math.round(Ry/2),
                        Math.round(Math.abs(Rx)),
                        Math.round(Math.abs(Ry)));;
        }
        g.setColor(this.corContorno);
        g.drawOval( Math.round(Cx) - Math.round(Rx/2),
                    Math.round(Cy) - Math.round(Ry/2),
                    Math.round(Math.abs(Rx)),
                    Math.round(Math.abs(Ry)));
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
