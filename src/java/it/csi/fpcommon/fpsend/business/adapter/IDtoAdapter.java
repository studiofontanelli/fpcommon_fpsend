package it.csi.fpcommon.fpsend.business.adapter;


import it.csi.fpcommon.fpsend.exception.fpsend.DtoConversionException;

import java.io.Serializable;
import java.util.List;

public interface IDtoAdapter <T,V> extends Serializable {
    
    public static final String LOGGER_PREFIX = "fpsend.adapter";
    
    public V convertTo(T t) throws DtoConversionException ;
    
    public T convertFrom(V v) throws DtoConversionException ;
    
    public List<V> convertTo(List<T> tList) throws DtoConversionException ;
    
    public List<T> convertFrom(List<V> vList) throws DtoConversionException ;
    
}