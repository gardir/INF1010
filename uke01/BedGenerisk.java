import java.util.ArrayList;

public class BedGenerisk<T> {
    private ArrayList<T> bed = new ArrayList<T>();

    public void plantNy(T plante) {
        bed.add(plante);
    }

    public T fjernElement(String plantenavn) {
        
        for (T t: bed) {
            if (t.toString().equals(plantenavn))   {  
                bed.remove(t);
                return t;

            }
            
        }
        return null;
    }
    
}