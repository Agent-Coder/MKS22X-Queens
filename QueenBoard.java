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
          if (board[i][j]!=-1){
            s+="_    ";
          }
          else{
            s+="Q    ";
          }
      }
    }
    return s;
  }
  public boolean solve(){
    for(int i=0;i<board.length;i++){
      for(int h=0;h<board.length;h++){
        if (board[i][h]!=0){
          throw new IllegalStateException();
        }
      }
    }
    return solution(0);
  }
  public boolean solution(int r){
    if(r==board.length){
      return true;
    }
    for (int i=0;i<board.length;i++){
      if (addQueen(r,i)){
        if (solution(r+1)){
          return true;
        }
      }
      removeQueen(r,i);
    }
    return false;
  }
  private boolean addQueen(int r,int c){
    if (board[r][c]!=0){
      return false;
    }
    for (int i=0;i<board.length;i++){
      board[r][i]=board[r][i]+1;
      if(r!=c||(r!=i)){
        board[i][c]=board[i][c]+1;
      }
    }
    int a=0;
    int b=c-r;
    while(a<board.length&&b<board.length&&a>=0&&b>=0){
      board[a][b]=board[a][b]+1;
      a+=1;
      b+=1;
    }
    a=0;
    b=c+r;
    while(a<board.length&&b<board.length&&a>=0&&b>=0){
      board[a][b]=board[a][b]+1;
      a+=1;
      b-=1;
    }
    board[r][c]=-1;
    return true;
  }
  private boolean removeQueen(int r,int c){
    if (board[r][c]==0){
      return false;
    }
    for (int i=0;i<board.length;i++){
      board[r][i]=board[r][i]-1;
      if(r!=c||(r!=i)){
        board[i][c]=board[i][c]-1;
      }
    }
    int a=0;
    int b=c-r;
    while(a<board.length&&b<board.length&&a>=0&&b>=0){
      board[a][b]=board[a][b]-1;
      a+=1;
      b+=1;
    }
    a=0;
    b=c+r;
    while(a<board.length&&b<board.length&&a>=0&&b>=0){
      board[a][b]=board[a][b]-1;
      a+=1;
      b-=1;
    }
    board[r][c]=0;
    return true;
  }
  public static void main(String[] args) {
    QueenBoard x=new QueenBoard(8);
    x.solve();
    System.out.println(x);
  }
}
