package fiuba.algo3.modelo.serializacion;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class AdaptadorDeInterfaces extends XmlAdapter<Object,Object> {
	public Object unmarshal(Object v) { return v; }
	public Object marshal(Object v) { return v; }
}
