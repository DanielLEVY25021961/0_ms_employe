package levy.daniel.application.model.persistence.metier.employe.entities.jpa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.employe.IEmploye;

/**
 * CLASSE Employe :<br/>
 * .<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author Daniel Lévy
 * @version 1.0
 * @since 7 nov. 2020
 */
public class Employe implements IEmploye {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ';'.<br/>
	 */
	public static final char POINT_VIRGULE = ';';
	
	/**
	 * ", ".<br/>
	 */
	public static final String VIRGULE_ESPACE = ", ";
	
	/**
	 * "null".<br/>
	 */
	public static final String NULL = "null";
	
	/**
	 * "unused".<br/>
	 */
	public static final String UNUSED = "unused";
	
	/**
	 * id en base.<br/>
	 */
	private Long id;
	
	/**
	 * code métier de l'employé.
	 */
	private String code;
	
	/**
	 * civilité de l'employé (M, F, ...).
	 */
	private String civilite;
	
	/**
	 * prénom de l'employé.
	 */
	private String prenom;
	
	/**
	 * nom de l'employé.
	 */
	private String nom;

	/**
	 * date de naissance de l'employé.
	 */
	private LocalDate dateNaissance;

	/**
	 * LOG : Log : Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(Employe.class);

	// *************************METHODES************************************/

	
	
