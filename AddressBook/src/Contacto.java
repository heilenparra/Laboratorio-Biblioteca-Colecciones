public class Contacto {
    private String nombre;
    private String telefono;
    private String email;

    public Contacto(String nombrex, String telefonox, String emailx) {
        this.nombre = nombrex;
        this.telefono = telefonox;
        this.email = emailx;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }


    public void setNombre(String nombrex) {
        this.nombre = nombrex; //preguntar aqui porque , estructura logica setters
    }

    public void setTelefono(String telefonox) {
        this.telefono = telefonox;
    }

    public void setEmail(String emailx) {
        this.email = emailx;
    }

    @Override // como funciona override
    public String toString(){
        return nombre+ "| Teléfono:" + telefono + "| Email:" + email;
    }

}

