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
          //if (board[i][j]!=-1){
            s+=board[i][j];
          //}
          //else{
            //s+="Q";
          //}
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
    return solution(board.length,0,0);
  }
  public boolean solution(int size,int r,int c){
    if (r==board.length||c==board.length||r<0){
      if(size<0){
        return true;
      }
      else{
        return false;
      }
    }
    System.out.println("begin"+size+" "+r+" "+c);
    if(addQueen(r,c)){
      return solution(size-1,r+1,0);
    }
    else{
      System.out.println("remove"+r+" "+c);
      for (int k=0;k<board.length;k++) {
        if(r!=0&&board[r][k]==-1){
          System.out.println("removing"+(r-1)+" "+c);
          removeQueen(r,k);
          c=k;
          }
        }
        if(c+1==board.length){
            return solution(size,r-1,0);
        }
        return solution(size,r,c+1);
      }
  }
  private boolean addQueen(int r,int c){
    if (board[r][c]!=0){
      return false;
    }
    for (int i=0;i<board.length;i++){
      board[r][i]=board[r][i]+1;
      if(r!=c){
        board[i][c]=board[i][c]+1;
      }
    }
    int a=0;
    int b=c-r;
    while(a<board.length&&b<board.length){
      board[a][b]=board[a][b]+1;
      a+=1;
      b+=1;
    }
    a=0;
    b=c+r;
    while(a<board.length&&b>=0){
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
    else{
      board[r][c]=0;
    }
    for (int i=0;i<board.length;i++){
      board[r][i]=board[r][i]-1;
      if(r!=c){
        board[i][c]=board[i][c]-1;
      }
    }
    int a=0;
    int b=c-r;
    while(a<board.length&&b<board.length){
      board[a][b]=board[a][b]-1;
      a+=1;
      b+=1;
    }
    a=0;
    b=c+r;
    while(a<board.length&&b>=0){
      board[a][b]=board[a][b]-1;
      a+=1;
      b-=1;
    }
    board[r][c]=0;
    return true;
  }
  public static void main(String[] args) {
    QueenBoard x=new QueenBoard(8);
    x.addQueen(1,3);
    x.removeQueen(1,3);
    System.out.println(x);
  }
}