	/**
	 * CONSTRUCTEUR D'ARITE NULLE.
	 */
	public Employe() {
		this(null, null, null, null, null, null);
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	

	/**
	 * CONSTRUCTEUR COMPLET
	 * 
	 * @param pCode : String : code métier de l'employé.
	 * @param pCivilite : String : 
	 * civilité de l'employé (M., Mme, Mlle, ...).
	 * @param pPrenom : String : 
	 * prénom de l'employé.<br/>
	 * @param pNom : String : 
	 * nom de l'employé.<br/>
	 * @param pDateNaissance : java.time.LocalDate : 
	 * date de naissance de l'employé.
	 */
	public Employe(
			final String pCode
				, final String pCivilite
					, final String pPrenom
						, final String pNom
							, final LocalDate pDateNaissance) {
		
		this(null, pCode, pCivilite, pPrenom, pNom, pDateNaissance);
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	/**
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 *
	 * @param pId : Long : 
	 * ID en base.
	 * @param pCode : String : code métier de l'employé.
	 * @param pCivilite : String : 
	 * civilité de l'employé (M., Mme, Mlle, ...).
	 * @param pPrenom : String : 
	 * prénom de l'employé.<br/>
	 * @param pNom : String : 
	 * nom de l'employé.<br/>
	 * @param pDateNaissance : java.time.LocalDate : 
	 * date de naissance de l'employé.
	 */
	public Employe(
			final Long pId
				, final String pCode
					, final String pCivilite
						, final String pPrenom
							, final String pNom
								, final LocalDate pDateNaissance) {
		
		super();
		
		this.id = pId;
		this.code = pCode;
		this.civilite = pCivilite;
		this.prenom = pPrenom;
		this.nom = pNom;
		this.dateNaissance = pDateNaissance;
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________

	
	
	/**
	* {@inheritDoc}
	*/
	@Override
	public final int hashCode() {
		return Objects.hash(this.getCode());
	} // Fin de hashCode().________________________________________________



	/**
	* {@inheritDoc}
	*/
	@Override
	public final boolean equals(final Object pObjet) {
		
		if (this == pObjet) {
			return true;
		}
		
		if (!(pObjet instanceof IEmploye)) {
			return false;
		}
		
		final IEmploye other = (IEmploye) pObjet;
		
		return Objects.equals(this.getCode(), other.getCode());
		
	} // Fin de equals(...)._______________________________________________



	/**
	* {@inheritDoc}
	*/
	@Override
	public final int compareTo(final IEmploye pObjet) {
		
		if (this == pObjet) {
			return 0;
		}

		if (pObjet == null) {
			return -1;
		}

		int compareNom = 0;
		int comparePrenom = 0;
		int compareDateNaissance = 0;
		int compareCode = 0;
		
		/* nom. */
		if (this.getNom() == null) {
			if (pObjet.getNom() != null) {
				return +1;
			}
		} else {
			
			if (pObjet.getNom() == null) {
				return -1;
			}
			
			compareNom 
			= this.getNom().compareToIgnoreCase(pObjet.getNom());
		
			if (compareNom != 0) {
				return compareNom;
			}
		}
				
		/* prenom. */
		if (this.getPrenom() == null) {
			if (pObjet.getPrenom() != null) {
				return +1;
			}
		} else {
			
			if (pObjet.getPrenom() == null) {
				return -1;
			}
			
			comparePrenom 
			= this.getPrenom().compareToIgnoreCase(pObjet.getPrenom());
		
			if (comparePrenom != 0) {
				return comparePrenom;
			}
		}
		
		
		/* dateNaissance. */
		if (this.getDateNaissance() == null) {
			if (pObjet.getDateNaissance() != null) {
				return +1;
			}
		} else {
			
			if (pObjet.getDateNaissance() == null) {
				return -1;
			}
			
			compareDateNaissance 
			= this.getDateNaissance().compareTo(pObjet.getDateNaissance());
		
			if (compareDateNaissance != 0) {
				return compareDateNaissance;
			}
		}
		
		/* code. */
		if (this.getCode() == null) {
			if (pObjet.getCode() != null) {
				return +1;
			}
			
			return 0;
		}
		
		if (pObjet.getCode() == null) {
			return -1;
		}
		
		compareCode 
			= this.getCode().compareToIgnoreCase(pObjet.getCode());
		
		return compareCode;

	} // Fin de compareTo(...).____________________________________________

	
	
	/**
	* {@inheritDoc}
	*/
	@Override
	public final Employe clone() throws CloneNotSupportedException {
		
		final IEmploye clone 
			= (IEmploye) super.clone();
				
		clone.setId(this.getId());
		clone.setCode(this.getCode());
		clone.setCivilite(this.getCivilite());
		clone.setPrenom(this.getPrenom());
		clone.setNom(this.getNom());
		clone.setDateNaissance(this.getDateNaissance());
		
		return (Employe) clone;
		
	} // Fin de clone().___________________________________________________

	
	
	/**
	* {@inheritDoc}
	*/
	@Override
	public final String toString() {
		
		final StringBuilder builder = new StringBuilder();
		
		builder.append("Employe [");
		
		builder.append("id=");
		if (this.getId() != null) {			
			builder.append(this.getId());
		} else {
			builder.append(NULL);
		}
		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("code=");
		if (this.getCode() != null) {			
			builder.append(this.getCode());
		} else {
			builder.append(NULL);
		}
		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("civilite=");
		if (this.getCivilite() != null) {			
			builder.append(this.getCivilite());
		} else {
			builder.append(NULL);
		}
		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("prenom=");
		if (this.getPrenom() != null) {			
			builder.append(this.getPrenom());
		} else {
			builder.append(NULL);
		}
		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("nom=");
		if (this.getNom() != null) {			
			builder.append(this.getNom());
		} else {
			builder.append(NULL);
		}
		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("dateNaissance=");
		if (this.getDateNaissance() != null) {
			
			/* formateur pour LocalDate */
			/* format java.time.LocalDate */
			final DateTimeFormatter dateFormatter 
				= DateTimeFormatter.ofPattern(
						"dd/MM/yyyy", Locale.getDefault());
			
			builder.append(this.getDateNaissance().format(dateFormatter));
			
		} else {
			builder.append(NULL);
		}
		
		builder.append(']');
		
		return builder.toString();
		
	} // Fin de toString().________________________________________________



	/**
	* {@inheritDoc}
	*/
	@Override
	public final String fournirEnTeteCsv() {
		return "id;code;civilite;prenom;nom;dateNaissance;";
	} // Fin de fournirEnTeteCsv().________________________________________

	
	
	/**
	* {@inheritDoc}
	*/
	@Override
	public final String fournirStringCsv() {
		
		final StringBuilder stb = new StringBuilder();

		stb.append(this.getId());
		stb.append(POINT_VIRGULE);
		stb.append(this.getCode());
		stb.append(POINT_VIRGULE);
		stb.append(this.getCivilite());
		stb.append(POINT_VIRGULE);
		stb.append(this.getPrenom());
		stb.append(POINT_VIRGULE);
		stb.append(this.getNom());
		stb.append(POINT_VIRGULE);
		
		if (this.getDateNaissance() != null) {
			
			/* formateur pour LocalDate */
			/* format java.time.LocalDate */
			final DateTimeFormatter dateFormatter 
				= DateTimeFormatter.ofPattern(
						"dd/MM/yyyy", Locale.getDefault());
			
			stb.append(this.getDateNaissance().format(dateFormatter));
			
		} else {
			stb.append(NULL);
		}		
		stb.append(POINT_VIRGULE);
				
		return stb.toString();
		
	} // Fin de fournirStringCsv().________________________________________

	
	
	/**
	* {@inheritDoc}
	*/
	@Override
	public final String fournirEnTeteColonne(final int pI) {
		
		String entete = null;

		switch (pI) {

		case 0:
			entete = "id";
			break;

		case 1:
			entete = "code";
			break;
			
		case 2:
			entete = "civilité";
			break;

		case 3:
			entete = "prénom";
			break;

		case 4:
			entete = "nom";
			break;
			
		case 5:
			entete = "dateNaissance";
			break;
			
		default:
			entete = "invalide";
			break;

		} // Fin du Switch._________________________________

		return entete;

	} // Fin de fournirEnTeteColonne(...)._________________________________

	
	
	/**
	* {@inheritDoc}
	*/
	@Override
	public final Object fournirValeurColonne(final int pI) {
		
		Object valeur = null;

		switch (pI) {

		case 0:
			if (this.getId() != null) {
				valeur = String.valueOf(this.getId());
			}
			break;

		case 1:
			valeur = this.getCode();
			break;
			
		case 2:
			valeur = this.getCivilite();
			break;

		case 3:
			valeur = this.getPrenom();
			break;

		case 4:
			valeur = this.getNom();
			break;

		case 5:
			if (this.getDateNaissance() != null) {
								
				/* formateur pour LocalDate */
				/* format java.time.LocalDate */
				final DateTimeFormatter dateFormatter 
					= DateTimeFormatter.ofPattern(
							"dd/MM/yyyy", Locale.getDefault());

				valeur = this.getDateNaissance().format(dateFormatter);
			}
			
			break;
			
		default:
			valeur = "invalide";
			break;

		} // Fin du Switch._________________________________

		return valeur;

	} // Fin de fournirValeurColonne(...)._________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Long getId() {	
		return this.id;
	} // Fin de getId().___________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setId(
			final Long pId) {	
		this.id = pId;
	} // Fin de setId(...).________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getCode() {
		return this.code;
	} // Fin de getCode()._________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setCode(final String pCode) {
		this.code = pCode;
	} // Fin de setCode(...).______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getCivilite() {
		return this.civilite;
	} // Fin de getCivilite()._____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setCivilite(
			final String pCivilite) {
		this.civilite = pCivilite;
	} // Fin de setCivilite(...).__________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getPrenom() {
		return this.prenom;
	} // Fin de getPrenom()._______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setPrenom(
			final String pPrenom) {
		this.prenom = pPrenom;
	} // Fin de setPrenom(...).____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getNom() {
		return this.nom;
	} // Fin de getNom().__________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setNom(
			final String pNom) {
		this.nom = pNom;
	} // Fin de setNom(...)._______________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final LocalDate getDateNaissance() {
		return this.dateNaissance;
	} // Fin de getDateNaissance().________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setDateNaissance(final LocalDate pDateNaissance) {
		this.dateNaissance = pDateNaissance;
	} // Fin de setDateNaissance(...)._____________________________________
	
		

} // FIN DE LA CLASSE Employe.-----------------------------------------------
