package ElasticCIM10.SearchCIM10;
import java.io.Serializable;
public class ICD_TS implements Serializable{
	private static final long serialVersionUID = 6934803011248581109L; 
	private int id;
	private String CIMO3_CUI_UMLS;
	private String libelle_en;
	private String CIM10;
	private String libelle_fr;
	/**
	 * @param id
	 * @param cIMO3_CUI_UMLS
	 * @param libelle_en
	 * @param cIM10
	 * @param libelle_fr
	 */
	public ICD_TS(int id, String cIMO3_CUI_UMLS, String libelle_en, String cIM10, String libelle_fr) {
		super();
		this.id = id;
		CIMO3_CUI_UMLS = cIMO3_CUI_UMLS;
		this.libelle_en = libelle_en;
		CIM10 = cIM10;
		this.libelle_fr = libelle_fr;
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
	 * @return the cIMO3_CUI_UMLS
	 */
	public String getCIMO3_CUI_UMLS() {
		return CIMO3_CUI_UMLS;
	}
	/**
	 * @param cIMO3_CUI_UMLS the cIMO3_CUI_UMLS to set
	 */
	public void setCIMO3_CUI_UMLS(String cIMO3_CUI_UMLS) {
		CIMO3_CUI_UMLS = cIMO3_CUI_UMLS;
	}
	/**
	 * @return the libelle_en
	 */
	public String getLibelle_en() {
		return libelle_en;
	}
	/**
	 * @param libelle_en the libelle_en to set
	 */
	public void setLibelle_en(String libelle_en) {
		this.libelle_en = libelle_en;
	}
	/**
	 * @return the cIM10
	 */
	public String getCIM10() {
		return CIM10;
	}
	/**
	 * @param cIM10 the cIM10 to set
	 */
	public void setCIM10(String cIM10) {
		CIM10 = cIM10;
	}
	/**
	 * @return the libelle_fr
	 */
	public String getLibelle_fr() {
		return libelle_fr;
	}
	/**
	 * @param libelle_fr the libelle_fr to set
	 */
	public void setLibelle_fr(String libelle_fr) {
		this.libelle_fr = libelle_fr;
	}


}
