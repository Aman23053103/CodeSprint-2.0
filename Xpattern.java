import java.util.*;

public class Xpattern {
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    String[][] matrix=new String[n][n];
     for(int i=0;i<n;i++){
       for(int j=0;j<n;j++){
         matrix[i][j]=String.valueOf(i+1);
       }else if(i==j){
         matrix[i][j]=String.valueOf(i+1);
       }else if(i+j==n-1){
         matrix[i][j]=String.valueOf(n-1);
       }else{
         matrix[i][j]="-";
       }
     }
    
    for(int i=0;i<n;i++){
      StringBuilder line=new StringBuilder();
      for(int j=0;j<n;j++){
        if(j>0){
          line.append(" ");
        }
        line.append(matrix[i][j]);
      }
      System.out.println(line.toString());
    }
   }
}