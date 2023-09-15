import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.*;
import java.io.*;
public class Laberinto extends JFrame {
    private int [][] maze = new int[10][13];   
    Random rand = new Random();
    int randomNum = rand.nextInt(9) + 1;
    Personaje pj = new Personaje(1, 6);
    Mounstro mn1 = new Mounstro(5,6);
    Mounstro mn2 = new Mounstro(1,1);
    private boolean dibujarMaze = false;

  

    
    
    

    
    
    

   
    
      public void leerArchivo()throws FileNotFoundException{
          Scanner input = new Scanner(new File(randomNum + "lab.txt"));
          for (int row = 0; row < 13; row++) {
              for (int col = 0; col < 10; col++) {
                  if(input.hasNextLine()){
                      String line = input.nextLine();
                      Scanner lineScan = new Scanner(line);
                      maze[col][row]=lineScan.nextInt();
                    }
                }
          }
    }
    
    public Laberinto() {
        setTitle("Labyrinth The Game");
        setSize(640, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
                try{
            leerArchivo();
        }catch(Exception e){
            e.printStackTrace();
        }

        
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        g.translate(50, 50);

        // debuja el mapa
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                Color color;
                switch (maze[row][col]) {
                    case 1 : color = Color.BLACK; break;
                    default : color = Color.WHITE;
                }
                g.setColor(color);
                g.fillRect(30 * col, 30 * row, 30, 30);
                g.setColor(Color.BLACK);
                g.drawRect(30 * col, 30 * row, 30, 30);
            }
        }      
    
