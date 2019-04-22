package logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class OtiumApp 
{
	/**
	 * Constante con la direccion del JSON de ofertas.
	 */
	private static final String DIR_OFERTAS_JSON = "./data/ofertas.json";

	/**
	 * Constante con la direccion del JSON de habilidades.
	 */
	private static final String DIR_HABILIDADES_JSON = "./data/habilidades.json";

	/**
	 * Constante con la direccion del JSON de materias.
	 */
	private static final String DIR_MATERIAS_JSON = "./data/materias.json";

	/**
	 * Constante con la direccion del JSON de Usuarios.
	 */
	private static final String DIR_USUARIOS_JSON = "./data/usuarios.json";


	/**
	 * Usuario actual
	 */
	private Usuario currentUser;

	/**
	 * Lista de todas las ofertas
	 */
	private ArrayList<Oferta> allOfertas;

	
	/**
	 * Lista de todas las materias
	 */
	private ArrayList<Materia> materias;


	/**
	 * Lista de todas las habilidades
	 */
	private ArrayList<HabilidadBlanda> habilidades;
	
	/**
	 * Lista de todos los usuarios
	 */
	private ArrayList<Usuario> usuarios;

	public OtiumApp()
	{
		estadoInicialPruebas();
	}
	
	public ArrayList<Oferta> darOfertas()
	{
		return allOfertas;
	}
	
	/**
	 * 
	 */
	public  void cargarOfertas()
	{
		JSONParser parser = new JSONParser();
		allOfertas = new ArrayList<Oferta>();

		try {
			JSONObject objOfrt = (JSONObject) parser.parse(new FileReader(new File(DIR_OFERTAS_JSON)));

			JSONArray jsonObjectList = (JSONArray) objOfrt.get("Ofertas");
			Oferta nuevaOferta = null;

			for(int i = 0; jsonObjectList != null &&  i < jsonObjectList.size(); i++)	
			{
				ArrayList<Materia> materias = new ArrayList<Materia>();
				ArrayList<HabilidadBlanda> habilidades = new ArrayList<HabilidadBlanda>();
				JSONObject obj= (JSONObject) jsonObjectList.get(i);
				String titulo = "";
				if(obj.get("Titulo") != null )
				{
					titulo = obj.get("Titulo").toString();
				}

				double salario = 0.0;
				if(obj.get("Salario") != null )
				{
					salario = Double.parseDouble(obj.get("Salario").toString());

				}

				String descripcion = "";

				if(obj.get("Descripcion") != null )
				{
					descripcion = obj.get("Descripcion").toString();
				}

				String ubicacion = "";

				if(obj.get("Ubicacion") != null )
				{
					ubicacion = obj.get("Ubicacion").toString();
				}

				Empresa empresa = null;
				String nombreEmpresa = "";

				if(obj.get("Empresa") != null && obj.get("Ubicacion") != null )
				{
					nombreEmpresa = obj.get("Empresa").toString();
					ubicacion = obj.get("Ubicacion").toString();
					empresa = new Empresa(nombreEmpresa, ubicacion, "empresa@contacto.com");
				}

				String jornada = "";

				if(obj.get("Jornada") != null )
				{
					jornada = obj.get("Jornada").toString();
				}

				String requerimiento = "";

				if(obj.get("Requerimiento") != null )
				{
					requerimiento = obj.get("Requerimiento").toString();
				}

				JSONArray jsonMaterias = null;

				if(obj.get("Materias") != null )
				{
					jsonMaterias = (JSONArray) obj.get("Materias");

					for (Object object : jsonMaterias) {

						String nombreMateria = object.toString();
						Materia materia = darMateria(nombreMateria);
						materias.add(materia);
					}
				}

				JSONArray jsonHabilidades = null;

				if(obj.get("HabilidadesBlandas") != null )
				{
					jsonHabilidades = (JSONArray) obj.get("HabilidadesBlandas");

					for (Object object : jsonHabilidades) {
						String nombreHabilidad = object.toString();

						HabilidadBlanda habilidad = darHabilidad(nombreHabilidad);
						habilidades.add(habilidad);
					}
				}

				nuevaOferta = new Oferta(titulo, salario, descripcion, ubicacion, empresa, jornada, requerimiento);

				nuevaOferta.setMaterias(materias);
				nuevaOferta.setHabilidades(habilidades);
				allOfertas.add(nuevaOferta);




			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void crearUsuario(String pNombre, String pApellido, String pEmail, String pUserName, String pUniversidad, Date pFechaNac, String pContra, String pComentario, ArrayList<Materia> materias, ArrayList<HabilidadBlanda> habilidades )
	{
		Formulario formulario = new Formulario(pComentario);
		formulario.setHabilidades(habilidades);
		formulario.setMaterias(materias);
		currentUser = new Usuario(pUserName, pNombre, pApellido, pEmail, pUniversidad, pFechaNac, pContra, formulario);
	}
	/**
	 * Agrega un usuario a la lista de usuarios.
	 * Cada vez que se agrega un usuario se debe crear el archivo de nuevo
	 */
	public  void persistirUsuario(Usuario user)
	{
		usuarios.add(user);
		
		crearArchivoUsers();
	}
	
	
	/**
	 * Metodo para verificar los datos de inicio de sesion de un usuario
	 * Retorna true si la info es valida; False si no es valida
	 */
	public boolean iniciarSesion(String pUsuario, String pContrasenia)
	{
		boolean esValida = false;
		
		
		Usuario current = null;
		for (int i = 0; i < usuarios.size(); i++) {
			
			current = usuarios.get(i);
			if(current.getUsername().equals(pUsuario) && current.getContrasenia().equals(pContrasenia))
			{
				esValida = true;
			}
			
			
		}
		
		return esValida;
	}
	
	/**
	 * Crea el archivo json con todos los usuarios
	 */
	@SuppressWarnings("unchecked")
	public void crearArchivoUsers()
	{
		//Crea array de json objects(usuarios)
		JSONArray userList = new JSONArray();
		//Por cada usuario un objeto JSON
		for (Usuario usuario : usuarios) 
		{
			
			JSONObject userDetails = new JSONObject();
			
			userDetails.put("Username", usuario.getUsername());
			
			userDetails.put("Nombres", usuario.getNombres());
			
			userDetails.put("Apellidos", usuario.getApellidos());
			
			userDetails.put("Email", usuario.getEmail());
			
			userDetails.put("Universidad", usuario.getUniversidad());
			
			userDetails.put("Fecha Nacimiento",usuario.getFechaNacimiento().toString());
			
			userDetails.put("Contrasenia", usuario.getContrasenia());
			
			//Crea un objeto para la info del formulario
			JSONObject formDetails = new JSONObject();
			formDetails.put("Comentario", usuario.getFormulario().getComentario());
			
			//Array con las habilidades seleccionadas en el formulario
			JSONArray userHab = new JSONArray();
			
			for (HabilidadBlanda habilidad : usuario.getFormulario().getHabilidades()) {
				userHab.add(habilidad.getNombre());
			}
			//Array con las materias seleccionadas en el formulario
			JSONArray userMat = new JSONArray();
			for (Materia materia : usuario.getFormulario().getMaterias()) {
				userMat.add(materia.getNombre());
			}
			formDetails.put("Materias", userMat);
			formDetails.put("Habilidades", userHab);
			userDetails.put("Formulario", formDetails);
			
			userList.add(userDetails);
		}
		//Escribe el archivo con la lista de objetos
        try (FileWriter file = new FileWriter(DIR_USUARIOS_JSON)) {
        	 
            file.write(userList.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * Metodo para cargar los usuarios
	 */
	public void cargarUsuarios()
	{
		JSONParser parser = new JSONParser();
		usuarios = new ArrayList<Usuario>();
		
		try {
			
			JSONArray arrayUsuarios = (JSONArray) parser.parse(new FileReader(new File(DIR_USUARIOS_JSON)));
			Usuario user = null;
			ArrayList<HabilidadBlanda> habUser = new ArrayList<>();
			ArrayList<Materia> matUser = new ArrayList<>();
			Formulario formulario = null;
			for(int i = 0; arrayUsuarios != null && i < arrayUsuarios.size(); i++)
			{
				JSONObject obj = (JSONObject) arrayUsuarios.get(i);
				
				String username = "";
				if(obj.get("Username")!= null)
					username = obj.get("Username").toString();
				
				String nombres = "";
				if(obj.get("Nombres") != null)
					nombres = obj.get("Nombres").toString();
				
				String apellidos = "";
				if(obj.get("Apellidos") != null)
					apellidos = obj.get("Apellidos").toString();
				
				String email = "";
				if(obj.get("Email") != null)
					email = obj.get("Email").toString();
				
				String universidad = "";
				if(obj.get("Universidad") != null)
					universidad  = obj.get("Universidad").toString();
				
				Date fechaNacimiento = null;
				if(obj.get("Fecha Nacimiento") != null)
				{
					String fecha = obj.get("Fecha Nacimiento").toString();
					
					SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
					fechaNacimiento = formatter.parse(fecha);
				}
				
				String contrasenia =  "";
				if(obj.get("Contrasenia") != null)
					contrasenia = obj.get("Contrasenia").toString();
				
				JSONObject form = null;
				String comentario = "";
				if(obj.get("Formulario") != null)
				{
					form = (JSONObject) obj.get("Formulario");
					
					JSONArray habilidades = (JSONArray) form.get("Habilidades");
					HabilidadBlanda hab = null;
					for (Object object : habilidades) {
						
						hab = darHabilidad(object.toString());
						habUser.add(hab);
					}
					
					JSONArray materias = (JSONArray) form.get("Materias");
					Materia mat = null;
					for (Object object : materias) {
						
						mat = darMateria(object.toString());
						matUser.add(mat);
					}
					

					if(form.get("Comentario") != null)
						comentario = form.get("Comentario").toString();
					
				}
				
				formulario = new Formulario(comentario);
				
				user = new Usuario(username, nombres, apellidos, email, universidad, fechaNacimiento, contrasenia, formulario);
				user.getFormulario().setHabilidades(habUser);
				user.getFormulario().setMaterias(matUser);
				usuarios.add(user);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 
	 */
	public void cargarHabilidades()
	{
		JSONParser parser = new JSONParser();
		habilidades = new ArrayList<HabilidadBlanda>();
		try {

			JSONObject objHabilidades = (JSONObject) parser.parse(new FileReader(new File(DIR_HABILIDADES_JSON)));
			JSONArray jsonObjectList = (JSONArray) objHabilidades.get("Habilidades");
			HabilidadBlanda habilidad = null;

			for(int i = 0; jsonObjectList != null &&  i < jsonObjectList.size(); i++)	
			{

				String nombre = "";

				if(jsonObjectList.get(i) != null)
					nombre = (String) jsonObjectList.get(i);

				habilidad = new HabilidadBlanda(nombre);
				habilidades.add(habilidad);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * 
	 */
	public void cargarMaterias()
	{
		JSONParser parser = new JSONParser();
		materias = new ArrayList<Materia>();
		try {

			JSONObject objMaterias = (JSONObject) parser.parse(new FileReader(new File(DIR_MATERIAS_JSON)));
			JSONArray jsonObjectList = (JSONArray) objMaterias.get("Materias");
			Materia materia = null;

			for(int i = 0; jsonObjectList != null &&  i < jsonObjectList.size(); i++)	
			{

				String nombre = "";

				if(jsonObjectList.get(i) != null)
					nombre = (String) jsonObjectList.get(i);

				materia = new Materia(nombre);
				materias.add(materia);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para agregar una habilidad que el usuario selecciono en su formulario
	 * a su lista de habilidades
	 */
	public void agregarHabilidad(HabilidadBlanda habilidad)
	{
		currentUser.getFormulario().getHabilidades().add(habilidad);
	}

	/**
	 * Metodo para agregar una materia que el usuario selecciono en su formulario
	 * a su lista de materias
	 */
	public void agregarMateria(Materia materia)
	{
		currentUser.getFormulario().getMaterias().add(materia);
	}
	
	/**
	 * Metodo para obtener el usuario por username
	 */
	public Usuario getUsuario(String pUsername)
	{
		Usuario buscado = null;
		
		for (Usuario usuario : usuarios) {
			
			if(usuario.getUsername().equals(pUsername))
				buscado = usuario;
				
		}
		
		return buscado;
	}

	/**
	 * Metodo que retorna una lista con ofertas que hacen match.
	 * El metodo calcula el porcentaje de materias y habilidades minimas 
	 * para hacer "match" con una oferta laboral y  si se cumple el porcentaje, se agrega a la lista 
	 */
	public ArrayList<Oferta> calcularMatch(String username)
	{
		ArrayList<Oferta> matchOfertas = new ArrayList<Oferta>();
		int numSeleccionadas = 0;
		
		int totalOferta = 0;

		ArrayList<HabilidadBlanda> habilidadesUser = getUsuario(username).getFormulario().getHabilidades();
		ArrayList<Materia> materiasUser = getUsuario(username).getFormulario().getMaterias();

		for (Oferta oferta : allOfertas) {
			totalOferta = oferta.getMaterias().size() + oferta.getHabilidades().size();
			numSeleccionadas =0;
			
			for (Materia materia : materiasUser) {
				
				for (Materia materiaOfer : oferta.getMaterias()) {
					System.out.println(materia.getNombre());
					System.out.println(oferta.getMaterias().size());
					System.out.println(oferta.getTitulo());
					if(materiaOfer == null)
					{
						System.out.println("loopp");
					}
					System.out.println(materiaOfer.getNombre());
					if(materia.getNombre().equals(materiaOfer.getNombre()))
					{
						numSeleccionadas++;
					}
					
				}

			}
			for (HabilidadBlanda habilidad : habilidadesUser) {

				for (HabilidadBlanda habilidadOfer : oferta.getHabilidades()) {
					if(habilidad.getNombre().equals(habilidadOfer.getNombre()))
					{
						numSeleccionadas++;
					}

				}
			}
			int calculoAct = (numSeleccionadas*100)/totalOferta;
//			System.out.println("numero Selec: " + numSeleccionadas);
//			System.out.println("totalOfer: " + totalOferta);
//			System.out.println("Calculo act: " + calculoAct);
			if(calculoAct>= 50)
			{

				matchOfertas.add(oferta);
			}
		}
		
		return matchOfertas;

	}

	/**
	 * Metodo que encuentra una materia con el nombre dado por parametro
	 */
	public Materia darMateria(String pNombre)
	{
		Materia buscada = null;
		String nombre = "";
		for (int i = 0; i < materias.size(); i++) {

			Materia act = materias.get(i);
			nombre = act.getNombre();

			if(nombre.equals(pNombre))
			{
				buscada = act;
			}

		}

		return buscada;
	}

	/**
	 * Metodo que encuentra una habilidad con el nombre dado por parametro
	 */
	public HabilidadBlanda darHabilidad(String pNombre)
	{
		HabilidadBlanda buscada = null;
		String nombre = "";
		for (int i = 0; i < habilidades.size(); i++) {

			HabilidadBlanda act = habilidades.get(i);
			nombre = act.getNombre();

			if(nombre.equals(pNombre))
			{
				buscada = act;
			}

		}

		return buscada;
	}

	/**
	 * 
	 */
	public void estadoInicialPruebas() 
	{

		cargarHabilidades();
		cargarMaterias();
		cargarOfertas();
		cargarUsuarios();
		System.out.println("no user: " + usuarios.size());
//		System.out.println("funciono!!!");
	System.out.println(allOfertas.size());
		
		for (Oferta act : allOfertas) {

			System.out.println("titulo: "+ act.getTitulo());
			System.out.println("salario: "+ act.getSalario());
			System.out.println("descripcion: "+ act.getDescripcion());
			System.out.println("Ubicacion: " + act.getUbicacion());
			System.out.println("Empresa: "+ act.getEmpresa().getNombre());
			System.out.println("Jornada: " + act.getJornada());
			System.out.println("Requerimiento: "+ act.getRequerimiento());
			System.out.println("# materias: " + act.getMaterias().size());
			System.out.println("# habilidas: " + act.getHabilidades().size());
			for (Materia materia : act.getMaterias()) {

				System.out.println("Materia: "+ materia.getNombre());
			}

			for (HabilidadBlanda habilidad : act.getHabilidades()) {

				System.out.println("Habilidad: "+ habilidad.getNombre());
			}
		}
		
//			Formulario newForm = new Formulario("nada jeje");
//			
//			currentUser = new Usuario("d", "a", "m", "n", "b", new Date(150), "y", newForm);
//			persistirUsuario(currentUser);
//			currentUser.getFormulario().getMaterias().add(darMateria("Matemática Estructural"));
//			currentUser.getFormulario().getMaterias().add(darMateria("Infraestructura Computacional"));
//			currentUser.getFormulario().getMaterias().add(darMateria("Sistemas Transaccionales"));
//			currentUser.getFormulario().getHabilidades().add(darHabilidad("Escritura"));
//			currentUser.getFormulario().getHabilidades().add(darHabilidad("Trabajo en equipo"));
//			currentUser.getFormulario().getHabilidades().add(darHabilidad("Comunicación"));
			
		/**	ArrayList<Oferta> oferSuggest = calcularMatch();
			System.out.println("-----------------------------------SOY UN SEPARADOR-------------------------------------");
			System.out.println(oferSuggest.size());
			for (Oferta oferta : oferSuggest) {
				System.out.println("titulo: "+ oferta.getTitulo());
				System.out.println("salario: "+ oferta.getSalario());
				System.out.println("descripcion: "+ oferta.getDescripcion());
				System.out.println("Ubicacion: " + oferta.getUbicacion());
				System.out.println("Empresa: "+ oferta.getEmpresa().getNombre());
				System.out.println("Jornada: " + oferta.getJornada());
				System.out.println("Requerimiento: "+ oferta.getRequerimiento());
				System.out.println("# materias: " + oferta.getMaterias().size());
				System.out.println("# habilidas: " + oferta.getHabilidades().size());
			}*/
		
	}
	

}
