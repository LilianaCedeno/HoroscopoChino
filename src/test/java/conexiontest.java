import org.lc.dao.UsuarioDaoImp;
import org.lc.modelo.Usuario;

import java.util.List;

public class conexiontest {
    public static void main(String[] args) {
        UsuarioDaoImp usuarioDaoImp = new UsuarioDaoImp();

        // Probar lista de usuarios()
        List<Usuario> usuarios = usuarioDaoImp.listarUsuario();

        if (usuarios != null && !usuarios.isEmpty()) {
            System.out.println("Productos recuperados de la base de datos:");
            usuarios.forEach(usuario -> {
                System.out.println("ID: " + usuario.getId());
                System.out.println("Nombre: " + usuario.getNombre());
                System.out.println("Usuario: " + usuario.getNomUsuario());
                System.out.println("email: " + usuario.getEmail());
                System.out.println("Fecha de nacimiento: " + usuario.getFechaNacimiento());
                System.out.println("Password: " + usuario.getPassword());
                System.out.println("Animal: " + usuario.getAnimal());
                System.out.println("------------------------------------");
            });
        } else {
            System.out.println("No se recuperaron usuarios la lista está vacía.");
        }
    }
}
