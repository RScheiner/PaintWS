import com.ozten.font.JFontChooser;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import javax.swing.text.StyledEditorKit;
import java.io.*;
import java.util.*;
 
public class Janela extends JFrame 
{
    protected static final long serialVersionUID = 1L;

    protected JButton btnPonto           = new JButton ("Ponto"),
                      btnLinha           = new JButton ("Linha"),
                      btnCirculo         = new JButton ("Circulo"),
                      btnElipse          = new JButton ("Elipse"),
                      btnRetangulo       = new JButton ("Retangulo"),
                      btnQuadrado        = new JButton ("Quadrado"),
                      btnPoligono        = new JButton ("Poligono"),
                      btnTexto           = new JButton ("Texto"),
                      btnFonte           = new JButton ("Fonte"),
                      btnCorContorno     = new JButton ("Contorno"),
                      btnCorCentro       = new JButton ("Preenchimento"),
                      btnAbrir           = new JButton ("Abrir"),
                      btnSalvar          = new JButton ("Salvar"),
                      btnApagar          = new JButton ("Apagar"),
                      btnSair            = new JButton ("Sair");

    protected MeuJPanel pnlDesenho = new MeuJPanel ();
    
    protected JLabel statusBar1 = new JLabel ("Mensagem:"),
                     statusBar2 = new JLabel ("Coordenada:");

    protected boolean esperaPonto, esperaInicioReta, esperaFimReta,
                      esperaP1Circulo, esperaP2Circulo,
                      esperaP1Elipse,esperaP2Elipse,
                      esperaP1Retangulo, esperaP2Retangulo,
                      esperaP1Quadrado,esperaP2Quardrado,
                      esperaTexto,esperaP1Poligono,esperaPNPoligono;

    protected Color corContornoAtual = Color.BLACK;
    protected Color corPreenchimentoAtual =  null;
    protected Font  fonteDoTexto = null;

    protected Ponto p1;

    protected ArrayList<Integer> coodernadasX = new ArrayList<Integer>();
    protected ArrayList<Integer> coodernadasY = new ArrayList<Integer>();
    protected int count=0;


    protected Vector<Figura> figuras = new Vector<Figura>();

