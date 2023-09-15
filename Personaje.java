public class Personaje
{
    private int pjX;
    private int pjY;

   
    public Personaje(int pjX,int pjY)
    {
     this.pjY =pjY;
     this.pjX =pjX;
    }
    public int getpjX(){
      return pjX;
    }
    public int getpjY(){
      return pjY;
    }
    public void plusY(){
        pjY = pjY+1;
    }
        public void plusX(){
        pjX = pjX+1;
    }
        public void minusX(){
        pjX = pjX-1;
    }
        public void minusY(){
        pjY = pjY-1;
    }

}