import javax.swing.*;
import java.awt.*;
import java.util.StringTokenizer;

public class Texto extends Figura{

    protected Ponto p1,p2;
    protected String texto;

    public Texto(int x1,int y1, Color corPreenchimento, Font fonteDoTexto){
        super(corPreenchimento,fonteDoTexto);
        this.p1 = new Ponto(x1,y1,corContorno);
        this.texto = JOptionPane.showInputDialog("Texto");
    }
    public Texto(String s){
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
      if(texto!=null)
        {
            g.setColor   (this.corPreenchimento);
            //g.setFont    (this.fonte);
            g.drawString (""+this.texto+"",this.p1.x,this.p1.y);
        }
    }

    @Override
    public String toString() {
        return "r:" +
                this.p1.getX() +
                ":" +
                this.p1.getY() +
                ":" +
                this.getCorPreenchimento().getRed() +
                ":" +
                this.getCorPreenchimento().getGreen() +
                ":" +
                this.getCorPreenchimento().getBlue();


    }


}
