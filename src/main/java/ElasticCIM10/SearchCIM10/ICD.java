package ElasticCIM10.SearchCIM10;

import java.io.Serializable;
import java.math.BigDecimal;

public class ICD implements Serializable{  
    private static final long serialVersionUID = 6934803011248581109L;  
    //疾病ID  
    private int id;  
    //疾病编码  
    private String code;  
    //疾病名称  
    private String diseaseName;  
    //疾病加拼音  
    private String mergeName;  
    //汉语拼音简拼  
    private String pinyin;  
    //是否恶心肿瘤  
    private boolean isTherioma;  
    //是否住院特殊病种  
    private boolean isSpecialDisease;  
      
    public ICD(BigDecimal id, String diseaseName, String code,  
            String pinyin, String isTherioma, String isSpecialDisease) {  
        this.id = id.intValue();  
        this.diseaseName = diseaseName;  
        this.code = code;  
        this.pinyin = pinyin;  
        if("是".equals(isTherioma)){  
            this.isTherioma = true;  
        }  
        else {  
            this.isTherioma = false;  
        }  
          
        if("是".equals(isSpecialDisease)){  
            this.isSpecialDisease = true;  
        }  
        else {  
            this.isSpecialDisease = false;  
        }  
        this.mergeName = diseaseName + "," + pinyin;  
    }

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the diseaseName
	 */
	public String getDiseaseName() {
		return diseaseName;
	}

	/**
	 * @param diseaseName the diseaseName to set
	 */
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	/**
	 * @return the mergeName
	 */
	public String getMergeName() {
		return mergeName;
	}

	/**
	 * @param mergeName the mergeName to set
	 */
	public void setMergeName(String mergeName) {
		this.mergeName = mergeName;
	}

	/**
	 * @return the pinyin
	 */
	public String getPinyin() {
		return pinyin;
	}

	/**
	 * @param pinyin the pinyin to set
	 */
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	/**
	 * @return the isTherioma
	 */
	public boolean isTherioma() {
		return isTherioma;
	}

	/**
	 * @param isTherioma the isTherioma to set
	 */
	public void setTherioma(boolean isTherioma) {
		this.isTherioma = isTherioma;
	}

	/**
	 * @return the isSpecialDisease
	 */
	public boolean isSpecialDisease() {
		return isSpecialDisease;
	}

	/**
	 * @param isSpecialDisease the isSpecialDisease to set
	 */
	public void setSpecialDisease(boolean isSpecialDisease) {
		this.isSpecialDisease = isSpecialDisease;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}  
    
      
} 
