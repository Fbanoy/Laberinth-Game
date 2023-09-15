import java.util.List;

/**
 *
 * @author Federico Banoy
 */
public class Mounstro {
    private int mnX;
    private int mnY;

   
    public Mounstro(int mnX,int mnY)
    {
     this.mnY =mnY;
     this.mnX =mnX;
    }
    public int getmnX(){
      return mnX;
    }
    public int getmnY(){
      return mnY;
    }
    public void plusY(){
        mnY = mnY+1;
    }
        public void plusX(){
        mnX = mnX+1;
    }
        public void minusX(){
        mnX = mnX-1;
    }
        public void minusY(){
        mnY = mnY-1;
    }

}