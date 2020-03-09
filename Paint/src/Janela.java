import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.util.*;
 
public class Janela extends JFrame 
{
    protected static final long serialVersionUID = 1L;

    protected JButton btnPonto           = new JButton ("Ponto"),
                      btnLinha           = new JButton ("Linha"),
                      btnCirculo         = new JButton ("Circulo"),
                      btnElipse          = new JButton ("Elipse"),
                      btnRetangulo       = new JButton("Retangulo"),
                      btnQuadrado        = new JButton("Quadrado"),
                      btnPoligono        = new JButton("Poligono"),
                      btnCorContorno     = new JButton ("Contorno"),
                      btnCorCentro       = new JButton("Preenchimento"),
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
                      esperaP1Quadrado,esperaP2Quardrado;

    protected Color corContornoAtual = Color.BLACK;
    protected Color corPreenchimentoAtual =  null;
    protected Ponto p1;
    
    protected Vector<Figura> figuras = new Vector<Figura>();

    public Janela ()
    {
        super("Editor Gráfico");

        try
        {
            Image btnPontoImg = ImageIO.read(getClass().getResource("resources/ponto.jpg"));
            btnPonto.setIcon(new ImageIcon(btnPontoImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo ponto.jpg não foi encontrado",
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
                                           "Arquivo linha.jpg não foi encontrado",
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
                                           "Arquivo circulo.jpg não foi encontrado",
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
                                           "Arquivo elipse.jpg não foi encontrado",
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
                                           "Arquivo cores.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try{

            Image btnCorContornoImg = ImageIO.read(getClass().getResource("resources/cores.jpg"));
            btnCorCentro.setIcon(new ImageIcon(btnCorContornoImg));

        }catch (IOException e){
            JOptionPane.showMessageDialog(null,"Aquivo cores.jpg não foi encontrado",
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
                                           "Arquivo abrir.jpg não foi encontrado",
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
                                           "Arquivo salvar.jpg não foi encontrado",
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
                                           "Arquivo apagar.jpg não foi encontrado",
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
                                           "Arquivo sair.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        //Açao dos botoes
        btnPonto.addActionListener      (new DesenhoDePonto());
        btnLinha.addActionListener      (new DesenhoDeReta ());
        btnCirculo.addActionListener    (new DesenhoDeCirculo());
        btnElipse.addActionListener     (new DesenhoDeElipse());
        btnQuadrado.addActionListener   (new DesenhoQuadrado());
        btnRetangulo.addActionListener  (new DesenhoDeRetangulo());
        btnCorContorno.addActionListener(new PainelDeCores());
        btnCorCentro.addActionListener  (new PainelDeCoresPreenchimento());


        JPanel     pnlBotoes = new JPanel();
        FlowLayout flwBotoes = new FlowLayout(); 
        pnlBotoes.setLayout (flwBotoes);

        pnlBotoes.add (btnAbrir);
        pnlBotoes.add (btnSalvar);
        pnlBotoes.add (btnPonto);
        pnlBotoes.add (btnLinha);
        pnlBotoes.add (btnCirculo);
        pnlBotoes.add (btnElipse);
        pnlBotoes.add (btnQuadrado);
        pnlBotoes.add (btnRetangulo);
        pnlBotoes.add (btnPoligono);
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
                                         MouseMotionListener
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
                                                }
                                            }
                                        }
                                    }
                                }
                            }
        }
        
        public void mouseReleased (MouseEvent e)
        {}
        
        public void mouseClicked (MouseEvent e)
        {}
        
        public void mouseEntered (MouseEvent e)
        {}

        public void mouseExited (MouseEvent e)
        {}
        
        public void mouseDragged(MouseEvent e)
        {}

        public void mouseMoved(MouseEvent e)
        {
            statusBar2.setText("Coordenada: "+e.getX()+","+e.getY());
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
