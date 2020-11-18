package levy.daniel.application.model.metier.employe;

import java.io.Serializable;
import java.time.LocalDate;

import levy.daniel.application.model.metier.IExportateurCsv;
import levy.daniel.application.model.metier.IExportateurJTable;

/**
 * INTERFACE IEmploye :<br/>
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
public interface IEmploye extends Comparable<IEmploye>
	, Serializable, Cloneable
		, IExportateurCsv, IExportateurJTable {

	
	
	/**
	* {@inheritDoc}<br/>
	* <br/>
	* HashCode et Equals sur (UNICITE METIER) :
	* <ol>
	* <li>code</li>
	* </ol>
	*/
	@Override
	int hashCode();



	/**
	* {@inheritDoc}<br/>
	* <br/>
	* HashCode et Equals sur (UNICITE METIER) :
	* <ol>
	* <li>code</li>
	* </ol>
	*/
	@Override
	boolean equals(Object pObjet);

	
	
	/**
	 * {@inheritDoc}<br/>
	 * <br/>
	 * Comparaison sur :
	 * <ol>
	 * <li>nom</li>
	 * <li>prenom</li>
	 * <li>dateNaissance</li>
	 * <li>code</li>
	 * </ol>
	 */
	@Override
	int compareTo(IEmploye pObjet);
	
	
	
	/**
	 * retourne un clone du présent objet métier.
	 * 
	 * @return IEmploye : Clone. 
	 * @throws CloneNotSupportedException 
	 */
	IEmploye clone()   // NOPMD by dan on 07/11/2020 03:40
				throws CloneNotSupportedException;



	/**
	 * {@inheritDoc}
	 * <b>enTete CSV pour un IEmploye</b> :<br/>
	 * "id;code;civilite;prenom;nom;dateNaissance;".<br/>
	 * <br/>
	 */
	@Override
	String fournirEnTeteCsv();



	/**
	 * {@inheritDoc}
	 * <b>enTete CSV pour un IEmploye</b> :<br/>
	 * "id;code;civilite;prenom;nom;dateNaissance;".<br/>
	 * <br/>
	 */
	@Override
	String fournirStringCsv();



	/**
	 * {@inheritDoc}
	 * <b>enTete CSV pour un IEmploye</b> :<br/>
	 * "id;code;civilite;prenom;nom;dateNaissance;".<br/>
	 * <br/>
	 */
	@Override
	String fournirEnTeteColonne(int pI);



	/**
	 * {@inheritDoc}
	 * <b>enTete CSV pour un IEmploye</b> :<br/>
	 * "id;code;civilite;prenom;nom;dateNaissance;".<br/>
	 * <br/>
	 */
	@Override
	Object fournirValeurColonne(int pI);



	/**
	 * {@inheritDoc}
	 */
	@Override
	String toString();
	


	/**
	 * Getter de id en base.
	 *
	 * @return <code>this.id</code> : Long.
	 */
	Long getId();


	
	/**
	 * Setter de id en base.
	 *
	 * @param pId : Long :
	 * valeur à passer à <code>this.id</code>.
	 */
	void setId(Long pId);

	
	
	/**
	 * Getter du code métier de l'employé.
	 * 
	 * @return <code>this.code</code> : String.<br/>
	 */
	String getCode();
	
	
	/**
	 * Setter du code métier de l'employé.
	 * 
	 * @param pCode : String :
	 * valeur à passer à <code>this.code</code>.<br/>
	 */
	void setCode(String pCode);
	
	
	/**
	 * Getter de la civilité de l'employe (M, F, ...).<br/>
	 *
	 * @return <code>this.civilite</code> : String.<br/>
	 */
	String getCivilite();

	
	
	/**
	* Setter de la civilité de l'employé (M, F, ...).<br/>
	*
	* @param pCivilite : String : 
	* valeur à passer à <code>this.civilite</code>.<br/>
	*/
	void setCivilite(String pCivilite);

	
	
	/**
	 * Getter du prénom de l'employé.<br/>
	 *
	 * @return <code>this.prenom</code> : String.<br/>
	 */
	String getPrenom();

	
	
	/**
	* Setter du prénom de l'employé.<br/>
	*
	* @param pPrenom : String : 
	* valeur à passer à <code>this.prenom</code>.<br/>
	*/
	void setPrenom(String pPrenom);



	/**
	 * Getter de nom de l'employé.
	 *
	 * @return <code>this.nom</code> : String
	 */
	String getNom();



	/**
	 * Setter de nom de l'employé.
	 *
	 * @param pNom : String :
	 * valeur à passer à <code>this.nom</code>.
	 */
	void setNom(String pNom);



	/**
	 * Getter de la date de naissance de l'employé.
	 *
	 * @return <code>this.dateNaissance</code> : java.time.LocalDate
	 */
	LocalDate getDateNaissance();



	/**
	 * Setter de la date de naissance de l'employé.
	 *
	 * @param pDateNaissance : java.time.LocalDate :
	 * valeur à passer à <code>this.dateNaissance</code>.
	 */
	void setDateNaissance(LocalDate pDateNaissance);
	
	

} // FIN DE L'INTERFACE IEmploye.--------------------------------------------
