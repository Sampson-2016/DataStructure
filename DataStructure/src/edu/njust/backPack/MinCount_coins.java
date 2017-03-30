package edu.njust.backPack;

/*找零钱问题：要找 K元的零钱，零钱的种类有 coins[],要求零钱的张数最少，用 road[]来找出具体使用的零钱*/
public class MinCount_coins {
    public static void main (String[] args) { 
       int coins[]={3,5};
       int k=8;
       int road[]=new int[k+1];
       int min=getMinCount(k ,coins ,road );      
       if(min>0){
    	   System.out. println( "数值为" +k +" 时，需要的最少的硬币数为： "+ min);
    	   while(k>0){
    		   System.out.print(road[k]+" ");
    		   k=k-road[k];
    		   
    	   }
       }else {
    	   System.out. println( "数值为" +k +" 时，无法找零");
       }
    } 
/**
 * 
 * @param k 总额
 * @param c	硬币值数组
 * @param r	组合
 * @return
 */
    public static int getMinCount (int k,int c[],int r[]){
     int a[]=new int[k+1];//保存最近加入的零钱值
     a [0]=0;
     for(int i=0;i<c.length;i++){
    	 if(k>=c[i]){
    		 a[c[i]]=1;
    		 r[c[i]]=c[i];
    	 }
     }
     for(int i=1;i<k+1;i++){
    	 for(int j=0;j<c.length;j++){
    		 if(c[j]>i){
    			 break;
    		 }else if(c[j]<i) {
    			 if(a[i-c[j]]!=0){
    				 if(a[i]==0){
    					 a[i]=a[i-c[j]]+1;
    					 r[i]=c[j];
    				 }else {
    					 a[i]=min(a[i], a[i-c[j]]+1);
    					 if(a[i]==a[i-c[j]]+1){
    						 r[i]=c[j];
    					 }
    				 }
    			 }
			 }
    	 }
     }
     return a[k];
    }
    
    public static int min(int a,int b){
    	return a<b?a:b;
    }
}