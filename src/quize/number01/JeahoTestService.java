package quize.number01;

public class JeahoTestService {
   public static void main(String[] args){
       int[] a = {80, 80, 60, 100};
       //int[] a = {20, 0, 100, 100};
		
        for(int i=0; i<a.length; i++){
           int x = 1;
           for(int j=0; j<a.length; j++){
      	      x += a[i] - a[j] < 0  ? 1 : 0; 
           }
	
           System.out.println(i + " : " + a[i] + " : " + x);
        }
    }
}