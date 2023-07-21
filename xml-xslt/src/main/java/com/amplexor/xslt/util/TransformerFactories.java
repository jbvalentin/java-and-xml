package com.amplexor.xslt.util;

public enum TransformerFactories {
	
	// org.apache.xalan.processor.TransformerFactoryImpl ou net.sf.saxon.TransformerFactoryImpl
	XALAN_TRANSFORMER_FACTORY("org.apache.xalan.processor.TransformerFactoryImpl"), 
	SAXON_TRANSFORMER_FACTORY("net.sf.saxon.TransformerFactoryImpl");
	
	private String factoryName;
	
	private TransformerFactories(String factoryName) {
		this.factoryName = factoryName;
	}
	
	@Override
	public String toString() {
		return factoryName;
	}
	

}
