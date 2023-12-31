package com.curso.spring.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;

import com.curso.spring.models.Usuario;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	
	
	    public static final String COL_NAME="usuarios";
	    
	    
	    public static void crearUsuario(String email, String password) {
	        FirebaseAuth auth = FirebaseAuth.getInstance();
	        CreateRequest request = new CreateRequest()
	            .setEmail(email)
	            .setPassword(password);
	        try {
	            UserRecord userRecord = auth.createUser(request);
	            System.out.println("Successfully created user: " + userRecord.getUid());
	        } catch (FirebaseAuthException e) {
	            System.err.println("Error creating user: " + e.getMessage());
	        }
	    }
	    
	    
	    public List<Usuario> obtenerTodosLosUsuarios() throws InterruptedException, ExecutionException {
	        Firestore dbFirestore = FirestoreClient.getFirestore();
	        CollectionReference usuarios = dbFirestore.collection(COL_NAME);
	        List<Usuario> listaUsuarios = new ArrayList<>();
	        ApiFuture<QuerySnapshot> future = usuarios.get();
	        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
	        for (QueryDocumentSnapshot document : documents) {
	            Usuario usuario = document.toObject(Usuario.class);
	            usuario.setId(document.getId()); // Aquí estamos agregando el ID del documento al objeto Usuario
	            listaUsuarios.add(usuario);
	        }
	        return listaUsuarios;
	    }


	    public String registrar(Usuario usuario) throws InterruptedException, ExecutionException {

	    	 Firestore dbFirestore = FirestoreClient.getFirestore();
	    	  
	    	    int numDigits = 8; // El número de dígitos del ID numérico
	    	    String numericId = generateNumericId(numDigits);

	    	    DocumentReference docRef = dbFirestore.collection("usuarios").document(numericId);
	    	    ApiFuture<WriteResult> writeResult = docRef.set(usuario);
	    	    
	    	    return writeResult.get().getUpdateTime().toString();
	    }
	    
	    private String generateNumericId(int numDigits) {
	        Random random = new Random();
	        int maxNumber = (int) Math.pow(10, numDigits) - 1;
	        int randomNumber = random.nextInt(maxNumber);
	        return String.format("%0" + numDigits + "d", randomNumber);
	    }
	    
	    public String eliminar(String id) {
	        Firestore dbFirestore = FirestoreClient.getFirestore();
	        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(id).delete();
	        return "Document with Patient ID "+id+" has been deleted";
	    }
	    

	    public Usuario getDetalleUsuario(String id) throws InterruptedException, ExecutionException {
	        Firestore dbFirestore = FirestoreClient.getFirestore();
	        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(id);
	        ApiFuture<DocumentSnapshot> future = documentReference.get();

	        DocumentSnapshot document = future.get();

	        Usuario usuario = null;

	        if(document.exists()) {
	        	usuario = document.toObject(Usuario.class);
	            return usuario;
	        }else {
	            return null;
	        }
	    }

	    public String updatePatientDetails(Usuario usuario) throws InterruptedException, ExecutionException {
	        Firestore dbFirestore = FirestoreClient.getFirestore();
	        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(usuario.getNombre()).set(usuario);
	        return collectionsApiFuture.get().getUpdateTime().toString();
	    }

	   


}
