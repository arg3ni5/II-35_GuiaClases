public class Sudoku
{
  private int tablero[][]= new int [9][9];
  
  private boolean valoresUsados [] = new  boolean [10];
  
  
  public Sudoku()
  {  
    for(int i=0;i<9;i++)
    {
      for(int j=0;j<9;j++){
        tablero[i][j]=0;// para k recorra toda la matriz
        
        
      }
      
    }
    
    for(int i=0;i<10;i++)
    {
      valoresUsados[i]=false;
    }
    
  }
  
  public void setCelda(int fila, int columna, int valor)
    
  {
    tablero [fila][columna]=valor;
  } 
  
  public int getValorCelda(int fila, int columna)
    
  {
    return tablero [fila][columna];
    
  } 
  
  public boolean jugadaValida(int fila,int columna,int valor){
    limpiarValoresUsados();
    for(int i=0;i<9;i++){
      valoresUsados[tablero[i][columna]]=true;//determinar filas
      valoresUsados[tablero[fila][i]]=true;}//determinar columnas
    //empieza determinar tablero....
    int filaT=fila/3*3;
    int colT=columna/3*3;
    for(int i=filaT;i<filaT+3;i++){
      for(int j=colT;j<colT+3;j++){
        valoresUsados[tablero[i][j]]=true;
      }
    }
    //....termina determinar tablero
    if(valoresUsados[valor]){
      return false;
    }
    return true;}
  
  public void limpiarValoresUsados(){
    for(int i=0;i<valoresUsados.length;i++){
      valoresUsados[i]=false;
    }
  }
  public String listarValoresValidos(){
    String sal="{";
    for(int i=0;i<9;i++){
      if(!this.valoresUsados[i]){
        sal+=i+",";
      }
    }
    return sal+"}";
  }
  
  public String listarValoresInvalidos(){
    String sal="";
    for(int i=0;i<9;i++){
      for(int j=0;j<9;j++){
        if(this.valoresUsados[i]){
          sal+=i+",";
        }
      }
    }
    return sal+"}";
  }
  public String toString()
  {
    String salida= "Estado del Sudoku";
    
    
    
    for(int i=0;i<9;i++)
    {
      salida+="|\n";
      for(int j=0;j<9;j++){
        salida+="["+tablero[i][j]+"]";        
      }
    }
    return salida; 
  }
}



