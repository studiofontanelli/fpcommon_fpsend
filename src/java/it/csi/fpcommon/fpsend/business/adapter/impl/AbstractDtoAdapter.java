package it.csi.fpcommon.fpsend.business.adapter.impl;

import it.csi.fpcommon.fpsend.business.adapter.IDtoAdapter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.dozer.Mapper;

public abstract class AbstractDtoAdapter <T, V> implements IDtoAdapter<T, V> {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 228589063762261992L;
	private Mapper mapper;
	private Class<T> tClazz;
	private Class<V> vClazz;
	
	public AbstractDtoAdapter (Mapper mapper, Class<T> tClazz, Class<V> vClazz) {
		this.mapper = mapper;
		this.tClazz = tClazz;
		this.vClazz = vClazz;
	}
	
	/*
	 * (non-Javadoc)
	 * @see it.csi.stasp.stapoc.business.adapter.IDtoAdapter#convertTo(java.lang.Object)
	 */
	public V convertTo(T t) {
		V v = null;
		if(t != null) {
			v = mapper.map(t, vClazz);
		}
		return v;
	}
	
	/*
	 * (non-Javadoc)
	 * @see it.csi.stasp.stapoc.business.adapter.IDtoAdapter#convertTo(java.util.List)
	 */
	public List<V> convertTo(List<T> tList) {
		List<V> vList = null;
		if(!CollectionUtils.isEmpty(tList)) {
			vList = new ArrayList<V>();
			for (T t : tList) {
				vList.add(convertTo(t));
			}
		}
		return vList;
	}
	
	/*
	 * (non-Javadoc)
	 * @see it.csi.stasp.stapoc.business.adapter.IDtoAdapter#convertFrom(java.lang.Object)
	 */
	public T convertFrom(V v) {
		T t = null;
		if(v != null) {
			t = mapper.map(v, tClazz);
		}
		return t;
	}

	/*
	 * (non-Javadoc)
	 * @see it.csi.stasp.stapoc.business.adapter.IDtoAdapter#convertFrom(java.util.List)
	 */
	public List<T> convertFrom(List<V> vList) {
		List<T> tList = null;
		if(!CollectionUtils.isEmpty(vList)) {
			tList = new ArrayList<T>();
			for (V v : vList) {
				tList.add(convertFrom(v));
			}
		}
		return tList;
	}
	
}
