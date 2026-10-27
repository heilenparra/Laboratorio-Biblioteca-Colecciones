import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.ArrayList;

public class Agenda {

    private Map<String, Contacto> contactos = new TreeMap<>(); // aca entiendo el treemap, pero no entiendo estamos haciendo un new que
    private Set<String> grupos = new TreeSet<>();
    private Map<String, Set<String>> contactosPorGrupo = new TreeMap<>();
    private List<Contacto> historial = new ArrayList<>();

    public void agregarContacto(Contacto c) {
        if (contactos.containsKey(c.getNombre())) {
            System.out.println("Error: Ya existe un contacto con el nombre '" + c.getNombre() + "'");
        } else {
            contactos.put(c.getNombre(), c);
            historial.add(c);
            System.out.println("Contacto agregado: " + c.getNombre());
        }
    }

    public Contacto buscarContacto(String nombre) {
        return contactos.get(nombre);
    }

    public boolean eliminarContacto(String nombre) {
        if (!contactos.containsKey(nombre)) {
            return false;
        }
//Vamos a eliminar del mapa, del historial y de los grupos:
        contactos.remove(nombre);
        historial.removeIf(contacto -> contacto.getNombre().equals(nombre));
        for (Set<String> nombresContactos : contactosPorGrupo.values()) {
            nombresContactos.remove(nombre);
        }
        return true;
    }

    public void listarContactos() {
        for (Contacto contacto : contactos.values()) {
            System.out.println(contacto);
        }
    }

    public void listarHistorial() {
        for (Contacto contacto : historial) {
            System.out.println(contacto);
        }
    }

    public void agregarGrupo(String nombreGrupo) {
        if (grupos.contains(nombreGrupo)) {
            System.out.println("Error: El grupo '" + nombreGrupo + "' ya existe");
        } else {
            grupos.add(nombreGrupo);
            contactosPorGrupo.put(nombreGrupo, new TreeSet<>());
            System.out.println("Grupo '" + nombreGrupo + "' creado");
        }
    }

    public void agregarContactoAGrupo(String nombreContacto, String nombreGrupo) {
        if (!contactos.containsKey(nombreContacto)) {
            System.out.println("Error: El contacto '" + nombreContacto + "' no existe");
            return;
        }
        if (!grupos.contains(nombreGrupo)) {
            System.out.println("Error: El grupo '" + nombreGrupo + "' no existe");
            return;
        }
        contactosPorGrupo.get(nombreGrupo).add(nombreContacto);
        System.out.println("Contacto agregado al grupo '" + nombreGrupo + "'");
    }

    public void listarGrupos() {
        for (String nombreGrupo : grupos) {
            System.out.println(nombreGrupo);
        }
    }

    public void mostrarContactosPorGrupo(String nombreGrupo) {
        if (!grupos.contains(nombreGrupo)) {
            System.out.println("Error: El grupo '" + nombreGrupo + "' no existe");
            return;
        }
        Set<String> nombresContactos = contactosPorGrupo.get(nombreGrupo);

        if (nombresContactos.isEmpty()) {
            System.out.println("El grupo '" + nombreGrupo + "' no tiene contactos");
            return;
        }
        System.out.println("Contactos en '" + nombreGrupo + "':");
        for (String nombreContacto : nombresContactos) {
            System.out.println("- " + contactos.get(nombreContacto));
        }
    }

}
