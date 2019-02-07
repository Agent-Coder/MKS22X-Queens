public class QueenBoard{
    private int[][] board;
    public QueenBoard(int size){
      board=new int[size][size];
      this.clear();
    }
    private void clear(){
      for (int i=0;i<board.length;i++){
        for (int j=0;j<board.length;j++){
          board[i][j]=0;
        }
      }
    }
    //private boolean addQueen(int r,int c){}
    //private boolean removeQueen(int r,int c){}
    public String toString(){
      s="";
      for (int i=0;i<board.length;i++){
        s+="\n";
        for (int j=0;j<board.length;j++){
          if (board[i][j]==0){
            s+="_";
          }
          else{
            s+="Q";
          }
      }
    }
  }
  public boolean solve(){
    
  }
}
