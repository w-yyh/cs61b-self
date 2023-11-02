public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    static  final double G = 6.67e-11;

    public Planet(double xP,double yP,double xV,double yV,double m,String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass =  p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        double dx = p.xxPos-this.xxPos;
        double dy = p.yyPos-this.yyPos;
        double r = Math.pow(dx*dx+dy*dy,0.5);
        return r;
    }

    public double calcForceExertedBy(Planet p){
        double r = this.calcDistance(p);
        double force = (G*mass*p.mass)/(r*r);
        return force;

    }
    public double calcForceExertedByX(Planet p){
        double dx = p.xxPos-xxPos;
        double force_x = (dx/this.calcDistance(p))*calcForceExertedBy(p);
        return force_x;

    }
    public double calcForceExertedByY(Planet p){
        double dy = p.yyPos-yyPos;
        double force_y = (dy/this.calcDistance(p))*calcForceExertedBy(p);
        return force_y;

    }
    public double calcNetForceExertedByX(Planet[] allPlanets){
        double netx = 0;
        for (Planet planet : allPlanets) {
            if(!this.equals(planet))netx +=this.calcForceExertedByX(planet);
        }
        return netx;
    }
    public double calcNetForceExertedByY(Planet[] allPlanets){
        double nety = 0;
        for (Planet planet : allPlanets) {
            if(!this.equals(planet))nety +=this.calcForceExertedByY(planet);
        }
        return nety;
    }

    public void update(double dt,double fx,double fy){
        double a_x = fx/mass;
        double a_y = fy/mass;
        xxVel += a_x*dt;
        yyVel += a_y*dt;
        xxPos += xxVel*dt;
        yyPos += yyVel*dt; 
    }


    public void draw(){
        String imag = "images/"+imgFileName;
        StdDraw.picture(xxPos, yyPos, imag);
    }

}
