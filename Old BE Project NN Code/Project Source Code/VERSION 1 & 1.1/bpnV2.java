//THIS CODE IS AN IMPROVEMENT OVER VERSION 1 & PRODUCES A LOW ERROR RATE


import java.io.*;
import java.util.*;


class bpnV2
     {
      public static void main(String args[])throws IOException
         {
          double ni11, ni12, ni21, ni22, nhi1, nhi2, nho1, nho2, noi, noo;
          double w21=0.35, w22=0.81, w11=0.62, w12=0.42, w13=0.55, w14=-0.17;
          double c21, c22, c11, c12, c13, c14;
          double lr=0.99;
          double t1, t2, e1, e2, E;
          int i=0;

          //Code for system date & time

      int day, month, year;
      int second, minute, hour;
      GregorianCalendar date = new GregorianCalendar();
 
      day = date.get(Calendar.DAY_OF_MONTH);
      month = date.get(Calendar.MONTH);
      year = date.get(Calendar.YEAR);
 
      second = date.get(Calendar.SECOND);
      minute = date.get(Calendar.MINUTE);
      hour = date.get(Calendar.HOUR);

          System.out.println();
          System.out.println();

         //Display time and date        
 
      System.out.println("Current date is  "+day+"/"+(month+1)+"/"+year);
      System.out.println("Current time is  "+hour+" : "+minute+" : "+second);


          System.out.println();
          System.out.println();    

          
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          System.out.println("enter ni11, ni12, ni21, ni22: ");
          ni11=Integer.parseInt(br.readLine());
          ni12=Integer.parseInt(br.readLine());
          ni21=Integer.parseInt(br.readLine());
          ni22=Integer.parseInt(br.readLine());

          System.out.println("enter targets t1, t2: ");
          t1=Integer.parseInt(br.readLine());
          t2=Integer.parseInt(br.readLine());

          while(i<50000) 
            {
             //activate hidden neurons
             nhi1=ni11*w11+ni12*w13;
             nhi2=ni11*w12+ni12*w14;

            
             //find o/p of hidden neurons
             nho1=(1/(1+Math.exp(-nhi1)));
             nho2=(1/(1+Math.exp(-nhi2)));

             //calculate ip of o/p layer
             noi=(nho1*w21)+(nho2*w22);

             //calculate final o/p
             noo=(1/(1+Math.exp(-noi)));

             //calc error
             e1=t1-noo;

             //end of FP, beginning of BP 

             //changes in weight matrix 2            

             c21=lr*e1*nho1*noo*(1-noo);
             w21=w21+c21;

             c22=lr*e1*nho2*noo*(1-noo);
             w22=w22+c22;

             //changes in weight matrix 1
             c11=lr*e1*ni11*nho1*(1-nho1)*noo*(1-noo)*w21;
             w11=w11+c11;

             c12=lr*e1*ni11*nho2*(1-nho2)*noo*(1-noo)*w22;
             w12=w12+c12;

             c13=lr*e1*ni12*nho1*(1-nho1)*noo*(1-noo)*w21;
             w13=w13+c13;

             c14=lr*e1*ni12*nho2*(1-nho2)*noo*(1-noo)*w22;
             w14=w14+c14;

        

             //now for ip 1 1

             nhi1=ni21*w11+ni22*w13;
             nhi2=ni21*w12+ni22*w14;

             nho1=(1/(1+Math.exp(-nhi1)));
             nho2=(1/(1+Math.exp(-nhi2)));

             noi=(nho1*w21)+(nho2*w22);
             noo=(1/(1+Math.exp(-noi)));

             e2=t2-noo;

             //end of FP, beginning of BP 

             //changes in weight matrix 2            

             c21=lr*e2*nho1*noo*(1-noo);
             w21=w21+c21;

             c22=lr*e2*nho2*noo*(1-noo);
             w22=w22+c22;

             //changes in weight matrix 1

             c11=lr*e2*ni21*nho1*(1-nho1)*noo*(1-noo)*w21;
             w11=w11+c11;

             c12=lr*e2*ni21*nho2*(1-nho2)*noo*(1-noo)*w22;
             w12=w12+c12;

             c13=lr*e2*ni22*nho1*(1-nho1)*noo*(1-noo)*w21;
             w13=w13+c13;

             c14=lr*e2*ni22*nho2*(1-nho2)*noo*(1-noo)*w22;
             w14=w14+c14;


             E=Math.sqrt((e1*e1)+(e2*e2));
             i++;
             System.out.println(E);
            }

    
          System.out.println();
          System.out.println();          


        //Display time and date        

         System.out.println("Current date is  "+day+"/"+(month+1)+"/"+year);
         System.out.println("Current time is  "+hour+" : "+minute+" : "+second);
  
          System.out.println();
          System.out.println();
           

          double ip11, ip12, ip21, ip22;

          System.out.println("enter ip11, ip12, ip21, ip22: ");
         /* System.out.println(w21);
          System.out.println(w22);
          System.out.println(w11);
          System.out.println(w12);
          System.out.println(w13);
          System.out.println(w14);*/
          ip11=Integer.parseInt(br.readLine());
          ip12=Integer.parseInt(br.readLine());
          ip21=Integer.parseInt(br.readLine());
          ip22=Integer.parseInt(br.readLine());

           nhi1=ip11*w11+ip12*w13;
           nhi2=ip11*w12+ip12*w14;

           nho1=(1/(1+Math.exp(-nhi1)));
           nho2=(1/(1+Math.exp(-nhi2)));

             noi=(nho1*w21)+(nho2*w22);
             noo=(1/(1+Math.exp(-noi)));

           System.out.println(noo);

           nhi1=ip21*w11+ip22*w13;
             nhi2=ip21*w12+ip22*w14;

             nho1=(1/(1+Math.exp(-nhi1)));
             nho2=(1/(1+Math.exp(-nhi2)));

             noi=(nho1*w21)+(nho2*w22);
             noo=(1/(1+Math.exp(-noi)));

System.out.println(noo);

}

}
      
          

          
          