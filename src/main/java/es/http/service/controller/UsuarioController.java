package es.http.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.http.service.dto.Usuario;
import es.http.service.services.UsuarioServiceImpl;

@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;
	
	@GetMapping("/usuario")
	public List<Usuario> listarCusuarios(){
		return usuarioServiceImpl.listarUsuario();
	}
	

	@PostMapping("/usuario")
	public Usuario salvarUsuario(@RequestBody Usuario usuario) {
		
		return usuarioServiceImpl.guardarUsuario(usuario);
	}
	
	
	@GetMapping("/usuario/{id}")
	public Usuario usuarioXID(@PathVariable(name="id") int id) {
		
		Usuario Usuario_xid= new Usuario();
		
		Usuario_xid=usuarioServiceImpl.usuarioXID(id);
		
		//System.out.println("Usuario XID: "+Usuario_xid);
		
		return Usuario_xid;
	}
	
	@PutMapping("/usuario/{id}")
	public Usuario actualizarUsuario(@PathVariable(name="id")int id,@RequestBody Usuario usuario) {
		
		Usuario Usuario_seleccionado= new Usuario();
		Usuario Usuario_actualizado= new Usuario();
		
		Usuario_seleccionado= usuarioServiceImpl.usuarioXID(id);
		
		Usuario_seleccionado.setNombre(usuario.getNombre());
		Usuario_seleccionado.setEmail(usuario.getEmail());
		Usuario_seleccionado.setPassword(usuario.getPassword());
		Usuario_seleccionado.setEdad(usuario.getEdad());
		Usuario_seleccionado.setRole(usuario.getRole());
		Usuario_seleccionado.setUrl_imagen(usuario.getUrl_imagen());
		Usuario_seleccionado.setActivo(usuario.getActivo());
		
		
		Usuario_actualizado = usuarioServiceImpl.actualizarUsuario(Usuario_seleccionado);
		
		//System.out.println("El Usuario actualizado es: "+ Usuario_actualizado);
		
		return Usuario_actualizado;
	}
	
	@DeleteMapping("/usuario/{id}")
	public void eleiminarUsuario(@PathVariable(name="id")int id) {
		usuarioServiceImpl.eliminarUsuario(id);
	}
}
