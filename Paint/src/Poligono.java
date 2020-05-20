import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Poligono extends Figura {

    public Poligono(ArrayList<Integer> coordX, ArrayList<Integer> coordY, int count, Color corContorno, Color corPreenchimento){
    super(coordX,coordY,count,corContorno,corPreenchimento);

    }

    @Override
    public void torneSeVisivel(Graphics g) {
        int[] coordX,coordY;
        coordX =new int[count];
        coordY = new int[count];

        for(int i = 0; i < count;i++)
        {
            coordX[i] = Integer.parseInt(String.valueOf(coordenadaX.get(i)));
            coordY[i] = Integer.parseInt(String.valueOf(coordenadaY.get(i)));

        }
        g.setColor(corContorno);
        g.fillPolygon(coordX,coordY,count);
        g.drawPolygon(coordX,coordY,count);
    }

    @Override
    public String toString() {
        return null;
    }

}
