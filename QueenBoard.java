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
            s+="_ ";
          }
          else{
            s+="Q ";
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
    if (solution(0)){
      return true;
    }
    else{
      this.clear();
      return false;
    }
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
    for (int i=0;i<board.length;i++){
      if(i+r<board.length&&i+c<board.length){
        board[r+i][c+i]=board[r+i][c+i]+1;
      }
      if(r-i>=0&&c-i>=0){
        board[r-i][c-i]=board[r-i][c-i]+1;
      }
      if(i+r<board.length&&c-i>=0){
        board[r+i][c-i]=board[r+i][c-i]+1;
      }
      if(r-i>=0&&i+c<board.length){
        board[r-i][c+i]=board[r-i][c+i]+1;
      }
    }
    board[r][c]=-1;
    return true;
  }
  private boolean removeQueen(int r,int c){
    if (board[r][c]!=-1){
      return false;
    }
    for (int i=0;i<board.length;i++){
      board[r][i]=board[r][i]-1;
      if(r!=c||(r!=i)){
        board[i][c]=board[i][c]-1;
      }
    }
    for (int i=0;i<board.length;i++){
      if(i+r<board.length&&i+c<board.length){
        board[r+i][c+i]=board[r+i][c+i]-1;
      }
      if(r-i>0&&c-i>=0){
        board[r-i][c-i]=board[r-i][c-i]-1;
      }
      if(i+r<board.length&&c-i>=0){
        board[r+i][c-i]=board[r+i][c-i]-1;
      }
      if(r-i>=0&&i+c<board.length){
        board[r-i][c+i]=board[r-i][c+i]-1;
      }
    }
    board[r][c]=0;
    return true;
  }
  public static void main(String[] args) {
    QueenBoard a=new QueenBoard(2);
    QueenBoard b=new QueenBoard(3);
    QueenBoard c=new QueenBoard(4);
    QueenBoard d=new QueenBoard(5);
    QueenBoard e=new QueenBoard(6);
    QueenBoard f=new QueenBoard(7);
    QueenBoard g=new QueenBoard(8);
    QueenBoard h=new QueenBoard(14);
    a.solve();
    b.solve();
    c.solve();
    d.solve();
    e.solve();
    f.solve();
    g.solve();
    h.solve();
    System.out.println(a);
    System.out.println(b);
    System.out.println(c);
    System.out.println(d);
    System.out.println(e);
    System.out.println(f);
    System.out.println(g);
    System.out.println(h);
  }
}
