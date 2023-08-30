package pgw.linhas.areas.pgwlinhasareas.util;

import org.springframework.beans.BeanUtils;

import javax.jws.Oneway;

public class Util {
    public Util() {
    }
    public Object copiarPropriedades(Object origem, Object destino){
        BeanUtils.copyProperties(origem, destino);
        return destino;
    }
}
