package formulario;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;

import org.json.*;
import org.json.simple.*;
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
	 * Usuario actual
	 */
	private static Usuario currentUser;

	/**
	 * Lista de todas las ofertas
	 */
	private static ArrayList<Oferta> allOfertas;

	
	/**
	 * Lista de todas las materias
	 */
	private static ArrayList<Materia> materias;


	/**
	 * Lista de todas las habilidades
	 */
	private static ArrayList<HabilidadBlanda> habilidades;


	/**
	 * 
	 */
	public static void cargarOfertas()
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

	/**
	 * 
	 */
	public static void cargarHabilidades()
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
	public static void cargarMaterias()
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
	 * Metodo que retorna una lista con ofertas que hacen match.
	 * El metodo calcula el porcentaje de materias y habilidades minimas 
	 * para hacer "match" con una oferta laboral y  si se cumple el porcentaje, se agrega a la lista 
	 */
	public static ArrayList<Oferta> calcularMatch()
	{
		ArrayList<Oferta> matchOfertas = new ArrayList<Oferta>();
		int numSeleccionadas = 0;
		
		int totalOferta = 0;

		ArrayList<HabilidadBlanda> habilidadesUser = currentUser.getFormulario().getHabilidades();
		ArrayList<Materia> materiasUser = currentUser.getFormulario().getMaterias();

		for (Oferta oferta : allOfertas) {
			totalOferta = oferta.getMaterias().size() + oferta.getHabilidades().size();
			numSeleccionadas =0;
			
			for (Materia materia : materiasUser) {
				
				for (Materia materiaOfer : oferta.getMaterias()) {

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
			System.out.println("numero Selec: " + numSeleccionadas);
			System.out.println("totalOfer: " + totalOferta);
			System.out.println("Calculo act: " + calculoAct);
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
	public static Materia darMateria(String pNombre)
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
	public static HabilidadBlanda darHabilidad(String pNombre)
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
	public static void main(String[] args) {

		cargarHabilidades();
		cargarMaterias();
		cargarOfertas();
		System.out.println("funciono!!!");
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
			Formulario newForm = new Formulario("nada jeje");
			currentUser = new Usuario("d", "a", "m", "n", "b", new Date(150), "y", newForm);
			currentUser.getFormulario().getMaterias().add(darMateria("Matemática Estructural"));
			currentUser.getFormulario().getMaterias().add(darMateria("Infraestructura Computacional"));
			currentUser.getFormulario().getMaterias().add(darMateria("Sistemas Transaccionales"));
			currentUser.getFormulario().getHabilidades().add(darHabilidad("Escritura"));
			currentUser.getFormulario().getHabilidades().add(darHabilidad("Trabajo en equipo"));
			currentUser.getFormulario().getHabilidades().add(darHabilidad("Comunicación"));
			ArrayList<Oferta> oferSuggest = calcularMatch();
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
			}
		
	}

}
