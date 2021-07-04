package T2;

public class Iris {
    
    private Double sl;
    private Double sw;
    private Double pl;
    private Double pw;
    private String name;

    public Iris(
        Double sl, Double sw,
        Double pl, Double pw,
        String name
    ) {
        this.sl = sl;
        this.sw = sw;
        this.pl = pl;
        this.pw = pw;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public double getSl(){
        return sl;
    }

    public double getSw(){
        return sw;
    }

    public double getPl(){
        return pl;
    }

    public double getPw(){
        return pl;
    }

    @Override
    /* public String toString(){
        return sl+","+sw+","+pl+","+pw+","+"'"+name+";";
    } */

    public String toString(){
        return "SL: " + sl + ", " + 
        "SW: " + sw + ", " +
        "PL: " + pl + ", " +
        "PW: " + pw + ", " +
        "Name: " + name + "\n";
    } 
}
