import java.util.ArrayList;

public class Bed {
    private ArrayList<Urt> bed = new ArrayList<Urt>();

    public void plantNy(Urt plante) {
        bed.add(plante);
    }

    public Urt fjernElement(String plantenavn) {
        
        for (Urt urt: bed) {
            if (urt.hentPlante().equals(plantenavn))   {  
                bed.remove(urt);
                return urt;

            }
            
        }
        return null;
    }
    
}