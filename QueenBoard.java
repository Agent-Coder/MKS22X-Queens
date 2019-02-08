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
      String s="";
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
    return solution(board.length,0,0);
  }
  public boolean solution(int size,int r,int c){
    if (r==c&&c==board.length){
      if(size==0){
        return true;
      }
      else{
        return false;
      }
    }
    if(addQueen(r,c)){
      return solution(size,r+1,c);
    }
    else{
      if (c==board.length){
        removeQueen(r,c)
      }
      return solution(size,r,c+1);
    }
  }
  private boolean addQueen(int r,int c){
    if (board[r][c]!=0){
      return false;
    }
    else{
      board[r][c]=-1;
    }
    for (int i=0;i<board.length;i++){
      board[r][i]=board[r][i]+1;
      board[i][c]=board[i][c]+1;
    }
    int a=0;
    int b=0;
    while(a<board.length&&b<board.length){
      board[a][b]=board[a][b]+1;
      a+=1;
      b+=1;
    }
    return true;
  }
  private boolean removeQueen(int r,int c){
    if (board[r][c]==0){
      return false;
    }
    else{
      board[r][c]=0;
    }
    for (int i=0;i<board.length;i++){
      board[r][i]=board[r][i]-1;
      board[i][c]=board[i][c]-1;
    }
    int a=0;
    int b=0;
    while(a<board.length&&b<board.length){
      board[a][b]=board[a][b]-1;
      a+=1;
      b+=1;
    }
    return true;
  }
}
