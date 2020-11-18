package levy.daniel.application.model.persistence.metier.employe.entities.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import levy.daniel.application.model.metier.employe.IEmploye;


/**
 * CLASSE EmployeTest :<br/>
 * Test JUnit 5 JUPITER de la classe ENTITY JPA 
 * {@link levy.daniel.application.model.persistence.metier.employe.entities.jpa.Employe}.<br/>
 * <ul>
 * <li>Test JUnit 5 JUPITER d'un <strong>ENTITY JPA</strong>.</li>
 * <li>Assure une bonne <strong>couverture du code par les tests via JaCoCo 
 * (EclLemma dans ECLIPSE)</strong>.</li>
 * <li>Vérifie les constructeurs de la classe Objet Metier.</li>
 * <li>Vérifie tous les contrats Java de la méthode equals(...)</li>
 * <li>Vérifie tous les contrats Java de la méthode hashCode()</li>
 * <li>Vérifie tous les contrats Java de la méthode compareTo()</li>
 * <li>Vérifie tous les contrats Java de la méthode clone()</li>
 * <li>vérifie toString()</li>
 * <li>vérifie fournirEnTeteCsv()</li>
 * <li>vérifie fournirStringCsv()</li>
 * <li>vérifie fournirEnTeteColonne()</li>
 * <li>vérifie fournirValeurColonne()</li>
 * </ul>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * <ul>
 * <li>String.format(...)</li>
 * <li>Math.signum(...), signe d'une fonction, </li>
 * </ul>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author Daniel Lévy
 * @version 1.0
 * @since 15 nov. 2020
 */
public class EmployeTest {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * Boolean qui commande l'affichage pour tous les tests.
	 */
	public static final Boolean AFFICHAGE_GENERAL = true;
	
	/**
	 * "unused".
	 */
	public static final String UNUSED = "unused";
	
	/**
	 * "===============================================".
	 */
	public static final String TIRETS 
	= "===============================================";

	/**
	 * "%1$-20s %2$-100s %3$-25s %4$-120s"
	 */
	public static final String FORMAT_STRING 
		= "%1$-20s %2$-100s %3$-25s %4$-120s";
	
	/**
	 * "testEquals()".
	 */
	public static final String TEST_EQUALS 
		= "testEquals()";
		
	/**
	 * "testCompareTo()".
	 */
	public static final String TEST_COMPARETO 
		= "testCompareTo()";
	
	/**
	 * "testClone()".
	 */
	public static final String TEST_CLONE 
		= "testClone()";
	
	/**
	 * "testToString()".
	 */
	public static final String TEST_TOSTRING 
		= "testToString()";
		
	/**
	 * "testFournirEnTeteCsv()".
	 */
	public static final String TEST_FOURNIRENTETECSV 
		= "testFournirEnTeteCsv()";
		
	/**
	 * "testFournirStringCsv()".
	 */
	public static final String TEST_FOURNIRSTRINGCSV 
		= "testFournirStringCsv()";
		
	/**
	 * "testFournirEnTeteColonne()".
	 */
	public static final String TEST_FOURNIRENTETECOLONNE 
		= "testFournirEnTeteColonne()";
		
	/**
	 * "testFournirValeurColonne()".
	 */
	public static final String TEST_FOURNIRVALEURCOLONNE 
		= "testFournirValeurColonne()";
	
	
	/**
	 * "objet1 : ".
	 */
	public static final String OBJET1 = "objet1 : ";
	
	/**
	 * "objetConstNull1 : "
	 */
	public static final String OBJETCONSTNULL1 = "objetConstNull1 : ";
	
	/**
	 * "objetNull1 : ".
	 */
	public static final String OBJETNULL1 = "objetNull1 : ";
	
	/**
	 * "objet1AvecNull : ".
	 */
	public static final String OBJET1AVECNULL = "objet1AvecNull : ";

	/**
	 * "objet2EqualsObj1 : "
	 */
	public static final String OBJET2EQUALSOBJET1 = "objet2EqualsObj1 : ";
	
	/**
	 * "objet3EqualsObj1 : "
	 */
	public static final String OBJET3EQUALSOBJET1 = "objet3EqualsObj1 : ";
	
	/**
	 * "objet1.equals(objet1) : "
	 */
	public static final String OBJET1_EQUALS_OBJET1 
		= "objet1.equals(objet1) : ";
	
	/**
	 * "objet1.equals(objet1MemeInstance) : "
	 */
	public static final String OBJET1_EQUALS_OBJET1MEMEINSTANCE 
		= "objet1.equals(objet1MemeInstance) : ";
	
	/**
	 * "objet1.equals(objet2EqualsObj1) : ".
	 */
	public static final String OBJET1_EQUALS_OBJET2EQUALSOBJET1 
		= "objet1.equals(objet2EqualsObj1) : ";
	
	/**
	 * "objet2EqualsObj1.equals(objet1) : "
	 */
	public static final String OBJET2EQUALSOBJET1_EQUALS_OBJET1 
		= "objet2EqualsObj1.equals(objet1) : ";
	
	/**
	 * "objet2EqualsObj1.equals(objet3EqualsObj1) : "
	 */
	public static final String OBJET2EQUALSOBJET1_EQUALS_OBJET3EQUALSOBJET1 
		= "objet2EqualsObj1.equals(objet3EqualsObj1) : ";

	/**
	 * "objet1.equals(objet3EqualsObj1) : "
	 */
	public static final String OBJET1_EQUALS_OBJET3EQUALSOBJET1 
		= "objet1.equals(objet3EqualsObj1) : ";
	
	/**
	 * "objet1.hashCode().equals(objet2EqualsObj1.hashCode()) : "
	 */
	public static final String OBJET1HASHCODE_EQUALS_OBJET2EQUALSOBJET1HASHCODE 
		= "objet1.hashCode().equals(objet2EqualsObj1.hashCode()) : ";
	
	/**
	 * "objetConstNull1.equals(objetConstNull2) : "
	 */
	public static final String OBJETCONSTNULL1_EQUALS_OBJETCONSTNULL2 
		= "objetConstNull1.equals(objetConstNull2) : ";
	
	/**
	 * "objetNull1.equals(objetNull2) : "
	 */
	public static final String OBJETNULL1_EQUALS_OBJETNULL2 
		= "objetNull1.equals(objetNull2) : ";

	/**
	 * "objetNull1.hashCode().equals(objetNull2.hashCode()) : "
	 */
	public static final String OBJETNULL1HASHCODE_EQUALS_OBJETNULL2HASCODE 
		= "objetNull1.hashCode().equals(objetNull2.hashCode()) : ";
	

	/**
	 * "objet1AvecNull.equals(objet2EqualsObjet1AvecNull) : "
	 */
	public static final String OBJET1AVECNULL_EQUALS_OBJET2EQUALSOBJET1AVECNULL 
		= "objet1AvecNull.equals(objet2EqualsObjet1AvecNull) : ";

	/**
	 * "objet1AvecNull.hashCode().equals(objet2EqualsObjet1AvecNull.hashCode()) : "
	 */
	public static final String OBJET1AVECNULLHASHCODE_EQUALS_OBJET2EQUALSOBJET1AVECNULLHASHCODE 
		= "objet1AvecNull.hashCode().equals(objet2EqualsObjet1AvecNull.hashCode()) : ";
	
	// ******************* PREPARATION DONNEES METIER ************************
	
	/**
	 * "code_1"
	 */
	public static final String CODE_METIER_1 = "code_1";
	
	/**
	 * "code_2"
	 */
	public static final String CODE_METIER_2 = "code_2";
	
	/**
	 * "code_3"
	 */
	public static final String CODE_METIER_3 = "code_3";
	
	
	/**
	 * "M".
	 */
	public static final String CIVILITE_M = "M";
	
	/**
	 * "F".
	 */
	public static final String CIVILITE_F = "F";
	
	/**
	 * "Vincent".
	 */
	public static final String PRENOM_VINCENT = "Vincent";
	
	/**
	 * "Dominique".
	 */
	public static final String PRENOM_DOMINIQUE = "Dominique";
	
	/**
	 * "Papy".
	 */
	public static final String PRENOM_PAPY = "Papy";
	
	/**
	 * "Daniel".
	 */
	public static final String PRENOM_DANIEL = "Daniel";

	/**
	 * "Olivier".
	 */
	public static final String PRENOM_OLIVIER = "Olivier";
	
	/**
	 * "Robin".
	 */
	public static final String NOM_ROBIN = "Robin";

	/**
	 * "Alamichel".
	 */
	public static final String NOM_ALAMICHEL = "Alamichel";
	
	/**
	 * "Gonzales".
	 */
	public static final String NOM_GONZALES = "Gonzales";
	
	/**
	 * "Lévy".
	 */
	public static final String NOM_LEVY = "Lévy";
	
	/**
	 * "Lesnes".
	 */
	public static final String NOM_LESNES = "Lesnes";

	/**
	 * 01/01/1960
	 */
	public static final LocalDate DATE_20_01_1960 = LocalDate.of(1960, 1, 1);
	
	/**
	 * 07/02/1959
	 */
	public static final LocalDate DATE_07_02_1959 = LocalDate.of(1959, 2, 7);
	
	/**
	 * 07/02/1959
	 */
	public static final LocalDate DATE_23_03_1940 = LocalDate.of(1940, 3, 23);

	

	// ***************** DONNEES METIER A IMPLEMENTER ***********************
	
	/**
	 * Objet Metier à instancier avec le Constructeur MALIN (JaCoCo, EclLemma).
	 */
	public static transient IEmploye objetConstMalin 
		= new Employe(CODE_METIER_1
				, CIVILITE_M, PRENOM_VINCENT, NOM_ROBIN
				, DATE_20_01_1960);
	
	/**
	 * objet1, objet2EqualsObj1, objet3EqualsObj1 doivent être equals().
	 */
	public static transient IEmploye objet1 
		= new Employe(1L
				, CODE_METIER_1
				, CIVILITE_M, PRENOM_VINCENT, NOM_ROBIN
				, DATE_20_01_1960);
	
	/**
	 * objet1MemeInstance doit être la même instance que objet1.<br/>
	 */
	public static transient IEmploye objet1MemeInstance = objet1;
	
	/**
	 * objet1, objet2EqualsObj1, objet3EqualsObj1 doivent être equals().
	 */
	public static transient IEmploye objet2EqualsObj1 
		=  new Employe(7L
				, CODE_METIER_1
				, CIVILITE_F, PRENOM_DOMINIQUE, NOM_LESNES
				, DATE_23_03_1940);
	
	/**
	 * objet1, objet2EqualsObj1, objet3EqualsObj1 doivent être equals().
	 */
	public static transient IEmploye objet3EqualsObj1 
		= new Employe(9L
				, CODE_METIER_1
				, CIVILITE_M, PRENOM_DOMINIQUE, NOM_ALAMICHEL
				, LocalDate.of(1960, 1, 20));
	
	/**
	 * objetConstNull1 et objetConstNull2 doivent être instanciés 
	 * avec le constructeur d'arité nulle.
	 */
	public static transient IEmploye objetConstNull1 = new Employe();
	