    public Janela ()
    {
        super("Editor Gr�fico");

        try
        {
            Image btnPontoImg = ImageIO.read(getClass().getResource("resources/ponto.jpg"));
            btnPonto.setIcon(new ImageIcon(btnPontoImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo ponto.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnLinhaImg = ImageIO.read(getClass().getResource("resources/linha.jpg"));
            btnLinha.setIcon(new ImageIcon(btnLinhaImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo linha.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnCirculoImg = ImageIO.read(getClass().getResource("resources/circulo.jpg"));
            btnCirculo.setIcon(new ImageIcon(btnCirculoImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo circulo.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnElipseImg = ImageIO.read(getClass().getResource("resources/elipse.jpg"));
            btnElipse.setIcon(new ImageIcon(btnElipseImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo elipse.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnCorContornoImg = ImageIO.read(getClass().getResource("resources/cores.jpg"));
            btnCorContorno.setIcon(new ImageIcon(btnCorContornoImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo cores.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try{

            Image btnCorContornoImg = ImageIO.read(getClass().getResource("resources/cores.jpg"));
            btnCorCentro.setIcon(new ImageIcon(btnCorContornoImg));

        }catch (IOException e){
            JOptionPane.showMessageDialog(null,"Aquivo cores.jpg n�o foi encontrado",
                    "Arquivo de imagem ausente",
                    JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnAbrirImg = ImageIO.read(getClass().getResource("resources/abrir.jpg"));
            btnAbrir.setIcon(new ImageIcon(btnAbrirImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo abrir.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnSalvarImg = ImageIO.read(getClass().getResource("resources/salvar.jpg"));
            btnSalvar.setIcon(new ImageIcon(btnSalvarImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo salvar.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnApagarImg = ImageIO.read(getClass().getResource("resources/apagar.jpg"));
            btnApagar.setIcon(new ImageIcon(btnApagarImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo apagar.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnSairImg = ImageIO.read(getClass().getResource("resources/sair.jpg"));
            btnSair.setIcon(new ImageIcon(btnSairImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo sair.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        //A�ao dos botoes
        btnPonto.addActionListener      (new DesenhoDePonto());
        btnLinha.addActionListener      (new DesenhoDeReta ());
        btnCirculo.addActionListener    (new DesenhoDeCirculo());
        btnElipse.addActionListener     (new DesenhoDeElipse());
        btnQuadrado.addActionListener   (new DesenhoQuadrado());
        btnRetangulo.addActionListener  (new DesenhoDeRetangulo());
        btnPoligono.addActionListener   (new DesenhoDePoligono());
        btnCorContorno.addActionListener(new PainelDeCores());
        btnCorCentro.addActionListener  (new PainelDeCoresPreenchimento());
        btnTexto.addActionListener      (new TextoTela());
        btnFonte.addActionListener      (new EscolherFonte());

        JPanel     pnlBotoes = new JPanel();
        GridLayout grdBotoes = new GridLayout(2,10);
        pnlBotoes.setLayout (grdBotoes);

        pnlBotoes.add (btnAbrir);
        pnlBotoes.add (btnSalvar);
        pnlBotoes.add (btnPonto);
        pnlBotoes.add (btnLinha);
        pnlBotoes.add (btnCirculo);
        pnlBotoes.add (btnElipse);
        pnlBotoes.add (btnQuadrado);
        pnlBotoes.add (btnRetangulo);
        pnlBotoes.add (btnPoligono);
        pnlBotoes.add (btnTexto);
        pnlBotoes.add (btnFonte);
        pnlBotoes.add (btnCorContorno);
        pnlBotoes.add (btnCorCentro);
        pnlBotoes.add (btnApagar);
        pnlBotoes.add (btnSair);

        JPanel     pnlStatus = new JPanel();
        GridLayout grdStatus = new GridLayout(1,2);
        pnlStatus.setLayout(grdStatus);

        pnlStatus.add(statusBar1);
        pnlStatus.add(statusBar2);

        Container cntForm = this.getContentPane();
        cntForm.setLayout (new BorderLayout());
        cntForm.add (pnlBotoes,  BorderLayout.NORTH);
        cntForm.add (pnlDesenho, BorderLayout.CENTER);
        cntForm.add (pnlStatus,  BorderLayout.SOUTH);
        
        this.addWindowListener (new FechamentoDeJanela());

        this.setSize (1250,500);
        this.setVisible (true);
    }

    protected class MeuJPanel extends    JPanel 
                              implements MouseListener,
                                         MouseMotionListener, KeyListener
    {
	public MeuJPanel()
        {
            super();

            this.addMouseListener       (this);
            this.addMouseMotionListener (this);
        }

        public void paint (Graphics g)
        {
            for (int i=0 ; i<figuras.size(); i++)
                figuras.get(i).torneSeVisivel(g);
        }
        
        public void mousePressed (MouseEvent e)
        {/*hashmap*/
            if (esperaPonto)
            {
                figuras.add (new Ponto (e.getX(), e.getY(), corContornoAtual));
                figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                esperaPonto = false;
            }
            else
                if (esperaInicioReta)
                {
                    p1 = new Ponto (e.getX(), e.getY(), corContornoAtual);
                    esperaInicioReta = false;
                    esperaFimReta = true;
                    statusBar1.setText("Mensagem: clique o ponto final da reta");    
                 }
                 else
                    if (esperaFimReta)
                    {
                        esperaInicioReta = false;
                        esperaFimReta = false;
                        figuras.add (new Linha(p1.getX(), p1.getY(), e.getX(), e.getY(), corContornoAtual));
                        figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                        statusBar1.setText("Mensagem:");    
                    }else
                        if(esperaP1Circulo) {
                            esperaP1Circulo = false;
                            esperaP2Circulo = true;
                            p1 = new Ponto(e.getX(), e.getY(), corContornoAtual);
                            statusBar1.setText("Mensagem: Clique no ponto final do circulo");
                        }else
                            if(esperaP2Circulo) {
                                esperaP1Circulo = false;
                                esperaP2Circulo = false;

                                figuras.add(new Circulo(p1.getX(), p1.getY(), e.getX(), e.getY(), corContornoAtual,corPreenchimentoAtual));
                                figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
                                statusBar1.setText("Mensagem:");
                            }else
                            if(esperaP1Elipse){
                                esperaP1Elipse =false;
                                esperaP2Elipse = true;
                                p1 =  new Ponto(e.getX(),e.getY(), corContornoAtual);
                                statusBar1.setText("Mensagem: Clique no ponto final da Elipse");
                            }else{
                                if(esperaP2Elipse){
                                    esperaP1Elipse = false;
                                    esperaP2Elipse = false;
                                    figuras.add(new Elipse(p1.getX(),p1.getY(),e.getX(),e.getY(), corContornoAtual,corPreenchimentoAtual));
                                    figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                                    statusBar1.setText("Mensagem:");
                                }else{
                                    if(esperaP1Retangulo){
                                        esperaP1Retangulo = false;
                                        esperaP2Retangulo = true;
                                        p1 =  new Ponto(e.getX(),e.getY(), corContornoAtual);
                                        statusBar1.setText("Mensagem: Clique no ponto final do Retangulo");
                                    }else{
                                        if(esperaP2Retangulo){
                                            esperaP2Retangulo = false;
                                            figuras.add(new Retangulo(p1.getX(),p1.getY(),e.getX(),e.getY(),corContornoAtual,corPreenchimentoAtual));
                                            figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                                            statusBar1.setText("Mensagem:");
                                        }else{
                                            if(esperaP1Quadrado){
                                                esperaP1Quadrado = false;
                                                esperaP2Quardrado = true;
                                                p1 =  new Ponto(e.getX(),e.getY(), corContornoAtual);
                                                statusBar1.setText("Mensagem: Clique no ponto final do Quadrado");
                                            }else{
                                                if(esperaP2Quardrado){
                                                    esperaP2Quardrado = false;
                                                    figuras.add(new Quadrado(p1.getX(),p1.getY(),e.getX(),e.getY(),corContornoAtual,corPreenchimentoAtual));
                                                    figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                                                    statusBar1.setText("Mensagem:");
                                                }else{
                                                    if(esperaTexto){
                                                        esperaTexto = false;
                                                        figuras.add(new Texto(e.getX(),e.getY(),corPreenchimentoAtual, fonteDoTexto));
                                                        figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                                                        statusBar1.setText("Mensagem:");
                                                    }else{
                                                        if(esperaP1Poligono) {
                                                            p1 = new Ponto(e.getX(), e.getY(), corContornoAtual);
                                                            if ((((MouseEvent) e).getButton() != 3)) {
                                                                count++;
                                                                coodernadasX.add(p1.getX());
                                                                coodernadasY.add(p1.getY());

                                                            } else {
                                                                count++;
                                                                coodernadasX.add(p1.getX());
                                                                coodernadasY.add(p1.getY());
                                                                figuras.add(new Poligono(coodernadasX, coodernadasY, count, corContornoAtual, corPreenchimentoAtual));
                                                                figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
                                                                esperaP1Poligono = false;
                                                                count = 0;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
        }
        
        public void mouseReleased (MouseEvent e)
        {

        }

        public void mouseMoved(MouseEvent e)
        {
            statusBar2.setText("Coordenada: "+e.getX()+","+e.getY());
        }

        public void mouseClicked (MouseEvent e)
        {

        }
        
        public void mouseEntered (MouseEvent e)
        {}

        public void mouseExited (MouseEvent e)
        {}
        
        public void mouseDragged(MouseEvent e)
        {}



        @Override
        public void keyTyped(KeyEvent keyEvent) {

        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {

        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {

        }
    }

    protected class DesenhoDePonto implements ActionListener
    {
          public void actionPerformed (ActionEvent e)    
          {
              esperaPonto      = true;
              esperaInicioReta = false;
              esperaFimReta    = false;
              esperaP1Elipse   = false;
              esperaP2Elipse   = false;

              esperaP1Circulo  = false;
              esperaP2Circulo  = false;
              statusBar1.setText("Mensagem: clique o local do ponto desejado");
          }
    }

    protected class DesenhoDeReta implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
            esperaPonto      = false;
            esperaInicioReta = true;
            esperaFimReta    = false;
            esperaP1Elipse   = false;
            esperaP2Elipse   = false;
            esperaP1Circulo  = false;
            esperaP2Circulo  = false;
            statusBar1.setText("Mensagem: clique o ponto inicial da reta");
        }
    }

    protected class DesenhoDeCirculo implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            esperaPonto      = false;
            esperaInicioReta = false;
            esperaFimReta    = false;
            esperaP1Elipse   = false;
            esperaP2Elipse   = false;

            esperaP1Circulo = true;
            esperaP2Circulo = false;

            statusBar1.setText("Mensagem: clique o ponto inicial do circulo");

        }
    }

    protected class DesenhoDeElipse implements ActionListener{


        public void actionPerformed(ActionEvent e) {
            esperaPonto      = false;
            esperaInicioReta = false;
            esperaFimReta    = false;
            esperaP1Circulo  = false;
            esperaP2Circulo  = false;

            esperaP1Elipse   = true;
            esperaP2Elipse   = false;

            statusBar1.setText("Mensagem: clique o ponto inicial da Elipse");
        }
    }

    protected  class DesenhoDeRetangulo implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            esperaPonto      = false;
            esperaInicioReta = false;
            esperaFimReta    = false;
            esperaP1Circulo  = false;
            esperaP2Circulo  = false;
            esperaP1Elipse   = false;
            esperaP2Elipse   = false;

            esperaP1Retangulo = true;
            esperaP2Retangulo = false;

            statusBar1.setText("Mensagem: clique o ponto inicial do Retangulo");
        }
    }

    private class DesenhoQuadrado implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            esperaPonto      = false;
            esperaInicioReta = false;
            esperaFimReta    = false;
            esperaP1Circulo  = false;
            esperaP2Circulo  = false;
            esperaP1Elipse   = false;
            esperaP2Elipse   = false;
            esperaP1Retangulo = false;
            esperaP2Retangulo = false;

            esperaP1Quadrado = true;
            esperaP2Quardrado = false;

            statusBar1.setText("Mensagem: clique o ponto inicial do Quadrado");
        }
    }

    private class TextoTela implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            esperaPonto      = false;
            esperaInicioReta = false;
            esperaFimReta    = false;
            esperaP1Circulo  = false;
            esperaP2Circulo  = false;
            esperaP1Elipse   = false;
            esperaP2Elipse   = false;
            esperaP1Retangulo = false;
            esperaP2Retangulo = false;

            esperaTexto = true;

            statusBar1.setText("Mensagem: clique onde gostaria de digitar");
        }
    }
    private class DesenhoDePoligono implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            esperaPonto      = false;
            esperaInicioReta = false;
            esperaFimReta    = false;
            esperaP1Circulo  = false;
            esperaP2Circulo  = false;
            esperaP1Elipse   = false;
            esperaP2Elipse   = false;
            esperaP1Retangulo = false;
            esperaP2Retangulo = false;
            esperaTexto = false;

            esperaP1Poligono = true;
            coodernadasX.clear();
            coodernadasY.clear();
        }
    }

    private class EscolherFonte extends Component implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            fonteDoTexto = JFontChooser.showDialog(this,"Esolha a Fonte","Teste de Fonte");
        }
    }

    protected class PainelDeCores extends Component implements ActionListener{

        public void actionPerformed(ActionEvent actionEvent) {
            corContornoAtual = JColorChooser.showDialog(this,"Escolha a Cor",Color.BLACK);
        }
    }

    protected class PainelDeCoresPreenchimento extends  Component implements  ActionListener{

        public void actionPerformed(ActionEvent actionEvent) {
            corPreenchimentoAtual = JColorChooser.showDialog(this,"Escolha a Cor",Color.BLACK);
        }
    }

    protected class FechamentoDeJanela extends WindowAdapter
    {
        public void windowClosing (WindowEvent e)
        {
            System.exit(0);
        }
    }


}
