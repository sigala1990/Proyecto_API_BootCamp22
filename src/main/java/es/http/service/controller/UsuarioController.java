package es.http.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.http.service.DAO.IUsuarioDAO;
import es.http.service.dto.Usuario;
import es.http.service.services.UsuarioServiceImpl;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UsuarioController {

	private IUsuarioDAO iUsuarioDAO;

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UsuarioController(IUsuarioDAO iUsuarioDAO, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.iUsuarioDAO = iUsuarioDAO;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;
	
	@GetMapping("/response-entity-builder-with-http-headers")
	public ResponseEntity<String> usingResponseEntityBuilderAndHttpHeaders() {
	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("Baeldung-Example-Header", 
	      "Value-ResponseEntityBuilderWithHttpHeaders");

	    return ResponseEntity.ok()
	      .headers(responseHeaders)
	      .body("Response with header using ResponseEntity");
	}
	
	@GetMapping("/usuario")
	public List<Usuario> listarUsuarios(){
		return usuarioServiceImpl.listarUsuario();
	}
	
	@PostMapping("/usuario")
	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
	public Usuario salvarUsuario(@RequestBody Usuario usuario) {
		usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
		iUsuarioDAO.save(usuario);
		
		return usuario;
	}
	
	
	@GetMapping("/usuario/{id}")
	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
	public Usuario usuarioXID(@PathVariable(name="id") int id) {
		
		
		Usuario Usuario_xid= new Usuario();
		
		Usuario_xid=usuarioServiceImpl.usuarioXID(id);
		
		//System.out.println("Usuario XID: "+Usuario_xid);
		
		return Usuario_xid;
	}
	
	@PutMapping("/usuario/{id}")
	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
	public Usuario actualizarUsuario(@PathVariable(name="id")int id,@RequestBody Usuario usuario) {
		
		Usuario Usuario_seleccionado= new Usuario();
		Usuario Usuario_actualizado= new Usuario();
		
		Usuario_seleccionado= usuarioServiceImpl.usuarioXID(id);
		
		Usuario_seleccionado.setUserName(usuario.getUsername());
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
	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
	public void eleiminarUsuario(@PathVariable(name="id")int id) {
		usuarioServiceImpl.eliminarUsuario(id);
	}
}