	/**
	 * objetConstNull1 et objetConstNull2 doivent être instanciés 
	 * avec le constructeur d'arité nulle.
	 */
	public static transient IEmploye objetConstNull2 = new Employe();
	
	/**
	 * null
	 */
	public static transient IEmploye objetNull;
	
	/**
	 * Objet qui n'est pas une instance de la classe à tester.
	 */
	public static transient String mauvaiseInstance = new String("BIDON");
	
	/**
	 * objetNull1 et objetNull2  doivent avoir 
	 * tous les attributs aux valeurs par défaut (null ou 0, ...).
	 */
	public static transient IEmploye objetNull1 
		= new Employe(0L
				, null
				, null, null, null, null);
	
	/**
	 * objetNull1 et objetNull2  doivent avoir 
	 * tous les attributs aux valeurs par défaut (null ou 0, ...).
	 */
	public static transient IEmploye objetNull2 
		= new Employe(7L
			, null
			, null, null, null, null);
	
	/**
	 * objet1AvecNull et objet2EqualsObjet1AvecNull 
	 * doivent être equals() et avoir certains attributs à null.
	 */
	public static transient IEmploye objet1AvecNull 
		= new Employe(17L
				, CODE_METIER_2
				, CIVILITE_F, null, NOM_GONZALES, null);
	
	/**
	 * objet1AvecNull et objet2EqualsObjet1AvecNull 
	 * doivent être equals() et avoir certains attributs à null.
	 */
	public static transient IEmploye objet2EqualsObjet1AvecNull 
		= new Employe(23L
				, CODE_METIER_2
				, CIVILITE_M, PRENOM_OLIVIER, null, null);
	
	/**
	 * objetDiffObjet1 doit être différent de objet1.
	 */
	public static transient IEmploye objetDiffObjet1 
		= new Employe(158L, CODE_METIER_3
					, CIVILITE_M
						, PRENOM_VINCENT, NOM_ROBIN
						, DATE_20_01_1960);
	
	/**
	 * objetDiff1 doit être différent de objetDiff2
	 */
	public static transient IEmploye objetDiff1 
		= new Employe(73L
				, CODE_METIER_3
				, CIVILITE_M, PRENOM_PAPY, NOM_GONZALES, DATE_07_02_1959);
	
	/**
	 * objetDiff2 doit être différent de objetDiff1
	 */
	public static transient IEmploye objetDiff2 
		= new Employe(73L
				, CODE_METIER_1
				, CIVILITE_M, PRENOM_PAPY, NOM_GONZALES, DATE_07_02_1959);
	
	/**
	 * objetDiff1AvecNull doit être différent de objetDiff2AvecNull.<br/>
	 * objetDiff1AvecNull et objetDiff2AvecNull doivent avoir des attributs null.
	 */
	public static transient IEmploye objetDiff1AvecNull 
		= new Employe(17L
				, CODE_METIER_1
				, null, null, NOM_GONZALES, DATE_07_02_1959);
	
	/**
	 * objetDiff1AvecNull doit être différent de objetDiff2AvecNull.<br/>
	 * objetDiff1AvecNull et objetDiff2AvecNull doivent avoir des attributs null.
	 */
	public static transient IEmploye objetDiff2AvecNull 
		= new Employe(17L
				, CODE_METIER_2
				, null, null, NOM_GONZALES, null);
	
	/**
	 * objetCompIdem1 et objetCompIdem2 doivent avoir même comparaison.<br/>
	 * En plus, objetCompIdem1 et objetCompIdem2 doivent être equals.
	 */
	public static transient IEmploye objetCompIdem1 
		= new Employe(123L, CODE_METIER_1, CIVILITE_F, null, NOM_GONZALES, null);
	
	/**
	 * objetCompIdem1 et objetCompIdem2 doivent avoir même comparaison.<br/>
	 * En plus, objetCompIdem1 et objetCompIdem2 doivent être equals.
	 */
	public static transient IEmploye objetCompIdem2 
		= new Employe(124L, CODE_METIER_1, CIVILITE_F, null, NOM_GONZALES, null);
	
	/**
	 * objetCompAvant doit être AVANT objetCompApres.
	 */
	public static transient IEmploye objetCompAvant 
		= new Employe(10007L
				, CODE_METIER_2
				, CIVILITE_F, PRENOM_PAPY, NOM_GONZALES, DATE_23_03_1940);
	
	/**
	 * objetCompApres doit être APRES objetCompAvant.
	 */
	public static transient IEmploye objetCompApres 
		= new Employe(20007L
				, CODE_METIER_2
				, CIVILITE_F, PRENOM_PAPY, NOM_GONZALES, DATE_07_02_1959);
	
	/**
	 * objetCompApresApres doit être APRES objetCompApres APRES objetCompAvant.
	 */
	public static transient IEmploye objetCompApresApres 
		= new Employe(30007L
				, CODE_METIER_2
				, CIVILITE_F, PRENOM_PAPY, NOM_GONZALES, DATE_20_01_1960);
	
	/**
	 * clone de objetNull1.<br/>
	 */
	public static transient IEmploye objetNullClone1;
	
	/**
	 * clone de objet1.<br/>
	 */
	public static transient IEmploye objetClone1;

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings(UNUSED)
	private static final Log LOG = LogFactory.getLog(EmployeTest.class);

	// *************************METHODES************************************/



	/**
	* CONSTRUCTEUR D'ARITE NULLE.
	*/
	public EmployeTest() {
		super();
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________

	
	
	/**
	 * Garantit que le Constructeur malin fonctionne bien 
	 * (Couverture de code JaCoCo - EclLemma).
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testConstructeurMalin() {
						
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE EmployeTest - méthode testConstructeurMalin() ********** ");
		}
		
		// ARRANGE (ENTRANTS) ***********
		/* utilise objetConstMalin. */
		
		// ACT (SORTANTS) ***************
		/* utilise objetConstMalin. */
		
		// ASSERT *******************
		/* utilise objetConstMalin. */
		assertNull(objetConstMalin.getId(), 
				"l'ID de l'objet construit avec le constructeur malin doit toujours être null : ");
		
	} // Fin de testConstructeurMalin().___________________________________


	
	/**
	 * Teste la méthode <b>equals(Object pObject)</b> :
	 * <ul>
	 * <li>Garantit que <code>quel que soit x non null, 
	 * x.equals(memeInstance) retourne true</code>.</li>
	 * <li>Garantit que <code>quel que soit x non null, 
	 * x.equals(null) retourne false</code>.</li>
	 * <li>garantit que <code>x.equals(mauvaiseInstance) 
	 * retourne false</code>.</li>
	 * <li>Garantit le contrat Java <strong>equals() REFLEXIF</strong> : 
	 * <code>quel que soit x != null, x.equals(x) == true</code>.</li>
	 * <li>Garantit le contrat Java <strong>equals() SYMETRIQUE</strong> : 
	 * <code>quel que soit x, y != null, x.equals(y) == true 
	 * <---> y.equals(x) == true</code>.</li>
	 * <li>Garantit le contrat Java <strong>equals() TRANSITIF</strong> :  
	 * <code>x.equals(y) et y.equals(z) ----> x.equals(z)</code>.</li>
	 * <li>Garantit le contrat Java <strong>equals() CONSISTANT</strong> : 
	 * de multiples appels <code>x.equals(y)</code> 
	 * doivent toujours répondre la même chose.</li>
	 * <li>Garantit le contrat Java <strong>sur les HASHCODE</strong> :  
	 * <code>x.equals(y) ----> x.hashcode() == y.hashcode()</code>.</li>
	 * <li>Garantit que les null sont bien gérés 
	 * dans equals(Object pObj).</li>
	 * <li>Garantit le bon fonctionnement de equals() 
	 * en cas d'égalité métier.</li>
	 * <li>Garantit le bon fonctionnement de equals() 
	 * en cas d'inégalité métier.</li>
	 * </ul>
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testEquals() {
					
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE EmployeTest - méthode testEquals() ********** ");
		}

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("CAS DE 3 Objets equals ----------------");
			System.out.println("objet1.toString() : " + objet1.toString());
			System.out.println("objet2EqualsObj1.toString() : " + objet2EqualsObj1.toString());
			System.out.println("objet3EqualsObj1.toString() : " + objet3EqualsObj1.toString());
			System.out.println();
			System.out.println(OBJET1_EQUALS_OBJET1 + objet1.equals(objet1));
			System.out.println(OBJET1_EQUALS_OBJET2EQUALSOBJET1 + objet1.equals(objet2EqualsObj1));
			System.out.println(OBJET2EQUALSOBJET1_EQUALS_OBJET1 + objet2EqualsObj1.equals(objet1));
			System.out.println(OBJET2EQUALSOBJET1_EQUALS_OBJET3EQUALSOBJET1 + objet2EqualsObj1.equals(objet3EqualsObj1));
			System.out.println(OBJET1_EQUALS_OBJET3EQUALSOBJET1 + objet1.equals(objet3EqualsObj1));
			System.out.println(OBJET1HASHCODE_EQUALS_OBJET2EQUALSOBJET1HASHCODE + (objet1.hashCode() == objet2EqualsObj1.hashCode()));
		}
		
		
		/* garantit le contrat Java reflexif x.equals(x). */
		assertEquals(objet1, objet1, OBJET1_EQUALS_OBJET1);
				
		/* garantit le contrat Java symétrique 
		 * x.equals(y) ----> y.equals(x). */
		assertEquals(objet1, objet2EqualsObj1, OBJET1_EQUALS_OBJET2EQUALSOBJET1);
		
		assertEquals(objet2EqualsObj1, objet1, OBJET2EQUALSOBJET1_EQUALS_OBJET1);
		
		/* garantit le contrat Java transitif 
		 * x.equals(y) et y.equals(z) ----> x.equals(z). */
		assertEquals(objet1, objet2EqualsObj1, OBJET1_EQUALS_OBJET2EQUALSOBJET1);
		
		assertEquals(objet2EqualsObj1, objet3EqualsObj1
				, OBJET2EQUALSOBJET1_EQUALS_OBJET3EQUALSOBJET1);
		
		assertEquals(objet1, objet3EqualsObj1
				, OBJET1_EQUALS_OBJET3EQUALSOBJET1);
		