        // Dibuja a el personaje
        g.setColor(Color.GREEN);
        g.fillOval(pj.getpjX()* 30, pj.getpjY() * 30, 30, 30);
        // Dibuja a el mounstro1
        g.setColor(Color.RED);
        g.fillRect(mn1.getmnX() * 30, mn1.getmnY() * 30, 30, 30);
        // Dibuja a el mounstro2
        g.setColor(Color.YELLOW);
        g.fillRect(mn2.getmnX() * 30, mn2.getmnY() * 30, 30, 30);
        // Dibuja la meta
        g.setColor(Color.BLUE);
        g.fillRect(11* 30, 2* 30, 30, 30);


    }
    
    public void moveMounters(){
        Random randm = new Random();
        int rmove = randm.nextInt(4);
        if(((maze[mn1.getmnY()][mn1.getmnX()+1] == 1 && maze[mn1.getmnY()][mn1.getmnX()-1] == 1) && maze[mn1.getmnY()+1][mn1.getmnX()] == 1 )){
            mn1.minusY();
        }else if(((maze[mn1.getmnY()][mn1.getmnX()+1] == 1 && maze[mn1.getmnY()][mn1.getmnX()-1] == 1) && maze[mn1.getmnY()-1][mn1.getmnX()] == 1 )){
            mn1.plusY();
        }else if(((maze[mn1.getmnY()-1][mn1.getmnX()] == 1 && maze[mn1.getmnY()][mn1.getmnX()-1] == 1) && maze[mn1.getmnY()+1][mn1.getmnX()] == 1 )){
           mn1.plusX();
        }else if(((maze[mn1.getmnY()-1][mn1.getmnX()+1] == 1 && maze[mn1.getmnY()][mn1.getmnX()+1] == 1) && maze[mn1.getmnY()+1][mn1.getmnX()] == 1 )){
           mn1.minusX();
        }else if(maze[mn1.getmnY()][mn1.getmnX()+1] == 1 && maze[mn1.getmnY()][mn1.getmnX()-1] == 1){
            if(rmove>2){
               mn1.minusY();
            }else{
               mn1.plusY();
            }
            
        }else if(maze[mn1.getmnY()+1][mn1.getmnX()] == 1 && maze[mn1.getmnY()-1][mn1.getmnX()] == 1){
            if(rmove>2){
               mn1.minusX();
            }else{
               mn1.plusX();
            }
            
        }else if(maze[mn1.getmnY()+1][mn1.getmnX()] == 1 && maze[mn1.getmnY()][mn1.getmnX()+1] == 1){
            if(rmove>2){
               mn1.minusX();
            }else{
               mn1.minusY();
            }
            
        }else if(maze[mn1.getmnY()-1][mn1.getmnX()] == 1 && maze[mn1.getmnY()][mn1.getmnX()+1] == 1){
            if(rmove>2){
               mn1.minusX();
            }else{
               mn1.plusY();
            }
            
        }else if(maze[mn1.getmnY()-1][mn1.getmnX()] == 1 && maze[mn1.getmnY()][mn1.getmnX()-1] == 1){
            if(rmove>2){
               mn1.plusX();
            }else{
               mn1.plusY();
            }
            
        }else if(maze[mn1.getmnY()+1][mn1.getmnX()] == 1 && maze[mn1.getmnY()][mn1.getmnX()-1] == 1){
            if(rmove>2){
               mn1.plusX();
            }else{
               mn1.minusY();
            }
            
        }else if(maze[mn1.getmnY()+1][mn1.getmnX()] == 1){
             if(rmove>2){
               mn1.plusX();
            }else if(rmove>1){
               mn1.minusX();
            }else{
               mn1.minusY();
            }
        }else if(maze[mn1.getmnY()-1][mn1.getmnX()] == 1){
             if(rmove>2){
               mn1.plusX();
            }else if(rmove>1){
               mn1.minusX();
            }else{
               mn1.plusY();
            }
        }else if(maze[mn1.getmnY()][mn1.getmnX()-1] == 1){
             if(rmove>2){
               mn1.plusX();
            }else if(rmove>1){
               mn1.minusY();
            }else{
               mn1.plusY();
            }
        }else if(maze[mn1.getmnY()][mn1.getmnX()+1] == 1){
             if(rmove>2){
               mn1.plusY();
            }else if(rmove>1){
               mn1.minusX();
            }else{
               mn1.minusY();
            }
        }

        
        if(((maze[mn2.getmnY()][mn2.getmnX()+1] == 1 && maze[mn2.getmnY()][mn2.getmnX()-1] == 1) && maze[mn2.getmnY()+1][mn2.getmnX()] == 1 )){
            mn2.minusY();
        }else if(((maze[mn2.getmnY()][mn2.getmnX()+1] == 1 && maze[mn2.getmnY()][mn2.getmnX()-1] == 1) && maze[mn2.getmnY()-1][mn2.getmnX()] == 1 )){
            mn2.plusY();
        }else if(((maze[mn2.getmnY()-1][mn2.getmnX()] == 1 && maze[mn2.getmnY()][mn2.getmnX()-1] == 1) && maze[mn2.getmnY()+1][mn2.getmnX()] == 1 )){
           mn2.plusX();
        }else if(((maze[mn2.getmnY()-1][mn2.getmnX()+1] == 1 && maze[mn2.getmnY()][mn2.getmnX()+1] == 1) && maze[mn2.getmnY()+1][mn2.getmnX()] == 1 )){
           mn2.minusX();
        }else if(maze[mn2.getmnY()][mn2.getmnX()+1] == 1 && maze[mn2.getmnY()][mn2.getmnX()-1] == 1){
            if(rmove>2){
               mn2.minusY();
            }else{
               mn2.plusY();
            }
            
        }else if(maze[mn2.getmnY()+1][mn2.getmnX()] == 1 && maze[mn2.getmnY()-1][mn2.getmnX()] == 1){
            if(rmove>2){
               mn2.minusX();
            }else{
               mn2.plusX();
            }
            
        }else if(maze[mn2.getmnY()+1][mn2.getmnX()] == 1 && maze[mn2.getmnY()][mn2.getmnX()+1] == 1){
            if(rmove>2){
               mn2.minusX();
            }else{
               mn2.minusY();
            }
            
        }else if(maze[mn2.getmnY()-1][mn2.getmnX()] == 1 && maze[mn2.getmnY()][mn2.getmnX()+1] == 1){
            if(rmove>2){
               mn2.minusX();
            }else{
               mn2.plusY();
            }
            
        }else if(maze[mn2.getmnY()-1][mn2.getmnX()] == 1 && maze[mn2.getmnY()][mn2.getmnX()-1] == 1){
            if(rmove>2){
               mn2.plusX();
            }else{
               mn2.plusY();
            }
            
        }else if(maze[mn2.getmnY()+1][mn2.getmnX()] == 1 && maze[mn2.getmnY()][mn2.getmnX()-1] == 1){
            if(rmove>2){
               mn2.plusX();
            }else{
               mn2.minusY();
            }
            
        }else if(maze[mn2.getmnY()+1][mn2.getmnX()] == 1){
             if(rmove>2){
               mn2.plusX();
            }else if(rmove>1){
               mn2.minusX();
            }else{
               mn2.minusY();
            }
        }else if(maze[mn2.getmnY()-1][mn2.getmnX()] == 1){
             if(rmove>2){
               mn2.plusX();
            }else if(rmove>1){
               mn2.minusX();
            }else{
               mn2.plusY();
            }
        }else if(maze[mn2.getmnY()][mn2.getmnX()-1] == 1){
             if(rmove>2){
               mn2.plusX();
            }else if(rmove>1){
               mn2.minusY();
            }else{
               mn2.plusY();
            }
        }else if(maze[mn2.getmnY()][mn2.getmnX()+1] == 1){
             if(rmove>2){
               mn2.plusY();
            }else if(rmove>1){
               mn2.minusX();
            }else{
               mn2.minusY();
            }
        }

    }

    @Override
    protected void processKeyEvent(KeyEvent ke) {
        if (ke.getID() != KeyEvent.KEY_PRESSED) {
            return;
        }

        if (ke.getKeyCode() == KeyEvent.VK_RIGHT && (maze[pj.getpjY()][pj.getpjX()+1] == 0 || maze[pj.getpjY()][pj.getpjX()+1] == 2 )) {
           pj.plusX(); 
        }
        else if (ke.getKeyCode() == KeyEvent.VK_LEFT &&(maze[pj.getpjY()][pj.getpjX()-1] == 0 || maze[pj.getpjY()][pj.getpjX()-1] == 2 )) {
           pj.minusX();
        }
        else if (ke.getKeyCode() == KeyEvent.VK_UP &&(maze[pj.getpjY()-1][pj.getpjX()] == 0 || maze[pj.getpjY()-1][pj.getpjX()] == 2 )) {
           pj.minusY();
        }
        else if (ke.getKeyCode() == KeyEvent.VK_DOWN && (maze[pj.getpjY()+1][pj.getpjX()] == 0 || maze[pj.getpjY()+1][pj.getpjX()] == 2 )) {
           pj.plusY();
        }

        if(verificarWin()){
            JOptionPane.showMessageDialog(null,"Ganaste!!!");
            System.exit(0);
        }
                if(verificarLose()){
            JOptionPane.showMessageDialog(null,"Perdiste...");
            System.exit(0);
        }
        moveMounters();
        if(verificarLose()){
            JOptionPane.showMessageDialog(null,"Perdiste...");
            System.exit(0);
        }
        repaint(); 
    }
    
    public boolean verificarLose(){
        boolean lose = false;
        if((mn1.getmnX() == pj.getpjX() && pj.getpjY() == mn1.getmnY())||(mn2.getmnX() == pj.getpjX() && pj.getpjY() == mn2.getmnY())){
           lose = true;
         }
        return lose;
    } 
    
    public boolean verificarWin(){
            boolean win = false;
       if(pj.getpjY()==2 && pj.getpjX() == 11){
         win = true;
        }
        return win;
    } 
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Laberinto view = new Laberinto();
                view.setVisible(true);
            }
        });
    }
    
}
