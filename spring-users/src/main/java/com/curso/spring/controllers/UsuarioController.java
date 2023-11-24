package com.curso.spring.controllers;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.curso.spring.dao.UsuarioService;
import com.curso.spring.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UsuarioController {
	
//	@Autowired
//	private UsuarioDao usuarioDao;
//	
//	@Autowired
//	private JWTUtil jwtUtil;
	
	 	@Autowired
	    UsuarioService usuarioService;
	 	
	 	@RequestMapping(value="/login", method = RequestMethod.POST)
	 	public void login(@RequestBody String pss, String usuario) {
	 		log.info("Login usuario");
	 		UsuarioService.crearUsuario(usuario, pss);
	 	}
	 
	 	@RequestMapping(value= "api/usuarios", method = RequestMethod.GET)
		public List<Usuario> getUsuarios() throws InterruptedException, ExecutionException {
	 		log.info("Lista de usuarios");
		       return usuarioService.obtenerTodosLosUsuarios();
		    }
	 	
	 	@RequestMapping(value="api/registrar",  method = RequestMethod.POST)
		    public String registrarUsuario(@RequestBody Usuario usuario ) throws InterruptedException, ExecutionException {
	 		log.info("Registro usuario");
		        return usuarioService.registrar(usuario);
		    }
	 	 
	  	@RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
	    public String eliminar(@PathVariable String id){
	  		log.info("Eliminar usuario");
	        return usuarioService.eliminar(id);
	    }
	  	
	  	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
	    public Usuario usuarioDetalle(@PathVariable String id) throws InterruptedException, ExecutionException{
	        return usuarioService.getDetalleUsuario(id);
	    }	 	 
	
	
//	@RequestMapping(value = "api/usuario/{id}", method = RequestMethod.DELETE)
//	public void eliminarUsuario(@PathVariable Long id) {
//			
//		usuarioDao.eliminar(id);
//	}

//	@RequestMapping(value="api/registra",  method = RequestMethod.POST)
//	public void registraUsuario(@RequestBody Usuario usuario) {
//		Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
//		String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
//		usuario.setPassword(hash);		
//		usuarioDao.registrar(usuario);
//		}
		
		
		
	
//	CollectionReference reference;
//	static Firestore db;
//	
//	public static boolean registrar(String coleccion, String documento, Map<String, Object> data){
//		
//		db = FirestoreClient.getFirestore();
//		
//		try {
//			DocumentReference docRef = db.collection(coleccion).document(documento);
//			ApiFuture<WriteResult> result = docRef.set(data);
//			System.out.println("Guardado con exito");
//		}catch (Exception e){
//			System.out.println("Error "+ e.getMessage());
//			
//		}
//		return false;
//		
//	}

}