		/* garantit le contrat Java sur les hashcode 
		 * x.equals(y) ----> x.hashcode() == y.hashcode(). */
		assertEquals(objet1.hashCode()
						, objet2EqualsObj1.hashCode()
							, OBJET1HASHCODE_EQUALS_OBJET2EQUALSOBJET1HASHCODE);

				
		/* garantit que les null sont bien gérés dans equals(...). */
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("CAS D'OBJETS INSTANCIES AVEC LE CONSTRUCTEUR D'ARITE NULLE (ou attributs par défaut) -------");
			System.out.println("OBJETNULL1 : " 
					+ objetNull1.toString());
			System.out.println("OBJETNULL2 : " 
					+ objetNull2.toString());
			System.out.println();
			System.out.println(OBJETNULL1_EQUALS_OBJETNULL2 + objetNull1.equals(objetNull2));
			System.out.println(OBJETNULL1HASHCODE_EQUALS_OBJETNULL2HASCODE + (objetNull1.hashCode() == objetNull2.hashCode()));
		}

		assertEquals(objetNull1
						, objetNull2, OBJETNULL1_EQUALS_OBJETNULL2);
		assertEquals(objetNull1.hashCode()
						, objetNull2.hashCode()
							, OBJETNULL1HASHCODE_EQUALS_OBJETNULL2HASCODE);
		

		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("CAS D'OBJETS AVEC CERTAINS ATTRIBUTS NULL -----------");
			System.out.println(OBJET1AVECNULL 
					+ objet1AvecNull.toString());
			System.out.println("objet2EqualsObjet1AvecNull : " 
					+ objet2EqualsObjet1AvecNull.toString());
			System.out.println();
			System.out.println(OBJET1AVECNULL_EQUALS_OBJET2EQUALSOBJET1AVECNULL + objet1AvecNull.equals(objet2EqualsObjet1AvecNull));
			System.out.println(OBJET1AVECNULLHASHCODE_EQUALS_OBJET2EQUALSOBJET1AVECNULLHASHCODE + (objet1AvecNull.hashCode() == objet2EqualsObjet1AvecNull.hashCode()));
		}

		assertEquals(objet1AvecNull
						, objet2EqualsObjet1AvecNull
							, OBJET1AVECNULL_EQUALS_OBJET2EQUALSOBJET1AVECNULL);
		
		assertEquals(objet1AvecNull.hashCode()
						, objet2EqualsObjet1AvecNull.hashCode()
							, OBJET1AVECNULLHASHCODE_EQUALS_OBJET2EQUALSOBJET1AVECNULLHASHCODE);


		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("OBJET EXISTANT EQUALS null --------------------------");
			System.out.println("objet1.toString() : " + objet1.toString());
			System.out.println();
			System.out.println("objet1.equals(null) : " + (objet1 == null));
		}
		
		/* garantit que x.equals(null) retourne false (avec x non null). */
		assertNotNull(objet1, "objet1 pas equals(null) : ");

		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("CAS D'EGALITE METIER --------------------");
			System.out.println(OBJET1 
					+ objet1.toString());
			System.out.println(OBJET2EQUALSOBJET1 
					+ objet2EqualsObj1.toString());
			System.out.println();
			System.out.println(OBJET1_EQUALS_OBJET2EQUALSOBJET1 + objet1.equals(objet2EqualsObj1));
		}

		
		/* garantit le bon fonctionnement de equals() 
		 * en cas d'égalité métier. */
		assertEquals(objet1
						, objet2EqualsObj1, OBJET1_EQUALS_OBJET2EQUALSOBJET1);
		

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("CAS DE 2 Objets DIFFERENTS (pas equals) ---------------------");
			System.out.println("objetDiff1 : " 
					+ objetDiff1.toString());
			System.out.println("objetDiff2 : " 
					+ objetDiff2.toString());
			System.out.println();
			System.out.println("objetDiff1.equals(objetDiff2) : " + objetDiff1.equals(objetDiff2));
			System.out.println("objetDiff1.hashcode() == objetDiff2.hashcode() : " + (objetDiff1.hashCode() == objetDiff2.hashCode()));
		}
		
		/* garantit le bon fonctionnement de equals() 
		 * en cas d'inégalité métier. */
		assertFalse(objetDiff1.equals(objetDiff2)
				, "objetDiff1 PAS equals(objetDiff2) : ");
		
		assertFalse(objetDiff1.hashCode() == objetDiff2.hashCode()
				, "objetDiff1.hashCode() PAS equals(objetDiff2.hashCode()) : ");
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("CAS DE 2 Objets DIFFERENTS (pas equals) avec des attributs null---------------------");
			System.out.println("objetDiff1AvecNull : " 
					+ objetDiff1AvecNull.toString());
			System.out.println("objetDiff2AvecNull : " 
					+ objetDiff2AvecNull.toString());
			System.out.println();
			System.out.println("objetDiff1AvecNull.equals(objetDiff2AvecNull) : " + objetDiff1AvecNull.equals(objetDiff2AvecNull));
			System.out.println("objetDiff1AvecNull.hashcode() == objetDiff2AvecNull.hashcode() : " + (objetDiff1AvecNull.hashCode() == objetDiff2AvecNull.hashCode()));
		}
		
		/* garantit le bon fonctionnement de equals() 
		 * en cas d'inégalité métier. */
		assertFalse(objetDiff1AvecNull.equals(objetDiff2AvecNull)
				, "objetDiff1AvecNull PAS equals(objetDiff2AvecNull) : ");
		
		assertFalse(objetDiff1AvecNull.hashCode() == objetDiff2AvecNull.hashCode()
				, "objetDiff1AvecNull.hashCode() PAS equals(objetDiff2AvecNull.hashCode()) : ");
				
	} // Fin de testEquals().______________________________________________
	
	
	
	/**
	 * Garantit que <code>quel que soit x non null, 
	 * x.equals(memeInstance) retourne true</code>.
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testXEqualsMemeInstanceReturnTrue() {
						
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE EmployeTest - méthode testXEqualsMemeInstanceReturnTrue() ********** ");
		}
		
		// ARRANGE (ENTRANTS) ***********
		/* utilise objet1 et objet1MemeInstance. */
		
		// ACT (SORTANTS) ***************
		/* utilise objet1 et objet1MemeInstance. */		
		final boolean resultatObjet1EqualsObjet1MemeInstance 
			= objet1.equals(objet1MemeInstance);
		
		// ASSERT *******************
		assertTrue(resultatObjet1EqualsObjet1MemeInstance
				, "X.equals(memeInstance) doit toujours retourner true : ");
		
	} // Fin de testXEqualsMemeInstanceReturnTrue()._______________________
	

	
	/**
	 * Garantit que <code>quel que soit x non null, 
	 * x.equals(null) retourne false</code>.
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testXEqualsNullReturnFalse() {
						
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE EmployeTest - méthode testXEqualsNullReturnFalse() ********** ");
		}
		
		// ARRANGE (ENTRANTS) ***********
		/* utilise objet1 et objetNull. */
		
		// ACT (SORTANTS) ***************
		/* utilise objet1 et objetNull. */		
		final boolean resultatObjet1Equalsnull = objet1.equals(objetNull); // NOPMD by dan on 13/11/2020 18:20
		
		// ASSERT *******************
		assertFalse(resultatObjet1Equalsnull
				, "X.equals(null) doit toujours retourner false : ");
		
	} // Fin de testXEqualsNullReturnFalse().______________________________

	
	
	/**
	 * garantit que <code>x.equals(mauvaiseInstance) 
	 * retourne false</code>.<br/>
	 * SuppressFBWarnings("EC") Laisse SpotBugs écrire une égalité 
	 * entre deux instances de type différents (désactive le warning).
	 */
	@SuppressWarnings(UNUSED)
	@SuppressFBWarnings("EC")
	@Test
	public void testXEqualsMauvaiseInstanceReturnFalse() {
						
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE EmployeTest - méthode testXEqualsMauvaiseInstanceReturnFalse() ********** ");
		}
		
		// ARRANGE (ENTRANTS) ***********
		/* utilise objet1 et mauvaiseInstance. */
		
		// ACT (SORTANTS) ***************
		/* utilise objet1 et objetNull. */		
		@SuppressWarnings("unlikely-arg-type")
		final boolean resultatObjet1EqualsMauvaiseInstance 
			= objet1.equals(mauvaiseInstance);
		
		// ASSERT *******************
		assertFalse(resultatObjet1EqualsMauvaiseInstance
				, "X.equals(mauvaiseInstance) doit toujours retourner false : ");
		
	} // Fin de testXEqualsMauvaiseInstanceReturnFalse().__________________
	
	
	
	/**
	 * Garantit le contrat Java <strong>equals() REFLEXIF</strong> : 
	 * <code>quel que soit x != null, x.equals(x) == true</code>.<br/>
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testXEqualsXReturnTrue() {
						
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE EmployeTest - méthode testXEqualsXReturnTrue() ********** ");
		}

		
		// ARRANGE (ENTRANTS) ***********
		/* utilise objet1 et objet1. */
		/* utilise objet1 et objet1MemeInstance. */
		/* utilise objet1 et objet2EqualsObj1. */
		/* utilise objet2EqualsObj1 et objet3EqualsObj1. */
		/* utilise objetConstNull1 et objetConstNull2. */
		/* Utilise objetNull1 et ObjetNull2. */
		/* Utilise objet1AvecNull et objet2EqualsObjet1AvecNull. */

		
		// ACT (SORTANTS) ***************
		/* utilise objet1 et objet1. */
		final boolean resultatObjet1EqualsObjet1 = objet1.equals(objet1);
		
		/* utilise objet1 et objet1MemeInstance. */
		final boolean resultatObjet1EqualsObjet1MemeInstance 
			= objet1.equals(objet1MemeInstance);
		
		/* utilise objet1 et objet2EqualsObj1. */
		final boolean resultatObjet1EqualsObjet2EqualsObjet1 
			= objet1.equals(objet2EqualsObj1);
		
		/* utilise objet2EqualsObj1 et objet3EqualsObj1. */
		final boolean resultatObjet2EqualsObjet1EqualsObjet3EqualsObjet1 
			= objet2EqualsObj1.equals(objet3EqualsObj1);
		
		/* utilise objetConstNull1 et objetConstNull2. */
		final boolean resultatObjetConstNull1EqualsObjetConstNull2 
			= objetConstNull1.equals(objetConstNull2);
		
		/* Utilise objetNull1 et ObjetNull2. */
		final boolean resultatObjetNull1EqualsObjetNull2 
			= objetNull1.equals(objetNull2);
		
		/* Utilise objet1AvecNull et objet2EqualsObjet1AvecNull. */
		final boolean resultatObjet1AvecNullEqualsObjet2EqualsObjet1AvecNull 
			= objet1AvecNull.equals(objet2EqualsObjet1AvecNull);
		
		
		if (AFFICHAGE_GENERAL && affichage) {
			
			System.out.println(String.format(Locale.getDefault()
					, FORMAT_STRING
						, OBJET1
						, objet1.toString()
						, OBJET1
						, objet1.toString()));
			System.out.println(OBJET1_EQUALS_OBJET1 + resultatObjet1EqualsObjet1);
			
			System.out.println(String.format(Locale.getDefault()
					, FORMAT_STRING
						, OBJET1
						, objet1.toString()
						, "objet1MemeInstance : "
						, objet1MemeInstance.toString()));
			System.out.println(OBJET1_EQUALS_OBJET1MEMEINSTANCE 
					+ resultatObjet1EqualsObjet1MemeInstance);
			
			System.out.println(String.format(Locale.getDefault()
					, FORMAT_STRING
						, OBJET1
						, objet1.toString()
						, OBJET2EQUALSOBJET1
						, objet2EqualsObj1.toString()));
			System.out.println(OBJET1_EQUALS_OBJET2EQUALSOBJET1 
					+ resultatObjet1EqualsObjet2EqualsObjet1);
			
			System.out.println(String.format(Locale.getDefault()
					, FORMAT_STRING
						, OBJET2EQUALSOBJET1
						, objet2EqualsObj1.toString()
						, OBJET3EQUALSOBJET1
						, objet3EqualsObj1.toString()));
			System.out.println(OBJET2EQUALSOBJET1_EQUALS_OBJET3EQUALSOBJET1 
					+ resultatObjet2EqualsObjet1EqualsObjet3EqualsObjet1);
			
			System.out.println(String.format(Locale.getDefault()
					, FORMAT_STRING
						, OBJETCONSTNULL1
						, objetConstNull1.toString()
						, "objetConstNull2 : "
						, objetConstNull2.toString()));
			System.out.println(OBJETCONSTNULL1_EQUALS_OBJETCONSTNULL2 
					+ resultatObjetConstNull1EqualsObjetConstNull2);
			
			System.out.println(String.format(Locale.getDefault()
					, FORMAT_STRING
						, OBJETNULL1
						, objetNull1.toString()
						, "objetNull2 : "
						, objetNull2.toString()));
			System.out.println(OBJETNULL1_EQUALS_OBJETNULL2 
					+ resultatObjetNull1EqualsObjetNull2);
			
			System.out.println(String.format(Locale.getDefault()
					, FORMAT_STRING
						, OBJET1AVECNULL
						, objet1AvecNull.toString()
						, "objet2EqualsObjet1AvecNull : "
						, objet2EqualsObjet1AvecNull.toString()));
			System.out.println(OBJET1AVECNULL_EQUALS_OBJET2EQUALSOBJET1AVECNULL
					+ resultatObjet1AvecNullEqualsObjet2EqualsObjet1AvecNull);
		}

		
		// ASSERT *******************
		assertEquals(objet1, objet1
				, OBJET1_EQUALS_OBJET1);
		
		assertTrue(resultatObjet1EqualsObjet1
				, "x.equals(x) doit toujours retourner true : ");
		
		assertEquals(objet1, objet1MemeInstance
				, OBJET1_EQUALS_OBJET1MEMEINSTANCE);
		
		assertEquals(objet1, objet2EqualsObj1
				, OBJET1_EQUALS_OBJET2EQUALSOBJET1);
		
		assertEquals(objet2EqualsObj1, objet3EqualsObj1
				, OBJET2EQUALSOBJET1_EQUALS_OBJET3EQUALSOBJET1);
		
		assertEquals(objetConstNull1, objetConstNull2
				, OBJETCONSTNULL1_EQUALS_OBJETCONSTNULL2);
		
		assertEquals(objetNull1, objetNull2
				, OBJETNULL1_EQUALS_OBJETNULL2);
		
		assertEquals(objet1AvecNull, objet2EqualsObjet1AvecNull
				, OBJET1AVECNULL_EQUALS_OBJET2EQUALSOBJET1AVECNULL);
		
	} // Fin de testXEqualsXReturnTrue().----------------------------------
	

	
	/**
	 * Garantit le contrat Java <strong>equals() SYMETRIQUE</strong> : 
	 * <code>quel que soit x, y != null, x.equals(y) == true 
	 * <---> y.equals(x) == true</code>.<br/>
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testXEqualsYReturnTrue() {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
		System.out.println();
		System.out.println("********** CLASSE EmployeTest - méthode testXEqualsXReturnTrue() ********** ");
		}
		

		// ARRANGE (ENTRANTS) ***********
		/* utilise objet1 et objet2EqualsObj1. */
		/* utilise objet2EqualsObj1 et objet1. */

		
		// ACT (SORTANTS) ***************		
		/* utilise objet1 et objet2EqualsObj1. */
		final boolean resultatObjet1EqualsObjet2EqualsObjet1 
			= objet1.equals(objet2EqualsObj1);
		/* utilise objet2EqualsObj1 et objet1. */
		final boolean resultatObjet2EqualsObjet1EqualsObjet1 
			= objet2EqualsObj1.equals(objet1);
		
		if (AFFICHAGE_GENERAL && affichage) {
			
			final String formatString = "%1$-20s %2$-100s %3$-25s %4$-120s";
			
			System.out.println(String.format(Locale.getDefault()
					, formatString
						, OBJET1
						, objet1.toString()
						, OBJET2EQUALSOBJET1
						, objet2EqualsObj1.toString()));
			System.out.println(OBJET1_EQUALS_OBJET2EQUALSOBJET1 
					+ resultatObjet1EqualsObjet2EqualsObjet1);
			
			System.out.println(String.format(Locale.getDefault()
					, formatString
						, OBJET2EQUALSOBJET1
						, objet2EqualsObj1.toString()
						, OBJET1
						, objet1.toString()));
			System.out.println(OBJET2EQUALSOBJET1_EQUALS_OBJET1 
					+ resultatObjet2EqualsObjet1EqualsObjet1);
		}

		
		// ASSERT *********************
		assertEquals(objet1, objet2EqualsObj1
				, OBJET1_EQUALS_OBJET2EQUALSOBJET1);
		
		assertEquals(objet2EqualsObj1, objet1
				, OBJET2EQUALSOBJET1_EQUALS_OBJET1);
		
		assertEquals(
				resultatObjet1EqualsObjet2EqualsObjet1
					, resultatObjet2EqualsObjet1EqualsObjet1
						, "equals() doit être SYMETRIQUE : ");
		
	} // Fin de testXEqualsYReturnTrue().__________________________________

	
	
	/**
	 * Garantit le contrat Java <strong>equals() TRANSITIF</strong> :  
	 * <code>x.equals(y) et y.equals(z) ----> x.equals(z)</code>.
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testXEqualsYEqualsZReturnTrue() {
						
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
		System.out.println();
		System.out.println("********** CLASSE EmployeTest - méthode testXEqualsYEqualsZReturnTrue() ********** ");
		}

		
		// ARRANGE (ENTRANTS) ***********
		/* utilise objet1 et objet2EqualsObj1. */
		/* utilise objet2EqualsObj1 et objet3EqualsObj1. */
		/* utilise objet1 et objet3EqualsObj1. */

		
		// ACT (SORTANTS) ***************		
		/* utilise objet1 et objet2EqualsObj1. */
		final boolean resultatObjet1EqualsObjet2EqualsObjet1 
			= objet1.equals(objet2EqualsObj1);
		/* utilise objet2EqualsObj1 et objet3EqualsObj1. */
		final boolean resultatObjet2EqualsObjet1EqualsObjet3EqualsObjet1 
			= objet2EqualsObj1.equals(objet3EqualsObj1);
		/* utilise objet1 et objet3EqualsObj1. */
		final boolean resultatObjet1EqualsObjet3EqualsObjet1 
			= objet1.equals(objet3EqualsObj1);
		
		
		if (AFFICHAGE_GENERAL && affichage) {
			
			System.out.println(String.format(Locale.getDefault()
					, FORMAT_STRING
						, OBJET1
						, objet1.toString()
						, OBJET2EQUALSOBJET1
						, objet2EqualsObj1.toString()));
			System.out.println(OBJET1_EQUALS_OBJET2EQUALSOBJET1 
					+ resultatObjet1EqualsObjet2EqualsObjet1);
						
			System.out.println(String.format(Locale.getDefault()
					, FORMAT_STRING
						, OBJET2EQUALSOBJET1
						, objet2EqualsObj1.toString()
						, OBJET3EQUALSOBJET1
						, objet3EqualsObj1.toString()));
			System.out.println(OBJET2EQUALSOBJET1_EQUALS_OBJET3EQUALSOBJET1 
					+ resultatObjet2EqualsObjet1EqualsObjet3EqualsObjet1);

			System.out.println(String.format(Locale.getDefault()
					, FORMAT_STRING
						, OBJET1
						, objet1.toString()
						, OBJET3EQUALSOBJET1
						, objet3EqualsObj1.toString()));
			System.out.println("objet1.equals(objet3EqualsObj1) : " 
					+ resultatObjet1EqualsObjet3EqualsObjet1);

		}
		

		// ASSERT ***********************
		assertEquals(objet1, objet2EqualsObj1
				, OBJET1_EQUALS_OBJET2EQUALSOBJET1);
		
		assertEquals(objet2EqualsObj1, objet3EqualsObj1
				, OBJET2EQUALSOBJET1_EQUALS_OBJET3EQUALSOBJET1);

		assertEquals(objet1, objet3EqualsObj1
				, "equals() doit être TRANSITIF : ");
		
	} // Fin de testXEqualsYEqualsZReturnTrue().___________________________
	
	
	
	/**
	 * Garantit le contrat Java <strong>equals() CONSISTANT</strong> : 
	 * de multiples appels <code>x.equals(y)</code> 
	 * doivent toujours répondre la même chose.
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testConsistenceEquals() {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
		System.out.println();
		System.out.println("********** CLASSE EmployeTest - méthode testConsistenceEquals() ********** ");
		}
		
		// ARRANGE (ENTRANTS) ***********
		/* utilise objet1 et objet2EqualsObj1. */
		/* utilise objet1 et objetDiffObjet1. */
		final int nombreEssais = 10;

		
		// ACT (SORTANTS) ***************		
		/* utilise objet1 et objet2EqualsObj1. */
		boolean resultatTrue = true;
				
		for (int i = 0; i < nombreEssais; i++) {
			if (!objet1.equals(objet2EqualsObj1)) {
				resultatTrue = false;
			}
		}
		
		/* utilise objet1 et objetDiffObjet1. */
		boolean resultatFalse = false;
		
		for (int i = 0; i < nombreEssais; i++) {
			if (objet1.equals(objetDiffObjet1)) {
				resultatFalse = true;
			}
		}
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(
					"Résultat des 10 invocations de objet1.equals(objet2EqualsObj1) : " 
							+ resultatTrue);
			System.out.println(
					"Résultat des 10 invocations de objet1.equals(objetDiffObjet1) : " 
							+ resultatFalse);
		}

		
		// ASSERT ***********************
		assertTrue(resultatTrue
				, "objet1.equals(objet2EqualsObj1) doit toujours retourner true : ");
		
		assertFalse(resultatFalse
				, "objet1.equals(objetDiffObjet1) doit toujours retourner false : ");
		
	} // Fin de testConsistenceEquals().___________________________________

	
	
	/**
	 * Garantit le contrat Java <strong>sur les HASHCODE</strong> :  
	 * <code>x.equals(y) ----> x.hashcode() == y.hashcode()</code>.
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testEqualsHashCode() {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
		System.out.println();
		System.out.println("********** CLASSE EmployeTest - méthode testEqualsHashCode() ********** ");
		}

		
		// ARRANGE (ENTRANTS) ***********
		/* utilise objet1 et objet1. */
		/* utilise objet1 et objet1MemeInstance. */
		/* utilise objet1 et objet2EqualsObj1. */
		/* utilise objet2EqualsObj1 et objet3EqualsObj1. */
		/* utilise objetConstNull1 et objetConstNull2. */
		/* Utilise objetNull1 et ObjetNull2. */
		/* Utilise objet1AvecNull et objet2EqualsObjet1AvecNull. */

		
		// ACT (SORTANTS) ***************
		/* utilise objet1 et objet1. */
		final boolean resultatObjet1EqualsObjet1 = objet1.equals(objet1);
		final int hashCodeObjet1 = objet1.hashCode();
		final int hashCodeObjet2 = objet1.hashCode();
		final boolean resultatComparaisonHashCodeObjet1HashCodeObjet1 
			= hashCodeObjet1 == hashCodeObjet2;
		
		/* utilise objet1 et objet1MemeInstance. */
		final boolean resultatObjet1EqualsObjet1MemeInstance 
			= objet1.equals(objet1MemeInstance);
		final int hashCodeObjet1MemeInstance = objet1MemeInstance.hashCode();
		final boolean resultatComparaisonHashCodeObjet1HashCodeObjet1MemeInstance 
			= hashCodeObjet1 == hashCodeObjet1MemeInstance;
		
		/* utilise objet1 et objet2EqualsObj1. */
		final boolean resultatObjet1EqualsObjet2EqualsObjet1 
			= objet1.equals(objet2EqualsObj1);
		final int hashCodeObjet2EqualsObjet1 = objet2EqualsObj1.hashCode();
		final boolean resultatComparaisonHashCodeObjet1HashCodeObjet2EqualsObjet1 
			= hashCodeObjet1 == hashCodeObjet2EqualsObjet1;
		
		/* utilise objet2EqualsObj1 et objet3EqualsObj1. */
		final boolean resultatObjet2EqualsObjet1EqualsObjet3EqualsObjet1 
			= objet2EqualsObj1.equals(objet3EqualsObj1);
		final int hashCodeObjet2EqualsObj1 = objet2EqualsObj1.hashCode();
		final int hashCodeObjet3EqualsObj1 = objet3EqualsObj1.hashCode();
		final boolean resultatComparaisonHashCodeObjet2EqualsObj1HashCodeObjet3EqualsObj1 
			= hashCodeObjet2EqualsObj1 == hashCodeObjet3EqualsObj1;
		
		/* utilise objetConstNull1 et objetConstNull2. */
		final boolean resultatObjetConstNull1EqualsObjetConstNull2 
			= objetConstNull1.equals(objetConstNull2);
		final int hashCodeObjetConstNull1 = objetConstNull1.hashCode();
		final int hashCodeObjetConstNull2 = objetConstNull2.hashCode();
		final boolean resultatComparaisonHashCodeObjetConstNull1HashCodeObjetConstNull2 
			= hashCodeObjetConstNull1 == hashCodeObjetConstNull2;
		
		/* Utilise objetNull1 et ObjetNull2. */
		final boolean resultatObjetNull1EqualsObjetNull2 
			= objetNull1.equals(objetNull2);
		final int hashCodeObjetNull1 = objetNull1.hashCode();
		final int hashCodeObjetNull2 = objetNull2.hashCode();
		final boolean resultatComparaisonHashCodeObjetNull1HashCodeObjetNull2 
			= hashCodeObjetNull1 == hashCodeObjetNull2;
		
		/* Utilise objet1AvecNull et objet2EqualsObjet1AvecNull. */
		final boolean resultatObjet1AvecNullEqualsObjet2EqualsObjet1AvecNull 
			= objet1AvecNull.equals(objet2EqualsObjet1AvecNull);
		final int hashCodeobjet1AvecNull = objet1AvecNull.hashCode();
		final int hashCodeObjet2EqualsObjet1AvecNull = objet2EqualsObjet1AvecNull.hashCode();
		final boolean resultatComparaisonHashCodeobjet1AvecNullHashCodeObjet2EqualsObjet1AvecNull 
			= hashCodeobjet1AvecNull == hashCodeObjet2EqualsObjet1AvecNull;
				
		if (AFFICHAGE_GENERAL && affichage) {
			
			System.out.println(String.format(Locale.getDefault()
					, FORMAT_STRING
						, OBJET1
						, objet1.toString()
						, OBJET1
						, objet1.toString()));
			System.out.println(OBJET1_EQUALS_OBJET1 
					+ resultatObjet1EqualsObjet1);
			System.out.println("objet1.hashCode() == objet1.hashCode() : " 
					+ resultatComparaisonHashCodeObjet1HashCodeObjet1);
			System.out.println();
			
			System.out.println(String.format(Locale.getDefault()
					, FORMAT_STRING
						, OBJET1
						, objet1.toString()
						, "objet1MemeInstance : "
						, objet1MemeInstance.toString()));
			System.out.println(OBJET1_EQUALS_OBJET1MEMEINSTANCE 
					+ resultatObjet1EqualsObjet1MemeInstance);
			System.out.println("objet1.hashCode() == objet1MemeInstance.hashCode() : " 
					+ resultatComparaisonHashCodeObjet1HashCodeObjet1MemeInstance);
			System.out.println();
			
			System.out.println(String.format(Locale.getDefault()
					, FORMAT_STRING
						, OBJET1
						, objet1.toString()
						, OBJET2EQUALSOBJET1
						, objet2EqualsObj1.toString()));
			System.out.println(OBJET1_EQUALS_OBJET2EQUALSOBJET1 
					+ resultatObjet1EqualsObjet2EqualsObjet1);
			System.out.println("objet1.hashCode() == objet2EqualsObj1.hashCode() : " 
					+ resultatComparaisonHashCodeObjet1HashCodeObjet2EqualsObjet1);
			System.out.println();
						
			System.out.println(String.format(Locale.getDefault()
					, FORMAT_STRING
						, OBJET2EQUALSOBJET1
						, objet2EqualsObj1.toString()
						, OBJET3EQUALSOBJET1
						, objet3EqualsObj1.toString()));
			System.out.println(OBJET2EQUALSOBJET1_EQUALS_OBJET3EQUALSOBJET1 
					+ resultatObjet2EqualsObjet1EqualsObjet3EqualsObjet1);
			System.out.println("objet2EqualsObj1.hashCode() == objet3EqualsObj1.hashCode() : " 
					+ resultatComparaisonHashCodeObjet2EqualsObj1HashCodeObjet3EqualsObj1);
			System.out.println();
			
			System.out.println(String.format(Locale.getDefault()
					, FORMAT_STRING
						, OBJETCONSTNULL1
						, objetConstNull1.toString()
						, "objetConstNull2 : "
						, objetConstNull2.toString()));
			System.out.println(OBJETCONSTNULL1_EQUALS_OBJETCONSTNULL2 
					+ resultatObjetConstNull1EqualsObjetConstNull2);
			System.out.println("objetConstNull1.hashCode() == objetConstNull2.hashCode() : " 
					+ resultatComparaisonHashCodeObjetConstNull1HashCodeObjetConstNull2);
			System.out.println();
			
			System.out.println(String.format(Locale.getDefault()
					, FORMAT_STRING
						, OBJETNULL1
						, objetNull1.toString()
						, "objetNull2 : "
						, objetNull2.toString()));
			System.out.println(OBJETNULL1_EQUALS_OBJETNULL2 
					+ resultatObjetNull1EqualsObjetNull2);
			System.out.println("objetNull1.hashCode() == objetNull2.hashCode() : " 
					+ resultatComparaisonHashCodeObjetNull1HashCodeObjetNull2);
			System.out.println();
						
			System.out.println(String.format(Locale.getDefault()
					, FORMAT_STRING
						, OBJET1AVECNULL
						, objet1AvecNull.toString()
						, "objet2EqualsObjet1AvecNull : "
						, objet2EqualsObjet1AvecNull.toString()));
			System.out.println(OBJET1AVECNULL_EQUALS_OBJET2EQUALSOBJET1AVECNULL
					+ resultatObjet1AvecNullEqualsObjet2EqualsObjet1AvecNull);
			System.out.println("objet1AvecNull.hashCode() == objet2EqualsObjet1AvecNull.hashCode() : " 
					+ resultatComparaisonHashCodeobjet1AvecNullHashCodeObjet2EqualsObjet1AvecNull);
			System.out.println();
			
		}

		
		// ASSERT ***********************
		assertEquals(objet1, objet1
				, OBJET1_EQUALS_OBJET1);
		assertTrue(resultatComparaisonHashCodeObjet1HashCodeObjet1
				, "objet1.hashCode() == objet1.hashCode() : ");
		
		assertEquals(objet1, objet1MemeInstance
				, OBJET1_EQUALS_OBJET1MEMEINSTANCE);
		assertTrue(resultatComparaisonHashCodeObjet1HashCodeObjet1MemeInstance
				, "objet1.hashCode() == objet1MemeInstance.hashCode() : ");
		
		assertEquals(objet1, objet2EqualsObj1
				, OBJET1_EQUALS_OBJET2EQUALSOBJET1);
		assertTrue(resultatComparaisonHashCodeObjet1HashCodeObjet2EqualsObjet1
				, "objet1.hashCode() == objet2EqualsObj1.hashCode() : ");
		
		assertEquals(objet2EqualsObj1, objet3EqualsObj1
				, OBJET2EQUALSOBJET1_EQUALS_OBJET3EQUALSOBJET1);
		assertTrue(resultatComparaisonHashCodeObjet2EqualsObj1HashCodeObjet3EqualsObj1
				, "objet2EqualsObj1.hashCode() == objet3EqualsObj1.hashCode() : ");
				
		assertEquals(objetConstNull1, objetConstNull2
				, OBJETCONSTNULL1_EQUALS_OBJETCONSTNULL2);
		assertTrue(resultatComparaisonHashCodeObjetConstNull1HashCodeObjetConstNull2
				, "objetConstNull1.hashCode() == objetConstNull2.hashCode() : ");
		
		assertEquals(objetNull1, objetNull2
				, OBJETNULL1_EQUALS_OBJETNULL2);
		assertTrue(resultatComparaisonHashCodeObjetNull1HashCodeObjetNull2
				, "objetNull1.hashCode() == objetNull2.hashCode() : ");
		
		assertEquals(objet1AvecNull, objet2EqualsObjet1AvecNull
				, OBJET1AVECNULL_EQUALS_OBJET2EQUALSOBJET1AVECNULL);
		assertTrue(resultatComparaisonHashCodeobjet1AvecNullHashCodeObjet2EqualsObjet1AvecNull
				, "objet1AvecNull.hashCode() == objet2EqualsObjet1AvecNull.hashCode() : ");
		
	} // Fin de testEqualsHashCode().______________________________________
	
	
	
	/**
	 * Garantit le contrat Java <strong>hashCode() CONSISTANT</strong> : 
	 * de multiples appels <code>x.hashCode</code> 
	 * doivent toujours répondre la même chose 
	 * pendant la durée de vie d'une application.
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testConsistenceHashCode() {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
		System.out.println();
		System.out.println("********** CLASSE EmployeTest - méthode testConsistenceHashCode() ********** ");
		}

		
		// ARRANGE (ENTRANTS) ***********
		/* utilise objet1. */
		final int nombreEssais = 10;

		
		// ACT (SORTANTS) ***************
		int hashCodeOld = 0;
		boolean resultat = true;
		
		/* utilise objet1. */
		for (int i = 0; i < nombreEssais; i++) {
			
			final int hashCode = objet1.hashCode();
			
			if (i > 0 && hashCode != hashCodeOld) {
				resultat = false;
				break;
			}
			
			hashCodeOld = hashCode;
		}
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("résultat des n tentatives de objet1.hashCode() sans aucun changement : " 
					+ resultat);
		}

		
		// ASSERT ***********************
		assertTrue(resultat
				, "le résultat des n invocations de objet1.hashCode() ne doit jamais changer : ");
		
	} // Fin de testConsistenceHashCode()._________________________________
	
	
	
	/**
	 * Teste la méthode <b>compareTo(...)</b> :
	 * <ul>
	 * <li>Garantit que compareTo(memeInstance) retourne 0 : 
	 * <code>quel que soit x non null, x.compareTo(memeInstance) == 0</code>.</li>
	 * <li>Garantit que compareTo(null) retourne un nombre négatif : 
	 * <code>quel que soit x non null, x.compareTo(null) &lt; 0 </code>.</li>
	 * <li>Garantit le contrat Java <strong>compareTo() ANTI-SYMETRIQUE</strong> : 
	 * <code>quel que soit x, y non nuls, 
	 * sgn(x.compareTo(y)) == - sgn(y.compareTo(x))</code>.</li>
	 * <li>Garantit le contrat Java <strong>compareTo() TRANSITIF</strong> :
	 * <code>(x.compareTo(y)>0 && y.compareTo(z)>0) 
	 * ---> x.compareTo(z)>0</code>.</li>
	 * <li>Garantit le contrat Java <strong>PROPAGATION du CompareTo()</strong> : 
	 * <code>si x.compareTo(y) == 0, sgn(x.compareTo(z)) 
	 * == sgn(y.compareTo(z)) pour tout z</code>.</li>
	 * <li>Garantit le contrat Java recommandé mais non obligatoire 
	 * <strong>EQUIVALENCE compareTo() - equals() </strong> : 
	 * <code>x.compareTo(y) == 0 ---> x.equals(y) == true</code>.</li>
	 * <li>Garantit le contrat Java recommandé mais non obligatoire 
	 * <strong>EQUIVALENCE compareTo() - equals() </strong> : 
	 * <code>x.equals(y) == false ---> x.compareTo(y) != 0</code>.</li>
	 * <li>Garantit que les null sont bien gérés 
	 * dans compareTo(...).</li>
	 * <li>Garantit le bon fonctionnement (bon ordre) de compareTo().</li>
	 * </ul>
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testCompareTo() {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE EmployeTest - méthode testCompareTo() ********** ");
		}

		
		/* garantit que compareTo(memeInstance) retourne 0. */		
		final int compareMemeInstance 
			= objet1.compareTo(objet1MemeInstance);

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("COMPARAISON DE 2 MEMES INSTANCES ------------");
			System.out.println(OBJET1 + objet1.toString());
			System.out.println("objet1MemeInstance : " + objet1MemeInstance.toString());
			System.out.println();
			System.out.println("COMPARETO() DE LA MEME INSTANCE (objet1.compareTo(objet1MemeInstance)) : " 
					+ compareMemeInstance);
		}
		
		assertTrue(compareMemeInstance == 0
				, "compareTo(memeInstance) doit retourner 0 : ");

		
		/* garantit que compareTo(null) retourne -1. */
		final int compareToNull = objet1.compareTo(null);

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("COMPARAISON DE objet1 avec null ---------------");
			System.out.println(OBJET1 + objet1.toString());
			System.out.println();
			System.out.println("COMPARETO(null) - (objet1.compareTo(null)) : " 
					+ compareToNull);
		}
		
		assertTrue(compareToNull < 0
				, "compareTo(null) doit retourner négatif : ");

		
		/* garantit le contrat Java Contrat Java : 
		 * x.equals(y) ---> x.compareTo(y) == 0. */		
		final int compareToEquals 
			= objetCompIdem1.compareTo(objetCompIdem2);

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("COMPARAISON DE 2 objets equals ---------------------");
			System.out.println("objetCompIdem1 : " + objetCompIdem1.toString());
			System.out.println("objetCompIdem2 : " + objetCompIdem2.toString());
			System.out.println();
			System.out.println("COMPARETO(objetCompIdem1.compareTo(objetCompIdem2)) : " 
					+ compareToEquals);
		}

		assertTrue(compareToEquals == 0
				, "COMPARETO(objetCompIdem1.compareTo(objetCompIdem2)) : ");
		
		assertTrue(objetCompIdem1.hashCode() 
				== objetCompIdem2.hashCode()
					, "objetCompIdem1.hashCode() == objetCompIdem2.hashCode() : ");
		
		
		
		/* garantit que les null sont bien gérés dans 
		 * compareTo(...). */		
		final int compareToEqualsNull 
			= objetNull1.compareTo(objetNull2);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("COMPARAISON DE 2 Objets INSTANCIES AVEC LE CONSTRUCTEUR D'ARITE NULLE (ou valeurs par défaut) ------------");
			System.out.println(OBJETNULL1 + objetNull1.toString());
			System.out.println("objetNull2 : " + objetNull2.toString());
			System.out.println();
			System.out.println("COMPARETO(2 objets instanciés avec le constructeur d'arite nulle)  (objetNull1.compareTo(objetNull2)) : " 
					+ compareToEqualsNull);
		}
		
		assertTrue(compareToEqualsNull == 0
				, "InstanceNull.compareTo(equalsInstanceNull) doit retourner 0 : ");
		
		assertTrue(objetNull1.hashCode() == objetNull2.hashCode()
				, "objetNull1.hashCode() == objetNull2.hashCode() : ");
		

		
		/* garantit le bon fonctionnement (bon ordre) de compareTo(). */		
		final int compare 
			= objetCompAvant.compareTo(objetCompApres);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("COMPARAISON DE 2 Objets différents -------------");
			System.out.println("objetCompAvant : " + objetCompAvant.toString());
			System.out.println("objetCompApres : " + objetCompApres.toString());
			System.out.println();
			System.out.println("COMPARETO(objetCompAvant.compareTo(this.objetCompApres) : " 
					+ compare);
			
		}
		
		assertTrue(compare < 0
				, "objetCompAvant doit être avant objetCompApres : ");
		
	} // Fin de testCompareTo().___________________________________________


	
	/**
	 * Garantit que compareTo(memeInstance) retourne 0 : 
	 * <code>quel que soit x non null, x.compareTo(memeInstance) == 0</code>.
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testXCompareToMemeInstanceRetourneZero() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
		System.out.println();
		System.out.println("********** CLASSE EmployeTest - méthode testXCompareToMemeInstanceRetourneZero() ********** ");
		}

		
		// ARRANGE (ENTRANTS) ***********
		/* utilise objet1 et objet1MemeInstance. */

		
		// ACT (SORTANTS) ***************
		/* utilise objet1 et objet1MemeInstance. */
		final int objet1CompareToObjet1MemeInstance 
			= objet1.compareTo(objet1MemeInstance);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("objet1.compareTo(objet1MemeInstance) : " 
					+ objet1CompareToObjet1MemeInstance);
		}

		
		// ASSERT ***********************
		assertEquals(0, objet1CompareToObjet1MemeInstance
				, "objet1.compareTo(objet1MemeInstance) doit toujours retourner 0 : ");
		
	} // Fin de testXCompareToMemeInstanceRetourneZero().__________________

	
	
	/**
	 * Garantit que compareTo(null) retourne un nombre négatif : 
	 * <code>quel que soit x non null, x.compareTo(null) &lt; 0 </code>.
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testXCompareToNullRetourneNegatif() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
		System.out.println();
		System.out.println("********** CLASSE EmployeTest - méthode testXCompareToNullRetourneNegatif() ********** ");
		}

		
		// ARRANGE (ENTRANTS) ***********
		/* utilise objet1 et objetNull. */

		
		// ACT (SORTANTS) ***************
		/* utilise objet1 et objetNull. */
		final int objet1CompareToObjetNull 
			= objet1.compareTo(objetNull);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("objet1.compareTo(objetNull) : " 
					+ objet1CompareToObjetNull);
		}

		
		// ASSERT ***********************
		assertTrue(Math.signum(objet1CompareToObjetNull) == -1
				, "objet1.compareTo(objetNull) doit toujours retourner < 0 : ");
		
	} // Fin de testXCompareToNullRetourneNegatif()._______________________

	
	
	/**
	 * Garantit que compareTo(memeInstance) retourne 0 : 
	 * <code>quel que soit x non nul, x.compareTo(x) == 0</code>.
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testXCompareToX() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
		System.out.println();
		System.out.println("********** CLASSE EmployeTest - méthode testXCompareToX() ********** ");
		}

		
		// ARRANGE (ENTRANTS) ***********
		/* utilise objet1. */

		
		// ACT (SORTANTS) ***************
		final int objet1CompareToObjet1 = objet1.compareTo(objet1);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("objet1.compareTo(objet1) : " 
					+ objet1CompareToObjet1);
		}

		
		// ASSERT ***********************
		assertEquals(0, objet1CompareToObjet1
				, "objet1.compareTo(objet1) doit toujours retourner 0 : ");
		
	} // Fin de testXCompareToX()._________________________________________

	
		
	/**
	 * Garantit le contrat Java <strong>compareTo() ANTI-SYMETRIQUE</strong> : 
	 * <code>quel que soit x, y non nuls, 
	 * sgn(x.compareTo(y)) == - sgn(y.compareTo(x))</code>.
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testAntiSymetrieCompareTo() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
		System.out.println();
		System.out.println("********** CLASSE EmployeTest - méthode testAntiSymetrieCompareTo() ********** ");
		}

		
		// ARRANGE (ENTRANTS) ***********
		/* utilise objetCompAvant et objetCompApres. */

		
		// ACT (SORTANTS) ***************
		/* utilise objetCompAvant et objetCompApres. */
		final int objetCompAvantCompareToObjetCompApres 
			= objetCompAvant.compareTo(objetCompApres);
		final int objetCompApresCompareToObjetCompAvant 
			= objetCompApres.compareTo(objetCompAvant);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("objetCompAvant.compareTo(objetCompApres) : " 
					+ objetCompAvantCompareToObjetCompApres);
			System.out.println("objetCompApres.compareTo(objetCompAvant) : " 
					+ objetCompApresCompareToObjetCompAvant);
		}

		
		// ASSERT ***********************
		assertTrue(Math.signum(objetCompAvantCompareToObjetCompApres) 
					== -Math.signum(objetCompApresCompareToObjetCompAvant)
				, "sgn(x.compareTo(y)) == - sgn(y.compareTo(x)) : ");
				
	} // Fin de testAntiSymetrieCompareTo()._______________________________

	
	
	/**
	 * Garantit le contrat Java <strong>compareTo() TRANSITIF</strong> :
	 * <code>(x.compareTo(y)>0 && y.compareTo(z)>0) 
	 * ---> x.compareTo(z)>0</code>.
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testTransitifCompareTo() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
		System.out.println();
		System.out.println("********** CLASSE EmployeTest - méthode testTransitifCompareTo() ********** ");
		}

		
		// ARRANGE (ENTRANTS) ***********
		/* utilise objetCompAvant et objetCompApres et objetCompApresApres. */

		
		// ACT (SORTANTS) ***************
		/* utilise objetCompAvant et objetCompApres et objetCompApresApres. */
		final int objetCompAvantCompareToObjetCompApres 
			= objetCompAvant.compareTo(objetCompApres);
		final int objetCompApresCompareToObjetCompApresApres 
			= objetCompApres.compareTo(objetCompApresApres);
		final int compAvantCompareToObjetCompApresApres 
			= objetCompAvant.compareTo(objetCompApresApres);
		
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("objetCompAvant.compareTo(objetCompApres) : " 
					+ objetCompAvantCompareToObjetCompApres);
			System.out.println("objetCompApres.compareTo(objetCompApresApres) : " 
					+ objetCompApresCompareToObjetCompApresApres);
			System.out.println("objetCompAvant.compareTo(objetCompApresApres) : " 
					+ compAvantCompareToObjetCompApresApres);
		}

		
		// ASSERT ***********************
		assertTrue(objetCompAvantCompareToObjetCompApres < 0
				, "objetCompAvant doit toujours être avant objetCompApres : ");
		
		assertTrue(objetCompApresCompareToObjetCompApresApres < 0
				, "objetCompApres doit toujours être avant objetCompApresApres : ");
		
		assertTrue(compAvantCompareToObjetCompApresApres < 0
				, "objetCompAvant doit toujours être avant objetCompApresApres : ");
				
	} // Fin de testTransitifCompareTo().__________________________________

	
	
	/**
	 * Garantit le contrat Java <strong>PROPAGATION du CompareTo()</strong> : 
	 * <code>si x.compareTo(y) == 0, sgn(x.compareTo(z)) 
	 * == sgn(y.compareTo(z)) pour tout z</code>.
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testMemeCompareTo() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
		System.out.println();
		System.out.println("********** CLASSE EmployeTest - méthode testMemeCompareTo() ********** ");
		}

		
		// ARRANGE (ENTRANTS) ***********
		/* utilise objetCompIdem1 et objetCompIdem2 et objet1. */

		
		// ACT (SORTANTS) ***************
		/* utilise objetCompIdem1 et objetCompIdem2 et objet1. */
		final int compObjetCompIdem1CompareToObjetCompIdem2 
			= objetCompIdem1.compareTo(objetCompIdem2);
		
		final int compObjetCompIdem1CompareToObjet1 
			= objetCompIdem1.compareTo(objet1);
		
		final int compObjetCompIdem2CompareToObjet1 
			= objetCompIdem2.compareTo(objet1);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			
			System.out.println("objetCompIdem1.compareTo(objetCompIdem2) : " 
					+ compObjetCompIdem1CompareToObjetCompIdem2);
			
			System.out.println("objetCompIdem1.compareTo(objet1) : " 
					+ compObjetCompIdem1CompareToObjet1);
			
			System.out.println("objetCompIdem2.compareTo(objet1) : " 
					+ compObjetCompIdem2CompareToObjet1);
		}
		
		// ASSERT ***********************
		assertTrue(compObjetCompIdem1CompareToObjetCompIdem2 == 0
				, "objetCompIdem1.compareTo(objetCompIdem2) doit toujours valoir 0 : ");
		
		assertEquals(Math.signum(compObjetCompIdem1CompareToObjet1)
						, Math.signum(compObjetCompIdem2CompareToObjet1)
							, "Le signe de objetCompIdem1.compareTo(objetCompIdem2) "
									+ "doit toujours être le signe de objetCompIdem2.compareTo(objet1) : ");

	} // Fin de testMemeCompareTo()._______________________________________


	
	/**
	 * Garantit le contrat Java recommandé mais non obligatoire 
	 * <strong>EQUIVALENCE compareTo() - equals() </strong> : 
	 * <code>x.compareTo(y) == 0 ---> x.equals(y) == true</code>.
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testEquivalenceCompareToEquals() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
		System.out.println();
		System.out.println("********** CLASSE EmployeTest - méthode testEquivalenceCompareToEquals() ********** ");
		}

		
		// ARRANGE (ENTRANTS) ***********
		/* utilise objetCompIdem1 et objetCompIdem2. */
		
		// ACT (SORTANTS) ***************
		/* utilise objetCompIdem1 et objetCompIdem2. */
		final int compObjetCompIdem1CompareToObjetCompIdem2 
			= objetCompIdem1.compareTo(objetCompIdem2);
		
		final boolean objetCompIdem1EqualsObjetCompIdem2 
			= objetCompIdem1.equals(objetCompIdem2);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			
			System.out.println();
			
			System.out.println("objetCompIdem1 : " + objetCompIdem1.toString());
			System.out.println("objetCompIdem2 : " + objetCompIdem2.toString());
			
			System.out.println();
			
			System.out.println("objetCompIdem1.compareTo(objetCompIdem2) = " 
					+ compObjetCompIdem1CompareToObjetCompIdem2);
			
			System.out.println("objetCompIdem1.equals(objetCompIdem2) ? = " 
					+ objetCompIdem1EqualsObjetCompIdem2);
			
		}
		
		// ASSERT ***********************
		assertTrue(compObjetCompIdem1CompareToObjetCompIdem2 == 0
			, "objetCompIdem1.compareTo(objetCompIdem2) doit toujours valoir 0 : ");
		
		assertTrue(objetCompIdem1EqualsObjetCompIdem2
				, "si objetCompIdem1.compareTo(objetCompIdem2) == 0"
						+ ", objetCompIdem1.equals(objetCompIdem2) doit toujours retourner true : ");
				
	} // Fin de testEquivalenceCompareToEquals().__________________________

	
	
	/**
	 * Garantit le contrat Java recommandé mais non obligatoire 
	 * <strong>EQUIVALENCE compareTo() - equals() </strong> : 
	 * <code>x.equals(y) == false ---> x.compareTo(y) != 0</code>.
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testEquivalenceEqualsCompareTo() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
		System.out.println();
		System.out.println("********** CLASSE EmployeTest - méthode testEquivalenceEqualsCompareTo() ********** ");
		}

		
		// ARRANGE (ENTRANTS) ***********
		/* utilise objetDiff1 et objetDiff2. */
		
		// ACT (SORTANTS) ***************
		/* utilise objetDiff1 et objetDiff2. */
		final boolean objetDiff1EqualsObjetDiff2 
			= objetDiff1.equals(objetDiff2);
		
		final int objetDiff1CompareToObjetDiff2 
			= objetDiff1.compareTo(objetDiff2);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			
			System.out.println();
			
			System.out.println(String.format(Locale.getDefault()
					, FORMAT_STRING
						, "objetDiff1 : "
						, objetDiff1.toString()
						, "objetDiff2 : "
						, objetDiff2.toString()));
			System.out.println("objetDiff1.equals(objetDiff2) ? : " 
						+ objetDiff1EqualsObjetDiff2);
			System.out.println("objetDiff1.compareTo(objetDiff2) = " 
						+ objetDiff1CompareToObjetDiff2);
			
		}
		
		// ASSERT ***********************
		assertNotEquals(objetDiff1, objetDiff2
				, "objetDiff1 et objetDiff2 ne sont pas equals : ");
		
		assertFalse(objetDiff1CompareToObjetDiff2 == 0
				, "objetDiff1.compareTo(objetDiff2) ne doit pas valoir 0 : ");
		
	} // Fin de testEquivalenceEqualsCompareTo().__________________________
	

	
	/**
	 * Teste la méthode <b>clone()</b> :
	 * <ul>
	 * <li>garantit que les null sont bien gérés dans clone().</li>
	 * <li>garantit que clone(x).equals(x).</li>
	 * <li>garantit que x et son clone ne sont pas la même instance.</li>
	 * </ul>
	 * @throws CloneNotSupportedException 
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testClone() throws CloneNotSupportedException {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE EmployeTest - méthode testClone() ********** ");
		}

		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("CAS DU CLONAGE D'OBJET INSTANCIES AVEC LE CONSTRUCTEUR D'ARITE NULLE ---------------------");
			System.out.println(OBJETNULL1 
					+ objetNull1.toString());
			System.out.println("objetNullClone1 : " 
					+ objetNullClone1.toString());
			System.out.println();
			System.out.println("objetNull1.equals(objetNullClone1) : " + objetNull1.equals(objetNullClone1));
		}
		
		/* garantit que les null sont bien gérés dans clone(). */
		assertEquals(objetNull1
						, objetNullClone1
							, "objetNull1.equals(objetNullClone1) : ");
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("CAS DU CLONAGE D'OBJETS ORDINAIREMENT INSTANCIES --------------------");
			System.out.println(OBJET1 
					+ objet1.toString());
			System.out.println("objetClone1 : " 
					+ objetClone1.toString());
			System.out.println();
			System.out.println("objet1.equals(objetClone1) : " + objet1.equals(objetClone1));
		}
		
		/* garantit que clone(x).equals(x). */
		assertEquals(objet1
						, objetClone1
							, "clone(x).equals(x) : ");
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("INSTANCE ET CLONE DIFFERENTS --------------------");
			System.out.println(OBJET1 
					+ objet1.toString());
			System.out.println("objetClone1 : " 
					+ objetClone1.toString());
			System.out.println();
			System.out.println("objet1 == objetClone1 : " + (objet1 == objetClone1));     // NOPMD by dan on 15/11/2020 16:24
		}
		
		/* garantit que x et son clone ne sont pas la même instance. */
		assertNotSame(objet1, objetClone1, "x != clonex : ");
						
	} // Fin de testClone()._______________________________________________
	
	
	
	/**
	 * Teste la méthode <b>toString()</b> :
	 * <ul>
	 * <li>garantit que les null sont bien gérés dans toString().</li>
	 * <li>garantit le bon affichage de toString().</li>
	 * <li><b>Pour les Développeurs : 
	 * Adapter la chaîne affichée dans les assertEquals</b></li>
	 * </ul>
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testToString() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
	
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE EmployeTest - méthode testToString() ********** ");
		}
	
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("objetNull1.toString() : " + objetNull1.toString());
		}
		
		/* garantit que les null sont bien gérés dans toString(). */
		assertEquals("Employe [id=0, code=null, civilite=null, prenom=null, nom=null, dateNaissance=null]"
						, objetNull1.toString()
							, "objetNull1.toString() retourne une chaine : ");
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("objet1.toString() : " + objet1.toString());
		}
		
		/* garantit le bon affichage de toString(). */
		assertEquals("Employe [id=1, code=code_1, civilite=M, prenom=Vincent, nom=Robin, dateNaissance=01/01/1960]"
						, objet1.toString()
							, "affichage : ");
				
	} // Fin de testToString().____________________________________________
	

	
	/**
	 * Teste la méthode <b>fournirEnTeteCsv()</b> :
	 * <ul>
	 * <li>garantit que fournirEnTeteCsv() retourne le bon en-tête csv.</li>
	 * <li><b>Pour les Développeurs : 
	 * Adapter la chaîne affichée dans les assertEquals</b></li>
	 * </ul>
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testFournirEnTeteCsv() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE EmployeTest - méthode testFournirEnTeteCsv() ********** ");
		}
	

		/* garantit que fournirEnTeteCsv() retourne le bon en-tête csv. */
		final String entete = objet1.fournirEnTeteCsv();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("EN-TETE CSV ------------------------------");
			System.out.println(OBJET1 + objet1.toString());
			System.out.println();
			System.out.println("En-tête csv : " + entete);
		}
		
		assertEquals("id;code;civilite;prenom;nom;dateNaissance;"
						, entete
							, "en-tête csv : ");
				
	} // Fin de testFournirEnTeteCsv().____________________________________
	

	
	/**
	 * Teste la méthode <b>fournirStringCsv()</b> :
	 * <ul>
	 * <li>garantit que les null sont gérés dans fournirStringCsv().</li> 
	 * <li>garantit que fournirStringCsv() retourne la bonne ligne csv.</li>
	 * <li><b>Adapter la chaîne affichée dans les assertEquals</b></li>
	 * </ul>
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testFournirStringCsv() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE EmployeTest - méthode testFournirStringCsv() ********** ");
		}

		/* garantit que les null sont gérés dans fournirStringCsv(). */
		final String ligneCsvNull = objetNull1.fournirStringCsv();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("STRING CSV D' UN OBJET INSTANCIE AVEC LE CONSTRUCTEUR D'ARITE NULLE -----------------------");
			System.out.println("objetNull1.toString() : " + objetNull1.toString());
			System.out.println();
			System.out.println("objetNull1.fournirStringCsv() : " 
					+ ligneCsvNull);
		}

		assertEquals("0;null;null;null;null;null;"
						, ligneCsvNull
							, "ligne csv null = ");
		
						
		/* garantit que fournirStringCsv() retourne la bonne ligne csv. */
		final String ligneCsv = objet1.fournirStringCsv();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("STRING CSV D' UN OBJET INSTANIE AVEC LE CONSTRUCTEUR ORDINAIRE -----------------------");
			System.out.println(OBJET1 + objet1.toString());
			System.out.println();
			System.out.println("objet1.fournirStringCsv() = " + ligneCsv);
		}

		assertEquals("1;code_1;M;Vincent;Robin;01/01/1960;"
					, ligneCsv
						, "ligne csv : ");
				
	} // Fin de testFournirStringCsv().____________________________________
	

	
	/**
	 * Teste la méthode <b>fournirEnTeteColonne(int pI)</b> :
	 * <ul>
	 * <li>garantit que les null sont gérés dans 
	 * fournirEnTeteColonne(int pI).</li> 
	 * <li>garantit que fournirEnTeteColonne(int pI) retourne 
	 * la bonne en-tête de colonne.</li>
	 * <li><b>Compléter les colonnes.</b></li>
	 * <li><b>Adapter la chaîne affichée dans les assertEquals</b></li>
	 * </ul>
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testFournirEnTeteColonne() {

		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE EmployeTest - méthode testFournirEnTeteColonne() ********** ");
		}
		
		/* garantit que les null sont gérés 
		 * dans fournirEnTeteColonne(int pI). */		
		final String enteteNull0 = objetNull1.fournirEnTeteColonne(0);
		final String enteteNull1 = objetNull1.fournirEnTeteColonne(1);
		final String enteteNull2 = objetNull1.fournirEnTeteColonne(2);
		final String enteteNull3 = objetNull1.fournirEnTeteColonne(3);
		final String enteteNull4 = objetNull1.fournirEnTeteColonne(4);
		final String enteteNull5 = objetNull1.fournirEnTeteColonne(5);
				
		/* garantit que fournirEnTeteColonne(int pI) retourne 
		 * la bonne en-tête de colonne. */
		final String entete0 = objet1.fournirEnTeteColonne(0);
		final String entete1 = objet1.fournirEnTeteColonne(1);
		final String entete2 = objet1.fournirEnTeteColonne(2);
		final String entete3 = objet1.fournirEnTeteColonne(3);
		final String entete4 = objet1.fournirEnTeteColonne(4);
		final String entete5 = objet1.fournirEnTeteColonne(5);
		
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(OBJET1 + objet1.toString());
			System.out.println(OBJETNULL1 + objetNull1.toString());
			System.out.println();
			System.out.println("EN-TETES JTABLE -----------------------------");
			System.out.println("entete0 (objet1.fournirEnTeteColonne(0)) : " + entete0);
			System.out.println("enteteNull0 (objetNull1.fournirEnTeteColonne(0)) : " + enteteNull0);
			System.out.println();
			System.out.println("entete1 (objet1.fournirEnTeteColonne(1)) : " + entete1);
			System.out.println("enteteNull1 (objetNull1.fournirEnTeteColonne(1)) : " + enteteNull1);
			System.out.println();
			System.out.println("entete2 (objet1.fournirEnTeteColonne(2)) : " + entete2);
			System.out.println("enteteNull2 (objetNull1.fournirEnTeteColonne(2)) : " + enteteNull2);			
			System.out.println();
			System.out.println("entete3 (objet1.fournirEnTeteColonne(3)) : " + entete3);
			System.out.println("enteteNull3 (objetNull1.fournirEnTeteColonne(3)) : " + enteteNull3);			
			System.out.println();
			System.out.println("entete4 (objet1.fournirEnTeteColonne(4)) : " + entete4);
			System.out.println("enteteNull4 (objetNull1.fournirEnTeteColonne(4)) : " + enteteNull4);
			System.out.println();
			System.out.println("entete5 (objet1.fournirEnTeteColonne(5)) : " + entete5);
			System.out.println("enteteNull5 (objetNull1.fournirEnTeteColonne(5)) : " + enteteNull5);
			System.out.println();
			
		}

		assertEquals("id", entete0, "entete0 : ");
		assertEquals("id", enteteNull0, "enteteNull0 : ");
		
		assertEquals("code", entete1, "entete1 : ");
		assertEquals("code", enteteNull1, "enteteNull1 : ");
				
	} // Fin de testFournirEnTeteColonne().________________________________
	
	
	
	/**
	 * Teste la méthode <b>fournirValeurColonne(int pI)</b> :
	 * <ul>
	 * <li>garantit que les null sont gérés dans 
	 * fournirValeurColonne(int pI).</li> 
	 * <li>garantit que fournirValeurColonne(int pI) retourne 
	 * la bonne valeur de colonne.</li>
	 * <li><b>Compléter les colonnes.</b></li>
	 * <li><b>Adapter la chaîne affichée dans les assertEquals</b></li>
	 * </ul>
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testFournirValeurColonne() {

		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE EmployeTest - méthode testFournirValeurColonne() ********** ");
		}
		
		/* garantit que les null sont gérés 
		 * dans fournirValeurColonne(int pI). */
		final String valeurNull0 = (String) objetNull1.fournirValeurColonne(0);
		final String valeurNull1 = (String) objetNull1.fournirValeurColonne(1);
		final String valeurNull2 = (String) objetNull1.fournirValeurColonne(2);
		final String valeurNull3 = (String) objetNull1.fournirValeurColonne(3);
		final String valeurNull4 = (String) objetNull1.fournirValeurColonne(4);
		final String valeurNull5 = (String) objetNull1.fournirValeurColonne(5);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("CAS D'UN OBJET INSTANCIE AVEC LE CONSTRUCTEUR D'ARITE NULLE --------------------");
			System.out.println(OBJETNULL1 + objetNull1.toString());
			System.out.println();
			System.out.println("valeurNull0 ((String) objetNull1.fournirValeurColonne(0)) : " + valeurNull0);
			System.out.println("valeurNull1 ((String) objetNull1.fournirValeurColonne(1)) : " + valeurNull1);
			System.out.println("valeurNull2 ((String) objetNull1.fournirValeurColonne(2)) : " + valeurNull2);
			System.out.println("valeurNull3 ((String) objetNull1.fournirValeurColonne(3)) : " + valeurNull3);
			System.out.println("valeurNull4 ((String) objetNull1.fournirValeurColonne(4)) : " + valeurNull4);
			System.out.println("valeurNull5 ((String) objetNull1.fournirValeurColonne(1)) : " + valeurNull5);
		}

		assertEquals("0", valeurNull0, "valeurNull0 ((String) objetNull1.fournirValeurColonne(0)) : ");
		assertEquals(null, valeurNull1, "valeurNull1 ((String) objetNull1.fournirValeurColonne(1)) : ");

		
		/* garantit que fournirValeurColonne(int pI) retourne 
		 * la bonne en-tête de colonne. */
		final String valeur0 = (String) objet1.fournirValeurColonne(0);
		final String valeur1 = (String) objet1.fournirValeurColonne(1);
		final String valeur2 = (String) objet1.fournirValeurColonne(2);
		final String valeur3 = (String) objet1.fournirValeurColonne(3);
		final String valeur4 = (String) objet1.fournirValeurColonne(4);
		final String valeur5 = (String) objet1.fournirValeurColonne(5);
		
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {	
			System.out.println();
			System.out.println("CAS D'UN OBJET INSTANCIE AVEC LE CONSTRUCTEUR ORDINAIRE -------------------------");
			System.out.println(OBJET1 + objet1.toString());
			System.out.println();
			System.out.println("valeur0 ((String) objet1.fournirValeurColonne(0)) : " + valeur0);
			System.out.println("valeur1 ((String) objet1.fournirValeurColonne(1)) : " + valeur1);
			System.out.println("valeur2 ((String) objet1.fournirValeurColonne(2)) : " + valeur2);
			System.out.println("valeur3 ((String) objet1.fournirValeurColonne(3)) : " + valeur3);
			System.out.println("valeur4 ((String) objet1.fournirValeurColonne(4)) : " + valeur4);
			System.out.println("valeur5 ((String) objet1.fournirValeurColonne(1)) : " + valeur5);
		}
		
		assertEquals("1", valeur0, "valeur0 ((String) objet1.fournirValeurColonne(0)) : ");		
		assertEquals("code_1", valeur1, "valeur1 ((String) objet1.fournirValeurColonne(1)) : ");
		
	} // Fin de testFournirValeurColonne().________________________________
	
	
		
	/**
	 * method avantTests() :
	 * <ul>
	 * <li>instructions exécutées <b>avant l'ensemble des tests</b> 
	 * de la classe JUnit.</li>
	 * <li><b>A REMPLIR A LA MAIN</b></li>
	 * </ul>
	 * @throws CloneNotSupportedException 
	 */
	@BeforeAll
   public static void avantTests() throws CloneNotSupportedException {
		
		/* CLONE. */
		objetNullClone1 = objetNull1.clone();
		objetClone1 = objet1.clone();
		
	} // Fin de avantTests().______________________________________________
	

	
} // FIN DE LA CLASSE EmployeTest.-------------------------------------------
