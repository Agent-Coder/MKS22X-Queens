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
    private boolean addQueen(int r,int c){}
    private boolean removeQueen(int r,int c){}
      
}
