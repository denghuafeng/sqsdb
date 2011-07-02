package com.sinovatech.common.config.bean;

public abstract class Property {
	//�����ļ�
	private String cfgName;
	//���ü�
	private String cfgKey;
	//	������ʾ��
	private String fdName;
	//����Label
	private String fdTypeLabel;
	//����value
	private String fdTypeValue = "";
	//��������
	private String fdTypeAttribute;
	
	//��������
	private String fdTypeName;
	
	//������ʾλ��
	private int fdTypeOrder;
	//ע��
	private String common;
	//script��У�����
	private String formScript;

	public Property(){
	}
	
	
	
	public int getFdTypeOrder() {
		return fdTypeOrder;
	}

	public void setFdTypeOrder(int fdTypeOrder) {
		this.fdTypeOrder = fdTypeOrder;
	}

	public String getFdTypeAttribute() {
		return fdTypeAttribute;
	}

	public void setFdTypeAttribute(String fdTypeAttribute) {
		this.fdTypeAttribute = fdTypeAttribute;
	}

	public String getFdTypeValue() {
		return fdTypeValue;
	}

	public void setFdTypeValue(String fdTypeValue) {
		this.fdTypeValue = fdTypeValue;
	}

	public String getFdTypeLabel() {
		return fdTypeLabel;
	}

	public void setFdTypeLabel(String fdTypeLabel) {
		this.fdTypeLabel = fdTypeLabel;
	}
	
	abstract public void buildFormField();

	public String getFdTypeName() {
		return fdTypeName;
	}

	public void setFdTypeName(String fdTypeName) {
		this.fdTypeName = fdTypeName;
	}

	public String getFdName() {
		return fdName;
	}

	public void setFdName(String fdName) {
		this.fdName = fdName;
	}
	
	/**
	 * @return the common
	 */
	public String getCommon() {
		return common;
	}



	/**
	 * @param common the common to set
	 */
	public void setCommon(String common) {
		this.common = common;
	}



	public String getFormScript() {
		return formScript;
	}

	public void setFormScript(String formScript) {
		this.formScript = formScript;
	}
	
	public String getFdTypeNameByStr( String fdName ){
		return "fd"+fdName;
	}
	
	public String getDealString( String s ){
		if( s==null )
			return "";
		else
			return s;
	}



	/**
	 * @return the cfgKey
	 */
	public String getCfgKey() {
		return cfgKey;
	}



	/**
	 * @param cfgKey the cfgKey to set
	 */
	public void setCfgKey(String cfgKey) {
		this.cfgKey = cfgKey;
	}



	/**
	 * @return the cfgName
	 */
	public String getCfgName() {
		return cfgName;
	}



	/**
	 * @param cfgName the cfgName to set
	 */
	public void setCfgName(String cfgName) {
		this.cfgName = cfgName;
	}
	
}
