public class NBody {
    static public double readRadius(String a){
        In in = new In(a);
        int n = in.readInt();
        double radius = in.readDouble();
        return radius;
    }
    static public int readNum(String a){
        In in = new In(a);
        int n = in.readInt();
        return n;
    }
    static public Planet[] readp(String a){
        int count = 0;
        In in = new In(a);
        int n = in.readInt();
        double radius = in.readDouble();
        Planet[] p = new Planet[n];
        while(!in.isEmpty()&&count<n){
            double x_1 = in.readDouble();
            double x_2 = in.readDouble();
            double x_3 = in.readDouble();
            double x_4 = in.readDouble();
            double x_5 = in.readDouble();
            String s = in.readString();
            p[count]  = new Planet(x_1,x_2,x_3,x_4,x_5,s);
            count+=1;
        }
        return p;
        
       
    }
    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet p[] = readp(filename);
        double r = readRadius(filename);
        int n = readNum(filename);

        StdDraw.setScale(-r,r);
        StdDraw.clear();
        StdDraw.picture(0, 0, "./images/starfield.jpg",2*r,2*r);
        for(Planet pla : p){
            pla.draw();
        }
        StdDraw.enableDoubleBuffering();
       
        for( double discreT = 0;discreT<T;discreT += dt){
            
            StdDraw.clear();
            double xForces[] = new double[n];
            double yForces[] = new double[n];
            int count = 0;
            for(Planet pla : p){
                xForces[count] = pla.calcNetForceExertedByX(p);
                yForces[count] = pla.calcNetForceExertedByY(p);
                count+=1;
            }
          
           
            for(int i =0;i<n;i++){
                p[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, "./images/starfield.jpg",2*r,2*r);
            for(Planet pla : p){
                pla.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            
    
        
            
        

        }
        StdOut.printf("%d\n", p.length);
        StdOut.printf("%.2e\n", r);
        for (int i = 0; i < p.length; i++) {
         StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  p[i].xxPos, p[i].yyPos, p[i].xxVel,
                  p[i].yyVel, p[i].mass, p[i].imgFileName);   
}
    
}
}
