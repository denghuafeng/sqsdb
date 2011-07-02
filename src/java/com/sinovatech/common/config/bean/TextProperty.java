package com.sinovatech.common.config.bean;


public class TextProperty extends Property{
	//���ַ���������ַ���
	private String smallStrFDStr;
	//scriptУ�����
	private String smallStrFormScript;

	public TextProperty(){}
	
	public TextProperty( String fdName,String fdTypeValue,String fdTypeAttribute,String fdTypeName,int fdTypeOrder ){
		this.setFdName( fdName );
		this.setFdTypeValue( fdTypeValue );
		this.setFdTypeAttribute( fdTypeAttribute );
		this.setFdTypeName( fdTypeName );
		this.setFdTypeOrder( fdTypeOrder ); 
		buildFormField();
	}
        
	public void buildFormField() {  
		smallStrFDStr = "<input type=\"text\" ";
		smallStrFDStr += "name=\""+getFdTypeName()+"\" ";
		smallStrFDStr += "value=\""+this.getFdTypeValue()+"\" ";
		smallStrFDStr += "class=\"input3\" ";
		smallStrFDStr += "style=\"width:300 \" ";
		smallStrFDStr += ""+getDealString(this.getFdTypeAttribute())+"";
		smallStrFDStr += ">";
		this.setFdTypeLabel( smallStrFDStr );	    
		smallStrFormScript = "if( !checkLeng(configForm."+getFdName()+",0,100,true,\""+this.getFdName()+"\") ){";
		smallStrFormScript += " return false;";
		smallStrFormScript += "}";
		this.setFormScript( smallStrFormScript );
	}


}
