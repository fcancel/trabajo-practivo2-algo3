package fiuba.algo3.modelo.efectosYSorpresas;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import fiuba.algo3.modelo.serializacion.AdaptadorDeInterfaces;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.CuatroPorCuatro;
import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

@XmlJavaTypeAdapter(AdaptadorDeInterfaces.class)
public interface Efecto {

	void realizarEfecto(Moto moto, Vehiculo vehiculo);

	void realizarEfecto(Auto auto, Vehiculo vehiculo);

	void realizarEfecto(CuatroPorCuatro cuatroPorCuatro, Vehiculo vehiculo);

}
