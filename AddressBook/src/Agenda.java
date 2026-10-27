import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.Treemap;
import java.util.Treeset;
import java.util.ArrayList;

public class Agenda {

    private Map<String, Contacto> contactos = new TreeMap<>(); // aca entiendo el treemap, pero no entiendo estamos haciendo un new que
    private Set<String> grupos = new TreeSet<>();
    private Map<String, Set<String>> contactosPorGrupo = new TreeMap<>();
    private List<Contacto> historial = new ArrayList<>();

public void agregarContacto(Contacto c){
    if(contactos.containsKey(c.getNombre())){
        System.out.println("Error: Ya existe un contacto con el nombre '" + c.getNombre() + "'");
    } else{
        contactos.put(c.getNombre(),c);
        historial.add(c);
        System.out.println("Contacto agregado: " + c.getNombre());
    }
}


}
