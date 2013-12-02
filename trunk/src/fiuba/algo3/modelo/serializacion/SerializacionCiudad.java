package fiuba.algo3.modelo.serializacion;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import fiuba.algo3.modelo.dificultad.Dificil;
import fiuba.algo3.modelo.dificultad.Facil;
import fiuba.algo3.modelo.dificultad.Moderado;
import fiuba.algo3.modelo.efectosYSorpresas.ControlPolicial;
import fiuba.algo3.modelo.efectosYSorpresas.Piquete;
import fiuba.algo3.modelo.efectosYSorpresas.Pozo;
import fiuba.algo3.modelo.efectosYSorpresas.ProbabilidadEquiprobable;
import fiuba.algo3.modelo.efectosYSorpresas.ProbabilidadEstatica;
import fiuba.algo3.modelo.efectosYSorpresas.SorpresaCambioDeVehiculo;
import fiuba.algo3.modelo.efectosYSorpresas.SorpresaDesfavorable;
import fiuba.algo3.modelo.efectosYSorpresas.SorpresaFavorable;
import fiuba.algo3.modelo.mapa.Ciudad;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.CuatroPorCuatro;
import fiuba.algo3.modelo.vehiculo.Moto;

public class SerializacionCiudad {

	public void serializar(Ciudad ciudad, String nombreArchivo) throws JAXBException{
		File file = new File(nombreArchivo);
		JAXBContext jaxbContext = JAXBContext.newInstance(Ciudad.class,SorpresaFavorable.class,
				SorpresaDesfavorable.class,SorpresaCambioDeVehiculo.class,Pozo.class,Piquete.class,
				ControlPolicial.class,Facil.class,Moderado.class,Dificil.class,Moto.class,
				Auto.class,CuatroPorCuatro.class,ProbabilidadEstatica.class,ProbabilidadEquiprobable.class);

		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(ciudad, file);
	}
	
	public Ciudad desSerealizar (String archivo) throws JAXBException{
		File file = new File(archivo);
		JAXBContext jaxbContext = JAXBContext.newInstance(Ciudad.class,SorpresaFavorable.class,
				SorpresaDesfavorable.class,SorpresaCambioDeVehiculo.class,Pozo.class,Piquete.class,
				ControlPolicial.class,Facil.class,Moderado.class,Dificil.class,Moto.class,
				Auto.class,CuatroPorCuatro.class,ProbabilidadEstatica.class,ProbabilidadEquiprobable.class);
 
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Ciudad ciudad = (Ciudad) jaxbUnmarshaller.unmarshal(file);
		return ciudad;
	}
}
